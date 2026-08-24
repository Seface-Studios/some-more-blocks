package net.sefacestudios.somemoreblocks.platform;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import net.sefacestudios.somemoreblocks.platform.registry.ForgePlatformRegistry;
import net.sefacestudios.somemoreblocks.platform.registry.PlatformRegistry;

public class ForgePlatformHelper implements PlatformHelper {

  @Override
  public String getPlatformName() {
    return PlatformServices.Platforms.FORGE.getName();
  }

  @Override
  public boolean isModLoaded(String id) {
    return ModList.getLoadedMods()
      .contains(
        ModList.getModContainerById(SomeMoreBlocks.ID)
        .orElseThrow(() -> new RuntimeException("Mod cannot be found."))
      );
  }

  @Override
  public PlatformEnvironment getEnvironment() {
    return !FMLLoader.isProduction() ? PlatformEnvironment.DEVELOPMENT : PlatformEnvironment.PRODUCTION;
  }

  @Override
  public PlatformRegistry getRegistry() {
    return new ForgePlatformRegistry();
  }

  @Override
  public String getVersion() {
    String minecraft = FMLLoader.versionInfo().mcVersion();
    String mod = ModList.getModContainerById(SomeMoreBlocks.ID)
      .orElseThrow(() -> new RuntimeException("Mod cannot be found."))
      .getModInfo()
      .getVersion().toString();

    return minecraft + "-" + mod;
  }
}
