package net.seface.somemoreblocks.registries;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * This is <b>only used for Data Generation</b> and should not be implemented in other part of the code.
 * We are not using BlockFamilies for all Mod Loaders 'cause it's annoying to register for multiple loaders.
 * <br /><br />
 * Are you a dev want to implement a PlatformRegistryObject for this? Feel free to make a PR!
 */
@Deprecated
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
  public static final BlockFamily SANDSTONE_BRICKS = register(SMBBlocks.SANDSTONE_BRICKS.get()).cracked(SMBBlocks.CRACKED_SANDSTONE_BRICKS.get()).stairs(SMBBlocks.SANDSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.SANDSTONE_BRICK_SLAB.get()).wall(SMBBlocks.SANDSTONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SANDSTONE_TILES = register(SMBBlocks.SANDSTONE_TILES.get()).cracked(SMBBlocks.CRACKED_SANDSTONE_TILES.get()).stairs(SMBBlocks.SANDSTONE_TILE_STAIRS.get()).slab(SMBBlocks.SANDSTONE_TILE_SLAB.get()).wall(SMBBlocks.SANDSTONE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_SANDSTONE_BRICKS = register(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get()).stairs(SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily RED_SANDSTONE_BRICKS = register(SMBBlocks.RED_SANDSTONE_BRICKS.get()).cracked(SMBBlocks.CRACKED_RED_SANDSTONE_BRICKS.get()).stairs(SMBBlocks.RED_SANDSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.RED_SANDSTONE_BRICK_SLAB.get()).wall(SMBBlocks.RED_SANDSTONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily RED_SANDSTONE_TILES = register(SMBBlocks.RED_SANDSTONE_TILES.get()).cracked(SMBBlocks.CRACKED_RED_SANDSTONE_TILES.get()).stairs(SMBBlocks.RED_SANDSTONE_TILE_STAIRS.get()).slab(SMBBlocks.RED_SANDSTONE_TILE_SLAB.get()).wall(SMBBlocks.RED_SANDSTONE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_RED_SANDSTONE_BRICKS = register(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get()).stairs(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily POLISHED_PRISMARINE = register(SMBBlocks.POLISHED_PRISMARINE.get()).stairs(SMBBlocks.POLISHED_PRISMARINE_STAIRS.get()).slab(SMBBlocks.POLISHED_PRISMARINE_SLAB.get()).getFamily();
  public static final BlockFamily PRISMARINE_TILES = register(SMBBlocks.PRISMARINE_TILES.get()).cracked(SMBBlocks.CRACKED_PRISMARINE_TILES.get()).stairs(SMBBlocks.PRISMARINE_TILE_STAIRS.get()).slab(SMBBlocks.PRISMARINE_TILE_SLAB.get()).wall(SMBBlocks.PRISMARINE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_PRISMARINE_BRICKS = register(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get()).stairs(SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_PRISMARINE = register(SMBBlocks.SMOOTH_PRISMARINE.get()).slab(SMBBlocks.SMOOTH_PRISMARINE_SLAB.get()).getFamily();
  public static final BlockFamily POLISHED_BASALT_BRICKS = register(SMBBlocks.POLISHED_BASALT_BRICKS.get()).cracked(SMBBlocks.CRACKED_POLISHED_BASALT_BRICKS.get()).stairs(SMBBlocks.POLISHED_BASALT_BRICK_STAIRS.get()).slab(SMBBlocks.POLISHED_BASALT_BRICK_SLAB.get()).wall(SMBBlocks.POLISHED_BASALT_BRICK_WALL.get()).chiseled(SMBBlocks.CHISELED_POLISHED_BASALT_BRICKS.get()).getFamily();
  public static final BlockFamily POLISHED_BASALT_TILES = register(SMBBlocks.POLISHED_BASALT_TILES.get()).cracked(SMBBlocks.CRACKED_POLISHED_BASALT_TILES.get()).stairs(SMBBlocks.POLISHED_BASALT_TILE_STAIRS.get()).slab(SMBBlocks.POLISHED_BASALT_TILE_SLAB.get()).wall(SMBBlocks.POLISHED_BASALT_TILE_WALL.get()).getFamily();
  public static final BlockFamily CORRUPTED_POLISHED_BASALT_BRICKS = register(SMBBlocks.CORRUPTED_POLISHED_BASALT_BRICKS.get()).stairs(SMBBlocks.CORRUPTED_POLISHED_BASALT_BRICK_STAIRS.get()).slab(SMBBlocks.CORRUPTED_POLISHED_BASALT_BRICK_SLAB.get()).wall(SMBBlocks.CORRUPTED_POLISHED_BASALT_BRICK_WALL.get()).getFamily();
  public static final BlockFamily POLISHED_BLACKSTONE_TILES = register(SMBBlocks.POLISHED_BLACKSTONE_TILES.get()).cracked(SMBBlocks.CRACKED_POLISHED_BLACKSTONE_TILES.get()).stairs(SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS.get()).slab(SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB.get()).wall(SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.get()).getFamily();
  public static final BlockFamily CORRUPTED_POLISHED_BLACKSTONE_BRICKS = register(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get()).stairs(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get()).wall(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_BLACKSTONE = register(SMBBlocks.SMOOTH_BLACKSTONE.get()).slab(SMBBlocks.SMOOTH_BLACKSTONE_SLAB.get()).getFamily();
  public static final BlockFamily POLISHED_END_STONE = register(SMBBlocks.POLISHED_END_STONE.get()).stairs(SMBBlocks.POLISHED_END_STONE_STAIRS.get()).slab(SMBBlocks.POLISHED_END_STONE_SLAB.get()).getFamily();
  public static final BlockFamily END_STONE_TILES = register(SMBBlocks.END_STONE_TILES.get()).cracked(SMBBlocks.CRACKED_END_STONE_TILES.get()).stairs(SMBBlocks.END_STONE_TILE_STAIRS.get()).slab(SMBBlocks.END_STONE_TILE_SLAB.get()).wall(SMBBlocks.END_STONE_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_END_STONE_BRICKS = register(SMBBlocks.MOSSY_END_STONE_BRICKS.get()).stairs(SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS.get()).slab(SMBBlocks.MOSSY_END_STONE_BRICK_SLAB.get()).wall(SMBBlocks.MOSSY_END_STONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_END_STONE = register(SMBBlocks.SMOOTH_END_STONE.get()).slab(SMBBlocks.SMOOTH_END_STONE_SLAB.get()).getFamily();
  public static final BlockFamily POLISHED_PURPUR = register(SMBBlocks.POLISHED_PURPUR.get()).stairs(SMBBlocks.POLISHED_PURPUR_STAIRS.get()).slab(SMBBlocks.POLISHED_PURPUR_SLAB.get()).getFamily();
  public static final BlockFamily PURPUR_TILES = register(SMBBlocks.PURPUR_TILES.get()).cracked(SMBBlocks.CRACKED_PURPUR_TILES.get()).stairs(SMBBlocks.PURPUR_TILE_STAIRS.get()).slab(SMBBlocks.PURPUR_TILE_SLAB.get()).wall(SMBBlocks.PURPUR_TILE_WALL.get()).getFamily();
  public static final BlockFamily MOSSY_PURPUR_BLOCK = register(SMBBlocks.MOSSY_PURPUR_BLOCK.get()).stairs(SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS.get()).slab(SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB.get()).wall(SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.get()).getFamily();
  public static final BlockFamily SMOOTH_PURPUR = register(SMBBlocks.SMOOTH_PURPUR.get()).slab(SMBBlocks.SMOOTH_PURPUR_SLAB.get()).getFamily();
  public static final BlockFamily COAL_BRICKS = register(SMBBlocks.COAL_BRICKS.get()).cracked(SMBBlocks.CRACKED_COAL_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_COAL = register(SMBBlocks.CUT_COAL.get()).cracked(SMBBlocks.CRACKED_CUT_COAL.get()).getFamily();
  public static final BlockFamily IRON_BRICKS = register(SMBBlocks.IRON_BRICKS.get()).cracked(SMBBlocks.CRACKED_IRON_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_IRON = register(SMBBlocks.CUT_IRON.get()).cracked(SMBBlocks.CRACKED_CUT_IRON.get()).getFamily();
  public static final BlockFamily GOLD_BRICKS = register(SMBBlocks.GOLD_BRICKS.get()).cracked(SMBBlocks.CRACKED_GOLD_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_GOLD = register(SMBBlocks.CUT_GOLD.get()).cracked(SMBBlocks.CRACKED_CUT_GOLD.get()).getFamily();
  public static final BlockFamily REDSTONE_BRICKS = register(SMBBlocks.REDSTONE_BRICKS.get()).cracked(SMBBlocks.CRACKED_REDSTONE_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_REDSTONE = register(SMBBlocks.CUT_REDSTONE.get()).cracked(SMBBlocks.CRACKED_CUT_REDSTONE.get()).getFamily();
  public static final BlockFamily EMERALD_BRICKS = register(SMBBlocks.EMERALD_BRICKS.get()).cracked(SMBBlocks.CRACKED_EMERALD_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_EMERALD = register(SMBBlocks.CUT_EMERALD.get()).cracked(SMBBlocks.CRACKED_CUT_EMERALD.get()).getFamily();
  public static final BlockFamily LAPIS_BRICKS = register(SMBBlocks.LAPIS_BRICKS.get()).cracked(SMBBlocks.CRACKED_LAPIS_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_LAPIS = register(SMBBlocks.CUT_LAPIS.get()).cracked(SMBBlocks.CRACKED_CUT_LAPIS.get()).getFamily();
  public static final BlockFamily DIAMOND_BRICKS = register(SMBBlocks.DIAMOND_BRICKS.get()).cracked(SMBBlocks.CRACKED_DIAMOND_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_DIAMOND = register(SMBBlocks.CUT_DIAMOND.get()).cracked(SMBBlocks.CRACKED_CUT_DIAMOND.get()).getFamily();
  public static final BlockFamily NETHERITE_BRICKS = register(SMBBlocks.NETHERITE_BRICKS.get()).cracked(SMBBlocks.CRACKED_NETHERITE_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_NETHERITE = register(SMBBlocks.CUT_NETHERITE.get()).cracked(SMBBlocks.CRACKED_CUT_NETHERITE.get()).getFamily();
  public static final BlockFamily CUT_QUARTZ = register(SMBBlocks.CUT_QUARTZ.get()).cracked(SMBBlocks.CRACKED_CUT_QUARTZ.get()).getFamily();
  public static final BlockFamily AMETHYST_BRICKS = register(SMBBlocks.AMETHYST_BRICKS.get()).cracked(SMBBlocks.CRACKED_AMETHYST_BRICKS.get()).getFamily();
  public static final BlockFamily CUT_AMETHYST = register(SMBBlocks.CUT_AMETHYST.get()).cracked(SMBBlocks.CRACKED_CUT_AMETHYST.get()).getFamily();
  public static final BlockFamily COPPER_BRICKS = register(SMBBlocks.COPPER_BRICKS.get()).cracked(SMBBlocks.CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily EXPOSED_COPPER_BRICKS = register(SMBBlocks.EXPOSED_COPPER_BRICKS.get()).cracked(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily WEATHERED_COPPER_BRICKS = register(SMBBlocks.WEATHERED_COPPER_BRICKS.get()).cracked(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily OXIDIZED_COPPER_BRICKS = register(SMBBlocks.OXIDIZED_COPPER_BRICKS.get()).cracked(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily WAXED_COPPER_BRICKS = register(SMBBlocks.WAXED_COPPER_BRICKS.get()).cracked(SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily WAXED_EXPOSED_COPPER_BRICKS = register(SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get()).cracked(SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily WAXED_WEATHERED_COPPER_BRICKS = register(SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get()).cracked(SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily WAXED_OXIDIZED_COPPER_BRICKS = register(SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get()).cracked(SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get()).dontGenerateModel().getFamily();
  public static final BlockFamily BONE_BRICKS = register(SMBBlocks.BONE_BRICKS.get()).cracked(SMBBlocks.CRACKED_BONE_BRICKS.get()).stairs(SMBBlocks.BONE_BRICK_STAIRS.get()).slab(SMBBlocks.BONE_BRICK_SLAB.get()).wall(SMBBlocks.BONE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily BONE_TILES = register(SMBBlocks.BONE_TILES.get()).cracked(SMBBlocks.CRACKED_BONE_TILES.get()).stairs(SMBBlocks.BONE_TILE_STAIRS.get()).slab(SMBBlocks.BONE_TILE_SLAB.get()).wall(SMBBlocks.BONE_TILE_WALL.get()).getFamily();
  public static final BlockFamily SOUL_SANDSTONE = register(SMBBlocks.SOUL_SANDSTONE.get()).stairs(SMBBlocks.SOUL_SANDSTONE_STAIRS.get()).slab(SMBBlocks.SOUL_SANDSTONE_SLAB.get()).wall(SMBBlocks.SOUL_SANDSTONE_WALL.get()).cut(SMBBlocks.CUT_SOUL_SANDSTONE.get()).dontGenerateModel().getFamily();
  public static final BlockFamily SOUL_SANDSTONE_BRICKS = register(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).cracked(SMBBlocks.CRACKED_SOUL_SANDSTONE_BRICKS.get()).stairs(SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS.get()).slab(SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB.get()).wall(SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get()).dontGenerateModel().getFamily();
  public static final BlockFamily SOUL_SANDSTONE_TILES = register(SMBBlocks.SOUL_SANDSTONE_TILES.get()).cracked(SMBBlocks.CRACKED_SOUL_SANDSTONE_TILES.get()).stairs(SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS.get()).slab(SMBBlocks.SOUL_SANDSTONE_TILE_SLAB.get()).wall(SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get()).dontGenerateModel().getFamily();
  public static final BlockFamily SMOOTH_SOUL_SANDSTONE = register(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get()).stairs(SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get()).slab(SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get()).dontGenerateModel().getFamily();
  public static final BlockFamily CUT_SOUL_SANDSTONE = register(SMBBlocks.CUT_SOUL_SANDSTONE.get()).slab(SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.get()).dontGenerateModel().getFamily();
  public static final BlockFamily PACKED_SNOW = register(SMBBlocks.PACKED_SNOW.get()).stairs(SMBBlocks.PACKED_SNOW_STAIRS.get()).slab(SMBBlocks.PACKED_SNOW_SLAB.get()).getFamily();
  public static final BlockFamily POLISHED_SNOW = register(SMBBlocks.POLISHED_SNOW.get()).stairs(SMBBlocks.POLISHED_SNOW_STAIRS.get()).slab(SMBBlocks.POLISHED_SNOW_SLAB.get()).getFamily();
  public static final BlockFamily SNOW_BRICKS = register(SMBBlocks.SNOW_BRICKS.get()).cracked(SMBBlocks.CRACKED_SNOW_BRICKS.get()).stairs(SMBBlocks.SNOW_BRICK_STAIRS.get()).slab(SMBBlocks.SNOW_BRICK_SLAB.get()).wall(SMBBlocks.SNOW_BRICK_WALL.get()).getFamily();
  public static final BlockFamily SNOW_TILES = register(SMBBlocks.SNOW_TILES.get()).cracked(SMBBlocks.CRACKED_SNOW_TILES.get()).stairs(SMBBlocks.SNOW_TILE_STAIRS.get()).slab(SMBBlocks.SNOW_TILE_SLAB.get()).wall(SMBBlocks.SNOW_TILE_WALL.get()).getFamily();
  public static final BlockFamily POLISHED_ICE = register(SMBBlocks.POLISHED_ICE.get()).stairs(SMBBlocks.POLISHED_ICE_STAIRS.get()).slab(SMBBlocks.POLISHED_ICE_SLAB.get()).getFamily();
  public static final BlockFamily ICE_BRICKS = register(SMBBlocks.ICE_BRICKS.get()).cracked(SMBBlocks.CRACKED_ICE_BRICKS.get()).stairs(SMBBlocks.ICE_BRICK_STAIRS.get()).slab(SMBBlocks.ICE_BRICK_SLAB.get()).wall(SMBBlocks.ICE_BRICK_WALL.get()).getFamily();
  public static final BlockFamily ICE_TILES = register(SMBBlocks.ICE_TILES.get()).cracked(SMBBlocks.CRACKED_ICE_TILES.get()).stairs(SMBBlocks.ICE_TILE_STAIRS.get()).slab(SMBBlocks.ICE_TILE_SLAB.get()).wall(SMBBlocks.ICE_TILE_WALL.get()).getFamily();

  public static final BlockFamily SHINGLES = register(SMBBlocks.SHINGLES.get()).stairs(SMBBlocks.SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily WHITE_SHINGLES = register(SMBBlocks.WHITE_SHINGLES.get()).stairs(SMBBlocks.WHITE_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily LIGHT_GRAY_SHINGLES = register(SMBBlocks.LIGHT_GRAY_SHINGLES.get()).stairs(SMBBlocks.LIGHT_GRAY_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily GRAY_SHINGLES = register(SMBBlocks.GRAY_SHINGLES.get()).stairs(SMBBlocks.GRAY_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily BLACK_SHINGLES = register(SMBBlocks.BLACK_SHINGLES.get()).stairs(SMBBlocks.BLACK_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily BROWN_SHINGLES = register(SMBBlocks.BROWN_SHINGLES.get()).stairs(SMBBlocks.BROWN_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily RED_SHINGLES = register(SMBBlocks.RED_SHINGLES.get()).stairs(SMBBlocks.RED_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily ORANGE_SHINGLES = register(SMBBlocks.ORANGE_SHINGLES.get()).stairs(SMBBlocks.ORANGE_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily YELLOW_SHINGLES = register(SMBBlocks.YELLOW_SHINGLES.get()).stairs(SMBBlocks.YELLOW_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily LIME_SHINGLES = register(SMBBlocks.LIME_SHINGLES.get()).stairs(SMBBlocks.LIME_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily GREEN_SHINGLES = register(SMBBlocks.GREEN_SHINGLES.get()).stairs(SMBBlocks.GREEN_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily CYAN_SHINGLES = register(SMBBlocks.CYAN_SHINGLES.get()).stairs(SMBBlocks.CYAN_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily LIGHT_BLUE_SHINGLES = register(SMBBlocks.LIGHT_BLUE_SHINGLES.get()).stairs(SMBBlocks.LIGHT_BLUE_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily BLUE_SHINGLES = register(SMBBlocks.BLUE_SHINGLES.get()).stairs(SMBBlocks.BLUE_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily PURPLE_SHINGLES = register(SMBBlocks.PURPLE_SHINGLES.get()).stairs(SMBBlocks.PURPLE_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily MAGENTA_SHINGLES = register(SMBBlocks.MAGENTA_SHINGLES.get()).stairs(SMBBlocks.MAGENTA_SHINGLES_STAIRS.get()).getFamily();
  public static final BlockFamily PINK_SHINGLES = register(SMBBlocks.PINK_SHINGLES.get()).stairs(SMBBlocks.PINK_SHINGLES_STAIRS.get()).getFamily();

  public static void init() {}

  public static Map<Block, BlockFamily> getAllFamilies() {
    return BLOCK_FAMILIES;
  }

  @Nullable
  public static BlockFamily getByBaseBlock(Block block) {
    for (Map.Entry<Block, BlockFamily> blockFamily : getAllFamilies().entrySet()) {
      if (blockFamily.getValue().getBaseBlock() == block) {
        return blockFamily.getValue();
      }
    }

    return null;
  }

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
