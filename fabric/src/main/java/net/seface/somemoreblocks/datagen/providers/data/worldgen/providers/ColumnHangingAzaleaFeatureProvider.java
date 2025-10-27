package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import com.mojang.serialization.Codec;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.BlockColumnFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.heightproviders.WeightedListHeight;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBFeatures;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.provider.worldgen.EmptyFeatureProvider;
import net.sefacestudios.datagen_extras.provider.worldgen.FeatureProvider;

import java.util.ArrayList;
import java.util.List;

public class ColumnHangingAzaleaFeatureProvider extends FeatureProvider<BlockColumnConfiguration> {

  public ColumnHangingAzaleaFeatureProvider() {
    super(Feature.BLOCK_COLUMN);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(188));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256)));
    modifier.add(EnvironmentScanPlacement.scanningFor(
      Direction.UP,
      BlockPredicate.matchesTag(BlockTags.LEAVES),
      BlockPredicate.ONLY_IN_AIR_PREDICATE,
      12
    ));
    modifier.add(RandomOffsetPlacement.of(ConstantInt.of(0), ConstantInt.of(-1)));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected BlockColumnConfiguration configuration() {
    List<BlockColumnConfiguration.Layer> layers = new ArrayList<>();
    layers.add(BlockColumnConfiguration.layer(
      new WeightedListInt(
        new WeightedList.Builder<IntProvider>()
          .add(UniformInt.of(0, 4), 10)
          .add(UniformInt.of(0, 8), 6)
          .add(UniformInt.of(0, 2), 3)
          .build()
      ),

      new WeightedStateProvider(
        new WeightedList.Builder<BlockState>()
          .add(SMBBlocks.HANGING_FLOWERING_AZALEA_PLANT.get().defaultBlockState(), 20)
          .add(SMBBlocks.HANGING_AZALEA_PLANT.get().defaultBlockState(), 80)
          .build()
      )
    ));

    layers.add(BlockColumnConfiguration.layer(
      ConstantInt.of(1),
      new RandomizedIntStateProvider(
        new WeightedStateProvider(
          new WeightedList.Builder<BlockState>()
            .add(SMBBlocks.HANGING_FLOWERING_AZALEA.get().defaultBlockState(), 30)
            .add(SMBBlocks.HANGING_AZALEA.get().defaultBlockState(), 70)
            .build()
        ),

        GrowingPlantHeadBlock.AGE,
        UniformInt.of(23, 25)
      )
    ));

    return new BlockColumnConfiguration(layers, Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true);
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new ColumnHangingAzaleaFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.COLUMN_HANGING_AZALEA)
      .setConfiguredFeatureKey(SMBConfiguredFeature.COLUMN_HANGING_AZALEA);
  }
}
