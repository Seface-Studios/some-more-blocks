package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class LuminousFlowerFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {

  public LuminousFlowerFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(8));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(50)));
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(23, 7, 3,
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
    return new LuminousFlowerFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_LUMINOUS_FLOWER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_LUMINOUS_FLOWER);
  }
}
