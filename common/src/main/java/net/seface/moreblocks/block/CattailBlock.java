package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class CattailBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public CattailBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(HALF, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level level = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        FluidState fluidState = level.getFluidState(pos);

        return super.getStateForPlacement(ctx).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    /*public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockAbove = level.getBlockState(pos.above());
        BlockState blockBelow = level.getBlockState(pos.below());

        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            blockBelow = level.getBlockState(pos.below());
            return blockBelow.is(BlockTags.SAND) || blockBelow.is(BlockTags.DIRT) || blockBelow.is(Blocks.GRAVEL) &&
                   !blockAbove.getValue(WATERLOGGED);
        }

        return blockBelow.is(this) && blockBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
    }*/
}
