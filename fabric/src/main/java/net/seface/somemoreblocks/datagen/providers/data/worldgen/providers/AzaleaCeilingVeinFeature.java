package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.registries.SMBFeatures;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;
import net.seface.somemoreblocks.worldgen.feature.configurations.CeilingVeinConfiguration;
import net.sefacestudios.datagen_extras.provider.worldgen.FeatureProvider;

import java.util.List;

public class AzaleaCeilingVeinFeature extends FeatureProvider<CeilingVeinConfiguration> {

  public AzaleaCeilingVeinFeature() {
    super(SMBFeatures.CEILING_VEIN_FEATURE.get());
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(125));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(0), VerticalAnchor.absolute(256)));
    modifier.add(EnvironmentScanPlacement.scanningFor(
      Direction.UP,
      BlockPredicate.hasSturdyFace(Direction.DOWN),
      BlockPredicate.ONLY_IN_AIR_PREDICATE,
      12
    ));
    modifier.add(RandomOffsetPlacement.of(ConstantInt.of(0), ConstantInt.of(-1)));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected CeilingVeinConfiguration configuration() {
    return new CeilingVeinConfiguration(
      new WeightedStateProvider(
        new WeightedList.Builder<BlockState>()
          .add(Blocks.AZALEA_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 80)
          .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 20)
          .build()
      ),
      BlockPredicate.anyOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.matchesTag(SMBBlockTags.AZALEA_CEILING_VEIN_REPLACEABLE)
      ),
      UniformInt.of(1, 3)
    );
  }

  public static <T extends FeatureProvider<?>> T create() {
    return new AzaleaCeilingVeinFeature()
      .setPlacedFeatureKey(SMBPlacedFeature.CEILING_AZALEA_LEAVES)
      .setConfiguredFeatureKey(SMBConfiguredFeature.CEILING_AZALEA_LEAVES);
  }
}
