package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.datagen.core.RecipeAdvancement;
import net.seface.somemoreblocks.datagen.core.RecipeAdvancementGroupType;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.function.Consumer;

@Deprecated
public class SMBRecipeAdvancementProvider extends FabricAdvancementProvider {
  public SMBRecipeAdvancementProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateAdvancement(Consumer<Advancement> consumer) {
    RecipeAdvancement.setConsumer(consumer);

    RecipeAdvancement.create(Items.GREEN_DYE, RecipeAdvancementGroupType.MISC).craftableFrom(SMBBlocks.TINY_CACTUS).build();
    RecipeAdvancement.create(Items.GLOWSTONE_DUST, RecipeAdvancementGroupType.MISC).craftableFrom(SMBBlocks.LUMINOUS_FLOWER).build();

    RecipeAdvancement
      .group("Mosaics", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBBlocks.OAK_MOSAIC).craftableFrom(Blocks.OAK_SLAB)
        .create(SMBBlocks.SPRUCE_MOSAIC).craftableFrom(Blocks.SPRUCE_SLAB)
        .create(SMBBlocks.BIRCH_MOSAIC).craftableFrom(Blocks.BIRCH_SLAB)
        .create(SMBBlocks.JUNGLE_MOSAIC).craftableFrom(Blocks.JUNGLE_SLAB)
        .create(SMBBlocks.ACACIA_MOSAIC).craftableFrom(Blocks.ACACIA_SLAB)
        .create(SMBBlocks.DARK_OAK_MOSAIC).craftableFrom(Blocks.DARK_OAK_SLAB)
        .create(SMBBlocks.MANGROVE_MOSAIC).craftableFrom(Blocks.MANGROVE_SLAB)
        .create(SMBBlocks.CRIMSON_MOSAIC).craftableFrom(Blocks.CRIMSON_SLAB)
        .create(SMBBlocks.WARPED_MOSAIC).craftableFrom(Blocks.WARPED_SLAB)
        .create(SMBBlocks.CHERRY_MOSAIC).craftableFrom(Blocks.CHERRY_SLAB)
      ).build();

    RecipeAdvancement
      .group("Mosaic Stairs", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBBlocks.OAK_MOSAIC_STAIRS).craftableFrom(SMBBlocks.OAK_MOSAIC)
        .create(SMBBlocks.SPRUCE_MOSAIC_STAIRS).craftableFrom(SMBBlocks.SPRUCE_MOSAIC)
        .create(SMBBlocks.BIRCH_MOSAIC_STAIRS).craftableFrom(SMBBlocks.BIRCH_MOSAIC)
        .create(SMBBlocks.JUNGLE_MOSAIC_STAIRS).craftableFrom(SMBBlocks.JUNGLE_MOSAIC)
        .create(SMBBlocks.ACACIA_MOSAIC_STAIRS).craftableFrom(SMBBlocks.ACACIA_MOSAIC)
        .create(SMBBlocks.DARK_OAK_MOSAIC_STAIRS).craftableFrom(SMBBlocks.DARK_OAK_MOSAIC)
        .create(SMBBlocks.MANGROVE_MOSAIC_STAIRS).craftableFrom(SMBBlocks.MANGROVE_MOSAIC)
        .create(SMBBlocks.CRIMSON_MOSAIC_STAIRS).craftableFrom(SMBBlocks.CRIMSON_MOSAIC)
        .create(SMBBlocks.WARPED_MOSAIC_STAIRS).craftableFrom(SMBBlocks.WARPED_MOSAIC)
        .create(SMBBlocks.CHERRY_MOSAIC_STAIRS).craftableFrom(SMBBlocks.CHERRY_MOSAIC)
      ).build();

    RecipeAdvancement
      .group("Mosaic Slabs", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBBlocks.OAK_MOSAIC_SLAB).craftableFrom(SMBBlocks.OAK_MOSAIC)
        .create(SMBBlocks.SPRUCE_MOSAIC_SLAB).craftableFrom(SMBBlocks.SPRUCE_MOSAIC)
        .create(SMBBlocks.BIRCH_MOSAIC_SLAB).craftableFrom(SMBBlocks.BIRCH_MOSAIC)
        .create(SMBBlocks.JUNGLE_MOSAIC_SLAB).craftableFrom(SMBBlocks.JUNGLE_MOSAIC)
        .create(SMBBlocks.ACACIA_MOSAIC_SLAB).craftableFrom(SMBBlocks.ACACIA_MOSAIC)
        .create(SMBBlocks.DARK_OAK_MOSAIC_SLAB).craftableFrom(SMBBlocks.DARK_OAK_MOSAIC)
        .create(SMBBlocks.MANGROVE_MOSAIC_SLAB).craftableFrom(SMBBlocks.MANGROVE_MOSAIC)
        .create(SMBBlocks.CRIMSON_MOSAIC_SLAB).craftableFrom(SMBBlocks.CRIMSON_MOSAIC)
        .create(SMBBlocks.WARPED_MOSAIC_SLAB).craftableFrom(SMBBlocks.WARPED_MOSAIC)
        .create(SMBBlocks.CHERRY_MOSAIC_SLAB).craftableFrom(SMBBlocks.CHERRY_MOSAIC)
      ).build();

    RecipeAdvancement
      .group("Stone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_STONE).cuttableFrom(Blocks.STONE)
        .create(SMBBlocks.POLISHED_STONE_STAIRS).craftableFrom(SMBBlocks.POLISHED_STONE).cuttableFrom(Blocks.STONE, SMBBlocks.POLISHED_STONE)
        .create(SMBBlocks.POLISHED_STONE_SLAB).craftableFrom(SMBBlocks.POLISHED_STONE).cuttableFrom(Blocks.STONE, SMBBlocks.POLISHED_STONE)
        .create(SMBBlocks.STONE_PILLAR).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE)
        .create(SMBBlocks.STONE_TILES).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE, SMBBlocks.POLISHED_STONE, Blocks.STONE_BRICKS)
        .create(SMBBlocks.CRACKED_STONE_TILES).craftableFrom(SMBBlocks.STONE_TILES)
        .create(SMBBlocks.STONE_TILE_STAIRS).craftableFrom(SMBBlocks.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, SMBBlocks.STONE_TILES, SMBBlocks.POLISHED_STONE, Blocks.STONE)
        .create(SMBBlocks.STONE_TILE_SLAB).craftableFrom(SMBBlocks.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, SMBBlocks.STONE_TILES, SMBBlocks.POLISHED_STONE, Blocks.STONE)
        .create(SMBBlocks.STONE_TILE_WALL).craftableFrom(SMBBlocks.STONE_TILES).cuttableFrom(Blocks.STONE_BRICKS, SMBBlocks.STONE_TILES, SMBBlocks.POLISHED_STONE, Blocks.STONE)
      ).build();

    RecipeAdvancement
      .group("Granite Variations", (instance) -> instance
        .create(SMBBlocks.CHISELED_GRANITE_BRICKS).craftableFrom(SMBBlocks.GRANITE_BRICK_SLAB).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS)
        .create(SMBBlocks.GRANITE_BRICKS).craftableFrom(Blocks.POLISHED_GRANITE).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.CRACKED_GRANITE_BRICKS).craftableFrom(SMBBlocks.GRANITE_BRICKS)
        .create(SMBBlocks.GRANITE_BRICK_STAIRS).craftableFrom(SMBBlocks.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.GRANITE_BRICK_SLAB).craftableFrom(SMBBlocks.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.GRANITE_BRICK_WALL).craftableFrom(SMBBlocks.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.GRANITE_PILLAR).craftableFrom(SMBBlocks.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE)
        .create(SMBBlocks.GRANITE_TILES).craftableFrom(SMBBlocks.GRANITE_BRICKS).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_BRICKS)
        .create(SMBBlocks.CRACKED_GRANITE_TILES).craftableFrom(SMBBlocks.GRANITE_TILES)
        .create(SMBBlocks.GRANITE_TILE_STAIRS).craftableFrom(SMBBlocks.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_TILES)
        .create(SMBBlocks.GRANITE_TILE_SLAB).craftableFrom(SMBBlocks.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_TILES)
        .create(SMBBlocks.GRANITE_TILE_WALL).craftableFrom(SMBBlocks.GRANITE_TILES).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS, Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_TILES)
        .create(SMBBlocks.MOSSY_GRANITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS)
        .create(SMBBlocks.MOSSY_GRANITE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS)
        .create(SMBBlocks.MOSSY_GRANITE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS)
        .create(SMBBlocks.SMOOTH_GRANITE).craftableFrom(Blocks.GRANITE)
        .create(SMBBlocks.SMOOTH_GRANITE_SLAB).craftableFrom(SMBBlocks.SMOOTH_GRANITE).cuttableFrom(SMBBlocks.SMOOTH_GRANITE)
      ).build();

    RecipeAdvancement
      .group("Diorite Variations", (instance) -> instance
        .create(SMBBlocks.CHISELED_DIORITE_BRICKS).craftableFrom(SMBBlocks.DIORITE_BRICK_SLAB).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS)
        .create(SMBBlocks.DIORITE_BRICKS).craftableFrom(Blocks.POLISHED_DIORITE).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.CRACKED_DIORITE_BRICKS).craftableFrom(SMBBlocks.DIORITE_BRICKS)
        .create(SMBBlocks.DIORITE_BRICK_STAIRS).craftableFrom(SMBBlocks.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.DIORITE_BRICK_SLAB).craftableFrom(SMBBlocks.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.DIORITE_BRICK_WALL).craftableFrom(SMBBlocks.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.DIORITE_PILLAR).craftableFrom(SMBBlocks.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE)
        .create(SMBBlocks.DIORITE_TILES).craftableFrom(SMBBlocks.DIORITE_BRICKS).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_BRICKS)
        .create(SMBBlocks.CRACKED_DIORITE_TILES).craftableFrom(SMBBlocks.DIORITE_TILES)
        .create(SMBBlocks.DIORITE_TILE_STAIRS).craftableFrom(SMBBlocks.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_TILES)
        .create(SMBBlocks.DIORITE_TILE_SLAB).craftableFrom(SMBBlocks.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_TILES)
        .create(SMBBlocks.DIORITE_TILE_WALL).craftableFrom(SMBBlocks.DIORITE_TILES).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS, Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_TILES)
        .create(SMBBlocks.MOSSY_DIORITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS)
        .create(SMBBlocks.MOSSY_DIORITE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS)
        .create(SMBBlocks.MOSSY_DIORITE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS)
        .create(SMBBlocks.SMOOTH_DIORITE).craftableFrom(Blocks.DIORITE)
        .create(SMBBlocks.SMOOTH_DIORITE_SLAB).craftableFrom(SMBBlocks.SMOOTH_DIORITE).cuttableFrom(SMBBlocks.SMOOTH_DIORITE)
      ).build();

    RecipeAdvancement
      .group("Andesite Variations", (instance) -> instance
        .create(SMBBlocks.CHISELED_ANDESITE_BRICKS).craftableFrom(SMBBlocks.ANDESITE_BRICK_SLAB).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS)
        .create(SMBBlocks.ANDESITE_BRICKS).craftableFrom(Blocks.POLISHED_ANDESITE).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.CRACKED_ANDESITE_BRICKS).craftableFrom(SMBBlocks.ANDESITE_BRICKS)
        .create(SMBBlocks.ANDESITE_BRICK_STAIRS).craftableFrom(SMBBlocks.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.ANDESITE_BRICK_SLAB).craftableFrom(SMBBlocks.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.ANDESITE_BRICK_WALL).craftableFrom(SMBBlocks.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.ANDESITE_PILLAR).craftableFrom(SMBBlocks.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE)
        .create(SMBBlocks.ANDESITE_TILES).craftableFrom(SMBBlocks.ANDESITE_BRICKS).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_BRICKS)
        .create(SMBBlocks.CRACKED_ANDESITE_TILES).craftableFrom(SMBBlocks.ANDESITE_TILES)
        .create(SMBBlocks.ANDESITE_TILE_STAIRS).craftableFrom(SMBBlocks.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_TILES)
        .create(SMBBlocks.ANDESITE_TILE_SLAB).craftableFrom(SMBBlocks.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_TILES)
        .create(SMBBlocks.GRANITE_TILE_WALL).craftableFrom(SMBBlocks.ANDESITE_TILES).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS, Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_TILES)
        .create(SMBBlocks.MOSSY_ANDESITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS)
        .create(SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS)
        .create(SMBBlocks.MOSSY_ANDESITE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS)
        .create(SMBBlocks.SMOOTH_ANDESITE).craftableFrom(Blocks.ANDESITE)
        .create(SMBBlocks.SMOOTH_ANDESITE_SLAB).craftableFrom(SMBBlocks.SMOOTH_ANDESITE).cuttableFrom(SMBBlocks.SMOOTH_ANDESITE)
      ).build();

    RecipeAdvancement.create(SMBBlocks.DEEPSLATE_PILLAR).craftableFrom(Blocks.DEEPSLATE_BRICKS).cuttableFrom(Blocks.DEEPSLATE).build();

    RecipeAdvancement
      .group("Calcite Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE)
        .create(SMBBlocks.POLISHED_CALCITE_STAIRS).craftableFrom(SMBBlocks.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE)
        .create(SMBBlocks.POLISHED_CALCITE_SLAB).craftableFrom(SMBBlocks.POLISHED_CALCITE).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE)
        .create(SMBBlocks.CHISELED_CALCITE_BRICKS).craftableFrom(SMBBlocks.CALCITE_BRICK_SLAB).cuttableFrom(Blocks.CALCITE, SMBBlocks.CALCITE_BRICKS)
        .create(SMBBlocks.CALCITE_BRICKS).craftableFrom(Blocks.CALCITE).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE)
        .create(SMBBlocks.CRACKED_CALCITE_BRICKS).craftableFrom(SMBBlocks.CALCITE_BRICKS)
        .create(SMBBlocks.CALCITE_BRICK_STAIRS).craftableFrom(SMBBlocks.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE, SMBBlocks.CALCITE_BRICKS)
        .create(SMBBlocks.CALCITE_BRICK_SLAB).craftableFrom(SMBBlocks.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE, SMBBlocks.CALCITE_BRICKS)
        .create(SMBBlocks.CALCITE_BRICK_WALL).craftableFrom(SMBBlocks.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE, SMBBlocks.CALCITE_BRICKS)
        .create(SMBBlocks.CALCITE_PILLAR).craftableFrom(SMBBlocks.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE)
        .create(SMBBlocks.CALCITE_TILES).craftableFrom(SMBBlocks.CALCITE_BRICKS).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE, SMBBlocks.CALCITE_BRICKS)
        .create(SMBBlocks.CRACKED_CALCITE_TILES).craftableFrom(SMBBlocks.CALCITE_TILES)
        .create(SMBBlocks.CALCITE_TILE_STAIRS).craftableFrom(SMBBlocks.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE, SMBBlocks.CALCITE_BRICKS, SMBBlocks.CALCITE_TILES)
        .create(SMBBlocks.CALCITE_TILE_SLAB).craftableFrom(SMBBlocks.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE, SMBBlocks.CALCITE_BRICKS, SMBBlocks.CALCITE_TILES)
        .create(SMBBlocks.CALCITE_TILE_WALL).craftableFrom(SMBBlocks.CALCITE_TILES).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE, SMBBlocks.CALCITE_BRICKS, SMBBlocks.CALCITE_TILES)
        .create(SMBBlocks.MOSSY_CALCITE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS)
        .create(SMBBlocks.MOSSY_CALCITE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS)
        .create(SMBBlocks.MOSSY_CALCITE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS)
        .create(SMBBlocks.SMOOTH_CALCITE).craftableFrom(Blocks.CALCITE)
        .create(SMBBlocks.SMOOTH_CALCITE_SLAB).craftableFrom(SMBBlocks.SMOOTH_CALCITE).cuttableFrom(SMBBlocks.SMOOTH_CALCITE)
      ).build();

    RecipeAdvancement
      .group("Tuff Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_TUFF_BRICKS).craftableFrom(SMBBlocks.TUFF_BRICKS)
        .create(SMBBlocks.TUFF_PILLAR).craftableFrom(SMBBlocks.TUFF_BRICKS).cuttableFrom(Blocks.TUFF)
        .create(SMBBlocks.TUFF_TILES).craftableFrom(SMBBlocks.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, SMBBlocks.POLISHED_TUFF, SMBBlocks.TUFF_BRICKS)
        .create(SMBBlocks.CRACKED_TUFF_TILES).craftableFrom(SMBBlocks.TUFF_TILES)
        .create(SMBBlocks.TUFF_TILE_STAIRS).craftableFrom(SMBBlocks.TUFF_TILES).cuttableFrom(Blocks.TUFF, SMBBlocks.POLISHED_TUFF, SMBBlocks.TUFF_BRICKS, SMBBlocks.TUFF_TILES)
        .create(SMBBlocks.TUFF_TILE_SLAB).craftableFrom(SMBBlocks.TUFF_TILES).cuttableFrom(Blocks.TUFF, SMBBlocks.POLISHED_TUFF, SMBBlocks.TUFF_BRICKS, SMBBlocks.TUFF_TILES)
        .create(SMBBlocks.TUFF_TILE_WALL).craftableFrom(SMBBlocks.TUFF_TILES).cuttableFrom(Blocks.TUFF, SMBBlocks.POLISHED_TUFF, SMBBlocks.TUFF_BRICKS, SMBBlocks.TUFF_TILES)
        .create(SMBBlocks.MOSSY_TUFF_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_TUFF_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_TUFF_BRICKS).cuttableFrom(SMBBlocks.MOSSY_TUFF_BRICKS)
        .create(SMBBlocks.MOSSY_TUFF_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_TUFF_BRICKS).cuttableFrom(SMBBlocks.MOSSY_TUFF_BRICKS)
        .create(SMBBlocks.MOSSY_TUFF_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_TUFF_BRICKS).cuttableFrom(SMBBlocks.MOSSY_TUFF_BRICKS)
        .create(SMBBlocks.SMOOTH_TUFF).craftableFrom(Blocks.TUFF)
        .create(SMBBlocks.SMOOTH_TUFF_SLAB).craftableFrom(SMBBlocks.SMOOTH_TUFF).cuttableFrom(SMBBlocks.SMOOTH_TUFF)
      ).build();

    RecipeAdvancement
      .group("Dripstone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBBlocks.POLISHED_DRIPSTONE_STAIRS).craftableFrom(SMBBlocks.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE)
        .create(SMBBlocks.POLISHED_DRIPSTONE_SLAB).craftableFrom(SMBBlocks.POLISHED_DRIPSTONE).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE)
        .create(SMBBlocks.CHISELED_DRIPSTONE_BRICKS).craftableFrom(SMBBlocks.DRIPSTONE_BRICK_SLAB).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.DRIPSTONE_BRICKS)
        .create(SMBBlocks.DRIPSTONE_BRICKS).craftableFrom(Blocks.DRIPSTONE_BLOCK).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE)
        .create(SMBBlocks.CRACKED_DRIPSTONE_BRICKS).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS)
        .create(SMBBlocks.DRIPSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE, SMBBlocks.DRIPSTONE_BRICKS)
        .create(SMBBlocks.DRIPSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE, SMBBlocks.DRIPSTONE_BRICKS)
        .create(SMBBlocks.DRIPSTONE_BRICK_WALL).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE, SMBBlocks.DRIPSTONE_BRICKS)
        .create(SMBBlocks.DRIPSTONE_PILLAR).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBBlocks.DRIPSTONE_TILES).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE, SMBBlocks.DRIPSTONE_BRICKS)
        .create(SMBBlocks.CRACKED_DRIPSTONE_TILES).craftableFrom(SMBBlocks.DRIPSTONE_TILES)
        .create(SMBBlocks.DRIPSTONE_TILE_STAIRS).craftableFrom(SMBBlocks.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE, SMBBlocks.DRIPSTONE_BRICKS, SMBBlocks.DRIPSTONE_TILES)
        .create(SMBBlocks.DRIPSTONE_TILE_SLAB).craftableFrom(SMBBlocks.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE, SMBBlocks.DRIPSTONE_BRICKS, SMBBlocks.DRIPSTONE_TILES)
        .create(SMBBlocks.DRIPSTONE_TILE_WALL).craftableFrom(SMBBlocks.DRIPSTONE_TILES).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE, SMBBlocks.DRIPSTONE_BRICKS, SMBBlocks.DRIPSTONE_TILES)
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS)
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS)
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS)
        .create(SMBBlocks.SMOOTH_DRIPSTONE).craftableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBBlocks.SMOOTH_DRIPSTONE_SLAB).craftableFrom(SMBBlocks.SMOOTH_DRIPSTONE).cuttableFrom(SMBBlocks.SMOOTH_DRIPSTONE)
      ).build();

    RecipeAdvancement.
      group("Bricks Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_BRICKS).craftableFrom(Blocks.BRICKS)
        .create(SMBBlocks.MOSSY_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_BRICKS).cuttableFrom(SMBBlocks.MOSSY_BRICKS)
        .create(SMBBlocks.MOSSY_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_BRICKS).cuttableFrom(SMBBlocks.MOSSY_BRICKS)
        .create(SMBBlocks.MOSSY_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_BRICKS).cuttableFrom(SMBBlocks.MOSSY_BRICKS)
      ).build();

    RecipeAdvancement.
      group("Mud Variations", (instance) -> instance
        .setExpectedEntries(17)
        .create(SMBBlocks.POLISHED_MUD).craftableFrom(Blocks.PACKED_MUD)
        .create(SMBBlocks.POLISHED_MUD_STAIRS).craftableFrom(SMBBlocks.POLISHED_MUD).cuttableFrom(Blocks.PACKED_MUD, SMBBlocks.POLISHED_MUD)
        .create(SMBBlocks.POLISHED_MUD_SLAB).craftableFrom(SMBBlocks.POLISHED_MUD).cuttableFrom(Blocks.PACKED_MUD, SMBBlocks.POLISHED_MUD)
        .create(SMBBlocks.CHISELED_MUD_BRICKS).craftableFrom(Blocks.MUD_BRICK_SLAB).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS)
        .create(SMBBlocks.CRACKED_MUD_BRICKS).craftableFrom(Blocks.MUD_BRICKS)
        .create(SMBBlocks.MUD_PILLAR).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD)
        .create(SMBBlocks.MUD_TILES).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD)
        .create(SMBBlocks.CRACKED_MUD_TILES).craftableFrom(SMBBlocks.MUD_TILES)
        .create(SMBBlocks.MUD_TILE_STAIRS).craftableFrom(SMBBlocks.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD, SMBBlocks.MUD_TILES)
        .create(SMBBlocks.MUD_TILE_SLAB).craftableFrom(SMBBlocks.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD, SMBBlocks.MUD_TILES)
        .create(SMBBlocks.MUD_TILE_WALL).craftableFrom(SMBBlocks.MUD_TILES).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD, SMBBlocks.MUD_TILES)
        .create(SMBBlocks.MOSSY_MUD_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_MUD_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_MUD_BRICKS).cuttableFrom(SMBBlocks.MOSSY_MUD_BRICKS)
        .create(SMBBlocks.MOSSY_MUD_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_MUD_BRICKS).cuttableFrom(SMBBlocks.MOSSY_MUD_BRICKS)
        .create(SMBBlocks.MOSSY_MUD_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_MUD_BRICKS).cuttableFrom(SMBBlocks.MOSSY_MUD_BRICKS)
        .create(SMBBlocks.SMOOTH_MUD).craftableFrom(Blocks.PACKED_MUD)
        .create(SMBBlocks.SMOOTH_MUD_SLAB).craftableFrom(SMBBlocks.SMOOTH_MUD).cuttableFrom(SMBBlocks.SMOOTH_MUD)
      ).build();

    RecipeAdvancement.
      group("Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(SMBBlocks.SANDSTONE_BRICKS).craftableFrom(Blocks.SMOOTH_SANDSTONE).cuttableFrom(Blocks.SANDSTONE)
        .create(SMBBlocks.CRACKED_SANDSTONE_BRICKS).craftableFrom(SMBBlocks.SANDSTONE_BRICKS)
        .create(SMBBlocks.SANDSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS)
        .create(SMBBlocks.SANDSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS)
        .create(SMBBlocks.SANDSTONE_BRICK_WALL).craftableFrom(SMBBlocks.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS)
        .create(SMBBlocks.SANDSTONE_PILLAR).craftableFrom(SMBBlocks.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE)
        .create(SMBBlocks.SANDSTONE_TILES).craftableFrom(SMBBlocks.SANDSTONE_BRICKS).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS)
        .create(SMBBlocks.CRACKED_SANDSTONE_TILES).craftableFrom(SMBBlocks.SANDSTONE_BRICKS)
        .create(SMBBlocks.SANDSTONE_TILE_STAIRS).craftableFrom(SMBBlocks.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS, SMBBlocks.SANDSTONE_TILES)
        .create(SMBBlocks.SANDSTONE_TILE_SLAB).craftableFrom(SMBBlocks.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS, SMBBlocks.SANDSTONE_TILES)
        .create(SMBBlocks.SANDSTONE_TILE_WALL).craftableFrom(SMBBlocks.SANDSTONE_TILES).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS, SMBBlocks.SANDSTONE_TILES)
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS)
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS)
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS)
      ).build();

    RecipeAdvancement.
      group("Red Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(SMBBlocks.RED_SANDSTONE_BRICKS).craftableFrom(Blocks.SMOOTH_RED_SANDSTONE).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(SMBBlocks.CRACKED_RED_SANDSTONE_BRICKS).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.RED_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.RED_SANDSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.RED_SANDSTONE_BRICK_WALL).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.RED_SANDSTONE_PILLAR).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(SMBBlocks.RED_SANDSTONE_TILES).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.CRACKED_RED_SANDSTONE_TILES).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.RED_SANDSTONE_TILE_STAIRS).craftableFrom(SMBBlocks.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS, SMBBlocks.RED_SANDSTONE_TILES)
        .create(SMBBlocks.RED_SANDSTONE_TILE_SLAB).craftableFrom(SMBBlocks.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS, SMBBlocks.RED_SANDSTONE_TILES)
        .create(SMBBlocks.RED_SANDSTONE_TILE_WALL).craftableFrom(SMBBlocks.RED_SANDSTONE_TILES).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS, SMBBlocks.RED_SANDSTONE_TILES)
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS)
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Prismarine Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE)
        .create(SMBBlocks.POLISHED_PRISMARINE_STAIRS).craftableFrom(SMBBlocks.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE)
        .create(SMBBlocks.POLISHED_PRISMARINE_SLAB).craftableFrom(SMBBlocks.POLISHED_PRISMARINE).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE)
        .create(SMBBlocks.CHISELED_PRISMARINE_BRICKS).craftableFrom(Blocks.PRISMARINE_BRICK_SLAB).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS)
        .create(SMBBlocks.CRACKED_PRISMARINE_BRICKS).craftableFrom(Blocks.PRISMARINE_BRICKS)
        .create(SMBBlocks.PRISMARINE_PILLAR).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE)
        .create(SMBBlocks.PRISMARINE_TILES).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS)
        .create(SMBBlocks.CRACKED_PRISMARINE_TILES).craftableFrom(SMBBlocks.PRISMARINE_TILES)
        .create(SMBBlocks.PRISMARINE_TILE_STAIRS).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, SMBBlocks.PRISMARINE_TILES)
        .create(SMBBlocks.PRISMARINE_TILE_SLAB).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, SMBBlocks.PRISMARINE_TILES)
        .create(SMBBlocks.PRISMARINE_TILE_WALL).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE, Blocks.PRISMARINE_BRICKS, SMBBlocks.PRISMARINE_TILES)
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICKS).craftableFrom(Items.KELP)
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS)
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS)
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS)
        .create(SMBBlocks.SMOOTH_PRISMARINE).craftableFrom(Blocks.PRISMARINE)
        .create(SMBBlocks.SMOOTH_PRISMARINE_SLAB).craftableFrom(SMBBlocks.SMOOTH_PRISMARINE).cuttableFrom(SMBBlocks.SMOOTH_PRISMARINE)
      ).build();

    RecipeAdvancement.create(SMBBlocks.NETHER_BRICKS_PILLAR).craftableFrom(Blocks.NETHER_BRICKS).cuttableFrom(Blocks.NETHER_BRICKS).build();

    RecipeAdvancement
      .group("Red Nether Bricks Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_RED_NETHER_BRICKS).craftableFrom(Blocks.RED_NETHER_BRICKS)
        .create(SMBBlocks.CHISELED_RED_NETHER_BRICKS).craftableFrom(Blocks.RED_NETHER_BRICK_SLAB).cuttableFrom(Blocks.RED_NETHER_BRICKS)
        .create(SMBBlocks.RED_NETHER_BRICKS_PILLAR).craftableFrom(Blocks.RED_NETHER_BRICKS).cuttableFrom(Blocks.RED_NETHER_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Polished Blackstone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_BLACKSTONE_PILLAR).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE)
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILES).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS)
        .create(SMBBlocks.CRACKED_POLISHED_BLACKSTONE_TILES).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES)
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBBlocks.POLISHED_BLACKSTONE_TILES)
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBBlocks.POLISHED_BLACKSTONE_TILES)
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBBlocks.POLISHED_BLACKSTONE_TILES)
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).craftableFrom(Items.MAGMA_CREAM)
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL).craftableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS).cuttableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS)
        .create(SMBBlocks.SMOOTH_BLACKSTONE).craftableFrom(Blocks.BLACKSTONE)
        .create(SMBBlocks.SMOOTH_BLACKSTONE_SLAB).craftableFrom(SMBBlocks.SMOOTH_BLACKSTONE).cuttableFrom(SMBBlocks.SMOOTH_BLACKSTONE)
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE)
        .create(SMBBlocks.POLISHED_END_STONE_STAIRS).craftableFrom(SMBBlocks.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE, SMBBlocks.POLISHED_STONE)
        .create(SMBBlocks.POLISHED_END_STONE_SLAB).craftableFrom(SMBBlocks.POLISHED_END_STONE).cuttableFrom(Blocks.END_STONE, SMBBlocks.POLISHED_STONE)
        .create(SMBBlocks.CHISELED_END_STONE_BRICKS).craftableFrom(Blocks.END_STONE_BRICK_SLAB).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS)
        .create(SMBBlocks.CRACKED_END_STONE_BRICKS).craftableFrom(Blocks.END_STONE_BRICKS)
        .create(SMBBlocks.END_STONE_PILLAR).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE)
        .create(SMBBlocks.END_STONE_TILES).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE)
        .create(SMBBlocks.CRACKED_END_STONE_TILES).craftableFrom(SMBBlocks.END_STONE_TILES)
        .create(SMBBlocks.END_STONE_TILE_STAIRS).craftableFrom(SMBBlocks.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE, SMBBlocks.END_STONE_TILES)
        .create(SMBBlocks.END_STONE_TILE_SLAB).craftableFrom(SMBBlocks.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE, SMBBlocks.END_STONE_TILES)
        .create(SMBBlocks.END_STONE_TILE_WALL).craftableFrom(SMBBlocks.END_STONE_TILES).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE, SMBBlocks.END_STONE_TILES)
        .create(SMBBlocks.MOSSY_END_STONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS).craftableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS)
        .create(SMBBlocks.MOSSY_END_STONE_BRICK_SLAB).craftableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS)
        .create(SMBBlocks.MOSSY_END_STONE_BRICK_WALL).craftableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS).cuttableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS)
        .create(SMBBlocks.SMOOTH_END_STONE).craftableFrom(Blocks.END_STONE)
        .create(SMBBlocks.SMOOTH_END_STONE_SLAB).craftableFrom(SMBBlocks.SMOOTH_END_STONE).cuttableFrom(SMBBlocks.SMOOTH_END_STONE)
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBBlocks.POLISHED_PURPUR_STAIRS).craftableFrom(SMBBlocks.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_STONE)
        .create(SMBBlocks.POLISHED_PURPUR_SLAB).craftableFrom(SMBBlocks.POLISHED_PURPUR).cuttableFrom(Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_STONE)
        .create(SMBBlocks.CHISELED_PURPUR).craftableFrom(Blocks.END_ROD)
        .create(SMBBlocks.CRACKED_PURPUR_BLOCK).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBBlocks.PURPUR_TILES).craftableFrom(Blocks.PURPUR_BLOCK).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR)
        .create(SMBBlocks.CRACKED_PURPUR_TILES).craftableFrom(SMBBlocks.PURPUR_TILES)
        .create(SMBBlocks.PURPUR_TILE_STAIRS).craftableFrom(SMBBlocks.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR, SMBBlocks.PURPUR_TILES)
        .create(SMBBlocks.PURPUR_TILE_SLAB).craftableFrom(SMBBlocks.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR, SMBBlocks.PURPUR_TILES)
        .create(SMBBlocks.PURPUR_TILE_WALL).craftableFrom(SMBBlocks.PURPUR_TILES).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR, SMBBlocks.PURPUR_TILES)
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS).craftableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK).cuttableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK)
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB).craftableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK).cuttableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK)
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK_WALL).craftableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK).cuttableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK)
        .create(SMBBlocks.SMOOTH_PURPUR).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBBlocks.SMOOTH_PURPUR_SLAB).craftableFrom(SMBBlocks.SMOOTH_PURPUR).cuttableFrom(SMBBlocks.SMOOTH_PURPUR)
      ).build();

    RecipeAdvancement
      .group("Coal Block Variations", (instance) -> instance
        .create(SMBBlocks.COAL_BRICKS).craftableFrom(SMBBlocks.CUT_COAL)
        .create(SMBBlocks.CRACKED_COAL_BRICKS).craftableFrom(SMBBlocks.COAL_BRICKS)
        .create(SMBBlocks.COAL_PILLAR).craftableFrom(Blocks.COAL_BLOCK)
        .create(SMBBlocks.CUT_COAL).craftableFrom(Blocks.COAL_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_COAL).craftableFrom(SMBBlocks.CUT_COAL)
      ).build();

    RecipeAdvancement
      .group("Iron Block Variations", (instance) -> instance
        .create(SMBBlocks.IRON_BRICKS).craftableFrom(SMBBlocks.CUT_IRON)
        .create(SMBBlocks.CRACKED_IRON_BRICKS).craftableFrom(SMBBlocks.IRON_BRICKS)
        .create(SMBBlocks.IRON_PILLAR).craftableFrom(Blocks.IRON_BLOCK)
        .create(SMBBlocks.CUT_IRON).craftableFrom(Blocks.IRON_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_IRON).craftableFrom(SMBBlocks.CUT_IRON)
      ).build();

    RecipeAdvancement
      .group("Gold Block Variations", (instance) -> instance
        .create(SMBBlocks.GOLD_BRICKS).craftableFrom(SMBBlocks.CUT_GOLD)
        .create(SMBBlocks.CRACKED_GOLD_BRICKS).craftableFrom(SMBBlocks.GOLD_BRICKS)
        .create(SMBBlocks.GOLD_PILLAR).craftableFrom(Blocks.GOLD_BLOCK)
        .create(SMBBlocks.CUT_GOLD).craftableFrom(Blocks.GOLD_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_GOLD).craftableFrom(SMBBlocks.CUT_GOLD)
      ).build();

    RecipeAdvancement
      .group("Emerald Block Variations", (instance) -> instance
        .create(SMBBlocks.EMERALD_BRICKS).craftableFrom(SMBBlocks.CUT_EMERALD)
        .create(SMBBlocks.CRACKED_EMERALD_BRICKS).craftableFrom(SMBBlocks.EMERALD_BRICKS)
        .create(SMBBlocks.EMERALD_PILLAR).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(SMBBlocks.CUT_EMERALD).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_EMERALD).craftableFrom(SMBBlocks.CUT_EMERALD)
      ).build();

    RecipeAdvancement
      .group("Lapis Block Variations", (instance) -> instance
        .create(SMBBlocks.LAPIS_BRICKS).craftableFrom(SMBBlocks.CUT_LAPIS)
        .create(SMBBlocks.CRACKED_LAPIS_BRICKS).craftableFrom(SMBBlocks.LAPIS_BRICKS)
        .create(SMBBlocks.LAPIS_PILLAR).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(SMBBlocks.CUT_LAPIS).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_LAPIS).craftableFrom(SMBBlocks.CUT_LAPIS)
      ).build();

    RecipeAdvancement
      .group("Diamond Block Variations", (instance) -> instance
        .create(SMBBlocks.DIAMOND_BRICKS).craftableFrom(SMBBlocks.CUT_DIAMOND)
        .create(SMBBlocks.CRACKED_DIAMOND_BRICKS).craftableFrom(SMBBlocks.DIAMOND_BRICKS)
        .create(SMBBlocks.DIAMOND_PILLAR).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(SMBBlocks.CUT_DIAMOND).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_DIAMOND).craftableFrom(SMBBlocks.CUT_DIAMOND)
      ).build();

    RecipeAdvancement
      .group("Netherite Block Variations", (instance) -> instance
        .create(SMBBlocks.NETHERITE_BRICKS).craftableFrom(SMBBlocks.CUT_NETHERITE)
        .create(SMBBlocks.CRACKED_NETHERITE_BRICKS).craftableFrom(SMBBlocks.NETHERITE_BRICKS)
        .create(SMBBlocks.NETHERITE_PILLAR).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(SMBBlocks.CUT_NETHERITE).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_NETHERITE).craftableFrom(SMBBlocks.CUT_NETHERITE)
      ).build();

    RecipeAdvancement
      .group("Quartz Block Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_QUARTZ_BRICKS).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(SMBBlocks.CUT_QUARTZ).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(SMBBlocks.CRACKED_CUT_QUARTZ).craftableFrom(SMBBlocks.CUT_QUARTZ)
      ).build();

    RecipeAdvancement
      .group("Amethyst Block Variations", (instance) -> instance
        .create(SMBBlocks.AMETHYST_BRICKS).craftableFrom(SMBBlocks.CUT_AMETHYST)
        .create(SMBBlocks.CRACKED_AMETHYST_BRICKS).craftableFrom(SMBBlocks.AMETHYST_BRICKS)
        .create(SMBBlocks.AMETHYST_PILLAR).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(SMBBlocks.CUT_AMETHYST).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_AMETHYST).craftableFrom(SMBBlocks.CUT_AMETHYST)
      ).build();

    RecipeAdvancement
      .group("Redstone Block Variations", (instance) -> instance
        .create(SMBBlocks.AMETHYST_BRICKS).craftableFrom(SMBBlocks.CUT_REDSTONE)
        .create(SMBBlocks.CRACKED_REDSTONE_BRICKS).craftableFrom(SMBBlocks.REDSTONE_BRICKS)
        .create(SMBBlocks.REDSTONE_PILLAR).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(SMBBlocks.CUT_REDSTONE).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_REDSTONE).craftableFrom(SMBBlocks.CUT_REDSTONE)
      ).build();

    RecipeAdvancement
      .group("Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(SMBBlocks.COPPER_BRICKS).craftableFrom(Blocks.CUT_COPPER)
        .create(SMBBlocks.CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.COPPER_PILLAR).craftableFrom(Blocks.COPPER_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_COPPER).craftableFrom(Blocks.CUT_COPPER)
        .create(SMBBlocks.EXPOSED_COPPER_BRICKS).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.EXPOSED_COPPER_PILLAR).craftableFrom(Blocks.EXPOSED_COPPER)
        .create(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(SMBBlocks.WEATHERED_COPPER_BRICKS).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.WEATHERED_COPPER_PILLAR).craftableFrom(Blocks.WEATHERED_COPPER)
        .create(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(SMBBlocks.OXIDIZED_COPPER_BRICKS).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
        .create(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.OXIDIZED_COPPER_PILLAR).craftableFrom(Blocks.OXIDIZED_COPPER)
        .create(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
      ).build();

    RecipeAdvancement
      .group("Waxed Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(SMBBlocks.WAXED_COPPER_BRICKS).craftableFrom(SMBBlocks.COPPER_BRICKS)
        .create(SMBBlocks.WAXED_CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.WAXED_COPPER_PILLAR).craftableFrom(SMBBlocks.COPPER_PILLAR)
        .create(SMBBlocks.WAXED_CRACKED_CUT_COPPER).craftableFrom(SMBBlocks.CRACKED_CUT_COPPER)
        .create(SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS).craftableFrom(SMBBlocks.EXPOSED_COPPER_BRICKS)
        .create(SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR).craftableFrom(SMBBlocks.EXPOSED_COPPER_PILLAR)
        .create(SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER).craftableFrom(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER)
        .create(SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS).craftableFrom(SMBBlocks.WEATHERED_COPPER_BRICKS)
        .create(SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR).craftableFrom(SMBBlocks.WEATHERED_COPPER_PILLAR)
        .create(SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER).craftableFrom(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER)
        .create(SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS).craftableFrom(SMBBlocks.OXIDIZED_COPPER_BRICKS)
        .create(SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS).craftableFrom(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS)
        .create(SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR).craftableFrom(SMBBlocks.OXIDIZED_COPPER_PILLAR)
        .create(SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER).craftableFrom(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER)
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
        .create(SMBBlocks.BONE_BRICKS).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK)
        .create(SMBBlocks.CRACKED_BONE_BRICKS).craftableFrom(SMBBlocks.BONE_BRICKS)
        .create(SMBBlocks.BONE_BRICK_STAIRS).craftableFrom(SMBBlocks.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS)
        .create(SMBBlocks.BONE_BRICK_SLAB).craftableFrom(SMBBlocks.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS)
        .create(SMBBlocks.BONE_BRICK_WALL).craftableFrom(SMBBlocks.BONE_BRICKS).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS)
        .create(SMBBlocks.BONE_TILES).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS)
        .create(SMBBlocks.CRACKED_BONE_TILES).craftableFrom(SMBBlocks.BONE_TILES)
        .create(SMBBlocks.BONE_TILE_STAIRS).craftableFrom(SMBBlocks.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS, SMBBlocks.BONE_TILES)
        .create(SMBBlocks.BONE_TILE_SLAB).craftableFrom(SMBBlocks.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS, SMBBlocks.BONE_TILES)
        .create(SMBBlocks.BONE_TILE_WALL).craftableFrom(SMBBlocks.BONE_TILES).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS, SMBBlocks.BONE_TILES)
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
          .create(SMBBlocks.SOUL_SANDSTONE).craftableFrom(Blocks.SOUL_SAND, Blocks.SOUL_SOIL)
          .create(SMBBlocks.SOUL_SANDSTONE_STAIRS).craftableFrom(SMBBlocks.SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SOUL_SANDSTONE)
          .create(SMBBlocks.SOUL_SANDSTONE_SLAB).craftableFrom(SMBBlocks.SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SOUL_SANDSTONE)
          .create(SMBBlocks.SOUL_SANDSTONE_WALL).craftableFrom(SMBBlocks.SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SOUL_SANDSTONE)
          .create(SMBBlocks.CHISELED_SOUL_SANDSTONE).craftableFrom(SMBBlocks.SOUL_SANDSTONE_SLAB).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS)
          .create(SMBBlocks.SOUL_SANDSTONE_BRICKS).craftableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SOUL_SANDSTONE)
          .create(SMBBlocks.CRACKED_SOUL_SANDSTONE_BRICKS).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS)
          .create(SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS)
          .create(SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS)
          .create(SMBBlocks.SOUL_SANDSTONE_BRICK_WALL).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS)
          .create(SMBBlocks.SOUL_SANDSTONE_PILLAR).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.SOUL_SANDSTONE)
          .create(SMBBlocks.SOUL_SANDSTONE_TILES).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS)
          .create(SMBBlocks.CRACKED_SOUL_SANDSTONE_TILES).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS)
          .create(SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS).craftableFrom(SMBBlocks.SOUL_SANDSTONE_TILES).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS, SMBBlocks.SOUL_SANDSTONE_TILES)
          .create(SMBBlocks.SOUL_SANDSTONE_TILE_SLAB).craftableFrom(SMBBlocks.SOUL_SANDSTONE_TILES).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS, SMBBlocks.SOUL_SANDSTONE_TILES)
          .create(SMBBlocks.SOUL_SANDSTONE_TILE_WALL).craftableFrom(SMBBlocks.SOUL_SANDSTONE_TILES).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.SOUL_SANDSTONE_BRICKS, SMBBlocks.SOUL_SANDSTONE_TILES)
          .create(SMBBlocks.SMOOTH_SOUL_SANDSTONE).craftableFrom(SMBBlocks.SOUL_SANDSTONE)
          .create(SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB).craftableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE)
          .create(SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS).craftableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE)

          .create(SMBBlocks.CUT_SOUL_SANDSTONE).craftableFrom(SMBBlocks.SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SOUL_SANDSTONE)
          .create(SMBBlocks.CUT_SOUL_SANDSTONE_SLAB).craftableFrom(SMBBlocks.CUT_SOUL_SANDSTONE).cuttableFrom(SMBBlocks.SOUL_SANDSTONE, SMBBlocks.CUT_SOUL_SANDSTONE)
      ).build();

    RecipeAdvancement
      .group("Snow Block Variations", (instance) -> instance
        .create(SMBBlocks.PACKED_SNOW).craftableFrom(Blocks.SNOW_BLOCK)
        .create(SMBBlocks.PACKED_SNOW_STAIRS).craftableFrom(SMBBlocks.PACKED_SNOW)
        .create(SMBBlocks.PACKED_SNOW_SLAB).craftableFrom(SMBBlocks.PACKED_SNOW)
        .create(SMBBlocks.POLISHED_SNOW).craftableFrom(SMBBlocks.PACKED_SNOW)
        .create(SMBBlocks.POLISHED_SNOW_STAIRS).craftableFrom(SMBBlocks.PACKED_SNOW)
        .create(SMBBlocks.POLISHED_SNOW_SLAB).craftableFrom(SMBBlocks.PACKED_SNOW)
        .create(SMBBlocks.SNOW_BRICKS).craftableFrom(SMBBlocks.POLISHED_SNOW_SLAB)
        //.create(MBItems.CRACKED_SNOW_BRICKS).craftableFrom(MBItems.POLISHED_SNOW_SLAB)
        .create(SMBBlocks.SNOW_BRICK_STAIRS).craftableFrom(SMBBlocks.SNOW_BRICKS)
        .create(SMBBlocks.SNOW_BRICK_SLAB).craftableFrom(SMBBlocks.SNOW_BRICKS)
        .create(SMBBlocks.SNOW_BRICK_WALL).craftableFrom(SMBBlocks.SNOW_BRICKS)
        .create(SMBBlocks.SNOW_PILLAR).craftableFrom(SMBBlocks.SNOW_BRICKS)
        .create(SMBBlocks.SNOW_TILES).craftableFrom(SMBBlocks.SNOW_BRICKS)
        //.create(MBItems.CRACKED_SNOW_TILES).craftableFrom(MBItems.SNOW_TILES)
        .create(SMBBlocks.SNOW_TILE_STAIRS).craftableFrom(SMBBlocks.SNOW_TILES)
        .create(SMBBlocks.SNOW_TILE_SLAB).craftableFrom(SMBBlocks.SNOW_TILES)
        .create(SMBBlocks.SNOW_TILE_WALL).craftableFrom(SMBBlocks.SNOW_TILES)
      ).build();

    RecipeAdvancement
      .group("Packed Ice Block Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE)
        .create(SMBBlocks.POLISHED_ICE_STAIRS).craftableFrom(SMBBlocks.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE)
        .create(SMBBlocks.POLISHED_ICE_SLAB).craftableFrom(SMBBlocks.POLISHED_ICE).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE)
        .create(SMBBlocks.ICE_BRICKS).craftableFrom(Blocks.PACKED_ICE).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE)
        //.create(MBItems.CRACKED_ICE_BRICKS).craftableFrom(MBItems.ICE_BRICKS)
        .create(SMBBlocks.ICE_BRICK_STAIRS).craftableFrom(SMBBlocks.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE, SMBBlocks.ICE_BRICKS)
        .create(SMBBlocks.ICE_BRICK_SLAB).craftableFrom(SMBBlocks.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE, SMBBlocks.ICE_BRICKS)
        .create(SMBBlocks.ICE_BRICK_WALL).craftableFrom(SMBBlocks.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE, SMBBlocks.ICE_BRICKS)
        .create(SMBBlocks.ICE_PILLAR).craftableFrom(SMBBlocks.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE)
        .create(SMBBlocks.ICE_TILES).craftableFrom(SMBBlocks.ICE_BRICKS).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE, SMBBlocks.ICE_BRICKS)
        //.create(MBItems.CRACKED_ICE_TILES).craftableFrom(MBItems.ICE_TILES)
        .create(SMBBlocks.ICE_TILE_STAIRS).craftableFrom(SMBBlocks.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE, SMBBlocks.ICE_BRICKS, SMBBlocks.ICE_TILES)
        .create(SMBBlocks.ICE_TILE_SLAB).craftableFrom(SMBBlocks.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE, SMBBlocks.ICE_BRICKS, SMBBlocks.ICE_TILES)
        .create(SMBBlocks.ICE_TILE_WALL).craftableFrom(SMBBlocks.ICE_TILES).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE, SMBBlocks.ICE_BRICKS, SMBBlocks.ICE_TILES)
      ).build();

    RecipeAdvancement
      .group("Tiled Glasses Variation", (instance) -> instance
        .create(SMBBlocks.TILED_GLASS).craftableFrom(Blocks.GLASS)
        .create(SMBBlocks.TILED_TINTED_GLASS).craftableFrom(Blocks.TINTED_GLASS)
        .create(SMBBlocks.WHITE_STAINED_TILED_GLASS).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_STAINED_GLASS)
        .create(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_STAINED_GLASS)
        .create(SMBBlocks.GRAY_STAINED_TILED_GLASS).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_STAINED_GLASS)
        .create(SMBBlocks.BLACK_STAINED_TILED_GLASS).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_STAINED_GLASS)
        .create(SMBBlocks.BROWN_STAINED_TILED_GLASS).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_STAINED_GLASS)
        .create(SMBBlocks.RED_STAINED_TILED_GLASS).craftableFrom(Items.RED_DYE, Blocks.RED_STAINED_GLASS)
        .create(SMBBlocks.ORANGE_STAINED_TILED_GLASS).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_STAINED_GLASS)
        .create(SMBBlocks.YELLOW_STAINED_TILED_GLASS).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_STAINED_GLASS)
        .create(SMBBlocks.LIME_STAINED_TILED_GLASS).craftableFrom(Items.LIME_DYE, Blocks.LIME_STAINED_GLASS)
        .create(SMBBlocks.GREEN_STAINED_TILED_GLASS).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_STAINED_GLASS)
        .create(SMBBlocks.CYAN_STAINED_TILED_GLASS).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_STAINED_GLASS)
        .create(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_STAINED_GLASS)
        .create(SMBBlocks.BLUE_STAINED_TILED_GLASS).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_STAINED_GLASS)
        .create(SMBBlocks.PURPLE_STAINED_TILED_GLASS).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_STAINED_GLASS)
        .create(SMBBlocks.MAGENTA_STAINED_TILED_GLASS).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_STAINED_GLASS)
        .create(SMBBlocks.PINK_STAINED_TILED_GLASS).craftableFrom(Items.PINK_DYE, Blocks.PINK_STAINED_GLASS)
      ).build();

    RecipeAdvancement
      .group("Shingles Variation", (instance) -> instance
        .create(SMBBlocks.SHINGLES).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(SMBBlocks.WHITE_SHINGLES).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(SMBBlocks.LIGHT_GRAY_SHINGLES).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(SMBBlocks.GRAY_SHINGLES).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(SMBBlocks.BLACK_SHINGLES).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(SMBBlocks.BROWN_SHINGLES).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(SMBBlocks.RED_SHINGLES).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(SMBBlocks.ORANGE_SHINGLES).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(SMBBlocks.YELLOW_SHINGLES).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(SMBBlocks.LIME_SHINGLES).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(SMBBlocks.GREEN_SHINGLES).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(SMBBlocks.CYAN_SHINGLES).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(SMBBlocks.LIGHT_BLUE_SHINGLES).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(SMBBlocks.BLUE_SHINGLES).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(SMBBlocks.PURPLE_SHINGLES).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(SMBBlocks.MAGENTA_SHINGLES).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(SMBBlocks.PINK_SHINGLES).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Bricks Variation", (instance) -> instance
        .create(SMBBlocks.TERRACOTTA_BRICKS).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(SMBBlocks.WHITE_TERRACOTTA_BRICKS).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(SMBBlocks.GRAY_TERRACOTTA_BRICKS).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(SMBBlocks.BLACK_TERRACOTTA_BRICKS).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(SMBBlocks.BROWN_TERRACOTTA_BRICKS).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(SMBBlocks.RED_TERRACOTTA_BRICKS).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(SMBBlocks.ORANGE_TERRACOTTA_BRICKS).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(SMBBlocks.YELLOW_TERRACOTTA_BRICKS).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(SMBBlocks.LIME_TERRACOTTA_BRICKS).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(SMBBlocks.GREEN_TERRACOTTA_BRICKS).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(SMBBlocks.CYAN_TERRACOTTA_BRICKS).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(SMBBlocks.BLUE_TERRACOTTA_BRICKS).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(SMBBlocks.PURPLE_TERRACOTTA_BRICKS).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(SMBBlocks.MAGENTA_TERRACOTTA_BRICKS).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(SMBBlocks.PINK_TERRACOTTA_BRICKS).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Tiles Variation", (instance) -> instance
        .create(SMBBlocks.TERRACOTTA_TILES).craftableFrom(SMBBlocks.TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.TERRACOTTA_BRICKS)
        .create(SMBBlocks.WHITE_TERRACOTTA_TILES).craftableFrom(Items.WHITE_DYE, SMBBlocks.WHITE_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.WHITE_TERRACOTTA_BRICKS)
        .create(SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES).craftableFrom(Items.LIGHT_GRAY_DYE, SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS)
        .create(SMBBlocks.GRAY_TERRACOTTA_TILES).craftableFrom(Items.GRAY_DYE, SMBBlocks.GRAY_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.GRAY_TERRACOTTA_BRICKS)
        .create(SMBBlocks.BLACK_TERRACOTTA_TILES).craftableFrom(Items.BLACK_DYE, SMBBlocks.BLACK_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.BLACK_TERRACOTTA_BRICKS)
        .create(SMBBlocks.BROWN_TERRACOTTA_TILES).craftableFrom(Items.BROWN_DYE, SMBBlocks.BROWN_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.BROWN_TERRACOTTA_BRICKS)
        .create(SMBBlocks.RED_TERRACOTTA_TILES).craftableFrom(Items.RED_DYE, SMBBlocks.RED_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.RED_TERRACOTTA_BRICKS)
        .create(SMBBlocks.ORANGE_TERRACOTTA_TILES).craftableFrom(Items.ORANGE_DYE, SMBBlocks.ORANGE_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.ORANGE_TERRACOTTA_BRICKS)
        .create(SMBBlocks.YELLOW_TERRACOTTA_TILES).craftableFrom(Items.YELLOW_DYE, SMBBlocks.YELLOW_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.YELLOW_TERRACOTTA_BRICKS)
        .create(SMBBlocks.LIME_TERRACOTTA_TILES).craftableFrom(Items.LIME_DYE, SMBBlocks.LIME_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.LIME_TERRACOTTA_BRICKS)
        .create(SMBBlocks.GREEN_TERRACOTTA_TILES).craftableFrom(Items.GREEN_DYE, SMBBlocks.GREEN_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.GREEN_TERRACOTTA_BRICKS)
        .create(SMBBlocks.CYAN_TERRACOTTA_TILES).craftableFrom(Items.CYAN_DYE, SMBBlocks.CYAN_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.CYAN_TERRACOTTA_BRICKS)
        .create(SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES).craftableFrom(Items.LIGHT_BLUE_DYE, SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS)
        .create(SMBBlocks.BLUE_TERRACOTTA_TILES).craftableFrom(Items.BLUE_DYE, SMBBlocks.BLUE_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.BLUE_TERRACOTTA_BRICKS)
        .create(SMBBlocks.PURPLE_TERRACOTTA_TILES).craftableFrom(Items.PURPLE_DYE, SMBBlocks.PURPLE_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.PURPLE_TERRACOTTA_BRICKS)
        .create(SMBBlocks.MAGENTA_TERRACOTTA_TILES).craftableFrom(Items.MAGENTA_DYE, SMBBlocks.MAGENTA_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.MAGENTA_TERRACOTTA_BRICKS)
        .create(SMBBlocks.PINK_TERRACOTTA_TILES).craftableFrom(Items.PINK_DYE, SMBBlocks.PINK_TERRACOTTA_BRICKS).cuttableFrom(SMBBlocks.PINK_TERRACOTTA_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Concrete Bricks Variation", (instance) -> instance
        .create(SMBBlocks.WHITE_CONCRETE_BRICKS).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(SMBBlocks.GRAY_CONCRETE_BRICKS).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(SMBBlocks.BLACK_CONCRETE_BRICKS).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(SMBBlocks.BROWN_CONCRETE_BRICKS).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(SMBBlocks.RED_CONCRETE_BRICKS).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(SMBBlocks.ORANGE_CONCRETE_BRICKS).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(SMBBlocks.YELLOW_CONCRETE_BRICKS).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(SMBBlocks.LIME_CONCRETE_BRICKS).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(SMBBlocks.GREEN_CONCRETE_BRICKS).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(SMBBlocks.CYAN_CONCRETE_BRICKS).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(SMBBlocks.BLUE_CONCRETE_BRICKS).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(SMBBlocks.PURPLE_CONCRETE_BRICKS).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(SMBBlocks.MAGENTA_CONCRETE_BRICKS).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(SMBBlocks.PINK_CONCRETE_BRICKS).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Concrete Tiles Variation", (instance) -> instance
        .create(SMBBlocks.WHITE_CONCRETE_TILES).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(SMBBlocks.LIGHT_GRAY_CONCRETE_TILES).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(SMBBlocks.GRAY_CONCRETE_TILES).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(SMBBlocks.BLACK_CONCRETE_TILES).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(SMBBlocks.BROWN_CONCRETE_TILES).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(SMBBlocks.RED_CONCRETE_TILES).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(SMBBlocks.ORANGE_CONCRETE_TILES).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(SMBBlocks.YELLOW_CONCRETE_TILES).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(SMBBlocks.LIME_CONCRETE_TILES).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(SMBBlocks.GREEN_CONCRETE_TILES).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(SMBBlocks.CYAN_CONCRETE_TILES).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(SMBBlocks.LIGHT_BLUE_CONCRETE_TILES).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(SMBBlocks.BLUE_CONCRETE_TILES).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(SMBBlocks.PURPLE_CONCRETE_TILES).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(SMBBlocks.MAGENTA_CONCRETE_TILES).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(SMBBlocks.PINK_CONCRETE_TILES).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Redstone Froglight Lamp", (instance) -> instance
        .create(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT).craftableFrom(Items.OCHRE_FROGLIGHT)
        .create(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT).craftableFrom(Items.VERDANT_FROGLIGHT)
        .create(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT).craftableFrom(Items.PEARLESCENT_FROGLIGHT)
      ).build();
  }
}
