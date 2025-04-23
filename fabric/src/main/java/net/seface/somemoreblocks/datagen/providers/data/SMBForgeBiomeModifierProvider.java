package net.seface.somemoreblocks.datagen.providers.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.somemoreblocks.SomeMoreBlocks;
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
    this.vegetalDecoration("none_leaf_litter", SMBPlacedFeature.NONE_LEAF_LITTER).setBiomes(BiomeTags.IS_OVERWORLD).build();
    this.vegetalDecoration("patch_cattail", SMBPlacedFeature.PATCH_CATTAIL).setBiomes(SMBBiomeTags.GENERATES_CATTAIL).build();
    this.vegetalDecoration("patch_dune_grass", SMBPlacedFeature.PATCH_DUNE_GRASS).setBiomes(BiomeTags.IS_BEACH).build();

    this.configure()
      .setType(SomeMoreBlocks.id("patch_luminous_flower"))
      .setFeature(SMBPlacedFeature.PATCH_LUMINOUS_FLOWER)
      .setDecorationStep(GenerationStep.Decoration.UNDERGROUND_DECORATION)
      .setBiomes(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER).build();

    this.configure()
      .setType(SomeMoreBlocks.id("patch_small_lily_pads"))
      .setFeature(SMBPlacedFeature.PATCH_SMALL_LILY_PADS)
      .setDecorationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
      .setBiomes(SMBBiomeTags.GENERATES_SMALL_LILY_PADS).build();

    this.vegetalDecoration("none_big_lily_pad", SMBPlacedFeature.NONE_BIG_LILY_PAD).setBiomes(SMBBiomeTags.GENERATES_BIG_LILY_PAD).build();

    this.configure()
      .setType(SomeMoreBlocks.id("patch_tall_dune_grass"))
      .setFeature(SMBPlacedFeature.PATCH_TALL_DUNE_GRASS)
      .setDecorationStep(GenerationStep.Decoration.VEGETAL_DECORATION)
      .setBiomes(BiomeTags.IS_BEACH).build();

    this.vegetalDecoration("patch_tiny_cactus", SMBPlacedFeature.PATCH_TINY_CACTUS).setBiomes(SMBBiomeTags.GENERATES_TINY_CACTUS).build();
  }

  private ForgeBiomeModifier vegetalDecoration(String path, ResourceKey<PlacedFeature> placedFeature) {
    return this.configure()
      .setType(SomeMoreBlocks.id(path))
      .setFeature(placedFeature)
      .setDecorationStep(GenerationStep.Decoration.VEGETAL_DECORATION);
  }
}
