package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.List;
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
        this.snowyPlant(Blocks.SHORT_GRASS, SMBBlocks.SHORT_SNOW_GRASS);
        this.snowyPlant(Blocks.FERN, SMBBlocks.SNOW_FERN);
        this.snowyPlant(Blocks.TALL_GRASS, SMBBlocks.TALL_SNOW_GRASS);
        this.snowyPlant(Blocks.LARGE_FERN, SMBBlocks.LARGE_SNOW_FERN);
        this.createGlassPaneRecipe(SMBBlocks.TILED_GLASS, SMBBlocks.TILED_GLASS_PANE, Blocks.GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.BLACK_STAINED_TILED_GLASS, SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.BLUE_STAINED_TILED_GLASS, SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.BROWN_STAINED_TILED_GLASS, SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.CYAN_STAINED_TILED_GLASS, SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.GRAY_STAINED_TILED_GLASS, SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.GREEN_STAINED_TILED_GLASS, SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.LIME_STAINED_TILED_GLASS, SMBBlocks.LIME_STAINED_TILED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.MAGENTA_STAINED_TILED_GLASS, SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.ORANGE_STAINED_TILED_GLASS, SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.PINK_STAINED_TILED_GLASS, SMBBlocks.PINK_STAINED_TILED_GLASS_PANE, Blocks.PINK_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.PURPLE_STAINED_TILED_GLASS, SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.RED_STAINED_TILED_GLASS, SMBBlocks.RED_STAINED_TILED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.WHITE_STAINED_TILED_GLASS, SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE, Blocks.WHITE_STAINED_GLASS_PANE);
        this.createGlassPaneRecipe(SMBBlocks.YELLOW_STAINED_TILED_GLASS, SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS_PANE);

        /* 1.21.4 */
        this.pillar(Blocks.PALE_OAK_SLAB, SMBBlocks.PALE_OAK_MOSAIC, 1);
        this.stairs(SMBBlocks.PALE_OAK_MOSAIC, SMBBlocks.PALE_OAK_MOSAIC_STAIRS);
        this.slab(SMBBlocks.PALE_OAK_MOSAIC, SMBBlocks.PALE_OAK_MOSAIC_SLAB);
        this.woodFromLogs(SMBBlocks.CARVED_PALE_OAK_WOOD, SMBBlocks.CARVED_PALE_OAK_LOG);
        this.stairs(SMBBlocks.POLISHED_RESIN, SMBBlocks.POLISHED_RESIN_STAIRS, SMBBlocks.POLISHED_RESIN);
        this.slab(SMBBlocks.POLISHED_RESIN, SMBBlocks.POLISHED_RESIN_SLAB, SMBBlocks.POLISHED_RESIN);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_RESIN_BRICKS, Blocks.RESIN_BRICKS);
        this.pillar(Blocks.RESIN_BRICKS, SMBBlocks.RESINE_PILLAR);
        this.twoByTwoPacker(Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES, 4, Blocks.RESIN_BRICKS);
        this.smeltingResultFromBase(SMBBlocks.CRACKED_RESIN_TILES, SMBBlocks.RESIN_TILES);
        this.stairs(SMBBlocks.RESIN_TILES, SMBBlocks.RESIN_TILE_STAIRS, Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES);
        this.slab(SMBBlocks.RESIN_TILES, SMBBlocks.RESIN_TILE_SLAB, Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES);
        this.wall(SMBBlocks.RESIN_TILES, SMBBlocks.RESIN_TILE_WALL, Blocks.RESIN_BRICKS, SMBBlocks.RESIN_TILES);
        this.twoByTwoPacker(Blocks.RESIN_BLOCK, SMBBlocks.POLISHED_RESIN, 4);
        this.smeltingResultFromBase(SMBBlocks.SMOOTH_RESIN, Blocks.RESIN_BLOCK);
        this.slab(SMBBlocks.SMOOTH_RESIN, SMBBlocks.SMOOTH_RESIN_SLAB, SMBBlocks.SMOOTH_RESIN);
      }

      private void snowyPlant(ItemLike input, ItemLike result) {
        this.shapeless(RecipeCategory.MISC, result)
          .requires(input)
          .requires(Items.SNOWBALL)
          .unlockedBy(getHasName(input), this.has(input))
          .save(this.output);
      }

      private void stonecuttingFrom(ItemLike result, ItemLike ...stonecuttingFrom) {
        this.stonecuttingFrom(result, 1, stonecuttingFrom);
      }

      private void stonecuttingFrom(ItemLike result, int count, ItemLike ...stonecuttingFrom) {
        for (ItemLike input : List.of(stonecuttingFrom)) {
          this.stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, result, input, count);
        }
      }

      public void twoByTwoPacker(ItemLike input, ItemLike result, ItemLike ...stonecuttingFrom) {
        this.twoByTwoPacker(input, result, 1, stonecuttingFrom);
      }

      public void twoByTwoPacker(ItemLike input, ItemLike result, int count, ItemLike ...stonecuttingFrom) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
          .define('#', input)
          .pattern("##")
          .pattern("##")
          .unlockedBy(getHasName(input), this.has(input))
          .save(this.output);


        this.stonecuttingFrom(result, stonecuttingFrom);
      }

      public void slab(ItemLike input, ItemLike result, ItemLike ...stoneCuttingFrom) {
        this.slab(RecipeCategory.BUILDING_BLOCKS, result, input);
        this.stonecuttingFrom(result, 2, stoneCuttingFrom);
      }

      public void wall(ItemLike input, ItemLike result, ItemLike ...stoneCuttingFrom) {
        this.wall(RecipeCategory.BUILDING_BLOCKS, result, input);
        this.stonecuttingFrom(result, stoneCuttingFrom);
      }

      private void pillar(ItemLike input, ItemLike result, ItemLike ...stoneCuttingFrom) {
        this.pillar(input, result, 2, stoneCuttingFrom);
      }

      private void pillar(ItemLike input, ItemLike result, int count, ItemLike ...stoneCuttingFrom) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, result, count)
          .define('#', input)
          .pattern("#")
          .pattern("#")
          .unlockedBy(getHasName(input), this.has(input))
          .save(this.output);

        this.stonecuttingFrom(result, stoneCuttingFrom);
      }

      private void stairs(ItemLike input, ItemLike result, ItemLike ...stoneCuttingFrom) {
        this.stairBuilder(result, Ingredient.of(input))
          .unlockedBy(getHasName(input), this.has(input))
          .save(this.output);

        this.stonecuttingFrom(result, stoneCuttingFrom);
      }

      private void createGlassPaneRecipe(Block tiledGlass, Block tiledGlassPane, Block vanillaGlassPane) {
        String group = tiledGlassPane instanceof StainedGlassPaneBlock ? "stained_tiled_glass_pane" : "tiled_glass_pane";

        // With Dye in the center
        if (tiledGlassPane instanceof StainedGlassPaneBlock) {
          DyeItem dye = DyeItem.byColor(((StainedGlassPaneBlock) tiledGlassPane).getColor());

          ResourceLocation fromTiledGlassPane = BuiltInRegistries.ITEM.getKey(tiledGlassPane.asItem())
            .withSuffix("_from_tiled_glass_pane");

          ShapedRecipeBuilder.shaped(BuiltInRegistries.ITEM, RecipeCategory.MISC, tiledGlassPane.asItem(), 8)
            .define('#', SMBBlocks.TILED_GLASS_PANE)
            .define('$', dye)
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .unlockedBy("has_needed_items", this.has(tiledGlass))
            .group(group)
            .save(output, ResourceKey.create(Registries.RECIPE, fromTiledGlassPane));
        }

        // With Vanilla Stained Glass Pane
        ResourceLocation fromVanillaPane = BuiltInRegistries.ITEM.getKey(tiledGlassPane.asItem())
          .withSuffix("_from_" + BuiltInRegistries.ITEM.getKey(vanillaGlassPane.asItem()).getPath());

        ShapedRecipeBuilder.shaped(BuiltInRegistries.ITEM, RecipeCategory.MISC, tiledGlassPane.asItem(), 4)
          .define('#', vanillaGlassPane)
          .pattern("##")
          .pattern("##")
          .unlockedBy("has_needed_items", this.has(vanillaGlassPane))
          .group(group)
          .save(output, ResourceKey.create(Registries.RECIPE, fromVanillaPane));

        // Default recipe
        ShapedRecipeBuilder.shaped(BuiltInRegistries.ITEM, RecipeCategory.MISC, tiledGlassPane.asItem(), 16)
          .define('#', tiledGlass)
          .pattern("###")
          .pattern("###")
          .unlockedBy("has_needed_items", this.has(tiledGlass))
          .group(group)
          .save(output);
      }
    };
  }

  @Override
  public String getName() {
    return null;
  }
}
