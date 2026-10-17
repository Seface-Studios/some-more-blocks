package net.sefacestudios.somemoreblocks.datagen.providers.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemId;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import net.sefacestudios.somemoreblocks.references.SMBBlockItemIds;
import net.sefacestudios.somemoreblocks.references.SMBItemIds;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class SMBItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
  public SMBItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, future);
  }

  @Override
  protected void addTags(@NotNull HolderLookup.Provider provider) {
    this.builder(ItemTags.ACACIA_LOGS)
      .add(SMBBlockItemIds.CARVED_ACACIA_LOG, SMBBlockItemIds.CARVED_ACACIA_WOOD)
      .setReplace(false);

    this.builder(ItemTags.BAMBOO_BLOCKS)
      .add(SMBBlockItemIds.CARVED_BAMBOO_BLOCK)
      .setReplace(false);

    this.builder(ItemTags.BIRCH_LOGS)
      .add(SMBBlockItemIds.CARVED_BIRCH_LOG, SMBBlockItemIds.CARVED_BIRCH_WOOD)
      .setReplace(false);

    this.builder(ItemTags.CHERRY_LOGS)
      .add(SMBBlockItemIds.CARVED_CHERRY_LOG, SMBBlockItemIds.CARVED_CHERRY_WOOD)
      .setReplace(false);

    this.builder(ItemTags.CRIMSON_STEMS)
      .add(SMBBlockItemIds.CARVED_CRIMSON_STEM, SMBBlockItemIds.CARVED_CRIMSON_HYPHAE)
      .setReplace(false);

    this.builder(ItemTags.DARK_OAK_LOGS)
      .add(SMBBlockItemIds.CARVED_DARK_OAK_LOG, SMBBlockItemIds.CARVED_DARK_OAK_WOOD)
      .setReplace(false);

    this.builder(ItemTags.JUNGLE_LOGS)
      .add(SMBBlockItemIds.CARVED_JUNGLE_LOG, SMBBlockItemIds.CARVED_JUNGLE_WOOD)
      .setReplace(false);

    this.builder(ItemTags.MANGROVE_LOGS)
      .add(SMBBlockItemIds.CARVED_MANGROVE_LOG, SMBBlockItemIds.CARVED_MANGROVE_WOOD)
      .setReplace(false);

    this.builder(ItemTags.OAK_LOGS)
      .add(SMBBlockItemIds.CARVED_OAK_LOG, SMBBlockItemIds.CARVED_OAK_WOOD)
      .setReplace(false);

    this.builder(ItemTags.PLANKS)
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

    this.builder(BlockItemTags.SLABS.item())
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
        SMBBlockItemIds.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB
      )
      .setReplace(false);

    this.builder(BlockItemTags.SMALL_FLOWERS.item())
      .add(
        SMBBlockItemIds.LUMINOUS_FLOWER,
        SMBBlockItemIds.LAVENDER,
        SMBBlockItemIds.SHORT_GALAHAD_LARKSPUR,
        SMBBlockItemIds.SHORT_ASTOLAT_LARKSPUR,
        SMBBlockItemIds.SHORT_SUMMER_SKIES_LARKSPUR,
        SMBBlockItemIds.SHORT_PURPLE_LARKSPUR,
        SMBBlockItemIds.SHORT_RED_LARK_LARKSPUR
      )
      .setReplace(false);

    this.builder(ItemTags.SPRUCE_LOGS)
      .add(SMBBlockItemIds.CARVED_SPRUCE_LOG, SMBBlockItemIds.CARVED_SPRUCE_WOOD)
      .setReplace(false);

    this.builder(BlockItemTags.STAIRS.item())
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
      .addAll(SMBBlockItemIds.DYED_SHINGLES_STAIRS.map(BlockItemId::item))
      .setReplace(false);

    this.builder(ItemTags.WALLS)
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

    this.builder(ItemTags.WARPED_STEMS)
      .add(SMBBlockItemIds.CARVED_WARPED_STEM, SMBBlockItemIds.CARVED_WARPED_HYPHAE)
      .setReplace(false);

    this.builder(ItemTags.WOODEN_SLABS)
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

    this.builder(ItemTags.WOODEN_STAIRS)
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

    this.builder(ItemTags.PALE_OAK_LOGS)
      .add(SMBItemIds.CARVED_PALE_OAK_LOG, SMBItemIds.CARVED_PALE_OAK_WOOD)
      .setReplace(false);
  }

}
