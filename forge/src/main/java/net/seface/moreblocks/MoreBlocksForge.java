package net.seface.moreblocks;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBItems;

@Mod(MoreBlocks.ID)
public class MoreBlocksForge {

    public MoreBlocksForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MoreBlocks.init();
        MBBlocks.register(eventBus);
        MBItems.register(eventBus);

        eventBus.addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        //ItemBlockRenderTypes.setRenderLayer(MBBlocks.IRON_GRATE.get(), RenderType.translucent());
    }
}