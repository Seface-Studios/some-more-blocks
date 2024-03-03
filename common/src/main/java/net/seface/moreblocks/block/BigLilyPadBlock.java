package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.moreblocks.utils.BigLilyPadDirectionOffset;
import org.jetbrains.annotations.Nullable;

public class BigLilyPadBlock extends WaterlilyBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    public static final IntegerProperty TEXTURE = IntegerProperty.create("texture", 0, 3);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public BigLilyPadBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(TEXTURE, 0).setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext collisionCtx) {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
        property.add(TEXTURE, FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext block) {
        return this.defaultBlockState().setValue(FACING, block.getHorizontalDirection());
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity livingEntity, ItemStack item) {
        Direction facing = state.getValue(FACING);
        BigLilyPadDirectionOffset offset = BigLilyPadDirectionOffset.getByDirection(facing);

        level.setBlock(pos, state.setValue(TEXTURE, 0).setValue(FACING, facing), 3);
        level.setBlock(offset.getTopOffset(pos), this.defaultBlockState().setValue(TEXTURE, 2).setValue(FACING, facing), 3);
        level.setBlock(offset.getRightOffset(pos), this.defaultBlockState().setValue(TEXTURE, 1).setValue(FACING, facing), 3);
        level.setBlock(offset.getTopRightOffset(pos), this.defaultBlockState().setValue(TEXTURE, 3).setValue(FACING, facing), 3);
    }

    public void place(Level level, BlockPos pos, BlockState state, Direction direction) {
        BigLilyPadDirectionOffset offset = BigLilyPadDirectionOffset.getByDirection(direction);

        level.setBlock(pos, state.setValue(TEXTURE, 0).setValue(FACING, direction), 3);
        level.setBlock(offset.getTopOffset(pos), this.defaultBlockState().setValue(TEXTURE, 2).setValue(FACING, direction), 3);
        level.setBlock(offset.getRightOffset(pos), this.defaultBlockState().setValue(TEXTURE, 1).setValue(FACING, direction), 3);
        level.setBlock(offset.getTopRightOffset(pos), this.defaultBlockState().setValue(TEXTURE, 3).setValue(FACING, direction), 3);

    }

    public boolean isValidPlace(Level level, BlockPos pos, Direction direction) {
        BigLilyPadDirectionOffset offset = BigLilyPadDirectionOffset.getByDirection(direction);

        boolean srcFluid = level.getBlockState(pos).getFluidState().isSource();
        boolean topFluid = level.getBlockState(offset.getTopOffset(pos)).getFluidState().isSource();
        boolean rightFluid = level.getBlockState(offset.getRightOffset(pos)).getFluidState().isSource();
        boolean topRightFluid = level.getBlockState(offset.getTopRightOffset(pos)).getFluidState().isSource();

        boolean srcAir = level.getBlockState(pos.above()).isAir();
        boolean topAir = level.getBlockState(offset.getTopOffset(pos.above())).isAir();
        boolean rightAir = level.getBlockState(offset.getRightOffset(pos.above())).isAir();
        boolean topRightAir = level.getBlockState(offset.getTopRightOffset(pos.above())).isAir();

        return (srcFluid && topFluid && rightFluid && topRightFluid) && (srcAir && topAir && rightAir && topRightAir);
    }

    /**
     * Checks if all the 4 needed blocks are air.
     * @param level The world level.
     * @param pos The source position.
     * @param state
     * @return
     */
    /*public static boolean isValidPosition(Level level, BlockPos pos, BlockState state) {

        BlockState source = level.getBlockState(pos.above());
        BlockState top = level.getBlockState(offset.getTopOffset(pos).above());
        BlockState right = level.getBlockState(offset.getRightOffset(pos).above());
        BlockState topRight = level.getBlockState(offset.getTopRightOffset(pos).above());
    }*/






    /*@Override
    protected boolean mayPlaceOn(@NotNull BlockState state, BlockGetter block, BlockPos pos) {
        Direction facing = block.getBlockState(pos).getValue(FACING);
        BigLilyPadDirectionOffset offset = BigLilyPadDirectionOffset.getByFacingPropertyValue(facing);

        BlockState source = block.getBlockState(pos.above());
        BlockState top = block.getBlockState(offset.getTopOffset(pos).above());
        BlockState right = block.getBlockState(offset.getRightOffset(pos).above());
        BlockState topRight = block.getBlockState(offset.getTopRightOffset(pos).above());

        return source.is(Blocks.AIR) && top.is(Blocks.AIR) && right.is(Blocks.AIR) && topRight.is(Blocks.AIR);
    }*/

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (level.isClientSide) return super.playerWillDestroy(level, pos, state, player);

        int texture = state.getValue(TEXTURE);
        Direction facing = state.getValue(FACING);
        BigLilyPadDirectionOffset offset = BigLilyPadDirectionOffset.getByDirection(facing);

        if (player.isCreative()) {
            if (texture == 0) {
                level.destroyBlock(offset.getTopOffset(pos), true);
                level.destroyBlock(offset.getRightOffset(pos), true);
                level.destroyBlock(offset.getTopRightOffset(pos), true);
            }

            if (facing == Direction.NORTH) {
                if (texture == 1) {
                    level.destroyBlock(pos.west(), true);
                    level.destroyBlock(pos.north(), true);
                    level.destroyBlock(pos.west().north(), true);
                }

                if (texture == 2) {
                    level.destroyBlock(pos.south(), true);
                    level.destroyBlock(pos.east(), true);
                    level.destroyBlock(pos.south().east(), true);
                }

                if (texture == 3) {
                    level.destroyBlock(pos.south(), true);
                    level.destroyBlock(pos.west(), true);
                    level.destroyBlock(pos.south().west(), true);
                }
            }

            if (facing == Direction.EAST) {
                if (texture == 1) {
                    level.destroyBlock(pos.east(), true);
                    level.destroyBlock(pos.north(), true);
                    level.destroyBlock(pos.east().north(), true);
                }

                if (texture == 2) {
                    level.destroyBlock(pos.south(), true);
                    level.destroyBlock(pos.west(), true);
                    level.destroyBlock(pos.south().west(), true);
                }

                if (texture == 3) {
                    level.destroyBlock(pos.west(), true);
                    level.destroyBlock(pos.north(), true);
                    level.destroyBlock(pos.west().north(), true);
                }
            }

            if (facing == Direction.SOUTH) {
                if (texture == 1) {
                    level.destroyBlock(pos.south(), true);
                    level.destroyBlock(pos.east(), true);
                    level.destroyBlock(pos.south().east(), true);
                }

                if (texture == 2) {
                    level.destroyBlock(pos.west(), true);
                    level.destroyBlock(pos.north(), true);
                    level.destroyBlock(pos.west().north(), true);
                }

                if (texture == 3) {
                    level.destroyBlock(pos.north(), true);
                    level.destroyBlock(pos.east(), true);
                    level.destroyBlock(pos.north().east(), true);
                }
            }

            if (facing == Direction.WEST) {
                if (texture == 1) {
                    level.destroyBlock(pos.west(), true);
                    level.destroyBlock(pos.south(), true);
                    level.destroyBlock(pos.west().south(), true);
                }

                if (texture == 2) {
                    level.destroyBlock(pos.north(), true);
                    level.destroyBlock(pos.east(), true);
                    level.destroyBlock(pos.north().east(), true);
                }

                if (texture == 3) {
                    level.destroyBlock(pos.east(), true);
                    level.destroyBlock(pos.south(), true);
                    level.destroyBlock(pos.east().south(), true);
                }
            }
        }

        return super.playerWillDestroy(level, pos, state, player);
    }

    private static boolean isValidBlockAt(BlockPos pos) {
        return true;
    }
}
