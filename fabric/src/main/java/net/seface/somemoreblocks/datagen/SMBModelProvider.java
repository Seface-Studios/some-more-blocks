package net.seface.somemoreblocks.datagen;

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

    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.TILED_GLASS, Blocks.GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.WHITE_STAINED_TILED_GLASS, Blocks.WHITE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.GRAY_STAINED_TILED_GLASS, Blocks.GRAY_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BLACK_STAINED_TILED_GLASS, Blocks.BLACK_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BROWN_STAINED_TILED_GLASS, Blocks.BROWN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.RED_STAINED_TILED_GLASS, Blocks.RED_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.ORANGE_STAINED_TILED_GLASS, Blocks.ORANGE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.YELLOW_STAINED_TILED_GLASS, Blocks.YELLOW_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIME_STAINED_TILED_GLASS, Blocks.LIME_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.GREEN_STAINED_TILED_GLASS, Blocks.GREEN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.CYAN_STAINED_TILED_GLASS, Blocks.CYAN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BLUE_STAINED_TILED_GLASS, Blocks.BLUE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.PURPLE_STAINED_TILED_GLASS, Blocks.PURPLE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.MAGENTA_STAINED_TILED_GLASS, Blocks.MAGENTA_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.PINK_STAINED_TILED_GLASS, Blocks.PINK_STAINED_GLASS_PANE);

    /* 1.21.4 */
    SMBBlockStateTemplates.createCarvedPaleOakBlock(SMBBlocks.CARVED_PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG);
    /*SMBBlockStateTemplates.createCarvedLogAndWoodBlocks(SMBBlocks.CARVED_PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_LOG);*/
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.PALE_OAK_MOSAIC);
    SMBBlockStateTemplates.createStairsBlock(SMBBlocks.PALE_OAK_MOSAIC_STAIRS, SMBBlocks.PALE_OAK_MOSAIC);
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.PALE_OAK_MOSAIC_SLAB, SMBBlocks.PALE_OAK_MOSAIC);
    SMBBlockStateTemplates.createRotatedPillarBlock(SMBBlocks.RESINE_PILLAR);
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.CRACKED_RESINE_BRICKS);
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.CRACKED_RESINE_TILES);
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.POLISHED_RESINE);
    SMBBlockStateTemplates.createStairsBlock(SMBBlocks.POLISHED_RESINE_STAIRS, SMBBlocks.POLISHED_RESINE);
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.POLISHED_RESINE_SLAB, SMBBlocks.POLISHED_RESINE);
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.RESINE_TILES);
    SMBBlockStateTemplates.createStairsBlock(SMBBlocks.RESINE_TILE_STAIRS, SMBBlocks.RESINE_TILES);
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.RESINE_TILE_SLAB, SMBBlocks.RESINE_TILES);
    SMBBlockStateTemplates.createWallBlock(SMBBlocks.RESINE_TILE_WALL, SMBBlocks.RESINE_TILES);
    SMBBlockStateTemplates.createGenericBlock(SMBBlocks.SMOOTH_RESINE);
    SMBBlockStateTemplates.createSlabBlock(SMBBlocks.SMOOTH_RESINE_SLAB, SMBBlocks.SMOOTH_RESINE);
  }

  @Override
  public void generateItemModels(ItemModelGenerators gen) {
    ITEM_MODEL_GENERATOR = gen;

    // More Building Blocks
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.STONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.GRANITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.GRANITE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_GRANITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DIORITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DIORITE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_DIORITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ANDESITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ANDESITE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_ANDESITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_DEEPSLATE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.CALCITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.CALCITE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_CALCITE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.TUFF_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_TUFF_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DRIPSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.DRIPSTONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MUD_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_MUD_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SANDSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SANDSTONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.RED_SANDSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.RED_SANDSTONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.PRISMARINE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.END_STONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_END_STONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.PURPUR_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.MOSSY_PURPUR_BLOCK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.BONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.BONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SNOW_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SNOW_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ICE_BRICK_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.ICE_TILE_WALL);
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.RESINE_TILE_WALL);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.CRACKED_COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.COPPER_PILLAR);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.CRACKED_CUT_COPPER);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_COPPER_PILLAR);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_COPPER_PILLAR);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_COPPER_PILLAR);
    SMBItemsTemplates.createWaxeableBlockItemModel(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER);

    // More Colored Blocks
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.RED_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE);

    // More Natural Blocks
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TINY_CACTUS);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.DUNE_GRASS);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_DUNE_GRASS);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.SHORT_SNOW_GRASS);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_SNOW_GRASS);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.SNOW_FERN);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LARGE_SNOW_FERN);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.CATTAIL);
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.LEAVES_BUCKET);
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.BIRCH_LEAVES_BUCKET);
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.SPRUCE_LEAVES_BUCKET);
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.PALE_OAK_LEAVES_BUCKET);
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.AZALEA_LEAVES_BUCKET);
    SMBItemsTemplates.createLeavesBucketItemModel(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.SMALL_LILY_PADS);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.LUMINOUS_FLOWER);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BIG_LILY_PAD);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.BROWN_MUSHROOM_COLONY);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.RED_MUSHROOM_COLONY);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_RED_MUSHROOM_COLONY);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.CRIMSON_FUNGUS_COLONY);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.WARPED_FUNGUS_COLONY);
    SMBItemsTemplates.createGenericItemModel(SMBBlocks.TALL_WARPED_FUNGUS_COLONY);

    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_LOG);
    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_WOOD);
  }
}
