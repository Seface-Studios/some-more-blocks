package net.seface.somemoreblocks.platform.registry;

import lombok.Getter;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class MultiLoaderRegistryObject<T> implements PlatformRegistryObject<T> {

  @Getter
  private final ResourceLocation id;
  private final Supplier<T> supplier;

  public MultiLoaderRegistryObject(ResourceLocation identifier, Supplier<T> supplier) {
    this.id = identifier;
    this.supplier = supplier;
  }

  @Override
  public T get() {
    return this.supplier.get();
  }
}
