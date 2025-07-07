package net.seface.somemoreblocks.datagen.providers.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.seface.somemoreblocks.tags.SMBBiomeTags;

import java.util.concurrent.CompletableFuture;

public class SMBBiomeTagProvider extends FabricTagProvider<Biome> {
  public SMBBiomeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, Registries.BIOME, future);
  }

  @Override
  protected void addTags(HolderLookup.Provider provider) {
    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER).add(Biomes.LUSH_CAVES);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_SMALL_LILY_PADS)
      .add(Biomes.LUSH_CAVES, Biomes.MANGROVE_SWAMP, Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_BIG_LILY_PAD)
      .add(Biomes.MANGROVE_SWAMP, Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_CACTUS_PLANTS)
      .forceAddTag(BiomeTags.IS_BADLANDS)
      .add(Biomes.DESERT);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY)
      .add(Biomes.SWAMP, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.MUSHROOM_FIELDS);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY)
      .add(Biomes.SWAMP, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.MUSHROOM_FIELDS);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY)
      .add(Biomes.CRIMSON_FOREST);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY)
      .add(Biomes.WARPED_FOREST);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_SNOW_GRASS).add(Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA);
    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_LARGE_SNOW_FERN).add(Biomes.SNOWY_TAIGA);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_CLOVER)
      .forceAddTag(BiomeTags.IS_JUNGLE)
      .add(Biomes.BIRCH_FOREST, Biomes.DARK_FOREST, Biomes.FLOWER_FOREST, Biomes.FOREST,
        Biomes.GROVE, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS,
        Biomes.MEADOW);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_NETHER_CLOVER)
      .add(Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST, Biomes.FLOWER_FOREST, Biomes.NETHER_WASTES);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_PALE_MUSHROOM)
      .add(Biomes.PALE_GARDEN, Biomes.DRIPSTONE_CAVES, Biomes.LUSH_CAVES, Biomes.DEEP_DARK);

    this.getOrCreateTagBuilder(SMBBiomeTags.GENERATES_PALE_MUSHROOM_COLONY)
      .add(Biomes.PALE_GARDEN);
  }
}
