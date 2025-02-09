package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
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
  public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
    if (level.isClientSide) return;
    if (entity instanceof LivingEntity affectedEntity) {
      affectedEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
    }
  }
}
