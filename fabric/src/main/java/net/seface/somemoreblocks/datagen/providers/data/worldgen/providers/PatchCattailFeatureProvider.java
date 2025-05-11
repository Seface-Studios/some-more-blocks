package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.Arrays;
import java.util.List;

public class PatchCattailFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {

  public PatchCattailFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(6));
    modifier.add(CountPlacement.of(12));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(76, 2, 3,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(
          new WeightedStateProvider(
            new SimpleWeightedRandomList.Builder<BlockState>()
              .add(SMBBlocks.CATTAIL.get().defaultBlockState(), 50)
              .add(SMBBlocks.REEDS.get().defaultBlockState(), 50)
              .build()
          )
        ),
        BlockPredicate.anyOf(
          this.canSpawnOnRiverBorder(),
          this.canSpawnOnWaterButNearRiverBorder()
        )
      )
    );
  }

  private BlockPredicate canSpawnOnRiverBorder() {
    return BlockPredicate.allOf(
      BlockPredicate.ONLY_IN_AIR_PREDICATE,
      BlockPredicate.anyOf(
        Arrays.stream(Direction.values())
          .filter(direction -> direction != Direction.UP && direction != Direction.DOWN)
          .map(direction ->
            BlockPredicate.anyOf(
              BlockPredicate.matchesFluids(Vec3i.ZERO.below().relative(direction), Fluids.WATER),
              BlockPredicate.allOf(
                BlockPredicate.not(BlockPredicate.matchesFluids(Vec3i.ZERO.relative(direction), Fluids.WATER)),
                BlockPredicate.matchesBlocks(Vec3i.ZERO.relative(direction), SMBBlocks.CATTAIL.get())
              )
            )
          )
          .toArray(BlockPredicate[]::new)
      )
    );
  }

  private BlockPredicate canSpawnOnWaterButNearRiverBorder() {
    return BlockPredicate.allOf(
      BlockPredicate.matchesFluids(Vec3i.ZERO, Fluids.WATER),
      BlockPredicate.anyOf(
        Arrays.stream(Direction.values())
          .filter(direction -> direction != Direction.UP && direction != Direction.DOWN)
          .map(direction ->
            BlockPredicate.anyOf(
              BlockPredicate.not(BlockPredicate.matchesFluids(Vec3i.ZERO.relative(direction), Fluids.WATER)),
              BlockPredicate.allOf(
                BlockPredicate.matchesFluids(Vec3i.ZERO.relative(direction), Fluids.WATER),
                BlockPredicate.matchesBlocks(Vec3i.ZERO.relative(direction), SMBBlocks.CATTAIL.get())
              )
            )
          )
          .toArray(BlockPredicate[]::new)
      )
    );
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new PatchCattailFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL);
  }
}
