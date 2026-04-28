package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.InsideBlockEffectType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("deprecation")
public class LuminousFlowerBlock extends FlowerBlock {
  public LuminousFlowerBlock(Properties properties) {
    super(MobEffects.GLOWING, 7, properties);
  }

  @Override
  protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier) {
    if (level.isClientSide() ) return;
    if (entity instanceof LivingEntity affectedEntity) {
      affectedEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
    }
  }
}
