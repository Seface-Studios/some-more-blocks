package net.seface.somemoreblocks.api;

import net.minecraft.core.component.DataComponentType;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;

public interface ILeavesBucketItem {

  /**
   * This only exists to mixin on Forge version.
   * We don't need to do anything on Fabric version.
   */
  default DataComponentType<Integer> getBucketVolumeComponentType() {
    return SMBDataComponentTypes.BUCKET_VOLUME;
  }
}
