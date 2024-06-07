package net.seface.moreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class MBBlockTags extends MoreBlocksTags {
  public static final TagKey<Block> CATTAIL_PLACEABLE = register(Registries.BLOCK, "cattail_placeable");
  public static final TagKey<Block> CONCRETE_BRICKS = register(Registries.BLOCK, "concrete_bricks");
  public static final TagKey<Block> CONCRETE_TILES = register(Registries.BLOCK, "concrete_tiles");
  public static final TagKey<Block> DUNE_GRASS_PLACEABLE = register(Registries.BLOCK, "dune_grass_placeable");
  public static final TagKey<Block> MUSHROOM_COLONY_PLACEABLE = register(Registries.BLOCK, "mushroom_colony_placeable");
  public static final TagKey<Block> SHINGLES = register(Registries.BLOCK, "shingles");
  public static final TagKey<Block> TERRACOTTA_BRICKS = register(Registries.BLOCK, "terracotta_bricks");
  public static final TagKey<Block> TERRACOTTA_TILES = register(Registries.BLOCK, "terracotta_tiles");
  public static final TagKey<Block> TINY_CACTUS_PLACEABLE = register(Registries.BLOCK, "tiny_cactus_placeable");

  private MBBlockTags() {}
}
