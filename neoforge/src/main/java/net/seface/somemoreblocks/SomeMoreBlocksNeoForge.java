package net.seface.somemoreblocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.seface.somemoreblocks.platform.registry.NeoForgePlatformRegistry;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

@Mod(SomeMoreBlocks.ID)
public class SomeMoreBlocksNeoForge {

  public SomeMoreBlocksNeoForge(IEventBus bus) {
    SomeMoreBlocks.init(() -> NeoForgePlatformRegistry.init(bus), null);
    SMBBiomeModifiers.init(bus);
  }
}
