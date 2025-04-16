package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class GenericSmallPlantFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {
  private final Block placeableBlock;

  public GenericSmallPlantFeatureProvider(Block placeableBlock) {
    super(Feature.RANDOM_PATCH);
    this.placeableBlock = placeableBlock;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(3));
    modifier.add(CountPlacement.of(8));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(24, 1, 3,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(this.placeableBlock)),
        BlockPredicate.ONLY_IN_AIR_PREDICATE
      )
    );
  }
}
