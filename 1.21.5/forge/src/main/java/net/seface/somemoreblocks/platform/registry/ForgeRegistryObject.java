package net.seface.somemoreblocks.platform.registry;

import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.registries.RegistryObject;

public class ForgeRegistryObject<T> implements PlatformRegistryObject<T> {

  @Getter
  private final ResourceLocation id;
  private final RegistryObject<T> registryObject;

  public ForgeRegistryObject(ResourceLocation identifier, RegistryObject<T> registryObject) {
    this.id = identifier;
    this.registryObject = registryObject;
  }

  @Override
  public T get() {
    return this.registryObject.get();
  }
}
