package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")
public class PaleMushroomBlock extends TallGrassBlock {
  public PaleMushroomBlock(Properties properties) {
    super(properties);
  }
  protected static final VoxelShape SHAPE = Block.box(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

  @Override
  protected VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext ctx) {
    return SHAPE;
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());
    return blockBelow.is(BlockTags.MUSHROOM_GROW_BLOCK) && !level.getBlockState(pos.above()).liquid() || (level.getRawBrightness(pos, 0) < 13 && Block.isFaceFull(blockBelow.getCollisionShape(level, pos.below()), Direction.UP));
  }
}
