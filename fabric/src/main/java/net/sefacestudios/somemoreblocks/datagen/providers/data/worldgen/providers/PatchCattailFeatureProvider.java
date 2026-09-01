package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.block.CattailBlock;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBBlockTags;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Dense shoreline thickets of cattails/reeds on land (sugar-cane style, 1 block from water).
 */
public class PatchCattailFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {
  private final int rarity;
  private final int minTries;
  private final int maxTries;
  private final int xzSpread;

  public PatchCattailFeatureProvider() {
    // Local patch density unchanged — rarity throttles how many chunks get a attempt.
    this(5, 160, 220, 6);
  }

  public PatchCattailFeatureProvider(int rarity, int minTries, int maxTries, int xzSpread) {
    super(Feature.SIMPLE_BLOCK);
    this.rarity = rarity;
    this.minTries = minTries;
    this.maxTries = maxTries;
    this.xzSpread = xzSpread;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(this.rarity));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    modifier.add(CountPlacement.of(UniformInt.of(this.minTries, this.maxTries)));
    modifier.add(RandomOffsetPlacement.ofTriangle(this.xzSpread, 0));
    modifier.add(BlockPredicateFilter.forPredicate(this.canSpawnOnShore()));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<@NotNull BlockState>()
          .add(SMBBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.WATERLOGGED, false), 45)
          .add(SMBBlocks.REEDS.get().defaultBlockState().setValue(CattailBlock.WATERLOGGED, false), 55)
          .build()
      )
    );
  }

  /**
   * Immediate shoreline only: placeable soil with water on a horizontal neighbor.
   */
  protected BlockPredicate canSpawnOnShore() {
    BlockState landCattail = SMBBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.WATERLOGGED, false);

    return BlockPredicate.allOf(
      BlockPredicate.ONLY_IN_AIR_PREDICATE,
      BlockPredicate.matchesBlocks(Vec3i.ZERO.above(), Blocks.AIR),
      BlockPredicate.matchesTag(Vec3i.ZERO.below(), SMBBlockTags.CATTAIL_PLACEABLE),
      BlockPredicate.wouldSurvive(landCattail, Vec3i.ZERO),
      this.waterAdjacentToSoil()
    );
  }

  protected BlockPredicate waterAdjacentToSoil() {
    return BlockPredicate.anyOf(
      Arrays.stream(Direction.values())
        .filter(direction -> direction.getAxis().isHorizontal())
        .map(direction -> BlockPredicate.matchesFluids(Vec3i.ZERO.below().relative(direction), Fluids.WATER))
        .toArray(BlockPredicate[]::new)
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchCattailFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL);
  }
}
