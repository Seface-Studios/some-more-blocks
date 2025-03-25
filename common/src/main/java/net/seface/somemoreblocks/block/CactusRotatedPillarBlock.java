package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

@SuppressWarnings("deprecation")
public class CactusRotatedPillarBlock extends RotatedPillarBlock {
  public CactusRotatedPillarBlock(Properties properties) {
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
