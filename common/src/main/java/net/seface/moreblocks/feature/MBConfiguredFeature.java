package net.seface.moreblocks.feature;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.seface.moreblocks.MoreBlocks;

import java.util.function.BiConsumer;

public class MBConfiguredFeature {
  public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_SMALL_LILY_PADS = ResourceKey.create(
    Registries.CONFIGURED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_small_lily_pads"));

  public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_BIG_LILY_PAD = ResourceKey.create(
    Registries.CONFIGURED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_big_lily_pad"));

  public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_DUNE_GRASS = ResourceKey.create(
    Registries.CONFIGURED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_dune_grass"));

  public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_TALL_DUNE_GRASS = ResourceKey.create(
    Registries.CONFIGURED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_tall_dune_grass"));

  public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_TINY_CACTUS = ResourceKey.create(
    Registries.CONFIGURED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_tiny_cactus_forest"));

  /*public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MUSHROOM_COLONY_WALL = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "red_mushroom_colony_wall"));*/

  public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_PATCH_CATTAIL = ResourceKey.create(
    Registries.CONFIGURED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_cattail"));


  private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BiConsumer<ResourceLocation, Feature<?>> ctx, String identifier, F feature) {
    ctx.accept(new ResourceLocation(MoreBlocks.ID, identifier), feature);
    //ctx.register(key, new ConfiguredFeature<>(feature, configuration));
  }
}
