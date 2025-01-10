package net.seface.somemoreblocks.utils;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.seface.somemoreblocks.SomeMoreBlocks;

public record ModelPredicate() {

  /**
   * Register a new Override predicate to be used on item model.
   * @param item The item that can use the predicate.
   */
  public static void register(Item item, String identifier) {
    FabricModelPredicateProviderRegistry.register(
      item, new ResourceLocation(SomeMoreBlocks.ID, identifier),
      (stack, world, entity, seed) -> stack.hasTag() && stack.getTag().contains(identifier)
        ? (float) stack.getTag().getInt(identifier) / 100.0F
        : 0.01F
    );
  }
}
