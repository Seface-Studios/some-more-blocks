package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.datagen.templates.SMBBlockStateTemplates;
import net.seface.somemoreblocks.datagen.templates.SMBItemsTemplates;
import net.seface.somemoreblocks.registries.SMBBlockFamilies;
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

    gen.family(SMBBlocks.ACACIA_MOSAIC.get()).generateFor(SMBBlockFamilies.ACACIA_MOSAIC);
    gen.family(SMBBlocks.BIRCH_MOSAIC.get()).generateFor(SMBBlockFamilies.BIRCH_MOSAIC);
    gen.family(SMBBlocks.CHERRY_MOSAIC.get()).generateFor(SMBBlockFamilies.CHERRY_MOSAIC);
    gen.family(SMBBlocks.CRIMSON_MOSAIC.get()).generateFor(SMBBlockFamilies.CRIMSON_MOSAIC);
    gen.family(SMBBlocks.DARK_OAK_MOSAIC.get()).generateFor(SMBBlockFamilies.DARK_OAK_MOSAIC);
    gen.family(SMBBlocks.JUNGLE_MOSAIC.get()).generateFor(SMBBlockFamilies.JUNGLE_MOSAIC);
    gen.family(SMBBlocks.MANGROVE_MOSAIC.get()).generateFor(SMBBlockFamilies.MANGROVE_MOSAIC);
    gen.family(SMBBlocks.OAK_MOSAIC.get()).generateFor(SMBBlockFamilies.OAK_MOSAIC);
    gen.family(SMBBlocks.PALE_OAK_MOSAIC.get()).generateFor(SMBBlockFamilies.PALE_OAK_MOSAIC);
    gen.family(SMBBlocks.SPRUCE_MOSAIC.get()).generateFor(SMBBlockFamilies.SPRUCE_MOSAIC);
    gen.family(SMBBlocks.WARPED_MOSAIC.get()).generateFor(SMBBlockFamilies.WARPED_MOSAIC);
    createCarvedGenericBlocks(SMBBlocks.CARVED_OAK_LOG.get(), Blocks.STRIPPED_OAK_LOG);
    createCarvedGenericBlocks(SMBBlocks.CARVED_SPRUCE_LOG.get(), Blocks.STRIPPED_SPRUCE_LOG);
    createCarvedGenericBlocks(SMBBlocks.CARVED_BIRCH_LOG.get(), Blocks.STRIPPED_BIRCH_LOG);
    createCarvedGenericBlocks(SMBBlocks.CARVED_JUNGLE_LOG.get(), Blocks.STRIPPED_JUNGLE_LOG);
    createCarvedGenericBlocks(SMBBlocks.CARVED_ACACIA_LOG.get(), Blocks.STRIPPED_ACACIA_LOG);
    createCarvedGenericBlocks(SMBBlocks.CARVED_DARK_OAK_LOG.get(), Blocks.STRIPPED_DARK_OAK_LOG);
    createCarvedGenericBlocks(SMBBlocks.CARVED_MANGROVE_LOG.get(), Blocks.STRIPPED_MANGROVE_LOG);
    createCarvedGenericBlocks(SMBBlocks.CARVED_CRIMSON_STEM.get(), Blocks.STRIPPED_CRIMSON_STEM);
    createCarvedGenericBlocks(SMBBlocks.CARVED_WARPED_STEM.get(), Blocks.STRIPPED_WARPED_STEM);
    createCarvedGenericBlocks(SMBBlocks.CARVED_CHERRY_LOG.get(), Blocks.STRIPPED_CHERRY_LOG);
    createCarvedPaleOakBlocks(SMBBlocks.CARVED_PALE_OAK_LOG.get(), Blocks.STRIPPED_PALE_OAK_LOG);
    createRotatedPillarBlock(SMBBlocks.CARVED_BAMBOO_BLOCK.get(), Blocks.STRIPPED_BAMBOO_BLOCK, false);
    gen.family(SMBBlocks.POLISHED_STONE.get()).generateFor(SMBBlockFamilies.POLISHED_STONE);
    createRotatedPillarBlock(SMBBlocks.STONE_PILLAR.get(), false);
    gen.family(SMBBlocks.STONE_TILES.get()).generateFor(SMBBlockFamilies.STONE_TILES);
    gen.family(SMBBlocks.GRANITE_BRICKS.get()).generateFor(SMBBlockFamilies.GRANITE_BRICKS);
    createRotatedPillarBlock(SMBBlocks.GRANITE_PILLAR.get(), false);
    gen.family(SMBBlocks.GRANITE_TILES.get()).generateFor(SMBBlockFamilies.GRANITE_TILES);
    gen.family(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_GRANITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_GRANITE.get()).generateFor(SMBBlockFamilies.SMOOTH_GRANITE);
    gen.family(SMBBlocks.DIORITE_BRICKS.get()).generateFor(SMBBlockFamilies.DIORITE_BRICKS);
    createRotatedPillarBlock(SMBBlocks.DIORITE_PILLAR.get(), false);
    gen.family(SMBBlocks.DIORITE_TILES.get()).generateFor(SMBBlockFamilies.DIORITE_TILES);
    gen.family(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_DIORITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_DIORITE.get()).generateFor(SMBBlockFamilies.SMOOTH_DIORITE);
    gen.family(SMBBlocks.ANDESITE_BRICKS.get()).generateFor(SMBBlockFamilies.ANDESITE_BRICKS);
    createRotatedPillarBlock(SMBBlocks.ANDESITE_PILLAR.get(), false);
    gen.family(SMBBlocks.ANDESITE_TILES.get()).generateFor(SMBBlockFamilies.ANDESITE_TILES);
    gen.family(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_ANDESITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_ANDESITE.get()).generateFor(SMBBlockFamilies.SMOOTH_ANDESITE);
    createRotatedPillarBlock(SMBBlocks.DEEPSLATE_PILLAR.get(), false);
    gen.family(SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_DEEPSLATE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_DEEPSLATE.get()).generateFor(SMBBlockFamilies.SMOOTH_DEEPSLATE);
    gen.family(SMBBlocks.POLISHED_CALCITE.get()).generateFor(SMBBlockFamilies.POLISHED_CALCITE);
    gen.family(SMBBlocks.CALCITE_BRICKS.get()).generateFor(SMBBlockFamilies.CALCITE_BRICKS);
    createRotatedPillarBlock(SMBBlocks.CALCITE_PILLAR.get(), false);
    gen.family(SMBBlocks.CALCITE_TILES.get()).generateFor(SMBBlockFamilies.CALCITE_TILES);
    gen.family(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_CALCITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_CALCITE.get()).generateFor(SMBBlockFamilies.SMOOTH_CALCITE);
    gen.createTrivialCube(SMBBlocks.CRACKED_TUFF_BRICKS.get());
    createRotatedPillarBlock(SMBBlocks.TUFF_PILLAR.get(), false);
    gen.family(SMBBlocks.TUFF_TILES.get()).generateFor(SMBBlockFamilies.TUFF_TILES);
    gen.family(SMBBlocks.MOSSY_TUFF_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_TUFF_BRICKS);
    gen.family(SMBBlocks.SMOOTH_TUFF.get()).generateFor(SMBBlockFamilies.SMOOTH_TUFF);
    gen.family(SMBBlocks.POLISHED_DRIPSTONE.get()).generateFor(SMBBlockFamilies.POLISHED_DRIPSTONE);
    gen.family(SMBBlocks.DRIPSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.DRIPSTONE_BRICKS);
    createRotatedPillarBlock(SMBBlocks.DRIPSTONE_PILLAR.get(), false);
    gen.family(SMBBlocks.DRIPSTONE_TILES.get()).generateFor(SMBBlockFamilies.DRIPSTONE_TILES);
    gen.family(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_DRIPSTONE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_DRIPSTONE.get()).generateFor(SMBBlockFamilies.SMOOTH_DRIPSTONE);
    gen.createTrivialCube(SMBBlocks.CRACKED_BRICKS.get());
    gen.family(SMBBlocks.MOSSY_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_BRICKS);
    gen.createTrivialCube(SMBBlocks.CHISELED_MUD_BRICKS.get());
    createRotatedPillarBlock(SMBBlocks.MUD_PILLAR.get(), false);
    gen.createTrivialCube(SMBBlocks.CRACKED_MUD_BRICKS.get());
    gen.family(SMBBlocks.POLISHED_MUD.get()).generateFor(SMBBlockFamilies.POLISHED_MUD);
    gen.family(SMBBlocks.MUD_TILES.get()).generateFor(SMBBlockFamilies.MUD_TILES);
    gen.family(SMBBlocks.MOSSY_MUD_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_MUD_BRICKS);
    gen.family(SMBBlocks.SMOOTH_MUD.get()).generateFor(SMBBlockFamilies.SMOOTH_MUD);

    /* Testing */







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
    SMBBlockStateTemplates.createRotatedPillarBlock(SMBBlocks.RESIN_PILLAR.get());
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
    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_LOG.get());
    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_WOOD.get());

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
  }

  public static void createRotatedPillarBlock(Block block, boolean ignoreHorizontal) {
    createRotatedPillarBlock(block, block, ignoreHorizontal);
  }

  /**
   * Create Pillar-Like model block.
   * @param block
   * @param topBlock
   * @param ignoreHorizontal
   */
  public static void createRotatedPillarBlock(Block block, Block topBlock, boolean ignoreHorizontal) {
    ResourceLocation vertical = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
    ResourceLocation horizontal = ignoreHorizontal ? vertical : vertical.withSuffix("_horizontal");

    ModelTemplates.CUBE_COLUMN.create(
      ModelLocationUtils.getModelLocation(block),
      TextureMapping.column(block)
        .put(TextureSlot.END, ModelLocationUtils.getModelLocation(topBlock).withSuffix(ignoreHorizontal ? "" : "_top"))
        .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(block)),
      BLOCK_STATE_GENERATOR.modelOutput);

    if (!ignoreHorizontal) {
      ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(
        ModelLocationUtils.getModelLocation(block).withSuffix("_horizontal"),
        TextureMapping.column(block)
          .put(TextureSlot.END, ModelLocationUtils.getModelLocation(topBlock).withSuffix("_top"))
          .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(block)),
        BLOCK_STATE_GENERATOR.modelOutput);
    }

    BLOCK_STATE_GENERATOR.blockStateOutput.accept(
      MultiVariantGenerator.multiVariant(block).with(
        PropertyDispatch.property(BlockStateProperties.AXIS)
          // axis=x
          .select(Direction.Axis.X, Variant.variant()
            .with(VariantProperties.MODEL, horizontal)
            .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
            .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))

          // axis=y
          .select(Direction.Axis.Y, Variant.variant()
            .with(VariantProperties.MODEL, vertical))

          // axis=z
          .select(Direction.Axis.Z, Variant.variant()
            .with(VariantProperties.MODEL, horizontal)
            .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)))
    );
  }

  /**
   * Create Carved Pale Oak Log/Wood block models.
   * @param logBlock
   * @param strippedLogBlock
   */
  public static void createCarvedGenericBlocks(Block logBlock, Block strippedLogBlock) {
    ResourceLocation identifier = BuiltInRegistries.BLOCK.getKey(logBlock);

    if (identifier.getPath().contains("_wood") || identifier.getPath().contains("_hyphae")) {
      throw new IllegalArgumentException("Don't try to register Carved Wood/Hyphae blocks. Use Carved Logs instead, the wood/hyphae variation will be auto-generated.");
    }

    String futureSuffix = identifier.getPath().contains("log") ? "wood" : "hyphae";

    ResourceLocation woodOrHyphae = futureSuffix.equals("wood") ?
      ResourceLocation.parse(identifier.toString().replace("log", "wood")) :
      ResourceLocation.parse(identifier.toString().replace("stem", "hyphae"));

    ResourceLocation[] variations = { identifier, woodOrHyphae };

    for (ResourceLocation id : variations) {
      boolean isWoodOrHyphae = id.toString().contains("_" + futureSuffix);
      Block block = isWoodOrHyphae ? BuiltInRegistries.BLOCK.getValue(id) : logBlock;

      ModelTemplates.CUBE_COLUMN.create(
        ModelLocationUtils.getModelLocation(block),
        TextureMapping.column(block)
          .put(TextureSlot.END, ModelLocationUtils.getModelLocation(isWoodOrHyphae ? logBlock : strippedLogBlock).withSuffix(isWoodOrHyphae ? "" : "_top"))
          .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(logBlock)),
        SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

      if (!isWoodOrHyphae) {
        ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(
          ModelLocationUtils.getModelLocation(block).withSuffix("_horizontal"),
          TextureMapping.column(block)
            .put(TextureSlot.END, ModelLocationUtils.getModelLocation(strippedLogBlock).withSuffix("_top"))
            .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(logBlock)),
          SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
      }

      /* Block State */
      ResourceLocation vertical = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
      ResourceLocation horizontal = vertical.withSuffix(isWoodOrHyphae ? "" : "_horizontal");

      SMBModelProvider.BLOCK_STATE_GENERATOR.blockStateOutput.accept(
        MultiVariantGenerator.multiVariant(block).with(
          PropertyDispatch.property(BlockStateProperties.AXIS)
            // axis=x
            .select(Direction.Axis.X, Variant.variant()
              .with(VariantProperties.MODEL, horizontal)
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))

            // axis=y
            .select(Direction.Axis.Y, Variant.variant()
              .with(VariantProperties.MODEL, vertical))

            // axis=z
            .select(Direction.Axis.Z, Variant.variant()
              .with(VariantProperties.MODEL, horizontal)
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))));
    }
  }

  /**
   * Create Carved Pale Oak Log/Wood block models.
   * @param logBlock
   * @param strippedLogBlock
   */
  public static void createCarvedPaleOakBlocks(Block logBlock, Block strippedLogBlock) {
    ResourceLocation identifier = BuiltInRegistries.BLOCK.getKey(logBlock);

    if (identifier.getPath().contains("_wood")) {
      throw new IllegalArgumentException("Don't try to register Carved Pale Wood blocks. Use Carved Logs instead, the wood variation will be auto-generated.");
    }

    ResourceLocation woodIdentifier = ResourceLocation.parse(identifier.toString().replace("log", "wood"));
    ResourceLocation[] variations = { identifier, woodIdentifier };

    for (ResourceLocation id : variations) {
      boolean isWood = id.toString().contains("_wood");
      Block block = isWood ? BuiltInRegistries.BLOCK.getValue(id) : logBlock;

      for (int i = 0; i <= 7; i++) {
        String suffix = "_" + i;

        ModelTemplates.CUBE_COLUMN.create(
          ModelLocationUtils.getModelLocation(block).withSuffix(suffix),
          TextureMapping.column(block)
            .put(TextureSlot.END, ModelLocationUtils.getModelLocation(isWood ? logBlock : strippedLogBlock).withSuffix(isWood ? suffix : "_top"))
            .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(logBlock).withSuffix(suffix)),
          SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

        if (!isWood) {
          ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(
            ModelLocationUtils.getModelLocation(block).withSuffix(suffix + "_horizontal"),
            TextureMapping.column(block)
              .put(TextureSlot.END, ModelLocationUtils.getModelLocation(strippedLogBlock).withSuffix("_top"))
              .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(logBlock).withSuffix(suffix)),
            SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
        }
      }

      /* Block State */
      ResourceLocation vertical = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");

      SMBModelProvider.BLOCK_STATE_GENERATOR.blockStateOutput.accept(
        MultiVariantGenerator.multiVariant(block).with(
          PropertyDispatch.properties(BlockStateProperties.AXIS, RotatedCarvedPaleOakBlock.MOON_PHASE)
            // axis=x,moon_phase=int
            .select(Direction.Axis.X, 0, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_0").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.X, 1, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_1").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.X, 2, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_2").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.X, 3, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_3").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.X, 4, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_4").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.X, 5, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_5").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.X, 6, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_6").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.X, 7, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_7").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
              .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))

            // axis=y,moon_phase=int
            .select(Direction.Axis.Y, 0, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_0")))
            .select(Direction.Axis.Y, 1, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_1")))
            .select(Direction.Axis.Y, 2, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_2")))
            .select(Direction.Axis.Y, 3, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_3")))
            .select(Direction.Axis.Y, 4, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_4")))
            .select(Direction.Axis.Y, 5, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_5")))
            .select(Direction.Axis.Y, 6, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_6")))
            .select(Direction.Axis.Y, 7, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_7")))

            // axis=z,moon_phase=int
            .select(Direction.Axis.Z, 0, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_0").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.Z, 1, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_1").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.Z, 2, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_2").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.Z, 3, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_3").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.Z, 4, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_4").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.Z, 5, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_5").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.Z, 6, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_6").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
            .select(Direction.Axis.Z, 7, Variant.variant()
              .with(VariantProperties.MODEL, vertical.withSuffix("_7").withSuffix(isWood ? "" : "_horizontal"))
              .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90))
        ));
    }
  }
}
