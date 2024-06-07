package net.seface.moreblocks.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.seface.moreblocks.feature.MBPlacedFeature;
import net.seface.moreblocks.tags.MBBiomeTags;

public class WorldGeneration {
    public static void register() {
      BiomeModifications.addFeature(
        (ctx) ->  WorldGeneration.genericTestWithBiomeTag(ctx, MBBiomeTags.CAN_GENERATE_SMALL_LILY_PADS),
        GenerationStep.Decoration.VEGETAL_DECORATION,
        MBPlacedFeature.PLACED_PATCH_SMALL_LILY_PADS
      );

      BiomeModifications.addFeature(
        (ctx) ->  WorldGeneration.genericTestWithBiomeTag(ctx, MBBiomeTags.CAN_GENERATE_BIG_LILY_PAD),
        GenerationStep.Decoration.VEGETAL_DECORATION,
        MBPlacedFeature.PLACED_PATCH_BIG_LILY_PAD
      );

        BiomeModifications.addFeature(
          WorldGeneration::canGenerateDuneGrass,
          GenerationStep.Decoration.VEGETAL_DECORATION,
          MBPlacedFeature.PLACED_PATCH_DUNE_GRASS
        );

        BiomeModifications.addFeature(
           WorldGeneration::canGenerateDuneGrass,
           GenerationStep.Decoration.VEGETAL_DECORATION,
           MBPlacedFeature.PLACED_PATCH_TALL_DUNE_GRASS
        );

        BiomeModifications.addFeature(
          (ctx) ->  WorldGeneration.genericTestWithBiomeTag(ctx, MBBiomeTags.CAN_GENERATE_TINY_CACTUS),
          GenerationStep.Decoration.VEGETAL_DECORATION,
          MBPlacedFeature.PLACED_PATCH_TINY_CACTUS_FOREST
        );

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.RIVER),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                MBPlacedFeature.PLACED_PATCH_CATTAIL
        );

        /*BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                RED_MUSHROOM_COLONY_WALL
        );*/
    }

  /**
   * Checks if is possible to generate the Dune Grass and Tall Dune Grass
   * on the parsed biome.
   *
   * @param biomeCtx The Biomes Context.
   * @return True if is a valid biome to generate the feature.
   */
  private static boolean canGenerateDuneGrass(BiomeSelectionContext biomeCtx) {
    return BiomeSelectors.tag(BiomeTags.IS_BEACH).test(biomeCtx) &&
      biomeCtx.getBiome().getBaseTemperature() >= 0.5F;
  }

  /**
   * Checks if is possible to generate the Small Lily Pads on the parsed biome.
   *
   * @param biomeCtx The Biomes Context.
   * @return True if is a valid biome to generate the feature.
   */
  private static boolean genericTestWithBiomeTag(BiomeSelectionContext biomeCtx, TagKey<Biome> biomeTag) {
    return BiomeSelectors.tag(biomeTag).test(biomeCtx);
  }
}
