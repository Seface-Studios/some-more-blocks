package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;

import java.util.List;

public class PatchSmallLilyPadsFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {

  public PatchSmallLilyPadsFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 10, 7, 3);
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.allOf(
        BlockPredicate.matchesBlocks(Vec3i.ZERO, Blocks.AIR),
        BlockPredicate.matchesFluids(Vec3i.ZERO.below(), Fluids.WATER)
      )
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.SMALL_LILY_PADS.get()));
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchSmallLilyPadsFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_SMALL_LILY_PADS)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_SMALL_LILY_PADS);
  }
}
