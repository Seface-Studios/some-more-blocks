package net.seface.somemoreblocks.datagen.providers;

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
      .add(SMBBlocks.CARVED_ACACIA_LOG.asItem(), SMBBlocks.CARVED_ACACIA_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.BAMBOO_BLOCKS).setReplace(false).add(SMBBlocks.CARVED_BAMBOO_BLOCK.asItem());

    getOrCreateTagBuilder(ItemTags.BIRCH_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_BIRCH_LOG.asItem(), SMBBlocks.CARVED_BIRCH_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.CHERRY_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_CHERRY_LOG.asItem(), SMBBlocks.CARVED_CHERRY_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.CRIMSON_STEMS).setReplace(false)
      .add(SMBBlocks.CARVED_CRIMSON_STEM.asItem(), SMBBlocks.CARVED_CRIMSON_HYPHAE.asItem());

    getOrCreateTagBuilder(ItemTags.DARK_OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_DARK_OAK_LOG.asItem(), SMBBlocks.CARVED_DARK_OAK_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.JUNGLE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_JUNGLE_LOG.asItem(), SMBBlocks.CARVED_JUNGLE_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.MANGROVE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_MANGROVE_LOG.asItem(), SMBBlocks.CARVED_MANGROVE_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_OAK_LOG.asItem(), SMBBlocks.CARVED_OAK_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.PLANKS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC.asItem(), SMBBlocks.SPRUCE_MOSAIC.asItem(),
        SMBBlocks.BIRCH_MOSAIC.asItem(), SMBBlocks.JUNGLE_MOSAIC.asItem(),
        SMBBlocks.ACACIA_MOSAIC.asItem(), SMBBlocks.DARK_OAK_MOSAIC.asItem(),
        SMBBlocks.MANGROVE_MOSAIC.asItem(), SMBBlocks.CRIMSON_MOSAIC.asItem(),
        SMBBlocks.WARPED_MOSAIC.asItem(), SMBBlocks.CHERRY_MOSAIC.asItem(),

        /* 1.21.4 */
        SMBBlocks.PALE_OAK_MOSAIC.asItem());

    getOrCreateTagBuilder(ItemTags.SLABS).setReplace(false)
      .add(
        SMBBlocks.PACKED_SNOW_SLAB.asItem(), SMBBlocks.POLISHED_SNOW_SLAB.asItem(),
        SMBBlocks.SNOW_BRICK_SLAB.asItem(), SMBBlocks.SNOW_TILE_SLAB.asItem(),
        SMBBlocks.SMOOTH_DEEPSLATE_SLAB.asItem(), SMBBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.asItem(),
        SMBBlocks.POLISHED_STONE_SLAB.asItem(), SMBBlocks.STONE_TILE_SLAB.asItem(),
        SMBBlocks.SMOOTH_GRANITE_SLAB.asItem(), SMBBlocks.GRANITE_BRICK_SLAB.asItem(),
        SMBBlocks.MOSSY_GRANITE_BRICK_SLAB.asItem(), SMBBlocks.GRANITE_TILE_SLAB.asItem(),
        SMBBlocks.SMOOTH_DIORITE_SLAB.asItem(), SMBBlocks.DIORITE_BRICK_SLAB.asItem(),
        SMBBlocks.MOSSY_DIORITE_BRICK_SLAB.asItem(), SMBBlocks.DIORITE_TILE_SLAB.asItem(),
        SMBBlocks.SMOOTH_ANDESITE_SLAB.asItem(), SMBBlocks.ANDESITE_BRICK_SLAB.asItem(),
        SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB.asItem(), SMBBlocks.ANDESITE_TILE_SLAB.asItem(),
        SMBBlocks.POLISHED_END_STONE_SLAB.asItem(), SMBBlocks.SMOOTH_END_STONE_SLAB.asItem(),
        SMBBlocks.MOSSY_END_STONE_BRICK_SLAB.asItem(), SMBBlocks.END_STONE_TILE_SLAB.asItem(),
        SMBBlocks.SMOOTH_TUFF_SLAB.asItem(), SMBBlocks.MOSSY_TUFF_BRICK_SLAB.asItem(),
        SMBBlocks.TUFF_TILE_SLAB.asItem(), SMBBlocks.RED_SANDSTONE_BRICK_SLAB.asItem(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB.asItem(), SMBBlocks.RED_SANDSTONE_TILE_SLAB.asItem(),
        SMBBlocks.POLISHED_CALCITE_SLAB.asItem(), SMBBlocks.SMOOTH_CALCITE_SLAB.asItem(),
        SMBBlocks.CALCITE_BRICK_SLAB.asItem(), SMBBlocks.MOSSY_CALCITE_BRICK_SLAB.asItem(),
        SMBBlocks.CALCITE_TILE_SLAB.asItem(), SMBBlocks.POLISHED_DRIPSTONE_SLAB.asItem(),
        SMBBlocks.SMOOTH_DRIPSTONE_SLAB.asItem(), SMBBlocks.DRIPSTONE_BRICK_SLAB.asItem(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.asItem(), SMBBlocks.DRIPSTONE_TILE_SLAB.asItem(),
        SMBBlocks.POLISHED_PRISMARINE_SLAB.asItem(), SMBBlocks.SMOOTH_PRISMARINE_SLAB.asItem(),
        SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB.asItem(), SMBBlocks.PRISMARINE_TILE_SLAB.asItem(),
        SMBBlocks.SMOOTH_BLACKSTONE_SLAB.asItem(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.asItem(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB.asItem(), SMBBlocks.POLISHED_MUD_SLAB.asItem(),
        SMBBlocks.SMOOTH_MUD_SLAB.asItem(), SMBBlocks.MOSSY_MUD_BRICK_SLAB.asItem(),
        SMBBlocks.MUD_TILE_SLAB.asItem(), SMBBlocks.SANDSTONE_BRICK_SLAB.asItem(),
        SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB.asItem(), SMBBlocks.SANDSTONE_TILE_SLAB.asItem(),
        SMBBlocks.POLISHED_ICE_SLAB.asItem(), SMBBlocks.ICE_BRICK_SLAB.asItem(),
        SMBBlocks.ICE_TILE_SLAB.asItem(), SMBBlocks.POLISHED_PURPUR_SLAB.asItem(),
        SMBBlocks.SMOOTH_PURPUR_SLAB.asItem(), SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB.asItem(),
        SMBBlocks.PURPUR_TILE_SLAB.asItem(), SMBBlocks.SOUL_SANDSTONE_SLAB.asItem(),
        SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.asItem(), SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.asItem(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB.asItem(), SMBBlocks.SOUL_SANDSTONE_TILE_SLAB.asItem(),
        SMBBlocks.MOSSY_BRICK_SLAB.asItem(), SMBBlocks.BONE_BRICK_SLAB.asItem(),
        SMBBlocks.BONE_TILE_SLAB.asItem(),

        /* 1.21.4 */
        SMBBlocks.POLISHED_RESIN_SLAB.asItem(), SMBBlocks.RESIN_TILE_SLAB.asItem(),
        SMBBlocks.SMOOTH_RESIN_SLAB.asItem());

    getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).setReplace(false).add(SMBBlocks.LUMINOUS_FLOWER.asItem());

    getOrCreateTagBuilder(ItemTags.SPRUCE_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_SPRUCE_LOG.asItem(), SMBBlocks.CARVED_SPRUCE_WOOD.asItem());

    getOrCreateTagBuilder(ItemTags.STAIRS).setReplace(false)
      .add(
        SMBBlocks.PACKED_SNOW_STAIRS.asItem(), SMBBlocks.POLISHED_SNOW_STAIRS.asItem(),
        SMBBlocks.SNOW_BRICK_STAIRS.asItem(), SMBBlocks.SNOW_TILE_STAIRS.asItem(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.asItem(), SMBBlocks.POLISHED_STONE_STAIRS.asItem(),
        SMBBlocks.STONE_TILE_STAIRS.asItem(), SMBBlocks.GRANITE_BRICK_STAIRS.asItem(),
        SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS.asItem(), SMBBlocks.GRANITE_TILE_STAIRS.asItem(),
        SMBBlocks.DIORITE_BRICK_STAIRS.asItem(), SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS.asItem(),
        SMBBlocks.DIORITE_TILE_STAIRS.asItem(), SMBBlocks.ANDESITE_BRICK_STAIRS.asItem(),
        SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS.asItem(), SMBBlocks.ANDESITE_TILE_STAIRS.asItem(),
        SMBBlocks.POLISHED_END_STONE_STAIRS.asItem(), SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS.asItem(),
        SMBBlocks.END_STONE_TILE_STAIRS.asItem(), SMBBlocks.MOSSY_TUFF_BRICK_STAIRS.asItem(),
        SMBBlocks.TUFF_TILE_STAIRS.asItem(), SMBBlocks.RED_SANDSTONE_BRICK_STAIRS.asItem(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS.asItem(), SMBBlocks.RED_SANDSTONE_TILE_STAIRS.asItem(),
        SMBBlocks.POLISHED_CALCITE_STAIRS.asItem(), SMBBlocks.CALCITE_BRICK_STAIRS.asItem(),
        SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS.asItem(), SMBBlocks.CALCITE_TILE_STAIRS.asItem(),
        SMBBlocks.POLISHED_DRIPSTONE_STAIRS.asItem(), SMBBlocks.DRIPSTONE_BRICK_STAIRS.asItem(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.asItem(), SMBBlocks.DRIPSTONE_TILE_STAIRS.asItem(),
        SMBBlocks.POLISHED_PRISMARINE_STAIRS.asItem(), SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS.asItem(),
        SMBBlocks.PRISMARINE_TILE_STAIRS.asItem(), SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS.asItem(),
        SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS.asItem(), SMBBlocks.POLISHED_MUD_STAIRS.asItem(),
        SMBBlocks.MOSSY_MUD_BRICK_STAIRS.asItem(), SMBBlocks.MUD_TILE_STAIRS.asItem(),
        SMBBlocks.SANDSTONE_BRICK_STAIRS.asItem(), SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS.asItem(),
        SMBBlocks.SANDSTONE_TILE_STAIRS.asItem(), SMBBlocks.POLISHED_ICE_STAIRS.asItem(),
        SMBBlocks.ICE_BRICK_STAIRS.asItem(), SMBBlocks.ICE_TILE_STAIRS.asItem(),
        SMBBlocks.POLISHED_PURPUR_STAIRS.asItem(), SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS.asItem(),
        SMBBlocks.PURPUR_TILE_STAIRS.asItem(), SMBBlocks.SOUL_SANDSTONE_STAIRS.asItem(),
        SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.asItem(), SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS.asItem(),
        SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS.asItem(), SMBBlocks.MOSSY_BRICK_STAIRS.asItem(),
        SMBBlocks.BONE_BRICK_STAIRS.asItem(), SMBBlocks.BONE_TILE_STAIRS.asItem(),

        /* 1.21.4 */
        SMBBlocks.POLISHED_RESIN_STAIRS.asItem(), SMBBlocks.RESIN_TILE_STAIRS.asItem()
      );

    getOrCreateTagBuilder(ItemTags.WALLS).setReplace(false)
      .add(
        SMBBlocks.SNOW_BRICK_WALL.asItem(), SMBBlocks.SNOW_TILE_WALL.asItem(),
        SMBBlocks.MOSSY_DEEPSLATE_BRICK_WALL.asItem(), SMBBlocks.STONE_TILE_WALL.asItem(),
        SMBBlocks.GRANITE_BRICK_WALL.asItem(), SMBBlocks.MOSSY_GRANITE_BRICK_WALL.asItem(),
        SMBBlocks.GRANITE_TILE_WALL.asItem(), SMBBlocks.DIORITE_BRICK_WALL.asItem(),
        SMBBlocks.MOSSY_DIORITE_BRICK_WALL.asItem(), SMBBlocks.DIORITE_TILE_WALL.asItem(),
        SMBBlocks.ANDESITE_BRICK_WALL.asItem(), SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.asItem(),
        SMBBlocks.ANDESITE_TILE_WALL.asItem(), SMBBlocks.MOSSY_END_STONE_BRICK_WALL.asItem(),
        SMBBlocks.END_STONE_TILE_WALL.asItem(), SMBBlocks.MOSSY_TUFF_BRICK_WALL.asItem(),
        SMBBlocks.TUFF_TILE_WALL.asItem(), SMBBlocks.RED_SANDSTONE_BRICK_WALL.asItem(),
        SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.asItem(), SMBBlocks.RED_SANDSTONE_TILE_WALL.asItem(),
        SMBBlocks.CALCITE_BRICK_WALL.asItem(), SMBBlocks.MOSSY_CALCITE_BRICK_WALL.asItem(),
        SMBBlocks.CALCITE_TILE_WALL.asItem(), SMBBlocks.DRIPSTONE_BRICK_WALL.asItem(),
        SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.asItem(), SMBBlocks.DRIPSTONE_TILE_WALL.asItem(),
        SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.asItem(), SMBBlocks.PRISMARINE_TILE_WALL.asItem(),
        SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.asItem(), SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.asItem(),
        SMBBlocks.MOSSY_MUD_BRICK_WALL.asItem(), SMBBlocks.MUD_TILE_WALL.asItem(),
        SMBBlocks.SANDSTONE_BRICK_WALL.asItem(), SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.asItem(),
        SMBBlocks.SANDSTONE_TILE_WALL.asItem(), SMBBlocks.ICE_BRICK_WALL.asItem(),
        SMBBlocks.ICE_TILE_WALL.asItem(), SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.asItem(),
        SMBBlocks.PURPUR_TILE_WALL.asItem(), SMBBlocks.SOUL_SANDSTONE_WALL.asItem(),
        SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.asItem(), SMBBlocks.SOUL_SANDSTONE_TILE_WALL.asItem(),
        SMBBlocks.MOSSY_BRICK_WALL.asItem(), SMBBlocks.BONE_BRICK_WALL.asItem(),
        SMBBlocks.BONE_TILE_WALL.asItem(),

        /* 1.21.4 */
        SMBBlocks.RESIN_TILE_WALL.asItem()
      );

    getOrCreateTagBuilder(ItemTags.WARPED_STEMS).setReplace(false)
      .add(SMBBlocks.CARVED_WARPED_STEM.asItem(), SMBBlocks.CARVED_WARPED_HYPHAE.asItem());

    getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC_SLAB.asItem(), SMBBlocks.SPRUCE_MOSAIC_SLAB.asItem(),
        SMBBlocks.BIRCH_MOSAIC_SLAB.asItem(), SMBBlocks.JUNGLE_MOSAIC_SLAB.asItem(),
        SMBBlocks.ACACIA_MOSAIC_SLAB.asItem(), SMBBlocks.DARK_OAK_MOSAIC_SLAB.asItem(),
        SMBBlocks.MANGROVE_MOSAIC_SLAB.asItem(), SMBBlocks.CRIMSON_MOSAIC_SLAB.asItem(),
        SMBBlocks.WARPED_MOSAIC_SLAB.asItem(), SMBBlocks.CHERRY_MOSAIC_SLAB.asItem(),

        /* 1.21.4 */
        SMBBlocks.PALE_OAK_MOSAIC_SLAB.asItem()
      );

    getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).setReplace(false)
      .add(
        SMBBlocks.OAK_MOSAIC_SLAB.asItem(), SMBBlocks.SPRUCE_MOSAIC_STAIRS.asItem(),
        SMBBlocks.BIRCH_MOSAIC_STAIRS.asItem(), SMBBlocks.JUNGLE_MOSAIC_STAIRS.asItem(),
        SMBBlocks.ACACIA_MOSAIC_STAIRS.asItem(), SMBBlocks.DARK_OAK_MOSAIC_STAIRS.asItem(),
        SMBBlocks.MANGROVE_MOSAIC_STAIRS.asItem(), SMBBlocks.CRIMSON_MOSAIC_STAIRS.asItem(),
        SMBBlocks.WARPED_MOSAIC_STAIRS.asItem(), SMBBlocks.CHERRY_MOSAIC_STAIRS.asItem(),

        /* 1.21.4 */
        SMBBlocks.PALE_OAK_MOSAIC_STAIRS.asItem()
      );

    /* 1.21.4 */
    getOrCreateTagBuilder(ItemTags.PALE_OAK_LOGS).setReplace(false)
      .add(SMBBlocks.CARVED_PALE_OAK_LOG.asItem(), SMBBlocks.CARVED_PALE_OAK_WOOD.asItem());
  }
}
