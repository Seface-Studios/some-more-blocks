package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class PatchLuminousFlowerFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {

  public PatchLuminousFlowerFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(4));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(52)));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(24, 3, 3,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.LUMINOUS_FLOWER.get())),
        BlockPredicate.anyOf(
          BlockPredicate.ONLY_IN_AIR_PREDICATE,
          BlockPredicate.matchesTag(SMBBlockTags.LUMINOUS_FLOWER_REPLACEABLE)
        )
      )
    );
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new PatchLuminousFlowerFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_LUMINOUS_FLOWER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_LUMINOUS_FLOWER);
  }
}
