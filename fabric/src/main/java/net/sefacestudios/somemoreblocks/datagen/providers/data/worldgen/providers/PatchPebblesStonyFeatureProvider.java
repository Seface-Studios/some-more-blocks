package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

/**
 * Denser surface pebbles for rocky coastal biomes like stony shore.
 */
public class PatchPebblesStonyFeatureProvider extends PatchPebblesFeatureProvider {

  public PatchPebblesStonyFeatureProvider() {
    super(3, 56, 6);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchPebblesStonyFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_PEBBLES_STONY)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_PEBBLES_STONY);
  }
}
