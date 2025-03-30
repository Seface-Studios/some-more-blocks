package net.seface.somemoreblocks.events;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.*;
import net.seface.somemoreblocks.utils.SMBUtils;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CommonSetupEvent {

  @SubscribeEvent
  public static void onCommonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      CommonSetupEvent.registerCarvedBlocks();
      CommonSetupEvent.registerCompostableItems();
      CommonSetupEvent.registerSnowyBlocks();
      CommonSetupEvent.registerWaxableCopperBlocks();
      CommonSetupEvent.registerWeatheringCopperBlocks();
    });
  }

  /**
   * Registry compostable items.
   */
  private static void registerCompostableItems() {
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.TINY_CACTUS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.DUNE_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBBlocks.TALL_DUNE_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBBlocks.TALL_DUNE_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.SHORT_SNOW_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.TALL_SNOW_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.SNOW_FERN.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.LARGE_SNOW_FERN.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.CATTAIL.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.LUMINOUS_FLOWER.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.BROWN_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.RED_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_RED_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.CRIMSON_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.WARPED_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.AZALEA_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.BIRCH_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.SPRUCE_LEAVES_BUCKET.get());

    /* 1.21.4 */
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.PALE_OAK_LEAVES_BUCKET.get());
  }

  /**
   * Registry weathering copper blocks.
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
    SnowyBushRegistry.register(Blocks.FERN, SMBBlocks.SNOW_FERN.get());
    SnowyBushRegistry.register(Blocks.TALL_GRASS, SMBBlocks.TALL_SNOW_GRASS.get());
    SnowyBushRegistry.register(Blocks.LARGE_FERN, SMBBlocks.LARGE_SNOW_FERN.get());
  }

  /**
   * Registers values related to Carved-like blocks.
   */
  private static void registerCarvedBlocks() {
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
}
