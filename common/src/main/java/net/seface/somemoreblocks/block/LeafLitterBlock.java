package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import lombok.Getter;
import lombok.Setter;
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
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.data.SMBBlockTags;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@Getter
@SuppressWarnings("deprecation")
public class LeafLitterBlock extends TransparentBlock implements BucketPickup {
  public static final MapCodec<LeafLitterBlock> CODEC = simpleCodec(LeafLitterBlock::new);
  protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

  @Setter
  private Item bucketItem;
  private final float chance;

  public LeafLitterBlock(Properties properties) {
    this(properties, 25.0F);
  }

  public LeafLitterBlock(Properties properties, float chance) {
    super(properties);
    this.chance = chance;
  }

  @NotNull
  @Override
  protected MapCodec<? extends TransparentBlock> codec() {
    return CODEC;
  }

  @Override
  public boolean skipRendering(BlockState state1, BlockState state2, Direction direction) {
    return state2.is(this) || super.skipRendering(state1, state2, direction);
  }

  @NotNull
  @Override
  public VoxelShape getOcclusionShape(BlockState state, BlockGetter block, BlockPos pos) {
    return Shapes.empty();
  }

  @NotNull
  @Override
  public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @NotNull
  @Override
  public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
    return !state1.canSurvive(level, pos1) ?
      Blocks.AIR.defaultBlockState() :
      super.updateShape(state1, direction, state2, level, pos1, pos2);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState stateBelow = level.getBlockState(pos.below());
    return Block.isFaceFull(stateBelow.getCollisionShape(level, pos.below()), Direction.UP)
      || stateBelow.is(SMBBlockTags.LEAF_LITTERS_PLACEABLE);
  }

  @NotNull
  @Override
  public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
    ItemStack stack = super.getCloneItemStack(level, pos, state);
    stack.set(SMBDataComponentTypes.BUCKET_VOLUME, LeavesBucketItem.MAX_VOLUME);

    return stack;
  }

  @Override
  public @NotNull ItemStack pickupBlock(@Nullable Player player, LevelAccessor level, BlockPos pos, BlockState state) {
    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
    if (!level.isClientSide()) {
      level.levelEvent(2001, pos, Block.getId(state));
    }

    return this.bucketItem.getDefaultInstance();
  }

  @NotNull
  @Override
  public Optional<SoundEvent> getPickupSound() {
    return Optional.empty();
  }
}
