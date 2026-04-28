package net.seface.somemoreblocks.platform;

import net.fabricmc.loader.api.FabricLoader;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.FabricPlatformRegistry;
import net.seface.somemoreblocks.platform.registry.PlatformRegistry;

public class FabricPlatformHelper implements PlatformHelper {
  private static final FabricLoader LOADER = FabricLoader.getInstance();

  @Override
  public String getPlatformName() {
    return PlatformServices.Platforms.FABRIC.getName();
  }

  @Override
  public boolean isModLoaded(String id) {
    return LOADER.isModLoaded(SomeMoreBlocks.ID);
  }

  @Override
  public PlatformEnvironment getEnvironment() {
    return LOADER.isDevelopmentEnvironment() ? PlatformEnvironment.DEVELOPMENT : PlatformEnvironment.PRODUCTION;
  }

  @Override
  public PlatformRegistry getRegistry() {
    return new FabricPlatformRegistry();
  }

  @Override
  public String getVersion() {
    String minecraft = LOADER.getModContainer("minecraft")
      .orElseThrow(() -> new RuntimeException("Minecraft container was not found."))
      .getMetadata().getVersion().getFriendlyString();

    String mod = LOADER.getModContainer(SomeMoreBlocks.ID)
      .orElseThrow(() -> new RuntimeException(SomeMoreBlocks.ID + " container cannot be found."))
      .getMetadata().getVersion().getFriendlyString();

    return minecraft + "-" + mod;
  }
}
