package net.seface.somemoreblocks.platform.registry;

import lombok.Getter;
import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

public class FabricRegistryObject<T> implements PlatformRegistryObject<T> {

  @Getter
  private final Identifier id;
  private final Supplier<T> supplier;

  public FabricRegistryObject(Identifier identifier, Supplier<T> supplier) {
    this.id = identifier;
    this.supplier = supplier;
  }

  @Override
  public T get() {
    return this.supplier.get();
  }
}
