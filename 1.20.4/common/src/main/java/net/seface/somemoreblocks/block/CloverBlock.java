package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
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

public class CloverBlock extends BushBlock {
  public static final MapCodec<CloverBlock> CODEC = simpleCodec(CloverBlock::new);
  public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final IntegerProperty AMOUNT = BlockStateProperties.FLOWER_AMOUNT;
  private static final BiFunction<Direction, Integer, VoxelShape> SHAPE_BY_PROPERTIES = Util.memoize((direction, amount) -> {
    VoxelShape[] shapes = new VoxelShape[]{
      Block.box(8.0, 0.0, 8.0, 16.0, 3.0, 16.0),
      Block.box(8.0, 0.0, 0.0, 16.0, 3.0, 8.0),
      Block.box(0.0, 0.0, 0.0, 8.0, 3.0, 8.0),
      Block.box(0.0, 0.0, 8.0, 8.0, 3.0, 16.0)
    };

    VoxelShape shape = Shapes.empty();

    for(int i = 0; i < amount; ++i) {
      int $$5 = Math.floorMod(i - direction.get2DDataValue(), 4);
      shape = Shapes.or(shape, shapes[$$5]);
    }

    return shape.singleEncompassing();
  });

  public static final int MIN_FLOWERS = 1;
  public static final int MAX_FLOWERS = 4;

  public CloverBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
      this.stateDefinition
        .any()
        .setValue(FACING, Direction.NORTH)
        .setValue(AMOUNT, 1));
  }

  @Override
  protected MapCodec<? extends BushBlock> codec() {
    return CODEC;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
    state.add(FACING, AMOUNT);
  }

  public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext ctx) {
    return SHAPE_BY_PROPERTIES.apply(state.getValue(FACING), state.getValue(AMOUNT));
  }

  public BlockState rotate(BlockState state, Rotation rotation) {
    return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
  }

  public BlockState mirror(BlockState state, Mirror mirror) {
    return state.rotate(mirror.getRotation(state.getValue(FACING)));
  }

  public boolean canBeReplaced(BlockState state, BlockPlaceContext ctx) {
    return !ctx.isSecondaryUseActive() && ctx.getItemInHand().is(this.asItem()) && state.getValue(AMOUNT) < MAX_FLOWERS ? true : super.canBeReplaced(state, ctx);
  }

  public BlockState getStateForPlacement(BlockPlaceContext ctx) {
    BlockState state = ctx.getLevel().getBlockState(ctx.getClickedPos());

    return state.is(this) ?
      state.setValue(AMOUNT, Math.min(4, state.getValue(AMOUNT) + 1)) :
      this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    if (state.is(SMBBlocks.NETHER_CLOVER.get())) {
      BlockState blockBelow = level.getBlockState(pos.below());
      return blockBelow.is(SMBBlockTags.NETHER_CLOVER_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
    }

    return super.canSurvive(state, level, pos);
  }
}
