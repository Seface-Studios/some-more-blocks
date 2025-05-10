package net.seface.somemoreblocks.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBRegistries;

@EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonSetupEvent {

  @SubscribeEvent
  public static void onCommonSetup(final FMLCommonSetupEvent event) {
    SomeMoreBlocks.LOGGER.info("onCommonSetup");
    event.enqueueWork(SMBRegistries::init);
  }
}
