package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.WeightedList;
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
import net.sefacestudios.datagen_extras.provider.worldgen.FeatureProvider;

import java.util.List;

public class PatchDunePlantsFeatureProvider extends FeatureProvider<RandomPatchConfiguration> {
  public PatchDunePlantsFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(2));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(32, 3, 3,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(
          new WeightedStateProvider(
            new WeightedList.Builder<BlockState>()
              .add(SMBBlocks.DUNE_GRASS.get().defaultBlockState(), 6)
              .add(SMBBlocks.TALL_DUNE_GRASS.get().defaultBlockState(), 2)
              .build()
          )
        ),
        BlockPredicate.ONLY_IN_AIR_PREDICATE
      )
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchDunePlantsFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_DUNE_GRASS)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_DUNE_GRASS);
  }
}
