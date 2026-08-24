package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PatchMushroomColonyFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {
  protected Block toPlaceBlock;
  protected Block toPlaceTallBlock;

  public PatchMushroomColonyFeatureProvider(Block toPlaceBlock, Block toPlaceTallBlock) {
    super(Feature.SIMPLE_BLOCK);

    this.toPlaceBlock = toPlaceBlock;
    this.toPlaceTallBlock = toPlaceTallBlock;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(8));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 8, 3, 2);
    modifier.add(BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<@NotNull BlockState>()
          .add(this.toPlaceBlock.defaultBlockState(), 75)
          .add(this.toPlaceTallBlock.defaultBlockState(), 25)
          .build()
      )
    );
  }
}
