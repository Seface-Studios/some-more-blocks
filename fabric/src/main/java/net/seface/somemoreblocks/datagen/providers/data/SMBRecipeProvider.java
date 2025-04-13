package net.seface.somemoreblocks.datagen.providers.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.seface.somemoreblocks.SomeMoreBlocks;
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

        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.POLISHED_STONE, List.of(Blocks.STONE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, BlockFamilies.STONE_BRICK, List.of(SMBBlocks.POLISHED_STONE.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.STONE_TILES, List.of(Blocks.STONE, Blocks.STONE_BRICKS, SMBBlocks.POLISHED_STONE.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.STONE_PILLAR.get(), Blocks.STONE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.GRANITE_BRICKS, List.of(Blocks.GRANITE, Blocks.POLISHED_GRANITE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.GRANITE_TILES, List.of(Blocks.GRANITE, Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_GRANITE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_GRANITE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRANITE_PILLAR.get(), Blocks.GRANITE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.DIORITE_BRICKS, List.of(Blocks.DIORITE, Blocks.POLISHED_DIORITE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.DIORITE_TILES, List.of(Blocks.DIORITE, Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_DIORITE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_DIORITE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.DIORITE_PILLAR.get(), Blocks.DIORITE);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.ANDESITE_BRICKS, List.of(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.ANDESITE_TILES, List.of(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_BRICKS.get()));
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.MOSSY_ANDESITE_BRICKS);
        this.stonecutterFamily(RecipeCategory.BUILDING_BLOCKS, SMBBlockFamilies.SMOOTH_ANDESITE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ANDESITE_PILLAR.get(), Blocks.ANDESITE);
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
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.SHINGLES.get(), Blocks.TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WHITE_SHINGLES.get(), Blocks.WHITE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_GRAY_SHINGLES.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRAY_SHINGLES.get(), Blocks.GRAY_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLACK_SHINGLES.get(), Blocks.BLACK_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BROWN_SHINGLES.get(), Blocks.BROWN_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_SHINGLES.get(), Blocks.RED_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ORANGE_SHINGLES.get(), Blocks.ORANGE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.YELLOW_SHINGLES.get(), Blocks.YELLOW_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIME_SHINGLES.get(), Blocks.LIME_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GREEN_SHINGLES.get(), Blocks.GREEN_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CYAN_SHINGLES.get(), Blocks.CYAN_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_BLUE_SHINGLES.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLUE_SHINGLES.get(), Blocks.BLUE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PURPLE_SHINGLES.get(), Blocks.PURPLE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MAGENTA_SHINGLES.get(), Blocks.MAGENTA_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PINK_SHINGLES.get(), Blocks.PINK_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TERRACOTTA_BRICKS.get(), Blocks.TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WHITE_TERRACOTTA_BRICKS.get(), Blocks.WHITE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRAY_TERRACOTTA_BRICKS.get(), Blocks.GRAY_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLACK_TERRACOTTA_BRICKS.get(), Blocks.BLACK_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BROWN_TERRACOTTA_BRICKS.get(), Blocks.BROWN_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_TERRACOTTA_BRICKS.get(), Blocks.RED_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get(), Blocks.ORANGE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get(), Blocks.YELLOW_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIME_TERRACOTTA_BRICKS.get(), Blocks.LIME_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GREEN_TERRACOTTA_BRICKS.get(), Blocks.GREEN_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CYAN_TERRACOTTA_BRICKS.get(), Blocks.CYAN_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLUE_TERRACOTTA_BRICKS.get(), Blocks.BLUE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get(), Blocks.PURPLE_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get(), Blocks.MAGENTA_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PINK_TERRACOTTA_BRICKS.get(), Blocks.PINK_TERRACOTTA);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.TERRACOTTA_TILES.get(), List.of(Blocks.TERRACOTTA, SMBBlocks.TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WHITE_TERRACOTTA_TILES.get(), List.of(Blocks.WHITE_TERRACOTTA, SMBBlocks.WHITE_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get(), List.of(Blocks.LIGHT_GRAY_TERRACOTTA, SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRAY_TERRACOTTA_TILES.get(), List.of(Blocks.GRAY_TERRACOTTA, SMBBlocks.GRAY_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLACK_TERRACOTTA_TILES.get(), List.of(Blocks.BLACK_TERRACOTTA, SMBBlocks.BLACK_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BROWN_TERRACOTTA_TILES.get(), List.of(Blocks.BROWN_TERRACOTTA, SMBBlocks.BROWN_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_TERRACOTTA_TILES.get(), List.of(Blocks.RED_TERRACOTTA, SMBBlocks.RED_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ORANGE_TERRACOTTA_TILES.get(), List.of(Blocks.ORANGE_TERRACOTTA, SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.YELLOW_TERRACOTTA_TILES.get(), List.of(Blocks.YELLOW_TERRACOTTA, SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIME_TERRACOTTA_TILES.get(), List.of(Blocks.LIME_TERRACOTTA, SMBBlocks.LIME_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GREEN_TERRACOTTA_TILES.get(), List.of(Blocks.GREEN_TERRACOTTA, SMBBlocks.GREEN_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CYAN_TERRACOTTA_TILES.get(), List.of(Blocks.CYAN_TERRACOTTA, SMBBlocks.CYAN_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get(), List.of(Blocks.LIGHT_BLUE_TERRACOTTA, SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLUE_TERRACOTTA_TILES.get(), List.of(Blocks.BLUE_TERRACOTTA, SMBBlocks.BLUE_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PURPLE_TERRACOTTA_TILES.get(), List.of(Blocks.PURPLE_TERRACOTTA, SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MAGENTA_TERRACOTTA_TILES.get(), List.of(Blocks.MAGENTA_TERRACOTTA, SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PINK_TERRACOTTA_TILES.get(), List.of(Blocks.PINK_TERRACOTTA, SMBBlocks.PINK_TERRACOTTA_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WHITE_CONCRETE_BRICKS.get(), Blocks.WHITE_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get(), Blocks.LIGHT_GRAY_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRAY_CONCRETE_BRICKS.get(), Blocks.GRAY_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLACK_CONCRETE_BRICKS.get(), Blocks.BLACK_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BROWN_CONCRETE_BRICKS.get(), Blocks.BROWN_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_CONCRETE_BRICKS.get(), Blocks.RED_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ORANGE_CONCRETE_BRICKS.get(), Blocks.ORANGE_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.YELLOW_CONCRETE_BRICKS.get(), Blocks.YELLOW_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIME_CONCRETE_BRICKS.get(), Blocks.LIME_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GREEN_CONCRETE_BRICKS.get(), Blocks.GREEN_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CYAN_CONCRETE_BRICKS.get(), Blocks.CYAN_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get(), Blocks.LIGHT_BLUE_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLUE_CONCRETE_BRICKS.get(), Blocks.BLUE_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PURPLE_CONCRETE_BRICKS.get(), Blocks.PURPLE_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MAGENTA_CONCRETE_BRICKS.get(), Blocks.MAGENTA_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PINK_CONCRETE_BRICKS.get(), Blocks.PINK_CONCRETE);
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.WHITE_CONCRETE_TILES.get(), List.of(Blocks.WHITE_CONCRETE, SMBBlocks.WHITE_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_GRAY_CONCRETE_TILES.get(), List.of(Blocks.LIGHT_GRAY_CONCRETE, SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GRAY_CONCRETE_TILES.get(), List.of(Blocks.GRAY_CONCRETE, SMBBlocks.GRAY_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLACK_CONCRETE_TILES.get(), List.of(Blocks.BLACK_CONCRETE, SMBBlocks.BLACK_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BROWN_CONCRETE_TILES.get(), List.of(Blocks.BROWN_CONCRETE, SMBBlocks.BROWN_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.RED_CONCRETE_TILES.get(), List.of(Blocks.RED_CONCRETE, SMBBlocks.RED_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.ORANGE_CONCRETE_TILES.get(), List.of(Blocks.ORANGE_CONCRETE, SMBBlocks.ORANGE_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.YELLOW_CONCRETE_TILES.get(), List.of(Blocks.YELLOW_CONCRETE, SMBBlocks.YELLOW_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIME_CONCRETE_TILES.get(), List.of(Blocks.LIME_CONCRETE, SMBBlocks.LIME_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.GREEN_CONCRETE_TILES.get(), List.of(Blocks.GREEN_CONCRETE, SMBBlocks.GREEN_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.CYAN_CONCRETE_TILES.get(), List.of(Blocks.CYAN_CONCRETE, SMBBlocks.CYAN_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.LIGHT_BLUE_CONCRETE_TILES.get(), List.of(Blocks.LIGHT_BLUE_CONCRETE, SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.BLUE_CONCRETE_TILES.get(), List.of(Blocks.BLUE_CONCRETE, SMBBlocks.BLUE_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PURPLE_CONCRETE_TILES.get(), List.of(Blocks.PURPLE_CONCRETE, SMBBlocks.PURPLE_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.MAGENTA_CONCRETE_TILES.get(), List.of(Blocks.MAGENTA_CONCRETE, SMBBlocks.MAGENTA_CONCRETE_BRICKS.get()));
        this.stonecutterFrom(RecipeCategory.BUILDING_BLOCKS, SMBBlocks.PINK_CONCRETE_TILES.get(), List.of(Blocks.PINK_CONCRETE, SMBBlocks.PINK_CONCRETE_BRICKS.get()));

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

        /* Implementing... */
        this.shingles();
        this.terracottaBricksAndTiles();
        this.concreteBricksAndTiles();
        this.tiledGlassAndTiledGlassPane();
        this.snowyPlant(Blocks.SHORT_GRASS);
        this.snowyPlant(Blocks.FERN);
        this.snowyPlant(Blocks.TALL_GRASS);
        this.snowyPlant(Blocks.LARGE_FERN);

        /* Testing Things below */

        /* 1.21.4 */
        /*this.pillar(Blocks.PALE_OAK_SLAB, SMBBlocks.PALE_OAK_MOSAIC.get(), 1);
        this.stairs(SMBBlocks.PALE_OAK_MOSAIC.get(), SMBBlocks.PALE_OAK_MOSAIC_STAIRS.get());
        this.slab(SMBBlocks.PALE_OAK_MOSAIC.get(), SMBBlocks.PALE_OAK_MOSAIC_SLAB.get());
        this.woodFromLogs(SMBBlocks.CARVED_PALE_OAK_WOOD.get(), SMBBlocks.CARVED_PALE_OAK_LOG.get());
        this.stairs(SMBBlocks.POLISHED_RESIN.get(), SMBBlocks.POLISHED_RESIN_STAIRS.get(), SMBBlocks.POLISHED_RESIN.get());
        this.slab(SMBBlocks.POLISHED_RESIN.get(), SMBBlocks.POLISHED_RESIN_SLAB.get(), SMBBlocks.POLISHED_RESIN.get());
        this.smeltingResultFromBase(SMBBlocks.CRACKED_RESIN_BRICKS.get(), Blocks.RESIN_BRICKS);
        this.pillar(Blocks.RESIN_BRICKS, SMBBlocks.RESIN_PILLAR.get());
        this.twoByTwoPacker(Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES.get(), 4, Blocks.RESIN_BRICKS);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_RESIN_TILES.get(), SMBBlocks.RESIN_TILES.get());
        this.stairs(SMBBlocks.RESIN_TILES.get(), SMBBlocks.RESIN_TILE_STAIRS.get(), Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES.get());
        this.slab(SMBBlocks.RESIN_TILES.get(), SMBBlocks.RESIN_TILE_SLAB.get(), Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES.get());
        this.wall(SMBBlocks.RESIN_TILES.get(), SMBBlocks.RESIN_TILE_WALL.get(), Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES.get());
        this.twoByTwoPacker(Blocks.RESIN_BLOCK, SMBBlocks.POLISHED_RESIN.get(), 4);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_RESIN.get(), Blocks.RESIN_BLOCK);
        this.slab(SMBBlocks.SMOOTH_RESIN.get(), SMBBlocks.SMOOTH_RESIN_SLAB.get(), SMBBlocks.SMOOTH_RESIN.get());*/
      }

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
       * Generate all the Shingles block variants.
       */
      private void shingles() {
        SomeMoreBlocks.LOGGER.info("Generating Shingles recipes.");
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block shingles = SMBRegistries.SHINGLES_BLOCKS.getNext(dyeColor).orElseThrow();
          Block terracotta = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_terracotta"));

          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "shingles_from_dye", SMBBlocks.SHINGLES.get(), shingles, dyeColor);
          this.shinglesFromTerracotta(RecipeCategory.BUILDING_BLOCKS, "shingles_from_terracotta", terracotta, shingles);
        }

        this.shinglesFromTerracotta(RecipeCategory.BUILDING_BLOCKS, "shingles", Blocks.TERRACOTTA, SMBBlocks.SHINGLES.get());
      }

      /**
       * Generate all the Terracotta Bricks and Terracotta Tiles blocks variants.
       */
      private void terracottaBricksAndTiles() {
        SomeMoreBlocks.LOGGER.info("Generating Terracotta Bricks and Terracotta Tiles recipes.");
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block terracotta = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_terracotta"));
          Block terracottaBricks = SMBRegistries.TERRACOTTA_BRICKS_BLOCKS.getNext(dyeColor).orElseThrow();
          Block terracottaTiles = SMBRegistries.TERRACOTTA_TILES_BLOCKS.getNext(dyeColor).orElseThrow();

          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "terracotta_bricks_from_dye", SMBBlocks.TERRACOTTA_BRICKS.get(), terracottaBricks, dyeColor);
          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "terracotta_tiles_from_dye", SMBBlocks.TERRACOTTA_TILES.get(), terracottaTiles, dyeColor);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "terracotta_bricks_from_terracotta", terracotta, terracottaBricks);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "terracotta_tiles_from_terracotta_bricks", terracottaBricks, terracottaTiles);
        }

        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "terracotta_bricks", Blocks.TERRACOTTA, SMBBlocks.TERRACOTTA_BRICKS.get());
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "terracotta_tiles", SMBBlocks.TERRACOTTA_BRICKS.get(), SMBBlocks.TERRACOTTA_TILES.get());
      }

      /**
       * Generate all the Concrete Bricks and Concrete Tiles blocks variants.
       */
      private void concreteBricksAndTiles() {
        SomeMoreBlocks.LOGGER.info("Generating Concrete Bricks and Concrete Tiles recipes.");
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block concrete = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_concrete"));
          Block concreteBricks = SMBRegistries.CONCRETE_BRICKS_BLOCKS.getNext(dyeColor).orElseThrow();
          Block concreteTiles = SMBRegistries.CONCRETE_TILES_BLOCKS.getNext(dyeColor).orElseThrow();

          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "concrete_bricks_from_concrete", concrete, concreteBricks);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "concrete_tiles_from_concrete_bricks", concreteBricks, concreteTiles);
        }
      }

      /**
       * Generate all the Tiled Glass and Tiled Glass Pane blocks variants.
       */
      private void tiledGlassAndTiledGlassPane() {
        SomeMoreBlocks.LOGGER.info("Generating Tiled Glass and Tiled Glass Pane recipes.");
        DyeColor[] dyeColors = DyeColor.values();

        for (DyeColor dyeColor : dyeColors) {
          Block stainedGlass = BuiltInRegistries.BLOCK.getValue(ResourceLocation.withDefaultNamespace(dyeColor + "_stained_glass"));
          Block tiledGlass = SMBRegistries.STAINED_TILED_GLASS_BLOCKS.getNext(dyeColor).orElseThrow();
          Block tiledGlassPane = SMBRegistries.STAINED_TILED_GLASS_PANE_BLOCKS.getNext(dyeColor).orElseThrow();

          this.aroundDyeItemWith(RecipeCategory.BUILDING_BLOCKS, "tiled_glass_from_dye", SMBBlocks.TILED_GLASS.get(), tiledGlass, dyeColor);
          this.aroundDyeItemWith(RecipeCategory.MISC, "tiled_glass_pane_from_dye", SMBBlocks.TILED_GLASS_PANE.get(), tiledGlassPane, dyeColor);
          this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "tiled_glass_from_stained_glass", stainedGlass, tiledGlass);
          this.tiledGlassPaneFromTiledGlass(RecipeCategory.MISC, tiledGlass, tiledGlassPane);
        }

        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "tiled_tinted_glass", Blocks.TINTED_GLASS, SMBBlocks.TILED_TINTED_GLASS.get());
        this.twoByTwoGrouped(RecipeCategory.BUILDING_BLOCKS, "tiled_glass", Blocks.GLASS, SMBBlocks.TILED_GLASS.get());
        this.tiledGlassPaneFromTiledGlass(RecipeCategory.MISC, SMBBlocks.TILED_GLASS.get(), SMBBlocks.TILED_GLASS_PANE.get());
      }

      /* =================== */
      private void shinglesFromTerracotta(RecipeCategory category, String group, ItemLike terracotta, ItemLike shingles) {
        this.shaped(category, shingles, 2)
          .define('#', terracotta)
          .pattern("#")
          .pattern("#")
          .group(group)
          .unlockedBy(RecipeProvider.getHasName(terracotta), this.has(terracotta))
          .save(this.output, getConversionRecipeName(shingles, terracotta));
      }

      private void tiledGlassPaneFromTiledGlass(RecipeCategory category, ItemLike tiledGlass, ItemLike tiledGlassPane) {
        this.shaped(category, tiledGlassPane, 16)
          .define('#', tiledGlass)
          .pattern("###")
          .pattern("###")
          .group("tiled_glass_pane_from_tiled_glass")
          .unlockedBy(RecipeProvider.getHasName(tiledGlass), this.has(tiledGlass))
          .save(this.output, getConversionRecipeName(tiledGlassPane, tiledGlass));
      }

      private void twoByTwoGrouped(RecipeCategory category, String group, ItemLike input, ItemLike output) {
        this.shaped(category, output, 4)
          .define('#', input)
          .pattern("##")
          .pattern("##")
          .group(group)
          .unlockedBy(RecipeProvider.getHasName(input), this.has(input))
          .save(this.output, getConversionRecipeName(output, input));
      }

      private void aroundDyeItemWith(RecipeCategory category, String group, ItemLike baseBlock, ItemLike output, @Nullable DyeColor dyeColor) {
        DyeItem dyeItem = DyeItem.byColor(dyeColor);

        this.shaped(category, output, 8)
          .define('#', baseBlock)
          .define('X', dyeItem)
          .pattern("###")
          .pattern("#X#")
          .pattern("###")
          .group(group)
          .unlockedBy(RecipeProvider.getHasName(dyeItem), this.has(dyeItem))
          .save(this.output);
      }

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
  public String getName() {
    return "Recipe";
  }
}
