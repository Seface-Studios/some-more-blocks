package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.datagen.templates.SMBFeatureTemplates;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.concurrent.CompletableFuture;

public class SMBFeatureProvider extends FabricDynamicRegistryProvider {
  public SMBFeatureProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, future);
  }

  @Override
  protected void configure(HolderLookup.Provider provider, Entries entries) {
    entries.addAll(provider.lookupOrThrow(Registries.CONFIGURED_FEATURE));
    entries.addAll(provider.lookupOrThrow(Registries.PLACED_FEATURE));
  }

  @Override
  public String getName() {
    return SomeMoreBlocks.ID + ":feature_provider";
  }

  public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> registry) {
    SMBFeatureTemplates.LOOKUP = registry.lookup(Registries.CONFIGURED_FEATURE);

    registry.register(SMBPlacedFeature.PATCH_CATTAIL, SMBFeatureTemplates.placedCattail());
    registry.register(SMBPlacedFeature.PATCH_DUNE_GRASS, SMBFeatureTemplates.placedGenericShortPlant(SMBConfiguredFeature.PATCH_DUNE_GRASS));
    registry.register(SMBPlacedFeature.PATCH_SHORT_SNOW_GRASS, SMBFeatureTemplates.placedGenericShortPlant(SMBConfiguredFeature.PATCH_SHORT_SNOW_GRASS));
    registry.register(SMBPlacedFeature.PATCH_SNOW_FERN, SMBFeatureTemplates.placedGenericShortPlant(SMBConfiguredFeature.PATCH_SNOW_FERN));
    registry.register(SMBPlacedFeature.PATCH_SMALL_LILY_PADS, SMBFeatureTemplates.placedPatchSmallLilyPads());
    registry.register(SMBPlacedFeature.PATCH_TALL_DUNE_GRASS, SMBFeatureTemplates.placedGenericTallPlant(SMBConfiguredFeature.PATCH_TALL_DUNE_GRASS));
    registry.register(SMBPlacedFeature.PATCH_TALL_SNOW_GRASS, SMBFeatureTemplates.placedGenericTallPlant(SMBConfiguredFeature.PATCH_TALL_SNOW_GRASS));
    registry.register(SMBPlacedFeature.PATCH_LARGE_SNOW_FERN, SMBFeatureTemplates.placedGenericTallPlant(SMBConfiguredFeature.PATCH_LARGE_SNOW_FERN));
  }

  public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> registry) {/*
    registry.register(SMBConfiguredFeature.PATCH_CATTAIL, SMBFeatureTemplates.configuredCattail());
    registry.register(SMBConfiguredFeature.PATCH_DUNE_GRASS, SMBFeatureTemplates.configuredGenericShortPlant(SMBBlocks.DUNE_GRASS.get()));
    registry.register(SMBConfiguredFeature.PATCH_SHORT_SNOW_GRASS, SMBFeatureTemplates.configuredGenericShortPlant(SMBBlocks.SHORT_SNOW_GRASS.get()));
    registry.register(SMBConfiguredFeature.PATCH_SNOW_FERN, SMBFeatureTemplates.configuredGenericShortPlant(SMBBlocks.SNOW_FERN.get()));
    registry.register(SMBConfiguredFeature.PATCH_SMALL_LILY_PADS, SMBFeatureTemplates.configuredPatchSmallLilyPads());
    registry.register(SMBConfiguredFeature.PATCH_TALL_DUNE_GRASS, SMBFeatureTemplates.configuredGenericTallPlant(SMBBlocks.TALL_DUNE_GRASS.get()));
    registry.register(SMBConfiguredFeature.PATCH_TALL_SNOW_GRASS, SMBFeatureTemplates.configuredGenericTallPlant(SMBBlocks.TALL_SNOW_GRASS.get()));
    registry.register(SMBConfiguredFeature.PATCH_LARGE_SNOW_FERN, SMBFeatureTemplates.configuredGenericTallPlant(SMBBlocks.LARGE_SNOW_FERN.get()));*/
  }
}
