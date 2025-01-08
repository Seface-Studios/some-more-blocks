package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.datagen.core.RecipeAdvancement;
import net.seface.somemoreblocks.datagen.core.RecipeAdvancementGroupType;
import net.seface.somemoreblocks.registry.MBItems;

import java.util.function.Consumer;

public class RecipeAdvancementProvider extends FabricAdvancementProvider {
  protected RecipeAdvancementProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateAdvancement(Consumer<AdvancementHolder> consumer) {
    RecipeAdvancement.setConsumer(consumer);

    RecipeAdvancement.create(Items.GREEN_DYE, RecipeAdvancementGroupType.MISC).craftableFrom(MBItems.TINY_CACTUS).build();
    RecipeAdvancement.create(Items.GLOWSTONE_DUST, RecipeAdvancementGroupType.MISC).craftableFrom(MBItems.LUMINOUS_FLOWER).build();

    RecipeAdvancement
      .group("Mosaics", (instance) -> instance
        .setExpectedEntries(10)
        .create(MBItems.OAK_MOSAIC).craftableFrom(Blocks.OAK_SLAB)
        .create(MBItems.SPRUCE_MOSAIC).craftableFrom(Blocks.SPRUCE_SLAB)
        .create(MBItems.BIRCH_MOSAIC).craftableFrom(Blocks.BIRCH_SLAB)
        .create(MBItems.JUNGLE_MOSAIC).craftableFrom(Blocks.JUNGLE_SLAB)
        .create(MBItems.ACACIA_MOSAIC).craftableFrom(Blocks.ACACIA_SLAB)
        .create(MBItems.DARK_OAK_MOSAIC).craftableFrom(Blocks.DARK_OAK_SLAB)
        .create(MBItems.MANGROVE_MOSAIC).craftableFrom(Blocks.MANGROVE_SLAB)
        .create(MBItems.CRIMSON_MOSAIC).craftableFrom(Blocks.CRIMSON_SLAB)
        .create(MBItems.WARPED_MOSAIC).craftableFrom(Blocks.WARPED_SLAB)
        .create(MBItems.CHERRY_MOSAIC).craftableFrom(Blocks.CHERRY_SLAB)
      ).build();

    RecipeAdvancement
      .group("Mosaic Stairs", (instance) -> instance
        .setExpectedEntries(10)
        .create(MBItems.OAK_MOSAIC_STAIRS).craftableFrom(MBItems.OAK_MOSAIC)
        .create(MBItems.SPRUCE_MOSAIC_STAIRS).craftableFrom(MBItems.SPRUCE_MOSAIC)
        .create(MBItems.BIRCH_MOSAIC_STAIRS).craftableFrom(MBItems.BIRCH_MOSAIC)
        .create(MBItems.JUNGLE_MOSAIC_STAIRS).craftableFrom(MBItems.JUNGLE_MOSAIC)
        .create(MBItems.ACACIA_MOSAIC_STAIRS).craftableFrom(MBItems.ACACIA_MOSAIC)
        .create(MBItems.DARK_OAK_MOSAIC_STAIRS).craftableFrom(MBItems.DARK_OAK_MOSAIC)
        .create(MBItems.MANGROVE_MOSAIC_STAIRS).craftableFrom(MBItems.MANGROVE_MOSAIC)
        .create(MBItems.CRIMSON_MOSAIC_STAIRS).craftableFrom(MBItems.CRIMSON_MOSAIC)
        .create(MBItems.WARPED_MOSAIC_STAIRS).craftableFrom(MBItems.WARPED_MOSAIC)
        .create(MBItems.CHERRY_MOSAIC_STAIRS).craftableFrom(MBItems.CHERRY_MOSAIC)
      ).build();

    RecipeAdvancement
      .group("Mosaic Slabs", (instance) -> instance
        .setExpectedEntries(10)
        .create(MBItems.OAK_MOSAIC_SLAB).craftableFrom(MBItems.OAK_MOSAIC)
        .create(MBItems.SPRUCE_MOSAIC_SLAB).craftableFrom(MBItems.SPRUCE_MOSAIC)
        .create(MBItems.BIRCH_MOSAIC_SLAB).craftableFrom(MBItems.BIRCH_MOSAIC)
        .create(MBItems.JUNGLE_MOSAIC_SLAB).craftableFrom(MBItems.JUNGLE_MOSAIC)
        .create(MBItems.ACACIA_MOSAIC_SLAB).craftableFrom(MBItems.ACACIA_MOSAIC)
        .create(MBItems.DARK_OAK_MOSAIC_SLAB).craftableFrom(MBItems.DARK_OAK_MOSAIC)
        .create(MBItems.MANGROVE_MOSAIC_SLAB).craftableFrom(MBItems.MANGROVE_MOSAIC)
        .create(MBItems.CRIMSON_MOSAIC_SLAB).craftableFrom(MBItems.CRIMSON_MOSAIC)
        .create(MBItems.WARPED_MOSAIC_SLAB).craftableFrom(MBItems.WARPED_MOSAIC)
        .create(MBItems.CHERRY_MOSAIC_SLAB).craftableFrom(MBItems.CHERRY_MOSAIC)
      ).build();

    RecipeAdvancement
      .group("Stone Variations", (instance) -> instance
        .create(MBItems.POLISHED_STONE).cuttableFrom(Blocks.STONE)
        .create(MBItems.POLISHED_STONE_STAIRS).craftableFrom(MBItems.POLISHED_STONE).cuttableFrom(Blocks.STONE, MBItems.POLISHED_STONE)
        .create(MBItems.POLISHED_STONE_SLAB).craftableFrom(MBItems.POLISHED_STONE).cuttableFrom(Blocks.STONE, MBItems.POLISHED_STONE)
        .create(MBItems.STONE_PILLAR).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE)
        .create(MBItems.STONE_TILES).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE, MBItems.POLISHED_STONE, Blocks.STONE_BRICKS)
        .create(MBItems.CRACKED_STONE_TILES).craftableFrom(MBItems.STONE_TILES)
        .create(MBItems.STONE_TILE_STAIRS).craftableFrom(MBItems.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, MBItems.STONE_TILES, MBItems.POLISHED_STONE, Blocks.STONE)
        .create(MBItems.STONE_TILE_SLAB).craftableFrom(MBItems.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, MBItems.STONE_TILES, MBItems.POLISHED_STONE, Blocks.STONE)
        .create(MBItems.STONE_TILE_WALL).craftableFrom(MBItems.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, MBItems.STONE_TILES, MBItems.POLISHED_STONE, Blocks.STONE)
      ).build();

    RecipeAdvancement
      .group("Granite Variations", (instance) -> instance
        .create(MBItems.CHISELED_GRANITE_BRICKS).craftableFrom(MBItems.GRANITE_BRICK_SLAB).cuttableFrom(Blocks.GRANITE, MBItems.GRANITE_BRICKS)
        .create(MBItems.GRANITE_BRICKS).craftableFrom(Blocks.POLISHED_GRANITE).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE)
        .create(MBItems.CRACKED_GRANITE_BRICKS).craftableFrom(MBItems.GRANITE_BRICKS)
        .create(MBItems.GRANITE_BRICK_STAIRS).craftableFrom(MBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, MBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(MBItems.GRANITE_BRICK_SLAB).craftableFrom(MBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, MBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(MBItems.GRANITE_BRICK_WALL).craftableFrom(MBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, MBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(MBItems.GRANITE_PILLAR).craftableFrom(MBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE)
        .create(MBItems.GRANITE_TILES).craftableFrom(MBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE, MBItems.GRANITE_BRICKS)
        .create(MBItems.CRACKED_GRANITE_TILES).craftableFrom(MBItems.GRANITE_TILES)
        .create(MBItems.GRANITE_TILE_STAIRS).craftableFrom(MBItems.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, MBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, MBItems.GRANITE_TILES)
        .create(MBItems.GRANITE_TILE_SLAB).craftableFrom(MBItems.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, MBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, MBItems.GRANITE_TILES)
        .create(MBItems.GRANITE_TILE_WALL).craftableFrom(MBItems.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, MBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, MBItems.GRANITE_TILES)
        .create(MBItems.MOSSY_GRANITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_GRANITE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_GRANITE_BRICKS).cuttableFrom(MBItems.MOSSY_GRANITE_BRICKS)
        .create(MBItems.MOSSY_GRANITE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_GRANITE_BRICKS).cuttableFrom(MBItems.MOSSY_GRANITE_BRICKS)
        .create(MBItems.MOSSY_GRANITE_BRICK_WALL).craftableFrom(MBItems.MOSSY_GRANITE_BRICKS).cuttableFrom(MBItems.MOSSY_GRANITE_BRICKS)
        .create(MBItems.SMOOTH_GRANITE).craftableFrom(Blocks.GRANITE)
        .create(MBItems.SMOOTH_GRANITE_SLAB).craftableFrom(MBItems.SMOOTH_GRANITE).cuttableFrom(MBItems.SMOOTH_GRANITE)
      ).build();

    RecipeAdvancement
      .group("Diorite Variations", (instance) -> instance
        .create(MBItems.CHISELED_DIORITE_BRICKS).craftableFrom(MBItems.DIORITE_BRICK_SLAB).cuttableFrom(Blocks.DIORITE, MBItems.DIORITE_BRICKS)
        .create(MBItems.DIORITE_BRICKS).craftableFrom(Blocks.POLISHED_DIORITE).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE)
        .create(MBItems.CRACKED_DIORITE_BRICKS).craftableFrom(MBItems.DIORITE_BRICKS)
        .create(MBItems.DIORITE_BRICK_STAIRS).craftableFrom(MBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, MBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(MBItems.DIORITE_BRICK_SLAB).craftableFrom(MBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, MBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(MBItems.DIORITE_BRICK_WALL).craftableFrom(MBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, MBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(MBItems.DIORITE_PILLAR).craftableFrom(MBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE)
        .create(MBItems.DIORITE_TILES).craftableFrom(MBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE, MBItems.DIORITE_BRICKS)
        .create(MBItems.CRACKED_DIORITE_TILES).craftableFrom(MBItems.DIORITE_TILES)
        .create(MBItems.DIORITE_TILE_STAIRS).craftableFrom(MBItems.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, MBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, MBItems.DIORITE_TILES)
        .create(MBItems.DIORITE_TILE_SLAB).craftableFrom(MBItems.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, MBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, MBItems.DIORITE_TILES)
        .create(MBItems.DIORITE_TILE_WALL).craftableFrom(MBItems.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, MBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, MBItems.DIORITE_TILES)
        .create(MBItems.MOSSY_DIORITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_DIORITE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_DIORITE_BRICKS).cuttableFrom(MBItems.MOSSY_DIORITE_BRICKS)
        .create(MBItems.MOSSY_DIORITE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_DIORITE_BRICKS).cuttableFrom(MBItems.MOSSY_DIORITE_BRICKS)
        .create(MBItems.MOSSY_DIORITE_BRICK_WALL).craftableFrom(MBItems.MOSSY_DIORITE_BRICKS).cuttableFrom(MBItems.MOSSY_DIORITE_BRICKS)
        .create(MBItems.SMOOTH_DIORITE).craftableFrom(Blocks.DIORITE)
        .create(MBItems.SMOOTH_DIORITE_SLAB).craftableFrom(MBItems.SMOOTH_DIORITE).cuttableFrom(MBItems.SMOOTH_DIORITE)
      ).build();

    RecipeAdvancement
      .group("Andesite Variations", (instance) -> instance
        .create(MBItems.CHISELED_ANDESITE_BRICKS).craftableFrom(MBItems.ANDESITE_BRICK_SLAB).cuttableFrom(Blocks.ANDESITE, MBItems.ANDESITE_BRICKS)
        .create(MBItems.ANDESITE_BRICKS).craftableFrom(Blocks.POLISHED_ANDESITE).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE)
        .create(MBItems.CRACKED_ANDESITE_BRICKS).craftableFrom(MBItems.ANDESITE_BRICKS)
        .create(MBItems.ANDESITE_BRICK_STAIRS).craftableFrom(MBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, MBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(MBItems.ANDESITE_BRICK_SLAB).craftableFrom(MBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, MBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(MBItems.ANDESITE_BRICK_WALL).craftableFrom(MBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, MBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(MBItems.ANDESITE_PILLAR).craftableFrom(MBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE)
        .create(MBItems.ANDESITE_TILES).craftableFrom(MBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, MBItems.ANDESITE_BRICKS)
        .create(MBItems.CRACKED_ANDESITE_TILES).craftableFrom(MBItems.ANDESITE_TILES)
        .create(MBItems.ANDESITE_TILE_STAIRS).craftableFrom(MBItems.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, MBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, MBItems.ANDESITE_TILES)
        .create(MBItems.ANDESITE_TILE_SLAB).craftableFrom(MBItems.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, MBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, MBItems.ANDESITE_TILES)
        .create(MBItems.GRANITE_TILE_WALL).craftableFrom(MBItems.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, MBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, MBItems.ANDESITE_TILES)
        .create(MBItems.MOSSY_ANDESITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_ANDESITE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_ANDESITE_BRICKS).cuttableFrom(MBItems.MOSSY_ANDESITE_BRICKS)
        .create(MBItems.MOSSY_ANDESITE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_ANDESITE_BRICKS).cuttableFrom(MBItems.MOSSY_ANDESITE_BRICKS)
        .create(MBItems.MOSSY_ANDESITE_BRICK_WALL).craftableFrom(MBItems.MOSSY_ANDESITE_BRICKS).cuttableFrom(MBItems.MOSSY_ANDESITE_BRICKS)
        .create(MBItems.SMOOTH_ANDESITE).craftableFrom(Blocks.ANDESITE)
        .create(MBItems.SMOOTH_ANDESITE_SLAB).craftableFrom(MBItems.SMOOTH_ANDESITE).cuttableFrom(MBItems.SMOOTH_ANDESITE)
      ).build();

    RecipeAdvancement.create(MBItems.DEEPSLATE_PILLAR).craftableFrom(Blocks.DEEPSLATE_BRICKS).cuttableFrom(Blocks.DEEPSLATE).build();

    RecipeAdvancement
      .group("Calcite Variations", (instance) -> instance
        .create(MBItems.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE)
        .create(MBItems.POLISHED_CALCITE_STAIRS).craftableFrom(MBItems.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE)
        .create(MBItems.POLISHED_CALCITE_SLAB).craftableFrom(MBItems.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE)
        .create(MBItems.CHISELED_CALCITE_BRICKS).craftableFrom(MBItems.CALCITE_BRICK_SLAB).cuttableFrom(Blocks.CALCITE, MBItems.CALCITE_BRICKS)
        .create(MBItems.CALCITE_BRICKS).craftableFrom(Blocks.CALCITE).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE)
        .create(MBItems.CRACKED_CALCITE_BRICKS).craftableFrom(MBItems.CALCITE_BRICKS)
        .create(MBItems.CALCITE_BRICK_STAIRS).craftableFrom(MBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE, MBItems.CALCITE_BRICKS)
        .create(MBItems.CALCITE_BRICK_SLAB).craftableFrom(MBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE, MBItems.CALCITE_BRICKS)
        .create(MBItems.CALCITE_BRICK_WALL).craftableFrom(MBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE, MBItems.CALCITE_BRICKS)
        .create(MBItems.CALCITE_PILLAR).craftableFrom(MBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE)
        .create(MBItems.CALCITE_TILES).craftableFrom(MBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE, MBItems.CALCITE_BRICKS)
        .create(MBItems.CRACKED_CALCITE_TILES).craftableFrom(MBItems.CALCITE_TILES)
        .create(MBItems.CALCITE_TILE_STAIRS).craftableFrom(MBItems.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE, MBItems.CALCITE_BRICKS, MBItems.CALCITE_TILES)
        .create(MBItems.CALCITE_TILE_SLAB).craftableFrom(MBItems.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE, MBItems.CALCITE_BRICKS, MBItems.CALCITE_TILES)
        .create(MBItems.CALCITE_TILE_WALL).craftableFrom(MBItems.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, MBItems.POLISHED_CALCITE, MBItems.CALCITE_BRICKS, MBItems.CALCITE_TILES)
        .create(MBItems.MOSSY_CALCITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_CALCITE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_CALCITE_BRICKS).cuttableFrom(MBItems.MOSSY_CALCITE_BRICKS)
        .create(MBItems.MOSSY_CALCITE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_CALCITE_BRICKS).cuttableFrom(MBItems.MOSSY_CALCITE_BRICKS)
        .create(MBItems.MOSSY_CALCITE_BRICK_WALL).craftableFrom(MBItems.MOSSY_CALCITE_BRICKS).cuttableFrom(MBItems.MOSSY_CALCITE_BRICKS)
        .create(MBItems.SMOOTH_CALCITE).craftableFrom(Blocks.CALCITE)
        .create(MBItems.SMOOTH_CALCITE_SLAB).craftableFrom(MBItems.SMOOTH_CALCITE).cuttableFrom(MBItems.SMOOTH_CALCITE)
      ).build();

    RecipeAdvancement
      .group("Tuff Variations", (instance) -> instance
        .create(MBItems.POLISHED_TUFF).cuttableFrom(Blocks.TUFF)
        .create(MBItems.POLISHED_TUFF_STAIRS).craftableFrom(MBItems.POLISHED_TUFF).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF)
        .create(MBItems.POLISHED_TUFF_SLAB).craftableFrom(MBItems.POLISHED_TUFF).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF)
        .create(MBItems.CHISELED_TUFF_BRICKS).craftableFrom(MBItems.TUFF_BRICK_SLAB).cuttableFrom(Blocks.TUFF, MBItems.TUFF_BRICKS)
        .create(MBItems.TUFF_BRICKS).craftableFrom(Blocks.TUFF).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF)
        .create(MBItems.CRACKED_TUFF_BRICKS).craftableFrom(MBItems.TUFF_BRICKS)
        .create(MBItems.TUFF_BRICK_STAIRS).craftableFrom(MBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF, MBItems.TUFF_BRICKS)
        .create(MBItems.TUFF_BRICK_SLAB).craftableFrom(MBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF, MBItems.TUFF_BRICKS)
        .create(MBItems.TUFF_BRICK_WALL).craftableFrom(MBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF, MBItems.TUFF_BRICKS)
        .create(MBItems.TUFF_PILLAR).craftableFrom(MBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF)
        .create(MBItems.TUFF_TILES).craftableFrom(MBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF, MBItems.TUFF_BRICKS)
        .create(MBItems.CRACKED_TUFF_TILES).craftableFrom(MBItems.TUFF_TILES)
        .create(MBItems.TUFF_TILE_STAIRS).craftableFrom(MBItems.TUFF_TILES).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF, MBItems.TUFF_BRICKS, MBItems.TUFF_TILES)
        .create(MBItems.TUFF_TILE_SLAB).craftableFrom(MBItems.TUFF_TILES).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF, MBItems.TUFF_BRICKS, MBItems.TUFF_TILES)
        .create(MBItems.TUFF_TILE_WALL).craftableFrom(MBItems.TUFF_TILES).cuttableFrom(Blocks.TUFF, MBItems.POLISHED_TUFF, MBItems.TUFF_BRICKS, MBItems.TUFF_TILES)
        .create(MBItems.MOSSY_TUFF_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_TUFF_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_TUFF_BRICKS).cuttableFrom(MBItems.MOSSY_TUFF_BRICKS)
        .create(MBItems.MOSSY_TUFF_BRICK_SLAB).craftableFrom(MBItems.MOSSY_TUFF_BRICKS).cuttableFrom(MBItems.MOSSY_TUFF_BRICKS)
        .create(MBItems.MOSSY_TUFF_BRICK_WALL).craftableFrom(MBItems.MOSSY_TUFF_BRICKS).cuttableFrom(MBItems.MOSSY_TUFF_BRICKS)
        .create(MBItems.SMOOTH_TUFF).craftableFrom(Blocks.TUFF)
        .create(MBItems.SMOOTH_TUFF_SLAB).craftableFrom(MBItems.SMOOTH_TUFF).cuttableFrom(MBItems.SMOOTH_TUFF)
      ).build();

    RecipeAdvancement
      .group("Dripstone Variations", (instance) -> instance
        .create(MBItems.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(MBItems.POLISHED_DRIPSTONE_STAIRS).craftableFrom(MBItems.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE)
        .create(MBItems.POLISHED_DRIPSTONE_SLAB).craftableFrom(MBItems.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE)
        .create(MBItems.CHISELED_DRIPSTONE_BRICKS).craftableFrom(MBItems.DRIPSTONE_BRICK_SLAB).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.DRIPSTONE_BRICKS)
        .create(MBItems.DRIPSTONE_BRICKS).craftableFrom(Blocks.DRIPSTONE_BLOCK).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE)
        .create(MBItems.CRACKED_DRIPSTONE_BRICKS).craftableFrom(MBItems.DRIPSTONE_BRICKS)
        .create(MBItems.DRIPSTONE_BRICK_STAIRS).craftableFrom(MBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE, MBItems.DRIPSTONE_BRICKS)
        .create(MBItems.DRIPSTONE_BRICK_SLAB).craftableFrom(MBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE, MBItems.DRIPSTONE_BRICKS)
        .create(MBItems.DRIPSTONE_BRICK_WALL).craftableFrom(MBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE, MBItems.DRIPSTONE_BRICKS)
        .create(MBItems.DRIPSTONE_PILLAR).craftableFrom(MBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(MBItems.DRIPSTONE_TILES).craftableFrom(MBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE, MBItems.DRIPSTONE_BRICKS)
        .create(MBItems.CRACKED_DRIPSTONE_TILES).craftableFrom(MBItems.DRIPSTONE_TILES)
        .create(MBItems.DRIPSTONE_TILE_STAIRS).craftableFrom(MBItems.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE, MBItems.DRIPSTONE_BRICKS, MBItems.DRIPSTONE_TILES)
        .create(MBItems.DRIPSTONE_TILE_SLAB).craftableFrom(MBItems.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE, MBItems.DRIPSTONE_BRICKS, MBItems.DRIPSTONE_TILES)
        .create(MBItems.DRIPSTONE_TILE_WALL).craftableFrom(MBItems.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, MBItems.POLISHED_DRIPSTONE, MBItems.DRIPSTONE_BRICKS, MBItems.DRIPSTONE_TILES)
        .create(MBItems.MOSSY_DRIPSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_DRIPSTONE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_DRIPSTONE_BRICKS)
        .create(MBItems.MOSSY_DRIPSTONE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_DRIPSTONE_BRICKS)
        .create(MBItems.MOSSY_DRIPSTONE_BRICK_WALL).craftableFrom(MBItems.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_DRIPSTONE_BRICKS)
        .create(MBItems.SMOOTH_DRIPSTONE).craftableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(MBItems.SMOOTH_DRIPSTONE_SLAB).craftableFrom(MBItems.SMOOTH_DRIPSTONE).cuttableFrom(MBItems.SMOOTH_DRIPSTONE)
      ).build();

    RecipeAdvancement.
      group("Bricks Variations", (instance) -> instance
        .create(MBItems.CRACKED_BRICKS).craftableFrom(Blocks.BRICKS)
        .create(MBItems.MOSSY_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_BRICKS).cuttableFrom(MBItems.MOSSY_BRICKS)
        .create(MBItems.MOSSY_BRICK_SLAB).craftableFrom(MBItems.MOSSY_BRICKS).cuttableFrom(MBItems.MOSSY_BRICKS)
        .create(MBItems.MOSSY_BRICK_WALL).craftableFrom(MBItems.MOSSY_BRICKS).cuttableFrom(MBItems.MOSSY_BRICKS)
      ).build();

    RecipeAdvancement.
      group("Mud Variations", (instance) -> instance
        .setExpectedEntries(17)
        .create(MBItems.POLISHED_MUD).craftableFrom(Blocks.PACKED_MUD)
        .create(MBItems.POLISHED_MUD_STAIRS).craftableFrom(MBItems.POLISHED_MUD).cuttableFrom(Blocks.PACKED_MUD, MBItems.POLISHED_MUD)
        .create(MBItems.POLISHED_MUD_SLAB).craftableFrom(MBItems.POLISHED_MUD).cuttableFrom(Blocks.PACKED_MUD, MBItems.POLISHED_MUD)
        .create(MBItems.CHISELED_MUD_BRICKS).craftableFrom(Blocks.MUD_BRICK_SLAB).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS)
        .create(MBItems.CRACKED_MUD_BRICKS).craftableFrom(Blocks.MUD_BRICKS)
        .create(MBItems.MUD_PILLAR).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD)
        .create(MBItems.MUD_TILES).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, MBItems.POLISHED_MUD)
        .create(MBItems.CRACKED_MUD_TILES).craftableFrom(MBItems.MUD_TILES)
        .create(MBItems.MUD_TILE_STAIRS).craftableFrom(MBItems.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, MBItems.POLISHED_MUD, MBItems.MUD_TILES)
        .create(MBItems.MUD_TILE_SLAB).craftableFrom(MBItems.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, MBItems.POLISHED_MUD, MBItems.MUD_TILES)
        .create(MBItems.MUD_TILE_WALL).craftableFrom(MBItems.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, MBItems.POLISHED_MUD, MBItems.MUD_TILES)
        .create(MBItems.MOSSY_MUD_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_MUD_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_MUD_BRICKS).cuttableFrom(MBItems.MOSSY_MUD_BRICKS)
        .create(MBItems.MOSSY_MUD_BRICK_SLAB).craftableFrom(MBItems.MOSSY_MUD_BRICKS).cuttableFrom(MBItems.MOSSY_MUD_BRICKS)
        .create(MBItems.MOSSY_MUD_BRICK_WALL).craftableFrom(MBItems.MOSSY_MUD_BRICKS).cuttableFrom(MBItems.MOSSY_MUD_BRICKS)
        .create(MBItems.SMOOTH_MUD).craftableFrom(Blocks.PACKED_MUD)
        .create(MBItems.SMOOTH_MUD_SLAB).craftableFrom(MBItems.SMOOTH_MUD).cuttableFrom(MBItems.SMOOTH_MUD)
      ).build();

    RecipeAdvancement.
      group("Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(MBItems.SANDSTONE_BRICKS).craftableFrom(Blocks.SMOOTH_SANDSTONE).cuttableFrom(Blocks.SANDSTONE)
        .create(MBItems.CRACKED_SANDSTONE_BRICKS).craftableFrom(MBItems.SANDSTONE_BRICKS)
        .create(MBItems.SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, MBItems.SANDSTONE_BRICKS)
        .create(MBItems.SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, MBItems.SANDSTONE_BRICKS)
        .create(MBItems.SANDSTONE_BRICK_WALL).craftableFrom(MBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, MBItems.SANDSTONE_BRICKS)
        .create(MBItems.SANDSTONE_PILLAR).craftableFrom(MBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE)
        .create(MBItems.SANDSTONE_TILES).craftableFrom(MBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, MBItems.SANDSTONE_BRICKS)
        .create(MBItems.CRACKED_SANDSTONE_TILES).craftableFrom(MBItems.SANDSTONE_BRICKS)
        .create(MBItems.SANDSTONE_TILE_STAIRS).craftableFrom(MBItems.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, MBItems.SANDSTONE_BRICKS, MBItems.SANDSTONE_TILES)
        .create(MBItems.SANDSTONE_TILE_SLAB).craftableFrom(MBItems.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, MBItems.SANDSTONE_BRICKS, MBItems.SANDSTONE_TILES)
        .create(MBItems.SANDSTONE_TILE_WALL).craftableFrom(MBItems.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, MBItems.SANDSTONE_BRICKS, MBItems.SANDSTONE_TILES)
        .create(MBItems.MOSSY_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_SANDSTONE_BRICK_WALL).craftableFrom(MBItems.MOSSY_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SANDSTONE_BRICKS)
      ).build();

    RecipeAdvancement.
      group("Red Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(MBItems.RED_SANDSTONE_BRICKS).craftableFrom(Blocks.SMOOTH_RED_SANDSTONE).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(MBItems.CRACKED_RED_SANDSTONE_BRICKS).craftableFrom(MBItems.RED_SANDSTONE_BRICKS)
        .create(MBItems.RED_SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, MBItems.RED_SANDSTONE_BRICKS)
        .create(MBItems.RED_SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, MBItems.RED_SANDSTONE_BRICKS)
        .create(MBItems.RED_SANDSTONE_BRICK_WALL).craftableFrom(MBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, MBItems.RED_SANDSTONE_BRICKS)
        .create(MBItems.RED_SANDSTONE_PILLAR).craftableFrom(MBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(MBItems.RED_SANDSTONE_TILES).craftableFrom(MBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, MBItems.RED_SANDSTONE_BRICKS)
        .create(MBItems.CRACKED_RED_SANDSTONE_TILES).craftableFrom(MBItems.RED_SANDSTONE_BRICKS)
        .create(MBItems.RED_SANDSTONE_TILE_STAIRS).craftableFrom(MBItems.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, MBItems.RED_SANDSTONE_BRICKS, MBItems.RED_SANDSTONE_TILES)
        .create(MBItems.RED_SANDSTONE_TILE_SLAB).craftableFrom(MBItems.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, MBItems.RED_SANDSTONE_BRICKS, MBItems.RED_SANDSTONE_TILES)
        .create(MBItems.RED_SANDSTONE_TILE_WALL).craftableFrom(MBItems.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, MBItems.RED_SANDSTONE_BRICKS, MBItems.RED_SANDSTONE_TILES)
        .create(MBItems.MOSSY_RED_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_RED_SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_RED_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_RED_SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_RED_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_RED_SANDSTONE_BRICK_WALL).craftableFrom(MBItems.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_RED_SANDSTONE_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Prismarine Variations", (instance) -> instance
        .create(MBItems.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE)
        .create(MBItems.POLISHED_PRISMARINE_STAIRS).craftableFrom(MBItems.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE, MBItems.POLISHED_PRISMARINE)
        .create(MBItems.POLISHED_PRISMARINE_SLAB).craftableFrom(MBItems.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE, MBItems.POLISHED_PRISMARINE)
        .create(MBItems.CHISELED_PRISMARINE_BRICKS).craftableFrom(Blocks.PRISMARINE_BRICK_SLAB).cuttableFrom(Blocks.PRISMARINE, MBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS)
        .create(MBItems.CRACKED_PRISMARINE_BRICKS).craftableFrom(Blocks.PRISMARINE_BRICKS)
        .create(MBItems.PRISMARINE_PILLAR).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE)
        .create(MBItems.PRISMARINE_TILES).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, MBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS)
        .create(MBItems.CRACKED_PRISMARINE_TILES).craftableFrom(MBItems.PRISMARINE_TILES)
        .create(MBItems.PRISMARINE_TILE_STAIRS).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, MBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, MBItems.PRISMARINE_TILES)
        .create(MBItems.PRISMARINE_TILE_SLAB).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, MBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, MBItems.PRISMARINE_TILES)
        .create(MBItems.PRISMARINE_TILE_WALL).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, MBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, MBItems.PRISMARINE_TILES)
        .create(MBItems.MOSSY_PRISMARINE_BRICKS).craftableFrom(Items.KELP)
        .create(MBItems.MOSSY_PRISMARINE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_PRISMARINE_BRICKS).cuttableFrom(MBItems.MOSSY_PRISMARINE_BRICKS)
        .create(MBItems.MOSSY_PRISMARINE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_PRISMARINE_BRICKS).cuttableFrom(MBItems.MOSSY_PRISMARINE_BRICKS)
        .create(MBItems.MOSSY_PRISMARINE_BRICK_WALL).craftableFrom(MBItems.MOSSY_PRISMARINE_BRICKS).cuttableFrom(MBItems.MOSSY_PRISMARINE_BRICKS)
        .create(MBItems.SMOOTH_PRISMARINE).craftableFrom(Blocks.PRISMARINE)
        .create(MBItems.SMOOTH_PRISMARINE_SLAB).craftableFrom(MBItems.SMOOTH_PRISMARINE).cuttableFrom(MBItems.SMOOTH_PRISMARINE)
      ).build();

    RecipeAdvancement.create(MBItems.NETHER_BRICKS_PILLAR).craftableFrom(Blocks.NETHER_BRICKS).cuttableFrom(Blocks.NETHER_BRICKS).build();

    RecipeAdvancement
      .group("Red Nether Bricks Variations", (instance) -> instance
        .create(MBItems.CRACKED_RED_NETHER_BRICKS).craftableFrom(Blocks.RED_NETHER_BRICKS)
        .create(MBItems.CHISELED_RED_NETHER_BRICKS).craftableFrom(Blocks.RED_NETHER_BRICK_SLAB).cuttableFrom(Blocks.RED_NETHER_BRICKS)
        .create(MBItems.RED_NETHER_BRICKS_PILLAR).craftableFrom(Blocks.RED_NETHER_BRICKS).cuttableFrom(Blocks.RED_NETHER_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Polished Blackstone Variations", (instance) -> instance
        .create(MBItems.POLISHED_BLACKSTONE_PILLAR).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE)
        .create(MBItems.POLISHED_BLACKSTONE_TILES).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS)
        .create(MBItems.CRACKED_POLISHED_BLACKSTONE_TILES).craftableFrom(MBItems.POLISHED_BLACKSTONE_TILES)
        .create(MBItems.POLISHED_BLACKSTONE_TILE_STAIRS).craftableFrom(MBItems.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, MBItems.POLISHED_BLACKSTONE_TILES)
        .create(MBItems.POLISHED_BLACKSTONE_TILE_SLAB).craftableFrom(MBItems.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, MBItems.POLISHED_BLACKSTONE_TILES)
        .create(MBItems.POLISHED_BLACKSTONE_TILE_WALL).craftableFrom(MBItems.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, MBItems.POLISHED_BLACKSTONE_TILES)
        .create(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).craftableFrom(Items.MAGMA_CREAM)
        .create(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS).craftableFrom(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB).craftableFrom(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL).craftableFrom(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(MBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(MBItems.SMOOTH_BLACKSTONE).craftableFrom(Blocks.BLACKSTONE)
        .create(MBItems.SMOOTH_BLACKSTONE_SLAB).craftableFrom(MBItems.SMOOTH_BLACKSTONE).cuttableFrom(MBItems.SMOOTH_BLACKSTONE)
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(MBItems.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE)
        .create(MBItems.POLISHED_END_STONE_STAIRS).craftableFrom(MBItems.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE, MBItems.POLISHED_STONE)
        .create(MBItems.POLISHED_END_STONE_SLAB).craftableFrom(MBItems.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE, MBItems.POLISHED_STONE)
        .create(MBItems.CHISELED_END_STONE_BRICKS).craftableFrom(Blocks.END_STONE_BRICK_SLAB).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS)
        .create(MBItems.CRACKED_END_STONE_BRICKS).craftableFrom(Blocks.END_STONE_BRICKS)
        .create(MBItems.END_STONE_PILLAR).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE)
        .create(MBItems.END_STONE_TILES).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, MBItems.POLISHED_END_STONE)
        .create(MBItems.CRACKED_END_STONE_TILES).craftableFrom(MBItems.END_STONE_TILES)
        .create(MBItems.END_STONE_TILE_STAIRS).craftableFrom(MBItems.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, MBItems.POLISHED_END_STONE, MBItems.END_STONE_TILES)
        .create(MBItems.END_STONE_TILE_SLAB).craftableFrom(MBItems.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, MBItems.POLISHED_END_STONE, MBItems.END_STONE_TILES)
        .create(MBItems.END_STONE_TILE_WALL).craftableFrom(MBItems.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, MBItems.POLISHED_END_STONE, MBItems.END_STONE_TILES)
        .create(MBItems.MOSSY_END_STONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_END_STONE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_END_STONE_BRICKS).cuttableFrom(MBItems.MOSSY_END_STONE_BRICKS)
        .create(MBItems.MOSSY_END_STONE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_END_STONE_BRICKS).cuttableFrom(MBItems.MOSSY_END_STONE_BRICKS)
        .create(MBItems.MOSSY_END_STONE_BRICK_WALL).craftableFrom(MBItems.MOSSY_END_STONE_BRICKS).cuttableFrom(MBItems.MOSSY_END_STONE_BRICKS)
        .create(MBItems.SMOOTH_END_STONE).craftableFrom(Blocks.END_STONE)
        .create(MBItems.SMOOTH_END_STONE_SLAB).craftableFrom(MBItems.SMOOTH_END_STONE).cuttableFrom(MBItems.SMOOTH_END_STONE)
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(MBItems.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK)
        .create(MBItems.POLISHED_PURPUR_STAIRS).craftableFrom(MBItems.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK, MBItems.POLISHED_STONE)
        .create(MBItems.POLISHED_PURPUR_SLAB).craftableFrom(MBItems.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK, MBItems.POLISHED_STONE)
        .create(MBItems.CHISELED_PURPUR).craftableFrom(Blocks.END_ROD)
        .create(MBItems.CRACKED_PURPUR_BLOCK).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(MBItems.PURPUR_TILES).craftableFrom(Blocks.PURPUR_BLOCK).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, MBItems.POLISHED_PURPUR)
        .create(MBItems.CRACKED_PURPUR_TILES).craftableFrom(MBItems.PURPUR_TILES)
        .create(MBItems.PURPUR_TILE_STAIRS).craftableFrom(MBItems.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, MBItems.POLISHED_PURPUR, MBItems.PURPUR_TILES)
        .create(MBItems.PURPUR_TILE_SLAB).craftableFrom(MBItems.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, MBItems.POLISHED_PURPUR, MBItems.PURPUR_TILES)
        .create(MBItems.PURPUR_TILE_WALL).craftableFrom(MBItems.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, MBItems.POLISHED_PURPUR, MBItems.PURPUR_TILES)
        .create(MBItems.MOSSY_PURPUR_BLOCK).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_PURPUR_BLOCK_STAIRS).craftableFrom(MBItems.MOSSY_PURPUR_BLOCK).cuttableFrom(MBItems.MOSSY_PURPUR_BLOCK)
        .create(MBItems.MOSSY_PURPUR_BLOCK_SLAB).craftableFrom(MBItems.MOSSY_PURPUR_BLOCK).cuttableFrom(MBItems.MOSSY_PURPUR_BLOCK)
        .create(MBItems.MOSSY_PURPUR_BLOCK_WALL).craftableFrom(MBItems.MOSSY_PURPUR_BLOCK).cuttableFrom(MBItems.MOSSY_PURPUR_BLOCK)
        .create(MBItems.SMOOTH_PURPUR).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(MBItems.SMOOTH_PURPUR_SLAB).craftableFrom(MBItems.SMOOTH_PURPUR).cuttableFrom(MBItems.SMOOTH_PURPUR)
      ).build();

    RecipeAdvancement
      .group("Coal Block Variations", (instance) -> instance
        .create(MBItems.COAL_BRICKS).craftableFrom(MBItems.CUT_COAL)
        .create(MBItems.CRACKED_COAL_BRICKS).craftableFrom(MBItems.COAL_BRICKS)
        .create(MBItems.COAL_PILLAR).craftableFrom(Blocks.COAL_BLOCK)
        .create(MBItems.CUT_COAL).craftableFrom(Blocks.COAL_BLOCK)
        .create(MBItems.CRACKED_CUT_COAL).craftableFrom(MBItems.CUT_COAL)
      ).build();

    RecipeAdvancement
      .group("Iron Block Variations", (instance) -> instance
        .create(MBItems.IRON_BRICKS).craftableFrom(MBItems.CUT_IRON)
        .create(MBItems.CRACKED_IRON_BRICKS).craftableFrom(MBItems.IRON_BRICKS)
        .create(MBItems.IRON_PILLAR).craftableFrom(Blocks.IRON_BLOCK)
        .create(MBItems.CUT_IRON).craftableFrom(Blocks.IRON_BLOCK)
        .create(MBItems.CRACKED_CUT_IRON).craftableFrom(MBItems.CUT_IRON)
        .create(MBItems.IRON_GRATE).craftableFrom(Blocks.IRON_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Gold Block Variations", (instance) -> instance
        .create(MBItems.GOLD_BRICKS).craftableFrom(MBItems.CUT_GOLD)
        .create(MBItems.CRACKED_GOLD_BRICKS).craftableFrom(MBItems.GOLD_BRICKS)
        .create(MBItems.GOLD_PILLAR).craftableFrom(Blocks.GOLD_BLOCK)
        .create(MBItems.CUT_GOLD).craftableFrom(Blocks.GOLD_BLOCK)
        .create(MBItems.CRACKED_CUT_GOLD).craftableFrom(MBItems.CUT_GOLD)
      ).build();

    RecipeAdvancement
      .group("Emerald Block Variations", (instance) -> instance
        .create(MBItems.EMERALD_BRICKS).craftableFrom(MBItems.CUT_EMERALD)
        .create(MBItems.CRACKED_EMERALD_BRICKS).craftableFrom(MBItems.EMERALD_BRICKS)
        .create(MBItems.EMERALD_PILLAR).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(MBItems.CUT_EMERALD).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(MBItems.CRACKED_CUT_EMERALD).craftableFrom(MBItems.CUT_EMERALD)
      ).build();

    RecipeAdvancement
      .group("Lapis Block Variations", (instance) -> instance
        .create(MBItems.LAPIS_BRICKS).craftableFrom(MBItems.CUT_LAPIS)
        .create(MBItems.CRACKED_LAPIS_BRICKS).craftableFrom(MBItems.LAPIS_BRICKS)
        .create(MBItems.LAPIS_PILLAR).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(MBItems.CUT_LAPIS).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(MBItems.CRACKED_CUT_LAPIS).craftableFrom(MBItems.CUT_LAPIS)
      ).build();

    RecipeAdvancement
      .group("Diamond Block Variations", (instance) -> instance
        .create(MBItems.DIAMOND_BRICKS).craftableFrom(MBItems.CUT_DIAMOND)
        .create(MBItems.CRACKED_DIAMOND_BRICKS).craftableFrom(MBItems.DIAMOND_BRICKS)
        .create(MBItems.DIAMOND_PILLAR).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(MBItems.CUT_DIAMOND).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(MBItems.CRACKED_CUT_DIAMOND).craftableFrom(MBItems.CUT_DIAMOND)
        .create(MBItems.DIAMOND_GRATE).craftableFrom(Blocks.DIAMOND_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Netherite Block Variations", (instance) -> instance
        .create(MBItems.NETHERITE_BRICKS).craftableFrom(MBItems.CUT_NETHERITE)
        .create(MBItems.CRACKED_NETHERITE_BRICKS).craftableFrom(MBItems.NETHERITE_BRICKS)
        .create(MBItems.NETHERITE_PILLAR).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(MBItems.CUT_NETHERITE).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(MBItems.CRACKED_CUT_NETHERITE).craftableFrom(MBItems.CUT_NETHERITE)
        .create(MBItems.NETHERITE_GRATE).craftableFrom(Blocks.NETHERITE_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Quartz Block Variations", (instance) -> instance
        .create(MBItems.CRACKED_QUARTZ_BRICKS).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(MBItems.CUT_QUARTZ).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(MBItems.CRACKED_CUT_QUARTZ).craftableFrom(MBItems.CUT_QUARTZ)
      ).build();

    RecipeAdvancement
      .group("Amethyst Block Variations", (instance) -> instance
        .create(MBItems.AMETHYST_BRICKS).craftableFrom(MBItems.CUT_AMETHYST)
        .create(MBItems.CRACKED_AMETHYST_BRICKS).craftableFrom(MBItems.AMETHYST_BRICKS)
        .create(MBItems.AMETHYST_PILLAR).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(MBItems.CUT_AMETHYST).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(MBItems.CRACKED_CUT_AMETHYST).craftableFrom(MBItems.CUT_AMETHYST)
      ).build();

    RecipeAdvancement
      .group("Redstone Block Variations", (instance) -> instance
        .create(MBItems.AMETHYST_BRICKS).craftableFrom(MBItems.CUT_REDSTONE)
        .create(MBItems.CRACKED_REDSTONE_BRICKS).craftableFrom(MBItems.REDSTONE_BRICKS)
        .create(MBItems.REDSTONE_PILLAR).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(MBItems.CUT_REDSTONE).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(MBItems.CRACKED_CUT_REDSTONE).craftableFrom(MBItems.CUT_REDSTONE)
      ).build();

    RecipeAdvancement
      .group("Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(MBItems.COPPER_BRICKS).craftableFrom(Blocks.CUT_COPPER)
        .create(MBItems.CRACKED_COPPER_BRICKS).craftableFrom(MBItems.CRACKED_COPPER_BRICKS)
        .create(MBItems.COPPER_PILLAR).craftableFrom(Blocks.COPPER_BLOCK)
        .create(MBItems.CRACKED_CUT_COPPER).craftableFrom(Blocks.CUT_COPPER)
        .create(MBItems.EXPOSED_COPPER_BRICKS).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(MBItems.EXPOSED_CRACKED_COPPER_BRICKS).craftableFrom(MBItems.EXPOSED_CRACKED_COPPER_BRICKS)
        .create(MBItems.EXPOSED_COPPER_PILLAR).craftableFrom(Blocks.EXPOSED_COPPER)
        .create(MBItems.EXPOSED_CRACKED_CUT_COPPER).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(MBItems.WEATHERED_COPPER_BRICKS).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(MBItems.WEATHERED_CRACKED_COPPER_BRICKS).craftableFrom(MBItems.WEATHERED_CRACKED_COPPER_BRICKS)
        .create(MBItems.WEATHERED_COPPER_PILLAR).craftableFrom(Blocks.WEATHERED_COPPER)
        .create(MBItems.WEATHERED_CRACKED_CUT_COPPER).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(MBItems.OXIDIZED_COPPER_BRICKS).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
        .create(MBItems.OXIDIZED_CRACKED_COPPER_BRICKS).craftableFrom(MBItems.OXIDIZED_CRACKED_COPPER_BRICKS)
        .create(MBItems.OXIDIZED_COPPER_PILLAR).craftableFrom(Blocks.OXIDIZED_COPPER)
        .create(MBItems.OXIDIZED_CRACKED_CUT_COPPER).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
      ).build();

    RecipeAdvancement
      .group("Waxed Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(MBItems.WAXED_COPPER_BRICKS).craftableFrom(MBItems.COPPER_BRICKS)
        .create(MBItems.WAXED_CRACKED_COPPER_BRICKS).craftableFrom(MBItems.CRACKED_COPPER_BRICKS)
        .create(MBItems.WAXED_COPPER_PILLAR).craftableFrom(MBItems.COPPER_PILLAR)
        .create(MBItems.WAXED_CRACKED_CUT_COPPER).craftableFrom(MBItems.CRACKED_CUT_COPPER)
        .create(MBItems.WAXED_EXPOSED_COPPER_BRICKS).craftableFrom(MBItems.EXPOSED_COPPER_BRICKS)
        .create(MBItems.WAXED_EXPOSED_CRACKED_COPPER_BRICKS).craftableFrom(MBItems.EXPOSED_CRACKED_COPPER_BRICKS)
        .create(MBItems.WAXED_EXPOSED_COPPER_PILLAR).craftableFrom(MBItems.EXPOSED_COPPER_PILLAR)
        .create(MBItems.WAXED_EXPOSED_CRACKED_CUT_COPPER).craftableFrom(MBItems.EXPOSED_CRACKED_CUT_COPPER)
        .create(MBItems.WAXED_WEATHERED_COPPER_BRICKS).craftableFrom(MBItems.WEATHERED_COPPER_BRICKS)
        .create(MBItems.WAXED_WEATHERED_CRACKED_COPPER_BRICKS).craftableFrom(MBItems.WEATHERED_CRACKED_COPPER_BRICKS)
        .create(MBItems.WAXED_WEATHERED_COPPER_PILLAR).craftableFrom(MBItems.WEATHERED_COPPER_PILLAR)
        .create(MBItems.WAXED_WEATHERED_CRACKED_CUT_COPPER).craftableFrom(MBItems.WEATHERED_CRACKED_CUT_COPPER)
        .create(MBItems.WAXED_OXIDIZED_COPPER_BRICKS).craftableFrom(MBItems.OXIDIZED_COPPER_BRICKS)
        .create(MBItems.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS).craftableFrom(MBItems.OXIDIZED_CRACKED_COPPER_BRICKS)
        .create(MBItems.WAXED_OXIDIZED_COPPER_PILLAR).craftableFrom(MBItems.OXIDIZED_COPPER_PILLAR)
        .create(MBItems.WAXED_OXIDIZED_CRACKED_CUT_COPPER).craftableFrom(MBItems.OXIDIZED_CRACKED_CUT_COPPER)
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
        .create(MBItems.BONE_BRICKS).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK)
        .create(MBItems.CRACKED_BONE_BRICKS).craftableFrom(MBItems.BONE_BRICKS)
        .create(MBItems.BONE_BRICK_STAIRS).craftableFrom(MBItems.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, MBItems.BONE_BRICKS)
        .create(MBItems.BONE_BRICK_SLAB).craftableFrom(MBItems.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, MBItems.BONE_BRICKS)
        .create(MBItems.BONE_BRICK_WALL).craftableFrom(MBItems.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, MBItems.BONE_BRICKS)
        .create(MBItems.BONE_TILES).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK, MBItems.BONE_BRICKS)
        .create(MBItems.CRACKED_BONE_TILES).craftableFrom(MBItems.BONE_TILES)
        .create(MBItems.BONE_TILE_STAIRS).craftableFrom(MBItems.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, MBItems.BONE_BRICKS, MBItems.BONE_TILES)
        .create(MBItems.BONE_TILE_SLAB).craftableFrom(MBItems.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, MBItems.BONE_BRICKS, MBItems.BONE_TILES)
        .create(MBItems.BONE_TILE_WALL).craftableFrom(MBItems.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, MBItems.BONE_BRICKS, MBItems.BONE_TILES)
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
        .create(MBItems.SOUL_SANDSTONE).craftableFrom(Blocks.SOUL_SAND, Blocks.SOUL_SOIL)
        .create(MBItems.SOUL_SANDSTONE_STAIRS).craftableFrom(MBItems.SOUL_SANDSTONE).cuttableFrom(MBItems.SOUL_SANDSTONE)
        .create(MBItems.SOUL_SANDSTONE_SLAB).craftableFrom(MBItems.SOUL_SANDSTONE).cuttableFrom(MBItems.SOUL_SANDSTONE)
        .create(MBItems.SOUL_SANDSTONE_WALL).craftableFrom(MBItems.SOUL_SANDSTONE).cuttableFrom(MBItems.SOUL_SANDSTONE)
        .create(MBItems.CHISELED_SOUL_SANDSTONE).craftableFrom(MBItems.SOUL_SANDSTONE_SLAB).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS)
        .create(MBItems.SOUL_SANDSTONE_BRICKS).craftableFrom(MBItems.SMOOTH_SOUL_SANDSTONE).cuttableFrom(MBItems.SOUL_SANDSTONE)
        .create(MBItems.CRACKED_SOUL_SANDSTONE_BRICKS).craftableFrom(MBItems.SOUL_SANDSTONE_BRICKS)
        .create(MBItems.SOUL_SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS)
        .create(MBItems.SOUL_SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS)
        .create(MBItems.SOUL_SANDSTONE_BRICK_WALL).craftableFrom(MBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS)
        .create(MBItems.SOUL_SANDSTONE_PILLAR).craftableFrom(MBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.SOUL_SANDSTONE)
        .create(MBItems.SOUL_SANDSTONE_TILES).craftableFrom(MBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS)
        .create(MBItems.CRACKED_SOUL_SANDSTONE_TILES).craftableFrom(MBItems.SOUL_SANDSTONE_BRICKS)
        .create(MBItems.SOUL_SANDSTONE_TILE_STAIRS).craftableFrom(MBItems.SOUL_SANDSTONE_TILES).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS, MBItems.SOUL_SANDSTONE_TILES)
        .create(MBItems.SOUL_SANDSTONE_TILE_SLAB).craftableFrom(MBItems.SOUL_SANDSTONE_TILES).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS, MBItems.SOUL_SANDSTONE_TILES)
        .create(MBItems.SOUL_SANDSTONE_TILE_WALL).craftableFrom(MBItems.SOUL_SANDSTONE_TILES).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.SOUL_SANDSTONE_BRICKS, MBItems.SOUL_SANDSTONE_TILES)
        .create(MBItems.SMOOTH_SOUL_SANDSTONE).craftableFrom(MBItems.SOUL_SANDSTONE)
        .create(MBItems.SMOOTH_SOUL_SANDSTONE_SLAB).craftableFrom(MBItems.SMOOTH_SOUL_SANDSTONE).cuttableFrom(MBItems.SMOOTH_SOUL_SANDSTONE)
        .create(MBItems.SMOOTH_SOUL_SANDSTONE_STAIRS).craftableFrom(MBItems.SMOOTH_SOUL_SANDSTONE).cuttableFrom(MBItems.SMOOTH_SOUL_SANDSTONE)

        .create(MBItems.CUT_SOUL_SANDSTONE).craftableFrom(MBItems.SOUL_SANDSTONE).cuttableFrom(MBItems.SOUL_SANDSTONE)
        .create(MBItems.CUT_SOUL_SANDSTONE_SLAB).craftableFrom(MBItems.CUT_SOUL_SANDSTONE).cuttableFrom(MBItems.SOUL_SANDSTONE, MBItems.CUT_SOUL_SANDSTONE)
        /*.create(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_WALL).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)*/
      ).build();

    RecipeAdvancement
      .group("Snow Block Variations", (instance) -> instance
        .create(MBItems.PACKED_SNOW).craftableFrom(Blocks.SNOW_BLOCK)
        .create(MBItems.PACKED_SNOW_STAIRS).craftableFrom(MBItems.PACKED_SNOW)
        .create(MBItems.PACKED_SNOW_SLAB).craftableFrom(MBItems.PACKED_SNOW)
        .create(MBItems.POLISHED_SNOW).craftableFrom(MBItems.PACKED_SNOW)
        .create(MBItems.POLISHED_SNOW_STAIRS).craftableFrom(MBItems.PACKED_SNOW)
        .create(MBItems.POLISHED_SNOW_SLAB).craftableFrom(MBItems.PACKED_SNOW)
        .create(MBItems.SNOW_BRICKS).craftableFrom(MBItems.POLISHED_SNOW_SLAB)
        //.create(MBItems.CRACKED_SNOW_BRICKS).craftableFrom(MBItems.POLISHED_SNOW_SLAB)
        .create(MBItems.SNOW_BRICK_STAIRS).craftableFrom(MBItems.SNOW_BRICKS)
        .create(MBItems.SNOW_BRICK_SLAB).craftableFrom(MBItems.SNOW_BRICKS)
        .create(MBItems.SNOW_BRICK_WALL).craftableFrom(MBItems.SNOW_BRICKS)
        .create(MBItems.SNOW_PILLAR).craftableFrom(MBItems.SNOW_BRICKS)
        .create(MBItems.SNOW_TILES).craftableFrom(MBItems.SNOW_BRICKS)
        //.create(MBItems.CRACKED_SNOW_TILES).craftableFrom(MBItems.SNOW_TILES)
        .create(MBItems.SNOW_TILE_STAIRS).craftableFrom(MBItems.SNOW_TILES)
        .create(MBItems.SNOW_TILE_SLAB).craftableFrom(MBItems.SNOW_TILES)
        .create(MBItems.SNOW_TILE_WALL).craftableFrom(MBItems.SNOW_TILES)
      ).build();

    RecipeAdvancement
      .group("Packed Ice Block Variations", (instance) -> instance
        .create(MBItems.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE)
        .create(MBItems.POLISHED_ICE_STAIRS).craftableFrom(MBItems.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE)
        .create(MBItems.POLISHED_ICE_SLAB).craftableFrom(MBItems.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE)
        .create(MBItems.ICE_BRICKS).craftableFrom(Blocks.PACKED_ICE).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE)
        //.create(MBItems.CRACKED_ICE_BRICKS).craftableFrom(MBItems.ICE_BRICKS)
        .create(MBItems.ICE_BRICK_STAIRS).craftableFrom(MBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE, MBItems.ICE_BRICKS)
        .create(MBItems.ICE_BRICK_SLAB).craftableFrom(MBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE, MBItems.ICE_BRICKS)
        .create(MBItems.ICE_BRICK_WALL).craftableFrom(MBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE, MBItems.ICE_BRICKS)
        .create(MBItems.ICE_PILLAR).craftableFrom(MBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE)
        .create(MBItems.ICE_TILES).craftableFrom(MBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE, MBItems.ICE_BRICKS)
        //.create(MBItems.CRACKED_ICE_TILES).craftableFrom(MBItems.ICE_TILES)
        .create(MBItems.ICE_TILE_STAIRS).craftableFrom(MBItems.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE, MBItems.ICE_BRICKS, MBItems.ICE_TILES)
        .create(MBItems.ICE_TILE_SLAB).craftableFrom(MBItems.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE, MBItems.ICE_BRICKS, MBItems.ICE_TILES)
        .create(MBItems.ICE_TILE_WALL).craftableFrom(MBItems.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, MBItems.POLISHED_ICE, MBItems.ICE_BRICKS, MBItems.ICE_TILES)
      ).build();

    RecipeAdvancement
      .group("Tiled Glasses Variation", (instance) -> instance
        .create(MBItems.TILED_GLASS).craftableFrom(Blocks.GLASS)
        .create(MBItems.TILED_TINTED_GLASS).craftableFrom(Blocks.TINTED_GLASS)
        .create(MBItems.WHITE_STAINED_TILED_GLASS).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_STAINED_GLASS)
        .create(MBItems.LIGHT_GRAY_STAINED_TILED_GLASS).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_STAINED_GLASS)
        .create(MBItems.GRAY_STAINED_TILED_GLASS).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_STAINED_GLASS)
        .create(MBItems.BLACK_STAINED_TILED_GLASS).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_STAINED_GLASS)
        .create(MBItems.BROWN_STAINED_TILED_GLASS).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_STAINED_GLASS)
        .create(MBItems.RED_STAINED_TILED_GLASS).craftableFrom(Items.RED_DYE, Blocks.RED_STAINED_GLASS)
        .create(MBItems.ORANGE_STAINED_TILED_GLASS).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_STAINED_GLASS)
        .create(MBItems.YELLOW_STAINED_TILED_GLASS).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_STAINED_GLASS)
        .create(MBItems.LIME_STAINED_TILED_GLASS).craftableFrom(Items.LIME_DYE, Blocks.LIME_STAINED_GLASS)
        .create(MBItems.GREEN_STAINED_TILED_GLASS).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_STAINED_GLASS)
        .create(MBItems.CYAN_STAINED_TILED_GLASS).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_STAINED_GLASS)
        .create(MBItems.LIGHT_BLUE_STAINED_TILED_GLASS).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_STAINED_GLASS)
        .create(MBItems.BLUE_STAINED_TILED_GLASS).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_STAINED_GLASS)
        .create(MBItems.PURPLE_STAINED_TILED_GLASS).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_STAINED_GLASS)
        .create(MBItems.MAGENTA_STAINED_TILED_GLASS).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_STAINED_GLASS)
        .create(MBItems.PINK_STAINED_TILED_GLASS).craftableFrom(Items.PINK_DYE, Blocks.PINK_STAINED_GLASS)
      ).build();

    RecipeAdvancement
      .group("Shingles Variation", (instance) -> instance
        .create(MBItems.SHINGLES).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(MBItems.WHITE_SHINGLES).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(MBItems.LIGHT_GRAY_SHINGLES).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(MBItems.GRAY_SHINGLES).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(MBItems.BLACK_SHINGLES).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(MBItems.BROWN_SHINGLES).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(MBItems.RED_SHINGLES).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(MBItems.ORANGE_SHINGLES).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(MBItems.YELLOW_SHINGLES).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(MBItems.LIME_SHINGLES).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(MBItems.GREEN_SHINGLES).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(MBItems.CYAN_SHINGLES).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(MBItems.LIGHT_BLUE_SHINGLES).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(MBItems.BLUE_SHINGLES).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(MBItems.PURPLE_SHINGLES).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(MBItems.MAGENTA_SHINGLES).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(MBItems.PINK_SHINGLES).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Bricks Variation", (instance) -> instance
        .create(MBItems.TERRACOTTA_BRICKS).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(MBItems.WHITE_TERRACOTTA_BRICKS).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(MBItems.LIGHT_GRAY_TERRACOTTA_BRICKS).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(MBItems.GRAY_TERRACOTTA_BRICKS).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(MBItems.BLACK_TERRACOTTA_BRICKS).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(MBItems.BROWN_TERRACOTTA_BRICKS).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(MBItems.RED_TERRACOTTA_BRICKS).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(MBItems.ORANGE_TERRACOTTA_BRICKS).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(MBItems.YELLOW_TERRACOTTA_BRICKS).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(MBItems.LIME_TERRACOTTA_BRICKS).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(MBItems.GREEN_TERRACOTTA_BRICKS).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(MBItems.CYAN_TERRACOTTA_BRICKS).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(MBItems.LIGHT_BLUE_TERRACOTTA_BRICKS).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(MBItems.BLUE_TERRACOTTA_BRICKS).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(MBItems.PURPLE_TERRACOTTA_BRICKS).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(MBItems.MAGENTA_TERRACOTTA_BRICKS).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(MBItems.PINK_TERRACOTTA_BRICKS).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Tiles Variation", (instance) -> instance
        .create(MBItems.TERRACOTTA_TILES).craftableFrom(MBItems.TERRACOTTA_BRICKS).cuttableFrom(MBItems.TERRACOTTA_BRICKS)
        .create(MBItems.WHITE_TERRACOTTA_TILES).craftableFrom(Items.WHITE_DYE, MBItems.WHITE_TERRACOTTA_BRICKS).cuttableFrom(MBItems.WHITE_TERRACOTTA_BRICKS)
        .create(MBItems.LIGHT_GRAY_TERRACOTTA_TILES).craftableFrom(Items.LIGHT_GRAY_DYE, MBItems.LIGHT_GRAY_TERRACOTTA_BRICKS).cuttableFrom(MBItems.LIGHT_GRAY_TERRACOTTA_BRICKS)
        .create(MBItems.GRAY_TERRACOTTA_TILES).craftableFrom(Items.GRAY_DYE, MBItems.GRAY_TERRACOTTA_BRICKS).cuttableFrom(MBItems.GRAY_TERRACOTTA_BRICKS)
        .create(MBItems.BLACK_TERRACOTTA_TILES).craftableFrom(Items.BLACK_DYE, MBItems.BLACK_TERRACOTTA_BRICKS).cuttableFrom(MBItems.BLACK_TERRACOTTA_BRICKS)
        .create(MBItems.BROWN_TERRACOTTA_TILES).craftableFrom(Items.BROWN_DYE, MBItems.BROWN_TERRACOTTA_BRICKS).cuttableFrom(MBItems.BROWN_TERRACOTTA_BRICKS)
        .create(MBItems.RED_TERRACOTTA_TILES).craftableFrom(Items.RED_DYE, MBItems.RED_TERRACOTTA_BRICKS).cuttableFrom(MBItems.RED_TERRACOTTA_BRICKS)
        .create(MBItems.ORANGE_TERRACOTTA_TILES).craftableFrom(Items.ORANGE_DYE, MBItems.ORANGE_TERRACOTTA_BRICKS).cuttableFrom(MBItems.ORANGE_TERRACOTTA_BRICKS)
        .create(MBItems.YELLOW_TERRACOTTA_TILES).craftableFrom(Items.YELLOW_DYE, MBItems.YELLOW_TERRACOTTA_BRICKS).cuttableFrom(MBItems.YELLOW_TERRACOTTA_BRICKS)
        .create(MBItems.LIME_TERRACOTTA_TILES).craftableFrom(Items.LIME_DYE, MBItems.LIME_TERRACOTTA_BRICKS).cuttableFrom(MBItems.LIME_TERRACOTTA_BRICKS)
        .create(MBItems.GREEN_TERRACOTTA_TILES).craftableFrom(Items.GREEN_DYE, MBItems.GREEN_TERRACOTTA_BRICKS).cuttableFrom(MBItems.GREEN_TERRACOTTA_BRICKS)
        .create(MBItems.CYAN_TERRACOTTA_TILES).craftableFrom(Items.CYAN_DYE, MBItems.CYAN_TERRACOTTA_BRICKS).cuttableFrom(MBItems.CYAN_TERRACOTTA_BRICKS)
        .create(MBItems.LIGHT_BLUE_TERRACOTTA_TILES).craftableFrom(Items.LIGHT_BLUE_DYE, MBItems.LIGHT_BLUE_TERRACOTTA_BRICKS).cuttableFrom(MBItems.LIGHT_BLUE_TERRACOTTA_BRICKS)
        .create(MBItems.BLUE_TERRACOTTA_TILES).craftableFrom(Items.BLUE_DYE, MBItems.BLUE_TERRACOTTA_BRICKS).cuttableFrom(MBItems.BLUE_TERRACOTTA_BRICKS)
        .create(MBItems.PURPLE_TERRACOTTA_TILES).craftableFrom(Items.PURPLE_DYE, MBItems.PURPLE_TERRACOTTA_BRICKS).cuttableFrom(MBItems.PURPLE_TERRACOTTA_BRICKS)
        .create(MBItems.MAGENTA_TERRACOTTA_TILES).craftableFrom(Items.MAGENTA_DYE, MBItems.MAGENTA_TERRACOTTA_BRICKS).cuttableFrom(MBItems.MAGENTA_TERRACOTTA_BRICKS)
        .create(MBItems.PINK_TERRACOTTA_TILES).craftableFrom(Items.PINK_DYE, MBItems.PINK_TERRACOTTA_BRICKS).cuttableFrom(MBItems.PINK_TERRACOTTA_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Concrete Bricks Variation", (instance) -> instance
        .create(MBItems.WHITE_CONCRETE_BRICKS).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(MBItems.LIGHT_GRAY_CONCRETE_BRICKS).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(MBItems.GRAY_CONCRETE_BRICKS).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(MBItems.BLACK_CONCRETE_BRICKS).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(MBItems.BROWN_CONCRETE_BRICKS).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(MBItems.RED_CONCRETE_BRICKS).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(MBItems.ORANGE_CONCRETE_BRICKS).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(MBItems.YELLOW_CONCRETE_BRICKS).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(MBItems.LIME_CONCRETE_BRICKS).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(MBItems.GREEN_CONCRETE_BRICKS).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(MBItems.CYAN_CONCRETE_BRICKS).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(MBItems.LIGHT_BLUE_CONCRETE_BRICKS).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(MBItems.BLUE_CONCRETE_BRICKS).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(MBItems.PURPLE_CONCRETE_BRICKS).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(MBItems.MAGENTA_CONCRETE_BRICKS).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(MBItems.PINK_CONCRETE_BRICKS).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Concrete Tiles Variation", (instance) -> instance
        .create(MBItems.WHITE_CONCRETE_TILES).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(MBItems.LIGHT_GRAY_CONCRETE_TILES).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(MBItems.GRAY_CONCRETE_TILES).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(MBItems.BLACK_CONCRETE_TILES).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(MBItems.BROWN_CONCRETE_TILES).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(MBItems.RED_CONCRETE_TILES).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(MBItems.ORANGE_CONCRETE_TILES).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(MBItems.YELLOW_CONCRETE_TILES).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(MBItems.LIME_CONCRETE_TILES).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(MBItems.GREEN_CONCRETE_TILES).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(MBItems.CYAN_CONCRETE_TILES).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(MBItems.LIGHT_BLUE_CONCRETE_TILES).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(MBItems.BLUE_CONCRETE_TILES).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(MBItems.PURPLE_CONCRETE_TILES).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(MBItems.MAGENTA_CONCRETE_TILES).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(MBItems.PINK_CONCRETE_TILES).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Redstone Froglight Lamp", (instance) -> instance
        .create(MBItems.OCHRE_REDSTONE_FROGLIGHT).craftableFrom(Items.OCHRE_FROGLIGHT)
        .create(MBItems.VERDANT_REDSTONE_FROGLIGHT).craftableFrom(Items.VERDANT_FROGLIGHT)
        .create(MBItems.PEARLESCENT_REDSTONE_FROGLIGHT).craftableFrom(Items.PEARLESCENT_FROGLIGHT)
      ).build();
  }
}
