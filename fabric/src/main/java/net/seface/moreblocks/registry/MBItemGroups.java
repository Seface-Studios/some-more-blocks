package net.seface.moreblocks.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.seface.moreblocks.MoreBlocks;

public class MBItemGroups {
    private static final CreativeModeTab MORE_BUILDING_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MBItems.MOSSY_BRICK_BLOCK))
            .title(Component.translatable("itemGroup.moreblocks.buildingBlocks"))
            .displayItems((ctx, entry) -> {
                entry.accept(MBItems.CARVED_OAK_LOG);
                entry.accept(MBItems.CARVED_OAK_WOOD);
                entry.accept(MBItems.OAK_MOSAIC);
                entry.accept(MBItems.OAK_MOSAIC_STAIRS);
                entry.accept(MBItems.OAK_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_SPRUCE_LOG);
                entry.accept(MBItems.CARVED_SPRUCE_WOOD);
                entry.accept(MBItems.SPRUCE_MOSAIC);
                entry.accept(MBItems.SPRUCE_MOSAIC_STAIRS);
                entry.accept(MBItems.SPRUCE_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_BIRCH_LOG);
                entry.accept(MBItems.CARVED_BIRCH_WOOD);
                entry.accept(MBItems.BIRCH_MOSAIC);
                entry.accept(MBItems.BIRCH_MOSAIC_STAIRS);
                entry.accept(MBItems.BIRCH_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_JUNGLE_LOG);
                entry.accept(MBItems.CARVED_JUNGLE_WOOD);
                entry.accept(MBItems.JUNGLE_MOSAIC);
                entry.accept(MBItems.JUNGLE_MOSAIC_STAIRS);
                entry.accept(MBItems.JUNGLE_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_ACACIA_LOG);
                entry.accept(MBItems.CARVED_ACACIA_WOOD);
                entry.accept(MBItems.ACACIA_MOSAIC);
                entry.accept(MBItems.ACACIA_MOSAIC_STAIRS);
                entry.accept(MBItems.ACACIA_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_DARK_OAK_LOG);
                entry.accept(MBItems.CARVED_DARK_OAK_WOOD);
                entry.accept(MBItems.DARK_OAK_MOSAIC);
                entry.accept(MBItems.DARK_OAK_MOSAIC_STAIRS);
                entry.accept(MBItems.DARK_OAK_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_MANGROVE_LOG);
                entry.accept(MBItems.CARVED_MANGROVE_WOOD);
                entry.accept(MBItems.MANGROVE_MOSAIC);
                entry.accept(MBItems.MANGROVE_MOSAIC_STAIRS);
                entry.accept(MBItems.MANGROVE_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_CRIMSON_STEM);
                entry.accept(MBItems.CARVED_CRIMSON_HYPHAE);
                entry.accept(MBItems.CRIMSON_MOSAIC);
                entry.accept(MBItems.CRIMSON_MOSAIC_STAIRS);
                entry.accept(MBItems.CRIMSON_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_WARPED_STEM);
                entry.accept(MBItems.CARVED_WARPED_HYPHAE);
                entry.accept(MBItems.WARPED_MOSAIC);
                entry.accept(MBItems.WARPED_MOSAIC_STAIRS);
                entry.accept(MBItems.WARPED_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_CHERRY_LOG);
                entry.accept(MBItems.CARVED_CHERRY_WOOD);
                entry.accept(MBItems.CHERRY_MOSAIC);
                entry.accept(MBItems.CHERRY_MOSAIC_STAIRS);
                entry.accept(MBItems.CHERRY_MOSAIC_SLAB);
                entry.accept(MBItems.CARVED_BAMBOO_BLOCK);
                entry.accept(MBItems.POLISHED_STONE);
                entry.accept(MBItems.POLISHED_STONE_STAIRS);
                entry.accept(MBItems.POLISHED_STONE_SLAB);
                entry.accept(MBItems.STONE_PILLAR);
                entry.accept(MBItems.STONE_TILES);
                entry.accept(MBItems.CRACKED_STONE_TILES);
                entry.accept(MBItems.STONE_TILES_STAIRS);
                entry.accept(MBItems.STONE_TILES_SLAB);
                entry.accept(MBItems.STONE_TILES_WALL);
                entry.accept(MBItems.CHISELED_GRANITE_BRICKS);
                entry.accept(MBItems.GRANITE_BRICKS);
                entry.accept(MBItems.GRANITE_BRICKS_STAIRS);
                entry.accept(MBItems.GRANITE_BRICKS_SLAB);
                entry.accept(MBItems.GRANITE_BRICKS_WALL);
                entry.accept(MBItems.GRANITE_PILLAR);
                entry.accept(MBItems.GRANITE_TILES);
                entry.accept(MBItems.CRACKED_GRANITE_TILES);
                entry.accept(MBItems.GRANITE_TILES_STAIRS);
                entry.accept(MBItems.GRANITE_TILES_SLAB);
                entry.accept(MBItems.GRANITE_TILES_WALL);
                entry.accept(MBItems.MOSSY_GRANITE_BRICKS);
                entry.accept(MBItems.MOSSY_GRANITE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_GRANITE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_GRANITE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_GRANITE);
                entry.accept(MBItems.SMOOTH_GRANITE_SLAB);
                entry.accept(MBItems.CHISELED_DIORITE_BRICKS);
                entry.accept(MBItems.DIORITE_BRICKS);
                entry.accept(MBItems.DIORITE_BRICKS_STAIRS);
                entry.accept(MBItems.DIORITE_BRICKS_SLAB);
                entry.accept(MBItems.DIORITE_BRICKS_WALL);
                entry.accept(MBItems.DIORITE_PILLAR);
                entry.accept(MBItems.DIORITE_TILES);
                entry.accept(MBItems.CRACKED_DIORITE_TILES);
                entry.accept(MBItems.DIORITE_TILES_STAIRS);
                entry.accept(MBItems.DIORITE_TILES_SLAB);
                entry.accept(MBItems.DIORITE_TILES_WALL);
                entry.accept(MBItems.MOSSY_DIORITE_BRICKS);
                entry.accept(MBItems.MOSSY_DIORITE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_DIORITE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_DIORITE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_DIORITE);
                entry.accept(MBItems.SMOOTH_DIORITE_SLAB);
                entry.accept(MBItems.CHISELED_ANDESITE_BRICKS);
                entry.accept(MBItems.ANDESITE_BRICKS);
                entry.accept(MBItems.ANDESITE_BRICKS_STAIRS);
                entry.accept(MBItems.ANDESITE_BRICKS_SLAB);
                entry.accept(MBItems.ANDESITE_BRICKS_WALL);
                entry.accept(MBItems.ANDESITE_PILLAR);
                entry.accept(MBItems.ANDESITE_TILES);
                entry.accept(MBItems.CRACKED_ANDESITE_TILES);
                entry.accept(MBItems.ANDESITE_TILES_STAIRS);
                entry.accept(MBItems.ANDESITE_TILES_SLAB);
                entry.accept(MBItems.ANDESITE_TILES_WALL);
                entry.accept(MBItems.MOSSY_ANDESITE_BRICKS);
                entry.accept(MBItems.MOSSY_ANDESITE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_ANDESITE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_ANDESITE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_ANDESITE);
                entry.accept(MBItems.SMOOTH_ANDESITE_SLAB);
                entry.accept(MBItems.DEEPSLATE_PILLAR);


                entry.accept(MBItems.POLISHED_CALCITE);
                entry.accept(MBItems.POLISHED_CALCITE_STAIRS);
                entry.accept(MBItems.POLISHED_CALCITE_SLAB);
                entry.accept(MBItems.CHISELED_CALCITE);
                entry.accept(MBItems.CALCITE_BRICKS);
                entry.accept(MBItems.CRACKED_CALCITE_BRICKS);
                entry.accept(MBItems.CALCITE_BRICKS_STAIRS);
                entry.accept(MBItems.CALCITE_BRICKS_SLAB);
                entry.accept(MBItems.CALCITE_BRICKS_WALL);
                entry.accept(MBItems.CALCITE_PILLAR);
                entry.accept(MBItems.CALCITE_TILES);
                entry.accept(MBItems.CRACKED_CALCITE_TILES);
                entry.accept(MBItems.CALCITE_TILES_STAIRS);
                entry.accept(MBItems.CALCITE_TILES_SLAB);
                entry.accept(MBItems.CALCITE_TILES_WALL);
                entry.accept(MBItems.MOSSY_CALCITE_BRICKS);
                entry.accept(MBItems.MOSSY_CALCITE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_CALCITE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_CALCITE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_CALCITE);
                entry.accept(MBItems.SMOOTH_CALCITE_SLAB);

                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.TUFF_BRICKS);
                entry.accept(MBItems.CRACKED_TUFF_BRICKS);
                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.TUFF_BRICKS_SLAB);
                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.TUFF_BRICKS_STAIRS);
                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.TUFF_BRICKS_WALL);
                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.CHISELED_TUFF);
                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.POLISHED_TUFF);
                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.POLISHED_TUFF_SLAB);
                entryWithoutFeatureFlag(ctx, entry, FeatureFlags.UPDATE_1_21, MBItems.POLISHED_TUFF_STAIRS);

                entry.accept(MBItems.TUFF_PILLAR);
                entry.accept(MBItems.TUFF_TILES);
                entry.accept(MBItems.CRACKED_TUFF_TILES);
                entry.accept(MBItems.TUFF_TILES_STAIRS);
                entry.accept(MBItems.TUFF_TILES_SLAB);
                entry.accept(MBItems.TUFF_TILES_WALL);
                entry.accept(MBItems.MOSSY_TUFF_BRICKS);
                entry.accept(MBItems.MOSSY_TUFF_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_TUFF_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_TUFF_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_TUFF);
                entry.accept(MBItems.SMOOTH_TUFF_SLAB);
                entry.accept(MBItems.POLISHED_DRIPSTONE);
                entry.accept(MBItems.POLISHED_DRIPSTONE_STAIRS);
                entry.accept(MBItems.POLISHED_DRIPSTONE_SLAB);
                entry.accept(MBItems.CHISELED_DRIPSTONE);
                entry.accept(MBItems.DRIPSTONE_BRICKS);
                entry.accept(MBItems.CRACKED_DRIPSTONE_BRICKS);
                entry.accept(MBItems.DRIPSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.DRIPSTONE_BRICKS_SLAB);
                entry.accept(MBItems.DRIPSTONE_BRICKS_WALL);
                entry.accept(MBItems.DRIPSTONE_PILLAR);
                entry.accept(MBItems.DRIPSTONE_TILES);
                entry.accept(MBItems.CRACKED_DRIPSTONE_TILES);
                entry.accept(MBItems.DRIPSTONE_TILES_STAIRS);
                entry.accept(MBItems.DRIPSTONE_TILES_SLAB);
                entry.accept(MBItems.DRIPSTONE_TILES_WALL);
                entry.accept(MBItems.MOSSY_DRIPSTONE_BRICKS);
                entry.accept(MBItems.MOSSY_DRIPSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_DRIPSTONE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_DRIPSTONE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_DRIPSTONE);
                entry.accept(MBItems.SMOOTH_DRIPSTONE_SLAB);
                entry.accept(MBItems.CRACKED_BRICK_BLOCK);
                entry.accept(MBItems.MOSSY_BRICK_BLOCK);
                entry.accept(MBItems.MOSSY_BRICK_BLOCK_STAIRS);
                entry.accept(MBItems.MOSSY_BRICK_BLOCK_SLAB);
                entry.accept(MBItems.MOSSY_BRICK_BLOCK_WALL);
                entry.accept(MBItems.POLISHED_MUD);
                entry.accept(MBItems.POLISHED_MUD_STAIRS);
                entry.accept(MBItems.POLISHED_MUD_SLAB);
                entry.accept(MBItems.CHISELED_MUD);
                entry.accept(MBItems.CRACKED_MUD_BRICKS);
                entry.accept(MBItems.MUD_PILLAR);
                entry.accept(MBItems.MUD_TILES);
                entry.accept(MBItems.CRACKED_MUD_TILES);
                entry.accept(MBItems.MUD_TILES_STAIRS);
                entry.accept(MBItems.MUD_TILES_SLAB);
                entry.accept(MBItems.MUD_TILES_WALL);
                entry.accept(MBItems.MOSSY_MUD_BRICKS);
                entry.accept(MBItems.MOSSY_MUD_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_MUD_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_MUD_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_MUD);
                entry.accept(MBItems.SMOOTH_MUD_SLAB);
                entry.accept(MBItems.SANDSTONE_BRICKS);
                entry.accept(MBItems.CRACKED_SANDSTONE_BRICKS);
                entry.accept(MBItems.SANDSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.SANDSTONE_BRICKS_SLAB);
                entry.accept(MBItems.SANDSTONE_BRICKS_WALL);
                entry.accept(MBItems.SANDSTONE_PILLAR);
                entry.accept(MBItems.SANDSTONE_TILES);
                entry.accept(MBItems.CRACKED_SANDSTONE_TILES);
                entry.accept(MBItems.SANDSTONE_TILES_STAIRS);
                entry.accept(MBItems.SANDSTONE_TILES_SLAB);
                entry.accept(MBItems.SANDSTONE_TILES_WALL);
                entry.accept(MBItems.MOSSY_SANDSTONE_BRICKS);
                entry.accept(MBItems.MOSSY_SANDSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_SANDSTONE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_SANDSTONE_BRICKS_WALL);
                entry.accept(MBItems.RED_SANDSTONE_BRICKS);
                entry.accept(MBItems.CRACKED_RED_SANDSTONE_BRICKS);
                entry.accept(MBItems.RED_SANDSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.RED_SANDSTONE_BRICKS_SLAB);
                entry.accept(MBItems.RED_SANDSTONE_BRICKS_WALL);
                entry.accept(MBItems.RED_SANDSTONE_PILLAR);
                entry.accept(MBItems.RED_SANDSTONE_TILES);
                entry.accept(MBItems.CRACKED_RED_SANDSTONE_TILES);
                entry.accept(MBItems.RED_SANDSTONE_TILES_STAIRS);
                entry.accept(MBItems.RED_SANDSTONE_TILES_SLAB);
                entry.accept(MBItems.RED_SANDSTONE_TILES_WALL);
                entry.accept(MBItems.MOSSY_RED_SANDSTONE_BRICKS);
                entry.accept(MBItems.MOSSY_RED_SANDSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_RED_SANDSTONE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_RED_SANDSTONE_BRICKS_WALL);
                entry.accept(MBItems.POLISHED_PRISMARINE);
                entry.accept(MBItems.POLISHED_PRISMARINE_STAIRS);
                entry.accept(MBItems.POLISHED_PRISMARINE_SLAB);
                //entry.accept(MBItems.POLISHED_PRISMARINE_WALL);
                entry.accept(MBItems.CHISELED_PRISMARINE);
                entry.accept(MBItems.CRACKED_PRISMARINE_BRICKS);
                entry.accept(MBItems.PRISMARINE_PILLAR);
                entry.accept(MBItems.PRISMARINE_TILES);
                entry.accept(MBItems.CRACKED_PRISMARINE_TILES);
                entry.accept(MBItems.PRISMARINE_TILES_STAIRS);
                entry.accept(MBItems.PRISMARINE_TILES_SLAB);
                entry.accept(MBItems.PRISMARINE_TILES_WALL);
                entry.accept(MBItems.MOSSY_PRISMARINE_BRICKS);
                entry.accept(MBItems.MOSSY_PRISMARINE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_PRISMARINE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_PRISMARINE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_PRISMARINE);
                entry.accept(MBItems.SMOOTH_PRISMARINE_SLAB);
                entry.accept(MBItems.NETHER_BRICKS_PILLAR);
                entry.accept(MBItems.CRACKED_RED_NETHER_BRICKS);
                entry.accept(MBItems.CHISELED_RED_NETHER_BRICKS);
                entry.accept(MBItems.RED_NETHER_BRICKS_PILLAR);
                entry.accept(MBItems.BLACKSTONE_PILLAR);
                entry.accept(MBItems.POLISHED_BLACKSTONE_TILES);
                entry.accept(MBItems.CRACKED_POLISHED_BLACKSTONE_TILES);
                entry.accept(MBItems.POLISHED_BLACKSTONE_TILES_STAIRS);
                entry.accept(MBItems.POLISHED_BLACKSTONE_TILES_SLAB);
                entry.accept(MBItems.POLISHED_BLACKSTONE_TILES_WALL);
                entry.accept(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS);
                entry.accept(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS_SLAB);
                entry.accept(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_BLACKSTONE);
                entry.accept(MBItems.POLISHED_END_STONE);
                entry.accept(MBItems.POLISHED_END_STONE_STAIRS);
                entry.accept(MBItems.POLISHED_END_STONE_SLAB);
                entry.accept(MBItems.CHISELED_END_STONE);
                entry.accept(MBItems.CRACKED_END_STONE_BRICKS);
                entry.accept(MBItems.END_STONE_PILLAR);
                entry.accept(MBItems.END_STONE_TILES);
                entry.accept(MBItems.END_STONE_TILES_STAIRS);
                entry.accept(MBItems.END_STONE_TILES_SLAB);
                entry.accept(MBItems.END_STONE_TILES_WALL);
                entry.accept(MBItems.MOSSY_END_STONE_BRICKS);
                entry.accept(MBItems.MOSSY_END_STONE_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_END_STONE_BRICKS_SLAB);
                entry.accept(MBItems.MOSSY_END_STONE_BRICKS_WALL);
                entry.accept(MBItems.SMOOTH_END_STONE);
                entry.accept(MBItems.SMOOTH_END_STONE_SLAB);
                entry.accept(MBItems.POLISHED_PURPUR);
                entry.accept(MBItems.POLISHED_PURPUR_STAIRS);
                entry.accept(MBItems.POLISHED_PURPUR_SLAB);
                entry.accept(MBItems.CHISELED_PURPUR);
                entry.accept(MBItems.CRACKED_PURPUR_BLOCK);
                entry.accept(MBItems.PURPUR_TILES);
                entry.accept(MBItems.PURPUR_TILES_STAIRS);
                entry.accept(MBItems.PURPUR_TILES_SLAB);
                entry.accept(MBItems.PURPUR_TILES_WALL);
                entry.accept(MBItems.MOSSY_PURPUR_BLOCK);
                entry.accept(MBItems.MOSSY_PURPUR_BLOCK_STAIRS);
                entry.accept(MBItems.MOSSY_PURPUR_BLOCK_SLAB);
                entry.accept(MBItems.MOSSY_PURPUR_BLOCK_WALL);
                entry.accept(MBItems.SMOOTH_PURPUR);
                entry.accept(MBItems.SMOOTH_PURPUR_SLAB);
                entry.accept(MBItems.COAL_BRICKS);
                entry.accept(MBItems.CRACKED_COAL_BRICKS);
                entry.accept(MBItems.COAL_PILLAR);
                entry.accept(MBItems.CUT_COAL);
                entry.accept(MBItems.CRACKED_CUT_COAL);
                entry.accept(MBItems.IRON_BRICKS);
                entry.accept(MBItems.CRACKED_IRON_BRICKS);
                entry.accept(MBItems.IRON_PILLAR);
                entry.accept(MBItems.CUT_IRON);
                entry.accept(MBItems.CRACKED_CUT_IRON);
                entry.accept(MBItems.IRON_GRATE);
                entry.accept(MBItems.GOLD_BRICKS);
                entry.accept(MBItems.CRACKED_GOLD_BRICKS);
                entry.accept(MBItems.GOLD_PILLAR);
                entry.accept(MBItems.CUT_GOLD);
                entry.accept(MBItems.CRACKED_CUT_GOLD);
                entry.accept(MBItems.REDSTONE_BRICKS);
                entry.accept(MBItems.CRACKED_REDSTONE_BRICKS);
                entry.accept(MBItems.REDSTONE_PILLAR);
                entry.accept(MBItems.CUT_REDSTONE);
                entry.accept(MBItems.CRACKED_CUT_REDSTONE);
                entry.accept(MBItems.EMERALD_BRICKS);
                entry.accept(MBItems.CRACKED_EMERALD_BRICKS);
                entry.accept(MBItems.EMERALD_PILLAR);
                entry.accept(MBItems.CUT_EMERALD);
                entry.accept(MBItems.CRACKED_CUT_EMERALD);
                entry.accept(MBItems.LAPIS_LAZULI_BRICKS);
                entry.accept(MBItems.CRACKED_LAPIS_LAZULI_BRICKS);
                entry.accept(MBItems.LAPIS_LAZULI_PILLAR);
                entry.accept(MBItems.CUT_LAPIS_LAZULI);
                entry.accept(MBItems.CRACKED_CUT_LAPIS_LAZULI);
                entry.accept(MBItems.DIAMOND_BRICKS);
                entry.accept(MBItems.CRACKED_DIAMOND_BRICKS);
                entry.accept(MBItems.DIAMOND_PILLAR);
                entry.accept(MBItems.CUT_DIAMOND);
                entry.accept(MBItems.CRACKED_CUT_DIAMOND);
                entry.accept(MBItems.DIAMOND_GRATE);
                entry.accept(MBItems.NETHERITE_BRICKS);
                entry.accept(MBItems.CRACKED_NETHERITE_BRICKS);
                entry.accept(MBItems.NETHERITE_PILLAR);
                entry.accept(MBItems.CUT_NETHERITE);
                entry.accept(MBItems.CRACKED_CUT_NETHERITE);
                entry.accept(MBItems.NETHERITE_GRATE);
                entry.accept(MBItems.CRACKED_QUARTZ_BRICKS);
                entry.accept(MBItems.CUT_QUARTZ);
                entry.accept(MBItems.CRACKED_CUT_QUARTZ);
                entry.accept(MBItems.MOSSY_QUARTZ_BRICKS);
                entry.accept(MBItems.MOSSY_QUARTZ_BRICKS_STAIRS);
                entry.accept(MBItems.MOSSY_QUARTZ_BRICKS_SLAB);
                entry.accept(MBItems.AMETHYST_BRICKS);
                entry.accept(MBItems.CRACKED_AMETHYST_BRICKS);
                entry.accept(MBItems.AMETHYST_PILLAR);
                entry.accept(MBItems.CUT_AMETHYST);
                entry.accept(MBItems.CRACKED_CUT_AMETHYST);
                entry.accept(MBItems.BONE_BLOCK_BRICKS);
                entry.accept(MBItems.CRACKED_BONE_BLOCK_BRICKS);
                entry.accept(MBItems.BONE_BLOCK_BRICKS_STAIRS);
                entry.accept(MBItems.BONE_BLOCK_BRICKS_SLAB);
                entry.accept(MBItems.BONE_BLOCK_BRICKS_WALL);
                entry.accept(MBItems.BONE_BLOCK_TILES);
                entry.accept(MBItems.CRACKED_BONE_BLOCK_TILES);
                entry.accept(MBItems.BONE_BLOCK_TILES_STAIRS);
                entry.accept(MBItems.BONE_BLOCK_TILES_SLAB);
                entry.accept(MBItems.BONE_BLOCK_TILES_WALL);
                entry.accept(MBItems.SOUL_SANDSTONE);
                entry.accept(MBItems.SOUL_SANDSTONE_STAIRS);
                entry.accept(MBItems.SOUL_SANDSTONE_SLAB);
                //entry.accept(MBItems.SOUL_SANDSTONE_WALL);
                entry.accept(MBItems.CHISELED_SOUL_SANDSTONE);
                entry.accept(MBItems.SOUL_SANDSTONE_BRICKS);
                entry.accept(MBItems.CRACKED_SOUL_SANDSTONE_BRICKS);
                entry.accept(MBItems.SOUL_SANDSTONE_BRICKS_STAIRS);
                entry.accept(MBItems.SOUL_SANDSTONE_BRICKS_SLAB);
                entry.accept(MBItems.SOUL_SANDSTONE_BRICKS_WALL);
                entry.accept(MBItems.SOUL_SANDSTONE_PILLAR);
                entry.accept(MBItems.SOUL_SANDSTONE_TILES);
                entry.accept(MBItems.CRACKED_SOUL_SANDSTONE_TILES);
                entry.accept(MBItems.SOUL_SANDSTONE_TILES_STAIRS);
                entry.accept(MBItems.SOUL_SANDSTONE_TILES_SLAB);
                entry.accept(MBItems.SOUL_SANDSTONE_TILES_WALL);
                entry.accept(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS);
                entry.accept(MBItems.SMOOTH_SOUL_SANDSTONE);
                entry.accept(MBItems.SMOOTH_SOUL_SANDSTONE_SLAB);
                entry.accept(MBItems.SMOOTH_SOUL_SANDSTONE_STAIRS);
                entry.accept(MBItems.CUT_SOUL_SANDSTONE);
                entry.accept(MBItems.CUT_SOUL_SANDSTONE_SLAB);

                entry.accept(MBItems.PACKED_SNOW);
                entry.accept(MBItems.PACKED_SNOW_STAIRS);
                entry.accept(MBItems.PACKED_SNOW_SLAB);
                entry.accept(MBItems.POLISHED_SNOW);
                entry.accept(MBItems.POLISHED_SNOW_STAIRS);
                entry.accept(MBItems.POLISHED_SNOW_SLAB);
                entry.accept(MBItems.SNOW_BRICKS);
                entry.accept(MBItems.CRACKED_SNOW_BRICKS);
                entry.accept(MBItems.SNOW_BRICKS_STAIRS);
                entry.accept(MBItems.SNOW_BRICKS_SLAB);
                entry.accept(MBItems.SNOW_BRICKS_WALL);
                entry.accept(MBItems.SNOW_PILLAR);
                entry.accept(MBItems.SNOW_TILES);
                entry.accept(MBItems.CRACKED_SNOW_TILES);
                entry.accept(MBItems.SNOW_TILES_STAIRS);
                entry.accept(MBItems.SNOW_TILES_SLAB);
                entry.accept(MBItems.SNOW_TILES_WALL);

                entry.accept(MBItems.POLISHED_ICE);
                entry.accept(MBItems.POLISHED_ICE_STAIRS);
                entry.accept(MBItems.POLISHED_ICE_SLAB);
                entry.accept(MBItems.ICE_BRICKS);
                entry.accept(MBItems.CRACKED_ICE_BRICKS);
                entry.accept(MBItems.ICE_BRICKS_STAIRS);
                entry.accept(MBItems.ICE_BRICKS_SLAB);
                entry.accept(MBItems.ICE_BRICKS_WALL);
                entry.accept(MBItems.ICE_PILLAR);
                entry.accept(MBItems.ICE_TILES);
                entry.accept(MBItems.CRACKED_ICE_TILES);
                entry.accept(MBItems.ICE_TILES_STAIRS);
                entry.accept(MBItems.ICE_TILES_SLAB);
                entry.accept(MBItems.ICE_TILES_WALL);
            }).build();

    private static final CreativeModeTab MORE_COLORED_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MBItems.MAGENTA_SHINGLES))
            .title(Component.translatable("itemGroup.moreblocks.coloredBlocks"))
            .displayItems((ctx, entry) -> {
                entry.accept(MBItems.TILED_GLASS);
                entry.accept(MBItems.TILED_TINTED_GLASS);
                entry.accept(MBItems.WHITE_STAINED_TILED_GLASS);
                entry.accept(MBItems.LIGHT_GRAY_STAINED_TILED_GLASS);
                entry.accept(MBItems.GRAY_STAINED_TILED_GLASS);
                entry.accept(MBItems.BLACK_STAINED_TILED_GLASS);
                entry.accept(MBItems.BROWN_STAINED_TILED_GLASS);
                entry.accept(MBItems.RED_STAINED_TILED_GLASS);
                entry.accept(MBItems.ORANGE_STAINED_TILED_GLASS);
                entry.accept(MBItems.YELLOW_STAINED_TILED_GLASS);
                entry.accept(MBItems.LIME_STAINED_TILED_GLASS);
                entry.accept(MBItems.GREEN_STAINED_TILED_GLASS);
                entry.accept(MBItems.CYAN_STAINED_TILED_GLASS);
                entry.accept(MBItems.LIGHT_BLUE_STAINED_TILED_GLASS);
                entry.accept(MBItems.BLUE_STAINED_TILED_GLASS);
                entry.accept(MBItems.PURPLE_STAINED_TILED_GLASS);
                entry.accept(MBItems.MAGENTA_STAINED_TILED_GLASS);
                entry.accept(MBItems.PINK_STAINED_TILED_GLASS);
                entry.accept(MBItems.SHINGLES);
                entry.accept(MBItems.WHITE_SHINGLES);
                entry.accept(MBItems.LIGHT_GRAY_SHINGLES);
                entry.accept(MBItems.GRAY_SHINGLES);
                entry.accept(MBItems.BLACK_SHINGLES);
                entry.accept(MBItems.BROWN_SHINGLES);
                entry.accept(MBItems.RED_SHINGLES);
                entry.accept(MBItems.ORANGE_SHINGLES);
                entry.accept(MBItems.YELLOW_SHINGLES);
                entry.accept(MBItems.LIME_SHINGLES);
                entry.accept(MBItems.GREEN_SHINGLES);
                entry.accept(MBItems.CYAN_SHINGLES);
                entry.accept(MBItems.LIGHT_BLUE_SHINGLES);
                entry.accept(MBItems.BLUE_SHINGLES);
                entry.accept(MBItems.PURPLE_SHINGLES);
                entry.accept(MBItems.MAGENTA_SHINGLES);
                entry.accept(MBItems.PINK_SHINGLES);
                entry.accept(MBItems.TERRACOTTA_BRICKS);
                entry.accept(MBItems.WHITE_TERRACOTTA_BRICKS);
                entry.accept(MBItems.LIGHT_GRAY_TERRACOTTA_BRICKS);
                entry.accept(MBItems.GRAY_TERRACOTTA_BRICKS);
                entry.accept(MBItems.BLACK_TERRACOTTA_BRICKS);
                entry.accept(MBItems.BROWN_TERRACOTTA_BRICKS);
                entry.accept(MBItems.RED_TERRACOTTA_BRICKS);
                entry.accept(MBItems.ORANGE_TERRACOTTA_BRICKS);
                entry.accept(MBItems.YELLOW_TERRACOTTA_BRICKS);
                entry.accept(MBItems.LIME_TERRACOTTA_BRICKS);
                entry.accept(MBItems.GREEN_TERRACOTTA_BRICKS);
                entry.accept(MBItems.CYAN_TERRACOTTA_BRICKS);
                entry.accept(MBItems.LIGHT_BLUE_TERRACOTTA_BRICKS);
                entry.accept(MBItems.BLUE_TERRACOTTA_BRICKS);
                entry.accept(MBItems.PURPLE_TERRACOTTA_BRICKS);
                entry.accept(MBItems.MAGENTA_TERRACOTTA_BRICKS);
                entry.accept(MBItems.PINK_TERRACOTTA_BRICKS);
                entry.accept(MBItems.TERRACOTTA_TILES);
                entry.accept(MBItems.WHITE_TERRACOTTA_TILES);
                entry.accept(MBItems.LIGHT_GRAY_TERRACOTTA_TILES);
                entry.accept(MBItems.GRAY_TERRACOTTA_TILES);
                entry.accept(MBItems.BLACK_TERRACOTTA_TILES);
                entry.accept(MBItems.BROWN_TERRACOTTA_TILES);
                entry.accept(MBItems.RED_TERRACOTTA_TILES);
                entry.accept(MBItems.ORANGE_TERRACOTTA_TILES);
                entry.accept(MBItems.YELLOW_TERRACOTTA_TILES);
                entry.accept(MBItems.LIME_TERRACOTTA_TILES);
                entry.accept(MBItems.GREEN_TERRACOTTA_TILES);
                entry.accept(MBItems.CYAN_TERRACOTTA_TILES);
                entry.accept(MBItems.LIGHT_BLUE_TERRACOTTA_TILES);
                entry.accept(MBItems.BLUE_TERRACOTTA_TILES);
                entry.accept(MBItems.PURPLE_TERRACOTTA_TILES);
                entry.accept(MBItems.MAGENTA_TERRACOTTA_TILES);
                entry.accept(MBItems.PINK_TERRACOTTA_TILES);
                entry.accept(MBItems.WHITE_CONCRETE_BRICKS);
                entry.accept(MBItems.LIGHT_GRAY_CONCRETE_BRICKS);
                entry.accept(MBItems.GRAY_CONCRETE_BRICKS);
                entry.accept(MBItems.BLACK_CONCRETE_BRICKS);
                entry.accept(MBItems.BROWN_CONCRETE_BRICKS);
                entry.accept(MBItems.RED_CONCRETE_BRICKS);
                entry.accept(MBItems.ORANGE_CONCRETE_BRICKS);
                entry.accept(MBItems.YELLOW_CONCRETE_BRICKS);
                entry.accept(MBItems.LIME_CONCRETE_BRICKS);
                entry.accept(MBItems.GREEN_CONCRETE_BRICKS);
                entry.accept(MBItems.CYAN_CONCRETE_BRICKS);
                entry.accept(MBItems.LIGHT_BLUE_CONCRETE_BRICKS);
                entry.accept(MBItems.BLUE_CONCRETE_BRICKS);
                entry.accept(MBItems.PURPLE_CONCRETE_BRICKS);
                entry.accept(MBItems.MAGENTA_CONCRETE_BRICKS);
                entry.accept(MBItems.PINK_CONCRETE_BRICKS);
                entry.accept(MBItems.WHITE_CONCRETE_TILES);
                entry.accept(MBItems.LIGHT_GRAY_CONCRETE_TILES);
                entry.accept(MBItems.GRAY_CONCRETE_TILES);
                entry.accept(MBItems.BLACK_CONCRETE_TILES);
                entry.accept(MBItems.BROWN_CONCRETE_TILES);
                entry.accept(MBItems.RED_CONCRETE_TILES);
                entry.accept(MBItems.ORANGE_CONCRETE_TILES);
                entry.accept(MBItems.YELLOW_CONCRETE_TILES);
                entry.accept(MBItems.LIME_CONCRETE_TILES);
                entry.accept(MBItems.GREEN_CONCRETE_TILES);
                entry.accept(MBItems.CYAN_CONCRETE_TILES);
                entry.accept(MBItems.LIGHT_BLUE_CONCRETE_TILES);
                entry.accept(MBItems.BLUE_CONCRETE_TILES);
                entry.accept(MBItems.PURPLE_CONCRETE_TILES);
                entry.accept(MBItems.MAGENTA_CONCRETE_TILES);
                entry.accept(MBItems.PINK_CONCRETE_TILES);
            }).build();

    private static final CreativeModeTab MORE_NATURAL_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MBItems.TINY_CACTUS))
            .title(Component.translatable("itemGroup.moreblocks.naturalBlocks"))
            .displayItems((ctx, entry) -> {
                entry.accept(MBItems.TINY_CACTUS);
                entry.accept(MBItems.DUNE_GRASS);
                entry.accept(MBItems.TALL_DUNE_GRASS);
                entry.accept(MBItems.SNOW_GRASS);
                entry.accept(MBItems.TALL_SNOW_GRASS);
                entry.accept(MBItems.SNOW_FERN);
                entry.accept(MBItems.TALL_SNOW_FERN);
                entry.accept(MBItems.CATTAIL);
                entry.accept(MBItems.LEAVES_BUCKET);
                entry.accept(MBItems.FROZEN_LEAVES_BUCKET);
                entry.accept(MBItems.PINK_PETALS_BUCKET);
                entry.accept(MBItems.BIG_LILY_PAD);
                entry.accept(MBItems.SMALL_LILY_PADS);
                entry.accept(MBItems.LUMINOUS_FLOWER);
                entry.accept(MBItems.BROWN_MUSHROOM_COLONY);
                entry.accept(MBItems.RED_MUSHROOM_COLONY);
            }).build();



    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MoreBlocks.ID, "more_building_blocks"), MORE_BUILDING_BLOCKS);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MoreBlocks.ID, "more_colored_blocks"), MORE_COLORED_BLOCKS);
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(MoreBlocks.ID, "more_natural_blocks"), MORE_NATURAL_BLOCKS);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register((entry) -> {
            entry.addAfter(Items.FISHING_ROD, MBItems.CRACKING_TOOL);
        });
    }

    public static void entryWithoutFeatureFlag(CreativeModeTab.ItemDisplayParameters context, CreativeModeTab.Output entry, FeatureFlag feature, Item item) {
        if (!context.enabledFeatures().contains(feature)) {
            entry.accept(item);
        }
    }
}
