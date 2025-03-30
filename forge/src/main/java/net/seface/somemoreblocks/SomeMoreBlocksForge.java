package net.seface.somemoreblocks;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.somemoreblocks.platform.registry.ForgePlatformRegistry;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

@SuppressWarnings({"removal", "deprecation"})
@Mod(SomeMoreBlocks.ID)
public class SomeMoreBlocksForge {
  public SomeMoreBlocksForge() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    SomeMoreBlocks.init(() -> ForgePlatformRegistry.init(bus), null);
    SMBBiomeModifiers.init(bus);
  }
}
