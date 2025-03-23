package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.datagen.templates.SMBBlockStateTemplates;
import net.seface.somemoreblocks.datagen.templates.SMBItemsTemplates;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBItems;

public class SMBModelProvider extends FabricModelProvider {
  public static BlockModelGenerators BLOCK_STATE_GENERATOR;
  public static ItemModelGenerators ITEM_MODEL_GENERATOR;
  private FabricDataOutput output;

  public SMBModelProvider(FabricDataOutput output) {
    super(output);

    this.output = output;
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators gen) {
    BLOCK_STATE_GENERATOR = gen;

    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.TILED_GLASS.get(), Blocks.GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.WHITE_STAINED_TILED_GLASS.get(), Blocks.WHITE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(), Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.GRAY_STAINED_TILED_GLASS.get(), Blocks.GRAY_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BLACK_STAINED_TILED_GLASS.get(), Blocks.BLACK_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BROWN_STAINED_TILED_GLASS.get(), Blocks.BROWN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.RED_STAINED_TILED_GLASS.get(), Blocks.RED_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get(), Blocks.ORANGE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get(), Blocks.YELLOW_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIME_STAINED_TILED_GLASS.get(), Blocks.LIME_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.GREEN_STAINED_TILED_GLASS.get(), Blocks.GREEN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.CYAN_STAINED_TILED_GLASS.get(), Blocks.CYAN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(), Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BLUE_STAINED_TILED_GLASS.get(), Blocks.BLUE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get(), Blocks.PURPLE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get(), Blocks.MAGENTA_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.PINK_STAINED_TILED_GLASS.get(), Blocks.PINK_STAINED_GLASS_PANE);

    /* 1.21.4 */
    SMBBlockStateTemplates.createCarvedPaleOakBlock(SMBBlocks.CARVED_PALE_OAK_LOG.get(), Blocks.STRIPPED_PALE_OAK_LOG);
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.PALE_OAK_MOSAIC.get());
    SMBBlockStateTemplates.createStairsBlock(SMBBlocks.PALE_OAK_MOSAIC_STAIRS.get(), SMBBlocks.PALE_OAK_MOSAIC.get());
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.PALE_OAK_MOSAIC_SLAB.get(), SMBBlocks.PALE_OAK_MOSAIC.get());
    SMBBlockStateTemplates.createRotatedPillarBlock(SMBBlocks.RESINE_PILLAR.get());
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.CRACKED_RESIN_BRICKS.get());
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.CRACKED_RESIN_TILES.get());
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.POLISHED_RESIN.get());
    SMBBlockStateTemplates.createStairsBlock(SMBBlocks.POLISHED_RESIN_STAIRS.get(), SMBBlocks.POLISHED_RESIN.get());
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.POLISHED_RESIN_SLAB.get(), SMBBlocks.POLISHED_RESIN.get());
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.RESIN_TILES.get());
    SMBBlockStateTemplates.createStairsBlock(SMBBlocks.RESIN_TILE_STAIRS.get(), SMBBlocks.RESIN_TILES.get());
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.RESIN_TILE_SLAB.get(), SMBBlocks.RESIN_TILES.get());
    SMBBlockStateTemplates.createWallBlock(SMBBlocks.RESIN_TILE_WALL.get(), SMBBlocks.RESIN_TILES.get());
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.SMOOTH_RESIN.get());
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.SMOOTH_RESIN_SLAB.get(), SMBBlocks.SMOOTH_RESIN.get());
  }

  @Override
  public void generateItemModels(ItemModelGenerators gen) {
    ITEM_MODEL_GENERATOR = gen;

    // More Building Blocks
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.STONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.GRANITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.GRANITE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_GRANITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DIORITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DIORITE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_DIORITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ANDESITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ANDESITE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.CALCITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.CALCITE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_CALCITE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.TUFF_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_TUFF_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DRIPSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DRIPSTONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MUD_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_MUD_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SANDSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SANDSTONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.RED_SANDSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.RED_SANDSTONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.PRISMARINE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.END_STONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_END_STONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.PURPUR_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.BONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.BONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SNOW_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SNOW_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ICE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ICE_TILE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.RESIN_TILE_WALL.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.CRACKED_COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.COPPER_PILLAR.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.CRACKED_CUT_COPPER.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());

    // More Colored Blocks
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get());

    // More Natural Blocks
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TINY_CACTUS.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.DUNE_GRASS.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_DUNE_GRASS.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.SHORT_SNOW_GRASS.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_SNOW_GRASS.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.SNOW_FERN.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LARGE_SNOW_FERN.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.CATTAIL.get());
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.LEAVES_BUCKET.get());
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.BIRCH_LEAVES_BUCKET.get());
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.SPRUCE_LEAVES_BUCKET.get());
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.PALE_OAK_LEAVES_BUCKET.get());
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.AZALEA_LEAVES_BUCKET.get());
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.SMALL_LILY_PADS.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LUMINOUS_FLOWER.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BIG_LILY_PAD.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BROWN_MUSHROOM_COLONY.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.RED_MUSHROOM_COLONY.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.CRIMSON_FUNGUS_COLONY.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.WARPED_FUNGUS_COLONY.get());
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get());

    /* 1.21.4 */
    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_LOG.get());
    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_WOOD.get());
  }
}
