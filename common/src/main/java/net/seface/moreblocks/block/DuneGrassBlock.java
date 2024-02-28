package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DuneGrassBlock extends FlowerBlock {
    public DuneGrassBlock(Properties properties) {
        super(MobEffects.ABSORPTION, 0, properties);
    }

    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos blockPos) {
        BlockState bellowBlockState;
        bellowBlockState = level.getBlockState(blockPos.below());

        return bellowBlockState.is(BlockTags.SAND) && !level.getBlockState(blockPos.above()).liquid();
    }
}
