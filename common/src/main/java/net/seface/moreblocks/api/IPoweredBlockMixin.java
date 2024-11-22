package net.seface.moreblocks.api;

import net.minecraft.world.level.block.Block;

public interface IPoweredBlockMixin {

  /**
   * Updates the Redstone power signal level. Default is 15.
   * @param value The Redstone power signal (in blocks).
   * @return The instance of PoweredBlock.
   */
  Block MB$setSignalLevel(int value);
}
