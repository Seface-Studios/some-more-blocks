package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class PatchCattailFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {

  public PatchCattailFeatureProvider() {
    super(Feature.SIMPLE_BLOCK);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(6));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, 76, 2, 3);
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.anyOf(this.canSpawnOnRiverBorder(), this.canSpawnOnWaterButNearRiverBorder())
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<@NotNull BlockState>()
          .add(SMBBlocks.CATTAIL.get().defaultBlockState(), 50)
          .add(SMBBlocks.REEDS.get().defaultBlockState(), 50)
          .build()
      )
    );
  }

  protected BlockPredicate canSpawnOnRiverBorder() {
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

  protected BlockPredicate canSpawnOnWaterButNearRiverBorder() {
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

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchCattailFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL);
  }
}
