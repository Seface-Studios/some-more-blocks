package net.sefacestudios.somemoreblocks.registries;

import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.sefacestudios.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.sefacestudios.somemoreblocks.item.properties.numeric.MoonPhaseProperty;

import java.util.List;

public class ClientRegistries {

  public static void init() {
    ClientRegistries.registerColorProviders();
    ClientRegistries.registerItemModelProperties();
  }

  /**
   * Registers values related to ColorProvider.
   */
  private static void registerColorProviders() {
    BlockColorRegistry.register(List.of(BlockTintSources.foliage()), SMBBlocks.LEAF_LITTER.get());
    BlockColorRegistry.register(List.of(BlockTintSources.grass()), SMBBlocks.CLOVER.get());
  }

  /**
   * Registers values related to ItemModelProperty.
   */
  private static void registerItemModelProperties() {
    RangeSelectItemModelProperties.ID_MAPPER.put(SMBDataComponentTypes.BUCKET_VOLUME.getId(), BucketVolumeProperty.MAP_CODEC);
    RangeSelectItemModelProperties.ID_MAPPER.put(SMBDataComponentTypes.MOON_PHASE.getId(), MoonPhaseProperty.MAP_CODEC);
  }
}
