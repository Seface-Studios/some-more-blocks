package net.seface.somemoreblocks.datagen.providers.assets;

import com.google.common.collect.ImmutableMap;
import com.mojang.math.Quadrant;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.core.Direction;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.seface.somemoreblocks.block.properties.QuadDirection;
import net.seface.somemoreblocks.datagen.providers.assets.providers.CarvedWoodBlockProvider;
import net.seface.somemoreblocks.datagen.providers.assets.providers.TiledGlassBlockProvider;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.registries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;


public class SMBModelProvider extends FabricModelProvider {
  private BlockModelGenerators blockModelGenerators;
  private Map<Block, TexturedModel> texturedModels;

  public BiConsumer<ResourceLocation, ModelInstance> modelOutput;
  public Consumer<BlockModelDefinitionGenerator> blockStateOutput;
  public ItemModelOutput itemModelOutput;

  public SMBModelProvider(FabricDataOutput output) {
    super(output);
    this.registerSoulSandstoneAsTexturedModel();
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators gen) {
    this.blockModelGenerators = gen;
    this.itemModelOutput = gen.itemModelOutput;
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
    this.carvedWoodProvider(SMBBlocks.CARVED_PALE_OAK_LOG.get()).logByMoonPhase(SMBBlocks.CARVED_PALE_OAK_LOG.get(), Blocks.STRIPPED_PALE_OAK_LOG).woodByMoonPhase(SMBBlocks.CARVED_PALE_OAK_WOOD.get());
    this.carvedWoodProvider(SMBBlocks.CARVED_BAMBOO_BLOCK.get()).log(SMBBlocks.CARVED_BAMBOO_BLOCK.get(), Blocks.STRIPPED_BAMBOO_BLOCK);
    gen.createMushroomBlock(SMBBlocks.CARVED_MUSHROOM_STEM.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.STONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.GRANITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DIORITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.ANDESITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DEEPSLATE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.CALCITE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CRACKED_TUFF_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.TUFF_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.DRIPSTONE_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CRACKED_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CHISELED_MUD_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.MUD_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
    gen.createTrivialCube(SMBBlocks.CRACKED_MUD_BRICKS.get());
    gen.createTrivialCube(SMBBlocks.CRACKED_RESIN_BRICKS.get());
    gen.createRotatedPillarWithHorizontalVariant(SMBBlocks.RESIN_PILLAR.get(), TexturedModel.COLUMN_ALT, TexturedModel.COLUMN_HORIZONTAL_ALT);
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
    gen.createCrossBlockWithDefaultItem(SMBBlocks.TINY_CACTUS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    this.createPottedTinyCactus(SMBBlocks.TINY_CACTUS.get(), SMBBlocks.POTTED_TINY_CACTUS.get());
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_CACTUS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.DUNE_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_DUNE_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.SHORT_SNOW_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_SNOW_GRASS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createPlantWithDefaultItem(SMBBlocks.SNOW_FERN.get(), SMBBlocks.POTTED_SNOW_FERN.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.LARGE_SNOW_FERN.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.SNOW_BUSH.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.SNOW_FIREFLY_BUSH.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    this.createEmissiveDoublePlantWithDefaultItem(SMBBlocks.PALE_ROSE_BUSH.get());
    gen.createDoublePlantWithDefaultItem(SMBBlocks.CATTAIL.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.REEDS.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    this.createLeafLitterWithBucket(SMBBlocks.LEAF_LITTER.get(), SMBItems.LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.BIRCH_LEAF_LITTER.get(), SMBItems.BIRCH_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SMBItems.SPRUCE_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SMBItems.PALE_OAK_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.AZALEA_LEAF_LITTER.get(), SMBItems.AZALEA_LEAVES_BUCKET.get());
    this.createLeafLitterWithBucket(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    this.createFlowerBedWithItem(SMBBlocks.CLOVER.get(), SMBItems.CLOVER.get(), false);
    this.createFlowerBedWithItem(SMBBlocks.NETHER_CLOVER.get(), SMBItems.NETHER_CLOVER.get(), true);
    this.createSmallLilyPad(SMBBlocks.SMALL_LILY_PADS.get());
    gen.createPlantWithDefaultItem(SMBBlocks.LUMINOUS_FLOWER.get(), SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    this.createBigLilyPad(SMBBlocks.BIG_LILY_PAD.get());
    gen.createCrossBlockWithDefaultItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.RED_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);

    gen.registerSimpleItemModel(SMBItems.PALE_MUSHROOM.get(), gen.createFlatItemModel(SMBItems.PALE_MUSHROOM.get()));
    gen.registerSimpleItemModel(SMBItems.PALE_MUSHROOM_COLONY.get(), gen.createFlatItemModel(SMBItems.PALE_MUSHROOM_COLONY.get()));
    gen.registerSimpleItemModel(SMBItems.TALL_PALE_MUSHROOM_COLONY.get(), gen.createFlatItemModel(SMBItems.TALL_PALE_MUSHROOM_COLONY.get()));


    gen.createNonTemplateModelBlock(SMBBlocks.PALE_MUSHROOM.get());
    gen.createNonTemplateModelBlock(SMBBlocks.POTTED_PALE_MUSHROOM.get());
    gen.createNonTemplateModelBlock(SMBBlocks.PALE_MUSHROOM_COLONY.get());
    //gen.createCrossBlockWithDefaultItem(SMBBlocks.PALE_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    //gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_PALE_MUSHROOM_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createCrossBlockWithDefaultItem(SMBBlocks.WARPED_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);
    gen.createDoublePlantWithDefaultItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), BlockModelGenerators.PlantType.NOT_TINTED);

    /* More Redstone Blocks */
    this.createRedstoneLampBlock(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get());
    this.createRedstoneLampBlock(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get());
    this.createRedstoneLampBlock(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get());
    this.createRedstoneLampBlock(SMBBlocks.REDSTONE_SHROOMLIGHT.get());

    this.createRedstoneSeaLantern(SMBBlocks.POLISHED_PRISMARINE.get(), SMBBlocks.REDSTONE_SEA_LANTERN.get());
  }

  @Override
  public void generateItemModels(ItemModelGenerators gen) {
    this.createLeavesBucket(SMBItems.DRY_LEAVES_BUCKET.get());
  }

  /**
   * Create a block with the model copied from other block.
   * This was created to be used between Cut Copper and Waxed Cut Copper blocks.
   * @param fromBlock The block to be copied.
   * @param toBlock The block to be generated.
   */
  public final void copyCutCopperModel(Block fromBlock, Block toBlock) {
    TextureMapping mapping = TextureMapping.cube(fromBlock).put(TextureSlot.ALL, ModelLocationUtils.getModelLocation(fromBlock));
    MultiVariant variant = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_ALL.create(ModelLocationUtils.getModelLocation(toBlock), mapping, this.modelOutput));

    this.itemModelOutput.copy(fromBlock.asItem(), toBlock.asItem());
    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(toBlock, variant));
  }

  /**
   * Create a block with the model copied from other block.
   * This was created to be used between Copper Pillar and Waxed Copper Pillar blocks.
   * @param fromBlock The block to be copied.
   * @param toBlock The block to be generated.
   */
  public final void copyCopperPillarModel(Block fromBlock, Block toBlock) {
    TextureMapping mappingY = TextureMapping.column(fromBlock).put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(fromBlock));
    TextureMapping mappingXZ = TextureMapping.column(fromBlock).put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(fromBlock));

    MultiVariant variantY = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_COLUMN.create(ModelLocationUtils.getModelLocation(toBlock), mappingY, this.modelOutput));
    MultiVariant variantXZ = BlockModelGenerators.plainVariant(ModelTemplates.CUBE_COLUMN_HORIZONTAL.createWithSuffix(toBlock, "_horizontal", mappingXZ, this.modelOutput));

    this.itemModelOutput.copy(fromBlock.asItem(), toBlock.asItem());
    this.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(toBlock, variantY, variantXZ));
  }

  /**
   * Create a Redstone Froglight block models.
   * @param block The Redstone Froglight block.
   */
  public final void createRedstoneLampBlock(Block block) {
    MultiVariant variantOff = BlockModelGenerators.plainVariant(TexturedModel.CUBE.create(block, this.modelOutput));
    MultiVariant variantOn = BlockModelGenerators.plainVariant(this.blockModelGenerators.createSuffixedVariant(block, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube));

    this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, variantOn, variantOff)));
  }

  /**
   * Create a Redstone Sea Lanter block models.
   * @param bottomAndTopBlock The Bottom-Top block.
   * @param block The Redstone Sea Lantern block.
   */
  public final void createRedstoneSeaLantern(Block bottomAndTopBlock, Block block) {
    TextureMapping mappingOff = TextureMapping.cube(block)
      .put(TextureSlot.UP, ModelLocationUtils.getModelLocation(bottomAndTopBlock))
      .put(TextureSlot.DOWN, ModelLocationUtils.getModelLocation(bottomAndTopBlock));

    TextureMapping mappingOn = TextureMapping.cube(block)
      .put(TextureSlot.UP, ModelLocationUtils.getModelLocation(bottomAndTopBlock))
      .put(TextureSlot.DOWN, ModelLocationUtils.getModelLocation(bottomAndTopBlock))
      .put(TextureSlot.NORTH, ModelLocationUtils.getModelLocation(block).withSuffix("_on_north"))
      .put(TextureSlot.SOUTH, ModelLocationUtils.getModelLocation(block).withSuffix("_on_south"))
      .put(TextureSlot.EAST, ModelLocationUtils.getModelLocation(block).withSuffix("_on_east"))
      .put(TextureSlot.WEST, ModelLocationUtils.getModelLocation(block).withSuffix("_on_west"));

    MultiVariant variantOff = BlockModelGenerators.plainVariant(ModelTemplates.CUBE.create(block, mappingOff, this.modelOutput));
    MultiVariant variantOn = BlockModelGenerators.plainVariant(ModelTemplates.CUBE.createWithSuffix(block, "_on", mappingOn, this.modelOutput));

    this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.LIT, variantOn, variantOff)));
  }

  /**
   * Create a Potted Tiny Cactus block model.
   * @param plantBlock The plant block.
   * @param pottedBlock The potted plant block.
   */
  public final void createPottedTinyCactus(Block plantBlock, Block pottedBlock) {
    BlockModelGenerators.PlantType plantType = BlockModelGenerators.PlantType.NOT_TINTED;
    TextureMapping mapping = plantType.getPlantTextureMapping(plantBlock).put(TextureSlot.PLANT, ModelLocationUtils.getModelLocation(pottedBlock));

    MultiVariant variant = BlockModelGenerators.plainVariant(plantType.getCrossPot().create(pottedBlock, mapping, this.modelOutput));

    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedBlock, variant));
  }

  /**
   * Create a Small Lily Pad block.
   * @param block The Small Lily Pad block.
   */
  public final void createSmallLilyPad(Block block) {
    this.createIndexedModelWithYRotationVariant(block, false, 1);

    Variant variant = new Variant(ModelLocationUtils.getModelLocation(block));
    Variant variantWithLotus = new Variant(ModelLocationUtils.getModelLocation(block).withSuffix("_with_lotus"));

    ResourceLocation itemModel = ModelTemplates.FLAT_ITEM.create(block.asItem(), TextureMapping.layer0(block), this.modelOutput);

    List<Weighted<Variant>> variants = new ArrayList<>();

    for (Quadrant quadrant : Quadrant.values()) {
      variants.add(new Weighted<>(variant.with(VariantMutator.Y_ROT.withValue(quadrant)), 1));
      variants.add(new Weighted<>(variantWithLotus.with(VariantMutator.Y_ROT.withValue(quadrant)), 1));
    }

    this.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(itemModel));
    this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, new MultiVariant(WeightedList.of(variants))));
  }

  /**
   * Create a Big Lily Pad block.
   * @param block The Big Lily Pad block.
   */
  public final void createBigLilyPad(Block block) {
    PropertyDispatch.C2<MultiVariant, Direction, QuadDirection> c2 = PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, SMBBlockStateProperties.POSITION);

    /* Generate Block Model */
    for (int i = 0; i < QuadDirection.values().length; i++) {
      String suffix = "_" + i;

      TextureMapping textureMapping = TextureMapping.defaultTexture(block)
        .copyAndUpdate(TextureSlot.TEXTURE, ModelLocationUtils.getModelLocation(block).withSuffix(suffix));

      ResourceLocation model = SMBModelTemplates.SQUARE_HORIZONTAL.createWithSuffix(block, suffix, textureMapping, this.modelOutput);

      for (Direction facing : Direction.Plane.HORIZONTAL) {
        MultiVariant variant = new MultiVariant(WeightedList.of(new Variant(model)))
          .with(VariantMutator.MODEL.withValue(model));

        if (facing != Direction.NORTH) {
          VariantMutator yRot;

          switch (facing) {
            case EAST  -> yRot = VariantMutator.Y_ROT.withValue(Quadrant.R90);
            case SOUTH -> yRot = VariantMutator.Y_ROT.withValue(Quadrant.R180);
            case WEST  -> yRot = VariantMutator.Y_ROT.withValue(Quadrant.R270);
            default -> yRot = VariantMutator.Y_ROT.withValue(Quadrant.R0);
          }

          variant = variant.with(yRot);
        }

        c2.select(facing, QuadDirection.getByIndex(i), variant);
      }
    }

    ResourceLocation itemModel = ModelTemplates.FLAT_ITEM
      .create(block.asItem(), TextureMapping.layer0(block.asItem()), this.modelOutput);

    this.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(itemModel));
    this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(c2));
  }

  /**
   * Create a Leaves Bucket item.
   * @param item The Leaves Bucket item
   */
  public final void createLeavesBucket(Item item) {
    RangeSelectItemModel.Entry[] overrides = new RangeSelectItemModel.Entry[4];
    int units = LeavesBucketItem.MAX_VOLUME / overrides.length;

    for (int i = 0; i < overrides.length; i++) {
      String suffix = i == 0 ? "" : "_" + (i - 1);
      int threshold = i == 0 ? 0 : units * i;

      ResourceLocation identifier = ModelLocationUtils.getModelLocation(item).withSuffix(suffix);
      TextureMapping textureMapping = TextureMapping.layer0(item).put(TextureSlot.LAYER0, identifier);
      ResourceLocation itemModel = ModelTemplates.FLAT_ITEM.create(identifier, textureMapping, this.modelOutput);

      overrides[i] = ItemModelUtils.override(ItemModelUtils.plainModel(itemModel), threshold);
    }

    this.itemModelOutput.accept(item, ItemModelUtils.rangeSelect(new BucketVolumeProperty(), overrides[3].model(), overrides));
  }

  /**
   * Create a Leaf Litter block and Bucket item.
   * @param block The Leaf Litter block.
   * @param item The Leaves Bucket item.
   */
  public final void createLeafLitterWithBucket(Block block, Item item) {
    MultiVariant variant1 = BlockModelGenerators.plainVariant(TexturedModel.LEAF_LITTER_1.create(block, this.modelOutput));
    MultiVariant variant2 = BlockModelGenerators.plainVariant(TexturedModel.LEAF_LITTER_2.create(block, this.modelOutput));
    MultiVariant variant3 = BlockModelGenerators.plainVariant(TexturedModel.LEAF_LITTER_3.create(block, this.modelOutput));
    MultiVariant variant4 = BlockModelGenerators.plainVariant(TexturedModel.LEAF_LITTER_4.create(block, this.modelOutput));

    this.blockModelGenerators.createSegmentedBlock(block,
      variant1, BlockModelGenerators.LEAF_LITTER_MODEL_1_SEGMENT_CONDITION,
      variant2, BlockModelGenerators.LEAF_LITTER_MODEL_2_SEGMENT_CONDITION,
      variant3, BlockModelGenerators.LEAF_LITTER_MODEL_3_SEGMENT_CONDITION,
      variant4, BlockModelGenerators.LEAF_LITTER_MODEL_4_SEGMENT_CONDITION
    );

    this.createLeavesBucket(item);
  }

  public final void createFlowerBedWithItem(Block block, Item item, boolean isNetherVersion) {
    this.blockModelGenerators.registerSimpleFlatItemModel(item);
    ResourceLocation resourceLocation = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_1 : SMBModelTemplates.NETHER_FLOWERBED_1).create(block, this.modelOutput);
    ResourceLocation resourceLocation2 = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_2 : SMBModelTemplates.NETHER_FLOWERBED_2).create(block, this.modelOutput);
    ResourceLocation resourceLocation3 = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_3 : SMBModelTemplates.NETHER_FLOWERBED_3).create(block, this.modelOutput);
    ResourceLocation resourceLocation4 = TexturedModel.createDefault(TextureMapping::flowerbed, !isNetherVersion ? SMBModelTemplates.TINTED_FLOWERBED_4 : SMBModelTemplates.NETHER_FLOWERBED_4).create(block, this.modelOutput);

    this.blockModelGenerators.createSegmentedBlock(block,
      BlockModelGenerators.plainVariant(resourceLocation), BlockModelGenerators.FLOWER_BED_MODEL_1_SEGMENT_CONDITION,
      BlockModelGenerators.plainVariant(resourceLocation2), BlockModelGenerators.FLOWER_BED_MODEL_2_SEGMENT_CONDITION,
      BlockModelGenerators.plainVariant(resourceLocation3), BlockModelGenerators.FLOWER_BED_MODEL_3_SEGMENT_CONDITION,
      BlockModelGenerators.plainVariant(resourceLocation4), BlockModelGenerators.FLOWER_BED_MODEL_4_SEGMENT_CONDITION
    );
  }

  /**
   * Create a Double Plant with Emissive textures.
   * @param block The plant block.
   */
  public final void createEmissiveDoublePlantWithDefaultItem(Block block) {
    TextureMapping topTextureMapping = TextureMapping.crossEmissive(block)
      .put(TextureSlot.CROSS, ModelLocationUtils.getModelLocation(block, "_top"))
      .put(TextureSlot.CROSS_EMISSIVE, ModelLocationUtils.getModelLocation(block, "_top_emissive"));

    TextureMapping bottomTextureMapping = TextureMapping.crossEmissive(block)
      .put(TextureSlot.CROSS, ModelLocationUtils.getModelLocation(block, "_bottom"))
      .put(TextureSlot.CROSS_EMISSIVE, ModelLocationUtils.getModelLocation(block, "_bottom_emissive"));

    ResourceLocation topModel = ModelTemplates.CROSS_EMISSIVE.createWithSuffix(block, "_top", topTextureMapping, this.modelOutput);
    ResourceLocation bottomModel = ModelTemplates.CROSS_EMISSIVE.createWithSuffix(block, "_bottom", bottomTextureMapping, this.modelOutput);

    TextureMapping itemTextureMapping = TextureMapping.layered(
      topTextureMapping.get(TextureSlot.CROSS),  topTextureMapping.get(TextureSlot.CROSS_EMISSIVE));

    ResourceLocation itemModel = ModelTemplates.TWO_LAYERED_ITEM.create(block.asItem(), itemTextureMapping, this.modelOutput);

    this.itemModelOutput.accept(block.asItem(), ItemModelUtils.plainModel(itemModel));
    this.blockModelGenerators.createDoubleBlock(block, BlockModelGenerators.plainVariant(topModel), BlockModelGenerators.plainVariant(bottomModel));
  }

  /**
   * Create a Square Horizontal Y-Axis Rotatable block with variations indexed as suffix.
   * @param block The block flat block.
   * @param maxVariations The max number of variations.
   */
  public final MultiVariant createIndexedModelWithYRotationVariant(Block block, int maxVariations) {
    return this.createIndexedModelWithYRotationVariant(block, true, maxVariations);
  }

  /**
   * Create a Square Horizontal Y-Axis Rotatable block with variations indexed as suffix.
   * @param block The block flat block.
   * @param generateBlockState If true, the block state will be generated.
   * @param maxVariations The max number of variations.
   */
  public final MultiVariant createIndexedModelWithYRotationVariant(Block block, boolean generateBlockState, int maxVariations) {
    if (maxVariations <= 0) {
      throw new IllegalArgumentException("The max variations value should be 1 or greater.");
    }

    List<Weighted<Variant>> variants = new ArrayList<>();

    for (int i = 0; i < maxVariations; i++) {
      String suffix = maxVariations > 1 ? "_" + i : "";

      TextureMapping textureMapping = TextureMapping.defaultTexture(block)
        .copyAndUpdate(TextureSlot.TEXTURE, ModelLocationUtils.getModelLocation(block).withSuffix(suffix));

      ResourceLocation model = SMBModelTemplates.SQUARE_HORIZONTAL.createWithSuffix(block, suffix, textureMapping, this.modelOutput);

      for (Quadrant quadrant : Quadrant.values()) {
        Variant variant = new Variant(model)
          .with(VariantMutator.MODEL.withValue(model))
          .with(VariantMutator.Y_ROT.withValue(quadrant));

        variants.add(new Weighted<>(variant, 1));
      }
    }

    MultiVariant multiVariant = new MultiVariant(WeightedList.of(variants));

    if (!generateBlockState) return multiVariant;
    this.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, multiVariant));

    return multiVariant;
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
    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, BlockModelGenerators.plainVariant(model)));
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
    return new CarvedWoodBlockProvider(block, this.modelOutput, this.itemModelOutput, this.blockStateOutput);
  }

  /**
   * The Tiled Glass provider
   * Used to generate a Tiled Glass and Tiled Glass Pane blocks.
   * @param block The Tile Glass block.
   */
  public final TiledGlassBlockProvider tiledGlassProvider(Block block) {
    return new TiledGlassBlockProvider(block, this.modelOutput, this.itemModelOutput, this.blockStateOutput);
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
