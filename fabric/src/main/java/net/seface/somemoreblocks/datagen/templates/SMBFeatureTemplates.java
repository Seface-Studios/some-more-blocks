package net.seface.somemoreblocks.datagen.templates;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;

import java.util.List;

public class SMBFeatureTemplates {
  public static HolderGetter<ConfiguredFeature<?, ?>> LOOKUP;

  /** Cattail Placed Feature configuration */
  public static PlacedFeature placedCattail() {
    return new PlacedFeature(LOOKUP.getOrThrow(SMBConfiguredFeature.PATCH_CATTAIL),
      List.of(
        CountPlacement.of(5),
        InSquarePlacement.spread(),
        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
        BiomeFilter.biome()));
  }

  /** Cattail Configured Feature configuration */
  public static ConfiguredFeature<?, ?> configuredCattail() {
    return new ConfiguredFeature<>(Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(32, 2, 2,
        PlacementUtils.filtered(
          Feature.SIMPLE_BLOCK,
          new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.CATTAIL.get())),

          BlockPredicate.anyOf(
            BlockPredicate.allOf(
              BlockPredicate.ONLY_IN_AIR_PREDICATE,
              BlockPredicate.anyOf(
                BlockPredicate.anyOf(
                  BlockPredicate.matchesFluids(new Vec3i(1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                  BlockPredicate.matchesBlocks(new Vec3i(1, -1, 0), SMBBlocks.CATTAIL.get()),
                  BlockPredicate.matchesBlocks(new Vec3i(1, 0, 0), SMBBlocks.CATTAIL.get())),
                BlockPredicate.anyOf(
                  BlockPredicate.matchesFluids(new Vec3i(-1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                  BlockPredicate.matchesBlocks(new Vec3i(-1, -1, 0), SMBBlocks.CATTAIL.get()),
                  BlockPredicate.matchesBlocks(new Vec3i(-1, 0, 0), SMBBlocks.CATTAIL.get())),
                BlockPredicate.anyOf(
                  BlockPredicate.matchesFluids(new Vec3i(0, -1, 1), Fluids.WATER, Fluids.FLOWING_WATER),
                  BlockPredicate.matchesBlocks(new Vec3i(0, -1, 1), SMBBlocks.CATTAIL.get()),
                  BlockPredicate.matchesBlocks(new Vec3i(0, 0, 1), SMBBlocks.CATTAIL.get())),
                BlockPredicate.anyOf(
                  BlockPredicate.matchesFluids(new Vec3i(0, -1, -1), Fluids.WATER, Fluids.FLOWING_WATER),
                  BlockPredicate.matchesBlocks(new Vec3i(0, -1, -1), SMBBlocks.CATTAIL.get()),
                  BlockPredicate.matchesBlocks(new Vec3i(0, 0, -1), SMBBlocks.CATTAIL.get()))
              )
            ),

            BlockPredicate.allOf(
              BlockPredicate.matchesFluids(Vec3i.ZERO, Fluids.WATER),
              BlockPredicate.matchesTag(Vec3i.ZERO.below(), SMBBlockTags.CATTAIL_PLACEABLE),
              BlockPredicate.anyOf(
                BlockPredicate.matchesTag(new Vec3i(1, 0, 0), SMBBlockTags.CATTAIL_PLACEABLE),
                BlockPredicate.matchesTag(new Vec3i(-1, 0, 0), SMBBlockTags.CATTAIL_PLACEABLE),
                BlockPredicate.matchesTag(new Vec3i(0, 0, 1), SMBBlockTags.CATTAIL_PLACEABLE),
                BlockPredicate.matchesTag(new Vec3i(0, 0, -1), SMBBlockTags.CATTAIL_PLACEABLE))
            )))));
  }

  /** Generic Plant Placed Feature configuration */
  public static PlacedFeature placedGenericShortPlant(ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new PlacedFeature(LOOKUP.getOrThrow(configuredFeature),
      List.of(
        RarityFilter.onAverageOnceEvery(3),
        CountPlacement.of(8),
        InSquarePlacement.spread(),
        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
        BiomeFilter.biome()));
  }

  /** Generic Plant Configured Feature configuration */
  public static ConfiguredFeature<?, ?> configuredGenericShortPlant(Block block) {
    return new ConfiguredFeature<>(Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(24, 1, 3,
        PlacementUtils.filtered(
          Feature.SIMPLE_BLOCK,
          new SimpleBlockConfiguration(SimpleStateProvider.simple(block)),
          BlockPredicate.ONLY_IN_AIR_PREDICATE)));
  }

  /** Small Lily Pads Placed Feature configuration */
  public static PlacedFeature placedPatchSmallLilyPads() {
    return new PlacedFeature(LOOKUP.getOrThrow(SMBConfiguredFeature.PATCH_SMALL_LILY_PADS),
      List.of(
        CountPlacement.of(4),
        InSquarePlacement.spread(),
        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
        BiomeFilter.biome()));
  }

  /** Small Lily Pads Configured Feature configuration */
  public static ConfiguredFeature<?, ?> configuredPatchSmallLilyPads() {
    return new ConfiguredFeature<>(Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(5, 7, 3,
        PlacementUtils.filtered(
          Feature.SIMPLE_BLOCK,
          new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.SMALL_LILY_PADS.get())),
          BlockPredicate.allOf(
            BlockPredicate.matchesBlocks(Vec3i.ZERO, Blocks.AIR),
            BlockPredicate.matchesFluids(Vec3i.ZERO.below(), Fluids.WATER)))));
  }

  /** Generic Tall Plant Placed Feature configuration */
  public static PlacedFeature placedGenericTallPlant(ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new PlacedFeature(LOOKUP.getOrThrow(configuredFeature),
      List.of(
        RarityFilter.onAverageOnceEvery(5),
        CountPlacement.of(5),
        InSquarePlacement.spread(),
        HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
        BiomeFilter.biome()));
  }

  /** Generic Tall Plant Configured Feature configuration */
  public static ConfiguredFeature<?, ?> configuredGenericTallPlant(Block block) {
    return new ConfiguredFeature<>(Feature.RANDOM_PATCH,
      new RandomPatchConfiguration(16, 1, 3,
        PlacementUtils.filtered(
          Feature.SIMPLE_BLOCK,
          new SimpleBlockConfiguration(SimpleStateProvider.simple(block)),
          BlockPredicate.ONLY_IN_AIR_PREDICATE)));
  }
}
