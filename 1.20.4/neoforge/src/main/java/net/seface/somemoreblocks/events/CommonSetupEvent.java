package net.seface.somemoreblocks.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBRegistries;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetupEvent {

  @SubscribeEvent
  public static void onCommonSetup(final FMLCommonSetupEvent event) {
    SomeMoreBlocks.LOGGER.info("onCommonSetup");
    event.enqueueWork(SMBRegistries::init);
  }
}
