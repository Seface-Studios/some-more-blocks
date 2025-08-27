package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.FeatureProvider;

import java.util.List;

public class PatchPaleMushroomFeatureProvider extends FeatureProvider<RandomPatchConfiguration> {

  public PatchPaleMushroomFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(3));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)));
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(96, 7, 3,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(BlockStateProvider.simple(SMBBlocks.PALE_MUSHROOM.get())),
        BlockPredicate.ONLY_IN_AIR_PREDICATE
      )
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchPaleMushroomFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_PALE_MUSHROOM)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_PALE_MUSHROOM);
  }
}
