package net.seface.somemoreblocks.platform.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public interface PlatformRegistryObject<T> extends Supplier<T> {

  /**
   * Get the registered object identifier.
   * @return The registered object identifier.
   */
  ResourceLocation getId();

  default String getPath() {
    return this.getId().getPath();
  }
}
