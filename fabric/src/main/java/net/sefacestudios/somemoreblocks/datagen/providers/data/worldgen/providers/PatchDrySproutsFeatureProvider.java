package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

/**
 * Dry sprouts patches for desert and badlands, matching short dry grass biomes.
 */
public class PatchDrySproutsFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {

  public PatchDrySproutsFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(2));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 80, 5, 2);
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.wouldSurvive(this.drySproutsState(), Vec3i.ZERO)
      )
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(SimpleStateProvider.simple(this.drySproutsState()));
  }

  private BlockState drySproutsState() {
    return SMBBlocks.DRY_SPROUTS.get().defaultBlockState();
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchDrySproutsFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_DRY_SPROUTS)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_DRY_SPROUTS);
  }
}
