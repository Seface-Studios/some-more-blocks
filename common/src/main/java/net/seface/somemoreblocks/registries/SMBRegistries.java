package net.seface.somemoreblocks.registries;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.BidirectionalRegistryObject;
import org.jetbrains.annotations.Nullable;

public class SMBRegistries {
  public static BidirectionalRegistryObject<Block, Block> CARVED_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("carved_blocks"));
  public static BidirectionalRegistryObject<Block, Block> SNOWY_PLANT_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("snowy_plant_blocks"));
  public static BidirectionalRegistryObject<Block, Block> WAXED_COPPER_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("waxed_copper_blocks"));
  public static BidirectionalRegistryObject<Block, Block> WEATHERING_COPPER_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("weathering_copper_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> STAINED_TILED_GLASS_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("tiled_glass_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> STAINED_TILED_GLASS_PANE_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("stained_tiled_glass_pane_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> SHINGLES_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("shingles_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> TERRACOTTA_BRICKS_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("terracotta_bricks_blocks"));
  public static BidirectionalRegistryObject<@Nullable DyeColor, Block> TERRACOTTA_TILES_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("terracotta_tiles_blocks"));
  public static BidirectionalRegistryObject<DyeColor, Block> CONCRETE_BRICKS_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("concrete_bricks_blocks"));
  public static BidirectionalRegistryObject<DyeColor, Block> CONCRETE_TILES_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("concrete_tiles_blocks"));
  public static BidirectionalRegistryObject<DyeColor, Block> CHECKERED_TILES = BidirectionalRegistryObject.create(SomeMoreBlocks.id("concrete_tiles_blocks"));
  public static BidirectionalRegistryObject<Block, Item> LEAVES_BUCKET = BidirectionalRegistryObject.create(SomeMoreBlocks.id("leaves_bucket"));

  /**
   * This initialization need to be called directly on Mod Loader initialize class!
   */
  public static void init() {
    SMBRegistries.carvedBlocks();
    SMBRegistries.checkeredTiles();
    SMBRegistries.compostableItems();
    SMBRegistries.concreteBlocks();
    SMBRegistries.leavesBucket();
    SMBRegistries.shinglesBlocks();
    SMBRegistries.snowyPlantBlocks();
    SMBRegistries.stainedTiledGlassBlocks();
    SMBRegistries.stainedTiledGlassPaneBlocks();
    SMBRegistries.terracottaBlocks();
    SMBRegistries.waxedCopperBlocks();
    SMBRegistries.weatheringCopperBlocks();
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
    WAXED_COPPER_BLOCKS.register(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    WAXED_COPPER_BLOCKS.register(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
  }

  private static void weatheringCopperBlocks() {
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    WEATHERING_COPPER_BLOCKS.register(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
  }

  private static void stainedTiledGlassBlocks() {
    STAINED_TILED_GLASS_BLOCKS.register(null, SMBBlocks.TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.WHITE, SMBBlocks.WHITE_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.GRAY, SMBBlocks.GRAY_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.BLACK, SMBBlocks.BLACK_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.BROWN, SMBBlocks.BROWN_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.RED, SMBBlocks.RED_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.ORANGE, SMBBlocks.ORANGE_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.YELLOW, SMBBlocks.YELLOW_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.LIME, SMBBlocks.LIME_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.GREEN, SMBBlocks.GREEN_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.CYAN, SMBBlocks.CYAN_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.BLUE, SMBBlocks.BLUE_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.PURPLE, SMBBlocks.PURPLE_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get());
    STAINED_TILED_GLASS_BLOCKS.register(DyeColor.PINK, SMBBlocks.PINK_STAINED_TILED_GLASS.get());
  }

  private static void stainedTiledGlassPaneBlocks() {
    STAINED_TILED_GLASS_PANE_BLOCKS.register(null, SMBBlocks.TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.WHITE, SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.GRAY, SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.BLACK, SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.BROWN, SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.RED, SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.ORANGE, SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.YELLOW, SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.LIME, SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.GREEN, SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.CYAN, SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.BLUE, SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.PURPLE, SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get());
    STAINED_TILED_GLASS_PANE_BLOCKS.register(DyeColor.PINK, SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get());
  }

  private static void shinglesBlocks() {
    SHINGLES_BLOCKS.register(null, SMBBlocks.SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.WHITE, SMBBlocks.WHITE_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.GRAY, SMBBlocks.GRAY_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.BLACK, SMBBlocks.BLACK_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.BROWN, SMBBlocks.BROWN_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.RED, SMBBlocks.RED_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.ORANGE, SMBBlocks.ORANGE_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.YELLOW, SMBBlocks.YELLOW_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.LIME, SMBBlocks.LIME_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.GREEN, SMBBlocks.GREEN_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.CYAN, SMBBlocks.CYAN_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.BLUE, SMBBlocks.BLUE_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.PURPLE, SMBBlocks.PURPLE_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_SHINGLES.get());
    SHINGLES_BLOCKS.register(DyeColor.PINK, SMBBlocks.PINK_SHINGLES.get());
  }

  private static void terracottaBlocks() {
    TERRACOTTA_BRICKS_BLOCKS.register(null, SMBBlocks.TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.WHITE, SMBBlocks.WHITE_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.GRAY, SMBBlocks.GRAY_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.BLACK, SMBBlocks.BLACK_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.BROWN, SMBBlocks.BROWN_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.RED, SMBBlocks.RED_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.ORANGE, SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.YELLOW, SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.LIME, SMBBlocks.LIME_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.GREEN, SMBBlocks.GREEN_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.CYAN, SMBBlocks.CYAN_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.BLUE, SMBBlocks.BLUE_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.PURPLE, SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
    TERRACOTTA_BRICKS_BLOCKS.register(DyeColor.PINK, SMBBlocks.PINK_TERRACOTTA_BRICKS.get());

    TERRACOTTA_TILES_BLOCKS.register(null, SMBBlocks.TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.WHITE, SMBBlocks.WHITE_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.GRAY, SMBBlocks.GRAY_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.BLACK, SMBBlocks.BLACK_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.BROWN, SMBBlocks.BROWN_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.RED, SMBBlocks.RED_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.ORANGE, SMBBlocks.ORANGE_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.YELLOW, SMBBlocks.YELLOW_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.LIME, SMBBlocks.LIME_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.GREEN, SMBBlocks.GREEN_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.CYAN, SMBBlocks.CYAN_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.BLUE, SMBBlocks.BLUE_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.PURPLE, SMBBlocks.PURPLE_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_TERRACOTTA_TILES.get());
    TERRACOTTA_TILES_BLOCKS.register(DyeColor.PINK, SMBBlocks.PINK_TERRACOTTA_TILES.get());
  }

  private static void concreteBlocks() {
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.WHITE, SMBBlocks.WHITE_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.GRAY, SMBBlocks.GRAY_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.BLACK, SMBBlocks.BLACK_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.BROWN, SMBBlocks.BROWN_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.RED, SMBBlocks.RED_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.ORANGE, SMBBlocks.ORANGE_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.YELLOW, SMBBlocks.YELLOW_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.LIME, SMBBlocks.LIME_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.GREEN, SMBBlocks.GREEN_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.CYAN, SMBBlocks.CYAN_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.BLUE, SMBBlocks.BLUE_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.PURPLE, SMBBlocks.PURPLE_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_CONCRETE_BRICKS.get());
    CONCRETE_BRICKS_BLOCKS.register(DyeColor.PINK, SMBBlocks.PINK_CONCRETE_BRICKS.get());

    CONCRETE_TILES_BLOCKS.register(DyeColor.WHITE, SMBBlocks.WHITE_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.GRAY, SMBBlocks.GRAY_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.BLACK, SMBBlocks.BLACK_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.BROWN, SMBBlocks.BROWN_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.RED, SMBBlocks.RED_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.ORANGE, SMBBlocks.ORANGE_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.YELLOW, SMBBlocks.YELLOW_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.LIME, SMBBlocks.LIME_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.GREEN, SMBBlocks.GREEN_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.CYAN, SMBBlocks.CYAN_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.BLUE, SMBBlocks.BLUE_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.PURPLE, SMBBlocks.PURPLE_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_CONCRETE_TILES.get());
    CONCRETE_TILES_BLOCKS.register(DyeColor.PINK, SMBBlocks.PINK_CONCRETE_TILES.get());
  }

  private static void checkeredTiles() {
    CHECKERED_TILES.register(DyeColor.WHITE, SMBBlocks.WHITE_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.LIGHT_GRAY, SMBBlocks.LIGHT_GRAY_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.GRAY, SMBBlocks.GRAY_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.BLACK, SMBBlocks.BLACK_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.BROWN, SMBBlocks.BROWN_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.RED, SMBBlocks.RED_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.ORANGE, SMBBlocks.ORANGE_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.YELLOW, SMBBlocks.YELLOW_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.LIME, SMBBlocks.LIME_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.GREEN, SMBBlocks.GREEN_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.CYAN, SMBBlocks.CYAN_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.LIGHT_BLUE, SMBBlocks.LIGHT_BLUE_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.BLUE, SMBBlocks.BLUE_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.PURPLE, SMBBlocks.PURPLE_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.MAGENTA, SMBBlocks.MAGENTA_CHECKERED_TILES.get());
    CHECKERED_TILES.register(DyeColor.PINK, SMBBlocks.PINK_CHECKERED_TILES.get());
  }
}
