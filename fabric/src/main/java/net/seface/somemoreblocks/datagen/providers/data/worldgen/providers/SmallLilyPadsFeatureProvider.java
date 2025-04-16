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
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class SmallLilyPadsFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {

  public SmallLilyPadsFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(4));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(5, 7, 3,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.SMALL_LILY_PADS.get())),
        BlockPredicate.allOf(
          BlockPredicate.matchesBlocks(Vec3i.ZERO, Blocks.AIR),
          BlockPredicate.matchesFluids(Vec3i.ZERO.below(), Fluids.WATER))));
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new SmallLilyPadsFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_SMALL_LILY_PADS)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_SMALL_LILY_PADS);
  }
}
