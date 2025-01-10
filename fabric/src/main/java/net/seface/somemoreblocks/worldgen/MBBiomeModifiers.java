package net.seface.somemoreblocks.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.somemoreblocks.data.SMBBiomeTags;
import net.seface.somemoreblocks.data.SMBPlacedFeature;

public class MBBiomeModifiers {
  public static void register() {
    registerVegetalDecoration(SMBBiomeTags.GENERATES_CATTAIL, SMBPlacedFeature.PATCH_CATTAIL);
    registerUndergroundDecoration(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER, SMBPlacedFeature.PATCH_LUMINOUS_FLOWER);
    registerVegetalDecoration(SMBBiomeTags.GENERATES_SMALL_LILY_PADS, SMBPlacedFeature.PATCH_SMALL_LILY_PADS);
    registerTinyCactusDecoration(SMBPlacedFeature.PATCH_TINY_CACTUS);
    registerDuneGrassDecoration(SMBPlacedFeature.PATCH_DUNE_GRASS);
    registerDuneGrassDecoration(SMBPlacedFeature.PATCH_TALL_DUNE_GRASS);
    registerLeafLitterDecoration(SMBPlacedFeature.NONE_LEAF_LITTER);
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
      (ctx) -> BiomeSelectors.tag(SMBBiomeTags.GENERATES_TINY_CACTUS).test(ctx) && ctx.getBiome().getBaseTemperature() >= 0.3F,
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
