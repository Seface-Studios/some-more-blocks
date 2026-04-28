package net.seface.somemoreblocks.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBRegistries;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CommonSetupEvent {

  @SubscribeEvent
  public static void onCommonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(SMBRegistries::init);
  }
}
