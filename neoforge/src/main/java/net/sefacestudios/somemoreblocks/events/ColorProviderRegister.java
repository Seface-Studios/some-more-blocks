package net.sefacestudios.somemoreblocks.events;

import net.minecraft.client.color.block.BlockTintSources;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;

import java.util.List;

@EventBusSubscriber(modid = SomeMoreBlocks.ID, value = Dist.CLIENT)
public class ColorProviderRegister {

  @SubscribeEvent
  public static void onRegisterColorProvider(final RegisterColorHandlersEvent.BlockTintSources event) {
    event.register(List.of(BlockTintSources.foliage()), SMBBlocks.LEAF_LITTER.get());
    event.register(List.of(BlockTintSources.grass()), SMBBlocks.CLOVER.get());
    event.register(List.of(BlockTintSources.grass()), SMBBlocks.SPROUTS.get());
  }
}
