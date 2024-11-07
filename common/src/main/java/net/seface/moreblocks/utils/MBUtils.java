package net.seface.moreblocks.utils;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class MBUtils {

  public static void entryWithoutFeatureFlag(CreativeModeTab.ItemDisplayParameters context, CreativeModeTab.Output entry,
                                             FeatureFlag featureFlag, Item item) {
    if (!context.enabledFeatures().contains(featureFlag)) {
      entry.accept(item);
    }
  }
}
