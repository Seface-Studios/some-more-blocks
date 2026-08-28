package net.sefacestudios.somemoreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import org.jetbrains.annotations.NotNull;

public final class SMBBiomeTags {
  public static final TagKey<@NotNull Biome> GENERATES_BIG_LILY_PAD = register("generates/big_lily_pad");
  public static final TagKey<@NotNull Biome> GENERATES_BROWN_MUSHROOM_COLONY = register("generates/brown_mushroom_colony");
  public static final TagKey<@NotNull Biome> GENERATES_CACTUS_PLANTS = register("generates/cactus_plants");
  public static final TagKey<@NotNull Biome> GENERATES_CATTAIL = register("generates/cattail");
  public static final TagKey<@NotNull Biome> GENERATES_CLOVER = register("generates/clover");
  public static final TagKey<@NotNull Biome> GENERATES_CRIMSON_FUNGUS_COLONY = register("generates/crimson_fungus_colony");
  public static final TagKey<@NotNull Biome> GENERATES_DUCKWEED = register("generates/duckweed");
  public static final TagKey<@NotNull Biome> GENERATES_LARGE_SNOW_FERN = register("generates/large_snow_fern");
  public static final TagKey<@NotNull Biome> GENERATES_LARKSPUR = register("generates/larkspur");
  public static final TagKey<@NotNull Biome> GENERATES_LUMINOUS_FLOWER = register("generates/luminous_flower");
  public static final TagKey<@NotNull Biome> GENERATES_NETHER_CLOVER = register("generates/nether_clover");
  public static final TagKey<@NotNull Biome> GENERATES_PALE_MUSHROOM = register("generates/pale_mushroom");
  public static final TagKey<@NotNull Biome> GENERATES_PALE_MUSHROOM_COLONY = register("generates/pale_mushroom_colony");
  public static final TagKey<@NotNull Biome> GENERATES_RED_MUSHROOM_COLONY = register("generates/red_mushroom_colony");
  public static final TagKey<@NotNull Biome> GENERATES_SMALL_LILY_PADS = register("generates/small_lily_pads");
  public static final TagKey<@NotNull Biome> GENERATES_SNOW_GRASS = register("generates/snow_grass");
  public static final TagKey<@NotNull Biome> GENERATES_SPROUTS = register("generates/sprouts");
  public static final TagKey<@NotNull Biome> GENERATES_SWAMP_VEGETATION = register("generates/swamp_vegetation");
  public static final TagKey<@NotNull Biome> GENERATES_WARPED_FUNGUS_COLONY = register("generates/warped_fungus_colony");
  public static final TagKey<@NotNull Biome> GENERATES_SNOW_BUSH = register("generates/snow_bush");

  public static void init() {}

  private static TagKey<@NotNull Biome> register(String path) {
    return SomeMoreBlocks.tagKey(Registries.BIOME, path);
  }
}
