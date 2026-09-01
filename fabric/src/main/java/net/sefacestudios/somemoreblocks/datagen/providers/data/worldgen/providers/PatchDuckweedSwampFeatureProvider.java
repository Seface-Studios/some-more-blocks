package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

/**
 * Dense swamp duckweed near island edges — can drift a few blocks into channels,
 * still capped by shore proximity (no mid-lake carpets).
 */
public class PatchDuckweedSwampFeatureProvider extends PatchDuckweedFeatureProvider {
  private final int rarity;
  private final int minTries;
  private final int maxTries;
  private final int xzSpread;

  public PatchDuckweedSwampFeatureProvider() {
    this(2, 90, 140, 7);
  }

  public PatchDuckweedSwampFeatureProvider(int rarity, int minTries, int maxTries, int xzSpread) {
    super(rarity, minTries, xzSpread);
    this.rarity = rarity;
    this.minTries = minTries;
    this.maxTries = maxTries;
    this.xzSpread = xzSpread;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(this.rarity));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    modifier.add(CountPlacement.of(UniformInt.of(this.minTries, this.maxTries)));
    modifier.add(RandomOffsetPlacement.ofTriangle(this.xzSpread, 0));
    modifier.add(BlockPredicateFilter.forPredicate(this.canSpawnNearShore()));
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchDuckweedSwampFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_DUCKWEED_SWAMP)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_DUCKWEED_SWAMP);
  }
}
