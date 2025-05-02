package net.seface.somemoreblocks.datagen.providers.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.somemoreblocks.datagen.providers.data.forge.ForgeBiomeModifier;
import net.seface.somemoreblocks.datagen.providers.data.forge.ForgeModifierProvider;
import net.seface.somemoreblocks.tags.SMBBiomeTags;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

public class SMBForgeBiomeModifierProvider extends ForgeModifierProvider {
  public SMBForgeBiomeModifierProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void create() {
    this.vegetalDecoration(SMBPlacedFeature.NONE_BIG_LILY_PAD).setBiomes(SMBBiomeTags.GENERATES_BIG_LILY_PAD).build();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CACTUS_PLANTS).setBiomes(SMBBiomeTags.GENERATES_CACTUS_PLANTS).build();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_CATTAIL).setBiomes(SMBBiomeTags.GENERATES_CATTAIL).build();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_DUNE_GRASS).setBiomes(BiomeTags.IS_BEACH).build();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_LARGE_SNOW_FERN).setBiomes(SMBBiomeTags.GENERATES_LARGE_SNOW_FERN).build();

    this.configure()
      .setType(SMBPlacedFeature.PATCH_LUMINOUS_FLOWER.location())
      .setFeature(SMBPlacedFeature.PATCH_LUMINOUS_FLOWER)
      .setDecorationStep(GenerationStep.Decoration.UNDERGROUND_DECORATION)
      .setBiomes(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER).build();

    this.vegetalDecoration(SMBPlacedFeature.PATCH_PALE_ROSE_BUSH).setBiomes(Biomes.PALE_GARDEN).build();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SMALL_LILY_PADS).setBiomes(SMBBiomeTags.GENERATES_SMALL_LILY_PADS).build();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SMALL_LILY_PADS_LUSH_CAVES).setBiomes(Biomes.LUSH_CAVES).build();
    this.vegetalDecoration(SMBPlacedFeature.PATCH_SNOW_GRASS).setBiomes(SMBBiomeTags.GENERATES_SNOW_GRASS).build();

    this.leafLitterDecoration(SMBPlacedFeature.SIMPLE_BLOCK_AZALEA_LEAF_LITTER).build();
    this.leafLitterDecoration(SMBPlacedFeature.SIMPLE_BLOCK_BIRCH_LEAF_LITTER).build();
    this.leafLitterDecoration(SMBPlacedFeature.SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER).build();
    this.leafLitterDecoration(SMBPlacedFeature.SIMPLE_BLOCK_LEAF_LITTER).build();
    this.leafLitterDecoration(SMBPlacedFeature.SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER).build();
    this.leafLitterDecoration(SMBPlacedFeature.SIMPLE_BLOCK_SPRUCE_LEAF_LITTER).build();
  }

  private ForgeBiomeModifier leafLitterDecoration(ResourceKey<PlacedFeature> placedFeature) {
    return this.vegetalDecoration(placedFeature)
      .setBiomes(BiomeTags.IS_OVERWORLD);
  }

  private ForgeBiomeModifier vegetalDecoration(ResourceKey<PlacedFeature> placedFeature) {
    return this.configure()
      .setType(placedFeature.location())
      .setFeature(placedFeature)
      .setDecorationStep(GenerationStep.Decoration.VEGETAL_DECORATION);
  }
}
