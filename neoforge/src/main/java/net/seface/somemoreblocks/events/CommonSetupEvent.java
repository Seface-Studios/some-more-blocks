package net.seface.somemoreblocks.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBRegistries;

@EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CommonSetupEvent {

  @SubscribeEvent
  public static void onClientSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(SMBRegistries::init);
  }
}
