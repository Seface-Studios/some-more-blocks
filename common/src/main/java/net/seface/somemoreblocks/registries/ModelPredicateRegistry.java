package net.seface.somemoreblocks.registries;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.item.LeavesBucketItem;

public record ModelPredicateRegistry() {

  /**
   * Register a new Override predicate to be used on item model.
   * @param item The item that can use the predicate.
   */
  public static void register(Item item, String identifier) {
    ItemProperties.register(
      item, ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, identifier),
      (stack, world, entity, seed) -> stack.has(SMBDataComponentTypes.BUCKET_VOLUME)
        ? (float) stack.get(SMBDataComponentTypes.BUCKET_VOLUME) / 100.0F
        : 0.01F
    );
  }
}
