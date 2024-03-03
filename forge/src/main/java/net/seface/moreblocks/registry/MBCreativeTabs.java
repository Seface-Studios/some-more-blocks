package net.seface.moreblocks.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.seface.moreblocks.MoreBlocks;

public class MBCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreBlocks.ID);

    private static final RegistryObject<CreativeModeTab> MORE_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("more_building_blocks", () -> CreativeModeTab.builder()
            .icon(() -> MBBlocks.MOSSY_BRICK_BLOCK.get().asItem().getDefaultInstance())
            .title(Component.translatable("itemGroup.moreblocks.buildingBlocks"))
            .displayItems((ctx, entry) -> {
                // Wooden Variations
                entry.accept(MBBlocks.CARVED_OAK_LOG.get());
                entry.accept(MBBlocks.CARVED_OAK_WOOD.get());
                entry.accept(MBBlocks.OAK_MOSAIC.get());
                entry.accept(MBBlocks.OAK_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.OAK_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_SPRUCE_LOG.get());
                entry.accept(MBBlocks.CARVED_SPRUCE_WOOD.get());
                entry.accept(MBBlocks.SPRUCE_MOSAIC.get());
                entry.accept(MBBlocks.SPRUCE_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.SPRUCE_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_BIRCH_LOG.get());
                entry.accept(MBBlocks.CARVED_BIRCH_WOOD.get());
                entry.accept(MBBlocks.BIRCH_MOSAIC.get());
                entry.accept(MBBlocks.BIRCH_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.BIRCH_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_JUNGLE_LOG.get());
                entry.accept(MBBlocks.CARVED_JUNGLE_WOOD.get());
                entry.accept(MBBlocks.JUNGLE_MOSAIC.get());
                entry.accept(MBBlocks.JUNGLE_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.JUNGLE_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_ACACIA_LOG.get());
                entry.accept(MBBlocks.CARVED_ACACIA_WOOD.get());
                entry.accept(MBBlocks.ACACIA_MOSAIC.get());
                entry.accept(MBBlocks.ACACIA_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.ACACIA_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_DARK_OAK_LOG.get());
                entry.accept(MBBlocks.CARVED_DARK_OAK_WOOD.get());
                entry.accept(MBBlocks.DARK_OAK_MOSAIC.get());
                entry.accept(MBBlocks.DARK_OAK_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.DARK_OAK_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_MANGROVE_LOG.get());
                entry.accept(MBBlocks.CARVED_MANGROVE_WOOD.get());
                entry.accept(MBBlocks.MANGROVE_MOSAIC.get());
                entry.accept(MBBlocks.MANGROVE_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.MANGROVE_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_CRIMSON_STEM.get());
                entry.accept(MBBlocks.CARVED_CRIMSON_HYPHAE.get());
                entry.accept(MBBlocks.CRIMSON_MOSAIC.get());
                entry.accept(MBBlocks.CRIMSON_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.CRIMSON_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_WARPED_STEM.get());
                entry.accept(MBBlocks.CARVED_WARPED_HYPHAE.get());
                entry.accept(MBBlocks.WARPED_MOSAIC.get());
                entry.accept(MBBlocks.WARPED_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.WARPED_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.CARVED_CHERRY_LOG.get());
                entry.accept(MBBlocks.CARVED_CHERRY_WOOD.get());
                entry.accept(MBBlocks.CHERRY_MOSAIC.get());
                entry.accept(MBBlocks.CHERRY_MOSAIC_STAIRS.get());
                entry.accept(MBBlocks.CHERRY_MOSAIC_SLAB.get());
                entry.accept(MBBlocks.POLISHED_STONE.get());
                entry.accept(MBBlocks.POLISHED_STONE_STAIRS.get());
                entry.accept(MBBlocks.POLISHED_STONE_SLAB.get());
                entry.accept(MBBlocks.STONE_PILLAR.get());
                entry.accept(MBBlocks.STONE_TILES.get());
                entry.accept(MBBlocks.CRACKED_STONE_TILES.get());
                entry.accept(MBBlocks.STONE_TILES_STAIRS.get());
                entry.accept(MBBlocks.STONE_TILES_SLAB.get());
                entry.accept(MBBlocks.STONE_TILES_WALL.get());
                entry.accept(MBBlocks.CHISELED_GRANITE_BRICKS.get());
                entry.accept(MBBlocks.GRANITE_BRICKS.get());
                entry.accept(MBBlocks.GRANITE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.GRANITE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.GRANITE_BRICKS_WALL.get());
                entry.accept(MBBlocks.GRANITE_PILLAR.get());
                entry.accept(MBBlocks.GRANITE_TILES.get());
                entry.accept(MBBlocks.CRACKED_GRANITE_TILES.get());
                entry.accept(MBBlocks.GRANITE_TILES_STAIRS.get());
                entry.accept(MBBlocks.GRANITE_TILES_SLAB.get());
                entry.accept(MBBlocks.GRANITE_TILES_WALL.get());
                entry.accept(MBBlocks.MOSSY_GRANITE_BRICKS.get());
                entry.accept(MBBlocks.MOSSY_GRANITE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.MOSSY_GRANITE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.MOSSY_GRANITE_BRICKS_WALL.get());
                entry.accept(MBBlocks.SMOOTH_GRANITE.get());
                entry.accept(MBBlocks.SMOOTH_GRANITE_SLAB.get());
                entry.accept(MBBlocks.CHISELED_DIORITE_BRICKS.get());
                entry.accept(MBBlocks.DIORITE_BRICKS.get());
                entry.accept(MBBlocks.DIORITE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.DIORITE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.DIORITE_BRICKS_WALL.get());
                entry.accept(MBBlocks.DIORITE_PILLAR.get());
                entry.accept(MBBlocks.DIORITE_TILES.get());
                entry.accept(MBBlocks.CRACKED_DIORITE_TILES.get());
                entry.accept(MBBlocks.DIORITE_TILES_STAIRS.get());
                entry.accept(MBBlocks.DIORITE_TILES_SLAB.get());
                entry.accept(MBBlocks.DIORITE_TILES_WALL.get());
                entry.accept(MBBlocks.MOSSY_DIORITE_BRICKS.get());
                entry.accept(MBBlocks.MOSSY_DIORITE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.MOSSY_DIORITE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.MOSSY_DIORITE_BRICKS_WALL.get());
                entry.accept(MBBlocks.SMOOTH_DIORITE.get());
                entry.accept(MBBlocks.SMOOTH_DIORITE_SLAB.get());
                entry.accept(MBBlocks.CHISELED_ANDESITE_BRICKS.get());
                entry.accept(MBBlocks.ANDESITE_BRICKS.get());
                entry.accept(MBBlocks.ANDESITE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.ANDESITE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.ANDESITE_BRICKS_WALL.get());
                entry.accept(MBBlocks.ANDESITE_PILLAR.get());
                entry.accept(MBBlocks.ANDESITE_TILES.get());
                entry.accept(MBBlocks.CRACKED_ANDESITE_TILES.get());
                entry.accept(MBBlocks.ANDESITE_TILES_STAIRS.get());
                entry.accept(MBBlocks.ANDESITE_TILES_SLAB.get());
                entry.accept(MBBlocks.ANDESITE_TILES_WALL.get());
                entry.accept(MBBlocks.MOSSY_ANDESITE_BRICKS.get());
                entry.accept(MBBlocks.MOSSY_ANDESITE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.MOSSY_ANDESITE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.MOSSY_ANDESITE_BRICKS_WALL.get());
                entry.accept(MBBlocks.SMOOTH_ANDESITE.get());
                entry.accept(MBBlocks.SMOOTH_ANDESITE_SLAB.get());
                entry.accept(MBBlocks.DEEPSLATE_PILLAR.get());
                entry.accept(MBBlocks.CRACKED_BRICK_BLOCK.get());
                entry.accept(MBBlocks.MOSSY_BRICK_BLOCK.get());
                entry.accept(MBBlocks.MOSSY_BRICK_BLOCK_STAIRS.get());
                entry.accept(MBBlocks.MOSSY_BRICK_BLOCK_SLAB.get());
                entry.accept(MBBlocks.MOSSY_BRICK_BLOCK_WALL.get());
                entry.accept(MBBlocks.POLISHED_MUD.get());
                entry.accept(MBBlocks.POLISHED_MUD_STAIRS.get());
                entry.accept(MBBlocks.POLISHED_MUD_SLAB.get());
                entry.accept(MBBlocks.CHISELED_MUD.get());
                entry.accept(MBBlocks.CRACKED_MUD_BRICKS.get());
                entry.accept(MBBlocks.MUD_PILLAR.get());
                entry.accept(MBBlocks.MUD_TILES.get());
                entry.accept(MBBlocks.CRACKED_MUD_TILES.get());
                entry.accept(MBBlocks.MUD_TILES_STAIRS.get());
                entry.accept(MBBlocks.MUD_TILES_SLAB.get());
                entry.accept(MBBlocks.MUD_TILES_WALL.get());
                entry.accept(MBBlocks.MOSSY_MUD_BRICKS.get());
                entry.accept(MBBlocks.MOSSY_MUD_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.MOSSY_MUD_BRICKS_SLAB.get());
                entry.accept(MBBlocks.MOSSY_MUD_BRICKS_WALL.get());
                entry.accept(MBBlocks.SMOOTH_MUD.get());
                entry.accept(MBBlocks.SMOOTH_MUD_SLAB.get());
                entry.accept(MBBlocks.SANDSTONE_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_SANDSTONE_BRICKS.get());
                entry.accept(MBBlocks.SANDSTONE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.SANDSTONE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.SANDSTONE_BRICKS_WALL.get());
                entry.accept(MBBlocks.SANDSTONE_PILLAR.get());
                entry.accept(MBBlocks.SANDSTONE_TILES.get());
                entry.accept(MBBlocks.CRACKED_SANDSTONE_TILES.get());
                entry.accept(MBBlocks.SANDSTONE_TILES_STAIRS.get());
                entry.accept(MBBlocks.SANDSTONE_TILES_SLAB.get());
                entry.accept(MBBlocks.SANDSTONE_TILES_WALL.get());
                entry.accept(MBBlocks.DRY_MOSSY_SANDSTONE_BRICKS.get());
                entry.accept(MBBlocks.DRY_MOSSY_SANDSTONE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.DRY_MOSSY_SANDSTONE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.DRY_MOSSY_SANDSTONE_BRICKS_WALL.get());
                entry.accept(MBBlocks.RED_SANDSTONE_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_RED_SANDSTONE_BRICKS.get());
                entry.accept(MBBlocks.RED_SANDSTONE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.RED_SANDSTONE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.RED_SANDSTONE_BRICKS_WALL.get());
                entry.accept(MBBlocks.RED_SANDSTONE_PILLAR.get());
                entry.accept(MBBlocks.RED_SANDSTONE_TILES.get());
                entry.accept(MBBlocks.CRACKED_RED_SANDSTONE_TILES.get());
                entry.accept(MBBlocks.RED_SANDSTONE_TILES_STAIRS.get());
                entry.accept(MBBlocks.RED_SANDSTONE_TILES_SLAB.get());
                entry.accept(MBBlocks.RED_SANDSTONE_TILES_WALL.get());
                entry.accept(MBBlocks.DRY_MOSSY_RED_SANDSTONE_BRICKS.get());
                entry.accept(MBBlocks.DRY_MOSSY_RED_SANDSTONE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.DRY_MOSSY_RED_SANDSTONE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.DRY_MOSSY_RED_SANDSTONE_BRICKS_WALL.get());
                entry.accept(MBBlocks.POLISHED_PRISMARINE.get());
                entry.accept(MBBlocks.POLISHED_PRISMARINE_STAIRS.get());
                entry.accept(MBBlocks.POLISHED_PRISMARINE_SLAB.get());
                //entry.aMBBlocks(MBItems.get().POLISHED_PRISMARINE_WALL);
                entry.accept(MBBlocks.CHISELED_PRISMARINE.get());
                entry.accept(MBBlocks.CRACKED_PRISMARINE_BRICKS.get());
                entry.accept(MBBlocks.PRISMARINE_PILLAR.get());
                entry.accept(MBBlocks.PRISMARINE_TILES.get());
                entry.accept(MBBlocks.CRACKED_PRISMARINE_TILES.get());
                entry.accept(MBBlocks.PRISMARINE_TILES_STAIRS.get());
                entry.accept(MBBlocks.PRISMARINE_TILES_SLAB.get());
                entry.accept(MBBlocks.PRISMARINE_TILES_WALL.get());
                entry.accept(MBBlocks.MOSSY_PRISMARINE_BRICKS.get());
                entry.accept(MBBlocks.MOSSY_PRISMARINE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.MOSSY_PRISMARINE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.MOSSY_PRISMARINE_BRICKS_WALL.get());
                entry.accept(MBBlocks.SMOOTH_PRISMARINE.get());
                entry.accept(MBBlocks.SMOOTH_PRISMARINE_SLAB.get());
                entry.accept(MBBlocks.NETHER_BRICKS_PILLAR.get());
                entry.accept(MBBlocks.CRACKED_RED_NETHER_BRICKS.get());
                entry.accept(MBBlocks.CHISELED_RED_NETHER_BRICKS.get());
                entry.accept(MBBlocks.RED_NETHER_BRICKS_PILLAR.get());
                entry.accept(MBBlocks.BLACKSTONE_PILLAR.get());
                entry.accept(MBBlocks.POLISHED_BLACKSTONE_TILES.get());
                entry.accept(MBBlocks.CRACKED_POLISHED_BLACKSTONE_TILES.get());
                entry.accept(MBBlocks.POLISHED_BLACKSTONE_TILES_STAIRS.get());
                entry.accept(MBBlocks.POLISHED_BLACKSTONE_TILES_SLAB.get());
                entry.accept(MBBlocks.POLISHED_BLACKSTONE_TILES_WALL.get());
                entry.accept(MBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get());
                entry.accept(MBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS_WALL.get());
                entry.accept(MBBlocks.SMOOTH_BLACKSTONE.get());
                entry.accept(MBBlocks.POLISHED_END_STONE.get());
                entry.accept(MBBlocks.POLISHED_END_STONE_STAIRS.get());
                entry.accept(MBBlocks.POLISHED_END_STONE_SLAB.get());
                entry.accept(MBBlocks.CHISELED_END_STONE.get());
                entry.accept(MBBlocks.CRACKED_END_STONE_BRICKS.get());
                entry.accept(MBBlocks.END_STONE_PILLAR.get());
                entry.accept(MBBlocks.END_STONE_TILES.get());
                entry.accept(MBBlocks.END_STONE_TILES_STAIRS.get());
                entry.accept(MBBlocks.END_STONE_TILES_SLAB.get());
                entry.accept(MBBlocks.END_STONE_TILES_WALL.get());
                entry.accept(MBBlocks.MOSSY_END_STONE_BRICKS.get());
                entry.accept(MBBlocks.MOSSY_END_STONE_BRICKS_STAIRS.get());
                entry.accept(MBBlocks.MOSSY_END_STONE_BRICKS_SLAB.get());
                entry.accept(MBBlocks.MOSSY_END_STONE_BRICKS_WALL.get());
                entry.accept(MBBlocks.SMOOTH_END_STONE.get());
                entry.accept(MBBlocks.SMOOTH_END_STONE_SLAB.get());
                entry.accept(MBBlocks.COAL_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_COAL_BRICKS.get());
                entry.accept(MBBlocks.COAL_PILLAR.get());
                entry.accept(MBBlocks.CUT_COAL.get());
                entry.accept(MBBlocks.CRACKED_CUT_COAL.get());
                entry.accept(MBBlocks.IRON_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_IRON_BRICKS.get());
                entry.accept(MBBlocks.IRON_PILLAR.get());
                entry.accept(MBBlocks.CUT_IRON.get());
                entry.accept(MBBlocks.CRACKED_CUT_IRON.get());
                entry.accept(MBBlocks.IRON_GRATE.get());
                entry.accept(MBBlocks.GOLD_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_GOLD_BRICKS.get());
                entry.accept(MBBlocks.GOLD_PILLAR.get());
                entry.accept(MBBlocks.CUT_GOLD.get());
                entry.accept(MBBlocks.CRACKED_CUT_GOLD.get());
                entry.accept(MBBlocks.REDSTONE_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_REDSTONE_BRICKS.get());
                entry.accept(MBBlocks.REDSTONE_PILLAR.get());
                entry.accept(MBBlocks.CUT_REDSTONE.get());
                entry.accept(MBBlocks.CRACKED_CUT_REDSTONE.get());
                entry.accept(MBBlocks.EMERALD_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_EMERALD_BRICKS.get());
                entry.accept(MBBlocks.EMERALD_PILLAR.get());
                entry.accept(MBBlocks.CUT_EMERALD.get());
                entry.accept(MBBlocks.CRACKED_CUT_EMERALD.get());
                entry.accept(MBBlocks.LAPIS_LAZULI_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_LAPIS_LAZULI_BRICKS.get());
                entry.accept(MBBlocks.LAPIS_LAZULI_PILLAR.get());
                entry.accept(MBBlocks.CUT_LAPIS_LAZULI.get());
                entry.accept(MBBlocks.CRACKED_CUT_LAPIS_LAZULI.get());
                entry.accept(MBBlocks.DIAMOND_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_DIAMOND_BRICKS.get());
                entry.accept(MBBlocks.DIAMOND_PILLAR.get());
                entry.accept(MBBlocks.CUT_DIAMOND.get());
                entry.accept(MBBlocks.CRACKED_CUT_DIAMOND.get());
                entry.accept(MBBlocks.DIAMOND_GRATE.get());
                entry.accept(MBBlocks.NETHERITE_BRICKS.get());
                entry.accept(MBBlocks.CRACKED_NETHERITE_BRICKS.get());
                entry.accept(MBBlocks.NETHERITE_PILLAR.get());
                entry.accept(MBBlocks.CUT_NETHERITE.get());
                entry.accept(MBBlocks.CRACKED_CUT_NETHERITE.get());
                entry.accept(MBBlocks.NETHERITE_GRATE.get());
            }).build());

    private static final RegistryObject<CreativeModeTab> MORE_COLORED_BLOCKS = CREATIVE_MODE_TABS.register("more_colored_blocks", () -> CreativeModeTab.builder()
            .icon(() -> MBBlocks.MAGENTA_SHINGLES.get().asItem().getDefaultInstance())
            .title(Component.translatable("itemGroup.moreblocks.coloredBlocks"))
            .displayItems((ctx, entry) -> {
                entry.accept(MBBlocks.TILED_GLASS.get());
                entry.accept(MBBlocks.TILED_TINTED_GLASS.get());
                entry.accept(MBBlocks.WHITE_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.GRAY_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.BLACK_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.BROWN_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.RED_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.ORANGE_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.YELLOW_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.LIME_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.GREEN_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.CYAN_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.BLUE_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.PURPLE_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.MAGENTA_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.PINK_STAINED_TILED_GLASS.get());
                entry.accept(MBBlocks.SHINGLES.get());
                entry.accept(MBBlocks.WHITE_SHINGLES.get());
                entry.accept(MBBlocks.LIGHT_GRAY_SHINGLES.get());
                entry.accept(MBBlocks.GRAY_SHINGLES.get());
                entry.accept(MBBlocks.BLACK_SHINGLES.get());
                entry.accept(MBBlocks.BROWN_SHINGLES.get());
                entry.accept(MBBlocks.RED_SHINGLES.get());
                entry.accept(MBBlocks.ORANGE_SHINGLES.get());
                entry.accept(MBBlocks.YELLOW_SHINGLES.get());
                entry.accept(MBBlocks.LIME_SHINGLES.get());
                entry.accept(MBBlocks.GREEN_SHINGLES.get());
                entry.accept(MBBlocks.CYAN_SHINGLES.get());
                entry.accept(MBBlocks.LIGHT_BLUE_SHINGLES.get());
                entry.accept(MBBlocks.BLUE_SHINGLES.get());
                entry.accept(MBBlocks.PURPLE_SHINGLES.get());
                entry.accept(MBBlocks.MAGENTA_SHINGLES.get());
                entry.accept(MBBlocks.PINK_SHINGLES.get());
                entry.accept(MBBlocks.TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.WHITE_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.GRAY_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.BLACK_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.BROWN_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.RED_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.ORANGE_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.YELLOW_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.LIME_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.GREEN_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.CYAN_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.BLUE_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.PURPLE_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.PINK_TERRACOTTA_BRICKS.get());
                entry.accept(MBBlocks.TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.WHITE_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.GRAY_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.BLACK_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.BROWN_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.RED_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.ORANGE_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.YELLOW_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.LIME_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.GREEN_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.CYAN_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.BLUE_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.PURPLE_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.MAGENTA_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.PINK_TERRACOTTA_TILES.get());
                entry.accept(MBBlocks.WHITE_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.GRAY_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.BLACK_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.BROWN_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.RED_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.ORANGE_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.YELLOW_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.LIME_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.GREEN_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.CYAN_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.BLUE_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.PURPLE_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.MAGENTA_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.PINK_CONCRETE_BRICKS.get());
                entry.accept(MBBlocks.WHITE_CONCRETE_TILES.get());
                entry.accept(MBBlocks.LIGHT_GRAY_CONCRETE_TILES.get());
                entry.accept(MBBlocks.GRAY_CONCRETE_TILES.get());
                entry.accept(MBBlocks.BLACK_CONCRETE_TILES.get());
                entry.accept(MBBlocks.BROWN_CONCRETE_TILES.get());
                entry.accept(MBBlocks.RED_CONCRETE_TILES.get());
                entry.accept(MBBlocks.ORANGE_CONCRETE_TILES.get());
                entry.accept(MBBlocks.YELLOW_CONCRETE_TILES.get());
                entry.accept(MBBlocks.LIME_CONCRETE_TILES.get());
                entry.accept(MBBlocks.GREEN_CONCRETE_TILES.get());
                entry.accept(MBBlocks.CYAN_CONCRETE_TILES.get());
                entry.accept(MBBlocks.LIGHT_BLUE_CONCRETE_TILES.get());
                entry.accept(MBBlocks.BLUE_CONCRETE_TILES.get());
                entry.accept(MBBlocks.PURPLE_CONCRETE_TILES.get());
                entry.accept(MBBlocks.MAGENTA_CONCRETE_TILES.get());
                entry.accept(MBBlocks.PINK_CONCRETE_TILES.get());
            }).build());

    private static final RegistryObject<CreativeModeTab> MORE_NATURAL_BLOCKS = CREATIVE_MODE_TABS.register("more_natural_blocks", () -> CreativeModeTab.builder()
            .icon(() -> MBBlocks.TINY_CACTUS.get().asItem().getDefaultInstance())
            .title(Component.translatable("itemGroup.moreblocks.naturalBlocks"))
            .displayItems((ctx, entry) -> {
                entry.accept(MBBlocks.TINY_CACTUS.get());
                entry.accept(MBBlocks.DUNE_GRASS.get());
                entry.accept(MBBlocks.TALL_DUNE_GRASS.get());
                entry.accept(MBBlocks.CATTAIL.get());
               //entry.accept(MBItems.LEAVES_BUCKET.get());
               //entry.accept(MBItems.FROZEN_LEAVES_BUCKET.get());
               //entry.accept(MBItems.PINK_PETALS_BUCKET.get());
                entry.accept(MBItems.SMALL_LILY_PADS.get());
                entry.accept(MBBlocks.LUMINOUS_FLOWER.get());
            }).build());

    public static void register(IEventBus event) {
        CREATIVE_MODE_TABS.register(event);
    }
}
