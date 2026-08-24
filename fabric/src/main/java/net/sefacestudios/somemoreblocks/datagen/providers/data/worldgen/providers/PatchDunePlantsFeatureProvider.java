package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PatchDunePlantsFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {
  public PatchDunePlantsFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(2));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 32, 3, 3);
    modifier.add(BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<@NotNull BlockState>()
          .add(SMBBlocks.DUNE_GRASS.get().defaultBlockState(), 6)
          .add(SMBBlocks.TALL_DUNE_GRASS.get().defaultBlockState(), 2)
          .add(Blocks.SHORT_DRY_GRASS.defaultBlockState(), 2)
          .build()
      )
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchDunePlantsFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_DUNE_GRASS)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_DUNE_GRASS);
  }
}
