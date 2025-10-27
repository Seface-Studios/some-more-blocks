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

public class HangingCherryLeavesPlantBlock extends GrowingPlantBodyBlock {
  public static final MapCodec<HangingCherryLeavesPlantBlock> CODEC = simpleCodec(HangingCherryLeavesPlantBlock::new);
  private static final VoxelShape SHAPE = Block.column(14.0F, 0.0F, 16.0F);

  public MapCodec<HangingCherryLeavesPlantBlock> codec() {
    return CODEC;
  }

  public HangingCherryLeavesPlantBlock(BlockBehaviour.Properties properties) {
    super(properties, Direction.DOWN, SHAPE, false);
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

  protected GrowingPlantHeadBlock getHeadBlock() {
    return (GrowingPlantHeadBlock) SMBBlocks.HANGING_CHERRY_LEAVES.get();
  }
}

