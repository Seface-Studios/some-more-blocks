package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
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

    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext collisionCtx) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
        property.add(TEXTURE, FACING);
    }

  @Override
  protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
    FluidState fluidState = blockGetter.getFluidState(pos);
    FluidState fluidState2 = blockGetter.getFluidState(pos.above());

    return (fluidState.getType() == Fluids.WATER || state.getBlock() instanceof IceBlock) && fluidState2.getType() == Fluids.EMPTY;
  }

  @Nullable
  @Override
  public BlockState getStateForPlacement(BlockPlaceContext ctx) {
    BlockPos pos = ctx.getClickedPos();
    Level level = ctx.getLevel();

    Direction facing = ctx.getHorizontalDirection();

    BlockPos sidePos = BigLilyPadChildOffsets.getSidePos(pos, facing, 0);
    BlockPos sideTopPos = BigLilyPadChildOffsets.getSideTopPos(pos, facing, 0);
    BlockPos topPos = BigLilyPadChildOffsets.getTopPos(pos, facing, 0);

    return (level.getBlockState(pos).canBeReplaced(ctx) && level.getFluidState(pos.below()).isSource()) &&
           (level.getBlockState(sidePos).canBeReplaced(ctx) && level.getFluidState(sidePos.below()).isSource()) &&
           (level.getBlockState(sideTopPos).canBeReplaced(ctx) && level.getFluidState(sideTopPos.below()).isSource()) &&
           (level.getBlockState(topPos).canBeReplaced(ctx) && level.getFluidState(topPos.below()).isSource())
      ? super.getStateForPlacement(ctx) : null;
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    return super.canSurvive(state, level, pos);
  }

  @Override
  public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack item) {
    Direction facing = player.getDirection();

    BlockPos rightPos = pos.offset(facing.getClockWise().getNormal());
    BlockPos rightTopPos = pos.offset(facing.getClockWise().getNormal().offset(facing.getNormal()));
    BlockPos topPos = pos.offset(facing.getNormal());

    level.setBlock(pos, buildState(state, facing, 0), 3);
    level.setBlock(rightPos, buildState(state, facing, 1), 3);
    level.setBlock(rightTopPos, buildState(state, facing, 2), 3);
    level.setBlock(topPos, buildState(state, facing, 3), 3);
  }

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

  protected static BlockState buildState(BlockState state, Direction facing, int texture) {
    return state.setValue(FACING, facing).setValue(TEXTURE, texture);
  }

  protected boolean destroyBlockIfSameType(Level level, BlockPos pos) {
      if (!level.getBlockState(pos).is(this)) return false;
      return level.destroyBlock(pos, true);
  }

  public enum BigLilyPadChildOffsets {
    DESTROYED_FROM_TEXTURE_0(0,
      new Rotation[]{Rotation.CLOCKWISE_90},
      new Rotation[]{Rotation.CLOCKWISE_90, Rotation.NONE},
      new Rotation[]{Rotation.NONE}
    ),
    DESTROYED_FROM_TEXTURE_1(1,
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90},
      new Rotation[]{Rotation.NONE},
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90, Rotation.NONE}
    ),
    DESTROYED_FROM_TEXTURE_2(2,
      new Rotation[]{Rotation.CLOCKWISE_90},
      new Rotation[]{Rotation.NONE},
      new Rotation[]{Rotation.CLOCKWISE_90, Rotation.NONE}
    ),
    DESTROYED_FROM_TEXTURE_3(3,
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90},
      new Rotation[]{Rotation.COUNTERCLOCKWISE_90, Rotation.NONE},
      new Rotation[]{Rotation.NONE}
    );

    private final int texture;
    private final Rotation[] sidePosRotations;
    private final Rotation[] sideTopPosRotations;
    private final Rotation[] topPosRotations;

    /**
     * Todo: Add a param to use a single getPOSITION method.
     */
    BigLilyPadChildOffsets(int texture, Rotation[] sidePosRotations, Rotation[] sideTopRotations, Rotation[] topPosRotations) {
      this.texture = texture;
      this.sidePosRotations = sidePosRotations;
      this.sideTopPosRotations = sideTopRotations;
      this.topPosRotations = topPosRotations;
    }

    public static BlockPos getSidePos(BlockPos pos, Direction facing, int texture) {
      BigLilyPadChildOffsets appendTo = BigLilyPadChildOffsets.getOffsetFromTexture(texture);
      boolean opposite = appendTo.texture >= 2;
      facing = opposite ? facing.getOpposite() : facing;

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
