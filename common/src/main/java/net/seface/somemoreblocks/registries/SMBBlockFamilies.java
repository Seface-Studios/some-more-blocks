package net.seface.somemoreblocks.registries;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class SMBBlockFamilies {
  private static final Map<Block, BlockFamily> BLOCK_FAMILIES = Maps.newHashMap();

  public static final BlockFamily ACACIA_MOSAIC = register(SMBBlocks.ACACIA_MOSAIC.get()).stairs(SMBBlocks.ACACIA_MOSAIC_STAIRS.get()).slab(SMBBlocks.ACACIA_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily BIRCH_MOSAIC = register(SMBBlocks.BIRCH_MOSAIC.get()).stairs(SMBBlocks.BIRCH_MOSAIC_STAIRS.get()).slab(SMBBlocks.BIRCH_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily CHERRY_MOSAIC = register(SMBBlocks.CHERRY_MOSAIC.get()).stairs(SMBBlocks.CHERRY_MOSAIC_STAIRS.get()).slab(SMBBlocks.CHERRY_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily CRIMSON_MOSAIC = register(SMBBlocks.CRIMSON_MOSAIC.get()).stairs(SMBBlocks.CRIMSON_MOSAIC_STAIRS.get()).slab(SMBBlocks.CRIMSON_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily DARK_OAK_MOSAIC = register(SMBBlocks.DARK_OAK_MOSAIC.get()).stairs(SMBBlocks.DARK_OAK_MOSAIC_STAIRS.get()).slab(SMBBlocks.DARK_OAK_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily JUNGLE_MOSAIC = register(SMBBlocks.JUNGLE_MOSAIC.get()).stairs(SMBBlocks.JUNGLE_MOSAIC_STAIRS.get()).slab(SMBBlocks.JUNGLE_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily MANGROVE_MOSAIC = register(SMBBlocks.MANGROVE_MOSAIC.get()).stairs(SMBBlocks.MANGROVE_MOSAIC_STAIRS.get()).slab(SMBBlocks.MANGROVE_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily OAK_MOSAIC = register(SMBBlocks.OAK_MOSAIC.get()).stairs(SMBBlocks.OAK_MOSAIC_STAIRS.get()).slab(SMBBlocks.OAK_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily PALE_OAK_MOSAIC = register(SMBBlocks.PALE_OAK_MOSAIC.get()).stairs(SMBBlocks.PALE_OAK_MOSAIC_STAIRS.get()).slab(SMBBlocks.PALE_OAK_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily SPRUCE_MOSAIC = register(SMBBlocks.SPRUCE_MOSAIC.get()).stairs(SMBBlocks.SPRUCE_MOSAIC_STAIRS.get()).slab(SMBBlocks.SPRUCE_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily WARPED_MOSAIC = register(SMBBlocks.WARPED_MOSAIC.get()).stairs(SMBBlocks.WARPED_MOSAIC_STAIRS.get()).slab(SMBBlocks.WARPED_MOSAIC_SLAB.get()).getFamily();
  public static final BlockFamily POLISHED_STONE = register(SMBBlocks.POLISHED_STONE.get()).stairs(SMBBlocks.POLISHED_STONE_STAIRS.get()).slab(SMBBlocks.POLISHED_STONE_SLAB.get()).getFamily();
  public static final BlockFamily STONE_TILES = register(SMBBlocks.STONE_TILES.get()).cracked(SMBBlocks.CRACKED_STONE_TILES.get()).stairs(SMBBlocks.STONE_TILE_STAIRS.get()).slab(SMBBlocks.STONE_TILE_SLAB.get()).wall(SMBBlocks.STONE_TILE_WALL.get()).getFamily();
  public static final BlockFamily GRANITE_BRICKS = register(SMBBlocks.GRANITE_BRICKS.get()).chiseled(SMBBlocks.CHISELED_GRANITE_BRICKS.get()).cracked(SMBBlocks.CRACKED_GRANITE_BRICKS.get()).stairs(SMBBlocks.GRANITE_BRICK_STAIRS.get()).slab(SMBBlocks.GRANITE_BRICK_SLAB.get()).wall(SMBBlocks.GRANITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily GRANITE_TILES = register(SMBBlocks.GRANITE_TILES.get()).cracked(SMBBlocks.CRACKED_GRANITE_TILES.get()).stairs(SMBBlocks.GRANITE_TILE_STAIRS.get()).slab(SMBBlocks.GRANITE_TILE_SLAB.get()).wall(SMBBlocks.GRANITE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_GRANITE_BRICKS = register(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).stairs(SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_GRANITE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_GRANITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_GRANITE = register(SMBBlocks.SMOOTH_GRANITE.get()).slab(SMBBlocks.SMOOTH_GRANITE_SLAB.get()).getFamily();
  public static final BlockFamily DIORITE_BRICKS = register(SMBBlocks.DIORITE_BRICKS.get()).chiseled(SMBBlocks.CHISELED_DIORITE_BRICKS.get()).cracked(SMBBlocks.CRACKED_DIORITE_BRICKS.get()).stairs(SMBBlocks.DIORITE_BRICK_STAIRS.get()).slab(SMBBlocks.DIORITE_BRICK_SLAB.get()).wall(SMBBlocks.DIORITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily DIORITE_TILES = register(SMBBlocks.DIORITE_TILES.get()).cracked(SMBBlocks.CRACKED_DIORITE_TILES.get()).stairs(SMBBlocks.DIORITE_TILE_STAIRS.get()).slab(SMBBlocks.DIORITE_TILE_SLAB.get()).wall(SMBBlocks.DIORITE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_DIORITE_BRICKS = register(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).stairs(SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_DIORITE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_DIORITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_DIORITE = register(SMBBlocks.SMOOTH_DIORITE.get()).slab(SMBBlocks.SMOOTH_DIORITE_SLAB.get()).getFamily();
  public static final BlockFamily ANDESITE_BRICKS = register(SMBBlocks.ANDESITE_BRICKS.get()).chiseled(SMBBlocks.CHISELED_ANDESITE_BRICKS.get()).cracked(SMBBlocks.CRACKED_ANDESITE_BRICKS.get()).stairs(SMBBlocks.ANDESITE_BRICK_STAIRS.get()).slab(SMBBlocks.ANDESITE_BRICK_SLAB.get()).wall(SMBBlocks.ANDESITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily ANDESITE_TILES = register(SMBBlocks.ANDESITE_TILES.get()).cracked(SMBBlocks.CRACKED_ANDESITE_TILES.get()).stairs(SMBBlocks.ANDESITE_TILE_STAIRS.get()).slab(SMBBlocks.ANDESITE_TILE_SLAB.get()).wall(SMBBlocks.ANDESITE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_ANDESITE_BRICKS = register(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).stairs(SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_ANDESITE = register(SMBBlocks.SMOOTH_ANDESITE.get()).slab(SMBBlocks.SMOOTH_ANDESITE_SLAB.get()).getFamily();
  public static final BlockFamily MOSSY_DEEPSLATE_BRICKS = register(SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get()).stairs(SMBBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_DEEPSLATE = register(SMBBlocks.SMOOTH_DEEPSLATE.get()).slab(SMBBlocks.SMOOTH_DEEPSLATE_SLAB.get()).getFamily();
  public static final BlockFamily POLISHED_CALCITE = register(SMBBlocks.POLISHED_CALCITE.get()).stairs(SMBBlocks.POLISHED_CALCITE_STAIRS.get()).slab(SMBBlocks.POLISHED_CALCITE_SLAB.get()).getFamily();
  public static final BlockFamily CALCITE_BRICKS = register(SMBBlocks.CALCITE_BRICKS.get()).chiseled(SMBBlocks.CHISELED_CALCITE_BRICKS.get()).cracked(SMBBlocks.CRACKED_CALCITE_BRICKS.get()).stairs(SMBBlocks.CALCITE_BRICK_STAIRS.get()).slab(SMBBlocks.CALCITE_BRICK_SLAB.get()).wall(SMBBlocks.CALCITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily CALCITE_TILES = register(SMBBlocks.CALCITE_TILES.get()).cracked(SMBBlocks.CRACKED_CALCITE_TILES.get()).stairs(SMBBlocks.CALCITE_TILE_STAIRS.get()).slab(SMBBlocks.CALCITE_TILE_SLAB.get()).wall(SMBBlocks.CALCITE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_CALCITE_BRICKS = register(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).stairs(SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_CALCITE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_CALCITE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_CALCITE = register(SMBBlocks.SMOOTH_CALCITE.get()).slab(SMBBlocks.SMOOTH_CALCITE_SLAB.get()).getFamily();
  public static final BlockFamily TUFF_TILES = register(SMBBlocks.TUFF_TILES.get()).cracked(SMBBlocks.CRACKED_TUFF_TILES.get()).stairs(SMBBlocks.TUFF_TILE_STAIRS.get()).slab(SMBBlocks.TUFF_TILE_SLAB.get()).wall(SMBBlocks.TUFF_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_TUFF_BRICKS = register(SMBBlocks.MOSSY_TUFF_BRICKS.get()).stairs(SMBBlocks.MOSSY_TUFF_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_TUFF_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_TUFF_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_TUFF = register(SMBBlocks.SMOOTH_TUFF.get()).slab(SMBBlocks.SMOOTH_TUFF_SLAB.get()).getFamily();
  public static final BlockFamily POLISHED_DRIPSTONE = register(SMBBlocks.POLISHED_DRIPSTONE.get()).stairs(SMBBlocks.POLISHED_DRIPSTONE_STAIRS.get()).slab(SMBBlocks.POLISHED_DRIPSTONE_SLAB.get()).getFamily();
  public static final BlockFamily DRIPSTONE_BRICKS = register(SMBBlocks.DRIPSTONE_BRICKS.get()).chiseled(SMBBlocks.CHISELED_DRIPSTONE_BRICKS.get()).cracked(SMBBlocks.CRACKED_DRIPSTONE_BRICKS.get()).stairs(SMBBlocks.DRIPSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.DRIPSTONE_BRICK_SLAB.get()).wall(SMBBlocks.DRIPSTONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily DRIPSTONE_TILES = register(SMBBlocks.DRIPSTONE_TILES.get()).cracked(SMBBlocks.CRACKED_DRIPSTONE_TILES.get()).stairs(SMBBlocks.DRIPSTONE_TILE_STAIRS.get()).slab(SMBBlocks.DRIPSTONE_TILE_SLAB.get()).wall(SMBBlocks.DRIPSTONE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_DRIPSTONE_BRICKS = register(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).stairs(SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_DRIPSTONE = register(SMBBlocks.SMOOTH_DRIPSTONE.get()).slab(SMBBlocks.SMOOTH_DRIPSTONE_SLAB.get()).getFamily();
  public static final BlockFamily MOSSY_BRICKS = register(SMBBlocks.MOSSY_BRICKS.get()).stairs(SMBBlocks.MOSSY_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_BRICK_WALL.get()).getFamily();
  public static final BlockFamily POLISHED_MUD = register(SMBBlocks.POLISHED_MUD.get()).stairs(SMBBlocks.POLISHED_MUD_STAIRS.get()).slab(SMBBlocks.POLISHED_MUD_SLAB.get()).getFamily();
  public static final BlockFamily MUD_TILES = register(SMBBlocks.MUD_TILES.get()).cracked(SMBBlocks.CRACKED_MUD_TILES.get()).stairs(SMBBlocks.MUD_TILE_STAIRS.get()).slab(SMBBlocks.MUD_TILE_SLAB.get()).wall(SMBBlocks.MUD_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_MUD_BRICKS = register(SMBBlocks.MOSSY_MUD_BRICKS.get()).stairs(SMBBlocks.MOSSY_MUD_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_MUD_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_MUD_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_MUD = register(SMBBlocks.SMOOTH_MUD.get()).slab(SMBBlocks.SMOOTH_MUD_SLAB.get()).getFamily();

  /* Testing */

  public static void init() {}

  /**
   * Literally a copy & paste of {@link net.minecraft.data.BlockFamilies#familyBuilder(Block) BlockFamilies#familyBuilder} method.
   * @param parent The main block of the family.
   */
  private static BlockFamily.Builder register(Block parent) {
    BlockFamily.Builder builder = new BlockFamily.Builder(parent);
    BlockFamily family = BLOCK_FAMILIES.put(parent, builder.getFamily());
    if (family != null) {
      throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(parent));
    } else {
      return builder;
    }
  }
}
