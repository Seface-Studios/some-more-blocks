package net.seface.somemoreblocks.datagen.providers.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.concurrent.CompletableFuture;

public class SMBItemTagProvider extends FabricTagProvider.ItemTagProvider {
  public SMBItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, future);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    this.valueLookupBuilder(ItemTags.ACACIA_LOGS)
      .add(SMBBlocks.CARVED_ACACIA_LOG.get().asItem(), SMBBlocks.CARVED_ACACIA_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.BAMBOO_BLOCKS)
      .add(SMBBlocks.CARVED_BAMBOO_BLOCK.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.BIRCH_LOGS)
      .add(SMBBlocks.CARVED_BIRCH_LOG.get().asItem(), SMBBlocks.CARVED_BIRCH_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.CHERRY_LOGS)
      .add(SMBBlocks.CARVED_CHERRY_LOG.get().asItem(), SMBBlocks.CARVED_CHERRY_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.CRIMSON_STEMS)
      .add(SMBBlocks.CARVED_CRIMSON_STEM.get().asItem(), SMBBlocks.CARVED_CRIMSON_HYPHAE.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.DARK_OAK_LOGS)
      .add(SMBBlocks.CARVED_DARK_OAK_LOG.get().asItem(), SMBBlocks.CARVED_DARK_OAK_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.JUNGLE_LOGS)
      .add(SMBBlocks.CARVED_JUNGLE_LOG.get().asItem(), SMBBlocks.CARVED_JUNGLE_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.MANGROVE_LOGS)
      .add(SMBBlocks.CARVED_MANGROVE_LOG.get().asItem(), SMBBlocks.CARVED_MANGROVE_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.OAK_LOGS)
      .add(SMBBlocks.CARVED_OAK_LOG.get().asItem(), SMBBlocks.CARVED_OAK_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.PLANKS)
      .add(
        SMBBlocks.OAK_MOSAIC.get().asItem(), SMBBlocks.SPRUCE_MOSAIC.get().asItem(),
        SMBBlocks.BIRCH_MOSAIC.get().asItem(), SMBBlocks.JUNGLE_MOSAIC.get().asItem(),
        SMBBlocks.ACACIA_MOSAIC.get().asItem(), SMBBlocks.DARK_OAK_MOSAIC.get().asItem(),
        SMBBlocks.MANGROVE_MOSAIC.get().asItem(), SMBBlocks.CRIMSON_MOSAIC.get().asItem(),
        SMBBlocks.WARPED_MOSAIC.get().asItem(), SMBBlocks.CHERRY_MOSAIC.get().asItem(),
        SMBBlocks.PALE_OAK_MOSAIC.get().asItem()
      )
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.SLABS)
      .add(
        SMBBlocks.PACKED_SNOW_SLAB.get().asItem(), SMBBlocks.POLISHED_SNOW_SLAB.get().asItem(),
        SMBBlocks.SNOW_BRICK_SLAB.get().asItem(), SMBBlocks.SNOW_TILE_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_DEEPSLATE_SLAB.get().asItem(), SMBBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.get().asItem(),
        SMBBlocks.POLISHED_STONE_SLAB.get().asItem(), SMBBlocks.STONE_TILE_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_GRANITE_SLAB.get().asItem(), SMBBlocks.GRANITE_BRICK_SLAB.get().asItem(),
        SMBBlocks.MOSSY_GRANITE_BRICK_SLAB.get().asItem(), SMBBlocks.GRANITE_TILE_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_DIORITE_SLAB.get().asItem(), SMBBlocks.DIORITE_BRICK_SLAB.get().asItem(),
        SMBBlocks.MOSSY_DIORITE_BRICK_SLAB.get().asItem(), SMBBlocks.DIORITE_TILE_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_ANDESITE_SLAB.get().asItem(), SMBBlocks.ANDESITE_BRICK_SLAB.get().asItem(),
        SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB.get().asItem(), SMBBlocks.ANDESITE_TILE_SLAB.get().asItem(),
        SMBBlocks.POLISHED_END_STONE_SLAB.get().asItem(), SMBBlocks.SMOOTH_END_STONE_SLAB.get().asItem(),
        SMBBlocks.MOSSY_END_STONE_BRICK_SLAB.get().asItem(), SMBBlocks.END_STONE_TILE_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_TUFF_SLAB.get().asItem(), SMBBlocks.MOSSY_TUFF_BRICK_SLAB.get().asItem(),
        SMBBlocks.TUFF_TILE_SLAB.get().asItem(), SMBBlocks.RED_SANDSTONE_BRICK_SLAB.get().asItem(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB.get().asItem(), SMBBlocks.RED_SANDSTONE_TILE_SLAB.get().asItem(),
        SMBBlocks.POLISHED_CALCITE_SLAB.get().asItem(), SMBBlocks.SMOOTH_CALCITE_SLAB.get().asItem(),
        SMBBlocks.CALCITE_BRICK_SLAB.get().asItem(), SMBBlocks.MOSSY_CALCITE_BRICK_SLAB.get().asItem(),
        SMBBlocks.CALCITE_TILE_SLAB.get().asItem(), SMBBlocks.POLISHED_DRIPSTONE_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_DRIPSTONE_SLAB.get().asItem(), SMBBlocks.DRIPSTONE_BRICK_SLAB.get().asItem(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.get().asItem(), SMBBlocks.DRIPSTONE_TILE_SLAB.get().asItem(),
        SMBBlocks.POLISHED_PRISMARINE_SLAB.get().asItem(), SMBBlocks.SMOOTH_PRISMARINE_SLAB.get().asItem(),
        SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB.get().asItem(), SMBBlocks.PRISMARINE_TILE_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_BLACKSTONE_SLAB.get().asItem(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get().asItem(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB.get().asItem(), SMBBlocks.POLISHED_MUD_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_MUD_SLAB.get().asItem(), SMBBlocks.MOSSY_MUD_BRICK_SLAB.get().asItem(),
        SMBBlocks.MUD_TILE_SLAB.get().asItem(), SMBBlocks.SANDSTONE_BRICK_SLAB.get().asItem(),
        SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB.get().asItem(), SMBBlocks.SANDSTONE_TILE_SLAB.get().asItem(),
        SMBBlocks.POLISHED_ICE_SLAB.get().asItem(), SMBBlocks.ICE_BRICK_SLAB.get().asItem(),
        SMBBlocks.ICE_TILE_SLAB.get().asItem(), SMBBlocks.POLISHED_PURPUR_SLAB.get().asItem(),
        SMBBlocks.SMOOTH_PURPUR_SLAB.get().asItem(), SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB.get().asItem(),
        SMBBlocks.PURPUR_TILE_SLAB.get().asItem(), SMBBlocks.SOUL_SANDSTONE_SLAB.get().asItem(),
        SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.get().asItem(), SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get().asItem(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB.get().asItem(), SMBBlocks.SOUL_SANDSTONE_TILE_SLAB.get().asItem(),
        SMBBlocks.MOSSY_BRICK_SLAB.get().asItem(), SMBBlocks.BONE_BRICK_SLAB.get().asItem(),
        SMBBlocks.BONE_TILE_SLAB.get().asItem(), SMBBlocks.POLISHED_RESIN_SLAB.get().asItem(),
        SMBBlocks.RESIN_TILE_SLAB.get().asItem(), SMBBlocks.SMOOTH_RESIN_SLAB.get().asItem(),
        SMBBlocks.POLISHED_BASALT_BRICK_SLAB.get().asItem(), SMBBlocks.POLISHED_BASALT_TILE_SLAB.get().asItem(),
        SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get().asItem()
      )
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.SMALL_FLOWERS)
      .add(SMBBlocks.LUMINOUS_FLOWER.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.SPRUCE_LOGS)
      .add(SMBBlocks.CARVED_SPRUCE_LOG.get().asItem(), SMBBlocks.CARVED_SPRUCE_WOOD.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.STAIRS)
      .add(
        SMBBlocks.PACKED_SNOW_STAIRS.get().asItem(), SMBBlocks.POLISHED_SNOW_STAIRS.get().asItem(),
        SMBBlocks.SNOW_BRICK_STAIRS.get().asItem(), SMBBlocks.SNOW_TILE_STAIRS.get().asItem(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.get().asItem(), SMBBlocks.POLISHED_STONE_STAIRS.get().asItem(),
        SMBBlocks.STONE_TILE_STAIRS.get().asItem(), SMBBlocks.GRANITE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS.get().asItem(), SMBBlocks.GRANITE_TILE_STAIRS.get().asItem(),
        SMBBlocks.DIORITE_BRICK_STAIRS.get().asItem(), SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.DIORITE_TILE_STAIRS.get().asItem(), SMBBlocks.ANDESITE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS.get().asItem(), SMBBlocks.ANDESITE_TILE_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_END_STONE_STAIRS.get().asItem(), SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.END_STONE_TILE_STAIRS.get().asItem(), SMBBlocks.MOSSY_TUFF_BRICK_STAIRS.get().asItem(),
        SMBBlocks.TUFF_TILE_STAIRS.get().asItem(), SMBBlocks.RED_SANDSTONE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS.get().asItem(), SMBBlocks.RED_SANDSTONE_TILE_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_CALCITE_STAIRS.get().asItem(), SMBBlocks.CALCITE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS.get().asItem(), SMBBlocks.CALCITE_TILE_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_DRIPSTONE_STAIRS.get().asItem(), SMBBlocks.DRIPSTONE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.get().asItem(), SMBBlocks.DRIPSTONE_TILE_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_PRISMARINE_STAIRS.get().asItem(), SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.PRISMARINE_TILE_STAIRS.get().asItem(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS.get().asItem(), SMBBlocks.POLISHED_MUD_STAIRS.get().asItem(),
        SMBBlocks.MOSSY_MUD_BRICK_STAIRS.get().asItem(), SMBBlocks.MUD_TILE_STAIRS.get().asItem(),
        SMBBlocks.SANDSTONE_BRICK_STAIRS.get().asItem(), SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.SANDSTONE_TILE_STAIRS.get().asItem(), SMBBlocks.POLISHED_ICE_STAIRS.get().asItem(),
        SMBBlocks.ICE_BRICK_STAIRS.get().asItem(), SMBBlocks.ICE_TILE_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_PURPUR_STAIRS.get().asItem(), SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS.get().asItem(),
        SMBBlocks.PURPUR_TILE_STAIRS.get().asItem(), SMBBlocks.SOUL_SANDSTONE_STAIRS.get().asItem(),
        SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get().asItem(), SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS.get().asItem(),
        SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS.get().asItem(), SMBBlocks.MOSSY_BRICK_STAIRS.get().asItem(),
        SMBBlocks.BONE_BRICK_STAIRS.get().asItem(), SMBBlocks.BONE_TILE_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_RESIN_STAIRS.get().asItem(), SMBBlocks.RESIN_TILE_STAIRS.get().asItem(),
        SMBBlocks.POLISHED_BASALT_BRICK_STAIRS.get().asItem(), SMBBlocks.POLISHED_BASALT_TILE_STAIRS.get().asItem(),
        SMBBlocks.CORRUPTED_POLISHED_BASALT_BRICK_STAIRS.get().asItem(),
        SMBBlocks.SHINGLES_STAIRS.get().asItem(), SMBBlocks.WHITE_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.LIGHT_GRAY_SHINGLES_STAIRS.get().asItem(), SMBBlocks.GRAY_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.BLACK_SHINGLES_STAIRS.get().asItem(), SMBBlocks.BROWN_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.RED_SHINGLES_STAIRS.get().asItem(), SMBBlocks.ORANGE_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.YELLOW_SHINGLES_STAIRS.get().asItem(), SMBBlocks.LIME_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.GREEN_SHINGLES_STAIRS.get().asItem(), SMBBlocks.CYAN_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.LIGHT_BLUE_SHINGLES_STAIRS.get().asItem(), SMBBlocks.BLUE_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.PURPLE_SHINGLES_STAIRS.get().asItem(), SMBBlocks.MAGENTA_SHINGLES_STAIRS.get().asItem(),
        SMBBlocks.PINK_SHINGLES_STAIRS.get().asItem()
      )
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.WALLS)
      .add(
        SMBBlocks.SNOW_BRICK_WALL.get().asItem(), SMBBlocks.SNOW_TILE_WALL.get().asItem(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get().asItem(), SMBBlocks.STONE_TILE_WALL.get().asItem(),
        SMBBlocks.GRANITE_BRICK_WALL.get().asItem(), SMBBlocks.MOSSY_GRANITE_BRICK_WALL.get().asItem(),
        SMBBlocks.GRANITE_TILE_WALL.get().asItem(), SMBBlocks.DIORITE_BRICK_WALL.get().asItem(),
        SMBBlocks.MOSSY_DIORITE_BRICK_WALL.get().asItem(), SMBBlocks.DIORITE_TILE_WALL.get().asItem(),
        SMBBlocks.ANDESITE_BRICK_WALL.get().asItem(), SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.get().asItem(),
        SMBBlocks.ANDESITE_TILE_WALL.get().asItem(), SMBBlocks.MOSSY_END_STONE_BRICK_WALL.get().asItem(),
        SMBBlocks.END_STONE_TILE_WALL.get().asItem(), SMBBlocks.MOSSY_TUFF_BRICK_WALL.get().asItem(),
        SMBBlocks.TUFF_TILE_WALL.get().asItem(), SMBBlocks.RED_SANDSTONE_BRICK_WALL.get().asItem(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.get().asItem(), SMBBlocks.RED_SANDSTONE_TILE_WALL.get().asItem(),
        SMBBlocks.CALCITE_BRICK_WALL.get().asItem(), SMBBlocks.MOSSY_CALCITE_BRICK_WALL.get().asItem(),
        SMBBlocks.CALCITE_TILE_WALL.get().asItem(), SMBBlocks.DRIPSTONE_BRICK_WALL.get().asItem(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.get().asItem(), SMBBlocks.DRIPSTONE_TILE_WALL.get().asItem(),
        SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.get().asItem(), SMBBlocks.PRISMARINE_TILE_WALL.get().asItem(),
        SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.get().asItem(), SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.get().asItem(),
        SMBBlocks.MOSSY_MUD_BRICK_WALL.get().asItem(), SMBBlocks.MUD_TILE_WALL.get().asItem(),
        SMBBlocks.SANDSTONE_BRICK_WALL.get().asItem(), SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.get().asItem(),
        SMBBlocks.SANDSTONE_TILE_WALL.get().asItem(), SMBBlocks.ICE_BRICK_WALL.get().asItem(),
        SMBBlocks.ICE_TILE_WALL.get().asItem(), SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.get().asItem(),
        SMBBlocks.PURPUR_TILE_WALL.get().asItem(), SMBBlocks.SOUL_SANDSTONE_WALL.get().asItem(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get().asItem(), SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get().asItem(),
        SMBBlocks.MOSSY_BRICK_WALL.get().asItem(), SMBBlocks.BONE_BRICK_WALL.get().asItem(),
        SMBBlocks.BONE_TILE_WALL.get().asItem(), SMBBlocks.RESIN_TILE_WALL.get().asItem(),
        SMBBlocks.POLISHED_BASALT_BRICK_WALL.get().asItem(), SMBBlocks.POLISHED_BASALT_TILE_WALL.get().asItem(),
        SMBBlocks.CORRUPTED_POLISHED_BASALT_BRICK_WALL.get().asItem()
      )
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.WARPED_STEMS)
      .add(SMBBlocks.CARVED_WARPED_STEM.get().asItem(), SMBBlocks.CARVED_WARPED_HYPHAE.get().asItem())
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.WOODEN_SLABS)
      .add(
        SMBBlocks.OAK_MOSAIC_SLAB.get().asItem(), SMBBlocks.SPRUCE_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.BIRCH_MOSAIC_SLAB.get().asItem(), SMBBlocks.JUNGLE_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.ACACIA_MOSAIC_SLAB.get().asItem(), SMBBlocks.DARK_OAK_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.MANGROVE_MOSAIC_SLAB.get().asItem(), SMBBlocks.CRIMSON_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.WARPED_MOSAIC_SLAB.get().asItem(), SMBBlocks.CHERRY_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.PALE_OAK_MOSAIC_SLAB.get().asItem()
      )
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.WOODEN_STAIRS)
      .add(
        SMBBlocks.OAK_MOSAIC_STAIRS.get().asItem(), SMBBlocks.SPRUCE_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.BIRCH_MOSAIC_STAIRS.get().asItem(), SMBBlocks.JUNGLE_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.ACACIA_MOSAIC_STAIRS.get().asItem(), SMBBlocks.DARK_OAK_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.MANGROVE_MOSAIC_STAIRS.get().asItem(), SMBBlocks.CRIMSON_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.WARPED_MOSAIC_STAIRS.get().asItem(), SMBBlocks.CHERRY_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.PALE_OAK_MOSAIC_STAIRS.get().asItem()
      )
      .setReplace(false);

    this.valueLookupBuilder(ItemTags.PALE_OAK_LOGS)
      .add(SMBBlocks.CARVED_PALE_OAK_LOG.get().asItem(), SMBBlocks.CARVED_PALE_OAK_WOOD.get().asItem())
      .setReplace(false);
  }
}
