package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.block.properties.QuadDirection;
import net.seface.somemoreblocks.registries.SMBBlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BigLilyPadBlock extends WaterlilyBlock {
  protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
  public static final EnumProperty<QuadDirection> POSITION = SMBBlockStateProperties.POSITION;
  public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

  public BigLilyPadBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
      (this.stateDefinition.any())
        .setValue(POSITION, QuadDirection.BOTTOM_LEFT)
        .setValue(FACING, Direction.NORTH));
  }

  @NotNull
  @Override
  public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
    property.add(POSITION, FACING);
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    BlockPos pos = context.getClickedPos();
    Level level = context.getLevel();

    Direction facing = context.getHorizontalDirection();
    BlockPos topLeftPos = pos.relative(facing);
    BlockPos topRightPos = pos.relative(facing.getClockWise()).relative(facing);
    BlockPos bottomRightPos = pos.relative(facing.getClockWise());

    boolean isPlaceable = level.getBlockState(pos).canBeReplaced(context) && level.getBlockState(topLeftPos).canBeReplaced(context) &&
                          level.getBlockState(topRightPos).canBeReplaced(context) && level.getBlockState(bottomRightPos).canBeReplaced(context);

    boolean isOnFluidOrIce =
      (level.getFluidState(pos.below()).is(Fluids.WATER) || level.getBlockState(pos.below()).is(Blocks.ICE)) &&
      (level.getFluidState(topLeftPos.below()).is(Fluids.WATER) || level.getBlockState(topLeftPos.below()).is(Blocks.ICE)) &&
      (level.getFluidState(topRightPos.below()).is(Fluids.WATER) || level.getBlockState(topRightPos.below()).is(Blocks.ICE)) &&
      (level.getFluidState(bottomRightPos.below()).is(Fluids.WATER) || level.getBlockState(bottomRightPos.below()).is(Blocks.ICE));

    return isPlaceable && isOnFluidOrIce ? super.getStateForPlacement(context) : null;
  }

  @Override
  public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack item) {
    Direction facing = player != null ? player.getDirection() : Direction.getRandom(RandomSource.create());

    BlockPos topLeftPos = pos.relative(facing);
    BlockPos topRightPos = pos.relative(facing.getClockWise()).relative(facing);
    BlockPos bottomRightPos = pos.relative(facing.getClockWise());

    level.setBlock(pos, this.defaultBlockState().setValue(FACING, facing), 3);
    level.setBlock(bottomRightPos, this.createBlockStateFor(facing, QuadDirection.BOTTOM_RIGHT), 3);
    level.setBlock(topRightPos, this.createBlockStateFor(facing, QuadDirection.TOP_RIGHT), 3);
    level.setBlock(topLeftPos, this.createBlockStateFor(facing, QuadDirection.TOP_LEFT), 3);
  }

  @Override
  protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockPos neighborBlockPos = this.getRelativeBlockPos(state, pos);
    QuadDirection expectedPosition = this.getExpectedNeighborPosition(state);

    BlockState neighborState = level.getBlockState(neighborBlockPos);

    if (state.getValue(POSITION) != QuadDirection.BOTTOM_LEFT) {
      return neighborState.is(this) && neighborState.getValue(POSITION) == expectedPosition && super.canSurvive(state, level, pos);
    }

    return super.canSurvive(state, level, pos);
  }

  @Override
  protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean bool) {
    Direction facing = state.getValue(FACING);
    QuadDirection position = state.getValue(POSITION);

    if (position == QuadDirection.BOTTOM_RIGHT) {
      BlockPos bottomLeftPos = pos.relative(facing.getCounterClockWise());

      if (level.getBlockState(bottomLeftPos).is(this)) {
        level.destroyBlock(bottomLeftPos, true);
        return;
      }
    }

    super.onRemove(state, level, pos, newState, bool);
  }

  private BlockState createBlockStateFor(Direction facing, QuadDirection position) {
    return this.defaultBlockState().setValue(FACING, facing).setValue(POSITION, position);
  }

  private BlockPos getRelativeBlockPos(BlockState state, BlockPos pos) {
    Direction facing = state.getValue(FACING);
    QuadDirection position = state.getValue(POSITION);

    return switch (position) {
      case BOTTOM_LEFT -> pos.relative(facing.getClockWise());
      case TOP_LEFT -> pos.relative(facing.getOpposite());
      case TOP_RIGHT -> pos.relative(facing.getCounterClockWise());
      case BOTTOM_RIGHT -> pos.relative(facing);
    };
  }

  private QuadDirection getExpectedNeighborPosition(BlockState state) {
    QuadDirection position = state.getValue(POSITION);

    return switch (position) {
      case BOTTOM_LEFT -> QuadDirection.BOTTOM_RIGHT;
      case TOP_LEFT -> QuadDirection.BOTTOM_LEFT;
      case TOP_RIGHT -> QuadDirection.TOP_LEFT;
      case BOTTOM_RIGHT -> QuadDirection.TOP_RIGHT;
    };
  }
}
