package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BigLilyPadBlock extends WaterlilyBlock {
  protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
  public static final IntegerProperty TEXTURE = IntegerProperty.create("texture", 0, 3);
  public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

  public BigLilyPadBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
      (this.stateDefinition.any())
        .setValue(TEXTURE, 0)
        .setValue(FACING, Direction.NORTH));
  }

  @NotNull
  @Override
  public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
    property.add(TEXTURE, FACING);
  }

  @Override
  protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
    FluidState fluidState = blockGetter.getFluidState(pos);
    FluidState fluidState2 = blockGetter.getFluidState(pos.above());

    return (fluidState.getType() == Fluids.WATER || state.getBlock() instanceof IceBlock) && fluidState2.getType() == Fluids.EMPTY;
  }

  @Override
  public BlockState getStateForPlacement(BlockPlaceContext context) {
    BlockPos pos = context.getClickedPos();
    Level level = context.getLevel();

    Direction facing = context.getHorizontalDirection();

    BlockPos sidePos = BigLilyPadChildOffsets.getSidePos(pos, facing, 0);
    BlockPos sideTopPos = BigLilyPadChildOffsets.getSideTopPos(pos, facing, 0);
    BlockPos topPos = BigLilyPadChildOffsets.getTopPos(pos, facing, 0);

    return (level.getBlockState(pos).canBeReplaced(context) && level.getFluidState(pos.below()).isSource()) &&
      (level.getBlockState(sidePos).canBeReplaced(context) && level.getFluidState(sidePos.below()).isSource()) &&
      (level.getBlockState(sideTopPos).canBeReplaced(context) && level.getFluidState(sideTopPos.below()).isSource()) &&
      (level.getBlockState(topPos).canBeReplaced(context) && level.getFluidState(topPos.below()).isSource())
      ? super.getStateForPlacement(context) : null;
  }

  @Override
  public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack item) {
    Direction facing = player != null ? player.getDirection() : Direction.getRandom(RandomSource.create());

    BlockPos rightPos = pos.offset(facing.getClockWise().getNormal());
    BlockPos rightTopPos = pos.offset(facing.getClockWise().getNormal().offset(facing.getNormal()));
    BlockPos topPos = pos.offset(facing.getNormal());

    level.setBlock(pos, createBlockState(state, facing, 0), 3);
    level.setBlock(rightPos, createBlockState(state, facing, 1), 3);
    level.setBlock(rightTopPos, createBlockState(state, facing, 2), 3);
    level.setBlock(topPos, createBlockState(state, facing, 3), 3);
  }

  @NotNull
  @Override
  public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
    if (level.isClientSide) return super.playerWillDestroy(level, pos, state, player);

    Direction facing = state.getValue(FACING);
    int texture = state.getValue(TEXTURE);

    this.destroyBlockIfSameType(level, BigLilyPadChildOffsets.getSidePos(pos, facing, texture));
    this.destroyBlockIfSameType(level, BigLilyPadChildOffsets.getSideTopPos(pos, facing, texture));
    this.destroyBlockIfSameType(level, BigLilyPadChildOffsets.getTopPos(pos, facing, texture));

    return super.playerWillDestroy(level, pos, state, player);
  }

  private static BlockState createBlockState(BlockState state, Direction facing, int texture) {
    return state.setValue(FACING, facing).setValue(TEXTURE, texture);
  }

  private void destroyBlockIfSameType(Level level, BlockPos pos) {
    if (!level.getBlockState(pos).is(this)) return;
    level.destroyBlock(pos, true);
  }

  /* NEED REWORK */
  protected enum BigLilyPadChildOffsets {
    DESTROYED_FROM_TEXTURE_0(0,
      new Rotation[]{Rotation.CLOCKWISE_90},
      new Rotation[]{Rotation.CLOCKWISE_90, Rotation.NONE},
      new Rotation[]{Rotation.NONE},
      false
    ),
    DESTROYED_FROM_TEXTURE_1(1,
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90},
      new Rotation[]{Rotation.NONE},
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90, Rotation.NONE},
      false
    ),
    DESTROYED_FROM_TEXTURE_2(2,
      new Rotation[]{Rotation.CLOCKWISE_90},
      new Rotation[]{Rotation.NONE},
      new Rotation[]{Rotation.CLOCKWISE_90, Rotation.NONE},
      true
    ),
    DESTROYED_FROM_TEXTURE_3(3,
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90},
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90, Rotation.NONE},
      new Rotation[]{Rotation.NONE},
      true
    );

    private final int texture;
    private final Rotation[] sidePosRotations;
    private final Rotation[] sideTopPosRotations;
    private final Rotation[] topPosRotations;
    private final boolean opposite;

    /**
     * Todo: Add a param to use a single getPOSITION method.
     */
    BigLilyPadChildOffsets(int texture, Rotation[] sidePosRotations, Rotation[] sideTopRotations, Rotation[] topPosRotations, boolean opposite) {
      this.texture = texture;
      this.sidePosRotations = sidePosRotations;
      this.sideTopPosRotations = sideTopRotations;
      this.topPosRotations = topPosRotations;
      this.opposite = opposite;
    }

    public static BlockPos getSidePos(BlockPos pos, Direction facing, int texture) {
      BigLilyPadChildOffsets appendTo = BigLilyPadChildOffsets.getOffsetFromTexture(texture);
      facing = appendTo.opposite ? facing.getOpposite() : facing;

      BlockPos savedPos = pos;
      for (Rotation rotation : appendTo.sidePosRotations) {
        savedPos = savedPos.offset(rotation.rotate(facing).getNormal());
      }

      return savedPos;
    }

    public static BlockPos getSideTopPos(BlockPos pos, Direction facing, int texture) {
      BigLilyPadChildOffsets appendTo = BigLilyPadChildOffsets.getOffsetFromTexture(texture);
      boolean opposite = appendTo.texture >= 2;
      facing = opposite ? facing.getOpposite() : facing;

      BlockPos savedPos = pos;
      for (Rotation rotation : appendTo.sideTopPosRotations) {
        savedPos = savedPos.offset(rotation.rotate(facing).getNormal());
      }

      return savedPos;
    }

    public static BlockPos getTopPos(BlockPos pos, Direction facing, int texture) {
      BigLilyPadChildOffsets appendTo = BigLilyPadChildOffsets.getOffsetFromTexture(texture);
      boolean opposite = appendTo.texture >= 2;
      facing = opposite ? facing.getOpposite() : facing;

      BlockPos savedPos = pos;
      for (Rotation rotation : appendTo.topPosRotations) {
        savedPos = savedPos.offset(rotation.rotate(facing).getNormal());
      }

      return savedPos;
    }

    public static BigLilyPadChildOffsets getOffsetFromTexture(int texture) {
      for (BigLilyPadChildOffsets append : BigLilyPadChildOffsets.values()) {
        if (append.texture == texture) {
          return append;
        }
      }

      return BigLilyPadChildOffsets.DESTROYED_FROM_TEXTURE_0;
    }
  }
}
