package net.seface.moreblocks.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.moreblocks.tags.MBBlockTags;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class WallMushroomColonyBlock extends BushBlock {
    public static final MapCodec<WallMushroomColonyBlock> CODEC = simpleCodec(WallMushroomColonyBlock::new);
    protected static final Map<Direction, VoxelShape> SHAPE = Maps.newEnumMap(ImmutableMap.of(
            Direction.SOUTH, Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 6.0),
            Direction.WEST, Block.box(10.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Direction.NORTH, Block.box(0.0, 0.0, 10.0, 16.0, 16.0, 16.0),
            Direction.EAST, Block.box(0.0, 0.0, 0.0, 6.0, 16.0, 16.0)
    ));

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public WallMushroomColonyBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    public MapCodec<WallMushroomColonyBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext collisionCtx) {
        return SHAPE.get(state.getValue(FACING));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
        property.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState state = this.defaultBlockState();
        LevelReader level = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        Direction[] direction = ctx.getNearestLookingDirections();
        Direction[] savedDirection = direction;
        int directionLen = direction.length;

        for(int i = 0; i < directionLen; ++i) {
            Direction direction1 = savedDirection[i];
            if (direction1.getAxis().isHorizontal()) {
                Direction $$6 = direction1.getOpposite();
                state = state.setValue(FACING, $$6);
                if (state.canSurvive(level, pos)) {
                    return state;
                }
            }
        }

        return null;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos relativePos = pos.relative(direction.getOpposite());
        BlockState block = level.getBlockState(relativePos);

        return block.is(MBBlockTags.MUSHROOM_COLONY_PLACEABLE);
    }
}
