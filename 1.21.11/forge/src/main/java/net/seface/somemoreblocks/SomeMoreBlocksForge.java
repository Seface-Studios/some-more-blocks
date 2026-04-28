package net.seface.somemoreblocks;

import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.somemoreblocks.platform.registry.ForgePlatformRegistry;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

@SuppressWarnings({"removal", "deprecation"})
@Mod(SomeMoreBlocks.ID)
public class SomeMoreBlocksForge {
  public static BusGroup EVENT_BUS;

  public SomeMoreBlocksForge(FMLJavaModLoadingContext context) {
    EVENT_BUS = context.getModBusGroup();

    SomeMoreBlocks.init(() -> ForgePlatformRegistry.init(EVENT_BUS), null);
    SMBBiomeModifiers.init(EVENT_BUS);
  }
}
