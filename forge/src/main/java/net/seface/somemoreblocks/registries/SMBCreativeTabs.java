package net.seface.somemoreblocks.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.utils.SMBUtils;

public class SMBCreativeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SomeMoreBlocks.ID);

  private static final RegistryObject<CreativeModeTab> MORE_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("more_building_blocks", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
    .icon(() -> SMBBlocks.MOSSY_BRICKS.get().asItem().getDefaultInstance())
    .title(Component.translatable("itemGroup.somemoreblocks.buildingBlocks"))
    .displayItems((ctx, entry) -> {

      entry.accept(SMBBlocks.CARVED_OAK_LOG.get());
      entry.accept(SMBBlocks.CARVED_OAK_WOOD.get());
      entry.accept(SMBBlocks.OAK_MOSAIC.get());
      entry.accept(SMBBlocks.OAK_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.OAK_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_SPRUCE_LOG.get());
      entry.accept(SMBBlocks.CARVED_SPRUCE_WOOD.get());
      entry.accept(SMBBlocks.SPRUCE_MOSAIC.get());
      entry.accept(SMBBlocks.SPRUCE_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.SPRUCE_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_BIRCH_LOG.get());
      entry.accept(SMBBlocks.CARVED_BIRCH_WOOD.get());
      entry.accept(SMBBlocks.BIRCH_MOSAIC.get());
      entry.accept(SMBBlocks.BIRCH_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.BIRCH_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_JUNGLE_LOG.get());
      entry.accept(SMBBlocks.CARVED_JUNGLE_WOOD.get());
      entry.accept(SMBBlocks.JUNGLE_MOSAIC.get());
      entry.accept(SMBBlocks.JUNGLE_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.JUNGLE_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_ACACIA_LOG.get());
      entry.accept(SMBBlocks.CARVED_ACACIA_WOOD.get());
      entry.accept(SMBBlocks.ACACIA_MOSAIC.get());
      entry.accept(SMBBlocks.ACACIA_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.ACACIA_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_DARK_OAK_LOG.get());
      entry.accept(SMBBlocks.CARVED_DARK_OAK_WOOD.get());
      entry.accept(SMBBlocks.DARK_OAK_MOSAIC.get());
      entry.accept(SMBBlocks.DARK_OAK_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.DARK_OAK_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_MANGROVE_LOG.get());
      entry.accept(SMBBlocks.CARVED_MANGROVE_WOOD.get());
      entry.accept(SMBBlocks.MANGROVE_MOSAIC.get());
      entry.accept(SMBBlocks.MANGROVE_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.MANGROVE_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_CRIMSON_STEM.get());
      entry.accept(SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
      entry.accept(SMBBlocks.CRIMSON_MOSAIC.get());
      entry.accept(SMBBlocks.CRIMSON_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.CRIMSON_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_WARPED_STEM.get());
      entry.accept(SMBBlocks.CARVED_WARPED_HYPHAE.get());
      entry.accept(SMBBlocks.WARPED_MOSAIC.get());
      entry.accept(SMBBlocks.WARPED_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.WARPED_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_CHERRY_LOG.get());
      entry.accept(SMBBlocks.CARVED_CHERRY_WOOD.get());
      entry.accept(SMBBlocks.CHERRY_MOSAIC.get());
      entry.accept(SMBBlocks.CHERRY_MOSAIC_STAIRS.get());
      entry.accept(SMBBlocks.CHERRY_MOSAIC_SLAB.get());
      entry.accept(SMBBlocks.CARVED_BAMBOO_BLOCK.get());
      entry.accept(SMBBlocks.POLISHED_STONE.get());
      entry.accept(SMBBlocks.POLISHED_STONE_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_STONE_SLAB.get());
      entry.accept(SMBBlocks.STONE_PILLAR.get());
      entry.accept(SMBBlocks.STONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_STONE_TILES.get());
      entry.accept(SMBBlocks.STONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.STONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.STONE_TILE_WALL.get());
      entry.accept(SMBBlocks.CHISELED_GRANITE_BRICKS.get());
      entry.accept(SMBBlocks.GRANITE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_GRANITE_BRICKS.get());
      entry.accept(SMBBlocks.GRANITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.GRANITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.GRANITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.GRANITE_PILLAR.get());
      entry.accept(SMBBlocks.GRANITE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_GRANITE_TILES.get());
      entry.accept(SMBBlocks.GRANITE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.GRANITE_TILE_SLAB.get());
      entry.accept(SMBBlocks.GRANITE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_GRANITE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_GRANITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_GRANITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_GRANITE.get());
      entry.accept(SMBBlocks.SMOOTH_GRANITE_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_DIORITE_BRICKS.get());
      entry.accept(SMBBlocks.DIORITE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_DIORITE_BRICKS.get());
      entry.accept(SMBBlocks.DIORITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.DIORITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.DIORITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.DIORITE_PILLAR.get());
      entry.accept(SMBBlocks.DIORITE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_DIORITE_TILES.get());
      entry.accept(SMBBlocks.DIORITE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.DIORITE_TILE_SLAB.get());
      entry.accept(SMBBlocks.DIORITE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_DIORITE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_DIORITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_DIORITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_DIORITE.get());
      entry.accept(SMBBlocks.SMOOTH_DIORITE_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_ANDESITE_BRICKS.get());
      entry.accept(SMBBlocks.ANDESITE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_ANDESITE_BRICKS.get());
      entry.accept(SMBBlocks.ANDESITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.ANDESITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.ANDESITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.ANDESITE_PILLAR.get());
      entry.accept(SMBBlocks.ANDESITE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_ANDESITE_TILES.get());
      entry.accept(SMBBlocks.ANDESITE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.ANDESITE_TILE_SLAB.get());
      entry.accept(SMBBlocks.ANDESITE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_ANDESITE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_ANDESITE.get());
      entry.accept(SMBBlocks.SMOOTH_ANDESITE_SLAB.get());
      entry.accept(SMBBlocks.DEEPSLATE_PILLAR.get());
      entry.accept(SMBBlocks.POLISHED_CALCITE.get());
      entry.accept(SMBBlocks.POLISHED_CALCITE_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_CALCITE_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_CALCITE_BRICKS.get());
      entry.accept(SMBBlocks.CALCITE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_CALCITE_BRICKS.get());
      entry.accept(SMBBlocks.CALCITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.CALCITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.CALCITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.CALCITE_PILLAR.get());
      entry.accept(SMBBlocks.CALCITE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_CALCITE_TILES.get());
      entry.accept(SMBBlocks.CALCITE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.CALCITE_TILE_SLAB.get());
      entry.accept(SMBBlocks.CALCITE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_CALCITE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_CALCITE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_CALCITE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_CALCITE.get());
      entry.accept(SMBBlocks.SMOOTH_CALCITE_SLAB.get());
      entry.accept(SMBBlocks.CRACKED_TUFF_BRICKS.get());
      entry.accept(SMBBlocks.TUFF_PILLAR.get());
      entry.accept(SMBBlocks.TUFF_TILES.get());
      entry.accept(SMBBlocks.CRACKED_TUFF_TILES.get());
      entry.accept(SMBBlocks.TUFF_TILE_STAIRS.get());
      entry.accept(SMBBlocks.TUFF_TILE_SLAB.get());
      entry.accept(SMBBlocks.TUFF_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_TUFF_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_TUFF_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_TUFF_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_TUFF_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_TUFF.get());
      entry.accept(SMBBlocks.SMOOTH_TUFF_SLAB.get());
      entry.accept(SMBBlocks.POLISHED_DRIPSTONE.get());
      entry.accept(SMBBlocks.POLISHED_DRIPSTONE_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_DRIPSTONE_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_DRIPSTONE_BRICKS.get());
      entry.accept(SMBBlocks.DRIPSTONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_DRIPSTONE_BRICKS.get());
      entry.accept(SMBBlocks.DRIPSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.DRIPSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.DRIPSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.DRIPSTONE_PILLAR.get());
      entry.accept(SMBBlocks.DRIPSTONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_DRIPSTONE_TILES.get());
      entry.accept(SMBBlocks.DRIPSTONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.DRIPSTONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.DRIPSTONE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_DRIPSTONE.get());
      entry.accept(SMBBlocks.SMOOTH_DRIPSTONE_SLAB.get());
      entry.accept(SMBBlocks.CRACKED_BRICKS_BLOCK.get());
      entry.accept(SMBBlocks.MOSSY_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_BRICK_WALL.get());
      entry.accept(SMBBlocks.POLISHED_MUD.get());
      entry.accept(SMBBlocks.POLISHED_MUD_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_MUD_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_MUD_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_MUD_BRICKS.get());
      entry.accept(SMBBlocks.MUD_PILLAR.get());
      entry.accept(SMBBlocks.MUD_TILES.get());
      entry.accept(SMBBlocks.CRACKED_MUD_TILES.get());
      entry.accept(SMBBlocks.MUD_TILE_STAIRS.get());
      entry.accept(SMBBlocks.MUD_TILE_SLAB.get());
      entry.accept(SMBBlocks.MUD_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_MUD_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_MUD_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_MUD_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_MUD_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_MUD.get());
      entry.accept(SMBBlocks.SMOOTH_MUD_SLAB.get());
      entry.accept(SMBBlocks.SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.SANDSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.SANDSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.SANDSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SANDSTONE_PILLAR.get());
      entry.accept(SMBBlocks.SANDSTONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_SANDSTONE_TILES.get());
      entry.accept(SMBBlocks.SANDSTONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.SANDSTONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.SANDSTONE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_RED_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_PILLAR.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_RED_SANDSTONE_TILES.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.RED_SANDSTONE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.POLISHED_PRISMARINE.get());
      entry.accept(SMBBlocks.POLISHED_PRISMARINE_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_PRISMARINE_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_PRISMARINE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_PRISMARINE_BRICKS.get());
      entry.accept(SMBBlocks.PRISMARINE_PILLAR.get());
      entry.accept(SMBBlocks.PRISMARINE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_PRISMARINE_TILES.get());
      entry.accept(SMBBlocks.PRISMARINE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.PRISMARINE_TILE_SLAB.get());
      entry.accept(SMBBlocks.PRISMARINE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_PRISMARINE.get());
      entry.accept(SMBBlocks.SMOOTH_PRISMARINE_SLAB.get());
      entry.accept(SMBBlocks.NETHER_BRICKS_PILLAR.get());
      entry.accept(SMBBlocks.CRACKED_RED_NETHER_BRICKS.get());
      entry.accept(SMBBlocks.CHISELED_RED_NETHER_BRICKS.get());
      entry.accept(SMBBlocks.RED_NETHER_BRICKS_PILLAR.get());
      entry.accept(SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get());
      entry.accept(SMBBlocks.POLISHED_BLACKSTONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_POLISHED_BLACKSTONE_TILES.get());
      entry.accept(SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.get());
      entry.accept(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get());
      entry.accept(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_BLACKSTONE.get());
      entry.accept(SMBBlocks.SMOOTH_BLACKSTONE_SLAB.get());
      entry.accept(SMBBlocks.POLISHED_END_STONE.get());
      entry.accept(SMBBlocks.POLISHED_END_STONE_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_END_STONE_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_END_STONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_END_STONE_BRICKS.get());
      entry.accept(SMBBlocks.END_STONE_PILLAR.get());
      entry.accept(SMBBlocks.END_STONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_END_STONE_TILES.get());
      entry.accept(SMBBlocks.END_STONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.END_STONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.END_STONE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_END_STONE_BRICKS.get());
      entry.accept(SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_END_STONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_END_STONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_END_STONE.get());
      entry.accept(SMBBlocks.SMOOTH_END_STONE_SLAB.get());
      entry.accept(SMBBlocks.POLISHED_PURPUR.get());
      entry.accept(SMBBlocks.POLISHED_PURPUR_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_PURPUR_SLAB.get());
      entry.accept(SMBBlocks.CHISELED_PURPUR.get());
      entry.accept(SMBBlocks.CRACKED_PURPUR_BLOCK.get());
      entry.accept(SMBBlocks.PURPUR_TILES.get());
      entry.accept(SMBBlocks.CRACKED_PURPUR_TILES.get());
      entry.accept(SMBBlocks.PURPUR_TILE_STAIRS.get());
      entry.accept(SMBBlocks.PURPUR_TILE_SLAB.get());
      entry.accept(SMBBlocks.PURPUR_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_PURPUR_BLOCK.get());
      entry.accept(SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS.get());
      entry.accept(SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB.get());
      entry.accept(SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.get());
      entry.accept(SMBBlocks.SMOOTH_PURPUR.get());
      entry.accept(SMBBlocks.SMOOTH_PURPUR_SLAB.get());
      entry.accept(SMBBlocks.COAL_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_COAL_BRICKS.get());
      entry.accept(SMBBlocks.COAL_PILLAR.get());
      entry.accept(SMBBlocks.CUT_COAL.get());
      entry.accept(SMBBlocks.CRACKED_CUT_COAL.get());
      entry.accept(SMBBlocks.IRON_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_IRON_BRICKS.get());
      entry.accept(SMBBlocks.IRON_PILLAR.get());
      entry.accept(SMBBlocks.CUT_IRON.get());
      entry.accept(SMBBlocks.CRACKED_CUT_IRON.get());
      entry.accept(SMBBlocks.IRON_GRATE.get());
      entry.accept(SMBBlocks.GOLD_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_GOLD_BRICKS.get());
      entry.accept(SMBBlocks.GOLD_PILLAR.get());
      entry.accept(SMBBlocks.CUT_GOLD.get());
      entry.accept(SMBBlocks.CRACKED_CUT_GOLD.get());
      entry.accept(SMBBlocks.REDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_REDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.REDSTONE_PILLAR.get());
      entry.accept(SMBBlocks.CUT_REDSTONE.get());
      entry.accept(SMBBlocks.CRACKED_CUT_REDSTONE.get());
      entry.accept(SMBBlocks.EMERALD_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_EMERALD_BRICKS.get());
      entry.accept(SMBBlocks.EMERALD_PILLAR.get());
      entry.accept(SMBBlocks.CUT_EMERALD.get());
      entry.accept(SMBBlocks.CRACKED_CUT_EMERALD.get());
      entry.accept(SMBBlocks.LAPIS_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_LAPIS_BRICKS.get());
      entry.accept(SMBBlocks.LAPIS_PILLAR.get());
      entry.accept(SMBBlocks.CUT_LAPIS.get());
      entry.accept(SMBBlocks.CRACKED_CUT_LAPIS.get());
      entry.accept(SMBBlocks.DIAMOND_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_DIAMOND_BRICKS.get());
      entry.accept(SMBBlocks.DIAMOND_PILLAR.get());
      entry.accept(SMBBlocks.CUT_DIAMOND.get());
      entry.accept(SMBBlocks.CRACKED_CUT_DIAMOND.get());
      entry.accept(SMBBlocks.DIAMOND_GRATE.get());
      entry.accept(SMBBlocks.NETHERITE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_NETHERITE_BRICKS.get());
      entry.accept(SMBBlocks.NETHERITE_PILLAR.get());
      entry.accept(SMBBlocks.CUT_NETHERITE.get());
      entry.accept(SMBBlocks.CRACKED_CUT_NETHERITE.get());
      entry.accept(SMBBlocks.NETHERITE_GRATE.get());
      entry.accept(SMBBlocks.CRACKED_QUARTZ_BRICKS.get());
      entry.accept(SMBBlocks.CUT_QUARTZ.get());
      entry.accept(SMBBlocks.CRACKED_CUT_QUARTZ.get());
      entry.accept(SMBBlocks.AMETHYST_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_AMETHYST_BRICKS.get());
      entry.accept(SMBBlocks.AMETHYST_PILLAR.get());
      entry.accept(SMBBlocks.CUT_AMETHYST.get());
      entry.accept(SMBBlocks.CRACKED_CUT_AMETHYST.get());
      entry.accept(SMBBlocks.COPPER_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.COPPER_PILLAR.get());
      entry.accept(SMBBlocks.CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.EXPOSED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.EXPOSED_COPPER_PILLAR.get());
      entry.accept(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.WEATHERED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WEATHERED_COPPER_PILLAR.get());
      entry.accept(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
      entry.accept(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.WAXED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_COPPER_PILLAR.get());
      entry.accept(SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
      entry.accept(SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
      entry.accept(SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
      entry.accept(SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
      entry.accept(SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
      entry.accept(SMBBlocks.BONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_BONE_BRICKS.get());
      entry.accept(SMBBlocks.BONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.BONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.BONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.BONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_BONE_TILES.get());
      entry.accept(SMBBlocks.BONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.BONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.BONE_TILE_WALL.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_STAIRS.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_SLAB.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_WALL.get());
      entry.accept(SMBBlocks.CHISELED_SOUL_SANDSTONE.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_SOUL_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_PILLAR.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_SOUL_SANDSTONE_TILES.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_TILE_SLAB.get());
      entry.accept(SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get());
      entry.accept(SMBBlocks.MOSSY_SOUL_SANDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get());
      entry.accept(SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get());
      entry.accept(SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get());
      entry.accept(SMBBlocks.CUT_SOUL_SANDSTONE.get());
      entry.accept(SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.get());
      entry.accept(SMBBlocks.PACKED_SNOW.get());
      entry.accept(SMBBlocks.PACKED_SNOW_STAIRS.get());
      entry.accept(SMBBlocks.PACKED_SNOW_SLAB.get());
      entry.accept(SMBBlocks.POLISHED_SNOW.get());
      entry.accept(SMBBlocks.POLISHED_SNOW_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_SNOW_SLAB.get());
      entry.accept(SMBBlocks.SNOW_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_SNOW_BRICKS.get());
      entry.accept(SMBBlocks.SNOW_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.SNOW_BRICK_SLAB.get());
      entry.accept(SMBBlocks.SNOW_BRICK_WALL.get());
      entry.accept(SMBBlocks.SNOW_PILLAR.get());
      entry.accept(SMBBlocks.SNOW_TILES.get());
      entry.accept(SMBBlocks.CRACKED_SNOW_TILES.get());
      entry.accept(SMBBlocks.SNOW_TILE_STAIRS.get());
      entry.accept(SMBBlocks.SNOW_TILE_SLAB.get());
      entry.accept(SMBBlocks.SNOW_TILE_WALL.get());
      entry.accept(SMBBlocks.POLISHED_ICE.get());
      entry.accept(SMBBlocks.POLISHED_ICE_STAIRS.get());
      entry.accept(SMBBlocks.POLISHED_ICE_SLAB.get());
      entry.accept(SMBBlocks.ICE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_ICE_BRICKS.get());
      entry.accept(SMBBlocks.ICE_BRICK_STAIRS.get());
      entry.accept(SMBBlocks.ICE_BRICK_SLAB.get());
      entry.accept(SMBBlocks.ICE_BRICK_WALL.get());
      entry.accept(SMBBlocks.ICE_PILLAR.get());
      entry.accept(SMBBlocks.ICE_TILES.get());
      entry.accept(SMBBlocks.CRACKED_ICE_TILES.get());
      entry.accept(SMBBlocks.ICE_TILE_STAIRS.get());
      entry.accept(SMBBlocks.ICE_TILE_SLAB.get());
      entry.accept(SMBBlocks.ICE_TILE_WALL.get());
    }).build());

  private static final RegistryObject<CreativeModeTab> MORE_COLORED_BLOCKS = CREATIVE_MODE_TABS.register("more_colored_blocks", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
    .icon(() -> SMBBlocks.MAGENTA_SHINGLES.get().asItem().getDefaultInstance())
    .title(Component.translatable("itemGroup.somemoreblocks.coloredBlocks"))
    .displayItems((ctx, entry) -> {
      entry.accept(SMBBlocks.TILED_GLASS.get());
      entry.accept(SMBBlocks.TILED_TINTED_GLASS.get());
      entry.accept(SMBBlocks.WHITE_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.GRAY_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.BLACK_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.BROWN_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.RED_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.LIME_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.GREEN_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.CYAN_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.BLUE_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.PINK_STAINED_TILED_GLASS.get());
      entry.accept(SMBBlocks.TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get());
      entry.accept(SMBBlocks.SHINGLES.get());
      entry.accept(SMBBlocks.WHITE_SHINGLES.get());
      entry.accept(SMBBlocks.LIGHT_GRAY_SHINGLES.get());
      entry.accept(SMBBlocks.GRAY_SHINGLES.get());
      entry.accept(SMBBlocks.BLACK_SHINGLES.get());
      entry.accept(SMBBlocks.BROWN_SHINGLES.get());
      entry.accept(SMBBlocks.RED_SHINGLES.get());
      entry.accept(SMBBlocks.ORANGE_SHINGLES.get());
      entry.accept(SMBBlocks.YELLOW_SHINGLES.get());
      entry.accept(SMBBlocks.LIME_SHINGLES.get());
      entry.accept(SMBBlocks.GREEN_SHINGLES.get());
      entry.accept(SMBBlocks.CYAN_SHINGLES.get());
      entry.accept(SMBBlocks.LIGHT_BLUE_SHINGLES.get());
      entry.accept(SMBBlocks.BLUE_SHINGLES.get());
      entry.accept(SMBBlocks.PURPLE_SHINGLES.get());
      entry.accept(SMBBlocks.MAGENTA_SHINGLES.get());
      entry.accept(SMBBlocks.PINK_SHINGLES.get());
      entry.accept(SMBBlocks.TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.WHITE_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.GRAY_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.BLACK_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.BROWN_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.RED_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.LIME_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.GREEN_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.CYAN_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.BLUE_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.PINK_TERRACOTTA_BRICKS.get());
      entry.accept(SMBBlocks.TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.WHITE_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.GRAY_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.BLACK_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.BROWN_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.RED_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.ORANGE_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.YELLOW_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.LIME_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.GREEN_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.CYAN_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.BLUE_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.PURPLE_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.MAGENTA_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.PINK_TERRACOTTA_TILES.get());
      entry.accept(SMBBlocks.WHITE_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.GRAY_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.BLACK_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.BROWN_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.RED_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.ORANGE_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.YELLOW_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.LIME_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.GREEN_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.CYAN_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.BLUE_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.PURPLE_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.MAGENTA_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.PINK_CONCRETE_BRICKS.get());
      entry.accept(SMBBlocks.WHITE_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.LIGHT_GRAY_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.GRAY_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.BLACK_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.BROWN_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.RED_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.ORANGE_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.YELLOW_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.LIME_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.GREEN_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.CYAN_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.LIGHT_BLUE_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.BLUE_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.PURPLE_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.MAGENTA_CONCRETE_TILES.get());
      entry.accept(SMBBlocks.PINK_CONCRETE_TILES.get());
    }).build());

  private static final RegistryObject<CreativeModeTab> MORE_NATURAL_BLOCKS = CREATIVE_MODE_TABS.register("more_natural_blocks", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 2)
    .icon(() -> SMBBlocks.TINY_CACTUS.get().asItem().getDefaultInstance())
    .title(Component.translatable("itemGroup.somemoreblocks.naturalBlocks"))
    .displayItems((ctx, entry) -> {
      entry.accept(SMBBlocks.TINY_CACTUS.get());
      entry.accept(SMBBlocks.DUNE_GRASS.get());
      entry.accept(SMBBlocks.TALL_DUNE_GRASS.get());
      entry.accept(SMBBlocks.SHORT_SNOW_GRASS.get());
      entry.accept(SMBBlocks.TALL_SNOW_GRASS.get());
      entry.accept(SMBBlocks.SNOW_FERN.get());
      entry.accept(SMBBlocks.LARGE_SNOW_FERN.get());
      entry.accept(SMBBlocks.CATTAIL.get());
      entry.accept(SMBItems.LEAVES_BUCKET.get());
      entry.accept(SMBItems.BIRCH_LEAVES_BUCKET.get());
      entry.accept(SMBItems.SPRUCE_LEAVES_BUCKET.get());
      entry.accept(SMBItems.AZALEA_LEAVES_BUCKET.get());
      entry.accept(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
      entry.accept(SMBItems.SMALL_LILY_PADS.get());
      entry.accept(SMBBlocks.LUMINOUS_FLOWER.get());

      if (ctx.hasPermissions()) {
        entry.accept(SMBItems.BIG_LILY_PAD.get());
        entry.accept(SMBItems.BROWN_MUSHROOM_COLONY.get());
        entry.accept(SMBItems.TALL_BROWN_MUSHROOM_COLONY.get());
        entry.accept(SMBItems.RED_MUSHROOM_COLONY.get());
        entry.accept(SMBItems.TALL_RED_MUSHROOM_COLONY.get());
        entry.accept(SMBItems.CRIMSON_FUNGUS_COLONY.get());
        entry.accept(SMBItems.TALL_CRIMSON_FUNGUS_COLONY.get());
        entry.accept(SMBItems.WARPED_FUNGUS_COLONY.get());
        entry.accept(SMBItems.TALL_WARPED_FUNGUS_COLONY.get());
      }
    }).build());

  private static final RegistryObject<CreativeModeTab> MORE_REDSTONE_BLOCKS = CREATIVE_MODE_TABS.register("more_redstone_blocks", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 3)
    .icon(() -> SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get().asItem().getDefaultInstance())
    .title(Component.translatable("itemGroup.somemoreblocks.redstoneBlocks"))
    .displayItems((ctx, entry) -> {
      entry.accept(SMBBlocks.REDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.CRACKED_REDSTONE_BRICKS.get());
      entry.accept(SMBBlocks.REDSTONE_PILLAR.get());
      entry.accept(SMBBlocks.CUT_REDSTONE.get());
      entry.accept(SMBBlocks.CRACKED_CUT_REDSTONE.get());
      entry.accept(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get());
      entry.accept(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get());
      entry.accept(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get());
    }).build());

  public static void register(IEventBus event) {
    CREATIVE_MODE_TABS.register(event);
  }
}
