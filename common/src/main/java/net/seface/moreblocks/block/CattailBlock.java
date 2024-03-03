package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/**
 * @deprecated Temp marked as deprecated to work on this in the future.
 */
public class CattailBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CattailBlock(Properties $$0) {
        super($$0);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> $$0) {
        $$0.add(new Property[]{HALF, WATERLOGGED});
    }

    public boolean canSurvive(BlockState blockState, LevelReader level, BlockPos blockPos) {
        BlockState bellowBlockState;

        if (blockState.getValue(HALF).equals(DoubleBlockHalf.UPPER) && blockState.getValue(WATERLOGGED)) {
            return false;
        }

        if (blockState.getValue(HALF) != DoubleBlockHalf.UPPER) {
            bellowBlockState = level.getBlockState(blockPos.below());
            return bellowBlockState.is(BlockTags.DIRT);
        } else {
            bellowBlockState = level.getBlockState(blockPos.below());
            return blockState.getValue(WATERLOGGED) || bellowBlockState.is(this) && bellowBlockState.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }
}
