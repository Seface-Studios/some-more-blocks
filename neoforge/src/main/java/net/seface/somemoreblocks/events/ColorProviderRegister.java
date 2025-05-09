package net.seface.somemoreblocks.events;

import net.minecraft.client.renderer.BiomeColors;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;

@EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorProviderRegister {

  @SubscribeEvent
  public static void onRegisterColorProvider(final RegisterColorHandlersEvent.Block event) {
    event.register((blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), SMBBlocks.LEAF_LITTER.get());
  }
}
