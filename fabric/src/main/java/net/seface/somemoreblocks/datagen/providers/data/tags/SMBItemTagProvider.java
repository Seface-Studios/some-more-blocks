package net.seface.somemoreblocks.datagen.providers.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.concurrent.CompletableFuture;

public class SMBItemTagProvider extends FabricTagProvider<Item> {
  public SMBItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, Registries.ITEM, future);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    getOrCreateTagBuilder(ItemTags.ACACIA_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_ACACIA_LOG.get().asItem(), SMBBlocks.CARVED_ACACIA_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.BAMBOO_BLOCKS).setReplace(false).add(SMBBlocks.CARVED_BAMBOO_BLOCK.get().asItem());

    getOrCreateTagBuilder(ItemTags.BIRCH_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_BIRCH_LOG.get().asItem(), SMBBlocks.CARVED_BIRCH_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.CHERRY_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_CHERRY_LOG.get().asItem(), SMBBlocks.CARVED_CHERRY_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.CRIMSON_STEMS).setReplace(false)
      .add(SMBBlocks.CARVED_CRIMSON_STEM.get().asItem(), SMBBlocks.CARVED_CRIMSON_HYPHAE.get().asItem());

    getOrCreateTagBuilder(ItemTags.DARK_OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_DARK_OAK_LOG.get().asItem(), SMBBlocks.CARVED_DARK_OAK_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.JUNGLE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_JUNGLE_LOG.get().asItem(), SMBBlocks.CARVED_JUNGLE_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.MANGROVE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_MANGROVE_LOG.get().asItem(), SMBBlocks.CARVED_MANGROVE_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_OAK_LOG.get().asItem(), SMBBlocks.CARVED_OAK_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.PLANKS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC.get().asItem(), SMBBlocks.SPRUCE_MOSAIC.get().asItem(),
        SMBBlocks.BIRCH_MOSAIC.get().asItem(), SMBBlocks.JUNGLE_MOSAIC.get().asItem(),
        SMBBlocks.ACACIA_MOSAIC.get().asItem(), SMBBlocks.DARK_OAK_MOSAIC.get().asItem(),
        SMBBlocks.MANGROVE_MOSAIC.get().asItem(), SMBBlocks.CRIMSON_MOSAIC.get().asItem(),
        SMBBlocks.WARPED_MOSAIC.get().asItem(), SMBBlocks.CHERRY_MOSAIC.get().asItem()
      );

    getOrCreateTagBuilder(ItemTags.SLABS).setReplace(false)
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
        SMBBlocks.BONE_TILE_SLAB.get().asItem(),
        SMBBlocks.POLISHED_BASALT_BRICK_SLAB.get().asItem(), SMBBlocks.POLISHED_BASALT_TILE_SLAB.get().asItem(),
        SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get().asItem()
      );

    getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).setReplace(false).add(SMBBlocks.LUMINOUS_FLOWER.get().asItem());

    getOrCreateTagBuilder(ItemTags.SPRUCE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_SPRUCE_LOG.get().asItem(), SMBBlocks.CARVED_SPRUCE_WOOD.get().asItem());

    getOrCreateTagBuilder(ItemTags.STAIRS).setReplace(false)
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
      );

    getOrCreateTagBuilder(ItemTags.WALLS).setReplace(false)
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
        SMBBlocks.BONE_TILE_WALL.get().asItem(),
        SMBBlocks.POLISHED_BASALT_BRICK_WALL.get().asItem(), SMBBlocks.POLISHED_BASALT_TILE_WALL.get().asItem(),
        SMBBlocks.CORRUPTED_POLISHED_BASALT_BRICK_WALL.get().asItem()
      );

    getOrCreateTagBuilder(ItemTags.WARPED_STEMS).setReplace(false)
      .add(SMBBlocks.CARVED_WARPED_STEM.get().asItem(), SMBBlocks.CARVED_WARPED_HYPHAE.get().asItem());

    getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC_SLAB.get().asItem(), SMBBlocks.SPRUCE_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.BIRCH_MOSAIC_SLAB.get().asItem(), SMBBlocks.JUNGLE_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.ACACIA_MOSAIC_SLAB.get().asItem(), SMBBlocks.DARK_OAK_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.MANGROVE_MOSAIC_SLAB.get().asItem(), SMBBlocks.CRIMSON_MOSAIC_SLAB.get().asItem(),
        SMBBlocks.WARPED_MOSAIC_SLAB.get().asItem(), SMBBlocks.CHERRY_MOSAIC_SLAB.get().asItem()
      );

    getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC_SLAB.get().asItem(), SMBBlocks.SPRUCE_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.BIRCH_MOSAIC_STAIRS.get().asItem(), SMBBlocks.JUNGLE_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.ACACIA_MOSAIC_STAIRS.get().asItem(), SMBBlocks.DARK_OAK_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.MANGROVE_MOSAIC_STAIRS.get().asItem(), SMBBlocks.CRIMSON_MOSAIC_STAIRS.get().asItem(),
        SMBBlocks.WARPED_MOSAIC_STAIRS.get().asItem(), SMBBlocks.CHERRY_MOSAIC_STAIRS.get().asItem()
      );
  }
}
