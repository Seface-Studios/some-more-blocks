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
import net.sefacestudios.datagen_extras.provider.worldgen.feature.FeatureProvider;
import net.sefacestudios.somemoreblocks.block.PebblesBlock;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Rare surface pebbles across the Overworld.
 */
public class PatchPebblesFeatureProvider extends FeatureProvider<SimpleBlockConfiguration> {
  private final int rarity;
  private final int tries;
  private final int xzSpread;

  public PatchPebblesFeatureProvider() {
    this(14, 12, 4);
  }

  public PatchPebblesFeatureProvider(int rarity, int tries, int xzSpread) {
    super(Feature.SIMPLE_BLOCK);
    this.rarity = rarity;
    this.tries = tries;
    this.xzSpread = xzSpread;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(this.rarity));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.add(modifier, this.tries, this.xzSpread, 2);
    modifier.add(BlockPredicateFilter.forPredicate(
      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.wouldSurvive(dryPebbleState(Direction.NORTH), Vec3i.ZERO)
      )
    ));
  }

  @Override
  protected SimpleBlockConfiguration configuration() {
    return dryConfiguration();
  }

  protected static SimpleBlockConfiguration dryConfiguration() {
    return new SimpleBlockConfiguration(new WeightedStateProvider(buildStates(false)));
  }

  protected static SimpleBlockConfiguration wetConfiguration() {
    return new SimpleBlockConfiguration(new WeightedStateProvider(buildStates(true)));
  }

  private static WeightedList<@NotNull BlockState> buildStates(boolean waterlogged) {
    WeightedList.Builder<@NotNull BlockState> builder = new WeightedList.Builder<>();

    for (Direction facing : Direction.Plane.HORIZONTAL) {
      builder.add(dryPebbleState(facing).setValue(PebblesBlock.WATERLOGGED, waterlogged), 1);
    }

    return builder.build();
  }

  protected static BlockState dryPebbleState(Direction facing) {
    return SMBBlocks.PEBBLES.get().defaultBlockState()
      .setValue(PebblesBlock.FACING, facing)
      .setValue(PebblesBlock.WATERLOGGED, false);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new PatchPebblesFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_PEBBLES)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_PEBBLES);
  }
}
