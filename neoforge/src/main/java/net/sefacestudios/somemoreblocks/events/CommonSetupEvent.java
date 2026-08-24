package net.sefacestudios.somemoreblocks.events;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;

@EventBusSubscriber(modid = SomeMoreBlocks.ID)
public class CommonSetupEvent {

  @SubscribeEvent
  public static void onCommonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(SMBRegistries::init);
  }
}
