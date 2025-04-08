package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.seface.somemoreblocks.registries.SMBModelTemplates;
import net.seface.somemoreblocks.datagen.providers.models.CarvedWoodBlockProvider;
import net.seface.somemoreblocks.datagen.providers.models.TiledGlassBlockProvider;
import net.seface.somemoreblocks.datagen.templates.SMBItemsTemplates;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.registries.SMBBlockFamilies;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBItems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SMBModelProvider extends FabricModelProvider {
  public static ItemModelGenerators ITEM_MODEL_GENERATOR;
  public BiConsumer<ResourceLocation, ModelInstance> modelOutput;
  public Consumer<BlockStateGenerator> blockStateOutput;
  public ItemModelOutput itemModelOutput;
  private FabricDataOutput output;

  public SMBModelProvider(FabricDataOutput output) {
    super(output);

    this.output = output;
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators gen) {
    this.itemModelOutput = gen.itemModelOutput;
    this.blockStateOutput = gen.blockStateOutput;
    this.modelOutput = gen.modelOutput;

    /* More Building Blocks */
    this.carvedWoodProvider(SMBBlocks.CARVED_OAK_LOG.get()).log(SMBBlocks.CARVED_OAK_LOG.get(), Blocks.STRIPPED_OAK_LOG).wood(SMBBlocks.CARVED_OAK_WOOD.get());
    gen.family(SMBBlocks.OAK_MOSAIC.get()).generateFor(SMBBlockFamilies.OAK_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_SPRUCE_LOG.get()).log(SMBBlocks.CARVED_SPRUCE_LOG.get(), Blocks.STRIPPED_SPRUCE_LOG).wood(SMBBlocks.CARVED_SPRUCE_WOOD.get());
    gen.family(SMBBlocks.SPRUCE_MOSAIC.get()).generateFor(SMBBlockFamilies.SPRUCE_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_BIRCH_LOG.get()).log(SMBBlocks.CARVED_BIRCH_LOG.get(), Blocks.STRIPPED_BIRCH_LOG).wood(SMBBlocks.CARVED_BIRCH_WOOD.get());
    gen.family(SMBBlocks.BIRCH_MOSAIC.get()).generateFor(SMBBlockFamilies.BIRCH_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_JUNGLE_LOG.get()).log(SMBBlocks.CARVED_JUNGLE_LOG.get(), Blocks.STRIPPED_JUNGLE_LOG).wood(SMBBlocks.CARVED_JUNGLE_WOOD.get());
    gen.family(SMBBlocks.JUNGLE_MOSAIC.get()).generateFor(SMBBlockFamilies.JUNGLE_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_ACACIA_LOG.get()).log(SMBBlocks.CARVED_ACACIA_LOG.get(), Blocks.STRIPPED_ACACIA_LOG).wood(SMBBlocks.CARVED_ACACIA_WOOD.get());
    gen.family(SMBBlocks.ACACIA_MOSAIC.get()).generateFor(SMBBlockFamilies.ACACIA_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_DARK_OAK_LOG.get()).log(SMBBlocks.CARVED_DARK_OAK_LOG.get(), Blocks.STRIPPED_DARK_OAK_LOG).wood(SMBBlocks.CARVED_DARK_OAK_WOOD.get());
    gen.family(SMBBlocks.DARK_OAK_MOSAIC.get()).generateFor(SMBBlockFamilies.DARK_OAK_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_MANGROVE_LOG.get()).log(SMBBlocks.CARVED_MANGROVE_LOG.get(), Blocks.STRIPPED_MANGROVE_LOG).wood(SMBBlocks.CARVED_MANGROVE_WOOD.get());
    gen.family(SMBBlocks.MANGROVE_MOSAIC.get()).generateFor(SMBBlockFamilies.MANGROVE_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_CRIMSON_STEM.get()).log(SMBBlocks.CARVED_CRIMSON_STEM.get(), Blocks.STRIPPED_CRIMSON_STEM).wood(SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
    gen.family(SMBBlocks.CRIMSON_MOSAIC.get()).generateFor(SMBBlockFamilies.CRIMSON_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_WARPED_STEM.get()).log(SMBBlocks.CARVED_WARPED_STEM.get(), Blocks.STRIPPED_WARPED_STEM).wood(SMBBlocks.CARVED_WARPED_HYPHAE.get());
    gen.family(SMBBlocks.WARPED_MOSAIC.get()).generateFor(SMBBlockFamilies.WARPED_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_CHERRY_LOG.get()).log(SMBBlocks.CARVED_CHERRY_LOG.get(), Blocks.STRIPPED_CHERRY_LOG).wood(SMBBlocks.CARVED_CHERRY_WOOD.get());
    gen.family(SMBBlocks.CHERRY_MOSAIC.get()).generateFor(SMBBlockFamilies.CHERRY_MOSAIC);
    this.carvedWoodProvider(SMBBlocks.CARVED_BAMBOO_BLOCK.get()).log(SMBBlocks.CARVED_BAMBOO_BLOCK.get(), Blocks.STRIPPED_BAMBOO_BLOCK);
    this.carvedWoodProvider(SMBBlocks.CARVED_PALE_OAK_LOG.get()).logByMoonPhase(SMBBlocks.CARVED_PALE_OAK_LOG.get(), Blocks.STRIPPED_PALE_OAK_LOG).woodByMoonPhase(SMBBlocks.CARVED_PALE_OAK_WOOD.get());
    gen.family(SMBBlocks.PALE_OAK_MOSAIC.get()).generateFor(SMBBlockFamilies.PALE_OAK_MOSAIC);
    gen.family(SMBBlocks.POLISHED_STONE.get()).generateFor(SMBBlockFamilies.POLISHED_STONE);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.STONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.STONE_TILES.get()).generateFor(SMBBlockFamilies.STONE_TILES);
    gen.family(SMBBlocks.GRANITE_BRICKS.get()).generateFor(SMBBlockFamilies.GRANITE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.GRANITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.GRANITE_TILES.get()).generateFor(SMBBlockFamilies.GRANITE_TILES);
    gen.family(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_GRANITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_GRANITE.get()).generateFor(SMBBlockFamilies.SMOOTH_GRANITE);
    gen.family(SMBBlocks.DIORITE_BRICKS.get()).generateFor(SMBBlockFamilies.DIORITE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DIORITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.DIORITE_TILES.get()).generateFor(SMBBlockFamilies.DIORITE_TILES);
    gen.family(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_DIORITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_DIORITE.get()).generateFor(SMBBlockFamilies.SMOOTH_DIORITE);
    gen.family(SMBBlocks.ANDESITE_BRICKS.get()).generateFor(SMBBlockFamilies.ANDESITE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.ANDESITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.ANDESITE_TILES.get()).generateFor(SMBBlockFamilies.ANDESITE_TILES);
    gen.family(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_ANDESITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_ANDESITE.get()).generateFor(SMBBlockFamilies.SMOOTH_ANDESITE);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DEEPSLATE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_DEEPSLATE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_DEEPSLATE.get()).generateFor(SMBBlockFamilies.SMOOTH_DEEPSLATE);
    gen.family(SMBBlocks.POLISHED_CALCITE.get()).generateFor(SMBBlockFamilies.POLISHED_CALCITE);
    gen.family(SMBBlocks.CALCITE_BRICKS.get()).generateFor(SMBBlockFamilies.CALCITE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.CALCITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CALCITE_TILES.get()).generateFor(SMBBlockFamilies.CALCITE_TILES);
    gen.family(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_CALCITE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_CALCITE.get()).generateFor(SMBBlockFamilies.SMOOTH_CALCITE);
    gen.createTrivialCube(SMBBlocks.CRACKED_TUFF_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.TUFF_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.TUFF_TILES.get()).generateFor(SMBBlockFamilies.TUFF_TILES);
    gen.family(SMBBlocks.MOSSY_TUFF_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_TUFF_BRICKS);
    gen.family(SMBBlocks.SMOOTH_TUFF.get()).generateFor(SMBBlockFamilies.SMOOTH_TUFF);
    gen.family(SMBBlocks.POLISHED_DRIPSTONE.get()).generateFor(SMBBlockFamilies.POLISHED_DRIPSTONE);
    gen.family(SMBBlocks.DRIPSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.DRIPSTONE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DRIPSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.DRIPSTONE_TILES.get()).generateFor(SMBBlockFamilies.DRIPSTONE_TILES);
    gen.family(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_DRIPSTONE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_DRIPSTONE.get()).generateFor(SMBBlockFamilies.SMOOTH_DRIPSTONE);
    gen.createTrivialCube(SMBBlocks.CRACKED_BRICKS.get());
    gen.family(SMBBlocks.MOSSY_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_BRICKS);
    gen.createTrivialCube(SMBBlocks.CHISELED_MUD_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.MUD_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CRACKED_MUD_BRICKS.get());
    gen.family(SMBBlocks.POLISHED_MUD.get()).generateFor(SMBBlockFamilies.POLISHED_MUD);
    gen.family(SMBBlocks.MUD_TILES.get()).generateFor(SMBBlockFamilies.MUD_TILES);
    gen.family(SMBBlocks.MOSSY_MUD_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_MUD_BRICKS);
    gen.family(SMBBlocks.SMOOTH_MUD.get()).generateFor(SMBBlockFamilies.SMOOTH_MUD);
    gen.family(SMBBlocks.POLISHED_RESIN.get()).generateFor(SMBBlockFamilies.POLISHED_RESIN);
    gen.createTrivialCube(SMBBlocks.CRACKED_RESIN_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.RESIN_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.RESIN_TILES.get()).generateFor(SMBBlockFamilies.RESIN_TILES);
    gen.family(SMBBlocks.SMOOTH_RESIN.get()).generateFor(SMBBlockFamilies.SMOOTH_RESIN);
    gen.family(SMBBlocks.SANDSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.SANDSTONE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.SANDSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.SANDSTONE_TILES.get()).generateFor(SMBBlockFamilies.SANDSTONE_TILES);
    gen.family(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_SANDSTONE_BRICKS);
    gen.family(SMBBlocks.RED_SANDSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.RED_SANDSTONE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.RED_SANDSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.RED_SANDSTONE_TILES.get()).generateFor(SMBBlockFamilies.RED_SANDSTONE_TILES);
    gen.family(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_RED_SANDSTONE_BRICKS);
    gen.family(SMBBlocks.POLISHED_PRISMARINE.get()).generateFor(SMBBlockFamilies.POLISHED_PRISMARINE);
    gen.createTrivialCube(SMBBlocks.CHISELED_PRISMARINE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_PRISMARINE_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.PRISMARINE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.PRISMARINE_TILES.get()).generateFor(SMBBlockFamilies.PRISMARINE_TILES);
    gen.family(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_PRISMARINE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_PRISMARINE.get()).generateFor(SMBBlockFamilies.SMOOTH_PRISMARINE);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.NETHER_BRICKS_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CHISELED_RED_NETHER_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_RED_NETHER_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.RED_NETHER_BRICKS_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.POLISHED_BLACKSTONE_TILES.get()).generateFor(SMBBlockFamilies.POLISHED_BLACKSTONE_TILES);
    gen.family(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.CORRUPTED_POLISHED_BLACKSTONE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_BLACKSTONE.get()).generateFor(SMBBlockFamilies.SMOOTH_BLACKSTONE);
    gen.family(SMBBlocks.POLISHED_END_STONE.get()).generateFor(SMBBlockFamilies.POLISHED_END_STONE);
    gen.createTrivialCube(SMBBlocks.CHISELED_END_STONE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_END_STONE_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.END_STONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.END_STONE_TILES.get()).generateFor(SMBBlockFamilies.END_STONE_TILES);
    gen.family(SMBBlocks.MOSSY_END_STONE_BRICKS.get()).generateFor(SMBBlockFamilies.MOSSY_END_STONE_BRICKS);
    gen.family(SMBBlocks.SMOOTH_END_STONE.get()).generateFor(SMBBlockFamilies.SMOOTH_END_STONE);
    gen.family(SMBBlocks.POLISHED_PURPUR.get()).generateFor(SMBBlockFamilies.POLISHED_PURPUR);
    gen.createTrivialCube(SMBBlocks.CHISELED_PURPUR.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_PURPUR_BLOCK.get());
    gen.family(SMBBlocks.PURPUR_TILES.get()).generateFor(SMBBlockFamilies.PURPUR_TILES);
    gen.family(SMBBlocks.MOSSY_PURPUR_BLOCK.get()).generateFor(SMBBlockFamilies.MOSSY_PURPUR_BLOCK);
    gen.family(SMBBlocks.SMOOTH_PURPUR.get()).generateFor(SMBBlockFamilies.SMOOTH_PURPUR);
    gen.family(SMBBlocks.COAL_BRICKS.get()).generateFor(SMBBlockFamilies.COAL_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.COAL_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_COAL.get()).generateFor(SMBBlockFamilies.CUT_COAL);
    gen.family(SMBBlocks.IRON_BRICKS.get()).generateFor(SMBBlockFamilies.IRON_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.IRON_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_IRON.get()).generateFor(SMBBlockFamilies.CUT_IRON);
    gen.createTrivialCube(SMBBlocks.IRON_GRATE.get());
    gen.family(SMBBlocks.GOLD_BRICKS.get()).generateFor(SMBBlockFamilies.GOLD_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.GOLD_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_GOLD.get()).generateFor(SMBBlockFamilies.CUT_GOLD);
    gen.family(SMBBlocks.REDSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.REDSTONE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.REDSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_REDSTONE.get()).generateFor(SMBBlockFamilies.CUT_REDSTONE);
    gen.family(SMBBlocks.EMERALD_BRICKS.get()).generateFor(SMBBlockFamilies.EMERALD_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.EMERALD_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_EMERALD.get()).generateFor(SMBBlockFamilies.CUT_EMERALD);
    gen.family(SMBBlocks.LAPIS_BRICKS.get()).generateFor(SMBBlockFamilies.LAPIS_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.LAPIS_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_LAPIS.get()).generateFor(SMBBlockFamilies.CUT_LAPIS);
    gen.family(SMBBlocks.DIAMOND_BRICKS.get()).generateFor(SMBBlockFamilies.DIAMOND_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DIAMOND_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_DIAMOND.get()).generateFor(SMBBlockFamilies.CUT_DIAMOND);
    gen.createTrivialCube(SMBBlocks.DIAMOND_GRATE.get());
    gen.family(SMBBlocks.NETHERITE_BRICKS.get()).generateFor(SMBBlockFamilies.NETHERITE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.NETHERITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_NETHERITE.get()).generateFor(SMBBlockFamilies.CUT_NETHERITE);
    gen.createTrivialCube(SMBBlocks.NETHERITE_GRATE.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_QUARTZ_BRICKS.get());
    gen.family(SMBBlocks.CUT_QUARTZ.get()).generateFor(SMBBlockFamilies.CUT_QUARTZ);
    gen.family(SMBBlocks.AMETHYST_BRICKS.get()).generateFor(SMBBlockFamilies.AMETHYST_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.AMETHYST_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.CUT_AMETHYST.get()).generateFor(SMBBlockFamilies.CUT_AMETHYST);
    gen.family(SMBBlocks.COPPER_BRICKS.get()).generateFor(SMBBlockFamilies.COPPER_BRICKS)
      .donateModelTo(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get())
      .donateModelTo(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    gen.family(SMBBlocks.EXPOSED_COPPER_BRICKS.get()).generateFor(SMBBlockFamilies.EXPOSED_COPPER_BRICKS)
      .donateModelTo(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get())
      .donateModelTo(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    gen.family(SMBBlocks.WEATHERED_COPPER_BRICKS.get()).generateFor(SMBBlockFamilies.WEATHERED_COPPER_BRICKS)
      .donateModelTo(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get())
      .donateModelTo(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    gen.family(SMBBlocks.OXIDIZED_COPPER_BRICKS.get()).generateFor(SMBBlockFamilies.OXIDIZED_COPPER_BRICKS)
      .donateModelTo(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get())
      .donateModelTo(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.COPPER_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CRACKED_CUT_COPPER.get());
    gen.createTrivialCube(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    gen.createTrivialCube(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    gen.createTrivialCube(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    this.copyCutCopperModel(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    this.copyCutCopperModel(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    this.copyCutCopperModel(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    this.copyCutCopperModel(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    this.copyCopperPillarModel(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    this.copyCopperPillarModel(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    this.copyCopperPillarModel(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    this.copyCopperPillarModel(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
    gen.family(SMBBlocks.BONE_BRICKS.get()).generateFor(SMBBlockFamilies.BONE_BRICKS);
    gen.family(SMBBlocks.BONE_TILES.get()).generateFor(SMBBlockFamilies.BONE_TILES);
    // TODO: SOUL SANDSTONE GENERATOR
    gen.family(SMBBlocks.PACKED_SNOW.get()).generateFor(SMBBlockFamilies.PACKED_SNOW);
    gen.family(SMBBlocks.POLISHED_SNOW.get()).generateFor(SMBBlockFamilies.POLISHED_SNOW);
    gen.family(SMBBlocks.SNOW_BRICKS.get()).generateFor(SMBBlockFamilies.SNOW_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.SNOW_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.SNOW_TILES.get()).generateFor(SMBBlockFamilies.SNOW_TILES);
    gen.family(SMBBlocks.POLISHED_ICE.get()).generateFor(SMBBlockFamilies.POLISHED_ICE);
    gen.family(SMBBlocks.ICE_BRICKS.get()).generateFor(SMBBlockFamilies.ICE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.ICE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.family(SMBBlocks.ICE_TILES.get()).generateFor(SMBBlockFamilies.ICE_TILES);

    /* More Colored Blocks */
    this.tiledGlassProvider(SMBBlocks.TILED_GLASS.get()).fullBlock().pane(SMBBlocks.TILED_GLASS_PANE.get(), Blocks.GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.TILED_TINTED_GLASS.get()).fullBlock();
    this.tiledGlassProvider(SMBBlocks.WHITE_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get(), Blocks.WHITE_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get(), Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.GRAY_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get(), Blocks.GRAY_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.BLACK_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get(), Blocks.BLACK_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.BROWN_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get(), Blocks.BROWN_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.RED_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get(), Blocks.RED_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get(), Blocks.ORANGE_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get(), Blocks.YELLOW_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.LIME_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get(), Blocks.LIME_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.GREEN_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get(), Blocks.GREEN_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.CYAN_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get(), Blocks.CYAN_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get(), Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.BLUE_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get(), Blocks.BLUE_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get(), Blocks.PURPLE_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get(), Blocks.MAGENTA_STAINED_GLASS_PANE);
    this.tiledGlassProvider(SMBBlocks.PINK_STAINED_TILED_GLASS.get()).fullBlock().pane(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get(), Blocks.PINK_STAINED_GLASS_PANE);
    gen.createTrivialCube(SMBBlocks.SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.WHITE_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_GRAY_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.GRAY_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.BLACK_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.BROWN_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.RED_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.ORANGE_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.YELLOW_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.LIME_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.GREEN_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.CYAN_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_BLUE_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.BLUE_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.PURPLE_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.MAGENTA_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.PINK_SHINGLES.get());
    gen.createTrivialCube(SMBBlocks.TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.WHITE_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.GRAY_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.BLACK_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.BROWN_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.RED_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.LIME_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.GREEN_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CYAN_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.BLUE_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.PINK_TERRACOTTA_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.WHITE_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.GRAY_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.BLACK_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.BROWN_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.RED_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.ORANGE_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.YELLOW_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIME_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.GREEN_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.CYAN_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.BLUE_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.PURPLE_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.MAGENTA_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.PINK_TERRACOTTA_TILES.get());
    gen.createTrivialCube(SMBBlocks.WHITE_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.GRAY_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.BLACK_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.BROWN_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.RED_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.ORANGE_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.YELLOW_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.LIME_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.GREEN_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CYAN_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.BLUE_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.PURPLE_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.MAGENTA_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.PINK_CONCRETE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.WHITE_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_GRAY_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.GRAY_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.BLACK_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.BROWN_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.RED_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.ORANGE_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.YELLOW_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIME_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.GREEN_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.CYAN_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_BLUE_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.BLUE_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.PURPLE_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.MAGENTA_CONCRETE_TILES.get());
    gen.createTrivialCube(SMBBlocks.PINK_CONCRETE_TILES.get());

    /* More Natural Blocks */
    gen.createCrossBlockWithDefaultItem(SMBBlocks.TINY_CACTUS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    this.createPottedTinyCactus(SMBBlocks.TINY_CACTUS.get(), SMBBlocks.POTTED_TINY_CACTUS.get());
    gen.createCrossBlockWithDefaultItem(SMBBlocks.DUNE_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_DUNE_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.SHORT_SNOW_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_SNOW_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createPlantWithDefaultItem(SMBBlocks.SNOW_FERN.get(), SMBBlocks.POTTED_SNOW_FERN.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.LARGE_SNOW_FERN.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.CATTAIL.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    this.createLeafLitterWithBucket(SMBBlocks.LEAF_LITTER.get(), SMBItems.LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.BIRCH_LEAF_LITTER.get(), SMBItems.BIRCH_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SMBItems.SPRUCE_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SMBItems.PALE_OAK_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.AZALEA_LEAF_LITTER.get(), SMBItems.AZALEA_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    this.createSmallLilyPad(SMBBlocks.SMALL_LILY_PADS.get());
    gen.createPlantWithDefaultItem(SMBBlocks.LUMINOUS_FLOWER.get(), SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    this.createIndexedModelWithYRotationVariant(SMBBlocks.BIG_LILY_PAD.get(), false, 4);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.RED_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.WARPED_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);

    /* More Redstone Blocks */
    this.createRedstoneFroglight(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get());
    this.createRedstoneFroglight(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get());
    this.createRedstoneFroglight(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get());
  }

  @Override
  public void generateItemModels(ItemModelGenerators gen) {
    ITEM_MODEL_GENERATOR = gen;

    // More Building Blocks
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get());
    SMBItemsTemplates.createWallBlockItemModel(SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get());
    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_LOG.get());
    SMBItemsTemplates.createCarvedBlockItemModel(SMBBlocks.CARVED_PALE_OAK_WOOD.get());

    // More Natural Blocks
    gen.createFlatItemModel(SMBBlocks.BIG_LILY_PAD.get().asItem(), ModelTemplates.FLAT_ITEM);
  }

  /**
   * Create a block with the model copied from other block.
   * This was created to be used between Cut Copper & Waxed Cut Copper blocks.
   * @param fromBlock The block to be copied.
   * @param toBlock The block to be generated.
   */
  public final void copyCutCopperModel(Block fromBlock, Block toBlock) {
    TextureMapping textureMapping = TextureMapping.cube(fromBlock).put(TextureSlot.ALL, ModelLocationUtils.getModelLocation(fromBlock));
    ResourceLocation location = ModelTemplates.CUBE_ALL.create(ModelLocationUtils.getModelLocation(toBlock), textureMapping, this.modelOutput);

    this.itemModelOutput.copy(fromBlock.asItem(), toBlock.asItem());
    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(toBlock, location));
  }

  /**
   * Create a block with the model copied from other block.
   * This was created to be used between Copper Pillar & Waxed Copper Pillar blocks.
   * @param fromBlock The block to be copied.
   * @param toBlock The block to be generated.
   */
  public final void copyCopperPillarModel(Block fromBlock, Block toBlock) {
    TextureMapping verticalMapping = TextureMapping.column(fromBlock)
      .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(fromBlock));
    TextureMapping horizontalMapping = TextureMapping.column(fromBlock)
      .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(fromBlock));

    ResourceLocation verticalModel = ModelTemplates.CUBE_COLUMN
      .create(ModelLocationUtils.getModelLocation(toBlock), verticalMapping, this.modelOutput);
    ResourceLocation horizontalModel = ModelTemplates.CUBE_COLUMN_HORIZONTAL
      .create(ModelLocationUtils.getModelLocation(toBlock).withSuffix("_horizontal"), horizontalMapping, this.modelOutput);

    this.itemModelOutput.copy(fromBlock.asItem(), toBlock.asItem());
    this.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(toBlock, verticalModel, horizontalModel));
  }

  /**
   * Create a Redstone Froglight block models.
   * @param block The Redstone Froglight block.
   */
  public final void createRedstoneFroglight(Block block) {
    TextureMapping offTextureMapping = TextureMapping.cube(block);
    TextureMapping onTextureMapping = TextureMapping.cube(block)
      .put(TextureSlot.ALL, ModelLocationUtils.getModelLocation(block).withSuffix("_on"));

    ResourceLocation offModel = ModelTemplates.CUBE_ALL.create(block, offTextureMapping, this.modelOutput);
    ResourceLocation onModel = ModelTemplates.CUBE_ALL.createWithSuffix(block, "_on", onTextureMapping, this.modelOutput);

    this.blockStateOutput.accept(
      MultiVariantGenerator.multiVariant(block)
        .with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, onModel, offModel))
    );
  }

  /**
   * Create a Potted Tiny Cactus block model.
   * @param plantBlock The plant block.
   * @param pottedBlock The potted plant block.
   */
  public final void createPottedTinyCactus(Block plantBlock, Block pottedBlock) {
    BlockModelGenerators.PlantType plantType = BlockModelGenerators.PlantType.NOT_TINTED;
    TextureMapping textureMapping = plantType.getPlantTextureMapping(plantBlock)
      .put(TextureSlot.PLANT, ModelLocationUtils.getModelLocation(pottedBlock));

    ResourceLocation model = plantType.getCrossPot().create(pottedBlock, textureMapping, this.modelOutput);

    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedBlock, model));
  }

  /**
   * Create a Small Lily Pad block.
   * @param block The Small Lily Pad block.
   */
  public final void createSmallLilyPad(Block block) {
    this.createIndexedModelWithYRotationVariant(block, false, 1);

    ResourceLocation model = ModelLocationUtils.getModelLocation(block);
    ResourceLocation modelWithLotus = ModelLocationUtils.getModelLocation(block).withSuffix("_with_lotus");
    ResourceLocation itemModel = ModelTemplates.FLAT_ITEM.create(block.asItem(), TextureMapping.layer0(block), this.modelOutput);

    List<Variant> variants = new ArrayList<>();

    for (VariantProperties.Rotation rotation : VariantProperties.Rotation.values()) {
      variants.add(Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, rotation));
      variants.add(Variant.variant().with(VariantProperties.MODEL, modelWithLotus).with(VariantProperties.Y_ROT, rotation));
    }

    this.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(itemModel));
    this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, variants.toArray(new Variant[0])));
  }

  /**
   * Create a Leaf Litter block and Bucket item.
   * @param block The Leaf Litter block.
   * @param item The Leaves Bucket item.
   */
  public final void createLeafLitterWithBucket(Block block, Item item) {
    this.createIndexedModelWithYRotationVariant(block, 3);

    RangeSelectItemModel.Entry[] overrides = new RangeSelectItemModel.Entry[4];
    for (int i = 0; i < overrides.length; i++) {
      String suffix = i == 0 ? "" : "_" + (i - 1);
      int threshold = i == 0 ? 0 : 5 + (i - 1) * 4;

      ResourceLocation identifier = ModelLocationUtils.getModelLocation(item).withSuffix(suffix);
      TextureMapping textureMapping = TextureMapping.layer0(item).put(TextureSlot.LAYER0, identifier);
      ResourceLocation itemModel = ModelTemplates.FLAT_ITEM.create(identifier, textureMapping, this.modelOutput);

     overrides[i] = ItemModelUtils.override(ItemModelUtils.plainModel(itemModel), threshold);
    }

    this.itemModelOutput.accept(item, ItemModelUtils.rangeSelect(new BucketVolumeProperty(), overrides[3].model(), overrides));
  }

  /**
   * Create a Square Horizontal Y-Axis Rotatable block with variations indexed as suffix.
   * @param block The block flat block.
   * @param maxVariations The max number of variations.
   */
  public final void createIndexedModelWithYRotationVariant(Block block, int maxVariations) {
    this.createIndexedModelWithYRotationVariant(block, true, maxVariations);
  }

  /**
   * Create a Square Horizontal Y-Axis Rotatable block with variations indexed as suffix.
   * @param block The block flat block.
   * @param generateBlockState If true, the block state will be generated.
   * @param maxVariations The max number of variations.
   */
  public final void createIndexedModelWithYRotationVariant(Block block, boolean generateBlockState, int maxVariations) {
    if (maxVariations <= 0) {
      throw new IllegalArgumentException("The max variations value should be 1 or greater.");
    }

    List<Variant> variants = new ArrayList<>();

    for (int i = 0; i < maxVariations; i++) {
      String suffix = maxVariations > 1 ? "_" + i : "";

      TextureMapping textureMapping = TextureMapping.defaultTexture(block)
        .copyAndUpdate(TextureSlot.TEXTURE, ModelLocationUtils.getModelLocation(block).withSuffix(suffix));

      ResourceLocation model = SMBModelTemplates.SQUARE_HORIZONTAL.createWithSuffix(block, suffix, textureMapping, this.modelOutput);

      for (VariantProperties.Rotation rotation : VariantProperties.Rotation.values()) {
        variants.add(
          Variant.variant()
            .with(VariantProperties.MODEL, model)
            .with(VariantProperties.Y_ROT, rotation)
        );
      }
    }

    if (!generateBlockState) return;
    this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, variants.toArray(new Variant[0])));
  }

  /**
   * The Carved Wood provider
   * Used to generate a Carved Log & Carved Wood blocks.
   * @param block The Carved Wood block.
   */
  public final CarvedWoodBlockProvider carvedWoodProvider(Block block) {
    return new CarvedWoodBlockProvider(block, this.modelOutput, this.itemModelOutput, this.blockStateOutput);
  }

  /**
   * The Tiled Glass provider
   * Used to generate a Tiled Glass & Tiled Glass Pane blocks.
   * @param block The Tile Glass block.
   */
  public final TiledGlassBlockProvider tiledGlassProvider(Block block) {
    return new TiledGlassBlockProvider(block, this.modelOutput, this.itemModelOutput, this.blockStateOutput);
  }
}
