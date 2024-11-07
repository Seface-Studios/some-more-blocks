package net.seface.moreblocks.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.seface.moreblocks.MoreBlocks;

public class MBPlacedFeature {
  public static final ResourceKey<PlacedFeature> PATCH_CATTAIL = create("patch_cattail");
  public static final ResourceKey<PlacedFeature> PATCH_DUNE_GRASS = create("patch_dune_grass");
  public static final ResourceKey<PlacedFeature> PATCH_LUMINOUS_FLOWER = create("patch_luminous_flower");
  public static final ResourceKey<PlacedFeature> PATCH_SMALL_LILY_PADS = create("patch_small_lily_pads");
  public static final ResourceKey<PlacedFeature> PATCH_TALL_DUNE_GRASS = create("patch_tall_dune_grass");
  public static final ResourceKey<PlacedFeature> PATCH_TINY_CACTUS = create("patch_tiny_cactus_forest");
  public static final ResourceKey<PlacedFeature> NONE_LEAF_LITTER = create("none_leaf_litter");

  /**
   * A generic method to create a Resource Key.
   * @param identifier The placed feature identifier.
   * @return A Resource Key
   */
  private static ResourceKey<PlacedFeature> create(String identifier) {
    return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MoreBlocks.ID, identifier));
  }
}
