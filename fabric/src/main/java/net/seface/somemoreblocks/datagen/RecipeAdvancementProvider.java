package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.datagen.core.RecipeAdvancement;
import net.seface.somemoreblocks.datagen.core.RecipeAdvancementGroupType;
import net.seface.somemoreblocks.registries.SMBItems;

import java.util.function.Consumer;

public class RecipeAdvancementProvider extends FabricAdvancementProvider {
  protected RecipeAdvancementProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateAdvancement(Consumer<AdvancementHolder> consumer) {
    RecipeAdvancement.setConsumer(consumer);

    RecipeAdvancement.create(Items.GREEN_DYE, RecipeAdvancementGroupType.MISC).craftableFrom(SMBItems.TINY_CACTUS).build();
    RecipeAdvancement.create(Items.GLOWSTONE_DUST, RecipeAdvancementGroupType.MISC).craftableFrom(SMBItems.LUMINOUS_FLOWER).build();

    RecipeAdvancement
      .group("Mosaics", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBItems.OAK_MOSAIC).craftableFrom(Blocks.OAK_SLAB)
        .create(SMBItems.SPRUCE_MOSAIC).craftableFrom(Blocks.SPRUCE_SLAB)
        .create(SMBItems.BIRCH_MOSAIC).craftableFrom(Blocks.BIRCH_SLAB)
        .create(SMBItems.JUNGLE_MOSAIC).craftableFrom(Blocks.JUNGLE_SLAB)
        .create(SMBItems.ACACIA_MOSAIC).craftableFrom(Blocks.ACACIA_SLAB)
        .create(SMBItems.DARK_OAK_MOSAIC).craftableFrom(Blocks.DARK_OAK_SLAB)
        .create(SMBItems.MANGROVE_MOSAIC).craftableFrom(Blocks.MANGROVE_SLAB)
        .create(SMBItems.CRIMSON_MOSAIC).craftableFrom(Blocks.CRIMSON_SLAB)
        .create(SMBItems.WARPED_MOSAIC).craftableFrom(Blocks.WARPED_SLAB)
        .create(SMBItems.CHERRY_MOSAIC).craftableFrom(Blocks.CHERRY_SLAB)
      ).build();

    RecipeAdvancement
      .group("Mosaic Stairs", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBItems.OAK_MOSAIC_STAIRS).craftableFrom(SMBItems.OAK_MOSAIC)
        .create(SMBItems.SPRUCE_MOSAIC_STAIRS).craftableFrom(SMBItems.SPRUCE_MOSAIC)
        .create(SMBItems.BIRCH_MOSAIC_STAIRS).craftableFrom(SMBItems.BIRCH_MOSAIC)
        .create(SMBItems.JUNGLE_MOSAIC_STAIRS).craftableFrom(SMBItems.JUNGLE_MOSAIC)
        .create(SMBItems.ACACIA_MOSAIC_STAIRS).craftableFrom(SMBItems.ACACIA_MOSAIC)
        .create(SMBItems.DARK_OAK_MOSAIC_STAIRS).craftableFrom(SMBItems.DARK_OAK_MOSAIC)
        .create(SMBItems.MANGROVE_MOSAIC_STAIRS).craftableFrom(SMBItems.MANGROVE_MOSAIC)
        .create(SMBItems.CRIMSON_MOSAIC_STAIRS).craftableFrom(SMBItems.CRIMSON_MOSAIC)
        .create(SMBItems.WARPED_MOSAIC_STAIRS).craftableFrom(SMBItems.WARPED_MOSAIC)
        .create(SMBItems.CHERRY_MOSAIC_STAIRS).craftableFrom(SMBItems.CHERRY_MOSAIC)
      ).build();

    RecipeAdvancement
      .group("Mosaic Slabs", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBItems.OAK_MOSAIC_SLAB).craftableFrom(SMBItems.OAK_MOSAIC)
        .create(SMBItems.SPRUCE_MOSAIC_SLAB).craftableFrom(SMBItems.SPRUCE_MOSAIC)
        .create(SMBItems.BIRCH_MOSAIC_SLAB).craftableFrom(SMBItems.BIRCH_MOSAIC)
        .create(SMBItems.JUNGLE_MOSAIC_SLAB).craftableFrom(SMBItems.JUNGLE_MOSAIC)
        .create(SMBItems.ACACIA_MOSAIC_SLAB).craftableFrom(SMBItems.ACACIA_MOSAIC)
        .create(SMBItems.DARK_OAK_MOSAIC_SLAB).craftableFrom(SMBItems.DARK_OAK_MOSAIC)
        .create(SMBItems.MANGROVE_MOSAIC_SLAB).craftableFrom(SMBItems.MANGROVE_MOSAIC)
        .create(SMBItems.CRIMSON_MOSAIC_SLAB).craftableFrom(SMBItems.CRIMSON_MOSAIC)
        .create(SMBItems.WARPED_MOSAIC_SLAB).craftableFrom(SMBItems.WARPED_MOSAIC)
        .create(SMBItems.CHERRY_MOSAIC_SLAB).craftableFrom(SMBItems.CHERRY_MOSAIC)
      ).build();

    RecipeAdvancement
      .group("Stone Variations", (instance) -> instance
        .create(SMBItems.POLISHED_STONE).cuttableFrom(Blocks.STONE)
        .create(SMBItems.POLISHED_STONE_STAIRS).craftableFrom(SMBItems.POLISHED_STONE).cuttableFrom(Blocks.STONE, SMBItems.POLISHED_STONE)
        .create(SMBItems.POLISHED_STONE_SLAB).craftableFrom(SMBItems.POLISHED_STONE).cuttableFrom(Blocks.STONE, SMBItems.POLISHED_STONE)
        .create(SMBItems.STONE_PILLAR).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE)
        .create(SMBItems.STONE_TILES).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE, SMBItems.POLISHED_STONE, Blocks.STONE_BRICKS)
        .create(SMBItems.CRACKED_STONE_TILES).craftableFrom(SMBItems.STONE_TILES)
        .create(SMBItems.STONE_TILE_STAIRS).craftableFrom(SMBItems.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, SMBItems.STONE_TILES, SMBItems.POLISHED_STONE, Blocks.STONE)
        .create(SMBItems.STONE_TILE_SLAB).craftableFrom(SMBItems.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, SMBItems.STONE_TILES, SMBItems.POLISHED_STONE, Blocks.STONE)
        .create(SMBItems.STONE_TILE_WALL).craftableFrom(SMBItems.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, SMBItems.STONE_TILES, SMBItems.POLISHED_STONE, Blocks.STONE)
      ).build();

    RecipeAdvancement
      .group("Granite Variations", (instance) -> instance
        .create(SMBItems.CHISELED_GRANITE_BRICKS).craftableFrom(SMBItems.GRANITE_BRICK_SLAB).cuttableFrom(Blocks.GRANITE, SMBItems.GRANITE_BRICKS)
        .create(SMBItems.GRANITE_BRICKS).craftableFrom(Blocks.POLISHED_GRANITE).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE)
        .create(SMBItems.CRACKED_GRANITE_BRICKS).craftableFrom(SMBItems.GRANITE_BRICKS)
        .create(SMBItems.GRANITE_BRICK_STAIRS).craftableFrom(SMBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, SMBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(SMBItems.GRANITE_BRICK_SLAB).craftableFrom(SMBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, SMBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(SMBItems.GRANITE_BRICK_WALL).craftableFrom(SMBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, SMBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(SMBItems.GRANITE_PILLAR).craftableFrom(SMBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE)
        .create(SMBItems.GRANITE_TILES).craftableFrom(SMBItems.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE, SMBItems.GRANITE_BRICKS)
        .create(SMBItems.CRACKED_GRANITE_TILES).craftableFrom(SMBItems.GRANITE_TILES)
        .create(SMBItems.GRANITE_TILE_STAIRS).craftableFrom(SMBItems.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, SMBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, SMBItems.GRANITE_TILES)
        .create(SMBItems.GRANITE_TILE_SLAB).craftableFrom(SMBItems.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, SMBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, SMBItems.GRANITE_TILES)
        .create(SMBItems.GRANITE_TILE_WALL).craftableFrom(SMBItems.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, SMBItems.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, SMBItems.GRANITE_TILES)
        .create(SMBItems.MOSSY_GRANITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_GRANITE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_GRANITE_BRICKS).cuttableFrom(SMBItems.MOSSY_GRANITE_BRICKS)
        .create(SMBItems.MOSSY_GRANITE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_GRANITE_BRICKS).cuttableFrom(SMBItems.MOSSY_GRANITE_BRICKS)
        .create(SMBItems.MOSSY_GRANITE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_GRANITE_BRICKS).cuttableFrom(SMBItems.MOSSY_GRANITE_BRICKS)
        .create(SMBItems.SMOOTH_GRANITE).craftableFrom(Blocks.GRANITE)
        .create(SMBItems.SMOOTH_GRANITE_SLAB).craftableFrom(SMBItems.SMOOTH_GRANITE).cuttableFrom(SMBItems.SMOOTH_GRANITE)
      ).build();

    RecipeAdvancement
      .group("Diorite Variations", (instance) -> instance
        .create(SMBItems.CHISELED_DIORITE_BRICKS).craftableFrom(SMBItems.DIORITE_BRICK_SLAB).cuttableFrom(Blocks.DIORITE, SMBItems.DIORITE_BRICKS)
        .create(SMBItems.DIORITE_BRICKS).craftableFrom(Blocks.POLISHED_DIORITE).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE)
        .create(SMBItems.CRACKED_DIORITE_BRICKS).craftableFrom(SMBItems.DIORITE_BRICKS)
        .create(SMBItems.DIORITE_BRICK_STAIRS).craftableFrom(SMBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, SMBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(SMBItems.DIORITE_BRICK_SLAB).craftableFrom(SMBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, SMBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(SMBItems.DIORITE_BRICK_WALL).craftableFrom(SMBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, SMBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(SMBItems.DIORITE_PILLAR).craftableFrom(SMBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE)
        .create(SMBItems.DIORITE_TILES).craftableFrom(SMBItems.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE, SMBItems.DIORITE_BRICKS)
        .create(SMBItems.CRACKED_DIORITE_TILES).craftableFrom(SMBItems.DIORITE_TILES)
        .create(SMBItems.DIORITE_TILE_STAIRS).craftableFrom(SMBItems.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, SMBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, SMBItems.DIORITE_TILES)
        .create(SMBItems.DIORITE_TILE_SLAB).craftableFrom(SMBItems.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, SMBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, SMBItems.DIORITE_TILES)
        .create(SMBItems.DIORITE_TILE_WALL).craftableFrom(SMBItems.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, SMBItems.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, SMBItems.DIORITE_TILES)
        .create(SMBItems.MOSSY_DIORITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_DIORITE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_DIORITE_BRICKS).cuttableFrom(SMBItems.MOSSY_DIORITE_BRICKS)
        .create(SMBItems.MOSSY_DIORITE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_DIORITE_BRICKS).cuttableFrom(SMBItems.MOSSY_DIORITE_BRICKS)
        .create(SMBItems.MOSSY_DIORITE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_DIORITE_BRICKS).cuttableFrom(SMBItems.MOSSY_DIORITE_BRICKS)
        .create(SMBItems.SMOOTH_DIORITE).craftableFrom(Blocks.DIORITE)
        .create(SMBItems.SMOOTH_DIORITE_SLAB).craftableFrom(SMBItems.SMOOTH_DIORITE).cuttableFrom(SMBItems.SMOOTH_DIORITE)
      ).build();

    RecipeAdvancement
      .group("Andesite Variations", (instance) -> instance
        .create(SMBItems.CHISELED_ANDESITE_BRICKS).craftableFrom(SMBItems.ANDESITE_BRICK_SLAB).cuttableFrom(Blocks.ANDESITE, SMBItems.ANDESITE_BRICKS)
        .create(SMBItems.ANDESITE_BRICKS).craftableFrom(Blocks.POLISHED_ANDESITE).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE)
        .create(SMBItems.CRACKED_ANDESITE_BRICKS).craftableFrom(SMBItems.ANDESITE_BRICKS)
        .create(SMBItems.ANDESITE_BRICK_STAIRS).craftableFrom(SMBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, SMBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(SMBItems.ANDESITE_BRICK_SLAB).craftableFrom(SMBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, SMBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(SMBItems.ANDESITE_BRICK_WALL).craftableFrom(SMBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, SMBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(SMBItems.ANDESITE_PILLAR).craftableFrom(SMBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE)
        .create(SMBItems.ANDESITE_TILES).craftableFrom(SMBItems.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, SMBItems.ANDESITE_BRICKS)
        .create(SMBItems.CRACKED_ANDESITE_TILES).craftableFrom(SMBItems.ANDESITE_TILES)
        .create(SMBItems.ANDESITE_TILE_STAIRS).craftableFrom(SMBItems.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, SMBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, SMBItems.ANDESITE_TILES)
        .create(SMBItems.ANDESITE_TILE_SLAB).craftableFrom(SMBItems.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, SMBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, SMBItems.ANDESITE_TILES)
        .create(SMBItems.GRANITE_TILE_WALL).craftableFrom(SMBItems.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, SMBItems.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, SMBItems.ANDESITE_TILES)
        .create(SMBItems.MOSSY_ANDESITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_ANDESITE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_ANDESITE_BRICKS).cuttableFrom(SMBItems.MOSSY_ANDESITE_BRICKS)
        .create(SMBItems.MOSSY_ANDESITE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_ANDESITE_BRICKS).cuttableFrom(SMBItems.MOSSY_ANDESITE_BRICKS)
        .create(SMBItems.MOSSY_ANDESITE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_ANDESITE_BRICKS).cuttableFrom(SMBItems.MOSSY_ANDESITE_BRICKS)
        .create(SMBItems.SMOOTH_ANDESITE).craftableFrom(Blocks.ANDESITE)
        .create(SMBItems.SMOOTH_ANDESITE_SLAB).craftableFrom(SMBItems.SMOOTH_ANDESITE).cuttableFrom(SMBItems.SMOOTH_ANDESITE)
      ).build();

    RecipeAdvancement.create(SMBItems.DEEPSLATE_PILLAR).craftableFrom(Blocks.DEEPSLATE_BRICKS).cuttableFrom(Blocks.DEEPSLATE).build();

    RecipeAdvancement
      .group("Calcite Variations", (instance) -> instance
        .create(SMBItems.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE)
        .create(SMBItems.POLISHED_CALCITE_STAIRS).craftableFrom(SMBItems.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE)
        .create(SMBItems.POLISHED_CALCITE_SLAB).craftableFrom(SMBItems.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE)
        .create(SMBItems.CHISELED_CALCITE_BRICKS).craftableFrom(SMBItems.CALCITE_BRICK_SLAB).cuttableFrom(Blocks.CALCITE, SMBItems.CALCITE_BRICKS)
        .create(SMBItems.CALCITE_BRICKS).craftableFrom(Blocks.CALCITE).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE)
        .create(SMBItems.CRACKED_CALCITE_BRICKS).craftableFrom(SMBItems.CALCITE_BRICKS)
        .create(SMBItems.CALCITE_BRICK_STAIRS).craftableFrom(SMBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE, SMBItems.CALCITE_BRICKS)
        .create(SMBItems.CALCITE_BRICK_SLAB).craftableFrom(SMBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE, SMBItems.CALCITE_BRICKS)
        .create(SMBItems.CALCITE_BRICK_WALL).craftableFrom(SMBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE, SMBItems.CALCITE_BRICKS)
        .create(SMBItems.CALCITE_PILLAR).craftableFrom(SMBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE)
        .create(SMBItems.CALCITE_TILES).craftableFrom(SMBItems.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE, SMBItems.CALCITE_BRICKS)
        .create(SMBItems.CRACKED_CALCITE_TILES).craftableFrom(SMBItems.CALCITE_TILES)
        .create(SMBItems.CALCITE_TILE_STAIRS).craftableFrom(SMBItems.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE, SMBItems.CALCITE_BRICKS, SMBItems.CALCITE_TILES)
        .create(SMBItems.CALCITE_TILE_SLAB).craftableFrom(SMBItems.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE, SMBItems.CALCITE_BRICKS, SMBItems.CALCITE_TILES)
        .create(SMBItems.CALCITE_TILE_WALL).craftableFrom(SMBItems.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, SMBItems.POLISHED_CALCITE, SMBItems.CALCITE_BRICKS, SMBItems.CALCITE_TILES)
        .create(SMBItems.MOSSY_CALCITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_CALCITE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_CALCITE_BRICKS).cuttableFrom(SMBItems.MOSSY_CALCITE_BRICKS)
        .create(SMBItems.MOSSY_CALCITE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_CALCITE_BRICKS).cuttableFrom(SMBItems.MOSSY_CALCITE_BRICKS)
        .create(SMBItems.MOSSY_CALCITE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_CALCITE_BRICKS).cuttableFrom(SMBItems.MOSSY_CALCITE_BRICKS)
        .create(SMBItems.SMOOTH_CALCITE).craftableFrom(Blocks.CALCITE)
        .create(SMBItems.SMOOTH_CALCITE_SLAB).craftableFrom(SMBItems.SMOOTH_CALCITE).cuttableFrom(SMBItems.SMOOTH_CALCITE)
      ).build();

    RecipeAdvancement
      .group("Tuff Variations", (instance) -> instance
        .create(SMBItems.POLISHED_TUFF).cuttableFrom(Blocks.TUFF)
        .create(SMBItems.POLISHED_TUFF_STAIRS).craftableFrom(SMBItems.POLISHED_TUFF).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF)
        .create(SMBItems.POLISHED_TUFF_SLAB).craftableFrom(SMBItems.POLISHED_TUFF).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF)
        .create(SMBItems.CHISELED_TUFF_BRICKS).craftableFrom(SMBItems.TUFF_BRICK_SLAB).cuttableFrom(Blocks.TUFF, SMBItems.TUFF_BRICKS)
        .create(SMBItems.TUFF_BRICKS).craftableFrom(Blocks.TUFF).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF)
        .create(SMBItems.CRACKED_TUFF_BRICKS).craftableFrom(SMBItems.TUFF_BRICKS)
        .create(SMBItems.TUFF_BRICK_STAIRS).craftableFrom(SMBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF, SMBItems.TUFF_BRICKS)
        .create(SMBItems.TUFF_BRICK_SLAB).craftableFrom(SMBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF, SMBItems.TUFF_BRICKS)
        .create(SMBItems.TUFF_BRICK_WALL).craftableFrom(SMBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF, SMBItems.TUFF_BRICKS)
        .create(SMBItems.TUFF_PILLAR).craftableFrom(SMBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF)
        .create(SMBItems.TUFF_TILES).craftableFrom(SMBItems.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF, SMBItems.TUFF_BRICKS)
        .create(SMBItems.CRACKED_TUFF_TILES).craftableFrom(SMBItems.TUFF_TILES)
        .create(SMBItems.TUFF_TILE_STAIRS).craftableFrom(SMBItems.TUFF_TILES).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF, SMBItems.TUFF_BRICKS, SMBItems.TUFF_TILES)
        .create(SMBItems.TUFF_TILE_SLAB).craftableFrom(SMBItems.TUFF_TILES).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF, SMBItems.TUFF_BRICKS, SMBItems.TUFF_TILES)
        .create(SMBItems.TUFF_TILE_WALL).craftableFrom(SMBItems.TUFF_TILES).cuttableFrom(Blocks.TUFF, SMBItems.POLISHED_TUFF, SMBItems.TUFF_BRICKS, SMBItems.TUFF_TILES)
        .create(SMBItems.MOSSY_TUFF_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_TUFF_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_TUFF_BRICKS).cuttableFrom(SMBItems.MOSSY_TUFF_BRICKS)
        .create(SMBItems.MOSSY_TUFF_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_TUFF_BRICKS).cuttableFrom(SMBItems.MOSSY_TUFF_BRICKS)
        .create(SMBItems.MOSSY_TUFF_BRICK_WALL).craftableFrom(SMBItems.MOSSY_TUFF_BRICKS).cuttableFrom(SMBItems.MOSSY_TUFF_BRICKS)
        .create(SMBItems.SMOOTH_TUFF).craftableFrom(Blocks.TUFF)
        .create(SMBItems.SMOOTH_TUFF_SLAB).craftableFrom(SMBItems.SMOOTH_TUFF).cuttableFrom(SMBItems.SMOOTH_TUFF)
      ).build();

    RecipeAdvancement
      .group("Dripstone Variations", (instance) -> instance
        .create(SMBItems.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBItems.POLISHED_DRIPSTONE_STAIRS).craftableFrom(SMBItems.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE)
        .create(SMBItems.POLISHED_DRIPSTONE_SLAB).craftableFrom(SMBItems.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE)
        .create(SMBItems.CHISELED_DRIPSTONE_BRICKS).craftableFrom(SMBItems.DRIPSTONE_BRICK_SLAB).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.DRIPSTONE_BRICKS)
        .create(SMBItems.DRIPSTONE_BRICKS).craftableFrom(Blocks.DRIPSTONE_BLOCK).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE)
        .create(SMBItems.CRACKED_DRIPSTONE_BRICKS).craftableFrom(SMBItems.DRIPSTONE_BRICKS)
        .create(SMBItems.DRIPSTONE_BRICK_STAIRS).craftableFrom(SMBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE, SMBItems.DRIPSTONE_BRICKS)
        .create(SMBItems.DRIPSTONE_BRICK_SLAB).craftableFrom(SMBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE, SMBItems.DRIPSTONE_BRICKS)
        .create(SMBItems.DRIPSTONE_BRICK_WALL).craftableFrom(SMBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE, SMBItems.DRIPSTONE_BRICKS)
        .create(SMBItems.DRIPSTONE_PILLAR).craftableFrom(SMBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBItems.DRIPSTONE_TILES).craftableFrom(SMBItems.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE, SMBItems.DRIPSTONE_BRICKS)
        .create(SMBItems.CRACKED_DRIPSTONE_TILES).craftableFrom(SMBItems.DRIPSTONE_TILES)
        .create(SMBItems.DRIPSTONE_TILE_STAIRS).craftableFrom(SMBItems.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE, SMBItems.DRIPSTONE_BRICKS, SMBItems.DRIPSTONE_TILES)
        .create(SMBItems.DRIPSTONE_TILE_SLAB).craftableFrom(SMBItems.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE, SMBItems.DRIPSTONE_BRICKS, SMBItems.DRIPSTONE_TILES)
        .create(SMBItems.DRIPSTONE_TILE_WALL).craftableFrom(SMBItems.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBItems.POLISHED_DRIPSTONE, SMBItems.DRIPSTONE_BRICKS, SMBItems.DRIPSTONE_TILES)
        .create(SMBItems.MOSSY_DRIPSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_DRIPSTONE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_DRIPSTONE_BRICKS)
        .create(SMBItems.MOSSY_DRIPSTONE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_DRIPSTONE_BRICKS)
        .create(SMBItems.MOSSY_DRIPSTONE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_DRIPSTONE_BRICKS)
        .create(SMBItems.SMOOTH_DRIPSTONE).craftableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBItems.SMOOTH_DRIPSTONE_SLAB).craftableFrom(SMBItems.SMOOTH_DRIPSTONE).cuttableFrom(SMBItems.SMOOTH_DRIPSTONE)
      ).build();

    RecipeAdvancement.
      group("Bricks Variations", (instance) -> instance
        .create(SMBItems.CRACKED_BRICKS).craftableFrom(Blocks.BRICKS)
        .create(SMBItems.MOSSY_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_BRICKS).cuttableFrom(SMBItems.MOSSY_BRICKS)
        .create(SMBItems.MOSSY_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_BRICKS).cuttableFrom(SMBItems.MOSSY_BRICKS)
        .create(SMBItems.MOSSY_BRICK_WALL).craftableFrom(SMBItems.MOSSY_BRICKS).cuttableFrom(SMBItems.MOSSY_BRICKS)
      ).build();

    RecipeAdvancement.
      group("Mud Variations", (instance) -> instance
        .setExpectedEntries(17)
        .create(SMBItems.POLISHED_MUD).craftableFrom(Blocks.PACKED_MUD)
        .create(SMBItems.POLISHED_MUD_STAIRS).craftableFrom(SMBItems.POLISHED_MUD).cuttableFrom(Blocks.PACKED_MUD, SMBItems.POLISHED_MUD)
        .create(SMBItems.POLISHED_MUD_SLAB).craftableFrom(SMBItems.POLISHED_MUD).cuttableFrom(Blocks.PACKED_MUD, SMBItems.POLISHED_MUD)
        .create(SMBItems.CHISELED_MUD_BRICKS).craftableFrom(Blocks.MUD_BRICK_SLAB).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS)
        .create(SMBItems.CRACKED_MUD_BRICKS).craftableFrom(Blocks.MUD_BRICKS)
        .create(SMBItems.MUD_PILLAR).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD)
        .create(SMBItems.MUD_TILES).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBItems.POLISHED_MUD)
        .create(SMBItems.CRACKED_MUD_TILES).craftableFrom(SMBItems.MUD_TILES)
        .create(SMBItems.MUD_TILE_STAIRS).craftableFrom(SMBItems.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBItems.POLISHED_MUD, SMBItems.MUD_TILES)
        .create(SMBItems.MUD_TILE_SLAB).craftableFrom(SMBItems.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBItems.POLISHED_MUD, SMBItems.MUD_TILES)
        .create(SMBItems.MUD_TILE_WALL).craftableFrom(SMBItems.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBItems.POLISHED_MUD, SMBItems.MUD_TILES)
        .create(SMBItems.MOSSY_MUD_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_MUD_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_MUD_BRICKS).cuttableFrom(SMBItems.MOSSY_MUD_BRICKS)
        .create(SMBItems.MOSSY_MUD_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_MUD_BRICKS).cuttableFrom(SMBItems.MOSSY_MUD_BRICKS)
        .create(SMBItems.MOSSY_MUD_BRICK_WALL).craftableFrom(SMBItems.MOSSY_MUD_BRICKS).cuttableFrom(SMBItems.MOSSY_MUD_BRICKS)
        .create(SMBItems.SMOOTH_MUD).craftableFrom(Blocks.PACKED_MUD)
        .create(SMBItems.SMOOTH_MUD_SLAB).craftableFrom(SMBItems.SMOOTH_MUD).cuttableFrom(SMBItems.SMOOTH_MUD)
      ).build();

    RecipeAdvancement.
      group("Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(SMBItems.SANDSTONE_BRICKS).craftableFrom(Blocks.SMOOTH_SANDSTONE).cuttableFrom(Blocks.SANDSTONE)
        .create(SMBItems.CRACKED_SANDSTONE_BRICKS).craftableFrom(SMBItems.SANDSTONE_BRICKS)
        .create(SMBItems.SANDSTONE_BRICK_STAIRS).craftableFrom(SMBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBItems.SANDSTONE_BRICKS)
        .create(SMBItems.SANDSTONE_BRICK_SLAB).craftableFrom(SMBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBItems.SANDSTONE_BRICKS)
        .create(SMBItems.SANDSTONE_BRICK_WALL).craftableFrom(SMBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBItems.SANDSTONE_BRICKS)
        .create(SMBItems.SANDSTONE_PILLAR).craftableFrom(SMBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE)
        .create(SMBItems.SANDSTONE_TILES).craftableFrom(SMBItems.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBItems.SANDSTONE_BRICKS)
        .create(SMBItems.CRACKED_SANDSTONE_TILES).craftableFrom(SMBItems.SANDSTONE_BRICKS)
        .create(SMBItems.SANDSTONE_TILE_STAIRS).craftableFrom(SMBItems.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, SMBItems.SANDSTONE_BRICKS, SMBItems.SANDSTONE_TILES)
        .create(SMBItems.SANDSTONE_TILE_SLAB).craftableFrom(SMBItems.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, SMBItems.SANDSTONE_BRICKS, SMBItems.SANDSTONE_TILES)
        .create(SMBItems.SANDSTONE_TILE_WALL).craftableFrom(SMBItems.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, SMBItems.SANDSTONE_BRICKS, SMBItems.SANDSTONE_TILES)
        .create(SMBItems.MOSSY_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_SANDSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_SANDSTONE_BRICKS)
        .create(SMBItems.MOSSY_SANDSTONE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_SANDSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_SANDSTONE_BRICKS)
        .create(SMBItems.MOSSY_SANDSTONE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_SANDSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_SANDSTONE_BRICKS)
      ).build();

    RecipeAdvancement.
      group("Red Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(SMBItems.RED_SANDSTONE_BRICKS).craftableFrom(Blocks.SMOOTH_RED_SANDSTONE).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(SMBItems.CRACKED_RED_SANDSTONE_BRICKS).craftableFrom(SMBItems.RED_SANDSTONE_BRICKS)
        .create(SMBItems.RED_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBItems.RED_SANDSTONE_BRICKS)
        .create(SMBItems.RED_SANDSTONE_BRICK_SLAB).craftableFrom(SMBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBItems.RED_SANDSTONE_BRICKS)
        .create(SMBItems.RED_SANDSTONE_BRICK_WALL).craftableFrom(SMBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBItems.RED_SANDSTONE_BRICKS)
        .create(SMBItems.RED_SANDSTONE_PILLAR).craftableFrom(SMBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(SMBItems.RED_SANDSTONE_TILES).craftableFrom(SMBItems.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBItems.RED_SANDSTONE_BRICKS)
        .create(SMBItems.CRACKED_RED_SANDSTONE_TILES).craftableFrom(SMBItems.RED_SANDSTONE_BRICKS)
        .create(SMBItems.RED_SANDSTONE_TILE_STAIRS).craftableFrom(SMBItems.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, SMBItems.RED_SANDSTONE_BRICKS, SMBItems.RED_SANDSTONE_TILES)
        .create(SMBItems.RED_SANDSTONE_TILE_SLAB).craftableFrom(SMBItems.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, SMBItems.RED_SANDSTONE_BRICKS, SMBItems.RED_SANDSTONE_TILES)
        .create(SMBItems.RED_SANDSTONE_TILE_WALL).craftableFrom(SMBItems.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, SMBItems.RED_SANDSTONE_BRICKS, SMBItems.RED_SANDSTONE_TILES)
        .create(SMBItems.MOSSY_RED_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_RED_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_RED_SANDSTONE_BRICKS)
        .create(SMBItems.MOSSY_RED_SANDSTONE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_RED_SANDSTONE_BRICKS)
        .create(SMBItems.MOSSY_RED_SANDSTONE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(SMBItems.MOSSY_RED_SANDSTONE_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Prismarine Variations", (instance) -> instance
        .create(SMBItems.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE)
        .create(SMBItems.POLISHED_PRISMARINE_STAIRS).craftableFrom(SMBItems.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE, SMBItems.POLISHED_PRISMARINE)
        .create(SMBItems.POLISHED_PRISMARINE_SLAB).craftableFrom(SMBItems.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE, SMBItems.POLISHED_PRISMARINE)
        .create(SMBItems.CHISELED_PRISMARINE_BRICKS).craftableFrom(Blocks.PRISMARINE_BRICK_SLAB).cuttableFrom(Blocks.PRISMARINE, SMBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS)
        .create(SMBItems.CRACKED_PRISMARINE_BRICKS).craftableFrom(Blocks.PRISMARINE_BRICKS)
        .create(SMBItems.PRISMARINE_PILLAR).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE)
        .create(SMBItems.PRISMARINE_TILES).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS)
        .create(SMBItems.CRACKED_PRISMARINE_TILES).craftableFrom(SMBItems.PRISMARINE_TILES)
        .create(SMBItems.PRISMARINE_TILE_STAIRS).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, SMBItems.PRISMARINE_TILES)
        .create(SMBItems.PRISMARINE_TILE_SLAB).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, SMBItems.PRISMARINE_TILES)
        .create(SMBItems.PRISMARINE_TILE_WALL).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBItems.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, SMBItems.PRISMARINE_TILES)
        .create(SMBItems.MOSSY_PRISMARINE_BRICKS).craftableFrom(Items.KELP)
        .create(SMBItems.MOSSY_PRISMARINE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_PRISMARINE_BRICKS).cuttableFrom(SMBItems.MOSSY_PRISMARINE_BRICKS)
        .create(SMBItems.MOSSY_PRISMARINE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_PRISMARINE_BRICKS).cuttableFrom(SMBItems.MOSSY_PRISMARINE_BRICKS)
        .create(SMBItems.MOSSY_PRISMARINE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_PRISMARINE_BRICKS).cuttableFrom(SMBItems.MOSSY_PRISMARINE_BRICKS)
        .create(SMBItems.SMOOTH_PRISMARINE).craftableFrom(Blocks.PRISMARINE)
        .create(SMBItems.SMOOTH_PRISMARINE_SLAB).craftableFrom(SMBItems.SMOOTH_PRISMARINE).cuttableFrom(SMBItems.SMOOTH_PRISMARINE)
      ).build();

    RecipeAdvancement.create(SMBItems.NETHER_BRICKS_PILLAR).craftableFrom(Blocks.NETHER_BRICKS).cuttableFrom(Blocks.NETHER_BRICKS).build();

    RecipeAdvancement
      .group("Red Nether Bricks Variations", (instance) -> instance
        .create(SMBItems.CRACKED_RED_NETHER_BRICKS).craftableFrom(Blocks.RED_NETHER_BRICKS)
        .create(SMBItems.CHISELED_RED_NETHER_BRICKS).craftableFrom(Blocks.RED_NETHER_BRICK_SLAB).cuttableFrom(Blocks.RED_NETHER_BRICKS)
        .create(SMBItems.RED_NETHER_BRICKS_PILLAR).craftableFrom(Blocks.RED_NETHER_BRICKS).cuttableFrom(Blocks.RED_NETHER_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Polished Blackstone Variations", (instance) -> instance
        .create(SMBItems.POLISHED_BLACKSTONE_PILLAR).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE)
        .create(SMBItems.POLISHED_BLACKSTONE_TILES).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS)
        .create(SMBItems.CRACKED_POLISHED_BLACKSTONE_TILES).craftableFrom(SMBItems.POLISHED_BLACKSTONE_TILES)
        .create(SMBItems.POLISHED_BLACKSTONE_TILE_STAIRS).craftableFrom(SMBItems.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBItems.POLISHED_BLACKSTONE_TILES)
        .create(SMBItems.POLISHED_BLACKSTONE_TILE_SLAB).craftableFrom(SMBItems.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBItems.POLISHED_BLACKSTONE_TILES)
        .create(SMBItems.POLISHED_BLACKSTONE_TILE_WALL).craftableFrom(SMBItems.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBItems.POLISHED_BLACKSTONE_TILES)
        .create(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).craftableFrom(Items.MAGMA_CREAM)
        .create(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS).craftableFrom(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB).craftableFrom(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL).craftableFrom(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(SMBItems.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(SMBItems.SMOOTH_BLACKSTONE).craftableFrom(Blocks.BLACKSTONE)
        .create(SMBItems.SMOOTH_BLACKSTONE_SLAB).craftableFrom(SMBItems.SMOOTH_BLACKSTONE).cuttableFrom(SMBItems.SMOOTH_BLACKSTONE)
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(SMBItems.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE)
        .create(SMBItems.POLISHED_END_STONE_STAIRS).craftableFrom(SMBItems.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE, SMBItems.POLISHED_STONE)
        .create(SMBItems.POLISHED_END_STONE_SLAB).craftableFrom(SMBItems.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE, SMBItems.POLISHED_STONE)
        .create(SMBItems.CHISELED_END_STONE_BRICKS).craftableFrom(Blocks.END_STONE_BRICK_SLAB).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS)
        .create(SMBItems.CRACKED_END_STONE_BRICKS).craftableFrom(Blocks.END_STONE_BRICKS)
        .create(SMBItems.END_STONE_PILLAR).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE)
        .create(SMBItems.END_STONE_TILES).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBItems.POLISHED_END_STONE)
        .create(SMBItems.CRACKED_END_STONE_TILES).craftableFrom(SMBItems.END_STONE_TILES)
        .create(SMBItems.END_STONE_TILE_STAIRS).craftableFrom(SMBItems.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBItems.POLISHED_END_STONE, SMBItems.END_STONE_TILES)
        .create(SMBItems.END_STONE_TILE_SLAB).craftableFrom(SMBItems.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBItems.POLISHED_END_STONE, SMBItems.END_STONE_TILES)
        .create(SMBItems.END_STONE_TILE_WALL).craftableFrom(SMBItems.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBItems.POLISHED_END_STONE, SMBItems.END_STONE_TILES)
        .create(SMBItems.MOSSY_END_STONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_END_STONE_BRICK_STAIRS).craftableFrom(SMBItems.MOSSY_END_STONE_BRICKS).cuttableFrom(SMBItems.MOSSY_END_STONE_BRICKS)
        .create(SMBItems.MOSSY_END_STONE_BRICK_SLAB).craftableFrom(SMBItems.MOSSY_END_STONE_BRICKS).cuttableFrom(SMBItems.MOSSY_END_STONE_BRICKS)
        .create(SMBItems.MOSSY_END_STONE_BRICK_WALL).craftableFrom(SMBItems.MOSSY_END_STONE_BRICKS).cuttableFrom(SMBItems.MOSSY_END_STONE_BRICKS)
        .create(SMBItems.SMOOTH_END_STONE).craftableFrom(Blocks.END_STONE)
        .create(SMBItems.SMOOTH_END_STONE_SLAB).craftableFrom(SMBItems.SMOOTH_END_STONE).cuttableFrom(SMBItems.SMOOTH_END_STONE)
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(SMBItems.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBItems.POLISHED_PURPUR_STAIRS).craftableFrom(SMBItems.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK, SMBItems.POLISHED_STONE)
        .create(SMBItems.POLISHED_PURPUR_SLAB).craftableFrom(SMBItems.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK, SMBItems.POLISHED_STONE)
        .create(SMBItems.CHISELED_PURPUR).craftableFrom(Blocks.END_ROD)
        .create(SMBItems.CRACKED_PURPUR_BLOCK).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBItems.PURPUR_TILES).craftableFrom(Blocks.PURPUR_BLOCK).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBItems.POLISHED_PURPUR)
        .create(SMBItems.CRACKED_PURPUR_TILES).craftableFrom(SMBItems.PURPUR_TILES)
        .create(SMBItems.PURPUR_TILE_STAIRS).craftableFrom(SMBItems.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBItems.POLISHED_PURPUR, SMBItems.PURPUR_TILES)
        .create(SMBItems.PURPUR_TILE_SLAB).craftableFrom(SMBItems.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBItems.POLISHED_PURPUR, SMBItems.PURPUR_TILES)
        .create(SMBItems.PURPUR_TILE_WALL).craftableFrom(SMBItems.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBItems.POLISHED_PURPUR, SMBItems.PURPUR_TILES)
        .create(SMBItems.MOSSY_PURPUR_BLOCK).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBItems.MOSSY_PURPUR_BLOCK_STAIRS).craftableFrom(SMBItems.MOSSY_PURPUR_BLOCK).cuttableFrom(SMBItems.MOSSY_PURPUR_BLOCK)
        .create(SMBItems.MOSSY_PURPUR_BLOCK_SLAB).craftableFrom(SMBItems.MOSSY_PURPUR_BLOCK).cuttableFrom(SMBItems.MOSSY_PURPUR_BLOCK)
        .create(SMBItems.MOSSY_PURPUR_BLOCK_WALL).craftableFrom(SMBItems.MOSSY_PURPUR_BLOCK).cuttableFrom(SMBItems.MOSSY_PURPUR_BLOCK)
        .create(SMBItems.SMOOTH_PURPUR).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBItems.SMOOTH_PURPUR_SLAB).craftableFrom(SMBItems.SMOOTH_PURPUR).cuttableFrom(SMBItems.SMOOTH_PURPUR)
      ).build();

    RecipeAdvancement
      .group("Coal Block Variations", (instance) -> instance
        .create(SMBItems.COAL_BRICKS).craftableFrom(SMBItems.CUT_COAL)
        .create(SMBItems.CRACKED_COAL_BRICKS).craftableFrom(SMBItems.COAL_BRICKS)
        .create(SMBItems.COAL_PILLAR).craftableFrom(Blocks.COAL_BLOCK)
        .create(SMBItems.CUT_COAL).craftableFrom(Blocks.COAL_BLOCK)
        .create(SMBItems.CRACKED_CUT_COAL).craftableFrom(SMBItems.CUT_COAL)
      ).build();

    RecipeAdvancement
      .group("Iron Block Variations", (instance) -> instance
        .create(SMBItems.IRON_BRICKS).craftableFrom(SMBItems.CUT_IRON)
        .create(SMBItems.CRACKED_IRON_BRICKS).craftableFrom(SMBItems.IRON_BRICKS)
        .create(SMBItems.IRON_PILLAR).craftableFrom(Blocks.IRON_BLOCK)
        .create(SMBItems.CUT_IRON).craftableFrom(Blocks.IRON_BLOCK)
        .create(SMBItems.CRACKED_CUT_IRON).craftableFrom(SMBItems.CUT_IRON)
        .create(SMBItems.IRON_GRATE).craftableFrom(Blocks.IRON_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Gold Block Variations", (instance) -> instance
        .create(SMBItems.GOLD_BRICKS).craftableFrom(SMBItems.CUT_GOLD)
        .create(SMBItems.CRACKED_GOLD_BRICKS).craftableFrom(SMBItems.GOLD_BRICKS)
        .create(SMBItems.GOLD_PILLAR).craftableFrom(Blocks.GOLD_BLOCK)
        .create(SMBItems.CUT_GOLD).craftableFrom(Blocks.GOLD_BLOCK)
        .create(SMBItems.CRACKED_CUT_GOLD).craftableFrom(SMBItems.CUT_GOLD)
      ).build();

    RecipeAdvancement
      .group("Emerald Block Variations", (instance) -> instance
        .create(SMBItems.EMERALD_BRICKS).craftableFrom(SMBItems.CUT_EMERALD)
        .create(SMBItems.CRACKED_EMERALD_BRICKS).craftableFrom(SMBItems.EMERALD_BRICKS)
        .create(SMBItems.EMERALD_PILLAR).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(SMBItems.CUT_EMERALD).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(SMBItems.CRACKED_CUT_EMERALD).craftableFrom(SMBItems.CUT_EMERALD)
      ).build();

    RecipeAdvancement
      .group("Lapis Block Variations", (instance) -> instance
        .create(SMBItems.LAPIS_BRICKS).craftableFrom(SMBItems.CUT_LAPIS)
        .create(SMBItems.CRACKED_LAPIS_BRICKS).craftableFrom(SMBItems.LAPIS_BRICKS)
        .create(SMBItems.LAPIS_PILLAR).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(SMBItems.CUT_LAPIS).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(SMBItems.CRACKED_CUT_LAPIS).craftableFrom(SMBItems.CUT_LAPIS)
      ).build();

    RecipeAdvancement
      .group("Diamond Block Variations", (instance) -> instance
        .create(SMBItems.DIAMOND_BRICKS).craftableFrom(SMBItems.CUT_DIAMOND)
        .create(SMBItems.CRACKED_DIAMOND_BRICKS).craftableFrom(SMBItems.DIAMOND_BRICKS)
        .create(SMBItems.DIAMOND_PILLAR).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(SMBItems.CUT_DIAMOND).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(SMBItems.CRACKED_CUT_DIAMOND).craftableFrom(SMBItems.CUT_DIAMOND)
        .create(SMBItems.DIAMOND_GRATE).craftableFrom(Blocks.DIAMOND_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Netherite Block Variations", (instance) -> instance
        .create(SMBItems.NETHERITE_BRICKS).craftableFrom(SMBItems.CUT_NETHERITE)
        .create(SMBItems.CRACKED_NETHERITE_BRICKS).craftableFrom(SMBItems.NETHERITE_BRICKS)
        .create(SMBItems.NETHERITE_PILLAR).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(SMBItems.CUT_NETHERITE).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(SMBItems.CRACKED_CUT_NETHERITE).craftableFrom(SMBItems.CUT_NETHERITE)
        .create(SMBItems.NETHERITE_GRATE).craftableFrom(Blocks.NETHERITE_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Quartz Block Variations", (instance) -> instance
        .create(SMBItems.CRACKED_QUARTZ_BRICKS).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(SMBItems.CUT_QUARTZ).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(SMBItems.CRACKED_CUT_QUARTZ).craftableFrom(SMBItems.CUT_QUARTZ)
      ).build();

    RecipeAdvancement
      .group("Amethyst Block Variations", (instance) -> instance
        .create(SMBItems.AMETHYST_BRICKS).craftableFrom(SMBItems.CUT_AMETHYST)
        .create(SMBItems.CRACKED_AMETHYST_BRICKS).craftableFrom(SMBItems.AMETHYST_BRICKS)
        .create(SMBItems.AMETHYST_PILLAR).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(SMBItems.CUT_AMETHYST).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(SMBItems.CRACKED_CUT_AMETHYST).craftableFrom(SMBItems.CUT_AMETHYST)
      ).build();

    RecipeAdvancement
      .group("Redstone Block Variations", (instance) -> instance
        .create(SMBItems.AMETHYST_BRICKS).craftableFrom(SMBItems.CUT_REDSTONE)
        .create(SMBItems.CRACKED_REDSTONE_BRICKS).craftableFrom(SMBItems.REDSTONE_BRICKS)
        .create(SMBItems.REDSTONE_PILLAR).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(SMBItems.CUT_REDSTONE).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(SMBItems.CRACKED_CUT_REDSTONE).craftableFrom(SMBItems.CUT_REDSTONE)
      ).build();

    RecipeAdvancement
      .group("Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(SMBItems.COPPER_BRICKS).craftableFrom(Blocks.CUT_COPPER)
        .create(SMBItems.CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.CRACKED_COPPER_BRICKS)
        .create(SMBItems.COPPER_PILLAR).craftableFrom(Blocks.COPPER_BLOCK)
        .create(SMBItems.CRACKED_CUT_COPPER).craftableFrom(Blocks.CUT_COPPER)
        .create(SMBItems.EXPOSED_COPPER_BRICKS).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(SMBItems.EXPOSED_CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.EXPOSED_CRACKED_COPPER_BRICKS)
        .create(SMBItems.EXPOSED_COPPER_PILLAR).craftableFrom(Blocks.EXPOSED_COPPER)
        .create(SMBItems.EXPOSED_CRACKED_CUT_COPPER).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(SMBItems.WEATHERED_COPPER_BRICKS).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(SMBItems.WEATHERED_CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.WEATHERED_CRACKED_COPPER_BRICKS)
        .create(SMBItems.WEATHERED_COPPER_PILLAR).craftableFrom(Blocks.WEATHERED_COPPER)
        .create(SMBItems.WEATHERED_CRACKED_CUT_COPPER).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(SMBItems.OXIDIZED_COPPER_BRICKS).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
        .create(SMBItems.OXIDIZED_CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.OXIDIZED_CRACKED_COPPER_BRICKS)
        .create(SMBItems.OXIDIZED_COPPER_PILLAR).craftableFrom(Blocks.OXIDIZED_COPPER)
        .create(SMBItems.OXIDIZED_CRACKED_CUT_COPPER).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
      ).build();

    RecipeAdvancement
      .group("Waxed Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(SMBItems.WAXED_COPPER_BRICKS).craftableFrom(SMBItems.COPPER_BRICKS)
        .create(SMBItems.WAXED_CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.CRACKED_COPPER_BRICKS)
        .create(SMBItems.WAXED_COPPER_PILLAR).craftableFrom(SMBItems.COPPER_PILLAR)
        .create(SMBItems.WAXED_CRACKED_CUT_COPPER).craftableFrom(SMBItems.CRACKED_CUT_COPPER)
        .create(SMBItems.WAXED_EXPOSED_COPPER_BRICKS).craftableFrom(SMBItems.EXPOSED_COPPER_BRICKS)
        .create(SMBItems.WAXED_EXPOSED_CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.EXPOSED_CRACKED_COPPER_BRICKS)
        .create(SMBItems.WAXED_EXPOSED_COPPER_PILLAR).craftableFrom(SMBItems.EXPOSED_COPPER_PILLAR)
        .create(SMBItems.WAXED_EXPOSED_CRACKED_CUT_COPPER).craftableFrom(SMBItems.EXPOSED_CRACKED_CUT_COPPER)
        .create(SMBItems.WAXED_WEATHERED_COPPER_BRICKS).craftableFrom(SMBItems.WEATHERED_COPPER_BRICKS)
        .create(SMBItems.WAXED_WEATHERED_CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.WEATHERED_CRACKED_COPPER_BRICKS)
        .create(SMBItems.WAXED_WEATHERED_COPPER_PILLAR).craftableFrom(SMBItems.WEATHERED_COPPER_PILLAR)
        .create(SMBItems.WAXED_WEATHERED_CRACKED_CUT_COPPER).craftableFrom(SMBItems.WEATHERED_CRACKED_CUT_COPPER)
        .create(SMBItems.WAXED_OXIDIZED_COPPER_BRICKS).craftableFrom(SMBItems.OXIDIZED_COPPER_BRICKS)
        .create(SMBItems.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS).craftableFrom(SMBItems.OXIDIZED_CRACKED_COPPER_BRICKS)
        .create(SMBItems.WAXED_OXIDIZED_COPPER_PILLAR).craftableFrom(SMBItems.OXIDIZED_COPPER_PILLAR)
        .create(SMBItems.WAXED_OXIDIZED_CRACKED_CUT_COPPER).craftableFrom(SMBItems.OXIDIZED_CRACKED_CUT_COPPER)
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
        .create(SMBItems.BONE_BRICKS).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK)
        .create(SMBItems.CRACKED_BONE_BRICKS).craftableFrom(SMBItems.BONE_BRICKS)
        .create(SMBItems.BONE_BRICK_STAIRS).craftableFrom(SMBItems.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, SMBItems.BONE_BRICKS)
        .create(SMBItems.BONE_BRICK_SLAB).craftableFrom(SMBItems.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, SMBItems.BONE_BRICKS)
        .create(SMBItems.BONE_BRICK_WALL).craftableFrom(SMBItems.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, SMBItems.BONE_BRICKS)
        .create(SMBItems.BONE_TILES).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK, SMBItems.BONE_BRICKS)
        .create(SMBItems.CRACKED_BONE_TILES).craftableFrom(SMBItems.BONE_TILES)
        .create(SMBItems.BONE_TILE_STAIRS).craftableFrom(SMBItems.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, SMBItems.BONE_BRICKS, SMBItems.BONE_TILES)
        .create(SMBItems.BONE_TILE_SLAB).craftableFrom(SMBItems.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, SMBItems.BONE_BRICKS, SMBItems.BONE_TILES)
        .create(SMBItems.BONE_TILE_WALL).craftableFrom(SMBItems.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, SMBItems.BONE_BRICKS, SMBItems.BONE_TILES)
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
        .create(SMBItems.SOUL_SANDSTONE).craftableFrom(Blocks.SOUL_SAND, Blocks.SOUL_SOIL)
        .create(SMBItems.SOUL_SANDSTONE_STAIRS).craftableFrom(SMBItems.SOUL_SANDSTONE).cuttableFrom(SMBItems.SOUL_SANDSTONE)
        .create(SMBItems.SOUL_SANDSTONE_SLAB).craftableFrom(SMBItems.SOUL_SANDSTONE).cuttableFrom(SMBItems.SOUL_SANDSTONE)
        .create(SMBItems.SOUL_SANDSTONE_WALL).craftableFrom(SMBItems.SOUL_SANDSTONE).cuttableFrom(SMBItems.SOUL_SANDSTONE)
        .create(SMBItems.CHISELED_SOUL_SANDSTONE).craftableFrom(SMBItems.SOUL_SANDSTONE_SLAB).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS)
        .create(SMBItems.SOUL_SANDSTONE_BRICKS).craftableFrom(SMBItems.SMOOTH_SOUL_SANDSTONE).cuttableFrom(SMBItems.SOUL_SANDSTONE)
        .create(SMBItems.CRACKED_SOUL_SANDSTONE_BRICKS).craftableFrom(SMBItems.SOUL_SANDSTONE_BRICKS)
        .create(SMBItems.SOUL_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS)
        .create(SMBItems.SOUL_SANDSTONE_BRICK_SLAB).craftableFrom(SMBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS)
        .create(SMBItems.SOUL_SANDSTONE_BRICK_WALL).craftableFrom(SMBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS)
        .create(SMBItems.SOUL_SANDSTONE_PILLAR).craftableFrom(SMBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBItems.SOUL_SANDSTONE)
        .create(SMBItems.SOUL_SANDSTONE_TILES).craftableFrom(SMBItems.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS)
        .create(SMBItems.CRACKED_SOUL_SANDSTONE_TILES).craftableFrom(SMBItems.SOUL_SANDSTONE_BRICKS)
        .create(SMBItems.SOUL_SANDSTONE_TILE_STAIRS).craftableFrom(SMBItems.SOUL_SANDSTONE_TILES).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS, SMBItems.SOUL_SANDSTONE_TILES)
        .create(SMBItems.SOUL_SANDSTONE_TILE_SLAB).craftableFrom(SMBItems.SOUL_SANDSTONE_TILES).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS, SMBItems.SOUL_SANDSTONE_TILES)
        .create(SMBItems.SOUL_SANDSTONE_TILE_WALL).craftableFrom(SMBItems.SOUL_SANDSTONE_TILES).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.SOUL_SANDSTONE_BRICKS, SMBItems.SOUL_SANDSTONE_TILES)
        .create(SMBItems.SMOOTH_SOUL_SANDSTONE).craftableFrom(SMBItems.SOUL_SANDSTONE)
        .create(SMBItems.SMOOTH_SOUL_SANDSTONE_SLAB).craftableFrom(SMBItems.SMOOTH_SOUL_SANDSTONE).cuttableFrom(SMBItems.SMOOTH_SOUL_SANDSTONE)
        .create(SMBItems.SMOOTH_SOUL_SANDSTONE_STAIRS).craftableFrom(SMBItems.SMOOTH_SOUL_SANDSTONE).cuttableFrom(SMBItems.SMOOTH_SOUL_SANDSTONE)

        .create(SMBItems.CUT_SOUL_SANDSTONE).craftableFrom(SMBItems.SOUL_SANDSTONE).cuttableFrom(SMBItems.SOUL_SANDSTONE)
        .create(SMBItems.CUT_SOUL_SANDSTONE_SLAB).craftableFrom(SMBItems.CUT_SOUL_SANDSTONE).cuttableFrom(SMBItems.SOUL_SANDSTONE, SMBItems.CUT_SOUL_SANDSTONE)
        /*.create(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)
        .create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_WALL).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)*/
      ).build();

    RecipeAdvancement
      .group("Snow Block Variations", (instance) -> instance
        .create(SMBItems.PACKED_SNOW).craftableFrom(Blocks.SNOW_BLOCK)
        .create(SMBItems.PACKED_SNOW_STAIRS).craftableFrom(SMBItems.PACKED_SNOW)
        .create(SMBItems.PACKED_SNOW_SLAB).craftableFrom(SMBItems.PACKED_SNOW)
        .create(SMBItems.POLISHED_SNOW).craftableFrom(SMBItems.PACKED_SNOW)
        .create(SMBItems.POLISHED_SNOW_STAIRS).craftableFrom(SMBItems.PACKED_SNOW)
        .create(SMBItems.POLISHED_SNOW_SLAB).craftableFrom(SMBItems.PACKED_SNOW)
        .create(SMBItems.SNOW_BRICKS).craftableFrom(SMBItems.POLISHED_SNOW_SLAB)
        //.create(MBItems.CRACKED_SNOW_BRICKS).craftableFrom(MBItems.POLISHED_SNOW_SLAB)
        .create(SMBItems.SNOW_BRICK_STAIRS).craftableFrom(SMBItems.SNOW_BRICKS)
        .create(SMBItems.SNOW_BRICK_SLAB).craftableFrom(SMBItems.SNOW_BRICKS)
        .create(SMBItems.SNOW_BRICK_WALL).craftableFrom(SMBItems.SNOW_BRICKS)
        .create(SMBItems.SNOW_PILLAR).craftableFrom(SMBItems.SNOW_BRICKS)
        .create(SMBItems.SNOW_TILES).craftableFrom(SMBItems.SNOW_BRICKS)
        //.create(MBItems.CRACKED_SNOW_TILES).craftableFrom(MBItems.SNOW_TILES)
        .create(SMBItems.SNOW_TILE_STAIRS).craftableFrom(SMBItems.SNOW_TILES)
        .create(SMBItems.SNOW_TILE_SLAB).craftableFrom(SMBItems.SNOW_TILES)
        .create(SMBItems.SNOW_TILE_WALL).craftableFrom(SMBItems.SNOW_TILES)
      ).build();

    RecipeAdvancement
      .group("Packed Ice Block Variations", (instance) -> instance
        .create(SMBItems.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE)
        .create(SMBItems.POLISHED_ICE_STAIRS).craftableFrom(SMBItems.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE)
        .create(SMBItems.POLISHED_ICE_SLAB).craftableFrom(SMBItems.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE)
        .create(SMBItems.ICE_BRICKS).craftableFrom(Blocks.PACKED_ICE).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE)
        //.create(MBItems.CRACKED_ICE_BRICKS).craftableFrom(MBItems.ICE_BRICKS)
        .create(SMBItems.ICE_BRICK_STAIRS).craftableFrom(SMBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE, SMBItems.ICE_BRICKS)
        .create(SMBItems.ICE_BRICK_SLAB).craftableFrom(SMBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE, SMBItems.ICE_BRICKS)
        .create(SMBItems.ICE_BRICK_WALL).craftableFrom(SMBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE, SMBItems.ICE_BRICKS)
        .create(SMBItems.ICE_PILLAR).craftableFrom(SMBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE)
        .create(SMBItems.ICE_TILES).craftableFrom(SMBItems.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE, SMBItems.ICE_BRICKS)
        //.create(MBItems.CRACKED_ICE_TILES).craftableFrom(MBItems.ICE_TILES)
        .create(SMBItems.ICE_TILE_STAIRS).craftableFrom(SMBItems.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE, SMBItems.ICE_BRICKS, SMBItems.ICE_TILES)
        .create(SMBItems.ICE_TILE_SLAB).craftableFrom(SMBItems.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE, SMBItems.ICE_BRICKS, SMBItems.ICE_TILES)
        .create(SMBItems.ICE_TILE_WALL).craftableFrom(SMBItems.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, SMBItems.POLISHED_ICE, SMBItems.ICE_BRICKS, SMBItems.ICE_TILES)
      ).build();

    RecipeAdvancement
      .group("Tiled Glasses Variation", (instance) -> instance
        .create(SMBItems.TILED_GLASS).craftableFrom(Blocks.GLASS)
        .create(SMBItems.TILED_TINTED_GLASS).craftableFrom(Blocks.TINTED_GLASS)
        .create(SMBItems.WHITE_STAINED_TILED_GLASS).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_STAINED_GLASS)
        .create(SMBItems.LIGHT_GRAY_STAINED_TILED_GLASS).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_STAINED_GLASS)
        .create(SMBItems.GRAY_STAINED_TILED_GLASS).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_STAINED_GLASS)
        .create(SMBItems.BLACK_STAINED_TILED_GLASS).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_STAINED_GLASS)
        .create(SMBItems.BROWN_STAINED_TILED_GLASS).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_STAINED_GLASS)
        .create(SMBItems.RED_STAINED_TILED_GLASS).craftableFrom(Items.RED_DYE, Blocks.RED_STAINED_GLASS)
        .create(SMBItems.ORANGE_STAINED_TILED_GLASS).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_STAINED_GLASS)
        .create(SMBItems.YELLOW_STAINED_TILED_GLASS).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_STAINED_GLASS)
        .create(SMBItems.LIME_STAINED_TILED_GLASS).craftableFrom(Items.LIME_DYE, Blocks.LIME_STAINED_GLASS)
        .create(SMBItems.GREEN_STAINED_TILED_GLASS).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_STAINED_GLASS)
        .create(SMBItems.CYAN_STAINED_TILED_GLASS).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_STAINED_GLASS)
        .create(SMBItems.LIGHT_BLUE_STAINED_TILED_GLASS).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_STAINED_GLASS)
        .create(SMBItems.BLUE_STAINED_TILED_GLASS).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_STAINED_GLASS)
        .create(SMBItems.PURPLE_STAINED_TILED_GLASS).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_STAINED_GLASS)
        .create(SMBItems.MAGENTA_STAINED_TILED_GLASS).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_STAINED_GLASS)
        .create(SMBItems.PINK_STAINED_TILED_GLASS).craftableFrom(Items.PINK_DYE, Blocks.PINK_STAINED_GLASS)
      ).build();

    RecipeAdvancement
      .group("Shingles Variation", (instance) -> instance
        .create(SMBItems.SHINGLES).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(SMBItems.WHITE_SHINGLES).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(SMBItems.LIGHT_GRAY_SHINGLES).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(SMBItems.GRAY_SHINGLES).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(SMBItems.BLACK_SHINGLES).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(SMBItems.BROWN_SHINGLES).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(SMBItems.RED_SHINGLES).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(SMBItems.ORANGE_SHINGLES).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(SMBItems.YELLOW_SHINGLES).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(SMBItems.LIME_SHINGLES).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(SMBItems.GREEN_SHINGLES).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(SMBItems.CYAN_SHINGLES).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(SMBItems.LIGHT_BLUE_SHINGLES).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(SMBItems.BLUE_SHINGLES).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(SMBItems.PURPLE_SHINGLES).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(SMBItems.MAGENTA_SHINGLES).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(SMBItems.PINK_SHINGLES).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Bricks Variation", (instance) -> instance
        .create(SMBItems.TERRACOTTA_BRICKS).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(SMBItems.WHITE_TERRACOTTA_BRICKS).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(SMBItems.LIGHT_GRAY_TERRACOTTA_BRICKS).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(SMBItems.GRAY_TERRACOTTA_BRICKS).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(SMBItems.BLACK_TERRACOTTA_BRICKS).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(SMBItems.BROWN_TERRACOTTA_BRICKS).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(SMBItems.RED_TERRACOTTA_BRICKS).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(SMBItems.ORANGE_TERRACOTTA_BRICKS).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(SMBItems.YELLOW_TERRACOTTA_BRICKS).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(SMBItems.LIME_TERRACOTTA_BRICKS).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(SMBItems.GREEN_TERRACOTTA_BRICKS).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(SMBItems.CYAN_TERRACOTTA_BRICKS).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(SMBItems.LIGHT_BLUE_TERRACOTTA_BRICKS).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(SMBItems.BLUE_TERRACOTTA_BRICKS).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(SMBItems.PURPLE_TERRACOTTA_BRICKS).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(SMBItems.MAGENTA_TERRACOTTA_BRICKS).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(SMBItems.PINK_TERRACOTTA_BRICKS).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Tiles Variation", (instance) -> instance
        .create(SMBItems.TERRACOTTA_TILES).craftableFrom(SMBItems.TERRACOTTA_BRICKS).cuttableFrom(SMBItems.TERRACOTTA_BRICKS)
        .create(SMBItems.WHITE_TERRACOTTA_TILES).craftableFrom(Items.WHITE_DYE, SMBItems.WHITE_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.WHITE_TERRACOTTA_BRICKS)
        .create(SMBItems.LIGHT_GRAY_TERRACOTTA_TILES).craftableFrom(Items.LIGHT_GRAY_DYE, SMBItems.LIGHT_GRAY_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.LIGHT_GRAY_TERRACOTTA_BRICKS)
        .create(SMBItems.GRAY_TERRACOTTA_TILES).craftableFrom(Items.GRAY_DYE, SMBItems.GRAY_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.GRAY_TERRACOTTA_BRICKS)
        .create(SMBItems.BLACK_TERRACOTTA_TILES).craftableFrom(Items.BLACK_DYE, SMBItems.BLACK_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.BLACK_TERRACOTTA_BRICKS)
        .create(SMBItems.BROWN_TERRACOTTA_TILES).craftableFrom(Items.BROWN_DYE, SMBItems.BROWN_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.BROWN_TERRACOTTA_BRICKS)
        .create(SMBItems.RED_TERRACOTTA_TILES).craftableFrom(Items.RED_DYE, SMBItems.RED_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.RED_TERRACOTTA_BRICKS)
        .create(SMBItems.ORANGE_TERRACOTTA_TILES).craftableFrom(Items.ORANGE_DYE, SMBItems.ORANGE_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.ORANGE_TERRACOTTA_BRICKS)
        .create(SMBItems.YELLOW_TERRACOTTA_TILES).craftableFrom(Items.YELLOW_DYE, SMBItems.YELLOW_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.YELLOW_TERRACOTTA_BRICKS)
        .create(SMBItems.LIME_TERRACOTTA_TILES).craftableFrom(Items.LIME_DYE, SMBItems.LIME_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.LIME_TERRACOTTA_BRICKS)
        .create(SMBItems.GREEN_TERRACOTTA_TILES).craftableFrom(Items.GREEN_DYE, SMBItems.GREEN_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.GREEN_TERRACOTTA_BRICKS)
        .create(SMBItems.CYAN_TERRACOTTA_TILES).craftableFrom(Items.CYAN_DYE, SMBItems.CYAN_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.CYAN_TERRACOTTA_BRICKS)
        .create(SMBItems.LIGHT_BLUE_TERRACOTTA_TILES).craftableFrom(Items.LIGHT_BLUE_DYE, SMBItems.LIGHT_BLUE_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.LIGHT_BLUE_TERRACOTTA_BRICKS)
        .create(SMBItems.BLUE_TERRACOTTA_TILES).craftableFrom(Items.BLUE_DYE, SMBItems.BLUE_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.BLUE_TERRACOTTA_BRICKS)
        .create(SMBItems.PURPLE_TERRACOTTA_TILES).craftableFrom(Items.PURPLE_DYE, SMBItems.PURPLE_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.PURPLE_TERRACOTTA_BRICKS)
        .create(SMBItems.MAGENTA_TERRACOTTA_TILES).craftableFrom(Items.MAGENTA_DYE, SMBItems.MAGENTA_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.MAGENTA_TERRACOTTA_BRICKS)
        .create(SMBItems.PINK_TERRACOTTA_TILES).craftableFrom(Items.PINK_DYE, SMBItems.PINK_TERRACOTTA_BRICKS).cuttableFrom(SMBItems.PINK_TERRACOTTA_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Concrete Bricks Variation", (instance) -> instance
        .create(SMBItems.WHITE_CONCRETE_BRICKS).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(SMBItems.LIGHT_GRAY_CONCRETE_BRICKS).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(SMBItems.GRAY_CONCRETE_BRICKS).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(SMBItems.BLACK_CONCRETE_BRICKS).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(SMBItems.BROWN_CONCRETE_BRICKS).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(SMBItems.RED_CONCRETE_BRICKS).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(SMBItems.ORANGE_CONCRETE_BRICKS).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(SMBItems.YELLOW_CONCRETE_BRICKS).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(SMBItems.LIME_CONCRETE_BRICKS).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(SMBItems.GREEN_CONCRETE_BRICKS).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(SMBItems.CYAN_CONCRETE_BRICKS).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(SMBItems.LIGHT_BLUE_CONCRETE_BRICKS).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(SMBItems.BLUE_CONCRETE_BRICKS).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(SMBItems.PURPLE_CONCRETE_BRICKS).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(SMBItems.MAGENTA_CONCRETE_BRICKS).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(SMBItems.PINK_CONCRETE_BRICKS).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Concrete Tiles Variation", (instance) -> instance
        .create(SMBItems.WHITE_CONCRETE_TILES).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(SMBItems.LIGHT_GRAY_CONCRETE_TILES).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(SMBItems.GRAY_CONCRETE_TILES).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(SMBItems.BLACK_CONCRETE_TILES).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(SMBItems.BROWN_CONCRETE_TILES).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(SMBItems.RED_CONCRETE_TILES).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(SMBItems.ORANGE_CONCRETE_TILES).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(SMBItems.YELLOW_CONCRETE_TILES).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(SMBItems.LIME_CONCRETE_TILES).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(SMBItems.GREEN_CONCRETE_TILES).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(SMBItems.CYAN_CONCRETE_TILES).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(SMBItems.LIGHT_BLUE_CONCRETE_TILES).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(SMBItems.BLUE_CONCRETE_TILES).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(SMBItems.PURPLE_CONCRETE_TILES).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(SMBItems.MAGENTA_CONCRETE_TILES).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(SMBItems.PINK_CONCRETE_TILES).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Redstone Froglight Lamp", (instance) -> instance
        .create(SMBItems.OCHRE_REDSTONE_FROGLIGHT).craftableFrom(Items.OCHRE_FROGLIGHT)
        .create(SMBItems.VERDANT_REDSTONE_FROGLIGHT).craftableFrom(Items.VERDANT_FROGLIGHT)
        .create(SMBItems.PEARLESCENT_REDSTONE_FROGLIGHT).craftableFrom(Items.PEARLESCENT_FROGLIGHT)
      ).build();
  }
}
