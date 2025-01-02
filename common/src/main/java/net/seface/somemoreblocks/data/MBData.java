package net.seface.somemoreblocks.data;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.seface.somemoreblocks.MoreBlocks;

public abstract class MBData {
  protected static <T> ResourceKey<T> createResourceKey(ResourceKey<Registry<T>> registryType, String identifier) {
    return ResourceKey.create(registryType, new ResourceLocation(MoreBlocks.ID, identifier));
  }

  protected static <T> TagKey<T> createTagKey(ResourceKey<Registry<T>> registryType, String identifier) {
    return TagKey.create(registryType, new ResourceLocation(MoreBlocks.ID, identifier));
  }
}
