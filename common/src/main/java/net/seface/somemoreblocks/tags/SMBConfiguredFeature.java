package net.seface.somemoreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class SMBConfiguredFeature extends SMBAbstractData {
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_CATTAIL = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_cattail");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DUNE_GRASS = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_dune_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LARGE_SNOW_FERN = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_large_snow_fern");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SMALL_LILY_PADS = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_small_lily_pads");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SNOW_FERN = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_snow_fern");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SHORT_SNOW_GRASS = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_short_snow_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_DUNE_GRASS = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_tall_dune_grass");
  public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_SNOW_GRASS = createResourceKey(Registries.CONFIGURED_FEATURE, "patch_tall_snow_grass");
}
