package net.seface.somemoreblocks.mixin;

import net.minecraft.core.component.DataComponentType;
import net.seface.somemoreblocks.api.ILeavesBucketItem;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.registries.SMBForgedDataComponentTypes;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LeavesBucketItem.class)
public abstract class LeavesBucketItemMixin implements ILeavesBucketItem {

  @Override
  public DataComponentType<Integer> getBucketVolumeComponentType() {
    return SMBForgedDataComponentTypes.BUCKET_VOLUME.get();
  }
}
