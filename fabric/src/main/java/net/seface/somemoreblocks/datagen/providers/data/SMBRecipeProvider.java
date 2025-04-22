package net.seface.somemoreblocks.datagen.providers.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.registries.SMBBlockFamilies;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class SMBRecipeProvider extends FabricRecipeProvider {
  public SMBRecipeProvider(FabricDataOutput fabricOutput, CompletableFuture<HolderLookup.Provider> future) {
    super(fabricOutput, future);
  }

  @Override
  protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
    return new RecipeProvider(provider, output) {

      @Override
      public void buildRecipes() {
        this.createBlockFamilyRecipes();

        /* More Building Block */

        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_STONE, List.of(Blocks.STONE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, BlockFamilies.STONE_BRICK, List.of(SMBBlocks.POLISHED_STONE.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.STONE_TILES, List.of(Blocks.STONE, Blocks.STONE_BRICKS, SMBBlocks.POLISHED_STONE.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.STONE_PILLAR.get(), Blocks.STONE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DEEPSLATE_PILLAR.get(), Blocks.DEEPSLATE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_DEEPSLATE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_DEEPSLATE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_CALCITE, List.of(Blocks.CALCITE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CALCITE_BRICKS, List.of(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CALCITE_PILLAR.get(), Blocks.CALCITE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CALCITE_TILES, List.of(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_CALCITE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_CALCITE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TUFF_PILLAR.get(), Blocks.TUFF);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.TUFF_TILES, List.of(Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_TUFF_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_TUFF);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_DRIPSTONE, List.of(Blocks.DRIPSTONE_BLOCK));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.DRIPSTONE_BRICKS, List.of(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DRIPSTONE_PILLAR.get(), Blocks.DRIPSTONE_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.DRIPSTONE_TILES, List.of(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_DRIPSTONE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_DRIPSTONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_MUD, List.of(Blocks.PACKED_MUD));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_MUD_BRICKS.get(), Blocks.PACKED_MUD);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD.get());
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MUD_PILLAR.get(), Blocks.PACKED_MUD);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MUD_TILES, List.of(Blocks.PACKED_MUD, SMBBlocks.POLISHED_MUD.get(), Blocks.MUD_BRICKS));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_MUD_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_MUD);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_RESIN, List.of(Blocks.RESIN_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RESIN_PILLAR.get(), Blocks.RESIN_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.RESIN_TILES, List.of(Blocks.RESIN_BLOCK, SMBBlocks.POLISHED_RESIN.get(), Blocks.RESIN_BRICKS));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_RESIN);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SANDSTONE_BRICKS, List.of(Blocks.SANDSTONE));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SANDSTONE_PILLAR.get(), Blocks.SANDSTONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SANDSTONE_TILES, List.of(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_SANDSTONE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.RED_SANDSTONE_BRICKS, List.of(Blocks.RED_SANDSTONE));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_SANDSTONE_PILLAR.get(), Blocks.RED_SANDSTONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.RED_SANDSTONE_TILES, List.of(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_RED_SANDSTONE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_PRISMARINE, List.of(Blocks.PRISMARINE));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_PRISMARINE_BRICKS.get(), Blocks.PRISMARINE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PRISMARINE_PILLAR.get(), Blocks.PRISMARINE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.PRISMARINE_TILES, List.of(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE_BRICKS));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_PRISMARINE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_PRISMARINE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.NETHER_BRICKS_PILLAR.get(), Blocks.NETHER_BRICKS);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICKS);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_NETHER_BRICKS_PILLAR.get(), Blocks.RED_NETHER_BRICKS);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get(), Blocks.BLACKSTONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_BLACKSTONE_TILES, List.of(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CORRUPTED_POLISHED_BLACKSTONE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_BLACKSTONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_END_STONE, List.of(Blocks.END_STONE));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_END_STONE_BRICKS.get(), Blocks.END_STONE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.END_STONE_PILLAR.get(), Blocks.END_STONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.END_STONE_TILES, List.of(Blocks.END_STONE, SMBBlocks.POLISHED_END_STONE.get(), Blocks.END_STONE_BRICKS));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_END_STONE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_END_STONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_PURPUR, List.of(Blocks.PURPUR_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_PURPUR.get(), Blocks.PURPUR_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.PURPUR_TILES, List.of(Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_PURPUR_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_PURPUR);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.COAL_BRICKS, List.of(Blocks.COAL_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.COAL_PILLAR.get(), Blocks.COAL_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_COAL, List.of(Blocks.COAL_BLOCK, SMBBlocks.COAL_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.IRON_BRICKS, List.of(Blocks.IRON_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.IRON_PILLAR.get(), Blocks.IRON_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_IRON, List.of(Blocks.IRON_BLOCK, SMBBlocks.IRON_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.IRON_GRATE.get(), Blocks.IRON_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.GOLD_BRICKS, List.of(Blocks.GOLD_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GOLD_PILLAR.get(), Blocks.GOLD_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_GOLD, List.of(Blocks.GOLD_BLOCK, SMBBlocks.GOLD_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.REDSTONE_BRICKS, List.of(Blocks.REDSTONE_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.REDSTONE_PILLAR.get(), Blocks.REDSTONE_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_REDSTONE, List.of(Blocks.REDSTONE_BLOCK, SMBBlocks.REDSTONE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.EMERALD_BRICKS, List.of(Blocks.EMERALD_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.EMERALD_PILLAR.get(), Blocks.EMERALD_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_EMERALD, List.of(Blocks.EMERALD_BLOCK, SMBBlocks.EMERALD_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.LAPIS_BRICKS, List.of(Blocks.LAPIS_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LAPIS_PILLAR.get(), Blocks.LAPIS_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_LAPIS, List.of(Blocks.LAPIS_BLOCK, SMBBlocks.LAPIS_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.DIAMOND_BRICKS, List.of(Blocks.DIAMOND_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIAMOND_PILLAR.get(), Blocks.DIAMOND_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_DIAMOND, List.of(Blocks.DIAMOND_BLOCK, SMBBlocks.DIAMOND_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIAMOND_GRATE.get(), Blocks.DIAMOND_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.NETHERITE_BRICKS, List.of(Blocks.NETHERITE_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.NETHERITE_PILLAR.get(), Blocks.NETHERITE_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_NETHERITE, List.of(Blocks.NETHERITE_BLOCK, SMBBlocks.NETHERITE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.NETHERITE_GRATE.get(), Blocks.NETHERITE_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_QUARTZ, List.of(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.AMETHYST_BRICKS, List.of(Blocks.AMETHYST_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.AMETHYST_PILLAR.get(), Blocks.AMETHYST_BLOCK);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_AMETHYST, List.of(Blocks.AMETHYST_BLOCK, SMBBlocks.AMETHYST_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.COPPER_BRICKS, List.of(Blocks.COPPER_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.COPPER_PILLAR.get(), Blocks.COPPER_BLOCK);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.CUT_COPPER, SMBBlocks.COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.EXPOSED_COPPER_BRICKS, List.of(Blocks.EXPOSED_COPPER));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.EXPOSED_COPPER_PILLAR.get(), Blocks.EXPOSED_COPPER);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.EXPOSED_CUT_COPPER, SMBBlocks.EXPOSED_COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.WEATHERED_COPPER_BRICKS, List.of(Blocks.WEATHERED_COPPER));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WEATHERED_COPPER_PILLAR.get(), Blocks.WEATHERED_COPPER);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.WEATHERED_CUT_COPPER, SMBBlocks.WEATHERED_COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.OXIDIZED_COPPER_BRICKS, List.of(Blocks.OXIDIZED_COPPER));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), Blocks.OXIDIZED_COPPER);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.OXIDIZED_CUT_COPPER, SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.WAXED_COPPER_BRICKS, List.of(Blocks.WAXED_COPPER_BLOCK));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.COPPER_PILLAR.get(), Blocks.WAXED_COPPER_BLOCK);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_CUT_COPPER, SMBBlocks.WAXED_COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.WAXED_EXPOSED_COPPER_BRICKS, List.of(Blocks.WAXED_EXPOSED_COPPER));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), Blocks.WAXED_EXPOSED_COPPER);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_EXPOSED_CUT_COPPER, SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.WAXED_WEATHERED_COPPER_BRICKS, List.of(Blocks.WAXED_WEATHERED_COPPER));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), Blocks.WAXED_WEATHERED_COPPER);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_WEATHERED_CUT_COPPER, SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.WAXED_OXIDIZED_COPPER_BRICKS, List.of(Blocks.WAXED_OXIDIZED_COPPER));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), Blocks.WAXED_OXIDIZED_COPPER);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.WAXED_OXIDIZED_CUT_COPPER, SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.BONE_BRICKS, List.of(Blocks.BONE_BLOCK));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.BONE_TILES, List.of(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SOUL_SANDSTONE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SOUL_SANDSTONE_BRICKS, List.of(SMBBlocks.SOUL_SANDSTONE.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SOUL_SANDSTONE_PILLAR.get(), SMBBlocks.SOUL_SANDSTONE.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SOUL_SANDSTONE_TILES, List.of(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_SOUL_SANDSTONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.CUT_SOUL_SANDSTONE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.get(), SMBBlocks.SOUL_SANDSTONE.get(), 2);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_ICE, List.of(Blocks.PACKED_ICE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.ICE_BRICKS, List.of(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ICE_PILLAR.get(), Blocks.PACKED_ICE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.ICE_TILES, List.of(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get()));

        /* More Building Blocks */
        this.carvedWoodFromLogs(SMBBlocks.CARVED_OAK_WOOD.get(), SMBBlocks.CARVED_OAK_LOG.get());
        this.mosaicBuilder(SMBBlocks.OAK_MOSAIC.get(), Blocks.OAK_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_SPRUCE_WOOD.get(), SMBBlocks.CARVED_SPRUCE_LOG.get());
        this.mosaicBuilder(SMBBlocks.SPRUCE_MOSAIC.get(), Blocks.SPRUCE_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_BIRCH_WOOD.get(), SMBBlocks.CARVED_BIRCH_LOG.get());
        this.mosaicBuilder(SMBBlocks.BIRCH_MOSAIC.get(), Blocks.BIRCH_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_JUNGLE_WOOD.get(), SMBBlocks.CARVED_JUNGLE_LOG.get());
        this.mosaicBuilder(SMBBlocks.JUNGLE_MOSAIC.get(), Blocks.JUNGLE_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_ACACIA_WOOD.get(), SMBBlocks.CARVED_ACACIA_LOG.get());
        this.mosaicBuilder(SMBBlocks.ACACIA_MOSAIC.get(), Blocks.ACACIA_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_DARK_OAK_WOOD.get(), SMBBlocks.CARVED_DARK_OAK_LOG.get());
        this.mosaicBuilder(SMBBlocks.DARK_OAK_MOSAIC.get(), Blocks.DARK_OAK_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_MANGROVE_WOOD.get(), SMBBlocks.CARVED_MANGROVE_LOG.get());
        this.mosaicBuilder(SMBBlocks.MANGROVE_MOSAIC.get(), Blocks.MANGROVE_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_CRIMSON_HYPHAE.get(), SMBBlocks.CARVED_CRIMSON_STEM.get());
        this.mosaicBuilder(SMBBlocks.CRIMSON_MOSAIC.get(), Blocks.CRIMSON_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_WARPED_HYPHAE.get(), SMBBlocks.CARVED_WARPED_STEM.get());
        this.mosaicBuilder(SMBBlocks.WARPED_MOSAIC.get(), Blocks.WARPED_SLAB);
        this.carvedWoodFromLogs(SMBBlocks.CARVED_CHERRY_WOOD.get(), SMBBlocks.CARVED_CHERRY_LOG.get());
        this.mosaicBuilder(SMBBlocks.CHERRY_MOSAIC.get(), Blocks.CHERRY_SLAB);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.STONE_TILES.get(), Blocks.STONE_BRICKS, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.STONE_PILLAR.get(), Blocks.STONE_BRICKS, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRANITE_PILLAR.get(), SMBBlocks.GRANITE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRANITE_TILES.get(), SMBBlocks.GRANITE_BRICKS.get(), 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_GRANITE_BRICKS.get(), SMBBlocks.GRANITE_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.GRANITE_BRICKS, List.of(Blocks.GRANITE, Blocks.POLISHED_GRANITE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.GRANITE_TILES, List.of(Blocks.GRANITE, Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_GRANITE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_GRANITE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRANITE_PILLAR.get(), Blocks.GRANITE);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_GRANITE.get(), Blocks.GRANITE);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIORITE_PILLAR.get(), SMBBlocks.DIORITE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIORITE_TILES.get(), SMBBlocks.DIORITE_BRICKS.get(), 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_DIORITE_BRICKS.get(), SMBBlocks.DIORITE_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.DIORITE_BRICKS, List.of(Blocks.DIORITE, Blocks.POLISHED_DIORITE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.DIORITE_TILES, List.of(Blocks.DIORITE, Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_DIORITE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_DIORITE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIORITE_PILLAR.get(), Blocks.DIORITE);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_DIORITE.get(), Blocks.DIORITE);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ANDESITE_PILLAR.get(), SMBBlocks.ANDESITE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ANDESITE_TILES.get(), SMBBlocks.ANDESITE_BRICKS.get(), 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_ANDESITE_BRICKS.get(), SMBBlocks.ANDESITE_BRICKS.get());
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.ANDESITE_BRICKS, List.of(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.ANDESITE_TILES, List.of(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_ANDESITE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_ANDESITE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ANDESITE_PILLAR.get(), Blocks.ANDESITE);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_ANDESITE.get(), Blocks.ANDESITE);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DEEPSLATE_PILLAR.get(), Blocks.DEEPSLATE_BRICKS, 2);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get(), Blocks.DEEPSLATE_BRICKS);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_DEEPSLATE.get(), Blocks.DEEPSLATE);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CALCITE_BRICKS.get(), Blocks.CALCITE, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CALCITE_PILLAR.get(), SMBBlocks.CALCITE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CALCITE_TILES.get(), SMBBlocks.CALCITE_BRICKS.get(), 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_CALCITE_BRICKS.get(), SMBBlocks.CALCITE_BRICKS.get());
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_CALCITE.get(), Blocks.CALCITE);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_TUFF_BRICKS.get(), Blocks.TUFF_BRICKS);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TUFF_PILLAR.get(), Blocks.TUFF_BRICKS, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TUFF_TILES.get(), Blocks.TUFF_BRICKS, 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_TUFF_BRICKS.get(), Blocks.TUFF_BRICKS);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_TUFF.get(), Blocks.TUFF);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DRIPSTONE_BRICKS.get(), Blocks.DRIPSTONE_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DRIPSTONE_PILLAR.get(), SMBBlocks.DRIPSTONE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DRIPSTONE_TILES.get(), SMBBlocks.DRIPSTONE_BRICKS.get(), 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get(), SMBBlocks.DRIPSTONE_BRICKS.get());
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_DRIPSTONE.get(), Blocks.DRIPSTONE_BLOCK);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_BRICKS.get(), Blocks.BRICKS);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_BRICKS.get(), Blocks.BRICKS);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_MUD_BRICKS.get(), Blocks.MUD_BRICKS);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_MUD_BRICKS.get(), Blocks.MUD_BRICK_SLAB, 1);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MUD_PILLAR.get(), Blocks.MUD_BRICKS, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MUD_TILES.get(), Blocks.MUD_BRICKS, 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_MUD_BRICKS.get(), Blocks.MUD_BRICKS);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_MUD.get(), Blocks.PACKED_MUD);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_RESIN_BRICKS.get(), Blocks.RESIN_BRICKS);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RESIN_PILLAR.get(), Blocks.RESIN_BRICKS, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RESIN_TILES.get(), Blocks.RESIN_BRICKS, 4);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_RESIN.get(), Blocks.RESIN_BLOCK);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SANDSTONE_BRICKS.get(), Blocks.CUT_SANDSTONE, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SANDSTONE_PILLAR.get(), SMBBlocks.SANDSTONE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SANDSTONE_TILES.get(), SMBBlocks.SANDSTONE_BRICKS.get(), 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_SANDSTONE_BRICKS.get(), SMBBlocks.SANDSTONE_BRICKS.get());
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_SANDSTONE_BRICKS.get(), Blocks.CUT_RED_SANDSTONE, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_SANDSTONE_PILLAR.get(), SMBBlocks.RED_SANDSTONE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_SANDSTONE_TILES.get(), SMBBlocks.RED_SANDSTONE_BRICKS.get(), 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get(), SMBBlocks.RED_SANDSTONE_BRICKS.get());
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_PRISMARINE_BRICKS.get(), Blocks.PRISMARINE_BRICK_SLAB, 1);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_PRISMARINE_BRICKS.get(), Blocks.PRISMARINE_BRICKS);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PRISMARINE_PILLAR.get(), Blocks.PRISMARINE_BRICKS, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PRISMARINE_TILES.get(), Blocks.PRISMARINE_BRICKS, 4);
        this.mossyPrismarineBricks();
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_PRISMARINE.get(), Blocks.PRISMARINE);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.NETHER_BRICKS_PILLAR.get(), Blocks.NETHER_BRICKS, 2);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICK_SLAB, 1);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_RED_NETHER_BRICKS.get(), Blocks.RED_NETHER_BRICKS);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_NETHER_BRICKS_PILLAR.get(), Blocks.RED_NETHER_BRICKS, 2);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get(), Blocks.POLISHED_BLACKSTONE_BRICKS, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.POLISHED_BLACKSTONE_TILES.get(), Blocks.POLISHED_BLACKSTONE_BRICKS, 4);
        this.corruptedBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get(), Blocks.POLISHED_BLACKSTONE_BRICKS);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_BLACKSTONE.get(), Blocks.BLACKSTONE);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_END_STONE_BRICKS.get(), Blocks.END_STONE_BRICK_SLAB, 1);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_END_STONE_BRICKS.get(), Blocks.END_STONE_BRICKS);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.END_STONE_PILLAR.get(), Blocks.END_STONE_BRICKS, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.END_STONE_TILES.get(), Blocks.END_STONE_BRICKS, 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_END_STONE_BRICKS.get(), Blocks.END_STONE_BRICKS);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_END_STONE.get(), Blocks.END_STONE);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_PURPUR.get(), Blocks.PURPUR_SLAB, 1);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_PURPUR_BLOCK.get(), Blocks.PURPUR_BLOCK);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PURPUR_TILES.get(), Blocks.PURPUR_BLOCK, 4);
        this.mossyBlockFromVineAndMossBlock(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_PURPUR_BLOCK.get(), Blocks.PURPUR_BLOCK);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_PURPUR.get(), SMBBlocks.POLISHED_PURPUR.get());
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_COAL.get(), Blocks.COAL_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.COAL_PILLAR.get(), Blocks.COAL_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.COAL_BRICKS.get(), SMBBlocks.CUT_COAL.get(), 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_IRON.get(), Blocks.IRON_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.IRON_PILLAR.get(), Blocks.IRON_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.IRON_BRICKS.get(), SMBBlocks.CUT_IRON.get(), 4);
        this.grate(SMBBlocks.IRON_GRATE.get(), Blocks.IRON_BLOCK);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_GOLD.get(), Blocks.GOLD_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GOLD_PILLAR.get(), Blocks.GOLD_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GOLD_BRICKS.get(), SMBBlocks.CUT_GOLD.get(), 4);
        this.twoByTwo(RecipeCategory.REDSTONE, SMBBlocks.CUT_REDSTONE.get(), Blocks.REDSTONE_BLOCK, 4);
        this.oneByTwo(RecipeCategory.REDSTONE, SMBBlocks.REDSTONE_PILLAR.get(), Blocks.REDSTONE_BLOCK, 2);
        this.twoByTwo(RecipeCategory.REDSTONE, SMBBlocks.REDSTONE_BRICKS.get(), SMBBlocks.CUT_REDSTONE.get(), 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_EMERALD.get(), Blocks.EMERALD_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.EMERALD_PILLAR.get(), Blocks.EMERALD_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.EMERALD_BRICKS.get(), SMBBlocks.CUT_EMERALD.get(), 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_LAPIS.get(), Blocks.LAPIS_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LAPIS_PILLAR.get(), Blocks.LAPIS_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LAPIS_BRICKS.get(), SMBBlocks.CUT_LAPIS.get(), 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_DIAMOND.get(), Blocks.DIAMOND_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIAMOND_PILLAR.get(), Blocks.DIAMOND_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIAMOND_BRICKS.get(), SMBBlocks.CUT_DIAMOND.get(), 4);
        this.grate(SMBBlocks.DIAMOND_GRATE.get(), Blocks.DIAMOND_BLOCK);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_NETHERITE.get(), Blocks.NETHERITE_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.NETHERITE_PILLAR.get(), Blocks.NETHERITE_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.NETHERITE_BRICKS.get(), SMBBlocks.CUT_NETHERITE.get(), 4);
        this.grate(SMBBlocks.NETHERITE_GRATE.get(), Blocks.NETHERITE_BLOCK);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_QUARTZ_BRICKS.get(), Blocks.QUARTZ_BRICKS);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_QUARTZ.get(), Blocks.QUARTZ_BRICKS, 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CUT_AMETHYST.get(), Blocks.AMETHYST_BLOCK, 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.AMETHYST_PILLAR.get(), Blocks.AMETHYST_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.AMETHYST_BRICKS.get(), SMBBlocks.CUT_AMETHYST.get(), 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.COPPER_PILLAR.get(), Blocks.COPPER_BLOCK, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.COPPER_BRICKS.get(), Blocks.CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_CUT_COPPER.get(), Blocks.CUT_COPPER);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.EXPOSED_COPPER_PILLAR.get(), Blocks.EXPOSED_COPPER, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.EXPOSED_COPPER_BRICKS.get(), Blocks.EXPOSED_CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), Blocks.EXPOSED_CUT_COPPER);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WEATHERED_COPPER_PILLAR.get(), Blocks.WEATHERED_COPPER, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WEATHERED_COPPER_BRICKS.get(), Blocks.WEATHERED_CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), Blocks.WEATHERED_CUT_COPPER);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), Blocks.OXIDIZED_COPPER, 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), Blocks.OXIDIZED_CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), Blocks.OXIDIZED_CUT_COPPER);
        this.oneByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_copper_pillar", SMBBlocks.WAXED_COPPER_PILLAR.get(), Blocks.WAXED_COPPER_BLOCK, 2);
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_copper_bricks", SMBBlocks.WAXED_COPPER_BRICKS.get(), Blocks.WAXED_CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.WAXED_CRACKED_CUT_COPPER.get(), Blocks.WAXED_CUT_COPPER);
        this.oneByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_exposed_copper_pillar", SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get(), Blocks.WAXED_EXPOSED_COPPER, 2);
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_exposed_copper_bricks", SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get(), Blocks.WAXED_EXPOSED_CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get(), Blocks.WAXED_EXPOSED_CUT_COPPER);
        this.oneByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_weathering_copper_pillar", SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get(), Blocks.WAXED_WEATHERED_COPPER, 2);
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_weathering_copper_bricks", SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get(), Blocks.WAXED_WEATHERED_CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get(), Blocks.WAXED_WEATHERED_CUT_COPPER);
        this.oneByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_oxidized_copper_pillar", SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get(), Blocks.WAXED_OXIDIZED_COPPER, 2);
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "waxed_oxidized_copper_bricks", SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get(), Blocks.WAXED_OXIDIZED_CUT_COPPER, 4);
        this.smeltingResultFromBase(SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get(), Blocks.WAXED_OXIDIZED_CUT_COPPER);
        this.waxedBlocksFromHoneycomb();
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BONE_BRICKS.get(), Blocks.BONE_BLOCK, 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BONE_TILES.get(), SMBBlocks.BONE_BRICKS.get(), 4);
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "soul_sandstone", Blocks.SOUL_SAND, SMBBlocks.SOUL_SANDSTONE.get(), 1);
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "soul_sandstone", Blocks.SOUL_SOIL, SMBBlocks.SOUL_SANDSTONE.get(), 1);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CHISELED_SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_SLAB.get(), 1);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SOUL_SANDSTONE_BRICKS.get(), SMBBlocks.CUT_SOUL_SANDSTONE.get(), 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SOUL_SANDSTONE_PILLAR.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SOUL_SANDSTONE_TILES.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get(), 4);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE.get());
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PACKED_SNOW.get(), Blocks.SNOW_BLOCK, 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SNOW_BRICKS.get(), SMBBlocks.PACKED_SNOW.get(), 4);
        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SNOW_PILLAR.get(), SMBBlocks.SNOW_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SNOW_TILES.get(), SMBBlocks.SNOW_BRICKS.get(), 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ICE_BRICKS.get(), Blocks.PACKED_ICE, 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ICE_PILLAR.get(), SMBBlocks.ICE_BRICKS.get(), 2);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ICE_TILES.get(), SMBBlocks.ICE_BRICKS.get(), 4);

        /* More Natural Blocks */
        this.snowyPlant(Blocks.SHORT_GRASS);
        this.snowyPlant(Blocks.FERN);
        this.snowyPlant(Blocks.TALL_GRASS);
        this.snowyPlant(Blocks.LARGE_FERN);

        /* More Colored Blocks */
        this.shingles();
        this.terracottaBricksAndTiles();
        this.concreteBricksAndTiles();
        this.tiledGlassAndTiledGlassPane();

        /* More Redstone Blocks */
        this.redstoneLamp(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get(), Blocks.OCHRE_FROGLIGHT);
        this.redstoneLamp(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get(), Blocks.VERDANT_FROGLIGHT);
        this.redstoneLamp(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get(), Blocks.PEARLESCENT_FROGLIGHT);
        this.redstoneLamp(SMBBlocks.REDSTONE_SHROOMLIGHT.get(), Blocks.SHROOMLIGHT);

        /* Extends Vanilla */
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICKS, SMBBlocks.POLISHED_PRISMARINE.get());
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICK_STAIRS, SMBBlocks.POLISHED_PRISMARINE.get());
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.PRISMARINE_BRICK_SLAB, SMBBlocks.POLISHED_PRISMARINE.get(), 2);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_STAIRS, SMBBlocks.POLISHED_MUD.get());
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_SLAB, SMBBlocks.POLISHED_MUD.get(), 2);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_WALL, SMBBlocks.POLISHED_MUD.get());
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE.get());
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICK_STAIRS, SMBBlocks.POLISHED_END_STONE.get());
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICK_SLAB, SMBBlocks.POLISHED_END_STONE.get(), 2);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICK_WALL, SMBBlocks.POLISHED_END_STONE.get());
        this.oneItemToOther(RecipeCategory.MISC, Items.GLOWSTONE_DUST, SMBBlocks.LUMINOUS_FLOWER.get(), 2);
        this.oneItemToOther(RecipeCategory.MISC, Items.GREEN_DYE, SMBBlocks.TINY_CACTUS.get(), 1);
      }

      /**
       * Generate all generic recipes for all custom Block Families.
       */
      private void createBlockFamilyRecipes() {
        for (Map.Entry<Block, BlockFamily> entry : SMBBlockFamilies.getAllFamilies().entrySet()) {
          if (!entry.getValue().shouldGenerateRecipe()) continue;
          this.generateRecipes(entry.getValue(), FeatureFlagSet.of(FeatureFlags.VANILLA));
        }
      }

      private void stonecutterFamily(RecipeCategory category, BlockFamily blockFamily) {
        this.stonecutterFamily(category, blockFamily, new ArrayList<>());
      }

      /**
       * Generate entire BlockFamily variations for Stonecutter recipes with parsed items.
       * @param blockFamily The affected BlockFamily.
       * @param items All the items to allow stonecutting to BlockFamily variations.
       */
      private void stonecutterFamily(RecipeCategory category, BlockFamily blockFamily, List<ItemLike> items) {
        this.stonecutterFrom(category, blockFamily.getBaseBlock(), items);

        for (Map.Entry<BlockFamily.Variant, Block> entry : blockFamily.getVariants().entrySet()) {
          BlockFamily.Variant variant = entry.getKey();
          Block block = entry.getValue();

          List<ItemLike> mutableItems = new ArrayList<>(items);

          if (!mutableItems.contains(blockFamily.getBaseBlock())) {
            mutableItems.add(blockFamily.getBaseBlock());
          }

          if (variant == BlockFamily.Variant.SLAB) {
            this.stonecutterFrom(category, block, mutableItems, 2);
            continue;
          }

          this.stonecutterFrom(category, block, mutableItems, 1);
        }
      }

      private void stonecutterFrom(RecipeCategory category, ItemLike result, ItemLike input) {
        this.stonecutterFrom(category, result, List.of(input));
      }

      private void stonecutterFrom(RecipeCategory category, ItemLike result, ItemLike input, int amount) {
        this.stonecutterFrom(category, result, List.of(input), amount);
      }

      private void stonecutterFrom(RecipeCategory category, ItemLike result, List<ItemLike> items) {
        this.stonecutterFrom(category, result, items, 1);
      }

      private void stonecutterFrom(RecipeCategory category, ItemLike result, List<ItemLike> items, int amount) {
        for (ItemLike input : items) {
          this.stonecutterResultFromBase(category, result, input, amount);
        }
      }

      /**
       * Create a generic Mossy Blocks recipe using Vines and Moss Block.
       * @param category The recipe category.
       * @param output The item output.
       * @param input The item input.
       */
      private void mossyBlockFromVineAndMossBlock(RecipeCategory category, ItemLike output, ItemLike input) {
        String mossyBlockPath = BuiltInRegistries.ITEM.getKey(output.asItem()).getPath();
        Block[] blocks = List.of(Blocks.VINE, Blocks.MOSS_BLOCK).toArray(new Block[0]);

        for (Block block : blocks) {
          this.shapeless(category, output, 1)
            .requires(input)
            .requires(block)
            .group(mossyBlockPath)
            .unlockedBy(RecipeProvider.getHasName(input), this.has(input))
            .save(this.output, getConversionRecipeName(output, block));
        }
      }

      /**
       * Create a Carved Wood from Carved Log block.
       * @param carvedWood The Carved Wood to be crafted.
       * @param carvedLog The Carved Log to be used as item.
       */
      private void carvedWoodFromLogs(ItemLike carvedWood, ItemLike carvedLog) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, carvedWood, 3)
          .define('#', carvedLog)
          .pattern("##")
          .pattern("##")
          .group("carved_wood")
          .unlockedBy("has_carved_log", this.has(carvedLog))
          .save(this.output);
      }

      /**
       * Create a Mosaic Block.
       * This actually already exist, but we are adding the group "mosaic" here.
       * @param output The item output.
       * @param input The item input.
       */
      private void mosaicBuilder(ItemLike output, ItemLike input) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, output)
          .define('#', input)
          .pattern("#")
          .pattern("#")
          .group("mosaic")
          .unlockedBy(RecipeProvider.getHasName(input), this.has(input))
          .save(this.output);
      }

      /**
       * Create a Mossy Prismarine Bricks recipe using KELP.
       */
      private void mossyPrismarineBricks() {
        this.shapeless(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MOSSY_PRISMARINE_BRICKS.get(), 1)
          .requires(Blocks.PRISMARINE_BRICKS)
          .requires(Items.KELP)
          .unlockedBy(RecipeProvider.getHasName(Blocks.PRISMARINE_BRICKS), this.has(Blocks.PRISMARINE_BRICKS))
          .save(this.output);
      }

      /**
       * Create a Corrupted Block like recipe.
       * @param category The recipe category.
       * @param output The item output.
       * @param input The item input.
       */
      private void corruptedBlock(RecipeCategory category, ItemLike output, ItemLike input) {
        this.shapeless(category, output, 1)
          .requires(Items.MAGMA_CREAM)
          .requires(input)
          .unlockedBy(RecipeProvider.getHasName(input), this.has(input))
          .save(this.output);
      }

      /**
       * Create a Redstone Lamp like recipe.
       * @param output The item output.
       * @param input The item input.
       */
      private void redstoneLamp(ItemLike output, ItemLike input) {
        this.shaped(RecipeCategory.REDSTONE, output, 1)
          .define('#', Items.REDSTONE)
          .define('X', input)
          .pattern(" # ")
          .pattern("#X#")
          .pattern(" # ")
          .unlockedBy(RecipeProvider.getHasName(input), this.has(input))
          .save(this.output);
      }

      /**
       * Transform one item into others.
       * @param category The recipe category.
       * @param output The transformed item.
       * @param input The item to be transformed.
       * @param amount The output amount.
       */
      private void oneItemToOther(RecipeCategory category, ItemLike output, ItemLike input, int amount) {
        this.shapeless(category, output, amount)
          .requires(input)
          .unlockedBy(RecipeProvider.getHasName(input), this.has(input))
          .save(this.output, getConversionRecipeName(output, input));
      }

      /**
       * Generate all the Shingles block variants.
       */
      private void shingles() {
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block shingles = SMBRegistries.SHINGLES_BLOCKS.getNext(dyeColor).orElseThrow();
          Block terracotta = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_terracotta"));

          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "shingles_from_dye", SMBBlocks.SHINGLES.get(), shingles, dyeColor);
          this.oneByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "shingles_from_terracotta", shingles, terracotta, 4);
          this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, shingles, List.of(terracotta));
        }

        this.oneByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SHINGLES.get(), Blocks.TERRACOTTA, 4);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SHINGLES.get(), List.of(Blocks.TERRACOTTA));
      }

      /**
       * Generate all the Terracotta Bricks and Terracotta Tiles blocks variants.
       */
      private void terracottaBricksAndTiles() {
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block terracotta = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_terracotta"));
          Block terracottaBricks = SMBRegistries.TERRACOTTA_BRICKS_BLOCKS.getNext(dyeColor).orElseThrow();
          Block terracottaTiles = SMBRegistries.TERRACOTTA_TILES_BLOCKS.getNext(dyeColor).orElseThrow();

          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "terracotta_bricks_from_dye", SMBBlocks.TERRACOTTA_BRICKS.get(), terracottaBricks, dyeColor);
          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "terracotta_tiles_from_dye", SMBBlocks.TERRACOTTA_TILES.get(), terracottaTiles, dyeColor);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "terracotta_bricks_from_terracotta", terracotta, terracottaBricks, 4);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "terracotta_tiles_from_terracotta_bricks", terracottaBricks, terracottaTiles, 4);
          this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, terracottaBricks, List.of(terracotta));
          this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, terracottaTiles, List.of(terracotta, terracottaBricks));
        }

        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TERRACOTTA_BRICKS.get(), Blocks.TERRACOTTA, 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TERRACOTTA_TILES.get(), SMBBlocks.TERRACOTTA_BRICKS.get(), 4);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TERRACOTTA_BRICKS.get(), List.of(Blocks.TERRACOTTA));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TERRACOTTA_TILES.get(), List.of(Blocks.TERRACOTTA, SMBBlocks.TERRACOTTA_BRICKS.get()));
      }

      /**
       * Generate all the Concrete Bricks and Concrete Tiles blocks variants.
       */
      private void concreteBricksAndTiles() {
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block concrete = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_concrete"));
          Block concreteBricks = SMBRegistries.CONCRETE_BRICKS_BLOCKS.getNext(dyeColor).orElseThrow();
          Block concreteTiles = SMBRegistries.CONCRETE_TILES_BLOCKS.getNext(dyeColor).orElseThrow();

          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "concrete_bricks_from_concrete", concrete, concreteBricks, 4);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "concrete_tiles_from_concrete_bricks", concreteBricks, concreteTiles, 4);
          this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, concreteTiles, List.of(concrete, concreteBricks));
        }
      }

      /**
       * Generate all the Tiled Glass and Tiled Glass Pane blocks variants.
       */
      private void tiledGlassAndTiledGlassPane() {
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block stainedGlass = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_stained_glass"));
          Block tiledGlass = SMBRegistries.STAINED_TILED_GLASS_BLOCKS.getNext(dyeColor).orElseThrow();
          Block tiledGlassPane = SMBRegistries.STAINED_TILED_GLASS_PANE_BLOCKS.getNext(dyeColor).orElseThrow();

          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "tiled_glass_from_dye", SMBBlocks.TILED_GLASS.get(), tiledGlass, dyeColor);
          this.aroundDyeItemWith(RecipeCategory.MISC, "tiled_glass_pane_from_dye", SMBBlocks.TILED_GLASS_PANE.get(), tiledGlassPane, dyeColor);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "tiled_glass_from_stained_glass", stainedGlass, tiledGlass, 4);
          this.tiledGlassPaneFromTiledGlass(RecipeCategory.MISC, tiledGlass, tiledGlassPane);
        }

        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TILED_TINTED_GLASS.get(), Blocks.TINTED_GLASS, 4);
        this.twoByTwo(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TILED_GLASS.get(), Blocks.GLASS, 4);
        this.tiledGlassPaneFromTiledGlass(RecipeCategory.MISC, SMBBlocks.TILED_GLASS.get(), SMBBlocks.TILED_GLASS_PANE.get());
      }

      /**
       * Create all Waxed Blocks from Honeycomb craft.
       */
      private void waxedBlocksFromHoneycomb() {
        for (Block block : SMBRegistries.WAXED_COPPER_BLOCKS.getKeySet()) {
          Block waxedBlock = SMBRegistries.WAXED_COPPER_BLOCKS.getNext(block).get();
          String group = BuiltInRegistries.ITEM.getKey(waxedBlock.asItem()).getPath();

          this.shapeless(RecipeCategory.BUILDING_BLOCKS, waxedBlock, 1)
            .requires(Items.HONEYCOMB)
            .requires(block)
            .group(group)
            .unlockedBy(RecipeProvider.getHasName(block), this.has(block))
            .save(this.output, getConversionRecipeName(waxedBlock, Items.HONEYCOMB));
        }
      }

      /**
       * Create a Tiled Glass Pane from Tiled Glass full block.
       * @param category The recipe category.
       * @param tiledGlass The Tiled Glass to be used.
       * @param tiledGlassPane The Tiled Glass Pane output.
       */
      private void tiledGlassPaneFromTiledGlass(RecipeCategory category, ItemLike tiledGlass, ItemLike tiledGlassPane) {
        this.shaped(category, tiledGlassPane, 16)
          .define('#', tiledGlass)
          .pattern("###")
          .pattern("###")
          .group("tiled_glass_pane_from_tiled_glass")
          .unlockedBy(RecipeProvider.getHasName(tiledGlass), this.has(tiledGlass))
          .save(this.output, getConversionRecipeName(tiledGlassPane, tiledGlass));
      }

      /**
       * Create a 1x2 craft recipe with no group linked.
       * @param category The recipe category.
       * @param output The item result.
       * @param input The item used in 2x2 square.
       * @param amount The result amount.
       */
      private void oneByTwo(RecipeCategory category, ItemLike output, ItemLike input, int amount) {
        this.oneByTwoBuilder(category, output, input, amount).save(this.output);
      }

      /**
       * Create a 1x2 craft recipe with group linked.
       * @param category The recipe category.
       * @param group The recipe group.
       * @param output The item result.
       * @param input The item used in 1x2 square.
       * @param amount The result amount.
       */
      private void oneByTwoGrouped(RecipeCategory category, String group, ItemLike output, ItemLike input, int amount) {
        this.oneByTwoBuilder(category, output, input, amount).group(group).save(this.output, getConversionRecipeName(output, input));
      }

      /**
       * Create a generic 1x2 craft recipe
       * @param category The recipe category.
       * @param output The item result.
       * @param input The item used in 1x2 square.
       * @param amount The result amount.
       * @return The Shaped Builder with 1x2 pattern.
       */
      private ShapedRecipeBuilder oneByTwoBuilder(RecipeCategory category, ItemLike output, ItemLike input, int amount) {
        return this.shaped(category, output, amount)
          .define('#', input)
          .pattern("#")
          .pattern("#")
          .unlockedBy(RecipeProvider.getHasName(input), this.has(input));
      }

      /**
       * Create a 2x2 craft recipe with no group linked.
       * @param category The recipe category.
       * @param output The item result.
       * @param input The item used in 2x2 square.
       * @param amount The result amount.
       */
      public void twoByTwo(RecipeCategory category, ItemLike output, ItemLike input, int amount) {
        this.twoByTwoBuilder(category, input, output, amount).save(this.output);
      }

      /**
       * Create a 2x2 craft recipe with group linked.
       * @param category The recipe category.
       * @param group The recipe group.
       * @param output The item result.
       * @param input The item used in 2x2 square.
       * @param amount The result amount.
       */
      private void twoByTwoGrouped(RecipeCategory category, String group, ItemLike input, ItemLike output, int amount) {
        this.twoByTwoBuilder(category, input, output, amount).group(group).save(this.output, getConversionRecipeName(output, input));
      }

      /**
       * Create a generic 2x2 craft recipe
       * @param category The recipe category.
       * @param output The item result.
       * @param input The item used in 2x2 square.
       * @param amount The result amount.
       * @return The Shaped Builder with 2x2 pattern.
       */
      private ShapedRecipeBuilder twoByTwoBuilder(RecipeCategory category, ItemLike input, ItemLike output, int amount) {
        return this.shaped(category, output, amount)
          .define('#', input)
          .pattern("##")
          .pattern("##")
          .unlockedBy(RecipeProvider.getHasName(input), this.has(input));
      }

      /**
       * Create a generic 3x3 recipe with base item surrounding a Dye Item.
       * @param category The recipe category.
       * @param group The recipe group.
       * @param baseItem The base item to surround the Dye Item.
       * @param output The item output.
       * @param dyeColor The Dye Color.
       */
      private void aroundDyeItemWith(RecipeCategory category, String group, ItemLike baseItem, ItemLike output, @Nullable DyeColor dyeColor) {
        DyeItem dyeItem = DyeItem.byColor(dyeColor);

        this.shaped(category, output, 8)
          .define('#', baseItem)
          .define('X', dyeItem)
          .pattern("###")
          .pattern("#X#")
          .pattern("###")
          .group(group)
          .unlockedBy(RecipeProvider.getHasName(dyeItem), this.has(dyeItem))
          .save(this.output);
      }

      /**
       * Create a Snowy Plant like recipe.
       * @param inputItem The item input.
       */
      private void snowyPlant(Block inputItem) {
        Block snowyPlant = SMBRegistries.SNOWY_PLANT_BLOCKS.getNext(inputItem).get();

        this.shapeless(RecipeCategory.MISC, snowyPlant)
          .requires(inputItem)
          .requires(Items.SNOWBALL)
          .unlockedBy(RecipeProvider.getHasName(inputItem), this.has(inputItem))
          .save(this.output);
      }
    };
  }

  @Override
  public String getName() { return "Recipe"; }
}
