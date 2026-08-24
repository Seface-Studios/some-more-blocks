package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;

import java.util.List;

public class PatchNetherCloverFeatureProvider extends PatchCloverFeatureProvider {
  public PatchNetherCloverFeatureProvider() {
    super(SMBBlocks.NETHER_CLOVER.get());
    this.setTries(48);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(8));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.addEveryLayer(modifier, 8, 6, 2);
    modifier.add(BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchNetherCloverFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_NETHER_CLOVER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_NETHER_CLOVER);
  }
}
