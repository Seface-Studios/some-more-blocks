package net.seface.somemoreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.seface.somemoreblocks.SomeMoreBlocks;

public final class SMBBiomeTags {
  public static final TagKey<Biome> GENERATES_CATTAIL = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_cattail");
  public static final TagKey<Biome> GENERATES_LUMINOUS_FLOWER = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_luminous_flower");
  public static final TagKey<Biome> GENERATES_SMALL_LILY_PADS = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_small_lily_pads");
  public static final TagKey<Biome> GENERATES_BIG_LILY_PAD = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_big_lily_pad");
  public static final TagKey<Biome> GENERATES_TINY_CACTUS = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_tiny_cactus");
  public static final TagKey<Biome> GENERATES_RED_MUSHROOM_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_red_mushroom_colony");
  public static final TagKey<Biome> GENERATES_BROWN_MUSHROOM_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_brown_mushroom_colony");
  public static final TagKey<Biome> GENERATES_CRIMSON_FUNGUS_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_crimson_fungus_colony");
  public static final TagKey<Biome> GENERATES_WARPED_FUNGUS_COLONY = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_warped_fungus_colony");
  public static final TagKey<Biome> GENERATES_SNOW_PLANTS = SomeMoreBlocks.tagKey(Registries.BIOME, "generates_snow_plants");

  public static void init() {}
}
