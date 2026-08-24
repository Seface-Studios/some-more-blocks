package net.sefacestudios.somemoreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import org.jetbrains.annotations.NotNull;

public class SMBConfiguredFeature {
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> NONE_BIG_LILY_PAD = register("none_big_lily_pad");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_BROWN_MUSHROOM_COLONY = register("patch_brown_mushroom_colony");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_PALE_MUSHROOM_COLONY = register("patch_pale_mushroom_colony");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_CACTUS_PLANTS = register("patch_cactus_plants");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_CATTAIL = register("patch_cattail");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_CATTAIL_SWAMP = register("patch_cattail_swamp");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_CLOVER = register("patch_clover");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_CRIMSON_FUNGUS_COLONY = register("patch_crimson_fungus_colony");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_DUNE_GRASS = register("patch_dune_grass");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_DUNE_GRASS_DESERT = register("patch_dune_grass_desert");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_LARGE_SNOW_FERN = register("patch_large_snow_fern");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_LUMINOUS_FLOWER = register("patch_luminous_flower");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_NETHER_CLOVER = register("patch_nether_clover");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_PALE_MUSHROOM = register("patch_pale_mushroom");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_PALE_ROSE_BUSH = register("patch_pale_rose_bush");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_RED_MUSHROOM_COLONY = register("patch_red_mushroom_colony");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_SMALL_LILY_PADS = register("patch_small_lily_pads");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_SMALL_LILY_PADS_LUSH_CAVES = register("patch_small_lily_pads_lush_caves");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_SNOW_GRASS = register("patch_snow_grass");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_WARPED_FUNGUS_COLONY = register("patch_warped_fungus_colony");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_BLOCK_AZALEA_LEAF_LITTER = register("simple_block_azalea_leaf_litter");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_BLOCK_BIRCH_LEAF_LITTER = register("simple_block_birch_leaf_litter");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER = register("simple_block_flowering_azalea_leaf_litter");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_BLOCK_LEAF_LITTER = register("simple_block_leaf_litter");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER = register("simple_block_pale_oak_leaf_litter");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_BLOCK_SPRUCE_LEAF_LITTER = register("simple_block_spruce_leaf_litter");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_BROWN_MUSHROOM_COLONY_WALL = register("simple_brown_mushroom_colony_wall");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_CRIMSON_FUNGUS_COLONY_WALL = register("simple_crimson_fungus_colony_wall");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_RED_MUSHROOM_COLONY_WALL = register("simple_red_mushroom_colony_wall");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_PALE_MUSHROOM_COLONY_WALL = register("simple_pale_mushroom_colony_wall");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> SIMPLE_WARPED_FUNGUS_COLONY_WALL = register("simple_warped_fungus_colony_wall");
  public static final ResourceKey<@NotNull ConfiguredFeature<?, ?>> PATCH_SNOW_BUSH = register("patch_snow_bush");

  public static void init() {}

  private static ResourceKey<@NotNull ConfiguredFeature<?, ?>> register(String path) {
    return SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, path);
  }
}
