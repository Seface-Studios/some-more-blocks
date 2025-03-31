package net.seface.somemoreblocks.registries;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.BidirectionalRegistryObject;
import net.seface.somemoreblocks.tags.SMBBlockTags;

public class SMBRegistries {
  public static BidirectionalRegistryObject<Block, Block> CARVED_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("carved_blocks"));
  public static BidirectionalRegistryObject<Block, Block> SNOWY_PLANT_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("snowy_plant_blocks"));
  public static BidirectionalRegistryObject<Block, Block> WAXED_COPPER_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("waxed_copper_blocks"));
  public static BidirectionalRegistryObject<Block, Block> WEATHERING_COPPER_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("weathering_copper_blocks"));
  public static BidirectionalRegistryObject<TagKey<Block>, Block> LEAF_LITTER_BLOCKS = BidirectionalRegistryObject.create(SomeMoreBlocks.id("leaf_litter_blocks"));

  /**
   * This initialization need to be called directly on Mod Loader initialize class!
   */
  public static void init() {
    SMBRegistries.carvedBlocks();
    SMBRegistries.snowyPlantBlocks();
    SMBRegistries.waxedCopperBlocks();
    SMBRegistries.weatheringCopperBlocks();
    SMBRegistries.compostableItems();
    SMBRegistries.leafLitterBlocks();
  }

  private static void compostableItems() {
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TINY_CACTUS.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.DUNE_GRASS.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TALL_DUNE_GRASS.get().asItem(), 0.5F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TALL_DUNE_GRASS.get().asItem(), 0.5F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SHORT_SNOW_GRASS.get().asItem(), 0.3F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.TALL_SNOW_GRASS.get().asItem(), 0.65F);
    ComposterBlock.COMPOSTABLES.put(SMBBlocks.SNOW_FERN.get().asItem(), 0.65F);
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
    CARVED_BLOCKS.register(Blocks.STRIPPED_BAMBOO_BLOCK, SMBBlocks.CARVED_BAMBOO_BLOCK.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_PALE_OAK_LOG, SMBBlocks.CARVED_PALE_OAK_LOG.get());
    CARVED_BLOCKS.register(Blocks.STRIPPED_PALE_OAK_WOOD, SMBBlocks.CARVED_PALE_OAK_WOOD.get());
  }

  private static void snowyPlantBlocks() {
    SNOWY_PLANT_BLOCKS.register(Blocks.SHORT_GRASS, SMBBlocks.SHORT_SNOW_GRASS.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.TALL_GRASS, SMBBlocks.TALL_SNOW_GRASS.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.FERN, SMBBlocks.SNOW_FERN.get());
    SNOWY_PLANT_BLOCKS.register(Blocks.LARGE_FERN, SMBBlocks.LARGE_SNOW_FERN.get());
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

  private static void leafLitterBlocks() {
    LEAF_LITTER_BLOCKS.register(SMBBlockTags.LEAF_LITTER_PARENT_LEAVES, SMBBlocks.LEAF_LITTER.get());
    LEAF_LITTER_BLOCKS.register(SMBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.BIRCH_LEAF_LITTER.get());
    LEAF_LITTER_BLOCKS.register(SMBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.SPRUCE_LEAF_LITTER.get());
    LEAF_LITTER_BLOCKS.register(SMBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.AZALEA_LEAF_LITTER.get());
    LEAF_LITTER_BLOCKS.register(SMBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get());
    LEAF_LITTER_BLOCKS.register(SMBBlockTags.PALE_OAK_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.PALE_OAK_LEAF_LITTER.get());
  }
}
