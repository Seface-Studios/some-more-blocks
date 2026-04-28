package net.seface.somemoreblocks.platform.registry;

import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

public interface PlatformRegistryObject<T> extends Supplier<T> {

  /**
   * Get the registered object identifier.
   * @return The registered object identifier.
   */
  Identifier getId();

  /**
   * Get the path from registered object identifier.
   * @return The path from registered object identifier.
   */
  default String getPath() {
    return this.getId().getPath();
  }
}
