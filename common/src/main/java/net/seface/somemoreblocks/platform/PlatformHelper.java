package net.seface.somemoreblocks.platform;

import net.seface.somemoreblocks.platform.registry.PlatformRegistry;

public interface PlatformHelper {
  /**
   * Get the loaded Platform name.
   * @return The Platform name.
   */
  String getPlatformName();

  /**
   * If the mod is loaded for the loaded Platform.
   * @param id The mod id.
   * @return True if the mod is loaded.
   */
  boolean isModLoaded(String id);

  /**
   * Get the current environment for the loaded Platform.
   * @return The loaded Platform environment.
   */
  PlatformEnvironment getEnvironment();

  /**
   * Get the main registries for the loaded Platform.
   * @return The loaded Platform registries.
   */
  PlatformRegistry getRegistry();

  /**
   * Get the Game and Mod version in the format: GameVersion-ModVersion
   */
  String getVersion();
}
