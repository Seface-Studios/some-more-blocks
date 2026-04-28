package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.FeatureProvider;

import java.util.List;

public class PatchSnowBushProvider extends FeatureProvider<RandomPatchConfiguration> {
  public PatchSnowBushProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(4));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(24, 5, 3,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.SNOW_BUSH.get())),
        BlockPredicate.ONLY_IN_AIR_PREDICATE
      )
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchSnowBushProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_SNOW_BUSH)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_SNOW_BUSH);
  }
}
