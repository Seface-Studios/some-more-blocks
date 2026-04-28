package net.seface.somemoreblocks;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.seface.somemoreblocks.platform.registry.NeoForgePlatformRegistry;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

@Mod(SomeMoreBlocks.ID)
public class SomeMoreBlocksNeoForge {
  public static IEventBus EVENT_BUS;

  public SomeMoreBlocksNeoForge(IEventBus bus) {
    EVENT_BUS = bus;

    SomeMoreBlocks.init();
    SMBBiomeModifiers.init(EVENT_BUS);
    NeoForgePlatformRegistry.init(EVENT_BUS);
  }
}
