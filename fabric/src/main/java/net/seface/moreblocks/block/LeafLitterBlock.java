package net.seface.moreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LeafLitterBlock extends TransparentBlock implements BucketPickup {
    public static final MapCodec<LeafLitterBlock> CODEC = simpleCodec(LeafLitterBlock::new);
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    protected static final VoxelShape SHAPE_LOWER = Block.box(0.0, -1.0, 0.0, 16.0, 1.0, 16.0);
    public static final BooleanProperty LOWER = BooleanProperty.create("lower");

    private SolidBucketItem bucket;

    public LeafLitterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(LOWER, false));
    }

    /*public LeafLitterBlock(SolidBucketItem bucket, Properties properties) {
        super(properties);

        this.bucket = bucket;
        this.registerDefaultState(this.defaultBlockState().setValue(LOWER, false));
    }*/

    @Override
    protected MapCodec<? extends TransparentBlock> codec() {
        return CODEC;
    }

    @Override
    public boolean skipRendering(BlockState state1, BlockState state2, Direction direction) {
        return state2.is(this) || super.skipRendering(state1, state2, direction);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState $$0, BlockGetter $$1, BlockPos $$2) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext collisionCtx) {
        return state.getValue(LOWER) ? SHAPE_LOWER : SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
        property.add(LOWER);
    }

    public BlockState getStateForPlacement(BlockPlaceContext block) {
        return this.defaultBlockState().setValue(LOWER, false);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity livingEntity, ItemStack item) {
        BlockState blockBellow = level.getBlockState(pos.below());
        boolean isLower = blockBellow.is(Blocks.FARMLAND) || blockBellow.is(Blocks.DIRT_PATH);

        level.setBlock(pos, state.setValue(LOWER, isLower), 0);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos2) {
        return !state.canSurvive(levelAccessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state2, levelAccessor, pos, pos2);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockBellow = level.getBlockState(pos.below());

        if (state.getValue(LOWER)) {
            return blockBellow.is(Blocks.FARMLAND) || blockBellow.is(Blocks.DIRT_PATH);
        }

        return blockBellow.isSolid();
    }

    public ItemStack pickupBlock(@Nullable Player player, LevelAccessor level, BlockPos pos, BlockState state) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
        if (!level.isClientSide()) {
            level.levelEvent(2001, pos, Block.getId(state));
        }

        if (state.is(MBBlocks.LEAF_LITTER)) { return new ItemStack(MBItems.LEAVES_BUCKET); }
        if (state.is(MBBlocks.FROZEN_LEAF_LITTER)) { return new ItemStack(MBItems.FROZEN_LEAVES_BUCKET); }
        if (state.is(MBBlocks.AZALEA_LEAF_LITTER)) { return new ItemStack(MBItems.AZALEA_LEAVES_BUCKET); }
        if (state.is(MBBlocks.FLOWERING_AZALEA_LEAF_LITTER)) { return new ItemStack(MBItems.FLOWERING_AZALEA_LEAVES_BUCKET); }

        return new ItemStack(Items.AIR);
    }

    public Optional<SoundEvent> getPickupSound() {
        return Optional.empty();
    }
}
