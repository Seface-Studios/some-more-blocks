package net.sefacestudios.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PebblesBlock extends Block implements SimpleWaterloggedBlock {
  public static final MapCodec<PebblesBlock> CODEC = simpleCodec(PebblesBlock::new);
  public static final EnumProperty<@NotNull Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
  public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  private static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 3.0, 15.0);

  public PebblesBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
      this.stateDefinition
        .any()
        .setValue(FACING, Direction.NORTH)
        .setValue(WATERLOGGED, false)
    );
  }

  @NotNull
  @Override
  public MapCodec<PebblesBlock> codec() {
    return CODEC;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<@NotNull Block, @NotNull BlockState> state) {
    state.add(FACING, WATERLOGGED);
  }

  @NotNull
  @Override
  protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @NotNull
  @Override
  public BlockState rotate(BlockState state, Rotation rotation) {
    return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
  }

  @NotNull
  @Override
  public BlockState mirror(BlockState state, Mirror mirror) {
    return state.rotate(mirror.getRotation(state.getValue(FACING)));
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext ctx) {
    FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());

    return this.defaultBlockState()
      .setValue(FACING, ctx.getHorizontalDirection().getOpposite())
      .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
  }

  @NotNull
  @Override
  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }

  @NotNull
  @Override
  protected BlockState updateShape(
    BlockState state,
    LevelReader level,
    ScheduledTickAccess ticks,
    BlockPos pos,
    Direction direction,
    BlockPos neighborPos,
    BlockState neighborState,
    RandomSource random
  ) {
    if (state.getValue(WATERLOGGED)) {
      ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
    }

    return super.updateShape(state, level, ticks, pos, direction, neighborPos, neighborState, random);
  }

  @NotNull
  @Override
  protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
    if (!player.mayBuild()) {
      return InteractionResult.PASS;
    }

    if (!level.isClientSide()) {
      ItemStack stack = new ItemStack(this);
      if (!player.getAbilities().instabuild) {
        if (!player.getInventory().add(stack)) {
          player.drop(stack, false);
        }
      }

      level.playSound(null, pos, SoundEvents.STONE_HIT, SoundSource.BLOCKS, 0.6F, 1.2F);
      level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);

      if (state.getValue(WATERLOGGED)) {
        level.setBlock(pos, Blocks.WATER.defaultBlockState(), Block.UPDATE_ALL);
      } else {
        level.removeBlock(pos, false);
      }
    }

    return InteractionResult.SUCCESS;
  }

  @Override
  protected boolean canSurvive(@NotNull BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());
    return Block.isFaceFull(blockBelow.getCollisionShape(level, pos.below()), Direction.UP);
  }
}
