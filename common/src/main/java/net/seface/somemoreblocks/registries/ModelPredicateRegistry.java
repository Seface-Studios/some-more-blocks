package net.seface.somemoreblocks.registries;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.api.ILeavesBucketItem;

public record ModelPredicateRegistry() {

  /**
   * Register a new Override predicate to be used on item model.
   * @param item The item that can use the predicate.
   */
  public static void registerBucketVolumePredicate(Item item, String identifier) {
    ItemProperties.register(
      item, ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, identifier),
      (stack, world, entity, seed) ->  stack.getItem() instanceof ILeavesBucketItem
        ? (float) stack.get(((ILeavesBucketItem) stack.getItem()).getBucketVolumeComponentType()) / 100.0F
        : 0.01F
    );
  }
}
