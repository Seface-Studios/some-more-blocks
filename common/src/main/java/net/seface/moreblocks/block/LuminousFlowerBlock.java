package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LuminousFlowerBlock extends FlowerBlock {
    public LuminousFlowerBlock(MobEffect mobEffect, int amplifier, Properties properties) {
        super(mobEffect, amplifier, properties);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        VoxelShape $$4 = this.getShape(state, level, pos, CollisionContext.empty());
        Vec3 $$5 = $$4.bounds().getCenter();
        double $$6 = (double)pos.getX() + $$5.x;
        double $$7 = (double)pos.getZ() + $$5.z;

        for(int $$8 = 0; $$8 < 3; ++$$8) {
            if (random.nextBoolean()) {
                level.addParticle(ParticleTypes.END_ROD, $$6 + random.nextDouble() / 5.0, (double)pos.getY() + (0.25 + random.nextDouble()), $$7 + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
            }
        }
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (level.isClientSide) return;

        if (entity instanceof LivingEntity) {
            LivingEntity affectedEntity = (LivingEntity) entity;
            affectedEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
        }
    }
}
