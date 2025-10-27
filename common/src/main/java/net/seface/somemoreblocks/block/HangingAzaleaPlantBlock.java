package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.NotNull;

public class HangingAzaleaPlantBlock extends GrowingPlantBodyBlock {
  public static final MapCodec<HangingAzaleaPlantBlock> CODEC = simpleCodec(HangingAzaleaPlantBlock::new);
  private static final VoxelShape SHAPE = Block.column(12.0F, 0.0F, 16.0F);

  public HangingAzaleaPlantBlock(Properties properties) {
    super(properties, Direction.DOWN, SHAPE, true);
  }

  @Override
  protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
    return CODEC;
  }

  @Override
  protected GrowingPlantHeadBlock getHeadBlock() {
    return this.defaultBlockState().is(SMBBlocks.HANGING_AZALEA_PLANT.get())
      ? (GrowingPlantHeadBlock) SMBBlocks.HANGING_AZALEA.get()
      : (GrowingPlantHeadBlock) SMBBlocks.HANGING_FLOWERING_AZALEA.get();
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
    if (direction == this.growthDirection.getOpposite() && !blockState.canSurvive(levelReader, blockPos)) {
      scheduledTickAccess.scheduleTick(blockPos, this, 1);
    }

    // Permite que qualquer tipo de azalea pendente cresça junto
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
      // Mantém o bloco como está, permitindo tipos misturados
      return blockState;
    }
  }
}
