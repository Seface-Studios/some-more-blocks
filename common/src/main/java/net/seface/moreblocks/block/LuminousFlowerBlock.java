package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
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

    /*public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        VoxelShape shape = this.getShape(state, level, pos, CollisionContext.empty());
        Vec3 shapeCenter = shape.bounds().getCenter();
        double x = (double) pos.getX() + shapeCenter.x;
        double z = (double) pos.getZ() + shapeCenter.z;

        for(int i = 0; i < 3; ++i) {
            if (random.nextBoolean()) {
                level.addParticle(ParticleTypes.END_ROD, x + random.nextDouble() / 5.0, (double)pos.getY() + (0.25 + random.nextDouble()), z + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
            }
        }
    }*/

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (level.isClientSide) return;

        if (entity instanceof LivingEntity affectedEntity) {
            affectedEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
        }
    }
}
