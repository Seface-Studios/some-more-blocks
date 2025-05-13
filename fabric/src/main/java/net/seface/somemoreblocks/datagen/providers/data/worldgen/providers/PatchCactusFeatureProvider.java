package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class PatchCactusFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {
  public PatchCactusFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(3));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(8, 3, 2,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(
          new WeightedStateProvider(
            new SimpleWeightedRandomList.Builder<BlockState>()
              .add(SMBBlocks.TINY_CACTUS.get().defaultBlockState(), 60)
              .add(SMBBlocks.TALL_CACTUS.get().defaultBlockState(), 40)
              .build()
          )
        ),
        BlockPredicate.ONLY_IN_AIR_PREDICATE
      )
    );
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new PatchCactusFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CACTUS_PLANTS)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CACTUS_PLANTS);
  }
}
