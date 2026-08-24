package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;

import java.util.List;

public class PatchCattailSwampFeatureProvider extends PatchCattailFeatureProvider {

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(12));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 96, 2, 3);
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.anyOf(this.canSpawnOnRiverBorder(), this.canSpawnOnWaterButNearRiverBorder())
    ));
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchCattailFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL_SWAMP)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL_SWAMP);
  }
}
