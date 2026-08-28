package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

/**
 * Extra-dense shallow-water thickets for swamps — crowded fringe just off the bank.
 */
public class PatchCattailWaterSwampFeatureProvider extends PatchCattailWaterFeatureProvider {

  public PatchCattailWaterSwampFeatureProvider() {
    super(1, 220, 300, 6);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchCattailWaterSwampFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL_WATER_SWAMP)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL_WATER_SWAMP);
  }
}
