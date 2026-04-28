package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.block.WallMushroomColonyBlock;
import net.seface.somemoreblocks.tags.SMBBlockTags;

import java.util.List;

public class SimpleMushroomColonyWallFeatureProvider extends AbstractFeatureProvider<RandomFeatureConfiguration> {
  protected final Block toPlaceBlock;

  public SimpleMushroomColonyWallFeatureProvider(Block toPlaceBlock) {
    super(Feature.RANDOM_SELECTOR);
    this.toPlaceBlock = toPlaceBlock;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(2));
    modifier.add(CountPlacement.of(256));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(RandomOffsetPlacement.vertical(UniformInt.of(1, 8)));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomFeatureConfiguration configuration() {
    return new RandomFeatureConfiguration(
      List.of(
        new WeightedPlacedFeature(this.placementFacing(Direction.NORTH), 0.25F),
        new WeightedPlacedFeature(this.placementFacing(Direction.SOUTH), 0.25F),
        new WeightedPlacedFeature(this.placementFacing(Direction.EAST), 0.25F),
        new WeightedPlacedFeature(this.placementFacing(Direction.WEST), 0.25F)
      ),

      this.placementFacing(Direction.NORTH)
    );
  }

  protected Holder<PlacedFeature> placementFacing(Direction direction) {
    return PlacementUtils.filtered(
      Feature.SIMPLE_BLOCK,
      new SimpleBlockConfiguration(
        BlockStateProvider.simple(
          this.toPlaceBlock.defaultBlockState()
            .setValue(WallMushroomColonyBlock.FACING, direction)
        )
      ),

      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.anyOf(
          BlockPredicate.matchesBlocks(Vec3i.ZERO.above(), Blocks.AIR),
          BlockPredicate.matchesTag(Vec3i.ZERO.above(), SMBBlockTags.MUSHROOM_COLONIES)
        ),

        BlockPredicate.anyOf(
          BlockPredicate.matchesTag(Vec3i.ZERO.relative(direction.getOpposite()), BlockTags.LOGS_THAT_BURN),
          BlockPredicate.matchesBlocks(Vec3i.ZERO.relative(direction.getOpposite()), Blocks.MUSHROOM_STEM)
        )
      )
    );
  }

}
