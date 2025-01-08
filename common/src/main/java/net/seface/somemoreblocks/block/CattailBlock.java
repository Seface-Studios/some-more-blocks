package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.seface.somemoreblocks.data.MBBlockTags;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class CattailBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

  public CattailBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, false));
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());

    if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
      return blockBelow.is(MBBlockTags.CATTAIL_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
    }

    return blockBelow.is(this) && blockBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
    stateBuilder.add(HALF, WATERLOGGED);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    Level level = context.getLevel();
    BlockPos pos = context.getClickedPos();
    FluidState fluidState = level.getFluidState(pos);

    return super.getStateForPlacement(context).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
  }

  @NotNull
  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }
}
