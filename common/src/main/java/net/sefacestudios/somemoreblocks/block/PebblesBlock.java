package net.sefacestudios.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SegmentableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Function;

public class PebblesBlock extends Block implements SegmentableBlock {
  public static final MapCodec<PebblesBlock> CODEC = simpleCodec(PebblesBlock::new);
  public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final IntegerProperty AMOUNT = BlockStateProperties.SEGMENT_AMOUNT;
  private final Function<BlockState, VoxelShape> shapes;

  public PebblesBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
      this.stateDefinition
        .any()
        .setValue(FACING, Direction.NORTH)
        .setValue(AMOUNT, 1));

    this.shapes = this.makeShapes();
  }

  @Override
  public MapCodec<PebblesBlock> codec() {
    return CODEC;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
    state.add(FACING, AMOUNT);
  }

  public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext ctx) {
    return this.shapes.apply(state);
  }

  public BlockState rotate(BlockState state, Rotation rotation) {
    return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
  }

  public BlockState mirror(BlockState state, Mirror mirror) {
    return state.rotate(mirror.getRotation(state.getValue(FACING)));
  }

  public boolean canBeReplaced(BlockState state, BlockPlaceContext ctx) {
    return this.canBeReplaced(state, ctx, AMOUNT) ? true : super.canBeReplaced(state, ctx);
  }

  public BlockState getStateForPlacement(BlockPlaceContext ctx) {
    BlockState state = ctx.getLevel().getBlockState(ctx.getClickedPos());

    return state.is(this) ?
      state.setValue(AMOUNT, Math.min(4, state.getValue(AMOUNT) + 1)) :
      this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
  }

  private Function<BlockState, VoxelShape> makeShapes() {
    return this.getShapeForEachState(this.getShapeCalculator(FACING, AMOUNT));
  }

  @Override
  public double getShapeHeight() {
    return 3.0F;
  }

  @Override
  protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());
    return Block.isFaceFull(blockBelow.getCollisionShape(level, pos.below()), Direction.UP);
  }
}
