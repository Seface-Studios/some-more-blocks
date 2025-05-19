package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.List;

public class PatchNetherCloverFeatureProvider extends PatchCloverFeatureProvider {
  public PatchNetherCloverFeatureProvider() {
    super(SMBBlocks.NETHER_CLOVER.get());
    this.setTries(48);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RarityFilter.onAverageOnceEvery(8));
    modifier.add(CountOnEveryLayerPlacement.of(8));
    modifier.add(BiomeFilter.biome());
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new PatchNetherCloverFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_NETHER_CLOVER)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_NETHER_CLOVER);
  }
}
