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
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.ShoreProximityPredicates;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

/**
 * Surface duckweed near shorelines — can sit a few blocks into the water, not mid-lake.
 */
public class PatchDuckweedFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {
  /** Max Chebyshev distance from solid land (water cell below the duckweed). */
  protected static final int SHORE_DISTANCE = 3;

  private final int rarity;
  private final int tries;
  private final int xzSpread;

  public PatchDuckweedFeatureProvider() {
    this(4, 40, 6);
  }

  public PatchDuckweedFeatureProvider(int rarity, int tries, int xzSpread) {
    super(Feature.SIMPLE_BLOCK);
    this.rarity = rarity;
    this.tries = tries;
    this.xzSpread = xzSpread;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(this.rarity));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, this.tries, this.xzSpread, 0);
    modifier.add(BlockPredicateFilter.forPredicate(this.canSpawnNearShore()));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.DUCKWEED.get()));
  }

  /**
   * Air on water with solid land within {@link #SHORE_DISTANCE} of the water cell.
   */
  protected BlockPredicate canSpawnNearShore() {
    return BlockPredicate.allOf(
      BlockPredicate.matchesBlocks(Vec3i.ZERO, Blocks.AIR),
      BlockPredicate.matchesFluids(Vec3i.ZERO.below(), Fluids.WATER),
      this.nearShoreLand()
    );
  }

  protected BlockPredicate nearShoreLand() {
    return ShoreProximityPredicates.solidWithin(SHORE_DISTANCE, -1);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchDuckweedFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_DUCKWEED)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_DUCKWEED);
  }
}
