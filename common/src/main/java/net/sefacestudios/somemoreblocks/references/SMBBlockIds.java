package net.sefacestudios.somemoreblocks.references;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;

public class SMBBlockIds {
  public static final ResourceKey<Block> AZALEA_LEAF_LITTER = create("azalea_leaf_litter");
  public static final ResourceKey<Block> BIRCH_LEAF_LITTER = create("birch_leaf_litter");
  public static final ResourceKey<Block> BIG_LILY_PAD = create("big_lily_pad");
  public static final ResourceKey<Block> TALL_BROWN_MUSHROOM_COLONY = create("tall_brown_mushroom_colony");
  public static final ResourceKey<Block> BROWN_MUSHROOM_COLONY = create("brown_mushroom_colony");
  public static final ResourceKey<Block> BROWN_MUSHROOM_COLONY_WALL = create("brown_mushroom_colony_wall");
  public static final ResourceKey<Block> TALL_CRIMSON_FUNGUS_COLONY = create("tall_crimson_fungus_colony");
  public static final ResourceKey<Block> CRIMSON_FUNGUS_COLONY = create("crimson_fungus_colony");
  public static final ResourceKey<Block> CRIMSON_FUNGUS_COLONY_WALL = create("crimson_fungus_colony_wall");
  public static final ResourceKey<Block> FLOWERING_AZALEA_LEAF_LITTER = create("flowering_azalea_leaf_litter");
  public static final ResourceKey<Block> SPRUCE_LEAF_LITTER = create("spruce_leaf_litter");
  public static final ResourceKey<Block> LEAF_LITTER = create("leaf_litter");
  public static final ResourceKey<Block> TALL_RED_MUSHROOM_COLONY = create("tall_red_mushroom_colony");
  public static final ResourceKey<Block> RED_MUSHROOM_COLONY = create("red_mushroom_colony");
  public static final ResourceKey<Block> RED_MUSHROOM_COLONY_WALL = create("red_mushroom_colony_wall");
  public static final ResourceKey<Block> SMALL_LILY_PADS = create("small_lily_pads");
  public static final ResourceKey<Block> TALL_WARPED_FUNGUS_COLONY = create("tall_warped_fungus_colony");
  public static final ResourceKey<Block> WARPED_FUNGUS_COLONY = create("warped_fungus_colony");
  public static final ResourceKey<Block> WARPED_FUNGUS_COLONY_WALL = create("warped_fungus_colony_wall");
  public static final ResourceKey<Block> POTTED_LUMINOUS_FLOWER = create("potted_luminous_flower");
  public static final ResourceKey<Block> POTTED_SNOW_FERN = create("potted_snow_fern");
  public static final ResourceKey<Block> POTTED_TINY_CACTUS = create("potted_tiny_cactus");
  public static final ResourceKey<Block> PALE_OAK_LEAF_LITTER = create("pale_oak_leaf_litter");
  public static final ResourceKey<Block> CARVED_PALE_OAK_LOG = create("carved_pale_oak_log");
  public static final ResourceKey<Block> CARVED_PALE_OAK_WOOD = create("carved_pale_oak_wood");
  public static final ResourceKey<Block> CLOVER = create("clover");
  public static final ResourceKey<Block> NETHER_CLOVER = create("nether_clover");
  public static final ResourceKey<Block> PALE_MUSHROOM = create("pale_mushroom");
  public static final ResourceKey<Block> POTTED_PALE_MUSHROOM = create("potted_pale_mushroom");
  public static final ResourceKey<Block> TALL_PALE_MUSHROOM_COLONY = create("tall_pale_mushroom_colony");
  public static final ResourceKey<Block> PALE_MUSHROOM_COLONY = create("pale_mushroom_colony");
  public static final ResourceKey<Block> PALE_MUSHROOM_COLONY_WALL = create("pale_mushroom_colony_wall");
  public static final ResourceKey<Block> POTTED_SHORT_GALAHAD_LARKSPUR = create("potted_short_galahad_larkspur");
  public static final ResourceKey<Block> POTTED_SHORT_ASTOLAT_LARKSPUR = create("potted_short_astolat_larkspur");
  public static final ResourceKey<Block> POTTED_SHORT_SUMMER_SKIES_LARKSPUR = create("potted_short_summer_skies_larkspur");
  public static final ResourceKey<Block> POTTED_SHORT_PURPLE_LARKSPUR = create("potted_short_purple_larkspur");
  public static final ResourceKey<Block> POTTED_SHORT_RED_LARK_LARKSPUR = create("potted_short_red_lark_larkspur");
  public static final ResourceKey<Block> DUCKWEED = create("duckweed");
  public static final ResourceKey<Block> PEBBLES = create("pebbles");

  private static ResourceKey<Block> create(String name) {
    return SomeMoreBlocks.key(Registries.BLOCK, name);
  }
}
