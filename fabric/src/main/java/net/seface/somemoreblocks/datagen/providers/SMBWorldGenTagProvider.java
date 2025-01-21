package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.seface.somemoreblocks.data.SMBBiomeTags;

import java.util.concurrent.CompletableFuture;

public class SMBWorldGenTagProvider extends FabricTagProvider<Biome> {
  public SMBWorldGenTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> future) {
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
      .forceAddTag(BiomeTags.IS_FOREST)
      .forceAddTag(BiomeTags.IS_BADLANDS)
      .add(Biomes.DESERT);
  }
}
