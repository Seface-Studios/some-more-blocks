package net.seface.somemoreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.item.properties.numeric.MoonPhaseProperty;
import net.seface.somemoreblocks.registries.ClientRegistries;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;

public class SomeMoreBlocksFabricClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    ClientRegistries.init();
  }
}
