package net.seface.somemoreblocks.events;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.seface.somemoreblocks.Constants;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorProviderRegister {

  @SubscribeEvent
  public static void onRegisterColorProvider(final RegisterColorHandlersEvent.Block event) {
    event.register((state, tint, pos, i) -> tint != null && pos != null
      ? BiomeColors.getAverageFoliageColor(tint, pos)
      : Constants.LEAF_LITTER_COLOR,
      SMBBlocks.LEAF_LITTER.get());

    event.register((state, tint, pos, i) -> tint != null && pos != null
      ? BiomeColors.getAverageGrassColor(tint, pos)
      : Constants.CLOVER_COLOR,
      SMBBlocks.CLOVER.get());
  }
}
