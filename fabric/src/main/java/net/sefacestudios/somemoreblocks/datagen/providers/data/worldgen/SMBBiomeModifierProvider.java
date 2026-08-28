package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.sefacestudios.somemoreblocks.tags.SMBBiomeTags;
import net.sefacestudios.somemoreblocks.tags.SMBPlacedFeature;
import net.sefacestudios.datagen_extras.biome_modifiers.BiomeModifier;
import net.sefacestudios.datagen_extras.provider.worldgen.BiomeModifierProvider;
import net.sefacestudios.datagen_extras.utils.ModLoaderType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBBiomeModifierProvider extends BiomeModifierProvider {
  public SMBBiomeModifierProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup, ModLoaderType.FORGE);
  }

  public SMBBiomeModifierProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup, ModLoaderType modLoader) {
    super(output, registryLookup, modLoader);
  }

  @Override
  public void generate(HolderLookup.Provider lookup, Consumer<BiomeModifier> gen) {
    this.vegetalDecoration(SMBPlacedFeature.NONE_BIG_LILY_PAD, SMBBiomeTags.GENERATES_BIG_LILY_PAD);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CACTUS_PLANTS, SMBBiomeTags.GENERATES_CACTUS_PLANTS);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CATTAIL, SMBBiomeTags.GENERATES_CATTAIL);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CATTAIL_WATER, SMBBiomeTags.GENERATES_CATTAIL);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CATTAIL_SWAMP, SMBBiomeTags.GENERATES_SWAMP_VEGETATION);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CATTAIL_WATER_SWAMP, SMBBiomeTags.GENERATES_SWAMP_VEGETATION);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CRIMSON_FUNGUS_COLONY, SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.SIMPLE_CRIMSON_FUNGUS_COLONY_WALL, SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_DUCKWEED, SMBBiomeTags.GENERATES_DUCKWEED);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_DUCKWEED_LUSH_CAVES, Biomes.LUSH_CAVES);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_DUCKWEED_SWAMP, SMBBiomeTags.GENERATES_SWAMP_VEGETATION);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_DUNE_GRASS, BiomeTags.IS_BEACH);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_DUNE_GRASS_DESERT, Biomes.DESERT);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_LARGE_SNOW_FERN, SMBBiomeTags.GENERATES_LARGE_SNOW_FERN);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_LARKSPUR, SMBBiomeTags.GENERATES_LARKSPUR);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_LARKSPUR_FLOWER_FOREST, Biomes.FLOWER_FOREST);
    this.luminousFlower();
    this.leafLitter(SMBPlacedFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER);
    this.leafLitter(SMBPlacedFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER);
    this.leafLitter(SMBPlacedFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER);
    this.leafLitter(SMBPlacedFeature.SIMPLE_BLOCK_LEAF_LITTER);
    this.leafLitter(SMBPlacedFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_BROWN_MUSHROOM_COLONY, SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CLOVER, SMBBiomeTags.GENERATES_CLOVER);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_NETHER_CLOVER, SMBBiomeTags.GENERATES_NETHER_CLOVER);
    this.paleMushroom();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_PALE_MUSHROOM_COLONY, SMBBiomeTags.GENERATES_PALE_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_PALE_ROSE_BUSH, Biomes.PALE_GARDEN);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_RED_MUSHROOM_COLONY, SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SMALL_LILY_PADS, SMBBiomeTags.GENERATES_SMALL_LILY_PADS);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SMALL_LILY_PADS_LUSH_CAVES, Biomes.LUSH_CAVES);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SNOW_GRASS, SMBBiomeTags.GENERATES_SNOW_GRASS);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SPROUTS, SMBBiomeTags.GENERATES_SPROUTS);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_WARPED_FUNGUS_COLONY, SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.SIMPLE_BROWN_MUSHROOM_COLONY_WALL, SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.SIMPLE_PALE_MUSHROOM_COLONY_WALL, SMBBiomeTags.GENERATES_PALE_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.SIMPLE_RED_MUSHROOM_COLONY_WALL, SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.SIMPLE_WARPED_FUNGUS_COLONY_WALL, SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY);
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SNOW_BUSH, SMBBiomeTags.GENERATES_SNOW_BUSH);
  }

  private void paleMushroom() {
    this.features().add(
      SMBPlacedFeature.PATCH_PALE_MUSHROOM.identifier(),
      SMBBiomeTags.GENERATES_PALE_MUSHROOM,
      SMBPlacedFeature.PATCH_PALE_MUSHROOM,
      GenerationStep.Decoration.UNDERGROUND_DECORATION
    );
  }

  private void leafLitter(ResourceKey<@NotNull PlacedFeature> feature) {
    this.features().add(
      feature.identifier(),
      BiomeTags.IS_OVERWORLD,
      feature,
      GenerationStep.Decoration.VEGETAL_DECORATION
    );
  }

  private void luminousFlower() {
    this.features().add(
      SMBPlacedFeature.PATCH_LUMINOUS_FLOWER.identifier(),
      BiomeTags.IS_OVERWORLD,
      SMBPlacedFeature.PATCH_LUMINOUS_FLOWER,
      GenerationStep.Decoration.VEGETAL_DECORATION
    );
  }

  private void vegetalDecoration(ResourceKey<@NotNull PlacedFeature> feature, ResourceKey<@NotNull Biome> biome) {
    this.features().add(
      feature.identifier(),
      biome,
      feature,
      GenerationStep.Decoration.VEGETAL_DECORATION
    );
  }

  private void vegetalDecoration(ResourceKey<@NotNull PlacedFeature> feature, TagKey<@NotNull Biome> biome) {
    this.features().add(
      feature.identifier(),
      biome,
      feature,
      GenerationStep.Decoration.VEGETAL_DECORATION
    );
  }
}
