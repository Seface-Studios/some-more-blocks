package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;

import java.util.function.BiFunction;
import java.util.function.Function;

public class CloverBlock extends VegetationBlock implements BonemealableBlock, SegmentableBlock {
  public static final MapCodec<CloverBlock> CODEC = simpleCodec(CloverBlock::new);
  public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final IntegerProperty AMOUNT = BlockStateProperties.FLOWER_AMOUNT;
  private final Function<BlockState, VoxelShape> shapes;

  public CloverBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
      this.stateDefinition
        .any()
        .setValue(FACING, Direction.NORTH)
        .setValue(AMOUNT, 1));

    this.shapes = this.makeShapes();
  }

  @Override
  public MapCodec<CloverBlock> codec() {
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
    if (state.is(SMBBlocks.NETHER_CLOVER.get())) {
      BlockState blockBelow = level.getBlockState(pos.below());
      return blockBelow.is(SMBBlockTags.NETHER_CLOVER_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
    }

    return super.canSurvive(state, level, pos);
  }

  @Override
  public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
    return true;
  }

  @Override
  public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
    return true;
  }

  @Override
  public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
    int amount = state.getValue(AMOUNT);

    if (amount < SegmentableBlock.MAX_SEGMENT) {
      level.setBlock(pos, state.setValue(AMOUNT, amount + 1), 2);
      return;
    }

    Block.popResource(level, pos, new ItemStack(this));
  }
}
