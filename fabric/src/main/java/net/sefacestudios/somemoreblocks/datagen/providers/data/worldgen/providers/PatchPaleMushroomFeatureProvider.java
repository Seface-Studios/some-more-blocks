package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;

import java.util.List;

public class PatchPaleMushroomFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {

  public PatchPaleMushroomFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(3));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)));
    RandomPatchPlacementUtils.add(modifier, 96, 7, 3);
    modifier.add(BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(BlockStateProvider.simple(SMBBlocks.PALE_MUSHROOM.get()));
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchPaleMushroomFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_PALE_MUSHROOM)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_PALE_MUSHROOM);
  }
}
