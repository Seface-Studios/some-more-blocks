package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SnowGrassBlock extends AbstractCustomGrassPlantBlock {

    public SnowGrassBlock(Block tallVariation, Properties properties) {
        super(tallVariation, properties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockBelow = level.getBlockState(pos.below());
        return blockBelow.is(BlockTags.DIRT);
    }
}
