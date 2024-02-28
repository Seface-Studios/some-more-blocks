package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class TallDuneGrassBlock extends DoublePlantBlock {
    public TallDuneGrassBlock(Properties properties) {
        super(properties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState bellowBlockState = level.getBlockState(pos.below());

        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            bellowBlockState = level.getBlockState(pos.below());
            return bellowBlockState.is(BlockTags.SAND) && !level.getBlockState(pos.above()).liquid();
        }

        return bellowBlockState.is(this) && bellowBlockState.getValue(HALF) == DoubleBlockHalf.LOWER;
    }
}
