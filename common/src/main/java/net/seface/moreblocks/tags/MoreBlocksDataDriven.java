package net.seface.moreblocks.tags;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.seface.moreblocks.MoreBlocks;

public abstract class MoreBlocksDataDriven {
  protected static <T> TagKey<T> create(ResourceKey<Registry<T>> registryType, String identifier) {
    return TagKey.create(registryType, new ResourceLocation(MoreBlocks.ID, identifier));
  }
}
