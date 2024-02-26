package net.seface.moreblocks;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBCreativeTabs;
import net.seface.moreblocks.registry.MBItems;

@Mod(MoreBlocks.ID)
public class MoreBlocksForge {

    public MoreBlocksForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MoreBlocks.init();
        MBBlocks.register(eventBus);
        MBItems.register(eventBus);
        MBCreativeTabs.register(eventBus);

        eventBus.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.TILED_TINTED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.WHITE_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.GRAY_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.BLACK_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.BROWN_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.RED_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.ORANGE_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.YELLOW_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIME_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.GREEN_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.CYAN_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.BLUE_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.PURPLE_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.MAGENTA_STAINED_TILED_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.PINK_STAINED_TILED_GLASS.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(MBBlocks.IRON_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.DIAMOND_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(MBBlocks.NETHERITE_GRATE.get(), RenderType.cutout());
    }
}