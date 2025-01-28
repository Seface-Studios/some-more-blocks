package net.seface.somemoreblocks.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.seface.somemoreblocks.SomeMoreBlocks;

public abstract class SMBAbstractData {
  public static <T> ResourceKey<T> createResourceKey(ResourceKey<Registry<T>> registryType, String identifier) {
    return ResourceKey.create(registryType, ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, identifier));
  }

  protected static <T> TagKey<T> createTagKey(ResourceKey<Registry<T>> registryType, String identifier) {
    return TagKey.create(registryType, ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, identifier));
  }
}
