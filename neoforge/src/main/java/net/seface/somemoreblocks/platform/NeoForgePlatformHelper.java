package net.seface.somemoreblocks.platform;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.NeoForgePlatformRegistry;
import net.seface.somemoreblocks.platform.registry.PlatformRegistry;

public class NeoForgePlatformHelper implements PlatformHelper {

  @Override
  public String getPlatformName() {
    return PlatformServices.Platforms.NEOFORGE.getName();
  }

  @Override
  public boolean isModLoaded(String id) {
    return ModList.get().isLoaded(SomeMoreBlocks.ID);
  }

  @Override
  public PlatformEnvironment getEnvironment() {
    return !FMLLoader.isProduction() ? PlatformEnvironment.DEVELOPMENT : PlatformEnvironment.PRODUCTION;
  }

  @Override
  public PlatformRegistry getRegistry() {
    return new NeoForgePlatformRegistry();
  }

  @Override
  public String getVersion() {
    String minecraft = FMLLoader.versionInfo().mcVersion();
    String mod = ModList.get().getModContainerById(SomeMoreBlocks.ID)
      .orElseThrow(() -> new RuntimeException("Mod cannot be found."))
      .getModInfo()
      .getVersion().toString();

    return minecraft + "-" + mod;
  }
}
