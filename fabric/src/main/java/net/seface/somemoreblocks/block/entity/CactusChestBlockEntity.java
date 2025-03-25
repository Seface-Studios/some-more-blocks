package net.seface.somemoreblocks.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.registries.SMBBlockEntities;

public class CactusChestBlockEntity extends ChestBlockEntity {
  public CactusChestBlockEntity(BlockEntityType<?> entityType, BlockPos pos, BlockState state) {
    super(entityType, pos, state);
  }

  public CactusChestBlockEntity(BlockPos pos, BlockState state) {
    super(SMBBlockEntities.CACTUS_CHEST, pos, state);
  }
}
