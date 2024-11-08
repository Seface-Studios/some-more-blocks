package net.seface.moreblocks.block;

import com.mojang.serialization.MapCodec;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BucketPickup;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.moreblocks.interfaces.ILeafLitterBlock;
import net.seface.moreblocks.item.LeavesBucketItem;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBItems;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class LeafLitterBlock extends TransparentBlock implements BucketPickup, ILeafLitterBlock {
    public static final MapCodec<LeafLitterBlock> CODEC = simpleCodec(LeafLitterBlock::new);
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

    @Getter
    private final float chance;

    public LeafLitterBlock(Properties properties) {
      this(properties, 100.0F);
    }

    public LeafLitterBlock(Properties properties, float chance) {
        super(properties);

        this.chance = chance;
    }

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
        return SHAPE;
    }

    /*@Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity livingEntity, ItemStack item) {
        BlockState blockBellow = level.getBlockState(pos.below());
        boolean isLower = blockBellow.is(Blocks.FARMLAND) || blockBellow.is(Blocks.DIRT_PATH);

        level.setBlock(pos, state.setValue(LOWER, isLower), 0);
    }*/

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos2) {
        return !state.canSurvive(levelAccessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state2, levelAccessor, pos, pos2);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockBellow = level.getBlockState(pos.below());
        return blockBellow.isSolid();
    }

  @Override
  public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
      ItemStack stack = super.getCloneItemStack(level, pos, state);
      ((LeavesBucketItem) stack.getItem()).setCustomData(stack, 16);

      return stack;
  }

  @Override
  public ItemStack pickupBlock(@Nullable Player player, LevelAccessor level, BlockPos pos, BlockState state) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
        if (!level.isClientSide()) {
            level.levelEvent(2001, pos, Block.getId(state));
        }

        ItemStack stack = null;

        if (state.is(MBBlocks.LEAF_LITTER)) { stack = MBItems.LEAVES_BUCKET.getDefaultInstance(); }
        if (state.is(MBBlocks.BIRCH_LEAF_LITTER)) { stack = MBItems.BIRCH_LEAVES_BUCKET.getDefaultInstance(); }
        if (state.is(MBBlocks.SPRUCE_LEAF_LITTER)) { stack = MBItems.SPRUCE_LEAVES_BUCKET.getDefaultInstance(); }
        if (state.is(MBBlocks.AZALEA_LEAF_LITTER)) { stack = MBItems.AZALEA_LEAVES_BUCKET.getDefaultInstance(); }
        if (state.is(MBBlocks.FLOWERING_AZALEA_LEAF_LITTER)) { stack = MBItems.FLOWERING_AZALEA_LEAVES_BUCKET.getDefaultInstance(); }

        LeavesBucketItem bucketItem = ((LeavesBucketItem) stack.getItem());
        bucketItem.setCustomData(stack, 1);

        return stack;
    }

    public Optional<SoundEvent> getPickupSound() {
        return Optional.empty();
    }
}
