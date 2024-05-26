package net.seface.moreblocks.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSources;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.moreblocks.MoreBlocks;
import net.seface.moreblocks.tags.MBBiomeTags;

public class WorldGeneration {
    private static final ResourceKey<PlacedFeature> PATCH_SMALL_LILY_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_small_lily_pads"));

    private static final ResourceKey<PlacedFeature> PATCH_DUNE_GRASS_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_dune_grass"));

    private static final ResourceKey<PlacedFeature> PATCH_TALL_DUNE_GRASS_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_tall_dune_grass"));

    private static final ResourceKey<PlacedFeature> TINY_CACTUS_FOREST_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "tiny_cactus_forest"));

    private static final ResourceKey<PlacedFeature> RED_MUSHROOM_COLONY_WALL = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "red_mushroom_colony_wall"));

    private static final ResourceKey<PlacedFeature> PATCH_CATTAIL_KEY = ResourceKey.create(
            Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_cattail"));


    public static void register() {
        BiomeModifications.addFeature(
                WorldGeneration::canGenerateSmallLilyPads,
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_SMALL_LILY_KEY
        );

        BiomeModifications.addFeature(
                WorldGeneration::canGenerateDuneGrass,
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_DUNE_GRASS_KEY
        );

        BiomeModifications.addFeature(
                WorldGeneration::canGenerateDuneGrass,
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_TALL_DUNE_GRASS_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                TINY_CACTUS_FOREST_KEY
        );

        BiomeModifications.addFeature(
                BiomeSelectors.tag(BiomeTags.IS_RIVER),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                PATCH_CATTAIL_KEY
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
    private static boolean canGenerateSmallLilyPads(BiomeSelectionContext biomeCtx) {
        return BiomeSelectors.tag(MBBiomeTags.CAN_GENERATE_SMALL_LILY_PADS).test(biomeCtx);
    }
}
