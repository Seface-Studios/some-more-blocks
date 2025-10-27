package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.registries.SMBBlocks;

public class LianaVinePlantBlock extends GrowingPlantBodyBlock {
  public static final MapCodec<LianaVinePlantBlock> CODEC = simpleCodec(LianaVinePlantBlock::new);
  private static final VoxelShape SHAPE = Block.column(14.0F, 0.0F, 16.0F);

  public MapCodec<LianaVinePlantBlock> codec() {
    return CODEC;
  }

  public LianaVinePlantBlock(Properties properties) {
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
    return (GrowingPlantHeadBlock) SMBBlocks.LIANA_VINE.get();
  }
}

