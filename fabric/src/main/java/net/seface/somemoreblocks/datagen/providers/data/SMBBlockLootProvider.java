package net.seface.somemoreblocks.datagen.providers.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.block.properties.QuadDirection;
import net.seface.somemoreblocks.registries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class SMBBlockLootProvider extends FabricBlockLootTableProvider {
  private static final List<BlockFamily> SHOULD_NOT_GENERATE_LOOT_TABLE = new ArrayList<>();

  public SMBBlockLootProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
    super(output, lookup);

    SHOULD_NOT_GENERATE_LOOT_TABLE.addAll(List.of(
      SMBBlockFamilies.PACKED_SNOW, SMBBlockFamilies.POLISHED_SNOW, SMBBlockFamilies.SNOW_BRICKS,
      SMBBlockFamilies.SNOW_TILES, SMBBlockFamilies.POLISHED_ICE, SMBBlockFamilies.ICE_BRICKS,
      SMBBlockFamilies.ICE_TILES
    ));
  }

  @Override
  public void generate() {
    this.dropSelfBlockFamilyBlocks();

    /* More Building Block */
    this.dropSelf(SMBBlocks.CARVED_OAK_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_OAK_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_SPRUCE_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_SPRUCE_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_BIRCH_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_BIRCH_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_JUNGLE_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_JUNGLE_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_ACACIA_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_ACACIA_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_DARK_OAK_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_DARK_OAK_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_MANGROVE_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_MANGROVE_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_CRIMSON_STEM.get());
    this.dropSelf(SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
    this.dropSelf(SMBBlocks.CARVED_WARPED_STEM.get());
    this.dropSelf(SMBBlocks.CARVED_WARPED_HYPHAE.get());
    this.dropSelf(SMBBlocks.CARVED_CHERRY_LOG.get());
    this.dropSelf(SMBBlocks.CARVED_CHERRY_WOOD.get());
    this.dropSelfCarvedPaleOak(SMBBlocks.CARVED_PALE_OAK_LOG.get());
    this.dropSelfCarvedPaleOak(SMBBlocks.CARVED_PALE_OAK_WOOD.get());
    this.dropSelf(SMBBlocks.CARVED_BAMBOO_BLOCK.get());
    this.dropSelf(SMBBlocks.AMETHYST_PILLAR.get());
    this.dropSelf(SMBBlocks.ANDESITE_PILLAR.get());
    this.dropSelf(SMBBlocks.CALCITE_PILLAR.get());
    this.dropSelf(SMBBlocks.COAL_PILLAR.get());
    this.dropSelf(SMBBlocks.COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.DEEPSLATE_PILLAR.get());
    this.dropSelf(SMBBlocks.DIAMOND_PILLAR.get());
    this.dropSelf(SMBBlocks.DIORITE_PILLAR.get());
    this.dropSelf(SMBBlocks.DRIPSTONE_PILLAR.get());
    this.dropSelf(SMBBlocks.EMERALD_PILLAR.get());
    this.dropSelf(SMBBlocks.END_STONE_PILLAR.get());
    this.dropSelf(SMBBlocks.CHISELED_END_STONE_BRICKS.get());
    this.dropSelf(SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.GOLD_PILLAR.get());
    this.dropSelf(SMBBlocks.GRANITE_PILLAR.get());
    this.dropSelf(SMBBlocks.IRON_PILLAR.get());
    this.dropSelf(SMBBlocks.LAPIS_PILLAR.get());
    this.dropSelf(SMBBlocks.MUD_PILLAR.get());
    this.dropSelf(SMBBlocks.CHISELED_MUD_BRICKS.get());
    this.dropSelf(SMBBlocks.NETHER_BRICKS_PILLAR.get());
    this.dropSelf(SMBBlocks.NETHERITE_PILLAR.get());
    this.dropSelf(SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get());
    this.dropSelf(SMBBlocks.PRISMARINE_PILLAR.get());
    this.dropSelf(SMBBlocks.CHISELED_PRISMARINE_BRICKS.get());
    this.dropSelf(SMBBlocks.CHISELED_PURPUR.get());
    this.dropSelf(SMBBlocks.RED_NETHER_BRICKS_PILLAR.get());
    this.dropSelf(SMBBlocks.CHISELED_RED_NETHER_BRICKS.get());
    this.dropSelf(SMBBlocks.RED_SANDSTONE_PILLAR.get());
    this.dropSelf(SMBBlocks.REDSTONE_PILLAR.get());
    this.dropSelf(SMBBlocks.SANDSTONE_PILLAR.get());
    this.dropSelf(SMBBlocks.SNOW_PILLAR.get());
    this.dropSelf(SMBBlocks.SOUL_SANDSTONE_PILLAR.get());
    this.dropSelf(SMBBlocks.CHISELED_SOUL_SANDSTONE.get());
    this.dropSelf(SMBBlocks.STONE_PILLAR.get());
    this.dropSelf(SMBBlocks.TUFF_PILLAR.get());
    this.dropSelf(SMBBlocks.WAXED_COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    this.dropSelf(SMBBlocks.CRACKED_BRICKS.get());
    this.dropSelf(SMBBlocks.CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.CRACKED_END_STONE_BRICKS.get());
    this.dropSelf(SMBBlocks.CRACKED_MUD_BRICKS.get());
    this.dropSelf(SMBBlocks.CRACKED_PRISMARINE_BRICKS.get());
    this.dropSelf(SMBBlocks.CRACKED_PURPUR_BLOCK.get());
    this.dropSelf(SMBBlocks.CRACKED_QUARTZ_BRICKS.get());
    this.dropSelf(SMBBlocks.CRACKED_RED_NETHER_BRICKS.get());
    this.dropSelf(SMBBlocks.CRACKED_TUFF_BRICKS.get());
    this.dropSelf(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    this.dropSelf(SMBBlocks.IRON_GRATE.get());
    this.dropSelf(SMBBlocks.DIAMOND_GRATE.get());
    this.dropSelf(SMBBlocks.NETHERITE_GRATE.get());
    this.dropWhenShovel(SMBBlocks.CRACKED_SNOW_BRICKS.get());
    this.dropWhenShovel(SMBBlocks.CRACKED_SNOW_TILES.get());
    this.dropWhenShovel(SMBBlocks.PACKED_SNOW.get());
    this.dropWhenShovelSlab(SMBBlocks.PACKED_SNOW_SLAB.get());
    this.dropWhenShovel(SMBBlocks.PACKED_SNOW_STAIRS.get());
    this.dropWhenShovel(SMBBlocks.POLISHED_SNOW.get());
    this.dropWhenShovelSlab(SMBBlocks.POLISHED_SNOW_SLAB.get());
    this.dropWhenShovel(SMBBlocks.POLISHED_SNOW_STAIRS.get());
    this.dropWhenShovelSlab(SMBBlocks.SNOW_BRICK_SLAB.get());
    this.dropWhenShovel(SMBBlocks.SNOW_BRICK_STAIRS.get());
    this.dropWhenShovel(SMBBlocks.SNOW_BRICK_WALL.get());
    this.dropWhenShovel(SMBBlocks.SNOW_BRICKS.get());
    this.dropWhenShovelSlab(SMBBlocks.SNOW_TILE_SLAB.get());
    this.dropWhenShovel(SMBBlocks.SNOW_TILE_STAIRS.get());
    this.dropWhenShovel(SMBBlocks.SNOW_TILE_WALL.get());
    this.dropWhenShovel(SMBBlocks.SNOW_TILES.get());
    this.dropWhenSilkTouch(SMBBlocks.POLISHED_ICE.get());
    this.dropWhenSilkTouch(SMBBlocks.POLISHED_ICE_STAIRS.get());
    this.dropWhenSilkTouch(SMBBlocks.POLISHED_ICE_SLAB.get());
    this.dropWhenSilkTouch(SMBBlocks.ICE_BRICKS.get());
    this.dropWhenSilkTouch(SMBBlocks.CRACKED_ICE_BRICKS.get());
    this.dropWhenSilkTouch(SMBBlocks.ICE_BRICK_STAIRS.get());
    this.dropWhenSilkTouchSlab(SMBBlocks.ICE_BRICK_SLAB.get());
    this.dropWhenSilkTouch(SMBBlocks.ICE_BRICK_WALL.get());
    this.dropWhenSilkTouch(SMBBlocks.ICE_PILLAR.get());
    this.dropWhenSilkTouch(SMBBlocks.ICE_TILES.get());
    this.dropWhenSilkTouch(SMBBlocks.CRACKED_ICE_TILES.get());
    this.dropWhenSilkTouch(SMBBlocks.ICE_TILE_STAIRS.get());
    this.dropWhenSilkTouchSlab(SMBBlocks.ICE_TILE_SLAB.get());
    this.dropWhenSilkTouch(SMBBlocks.ICE_TILE_WALL.get());

    /* More Colored Blocks */
    this.dropWhenSilkTouch(SMBBlocks.TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.TILED_TINTED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.WHITE_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.GRAY_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.BLACK_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.BROWN_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.RED_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.LIME_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.GREEN_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.CYAN_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.BLUE_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.PINK_STAINED_TILED_GLASS.get());
    this.dropWhenSilkTouch(SMBBlocks.TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get());
    this.dropWhenSilkTouch(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get());
    this.dropSelf(SMBBlocks.SHINGLES.get());
    this.dropSelf(SMBBlocks.WHITE_SHINGLES.get());
    this.dropSelf(SMBBlocks.LIGHT_GRAY_SHINGLES.get());
    this.dropSelf(SMBBlocks.GRAY_SHINGLES.get());
    this.dropSelf(SMBBlocks.BLACK_SHINGLES.get());
    this.dropSelf(SMBBlocks.BROWN_SHINGLES.get());
    this.dropSelf(SMBBlocks.RED_SHINGLES.get());
    this.dropSelf(SMBBlocks.ORANGE_SHINGLES.get());
    this.dropSelf(SMBBlocks.YELLOW_SHINGLES.get());
    this.dropSelf(SMBBlocks.LIME_SHINGLES.get());
    this.dropSelf(SMBBlocks.GREEN_SHINGLES.get());
    this.dropSelf(SMBBlocks.CYAN_SHINGLES.get());
    this.dropSelf(SMBBlocks.LIGHT_BLUE_SHINGLES.get());
    this.dropSelf(SMBBlocks.BLUE_SHINGLES.get());
    this.dropSelf(SMBBlocks.PURPLE_SHINGLES.get());
    this.dropSelf(SMBBlocks.MAGENTA_SHINGLES.get());
    this.dropSelf(SMBBlocks.PINK_SHINGLES.get());
    this.dropSelf(SMBBlocks.TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.WHITE_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.GRAY_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.BLACK_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.BROWN_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.RED_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.LIME_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.GREEN_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.CYAN_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.BLUE_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.PINK_TERRACOTTA_BRICKS.get());
    this.dropSelf(SMBBlocks.TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.WHITE_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.GRAY_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.BLACK_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.BROWN_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.RED_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.ORANGE_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.YELLOW_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.LIME_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.GREEN_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.CYAN_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.BLUE_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.PURPLE_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.MAGENTA_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.PINK_TERRACOTTA_TILES.get());
    this.dropSelf(SMBBlocks.WHITE_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.GRAY_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.BLACK_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.BROWN_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.RED_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.ORANGE_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.YELLOW_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.LIME_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.GREEN_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.CYAN_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.BLUE_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.PURPLE_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.MAGENTA_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.PINK_CONCRETE_BRICKS.get());
    this.dropSelf(SMBBlocks.WHITE_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.LIGHT_GRAY_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.GRAY_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.BLACK_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.BROWN_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.RED_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.ORANGE_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.YELLOW_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.LIME_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.GREEN_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.CYAN_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.LIGHT_BLUE_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.BLUE_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.PURPLE_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.MAGENTA_CONCRETE_TILES.get());
    this.dropSelf(SMBBlocks.PINK_CONCRETE_TILES.get());

    /* More Natural Blocks */
    this.dropSelf(SMBBlocks.TINY_CACTUS.get());
    this.dropWhenShears(SMBBlocks.DUNE_GRASS.get());
    this.dropWhenShearsDoublePlant(SMBBlocks.TALL_DUNE_GRASS.get(), SMBBlocks.DUNE_GRASS.get());
    this.dropWhenShears(SMBBlocks.SHORT_SNOW_GRASS.get());
    this.dropWhenShearsDoublePlant(SMBBlocks.TALL_SNOW_GRASS.get(), SMBBlocks.SHORT_SNOW_GRASS.get());
    this.dropWhenShears(SMBBlocks.SNOW_FERN.get());
    this.dropWhenShearsDoublePlant(SMBBlocks.LARGE_SNOW_FERN.get(), SMBBlocks.SNOW_FERN.get());
    this.dropWhenShears(SMBBlocks.CATTAIL.get());
    this.dropSelf(SMBBlocks.SMALL_LILY_PADS.get());
    this.dropBigLilyPad(SMBBlocks.BIG_LILY_PAD.get());
    this.dropSelf(SMBBlocks.LUMINOUS_FLOWER.get());
    this.dropSmallMushroomColony(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), SMBItems.BROWN_MUSHROOM_COLONY.get(), Items.BROWN_MUSHROOM, 2);
    this.dropSmallMushroomColony(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), SMBItems.BROWN_MUSHROOM_COLONY.get(), Items.BROWN_MUSHROOM, 2);
    this.dropTallMushroomColony(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), SMBItems.BROWN_MUSHROOM_COLONY.get(), Items.BROWN_MUSHROOM);
    this.dropSmallMushroomColony(SMBBlocks.RED_MUSHROOM_COLONY.get(), SMBItems.RED_MUSHROOM_COLONY.get(), Items.RED_MUSHROOM, 2);
    this.dropSmallMushroomColony(SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), SMBItems.RED_MUSHROOM_COLONY.get(), Items.RED_MUSHROOM, 2);
    this.dropTallMushroomColony(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), SMBItems.RED_MUSHROOM_COLONY.get(), Items.RED_MUSHROOM);
    this.dropSmallMushroomColony(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), SMBItems.CRIMSON_FUNGUS_COLONY.get(), Items.CRIMSON_FUNGUS, 2);
    this.dropSmallMushroomColony(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), SMBItems.CRIMSON_FUNGUS_COLONY.get(), Items.CRIMSON_FUNGUS, 2);
    this.dropTallMushroomColony(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), SMBItems.CRIMSON_FUNGUS_COLONY.get(), Items.CRIMSON_FUNGUS);
    this.dropSmallMushroomColony(SMBBlocks.WARPED_FUNGUS_COLONY.get(), SMBItems.WARPED_FUNGUS_COLONY.get(), Items.WARPED_FUNGUS, 2);
    this.dropSmallMushroomColony(SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), SMBItems.WARPED_FUNGUS_COLONY.get(), Items.WARPED_FUNGUS, 2);
    this.dropTallMushroomColony(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), SMBItems.WARPED_FUNGUS_COLONY.get(), Items.WARPED_FUNGUS);
    this.dropPottedContents(SMBBlocks.POTTED_TINY_CACTUS.get());
    this.dropPottedContents(SMBBlocks.POTTED_LUMINOUS_FLOWER.get());
    this.dropPottedContents(SMBBlocks.POTTED_SNOW_FERN.get());

    /* More Redstone Blocks */
    this.dropSelf(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get());
    this.dropSelf(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get());
    this.dropSelf(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get());
    this.dropSelf(SMBBlocks.REDSTONE_SHROOMLIGHT.get());
  }

  /**
   * Generate all loot tables for all custom Block Families.
   */
  private void dropSelfBlockFamilyBlocks() {
    for (Map.Entry<Block, BlockFamily> entry : SMBBlockFamilies.getAllFamilies().entrySet()) {
      if (SHOULD_NOT_GENERATE_LOOT_TABLE.contains(entry.getValue())) continue;

      for (Map.Entry<BlockFamily.Variant, Block> variantEntry : entry.getValue().getVariants().entrySet()) {
        if (variantEntry.getKey() == BlockFamily.Variant.SLAB) {
          this.add(variantEntry.getValue(), this.createSlabItemTable(variantEntry.getValue()).setRandomSequence(ModelLocationUtils.getModelLocation(variantEntry.getValue())));
          continue;
        }

        this.dropSelf(variantEntry.getValue());
      }

      this.dropSelf(entry.getKey());
    }
  }

  private void dropTallMushroomColony(Block block, ItemLike whenShearsItem, ItemLike otherItem) {
    this.add(block, LootTable.lootTable()
      .withPool(LootPool.lootPool()
        .setRolls(ConstantValue.exactly(1.0F))
        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))
        .when(LocationCheck.checkLocation(
          LocationPredicate.Builder.location()
            .setBlock(BlockPredicate.Builder.block()
              .of(this.registries.lookupOrThrow(Registries.BLOCK), block)
              .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))
            ), new BlockPos(0, 1, 0)
        ))
        .add(AlternativesEntry.alternatives(LootItem.lootTableItem(whenShearsItem).when(this.hasShears()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
          .otherwise(LootItem.lootTableItem(otherItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
        )
      )

      .withPool(LootPool.lootPool()
        .setRolls(ConstantValue.exactly(1.0F))
        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)))
        .when(LocationCheck.checkLocation(
          LocationPredicate.Builder.location()
            .setBlock(BlockPredicate.Builder.block()
              .of(this.registries.lookupOrThrow(Registries.BLOCK), block)
              .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))
            ), new BlockPos(0, -1, 0)
        ))
        .add(AlternativesEntry.alternatives(LootItem.lootTableItem(whenShearsItem).when(this.hasShears()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
          .otherwise(LootItem.lootTableItem(otherItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))))
        )
      )
    );
  }

  private void dropSmallMushroomColony(Block block, ItemLike whenShearsItem, ItemLike otherItem, float otherAmount) {
    this.add(block, LootTable.lootTable()
      .withPool(LootPool.lootPool()
        .setRolls(ConstantValue.exactly(1.0F))
        .add(AlternativesEntry.alternatives(LootItem.lootTableItem(whenShearsItem).when(this.hasShears()))
          .otherwise(LootItem.lootTableItem(otherItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(otherAmount))))
        )
      )
    );
  }

  private void dropBigLilyPad(Block block) {
    this.add(block, LootTable.lootTable()
      .withPool(LootPool.lootPool()
        .setRolls(ConstantValue.exactly(1.0F))
        .when(
          LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
            .setProperties(StatePropertiesPredicate.Builder.properties()
              .hasProperty(SMBBlockStateProperties.POSITION, QuadDirection.BOTTOM_LEFT))
        )
        .add(LootItem.lootTableItem(block))
      )
    );
  }

  /**
   * Specific to Carved Pale Log/Wood loot table where drops the correct item by the
   * moon_phase block state.
   */
  private void dropSelfCarvedPaleOak(Block block) {
    LootPoolSingletonContainer.Builder<?> lootItem = LootItem.lootTableItem(block);

    for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE ; i++) {
      lootItem.apply(
        SetComponentsFunction.setComponent(SMBDataComponentTypes.MOON_PHASE.get(), i)
          .when(
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
              .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RotatedCarvedPaleOakBlock.MOON_PHASE, i))
          )
      );
    }

    this.add(block,
      LootTable.lootTable()
        .withPool(LootPool.lootPool()
          .setRolls(ConstantValue.exactly(1.0F))
          .setBonusRolls(ConstantValue.exactly(0.0F))
          .add(lootItem))
        .setRandomSequence(ModelLocationUtils.getModelLocation(block)));
  }

  private void dropWhenShovel(Block block) {
    this.add(block, LootTable.lootTable()
      .withPool(LootPool.lootPool()
        .setRolls(ConstantValue.exactly(1.0F))
        .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(this.registries.lookupOrThrow(Registries.ITEM), ItemTags.SHOVELS)))
        .add(LootItem.lootTableItem(block)))
    );
  }

  private void dropWhenShovelSlab(Block block) {
    this.add(block, LootTable.lootTable()
      .withPool(
        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
          .add(
            this.applyExplosionDecay(block, LootItem.lootTableItem(block)
              .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(this.registries.lookupOrThrow(Registries.ITEM), ItemTags.SHOVELS)))
              .apply(
                SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                  .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))
              )
            )
          )
      )
    );
  }

  /**
   * Drop the block item when broken with shears.
   * @param block The affected block.
   */
  private void dropWhenShears(Block block) {
    this.add(block, this.createShearsOnlyDrop(block));
  }

  /**
   * Drop an item when break a double plant block with shears.
   * @param block The affected plant block.
   * @param dropBlock The dropped plant block in place.
   */
  private void dropWhenShearsDoublePlant(Block block, Block dropBlock) {
    this.add(block, this.createDoublePlantShearsDrop(dropBlock));
  }

  /**
   * Generic slab drop with silk touch condition.
   */
  private void dropWhenSilkTouchSlab(Block block) {
    this.add(block, LootTable.lootTable()
      .withPool(
        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
          .add(
            this.applyExplosionDecay(block, LootItem.lootTableItem(block)
              .when(this.hasSilkTouch())
              .apply(
                SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                  .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))
              )
            )
          )
      )
    );
  }
}
