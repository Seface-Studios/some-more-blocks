package net.seface.somemoreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.registry.MBBlocks;
import net.seface.somemoreblocks.registry.MBItems;
import net.seface.somemoreblocks.utils.ModelPredicate;

public class MoreBlocksFabricClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    this.registerBlockRenders();
    this.registerColorProviders();
    this.registerModelPredicateProviders();
  }

  private void registerBlockRenders() {
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TILED_TINTED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.WHITE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.GRAY_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BLACK_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BROWN_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.RED_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.ORANGE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.YELLOW_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LIME_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.GREEN_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.CYAN_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BLUE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.PURPLE_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.MAGENTA_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.PINK_STAINED_TILED_GLASS, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.WHITE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.GRAY_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BLACK_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BROWN_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.RED_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.ORANGE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.YELLOW_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LIME_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.GREEN_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.CYAN_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BLUE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.PURPLE_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE, RenderType.translucent());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.PINK_STAINED_TILED_GLASS_PANE, RenderType.translucent());

    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.IRON_GRATE, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.DIAMOND_GRATE, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.NETHERITE_GRATE, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LUMINOUS_FLOWER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TINY_CACTUS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.DUNE_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_DUNE_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.SHORT_SNOW_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_SNOW_GRASS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.SNOW_FERN, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LARGE_SNOW_FERN, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.CATTAIL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.SMALL_LILY_PADS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.SPRUCE_LEAF_LITTER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BIRCH_LEAF_LITTER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.AZALEA_LEAF_LITTER, RenderType.cutoutMipped());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.FLOWERING_AZALEA_LEAF_LITTER, RenderType.cutoutMipped());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LEAF_LITTER, RenderType.cutoutMipped());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BIG_LILY_PAD, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_BROWN_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BROWN_MUSHROOM_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BROWN_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_RED_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.RED_MUSHROOM_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.RED_MUSHROOM_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_WARPED_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.WARPED_FUNGUS_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.WARPED_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_CRIMSON_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.CRIMSON_FUNGUS_COLONY_WALL, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.CRIMSON_FUNGUS_COLONY, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.POTTED_LUMINOUS_FLOWER, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.POTTED_TINY_CACTUS, RenderType.cutout());
    BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.POTTED_SNOW_FERN, RenderType.cutout());
  }

  private void registerColorProviders() {
    ColorProviderRegistry.BLOCK.register((blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), MBBlocks.LEAF_LITTER);
  }

  private void registerModelPredicateProviders() {
    ModelPredicate.register(MBItems.LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicate.register(MBItems.SPRUCE_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicate.register(MBItems.BIRCH_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicate.register(MBItems.AZALEA_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicate.register(MBItems.FLOWERING_AZALEA_LEAVES_BUCKET, LeavesBucketItem.BUCKET_VOLUME);
  }
}
