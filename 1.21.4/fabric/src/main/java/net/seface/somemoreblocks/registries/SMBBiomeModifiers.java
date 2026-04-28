package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.somemoreblocks.tags.SMBBiomeTags;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

public class SMBBiomeModifiers {
  public static void init() {
    SMBBiomeModifiers.noneBigLilyPad();
    SMBBiomeModifiers.patchCactusPlants();
    SMBBiomeModifiers.patchCattail();
    SMBBiomeModifiers.patchCattailSwamp();
    SMBBiomeModifiers.patchClover();
    SMBBiomeModifiers.patchCrimsonFungusColony(SMBPlacedFeature.PATCH_CRIMSON_FUNGUS_COLONY);
    SMBBiomeModifiers.patchCrimsonFungusColony(SMBPlacedFeature.SIMPLE_CRIMSON_FUNGUS_COLONY_WALL);
    SMBBiomeModifiers.patchDuneGrass();
    SMBBiomeModifiers.patchLargeSnowFern();
    SMBBiomeModifiers.patchLuminousFlower();
    SMBBiomeModifiers.patchNetherClover();
    SMBBiomeModifiers.patchPaleMushroom();
    SMBBiomeModifiers.patchPaleRoseBush();
    SMBBiomeModifiers.patchSmallLilyPads();
    SMBBiomeModifiers.patchSmallLilyPadsLushCaves();
    SMBBiomeModifiers.patchSnowGrass();
    SMBBiomeModifiers.patchWarpedFungusColony(SMBPlacedFeature.PATCH_WARPED_FUNGUS_COLONY);
    SMBBiomeModifiers.patchWarpedFungusColony(SMBPlacedFeature.SIMPLE_WARPED_FUNGUS_COLONY_WALL);
    SMBBiomeModifiers.simpleBrownMushroomColony(SMBPlacedFeature.PATCH_BROWN_MUSHROOM_COLONY);
    SMBBiomeModifiers.simpleBrownMushroomColony(SMBPlacedFeature.SIMPLE_BROWN_MUSHROOM_COLONY_WALL);
    SMBBiomeModifiers.simpleLeafLitter(SMBPlacedFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER);
    SMBBiomeModifiers.simpleLeafLitter(SMBPlacedFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER);
    SMBBiomeModifiers.simpleLeafLitter(SMBPlacedFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER);
    SMBBiomeModifiers.simpleLeafLitter(SMBPlacedFeature.SIMPLE_BLOCK_LEAF_LITTER);
    SMBBiomeModifiers.simpleLeafLitter(SMBPlacedFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER);
    SMBBiomeModifiers.simpleLeafLitter(SMBPlacedFeature.SIMPLE_BLOCK_SPRUCE_LEAF_LITTER);
    SMBBiomeModifiers.simplePaleMushroomColony(SMBPlacedFeature.PATCH_PALE_MUSHROOM_COLONY);
    SMBBiomeModifiers.simplePaleMushroomColony(SMBPlacedFeature.SIMPLE_PALE_MUSHROOM_COLONY_WALL);
    SMBBiomeModifiers.simpleRedMushroomColony(SMBPlacedFeature.PATCH_RED_MUSHROOM_COLONY);
    SMBBiomeModifiers.simpleRedMushroomColony(SMBPlacedFeature.SIMPLE_RED_MUSHROOM_COLONY_WALL);
  }

  private static void noneBigLilyPad() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_BIG_LILY_PAD).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.NONE_BIG_LILY_PAD
    );
  }

  private static void patchPaleRoseBush() {
    BiomeModifications.addFeature(
      (ctx) -> ctx.getBiomeKey() == Biomes.PALE_GARDEN,
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_PALE_ROSE_BUSH
    );
  }

  private static void patchCactusPlants() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_CACTUS_PLANTS).test(ctx) && ctx.getBiome().getBaseTemperature() >= 0.3F,
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_CACTUS_PLANTS
    );
  }

  private static void patchCattail() {
    BiomeModifications.addFeature(
      (ctx) -> ctx.getBiomeKey() == Biomes.RIVER,
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_CATTAIL
    );
  }

  private static void patchCattailSwamp() {
    BiomeModifications.addFeature(
      (ctx) -> ctx.getBiomeKey() == Biomes.SWAMP,
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_CATTAIL
    );
  }

  private static void patchClover() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_CLOVER).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_CLOVER
    );
  }

  private static void patchNetherClover() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_NETHER_CLOVER).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_NETHER_CLOVER
    );
  }

  private static void patchDuneGrass() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(BiomeTags.IS_BEACH).test(ctx) && ctx.getBiome().getBaseTemperature() >= 0.5F,
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_DUNE_GRASS
    );
  }

  private static void patchLuminousFlower() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_LUMINOUS_FLOWER
    );
  }

  private static void patchSmallLilyPads() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_SMALL_LILY_PADS).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_SMALL_LILY_PADS
    );
  }

  private static void patchSmallLilyPadsLushCaves() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.includeByKey(Biomes.LUSH_CAVES).test(ctx),
      GenerationStep.Decoration.UNDERGROUND_DECORATION,
      SMBPlacedFeature.PATCH_SMALL_LILY_PADS_LUSH_CAVES
    );
  }

  private static void patchSnowGrass() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_SNOW_GRASS).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_SNOW_GRASS
    );
  }

  private static void patchPaleMushroom() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_PALE_MUSHROOM).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_PALE_MUSHROOM
    );
  }

  private static void patchLargeSnowFern() {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_LARGE_SNOW_FERN).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      SMBPlacedFeature.PATCH_LARGE_SNOW_FERN
    );
  }

  private static void patchWarpedFungusColony(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.foundInTheNether().test(ctx) && BiomeSelectors.tag(SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }

  private static void patchCrimsonFungusColony(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.foundInTheNether().test(ctx) && BiomeSelectors.tag(SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }

  private static void simpleRedMushroomColony(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }

  private static void simplePaleMushroomColony(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_PALE_MUSHROOM_COLONY).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }

  private static void simpleBrownMushroomColony(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }

  private static void simpleLeafLitter(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(BiomeTags.IS_OVERWORLD).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }
}
