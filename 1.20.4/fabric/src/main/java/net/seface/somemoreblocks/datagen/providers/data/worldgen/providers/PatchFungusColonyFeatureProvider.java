package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class PatchFungusColonyFeatureProvider extends PatchMushroomColonyFeatureProvider {

  public PatchFungusColonyFeatureProvider(Block toPlaceBlock, Block toPlaceTallBlock) {
    super(toPlaceBlock, toPlaceTallBlock);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(8));
    modifier.add(CountOnEveryLayerPlacement.of(8));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(10, 3, 2,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(
          new WeightedStateProvider(
            new SimpleWeightedRandomList.Builder<BlockState>()
              .add(this.toPlaceBlock.defaultBlockState(), 75)
              .add(this.toPlaceTallBlock.defaultBlockState(), 25)
              .build()
          )
        ),
        BlockPredicate.ONLY_IN_AIR_PREDICATE
      )
    );
  }
}
