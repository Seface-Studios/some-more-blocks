package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PatchMushroomColonyFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {
  protected Block toPlaceBlock;
  protected Block toPlaceTallBlock;

  public PatchMushroomColonyFeatureProvider(Block toPlaceBlock, Block toPlaceTallBlock) {
    super(Feature.RANDOM_PATCH);

    this.toPlaceBlock = toPlaceBlock;
    this.toPlaceTallBlock = toPlaceTallBlock;
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
    return new RandomPatchConfiguration(24, 3, 2,
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
