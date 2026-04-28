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
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

@Setter
@Getter
@SuppressWarnings("deprecation")
public class LeafLitterBlock extends HalfTransparentBlock implements BucketPickup {
  //public static final MapCodec<LeafLitterBlock> CODEC = simpleCodec(LeafLitterBlock::new);
  protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);

  private Item bucketItem;

  public LeafLitterBlock(Properties properties) {
    super(properties);
  }

  /*@NotNull
  @Override
  protected MapCodec<? extends TransparentBlock> codec() {
    return CODEC;
  }*/

  @Override
  public boolean skipRendering(BlockState state1, BlockState state2, Direction direction) {
    return state2.is(this) || super.skipRendering(state1, state2, direction);
  }

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
  public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState state) {
    ItemStack stack = super.getCloneItemStack(blockGetter, pos, state);
    LeavesBucketItem.setBucketVolume(stack, LeavesBucketItem.MAX_VOLUME);

    return stack;
  }

  @Override
  public @NotNull ItemStack pickupBlock(LevelAccessor level, BlockPos pos, BlockState state) {
    level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);

    if (!level.isClientSide()) {
      level.levelEvent(2001, pos, Block.getId(state));
    }

    ItemStack stack = this.bucketItem.getDefaultInstance();
    LeavesBucketItem.setBucketVolume(stack, LeavesBucketItem.MIN_VOLUME);

    return stack;
  }

  @NotNull
  @Override
  public Optional<SoundEvent> getPickupSound() {
    return Optional.empty();
  }
}
