package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.datagen._deprecated.core.RecipeAdvancement;
import net.seface.somemoreblocks.datagen._deprecated.core.RecipeAdvancementGroupType;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBRecipeAdvancementProvider extends FabricAdvancementProvider {
  public SMBRecipeAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
    super(output, lookup);
  }

  @Override
  public void generateAdvancement(HolderLookup.Provider lookup, Consumer<AdvancementHolder> consumer) {
    RecipeAdvancement.setConsumer(consumer);

    RecipeAdvancement.create(Items.GREEN_DYE, RecipeAdvancementGroupType.MISC).craftableFrom(SMBBlocks.TINY_CACTUS.get()).build();
    RecipeAdvancement.create(Items.GLOWSTONE_DUST, RecipeAdvancementGroupType.MISC).craftableFrom(SMBBlocks.LUMINOUS_FLOWER.get()).build();

    RecipeAdvancement
      .group("Mosaics", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBBlocks.OAK_MOSAIC.get()).craftableFrom(Blocks.OAK_SLAB)
        .create(SMBBlocks.SPRUCE_MOSAIC.get()).craftableFrom(Blocks.SPRUCE_SLAB)
        .create(SMBBlocks.BIRCH_MOSAIC.get()).craftableFrom(Blocks.BIRCH_SLAB)
        .create(SMBBlocks.JUNGLE_MOSAIC.get()).craftableFrom(Blocks.JUNGLE_SLAB)
        .create(SMBBlocks.ACACIA_MOSAIC.get()).craftableFrom(Blocks.ACACIA_SLAB)
        .create(SMBBlocks.DARK_OAK_MOSAIC.get()).craftableFrom(Blocks.DARK_OAK_SLAB)
        .create(SMBBlocks.MANGROVE_MOSAIC.get()).craftableFrom(Blocks.MANGROVE_SLAB)
        .create(SMBBlocks.CRIMSON_MOSAIC.get()).craftableFrom(Blocks.CRIMSON_SLAB)
        .create(SMBBlocks.WARPED_MOSAIC.get()).craftableFrom(Blocks.WARPED_SLAB)
        .create(SMBBlocks.CHERRY_MOSAIC.get()).craftableFrom(Blocks.CHERRY_SLAB)
      ).build();

    RecipeAdvancement
      .group("Mosaic Stairs", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBBlocks.OAK_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.OAK_MOSAIC.get())
        .create(SMBBlocks.SPRUCE_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.SPRUCE_MOSAIC.get())
        .create(SMBBlocks.BIRCH_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.BIRCH_MOSAIC.get())
        .create(SMBBlocks.JUNGLE_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.JUNGLE_MOSAIC.get())
        .create(SMBBlocks.ACACIA_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.ACACIA_MOSAIC.get())
        .create(SMBBlocks.DARK_OAK_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.DARK_OAK_MOSAIC.get())
        .create(SMBBlocks.MANGROVE_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.MANGROVE_MOSAIC.get())
        .create(SMBBlocks.CRIMSON_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.CRIMSON_MOSAIC.get())
        .create(SMBBlocks.WARPED_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.WARPED_MOSAIC.get())
        .create(SMBBlocks.CHERRY_MOSAIC_STAIRS.get()).craftableFrom(SMBBlocks.CHERRY_MOSAIC.get())
      ).build();

    RecipeAdvancement
      .group("Mosaic Slabs", (instance) -> instance
        .setExpectedEntries(10)
        .create(SMBBlocks.OAK_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.OAK_MOSAIC.get())
        .create(SMBBlocks.SPRUCE_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.SPRUCE_MOSAIC.get())
        .create(SMBBlocks.BIRCH_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.BIRCH_MOSAIC.get())
        .create(SMBBlocks.JUNGLE_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.JUNGLE_MOSAIC.get())
        .create(SMBBlocks.ACACIA_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.ACACIA_MOSAIC.get())
        .create(SMBBlocks.DARK_OAK_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.DARK_OAK_MOSAIC.get())
        .create(SMBBlocks.MANGROVE_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.MANGROVE_MOSAIC.get())
        .create(SMBBlocks.CRIMSON_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.CRIMSON_MOSAIC.get())
        .create(SMBBlocks.WARPED_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.WARPED_MOSAIC.get())
        .create(SMBBlocks.CHERRY_MOSAIC_SLAB.get()).craftableFrom(SMBBlocks.CHERRY_MOSAIC.get())
      ).build();

    RecipeAdvancement
      .group("Stone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_STONE.get()).cuttableFrom(Blocks.STONE)
        .create(SMBBlocks.POLISHED_STONE_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_STONE.get()).cuttableFrom(Blocks.STONE, SMBBlocks.POLISHED_STONE.get())
        .create(SMBBlocks.POLISHED_STONE_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_STONE.get()).cuttableFrom(Blocks.STONE, SMBBlocks.POLISHED_STONE.get())
        .create(SMBBlocks.STONE_PILLAR.get()).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE)
        .create(SMBBlocks.STONE_TILES.get()).craftableFrom(Blocks.STONE_BRICKS).cuttableFrom(Blocks.STONE, SMBBlocks.POLISHED_STONE.get(), Blocks.STONE_BRICKS)
        .create(SMBBlocks.CRACKED_STONE_TILES.get()).craftableFrom(SMBBlocks.STONE_TILES.get())
        .create(SMBBlocks.STONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.STONE_TILES.get()).cuttableFrom(Blocks.STONE_BRICKS, SMBBlocks.STONE_TILES.get(), SMBBlocks.POLISHED_STONE.get(), Blocks.STONE)
        .create(SMBBlocks.STONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.STONE_TILES.get()).cuttableFrom(Blocks.STONE_BRICKS, SMBBlocks.STONE_TILES.get(), SMBBlocks.POLISHED_STONE.get(), Blocks.STONE)
        .create(SMBBlocks.STONE_TILE_WALL.get()).craftableFrom(SMBBlocks.STONE_TILES.get()).cuttableFrom(Blocks.STONE_BRICKS, SMBBlocks.STONE_TILES.get(), SMBBlocks.POLISHED_STONE.get(), Blocks.STONE)
      ).build();

    RecipeAdvancement
      .group("Granite Variations", (instance) -> instance
        .create(SMBBlocks.CHISELED_GRANITE_BRICKS.get()).craftableFrom(SMBBlocks.GRANITE_BRICK_SLAB.get()).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS.get())
        .create(SMBBlocks.GRANITE_BRICKS.get()).craftableFrom(Blocks.POLISHED_GRANITE).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.CRACKED_GRANITE_BRICKS.get()).craftableFrom(SMBBlocks.GRANITE_BRICKS.get())
        .create(SMBBlocks.GRANITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.GRANITE_BRICKS.get()).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.GRANITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.GRANITE_BRICKS.get()).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.GRANITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.GRANITE_BRICKS.get()).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE)
        .create(SMBBlocks.GRANITE_PILLAR.get()).craftableFrom(SMBBlocks.GRANITE_BRICKS.get()).cuttableFrom(Blocks.GRANITE)
        .create(SMBBlocks.GRANITE_TILES.get()).craftableFrom(SMBBlocks.GRANITE_BRICKS.get()).cuttableFrom(Blocks.GRANITE, Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_BRICKS.get())
        .create(SMBBlocks.CRACKED_GRANITE_TILES.get()).craftableFrom(SMBBlocks.GRANITE_TILES.get())
        .create(SMBBlocks.GRANITE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.GRANITE_TILES.get()).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_TILES.get())
        .create(SMBBlocks.GRANITE_TILE_SLAB.get()).craftableFrom(SMBBlocks.GRANITE_TILES.get()).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_TILES.get())
        .create(SMBBlocks.GRANITE_TILE_WALL.get()).craftableFrom(SMBBlocks.GRANITE_TILES.get()).cuttableFrom(Blocks.GRANITE, SMBBlocks.GRANITE_BRICKS.get(), Blocks.POLISHED_GRANITE, SMBBlocks.GRANITE_TILES.get())
        .create(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_GRANITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_GRANITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_GRANITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_GRANITE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_GRANITE.get()).craftableFrom(Blocks.GRANITE)
        .create(SMBBlocks.SMOOTH_GRANITE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_GRANITE.get()).cuttableFrom(SMBBlocks.SMOOTH_GRANITE.get())
      ).build();

    RecipeAdvancement
      .group("Diorite Variations", (instance) -> instance
        .create(SMBBlocks.CHISELED_DIORITE_BRICKS.get()).craftableFrom(SMBBlocks.DIORITE_BRICK_SLAB.get()).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS.get())
        .create(SMBBlocks.DIORITE_BRICKS.get()).craftableFrom(Blocks.POLISHED_DIORITE).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.CRACKED_DIORITE_BRICKS.get()).craftableFrom(SMBBlocks.DIORITE_BRICKS.get())
        .create(SMBBlocks.DIORITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.DIORITE_BRICKS.get()).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.DIORITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.DIORITE_BRICKS.get()).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.DIORITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.DIORITE_BRICKS.get()).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE)
        .create(SMBBlocks.DIORITE_PILLAR.get()).craftableFrom(SMBBlocks.DIORITE_BRICKS.get()).cuttableFrom(Blocks.DIORITE)
        .create(SMBBlocks.DIORITE_TILES.get()).craftableFrom(SMBBlocks.DIORITE_BRICKS.get()).cuttableFrom(Blocks.DIORITE, Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_BRICKS.get())
        .create(SMBBlocks.CRACKED_DIORITE_TILES.get()).craftableFrom(SMBBlocks.DIORITE_TILES.get())
        .create(SMBBlocks.DIORITE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.DIORITE_TILES.get()).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_TILES.get())
        .create(SMBBlocks.DIORITE_TILE_SLAB.get()).craftableFrom(SMBBlocks.DIORITE_TILES.get()).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_TILES.get())
        .create(SMBBlocks.DIORITE_TILE_WALL.get()).craftableFrom(SMBBlocks.DIORITE_TILES.get()).cuttableFrom(Blocks.DIORITE, SMBBlocks.DIORITE_BRICKS.get(), Blocks.POLISHED_DIORITE, SMBBlocks.DIORITE_TILES.get())
        .create(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_DIORITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_DIORITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_DIORITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_DIORITE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_DIORITE.get()).craftableFrom(Blocks.DIORITE)
        .create(SMBBlocks.SMOOTH_DIORITE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_DIORITE.get()).cuttableFrom(SMBBlocks.SMOOTH_DIORITE.get())
      ).build();

    RecipeAdvancement
      .group("Andesite Variations", (instance) -> instance
        .create(SMBBlocks.CHISELED_ANDESITE_BRICKS.get()).craftableFrom(SMBBlocks.ANDESITE_BRICK_SLAB.get()).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS.get())
        .create(SMBBlocks.ANDESITE_BRICKS.get()).craftableFrom(Blocks.POLISHED_ANDESITE).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.CRACKED_ANDESITE_BRICKS.get()).craftableFrom(SMBBlocks.ANDESITE_BRICKS.get())
        .create(SMBBlocks.ANDESITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.ANDESITE_BRICKS.get()).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.ANDESITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.ANDESITE_BRICKS.get()).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.ANDESITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.ANDESITE_BRICKS.get()).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE)
        .create(SMBBlocks.ANDESITE_PILLAR.get()).craftableFrom(SMBBlocks.ANDESITE_BRICKS.get()).cuttableFrom(Blocks.ANDESITE)
        .create(SMBBlocks.ANDESITE_TILES.get()).craftableFrom(SMBBlocks.ANDESITE_BRICKS.get()).cuttableFrom(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_BRICKS.get())
        .create(SMBBlocks.CRACKED_ANDESITE_TILES.get()).craftableFrom(SMBBlocks.ANDESITE_TILES.get())
        .create(SMBBlocks.ANDESITE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.ANDESITE_TILES.get()).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_TILES.get())
        .create(SMBBlocks.ANDESITE_TILE_SLAB.get()).craftableFrom(SMBBlocks.ANDESITE_TILES.get()).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_TILES.get())
        .create(SMBBlocks.GRANITE_TILE_WALL.get()).craftableFrom(SMBBlocks.ANDESITE_TILES.get()).cuttableFrom(Blocks.ANDESITE, SMBBlocks.ANDESITE_BRICKS.get(), Blocks.POLISHED_ANDESITE, SMBBlocks.ANDESITE_TILES.get())
        .create(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_ANDESITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_ANDESITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_ANDESITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_ANDESITE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_ANDESITE.get()).craftableFrom(Blocks.ANDESITE)
        .create(SMBBlocks.SMOOTH_ANDESITE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_ANDESITE.get()).cuttableFrom(SMBBlocks.SMOOTH_ANDESITE.get())
      ).build();

    RecipeAdvancement.create(SMBBlocks.DEEPSLATE_PILLAR.get()).craftableFrom(Blocks.DEEPSLATE_BRICKS).cuttableFrom(Blocks.DEEPSLATE).build();

    RecipeAdvancement
      .group("Calcite Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_CALCITE.get()).cuttableFrom(Blocks.CALCITE)
        .create(SMBBlocks.POLISHED_CALCITE_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_CALCITE.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get())
        .create(SMBBlocks.POLISHED_CALCITE_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_CALCITE.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get())
        .create(SMBBlocks.CHISELED_CALCITE_BRICKS.get()).craftableFrom(SMBBlocks.CALCITE_BRICK_SLAB.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.CALCITE_BRICKS.get())
        .create(SMBBlocks.CALCITE_BRICKS.get()).craftableFrom(Blocks.CALCITE).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get())
        .create(SMBBlocks.CRACKED_CALCITE_BRICKS.get()).craftableFrom(SMBBlocks.CALCITE_BRICKS.get())
        .create(SMBBlocks.CALCITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.CALCITE_BRICKS.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get())
        .create(SMBBlocks.CALCITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.CALCITE_BRICKS.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get())
        .create(SMBBlocks.CALCITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.CALCITE_BRICKS.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get())
        .create(SMBBlocks.CALCITE_PILLAR.get()).craftableFrom(SMBBlocks.CALCITE_BRICKS.get()).cuttableFrom(Blocks.CALCITE)
        .create(SMBBlocks.CALCITE_TILES.get()).craftableFrom(SMBBlocks.CALCITE_BRICKS.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get())
        .create(SMBBlocks.CRACKED_CALCITE_TILES.get()).craftableFrom(SMBBlocks.CALCITE_TILES.get())
        .create(SMBBlocks.CALCITE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.CALCITE_TILES.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get(), SMBBlocks.CALCITE_TILES.get())
        .create(SMBBlocks.CALCITE_TILE_SLAB.get()).craftableFrom(SMBBlocks.CALCITE_TILES.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get(), SMBBlocks.CALCITE_TILES.get())
        .create(SMBBlocks.CALCITE_TILE_WALL.get()).craftableFrom(SMBBlocks.CALCITE_TILES.get()).cuttableFrom(Blocks.CALCITE, SMBBlocks.POLISHED_CALCITE.get(), SMBBlocks.CALCITE_BRICKS.get(), SMBBlocks.CALCITE_TILES.get())
        .create(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_CALCITE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_CALCITE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS.get())
        .create(SMBBlocks.MOSSY_CALCITE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_CALCITE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_CALCITE.get()).craftableFrom(Blocks.CALCITE)
        .create(SMBBlocks.SMOOTH_CALCITE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_CALCITE.get()).cuttableFrom(SMBBlocks.SMOOTH_CALCITE.get())
      ).build();

    RecipeAdvancement
      .group("Tuff Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_TUFF_BRICKS.get()).craftableFrom(Blocks.TUFF_BRICKS)
        .create(SMBBlocks.TUFF_PILLAR.get()).craftableFrom(Blocks.TUFF_BRICKS).cuttableFrom(Blocks.TUFF)
        .create(SMBBlocks.TUFF_TILES.get()).craftableFrom(Blocks.TUFF_BRICKS).cuttableFrom(Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS)
        .create(SMBBlocks.CRACKED_TUFF_TILES.get()).craftableFrom(SMBBlocks.TUFF_TILES.get())
        .create(SMBBlocks.TUFF_TILE_STAIRS.get()).craftableFrom(SMBBlocks.TUFF_TILES.get()).cuttableFrom(Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS, SMBBlocks.TUFF_TILES.get())
        .create(SMBBlocks.TUFF_TILE_SLAB.get()).craftableFrom(SMBBlocks.TUFF_TILES.get()).cuttableFrom(Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS, SMBBlocks.TUFF_TILES.get())
        .create(SMBBlocks.TUFF_TILE_WALL.get()).craftableFrom(SMBBlocks.TUFF_TILES.get()).cuttableFrom(Blocks.TUFF, Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS, SMBBlocks.TUFF_TILES.get())
        .create(SMBBlocks.MOSSY_TUFF_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_TUFF_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_TUFF_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_TUFF_BRICKS.get())
        .create(SMBBlocks.MOSSY_TUFF_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_TUFF_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_TUFF_BRICKS.get())
        .create(SMBBlocks.MOSSY_TUFF_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_TUFF_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_TUFF_BRICKS.get())
        .create(SMBBlocks.SMOOTH_TUFF.get()).craftableFrom(Blocks.TUFF)
        .create(SMBBlocks.SMOOTH_TUFF_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_TUFF.get()).cuttableFrom(SMBBlocks.SMOOTH_TUFF.get())
      ).build();

    RecipeAdvancement
      .group("Dripstone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_DRIPSTONE.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBBlocks.POLISHED_DRIPSTONE_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_DRIPSTONE.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get())
        .create(SMBBlocks.POLISHED_DRIPSTONE_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_DRIPSTONE.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get())
        .create(SMBBlocks.CHISELED_DRIPSTONE_BRICKS.get()).craftableFrom(SMBBlocks.DRIPSTONE_BRICK_SLAB.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.DRIPSTONE_BRICKS.get()).craftableFrom(Blocks.DRIPSTONE_BLOCK).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get())
        .create(SMBBlocks.CRACKED_DRIPSTONE_BRICKS.get()).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.DRIPSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.DRIPSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.DRIPSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.DRIPSTONE_PILLAR.get()).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBBlocks.DRIPSTONE_TILES.get()).craftableFrom(SMBBlocks.DRIPSTONE_BRICKS.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.CRACKED_DRIPSTONE_TILES.get()).craftableFrom(SMBBlocks.DRIPSTONE_TILES.get())
        .create(SMBBlocks.DRIPSTONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.DRIPSTONE_TILES.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get(), SMBBlocks.DRIPSTONE_TILES.get())
        .create(SMBBlocks.DRIPSTONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.DRIPSTONE_TILES.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get(), SMBBlocks.DRIPSTONE_TILES.get())
        .create(SMBBlocks.DRIPSTONE_TILE_WALL.get()).craftableFrom(SMBBlocks.DRIPSTONE_TILES.get()).cuttableFrom(Blocks.DRIPSTONE_BLOCK, SMBBlocks.POLISHED_DRIPSTONE.get(), SMBBlocks.DRIPSTONE_BRICKS.get(), SMBBlocks.DRIPSTONE_TILES.get())
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_DRIPSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_DRIPSTONE.get()).craftableFrom(Blocks.DRIPSTONE_BLOCK)
        .create(SMBBlocks.SMOOTH_DRIPSTONE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_DRIPSTONE.get()).cuttableFrom(SMBBlocks.SMOOTH_DRIPSTONE.get())
      ).build();

    RecipeAdvancement.
      group("Bricks Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_BRICKS.get()).craftableFrom(Blocks.BRICKS)
        .create(SMBBlocks.MOSSY_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_BRICKS.get())
        .create(SMBBlocks.MOSSY_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_BRICKS.get())
        .create(SMBBlocks.MOSSY_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_BRICKS.get())
      ).build();

    RecipeAdvancement.
      group("Mud Variations", (instance) -> instance
        .setExpectedEntries(17)
        .create(SMBBlocks.POLISHED_MUD.get()).craftableFrom(Blocks.PACKED_MUD)
        .create(SMBBlocks.POLISHED_MUD_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_MUD.get()).cuttableFrom(Blocks.PACKED_MUD, SMBBlocks.POLISHED_MUD.get())
        .create(SMBBlocks.POLISHED_MUD_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_MUD.get()).cuttableFrom(Blocks.PACKED_MUD, SMBBlocks.POLISHED_MUD.get())
        .create(SMBBlocks.CHISELED_MUD_BRICKS.get()).craftableFrom(Blocks.MUD_BRICK_SLAB).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS)
        .create(SMBBlocks.CRACKED_MUD_BRICKS.get()).craftableFrom(Blocks.MUD_BRICKS)
        .create(SMBBlocks.MUD_PILLAR.get()).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD)
        .create(SMBBlocks.MUD_TILES.get()).craftableFrom(Blocks.MUD_BRICKS).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD.get())
        .create(SMBBlocks.CRACKED_MUD_TILES.get()).craftableFrom(SMBBlocks.MUD_TILES.get())
        .create(SMBBlocks.MUD_TILE_STAIRS.get()).craftableFrom(SMBBlocks.MUD_TILES.get()).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD.get(), SMBBlocks.MUD_TILES.get())
        .create(SMBBlocks.MUD_TILE_SLAB.get()).craftableFrom(SMBBlocks.MUD_TILES.get()).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD.get(), SMBBlocks.MUD_TILES.get())
        .create(SMBBlocks.MUD_TILE_WALL.get()).craftableFrom(SMBBlocks.MUD_TILES.get()).cuttableFrom(Blocks.PACKED_MUD, Blocks.MUD_BRICKS, SMBBlocks.POLISHED_MUD.get(), SMBBlocks.MUD_TILES.get())
        .create(SMBBlocks.MOSSY_MUD_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_MUD_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_MUD_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_MUD_BRICKS.get())
        .create(SMBBlocks.MOSSY_MUD_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_MUD_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_MUD_BRICKS.get())
        .create(SMBBlocks.MOSSY_MUD_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_MUD_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_MUD_BRICKS.get())
        .create(SMBBlocks.SMOOTH_MUD.get()).craftableFrom(Blocks.PACKED_MUD)
        .create(SMBBlocks.SMOOTH_MUD_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_MUD.get()).cuttableFrom(SMBBlocks.SMOOTH_MUD.get())
      ).build();

    RecipeAdvancement.
      group("Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(SMBBlocks.SANDSTONE_BRICKS.get()).craftableFrom(Blocks.SMOOTH_SANDSTONE).cuttableFrom(Blocks.SANDSTONE)
        .create(SMBBlocks.CRACKED_SANDSTONE_BRICKS.get()).craftableFrom(SMBBlocks.SANDSTONE_BRICKS.get())
        .create(SMBBlocks.SANDSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get())
        .create(SMBBlocks.SANDSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get())
        .create(SMBBlocks.SANDSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get())
        .create(SMBBlocks.SANDSTONE_PILLAR.get()).craftableFrom(SMBBlocks.SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.SANDSTONE)
        .create(SMBBlocks.SANDSTONE_TILES.get()).craftableFrom(SMBBlocks.SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get())
        .create(SMBBlocks.CRACKED_SANDSTONE_TILES.get()).craftableFrom(SMBBlocks.SANDSTONE_BRICKS.get())
        .create(SMBBlocks.SANDSTONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.SANDSTONE_TILES.get()).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get(), SMBBlocks.SANDSTONE_TILES.get())
        .create(SMBBlocks.SANDSTONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.SANDSTONE_TILES.get()).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get(), SMBBlocks.SANDSTONE_TILES.get())
        .create(SMBBlocks.SANDSTONE_TILE_WALL.get()).craftableFrom(SMBBlocks.SANDSTONE_TILES.get()).cuttableFrom(Blocks.SANDSTONE, SMBBlocks.SANDSTONE_BRICKS.get(), SMBBlocks.SANDSTONE_TILES.get())
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_SANDSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get())
      ).build();

    RecipeAdvancement.
      group("Red Sandstone Variations", (instance) -> instance
        .setExpectedEntries(15)
        .create(SMBBlocks.RED_SANDSTONE_BRICKS.get()).craftableFrom(Blocks.SMOOTH_RED_SANDSTONE).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(SMBBlocks.CRACKED_RED_SANDSTONE_BRICKS.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.RED_SANDSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.RED_SANDSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.RED_SANDSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.RED_SANDSTONE_PILLAR.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.RED_SANDSTONE)
        .create(SMBBlocks.RED_SANDSTONE_TILES.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS.get()).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.CRACKED_RED_SANDSTONE_TILES.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.RED_SANDSTONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_TILES.get()).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get(), SMBBlocks.RED_SANDSTONE_TILES.get())
        .create(SMBBlocks.RED_SANDSTONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_TILES.get()).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get(), SMBBlocks.RED_SANDSTONE_TILES.get())
        .create(SMBBlocks.RED_SANDSTONE_TILE_WALL.get()).craftableFrom(SMBBlocks.RED_SANDSTONE_TILES.get()).cuttableFrom(Blocks.RED_SANDSTONE, SMBBlocks.RED_SANDSTONE_BRICKS.get(), SMBBlocks.RED_SANDSTONE_TILES.get())
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get())
      ).build();

    RecipeAdvancement
      .group("Prismarine Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_PRISMARINE.get()).cuttableFrom(Blocks.PRISMARINE)
        .create(SMBBlocks.POLISHED_PRISMARINE_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_PRISMARINE.get()).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get())
        .create(SMBBlocks.POLISHED_PRISMARINE_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_PRISMARINE.get()).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get())
        .create(SMBBlocks.CHISELED_PRISMARINE_BRICKS.get()).craftableFrom(Blocks.PRISMARINE_BRICK_SLAB).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE_BRICKS)
        .create(SMBBlocks.CRACKED_PRISMARINE_BRICKS.get()).craftableFrom(Blocks.PRISMARINE_BRICKS)
        .create(SMBBlocks.PRISMARINE_PILLAR.get()).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE)
        .create(SMBBlocks.PRISMARINE_TILES.get()).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE_BRICKS)
        .create(SMBBlocks.CRACKED_PRISMARINE_TILES.get()).craftableFrom(SMBBlocks.PRISMARINE_TILES.get())
        .create(SMBBlocks.PRISMARINE_TILE_STAIRS.get()).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE_BRICKS, SMBBlocks.PRISMARINE_TILES.get())
        .create(SMBBlocks.PRISMARINE_TILE_SLAB.get()).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE_BRICKS, SMBBlocks.PRISMARINE_TILES.get())
        .create(SMBBlocks.PRISMARINE_TILE_WALL.get()).craftableFrom(Blocks.PRISMARINE_BRICKS).cuttableFrom(Blocks.PRISMARINE, SMBBlocks.POLISHED_PRISMARINE.get(), Blocks.PRISMARINE_BRICKS, SMBBlocks.PRISMARINE_TILES.get())
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get()).craftableFrom(Items.KELP)
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get())
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get())
        .create(SMBBlocks.MOSSY_PRISMARINE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_PRISMARINE.get()).craftableFrom(Blocks.PRISMARINE)
        .create(SMBBlocks.SMOOTH_PRISMARINE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_PRISMARINE.get()).cuttableFrom(SMBBlocks.SMOOTH_PRISMARINE.get())
      ).build();

    RecipeAdvancement.create(SMBBlocks.NETHER_BRICKS_PILLAR.get()).craftableFrom(Blocks.NETHER_BRICKS).cuttableFrom(Blocks.NETHER_BRICKS).build();

    RecipeAdvancement
      .group("Red Nether Bricks Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_RED_NETHER_BRICKS.get()).craftableFrom(Blocks.RED_NETHER_BRICKS)
        .create(SMBBlocks.CHISELED_RED_NETHER_BRICKS.get()).craftableFrom(Blocks.RED_NETHER_BRICK_SLAB).cuttableFrom(Blocks.RED_NETHER_BRICKS)
        .create(SMBBlocks.RED_NETHER_BRICKS_PILLAR.get()).craftableFrom(Blocks.RED_NETHER_BRICKS).cuttableFrom(Blocks.RED_NETHER_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Polished Blackstone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_BLACKSTONE_PILLAR.get()).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE)
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILES.get()).craftableFrom(Blocks.POLISHED_BLACKSTONE_BRICKS).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS)
        .create(SMBBlocks.CRACKED_POLISHED_BLACKSTONE_TILES.get()).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES.get())
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES.get()).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBBlocks.POLISHED_BLACKSTONE_TILES.get())
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES.get()).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBBlocks.POLISHED_BLACKSTONE_TILES.get())
        .create(SMBBlocks.POLISHED_BLACKSTONE_TILE_WALL.get()).craftableFrom(SMBBlocks.POLISHED_BLACKSTONE_TILES.get()).cuttableFrom(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS, SMBBlocks.POLISHED_BLACKSTONE_TILES.get())
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get()).craftableFrom(Items.MAGMA_CREAM)
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get())
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get())
        .create(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_BLACKSTONE.get()).craftableFrom(Blocks.BLACKSTONE)
        .create(SMBBlocks.SMOOTH_BLACKSTONE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_BLACKSTONE.get()).cuttableFrom(SMBBlocks.SMOOTH_BLACKSTONE.get())
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_END_STONE.get()).cuttableFrom(Blocks.END_STONE)
        .create(SMBBlocks.POLISHED_END_STONE_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_END_STONE.get()).cuttableFrom(Blocks.END_STONE, SMBBlocks.POLISHED_STONE.get())
        .create(SMBBlocks.POLISHED_END_STONE_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_END_STONE.get()).cuttableFrom(Blocks.END_STONE, SMBBlocks.POLISHED_STONE.get())
        .create(SMBBlocks.CHISELED_END_STONE_BRICKS.get()).craftableFrom(Blocks.END_STONE_BRICK_SLAB).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS)
        .create(SMBBlocks.CRACKED_END_STONE_BRICKS.get()).craftableFrom(Blocks.END_STONE_BRICKS)
        .create(SMBBlocks.END_STONE_PILLAR.get()).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE)
        .create(SMBBlocks.END_STONE_TILES.get()).craftableFrom(Blocks.END_STONE_BRICKS).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE.get())
        .create(SMBBlocks.CRACKED_END_STONE_TILES.get()).craftableFrom(SMBBlocks.END_STONE_TILES.get())
        .create(SMBBlocks.END_STONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.END_STONE_TILES.get()).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE.get(), SMBBlocks.END_STONE_TILES.get())
        .create(SMBBlocks.END_STONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.END_STONE_TILES.get()).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE.get(), SMBBlocks.END_STONE_TILES.get())
        .create(SMBBlocks.END_STONE_TILE_WALL.get()).craftableFrom(SMBBlocks.END_STONE_TILES.get()).cuttableFrom(Blocks.END_STONE, Blocks.END_STONE_BRICKS, SMBBlocks.POLISHED_END_STONE.get(), SMBBlocks.END_STONE_TILES.get())
        .create(SMBBlocks.MOSSY_END_STONE_BRICKS.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_END_STONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_END_STONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS.get())
        .create(SMBBlocks.MOSSY_END_STONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS.get()).cuttableFrom(SMBBlocks.MOSSY_END_STONE_BRICKS.get())
        .create(SMBBlocks.SMOOTH_END_STONE.get()).craftableFrom(Blocks.END_STONE)
        .create(SMBBlocks.SMOOTH_END_STONE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_END_STONE.get()).cuttableFrom(SMBBlocks.SMOOTH_END_STONE.get())
      ).build();

    RecipeAdvancement
      .group("End Stone Variations", (instance) -> instance
        .create(SMBBlocks.POLISHED_PURPUR.get()).cuttableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBBlocks.POLISHED_PURPUR_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_PURPUR.get()).cuttableFrom(Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_STONE.get())
        .create(SMBBlocks.POLISHED_PURPUR_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_PURPUR.get()).cuttableFrom(Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_STONE.get())
        .create(SMBBlocks.CHISELED_PURPUR.get()).craftableFrom(Blocks.END_ROD)
        .create(SMBBlocks.CRACKED_PURPUR_BLOCK.get()).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBBlocks.PURPUR_TILES.get()).craftableFrom(Blocks.PURPUR_BLOCK).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR.get())
        .create(SMBBlocks.CRACKED_PURPUR_TILES.get()).craftableFrom(SMBBlocks.PURPUR_TILES.get())
        .create(SMBBlocks.PURPUR_TILE_STAIRS.get()).craftableFrom(SMBBlocks.PURPUR_TILES.get()).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR.get(), SMBBlocks.PURPUR_TILES.get())
        .create(SMBBlocks.PURPUR_TILE_SLAB.get()).craftableFrom(SMBBlocks.PURPUR_TILES.get()).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR.get(), SMBBlocks.PURPUR_TILES.get())
        .create(SMBBlocks.PURPUR_TILE_WALL.get()).craftableFrom(SMBBlocks.PURPUR_TILES.get()).cuttableFrom(Blocks.PURPUR_BLOCK, Blocks.PURPUR_BLOCK, SMBBlocks.POLISHED_PURPUR.get(), SMBBlocks.PURPUR_TILES.get())
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK.get()).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK_STAIRS.get()).craftableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK.get()).cuttableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK.get())
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK_SLAB.get()).craftableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK.get()).cuttableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK.get())
        .create(SMBBlocks.MOSSY_PURPUR_BLOCK_WALL.get()).craftableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK.get()).cuttableFrom(SMBBlocks.MOSSY_PURPUR_BLOCK.get())
        .create(SMBBlocks.SMOOTH_PURPUR.get()).craftableFrom(Blocks.PURPUR_BLOCK)
        .create(SMBBlocks.SMOOTH_PURPUR_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_PURPUR.get()).cuttableFrom(SMBBlocks.SMOOTH_PURPUR.get())
      ).build();

    RecipeAdvancement
      .group("Coal Block Variations", (instance) -> instance
        .create(SMBBlocks.COAL_BRICKS.get()).craftableFrom(SMBBlocks.CUT_COAL.get())
        .create(SMBBlocks.CRACKED_COAL_BRICKS.get()).craftableFrom(SMBBlocks.COAL_BRICKS.get())
        .create(SMBBlocks.COAL_PILLAR.get()).craftableFrom(Blocks.COAL_BLOCK)
        .create(SMBBlocks.CUT_COAL.get()).craftableFrom(Blocks.COAL_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_COAL.get()).craftableFrom(SMBBlocks.CUT_COAL.get())
      ).build();

    RecipeAdvancement
      .group("Iron Block Variations", (instance) -> instance
        .create(SMBBlocks.IRON_BRICKS.get()).craftableFrom(SMBBlocks.CUT_IRON.get())
        .create(SMBBlocks.CRACKED_IRON_BRICKS.get()).craftableFrom(SMBBlocks.IRON_BRICKS.get())
        .create(SMBBlocks.IRON_PILLAR.get()).craftableFrom(Blocks.IRON_BLOCK)
        .create(SMBBlocks.CUT_IRON.get()).craftableFrom(Blocks.IRON_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_IRON.get()).craftableFrom(SMBBlocks.CUT_IRON.get())
        .create(SMBBlocks.IRON_GRATE.get()).craftableFrom(Blocks.IRON_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Gold Block Variations", (instance) -> instance
        .create(SMBBlocks.GOLD_BRICKS.get()).craftableFrom(SMBBlocks.CUT_GOLD.get())
        .create(SMBBlocks.CRACKED_GOLD_BRICKS.get()).craftableFrom(SMBBlocks.GOLD_BRICKS.get())
        .create(SMBBlocks.GOLD_PILLAR.get()).craftableFrom(Blocks.GOLD_BLOCK)
        .create(SMBBlocks.CUT_GOLD.get()).craftableFrom(Blocks.GOLD_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_GOLD.get()).craftableFrom(SMBBlocks.CUT_GOLD.get())
      ).build();

    RecipeAdvancement
      .group("Emerald Block Variations", (instance) -> instance
        .create(SMBBlocks.EMERALD_BRICKS.get()).craftableFrom(SMBBlocks.CUT_EMERALD.get())
        .create(SMBBlocks.CRACKED_EMERALD_BRICKS.get()).craftableFrom(SMBBlocks.EMERALD_BRICKS.get())
        .create(SMBBlocks.EMERALD_PILLAR.get()).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(SMBBlocks.CUT_EMERALD.get()).craftableFrom(Blocks.EMERALD_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_EMERALD.get()).craftableFrom(SMBBlocks.CUT_EMERALD.get())
      ).build();

    RecipeAdvancement
      .group("Lapis Block Variations", (instance) -> instance
        .create(SMBBlocks.LAPIS_BRICKS.get()).craftableFrom(SMBBlocks.CUT_LAPIS.get())
        .create(SMBBlocks.CRACKED_LAPIS_BRICKS.get()).craftableFrom(SMBBlocks.LAPIS_BRICKS.get())
        .create(SMBBlocks.LAPIS_PILLAR.get()).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(SMBBlocks.CUT_LAPIS.get()).craftableFrom(Blocks.LAPIS_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_LAPIS.get()).craftableFrom(SMBBlocks.CUT_LAPIS.get())
      ).build();

    RecipeAdvancement
      .group("Diamond Block Variations", (instance) -> instance
        .create(SMBBlocks.DIAMOND_BRICKS.get()).craftableFrom(SMBBlocks.CUT_DIAMOND.get())
        .create(SMBBlocks.CRACKED_DIAMOND_BRICKS.get()).craftableFrom(SMBBlocks.DIAMOND_BRICKS.get())
        .create(SMBBlocks.DIAMOND_PILLAR.get()).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(SMBBlocks.CUT_DIAMOND.get()).craftableFrom(Blocks.DIAMOND_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_DIAMOND.get()).craftableFrom(SMBBlocks.CUT_DIAMOND.get())
        .create(SMBBlocks.DIAMOND_GRATE.get()).craftableFrom(Blocks.DIAMOND_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Netherite Block Variations", (instance) -> instance
        .create(SMBBlocks.NETHERITE_BRICKS.get()).craftableFrom(SMBBlocks.CUT_NETHERITE.get())
        .create(SMBBlocks.CRACKED_NETHERITE_BRICKS.get()).craftableFrom(SMBBlocks.NETHERITE_BRICKS.get())
        .create(SMBBlocks.NETHERITE_PILLAR.get()).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(SMBBlocks.CUT_NETHERITE.get()).craftableFrom(Blocks.NETHERITE_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_NETHERITE.get()).craftableFrom(SMBBlocks.CUT_NETHERITE.get())
        .create(SMBBlocks.NETHERITE_GRATE.get()).craftableFrom(Blocks.NETHERITE_BLOCK)
      ).build();

    RecipeAdvancement
      .group("Quartz Block Variations", (instance) -> instance
        .create(SMBBlocks.CRACKED_QUARTZ_BRICKS.get()).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(SMBBlocks.CUT_QUARTZ.get()).craftableFrom(Blocks.QUARTZ_BRICKS)
        .create(SMBBlocks.CRACKED_CUT_QUARTZ.get()).craftableFrom(SMBBlocks.CUT_QUARTZ.get())
      ).build();

    RecipeAdvancement
      .group("Amethyst Block Variations", (instance) -> instance
        .create(SMBBlocks.AMETHYST_BRICKS.get()).craftableFrom(SMBBlocks.CUT_AMETHYST.get())
        .create(SMBBlocks.CRACKED_AMETHYST_BRICKS.get()).craftableFrom(SMBBlocks.AMETHYST_BRICKS.get())
        .create(SMBBlocks.AMETHYST_PILLAR.get()).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(SMBBlocks.CUT_AMETHYST.get()).craftableFrom(Blocks.AMETHYST_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_AMETHYST.get()).craftableFrom(SMBBlocks.CUT_AMETHYST.get())
      ).build();

    RecipeAdvancement
      .group("Redstone Block Variations", (instance) -> instance
        .create(SMBBlocks.AMETHYST_BRICKS.get()).craftableFrom(SMBBlocks.CUT_REDSTONE.get())
        .create(SMBBlocks.CRACKED_REDSTONE_BRICKS.get()).craftableFrom(SMBBlocks.REDSTONE_BRICKS.get())
        .create(SMBBlocks.REDSTONE_PILLAR.get()).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(SMBBlocks.CUT_REDSTONE.get()).craftableFrom(Blocks.REDSTONE_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_REDSTONE.get()).craftableFrom(SMBBlocks.CUT_REDSTONE.get())
      ).build();

    RecipeAdvancement
      .group("Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(SMBBlocks.COPPER_BRICKS.get()).craftableFrom(Blocks.CUT_COPPER)
        .create(SMBBlocks.CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.COPPER_PILLAR.get()).craftableFrom(Blocks.COPPER_BLOCK)
        .create(SMBBlocks.CRACKED_CUT_COPPER.get()).craftableFrom(Blocks.CUT_COPPER)
        .create(SMBBlocks.EXPOSED_COPPER_BRICKS.get()).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.EXPOSED_COPPER_PILLAR.get()).craftableFrom(Blocks.EXPOSED_COPPER)
        .create(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get()).craftableFrom(Blocks.EXPOSED_CUT_COPPER)
        .create(SMBBlocks.WEATHERED_COPPER_BRICKS.get()).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.WEATHERED_COPPER_PILLAR.get()).craftableFrom(Blocks.WEATHERED_COPPER)
        .create(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get()).craftableFrom(Blocks.WEATHERED_CUT_COPPER)
        .create(SMBBlocks.OXIDIZED_COPPER_BRICKS.get()).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
        .create(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.OXIDIZED_COPPER_PILLAR.get()).craftableFrom(Blocks.OXIDIZED_COPPER)
        .create(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get()).craftableFrom(Blocks.OXIDIZED_CUT_COPPER)
      ).build();

    RecipeAdvancement
      .group("Waxed Copper Block Variations", (instance) -> instance
        .setExpectedEntries(16)
        .create(SMBBlocks.WAXED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_COPPER_PILLAR.get()).craftableFrom(SMBBlocks.COPPER_PILLAR.get())
        .create(SMBBlocks.WAXED_CRACKED_CUT_COPPER.get()).craftableFrom(SMBBlocks.CRACKED_CUT_COPPER.get())
        .create(SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.EXPOSED_COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get()).craftableFrom(SMBBlocks.EXPOSED_COPPER_PILLAR.get())
        .create(SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get()).craftableFrom(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get())
        .create(SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.WEATHERED_COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get()).craftableFrom(SMBBlocks.WEATHERED_COPPER_PILLAR.get())
        .create(SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get()).craftableFrom(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get())
        .create(SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.OXIDIZED_COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get()).craftableFrom(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get())
        .create(SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get()).craftableFrom(SMBBlocks.OXIDIZED_COPPER_PILLAR.get())
        .create(SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get()).craftableFrom(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get())
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
        .create(SMBBlocks.BONE_BRICKS.get()).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK)
        .create(SMBBlocks.CRACKED_BONE_BRICKS.get()).craftableFrom(SMBBlocks.BONE_BRICKS.get())
        .create(SMBBlocks.BONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.BONE_BRICKS.get()).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get())
        .create(SMBBlocks.BONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.BONE_BRICKS.get()).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get())
        .create(SMBBlocks.BONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.BONE_BRICKS.get()).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get())
        .create(SMBBlocks.BONE_TILES.get()).craftableFrom(Blocks.BONE_BLOCK).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get())
        .create(SMBBlocks.CRACKED_BONE_TILES.get()).craftableFrom(SMBBlocks.BONE_TILES.get())
        .create(SMBBlocks.BONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.BONE_TILES.get()).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get(), SMBBlocks.BONE_TILES.get())
        .create(SMBBlocks.BONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.BONE_TILES.get()).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get(), SMBBlocks.BONE_TILES.get())
        .create(SMBBlocks.BONE_TILE_WALL.get()).craftableFrom(SMBBlocks.BONE_TILES.get()).cuttableFrom(Blocks.BONE_BLOCK, SMBBlocks.BONE_BRICKS.get(), SMBBlocks.BONE_TILES.get())
      ).build();

    RecipeAdvancement
      .group("Bone Block Variations", (instance) -> instance
          .create(SMBBlocks.SOUL_SANDSTONE.get()).craftableFrom(Blocks.SOUL_SAND, Blocks.SOUL_SOIL)
          .create(SMBBlocks.SOUL_SANDSTONE_STAIRS.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get())
          .create(SMBBlocks.SOUL_SANDSTONE_SLAB.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get())
          .create(SMBBlocks.SOUL_SANDSTONE_WALL.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get())
          .create(SMBBlocks.CHISELED_SOUL_SANDSTONE.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_SLAB.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get())
          .create(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).craftableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get())
          .create(SMBBlocks.CRACKED_SOUL_SANDSTONE_BRICKS.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS.get())
          .create(SMBBlocks.SOUL_SANDSTONE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get())
          .create(SMBBlocks.SOUL_SANDSTONE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get())
          .create(SMBBlocks.SOUL_SANDSTONE_BRICK_WALL.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get())
          .create(SMBBlocks.SOUL_SANDSTONE_PILLAR.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get())
          .create(SMBBlocks.SOUL_SANDSTONE_TILES.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get())
          .create(SMBBlocks.CRACKED_SOUL_SANDSTONE_TILES.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_BRICKS.get())
          .create(SMBBlocks.SOUL_SANDSTONE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_TILES.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get(), SMBBlocks.SOUL_SANDSTONE_TILES.get())
          .create(SMBBlocks.SOUL_SANDSTONE_TILE_SLAB.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_TILES.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get(), SMBBlocks.SOUL_SANDSTONE_TILES.get())
          .create(SMBBlocks.SOUL_SANDSTONE_TILE_WALL.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE_TILES.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.SOUL_SANDSTONE_BRICKS.get(), SMBBlocks.SOUL_SANDSTONE_TILES.get())
          .create(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE.get())
          .create(SMBBlocks.SMOOTH_SOUL_SANDSTONE_SLAB.get()).craftableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get())
          .create(SMBBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS.get()).craftableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get())

          .create(SMBBlocks.CUT_SOUL_SANDSTONE.get()).craftableFrom(SMBBlocks.SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get())
          .create(SMBBlocks.CUT_SOUL_SANDSTONE_SLAB.get()).craftableFrom(SMBBlocks.CUT_SOUL_SANDSTONE.get()).cuttableFrom(SMBBlocks.SOUL_SANDSTONE.get(), SMBBlocks.CUT_SOUL_SANDSTONE.get())
        //.create(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).craftableFrom(Blocks.VINE, Blocks.MOSS_BLOCK)
        //.create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_STAIRS).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)
        //.create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_SLAB).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)
        //.create(MBItems.MOSSY_SOUL_SANDSTONE_BRICK_WALL).craftableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS).cuttableFrom(MBItems.MOSSY_SOUL_SANDSTONE_BRICKS)
      ).build();

    RecipeAdvancement
      .group("Snow Block Variations", (instance) -> instance
          .create(SMBBlocks.PACKED_SNOW.get()).craftableFrom(Blocks.SNOW_BLOCK)
          .create(SMBBlocks.PACKED_SNOW_STAIRS.get()).craftableFrom(SMBBlocks.PACKED_SNOW.get())
          .create(SMBBlocks.PACKED_SNOW_SLAB.get()).craftableFrom(SMBBlocks.PACKED_SNOW.get())
          .create(SMBBlocks.POLISHED_SNOW.get()).craftableFrom(SMBBlocks.PACKED_SNOW.get())
          .create(SMBBlocks.POLISHED_SNOW_STAIRS.get()).craftableFrom(SMBBlocks.PACKED_SNOW.get())
          .create(SMBBlocks.POLISHED_SNOW_SLAB.get()).craftableFrom(SMBBlocks.PACKED_SNOW.get())
          .create(SMBBlocks.SNOW_BRICKS.get()).craftableFrom(SMBBlocks.POLISHED_SNOW_SLAB.get())
//.create(MBItems.CRACKED_SNOW_BRICKS).craftableFrom(MBItems.POLISHED_SNOW_SLAB)
          .create(SMBBlocks.SNOW_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.SNOW_BRICKS.get())
          .create(SMBBlocks.SNOW_BRICK_SLAB.get()).craftableFrom(SMBBlocks.SNOW_BRICKS.get())
          .create(SMBBlocks.SNOW_BRICK_WALL.get()).craftableFrom(SMBBlocks.SNOW_BRICKS.get())
          .create(SMBBlocks.SNOW_PILLAR.get()).craftableFrom(SMBBlocks.SNOW_BRICKS.get())
          .create(SMBBlocks.SNOW_TILES.get()).craftableFrom(SMBBlocks.SNOW_BRICKS.get())
//.create(MBItems.CRACKED_SNOW_TILES).craftableFrom(MBItems.SNOW_TILES)
          .create(SMBBlocks.SNOW_TILE_STAIRS.get()).craftableFrom(SMBBlocks.SNOW_TILES.get())
          .create(SMBBlocks.SNOW_TILE_SLAB.get()).craftableFrom(SMBBlocks.SNOW_TILES.get())
          .create(SMBBlocks.SNOW_TILE_WALL.get()).craftableFrom(SMBBlocks.SNOW_TILES.get())
      ).build();

    RecipeAdvancement
      .group("Packed Ice Block Variations", (instance) -> instance
          .create(SMBBlocks.POLISHED_ICE.get()).cuttableFrom(Blocks.PACKED_ICE)
          .create(SMBBlocks.POLISHED_ICE_STAIRS.get()).craftableFrom(SMBBlocks.POLISHED_ICE.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get())
          .create(SMBBlocks.POLISHED_ICE_SLAB.get()).craftableFrom(SMBBlocks.POLISHED_ICE.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get())
          .create(SMBBlocks.ICE_BRICKS.get()).craftableFrom(Blocks.PACKED_ICE).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get())
//.create(MBItems.CRACKED_ICE_BRICKS).craftableFrom(MBItems.ICE_BRICKS)
          .create(SMBBlocks.ICE_BRICK_STAIRS.get()).craftableFrom(SMBBlocks.ICE_BRICKS.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get())
          .create(SMBBlocks.ICE_BRICK_SLAB.get()).craftableFrom(SMBBlocks.ICE_BRICKS.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get())
          .create(SMBBlocks.ICE_BRICK_WALL.get()).craftableFrom(SMBBlocks.ICE_BRICKS.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get())
          .create(SMBBlocks.ICE_PILLAR.get()).craftableFrom(SMBBlocks.ICE_BRICKS.get()).cuttableFrom(Blocks.PACKED_ICE)
          .create(SMBBlocks.ICE_TILES.get()).craftableFrom(SMBBlocks.ICE_BRICKS.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get())
//.create(MBItems.CRACKED_ICE_TILES).craftableFrom(MBItems.ICE_TILES)
          .create(SMBBlocks.ICE_TILE_STAIRS.get()).craftableFrom(SMBBlocks.ICE_TILES.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get(), SMBBlocks.ICE_TILES.get())
          .create(SMBBlocks.ICE_TILE_SLAB.get()).craftableFrom(SMBBlocks.ICE_TILES.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get(), SMBBlocks.ICE_TILES.get())
          .create(SMBBlocks.ICE_TILE_WALL.get()).craftableFrom(SMBBlocks.ICE_TILES.get()).cuttableFrom(Blocks.PACKED_ICE, SMBBlocks.POLISHED_ICE.get(), SMBBlocks.ICE_BRICKS.get(), SMBBlocks.ICE_TILES.get())
      ).build();

    RecipeAdvancement
      .group("Tiled Glasses Variation", (instance) -> instance
        .create(SMBBlocks.TILED_GLASS.get()).craftableFrom(Blocks.GLASS)
        .create(SMBBlocks.TILED_TINTED_GLASS.get()).craftableFrom(Blocks.TINTED_GLASS)
        .create(SMBBlocks.WHITE_STAINED_TILED_GLASS.get()).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_STAINED_GLASS)
        .create(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get()).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_STAINED_GLASS)
        .create(SMBBlocks.GRAY_STAINED_TILED_GLASS.get()).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_STAINED_GLASS)
        .create(SMBBlocks.BLACK_STAINED_TILED_GLASS.get()).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_STAINED_GLASS)
        .create(SMBBlocks.BROWN_STAINED_TILED_GLASS.get()).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_STAINED_GLASS)
        .create(SMBBlocks.RED_STAINED_TILED_GLASS.get()).craftableFrom(Items.RED_DYE, Blocks.RED_STAINED_GLASS)
        .create(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get()).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_STAINED_GLASS)
        .create(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get()).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_STAINED_GLASS)
        .create(SMBBlocks.LIME_STAINED_TILED_GLASS.get()).craftableFrom(Items.LIME_DYE, Blocks.LIME_STAINED_GLASS)
        .create(SMBBlocks.GREEN_STAINED_TILED_GLASS.get()).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_STAINED_GLASS)
        .create(SMBBlocks.CYAN_STAINED_TILED_GLASS.get()).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_STAINED_GLASS)
        .create(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get()).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_STAINED_GLASS)
        .create(SMBBlocks.BLUE_STAINED_TILED_GLASS.get()).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_STAINED_GLASS)
        .create(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get()).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_STAINED_GLASS)
        .create(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get()).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_STAINED_GLASS)
        .create(SMBBlocks.PINK_STAINED_TILED_GLASS.get()).craftableFrom(Items.PINK_DYE, Blocks.PINK_STAINED_GLASS)
      ).build();

    RecipeAdvancement
      .group("Shingles Variation", (instance) -> instance
        .create(SMBBlocks.SHINGLES.get()).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(SMBBlocks.WHITE_SHINGLES.get()).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(SMBBlocks.LIGHT_GRAY_SHINGLES.get()).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(SMBBlocks.GRAY_SHINGLES.get()).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(SMBBlocks.BLACK_SHINGLES.get()).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(SMBBlocks.BROWN_SHINGLES.get()).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(SMBBlocks.RED_SHINGLES.get()).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(SMBBlocks.ORANGE_SHINGLES.get()).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(SMBBlocks.YELLOW_SHINGLES.get()).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(SMBBlocks.LIME_SHINGLES.get()).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(SMBBlocks.GREEN_SHINGLES.get()).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(SMBBlocks.CYAN_SHINGLES.get()).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(SMBBlocks.LIGHT_BLUE_SHINGLES.get()).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(SMBBlocks.BLUE_SHINGLES.get()).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(SMBBlocks.PURPLE_SHINGLES.get()).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(SMBBlocks.MAGENTA_SHINGLES.get()).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(SMBBlocks.PINK_SHINGLES.get()).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Bricks Variation", (instance) -> instance
        .create(SMBBlocks.TERRACOTTA_BRICKS.get()).craftableFrom(Blocks.TERRACOTTA).cuttableFrom(Blocks.TERRACOTTA)
        .create(SMBBlocks.WHITE_TERRACOTTA_BRICKS.get()).craftableFrom(Items.WHITE_DYE, Blocks.WHITE_TERRACOTTA).cuttableFrom(Blocks.WHITE_TERRACOTTA)
        .create(SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get()).craftableFrom(Items.LIGHT_GRAY_DYE, Blocks.LIGHT_GRAY_TERRACOTTA).cuttableFrom(Blocks.LIGHT_GRAY_TERRACOTTA)
        .create(SMBBlocks.GRAY_TERRACOTTA_BRICKS.get()).craftableFrom(Items.GRAY_DYE, Blocks.GRAY_TERRACOTTA).cuttableFrom(Blocks.GRAY_TERRACOTTA)
        .create(SMBBlocks.BLACK_TERRACOTTA_BRICKS.get()).craftableFrom(Items.BLACK_DYE, Blocks.BLACK_TERRACOTTA).cuttableFrom(Blocks.BLACK_TERRACOTTA)
        .create(SMBBlocks.BROWN_TERRACOTTA_BRICKS.get()).craftableFrom(Items.BROWN_DYE, Blocks.BROWN_TERRACOTTA).cuttableFrom(Blocks.BROWN_TERRACOTTA)
        .create(SMBBlocks.RED_TERRACOTTA_BRICKS.get()).craftableFrom(Items.RED_DYE, Blocks.RED_TERRACOTTA).cuttableFrom(Blocks.RED_TERRACOTTA)
        .create(SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get()).craftableFrom(Items.ORANGE_DYE, Blocks.ORANGE_TERRACOTTA).cuttableFrom(Blocks.ORANGE_TERRACOTTA)
        .create(SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get()).craftableFrom(Items.YELLOW_DYE, Blocks.YELLOW_TERRACOTTA).cuttableFrom(Blocks.YELLOW_TERRACOTTA)
        .create(SMBBlocks.LIME_TERRACOTTA_BRICKS.get()).craftableFrom(Items.LIME_DYE, Blocks.LIME_TERRACOTTA).cuttableFrom(Blocks.LIME_TERRACOTTA)
        .create(SMBBlocks.GREEN_TERRACOTTA_BRICKS.get()).craftableFrom(Items.GREEN_DYE, Blocks.GREEN_TERRACOTTA).cuttableFrom(Blocks.GREEN_TERRACOTTA)
        .create(SMBBlocks.CYAN_TERRACOTTA_BRICKS.get()).craftableFrom(Items.CYAN_DYE, Blocks.CYAN_TERRACOTTA).cuttableFrom(Blocks.CYAN_TERRACOTTA)
        .create(SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get()).craftableFrom(Items.LIGHT_BLUE_DYE, Blocks.LIGHT_BLUE_TERRACOTTA).cuttableFrom(Blocks.LIGHT_BLUE_TERRACOTTA)
        .create(SMBBlocks.BLUE_TERRACOTTA_BRICKS.get()).craftableFrom(Items.BLUE_DYE, Blocks.BLUE_TERRACOTTA).cuttableFrom(Blocks.BLUE_TERRACOTTA)
        .create(SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get()).craftableFrom(Items.PURPLE_DYE, Blocks.PURPLE_TERRACOTTA).cuttableFrom(Blocks.PURPLE_TERRACOTTA)
        .create(SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get()).craftableFrom(Items.MAGENTA_DYE, Blocks.MAGENTA_TERRACOTTA).cuttableFrom(Blocks.MAGENTA_TERRACOTTA)
        .create(SMBBlocks.PINK_TERRACOTTA_BRICKS.get()).craftableFrom(Items.PINK_DYE, Blocks.PINK_TERRACOTTA).cuttableFrom(Blocks.PINK_TERRACOTTA)
      ).build();

    RecipeAdvancement
      .group("Terracotta Tiles Variation", (instance) -> instance
        .create(SMBBlocks.TERRACOTTA_TILES.get()).craftableFrom(SMBBlocks.TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.WHITE_TERRACOTTA_TILES.get()).craftableFrom(Items.WHITE_DYE, SMBBlocks.WHITE_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.WHITE_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get()).craftableFrom(Items.LIGHT_GRAY_DYE, SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.GRAY_TERRACOTTA_TILES.get()).craftableFrom(Items.GRAY_DYE, SMBBlocks.GRAY_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.GRAY_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.BLACK_TERRACOTTA_TILES.get()).craftableFrom(Items.BLACK_DYE, SMBBlocks.BLACK_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.BLACK_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.BROWN_TERRACOTTA_TILES.get()).craftableFrom(Items.BROWN_DYE, SMBBlocks.BROWN_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.BROWN_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.RED_TERRACOTTA_TILES.get()).craftableFrom(Items.RED_DYE, SMBBlocks.RED_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.RED_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.ORANGE_TERRACOTTA_TILES.get()).craftableFrom(Items.ORANGE_DYE, SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.ORANGE_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.YELLOW_TERRACOTTA_TILES.get()).craftableFrom(Items.YELLOW_DYE, SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.YELLOW_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.LIME_TERRACOTTA_TILES.get()).craftableFrom(Items.LIME_DYE, SMBBlocks.LIME_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.LIME_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.GREEN_TERRACOTTA_TILES.get()).craftableFrom(Items.GREEN_DYE, SMBBlocks.GREEN_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.GREEN_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.CYAN_TERRACOTTA_TILES.get()).craftableFrom(Items.CYAN_DYE, SMBBlocks.CYAN_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.CYAN_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get()).craftableFrom(Items.LIGHT_BLUE_DYE, SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.BLUE_TERRACOTTA_TILES.get()).craftableFrom(Items.BLUE_DYE, SMBBlocks.BLUE_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.BLUE_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.PURPLE_TERRACOTTA_TILES.get()).craftableFrom(Items.PURPLE_DYE, SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.PURPLE_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.MAGENTA_TERRACOTTA_TILES.get()).craftableFrom(Items.MAGENTA_DYE, SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.MAGENTA_TERRACOTTA_BRICKS.get())
        .create(SMBBlocks.PINK_TERRACOTTA_TILES.get()).craftableFrom(Items.PINK_DYE, SMBBlocks.PINK_TERRACOTTA_BRICKS.get()).cuttableFrom(SMBBlocks.PINK_TERRACOTTA_BRICKS.get())
      ).build();

    RecipeAdvancement
      .group("Concrete Bricks Variation", (instance) -> instance
        .create(SMBBlocks.WHITE_CONCRETE_BRICKS.get()).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(SMBBlocks.LIGHT_GRAY_CONCRETE_BRICKS.get()).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(SMBBlocks.GRAY_CONCRETE_BRICKS.get()).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(SMBBlocks.BLACK_CONCRETE_BRICKS.get()).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(SMBBlocks.BROWN_CONCRETE_BRICKS.get()).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(SMBBlocks.RED_CONCRETE_BRICKS.get()).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(SMBBlocks.ORANGE_CONCRETE_BRICKS.get()).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(SMBBlocks.YELLOW_CONCRETE_BRICKS.get()).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(SMBBlocks.LIME_CONCRETE_BRICKS.get()).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(SMBBlocks.GREEN_CONCRETE_BRICKS.get()).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(SMBBlocks.CYAN_CONCRETE_BRICKS.get()).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(SMBBlocks.LIGHT_BLUE_CONCRETE_BRICKS.get()).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(SMBBlocks.BLUE_CONCRETE_BRICKS.get()).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(SMBBlocks.PURPLE_CONCRETE_BRICKS.get()).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(SMBBlocks.MAGENTA_CONCRETE_BRICKS.get()).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(SMBBlocks.PINK_CONCRETE_BRICKS.get()).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Concrete Tiles Variation", (instance) -> instance
        .create(SMBBlocks.WHITE_CONCRETE_TILES.get()).craftableFrom(Blocks.WHITE_CONCRETE).cuttableFrom(Blocks.WHITE_CONCRETE)
        .create(SMBBlocks.LIGHT_GRAY_CONCRETE_TILES.get()).craftableFrom(Blocks.LIGHT_GRAY_CONCRETE).cuttableFrom(Blocks.LIGHT_GRAY_CONCRETE)
        .create(SMBBlocks.GRAY_CONCRETE_TILES.get()).craftableFrom(Blocks.GRAY_CONCRETE).cuttableFrom(Blocks.GRAY_CONCRETE)
        .create(SMBBlocks.BLACK_CONCRETE_TILES.get()).craftableFrom(Blocks.BLACK_CONCRETE).cuttableFrom(Blocks.BLACK_CONCRETE)
        .create(SMBBlocks.BROWN_CONCRETE_TILES.get()).craftableFrom(Blocks.BROWN_CONCRETE).cuttableFrom(Blocks.BROWN_CONCRETE)
        .create(SMBBlocks.RED_CONCRETE_TILES.get()).craftableFrom(Blocks.RED_CONCRETE).cuttableFrom(Blocks.RED_CONCRETE)
        .create(SMBBlocks.ORANGE_CONCRETE_TILES.get()).craftableFrom(Blocks.ORANGE_CONCRETE).cuttableFrom(Blocks.ORANGE_CONCRETE)
        .create(SMBBlocks.YELLOW_CONCRETE_TILES.get()).craftableFrom(Blocks.YELLOW_CONCRETE).cuttableFrom(Blocks.YELLOW_CONCRETE)
        .create(SMBBlocks.LIME_CONCRETE_TILES.get()).craftableFrom(Blocks.LIME_CONCRETE).cuttableFrom(Blocks.LIME_CONCRETE)
        .create(SMBBlocks.GREEN_CONCRETE_TILES.get()).craftableFrom(Blocks.GREEN_CONCRETE).cuttableFrom(Blocks.GREEN_CONCRETE)
        .create(SMBBlocks.CYAN_CONCRETE_TILES.get()).craftableFrom(Blocks.CYAN_CONCRETE).cuttableFrom(Blocks.CYAN_CONCRETE)
        .create(SMBBlocks.LIGHT_BLUE_CONCRETE_TILES.get()).craftableFrom(Blocks.LIGHT_BLUE_CONCRETE).cuttableFrom(Blocks.LIGHT_BLUE_CONCRETE)
        .create(SMBBlocks.BLUE_CONCRETE_TILES.get()).craftableFrom(Blocks.BLUE_CONCRETE).cuttableFrom(Blocks.BLUE_CONCRETE)
        .create(SMBBlocks.PURPLE_CONCRETE_TILES.get()).craftableFrom(Blocks.PURPLE_CONCRETE).cuttableFrom(Blocks.PURPLE_CONCRETE)
        .create(SMBBlocks.MAGENTA_CONCRETE_TILES.get()).craftableFrom(Blocks.MAGENTA_CONCRETE).cuttableFrom(Blocks.MAGENTA_CONCRETE)
        .create(SMBBlocks.PINK_CONCRETE_TILES.get()).craftableFrom(Blocks.PINK_CONCRETE).cuttableFrom(Blocks.PINK_CONCRETE)
      ).build();

    RecipeAdvancement
      .group("Redstone Froglight Lamp", (instance) -> instance
        .create(SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get()).craftableFrom(Items.OCHRE_FROGLIGHT)
        .create(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get()).craftableFrom(Items.VERDANT_FROGLIGHT)
        .create(SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get()).craftableFrom(Items.PEARLESCENT_FROGLIGHT)
      ).build();
  }
}
