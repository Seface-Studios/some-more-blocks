package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

/**
 * More common underground pebbles on cave floors across the Overworld.
 */
public class PatchPebblesUndergroundFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {

  public PatchPebblesUndergroundFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(3));
    modifier.add(CountPlacement.of(32));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(64)));
    modifier.add(RandomOffsetPlacement.ofTriangle(6, 0));
    // Start Y is often inside solid rock — allow scanning through anything until a cave floor is found.
    modifier.add(
      EnvironmentScanPlacement.scanningFor(
        Direction.DOWN,
        BlockPredicate.allOf(
          BlockPredicate.ONLY_IN_AIR_PREDICATE,
          BlockPredicate.wouldSurvive(PatchPebblesFeatureProvider.dryPebbleState(Direction.NORTH), Vec3i.ZERO)
        ),
        BlockPredicate.alwaysTrue(),
        32
      )
    );
    modifier.add(BiomeFilter.biome());
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.wouldSurvive(PatchPebblesFeatureProvider.dryPebbleState(Direction.NORTH), Vec3i.ZERO)
      )
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return PatchPebblesFeatureProvider.dryConfiguration();
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchPebblesUndergroundFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_PEBBLES_UNDERGROUND)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_PEBBLES_UNDERGROUND);
  }
}
