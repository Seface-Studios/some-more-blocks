package net.seface.moreblocks.block;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.moreblocks.MoreBlocks;
import net.seface.moreblocks.utils.LeavesBucketItems;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LeafLitterBlock extends TransparentBlock implements BucketPickup {
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    protected static final VoxelShape SHAPE_LOWER = Block.box(0.0, -1.0, 0.0, 16.0, 1.0, 16.0);
    public static final BooleanProperty LOWER = BooleanProperty.create("lower");

    public LeafLitterBlock(Properties properties) {
        super(properties);
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

    @Override
    public ItemStack pickupBlock(@Nullable Player player, LevelAccessor level, BlockPos pos, BlockState state) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
        String id = this.getDescriptionId()
                .replace("block.", "")
                .replace(".", ":");

        Minecraft.getInstance().player.sendSystemMessage(Component.literal(id));
        return new ItemStack(BuiltInRegistries.ITEM.get(
                new ResourceLocation(MoreBlocks.ID, LeavesBucketItems.getByBlockIdentifier(id).getBucketIdentifier())));
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.empty();
    }
}
