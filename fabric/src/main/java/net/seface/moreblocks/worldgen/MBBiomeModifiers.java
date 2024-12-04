package net.seface.moreblocks.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.moreblocks.data.MBPlacedFeature;
import net.seface.moreblocks.data.MBBiomeTags;

public class MBBiomeModifiers {
  public static void register() {
    registerVegetalDecoration(MBBiomeTags.GENERATES_CATTAIL, MBPlacedFeature.PATCH_CATTAIL);
    registerUndergroundDecoration(MBBiomeTags.GENERATES_LUMINOUS_FLOWER, MBPlacedFeature.PATCH_LUMINOUS_FLOWER);
    registerVegetalDecoration(MBBiomeTags.GENERATES_SMALL_LILY_PADS, MBPlacedFeature.PATCH_SMALL_LILY_PADS);
    registerTinyCactusDecoration(MBPlacedFeature.PATCH_TINY_CACTUS);
    registerDuneGrassDecoration(MBPlacedFeature.PATCH_DUNE_GRASS);
    registerDuneGrassDecoration(MBPlacedFeature.PATCH_TALL_DUNE_GRASS);
    registerLeafLitterDecoration(MBPlacedFeature.NONE_LEAF_LITTER);

    //registerVegetalDecoration(BiomeTags.IS_OVERWORLD, MBPlacedFeature.PATCH_RED_MUSHROOM_COLONY_WALL);
  }

  private static void registerVegetalDecoration(TagKey<Biome> biomeTag, ResourceKey<PlacedFeature> feature) {
    registerDecoration(biomeTag, GenerationStep.Decoration.VEGETAL_DECORATION, feature);
  }

  private static void registerUndergroundDecoration(TagKey<Biome> biomeTag, ResourceKey<PlacedFeature> feature) {
    registerDecoration(biomeTag, GenerationStep.Decoration.UNDERGROUND_DECORATION, feature);
  }

  private static void registerDecoration(TagKey<Biome> biomeTag, GenerationStep.Decoration step, ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(biomeTag).test(ctx), step, feature
    );
  }

  private static void registerTinyCactusDecoration(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(MBBiomeTags.GENERATES_TINY_CACTUS).test(ctx) && ctx.getBiome().getBaseTemperature() >= 0.3F,
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }

  private static void registerDuneGrassDecoration(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(BiomeTags.IS_BEACH).test(ctx) && ctx.getBiome().getBaseTemperature() >= 0.5F,
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }

  private static void registerLeafLitterDecoration(ResourceKey<PlacedFeature> feature) {
    BiomeModifications.addFeature(
      (ctx) -> BiomeSelectors.tag(BiomeTags.IS_OVERWORLD).test(ctx),
      GenerationStep.Decoration.VEGETAL_DECORATION,
      feature
    );
  }
}
