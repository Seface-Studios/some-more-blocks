package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PatchFungusColonyFeatureProvider extends PatchMushroomColonyFeatureProvider {

  public PatchFungusColonyFeatureProvider(Block toPlaceBlock, Block toPlaceTallBlock) {
    super(toPlaceBlock, toPlaceTallBlock);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(8));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.addEveryLayer(modifier, 10, 3, 3);
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
