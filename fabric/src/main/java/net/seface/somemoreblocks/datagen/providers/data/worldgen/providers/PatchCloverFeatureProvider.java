package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import lombok.Setter;
import net.minecraft.core.Direction;
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
import net.seface.somemoreblocks.block.CloverBlock;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class PatchCloverFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {
  protected Block toPlaceBlock;

  @Setter
  protected int tries = 96;

  public PatchCloverFeatureProvider() {
    this(SMBBlocks.CLOVER.get());
  }

  public PatchCloverFeatureProvider(Block toPlaceBlock) {
    super(Feature.FLOWER);
    this.toPlaceBlock = toPlaceBlock;
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(3));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    SimpleWeightedRandomList.Builder<BlockState> builder = new SimpleWeightedRandomList.Builder<>();

    for (Direction direction : CloverBlock.FACING.getPossibleValues()) {
      for (int i : CloverBlock.AMOUNT.getPossibleValues()) {
        builder.add(this.toPlaceBlock
          .defaultBlockState()
          .setValue(CloverBlock.FACING, direction)
          .setValue(CloverBlock.AMOUNT, i), 1);
      }
    }

    return new RandomPatchConfiguration(this.tries, 6, 2,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(
          new WeightedStateProvider(builder.build())),
        BlockPredicate.ONLY_IN_AIR_PREDICATE
      )
    );
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new PatchCloverFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CLOVER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CLOVER);
  }
}
