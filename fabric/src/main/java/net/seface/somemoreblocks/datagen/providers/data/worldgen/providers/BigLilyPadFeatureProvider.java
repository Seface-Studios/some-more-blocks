package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;


import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.registries.SMBFeatures;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class BigLilyPadFeatureProvider extends EmptyFeatureProvider {

  public BigLilyPadFeatureProvider() {
    super(SMBFeatures.NONE_BIG_LILY_FEATURE.get());
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(1));
    modifier.add(RarityFilter.onAverageOnceEvery(3));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new BigLilyPadFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.NONE_BIG_LILY_PAD)
      .setConfiguredFeatureKey(SMBConfiguredFeature.NONE_BIG_LILY_PAD);
  }
}
