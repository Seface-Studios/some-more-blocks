package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class TinyCactusBlock extends FlowerBlock {
    public TinyCactusBlock(MobEffect mobEffect, int i, Properties properties) {
        super(mobEffect, i, properties);
    }

    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos blockPos) {
        BlockState bellowBlockState = level.getBlockState(blockPos.below());
        boolean isValidPlacement = bellowBlockState.is(BlockTags.SAND) || bellowBlockState.is(BlockTags.DIRT);

        return isValidPlacement && !level.getBlockState(blockPos.above()).liquid();
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (level.isClientSide) return;

        if (entity instanceof LivingEntity) {
            entity.makeStuckInBlock(state, new Vec3(0.8, 0.75, 0.8));

            if (entity.xOld != entity.getX() || entity.zOld != entity.getZ()) {
                double $$4 = Math.abs(entity.getX() - entity.xOld);
                double $$5 = Math.abs(entity.getZ() - entity.zOld);
                if ($$4 >= 0.003000000026077032 || $$5 >= 0.003000000026077032) {
                    entity.hurt(level.damageSources().cactus(), 1.0F);
                }
            }
        }
    }
}
