package net.seface.moreblocks.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class WallMushroomColonyBlock extends TransparentBlock {
    protected static final Map<Direction, VoxelShape> SHAPE = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 6.0),
            Direction.EAST, Block.box(10.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Direction.SOUTH, Block.box(0.0, 0.0, 10.0, 16.0, 16.0, 16.0),
            Direction.WEST, Block.box(0.0, 0.0, 0.0, 6.0, 16.0, 16.0)
    ));

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public WallMushroomColonyBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext collisionCtx) {
        return SHAPE.get(state.getValue(FACING));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
        property.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext block) {
        return this.defaultBlockState().setValue(FACING, block.getHorizontalDirection());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState block = level.getBlockState(pos.relative(state.getValue(FACING)));
        return block.is(BlockTags.LOGS) || block.is(BlockTags.DIRT);
    }
}
