package net.seface.somemoreblocks.utils;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.seface.somemoreblocks.api.IBushBlock;

public class SMBUtils {

  public static void entryWithoutFeatureFlag(CreativeModeTab.ItemDisplayParameters context, CreativeModeTab.Output entry,
                                             FeatureFlag featureFlag, Item item) {
    if (!context.enabledFeatures().contains(featureFlag)) {
      entry.accept(item);
    }
  }

  public static void registerCompostableItem(float chance, ItemLike item) {
    ComposterBlock.COMPOSTABLES.put(item, chance);
  }

  public static void registerSnowVariationBlock(Block block, Block snowy) {
    IBushBlock.SNOW_VARIATIONS.put(block, snowy);
  }
}
