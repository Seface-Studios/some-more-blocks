package net.seface.somemoreblocks.datagen.providers.data.worldgen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.somemoreblocks.datagen.providers.data.worldgen.providers.*;
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
    return "Feature";
  }

  public static void bootstrapF(BootstrapContext<PlacedFeature> context) {
    BigLilyPadFeatureProvider.create().registerPlaceFeature(context);
    CattailFeatureProvider.create().registerPlaceFeature(context);
    DunePlantsFeatureProvider.create().registerPlaceFeature(context);
    LargeSnowFernFeatureProvider.create().registerPlaceFeature(context);
    LuminousFlowerFeatureProvider.create().registerPlaceFeature(context);
    PatchCactusFeatureProvider.create().registerPlaceFeature(context);
    SMBFeatureProvider.azaleaLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.birchLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.floweringAzaleaLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.leafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.paleOakLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.spruceLeafLitter().registerPlaceFeature(context);
    SmallLilyPadsFeatureProvider.create().registerPlaceFeature(context);
    SmallLilyPadsLushCavesFeatureProvider.create().registerPlaceFeature(context);
    SnowPlantsFeatureProvider.create().registerPlaceFeature(context);
  }

  public static void bootstrapCF(BootstrapContext<ConfiguredFeature<?, ?>> context) {
    BigLilyPadFeatureProvider.create().registerConfiguredFeature(context);
    CattailFeatureProvider.create().registerConfiguredFeature(context);
    DunePlantsFeatureProvider.create().registerConfiguredFeature(context);
    LargeSnowFernFeatureProvider.create().registerConfiguredFeature(context);
    LuminousFlowerFeatureProvider.create().registerConfiguredFeature(context);
    PatchCactusFeatureProvider.create().registerConfiguredFeature(context);
    SMBFeatureProvider.azaleaLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.birchLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.floweringAzaleaLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.leafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.paleOakLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.spruceLeafLitter().registerConfiguredFeature(context);
    SmallLilyPadsFeatureProvider.create().registerConfiguredFeature(context);
    SmallLilyPadsLushCavesFeatureProvider.create().registerConfiguredFeature(context);
    SnowPlantsFeatureProvider.create().registerConfiguredFeature(context);
  }

  private static LeafLitterFeatureProvider leafLitter() {
    return simpleLeafLitter(SMBBlocks.LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_LEAF_LITTER)
      .addParent(Blocks.ACACIA_LEAVES)
      .addParent(Blocks.DARK_OAK_LEAVES)
      .addParent(Blocks.JUNGLE_LEAVES)
      .addParent(Blocks.MANGROVE_LEAVES)
      .addParent(Blocks.OAK_LEAVES)
      .setChance(12.5F);
  }

  private static LeafLitterFeatureProvider birchLeafLitter() {
    return simpleLeafLitter(SMBBlocks.BIRCH_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER)
      .addParent(Blocks.BIRCH_LEAVES)
      .setChance(12.5F);
  }

  private static LeafLitterFeatureProvider spruceLeafLitter() {
    return simpleLeafLitter(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_SPRUCE_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_SPRUCE_LEAF_LITTER)
      .addParent(Blocks.SPRUCE_LEAVES)
      .setChance(12.5F);
  }

  private static LeafLitterFeatureProvider azaleaLeafLitter() {
    return simpleLeafLitter(SMBBlocks.AZALEA_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER)
      .addParent(Blocks.AZALEA_LEAVES)
      .setChance(15.0F);
  }

  private static LeafLitterFeatureProvider floweringAzaleaLeafLitter() {
    return simpleLeafLitter(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER)
      .addParent(Blocks.FLOWERING_AZALEA_LEAVES)
      .addParent(Blocks.AZALEA_LEAVES)
      .setChance(10.0F);
  }

  private static LeafLitterFeatureProvider paleOakLeafLitter() {
    return simpleLeafLitter(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER)
      .addParent(Blocks.PALE_OAK_LEAVES)
      .setChance(12.5F);
  }

  private static LeafLitterFeatureProvider simpleLeafLitter(Block block, ResourceKey<PlacedFeature> placedFeature, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new LeafLitterFeatureProvider(block).setPlacedFeatureKey(placedFeature).setConfiguredFeatureKey(configuredFeature);
  }
}
