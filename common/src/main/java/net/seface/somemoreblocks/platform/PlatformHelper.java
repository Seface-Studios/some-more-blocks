package net.seface.somemoreblocks.platform;

public interface PlatformHelper {
  String getPlatformName();
  boolean isModLoaded(String id);
  PlatformEnvironment getEnvironment();
  PlatformRegistry getRegistry();
}
