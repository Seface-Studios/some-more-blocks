package net.seface.somemoreblocks.platform;

import net.seface.somemoreblocks.platform.registry.PlatformRegistry;

public interface PlatformHelper {
  String getPlatformName();
  boolean isModLoaded(String id);
  PlatformEnvironment getEnvironment();
  PlatformRegistry getRegistry();
  String getVersion();
}
