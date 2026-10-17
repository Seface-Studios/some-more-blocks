package net.sefacestudios.somemoreblocks.registries;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.WeatheringCopperCollection;
import net.sefacestudios.somemoreblocks.Constants;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import net.sefacestudios.somemoreblocks.platform.PlatformEnvironment;
import net.sefacestudios.somemoreblocks.platform.PlatformServices;
import net.sefacestudios.somemoreblocks.platform.registry.BidirectionalRegistryObject;
import org.jetbrains.annotations.Nullable;

public class SMBRegistries {
  public static BidirectionalRegistryObject<Block, Block> CARVED_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("carved_blocks"));
  public static BidirectionalRegistryObject<Block, Block> SNOWY_PLANT_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("snowy_plant_blocks"));
  public static BidirectionalRegistryObject<Block, Block> WAXED_COPPER_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("waxed_copper_blocks"));
  public static BidirectionalRegistryObject<Block, Block> WEATHERING_COPPER_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("weathering_copper_blocks"));
  /*public static BidirectionalRegistryObject<@Nullable DyeColor, Block> STAINED_TILED_GLASS_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("tiled_glass_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> STAINED_TILED_GLASS_PANE_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("stained_tiled_glass_pane_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> SHINGLES_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("shingles_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> TERRACOTTA_BRICKS_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("terracotta_bricks_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> TERRACOTTA_TILES_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("terracotta_tiles_blocks"));
  public static BidirectionalRegistryObject<DyeColor, Block> CONCRETE_BRICKS_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("concrete_bricks_blocks"));
  public static BidirectionalRegistryObject<DyeColor, Block> CONCRETE_TILES_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("concrete_tiles_blocks"));
  public static BidirectionalRegistryObject<DyeColor, Block> CHECKERED_TILES = BidirectionalRegistryObject.create(SomeMoreBlocks.id("concrete_tiles_blocks"));*/
  public static BidirectionalRegistryObject<Block, Item> LEAVES_BUCKET = BidirectionalRegistryObject.create(SomeMoreBlocks.id("leaves_bucket"));

  /**
   * This initialization need to be called directly on Mod Loader initialize class!
   */
  public static void init() {
    SMBRegistries.carvedBlocks();
    /*SMBRegistries.checkeredTiles();*/
    SMBRegistries.compostableItems();
    /*SMBRegistries.concreteBlocks();*/
    SMBRegistries.leavesBucket();
    /*SMBRegistries.shinglesBlocks();*/
    SMBRegistries.snowyPlantBlocks();/*
    SMBRegistries.stainedTiledGlassBlocks();
    SMBRegistries.stainedTiledGlassPaneBlocks();
    SMBRegistries.terracottaBlocks();*/
    SMBRegistries.waxedCopperBlocks();
    SMBRegistries.weatheringCopperBlocks();

    if (PlatformServices.HELPER.getEnvironment().equals(PlatformEnvironment.DEVELOPMENT)) {
      SomeMoreBlocks.LOGGER.info("Bidirectional registry initialized.");
    }
  }

  private static void leavesBucket() {
    LEAVES_BUCKET.register(SMBBlocks.AZALEA_LEAF_LITTER.get(), SMBItems.AZALEA_LEAVES_BUCKET.get());
    LEAVES_BUCKET.register(SMBBlocks.BIRCH_LEAF_LITTER.get(), SMBItems.BIRCH_LEAVES_BUCKET.get());
    LEAVES_BUCKET.register(Blocks.LEAF_LITTER, SMBItems.DRY_LEAVES_BUCKET.get());
    LEAVES_BUCKET.register(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    LEAVES_BUCKET.register(SMBBlocks.LEAF_LITTER.get(), SMBItems.LEAVES_BUCKET.get());
    LEAVES_BUCKET.register(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SMBItems.PALE_OAK_LEAVES_BUCKET.get());
    LEAVES_BUCKET.register(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SMBItems.SPRUCE_LEAVES_BUCKET.get());
  }

  private static void compostableItems() {
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TINY_CACTUS.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TALL_CACTUS.get().asItem(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.DUNE_GRASS.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TALL_DUNE_GRASS.get().asItem(), 0.5F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SHORT_SNOW_GRASS.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TALL_SNOW_GRASS.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SNOW_FERN.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.LARGE_SNOW_FERN.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.CATTAIL.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.LUMINOUS_FLOWER.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.BROWN_MUSHROOM_COLONY.get(), 0.85F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.TALL_BROWN_MUSHROOM_COLONY.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.RED_MUSHROOM_COLONY.get(), 0.85F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.TALL_RED_MUSHROOM_COLONY.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.CRIMSON_FUNGUS_COLONY.get(), 0.85F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.TALL_CRIMSON_FUNGUS_COLONY.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.WARPED_FUNGUS_COLONY.get(), 0.85F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.TALL_WARPED_FUNGUS_COLONY.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.PALE_ROSE_BUSH.get().asItem(), 0.85F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SMALL_LILY_PADS.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.BIG_LILY_PAD.get().asItem(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.LEAVES_BUCKET.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.AZALEA_LEAVES_BUCKET.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.BIRCH_LEAVES_BUCKET.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.SPRUCE_LEAVES_BUCKET.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.PALE_OAK_LEAVES_BUCKET.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBItems.DRY_LEAVES_BUCKET.get(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SNOW_BUSH.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SNOW_FIREFLY_BUSH.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.REEDS.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.CLOVER.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.NETHER_CLOVER.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.PALE_MUSHROOM.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.PALE_MUSHROOM_COLONY.get().asItem(), 0.85F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TALL_PALE_MUSHROOM_COLONY.get().asItem(), 1.0F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.DUCKWEED.get().asItem(), 0.4f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.GALAHAD_LARKSPUR.get().asItem(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SHORT_GALAHAD_LARKSPUR.get().asItem(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.ASTOLAT_LARKSPUR.get().asItem(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SHORT_ASTOLAT_LARKSPUR.get().asItem(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SUMMER_SKIES_LARKSPUR.get().asItem(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SHORT_SUMMER_SKIES_LARKSPUR.get().asItem(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.PURPLE_LARKSPUR.get().asItem(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SHORT_PURPLE_LARKSPUR.get().asItem(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.RED_LARK_LARKSPUR.get().asItem(), 1.0f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SHORT_RED_LARK_LARKSPUR.get().asItem(), 0.65f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SPROUTS.get().asItem(), 0.3f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.DRY_SPROUTS.get().asItem(), 0.3f);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.LAVENDER.get().asItem(), 0.65f);
  }

  private static void carvedBlocks() {
    CARVED_BLOCKS.register(Blocks.STRIPPED_OAK_WOOD, SMBBlocks.CARVED_OAK_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_OAK_LOG, SMBBlocks.CARVED_OAK_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_DARK_OAK_WOOD, SMBBlocks.CARVED_DARK_OAK_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_DARK_OAK_LOG, SMBBlocks.CARVED_DARK_OAK_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_ACACIA_WOOD, SMBBlocks.CARVED_ACACIA_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_ACACIA_LOG, SMBBlocks.CARVED_ACACIA_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_CHERRY_WOOD, SMBBlocks.CARVED_CHERRY_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_CHERRY_LOG, SMBBlocks.CARVED_CHERRY_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_BIRCH_WOOD, SMBBlocks.CARVED_BIRCH_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_BIRCH_LOG, SMBBlocks.CARVED_BIRCH_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_JUNGLE_WOOD, SMBBlocks.CARVED_JUNGLE_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_JUNGLE_LOG, SMBBlocks.CARVED_JUNGLE_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_SPRUCE_WOOD, SMBBlocks.CARVED_SPRUCE_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_SPRUCE_LOG, SMBBlocks.CARVED_SPRUCE_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_WARPED_STEM, SMBBlocks.CARVED_WARPED_STEM.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_WARPED_HYPHAE, SMBBlocks.CARVED_WARPED_HYPHAE.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_CRIMSON_STEM, SMBBlocks.CARVED_CRIMSON_STEM.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_CRIMSON_HYPHAE, SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_MANGROVE_WOOD, SMBBlocks.CARVED_MANGROVE_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_MANGROVE_LOG, SMBBlocks.CARVED_MANGROVE_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_PALE_OAK_LOG, SMBBlocks.CARVED_PALE_OAK_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_PALE_OAK_WOOD, SMBBlocks.CARVED_PALE_OAK_WOOD.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_BAMBOO_BLOCK, SMBBlocks.CARVED_BAMBOO_BLOCK.get());
    CARVED_BLOCKS.register(Blocks.MUSHROOM_STEM, SMBBlocks.CARVED_MUSHROOM_STEM.get());
  }

  private static void snowyPlantBlocks() {
    SNOWY_PLANT_BLOCKS.register(Blocks.SHORT_GRASS, SMBBlocks.SHORT_SNOW_GRASS.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.TALL_GRASS, SMBBlocks.TALL_SNOW_GRASS.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.FERN, SMBBlocks.SNOW_FERN.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.LARGE_FERN, SMBBlocks.LARGE_SNOW_FERN.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.BUSH, SMBBlocks.SNOW_BUSH.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.FIREFLY_BUSH, SMBBlocks.SNOW_FIREFLY_BUSH.get());
  }

  private static void waxedCopperBlocks() {
    SMBBlocks.COPPER_BRICKS.get().waxed().progressMapping((WAXED_COPPER_BLOCKS::register));
    SMBBlocks.CRACKED_COPPER_BRICKS.get().waxed().progressMapping((WAXED_COPPER_BLOCKS::register));
    SMBBlocks.CRACKED_CUT_COPPER.get().waxed().progressMapping((WAXED_COPPER_BLOCKS::register));
    SMBBlocks.COPPER_PILLAR.get().waxed().progressMapping((WAXED_COPPER_BLOCKS::register));
  }

  private static void weatheringCopperBlocks() {
    SMBBlocks.COPPER_BRICKS.get().weathering().progressMapping((WEATHERING_COPPER_BLOCKS::register));
    SMBBlocks.CRACKED_COPPER_BRICKS.get().weathering().progressMapping((WEATHERING_COPPER_BLOCKS::register));
    SMBBlocks.CRACKED_CUT_COPPER.get().weathering().progressMapping((WEATHERING_COPPER_BLOCKS::register));
    SMBBlocks.COPPER_PILLAR.get().weathering().progressMapping((WEATHERING_COPPER_BLOCKS::register));
  }
}
