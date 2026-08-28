package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;

/**
 * Denser mixed larkspur patches for flower forests.
 */
public class PatchLarkspurFlowerForestFeatureProvider extends PatchLarkspurFeatureProvider {

  public PatchLarkspurFlowerForestFeatureProvider() {
    super(3, 96, 7);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchLarkspurFlowerForestFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_LARKSPUR_FLOWER_FOREST)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_LARKSPUR_FLOWER_FOREST);
  }
}
