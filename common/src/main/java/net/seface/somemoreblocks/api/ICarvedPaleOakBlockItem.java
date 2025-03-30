package net.seface.somemoreblocks.api;

import net.minecraft.core.component.DataComponentType;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;

public interface ICarvedPaleOakBlockItem {

  /**
   * This only exists to mixin on Forge version.
   * We don't need to do anything on Fabric version.
   */
  default DataComponentType<Integer> getMoonPhaseComponentType() {
    return SMBDataComponentTypes.MOON_PHASE.get();
  }
}
