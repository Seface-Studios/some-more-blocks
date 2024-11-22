package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.seface.moreblocks.core.SnowyVariationsManager;
import net.seface.moreblocks.registry.*;
import net.seface.moreblocks.utils.MBUtils;
import net.seface.moreblocks.registry.MBFeatures;
import net.seface.moreblocks.worldgen.MBBiomeModifiers;

public class MoreBlocksFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    MoreBlocks.init();
    MBItems.register();
    MBBlocks.register();
    MBItemGroups.register();
    MBFeatures.register();
    MBBiomeModifiers.register();

    registerSnowyVariations();
    registerCompostableItems();
    registerWeatheringCopperBlocks();
    registerWaxableCopperBlocks();
    registerFuels();
    registerSnowyBlocks();
  }

  private static void registerSnowyVariations() {
    SnowyVariationsManager.register(Blocks.SHORT_GRASS, MBBlocks.SHORT_SNOW_GRASS);
    SnowyVariationsManager.register(Blocks.FERN, MBBlocks.SNOW_FERN);
    SnowyVariationsManager.register(Blocks.TALL_GRASS, MBBlocks.TALL_SNOW_GRASS, true);
    SnowyVariationsManager.register(Blocks.LARGE_FERN, MBBlocks.LARGE_SNOW_FERN, true);
  }

  /** Register new compostable items into Composter block. */
  private static void registerCompostableItems() {
    MBUtils.registerCompostableItem(0.3F, MBItems.TINY_CACTUS);
    MBUtils.registerCompostableItem(0.3F, MBItems.DUNE_GRASS);
    MBUtils.registerCompostableItem(0.5F, MBItems.TALL_DUNE_GRASS);
    MBUtils.registerCompostableItem(0.5F, MBItems.TALL_DUNE_GRASS);
    MBUtils.registerCompostableItem(0.3F, MBItems.SHORT_SNOW_GRASS);
    MBUtils.registerCompostableItem(0.65F, MBItems.TALL_SNOW_GRASS);
    MBUtils.registerCompostableItem(0.65F, MBItems.SNOW_FERN);
    MBUtils.registerCompostableItem(0.65F, MBItems.LARGE_SNOW_FERN);
    MBUtils.registerCompostableItem(0.65F, MBItems.CATTAIL);
    MBUtils.registerCompostableItem(0.65F, MBItems.LUMINOUS_FLOWER);
    MBUtils.registerCompostableItem(0.85F, MBItems.BROWN_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_BROWN_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(0.85F, MBItems.RED_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_RED_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(0.85F, MBItems.CRIMSON_FUNGUS_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_CRIMSON_FUNGUS_COLONY);
    MBUtils.registerCompostableItem(0.85F, MBItems.WARPED_FUNGUS_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_WARPED_FUNGUS_COLONY);
  }

  private static void registerWeatheringCopperBlocks() {
    MBUtils.registerWeatheringCopperBlock(MBBlocks.COPPER_BRICKS, MBBlocks.EXPOSED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_COPPER_BRICKS, MBBlocks.WEATHERED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_COPPER_BRICKS, MBBlocks.OXIDIZED_COPPER_BRICKS);

    MBUtils.registerWeatheringCopperBlock(MBBlocks.CRACKED_COPPER_BRICKS, MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS, MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS, MBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS);

    MBUtils.registerWeatheringCopperBlock(MBBlocks.CRACKED_CUT_COPPER, MBBlocks.EXPOSED_CRACKED_CUT_COPPER);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_CRACKED_CUT_COPPER, MBBlocks.WEATHERED_CRACKED_CUT_COPPER);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_CRACKED_CUT_COPPER, MBBlocks.OXIDIZED_CRACKED_CUT_COPPER);

    MBUtils.registerWeatheringCopperBlock(MBBlocks.COPPER_PILLAR, MBBlocks.EXPOSED_COPPER_PILLAR);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_COPPER_PILLAR, MBBlocks.WEATHERED_COPPER_PILLAR);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_COPPER_PILLAR, MBBlocks.OXIDIZED_COPPER_PILLAR);
  }

  private static void registerWaxableCopperBlocks() {
    MBUtils.registerWaxableCopperBlock(MBBlocks.COPPER_BRICKS, MBBlocks.WAXED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_COPPER_BRICKS, MBBlocks.WAXED_EXPOSED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_COPPER_BRICKS, MBBlocks.WAXED_WEATHERED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_COPPER_BRICKS, MBBlocks.WAXED_OXIDIZED_COPPER_BRICKS);

    MBUtils.registerWaxableCopperBlock(MBBlocks.CRACKED_COPPER_BRICKS, MBBlocks.WAXED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS, MBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS, MBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS, MBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS);

    MBUtils.registerWaxableCopperBlock(MBBlocks.CRACKED_CUT_COPPER, MBBlocks.WAXED_CRACKED_CUT_COPPER);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_CRACKED_CUT_COPPER, MBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_CRACKED_CUT_COPPER, MBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_CRACKED_CUT_COPPER, MBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER);

    MBUtils.registerWaxableCopperBlock(MBBlocks.COPPER_PILLAR, MBBlocks.WAXED_COPPER_PILLAR);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_COPPER_PILLAR, MBBlocks.WAXED_EXPOSED_COPPER_PILLAR);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_COPPER_PILLAR, MBBlocks.WAXED_WEATHERED_COPPER_PILLAR);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_COPPER_PILLAR, MBBlocks.WAXED_OXIDIZED_COPPER_PILLAR);
  }

  private static void registerSnowyBlocks() {
    MBUtils.registerSnowVariationBlock(Blocks.SHORT_GRASS, MBBlocks.SHORT_SNOW_GRASS);
    MBUtils.registerSnowVariationBlock(Blocks.TALL_GRASS, MBBlocks.TALL_SNOW_GRASS);
    MBUtils.registerSnowVariationBlock(Blocks.FERN, MBBlocks.SNOW_FERN);
    MBUtils.registerSnowVariationBlock(Blocks.LARGE_FERN, MBBlocks.LARGE_SNOW_FERN);
  }

  private static void registerFuels() {
    FuelRegistry.INSTANCE.add(MBItems.COAL_BRICKS, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) * 2);
    FuelRegistry.INSTANCE.add(MBItems.CRACKED_COAL_BRICKS, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) + 3200);
    FuelRegistry.INSTANCE.add(MBItems.COAL_PILLAR, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK));
    FuelRegistry.INSTANCE.add(MBItems.CUT_COAL, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) * 3);
    FuelRegistry.INSTANCE.add(MBItems.CRACKED_CUT_COAL, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) + 3200);
  }
}
