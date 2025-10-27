package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.registries.SMBBlocks;

public class HangingCherryLeavesBlock extends GrowingPlantHeadBlock {
  public static final MapCodec<HangingCherryLeavesBlock> CODEC = simpleCodec(HangingCherryLeavesBlock::new);
  private static final VoxelShape SHAPE = Block.column(14.0F, 0.0F, 16.0F);

  public MapCodec<HangingCherryLeavesBlock> codec() {
    return CODEC;
  }

  public HangingCherryLeavesBlock(BlockBehaviour.Properties properties) {
    super(properties, Direction.DOWN, SHAPE, false, 0.1);
  }

  protected int getBlocksToGrowWhenBonemealed(RandomSource randomSource) {
    return 1;
  }

  @Override
  protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockPos parentPos = pos.relative(this.growthDirection.getOpposite());
    BlockState parentBlock = level.getBlockState(parentPos);

    if (!this.canAttachTo(parentBlock)) {
      return false;
    } else {
      return parentBlock.is(this.getHeadBlock()) ||
             parentBlock.is(this.getBodyBlock()) ||
             parentBlock.is(BlockTags.LEAVES);
    }
  }

  @Override
  protected boolean canAttachTo(BlockState state) {
    return super.canAttachTo(state);
  }

  protected Block getBodyBlock() {
    return SMBBlocks.HANGING_CHERRY_LEAVES_PLANT.get();
  }

  protected boolean canGrowInto(BlockState blockState) {
    return true;
  }
}
