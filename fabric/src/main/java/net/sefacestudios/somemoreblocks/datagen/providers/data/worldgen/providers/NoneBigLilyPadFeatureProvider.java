package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;


import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.somemoreblocks.registries.SMBFeatures;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.EmptyFeatureProvider;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;

import java.util.List;

public class NoneBigLilyPadFeatureProvider extends EmptyFeatureProvider {

  public NoneBigLilyPadFeatureProvider() {
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

  public static <T extends FeatureProvider<?>> T create() {
    return new NoneBigLilyPadFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.NONE_BIG_LILY_PAD)
      .setConfiguredFeatureKey(SMBConfiguredFeature.NONE_BIG_LILY_PAD);
  }
}
