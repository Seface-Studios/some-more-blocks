package net.seface.somemoreblocks.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class SMBPlacedFeature extends SMBAbstractData {
  public static final ResourceKey<PlacedFeature> PATCH_CATTAIL = createResourceKey(Registries.PLACED_FEATURE, "patch_cattail");
  public static final ResourceKey<PlacedFeature> PATCH_DUNE_GRASS = createResourceKey(Registries.PLACED_FEATURE, "patch_dune_grass");
  public static final ResourceKey<PlacedFeature> PATCH_LUMINOUS_FLOWER = createResourceKey(Registries.PLACED_FEATURE, "patch_luminous_flower");
  public static final ResourceKey<PlacedFeature> PATCH_SMALL_LILY_PADS = createResourceKey(Registries.PLACED_FEATURE, "patch_small_lily_pads");
  public static final ResourceKey<PlacedFeature> PATCH_TALL_DUNE_GRASS = createResourceKey(Registries.PLACED_FEATURE, "patch_tall_dune_grass");
  public static final ResourceKey<PlacedFeature> PATCH_TINY_CACTUS = createResourceKey(Registries.PLACED_FEATURE, "patch_tiny_cactus_forest");
  public static final ResourceKey<PlacedFeature> NONE_LEAF_LITTER = createResourceKey(Registries.PLACED_FEATURE, "none_leaf_litter");

  //public static final ResourceKey<PlacedFeature> PATCH_RED_MUSHROOM_COLONY_WALL = createResourceKey(Registries.PLACED_FEATURE, "experimental/patch_red_mushroom_colony_wall");
}
