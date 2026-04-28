package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.seface.somemoreblocks.tags.SMBBlockTags;

public class TallCactusBlock extends DoublePlantBlock {
  public TallCactusBlock(Properties properties) {
    super(properties);
  }

  @Override
  protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());
    if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
      return blockBelow.is(SMBBlockTags.CACTUS_PLANTS_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
    }

    return blockBelow.is(this) && blockBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
  }

  @Override
  protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean b) {
    if (!(entity instanceof LivingEntity)) return;
    entity.hurt(level.damageSources().cactus(), 1.0F);
  }
}
