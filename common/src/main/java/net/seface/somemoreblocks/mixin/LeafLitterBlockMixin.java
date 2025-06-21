package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;
import net.seface.somemoreblocks.registries.SMBGameRules;
import net.seface.somemoreblocks.registries.SMBItems;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Optional;

@Mixin(LeafLitterBlock.class)
public abstract class LeafLitterBlockMixin extends VegetationBlock implements SegmentableBlock, BucketPickup {

  protected LeafLitterBlockMixin(Properties properties) {
    super(properties);
  }

  @Override
  protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean bool) {
    return state.getBlock() == Blocks.LEAF_LITTER ?
      Items.LEAF_LITTER.getDefaultInstance() :
      super.getCloneItemStack(level, pos, state, bool);
  }

  @Override
  public ItemStack pickupBlock(@Nullable LivingEntity entity, LevelAccessor level, BlockPos pos, BlockState state) {
    ItemStack stack = SMBRegistries.LEAVES_BUCKET.getNext(this)
      .orElse(SMBItems.LEAVES_BUCKET.get())
      .getDefaultInstance();


    if (state.getValue(LeafLitterBlock.AMOUNT) > 1) {
      level.setBlock(pos, state.setValue(LeafLitterBlock.AMOUNT, state.getValue(LeafLitterBlock.AMOUNT) - 1), Block.UPDATE_ALL_IMMEDIATE);
    } else {
      level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
    }

    if (!level.isClientSide()) {
      level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(state));
    }

    stack.set(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MIN_VOLUME);
    return stack;
  }

  @Override
  protected boolean isRandomlyTicking(BlockState state) {
    return state.getBlock() != Blocks.LEAF_LITTER;
  }

  @Override
  protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    if (level.getGameRules().getBoolean(SMBGameRules.RULE_DRY_LEAF_LITTER)) {
      level.setBlock(pos, Blocks.LEAF_LITTER.withPropertiesOf(state), Block.UPDATE_ALL);
    }
  }

  @NotNull
  @Override
  public Optional<SoundEvent> getPickupSound() {
    return Optional.of(SoundType.LEAF_LITTER.getBreakSound());
  }
}
