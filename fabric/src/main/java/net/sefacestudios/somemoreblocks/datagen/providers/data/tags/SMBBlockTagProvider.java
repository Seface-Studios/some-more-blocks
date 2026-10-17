package net.sefacestudios.somemoreblocks.datagen.providers.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockIds;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
import net.sefacestudios.somemoreblocks.references.SMBBlockIds;
import net.sefacestudios.somemoreblocks.references.SMBBlockItemIds;
import net.sefacestudios.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SMBBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
  public SMBBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, future);
  }

  @Override
  protected void addTags(@NotNull HolderLookup.Provider provider) {
    this.builder(SMBBlockTags.CATTAIL_PLACEABLE)
      .addOptionalTag(BlockTags.DIRT)
      .addOptionalTag(BlockTags.SAND)
      .add(BlockItemIds.MUD, BlockItemIds.MUDDY_MANGROVE_ROOTS, BlockItemIds.CLAY, BlockItemIds.GRAVEL);

    this.builder(SMBBlockTags.CATTAIL_ON_WATER_PLACEABLE)
      .addOptionalTag(SMBBlockTags.CATTAIL_PLACEABLE);

    this.builder(SMBBlockTags.DUNE_GRASS_PLACEABLE)
      .addOptionalTag(BlockTags.DIRT)
      .addOptionalTag(BlockTags.SAND);

    this.builder(SMBBlockTags.LARKSPUR_PLACEABLE)
      .addOptionalTag(BlockTags.SUPPORTS_VEGETATION);

    this.builder(SMBBlockTags.LEAF_LITTERS_PLACEABLE).add(BlockItemIds.DIRT_PATH, BlockItemIds.FARMLAND, BlockItemIds.MUD);

    this.builder(SMBBlockTags.LEAF_LITTER_REPLACEABLE)
      .add(
        BlockItemIds.DEAD_BUSH.block(), BlockItemIds.FERN.block(),
        BlockItemIds.SHORT_GRASS.block(), BlockItemIds.VINE.block(),
        BlockItemIds.MOSS_CARPET.block(), BlockItemIds.PALE_MOSS_CARPET.block(),
        SMBBlockItemIds.DUNE_GRASS.block(), SMBBlockItemIds.SNOW_FERN.block(),
        SMBBlockItemIds.SHORT_SNOW_GRASS.block(), BlockItemIds.LEAF_LITTER.block());

    this.builder(SMBBlockTags.MUSHROOM_COLONY_PLACEABLE)
      .addOptionalTag(BlockTags.DIRT)
      .addOptionalTag(BlockTags.LOGS)
      .add(BlockItemIds.MUSHROOM_STEM)
      .add(
        BlockItemIds.MANGROVE_ROOTS, BlockItemIds.MUDDY_MANGROVE_ROOTS,
        BlockItemIds.CRIMSON_NYLIUM, BlockItemIds.WARPED_NYLIUM, BlockItemIds.CREAKING_HEART);

    this.builder(SMBBlockTags.SHINGLES)
      .add(SMBBlockItemIds.SHINGLES)
      .addAll(SMBBlockItemIds.DYED_SHINGLES.map(BlockItemId::block));

    this.builder(SMBBlockTags.TERRACOTTA_BRICKS)
      .add(SMBBlockItemIds.TERRACOTTA_BRICKS)
      .addAll(SMBBlockItemIds.DYED_TERRACOTTA_BRICKS.map(BlockItemId::block));

    this.builder(SMBBlockTags.TERRACOTTA_TILES)
      .add(SMBBlockItemIds.TERRACOTTA_TILES)
      .addAll(SMBBlockItemIds.DYED_TERRACOTTA_TILES.map(BlockItemId::block));

    this.builder(SMBBlockTags.CONCRETE_BRICKS)
      .addAll(SMBBlockItemIds.CONCRETE_BRICKS.map(BlockItemId::block));

    this.builder(SMBBlockTags.CONCRETE_TILES)
      .addAll(SMBBlockItemIds.CONCRETE_TILES.map(BlockItemId::block));

    this.builder(SMBBlockTags.CACTUS_PLANTS_PLACEABLE)
      .addOptionalTag(BlockTags.DIRT)
      .addOptionalTag(BlockTags.SAND)
      .addOptionalTag(BlockTags.TERRACOTTA)
      .addOptionalTag(SMBBlockTags.TERRACOTTA_BRICKS)
      .addOptionalTag(SMBBlockTags.TERRACOTTA_TILES)
      .addOptionalTag(SMBBlockTags.SHINGLES);

    this.builder(SMBBlockTags.LEAF_LITTERS)
      .add(
        SMBBlockIds.LEAF_LITTER, SMBBlockIds.AZALEA_LEAF_LITTER,
        SMBBlockIds.BIRCH_LEAF_LITTER, SMBBlockIds.SPRUCE_LEAF_LITTER,
        SMBBlockIds.PALE_OAK_LEAF_LITTER, SMBBlockIds.FLOWERING_AZALEA_LEAF_LITTER);

    addToVanillaTags();
  }

  private void addToVanillaTags() {
    this.builder(BlockTags.LOGS)
      .add(SMBBlockItemIds.CARVED_ACACIA_LOG, SMBBlockItemIds.CARVED_ACACIA_WOOD)
      .add(SMBBlockItemIds.CARVED_BIRCH_LOG, SMBBlockItemIds.CARVED_BIRCH_WOOD)
      .add(SMBBlockItemIds.CARVED_CHERRY_LOG, SMBBlockItemIds.CARVED_CHERRY_WOOD)
      .add(SMBBlockItemIds.CARVED_CRIMSON_STEM, SMBBlockItemIds.CARVED_CRIMSON_HYPHAE)
      .add(SMBBlockItemIds.CARVED_DARK_OAK_LOG, SMBBlockItemIds.CARVED_DARK_OAK_WOOD)
      .add(SMBBlockItemIds.CARVED_MANGROVE_LOG, SMBBlockItemIds.CARVED_MANGROVE_WOOD)
      .add(SMBBlockItemIds.CARVED_OAK_LOG, SMBBlockItemIds.CARVED_OAK_WOOD)
      .add(SMBBlockItemIds.CARVED_SPRUCE_LOG, SMBBlockItemIds.CARVED_SPRUCE_WOOD)
      .add(SMBBlockItemIds.CARVED_WARPED_STEM, SMBBlockItemIds.CARVED_WARPED_HYPHAE)
      .setReplace(false);

    this.builder(BlockTags.BAMBOO_BLOCKS)
      .add(SMBBlockItemIds.CARVED_BAMBOO_BLOCK)
      .setReplace(false);

    /*this.builder(BlockTags.BIRCH_LOGS)
      .setReplace(false);

    this.builder(BlockTags.CHERRY_LOGS)
      .setReplace(false);

    this.builder(BlockTags.CRIMSON_STEMS)
      .setReplace(false);

    this.builder(BlockTags.DARK_OAK_LOGS)
      .setReplace(false);
*/
    this.builder(BlockTags.FLOWER_POTS)
      .add(
        SMBBlockIds.POTTED_LUMINOUS_FLOWER,
        SMBBlockIds.POTTED_SNOW_FERN,
        SMBBlockIds.POTTED_TINY_CACTUS,
        SMBBlockIds.POTTED_SHORT_GALAHAD_LARKSPUR,
        SMBBlockIds.POTTED_SHORT_ASTOLAT_LARKSPUR,
        SMBBlockIds.POTTED_SHORT_SUMMER_SKIES_LARKSPUR,
        SMBBlockIds.POTTED_SHORT_PURPLE_LARKSPUR,
        SMBBlockIds.POTTED_SHORT_RED_LARK_LARKSPUR
      )
      .setReplace(false);

    this.builder(BlockTags.ICE)
      .add(
        SMBBlockItemIds.POLISHED_ICE, SMBBlockItemIds.POLISHED_ICE_STAIRS,
        SMBBlockItemIds.POLISHED_ICE_SLAB, SMBBlockItemIds.ICE_BRICKS,
        SMBBlockItemIds.CRACKED_ICE_BRICKS, SMBBlockItemIds.ICE_BRICK_STAIRS,
        SMBBlockItemIds.ICE_BRICK_SLAB, SMBBlockItemIds.ICE_BRICK_WALL,
        SMBBlockItemIds.ICE_PILLAR, SMBBlockItemIds.ICE_TILES,
        SMBBlockItemIds.CRACKED_ICE_TILES, SMBBlockItemIds.ICE_TILE_STAIRS,
        SMBBlockItemIds.ICE_TILE_SLAB, SMBBlockItemIds.ICE_TILE_WALL)
      .setReplace(false);

    this.builder(BlockTags.IMPERMEABLE)
      .add(
        SMBBlockItemIds.TILED_GLASS, SMBBlockItemIds.TILED_TINTED_GLASS)
      .addAll(SMBBlockItemIds.STAINED_TILED_GLASS.map(BlockItemId::block))
      .setReplace(false);

    this.builder(BlockTags.JUNGLE_LOGS)
      .add(SMBBlockItemIds.CARVED_JUNGLE_LOG, SMBBlockItemIds.CARVED_JUNGLE_WOOD)
      .setReplace(false);

    /*this.builder(BlockTags.MANGROVE_LOGS)
      .setReplace(false);

    this.builder(BlockTags.OAK_LOGS)
      .setReplace(false);*/

    this.builder(BlockTags.PALE_OAK_LOGS)
      .add(SMBBlockIds.CARVED_PALE_OAK_LOG, SMBBlockIds.CARVED_PALE_OAK_WOOD)
      .setReplace(false);

    this.builder(BlockTags.PLANKS)
      .add(
        SMBBlockItemIds.OAK_BOARDS,
        SMBBlockItemIds.OAK_SLATS,
        SMBBlockItemIds.OAK_MOSAIC,
        SMBBlockItemIds.SPRUCE_BOARDS,
        SMBBlockItemIds.SPRUCE_SLATS,
        SMBBlockItemIds.SPRUCE_MOSAIC,
        SMBBlockItemIds.BIRCH_BOARDS,
        SMBBlockItemIds.BIRCH_SLATS,
        SMBBlockItemIds.BIRCH_MOSAIC,
        SMBBlockItemIds.JUNGLE_BOARDS,
        SMBBlockItemIds.JUNGLE_SLATS,
        SMBBlockItemIds.JUNGLE_MOSAIC,
        SMBBlockItemIds.ACACIA_BOARDS,
        SMBBlockItemIds.ACACIA_SLATS,
        SMBBlockItemIds.ACACIA_MOSAIC,
        SMBBlockItemIds.DARK_OAK_BOARDS,
        SMBBlockItemIds.DARK_OAK_SLATS,
        SMBBlockItemIds.DARK_OAK_MOSAIC,
        SMBBlockItemIds.MANGROVE_BOARDS,
        SMBBlockItemIds.MANGROVE_SLATS,
        SMBBlockItemIds.MANGROVE_MOSAIC,
        SMBBlockItemIds.CRIMSON_BOARDS,
        SMBBlockItemIds.CRIMSON_SLATS,
        SMBBlockItemIds.CRIMSON_MOSAIC,
        SMBBlockItemIds.WARPED_BOARDS,
        SMBBlockItemIds.WARPED_SLATS,
        SMBBlockItemIds.WARPED_MOSAIC,
        SMBBlockItemIds.CHERRY_BOARDS,
        SMBBlockItemIds.CHERRY_SLATS,
        SMBBlockItemIds.CHERRY_MOSAIC,
        SMBBlockItemIds.PALE_OAK_BOARDS,
        SMBBlockItemIds.PALE_OAK_SLATS,
        SMBBlockItemIds.PALE_OAK_MOSAIC,
        SMBBlockItemIds.BAMBOO_BOARDS,
        SMBBlockItemIds.BAMBOO_SLATS
      )
      .setReplace(false);

    this.builder(BlockTags.REPLACEABLE_BY_TREES)
      .addOptionalTag(SMBBlockTags.LEAF_LITTERS)
      .add(
        SMBBlockItemIds.DUNE_GRASS, SMBBlockItemIds.TALL_DUNE_GRASS,
        SMBBlockItemIds.SHORT_SNOW_GRASS, SMBBlockItemIds.TALL_SNOW_GRASS,
        SMBBlockItemIds.SNOW_FERN, SMBBlockItemIds.LARGE_SNOW_FERN,
        SMBBlockItemIds.CATTAIL)
      .setReplace(false);

    this.builder(BlockTags.REPLACEABLE)
      .addOptionalTag(SMBBlockTags.LEAF_LITTERS)
      .add(
        SMBBlockItemIds.DUNE_GRASS, SMBBlockItemIds.TALL_DUNE_GRASS,
        SMBBlockItemIds.SHORT_SNOW_GRASS, SMBBlockItemIds.TALL_SNOW_GRASS,
        SMBBlockItemIds.SNOW_FERN, SMBBlockItemIds.LARGE_SNOW_FERN,
        SMBBlockItemIds.CATTAIL)
      .setReplace(false);

    this.builder(BlockTags.SLABS)
      .add(
        SMBBlockItemIds.PACKED_SNOW_SLAB, SMBBlockItemIds.POLISHED_SNOW_SLAB,
        SMBBlockItemIds.SNOW_BRICK_SLAB, SMBBlockItemIds.SNOW_TILE_SLAB,
        SMBBlockItemIds.SMOOTH_DEEPSLATE_SLAB, SMBBlockItemIds.MOSSY_DEEPSLATE_BRICK_SLAB,
        SMBBlockItemIds.POLISHED_STONE_SLAB, SMBBlockItemIds.STONE_TILE_SLAB,
        SMBBlockItemIds.SMOOTH_GRANITE_SLAB, SMBBlockItemIds.GRANITE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_GRANITE_BRICK_SLAB, SMBBlockItemIds.GRANITE_TILE_SLAB,
        SMBBlockItemIds.SMOOTH_DIORITE_SLAB, SMBBlockItemIds.DIORITE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_DIORITE_BRICK_SLAB, SMBBlockItemIds.DIORITE_TILE_SLAB,
        SMBBlockItemIds.SMOOTH_ANDESITE_SLAB, SMBBlockItemIds.ANDESITE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_ANDESITE_BRICK_SLAB, SMBBlockItemIds.ANDESITE_TILE_SLAB,
        SMBBlockItemIds.POLISHED_END_STONE_SLAB, SMBBlockItemIds.SMOOTH_END_STONE_SLAB,
        SMBBlockItemIds.MOSSY_END_STONE_BRICK_SLAB, SMBBlockItemIds.END_STONE_TILE_SLAB,
        SMBBlockItemIds.SMOOTH_TUFF_SLAB, SMBBlockItemIds.MOSSY_TUFF_BRICK_SLAB,
        SMBBlockItemIds.TUFF_TILE_SLAB, SMBBlockItemIds.RED_SANDSTONE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_RED_SANDSTONE_BRICK_SLAB, SMBBlockItemIds.RED_SANDSTONE_TILE_SLAB,
        SMBBlockItemIds.POLISHED_CALCITE_SLAB, SMBBlockItemIds.SMOOTH_CALCITE_SLAB,
        SMBBlockItemIds.CALCITE_BRICK_SLAB, SMBBlockItemIds.MOSSY_CALCITE_BRICK_SLAB,
        SMBBlockItemIds.CALCITE_TILE_SLAB, SMBBlockItemIds.POLISHED_DRIPSTONE_SLAB,
        SMBBlockItemIds.SMOOTH_DRIPSTONE_SLAB, SMBBlockItemIds.DRIPSTONE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_DRIPSTONE_BRICK_SLAB, SMBBlockItemIds.DRIPSTONE_TILE_SLAB,
        SMBBlockItemIds.POLISHED_PRISMARINE_SLAB, SMBBlockItemIds.SMOOTH_PRISMARINE_SLAB,
        SMBBlockItemIds.MOSSY_PRISMARINE_BRICK_SLAB, SMBBlockItemIds.PRISMARINE_TILE_SLAB,
        SMBBlockItemIds.SMOOTH_BLACKSTONE_SLAB, SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB,
        SMBBlockItemIds.POLISHED_BLACKSTONE_TILE_SLAB, SMBBlockItemIds.POLISHED_MUD_SLAB,
        SMBBlockItemIds.SMOOTH_MUD_SLAB, SMBBlockItemIds.MOSSY_MUD_BRICK_SLAB,
        SMBBlockItemIds.MUD_TILE_SLAB, SMBBlockItemIds.SANDSTONE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_SANDSTONE_BRICK_SLAB, SMBBlockItemIds.SANDSTONE_TILE_SLAB,
        SMBBlockItemIds.POLISHED_ICE_SLAB, SMBBlockItemIds.ICE_BRICK_SLAB,
        SMBBlockItemIds.ICE_TILE_SLAB, SMBBlockItemIds.POLISHED_PURPUR_SLAB,
        SMBBlockItemIds.SMOOTH_PURPUR_SLAB, SMBBlockItemIds.MOSSY_PURPUR_BLOCK_SLAB,
        SMBBlockItemIds.PURPUR_TILE_SLAB, SMBBlockItemIds.SOUL_SANDSTONE_SLAB,
        SMBBlockItemIds.CUT_SOUL_SANDSTONE_SLAB, SMBBlockItemIds.SMOOTH_SOUL_SANDSTONE_SLAB,
        SMBBlockItemIds.SOUL_SANDSTONE_BRICK_SLAB, SMBBlockItemIds.SOUL_SANDSTONE_TILE_SLAB,
        SMBBlockItemIds.MOSSY_BRICK_SLAB, SMBBlockItemIds.BONE_BRICK_SLAB,
        SMBBlockItemIds.BONE_TILE_SLAB, SMBBlockItemIds.POLISHED_RESIN_SLAB,
        SMBBlockItemIds.RESIN_TILE_SLAB, SMBBlockItemIds.SMOOTH_RESIN_SLAB,
        SMBBlockItemIds.POLISHED_BASALT_BRICK_SLAB, SMBBlockItemIds.POLISHED_BASALT_TILE_SLAB,
        SMBBlockItemIds.CORRUPTED_POLISHED_BASALT_BRICK_SLAB
      )
      .setReplace(false);

    this.builder(BlockTags.SMALL_FLOWERS)
      .add(
        SMBBlockItemIds.LUMINOUS_FLOWER,
        SMBBlockItemIds.LAVENDER
      )
      .setReplace(false);

    this.builder(BlockTags.SNOW)
      .add(
        SMBBlockItemIds.PACKED_SNOW, SMBBlockItemIds.POLISHED_SNOW,
        SMBBlockItemIds.SNOW_BRICKS, SMBBlockItemIds.CRACKED_SNOW_BRICKS,
        SMBBlockItemIds.SNOW_PILLAR, SMBBlockItemIds.SNOW_TILES,
        SMBBlockItemIds.CRACKED_SNOW_TILES)
      .setReplace(false);

   /* this.builder(BlockTags.SPRUCE_LOGS)
      .setReplace(false);
*/
    this.builder(BlockTags.STAIRS)
      .add(
        SMBBlockItemIds.PACKED_SNOW_STAIRS, SMBBlockItemIds.POLISHED_SNOW_STAIRS,
        SMBBlockItemIds.SNOW_BRICK_STAIRS, SMBBlockItemIds.SNOW_TILE_STAIRS,
        SMBBlockItemIds.MOSSY_DEEPSLATE_BRICK_STAIRS, SMBBlockItemIds.POLISHED_STONE_STAIRS,
        SMBBlockItemIds.STONE_TILE_STAIRS, SMBBlockItemIds.GRANITE_BRICK_STAIRS,
        SMBBlockItemIds.MOSSY_GRANITE_BRICK_STAIRS, SMBBlockItemIds.GRANITE_TILE_STAIRS,
        SMBBlockItemIds.DIORITE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_DIORITE_BRICK_STAIRS,
        SMBBlockItemIds.DIORITE_TILE_STAIRS, SMBBlockItemIds.ANDESITE_BRICK_STAIRS,
        SMBBlockItemIds.MOSSY_ANDESITE_BRICK_STAIRS, SMBBlockItemIds.ANDESITE_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_END_STONE_STAIRS, SMBBlockItemIds.MOSSY_END_STONE_BRICK_STAIRS,
        SMBBlockItemIds.END_STONE_TILE_STAIRS, SMBBlockItemIds.MOSSY_TUFF_BRICK_STAIRS,
        SMBBlockItemIds.TUFF_TILE_STAIRS, SMBBlockItemIds.RED_SANDSTONE_BRICK_STAIRS,
        SMBBlockItemIds.MOSSY_RED_SANDSTONE_BRICK_STAIRS, SMBBlockItemIds.RED_SANDSTONE_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_CALCITE_STAIRS, SMBBlockItemIds.CALCITE_BRICK_STAIRS,
        SMBBlockItemIds.MOSSY_CALCITE_BRICK_STAIRS, SMBBlockItemIds.CALCITE_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_DRIPSTONE_STAIRS, SMBBlockItemIds.DRIPSTONE_BRICK_STAIRS,
        SMBBlockItemIds.MOSSY_DRIPSTONE_BRICK_STAIRS, SMBBlockItemIds.DRIPSTONE_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_PRISMARINE_STAIRS, SMBBlockItemIds.MOSSY_PRISMARINE_BRICK_STAIRS,
        SMBBlockItemIds.PRISMARINE_TILE_STAIRS, SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS,
        SMBBlockItemIds.POLISHED_BLACKSTONE_TILE_STAIRS, SMBBlockItemIds.POLISHED_MUD_STAIRS,
        SMBBlockItemIds.MOSSY_MUD_BRICK_STAIRS, SMBBlockItemIds.MUD_TILE_STAIRS,
        SMBBlockItemIds.SANDSTONE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_SANDSTONE_BRICK_STAIRS,
        SMBBlockItemIds.SANDSTONE_TILE_STAIRS, SMBBlockItemIds.POLISHED_ICE_STAIRS,
        SMBBlockItemIds.ICE_BRICK_STAIRS, SMBBlockItemIds.ICE_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_PURPUR_STAIRS, SMBBlockItemIds.MOSSY_PURPUR_BLOCK_STAIRS,
        SMBBlockItemIds.PURPUR_TILE_STAIRS, SMBBlockItemIds.SOUL_SANDSTONE_STAIRS,
        SMBBlockItemIds.SMOOTH_SOUL_SANDSTONE_STAIRS, SMBBlockItemIds.SOUL_SANDSTONE_BRICK_STAIRS,
        SMBBlockItemIds.SOUL_SANDSTONE_TILE_STAIRS, SMBBlockItemIds.MOSSY_BRICK_STAIRS,
        SMBBlockItemIds.BONE_BRICK_STAIRS, SMBBlockItemIds.BONE_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_RESIN_STAIRS, SMBBlockItemIds.RESIN_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_BASALT_BRICK_STAIRS, SMBBlockItemIds.POLISHED_BASALT_TILE_STAIRS,
        SMBBlockItemIds.CORRUPTED_POLISHED_BASALT_BRICK_STAIRS,
        SMBBlockItemIds.SHINGLES_STAIRS
      )
      .addAll(SMBBlockItemIds.DYED_SHINGLES_STAIRS.map(BlockItemId::block))
      .setReplace(false);

    this.builder(BlockTags.TERRACOTTA)
      .addOptionalTag(SMBBlockTags.TERRACOTTA_BRICKS)
      .addOptionalTag(SMBBlockTags.TERRACOTTA_TILES)
      .setReplace(false);

    this.builder(BlockTags.WALLS)
      .add(
        SMBBlockItemIds.SNOW_BRICK_WALL, SMBBlockItemIds.SNOW_TILE_WALL,
        SMBBlockItemIds.MOSSY_DEEPSLATE_BRICK_WALL, SMBBlockItemIds.STONE_TILE_WALL,
        SMBBlockItemIds.GRANITE_BRICK_WALL, SMBBlockItemIds.MOSSY_GRANITE_BRICK_WALL,
        SMBBlockItemIds.GRANITE_TILE_WALL, SMBBlockItemIds.DIORITE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_DIORITE_BRICK_WALL, SMBBlockItemIds.DIORITE_TILE_WALL,
        SMBBlockItemIds.ANDESITE_BRICK_WALL, SMBBlockItemIds.MOSSY_ANDESITE_BRICK_WALL,
        SMBBlockItemIds.ANDESITE_TILE_WALL, SMBBlockItemIds.MOSSY_END_STONE_BRICK_WALL,
        SMBBlockItemIds.END_STONE_TILE_WALL, SMBBlockItemIds.MOSSY_TUFF_BRICK_WALL,
        SMBBlockItemIds.TUFF_TILE_WALL, SMBBlockItemIds.RED_SANDSTONE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_RED_SANDSTONE_BRICK_WALL, SMBBlockItemIds.RED_SANDSTONE_TILE_WALL,
        SMBBlockItemIds.CALCITE_BRICK_WALL, SMBBlockItemIds.MOSSY_CALCITE_BRICK_WALL,
        SMBBlockItemIds.CALCITE_TILE_WALL, SMBBlockItemIds.DRIPSTONE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_DRIPSTONE_BRICK_WALL, SMBBlockItemIds.DRIPSTONE_TILE_WALL,
        SMBBlockItemIds.MOSSY_PRISMARINE_BRICK_WALL, SMBBlockItemIds.PRISMARINE_TILE_WALL,
        SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL, SMBBlockItemIds.POLISHED_BLACKSTONE_TILE_WALL,
        SMBBlockItemIds.MOSSY_MUD_BRICK_WALL, SMBBlockItemIds.MUD_TILE_WALL,
        SMBBlockItemIds.SANDSTONE_BRICK_WALL, SMBBlockItemIds.MOSSY_SANDSTONE_BRICK_WALL,
        SMBBlockItemIds.SANDSTONE_TILE_WALL, SMBBlockItemIds.ICE_BRICK_WALL,
        SMBBlockItemIds.ICE_TILE_WALL, SMBBlockItemIds.MOSSY_PURPUR_BLOCK_WALL,
        SMBBlockItemIds.PURPUR_TILE_WALL, SMBBlockItemIds.SOUL_SANDSTONE_WALL,
        SMBBlockItemIds.SOUL_SANDSTONE_BRICK_WALL, SMBBlockItemIds.SOUL_SANDSTONE_TILE_WALL,
        SMBBlockItemIds.MOSSY_BRICK_WALL, SMBBlockItemIds.BONE_BRICK_WALL,
        SMBBlockItemIds.BONE_TILE_WALL, SMBBlockItemIds.RESIN_TILE_WALL,
        SMBBlockItemIds.POLISHED_BASALT_BRICK_WALL, SMBBlockItemIds.POLISHED_BASALT_TILE_WALL,
        SMBBlockItemIds.CORRUPTED_POLISHED_BASALT_BRICK_WALL
      )
      .setReplace(false);

    /*this.builder(BlockTags.WARPED_STEMS)
      .setReplace(false);*/

    this.builder(BlockTags.WOODEN_SLABS)
      .add(
        SMBBlockItemIds.OAK_MOSAIC_SLAB, SMBBlockItemIds.SPRUCE_MOSAIC_SLAB,
        SMBBlockItemIds.BIRCH_MOSAIC_SLAB, SMBBlockItemIds.JUNGLE_MOSAIC_SLAB,
        SMBBlockItemIds.ACACIA_MOSAIC_SLAB, SMBBlockItemIds.DARK_OAK_MOSAIC_SLAB,
        SMBBlockItemIds.MANGROVE_MOSAIC_SLAB, SMBBlockItemIds.CRIMSON_MOSAIC_SLAB,
        SMBBlockItemIds.WARPED_MOSAIC_SLAB, SMBBlockItemIds.CHERRY_MOSAIC_SLAB,
        SMBBlockItemIds.PALE_OAK_MOSAIC_SLAB,
        SMBBlockItemIds.OAK_BOARDS_SLAB, SMBBlockItemIds.SPRUCE_BOARDS_SLAB,
        SMBBlockItemIds.BIRCH_BOARDS_SLAB, SMBBlockItemIds.JUNGLE_BOARDS_SLAB,
        SMBBlockItemIds.ACACIA_BOARDS_SLAB, SMBBlockItemIds.DARK_OAK_BOARDS_SLAB,
        SMBBlockItemIds.MANGROVE_BOARDS_SLAB, SMBBlockItemIds.CRIMSON_BOARDS_SLAB,
        SMBBlockItemIds.WARPED_BOARDS_SLAB, SMBBlockItemIds.CHERRY_BOARDS_SLAB,
        SMBBlockItemIds.PALE_OAK_BOARDS_SLAB, SMBBlockItemIds.BAMBOO_BOARDS_SLAB
      )
      .setReplace(false);

    this.builder(BlockTags.WOODEN_STAIRS)
      .add(
        SMBBlockItemIds.OAK_MOSAIC_STAIRS, SMBBlockItemIds.SPRUCE_MOSAIC_STAIRS,
        SMBBlockItemIds.BIRCH_MOSAIC_STAIRS, SMBBlockItemIds.JUNGLE_MOSAIC_STAIRS,
        SMBBlockItemIds.ACACIA_MOSAIC_STAIRS, SMBBlockItemIds.DARK_OAK_MOSAIC_STAIRS,
        SMBBlockItemIds.MANGROVE_MOSAIC_STAIRS, SMBBlockItemIds.CRIMSON_MOSAIC_STAIRS,
        SMBBlockItemIds.WARPED_MOSAIC_STAIRS, SMBBlockItemIds.CHERRY_MOSAIC_STAIRS,
        SMBBlockItemIds.PALE_OAK_MOSAIC_STAIRS,
        SMBBlockItemIds.OAK_BOARDS_STAIRS, SMBBlockItemIds.SPRUCE_BOARDS_STAIRS,
        SMBBlockItemIds.BIRCH_BOARDS_STAIRS, SMBBlockItemIds.JUNGLE_BOARDS_STAIRS,
        SMBBlockItemIds.ACACIA_BOARDS_STAIRS, SMBBlockItemIds.DARK_OAK_BOARDS_STAIRS,
        SMBBlockItemIds.MANGROVE_BOARDS_STAIRS, SMBBlockItemIds.CRIMSON_BOARDS_STAIRS,
        SMBBlockItemIds.WARPED_BOARDS_STAIRS, SMBBlockItemIds.CHERRY_BOARDS_STAIRS,
        SMBBlockItemIds.PALE_OAK_BOARDS_STAIRS, SMBBlockItemIds.BAMBOO_BOARDS_STAIRS
      )
      .setReplace(false);

    this.builder(BlockTags.MINEABLE_WITH_AXE)
      .add(SMBBlockItemIds.CARVED_MUSHROOM_STEM)
      .setReplace(false);

    this.builder(BlockTags.MINEABLE_WITH_PICKAXE)
      .addOptionalTag(SMBBlockTags.SHINGLES)
      .addOptionalTag(SMBBlockTags.CONCRETE_BRICKS)
      .addOptionalTag(SMBBlockTags.CONCRETE_TILES)
      .addOptionalTag(SMBBlockTags.TERRACOTTA_BRICKS)
      .addOptionalTag(SMBBlockTags.TERRACOTTA_TILES)
      .add(
        SMBBlockItemIds.AMETHYST_BRICKS, SMBBlockItemIds.AMETHYST_PILLAR,
        SMBBlockItemIds.ANDESITE_BRICK_SLAB, SMBBlockItemIds.ANDESITE_BRICK_STAIRS,
        SMBBlockItemIds.ANDESITE_BRICK_WALL, SMBBlockItemIds.ANDESITE_BRICKS,
        SMBBlockItemIds.ANDESITE_PILLAR, SMBBlockItemIds.ANDESITE_TILE_SLAB,
        SMBBlockItemIds.ANDESITE_TILE_STAIRS, SMBBlockItemIds.ANDESITE_TILE_WALL,
        SMBBlockItemIds.ANDESITE_TILES, SMBBlockItemIds.POLISHED_BLACKSTONE_PILLAR,
        SMBBlockItemIds.BONE_BRICK_SLAB, SMBBlockItemIds.BONE_BRICK_STAIRS,
        SMBBlockItemIds.BONE_BRICK_WALL, SMBBlockItemIds.BONE_BRICKS,
        SMBBlockItemIds.BONE_TILE_SLAB, SMBBlockItemIds.BONE_TILE_STAIRS,
        SMBBlockItemIds.BONE_TILE_WALL, SMBBlockItemIds.BONE_TILES,
        SMBBlockItemIds.CALCITE_BRICK_SLAB, SMBBlockItemIds.CALCITE_BRICK_STAIRS,
        SMBBlockItemIds.CALCITE_BRICK_WALL, SMBBlockItemIds.CALCITE_BRICKS,
        SMBBlockItemIds.CALCITE_PILLAR, SMBBlockItemIds.CALCITE_TILE_SLAB,
        SMBBlockItemIds.CALCITE_TILE_STAIRS, SMBBlockItemIds.CALCITE_TILE_WALL,
        SMBBlockItemIds.CALCITE_TILES, SMBBlockItemIds.CHISELED_ANDESITE_BRICKS,
        SMBBlockItemIds.CHISELED_CALCITE_BRICKS, SMBBlockItemIds.CHISELED_DIORITE_BRICKS,
        SMBBlockItemIds.CHISELED_DRIPSTONE_BRICKS, SMBBlockItemIds.CHISELED_END_STONE_BRICKS,
        SMBBlockItemIds.CHISELED_GRANITE_BRICKS, SMBBlockItemIds.CHISELED_MUD_BRICKS,
        SMBBlockItemIds.CHISELED_PRISMARINE_BRICKS, SMBBlockItemIds.CHISELED_PURPUR,
        SMBBlockItemIds.CHISELED_RED_NETHER_BRICKS, SMBBlockItemIds.CHISELED_SOUL_SANDSTONE,
        SMBBlockItemIds.COAL_BRICKS, SMBBlockItemIds.COAL_PILLAR,
        SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB, SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS,
        SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL, SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICKS,
        SMBBlockItemIds.CRACKED_AMETHYST_BRICKS, SMBBlockItemIds.CRACKED_ANDESITE_BRICKS,
        SMBBlockItemIds.CRACKED_ANDESITE_TILES, SMBBlockItemIds.CRACKED_BONE_BRICKS,
        SMBBlockItemIds.CRACKED_BONE_TILES, SMBBlockItemIds.CRACKED_BRICKS,
        SMBBlockItemIds.CRACKED_CALCITE_BRICKS, SMBBlockItemIds.CRACKED_CALCITE_TILES,
        SMBBlockItemIds.CRACKED_COAL_BRICKS, SMBBlockItemIds.CRACKED_CUT_AMETHYST,
        SMBBlockItemIds.CRACKED_CUT_COAL, SMBBlockItemIds.CRACKED_CUT_DIAMOND,
        SMBBlockItemIds.CRACKED_CUT_EMERALD, SMBBlockItemIds.CRACKED_CUT_GOLD,
        SMBBlockItemIds.CRACKED_CUT_IRON, SMBBlockItemIds.CRACKED_CUT_LAPIS,
        SMBBlockItemIds.CRACKED_CUT_NETHERITE, SMBBlockItemIds.CRACKED_CUT_QUARTZ,
        SMBBlockItemIds.CRACKED_CUT_REDSTONE, SMBBlockItemIds.CRACKED_DIAMOND_BRICKS,
        SMBBlockItemIds.CRACKED_DIORITE_BRICKS, SMBBlockItemIds.CRACKED_DIORITE_TILES,
        SMBBlockItemIds.CRACKED_DRIPSTONE_BRICKS, SMBBlockItemIds.CRACKED_DRIPSTONE_TILES,
        SMBBlockItemIds.CRACKED_EMERALD_BRICKS, SMBBlockItemIds.CRACKED_END_STONE_BRICKS,
        SMBBlockItemIds.CRACKED_END_STONE_TILES, SMBBlockItemIds.CRACKED_GOLD_BRICKS,
        SMBBlockItemIds.CRACKED_GRANITE_BRICKS, SMBBlockItemIds.CRACKED_GRANITE_TILES,
        SMBBlockItemIds.CRACKED_IRON_BRICKS, SMBBlockItemIds.CRACKED_LAPIS_BRICKS,
        SMBBlockItemIds.CRACKED_MUD_BRICKS, SMBBlockItemIds.CRACKED_MUD_TILES,
        SMBBlockItemIds.CRACKED_NETHERITE_BRICKS, SMBBlockItemIds.CRACKED_POLISHED_BLACKSTONE_TILES,
        SMBBlockItemIds.CRACKED_PRISMARINE_BRICKS, SMBBlockItemIds.CRACKED_PRISMARINE_TILES,
        SMBBlockItemIds.CRACKED_PURPUR_BLOCK, SMBBlockItemIds.CRACKED_PURPUR_TILES,
        SMBBlockItemIds.CRACKED_QUARTZ_BRICKS, SMBBlockItemIds.CRACKED_RED_NETHER_BRICKS,
        SMBBlockItemIds.CRACKED_RED_SANDSTONE_BRICKS, SMBBlockItemIds.CRACKED_RED_SANDSTONE_TILES,
        SMBBlockItemIds.CRACKED_REDSTONE_BRICKS, SMBBlockItemIds.CRACKED_SANDSTONE_BRICKS,
        SMBBlockItemIds.CRACKED_SANDSTONE_TILES, SMBBlockItemIds.CRACKED_SOUL_SANDSTONE_BRICKS,
        SMBBlockItemIds.CRACKED_SOUL_SANDSTONE_TILES, SMBBlockItemIds.CRACKED_STONE_TILES,
        SMBBlockItemIds.CRACKED_TUFF_BRICKS, SMBBlockItemIds.CRACKED_TUFF_TILES,
        SMBBlockItemIds.CUT_AMETHYST, SMBBlockItemIds.CUT_COAL,
        SMBBlockItemIds.CUT_DIAMOND, SMBBlockItemIds.CUT_EMERALD,
        SMBBlockItemIds.CUT_GOLD, SMBBlockItemIds.CUT_IRON,
        SMBBlockItemIds.CUT_LAPIS, SMBBlockItemIds.CUT_NETHERITE,
        SMBBlockItemIds.CUT_QUARTZ, SMBBlockItemIds.CUT_REDSTONE,
        SMBBlockItemIds.CUT_SOUL_SANDSTONE_SLAB, SMBBlockItemIds.CUT_SOUL_SANDSTONE,
        SMBBlockItemIds.DEEPSLATE_PILLAR, SMBBlockItemIds.DIAMOND_BRICKS,
        SMBBlockItemIds.DIAMOND_GRATE, SMBBlockItemIds.DIAMOND_PILLAR,
        SMBBlockItemIds.DIORITE_BRICK_SLAB, SMBBlockItemIds.DIORITE_BRICK_STAIRS,
        SMBBlockItemIds.DIORITE_BRICK_WALL, SMBBlockItemIds.DIORITE_BRICKS,
        SMBBlockItemIds.DIORITE_PILLAR, SMBBlockItemIds.DIORITE_TILE_SLAB,
        SMBBlockItemIds.DIORITE_TILE_STAIRS, SMBBlockItemIds.DIORITE_TILE_WALL,
        SMBBlockItemIds.DIORITE_TILES, SMBBlockItemIds.DRIPSTONE_BRICK_SLAB,
        SMBBlockItemIds.DRIPSTONE_BRICK_STAIRS, SMBBlockItemIds.DRIPSTONE_BRICK_WALL,
        SMBBlockItemIds.DRIPSTONE_BRICKS, SMBBlockItemIds.DRIPSTONE_PILLAR,
        SMBBlockItemIds.DRIPSTONE_TILE_SLAB, SMBBlockItemIds.DRIPSTONE_TILE_STAIRS,
        SMBBlockItemIds.DRIPSTONE_TILE_WALL, SMBBlockItemIds.DRIPSTONE_TILES,
        SMBBlockItemIds.EMERALD_BRICKS, SMBBlockItemIds.EMERALD_PILLAR,
        SMBBlockItemIds.END_STONE_PILLAR, SMBBlockItemIds.END_STONE_TILE_SLAB,
        SMBBlockItemIds.END_STONE_TILE_STAIRS, SMBBlockItemIds.END_STONE_TILE_WALL,
        SMBBlockItemIds.END_STONE_TILES, SMBBlockItemIds.GOLD_BRICKS,
        SMBBlockItemIds.GOLD_PILLAR, SMBBlockItemIds.GRANITE_BRICK_SLAB,
        SMBBlockItemIds.GRANITE_BRICK_STAIRS, SMBBlockItemIds.GRANITE_BRICK_WALL,
        SMBBlockItemIds.GRANITE_BRICKS, SMBBlockItemIds.GRANITE_PILLAR,
        SMBBlockItemIds.GRANITE_TILE_SLAB, SMBBlockItemIds.GRANITE_TILE_STAIRS,
        SMBBlockItemIds.GRANITE_TILE_WALL, SMBBlockItemIds.GRANITE_TILES,
        SMBBlockItemIds.IRON_BRICKS, SMBBlockItemIds.IRON_GRATE,
        SMBBlockItemIds.IRON_PILLAR, SMBBlockItemIds.LAPIS_BRICKS,
        SMBBlockItemIds.LAPIS_PILLAR, SMBBlockItemIds.MOSSY_ANDESITE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_ANDESITE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_ANDESITE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_ANDESITE_BRICKS, SMBBlockItemIds.MOSSY_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_BRICK_STAIRS, SMBBlockItemIds.MOSSY_BRICK_WALL,
        SMBBlockItemIds.MOSSY_BRICKS, SMBBlockItemIds.MOSSY_CALCITE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_CALCITE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_CALCITE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_CALCITE_BRICKS, SMBBlockItemIds.MOSSY_DEEPSLATE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_DEEPSLATE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_DEEPSLATE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_DEEPSLATE_BRICKS, SMBBlockItemIds.MOSSY_DIORITE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_DIORITE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_DIORITE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_DIORITE_BRICKS, SMBBlockItemIds.MOSSY_DRIPSTONE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_DRIPSTONE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_DRIPSTONE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_DRIPSTONE_BRICKS, SMBBlockItemIds.MOSSY_END_STONE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_END_STONE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_END_STONE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_END_STONE_BRICKS, SMBBlockItemIds.MOSSY_GRANITE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_GRANITE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_GRANITE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_GRANITE_BRICKS, SMBBlockItemIds.MOSSY_MUD_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_MUD_BRICK_STAIRS, SMBBlockItemIds.MOSSY_MUD_BRICK_WALL,
        SMBBlockItemIds.MOSSY_MUD_BRICKS, SMBBlockItemIds.MOSSY_PRISMARINE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_PRISMARINE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_PRISMARINE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_PRISMARINE_BRICKS, SMBBlockItemIds.MOSSY_PURPUR_BLOCK_SLAB,
        SMBBlockItemIds.MOSSY_PURPUR_BLOCK_STAIRS, SMBBlockItemIds.MOSSY_PURPUR_BLOCK_WALL,
        SMBBlockItemIds.MOSSY_PURPUR_BLOCK, SMBBlockItemIds.MOSSY_RED_SANDSTONE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_RED_SANDSTONE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_RED_SANDSTONE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_RED_SANDSTONE_BRICKS, SMBBlockItemIds.MOSSY_SANDSTONE_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_SANDSTONE_BRICK_STAIRS, SMBBlockItemIds.MOSSY_SANDSTONE_BRICK_WALL,
        SMBBlockItemIds.MOSSY_SANDSTONE_BRICKS, SMBBlockItemIds.MOSSY_TUFF_BRICK_SLAB,
        SMBBlockItemIds.MOSSY_TUFF_BRICK_STAIRS, SMBBlockItemIds.MOSSY_TUFF_BRICK_WALL,
        SMBBlockItemIds.MOSSY_TUFF_BRICKS, SMBBlockItemIds.MUD_PILLAR,
        SMBBlockItemIds.MUD_TILE_SLAB, SMBBlockItemIds.MUD_TILE_STAIRS,
        SMBBlockItemIds.MUD_TILE_WALL, SMBBlockItemIds.MUD_TILES,
        SMBBlockItemIds.NETHER_BRICKS_PILLAR, SMBBlockItemIds.NETHERITE_BRICKS,
        SMBBlockItemIds.NETHERITE_GRATE, SMBBlockItemIds.NETHERITE_PILLAR,
        SMBBlockItemIds.POLISHED_BLACKSTONE_TILE_SLAB, SMBBlockItemIds.POLISHED_BLACKSTONE_TILE_STAIRS,
        SMBBlockItemIds.POLISHED_BLACKSTONE_TILE_WALL, SMBBlockItemIds.POLISHED_BLACKSTONE_TILES,
        SMBBlockItemIds.POLISHED_CALCITE_SLAB, SMBBlockItemIds.POLISHED_CALCITE_STAIRS,
        SMBBlockItemIds.POLISHED_CALCITE, SMBBlockItemIds.POLISHED_DRIPSTONE_SLAB,
        SMBBlockItemIds.POLISHED_DRIPSTONE_STAIRS, SMBBlockItemIds.POLISHED_DRIPSTONE,
        SMBBlockItemIds.POLISHED_END_STONE_SLAB, SMBBlockItemIds.POLISHED_END_STONE_STAIRS,
        SMBBlockItemIds.POLISHED_END_STONE, SMBBlockItemIds.POLISHED_MUD_SLAB,
        SMBBlockItemIds.POLISHED_MUD_STAIRS, SMBBlockItemIds.POLISHED_MUD,
        SMBBlockItemIds.POLISHED_PRISMARINE_SLAB, SMBBlockItemIds.POLISHED_PRISMARINE_STAIRS,
        SMBBlockItemIds.POLISHED_PRISMARINE, SMBBlockItemIds.POLISHED_PURPUR_SLAB,
        SMBBlockItemIds.POLISHED_PURPUR_STAIRS, SMBBlockItemIds.POLISHED_PURPUR,
        SMBBlockItemIds.POLISHED_STONE_SLAB, SMBBlockItemIds.POLISHED_STONE_STAIRS,
        SMBBlockItemIds.POLISHED_STONE, SMBBlockItemIds.PRISMARINE_PILLAR,
        SMBBlockItemIds.PRISMARINE_TILE_SLAB, SMBBlockItemIds.PRISMARINE_TILE_STAIRS,
        SMBBlockItemIds.PRISMARINE_TILE_WALL, SMBBlockItemIds.PRISMARINE_TILES,
        SMBBlockItemIds.PURPUR_TILE_SLAB, SMBBlockItemIds.PURPUR_TILE_STAIRS,
        SMBBlockItemIds.PURPUR_TILE_WALL, SMBBlockItemIds.PURPUR_TILES,
        SMBBlockItemIds.RED_NETHER_BRICKS_PILLAR, SMBBlockItemIds.RED_SANDSTONE_BRICK_SLAB,
        SMBBlockItemIds.RED_SANDSTONE_BRICK_STAIRS, SMBBlockItemIds.RED_SANDSTONE_BRICK_WALL,
        SMBBlockItemIds.RED_SANDSTONE_BRICKS, SMBBlockItemIds.RED_SANDSTONE_PILLAR,
        SMBBlockItemIds.RED_SANDSTONE_TILE_SLAB, SMBBlockItemIds.RED_SANDSTONE_TILE_STAIRS,
        SMBBlockItemIds.RED_SANDSTONE_TILE_WALL, SMBBlockItemIds.RED_SANDSTONE_TILES,
        SMBBlockItemIds.REDSTONE_BRICKS, SMBBlockItemIds.REDSTONE_PILLAR,
        SMBBlockItemIds.SANDSTONE_BRICK_SLAB, SMBBlockItemIds.SANDSTONE_BRICK_STAIRS,
        SMBBlockItemIds.SANDSTONE_BRICK_WALL, SMBBlockItemIds.SANDSTONE_BRICKS,
        SMBBlockItemIds.SANDSTONE_PILLAR, SMBBlockItemIds.SANDSTONE_TILE_SLAB,
        SMBBlockItemIds.SANDSTONE_TILE_STAIRS, SMBBlockItemIds.SANDSTONE_TILE_WALL,
        SMBBlockItemIds.SANDSTONE_TILES, SMBBlockItemIds.SMOOTH_ANDESITE_SLAB,
        SMBBlockItemIds.SMOOTH_ANDESITE, SMBBlockItemIds.SMOOTH_BLACKSTONE_SLAB,
        SMBBlockItemIds.SMOOTH_BLACKSTONE, SMBBlockItemIds.SMOOTH_CALCITE_SLAB,
        SMBBlockItemIds.SMOOTH_CALCITE, SMBBlockItemIds.SMOOTH_DEEPSLATE_SLAB,
        SMBBlockItemIds.SMOOTH_DEEPSLATE, SMBBlockItemIds.SMOOTH_DIORITE_SLAB,
        SMBBlockItemIds.SMOOTH_DIORITE, SMBBlockItemIds.SMOOTH_DRIPSTONE_SLAB,
        SMBBlockItemIds.SMOOTH_DRIPSTONE, SMBBlockItemIds.SMOOTH_END_STONE_SLAB,
        SMBBlockItemIds.SMOOTH_END_STONE, SMBBlockItemIds.SMOOTH_GRANITE_SLAB,
        SMBBlockItemIds.SMOOTH_GRANITE, SMBBlockItemIds.SMOOTH_MUD_SLAB,
        SMBBlockItemIds.SMOOTH_MUD, SMBBlockItemIds.SMOOTH_PRISMARINE_SLAB,
        SMBBlockItemIds.SMOOTH_PRISMARINE, SMBBlockItemIds.SMOOTH_PURPUR_SLAB,
        SMBBlockItemIds.SMOOTH_PURPUR, SMBBlockItemIds.SMOOTH_SOUL_SANDSTONE_SLAB,
        SMBBlockItemIds.SMOOTH_SOUL_SANDSTONE_STAIRS, SMBBlockItemIds.SMOOTH_SOUL_SANDSTONE,
        SMBBlockItemIds.SMOOTH_TUFF_SLAB, SMBBlockItemIds.SMOOTH_TUFF,
        SMBBlockItemIds.SOUL_SANDSTONE_BRICK_SLAB, SMBBlockItemIds.SOUL_SANDSTONE_BRICK_STAIRS,
        SMBBlockItemIds.SOUL_SANDSTONE_BRICK_WALL, SMBBlockItemIds.SOUL_SANDSTONE_BRICKS,
        SMBBlockItemIds.SOUL_SANDSTONE_PILLAR, SMBBlockItemIds.SOUL_SANDSTONE_SLAB,
        SMBBlockItemIds.SOUL_SANDSTONE_STAIRS, SMBBlockItemIds.SOUL_SANDSTONE_TILE_SLAB,
        SMBBlockItemIds.SOUL_SANDSTONE_TILE_STAIRS, SMBBlockItemIds.SOUL_SANDSTONE_TILE_WALL,
        SMBBlockItemIds.SOUL_SANDSTONE_TILES, SMBBlockItemIds.SOUL_SANDSTONE_WALL,
        SMBBlockItemIds.SOUL_SANDSTONE, SMBBlockItemIds.STONE_PILLAR,
        SMBBlockItemIds.STONE_TILE_SLAB, SMBBlockItemIds.STONE_TILE_STAIRS,
        SMBBlockItemIds.STONE_TILE_WALL, SMBBlockItemIds.STONE_TILES,
        SMBBlockItemIds.TUFF_PILLAR, SMBBlockItemIds.TUFF_TILE_SLAB,
        SMBBlockItemIds.TUFF_TILE_STAIRS, SMBBlockItemIds.TUFF_TILE_WALL,
        SMBBlockItemIds.TUFF_TILES)
      .addAll(SMBBlockItemIds.COPPER_BRICKS.map(BlockItemId::block))
      .addAll(SMBBlockItemIds.CRACKED_COPPER_BRICKS.map(BlockItemId::block))
      .addAll(SMBBlockItemIds.CRACKED_CUT_COPPER.map(BlockItemId::block))
      .addAll(SMBBlockItemIds.COPPER_PILLAR.map(BlockItemId::block))
      .addAll(SMBBlockItemIds.CHECKERED_TILES.map(BlockItemId::block))
      .addAll(SMBBlockItemIds.DYED_SHINGLES_STAIRS.map(BlockItemId::block))
      .add(
        SMBBlockItemIds.POLISHED_RESIN,
        SMBBlockItemIds.POLISHED_RESIN_STAIRS, SMBBlockItemIds.POLISHED_RESIN_SLAB,
        SMBBlockItemIds.CRACKED_RESIN_BRICKS, SMBBlockItemIds.RESIN_PILLAR,
        SMBBlockItemIds.RESIN_TILES, SMBBlockItemIds.CRACKED_RESIN_TILES,
        SMBBlockItemIds.RESIN_TILE_STAIRS, SMBBlockItemIds.RESIN_TILE_SLAB,
        SMBBlockItemIds.RESIN_TILE_WALL, SMBBlockItemIds.SMOOTH_RESIN,
        SMBBlockItemIds.SMOOTH_RESIN_SLAB, SMBBlockItemIds.POLISHED_BASALT_BRICKS,
        SMBBlockItemIds.CRACKED_POLISHED_BASALT_BRICKS, SMBBlockItemIds.POLISHED_BASALT_BRICK_STAIRS,
        SMBBlockItemIds.POLISHED_BASALT_BRICK_SLAB, SMBBlockItemIds.POLISHED_BASALT_BRICK_WALL,
        SMBBlockItemIds.CHISELED_POLISHED_BASALT_BRICKS, SMBBlockItemIds.POLISHED_BASALT_PILLAR,
        SMBBlockItemIds.POLISHED_BASALT_TILES, SMBBlockItemIds.CRACKED_POLISHED_BASALT_TILES,
        SMBBlockItemIds.POLISHED_BASALT_TILE_STAIRS, SMBBlockItemIds.POLISHED_BASALT_TILE_SLAB,
        SMBBlockItemIds.POLISHED_BASALT_TILE_WALL, SMBBlockItemIds.CORRUPTED_POLISHED_BASALT_BRICKS,
        SMBBlockItemIds.CORRUPTED_POLISHED_BASALT_BRICK_STAIRS, SMBBlockItemIds.CORRUPTED_POLISHED_BASALT_BRICK_SLAB,
        SMBBlockItemIds.CORRUPTED_POLISHED_BASALT_BRICK_WALL, SMBBlockItemIds.REDSTONE_SEA_LANTERN,
        SMBBlockItemIds.SHINGLES_STAIRS
      )
      .setReplace(false);

    this.builder(BlockTags.MINEABLE_WITH_SHOVEL)
        .add(
          SMBBlockItemIds.PACKED_SNOW, SMBBlockItemIds.PACKED_SNOW_STAIRS, SMBBlockItemIds.PACKED_SNOW_SLAB,
          SMBBlockItemIds.POLISHED_SNOW, SMBBlockItemIds.POLISHED_SNOW_STAIRS, SMBBlockItemIds.POLISHED_SNOW_SLAB,
          SMBBlockItemIds.SNOW_BRICKS, SMBBlockItemIds.CRACKED_SNOW_BRICKS, SMBBlockItemIds.SNOW_BRICK_STAIRS,
          SMBBlockItemIds.SNOW_BRICK_SLAB, SMBBlockItemIds.SNOW_BRICK_WALL, SMBBlockItemIds.SNOW_PILLAR,
          SMBBlockItemIds.SNOW_TILES, SMBBlockItemIds.CRACKED_SNOW_TILES, SMBBlockItemIds.SNOW_TILE_STAIRS,
          SMBBlockItemIds.SNOW_TILE_SLAB, SMBBlockItemIds.SNOW_TILE_WALL)
      .setReplace(false);

    this.builder(BlockTags.MINEABLE_WITH_HOE)
      .add(SMBBlockItemIds.REDSTONE_SHROOMLIGHT)
      .setReplace(false);

    this.builder(BlockTags.NEEDS_STONE_TOOL)
        .add(
          SMBBlockItemIds.IRON_BRICKS, SMBBlockItemIds.CRACKED_SNOW_BRICKS, SMBBlockItemIds.IRON_PILLAR,
          SMBBlockItemIds.CUT_IRON, SMBBlockItemIds.CRACKED_CUT_IRON, SMBBlockItemIds.IRON_GRATE,
          SMBBlockItemIds.LAPIS_BRICKS, SMBBlockItemIds.CRACKED_LAPIS_BRICKS, SMBBlockItemIds.LAPIS_PILLAR,
          SMBBlockItemIds.CUT_LAPIS, SMBBlockItemIds.CRACKED_CUT_LAPIS
        )
        .addAll(SMBBlockItemIds.COPPER_BRICKS.map(BlockItemId::block))
        .addAll(SMBBlockItemIds.CRACKED_COPPER_BRICKS.map(BlockItemId::block))
        .addAll(SMBBlockItemIds.CRACKED_CUT_COPPER.map(BlockItemId::block))
        .addAll(SMBBlockItemIds.COPPER_PILLAR.map(BlockItemId::block))
      .setReplace(false);

    this.builder(BlockTags.NEEDS_IRON_TOOL)
      .add(
        SMBBlockItemIds.GOLD_BRICKS, SMBBlockItemIds.CRACKED_GOLD_BRICKS, SMBBlockItemIds.GOLD_PILLAR,
        SMBBlockItemIds.CUT_GOLD, SMBBlockItemIds.CRACKED_CUT_GOLD,
        SMBBlockItemIds.EMERALD_BRICKS, SMBBlockItemIds.CRACKED_EMERALD_BRICKS, SMBBlockItemIds.EMERALD_PILLAR,
        SMBBlockItemIds.CUT_EMERALD, SMBBlockItemIds.CRACKED_CUT_EMERALD,
        SMBBlockItemIds.DIAMOND_BRICKS, SMBBlockItemIds.CRACKED_DIAMOND_BRICKS, SMBBlockItemIds.DIAMOND_PILLAR,
        SMBBlockItemIds.CUT_DIAMOND, SMBBlockItemIds.CRACKED_CUT_DIAMOND, SMBBlockItemIds.DIAMOND_GRATE
      )
      .setReplace(false);

    this.builder(BlockTags.NEEDS_DIAMOND_TOOL)
      .add(
        SMBBlockItemIds.NETHERITE_BRICKS, SMBBlockItemIds.CRACKED_NETHERITE_BRICKS, SMBBlockItemIds.NETHERITE_PILLAR,
        SMBBlockItemIds.CUT_NETHERITE, SMBBlockItemIds.CRACKED_CUT_NETHERITE, SMBBlockItemIds.NETHERITE_GRATE
      )
      .setReplace(false);

    this.builder(BlockTags.PALE_OAK_LOGS)
      .add(SMBBlockIds.CARVED_PALE_OAK_LOG, SMBBlockIds.CARVED_PALE_OAK_WOOD)
      .setReplace(false);

    this.builder(SMBBlockTags.LUMINOUS_FLOWER_REPLACEABLE)
      .add(
        BlockItemIds.SHORT_GRASS.block(), BlockItemIds.MOSS_CARPET.block(), BlockItemIds.SCULK_VEIN.block(),
        BlockItemIds.GLOW_LICHEN.block(), BlockItemIds.VINE.block()/*, BlockIds.CAVE_VINES*/,
        BlockIds.CAVE_VINES_PLANT);

    this.builder(BlockTags.FROG_PREFER_JUMP_TO)
      .add(SMBBlockIds.BIG_LILY_PAD)
      .setReplace(false);

    this.builder(SMBBlockTags.BIG_LILY_PAD_REPLACEABLE)
      .add(BlockItemIds.LILY_PAD.block(), BlockItemIds.MOSS_CARPET.block(), SMBBlockIds.SMALL_LILY_PADS);

    this.builder(SMBBlockTags.MUSHROOM_COLONIES)
      .add(
        SMBBlockIds.BROWN_MUSHROOM_COLONY, SMBBlockIds.TALL_BROWN_MUSHROOM_COLONY, SMBBlockIds.BROWN_MUSHROOM_COLONY_WALL,
        SMBBlockIds.RED_MUSHROOM_COLONY, SMBBlockIds.TALL_RED_MUSHROOM_COLONY, SMBBlockIds.RED_MUSHROOM_COLONY_WALL);

    this.builder(SMBBlockTags.FUNGUS_COLONIES)
      .add(
        SMBBlockIds.WARPED_FUNGUS_COLONY, SMBBlockIds.TALL_WARPED_FUNGUS_COLONY, SMBBlockIds.WARPED_FUNGUS_COLONY,
        SMBBlockIds.CRIMSON_FUNGUS_COLONY, SMBBlockIds.TALL_CRIMSON_FUNGUS_COLONY, SMBBlockIds.CRIMSON_FUNGUS_COLONY);

    this.builder(BlockTags.BEACON_BASE_BLOCKS)
      .add(
        SMBBlockItemIds.IRON_BRICKS, SMBBlockItemIds.IRON_PILLAR, SMBBlockItemIds.CUT_IRON,
        SMBBlockItemIds.GOLD_BRICKS, SMBBlockItemIds.GOLD_PILLAR, SMBBlockItemIds.CUT_GOLD,
        SMBBlockItemIds.EMERALD_BRICKS, SMBBlockItemIds.EMERALD_PILLAR, SMBBlockItemIds.CUT_EMERALD,
        SMBBlockItemIds.DIAMOND_BRICKS, SMBBlockItemIds.DIAMOND_PILLAR, SMBBlockItemIds.CUT_DIAMOND,
        SMBBlockItemIds.NETHERITE_BRICKS, SMBBlockItemIds.NETHERITE_PILLAR, SMBBlockItemIds.CUT_NETHERITE)
      .setReplace(false);

    this.builder(SMBBlockTags.NETHER_CLOVER_PLACEABLE)
      .add(
        BlockItemIds.NETHERRACK, BlockItemIds.CRIMSON_NYLIUM, BlockItemIds.WARPED_NYLIUM,
        BlockItemIds.SOUL_SAND, BlockItemIds.SOUL_SOIL);

    this.builder(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
      .add(
        SMBBlockIds.LEAF_LITTER, SMBBlockIds.BIRCH_LEAF_LITTER, SMBBlockIds.SPRUCE_LEAF_LITTER,
        SMBBlockIds.PALE_OAK_LEAF_LITTER, SMBBlockIds.AZALEA_LEAF_LITTER, SMBBlockIds.FLOWERING_AZALEA_LEAF_LITTER,
        SMBBlockIds.CLOVER, SMBBlockIds.NETHER_CLOVER)
      .setReplace(false);
  }

}
