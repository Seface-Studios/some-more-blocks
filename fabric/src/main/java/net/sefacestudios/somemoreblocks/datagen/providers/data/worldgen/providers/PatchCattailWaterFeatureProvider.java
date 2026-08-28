package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Vec3i;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.block.CattailBlock;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.ShoreProximityPredicates;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Cattails/reeds in shallow water near shore — up to a few blocks into the water.
 */
public class PatchCattailWaterFeatureProvider extends PatchCattailFeatureProvider {
  /** Max Chebyshev distance from solid land. */
  protected static final int SHORE_DISTANCE = 3;

  private final int rarity;
  private final int minTries;
  private final int maxTries;
  private final int xzSpread;

  public PatchCattailWaterFeatureProvider() {
    this(1, 140, 200, 6);
  }

  public PatchCattailWaterFeatureProvider(int rarity, int minTries, int maxTries, int xzSpread) {
    super(rarity, minTries, maxTries, xzSpread);
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
    modifier.add(RandomOffsetPlacement.vertical(ConstantInt.of(-1)));
    modifier.add(BiomeFilter.biome());
    modifier.add(CountPlacement.of(UniformInt.of(this.minTries, this.maxTries)));
    modifier.add(RandomOffsetPlacement.ofTriangle(this.xzSpread, 0));
    modifier.add(BlockPredicateFilter.forPredicate(this.canSpawnInShallowWater()));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<@NotNull BlockState>()
          .add(SMBBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.WATERLOGGED, true), 55)
          .add(SMBBlocks.REEDS.get().defaultBlockState().setValue(CattailBlock.WATERLOGGED, true), 45)
          .build()
      )
    );
  }

  protected BlockPredicate canSpawnInShallowWater() {
    BlockState waterCattail = SMBBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.WATERLOGGED, true);

    return BlockPredicate.allOf(
      BlockPredicate.matchesFluids(Vec3i.ZERO, Fluids.WATER),
      BlockPredicate.matchesBlocks(Vec3i.ZERO.above(), Blocks.AIR),
      BlockPredicate.wouldSurvive(waterCattail, Vec3i.ZERO),
      this.nearShoreLand()
    );
  }

  protected BlockPredicate nearShoreLand() {
    return ShoreProximityPredicates.solidWithin(SHORE_DISTANCE, 0);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchCattailWaterFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL_WATER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL_WATER);
  }
}
