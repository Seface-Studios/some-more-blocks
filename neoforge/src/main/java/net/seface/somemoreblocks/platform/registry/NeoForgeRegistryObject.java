package net.seface.somemoreblocks.platform.registry;

import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public class NeoForgeRegistryObject<R, T extends R> implements PlatformRegistryObject<T> {

  @Getter
  private final ResourceLocation id;
  private final Supplier<T> registryObject;

  public NeoForgeRegistryObject(ResourceLocation identifier, Supplier<T> registryObject) {
    this.id = identifier;
    this.registryObject = registryObject;
  }

  @Override
  public T get() {
    return this.registryObject.get();
  }
}
