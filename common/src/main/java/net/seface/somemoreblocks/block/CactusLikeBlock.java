package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CactusLikeBlock extends Block {
  public CactusLikeBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
    entity.hurt(level.damageSources().cactus(), 1.0F);
  }

  @Override
  public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
    entity.hurt(level.damageSources().cactus(), 1.0F);
  }

  @Override
  protected boolean isPathfindable(BlockState state, PathComputationType pathType) {
    return false;
  }
}
