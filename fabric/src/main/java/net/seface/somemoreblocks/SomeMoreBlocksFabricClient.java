package net.seface.somemoreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.registries.ModelPredicateRegistry;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBItems;

public class SomeMoreBlocksFabricClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    registerBlockRenders();
    registerColorProviders();
    registerModelPredicateProviders();
  }

  /**
   * Registers values related to BlockRender.
   */
  private static void registerBlockRenders() {
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.AZALEA_LEAF_LITTER, RenderType.cutoutMipped());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BIG_LILY_PAD, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BIRCH_LEAF_LITTER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLACK_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLUE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CATTAIL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CRIMSON_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CYAN_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.DIAMOND_GRATE, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.DUNE_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER, RenderType.cutoutMipped());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GRAY_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GREEN_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.IRON_GRATE, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LARGE_SNOW_FERN, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LEAF_LITTER, RenderType.cutoutMipped());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIME_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.LUMINOUS_FLOWER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.MAGENTA_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.NETHERITE_GRATE, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.ORANGE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PINK_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_LUMINOUS_FLOWER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_SNOW_FERN, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.POTTED_TINY_CACTUS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PURPLE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_MUSHROOM_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.RED_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SHORT_SNOW_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SMALL_LILY_PADS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SNOW_FERN, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.SPRUCE_LEAF_LITTER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_DUNE_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_RED_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_SNOW_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TALL_WARPED_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TILED_TINTED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.TINY_CACTUS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WARPED_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WARPED_FUNGUS_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WHITE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.YELLOW_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE, RenderType.translucent());
  }

  /**
   * Registers values related to ColorProvider.
   */
  private static void registerColorProviders() {
    ColorProviderRegistry.BLOCK.register(
      (blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), SMBBlocks.LEAF_LITTER);
  }

  /**
   * Registers values related to ModelPredicate.
   */
  private static void registerModelPredicateProviders() {
    ModelPredicateRegistry.register(SMBItems.LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.SPRUCE_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.BIRCH_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.AZALEA_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
  }
}
