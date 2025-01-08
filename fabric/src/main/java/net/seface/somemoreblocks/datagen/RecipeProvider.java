package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.seface.somemoreblocks.registry.MBBlocks;

public class RecipeProvider extends FabricRecipeProvider {
  private RecipeOutput exporter;

  public RecipeProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void buildRecipes(RecipeOutput exporter) {
    this.exporter = exporter;

    this.createGlassPaneRecipe(MBBlocks.TILED_GLASS, MBBlocks.TILED_GLASS_PANE, Blocks.GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.BLACK_STAINED_TILED_GLASS, MBBlocks.BLACK_STAINED_TILED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.BLUE_STAINED_TILED_GLASS, MBBlocks.BLUE_STAINED_TILED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.BROWN_STAINED_TILED_GLASS, MBBlocks.BROWN_STAINED_TILED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.CYAN_STAINED_TILED_GLASS, MBBlocks.CYAN_STAINED_TILED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.GRAY_STAINED_TILED_GLASS, MBBlocks.GRAY_STAINED_TILED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.GREEN_STAINED_TILED_GLASS, MBBlocks.GREEN_STAINED_TILED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.LIME_STAINED_TILED_GLASS, MBBlocks.LIME_STAINED_TILED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.MAGENTA_STAINED_TILED_GLASS, MBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.ORANGE_STAINED_TILED_GLASS, MBBlocks.ORANGE_STAINED_TILED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.PINK_STAINED_TILED_GLASS, MBBlocks.PINK_STAINED_TILED_GLASS_PANE, Blocks.PINK_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.PURPLE_STAINED_TILED_GLASS, MBBlocks.PURPLE_STAINED_TILED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.RED_STAINED_TILED_GLASS, MBBlocks.RED_STAINED_TILED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.WHITE_STAINED_TILED_GLASS, MBBlocks.WHITE_STAINED_TILED_GLASS_PANE, Blocks.WHITE_STAINED_GLASS_PANE);
    this.createGlassPaneRecipe(MBBlocks.YELLOW_STAINED_TILED_GLASS, MBBlocks.YELLOW_STAINED_TILED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS_PANE);
  }

  private void createGlassPaneRecipe(Block tiledGlass, Block tiledGlassPane, Block vanillaGlassPane) {
    String group = tiledGlassPane instanceof StainedGlassPaneBlock ? "stained_tiled_glass_pane" : "tiled_glass_pane";

    // With Dye in the center
    if (tiledGlassPane instanceof StainedGlassPaneBlock) {
      DyeItem dye = DyeItem.byColor(((StainedGlassPaneBlock) tiledGlassPane).getColor());

      ResourceLocation fromTiledGlassPane = BuiltInRegistries.ITEM.getKey(tiledGlassPane.asItem())
        .withSuffix("_from_tiled_glass_pane");

      ShapedRecipeBuilder.shaped(RecipeCategory.MISC, tiledGlassPane, 8)
        .define('#', MBBlocks.TILED_GLASS_PANE)
        .define('$', dye)
        .pattern("###")
        .pattern("#$#")
        .pattern("###")
        .unlockedBy("has_needed_items", FabricRecipeProvider.has(tiledGlass))
        .group(group)
        .save(this.exporter, fromTiledGlassPane);
    }

    // With Vanilla Stained Glass Pane
    ResourceLocation fromVanillaPane = BuiltInRegistries.ITEM.getKey(tiledGlassPane.asItem())
      .withSuffix("_from_" + BuiltInRegistries.ITEM.getKey(vanillaGlassPane.asItem()).getPath());

    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, tiledGlassPane, 4)
      .define('#', vanillaGlassPane)
      .pattern("##")
      .pattern("##")
      .unlockedBy("has_needed_items", FabricRecipeProvider.has(vanillaGlassPane))
      .group(group)
      .save(this.exporter, fromVanillaPane);

    // Default recipe
    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, tiledGlassPane, 16)
      .define('#', tiledGlass)
      .pattern("###")
      .pattern("###")
      .unlockedBy("has_needed_items", FabricRecipeProvider.has(tiledGlass))
      .group(group)
      .save(this.exporter);
  }
}
