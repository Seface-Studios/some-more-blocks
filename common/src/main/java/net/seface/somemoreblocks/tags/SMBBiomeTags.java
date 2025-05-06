package net.seface.somemoreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.seface.somemoreblocks.SomeMoreBlocks;

public final class SMBBiomeTags {
  public static final TagKey<Biome> GENERATES_CATTAIL = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/cattail");
  public static final TagKey<Biome> GENERATES_LUMINOUS_FLOWER = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/luminous_flower");
  public static final TagKey<Biome> GENERATES_SMALL_LILY_PADS = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/small_lily_pads");
  public static final TagKey<Biome> GENERATES_BIG_LILY_PAD = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/big_lily_pad");
  public static final TagKey<Biome> GENERATES_CACTUS_PLANTS = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/cactus_plants");
  public static final TagKey<Biome> GENERATES_RED_MUSHROOM_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/red_mushroom_colony");
  public static final TagKey<Biome> GENERATES_BROWN_MUSHROOM_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/brown_mushroom_colony");
  public static final TagKey<Biome> GENERATES_CRIMSON_FUNGUS_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/crimson_fungus_colony");
  public static final TagKey<Biome> GENERATES_WARPED_FUNGUS_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/warped_fungus_colony");
  public static final TagKey<Biome> GENERATES_SNOW_GRASS = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/snow_grass");
  public static final TagKey<Biome> GENERATES_LARGE_SNOW_FERN = SomeMoreBlocks.tagKey(Registries.BIOME, "generates/large_snow_fern");

  public static void init() {}
}
