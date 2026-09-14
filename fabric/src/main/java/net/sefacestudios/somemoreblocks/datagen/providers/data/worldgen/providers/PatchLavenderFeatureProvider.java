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
 * Lavender flower patches mixed with short grass and sprouts.
 */
public class PatchLavenderFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {
  private final int rarity;
  private final int tries;
  private final int xzSpread;

  public PatchLavenderFeatureProvider() {
    this(6, 64, 6);
  }

  public PatchLavenderFeatureProvider(int rarity, int tries, int xzSpread) {
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
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.wouldSurvive(SMBBlocks.LAVENDER.get().defaultBlockState(), Vec3i.ZERO)
      )
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return new SimpleBlockConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<@NotNull BlockState>()
          .add(SMBBlocks.LAVENDER.get().defaultBlockState(), 6)
          .add(Blocks.SHORT_GRASS.defaultBlockState(), 2)
          .add(SMBBlocks.SPROUTS.get().defaultBlockState(), 2)
          .build()
      )
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchLavenderFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_LAVENDER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_LAVENDER);
  }
}
