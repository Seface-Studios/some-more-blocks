package net.seface.somemoreblocks.utils;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.seface.somemoreblocks.SomeMoreBlocks;

public record ModelPredicate() {

  /**
   * Register a new Override predicate to be used on item model.
   * @param item The item that can use the predicate.
   */
  public static void register(Item item, String identifier) {
    ItemProperties.register(
      item, new ResourceLocation(SomeMoreBlocks.ID, identifier),
      (stack, level, living, id) -> stack.hasTag() && stack.getTag().contains(identifier)
        ? (float) stack.getTag().getInt(identifier) / 100.0F
        : 0.01F
    );
  }
}
