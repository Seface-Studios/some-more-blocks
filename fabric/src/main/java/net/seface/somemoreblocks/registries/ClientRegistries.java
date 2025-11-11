package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.network.chat.Component;
import net.seface.somemoreblocks.Constants;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.SomeMoreBlocksFabric;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;

public class ClientRegistries {

  public static void init() {
    ClientRegistries.registerColorProviders();
    ClientRegistries.onFindPacks();
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
        : Constants.CLOVER_COLOR,
      SMBBlocks.CLOVER.get());
  }

  /**
   * Registers the built-in resource packs.
   */
  private static void onFindPacks() {
    if (SomeMoreBlocksFabric.CONTAINER.isEmpty()) return;

    ResourceManagerHelper.registerBuiltinResourcePack(
      SomeMoreBlocks.id("update_1_21"),
      SomeMoreBlocksFabric.CONTAINER.get(),
      Component.translatable("somemoreblocks.resourcepack.update_1_21.name"),
      ResourcePackActivationType.NORMAL
    );
  }
}
