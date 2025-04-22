package net.seface.somemoreblocks.datagen.providers.data.worldgen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.somemoreblocks.datagen.providers.data.worldgen.providers.*;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBFeatures;
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
    return "Feature";
  }

  public static void bootstrapF(BootstrapContext<PlacedFeature> context) {
    CattailFeatureProvider.create().registerPlaceFeature(context);
    SmallLilyPadsFeatureProvider.create().registerPlaceFeature(context);
    LuminousFlowerFeatureProvider.create().registerPlaceFeature(context);
    TinyCactusFeatureProvider.create().registerPlaceFeature(context);
    BigLilyPadFeatureProvider.create().registerPlaceFeature(context);
    patchDuneGrass().registerPlaceFeature(context);
    patchTallDuneGrass().registerPlaceFeature(context);
    patchShortSnowGrass().registerPlaceFeature(context);
    patchTallSnowGrass().registerPlaceFeature(context);
    patchSnowFern().registerPlaceFeature(context);
    patchLargeSnowFern().registerPlaceFeature(context);
    noneLeafLitter().registerPlaceFeature(context);
  }

  public static void bootstrapCF(BootstrapContext<ConfiguredFeature<?, ?>> context) {
    CattailFeatureProvider.create().registerConfiguredFeature(context);
    SmallLilyPadsFeatureProvider.create().registerConfiguredFeature(context);
    LuminousFlowerFeatureProvider.create().registerConfiguredFeature(context);
    TinyCactusFeatureProvider.create().registerConfiguredFeature(context);
    BigLilyPadFeatureProvider.create().registerConfiguredFeature(context);
    patchDuneGrass().registerConfiguredFeature(context);
    patchTallDuneGrass().registerConfiguredFeature(context);
    patchShortSnowGrass().registerConfiguredFeature(context);
    patchTallSnowGrass().registerConfiguredFeature(context);
    patchSnowFern().registerConfiguredFeature(context);
    patchLargeSnowFern().registerConfiguredFeature(context);
    noneLeafLitter().registerConfiguredFeature(context);
  }

  private static GenericSmallPlantFeatureProvider patchDuneGrass() {
    return smallPlantProvider(SMBBlocks.DUNE_GRASS.get(), SMBPlacedFeature.PATCH_DUNE_GRASS, SMBConfiguredFeature.PATCH_DUNE_GRASS);
  }

  private static GenericSmallPlantFeatureProvider patchShortSnowGrass() {
    return smallPlantProvider(SMBBlocks.SHORT_SNOW_GRASS.get(), SMBPlacedFeature.PATCH_SHORT_SNOW_GRASS, SMBConfiguredFeature.PATCH_SHORT_SNOW_GRASS);
  }

  private static GenericSmallPlantFeatureProvider patchSnowFern() {
    return smallPlantProvider(SMBBlocks.SNOW_FERN.get(), SMBPlacedFeature.PATCH_SNOW_FERN, SMBConfiguredFeature.PATCH_SNOW_FERN);
  }

  private static GenericTallPlantFeatureProvider patchTallDuneGrass() {
    return tallPlantProvider(SMBBlocks.TALL_DUNE_GRASS.get(), SMBPlacedFeature.PATCH_TALL_DUNE_GRASS, SMBConfiguredFeature.PATCH_TALL_DUNE_GRASS);
  }

  private static GenericTallPlantFeatureProvider patchTallSnowGrass() {
    return tallPlantProvider(SMBBlocks.TALL_SNOW_GRASS.get(), SMBPlacedFeature.PATCH_TALL_SNOW_GRASS, SMBConfiguredFeature.PATCH_TALL_SNOW_GRASS);
  }

  private static GenericTallPlantFeatureProvider patchLargeSnowFern() {
    return tallPlantProvider(SMBBlocks.LARGE_SNOW_FERN.get(), SMBPlacedFeature.PATCH_LARGE_SNOW_FERN, SMBConfiguredFeature.PATCH_LARGE_SNOW_FERN);
  }

  private static EmptyFeatureProvider noneLeafLitter() {
    return emptyProvider(SMBFeatures.NONE_LEAF_LITTER_FEATURE.get(), SMBPlacedFeature.NONE_LEAF_LITTER, SMBConfiguredFeature.NONE_LEAF_LITTER);
  }

  private static GenericSmallPlantFeatureProvider smallPlantProvider(Block block, ResourceKey<PlacedFeature> placedFeature, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new GenericSmallPlantFeatureProvider(block).setPlacedFeatureKey(placedFeature).setConfiguredFeatureKey(configuredFeature);
  }

  private static GenericTallPlantFeatureProvider tallPlantProvider(Block block, ResourceKey<PlacedFeature> placedFeature, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new GenericTallPlantFeatureProvider(block).setPlacedFeatureKey(placedFeature).setConfiguredFeatureKey(configuredFeature);
  }

  private static EmptyFeatureProvider emptyProvider(Feature<NoneFeatureConfiguration> feature, ResourceKey<PlacedFeature> placedFeature, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new EmptyFeatureProvider(feature).setPlacedFeatureKey(placedFeature).setConfiguredFeatureKey(configuredFeature);
  }
}
