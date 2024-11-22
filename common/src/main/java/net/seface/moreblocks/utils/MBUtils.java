package net.seface.moreblocks.utils;

import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.seface.moreblocks.api.IBushBlock;

public class MBUtils {

  public static void entryWithoutFeatureFlag(CreativeModeTab.ItemDisplayParameters context, CreativeModeTab.Output entry,
                                             FeatureFlag featureFlag, Item item) {
    if (!context.enabledFeatures().contains(featureFlag)) {
      entry.accept(item);
    }
  }

  public static void registerCompostableItem(float chance, ItemLike item) {
    ComposterBlock.COMPOSTABLES.put(item, chance);
  }

  public static void registerWeatheringCopperBlock(Block block, Block nextBlock) {
    WeatheringCopper.NEXT_BY_BLOCK.get().put(block, nextBlock);
  }

  public static void registerWaxableCopperBlock(Block block, Block waxedBlock) {
    HoneycombItem.WAXABLES.get().put(block, waxedBlock);
  }

  public static void registerSnowVariationBlock(Block block, Block snowy) {
    IBushBlock.SNOW_VARIATIONS.put(block, snowy);
  }
}
