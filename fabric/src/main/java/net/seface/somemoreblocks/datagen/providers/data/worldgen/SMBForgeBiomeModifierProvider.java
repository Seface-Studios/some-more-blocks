package net.seface.somemoreblocks.datagen.providers.data.worldgen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBBiomeTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.sefacestudios.datagen_extras.modifiers.ForgedBiomeModifier;
import net.sefacestudios.datagen_extras.modifiers.ForgedBiomeModifierTypes;
import net.sefacestudios.datagen_extras.provider.forge.ForgeBiomeModifierProvider;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBForgeBiomeModifierProvider extends ForgeBiomeModifierProvider {
  private Consumer<ForgedBiomeModifier> consumer;

  public SMBForgeBiomeModifierProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generate(HolderLookup.Provider lookup, Consumer<ForgedBiomeModifier> gen) {
    this.consumer = gen;

    this.vegetalDecoration(SMBConfiguredFeature.NONE_BIG_LILY_PAD, SMBBiomeTags.GENERATES_BIG_LILY_PAD);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_CACTUS_PLANTS, SMBBiomeTags.GENERATES_CACTUS_PLANTS);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_CATTAIL, Biomes.RIVER);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_CATTAIL_SWAMP, Biomes.SWAMP);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_CRIMSON_FUNGUS_COLONY, SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.SIMPLE_CRIMSON_FUNGUS_COLONY_WALL, SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_DUNE_GRASS, BiomeTags.IS_BEACH);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_LARGE_SNOW_FERN, SMBBiomeTags.GENERATES_LARGE_SNOW_FERN);
    this.luminousFlower();
    this.leafLitter(SMBConfiguredFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER);
    this.leafLitter(SMBConfiguredFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER);
    this.leafLitter(SMBConfiguredFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER);
    this.leafLitter(SMBConfiguredFeature.SIMPLE_BLOCK_LEAF_LITTER);
    this.leafLitter(SMBConfiguredFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_BROWN_MUSHROOM_COLONY, SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_CLOVER, SMBBiomeTags.GENERATES_CLOVER);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_NETHER_CLOVER, SMBBiomeTags.GENERATES_NETHER_CLOVER);
    this.paleMushroom();
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_PALE_MUSHROOM_COLONY, SMBBiomeTags.GENERATES_PALE_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_PALE_ROSE_BUSH, Biomes.PALE_GARDEN);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_RED_MUSHROOM_COLONY, SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_SMALL_LILY_PADS, SMBBiomeTags.GENERATES_SMALL_LILY_PADS);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_SMALL_LILY_PADS_LUSH_CAVES, Biomes.LUSH_CAVES);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_SNOW_GRASS, SMBBiomeTags.GENERATES_SNOW_GRASS);
    this.vegetalDecoration(SMBConfiguredFeature.PATCH_WARPED_FUNGUS_COLONY, SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.SIMPLE_BROWN_MUSHROOM_COLONY_WALL, SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.SIMPLE_PALE_MUSHROOM_COLONY_WALL, SMBBiomeTags.GENERATES_PALE_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.SIMPLE_RED_MUSHROOM_COLONY_WALL, SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBConfiguredFeature.SIMPLE_WARPED_FUNGUS_COLONY_WALL, SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY);
  }

  private void paleMushroom() {
    ForgedBiomeModifier.Builder.biomeModifier(this.loader)
      .type(ForgedBiomeModifierTypes.ADD_FEATURES)
      .biomes(SMBBiomeTags.GENERATES_PALE_MUSHROOM)
      .features(SMBConfiguredFeature.PATCH_PALE_MUSHROOM)
      .step(GenerationStep.Decoration.UNDERGROUND_DECORATION)
      .save(this.consumer);
  }

  private void leafLitter(ResourceKey<ConfiguredFeature<?, ?>> feature) {
    this.vegetalDecoration(feature).biomes(BiomeTags.IS_OVERWORLD).save(this.consumer);
  }

  private void luminousFlower() {
    ForgedBiomeModifier.Builder.biomeModifier(this.loader)
      .type(ForgedBiomeModifierTypes.ADD_FEATURES)
      .biomes(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER)
      .features(SMBConfiguredFeature.PATCH_LUMINOUS_FLOWER)
      .step(GenerationStep.Decoration.UNDERGROUND_DECORATION)
      .save(this.consumer);
  }

  private void vegetalDecoration(ResourceKey<ConfiguredFeature<?, ?>> feature, ResourceKey<Biome> biome) {
    this.vegetalDecoration(feature).biomes(biome).save(this.consumer);
  }

  private void vegetalDecoration(ResourceKey<ConfiguredFeature<?, ?>> feature, TagKey<Biome> biome) {
    this.vegetalDecoration(feature).biomes(biome).save(this.consumer);
  }

  private ForgedBiomeModifier.Builder vegetalDecoration(ResourceKey<ConfiguredFeature<?, ?>> feature) {
    return ForgedBiomeModifier.Builder.biomeModifier(this.loader)
      .type(ForgedBiomeModifierTypes.ADD_FEATURES)
      .features(feature)
      .step(GenerationStep.Decoration.VEGETAL_DECORATION);
  }
}
