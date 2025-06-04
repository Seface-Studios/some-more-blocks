package net.seface.somemoreblocks.datagen.providers.assets;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.Direction;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.seface.somemoreblocks.block.properties.QuadDirection;
import net.seface.somemoreblocks.datagen.providers.assets.providers.CarvedWoodBlockProvider;
import net.seface.somemoreblocks.datagen.providers.assets.providers.TiledGlassBlockProvider;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.registries.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SMBModelProvider extends FabricModelProvider {
  private BlockModelGenerators blockModelGenerators;
  private Map<Block, TexturedModel> texturedModels;

  public BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput;
  public Consumer<BlockStateGenerator> blockStateOutput;

  public SMBModelProvider(FabricDataOutput output) {
    super(output);
    this.registerSoulSandstoneAsTexturedModel();
  }

  @Override
  public void generateBlockStateModels(@NotNull BlockModelGenerators gen) {
    this.blockModelGenerators = gen;
    this.blockStateOutput = gen.blockStateOutput;
    this.modelOutput = gen.modelOutput;

    this.createBlockFamilyVariations();

    /* More Building Blocks */
    this.carvedWoodProvider(SMBBlocks.CARVED_OAK_LOG.get()).log(SMBBlocks.CARVED_OAK_LOG.get(), Blocks.STRIPPED_OAK_LOG).wood(SMBBlocks.CARVED_OAK_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_SPRUCE_LOG.get()).log(SMBBlocks.CARVED_SPRUCE_LOG.get(), Blocks.STRIPPED_SPRUCE_LOG).wood(SMBBlocks.CARVED_SPRUCE_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_BIRCH_LOG.get()).log(SMBBlocks.CARVED_BIRCH_LOG.get(), Blocks.STRIPPED_BIRCH_LOG).wood(SMBBlocks.CARVED_BIRCH_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_JUNGLE_LOG.get()).log(SMBBlocks.CARVED_JUNGLE_LOG.get(), Blocks.STRIPPED_JUNGLE_LOG).wood(SMBBlocks.CARVED_JUNGLE_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_ACACIA_LOG.get()).log(SMBBlocks.CARVED_ACACIA_LOG.get(), Blocks.STRIPPED_ACACIA_LOG).wood(SMBBlocks.CARVED_ACACIA_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_DARK_OAK_LOG.get()).log(SMBBlocks.CARVED_DARK_OAK_LOG.get(), Blocks.STRIPPED_DARK_OAK_LOG).wood(SMBBlocks.CARVED_DARK_OAK_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_MANGROVE_LOG.get()).log(SMBBlocks.CARVED_MANGROVE_LOG.get(), Blocks.STRIPPED_MANGROVE_LOG).wood(SMBBlocks.CARVED_MANGROVE_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_CRIMSON_STEM.get()).log(SMBBlocks.CARVED_CRIMSON_STEM.get(), Blocks.STRIPPED_CRIMSON_STEM).wood(SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_WARPED_STEM.get()).log(SMBBlocks.CARVED_WARPED_STEM.get(), Blocks.STRIPPED_WARPED_STEM).wood(SMBBlocks.CARVED_WARPED_HYPHAE.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_CHERRY_LOG.get()).log(SMBBlocks.CARVED_CHERRY_LOG.get(), Blocks.STRIPPED_CHERRY_LOG).wood(SMBBlocks.CARVED_CHERRY_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_BAMBOO_BLOCK.get()).log(SMBBlocks.CARVED_BAMBOO_BLOCK.get(), Blocks.STRIPPED_BAMBOO_BLOCK);
    gen.createMushroomBlock(SMBBlocks.CARVED_MUSHROOM_STEM.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.STONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.GRANITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DIORITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.ANDESITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DEEPSLATE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.CALCITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.TUFF_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DRIPSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CRACKED_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CHISELED_MUD_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.MUD_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CRACKED_MUD_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.SANDSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.RED_SANDSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CHISELED_PRISMARINE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_PRISMARINE_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.PRISMARINE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.NETHER_BRICKS_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CHISELED_RED_NETHER_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_RED_NETHER_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.RED_NETHER_BRICKS_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.POLISHED_BASALT_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CHISELED_END_STONE_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_END_STONE_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.END_STONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CHISELED_PURPUR.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_PURPUR_BLOCK.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.COAL_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.IRON_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.IRON_GRATE.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.GOLD_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.REDSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.EMERALD_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.LAPIS_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DIAMOND_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.DIAMOND_GRATE.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.NETHERITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.NETHERITE_GRATE.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_QUARTZ_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.AMETHYST_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
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
    this.soulSandstoneFamily(SMBBlocks.SOUL_SANDSTONE.get()).generateFor(SMBBlockFamilies.SOUL_SANDSTONE);
    this.createChiseledSoulSandstone(SMBBlocks.CHISELED_SOUL_SANDSTONE.get());
    this.soulSandstoneFamily(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).generateFor(SMBBlockFamilies.SOUL_SANDSTONE_BRICKS);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.SOUL_SANDSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    this.soulSandstoneFamily(SMBBlocks.SOUL_SANDSTONE_TILES.get()).generateFor(SMBBlockFamilies.SOUL_SANDSTONE_TILES);
    this.soulSandstoneFamily(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get()).generateFor(SMBBlockFamilies.SMOOTH_SOUL_SANDSTONE);
    this.soulSandstoneFamily(SMBBlocks.CUT_SOUL_SANDSTONE.get()).generateFor(SMBBlockFamilies.CUT_SOUL_SANDSTONE);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.SNOW_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.ICE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);

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
    gen.createTrivialCube(SMBBlocks.WHITE_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_GRAY_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.GRAY_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.BLACK_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.BROWN_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.RED_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.ORANGE_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.YELLOW_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIME_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.GREEN_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.CYAN_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.LIGHT_BLUE_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.BLUE_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.PURPLE_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.MAGENTA_CHECKERED_TILES.get());
    gen.createTrivialCube(SMBBlocks.PINK_CHECKERED_TILES.get());
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
    gen.createCrossBlockWithDefaultItem(SMBBlocks.TINY_CACTUS.get(), BlockModelGenerators.TintState.NOT_TINTED);
    this.createPottedTinyCactus(SMBBlocks.TINY_CACTUS.get(), SMBBlocks.POTTED_TINY_CACTUS.get());
    gen.createDoublePlant(SMBBlocks.TALL_CACTUS.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.DUNE_GRASS.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.TALL_DUNE_GRASS.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.SHORT_SNOW_GRASS.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.TALL_SNOW_GRASS.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createPlant(SMBBlocks.SNOW_FERN.get(), SMBBlocks.POTTED_SNOW_FERN.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.LARGE_SNOW_FERN.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.CATTAIL.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.REEDS.get(), BlockModelGenerators.TintState.NOT_TINTED);
    this.createLeafLitterWithBucket(SMBBlocks.LEAF_LITTER.get(), SMBItems.LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.BIRCH_LEAF_LITTER.get(), SMBItems.BIRCH_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SMBItems.SPRUCE_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.AZALEA_LEAF_LITTER.get(), SMBItems.AZALEA_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    this.createFlowerBedWithItem(SMBBlocks.CLOVER.get(), SMBItems.CLOVER.get(), false);
    this.createFlowerBedWithItem(SMBBlocks.NETHER_CLOVER.get(), SMBItems.NETHER_CLOVER.get(), true);
    this.createSmallLilyPad(SMBBlocks.SMALL_LILY_PADS.get());
    gen.createPlant(SMBBlocks.LUMINOUS_FLOWER.get(), SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), BlockModelGenerators.TintState.NOT_TINTED);
    this.createBigLilyPad(SMBBlocks.BIG_LILY_PAD.get());
    gen.createCrossBlockWithDefaultItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.RED_MUSHROOM_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.WARPED_FUNGUS_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);
    gen.createDoublePlant(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), BlockModelGenerators.TintState.NOT_TINTED);

    /* More Redstone Blocks */
    this.createRedstoneLampBlock(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get());
    this.createRedstoneLampBlock(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get());
    this.createRedstoneLampBlock(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get());
    this.createRedstoneLampBlock(SMBBlocks.REDSTONE_SHROOMLIGHT.get());

    this.createRedstoneSeaLantern(SMBBlocks.POLISHED_PRISMARINE.get(), SMBBlocks.REDSTONE_SEA_LANTERN.get());
  }

  @Override
  public void generateItemModels(ItemModelGenerators gen) {}

  /**
   * Create a block with the model copied from other block.
   * This was created to be used between Cut Copper and Waxed Cut Copper blocks.
   * @param fromBlock The block to be copied.
   * @param toBlock The block to be generated.
   */
  public final void copyCutCopperModel(Block fromBlock, Block toBlock) {
    TextureMapping textureMapping = TextureMapping.cube(fromBlock).put(TextureSlot.ALL, ModelLocationUtils.getModelLocation(fromBlock));
    ResourceLocation location = ModelTemplates.CUBE_ALL.create(ModelLocationUtils.getModelLocation(toBlock), textureMapping, this.modelOutput);

    //this.itemModelOutput.copy(fromBlock.asItem(), toBlock.asItem());
    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(toBlock, location));
  }

  /**
   * Create a block with the model copied from other block.
   * This was created to be used between Copper Pillar and Waxed Copper Pillar blocks.
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

    this.blockModelGenerators.delegateItemModel(fromBlock.asItem(), ModelLocationUtils.getModelLocation(toBlock));
    //this.itemModelOutput.copy(fromBlock.asItem(), toBlock.asItem());
    this.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(toBlock, verticalModel, horizontalModel));
  }

  /**
   * Create a Redstone Froglight block models.
   * @param block The Redstone Froglight block.
   */
  public final void createRedstoneLampBlock(Block block) {
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
   * Create a Redstone Sea Lanter block models.
   * @param bottomAndTopBlock The Bottom-Top block.
   * @param block The Redstone Sea Lantern block.
   */
  public final void createRedstoneSeaLantern(Block bottomAndTopBlock, Block block) {
    TextureMapping offTextureMapping = TextureMapping.cube(block)
      .put(TextureSlot.UP, ModelLocationUtils.getModelLocation(bottomAndTopBlock))
      .put(TextureSlot.DOWN, ModelLocationUtils.getModelLocation(bottomAndTopBlock));

    TextureMapping onTextureMapping = TextureMapping.cube(block)
      .put(TextureSlot.UP, ModelLocationUtils.getModelLocation(bottomAndTopBlock))
      .put(TextureSlot.DOWN, ModelLocationUtils.getModelLocation(bottomAndTopBlock))
      .put(TextureSlot.NORTH, ModelLocationUtils.getModelLocation(block).withSuffix("_on_north"))
      .put(TextureSlot.SOUTH, ModelLocationUtils.getModelLocation(block).withSuffix("_on_south"))
      .put(TextureSlot.EAST, ModelLocationUtils.getModelLocation(block).withSuffix("_on_east"))
      .put(TextureSlot.WEST, ModelLocationUtils.getModelLocation(block).withSuffix("_on_west"));

    ResourceLocation offModel = ModelTemplates.CUBE.create(block, offTextureMapping, this.modelOutput);
    ResourceLocation onModel = ModelTemplates.CUBE.createWithSuffix(block, "_on", onTextureMapping, this.modelOutput);

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
    BlockModelGenerators.TintState TintState = BlockModelGenerators.TintState.NOT_TINTED;
    TextureMapping textureMapping = TextureMapping.plant(plantBlock)
      .put(TextureSlot.PLANT, ModelLocationUtils.getModelLocation(pottedBlock));

    ResourceLocation model = TintState.getCrossPot().create(pottedBlock, textureMapping, this.modelOutput);

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

    List<Variant> variants = new ArrayList<>();

    for (VariantProperties.Rotation rotation : VariantProperties.Rotation.values()) {
      variants.add(Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, rotation));
      variants.add(Variant.variant().with(VariantProperties.MODEL, modelWithLotus).with(VariantProperties.Y_ROT, rotation));
    }

    this.blockModelGenerators.createSimpleFlatItemModel(block);
    this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, variants.toArray(new Variant[0])));
  }

  /**
   * Create a Big Lily Pad block.
   * @param block The Big Lily Pad block.
   */
  public final void createBigLilyPad(Block block) {
    PropertyDispatch.C2<Direction, QuadDirection> c2 = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, SMBBlockStateProperties.POSITION);

    /* Generate Block Model */
    for (int i = 0; i < QuadDirection.values().length; i++) {
      String suffix = "_" + i;

      TextureMapping textureMapping = TextureMapping.defaultTexture(block)
        .copyAndUpdate(TextureSlot.TEXTURE, ModelLocationUtils.getModelLocation(block).withSuffix(suffix));

      ResourceLocation model = SMBModelTemplates.SQUARE_HORIZONTAL.createWithSuffix(block, suffix, textureMapping, this.modelOutput);

      for (Direction facing : Direction.Plane.HORIZONTAL) {
        Variant variant = Variant.variant()
          .with(VariantProperties.MODEL, model);

        if (facing != Direction.NORTH) {
          VariantProperties.Rotation yRot;

          switch (facing) {
            case EAST  -> yRot = VariantProperties.Rotation.R90;
            case SOUTH -> yRot = VariantProperties.Rotation.R180;
            case WEST  -> yRot = VariantProperties.Rotation.R270;
            default -> yRot = VariantProperties.Rotation.R0;
          }

          variant.with(VariantProperties.Y_ROT, yRot);
        }

        c2.select(facing, QuadDirection.getByIndex(i), variant);
      }
    }

    this.blockModelGenerators.createSimpleFlatItemModel(block.asItem());
    this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(c2));
  }

  /**
   * Create a Leaf Litter block and Bucket item.
   * @param block The Leaf Litter block.
   * @param item The Leaves Bucket item.
   */
  public final void createLeafLitterWithBucket(Block block, Item item) {
    this.blockModelGenerators.skipAutoItemBlock(block);
    this.createIndexedModelWithYRotationVariant(block, 3);

    for (int i = 0; i < 4; i++) {
      if (i == 0) continue;
      String suffix = "_" + (i - 1);

      ResourceLocation identifier = ModelLocationUtils.getModelLocation(item).withSuffix(suffix);
      TextureMapping textureMapping = TextureMapping.layer0(item).put(TextureSlot.LAYER0, identifier);
      ModelTemplates.FLAT_ITEM.create(identifier, textureMapping, this.modelOutput);
    }
  }

  public final void createFlowerBedWithItem(Block block, Item item, boolean isNetherVersion) {
    this.blockModelGenerators.createSimpleFlatItemModel(item);
    ResourceLocation resourceLocation = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_1 : SMBModelTemplates.NETHER_FLOWERBED_1).create(block, this.modelOutput);
    ResourceLocation resourceLocation2 = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_2 : SMBModelTemplates.NETHER_FLOWERBED_2).create(block, this.modelOutput);
    ResourceLocation resourceLocation3 = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_3 : SMBModelTemplates.NETHER_FLOWERBED_3).create(block, this.modelOutput);
    ResourceLocation resourceLocation4 = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_4 : SMBModelTemplates.NETHER_FLOWERBED_4).create(block, this.modelOutput);
    this.blockStateOutput.accept(MultiPartGenerator.multiPart(block).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, new Integer[]{2, 3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, new Integer[]{2, 3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, new Integer[]{2, 3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 1, new Integer[]{2, 3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, new Integer[]{3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation2)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, new Integer[]{3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, resourceLocation2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, new Integer[]{3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 2, new Integer[]{3, 4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, resourceLocation2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, new Integer[]{4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation3)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, new Integer[]{4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, resourceLocation3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, new Integer[]{4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 3, new Integer[]{4}).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, resourceLocation3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation4)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), Variant.variant().with(VariantProperties.MODEL, resourceLocation4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), Variant.variant().with(VariantProperties.MODEL, resourceLocation4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).with(Condition.condition().term(BlockStateProperties.FLOWER_AMOUNT, 4).term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), Variant.variant().with(VariantProperties.MODEL, resourceLocation4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
  }

  /**
   * Create a Square Horizontal Y-Axis Rotatable block with variations indexed as suffix.
   * @param block The block flat block.
   * @param maxVariations The max number of variations.
   */
  public final List<Variant> createIndexedModelWithYRotationVariant(Block block, int maxVariations) {
    return this.createIndexedModelWithYRotationVariant(block, true, maxVariations);
  }

  /**
   * Create a Square Horizontal Y-Axis Rotatable block with variations indexed as suffix.
   * @param block The block flat block.
   * @param generateBlockState If true, the block state will be generated.
   * @param maxVariations The max number of variations.
   */
  public final List<Variant> createIndexedModelWithYRotationVariant(Block block, boolean generateBlockState, int maxVariations) {
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

    if (!generateBlockState) return variants;
    this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, variants.toArray(new Variant[0])));

    return variants;
  }

  /**
   * Create a Chiseled Soul Sandstone block.
   * @param block The Chiseled Soul Sandstone block.
   */
  public final void createChiseledSoulSandstone(Block block) {
    TextureMapping textureMapping = TextureMapping.column(block)
      .put(TextureSlot.END, TextureMapping.getBlockTexture(SMBBlocks.SOUL_SANDSTONE.get()).withSuffix("_top"))
      .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(SMBBlocks.CHISELED_SOUL_SANDSTONE.get()));

    ResourceLocation model = ModelTemplates.CUBE_COLUMN.create(block, textureMapping, this.modelOutput);
    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, model));
  }

  /**
   * Generate all Block Families variations.
   */
  private void createBlockFamilyVariations() {
    for (Map.Entry<Block, BlockFamily> entry : SMBBlockFamilies.getAllFamilies().entrySet()) {
      if (!entry.getValue().shouldGenerateModel()) continue;
      this.blockModelGenerators.family(entry.getKey()).generateFor(entry.getValue());
    }
  }

  /**
   * Generate all the block family models for Soul Sandstone blocks with
   * configured Textured Models values.
   * @param block The Soul Sandstone block.
   */
  private BlockModelGenerators.BlockFamilyProvider soulSandstoneFamily(Block block) {
    List<Block> validNonTexturedModel = List.of(
      SMBBlocks.SOUL_SANDSTONE_BRICKS.get(), SMBBlocks.SOUL_SANDSTONE_TILES.get());

    if (!this.texturedModels.containsKey(block) && !validNonTexturedModel.contains(block)) {
      throw new IllegalArgumentException(
        "The parsed block is not a Soul Sandstone block. " +
          "For non-Soul Sandstone blocks, use the method BlockModelGenerators#family."
      );
    }

    TexturedModel texturedModel = this.texturedModels.getOrDefault(block, TexturedModel.CUBE.get(block));
    return (this.blockModelGenerators).
      new BlockFamilyProvider(texturedModel.getMapping()).fullBlock(block, texturedModel.getTemplate());
  }

  /**
   * The Carved Wood provider
   * Used to generate a Carved Log and Carved Wood blocks.
   * @param block The Carved Wood block.
   */
  public final CarvedWoodBlockProvider carvedWoodProvider(Block block) {
    return new CarvedWoodBlockProvider(block, this.modelOutput, this.blockStateOutput);
  }

  /**
   * The Tiled Glass provider
   * Used to generate a Tiled Glass and Tiled Glass Pane blocks.
   * @param block The Tile Glass block.
   */
  public final TiledGlassBlockProvider tiledGlassProvider(Block block) {
    return new TiledGlassBlockProvider(block, this.modelOutput, this.blockStateOutput);
  }

  /**
   * Register all Soul Sandstone blocks as Textured Model.
   */
  private void registerSoulSandstoneAsTexturedModel() {
    this.texturedModels = ImmutableMap.<Block, TexturedModel>builder()
      .put(SMBBlocks.SOUL_SANDSTONE.get(), TexturedModel.TOP_BOTTOM_WITH_WALL.get(SMBBlocks.SOUL_SANDSTONE.get()))
      .put(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get(), TexturedModel.createAllSame(TextureMapping.getBlockTexture(SMBBlocks.SOUL_SANDSTONE.get(), "_top")))
      .put(SMBBlocks.CUT_SOUL_SANDSTONE.get(), TexturedModel.COLUMN.get(SMBBlocks.SOUL_SANDSTONE.get()).updateTextures(
        (mapping) -> mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(SMBBlocks.CUT_SOUL_SANDSTONE.get()))))
      .build();
  }
}
