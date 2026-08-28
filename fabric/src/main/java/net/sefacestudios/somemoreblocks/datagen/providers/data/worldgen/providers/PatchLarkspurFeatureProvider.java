package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Vec3i;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Mixed tall and short larkspur flower patches for meadows / flower forests / plains.
 */
public class PatchLarkspurFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {
  private final int rarity;
  private final int tries;
  private final int xzSpread;

  public PatchLarkspurFeatureProvider() {
    this(7, 56, 6);
  }

  public PatchLarkspurFeatureProvider(int rarity, int tries, int xzSpread) {
    super(Feature.SIMPLE_BLOCK);
    this.rarity = rarity;
    this.tries = tries;
    this.xzSpread = xzSpread;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(this.rarity));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, this.tries, this.xzSpread, 2);
    modifier.add(BlockPredicateFilter.forPredicate(this.canSpawnLarkspur()));
  }

  protected BlockPredicate canSpawnLarkspur() {
    return BlockPredicate.anyOf(
      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.matchesBlocks(Vec3i.ZERO.above(), Blocks.AIR),
        BlockPredicate.wouldSurvive(SMBBlocks.PURPLE_LARKSPUR.get().defaultBlockState(), Vec3i.ZERO)
      ),
      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.wouldSurvive(SMBBlocks.SHORT_PURPLE_LARKSPUR.get().defaultBlockState(), Vec3i.ZERO)
      )
    );
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<@NotNull BlockState>()
          .add(SMBBlocks.GALAHAD_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.ASTOLAT_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.SUMMER_SKIES_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.PURPLE_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.RED_LARK_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.SHORT_GALAHAD_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.SHORT_ASTOLAT_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.SHORT_SUMMER_SKIES_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.SHORT_PURPLE_LARKSPUR.get().defaultBlockState(), 20)
          .add(SMBBlocks.SHORT_RED_LARK_LARKSPUR.get().defaultBlockState(), 20)
          .build()
      )
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchLarkspurFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_LARKSPUR)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_LARKSPUR);
  }
}
