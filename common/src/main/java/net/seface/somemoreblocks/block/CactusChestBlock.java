package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import java.util.function.Supplier;

public class CactusChestBlock extends ChestBlock {
  protected CactusChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntity, Properties properties) {
    super(blockEntity, properties);
  }

  @Override
  protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
    entity.hurt(level.damageSources().cactus(), 1.0F);
  }

  @Override
  public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
    entity.hurt(level.damageSources().cactus(), 1.0F);
  }
}
