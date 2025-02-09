package net.seface.somemoreblocks.utils;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class SMBUtils {

  /**
   * Insert the item into specific Creative Tab only if a specific Feature is disabled.
   *
   * @param context The Creative Tab context.
   * @param entry The Creative Tab entries.
   * @param featureFlag The NOT wanted Feature Flag.
   * @param item The item instance.
   */
  public static void entryWithoutFeatureFlag(CreativeModeTab.ItemDisplayParameters context, CreativeModeTab.Output entry,
                                             FeatureFlag featureFlag, Item item) {
    if (!context.enabledFeatures().contains(featureFlag)) {
      entry.accept(item);
    }
  }

  public static class GenericRegistry {

    /**
     * Registry an Item to be compostable on {@link ComposterBlock}.
     *
     * @param chance The chance between 0-1 of being compostable
     * @param item The item instance.
     */
    public static void compostableItem(float chance, ItemLike item) {
      ComposterBlock.COMPOSTABLES.put(item, chance);
    }
  }
}
