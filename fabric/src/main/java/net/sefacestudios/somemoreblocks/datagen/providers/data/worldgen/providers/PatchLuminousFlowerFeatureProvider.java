package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBBlockTags;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;

import java.util.List;

public class PatchLuminousFlowerFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {

  public PatchLuminousFlowerFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(52)));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 24, 3, 3);
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.anyOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.matchesTag(SMBBlockTags.LUMINOUS_FLOWER_REPLACEABLE)
      )
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.LUMINOUS_FLOWER.get()));
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchLuminousFlowerFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_LUMINOUS_FLOWER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_LUMINOUS_FLOWER);
  }
}
