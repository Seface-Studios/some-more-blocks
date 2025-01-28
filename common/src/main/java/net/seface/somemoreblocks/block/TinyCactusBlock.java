package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.tags.SMBBlockTags;

@SuppressWarnings("deprecation")
public class TinyCactusBlock extends FlowerBlock {
  public TinyCactusBlock(MobEffect mobEffect, int i, Properties properties) {
    super(mobEffect, i, properties);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState bellowBlockState = level.getBlockState(pos.below());
    return bellowBlockState.is(SMBBlockTags.TINY_CACTUS_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
  }

  @Override
  public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
    if (level.isClientSide) return;
    if (entity instanceof LivingEntity) {
      entity.hurt(level.damageSources().cactus(), 1.0F);
    }
  }
}
