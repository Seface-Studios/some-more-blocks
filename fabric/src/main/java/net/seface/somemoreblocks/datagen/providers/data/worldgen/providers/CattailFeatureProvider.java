package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class CattailFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {

  public CattailFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(5));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(32, 2, 2,
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
          ))));
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new CattailFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL);
  }
}
