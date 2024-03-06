package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public abstract class AbstractCustomGrassPlantBlock extends TallGrassBlock implements BonemealableBlock {
    private final Block tallVariation;

    public AbstractCustomGrassPlantBlock(Block tallVariation, Properties properties) {
        super(properties);

        this.tallVariation = tallVariation;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return super.canSurvive(state, level, pos);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        DoublePlantBlock doublePlantBlock = (DoublePlantBlock) this.tallVariation;
        if (doublePlantBlock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
            DoublePlantBlock.placeAt(level, doublePlantBlock.defaultBlockState(), pos, 2);
        }
    }
}
