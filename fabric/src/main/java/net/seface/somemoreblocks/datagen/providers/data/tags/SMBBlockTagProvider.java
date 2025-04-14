package net.seface.somemoreblocks.datagen.providers.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;

import java.util.concurrent.CompletableFuture;

public class SMBBlockTagProvider extends FabricTagProvider<Block> {
  public SMBBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, Registries.BLOCK, future);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    getOrCreateTagBuilder(SMBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES).add(Blocks.AZALEA_LEAVES);
    getOrCreateTagBuilder(SMBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES).add(Blocks.BIRCH_LEAVES);

    getOrCreateTagBuilder(SMBBlockTags.CATTAIL_PLACEABLE)
      .forceAddTag(BlockTags.DIRT)
      .add(Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS,Blocks.CLAY);

    getOrCreateTagBuilder(SMBBlockTags.DUNE_GRASS_PLACEABLE)
      .forceAddTag(BlockTags.DIRT)
      .forceAddTag(BlockTags.SAND);

    getOrCreateTagBuilder(SMBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES).add(Blocks.FLOWERING_AZALEA_LEAVES);
    getOrCreateTagBuilder(SMBBlockTags.LEAF_LITTERS_PLACEABLE).add(Blocks.DIRT_PATH, Blocks.FARMLAND, Blocks.MUD);
    getOrCreateTagBuilder(SMBBlockTags.LEAF_LITTER_PARENT_LEAVES)
      .add(
        Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES,
        Blocks.JUNGLE_LEAVES,Blocks.MANGROVE_LEAVES, Blocks.OAK_LEAVES);

    getOrCreateTagBuilder(SMBBlockTags.LEAF_LITTER_REPLACEABLE)
      .add(
        Blocks.DEAD_BUSH, Blocks.FERN,
        Blocks.SHORT_GRASS, Blocks.VINE,
        Blocks.MOSS_CARPET, Blocks.PALE_MOSS_CARPET,
        SMBBlocks.DUNE_GRASS.get(), SMBBlocks.SNOW_FERN.get(), SMBBlocks.SHORT_SNOW_GRASS.get());

    getOrCreateTagBuilder(SMBBlockTags.MUSHROOM_COLONY_PLACEABLE)
      .forceAddTag(BlockTags.DIRT)
      .forceAddTag(BlockTags.LOGS)
      .add(
        Blocks.MANGROVE_ROOTS, Blocks.MUDDY_MANGROVE_ROOTS,
        Blocks.CRIMSON_NYLIUM, Blocks.WARPED_NYLIUM);

    getOrCreateTagBuilder(SMBBlockTags.PALE_OAK_LEAF_LITTER_PARENT_LEAVES).add(Blocks.PALE_OAK_LEAVES);

    getOrCreateTagBuilder(SMBBlockTags.SHINGLES)
      .add(
        SMBBlocks.SHINGLES.get(), SMBBlocks.WHITE_SHINGLES.get(),
        SMBBlocks.LIGHT_GRAY_SHINGLES.get(), SMBBlocks.GRAY_SHINGLES.get(),
        SMBBlocks.BLACK_SHINGLES.get(), SMBBlocks.BROWN_SHINGLES.get(),
        SMBBlocks.RED_SHINGLES.get(), SMBBlocks.ORANGE_SHINGLES.get(),
        SMBBlocks.YELLOW_SHINGLES.get(), SMBBlocks.LIME_SHINGLES.get(),
        SMBBlocks.GREEN_SHINGLES.get(), SMBBlocks.CYAN_SHINGLES.get(),
        SMBBlocks.LIGHT_BLUE_SHINGLES.get(), SMBBlocks.BLUE_SHINGLES.get(),
        SMBBlocks.PURPLE_SHINGLES.get(), SMBBlocks.MAGENTA_SHINGLES.get(), SMBBlocks.PINK_SHINGLES.get());

    getOrCreateTagBuilder(SMBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES).add(Blocks.SPRUCE_LEAVES);

    getOrCreateTagBuilder(SMBBlockTags.TERRACOTTA_BRICKS)
      .add(
        SMBBlocks.TERRACOTTA_BRICKS.get(), SMBBlocks.WHITE_TERRACOTTA_BRICKS.get(),
        SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), SMBBlocks.GRAY_TERRACOTTA_BRICKS.get(),
        SMBBlocks.BLACK_TERRACOTTA_BRICKS.get(), SMBBlocks.BROWN_TERRACOTTA_BRICKS.get(),
        SMBBlocks.RED_TERRACOTTA_BRICKS.get(), SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get(),
        SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get(), SMBBlocks.LIME_TERRACOTTA_BRICKS.get(),
        SMBBlocks.GREEN_TERRACOTTA_BRICKS.get(), SMBBlocks.CYAN_TERRACOTTA_BRICKS.get(),
        SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), SMBBlocks.BLUE_TERRACOTTA_BRICKS.get(),
        SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get(), SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get(), SMBBlocks.PINK_TERRACOTTA_BRICKS.get());

    getOrCreateTagBuilder(SMBBlockTags.TERRACOTTA_TILES)
      .add(
        SMBBlocks.TERRACOTTA_TILES.get(), SMBBlocks.WHITE_TERRACOTTA_TILES.get(),
        SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get(), SMBBlocks.GRAY_TERRACOTTA_TILES.get(),
        SMBBlocks.BLACK_TERRACOTTA_TILES.get(), SMBBlocks.BROWN_TERRACOTTA_TILES.get(),
        SMBBlocks.RED_TERRACOTTA_TILES.get(), SMBBlocks.ORANGE_TERRACOTTA_TILES.get(),
        SMBBlocks.YELLOW_TERRACOTTA_TILES.get(), SMBBlocks.LIME_TERRACOTTA_TILES.get(),
        SMBBlocks.GREEN_TERRACOTTA_TILES.get(), SMBBlocks.CYAN_TERRACOTTA_TILES.get(),
        SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get(), SMBBlocks.BLUE_TERRACOTTA_TILES.get(),
        SMBBlocks.PURPLE_TERRACOTTA_TILES.get(), SMBBlocks.MAGENTA_TERRACOTTA_TILES.get(), SMBBlocks.PINK_TERRACOTTA_TILES.get());

    getOrCreateTagBuilder(SMBBlockTags.CONCRETE_BRICKS)
      .add(
        SMBBlocks.WHITE_CONCRETE_BRICKS.get(), SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get(),
        SMBBlocks.GRAY_CONCRETE_BRICKS.get(), SMBBlocks.BLACK_CONCRETE_BRICKS.get(),
        SMBBlocks.BROWN_CONCRETE_BRICKS.get(), SMBBlocks.RED_CONCRETE_BRICKS.get(),
        SMBBlocks.ORANGE_CONCRETE_BRICKS.get(), SMBBlocks.YELLOW_CONCRETE_BRICKS.get(),
        SMBBlocks.LIME_CONCRETE_BRICKS.get(), SMBBlocks.GREEN_CONCRETE_BRICKS.get(),
        SMBBlocks.CYAN_CONCRETE_BRICKS.get(), SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get(),
        SMBBlocks.BLUE_CONCRETE_BRICKS.get(), SMBBlocks.PURPLE_CONCRETE_BRICKS.get(),
        SMBBlocks.MAGENTA_CONCRETE_BRICKS.get(), SMBBlocks.PINK_TERRACOTTA_BRICKS.get());

    getOrCreateTagBuilder(SMBBlockTags.CONCRETE_TILES)
      .add(
        SMBBlocks.WHITE_CONCRETE_TILES.get(), SMBBlocks.LIGHT_GRAY_CONCRETE_TILES.get(),
        SMBBlocks.GRAY_CONCRETE_TILES.get(), SMBBlocks.BLACK_CONCRETE_TILES.get(),
        SMBBlocks.BROWN_CONCRETE_TILES.get(), SMBBlocks.RED_CONCRETE_TILES.get(),
        SMBBlocks.ORANGE_CONCRETE_TILES.get(), SMBBlocks.YELLOW_CONCRETE_TILES.get(),
        SMBBlocks.LIME_CONCRETE_TILES.get(), SMBBlocks.GREEN_CONCRETE_TILES.get(),
        SMBBlocks.CYAN_CONCRETE_TILES.get(), SMBBlocks.LIGHT_BLUE_CONCRETE_TILES.get(),
        SMBBlocks.BLUE_CONCRETE_TILES.get(), SMBBlocks.PURPLE_CONCRETE_TILES.get(),
        SMBBlocks.MAGENTA_CONCRETE_TILES.get(), SMBBlocks.PINK_TERRACOTTA_TILES.get());

    getOrCreateTagBuilder(SMBBlockTags.TINY_CACTUS_PLACEABLE)
      .forceAddTag(BlockTags.DIRT)
      .forceAddTag(BlockTags.SAND)
      .forceAddTag(BlockTags.TERRACOTTA)
      .forceAddTag(SMBBlockTags.TERRACOTTA_BRICKS)
      .forceAddTag(SMBBlockTags.TERRACOTTA_TILES)
      .forceAddTag(SMBBlockTags.SHINGLES);

    getOrCreateTagBuilder(SMBBlockTags.LEAF_LITTERS)
      .add(
        SMBBlocks.LEAF_LITTER.get(), SMBBlocks.AZALEA_LEAF_LITTER.get(),
        SMBBlocks.BIRCH_LEAF_LITTER.get(), SMBBlocks.SPRUCE_LEAF_LITTER.get(),
        SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get());

    addToVanillaTags();
  }

  private void addToVanillaTags() {
    getOrCreateTagBuilder(BlockTags.ACACIA_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_ACACIA_LOG.get(), SMBBlocks.CARVED_ACACIA_WOOD.get());

    getOrCreateTagBuilder(BlockTags.BAMBOO_BLOCKS).setReplace(false)
      .add(SMBBlocks.CARVED_BAMBOO_BLOCK.get());

    getOrCreateTagBuilder(BlockTags.BIRCH_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_BIRCH_LOG.get(), SMBBlocks.CARVED_BIRCH_WOOD.get());

    getOrCreateTagBuilder(BlockTags.CHERRY_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_CHERRY_LOG.get(), SMBBlocks.CARVED_CHERRY_WOOD.get());

    getOrCreateTagBuilder(BlockTags.CRIMSON_STEMS).setReplace(false)
      .add(SMBBlocks.CARVED_CRIMSON_STEM.get(), SMBBlocks.CARVED_CRIMSON_HYPHAE.get());

    getOrCreateTagBuilder(BlockTags.DARK_OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_DARK_OAK_LOG.get(), SMBBlocks.CARVED_DARK_OAK_WOOD.get());

    getOrCreateTagBuilder(BlockTags.FLOWER_POTS).setReplace(false)
      .add(SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), SMBBlocks.POTTED_SNOW_FERN.get(), SMBBlocks.POTTED_TINY_CACTUS.get());

    getOrCreateTagBuilder(BlockTags.ICE).setReplace(false)
      .add(
        SMBBlocks.POLISHED_ICE.get(), SMBBlocks.POLISHED_ICE_STAIRS.get(),
        SMBBlocks.POLISHED_ICE_SLAB.get(), SMBBlocks.ICE_BRICKS.get(),
        SMBBlocks.CRACKED_ICE_BRICKS.get(), SMBBlocks.ICE_BRICK_STAIRS.get(),
        SMBBlocks.ICE_BRICK_SLAB.get(), SMBBlocks.ICE_BRICK_WALL.get(),
        SMBBlocks.ICE_PILLAR.get(), SMBBlocks.ICE_TILES.get(),
        SMBBlocks.CRACKED_ICE_TILES.get(), SMBBlocks.ICE_TILE_STAIRS.get(),
        SMBBlocks.ICE_TILE_SLAB.get(), SMBBlocks.ICE_TILE_WALL.get());

    getOrCreateTagBuilder(BlockTags.IMPERMEABLE).setReplace(false)
      .add(
        SMBBlocks.TILED_GLASS.get(), SMBBlocks.WHITE_STAINED_TILED_GLASS.get(),
        SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(), SMBBlocks.GRAY_STAINED_TILED_GLASS.get(),
        SMBBlocks.BLACK_STAINED_TILED_GLASS.get(), SMBBlocks.BROWN_STAINED_TILED_GLASS.get(),
        SMBBlocks.RED_STAINED_TILED_GLASS.get(), SMBBlocks.ORANGE_STAINED_TILED_GLASS.get(),
        SMBBlocks.YELLOW_STAINED_TILED_GLASS.get(), SMBBlocks.LIME_STAINED_TILED_GLASS.get(),
        SMBBlocks.GREEN_STAINED_TILED_GLASS.get(), SMBBlocks.CYAN_STAINED_TILED_GLASS.get(),
        SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(), SMBBlocks.BLUE_STAINED_TILED_GLASS.get(),
        SMBBlocks.PURPLE_STAINED_TILED_GLASS.get(), SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get(),
        SMBBlocks.PINK_STAINED_TILED_GLASS.get(), SMBBlocks.TILED_TINTED_GLASS.get());

    getOrCreateTagBuilder(BlockTags.JUNGLE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_JUNGLE_LOG.get(), SMBBlocks.CARVED_JUNGLE_WOOD.get());

    getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_MANGROVE_LOG.get(), SMBBlocks.CARVED_MANGROVE_WOOD.get());

    getOrCreateTagBuilder(BlockTags.OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_OAK_LOG.get(), SMBBlocks.CARVED_OAK_WOOD.get());

    getOrCreateTagBuilder(BlockTags.PALE_OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_PALE_OAK_LOG.get(), SMBBlocks.CARVED_PALE_OAK_WOOD.get());

    getOrCreateTagBuilder(BlockTags.PLANKS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC.get(), SMBBlocks.SPRUCE_MOSAIC.get(),
        SMBBlocks.BIRCH_MOSAIC.get(), SMBBlocks.JUNGLE_MOSAIC.get(),
        SMBBlocks.ACACIA_MOSAIC.get(), SMBBlocks.DARK_OAK_MOSAIC.get(),
        SMBBlocks.MANGROVE_MOSAIC.get(), SMBBlocks.CRIMSON_MOSAIC.get(),
        SMBBlocks.WARPED_MOSAIC.get(), SMBBlocks.CHERRY_MOSAIC.get(), SMBBlocks.PALE_OAK_MOSAIC.get());

    getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES).setReplace(false)
      .forceAddTag(SMBBlockTags.LEAF_LITTERS)
      .add(
        SMBBlocks.TINY_CACTUS.get(), SMBBlocks.DUNE_GRASS.get(),
        SMBBlocks.TALL_DUNE_GRASS.get(), SMBBlocks.SHORT_SNOW_GRASS.get(),
        SMBBlocks.TALL_SNOW_GRASS.get(), SMBBlocks.SNOW_FERN.get(),
        SMBBlocks.LARGE_SNOW_FERN.get(), SMBBlocks.CATTAIL.get());

    getOrCreateTagBuilder(BlockTags.REPLACEABLE).setReplace(false)
      .forceAddTag(SMBBlockTags.LEAF_LITTERS)
      .add(
        SMBBlocks.TINY_CACTUS.get(), SMBBlocks.DUNE_GRASS.get(),
        SMBBlocks.TALL_DUNE_GRASS.get(), SMBBlocks.SHORT_SNOW_GRASS.get(),
        SMBBlocks.TALL_SNOW_GRASS.get(), SMBBlocks.SNOW_FERN.get(),
        SMBBlocks.LARGE_SNOW_FERN.get(), SMBBlocks.CATTAIL.get());

    getOrCreateTagBuilder(BlockTags.SLABS).setReplace(false)
      .add(
        SMBBlocks.PACKED_SNOW_SLAB.get(), SMBBlocks.POLISHED_SNOW_SLAB.get(),
        SMBBlocks.SNOW_BRICK_SLAB.get(), SMBBlocks.SNOW_TILE_SLAB.get(),
        SMBBlocks.SMOOTH_DEEPSLATE_SLAB.get(), SMBBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.get(),
        SMBBlocks.POLISHED_STONE_SLAB.get(), SMBBlocks.STONE_TILE_SLAB.get(),
        SMBBlocks.SMOOTH_GRANITE_SLAB.get(), SMBBlocks.GRANITE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_GRANITE_BRICK_SLAB.get(), SMBBlocks.GRANITE_TILE_SLAB.get(),
        SMBBlocks.SMOOTH_DIORITE_SLAB.get(), SMBBlocks.DIORITE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_DIORITE_BRICK_SLAB.get(), SMBBlocks.DIORITE_TILE_SLAB.get(),
        SMBBlocks.SMOOTH_ANDESITE_SLAB.get(), SMBBlocks.ANDESITE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB.get(), SMBBlocks.ANDESITE_TILE_SLAB.get(),
        SMBBlocks.POLISHED_END_STONE_SLAB.get(), SMBBlocks.SMOOTH_END_STONE_SLAB.get(),
        SMBBlocks.MOSSY_END_STONE_BRICK_SLAB.get(), SMBBlocks.END_STONE_TILE_SLAB.get(),
        SMBBlocks.SMOOTH_TUFF_SLAB.get(), SMBBlocks.MOSSY_TUFF_BRICK_SLAB.get(),
        SMBBlocks.TUFF_TILE_SLAB.get(), SMBBlocks.RED_SANDSTONE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB.get(), SMBBlocks.RED_SANDSTONE_TILE_SLAB.get(),
        SMBBlocks.POLISHED_CALCITE_SLAB.get(), SMBBlocks.SMOOTH_CALCITE_SLAB.get(),
        SMBBlocks.CALCITE_BRICK_SLAB.get(), SMBBlocks.MOSSY_CALCITE_BRICK_SLAB.get(),
        SMBBlocks.CALCITE_TILE_SLAB.get(), SMBBlocks.POLISHED_DRIPSTONE_SLAB.get(),
        SMBBlocks.SMOOTH_DRIPSTONE_SLAB.get(), SMBBlocks.DRIPSTONE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.get(), SMBBlocks.DRIPSTONE_TILE_SLAB.get(),
        SMBBlocks.POLISHED_PRISMARINE_SLAB.get(), SMBBlocks.SMOOTH_PRISMARINE_SLAB.get(),
        SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB.get(), SMBBlocks.PRISMARINE_TILE_SLAB.get(),
        SMBBlocks.SMOOTH_BLACKSTONE_SLAB.get(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB.get(), SMBBlocks.POLISHED_MUD_SLAB.get(),
        SMBBlocks.SMOOTH_MUD_SLAB.get(), SMBBlocks.MOSSY_MUD_BRICK_SLAB.get(),
        SMBBlocks.MUD_TILE_SLAB.get(), SMBBlocks.SANDSTONE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB.get(), SMBBlocks.SANDSTONE_TILE_SLAB.get(),
        SMBBlocks.POLISHED_ICE_SLAB.get(), SMBBlocks.ICE_BRICK_SLAB.get(),
        SMBBlocks.ICE_TILE_SLAB.get(), SMBBlocks.POLISHED_PURPUR_SLAB.get(),
        SMBBlocks.SMOOTH_PURPUR_SLAB.get(), SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB.get(),
        SMBBlocks.PURPUR_TILE_SLAB.get(), SMBBlocks.SOUL_SANDSTONE_SLAB.get(),
        SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.get(), SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB.get(), SMBBlocks.SOUL_SANDSTONE_TILE_SLAB.get(),
        SMBBlocks.MOSSY_BRICK_SLAB.get(), SMBBlocks.BONE_BRICK_SLAB.get(),
        SMBBlocks.BONE_TILE_SLAB.get(), SMBBlocks.POLISHED_RESIN_SLAB.get(),
        SMBBlocks.RESIN_TILE_SLAB.get(), SMBBlocks.SMOOTH_RESIN_SLAB.get()
      );

    getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).setReplace(false).add(SMBBlocks.LUMINOUS_FLOWER.get());

    getOrCreateTagBuilder(BlockTags.SNOW).setReplace(false)
      .add(
        SMBBlocks.PACKED_SNOW.get(), SMBBlocks.POLISHED_SNOW.get(),
        SMBBlocks.SNOW_BRICKS.get(), SMBBlocks.CRACKED_SNOW_BRICKS.get(),
        SMBBlocks.SNOW_PILLAR.get(), SMBBlocks.SNOW_TILES.get(),
        SMBBlocks.CRACKED_SNOW_TILES.get());

    getOrCreateTagBuilder(BlockTags.SPRUCE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_SPRUCE_LOG.get(), SMBBlocks.CARVED_SPRUCE_WOOD.get());

    getOrCreateTagBuilder(BlockTags.STAIRS).setReplace(false)
      .add(
        SMBBlocks.PACKED_SNOW_STAIRS.get(), SMBBlocks.POLISHED_SNOW_STAIRS.get(),
        SMBBlocks.SNOW_BRICK_STAIRS.get(), SMBBlocks.SNOW_TILE_STAIRS.get(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.get(), SMBBlocks.POLISHED_STONE_STAIRS.get(),
        SMBBlocks.STONE_TILE_STAIRS.get(), SMBBlocks.GRANITE_BRICK_STAIRS.get(),
        SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS.get(), SMBBlocks.GRANITE_TILE_STAIRS.get(),
        SMBBlocks.DIORITE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS.get(),
        SMBBlocks.DIORITE_TILE_STAIRS.get(), SMBBlocks.ANDESITE_BRICK_STAIRS.get(),
        SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS.get(), SMBBlocks.ANDESITE_TILE_STAIRS.get(),
        SMBBlocks.POLISHED_END_STONE_STAIRS.get(), SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS.get(),
        SMBBlocks.END_STONE_TILE_STAIRS.get(), SMBBlocks.MOSSY_TUFF_BRICK_STAIRS.get(),
        SMBBlocks.TUFF_TILE_STAIRS.get(), SMBBlocks.RED_SANDSTONE_BRICK_STAIRS.get(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS.get(), SMBBlocks.RED_SANDSTONE_TILE_STAIRS.get(),
        SMBBlocks.POLISHED_CALCITE_STAIRS.get(), SMBBlocks.CALCITE_BRICK_STAIRS.get(),
        SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS.get(), SMBBlocks.CALCITE_TILE_STAIRS.get(),
        SMBBlocks.POLISHED_DRIPSTONE_STAIRS.get(), SMBBlocks.DRIPSTONE_BRICK_STAIRS.get(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.get(), SMBBlocks.DRIPSTONE_TILE_STAIRS.get(),
        SMBBlocks.POLISHED_PRISMARINE_STAIRS.get(), SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS.get(),
        SMBBlocks.PRISMARINE_TILE_STAIRS.get(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS.get(), SMBBlocks.POLISHED_MUD_STAIRS.get(),
        SMBBlocks.MOSSY_MUD_BRICK_STAIRS.get(), SMBBlocks.MUD_TILE_STAIRS.get(),
        SMBBlocks.SANDSTONE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS.get(),
        SMBBlocks.SANDSTONE_TILE_STAIRS.get(), SMBBlocks.POLISHED_ICE_STAIRS.get(),
        SMBBlocks.ICE_BRICK_STAIRS.get(), SMBBlocks.ICE_TILE_STAIRS.get(),
        SMBBlocks.POLISHED_PURPUR_STAIRS.get(), SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS.get(),
        SMBBlocks.PURPUR_TILE_STAIRS.get(), SMBBlocks.SOUL_SANDSTONE_STAIRS.get(),
        SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get(), SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS.get(),
        SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS.get(), SMBBlocks.MOSSY_BRICK_STAIRS.get(),
        SMBBlocks.BONE_BRICK_STAIRS.get(), SMBBlocks.BONE_TILE_STAIRS.get(),
        SMBBlocks.POLISHED_RESIN_STAIRS.get(), SMBBlocks.RESIN_TILE_STAIRS.get()
      );

    getOrCreateTagBuilder(BlockTags.TERRACOTTA).setReplace(false)
      .forceAddTag(SMBBlockTags.TERRACOTTA_BRICKS)
      .forceAddTag(SMBBlockTags.TERRACOTTA_TILES);

    getOrCreateTagBuilder(BlockTags.WALLS).setReplace(false)
      .add(
        SMBBlocks.SNOW_BRICK_WALL.get(), SMBBlocks.SNOW_TILE_WALL.get(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get(), SMBBlocks.STONE_TILE_WALL.get(),
        SMBBlocks.GRANITE_BRICK_WALL.get(), SMBBlocks.MOSSY_GRANITE_BRICK_WALL.get(),
        SMBBlocks.GRANITE_TILE_WALL.get(), SMBBlocks.DIORITE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_DIORITE_BRICK_WALL.get(), SMBBlocks.DIORITE_TILE_WALL.get(),
        SMBBlocks.ANDESITE_BRICK_WALL.get(), SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.get(),
        SMBBlocks.ANDESITE_TILE_WALL.get(), SMBBlocks.MOSSY_END_STONE_BRICK_WALL.get(),
        SMBBlocks.END_STONE_TILE_WALL.get(), SMBBlocks.MOSSY_TUFF_BRICK_WALL.get(),
        SMBBlocks.TUFF_TILE_WALL.get(), SMBBlocks.RED_SANDSTONE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.get(), SMBBlocks.RED_SANDSTONE_TILE_WALL.get(),
        SMBBlocks.CALCITE_BRICK_WALL.get(), SMBBlocks.MOSSY_CALCITE_BRICK_WALL.get(),
        SMBBlocks.CALCITE_TILE_WALL.get(), SMBBlocks.DRIPSTONE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.get(), SMBBlocks.DRIPSTONE_TILE_WALL.get(),
        SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.get(), SMBBlocks.PRISMARINE_TILE_WALL.get(),
        SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.get(), SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.get(),
        SMBBlocks.MOSSY_MUD_BRICK_WALL.get(), SMBBlocks.MUD_TILE_WALL.get(),
        SMBBlocks.SANDSTONE_BRICK_WALL.get(), SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.get(),
        SMBBlocks.SANDSTONE_TILE_WALL.get(), SMBBlocks.ICE_BRICK_WALL.get(),
        SMBBlocks.ICE_TILE_WALL.get(), SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.get(),
        SMBBlocks.PURPUR_TILE_WALL.get(), SMBBlocks.SOUL_SANDSTONE_WALL.get(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get(), SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get(),
        SMBBlocks.MOSSY_BRICK_WALL.get(), SMBBlocks.BONE_BRICK_WALL.get(),
        SMBBlocks.BONE_TILE_WALL.get(), SMBBlocks.RESIN_TILE_WALL.get()
      );

    getOrCreateTagBuilder(BlockTags.WARPED_STEMS).setReplace(false)
      .add(SMBBlocks.CARVED_WARPED_STEM.get(), SMBBlocks.CARVED_WARPED_HYPHAE.get());

    getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC_SLAB.get(), SMBBlocks.SPRUCE_MOSAIC_SLAB.get(),
        SMBBlocks.BIRCH_MOSAIC_SLAB.get(), SMBBlocks.JUNGLE_MOSAIC_SLAB.get(),
        SMBBlocks.ACACIA_MOSAIC_SLAB.get(), SMBBlocks.DARK_OAK_MOSAIC_SLAB.get(),
        SMBBlocks.MANGROVE_MOSAIC_SLAB.get(), SMBBlocks.CRIMSON_MOSAIC_SLAB.get(),
        SMBBlocks.WARPED_MOSAIC_SLAB.get(), SMBBlocks.CHERRY_MOSAIC_SLAB.get(),
        SMBBlocks.PALE_OAK_MOSAIC_SLAB.get()
      );

    getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC_SLAB.get(), SMBBlocks.SPRUCE_MOSAIC_STAIRS.get(),
        SMBBlocks.BIRCH_MOSAIC_STAIRS.get(), SMBBlocks.JUNGLE_MOSAIC_STAIRS.get(),
        SMBBlocks.ACACIA_MOSAIC_STAIRS.get(), SMBBlocks.DARK_OAK_MOSAIC_STAIRS.get(),
        SMBBlocks.MANGROVE_MOSAIC_STAIRS.get(), SMBBlocks.CRIMSON_MOSAIC_STAIRS.get(),
        SMBBlocks.WARPED_MOSAIC_STAIRS.get(), SMBBlocks.CHERRY_MOSAIC_STAIRS.get(),
        SMBBlocks.PALE_OAK_MOSAIC_STAIRS.get()
      );

    getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).setReplace(false)
      .forceAddTag(SMBBlockTags.SHINGLES)
      .forceAddTag(SMBBlockTags.CONCRETE_BRICKS)
      .forceAddTag(SMBBlockTags.CONCRETE_TILES)
      .forceAddTag(SMBBlockTags.TERRACOTTA_BRICKS)
      .forceAddTag(SMBBlockTags.TERRACOTTA_TILES)
      .add(
        SMBBlocks.AMETHYST_BRICKS.get(), SMBBlocks.AMETHYST_PILLAR.get(),
        SMBBlocks.ANDESITE_BRICK_SLAB.get(), SMBBlocks.ANDESITE_BRICK_STAIRS.get(),
        SMBBlocks.ANDESITE_BRICK_WALL.get(), SMBBlocks.ANDESITE_BRICKS.get(),
        SMBBlocks.ANDESITE_PILLAR.get(), SMBBlocks.ANDESITE_TILE_SLAB.get(),
        SMBBlocks.ANDESITE_TILE_STAIRS.get(), SMBBlocks.ANDESITE_TILE_WALL.get(),
        SMBBlocks.ANDESITE_TILES.get(), SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get(),
        SMBBlocks.BONE_BRICK_SLAB.get(), SMBBlocks.BONE_BRICK_STAIRS.get(),
        SMBBlocks.BONE_BRICK_WALL.get(), SMBBlocks.BONE_BRICKS.get(),
        SMBBlocks.BONE_TILE_SLAB.get(), SMBBlocks.BONE_TILE_STAIRS.get(),
        SMBBlocks.BONE_TILE_WALL.get(), SMBBlocks.BONE_TILES.get(),
        SMBBlocks.CALCITE_BRICK_SLAB.get(), SMBBlocks.CALCITE_BRICK_STAIRS.get(),
        SMBBlocks.CALCITE_BRICK_WALL.get(), SMBBlocks.CALCITE_BRICKS.get(),
        SMBBlocks.CALCITE_PILLAR.get(), SMBBlocks.CALCITE_TILE_SLAB.get(),
        SMBBlocks.CALCITE_TILE_STAIRS.get(), SMBBlocks.CALCITE_TILE_WALL.get(),
        SMBBlocks.CALCITE_TILES.get(), SMBBlocks.CHISELED_ANDESITE_BRICKS.get(),
        SMBBlocks.CHISELED_CALCITE_BRICKS.get(), SMBBlocks.CHISELED_DIORITE_BRICKS.get(),
        SMBBlocks.CHISELED_DRIPSTONE_BRICKS.get(), SMBBlocks.CHISELED_END_STONE_BRICKS.get(),
        SMBBlocks.CHISELED_GRANITE_BRICKS.get(), SMBBlocks.CHISELED_MUD_BRICKS.get(),
        SMBBlocks.CHISELED_PRISMARINE_BRICKS.get(), SMBBlocks.CHISELED_PURPUR.get(),
        SMBBlocks.CHISELED_RED_NETHER_BRICKS.get(), SMBBlocks.CHISELED_SOUL_SANDSTONE.get(),
        SMBBlocks.COAL_BRICKS.get(), SMBBlocks.COAL_PILLAR.get(),
        SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(),
        SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.get(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get(),
        SMBBlocks.CRACKED_AMETHYST_BRICKS.get(), SMBBlocks.CRACKED_ANDESITE_BRICKS.get(),
        SMBBlocks.CRACKED_ANDESITE_TILES.get(), SMBBlocks.CRACKED_BONE_BRICKS.get(),
        SMBBlocks.CRACKED_BONE_TILES.get(), SMBBlocks.CRACKED_BRICKS.get(),
        SMBBlocks.CRACKED_CALCITE_BRICKS.get(), SMBBlocks.CRACKED_CALCITE_TILES.get(),
        SMBBlocks.CRACKED_COAL_BRICKS.get(), SMBBlocks.CRACKED_CUT_AMETHYST.get(),
        SMBBlocks.CRACKED_CUT_COAL.get(), SMBBlocks.CRACKED_CUT_DIAMOND.get(),
        SMBBlocks.CRACKED_CUT_EMERALD.get(), SMBBlocks.CRACKED_CUT_GOLD.get(),
        SMBBlocks.CRACKED_CUT_IRON.get(), SMBBlocks.CRACKED_CUT_LAPIS.get(),
        SMBBlocks.CRACKED_CUT_NETHERITE.get(), SMBBlocks.CRACKED_CUT_QUARTZ.get(),
        SMBBlocks.CRACKED_CUT_REDSTONE.get(), SMBBlocks.CRACKED_DIAMOND_BRICKS.get(),
        SMBBlocks.CRACKED_DIORITE_BRICKS.get(), SMBBlocks.CRACKED_DIORITE_TILES.get(),
        SMBBlocks.CRACKED_DRIPSTONE_BRICKS.get(), SMBBlocks.CRACKED_DRIPSTONE_TILES.get(),
        SMBBlocks.CRACKED_EMERALD_BRICKS.get(), SMBBlocks.CRACKED_END_STONE_BRICKS.get(),
        SMBBlocks.CRACKED_END_STONE_TILES.get(), SMBBlocks.CRACKED_GOLD_BRICKS.get(),
        SMBBlocks.CRACKED_GRANITE_BRICKS.get(), SMBBlocks.CRACKED_GRANITE_TILES.get(),
        SMBBlocks.CRACKED_IRON_BRICKS.get(), SMBBlocks.CRACKED_LAPIS_BRICKS.get(),
        SMBBlocks.CRACKED_MUD_BRICKS.get(), SMBBlocks.CRACKED_MUD_TILES.get(),
        SMBBlocks.CRACKED_NETHERITE_BRICKS.get(), SMBBlocks.CRACKED_POLISHED_BLACKSTONE_TILES.get(),
        SMBBlocks.CRACKED_PRISMARINE_BRICKS.get(), SMBBlocks.CRACKED_PRISMARINE_TILES.get(),
        SMBBlocks.CRACKED_PURPUR_BLOCK.get(), SMBBlocks.CRACKED_PURPUR_TILES.get(),
        SMBBlocks.CRACKED_QUARTZ_BRICKS.get(), SMBBlocks.CRACKED_RED_NETHER_BRICKS.get(),
        SMBBlocks.CRACKED_RED_SANDSTONE_BRICKS.get(), SMBBlocks.CRACKED_RED_SANDSTONE_TILES.get(),
        SMBBlocks.CRACKED_REDSTONE_BRICKS.get(), SMBBlocks.CRACKED_SANDSTONE_BRICKS.get(),
        SMBBlocks.CRACKED_SANDSTONE_TILES.get(), SMBBlocks.CRACKED_SOUL_SANDSTONE_BRICKS.get(),
        SMBBlocks.CRACKED_SOUL_SANDSTONE_TILES.get(), SMBBlocks.CRACKED_STONE_TILES.get(),
        SMBBlocks.CRACKED_TUFF_BRICKS.get(), SMBBlocks.CRACKED_TUFF_TILES.get(),
        SMBBlocks.CUT_AMETHYST.get(), SMBBlocks.CUT_COAL.get(),
        SMBBlocks.CUT_DIAMOND.get(), SMBBlocks.CUT_EMERALD.get(),
        SMBBlocks.CUT_GOLD.get(), SMBBlocks.CUT_IRON.get(),
        SMBBlocks.CUT_LAPIS.get(), SMBBlocks.CUT_NETHERITE.get(),
        SMBBlocks.CUT_QUARTZ.get(), SMBBlocks.CUT_REDSTONE.get(),
        SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.get(), SMBBlocks.CUT_SOUL_SANDSTONE.get(),
        SMBBlocks.DEEPSLATE_PILLAR.get(), SMBBlocks.DIAMOND_BRICKS.get(),
        SMBBlocks.DIAMOND_GRATE.get(), SMBBlocks.DIAMOND_PILLAR.get(),
        SMBBlocks.DIORITE_BRICK_SLAB.get(), SMBBlocks.DIORITE_BRICK_STAIRS.get(),
        SMBBlocks.DIORITE_BRICK_WALL.get(), SMBBlocks.DIORITE_BRICKS.get(),
        SMBBlocks.DIORITE_PILLAR.get(), SMBBlocks.DIORITE_TILE_SLAB.get(),
        SMBBlocks.DIORITE_TILE_STAIRS.get(), SMBBlocks.DIORITE_TILE_WALL.get(),
        SMBBlocks.DIORITE_TILES.get(), SMBBlocks.DRIPSTONE_BRICK_SLAB.get(),
        SMBBlocks.DRIPSTONE_BRICK_STAIRS.get(), SMBBlocks.DRIPSTONE_BRICK_WALL.get(),
        SMBBlocks.DRIPSTONE_BRICKS.get(), SMBBlocks.DRIPSTONE_PILLAR.get(),
        SMBBlocks.DRIPSTONE_TILE_SLAB.get(), SMBBlocks.DRIPSTONE_TILE_STAIRS.get(),
        SMBBlocks.DRIPSTONE_TILE_WALL.get(), SMBBlocks.DRIPSTONE_TILES.get(),
        SMBBlocks.EMERALD_BRICKS.get(), SMBBlocks.EMERALD_PILLAR.get(),
        SMBBlocks.END_STONE_PILLAR.get(), SMBBlocks.END_STONE_TILE_SLAB.get(),
        SMBBlocks.END_STONE_TILE_STAIRS.get(), SMBBlocks.END_STONE_TILE_WALL.get(),
        SMBBlocks.END_STONE_TILES.get(), SMBBlocks.GOLD_BRICKS.get(),
        SMBBlocks.GOLD_PILLAR.get(), SMBBlocks.GRANITE_BRICK_SLAB.get(),
        SMBBlocks.GRANITE_BRICK_STAIRS.get(), SMBBlocks.GRANITE_BRICK_WALL.get(),
        SMBBlocks.GRANITE_BRICKS.get(), SMBBlocks.GRANITE_PILLAR.get(),
        SMBBlocks.GRANITE_TILE_SLAB.get(), SMBBlocks.GRANITE_TILE_STAIRS.get(),
        SMBBlocks.GRANITE_TILE_WALL.get(), SMBBlocks.GRANITE_TILES.get(),
        SMBBlocks.IRON_BRICKS.get(), SMBBlocks.IRON_GRATE.get(),
        SMBBlocks.IRON_PILLAR.get(), SMBBlocks.LAPIS_BRICKS.get(),
        SMBBlocks.LAPIS_PILLAR.get(), SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_ANDESITE_BRICKS.get(), SMBBlocks.MOSSY_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_BRICK_STAIRS.get(), SMBBlocks.MOSSY_BRICK_WALL.get(),
        SMBBlocks.MOSSY_BRICKS.get(), SMBBlocks.MOSSY_CALCITE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_CALCITE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_CALCITE_BRICKS.get(), SMBBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get(), SMBBlocks.MOSSY_DIORITE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_DIORITE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_DIORITE_BRICKS.get(), SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get(), SMBBlocks.MOSSY_END_STONE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_END_STONE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_END_STONE_BRICKS.get(), SMBBlocks.MOSSY_GRANITE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_GRANITE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_GRANITE_BRICKS.get(), SMBBlocks.MOSSY_MUD_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_MUD_BRICK_STAIRS.get(), SMBBlocks.MOSSY_MUD_BRICK_WALL.get(),
        SMBBlocks.MOSSY_MUD_BRICKS.get(), SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_PRISMARINE_BRICKS.get(), SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB.get(),
        SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS.get(), SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.get(),
        SMBBlocks.MOSSY_PURPUR_BLOCK.get(), SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get(), SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS.get(), SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.get(),
        SMBBlocks.MOSSY_SANDSTONE_BRICKS.get(), SMBBlocks.MOSSY_TUFF_BRICK_SLAB.get(),
        SMBBlocks.MOSSY_TUFF_BRICK_STAIRS.get(), SMBBlocks.MOSSY_TUFF_BRICK_WALL.get(),
        SMBBlocks.MOSSY_TUFF_BRICKS.get(), SMBBlocks.MUD_PILLAR.get(),
        SMBBlocks.MUD_TILE_SLAB.get(), SMBBlocks.MUD_TILE_STAIRS.get(),
        SMBBlocks.MUD_TILE_WALL.get(), SMBBlocks.MUD_TILES.get(),
        SMBBlocks.NETHER_BRICKS_PILLAR.get(), SMBBlocks.NETHERITE_BRICKS.get(),
        SMBBlocks.NETHERITE_GRATE.get(), SMBBlocks.NETHERITE_PILLAR.get(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB.get(), SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS.get(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.get(), SMBBlocks.POLISHED_BLACKSTONE_TILES.get(),
        SMBBlocks.POLISHED_CALCITE_SLAB.get(), SMBBlocks.POLISHED_CALCITE_STAIRS.get(),
        SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.POLISHED_DRIPSTONE_SLAB.get(),
        SMBBlocks.POLISHED_DRIPSTONE_STAIRS.get(), SMBBlocks.POLISHED_DRIPSTONE.get(),
        SMBBlocks.POLISHED_END_STONE_SLAB.get(), SMBBlocks.POLISHED_END_STONE_STAIRS.get(),
        SMBBlocks.POLISHED_END_STONE.get(), SMBBlocks.POLISHED_MUD_SLAB.get(),
        SMBBlocks.POLISHED_MUD_STAIRS.get(), SMBBlocks.POLISHED_MUD.get(),
        SMBBlocks.POLISHED_PRISMARINE_SLAB.get(), SMBBlocks.POLISHED_PRISMARINE_STAIRS.get(),
        SMBBlocks.POLISHED_PRISMARINE.get(), SMBBlocks.POLISHED_PURPUR_SLAB.get(),
        SMBBlocks.POLISHED_PURPUR_STAIRS.get(), SMBBlocks.POLISHED_PURPUR.get(),
        SMBBlocks.POLISHED_STONE_SLAB.get(), SMBBlocks.POLISHED_STONE_STAIRS.get(),
        SMBBlocks.POLISHED_STONE.get(), SMBBlocks.PRISMARINE_PILLAR.get(),
        SMBBlocks.PRISMARINE_TILE_SLAB.get(), SMBBlocks.PRISMARINE_TILE_STAIRS.get(),
        SMBBlocks.PRISMARINE_TILE_WALL.get(), SMBBlocks.PRISMARINE_TILES.get(),
        SMBBlocks.PURPUR_TILE_SLAB.get(), SMBBlocks.PURPUR_TILE_STAIRS.get(),
        SMBBlocks.PURPUR_TILE_WALL.get(), SMBBlocks.PURPUR_TILES.get(),
        SMBBlocks.RED_NETHER_BRICKS_PILLAR.get(), SMBBlocks.RED_SANDSTONE_BRICK_SLAB.get(),
        SMBBlocks.RED_SANDSTONE_BRICK_STAIRS.get(), SMBBlocks.RED_SANDSTONE_BRICK_WALL.get(),
        SMBBlocks.RED_SANDSTONE_BRICKS.get(), SMBBlocks.RED_SANDSTONE_PILLAR.get(),
        SMBBlocks.RED_SANDSTONE_TILE_SLAB.get(), SMBBlocks.RED_SANDSTONE_TILE_STAIRS.get(),
        SMBBlocks.RED_SANDSTONE_TILE_WALL.get(), SMBBlocks.RED_SANDSTONE_TILES.get(),
        SMBBlocks.REDSTONE_BRICKS.get(), SMBBlocks.REDSTONE_PILLAR.get(),
        SMBBlocks.SANDSTONE_BRICK_SLAB.get(), SMBBlocks.SANDSTONE_BRICK_STAIRS.get(),
        SMBBlocks.SANDSTONE_BRICK_WALL.get(), SMBBlocks.SANDSTONE_BRICKS.get(),
        SMBBlocks.SANDSTONE_PILLAR.get(), SMBBlocks.SANDSTONE_TILE_SLAB.get(),
        SMBBlocks.SANDSTONE_TILE_STAIRS.get(), SMBBlocks.SANDSTONE_TILE_WALL.get(),
        SMBBlocks.SANDSTONE_TILES.get(), SMBBlocks.SMOOTH_ANDESITE_SLAB.get(),
        SMBBlocks.SMOOTH_ANDESITE.get(), SMBBlocks.SMOOTH_BLACKSTONE_SLAB.get(),
        SMBBlocks.SMOOTH_BLACKSTONE.get(), SMBBlocks.SMOOTH_CALCITE_SLAB.get(),
        SMBBlocks.SMOOTH_CALCITE.get(), SMBBlocks.SMOOTH_DEEPSLATE_SLAB.get(),
        SMBBlocks.SMOOTH_DEEPSLATE.get(), SMBBlocks.SMOOTH_DIORITE_SLAB.get(),
        SMBBlocks.SMOOTH_DIORITE.get(), SMBBlocks.SMOOTH_DRIPSTONE_SLAB.get(),
        SMBBlocks.SMOOTH_DRIPSTONE.get(), SMBBlocks.SMOOTH_END_STONE_SLAB.get(),
        SMBBlocks.SMOOTH_END_STONE.get(), SMBBlocks.SMOOTH_GRANITE_SLAB.get(),
        SMBBlocks.SMOOTH_GRANITE.get(), SMBBlocks.SMOOTH_MUD_SLAB.get(),
        SMBBlocks.SMOOTH_MUD.get(), SMBBlocks.SMOOTH_PRISMARINE_SLAB.get(),
        SMBBlocks.SMOOTH_PRISMARINE.get(), SMBBlocks.SMOOTH_PURPUR_SLAB.get(),
        SMBBlocks.SMOOTH_PURPUR.get(), SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get(),
        SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get(), SMBBlocks.SMOOTH_SOUL_SANDSTONE.get(),
        SMBBlocks.SMOOTH_TUFF_SLAB.get(), SMBBlocks.SMOOTH_TUFF.get(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB.get(), SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS.get(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get(),
        SMBBlocks.SOUL_SANDSTONE_PILLAR.get(), SMBBlocks.SOUL_SANDSTONE_SLAB.get(),
        SMBBlocks.SOUL_SANDSTONE_STAIRS.get(), SMBBlocks.SOUL_SANDSTONE_TILE_SLAB.get(),
        SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS.get(), SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get(),
        SMBBlocks.SOUL_SANDSTONE_TILES.get(), SMBBlocks.SOUL_SANDSTONE_WALL.get(),
        SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.STONE_PILLAR.get(),
        SMBBlocks.STONE_TILE_SLAB.get(), SMBBlocks.STONE_TILE_STAIRS.get(),
        SMBBlocks.STONE_TILE_WALL.get(), SMBBlocks.STONE_TILES.get(),
        SMBBlocks.TUFF_PILLAR.get(), SMBBlocks.TUFF_TILE_SLAB.get(),
        SMBBlocks.TUFF_TILE_STAIRS.get(), SMBBlocks.TUFF_TILE_WALL.get(),
        SMBBlocks.TUFF_TILES.get(), SMBBlocks.COPPER_BRICKS.get(),
        SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get(),
        SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.CRACKED_COPPER_BRICKS.get(),
        SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(),
        SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.CRACKED_CUT_COPPER.get(),
        SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(),
        SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.COPPER_PILLAR.get(),
        SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get(),
        SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_BRICKS.get(),
        SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get(),
        SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get(),
        SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get(),
        SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get(),
        SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get(),
        SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_COPPER_PILLAR.get(),
        SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(),
        SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.POLISHED_RESIN.get(),
        SMBBlocks.POLISHED_RESIN_STAIRS.get(), SMBBlocks.POLISHED_RESIN_SLAB.get(),
        SMBBlocks.CRACKED_RESIN_BRICKS.get(), SMBBlocks.RESIN_PILLAR.get(),
        SMBBlocks.RESIN_TILES.get(), SMBBlocks.CRACKED_RESIN_TILES.get(),
        SMBBlocks.RESIN_TILE_STAIRS.get(), SMBBlocks.RESIN_TILE_SLAB.get(),
        SMBBlocks.RESIN_TILE_WALL.get(), SMBBlocks.SMOOTH_RESIN.get(),
        SMBBlocks.SMOOTH_RESIN_SLAB.get()
      );

    getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).setReplace(false)
        .add(
          SMBBlocks.PACKED_SNOW.get(), SMBBlocks.PACKED_SNOW_STAIRS.get(), SMBBlocks.PACKED_SNOW_SLAB.get(),
          SMBBlocks.POLISHED_SNOW.get(), SMBBlocks.POLISHED_SNOW_STAIRS.get(), SMBBlocks.POLISHED_SNOW_SLAB.get(),
          SMBBlocks.SNOW_BRICKS.get(), SMBBlocks.CRACKED_SNOW_BRICKS.get(), SMBBlocks.SNOW_BRICK_STAIRS.get(),
          SMBBlocks.SNOW_BRICK_SLAB.get(), SMBBlocks.SNOW_BRICK_WALL.get(), SMBBlocks.SNOW_PILLAR.get(),
          SMBBlocks.SNOW_TILES.get(), SMBBlocks.CRACKED_SNOW_TILES.get(), SMBBlocks.SNOW_TILE_STAIRS.get(),
          SMBBlocks.SNOW_TILE_SLAB.get(), SMBBlocks.SNOW_TILE_WALL.get()
        );

    getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).setReplace(false)
        .add(
          SMBBlocks.IRON_BRICKS.get(), SMBBlocks.CRACKED_SNOW_BRICKS.get(), SMBBlocks.IRON_PILLAR.get(),
          SMBBlocks.CUT_IRON.get(), SMBBlocks.CRACKED_CUT_IRON.get(), SMBBlocks.IRON_GRATE.get(),
          SMBBlocks.LAPIS_BRICKS.get(), SMBBlocks.CRACKED_LAPIS_BRICKS.get(), SMBBlocks.LAPIS_PILLAR.get(),
          SMBBlocks.CUT_LAPIS.get(), SMBBlocks.CRACKED_CUT_LAPIS.get(),
          SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.CRACKED_CUT_COPPER.get(),
          SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(),
          SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(),
          SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(),
          SMBBlocks.WAXED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_PILLAR.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get(),
          SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get(),
          SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get(),
          SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get()
        );

    getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).setReplace(false)
      .add(
        SMBBlocks.GOLD_BRICKS.get(), SMBBlocks.CRACKED_GOLD_BRICKS.get(), SMBBlocks.GOLD_PILLAR.get(),
        SMBBlocks.CUT_GOLD.get(), SMBBlocks.CRACKED_CUT_GOLD.get(),
        SMBBlocks.EMERALD_BRICKS.get(), SMBBlocks.CRACKED_EMERALD_BRICKS.get(), SMBBlocks.EMERALD_PILLAR.get(),
        SMBBlocks.CUT_EMERALD.get(), SMBBlocks.CRACKED_CUT_EMERALD.get(),
        SMBBlocks.DIAMOND_BRICKS.get(), SMBBlocks.CRACKED_DIAMOND_BRICKS.get(), SMBBlocks.DIAMOND_PILLAR.get(),
        SMBBlocks.CUT_DIAMOND.get(), SMBBlocks.CRACKED_CUT_DIAMOND.get(), SMBBlocks.DIAMOND_GRATE.get()
      );

    getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).setReplace(false)
      .add(
        SMBBlocks.NETHERITE_BRICKS.get(), SMBBlocks.CRACKED_NETHERITE_BRICKS.get(), SMBBlocks.NETHERITE_PILLAR.get(),
        SMBBlocks.CUT_NETHERITE.get(), SMBBlocks.CRACKED_CUT_NETHERITE.get(), SMBBlocks.NETHERITE_GRATE.get()
      );

    getOrCreateTagBuilder(BlockTags.PALE_OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_PALE_OAK_LOG.get(), SMBBlocks.CARVED_PALE_OAK_WOOD.get());
  }
}
