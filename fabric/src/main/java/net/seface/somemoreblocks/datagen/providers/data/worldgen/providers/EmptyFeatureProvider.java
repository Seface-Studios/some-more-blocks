package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class EmptyFeatureProvider extends AbstractFeatureProvider<NoneFeatureConfiguration> {

  public EmptyFeatureProvider(Feature<NoneFeatureConfiguration> feature) {
    super(feature);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {}

  @Override
  protected NoneFeatureConfiguration configuration() {
    return new NoneFeatureConfiguration();
  }
}
