package net.sefacestudios.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.sefacestudios.somemoreblocks.item.LeavesBucketItem;
import net.sefacestudios.somemoreblocks.registries.SMBDataComponentTypes;
import net.sefacestudios.somemoreblocks.registries.SMBItems;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Optional;

@Mixin(LeafLitterBlock.class)
@Implements(@Interface(iface = BucketPickup.class, prefix = "smb$bucket$"))
public abstract class LeafLitterPickupMixin {

  public ItemStack smb$bucket$pickupBlock(@Nullable LivingEntity entity, LevelAccessor level, BlockPos pos, BlockState state) {
    Block block = (Block) (Object) this;
    ItemStack stack = SMBRegistries.LEAVES_BUCKET.getNext(block)
      .orElse(SMBItems.LEAVES_BUCKET.get())
      .getDefaultInstance();

    if (state.getValue(SegmentableBlock.AMOUNT) > 1) {
      level.setBlock(pos, state.setValue(SegmentableBlock.AMOUNT, state.getValue(SegmentableBlock.AMOUNT) - 1), Block.UPDATE_ALL_IMMEDIATE);
    } else {
      level.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL_IMMEDIATE);
    }

    if (!level.isClientSide()) {
      level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(state));
    }

    stack.set(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MIN_VOLUME);
    return stack;
  }

  public Optional<SoundEvent> smb$bucket$getPickupSound() {
    return Optional.of(SoundType.LEAF_LITTER.getBreakSound());
  }
}
