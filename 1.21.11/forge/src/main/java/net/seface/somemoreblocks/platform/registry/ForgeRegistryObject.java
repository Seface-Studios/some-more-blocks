package net.seface.somemoreblocks.platform.registry;

import lombok.Getter;
import net.minecraft.resources.Identifier;
import net.minecraftforge.registries.RegistryObject;

public class ForgeRegistryObject<T> implements PlatformRegistryObject<T> {

  @Getter
  private final Identifier id;
  private final RegistryObject<T> registryObject;

  public ForgeRegistryObject(Identifier identifier, RegistryObject<T> registryObject) {
    this.id = identifier;
    this.registryObject = registryObject;
  }

  @Override
  public T get() {
    return this.registryObject.get();
  }
}
