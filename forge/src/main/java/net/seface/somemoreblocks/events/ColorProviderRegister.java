package net.seface.somemoreblocks.events;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.seface.somemoreblocks.SomeMoreBlocks;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorProviderRegister {

  /**
   * Registers values related to ColorProvider.
   */
  /*@SubscribeEvent
  public static void registerColorProviders(RegisterColorHandlersEvent.Block event) {
    event.register((blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), SMBBlocks.LEAF_LITTER.get());
  }*/
}
