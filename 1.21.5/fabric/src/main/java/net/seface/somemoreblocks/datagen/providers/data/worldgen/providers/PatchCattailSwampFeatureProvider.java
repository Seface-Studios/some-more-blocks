package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.FeatureProvider;

import java.util.List;

public class PatchCattailSwampFeatureProvider extends PatchCattailFeatureProvider {

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(12));
    modifier.add(CountPlacement.of(6));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING));
    modifier.add(BiomeFilter.biome());
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchCattailFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL_SWAMP)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL_SWAMP);
  }
}
