package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.seface.somemoreblocks.Constants;

public class ClientRegistries {

  public static void init() {
    ClientRegistries.registerColorProviders();
  }

  /**
   * Registers values related to ColorProvider.
   */
  private static void registerColorProviders() {
    ColorProviderRegistry.BLOCK.register(
      (blockState, tint, pos, i) -> tint != null && pos != null
        ? BiomeColors.getAverageFoliageColor(tint, pos)
        : Constants.LEAF_LITTER_COLOR,
      SMBBlocks.LEAF_LITTER.get());

    ColorProviderRegistry.BLOCK.register(
      (blockState, tint, pos, i) -> tint != null && pos != null
        ? BiomeColors.getAverageGrassColor(tint, pos)
        : Constants.CLOVER_COLOR, SMBBlocks.CLOVER.get()
    );
  }
}
