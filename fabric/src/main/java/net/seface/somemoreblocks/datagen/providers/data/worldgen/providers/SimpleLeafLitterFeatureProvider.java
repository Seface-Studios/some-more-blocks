package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.seface.somemoreblocks.registries.SMBFeatures;
import net.seface.somemoreblocks.worldgen.feature.configurations.SimpleLeafLitterBlockConfiguration;
import net.sefacestudios.datagen_extras.provider.worldgen.FeatureProvider;

import java.util.ArrayList;
import java.util.List;

public class SimpleLeafLitterFeatureProvider extends FeatureProvider<SimpleLeafLitterBlockConfiguration> {
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
  protected void placed(List<PlacementModifier> modifier) {}

  @Override
  protected SimpleLeafLitterBlockConfiguration configuration() {
    return new SimpleLeafLitterBlockConfiguration(
      BlockStateProvider.simple(this.toPlaceBlock),
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
