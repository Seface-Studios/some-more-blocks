package net.seface.somemoreblocks;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.somemoreblocks.platform.registry.ForgePlatformRegistry;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

@Mod(SomeMoreBlocks.ID)
public class SomeMoreBlocksForge {
  public static IEventBus EVENT_BUS;

  public SomeMoreBlocksForge() {
    EVENT_BUS = FMLJavaModLoadingContext.get().getModEventBus();

    SomeMoreBlocks.init(() -> ForgePlatformRegistry.init(EVENT_BUS), null);
    SMBBiomeModifiers.init(EVENT_BUS);
  }
}
