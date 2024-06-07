package net.seface.moreblocks.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.moreblocks.MoreBlocks;

public class MBPlacedFeature {
  public static final ResourceKey<PlacedFeature> PLACED_PATCH_SMALL_LILY_PADS = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_small_lily_pads"));

  public static final ResourceKey<PlacedFeature> PLACED_PATCH_BIG_LILY_PAD = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_big_lily_pad"));

  public static final ResourceKey<PlacedFeature> PLACED_PATCH_DUNE_GRASS = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_dune_grass"));

  public static final ResourceKey<PlacedFeature> PLACED_PATCH_TALL_DUNE_GRASS = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_tall_dune_grass"));

  public static final ResourceKey<PlacedFeature> PLACED_PATCH_TINY_CACTUS_FOREST = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_tiny_cactus_forest"));

  /*public static final ResourceKey<PlacedFeature> RED_MUSHROOM_COLONY_WALL = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "red_mushroom_colony_wall"));*/

  public static final ResourceKey<PlacedFeature> PLACED_PATCH_CATTAIL = ResourceKey.create(
    Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, "patch_cattail"));
}
