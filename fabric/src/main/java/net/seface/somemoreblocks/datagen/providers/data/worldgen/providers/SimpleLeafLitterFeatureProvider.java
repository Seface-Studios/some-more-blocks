package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeafLitterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.block.CloverBlock;
import net.seface.somemoreblocks.registries.SMBFeatures;
import net.seface.somemoreblocks.worldgen.feature.configurations.SimpleLeafLitterBlockConfiguration;

import java.util.ArrayList;
import java.util.List;

public class SimpleLeafLitterFeatureProvider extends AbstractFeatureProvider<SimpleLeafLitterBlockConfiguration> {
  private final Block toPlaceBlock;
  private float toPlaceChance;
  private final List<ResourceKey<Block>> parents;

  public SimpleLeafLitterFeatureProvider(Block toPlaceBlock) {
    this(toPlaceBlock, 12.5F);
  }

  public SimpleLeafLitterFeatureProvider(Block toPlaceBlock, float toPlaceChance) {
    super(SMBFeatures.SIMPLE_BLOCK_LEAF_LITTER.get());
    this.toPlaceBlock = toPlaceBlock;
    this.toPlaceChance = toPlaceChance;
    this.parents = new ArrayList<>();
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(3));
  }

  @Override
  protected SimpleLeafLitterBlockConfiguration configuration() {
    WeightedList.Builder<BlockState> builder = new WeightedList.Builder<>();

    for (Direction direction : LeafLitterBlock.FACING.getPossibleValues()) {
      for (int i : LeafLitterBlock.AMOUNT.getPossibleValues()) {
        builder.add(this.toPlaceBlock
          .defaultBlockState()
          .setValue(LeafLitterBlock.FACING, direction)
          .setValue(LeafLitterBlock.AMOUNT, i), 1);
      }
    }

    return new SimpleLeafLitterBlockConfiguration(
      new WeightedStateProvider(builder.build()),
      this.toPlaceChance,
      2,
      this.parents
    );
  }

  public SimpleLeafLitterFeatureProvider addParent(Block block) {
    this.parents.add(BuiltInRegistries.BLOCK.getResourceKey(block).get());
    return this;
  }

  public SimpleLeafLitterFeatureProvider setChance(float value) {
    this.toPlaceChance = value;
    return this;
  }
}
