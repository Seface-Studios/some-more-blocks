package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;

public class HangingAzaleaBlock extends GrowingPlantHeadBlock {
  public static final MapCodec<HangingAzaleaBlock> CODEC = simpleCodec(HangingAzaleaBlock::new);
  private static final VoxelShape SHAPE = Block.column(12.0F, 0.0F, 12.0F);

  public HangingAzaleaBlock(Properties properties) {
    super(properties, Direction.DOWN, SHAPE, true, 0.14);
  }

  @Override
  protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
    return CODEC;
  }

  @Override
  protected Block getBodyBlock() {
    return this.defaultBlockState().is(SMBBlocks.HANGING_AZALEA.get())
      ? SMBBlocks.HANGING_AZALEA_PLANT.get()
      : SMBBlocks.HANGING_FLOWERING_AZALEA_PLANT.get();
  }

  @Override
  protected boolean canAttachTo(BlockState state) {
    return
      state.is(SMBBlockTags.HANGING_AZALEA_ATTACHABLE) ||
      state.is(SMBBlocks.HANGING_AZALEA.get()) ||
      state.is(SMBBlocks.HANGING_FLOWERING_AZALEA.get()) ||
      state.is(SMBBlocks.HANGING_AZALEA_PLANT.get()) ||
      state.is(SMBBlocks.HANGING_FLOWERING_AZALEA_PLANT.get());
  }

  @Override
  protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
    return 1;
  }

  @Override
  protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
    BlockPos blockPos2 = blockPos.relative(this.growthDirection.getOpposite());
    BlockState blockState2 = levelReader.getBlockState(blockPos2);
    if (!this.canAttachTo(blockState2)) {
      return false;
    } else {
      return
        blockState2.is(SMBBlockTags.HANGING_AZALEA_ATTACHABLE) ||
        blockState2.is(SMBBlocks.HANGING_AZALEA.get()) ||
        blockState2.is(SMBBlocks.HANGING_FLOWERING_AZALEA.get()) ||
        blockState2.is(SMBBlocks.HANGING_AZALEA_PLANT.get()) ||
        blockState2.is(SMBBlocks.HANGING_FLOWERING_AZALEA_PLANT.get());
    }
  }

  @Override
  protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess,
                                    BlockPos blockPos, Direction direction, BlockPos blockPos2,
                                    BlockState blockState2, RandomSource randomSource) {
    if (direction == this.growthDirection.getOpposite()) {
      if (!blockState.canSurvive(levelReader, blockPos)) {
        scheduledTickAccess.scheduleTick(blockPos, this, 1);
      } else {
        BlockState blockState3 = levelReader.getBlockState(blockPos.relative(this.growthDirection));
        if (blockState3.is(SMBBlocks.HANGING_AZALEA.get()) ||
            blockState3.is(SMBBlocks.HANGING_FLOWERING_AZALEA.get()) ||
            blockState3.is(SMBBlocks.HANGING_AZALEA_PLANT.get()) ||
            blockState3.is(SMBBlocks.HANGING_FLOWERING_AZALEA_PLANT.get())) {
          return this.updateBodyAfterConvertedFromHead(blockState, this.getBodyBlock().defaultBlockState());
        }
      }
    }

    if (direction != this.growthDirection ||
        (!blockState2.is(SMBBlocks.HANGING_AZALEA.get()) &&
         !blockState2.is(SMBBlocks.HANGING_FLOWERING_AZALEA.get()) &&
         !blockState2.is(SMBBlocks.HANGING_AZALEA_PLANT.get()) &&
         !blockState2.is(SMBBlocks.HANGING_FLOWERING_AZALEA_PLANT.get()))) {
      if (this.scheduleFluidTicks) {
        scheduledTickAccess.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelReader));
      }
      return super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
    } else {
      return this.updateBodyAfterConvertedFromHead(blockState, this.getBodyBlock().defaultBlockState());
    }
  }

  @Override
  protected boolean canGrowInto(BlockState state) {
    return state.isAir();
  }

  @Override
  protected BlockState getGrowIntoState(BlockState blockState, RandomSource randomSource) {
    // Escolhe aleatoriamente entre azalea normal e florida
    Block randomBlock = randomSource.nextBoolean()
      ? SMBBlocks.HANGING_AZALEA.get()
      : SMBBlocks.HANGING_FLOWERING_AZALEA.get();
    return randomBlock.defaultBlockState().setValue(BlockStateProperties.AGE_25, blockState.getValue(BlockStateProperties.AGE_25));
  }

  @Override
  public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
    BlockPos blockPos2 = blockPos.relative(this.growthDirection);
    int i = Math.min(blockState.getValue(BlockStateProperties.AGE_25) + 1, 25);
    int j = this.getBlocksToGrowWhenBonemealed(randomSource);

    for(int k = 0; k < j && this.canGrowInto(serverLevel.getBlockState(blockPos2)); ++k) {
      // Escolhe aleatoriamente entre azalea normal e florida
      Block randomBlock = randomSource.nextBoolean()
        ? SMBBlocks.HANGING_AZALEA.get()
        : SMBBlocks.HANGING_FLOWERING_AZALEA.get();
      serverLevel.setBlockAndUpdate(blockPos2, randomBlock.defaultBlockState().setValue(BlockStateProperties.AGE_25, i));
      blockPos2 = blockPos2.relative(this.growthDirection);
      i = Math.min(i + 1, 25);
    }
  }
}
