package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

/**
 * Extra-dense shoreline thickets for swamps — fringe of cattails/reeds on island edges.
 */
public class PatchCattailSwampFeatureProvider extends PatchCattailFeatureProvider {

  public PatchCattailSwampFeatureProvider() {
    super(1, 240, 320, 6);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchCattailSwampFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL_SWAMP)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL_SWAMP);
  }
}
