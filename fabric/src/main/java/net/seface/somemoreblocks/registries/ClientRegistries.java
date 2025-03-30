package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.item.properties.numeric.MoonPhaseProperty;

public class ClientRegistries {

  public static void init() {
    ClientRegistries.registerBlockRenders();
    ClientRegistries.registerColorProviders();
    ClientRegistries.registerItemModelProperties();
  }

  /**
   * Registers values related to BlockRender.
   */
  private static void registerBlockRenders() {
    RenderType cutout = RenderType.cutout();
    RenderType cutoutMipped = RenderType.cutoutMipped();
    RenderType translucent = RenderType.translucent();

    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.AZALEA_LEAF_LITTER.get(), cutoutMipped);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BIG_LILY_PAD.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BIRCH_LEAF_LITTER.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLACK_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLUE_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CATTAIL.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CYAN_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.DIAMOND_GRATE.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.DUNE_GRASS.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), cutoutMipped);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GRAY_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GREEN_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.IRON_GRATE.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LARGE_SNOW_FERN.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LEAF_LITTER.get(), cutoutMipped);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIME_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LUMINOUS_FLOWER.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.NETHERITE_GRATE.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PINK_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_SNOW_FERN.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_TINY_CACTUS.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_MUSHROOM_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SHORT_SNOW_GRASS.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SMALL_LILY_PADS.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SNOW_FERN.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SPRUCE_LEAF_LITTER.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_DUNE_GRASS.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_SNOW_GRASS.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_TINTED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TINY_CACTUS.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WARPED_FUNGUS_COLONY.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WHITE_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get(),translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get(),translucent);

    /* 1.21.4 */
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), cutout);
  }

  /**
   * Registers values related to ColorProvider.
   */
  private static void registerColorProviders() {
    ColorProviderRegistry.BLOCK.register(
      (blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), SMBBlocks.LEAF_LITTER.get());
  }

  /**
   * Registers values related to ItemModelProperty.
   */
  private static void registerItemModelProperties() {
    RangeSelectItemModelProperties.ID_MAPPER.put(
      BuiltInRegistries.DATA_COMPONENT_TYPE.getKey(SMBDataComponentTypes.BUCKET_VOLUME.get()),
      BucketVolumeProperty.MAP_CODEC);

    RangeSelectItemModelProperties.ID_MAPPER.put(
      BuiltInRegistries.DATA_COMPONENT_TYPE.getKey(SMBDataComponentTypes.MOON_PHASE.get()),
      MoonPhaseProperty.MAP_CODEC);
  }
}
