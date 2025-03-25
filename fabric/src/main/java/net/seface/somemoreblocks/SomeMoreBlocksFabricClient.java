package net.seface.somemoreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.item.properties.numeric.MoonPhaseProperty;
import net.seface.somemoreblocks.registries.SMBBlocks;

public class SomeMoreBlocksFabricClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    registerBlockRenders();
    registerColorProviders();
    registerItemModelProperties();
  }

  /**
   * Registers values related to BlockRender.
   */
  private static void registerBlockRenders() {
    RenderType cutout = RenderType.cutout();
    RenderType cutoutMipped = RenderType.cutoutMipped();
    RenderType translucent = RenderType.translucent();

    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.AZALEA_LEAF_LITTER, cutoutMipped);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BIG_LILY_PAD, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BIRCH_LEAF_LITTER, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLACK_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLUE_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_MUSHROOM_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CATTAIL, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CRIMSON_FUNGUS_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CYAN_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.DIAMOND_GRATE, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.DUNE_GRASS, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER, cutoutMipped);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GRAY_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GREEN_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.IRON_GRATE, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LARGE_SNOW_FERN, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LEAF_LITTER, cutoutMipped);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIME_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LUMINOUS_FLOWER, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.MAGENTA_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.NETHERITE_GRATE, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.ORANGE_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PINK_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_LUMINOUS_FLOWER, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_SNOW_FERN, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_TINY_CACTUS, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PURPLE_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_MUSHROOM_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_MUSHROOM_COLONY_WALL, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SHORT_SNOW_GRASS, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SMALL_LILY_PADS, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SNOW_FERN, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SPRUCE_LEAF_LITTER, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_DUNE_GRASS, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_RED_MUSHROOM_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_SNOW_GRASS, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_WARPED_FUNGUS_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_TINTED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TINY_CACTUS, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WARPED_FUNGUS_COLONY, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WARPED_FUNGUS_COLONY_WALL, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WHITE_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.YELLOW_STAINED_TILED_GLASS, translucent);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE, translucent);

    /* 1.21.4 */
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PALE_OAK_LEAF_LITTER, cutout);

    /* 1.21.4-without-cactus-on-forest */
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CACTUS_LADDER, cutout);
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_CACTUS, cutout);
  }

  /**
   * Registers values related to ColorProvider.
   */
  private static void registerColorProviders() {
    ColorProviderRegistry.BLOCK.register(
      (blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), SMBBlocks.LEAF_LITTER);
  }

  /**
   * Registers values related to ItemModelProperty.
   */
  private static void registerItemModelProperties() {
    RangeSelectItemModelProperties.ID_MAPPER.put(
      BuiltInRegistries.DATA_COMPONENT_TYPE.getKey(SMBDataComponentTypes.BUCKET_VOLUME),
      BucketVolumeProperty.MAP_CODEC);

    RangeSelectItemModelProperties.ID_MAPPER.put(
      BuiltInRegistries.DATA_COMPONENT_TYPE.getKey(SMBDataComponentTypes.MOON_PHASE),
      MoonPhaseProperty.MAP_CODEC);
  }
}
