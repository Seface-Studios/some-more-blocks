package net.seface.somemoreblocks.datagen.providers.tags;

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
    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_CATTAIL).add(Biomes.RIVER, Biomes.SWAMP);
    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_LUMINOUS_FLOWER).forceAddTag(BiomeTags.IS_OVERWORLD);
    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_SMALL_LILY_PADS)
      .add(Biomes.LUSH_CAVES, Biomes.MANGROVE_SWAMP,
        Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE);

    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_TINY_CACTUS)
      .forceAddTag(BiomeTags.IS_BADLANDS)
      .add(Biomes.DESERT);

    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_RED_MUSHROOM_COLONY).add(Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_BROWN_MUSHROOM_COLONY).add(Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_CRIMSON_FUNGUS_COLONY).add(Biomes.CRIMSON_FOREST);
    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_WARPED_FUNGUS_COLONY).add(Biomes.WARPED_FOREST);

    getOrCreateTagBuilder(SMBBiomeTags.GENERATES_SNOW_PLANTS).add(Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA);
  }
}
