package net.seface.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.PathType;
import net.seface.somemoreblocks.registries.*;
import net.seface.somemoreblocks.utils.SMBUtils;

import java.util.Optional;

public class SomeMoreBlocksFabric implements ModInitializer {
  private static final Optional<ModContainer> MOD_CONTAINER = FabricLoader.getInstance().getModContainer(SomeMoreBlocks.ID);

  @Override
  public void onInitialize() {
    SomeMoreBlocks.init();

    //SMBBlocks.init.get()();
    //SMBItems.init.get()();
    SMBCreativeTabs.init();
    SMBFeatures.init();
    //SMBBiomeModifiers.init();

    LandPathNodeTypesRegistry.register(SMBBlocks.TINY_CACTUS.get(), (state, neighbor) -> PathType.DAMAGE_OTHER);

    registerCarvedBlocks();
    registerCompostableItems();
    registerFuels();
    registerSnowyBlocks();
    registerWaxableCopperBlocks();
    registerWeatheringCopperBlocks();
  }

  /**
   * Registers values related to Compostable items.
   */
  private static void registerCompostableItems() {
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.TINY_CACTUS.get());
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.DUNE_GRASS.get());
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBBlocks.TALL_DUNE_GRASS.get());
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBBlocks.TALL_DUNE_GRASS.get());
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.SHORT_SNOW_GRASS.get());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.TALL_SNOW_GRASS.get());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.SNOW_FERN.get());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.LARGE_SNOW_FERN.get());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.CATTAIL.get());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.LUMINOUS_FLOWER.get());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.BROWN_MUSHROOM_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_BROWN_MUSHROOM_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.RED_MUSHROOM_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_RED_MUSHROOM_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.CRIMSON_FUNGUS_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_CRIMSON_FUNGUS_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.WARPED_FUNGUS_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_WARPED_FUNGUS_COLONY.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.AZALEA_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.BIRCH_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.SPRUCE_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.PALE_OAK_LEAVES_BUCKET.get());
  }

  /**
   * Registers values related to Weathering-like blocks.
   */
  private static void registerWeatheringCopperBlocks() {
    WeatheringCopperBlockRegistry.register(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
  }

  /**
   * Registers values related to Waxable-like blocks.
   */
  private static void registerWaxableCopperBlocks() {
    WaxableCopperBlockRegistry.register(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
  }

  /**
   * Registers values related to Snowy-like blocks.
   */
  private static void registerSnowyBlocks() {
    SnowyBushRegistry.register(Blocks.SHORT_GRASS, SMBBlocks.SHORT_SNOW_GRASS.get());
    SnowyBushRegistry.register(Blocks.TALL_GRASS, SMBBlocks.TALL_SNOW_GRASS.get());
    SnowyBushRegistry.register(Blocks.FERN, SMBBlocks.SNOW_FERN.get());
    SnowyBushRegistry.register(Blocks.LARGE_FERN, SMBBlocks.LARGE_SNOW_FERN.get());
  }

  /**
   * Registers values related to Carved-like blocks.
   */
  private static void registerCarvedBlocks() {
    /*
     * "SeNiOr" dev: Why don't you use "StrippableBlockRegistry" from Fabric here?!!
     *  - We want to encompass functionality between the two versions and avoid the specific modifications for them.
     *    This makes more sense on 1.21.4 for example where the "Carved Pale Oak" has special functionality.
     * */

    CarvedBlockRegistry.register(Blocks.STRIPPED_OAK_WOOD, SMBBlocks.CARVED_OAK_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_OAK_LOG, SMBBlocks.CARVED_OAK_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_WOOD, SMBBlocks.CARVED_DARK_OAK_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_LOG, SMBBlocks.CARVED_DARK_OAK_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_ACACIA_WOOD, SMBBlocks.CARVED_ACACIA_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_ACACIA_LOG, SMBBlocks.CARVED_ACACIA_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CHERRY_WOOD, SMBBlocks.CARVED_CHERRY_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CHERRY_LOG, SMBBlocks.CARVED_CHERRY_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_BIRCH_WOOD, SMBBlocks.CARVED_BIRCH_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_BIRCH_LOG, SMBBlocks.CARVED_BIRCH_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_JUNGLE_WOOD, SMBBlocks.CARVED_JUNGLE_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_JUNGLE_LOG, SMBBlocks.CARVED_JUNGLE_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_SPRUCE_WOOD, SMBBlocks.CARVED_SPRUCE_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_SPRUCE_LOG, SMBBlocks.CARVED_SPRUCE_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_WARPED_STEM, SMBBlocks.CARVED_WARPED_STEM.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_WARPED_HYPHAE, SMBBlocks.CARVED_WARPED_HYPHAE.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CRIMSON_STEM, SMBBlocks.CARVED_CRIMSON_STEM.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CRIMSON_HYPHAE, SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_MANGROVE_WOOD, SMBBlocks.CARVED_MANGROVE_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_MANGROVE_LOG, SMBBlocks.CARVED_MANGROVE_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_BAMBOO_BLOCK, SMBBlocks.CARVED_BAMBOO_BLOCK.get());

    /* 1.21.4 */
    CarvedBlockRegistry.register(Blocks.STRIPPED_PALE_OAK_LOG, SMBBlocks.CARVED_PALE_OAK_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_PALE_OAK_WOOD, SMBBlocks.CARVED_PALE_OAK_WOOD.get());
  }

  /**
   * Registers Fuel values.
   */
  private static void registerFuels() {
    FuelRegistryEvents.BUILD.register((builder, ctx) -> {
      builder.add(SMBBlocks.COAL_BRICKS.get(), Constants.COAL_BRICKS_FUEL);
      builder.add(SMBBlocks.CRACKED_COAL_BRICKS.get(), Constants.CRACKED_COAL_BRICKS_FUEL);
      builder.add(SMBBlocks.COAL_PILLAR.get(), Constants.COAL_PILLAR_FUEL);
      builder.add(SMBBlocks.CUT_COAL.get(), Constants.CUT_COAL_FUEL);
      builder.add(SMBBlocks.CRACKED_CUT_COAL.get(), Constants.CRACKED_CUT_COAL_FUEL);
    });
  }
}
