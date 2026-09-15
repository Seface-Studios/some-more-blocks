package net.sefacestudios.somemoreblocks.events;

import net.minecraft.client.color.block.BlockTintSources;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;

import java.util.List;

public final class ColorProviderRegister {
  private ColorProviderRegister() {}

  public static void init() {
    RegisterColorHandlersEvent.Block.BUS.addListener(ColorProviderRegister::onRegisterColorProvider);
  }

  private static void onRegisterColorProvider(final RegisterColorHandlersEvent.Block event) {
    event.register(List.of(BlockTintSources.foliage()), SMBBlocks.LEAF_LITTER.get());
    event.register(List.of(BlockTintSources.grass()), SMBBlocks.CLOVER.get());
    event.register(List.of(BlockTintSources.grass()), SMBBlocks.SPROUTS.get());
    event.register(List.of(BlockTintSources.grass()), SMBBlocks.LAVENDER.get());
  }
}
