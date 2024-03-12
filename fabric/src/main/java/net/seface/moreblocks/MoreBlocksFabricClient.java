package net.seface.moreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBItems;

public class MoreBlocksFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        this.registerBlockRenders();
        this.registerColorProviders();
        this.registerItemModelPredicates();
    }

    private void registerItemModelPredicates() {
        this.addItemModelPredicateWithFeatureFlag(MBItems.CRACKED_TUFF_BRICKS, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.CRACKED_TUFF_BRICKS, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.TUFF_PILLAR, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.TUFF_TILES, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.TUFF_TILES_SLAB, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.TUFF_TILES_STAIRS, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.TUFF_TILES_WALL, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.CRACKED_TUFF_TILES, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.MOSSY_TUFF_BRICKS, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.MOSSY_TUFF_BRICKS_SLAB, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.MOSSY_TUFF_BRICKS_STAIRS, "experimental_1_21", FeatureFlags.UPDATE_1_21)
            .addItemModelPredicateWithFeatureFlag(MBItems.MOSSY_TUFF_BRICKS_WALL, "experimental_1_21", FeatureFlags.UPDATE_1_21)

        ;
    }

    private MoreBlocksFabricClient addItemModelPredicateWithFeatureFlag(Item item, String predicateId, FeatureFlag feature) {
        FabricModelPredicateProviderRegistry.register(
                item,
                new ResourceLocation(MoreBlocks.ID, predicateId), (stack, level, entity, i) -> {
                    if (entity == null) return 0.0F;
                    return level.enabledFeatures().contains(feature) ? 1.0F : 0.0F;
                }
        );

        return this;
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
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.IRON_GRATE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.DIAMOND_GRATE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.NETHERITE_GRATE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LUMINOUS_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TINY_CACTUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.DUNE_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_DUNE_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.SNOW_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_SNOW_GRASS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.SNOW_FERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.TALL_SNOW_FERN, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.CATTAIL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.SMALL_LILY_PADS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.FROZEN_LEAF_LITTER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.LEAF_LITTER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.PINK_PETALS_LITTER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BIG_LILY_PAD, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BROWN_MUSHROOM_COLONY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.BROWN_MUSHROOM_COLONY_WALL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.RED_MUSHROOM_COLONY, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.RED_MUSHROOM_COLONY_WALL, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.POTTED_LUMINOUS_FLOWER, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.POTTED_TINY_CACTUS, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MBBlocks.POTTED_SNOW_FERN, RenderType.cutout());
    }

    private void registerColorProviders() {
        ColorProviderRegistry.BLOCK.register((blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), MBBlocks.LEAF_LITTER);
    }
}
