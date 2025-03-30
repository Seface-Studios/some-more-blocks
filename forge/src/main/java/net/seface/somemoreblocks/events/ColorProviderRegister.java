package net.seface.somemoreblocks.events;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorProviderRegister {

  @SubscribeEvent
  public static void onRegisterColorProvider(final RegisterColorHandlersEvent.Block event) {
    event.register((blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), SMBBlocks.LEAF_LITTER.get());
  }
}
