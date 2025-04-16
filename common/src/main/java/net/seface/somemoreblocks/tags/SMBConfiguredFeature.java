package net.seface.somemoreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.seface.somemoreblocks.SomeMoreBlocks;

public class SMBConfiguredFeature {
  public static final ResourceKey<ConfiguredFeature<?, ?>> NONE_LEAF_LITTER = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "none_leaf_litter");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CATTAIL = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_cattail");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DUNE_GRASS = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_dune_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LARGE_SNOW_FERN = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_large_snow_fern");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SMALL_LILY_PADS = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_small_lily_pads");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SNOW_FERN = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_snow_fern");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SHORT_SNOW_GRASS = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_short_snow_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_DUNE_GRASS = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_tall_dune_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_SNOW_GRASS = SomeMoreBlocks.key(Registries.CONFIGURED_FEATURE, "patch_tall_snow_grass");

  public static void init() {}
}
