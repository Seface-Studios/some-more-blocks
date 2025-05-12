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
    NoneBigLilyPadFeatureProvider.create().registerPlaceFeature(context);
    PatchCactusFeatureProvider.create().registerPlaceFeature(context);
    PatchCattailFeatureProvider.create().registerPlaceFeature(context);
    PatchCattailSwampFeatureProvider.create().registerPlaceFeature(context);
    PatchCloverFeatureProvider.create().registerPlaceFeature(context);
    PatchDunePlantsFeatureProvider.create().registerPlaceFeature(context);
    PatchLargeSnowFernFeatureProvider.create().registerPlaceFeature(context);
    PatchLuminousFlowerFeatureProvider.create().registerPlaceFeature(context);
    PatchPaleRoseBushFeatureProvider.create().registerPlaceFeature(context);
    PatchSmallLilyPadsFeatureProvider.create().registerPlaceFeature(context);
    PatchSmallLilyPadsLushCavesFeatureProvider.create().registerPlaceFeature(context);
    PatchSnowPlantsFeatureProvider.create().registerPlaceFeature(context);
    SMBFeatureProvider.azaleaLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.birchLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.brownMushroomColony().registerPlaceFeature(context);
    SMBFeatureProvider.brownMushroomColonyWall().registerPlaceFeature(context);
    SMBFeatureProvider.crimsonFungusColony().registerPlaceFeature(context);
    SMBFeatureProvider.crimsonFungusColonyWall().registerPlaceFeature(context);
    SMBFeatureProvider.floweringAzaleaLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.leafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.paleOakLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.redMushroomColony().registerPlaceFeature(context);
    SMBFeatureProvider.redMushroomColonyWall().registerPlaceFeature(context);
    SMBFeatureProvider.spruceLeafLitter().registerPlaceFeature(context);
    SMBFeatureProvider.warpedFungusColony().registerPlaceFeature(context);
    SMBFeatureProvider.warpedFungusColonyWall().registerPlaceFeature(context);
  }

  public static void bootstrapCF(BootstrapContext<ConfiguredFeature<?, ?>> context) {
    NoneBigLilyPadFeatureProvider.create().registerConfiguredFeature(context);
    PatchCactusFeatureProvider.create().registerConfiguredFeature(context);
    PatchCattailFeatureProvider.create().registerConfiguredFeature(context);
    PatchCattailSwampFeatureProvider.create().registerConfiguredFeature(context);
    PatchCloverFeatureProvider.create().registerConfiguredFeature(context);
    PatchDunePlantsFeatureProvider.create().registerConfiguredFeature(context);
    PatchLargeSnowFernFeatureProvider.create().registerConfiguredFeature(context);
    PatchLuminousFlowerFeatureProvider.create().registerConfiguredFeature(context);
    PatchPaleRoseBushFeatureProvider.create().registerConfiguredFeature(context);
    PatchSmallLilyPadsFeatureProvider.create().registerConfiguredFeature(context);
    PatchSmallLilyPadsLushCavesFeatureProvider.create().registerConfiguredFeature(context);
    PatchSnowPlantsFeatureProvider.create().registerConfiguredFeature(context);
    SMBFeatureProvider.azaleaLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.birchLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.brownMushroomColony().registerConfiguredFeature(context);
    SMBFeatureProvider.brownMushroomColonyWall().registerConfiguredFeature(context);
    SMBFeatureProvider.crimsonFungusColony().registerConfiguredFeature(context);
    SMBFeatureProvider.crimsonFungusColonyWall().registerConfiguredFeature(context);
    SMBFeatureProvider.floweringAzaleaLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.leafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.paleOakLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.redMushroomColony().registerConfiguredFeature(context);
    SMBFeatureProvider.redMushroomColonyWall().registerConfiguredFeature(context);
    SMBFeatureProvider.spruceLeafLitter().registerConfiguredFeature(context);
    SMBFeatureProvider.warpedFungusColony().registerConfiguredFeature(context);
    SMBFeatureProvider.warpedFungusColonyWall().registerConfiguredFeature(context);
  }

  private static SimpleLeafLitterFeatureProvider leafLitter() {
    return simpleLeafLitter(SMBBlocks.LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_LEAF_LITTER)
      .addParent(Blocks.ACACIA_LEAVES)
      .addParent(Blocks.DARK_OAK_LEAVES)
      .addParent(Blocks.JUNGLE_LEAVES)
      .addParent(Blocks.MANGROVE_LEAVES)
      .addParent(Blocks.OAK_LEAVES)
      .setChance(12.5F);
  }

  private static SimpleLeafLitterFeatureProvider birchLeafLitter() {
    return simpleLeafLitter(SMBBlocks.BIRCH_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER)
      .addParent(Blocks.BIRCH_LEAVES)
      .setChance(12.5F);
  }

  private static SimpleLeafLitterFeatureProvider spruceLeafLitter() {
    return simpleLeafLitter(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_SPRUCE_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_SPRUCE_LEAF_LITTER)
      .addParent(Blocks.SPRUCE_LEAVES)
      .setChance(12.5F);
  }

  private static SimpleLeafLitterFeatureProvider azaleaLeafLitter() {
    return simpleLeafLitter(SMBBlocks.AZALEA_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER)
      .addParent(Blocks.AZALEA_LEAVES)
      .setChance(15.0F);
  }

  private static SimpleLeafLitterFeatureProvider floweringAzaleaLeafLitter() {
    return simpleLeafLitter(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER)
      .addParent(Blocks.FLOWERING_AZALEA_LEAVES)
      .addParent(Blocks.AZALEA_LEAVES)
      .setChance(10.0F);
  }

  private static SimpleLeafLitterFeatureProvider paleOakLeafLitter() {
    return simpleLeafLitter(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SMBPlacedFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER, SMBConfiguredFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER)
      .addParent(Blocks.PALE_OAK_LEAVES)
      .setChance(12.5F);
  }

  private static PatchMushroomColonyFeatureProvider redMushroomColony() {
    return new PatchMushroomColonyFeatureProvider(SMBBlocks.RED_MUSHROOM_COLONY.get(), SMBBlocks.TALL_RED_MUSHROOM_COLONY.get()).setPlacedFeatureKey(SMBPlacedFeature.PATCH_RED_MUSHROOM_COLONY).setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_RED_MUSHROOM_COLONY);
  }

  private static SimpleMushroomColonyWallFeatureProvider redMushroomColonyWall() {
    return simpleMushroomColony(SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), SMBPlacedFeature.SIMPLE_RED_MUSHROOM_COLONY_WALL, SMBConfiguredFeature.SIMPLE_RED_MUSHROOM_COLONY_WALL);
  }

  private static PatchMushroomColonyFeatureProvider brownMushroomColony() {
    return new PatchMushroomColonyFeatureProvider(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get()).setPlacedFeatureKey(SMBPlacedFeature.PATCH_BROWN_MUSHROOM_COLONY).setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_BROWN_MUSHROOM_COLONY);
  }

  private static SimpleMushroomColonyWallFeatureProvider brownMushroomColonyWall() {
    return simpleMushroomColony(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), SMBPlacedFeature.SIMPLE_BROWN_MUSHROOM_COLONY_WALL, SMBConfiguredFeature.SIMPLE_BROWN_MUSHROOM_COLONY_WALL);
  }

  private static PatchFungusColonyFeatureProvider warpedFungusColony() {
    return new PatchFungusColonyFeatureProvider(SMBBlocks.WARPED_FUNGUS_COLONY.get(), SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get()).setPlacedFeatureKey(SMBPlacedFeature.PATCH_WARPED_FUNGUS_COLONY).setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_WARPED_FUNGUS_COLONY);
  }

  private static SimpleMushroomColonyWallFeatureProvider warpedFungusColonyWall() {
    return simpleFungusColony(SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), SMBPlacedFeature.SIMPLE_WARPED_FUNGUS_COLONY_WALL, SMBConfiguredFeature.SIMPLE_WARPED_FUNGUS_COLONY_WALL);
  }

  private static PatchFungusColonyFeatureProvider crimsonFungusColony() {
    return new PatchFungusColonyFeatureProvider(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get()).setPlacedFeatureKey(SMBPlacedFeature.PATCH_CRIMSON_FUNGUS_COLONY).setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CRIMSON_FUNGUS_COLONY);
  }

  private static SimpleMushroomColonyWallFeatureProvider crimsonFungusColonyWall() {
    return simpleFungusColony(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), SMBPlacedFeature.SIMPLE_CRIMSON_FUNGUS_COLONY_WALL, SMBConfiguredFeature.SIMPLE_CRIMSON_FUNGUS_COLONY_WALL);
  }

  private static SimpleFungusColonyWallFeatureProvider simpleFungusColony(Block block, ResourceKey<PlacedFeature> placedFeature, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new SimpleFungusColonyWallFeatureProvider(block).setPlacedFeatureKey(placedFeature).setConfiguredFeatureKey(configuredFeature);
  }

  private static SimpleMushroomColonyWallFeatureProvider simpleMushroomColony(Block block, ResourceKey<PlacedFeature> placedFeature, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new SimpleMushroomColonyWallFeatureProvider(block).setPlacedFeatureKey(placedFeature).setConfiguredFeatureKey(configuredFeature);
  }

  private static SimpleLeafLitterFeatureProvider simpleLeafLitter(Block block, ResourceKey<PlacedFeature> placedFeature, ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
    return new SimpleLeafLitterFeatureProvider(block).setPlacedFeatureKey(placedFeature).setConfiguredFeatureKey(configuredFeature);
  }
}
