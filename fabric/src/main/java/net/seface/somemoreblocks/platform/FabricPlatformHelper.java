package net.seface.somemoreblocks.platform;

import net.fabricmc.loader.api.FabricLoader;
import net.seface.somemoreblocks.SomeMoreBlocks;

public class FabricPlatformHelper implements PlatformHelper {
  private static FabricLoader LOADER = FabricLoader.getInstance();

  @Override
  public String getPlatformName() {
    return "Fabric";
  }

  @Override
  public boolean isModLoaded(String id) {
    return LOADER.isModLoaded(SomeMoreBlocks.ID);
  }

  @Override
  public PlatformEnvironment getEnviroment() {
    return LOADER.isDevelopmentEnvironment() ? PlatformEnvironment.DEVELOPMENT : PlatformEnvironment.PRODUCTION;
  }
}
