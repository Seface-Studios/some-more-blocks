package net.sefacestudios.somemoreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import org.jetbrains.annotations.NotNull;

public final class SMBBlockTags {
  public static final TagKey<@NotNull Block> BIG_LILY_PAD_REPLACEABLE = register("big_lily_pad_replaceable");
  public static final TagKey<@NotNull Block> CACTUS_PLANTS_PLACEABLE = register("cactus_plants_placeable");
  public static final TagKey<@NotNull Block> CATTAIL_ON_WATER_PLACEABLE = register("cattail_on_water_placeable");
  public static final TagKey<@NotNull Block> CATTAIL_PLACEABLE = register("cattail_placeable");
  public static final TagKey<@NotNull Block> CONCRETE_BRICKS = register("concrete_bricks");
  public static final TagKey<@NotNull Block> CONCRETE_TILES = register("concrete_tiles");
  public static final TagKey<@NotNull Block> DUNE_GRASS_PLACEABLE = register("dune_grass_placeable");
  public static final TagKey<@NotNull Block> FUNGUS_COLONIES = register("fungus_colonies");
  public static final TagKey<@NotNull Block> LEAF_LITTERS = register("leaf_litters");
  public static final TagKey<@NotNull Block> LEAF_LITTERS_PLACEABLE = register("leaf_litters_placeable");
  public static final TagKey<@NotNull Block> LEAF_LITTER_REPLACEABLE = register("leaf_litter_replaceable");
  public static final TagKey<@NotNull Block> LUMINOUS_FLOWER_REPLACEABLE = register("luminous_flower_replaceable");
  public static final TagKey<@NotNull Block> MUSHROOM_COLONIES = register("mushroom_colonies");
  public static final TagKey<@NotNull Block> MUSHROOM_COLONY_PLACEABLE = register("mushroom_colony_placeable");
  public static final TagKey<@NotNull Block> NETHER_CLOVER_PLACEABLE = register("nether_clover_placeable");
  public static final TagKey<@NotNull Block> SHINGLES = register("shingles");
  public static final TagKey<@NotNull Block> TERRACOTTA_BRICKS = register("terracotta_bricks");
  public static final TagKey<@NotNull Block> TERRACOTTA_TILES = register("terracotta_tiles");
  public static final TagKey<@NotNull Block> LARKSPUR_PLACEABLE = register("larkspur_placeable");

  public static void init() {}

  private static TagKey<@NotNull Block> register(String path) {
    return SomeMoreBlocks.tagKey(Registries.BLOCK, path);
  }
}
