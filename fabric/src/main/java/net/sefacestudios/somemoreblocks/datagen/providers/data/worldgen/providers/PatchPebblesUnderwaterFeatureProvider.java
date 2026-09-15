package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.block.PebblesBlock;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

/**
 * Somewhat rare underwater pebbles on ocean/river floors across the Overworld.
 */
public class PatchPebblesUnderwaterFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {

  public PatchPebblesUnderwaterFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(9));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 20, 5, 2);
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.allOf(
        BlockPredicate.matchesFluids(Vec3i.ZERO, Fluids.WATER),
        BlockPredicate.wouldSurvive(
          PatchPebblesFeatureProvider.dryPebbleState(Direction.NORTH).setValue(PebblesBlock.WATERLOGGED, true),
          Vec3i.ZERO
        )
      )
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return PatchPebblesFeatureProvider.wetConfiguration();
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchPebblesUnderwaterFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_PEBBLES_UNDERWATER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_PEBBLES_UNDERWATER);
  }
}
