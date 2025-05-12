package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.item.properties.numeric.MoonPhaseProperty;

public class ClientRegistries {

  public static void init() {
    ClientRegistries.registerColorProviders();
    ClientRegistries.registerItemModelProperties();
  }

  /**
   * Registers values related to ColorProvider.
   */
  private static void registerColorProviders() {
    ColorProviderRegistry.BLOCK.register(
      (blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), SMBBlocks.LEAF_LITTER.get());

    ColorProviderRegistry.BLOCK.register(
      (blockState, tint, pos, i) -> BiomeColors.getAverageGrassColor(tint, pos), SMBBlocks.CLOVER.get());
  }

  /**
   * Registers values related to ItemModelProperty.
   */
  private static void registerItemModelProperties() {
    RangeSelectItemModelProperties.ID_MAPPER.put(SMBDataComponentTypes.BUCKET_VOLUME.getId(), BucketVolumeProperty.MAP_CODEC);
    RangeSelectItemModelProperties.ID_MAPPER.put(SMBDataComponentTypes.MOON_PHASE.getId(), MoonPhaseProperty.MAP_CODEC);
  }
}
