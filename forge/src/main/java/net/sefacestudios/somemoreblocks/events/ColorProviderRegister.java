package net.sefacestudios.somemoreblocks.events;

import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sefacestudios.somemoreblocks.Constants;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;

import java.util.List;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, value = Dist.CLIENT)
public class ColorProviderRegister {

  @SubscribeEvent
  public static void onRegisterColorProvider(final RegisterColorHandlersEvent.Block event) {
    event.register(List.of(BlockTintSources.foliage()), SMBBlocks.LEAF_LITTER.get());
    event.register(List.of(BlockTintSources.grass()), SMBBlocks.CLOVER.get());
    event.register(List.of(BlockTintSources.grass()), SMBBlocks.SPROUTS.get());
  }
}
