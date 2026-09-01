package net.sefacestudios.somemoreblocks.datagen.providers.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.sefacestudios.somemoreblocks.tags.SMBBiomeTags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SMBBiomeTagProvider extends FabricTagsProvider<@NotNull Biome> {
  public SMBBiomeTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> future) {
    super(output, Registries.BIOME, future);
  }

  @Override
  protected void addTags(@NotNull HolderLookup.Provider provider) {
    this.builder(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER).add(Biomes.LUSH_CAVES);

    this.builder(SMBBiomeTags.GENERATES_SMALL_LILY_PADS)
      .addAll(List.of(
        Biomes.LUSH_CAVES,
        Biomes.MANGROVE_SWAMP,
        Biomes.JUNGLE,
        Biomes.BAMBOO_JUNGLE
      ));

    // Same biomes as cattail/reeds; swamp uses the denser GENERATES_SWAMP_VEGETATION feature instead.
    this.builder(SMBBiomeTags.GENERATES_DUCKWEED)
      .addOptionalTag(BiomeTags.IS_FOREST)
      .addOptionalTag(BiomeTags.IS_RIVER)
      .addAll(List.of(
        Biomes.PLAINS,
        Biomes.SUNFLOWER_PLAINS,
        Biomes.MEADOW,
        Biomes.BIRCH_FOREST,
        Biomes.OLD_GROWTH_BIRCH_FOREST,
        Biomes.DARK_FOREST,
        Biomes.FLOWER_FOREST,
        Biomes.FOREST,
        Biomes.TAIGA,
        Biomes.OLD_GROWTH_PINE_TAIGA,
        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
        Biomes.JUNGLE,
        Biomes.BAMBOO_JUNGLE,
        Biomes.SPARSE_JUNGLE,
        Biomes.BEACH
      ));

    this.builder(SMBBiomeTags.GENERATES_CATTAIL)
      .addOptionalTag(BiomeTags.IS_FOREST)
      .addOptionalTag(BiomeTags.IS_RIVER)
      .addAll(List.of(
        Biomes.PLAINS,
        Biomes.SUNFLOWER_PLAINS,
        Biomes.MEADOW,
        Biomes.BIRCH_FOREST,
        Biomes.OLD_GROWTH_BIRCH_FOREST,
        Biomes.DARK_FOREST,
        Biomes.FLOWER_FOREST,
        Biomes.FOREST,
        Biomes.TAIGA,
        Biomes.OLD_GROWTH_PINE_TAIGA,
        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
        Biomes.JUNGLE,
        Biomes.BAMBOO_JUNGLE,
        Biomes.SPARSE_JUNGLE,
        Biomes.BEACH
      ));

    this.builder(SMBBiomeTags.GENERATES_BIG_LILY_PAD)
      .addAll(List.of(
        Biomes.MANGROVE_SWAMP,
        Biomes.JUNGLE,
        Biomes.BAMBOO_JUNGLE
      ));

    this.builder(SMBBiomeTags.GENERATES_CACTUS_PLANTS)
      .addOptionalTag(BiomeTags.IS_BADLANDS)
      .add(Biomes.DESERT);

    this.builder(SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY)
      .addAll(List.of(
        Biomes.SWAMP,
        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
        Biomes.OLD_GROWTH_BIRCH_FOREST,
        Biomes.MUSHROOM_FIELDS
      ));

    this.builder(SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY)
      .addAll(List.of(
        Biomes.SWAMP,
        Biomes.OLD_GROWTH_SPRUCE_TAIGA,
        Biomes.OLD_GROWTH_PINE_TAIGA,
        Biomes.OLD_GROWTH_BIRCH_FOREST,
        Biomes.MUSHROOM_FIELDS
      ));

    this.builder(SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY)
      .add(Biomes.CRIMSON_FOREST);

    this.builder(SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY)
      .add(Biomes.WARPED_FOREST);

    this.builder(SMBBiomeTags.GENERATES_SNOW_GRASS)
      .addAll(List.of(
        Biomes.SNOWY_PLAINS,
        Biomes.SNOWY_TAIGA
      ));

    this.builder(SMBBiomeTags.GENERATES_LARGE_SNOW_FERN)
      .add(Biomes.SNOWY_TAIGA);

    this.builder(SMBBiomeTags.GENERATES_CLOVER)
      .addOptionalTag(BiomeTags.IS_JUNGLE)
      .addAll(List.of(
        Biomes.BIRCH_FOREST,
        Biomes.DARK_FOREST,
        Biomes.FLOWER_FOREST,
        Biomes.FOREST,
        Biomes.GROVE,
        Biomes.OLD_GROWTH_BIRCH_FOREST,
        Biomes.PLAINS,
        Biomes.SUNFLOWER_PLAINS,
        Biomes.MEADOW
      ));

    this.builder(SMBBiomeTags.GENERATES_SPROUTS)
      .addOptionalTag(BiomeTags.IS_FOREST)
      .addAll(List.of(
        Biomes.PLAINS,
        Biomes.SUNFLOWER_PLAINS,
        Biomes.MEADOW,
        Biomes.RIVER,
        Biomes.SWAMP,
        Biomes.MANGROVE_SWAMP,
        Biomes.CHERRY_GROVE
      ));

    this.builder(SMBBiomeTags.GENERATES_LARKSPUR)
      .addAll(List.of(
        Biomes.MEADOW,
        Biomes.FOREST,
        Biomes.BIRCH_FOREST,
        Biomes.OLD_GROWTH_BIRCH_FOREST,
        Biomes.CHERRY_GROVE
      ));

    this.builder(SMBBiomeTags.GENERATES_NETHER_CLOVER)
      .addAll(List.of(
        Biomes.CRIMSON_FOREST,
        Biomes.WARPED_FOREST,
        Biomes.FLOWER_FOREST,
        Biomes.NETHER_WASTES
      ));

    this.builder(SMBBiomeTags.GENERATES_PALE_MUSHROOM)
      .addAll(List.of(
        Biomes.PALE_GARDEN,
        Biomes.DRIPSTONE_CAVES,
        Biomes.LUSH_CAVES,
        Biomes.DEEP_DARK
      ));

    this.builder(SMBBiomeTags.GENERATES_PALE_MUSHROOM_COLONY)
      .add(Biomes.PALE_GARDEN);

    this.builder(SMBBiomeTags.GENERATES_SNOW_BUSH)
      .add(Biomes.FROZEN_RIVER);

    this.builder(SMBBiomeTags.GENERATES_SWAMP_VEGETATION)
      .addAll(List.of(
        Biomes.SWAMP,
        Biomes.MANGROVE_SWAMP
      ));
  }
}
