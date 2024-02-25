package net.seface.moreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.seface.moreblocks.registry.MBBlocks;

public class MoreBlocksFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
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
    }
}
