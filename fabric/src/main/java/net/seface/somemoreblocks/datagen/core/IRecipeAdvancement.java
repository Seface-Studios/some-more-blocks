package net.seface.somemoreblocks.datagen.core;

import net.minecraft.world.level.ItemLike;

public interface IRecipeAdvancement<T> {

  /**
   * Link blocks that can unlock this Recipe Advancement.
   * @param items Items that will unlock this Crafting Table/Smelting Recipe.
   *              Multiple items will result in the output pattern [unlocked_item]_from_[required_item]
   * @return The instance of this Recipe Advancement.
   */
  T craftableFrom(ItemLike ...items);

  /**
   * Link blocks that can unlock this Recipe Advancement.
   * @param items Items that will unlock this Stonecutting Recipe.
   * @return The instance of this Recipe Advancement.
   */
  T cuttableFrom(ItemLike ...items);

  T setMainCraftableItem(ItemLike item);
  void build();
}
