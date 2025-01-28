package net.seface.somemoreblocks.registries;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.Constants;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.block.*;
import net.seface.somemoreblocks.item.FuelBlockItem;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class SMBBlocks {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeMoreBlocks.ID);

  public static final RegistryObject<Block> AZALEA_LEAF_LITTER = registerBlock("azalea_leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA_LEAVES).replaceable().noCollission().instabreak(), Constants.AZALEA_LEAF_LITTER_CHANCE), false);
  public static final RegistryObject<Block> BIRCH_LEAF_LITTER = registerBlock("birch_leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_LEAVES).replaceable().noCollission().instabreak(), Constants.BIRCH_LEAF_LITTER_CHANCE), false);
  public static final RegistryObject<Block> BIG_LILY_PAD = registerBlock("big_lily_pad", () -> new BigLilyPadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).pushReaction(PushReaction.BLOCK)), false);
  public static final RegistryObject<Block> BROWN_MUSHROOM_COLONY = registerBlock("brown_mushroom_colony", () -> new MushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)), false);
  public static final RegistryObject<Block> TALL_BROWN_MUSHROOM_COLONY = registerBlock("tall_brown_mushroom_colony", () -> new DoubleMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)), false);
  public static final RegistryObject<Block> BROWN_MUSHROOM_COLONY_WALL = registerBlock("brown_mushroom_colony_wall", () -> new WallMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BROWN_MUSHROOM_COLONY.get())), false);
  public static final RegistryObject<Block> CATTAIL = registerBlock("cattail", () -> new CattailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).noCollission()));
  public static final RegistryObject<Block> CRIMSON_FUNGUS_COLONY = registerBlock("crimson_fungus_colony", () -> new MushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FUNGUS)), false);
  public static final RegistryObject<Block> TALL_CRIMSON_FUNGUS_COLONY = registerBlock("tall_crimson_fungus_colony", () -> new DoubleMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_FUNGUS)), false);
  public static final RegistryObject<Block> CRIMSON_FUNGUS_COLONY_WALL = registerBlock("crimson_fungus_colony_wall", () -> new WallMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CRIMSON_FUNGUS_COLONY.get())), false);
  public static final RegistryObject<Block> FLOWERING_AZALEA_LEAF_LITTER = registerBlock("flowering_azalea_leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWERING_AZALEA_LEAVES).replaceable().noCollission().instabreak(), Constants.FLOWERING_AZALEA_LEAF_LITTER_CHANCE), false);
  public static final RegistryObject<Block> SPRUCE_LEAF_LITTER = registerBlock("spruce_leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES).replaceable().noCollission().instabreak(), Constants.SPRUCE_LEAF_LITTER_CHANCE), false);
  public static final RegistryObject<Block> LEAF_LITTER = registerBlock("leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).replaceable().noCollission().instabreak(), Constants.LEAF_LITTER_CHANCE), false);
  public static final RegistryObject<Block> LUMINOUS_FLOWER = registerBlock("luminous_flower", () -> new LuminousFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION).lightLevel((blockStatex) -> Constants.LUMINOUS_FLOWER_LIGHT_LEVEL)));
  public static final RegistryObject<Block> RED_MUSHROOM_COLONY = registerBlock("red_mushroom_colony", () -> new MushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)), false);
  public static final RegistryObject<Block> TALL_RED_MUSHROOM_COLONY = registerBlock("tall_red_mushroom_colony", () -> new DoubleMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)), false);
  public static final RegistryObject<Block> RED_MUSHROOM_COLONY_WALL = registerBlock("red_mushroom_colony_wall", () -> new WallMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.RED_MUSHROOM_COLONY.get())), false);
  public static final RegistryObject<Block> SMALL_LILY_PADS = registerBlock("small_lily_pads", () -> new WaterlilyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).noCollission()), false);
  public static final RegistryObject<Block> TALL_DUNE_GRASS = registerBlock("tall_dune_grass", () -> new DoubleDuneGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
  public static final RegistryObject<Block> DUNE_GRASS = registerBlock("dune_grass", () -> new GenericBonemealableBushBlock(SMBBlocks.TALL_DUNE_GRASS.get(), SMBBlockTags.DUNE_GRASS_PLACEABLE, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
  public static final RegistryObject<Block> LARGE_SNOW_FERN = registerBlock("large_snow_fern", () -> new DoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LARGE_FERN)));
  public static final RegistryObject<Block> SNOW_FERN = registerBlock("snow_fern", () -> new GenericBonemealableBushBlock(SMBBlocks.LARGE_SNOW_FERN.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.FERN)));
  public static final RegistryObject<Block> TALL_SNOW_GRASS = registerBlock("tall_snow_grass", () -> new DoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
  public static final RegistryObject<Block> SHORT_SNOW_GRASS = registerBlock("short_snow_grass", () -> new GenericBonemealableBushBlock(SMBBlocks.TALL_SNOW_GRASS.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS)));
  public static final RegistryObject<Block> TINY_CACTUS = registerBlock("tiny_cactus", () -> new TinyCactusBlock(MobEffects.POISON, 7, BlockBehaviour.Properties.ofFullCopy(Blocks.TORCHFLOWER)));
  public static final RegistryObject<Block> WARPED_FUNGUS_COLONY = registerBlock("warped_fungus_colony", () -> new MushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS)), false);
  public static final RegistryObject<Block> TALL_WARPED_FUNGUS_COLONY = registerBlock("tall_warped_fungus_colony", () -> new DoubleMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS)), false);
  public static final RegistryObject<Block> WARPED_FUNGUS_COLONY_WALL = registerBlock("warped_fungus_colony_wall", () -> new WallMushroomColonyBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WARPED_FUNGUS_COLONY.get())), false);
  public static final RegistryObject<Block> POTTED_LUMINOUS_FLOWER = createAndRegisterFlowerPotBlock("potted_luminous_flower", SMBBlocks.LUMINOUS_FLOWER, Constants.POTTED_LUMINOUS_FLOWER_LIGHT_LEVEL);
  public static final RegistryObject<Block> POTTED_SNOW_FERN = createAndRegisterFlowerPotBlock("potted_snow_fern", SMBBlocks.SNOW_FERN);
  public static final RegistryObject<Block> POTTED_TINY_CACTUS = createAndRegisterFlowerPotBlock("potted_tiny_cactus", SMBBlocks.TINY_CACTUS);
  public static final RegistryObject<Block> OCHRE_REDSTONE_FROGLIGHT = registerBlock("ochre_redstone_froglight", () -> new RedstoneLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.FROGLIGHT)));
  public static final RegistryObject<Block> PEARLESCENT_REDSTONE_FROGLIGHT = registerBlock("pearlescent_redstone_froglight", () -> new RedstoneLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.FROGLIGHT)));
  public static final RegistryObject<Block> VERDANT_REDSTONE_FROGLIGHT = registerBlock("verdant_redstone_froglight", () -> new RedstoneLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.FROGLIGHT)));
  public static final RegistryObject<Block> PACKED_SNOW = registerBlock("packed_snow", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
  public static final RegistryObject<Block> PACKED_SNOW_SLAB = registerBlock("packed_snow_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PACKED_SNOW.get())));
  public static final RegistryObject<Block> PACKED_SNOW_STAIRS = registerBlock("packed_snow_stairs", () -> new StairBlock(PACKED_SNOW.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PACKED_SNOW.get())));
  public static final RegistryObject<Block> POLISHED_SNOW = registerBlock("polished_snow", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
  public static final RegistryObject<Block> POLISHED_SNOW_SLAB = registerBlock("polished_snow_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_SNOW.get())));
  public static final RegistryObject<Block> POLISHED_SNOW_STAIRS = registerBlock("polished_snow_stairs", () -> new StairBlock(POLISHED_SNOW.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_SNOW.get())));
  public static final RegistryObject<Block> SNOW_BRICKS = registerBlock("snow_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
  public static final RegistryObject<Block> SNOW_BRICK_SLAB = registerBlock("snow_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SNOW_BRICKS.get())));
  public static final RegistryObject<Block> SNOW_BRICK_STAIRS = registerBlock("snow_brick_stairs", () -> new StairBlock(SNOW_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SNOW_BRICKS.get())));
  public static final RegistryObject<Block> SNOW_BRICK_WALL = registerBlock("snow_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SNOW_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_SNOW_BRICKS = registerBlock("cracked_snow_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
  public static final RegistryObject<Block> SNOW_TILES = registerBlock("snow_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
  public static final RegistryObject<Block> SNOW_TILE_SLAB = registerBlock("snow_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SNOW_TILES.get())));
  public static final RegistryObject<Block> SNOW_TILE_STAIRS = registerBlock("snow_tile_stairs", () -> new StairBlock(SNOW_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SNOW_TILES.get())));
  public static final RegistryObject<Block> SNOW_TILE_WALL = registerBlock("snow_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SNOW_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_SNOW_TILES = registerBlock("cracked_snow_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
  public static final RegistryObject<Block> SNOW_PILLAR = registerBlock("snow_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SNOW_BLOCK)));
  public static final RegistryObject<Block> SMOOTH_DEEPSLATE = registerBlock("smooth_deepslate", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
  public static final RegistryObject<Block> SMOOTH_DEEPSLATE_SLAB = registerBlock("smooth_deepslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_DEEPSLATE.get())));
  public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICKS = registerBlock("mossy_deepslate_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)));
  public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_SLAB = registerBlock("mossy_deepslate_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_STAIRS = registerBlock("mossy_deepslate_brick_stairs", () -> new StairBlock(MOSSY_DEEPSLATE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_WALL = registerBlock("mossy_deepslate_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DEEPSLATE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> DEEPSLATE_PILLAR = registerBlock("deepslate_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_BRICKS)));
  public static final RegistryObject<Block> POLISHED_STONE = registerBlock("polished_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
  public static final RegistryObject<Block> POLISHED_STONE_SLAB = registerBlock("polished_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_STONE.get())));
  public static final RegistryObject<Block> POLISHED_STONE_STAIRS = registerBlock("polished_stone_stairs", () -> new StairBlock(POLISHED_STONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_STONE.get())));
  public static final RegistryObject<Block> STONE_TILES = registerBlock("stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
  public static final RegistryObject<Block> STONE_TILE_SLAB = registerBlock("stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.STONE_TILES.get())));
  public static final RegistryObject<Block> STONE_TILE_STAIRS = registerBlock("stone_tile_stairs", () -> new StairBlock(STONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.STONE_TILES.get())));
  public static final RegistryObject<Block> STONE_TILE_WALL = registerBlock("stone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.STONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_STONE_TILES = registerBlock("cracked_stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
  public static final RegistryObject<Block> STONE_PILLAR = registerBlock("stone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
  public static final RegistryObject<Block> SMOOTH_GRANITE = registerBlock("smooth_granite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> SMOOTH_GRANITE_SLAB = registerBlock("smooth_granite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_GRANITE.get())));
  public static final RegistryObject<Block> CHISELED_GRANITE_BRICKS = registerBlock("chiseled_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> GRANITE_BRICKS = registerBlock("granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> GRANITE_BRICK_SLAB = registerBlock("granite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.GRANITE_BRICKS.get())));
  public static final RegistryObject<Block> GRANITE_BRICK_STAIRS = registerBlock("granite_brick_stairs", () -> new StairBlock(GRANITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.GRANITE_BRICKS.get())));
  public static final RegistryObject<Block> GRANITE_BRICK_WALL = registerBlock("granite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.GRANITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_GRANITE_BRICKS = registerBlock("cracked_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> MOSSY_GRANITE_BRICKS = registerBlock("mossy_granite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> MOSSY_GRANITE_BRICK_SLAB = registerBlock("mossy_granite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_GRANITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_GRANITE_BRICK_STAIRS = registerBlock("mossy_granite_brick_stairs", () -> new StairBlock(MOSSY_GRANITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_GRANITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_GRANITE_BRICK_WALL = registerBlock("mossy_granite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_GRANITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> GRANITE_TILES = registerBlock("granite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> GRANITE_TILE_SLAB = registerBlock("granite_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.GRANITE_TILES.get())));
  public static final RegistryObject<Block> GRANITE_TILE_STAIRS = registerBlock("granite_tile_stairs", () -> new StairBlock(GRANITE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.GRANITE_TILES.get())));
  public static final RegistryObject<Block> GRANITE_TILE_WALL = registerBlock("granite_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.GRANITE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_GRANITE_TILES = registerBlock("cracked_granite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> GRANITE_PILLAR = registerBlock("granite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
  public static final RegistryObject<Block> SMOOTH_DIORITE = registerBlock("smooth_diorite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> SMOOTH_DIORITE_SLAB = registerBlock("smooth_diorite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_DIORITE.get())));
  public static final RegistryObject<Block> CHISELED_DIORITE_BRICKS = registerBlock("chiseled_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> DIORITE_BRICKS = registerBlock("diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> DIORITE_BRICK_SLAB = registerBlock("diorite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DIORITE_BRICKS.get())));
  public static final RegistryObject<Block> DIORITE_BRICK_STAIRS = registerBlock("diorite_brick_stairs", () -> new StairBlock(DIORITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DIORITE_BRICKS.get())));
  public static final RegistryObject<Block> DIORITE_BRICK_WALL = registerBlock("diorite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DIORITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_DIORITE_BRICKS = registerBlock("cracked_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> MOSSY_DIORITE_BRICKS = registerBlock("mossy_diorite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> MOSSY_DIORITE_BRICK_SLAB = registerBlock("mossy_diorite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DIORITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_DIORITE_BRICK_STAIRS = registerBlock("mossy_diorite_brick_stairs", () -> new StairBlock(MOSSY_DIORITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DIORITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_DIORITE_BRICK_WALL = registerBlock("mossy_diorite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DIORITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> DIORITE_TILES = registerBlock("diorite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> DIORITE_TILE_SLAB = registerBlock("diorite_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DIORITE_TILES.get())));
  public static final RegistryObject<Block> DIORITE_TILE_STAIRS = registerBlock("diorite_tile_stairs", () -> new StairBlock(DIORITE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DIORITE_TILES.get())));
  public static final RegistryObject<Block> DIORITE_TILE_WALL = registerBlock("diorite_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DIORITE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_DIORITE_TILES = registerBlock("cracked_diorite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> DIORITE_PILLAR = registerBlock("diorite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
  public static final RegistryObject<Block> SMOOTH_ANDESITE = registerBlock("smooth_andesite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> SMOOTH_ANDESITE_SLAB = registerBlock("smooth_andesite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_ANDESITE.get())));
  public static final RegistryObject<Block> CHISELED_ANDESITE_BRICKS = registerBlock("chiseled_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> ANDESITE_BRICKS = registerBlock("andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> ANDESITE_BRICK_SLAB = registerBlock("andesite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ANDESITE_BRICKS.get())));
  public static final RegistryObject<Block> ANDESITE_BRICK_STAIRS = registerBlock("andesite_brick_stairs", () -> new StairBlock(ANDESITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ANDESITE_BRICKS.get())));
  public static final RegistryObject<Block> ANDESITE_BRICK_WALL = registerBlock("andesite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ANDESITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_ANDESITE_BRICKS = registerBlock("cracked_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> MOSSY_ANDESITE_BRICKS = registerBlock("mossy_andesite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> MOSSY_ANDESITE_BRICK_SLAB = registerBlock("mossy_andesite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_ANDESITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_ANDESITE_BRICK_STAIRS = registerBlock("mossy_andesite_brick_stairs", () -> new StairBlock(MOSSY_ANDESITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_ANDESITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_ANDESITE_BRICK_WALL = registerBlock("mossy_andesite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_ANDESITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> ANDESITE_TILES = registerBlock("andesite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> ANDESITE_TILE_SLAB = registerBlock("andesite_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ANDESITE_TILES.get())));
  public static final RegistryObject<Block> ANDESITE_TILE_STAIRS = registerBlock("andesite_tile_stairs", () -> new StairBlock(ANDESITE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ANDESITE_TILES.get())));
  public static final RegistryObject<Block> ANDESITE_TILE_WALL = registerBlock("andesite_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ANDESITE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_ANDESITE_TILES = registerBlock("cracked_andesite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> ANDESITE_PILLAR = registerBlock("andesite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
  public static final RegistryObject<Block> POLISHED_END_STONE = registerBlock("polished_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
  public static final RegistryObject<Block> POLISHED_END_STONE_SLAB = registerBlock("polished_end_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_END_STONE.get())));
  public static final RegistryObject<Block> POLISHED_END_STONE_STAIRS = registerBlock("polished_end_stone_stairs", () -> new StairBlock(POLISHED_END_STONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_END_STONE.get())));
  public static final RegistryObject<Block> SMOOTH_END_STONE = registerBlock("smooth_end_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
  public static final RegistryObject<Block> SMOOTH_END_STONE_SLAB = registerBlock("smooth_end_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_END_STONE.get())));
  public static final RegistryObject<Block> CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));
  public static final RegistryObject<Block> CRACKED_END_STONE_BRICKS = registerBlock("cracked_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)));
  public static final RegistryObject<Block> MOSSY_END_STONE_BRICKS = registerBlock("mossy_end_stone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)));
  public static final RegistryObject<Block> MOSSY_END_STONE_BRICK_SLAB = registerBlock("mossy_end_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_END_STONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_END_STONE_BRICK_STAIRS = registerBlock("mossy_end_stone_brick_stairs", () -> new StairBlock(MOSSY_END_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_END_STONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_END_STONE_BRICK_WALL = registerBlock("mossy_end_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_END_STONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> END_STONE_TILES = registerBlock("end_stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)));
  public static final RegistryObject<Block> END_STONE_TILE_SLAB = registerBlock("end_stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.END_STONE_TILES.get())));
  public static final RegistryObject<Block> END_STONE_TILE_STAIRS = registerBlock("end_stone_tile_stairs", () -> new StairBlock(END_STONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.END_STONE_TILES.get())));
  public static final RegistryObject<Block> END_STONE_TILE_WALL = registerBlock("end_stone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.END_STONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_END_STONE_TILES = registerBlock("cracked_end_stone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)));
  public static final RegistryObject<Block> END_STONE_PILLAR = registerBlock("end_stone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE_BRICKS)));
  public static final RegistryObject<Block> SMOOTH_TUFF = registerBlock("smooth_tuff", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF)));
  public static final RegistryObject<Block> SMOOTH_TUFF_SLAB = registerBlock("smooth_tuff_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_TUFF.get())));
  public static final RegistryObject<Block> CRACKED_TUFF_BRICKS = registerBlock("cracked_tuff_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> MOSSY_TUFF_BRICKS = registerBlock("mossy_tuff_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> MOSSY_TUFF_BRICK_SLAB = registerBlock("mossy_tuff_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_TUFF_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_TUFF_BRICK_STAIRS = registerBlock("mossy_tuff_brick_stairs", () -> new StairBlock(MOSSY_TUFF_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_TUFF_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_TUFF_BRICK_WALL = registerBlock("mossy_tuff_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_TUFF_BRICKS.get())));
  public static final RegistryObject<Block> TUFF_TILES = registerBlock("tuff_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> TUFF_TILE_SLAB = registerBlock("tuff_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.TUFF_TILES.get()).sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> TUFF_TILE_STAIRS = registerBlock("tuff_tile_stairs", () -> new StairBlock(TUFF_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.TUFF_TILES.get()).sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> TUFF_TILE_WALL = registerBlock("tuff_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.TUFF_TILES.get()).forceSolidOn().sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> CRACKED_TUFF_TILES = registerBlock("cracked_tuff_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> TUFF_PILLAR = registerBlock("tuff_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TUFF).sound(SoundType.TUFF_BRICKS)));
  public static final RegistryObject<Block> RED_SANDSTONE_BRICKS = registerBlock("red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
  public static final RegistryObject<Block> RED_SANDSTONE_BRICK_SLAB = registerBlock("red_sandstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.RED_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> RED_SANDSTONE_BRICK_STAIRS = registerBlock("red_sandstone_brick_stairs", () -> new StairBlock(RED_SANDSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.RED_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> RED_SANDSTONE_BRICK_WALL = registerBlock("red_sandstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.RED_SANDSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_RED_SANDSTONE_BRICKS = registerBlock("cracked_red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
  public static final RegistryObject<Block> MOSSY_RED_SANDSTONE_BRICKS = registerBlock("mossy_red_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
  public static final RegistryObject<Block> MOSSY_RED_SANDSTONE_BRICK_SLAB = registerBlock("mossy_red_sandstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_RED_SANDSTONE_BRICK_STAIRS = registerBlock("mossy_red_sandstone_brick_stairs", () -> new StairBlock(MOSSY_RED_SANDSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_RED_SANDSTONE_BRICK_WALL = registerBlock("mossy_red_sandstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_RED_SANDSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> RED_SANDSTONE_TILES = registerBlock("red_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
  public static final RegistryObject<Block> RED_SANDSTONE_TILE_SLAB = registerBlock("red_sandstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.RED_SANDSTONE_TILES.get())));
  public static final RegistryObject<Block> RED_SANDSTONE_TILE_STAIRS = registerBlock("red_sandstone_tile_stairs", () -> new StairBlock(RED_SANDSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.RED_SANDSTONE_TILES.get())));
  public static final RegistryObject<Block> RED_SANDSTONE_TILE_WALL = registerBlock("red_sandstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.RED_SANDSTONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_RED_SANDSTONE_TILES = registerBlock("cracked_red_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
  public static final RegistryObject<Block> RED_SANDSTONE_PILLAR = registerBlock("red_sandstone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_SANDSTONE)));
  public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_CALCITE.get())));
  public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs", () -> new StairBlock(POLISHED_CALCITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_CALCITE.get())));
  public static final RegistryObject<Block> SMOOTH_CALCITE = registerBlock("smooth_calcite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> SMOOTH_CALCITE_SLAB = registerBlock("smooth_calcite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_CALCITE.get())));
  public static final RegistryObject<Block> CHISELED_CALCITE_BRICKS = registerBlock("chiseled_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> CALCITE_BRICKS = registerBlock("calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> CALCITE_BRICK_SLAB = registerBlock("calcite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CALCITE_BRICKS.get())));
  public static final RegistryObject<Block> CALCITE_BRICK_STAIRS = registerBlock("calcite_brick_stairs", () -> new StairBlock(CALCITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CALCITE_BRICKS.get())));
  public static final RegistryObject<Block> CALCITE_BRICK_WALL = registerBlock("calcite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CALCITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_CALCITE_BRICKS = registerBlock("cracked_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> MOSSY_CALCITE_BRICKS = registerBlock("mossy_calcite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> MOSSY_CALCITE_BRICK_SLAB = registerBlock("mossy_calcite_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_CALCITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_CALCITE_BRICK_STAIRS = registerBlock("mossy_calcite_brick_stairs", () -> new StairBlock(MOSSY_CALCITE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_CALCITE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_CALCITE_BRICK_WALL = registerBlock("mossy_calcite_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_CALCITE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CALCITE_TILES = registerBlock("calcite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> CALCITE_TILE_SLAB = registerBlock("calcite_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CALCITE_TILES.get())));
  public static final RegistryObject<Block> CALCITE_TILE_STAIRS = registerBlock("calcite_tile_stairs", () -> new StairBlock(CALCITE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CALCITE_TILES.get())));
  public static final RegistryObject<Block> CALCITE_TILE_WALL = registerBlock("calcite_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CALCITE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_CALCITE_TILES = registerBlock("cracked_calcite_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> CALCITE_PILLAR = registerBlock("calcite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE)));
  public static final RegistryObject<Block> POLISHED_DRIPSTONE = registerBlock("polished_dripstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_DRIPSTONE.get())));
  public static final RegistryObject<Block> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs", () -> new StairBlock(POLISHED_DRIPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_DRIPSTONE.get())));
  public static final RegistryObject<Block> SMOOTH_DRIPSTONE = registerBlock("smooth_dripstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> SMOOTH_DRIPSTONE_SLAB = registerBlock("smooth_dripstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_DRIPSTONE.get())));
  public static final RegistryObject<Block> CHISELED_DRIPSTONE_BRICKS = registerBlock("chiseled_dripstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> DRIPSTONE_BRICKS = registerBlock("dripstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> DRIPSTONE_BRICK_SLAB = registerBlock("dripstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DRIPSTONE_BRICKS.get())));
  public static final RegistryObject<Block> DRIPSTONE_BRICK_STAIRS = registerBlock("dripstone_brick_stairs", () -> new StairBlock(DRIPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DRIPSTONE_BRICKS.get())));
  public static final RegistryObject<Block> DRIPSTONE_BRICK_WALL = registerBlock("dripstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DRIPSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_DRIPSTONE_BRICKS = registerBlock("cracked_dripstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> MOSSY_DRIPSTONE_BRICKS = registerBlock("mossy_dripstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> MOSSY_DRIPSTONE_BRICK_SLAB = registerBlock("mossy_dripstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_DRIPSTONE_BRICK_STAIRS = registerBlock("mossy_dripstone_brick_stairs", () -> new StairBlock(MOSSY_DRIPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_DRIPSTONE_BRICK_WALL = registerBlock("mossy_dripstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_DRIPSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> DRIPSTONE_TILES = registerBlock("dripstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> DRIPSTONE_TILE_SLAB = registerBlock("dripstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DRIPSTONE_TILES.get())));
  public static final RegistryObject<Block> DRIPSTONE_TILE_STAIRS = registerBlock("dripstone_tile_stairs", () -> new StairBlock(DRIPSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DRIPSTONE_TILES.get())));
  public static final RegistryObject<Block> DRIPSTONE_TILE_WALL = registerBlock("dripstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DRIPSTONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_DRIPSTONE_TILES = registerBlock("cracked_dripstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> DRIPSTONE_PILLAR = registerBlock("dripstone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DRIPSTONE_BLOCK)));
  public static final RegistryObject<Block> POLISHED_PRISMARINE = registerBlock("polished_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
  public static final RegistryObject<Block> POLISHED_PRISMARINE_SLAB = registerBlock("polished_prismarine_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_PRISMARINE.get())));
  public static final RegistryObject<Block> POLISHED_PRISMARINE_STAIRS = registerBlock("polished_prismarine_stairs", () -> new StairBlock(POLISHED_PRISMARINE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_PRISMARINE.get())));
  public static final RegistryObject<Block> SMOOTH_PRISMARINE = registerBlock("smooth_prismarine", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
  public static final RegistryObject<Block> SMOOTH_PRISMARINE_SLAB = registerBlock("smooth_prismarine_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_PRISMARINE.get())));
  public static final RegistryObject<Block> CHISELED_PRISMARINE_BRICKS = registerBlock("chiseled_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE)));
  public static final RegistryObject<Block> CRACKED_PRISMARINE_BRICKS = registerBlock("cracked_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
  public static final RegistryObject<Block> MOSSY_PRISMARINE_BRICKS = registerBlock("mossy_prismarine_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
  public static final RegistryObject<Block> MOSSY_PRISMARINE_BRICK_SLAB = registerBlock("mossy_prismarine_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_PRISMARINE_BRICK_STAIRS = registerBlock("mossy_prismarine_brick_stairs", () -> new StairBlock(MOSSY_PRISMARINE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_PRISMARINE_BRICK_WALL = registerBlock("mossy_prismarine_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> PRISMARINE_TILES = registerBlock("prismarine_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
  public static final RegistryObject<Block> PRISMARINE_TILE_SLAB = registerBlock("prismarine_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PRISMARINE_TILES.get())));
  public static final RegistryObject<Block> PRISMARINE_TILE_STAIRS = registerBlock("prismarine_tile_stairs", () -> new StairBlock(PRISMARINE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PRISMARINE_TILES.get())));
  public static final RegistryObject<Block> PRISMARINE_TILE_WALL = registerBlock("prismarine_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PRISMARINE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_PRISMARINE_TILES = registerBlock("cracked_prismarine_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
  public static final RegistryObject<Block> PRISMARINE_PILLAR = registerBlock("prismarine_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PRISMARINE_BRICKS)));
  public static final RegistryObject<Block> SMOOTH_BLACKSTONE = registerBlock("smooth_blackstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
  public static final RegistryObject<Block> SMOOTH_BLACKSTONE_SLAB = registerBlock("smooth_blackstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_BLACKSTONE.get())));
  public static final RegistryObject<Block> CORRUPTED_POLISHED_BLACKSTONE_BRICKS = registerBlock("corrupted_polished_blackstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
  public static final RegistryObject<Block> CORRUPTED_POLISHED_BLACKSTONE_BRICK_SLAB = registerBlock("corrupted_polished_blackstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get())));
  public static final RegistryObject<Block> CORRUPTED_POLISHED_BLACKSTONE_BRICK_STAIRS = registerBlock("corrupted_polished_blackstone_brick_stairs", () -> new StairBlock(CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get())));
  public static final RegistryObject<Block> CORRUPTED_POLISHED_BLACKSTONE_BRICK_WALL = registerBlock("corrupted_polished_blackstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CORRUPTED_POLISHED_BLACKSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> POLISHED_BLACKSTONE_TILES = registerBlock("polished_blackstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
  public static final RegistryObject<Block> POLISHED_BLACKSTONE_TILE_SLAB = registerBlock("polished_blackstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_BLACKSTONE_TILES.get())));
  public static final RegistryObject<Block> POLISHED_BLACKSTONE_TILE_STAIRS = registerBlock("polished_blackstone_tile_stairs", () -> new StairBlock(POLISHED_BLACKSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_BLACKSTONE_TILES.get())));
  public static final RegistryObject<Block> POLISHED_BLACKSTONE_TILE_WALL = registerBlock("polished_blackstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_BLACKSTONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_TILES = registerBlock("cracked_polished_blackstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
  public static final RegistryObject<Block> POLISHED_BLACKSTONE_PILLAR = registerBlock("polished_blackstone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)));
  public static final RegistryObject<Block> CRACKED_QUARTZ_BRICKS = registerBlock("cracked_quartz_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS)));
  public static final RegistryObject<Block> CUT_QUARTZ = registerBlock("cut_quartz", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS)));
  public static final RegistryObject<Block> CRACKED_CUT_QUARTZ = registerBlock("cracked_cut_quartz", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.QUARTZ_BRICKS)));
  public static final RegistryObject<Block> POLISHED_MUD = registerBlock("polished_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> POLISHED_MUD_SLAB = registerBlock("polished_mud_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_MUD.get())));
  public static final RegistryObject<Block> POLISHED_MUD_STAIRS = registerBlock("polished_mud_stairs", () -> new StairBlock(POLISHED_MUD.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_MUD.get())));
  public static final RegistryObject<Block> SMOOTH_MUD = registerBlock("smooth_mud", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> SMOOTH_MUD_SLAB = registerBlock("smooth_mud_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_MUD.get())));
  public static final RegistryObject<Block> CHISELED_MUD_BRICKS = registerBlock("chiseled_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> CRACKED_MUD_BRICKS = registerBlock("cracked_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> MOSSY_MUD_BRICKS = registerBlock("mossy_mud_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> MOSSY_MUD_BRICK_SLAB = registerBlock("mossy_mud_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_MUD_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_MUD_BRICK_STAIRS = registerBlock("mossy_mud_brick_stairs", () -> new StairBlock(MOSSY_MUD_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_MUD_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_MUD_BRICK_WALL = registerBlock("mossy_mud_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_MUD_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> MUD_TILES = registerBlock("mud_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> MUD_TILE_SLAB = registerBlock("mud_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MUD_TILES.get())));
  public static final RegistryObject<Block> MUD_TILE_STAIRS = registerBlock("mud_tile_stairs", () -> new StairBlock(MUD_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MUD_TILES.get())));
  public static final RegistryObject<Block> MUD_TILE_WALL = registerBlock("mud_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MUD_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_MUD_TILES = registerBlock("cracked_mud_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> MUD_PILLAR = registerBlock("mud_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUD_BRICKS)));
  public static final RegistryObject<Block> SANDSTONE_BRICKS = registerBlock("sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SANDSTONE_BRICK_SLAB = registerBlock("sandstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> SANDSTONE_BRICK_STAIRS = registerBlock("sandstone_brick_stairs", () -> new StairBlock(SANDSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> SANDSTONE_BRICK_WALL = registerBlock("sandstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SANDSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_SANDSTONE_BRICKS = registerBlock("cracked_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> MOSSY_SANDSTONE_BRICKS = registerBlock("mossy_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> MOSSY_SANDSTONE_BRICK_SLAB = registerBlock("mossy_sandstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_SANDSTONE_BRICK_STAIRS = registerBlock("mossy_sandstone_brick_stairs", () -> new StairBlock(MOSSY_SANDSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_SANDSTONE_BRICK_WALL = registerBlock("mossy_sandstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_SANDSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> SANDSTONE_TILES = registerBlock("sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SANDSTONE_TILE_SLAB = registerBlock("sandstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SANDSTONE_TILES.get())));
  public static final RegistryObject<Block> SANDSTONE_TILE_STAIRS = registerBlock("sandstone_tile_stairs", () -> new StairBlock(SANDSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SANDSTONE_TILES.get())));
  public static final RegistryObject<Block> SANDSTONE_TILE_WALL = registerBlock("sandstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SANDSTONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_SANDSTONE_TILES = registerBlock("cracked_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SANDSTONE_PILLAR = registerBlock("sandstone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> NETHER_BRICKS_PILLAR = registerBlock("nether_bricks_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
  public static final RegistryObject<Block> CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
  public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICKS = registerBlock("cracked_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
  public static final RegistryObject<Block> RED_NETHER_BRICKS_PILLAR = registerBlock("red_nether_bricks_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_BRICKS)));
  public static final RegistryObject<Block> POLISHED_ICE = registerBlock("polished_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
  public static final RegistryObject<Block> POLISHED_ICE_SLAB = registerBlock("polished_ice_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_ICE.get())));
  public static final RegistryObject<Block> POLISHED_ICE_STAIRS = registerBlock("polished_ice_stairs", () -> new StairBlock(POLISHED_ICE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_ICE.get())));
  public static final RegistryObject<Block> ICE_BRICKS = registerBlock("ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
  public static final RegistryObject<Block> ICE_BRICK_SLAB = registerBlock("ice_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ICE_BRICKS.get())));
  public static final RegistryObject<Block> ICE_BRICK_STAIRS = registerBlock("ice_brick_stairs", () -> new StairBlock(ICE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ICE_BRICKS.get())));
  public static final RegistryObject<Block> ICE_BRICK_WALL = registerBlock("ice_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ICE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_ICE_BRICKS = registerBlock("cracked_ice_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
  public static final RegistryObject<Block> ICE_TILES = registerBlock("ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
  public static final RegistryObject<Block> ICE_TILE_SLAB = registerBlock("ice_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ICE_TILES.get())));
  public static final RegistryObject<Block> ICE_TILE_STAIRS = registerBlock("ice_tile_stairs", () -> new StairBlock(ICE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ICE_TILES.get())));
  public static final RegistryObject<Block> ICE_TILE_WALL = registerBlock("ice_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ICE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_ICE_TILES = registerBlock("cracked_ice_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
  public static final RegistryObject<Block> ICE_PILLAR = registerBlock("ice_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ICE)));
  public static final RegistryObject<Block> POLISHED_PURPUR = registerBlock("polished_purpur", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
  public static final RegistryObject<Block> POLISHED_PURPUR_SLAB = registerBlock("polished_purpur_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_PURPUR.get())));
  public static final RegistryObject<Block> POLISHED_PURPUR_STAIRS = registerBlock("polished_purpur_stairs", () -> new StairBlock(POLISHED_PURPUR.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.POLISHED_PURPUR.get())));
  public static final RegistryObject<Block> SMOOTH_PURPUR = registerBlock("smooth_purpur", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
  public static final RegistryObject<Block> SMOOTH_PURPUR_SLAB = registerBlock("smooth_purpur_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_PURPUR.get())));
  public static final RegistryObject<Block> CHISELED_PURPUR = registerBlock("chiseled_purpur", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK).lightLevel((state) -> 14)));
  public static final RegistryObject<Block> CRACKED_PURPUR_BLOCK = registerBlock("cracked_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
  public static final RegistryObject<Block> MOSSY_PURPUR_BLOCK = registerBlock("mossy_purpur_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
  public static final RegistryObject<Block> MOSSY_PURPUR_BLOCK_SLAB = registerBlock("mossy_purpur_block_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_PURPUR_BLOCK.get())));
  public static final RegistryObject<Block> MOSSY_PURPUR_BLOCK_STAIRS = registerBlock("mossy_purpur_block_stairs", () -> new StairBlock(MOSSY_PURPUR_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_PURPUR_BLOCK.get())));
  public static final RegistryObject<Block> MOSSY_PURPUR_BLOCK_WALL = registerBlock("mossy_purpur_block_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_PURPUR_BLOCK.get()).forceSolidOn()));
  public static final RegistryObject<Block> PURPUR_TILES = registerBlock("purpur_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
  public static final RegistryObject<Block> PURPUR_TILE_SLAB = registerBlock("purpur_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PURPUR_TILES.get())));
  public static final RegistryObject<Block> PURPUR_TILE_STAIRS = registerBlock("purpur_tile_stairs", () -> new StairBlock(PURPUR_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PURPUR_TILES.get())));
  public static final RegistryObject<Block> PURPUR_TILE_WALL = registerBlock("purpur_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.PURPUR_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_PURPUR_TILES = registerBlock("cracked_purpur_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPUR_BLOCK)));
  public static final RegistryObject<Block> TERRACOTTA_BRICKS = registerBlock("terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
  public static final RegistryObject<Block> WHITE_TERRACOTTA_BRICKS = registerBlock("white_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
  public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_BRICKS = registerBlock("light_gray_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
  public static final RegistryObject<Block> GRAY_TERRACOTTA_BRICKS = registerBlock("gray_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
  public static final RegistryObject<Block> BLACK_TERRACOTTA_BRICKS = registerBlock("black_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
  public static final RegistryObject<Block> BROWN_TERRACOTTA_BRICKS = registerBlock("brown_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
  public static final RegistryObject<Block> RED_TERRACOTTA_BRICKS = registerBlock("red_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
  public static final RegistryObject<Block> ORANGE_TERRACOTTA_BRICKS = registerBlock("orange_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
  public static final RegistryObject<Block> YELLOW_TERRACOTTA_BRICKS = registerBlock("yellow_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
  public static final RegistryObject<Block> LIME_TERRACOTTA_BRICKS = registerBlock("lime_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
  public static final RegistryObject<Block> GREEN_TERRACOTTA_BRICKS = registerBlock("green_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
  public static final RegistryObject<Block> CYAN_TERRACOTTA_BRICKS = registerBlock("cyan_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
  public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_BRICKS = registerBlock("light_blue_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
  public static final RegistryObject<Block> BLUE_TERRACOTTA_BRICKS = registerBlock("blue_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
  public static final RegistryObject<Block> PURPLE_TERRACOTTA_BRICKS = registerBlock("purple_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
  public static final RegistryObject<Block> MAGENTA_TERRACOTTA_BRICKS = registerBlock("magenta_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
  public static final RegistryObject<Block> PINK_TERRACOTTA_BRICKS = registerBlock("pink_terracotta_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
  public static final RegistryObject<Block> TERRACOTTA_TILES = registerBlock("terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA)));
  public static final RegistryObject<Block> WHITE_TERRACOTTA_TILES = registerBlock("white_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA)));
  public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_TILES = registerBlock("light_gray_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA)));
  public static final RegistryObject<Block> GRAY_TERRACOTTA_TILES = registerBlock("gray_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA)));
  public static final RegistryObject<Block> BLACK_TERRACOTTA_TILES = registerBlock("black_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA)));
  public static final RegistryObject<Block> BROWN_TERRACOTTA_TILES = registerBlock("brown_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA)));
  public static final RegistryObject<Block> RED_TERRACOTTA_TILES = registerBlock("red_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA)));
  public static final RegistryObject<Block> ORANGE_TERRACOTTA_TILES = registerBlock("orange_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA)));
  public static final RegistryObject<Block> YELLOW_TERRACOTTA_TILES = registerBlock("yellow_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA)));
  public static final RegistryObject<Block> LIME_TERRACOTTA_TILES = registerBlock("lime_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA)));
  public static final RegistryObject<Block> GREEN_TERRACOTTA_TILES = registerBlock("green_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA)));
  public static final RegistryObject<Block> CYAN_TERRACOTTA_TILES = registerBlock("cyan_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA)));
  public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_TILES = registerBlock("light_blue_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA)));
  public static final RegistryObject<Block> BLUE_TERRACOTTA_TILES = registerBlock("blue_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA)));
  public static final RegistryObject<Block> PURPLE_TERRACOTTA_TILES = registerBlock("purple_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA)));
  public static final RegistryObject<Block> MAGENTA_TERRACOTTA_TILES = registerBlock("magenta_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA)));
  public static final RegistryObject<Block> PINK_TERRACOTTA_TILES = registerBlock("pink_terracotta_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA)));
  public static final RegistryObject<Block> WHITE_CONCRETE_BRICKS = registerBlock("white_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
  public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_BRICKS = registerBlock("light_gray_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
  public static final RegistryObject<Block> GRAY_CONCRETE_BRICKS = registerBlock("gray_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
  public static final RegistryObject<Block> BLACK_CONCRETE_BRICKS = registerBlock("black_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
  public static final RegistryObject<Block> BROWN_CONCRETE_BRICKS = registerBlock("brown_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
  public static final RegistryObject<Block> RED_CONCRETE_BRICKS = registerBlock("red_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
  public static final RegistryObject<Block> ORANGE_CONCRETE_BRICKS = registerBlock("orange_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
  public static final RegistryObject<Block> YELLOW_CONCRETE_BRICKS = registerBlock("yellow_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
  public static final RegistryObject<Block> LIME_CONCRETE_BRICKS = registerBlock("lime_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
  public static final RegistryObject<Block> GREEN_CONCRETE_BRICKS = registerBlock("green_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
  public static final RegistryObject<Block> CYAN_CONCRETE_BRICKS = registerBlock("cyan_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
  public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_BRICKS = registerBlock("light_blue_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
  public static final RegistryObject<Block> BLUE_CONCRETE_BRICKS = registerBlock("blue_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
  public static final RegistryObject<Block> PURPLE_CONCRETE_BRICKS = registerBlock("purple_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
  public static final RegistryObject<Block> MAGENTA_CONCRETE_BRICKS = registerBlock("magenta_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
  public static final RegistryObject<Block> PINK_CONCRETE_BRICKS = registerBlock("pink_concrete_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
  public static final RegistryObject<Block> WHITE_CONCRETE_TILES = registerBlock("white_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
  public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_TILES = registerBlock("light_gray_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
  public static final RegistryObject<Block> GRAY_CONCRETE_TILES = registerBlock("gray_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
  public static final RegistryObject<Block> BLACK_CONCRETE_TILES = registerBlock("black_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
  public static final RegistryObject<Block> BROWN_CONCRETE_TILES = registerBlock("brown_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
  public static final RegistryObject<Block> RED_CONCRETE_TILES = registerBlock("red_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
  public static final RegistryObject<Block> ORANGE_CONCRETE_TILES = registerBlock("orange_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
  public static final RegistryObject<Block> YELLOW_CONCRETE_TILES = registerBlock("yellow_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
  public static final RegistryObject<Block> LIME_CONCRETE_TILES = registerBlock("lime_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
  public static final RegistryObject<Block> GREEN_CONCRETE_TILES = registerBlock("green_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
  public static final RegistryObject<Block> CYAN_CONCRETE_TILES = registerBlock("cyan_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
  public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_TILES = registerBlock("light_blue_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
  public static final RegistryObject<Block> BLUE_CONCRETE_TILES = registerBlock("blue_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
  public static final RegistryObject<Block> PURPLE_CONCRETE_TILES = registerBlock("purple_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
  public static final RegistryObject<Block> MAGENTA_CONCRETE_TILES = registerBlock("magenta_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
  public static final RegistryObject<Block> PINK_CONCRETE_TILES = registerBlock("pink_concrete_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));
  public static final RegistryObject<Block> SOUL_SANDSTONE = registerBlock("soul_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SOUL_SANDSTONE_SLAB = registerBlock("soul_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE.get())));
  public static final RegistryObject<Block> SOUL_SANDSTONE_STAIRS = registerBlock("soul_sandstone_stairs", () -> new StairBlock(SOUL_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE.get())));
  public static final RegistryObject<Block> SOUL_SANDSTONE_WALL = registerBlock("soul_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE.get())));
  public static final RegistryObject<Block> CUT_SOUL_SANDSTONE = registerBlock("cut_soul_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE)));
  public static final RegistryObject<Block> CUT_SOUL_SANDSTONE_SLAB = registerBlock("cut_soul_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CUT_SOUL_SANDSTONE.get())));
  public static final RegistryObject<Block> SMOOTH_SOUL_SANDSTONE = registerBlock("smooth_soul_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));
  public static final RegistryObject<Block> SMOOTH_SOUL_SANDSTONE_SLAB = registerBlock("smooth_soul_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get())));
  public static final RegistryObject<Block> SMOOTH_SOUL_SANDSTONE_STAIRS = registerBlock("smooth_soul_sandstone_stairs", () -> new StairBlock(SMOOTH_SOUL_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SMOOTH_SOUL_SANDSTONE.get())));
  public static final RegistryObject<Block> CHISELED_SOUL_SANDSTONE = registerBlock("chiseled_soul_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_SANDSTONE)));
  public static final RegistryObject<Block> SOUL_SANDSTONE_BRICKS = registerBlock("soul_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SOUL_SANDSTONE_BRICK_SLAB = registerBlock("soul_sandstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> SOUL_SANDSTONE_BRICK_STAIRS = registerBlock("soul_sandstone_brick_stairs", () -> new StairBlock(SOUL_SANDSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE_BRICKS.get())));
  public static final RegistryObject<Block> SOUL_SANDSTONE_BRICK_WALL = registerBlock("soul_sandstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_SOUL_SANDSTONE_BRICKS = registerBlock("cracked_soul_sandstone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SOUL_SANDSTONE_TILES = registerBlock("soul_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SOUL_SANDSTONE_TILE_SLAB = registerBlock("soul_sandstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE_TILES.get())));
  public static final RegistryObject<Block> SOUL_SANDSTONE_TILE_STAIRS = registerBlock("soul_sandstone_tile_stairs", () -> new StairBlock(SOUL_SANDSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE_TILES.get())));
  public static final RegistryObject<Block> SOUL_SANDSTONE_TILE_WALL = registerBlock("soul_sandstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SOUL_SANDSTONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_SOUL_SANDSTONE_TILES = registerBlock("cracked_soul_sandstone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> SOUL_SANDSTONE_PILLAR = registerBlock("soul_sandstone_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
  public static final RegistryObject<Block> COAL_BRICKS = registerBlock("coal_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)), Constants.COAL_BRICKS_FUEL);
  public static final RegistryObject<Block> CRACKED_COAL_BRICKS = registerBlock("cracked_coal_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)), Constants.CRACKED_COAL_BRICKS_FUEL);
  public static final RegistryObject<Block> CUT_COAL = registerBlock("cut_coal", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)), Constants.CUT_COAL_FUEL);
  public static final RegistryObject<Block> CRACKED_CUT_COAL = registerBlock("cracked_cut_coal", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)), Constants.CRACKED_CUT_COAL_FUEL);
  public static final RegistryObject<Block> COAL_PILLAR = registerBlock("coal_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COAL_BLOCK)), Constants.COAL_PILLAR_FUEL);
  public static final RegistryObject<Block> IRON_BRICKS = registerBlock("iron_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
  public static final RegistryObject<Block> CRACKED_IRON_BRICKS = registerBlock("cracked_iron_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
  public static final RegistryObject<Block> CUT_IRON = registerBlock("cut_iron", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_IRON = registerBlock("cracked_cut_iron", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
  public static final RegistryObject<Block> IRON_PILLAR = registerBlock("iron_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
  public static final RegistryObject<Block> IRON_GRATE = registerBlock("iron_grate", () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.of().noOcclusion().strength(Blocks.IRON_BLOCK.defaultDestroyTime()).requiresCorrectToolForDrops().sound(SoundType.METAL)));
  public static final RegistryObject<Block> GOLD_BRICKS = registerBlock("gold_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
  public static final RegistryObject<Block> CRACKED_GOLD_BRICKS = registerBlock("cracked_gold_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
  public static final RegistryObject<Block> CUT_GOLD = registerBlock("cut_gold", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_GOLD = registerBlock("cracked_cut_gold", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
  public static final RegistryObject<Block> GOLD_PILLAR = registerBlock("gold_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)));
  public static final RegistryObject<Block> REDSTONE_BRICKS = registerBlock("redstone_bricks", () -> new PoweredBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
  public static final RegistryObject<Block> CRACKED_REDSTONE_BRICKS = registerBlock("cracked_redstone_bricks", () -> new CrackedPoweredBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
  public static final RegistryObject<Block> CUT_REDSTONE = registerBlock("cut_redstone", () -> new PoweredBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_REDSTONE = registerBlock("cracked_cut_redstone", () -> new CrackedPoweredBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
  public static final RegistryObject<Block> REDSTONE_PILLAR = registerBlock("redstone_pillar", () -> new PoweredRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_BLOCK)));
  public static final RegistryObject<Block> EMERALD_BRICKS = registerBlock("emerald_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
  public static final RegistryObject<Block> CRACKED_EMERALD_BRICKS = registerBlock("cracked_emerald_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
  public static final RegistryObject<Block> CUT_EMERALD = registerBlock("cut_emerald", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_EMERALD = registerBlock("cracked_cut_emerald", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
  public static final RegistryObject<Block> EMERALD_PILLAR = registerBlock("emerald_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK)));
  public static final RegistryObject<Block> LAPIS_BRICKS = registerBlock("lapis_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
  public static final RegistryObject<Block> CRACKED_LAPIS_BRICKS = registerBlock("cracked_lapis_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
  public static final RegistryObject<Block> CUT_LAPIS = registerBlock("cut_lapis", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_LAPIS = registerBlock("cracked_cut_lapis", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
  public static final RegistryObject<Block> LAPIS_PILLAR = registerBlock("lapis_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK)));
  public static final RegistryObject<Block> DIAMOND_BRICKS = registerBlock("diamond_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
  public static final RegistryObject<Block> CRACKED_DIAMOND_BRICKS = registerBlock("cracked_diamond_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
  public static final RegistryObject<Block> CUT_DIAMOND = registerBlock("cut_diamond", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_DIAMOND = registerBlock("cracked_cut_diamond", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
  public static final RegistryObject<Block> DIAMOND_PILLAR = registerBlock("diamond_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));
  public static final RegistryObject<Block> DIAMOND_GRATE = registerBlock("diamond_grate", () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.of().noOcclusion().strength(Blocks.DIAMOND_BLOCK.defaultDestroyTime()).requiresCorrectToolForDrops().sound(SoundType.METAL)));
  public static final RegistryObject<Block> NETHERITE_BRICKS = registerBlock("netherite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
  public static final RegistryObject<Block> CRACKED_NETHERITE_BRICKS = registerBlock("cracked_netherite_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
  public static final RegistryObject<Block> CUT_NETHERITE = registerBlock("cut_netherite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_NETHERITE = registerBlock("cracked_cut_netherite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
  public static final RegistryObject<Block> NETHERITE_PILLAR = registerBlock("netherite_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)));
  public static final RegistryObject<Block> NETHERITE_GRATE = registerBlock("netherite_grate", () -> new WaterloggedTransparentBlock(BlockBehaviour.Properties.of().noOcclusion().strength(Blocks.NETHERITE_BLOCK.defaultDestroyTime()).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
  public static final RegistryObject<Block> AMETHYST_BRICKS = registerBlock("amethyst_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
  public static final RegistryObject<Block> CRACKED_AMETHYST_BRICKS = registerBlock("cracked_amethyst_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
  public static final RegistryObject<Block> CUT_AMETHYST = registerBlock("cut_amethyst", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
  public static final RegistryObject<Block> CRACKED_CUT_AMETHYST = registerBlock("cracked_cut_amethyst", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
  public static final RegistryObject<Block> AMETHYST_PILLAR = registerBlock("amethyst_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK)));
  public static final RegistryObject<Block> SHINGLES = registerBlock("shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(Constants.SHINGLES_DESTROY_TIME, Constants.SHINGLES_EXPLOSION_RESISTANCE).sound(SoundType.DEEPSLATE_TILES)));
  public static final RegistryObject<Block> WHITE_SHINGLES = registerBlock("white_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SHINGLES.get()).mapColor(MapColor.TERRACOTTA_WHITE)));
  public static final RegistryObject<Block> LIGHT_GRAY_SHINGLES = registerBlock("light_gray_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)));
  public static final RegistryObject<Block> GRAY_SHINGLES = registerBlock("gray_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_GRAY)));
  public static final RegistryObject<Block> BLACK_SHINGLES = registerBlock("black_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_BLACK)));
  public static final RegistryObject<Block> BROWN_SHINGLES = registerBlock("brown_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_BROWN)));
  public static final RegistryObject<Block> RED_SHINGLES = registerBlock("red_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_RED)));
  public static final RegistryObject<Block> ORANGE_SHINGLES = registerBlock("orange_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_ORANGE)));
  public static final RegistryObject<Block> YELLOW_SHINGLES = registerBlock("yellow_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_YELLOW)));
  public static final RegistryObject<Block> LIME_SHINGLES = registerBlock("lime_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)));
  public static final RegistryObject<Block> GREEN_SHINGLES = registerBlock("green_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_GREEN)));
  public static final RegistryObject<Block> CYAN_SHINGLES = registerBlock("cyan_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_CYAN)));
  public static final RegistryObject<Block> LIGHT_BLUE_SHINGLES = registerBlock("light_blue_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)));
  public static final RegistryObject<Block> BLUE_SHINGLES = registerBlock("blue_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_BLUE)));
  public static final RegistryObject<Block> PURPLE_SHINGLES = registerBlock("purple_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_PURPLE)));
  public static final RegistryObject<Block> MAGENTA_SHINGLES = registerBlock("magenta_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_MAGENTA)));
  public static final RegistryObject<Block> PINK_SHINGLES = registerBlock("pink_shingles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SHINGLES.get()).mapColor(MapColor.TERRACOTTA_PINK)));
  public static final RegistryObject<Block> OAK_MOSAIC = registerBlock("oak_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
  public static final RegistryObject<Block> OAK_MOSAIC_SLAB = registerBlock("oak_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.OAK_MOSAIC.get())));
  public static final RegistryObject<Block> OAK_MOSAIC_STAIRS = registerBlock("oak_mosaic_stairs", () -> new StairBlock(OAK_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.OAK_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_OAK_LOG = registerBlock("carved_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
  public static final RegistryObject<Block> CARVED_OAK_WOOD = registerBlock("carved_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
  public static final RegistryObject<Block> SPRUCE_MOSAIC = registerBlock("spruce_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
  public static final RegistryObject<Block> SPRUCE_MOSAIC_SLAB = registerBlock("spruce_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SPRUCE_MOSAIC.get())));
  public static final RegistryObject<Block> SPRUCE_MOSAIC_STAIRS = registerBlock("spruce_mosaic_stairs", () -> new StairBlock(SPRUCE_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.SPRUCE_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_SPRUCE_LOG = registerBlock("carved_spruce_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_LOG)));
  public static final RegistryObject<Block> CARVED_SPRUCE_WOOD = registerBlock("carved_spruce_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_SPRUCE_WOOD)));
  public static final RegistryObject<Block> BIRCH_MOSAIC = registerBlock("birch_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
  public static final RegistryObject<Block> BIRCH_MOSAIC_SLAB = registerBlock("birch_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BIRCH_MOSAIC.get())));
  public static final RegistryObject<Block> BIRCH_MOSAIC_STAIRS = registerBlock("birch_mosaic_stairs", () -> new StairBlock(BIRCH_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BIRCH_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_BIRCH_LOG = registerBlock("carved_birch_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_LOG)));
  public static final RegistryObject<Block> CARVED_BIRCH_WOOD = registerBlock("carved_birch_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BIRCH_WOOD)));
  public static final RegistryObject<Block> JUNGLE_MOSAIC = registerBlock("jungle_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
  public static final RegistryObject<Block> JUNGLE_MOSAIC_SLAB = registerBlock("jungle_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.JUNGLE_MOSAIC.get())));
  public static final RegistryObject<Block> JUNGLE_MOSAIC_STAIRS = registerBlock("jungle_mosaic_stairs", () -> new StairBlock(JUNGLE_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.JUNGLE_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_JUNGLE_LOG = registerBlock("carved_jungle_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_LOG)));
  public static final RegistryObject<Block> CARVED_JUNGLE_WOOD = registerBlock("carved_jungle_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_JUNGLE_WOOD)));
  public static final RegistryObject<Block> ACACIA_MOSAIC = registerBlock("acacia_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
  public static final RegistryObject<Block> ACACIA_MOSAIC_SLAB = registerBlock("acacia_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ACACIA_MOSAIC.get())));
  public static final RegistryObject<Block> ACACIA_MOSAIC_STAIRS = registerBlock("acacia_mosaic_stairs", () -> new StairBlock(ACACIA_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.ACACIA_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_ACACIA_LOG = registerBlock("carved_acacia_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_LOG)));
  public static final RegistryObject<Block> CARVED_ACACIA_WOOD = registerBlock("carved_acacia_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));
  public static final RegistryObject<Block> DARK_OAK_MOSAIC = registerBlock("dark_oak_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
  public static final RegistryObject<Block> DARK_OAK_MOSAIC_SLAB = registerBlock("dark_oak_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DARK_OAK_MOSAIC.get())));
  public static final RegistryObject<Block> DARK_OAK_MOSAIC_STAIRS = registerBlock("dark_oak_mosaic_stairs", () -> new StairBlock(DARK_OAK_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.DARK_OAK_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_DARK_OAK_LOG = registerBlock("carved_dark_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_DARK_OAK_LOG)));
  public static final RegistryObject<Block> CARVED_DARK_OAK_WOOD = registerBlock("carved_dark_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD)));
  public static final RegistryObject<Block> MANGROVE_MOSAIC = registerBlock("mangrove_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
  public static final RegistryObject<Block> MANGROVE_MOSAIC_SLAB = registerBlock("mangrove_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MANGROVE_MOSAIC.get())));
  public static final RegistryObject<Block> MANGROVE_MOSAIC_STAIRS = registerBlock("mangrove_mosaic_stairs", () -> new StairBlock(MANGROVE_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MANGROVE_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_MANGROVE_LOG = registerBlock("carved_mangrove_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_MANGROVE_LOG)));
  public static final RegistryObject<Block> CARVED_MANGROVE_WOOD = registerBlock("carved_mangrove_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_MANGROVE_WOOD)));
  public static final RegistryObject<Block> CRIMSON_MOSAIC = registerBlock("crimson_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
  public static final RegistryObject<Block> CRIMSON_MOSAIC_SLAB = registerBlock("crimson_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CRIMSON_MOSAIC.get())));
  public static final RegistryObject<Block> CRIMSON_MOSAIC_STAIRS = registerBlock("crimson_mosaic_stairs", () -> new StairBlock(CRIMSON_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CRIMSON_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_CRIMSON_STEM = registerBlock("carved_crimson_stem", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_STEM)));
  public static final RegistryObject<Block> CARVED_CRIMSON_HYPHAE = registerBlock("carved_crimson_hyphae", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CRIMSON_HYPHAE)));
  public static final RegistryObject<Block> WARPED_MOSAIC = registerBlock("warped_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));
  public static final RegistryObject<Block> WARPED_MOSAIC_SLAB = registerBlock("warped_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WARPED_MOSAIC.get())));
  public static final RegistryObject<Block> WARPED_MOSAIC_STAIRS = registerBlock("warped_mosaic_stairs", () -> new StairBlock(WARPED_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WARPED_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_WARPED_STEM = registerBlock("carved_warped_stem", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_STEM)));
  public static final RegistryObject<Block> CARVED_WARPED_HYPHAE = registerBlock("carved_warped_hyphae", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_WARPED_HYPHAE)));
  public static final RegistryObject<Block> CHERRY_MOSAIC = registerBlock("cherry_mosaic", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
  public static final RegistryObject<Block> CHERRY_MOSAIC_SLAB = registerBlock("cherry_mosaic_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CHERRY_MOSAIC.get())));
  public static final RegistryObject<Block> CHERRY_MOSAIC_STAIRS = registerBlock("cherry_mosaic_stairs", () -> new StairBlock(CHERRY_MOSAIC.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CHERRY_MOSAIC.get())));
  public static final RegistryObject<Block> CARVED_CHERRY_LOG = registerBlock("carved_cherry_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_LOG)));
  public static final RegistryObject<Block> CARVED_CHERRY_WOOD = registerBlock("carved_cherry_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_CHERRY_WOOD)));
  public static final RegistryObject<Block> CARVED_BAMBOO_BLOCK = registerBlock("carved_bamboo_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_BAMBOO_BLOCK)));
  public static final RegistryObject<Block> MOSSY_BRICKS = registerBlock("mossy_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
  public static final RegistryObject<Block> MOSSY_BRICK_SLAB = registerBlock("mossy_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_BRICK_STAIRS = registerBlock("mossy_brick_stairs", () -> new StairBlock(MOSSY_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_BRICKS.get())));
  public static final RegistryObject<Block> MOSSY_BRICK_WALL = registerBlock("mossy_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.MOSSY_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_BRICKS_BLOCK = registerBlock("cracked_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BRICKS)));
  public static final RegistryObject<Block> TILED_GLASS = registerBlock("tiled_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
  public static final RegistryObject<Block> TILED_TINTED_GLASS = registerBlock("tiled_tinted_glass", () -> new TintedGlassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TINTED_GLASS)));
  public static final RegistryObject<Block> WHITE_STAINED_TILED_GLASS = registerBlock("white_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
  public static final RegistryObject<Block> LIGHT_GRAY_STAINED_TILED_GLASS = registerBlock("light_gray_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
  public static final RegistryObject<Block> GRAY_STAINED_TILED_GLASS = registerBlock("gray_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
  public static final RegistryObject<Block> BLACK_STAINED_TILED_GLASS = registerBlock("black_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
  public static final RegistryObject<Block> BROWN_STAINED_TILED_GLASS = registerBlock("brown_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
  public static final RegistryObject<Block> RED_STAINED_TILED_GLASS = registerBlock("red_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
  public static final RegistryObject<Block> ORANGE_STAINED_TILED_GLASS = registerBlock("orange_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
  public static final RegistryObject<Block> YELLOW_STAINED_TILED_GLASS = registerBlock("yellow_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
  public static final RegistryObject<Block> LIME_STAINED_TILED_GLASS = registerBlock("lime_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
  public static final RegistryObject<Block> GREEN_STAINED_TILED_GLASS = registerBlock("green_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
  public static final RegistryObject<Block> CYAN_STAINED_TILED_GLASS = registerBlock("cyan_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
  public static final RegistryObject<Block> LIGHT_BLUE_STAINED_TILED_GLASS = registerBlock("light_blue_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
  public static final RegistryObject<Block> BLUE_STAINED_TILED_GLASS = registerBlock("blue_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
  public static final RegistryObject<Block> PURPLE_STAINED_TILED_GLASS = registerBlock("purple_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
  public static final RegistryObject<Block> MAGENTA_STAINED_TILED_GLASS = registerBlock("magenta_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
  public static final RegistryObject<Block> PINK_STAINED_TILED_GLASS = registerBlock("pink_stained_tiled_glass", () -> new StainedGlassBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
  public static final RegistryObject<Block> TILED_GLASS_PANE = registerBlock("tiled_glass_pane", () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS_PANE)));
  public static final RegistryObject<Block> WHITE_STAINED_TILED_GLASS_PANE = registerBlock("white_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> LIGHT_GRAY_STAINED_TILED_GLASS_PANE = registerBlock("light_gray_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> GRAY_STAINED_TILED_GLASS_PANE = registerBlock("gray_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> BLACK_STAINED_TILED_GLASS_PANE = registerBlock("black_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> BROWN_STAINED_TILED_GLASS_PANE = registerBlock("brown_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> RED_STAINED_TILED_GLASS_PANE = registerBlock("red_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> ORANGE_STAINED_TILED_GLASS_PANE = registerBlock("orange_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> YELLOW_STAINED_TILED_GLASS_PANE = registerBlock("yellow_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> LIME_STAINED_TILED_GLASS_PANE = registerBlock("lime_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> GREEN_STAINED_TILED_GLASS_PANE = registerBlock("green_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> CYAN_STAINED_TILED_GLASS_PANE = registerBlock("cyan_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> LIGHT_BLUE_STAINED_TILED_GLASS_PANE = registerBlock("light_blue_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> BLUE_STAINED_TILED_GLASS_PANE = registerBlock("blue_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> PURPLE_STAINED_TILED_GLASS_PANE = registerBlock("purple_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> MAGENTA_STAINED_TILED_GLASS_PANE = registerBlock("magenta_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> PINK_STAINED_TILED_GLASS_PANE = registerBlock("pink_stained_tiled_glass_pane", () -> new StainedGlassPaneBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS_PANE)));
  public static final RegistryObject<Block> BONE_BRICKS = registerBlock("bone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));
  public static final RegistryObject<Block> BONE_BRICK_SLAB = registerBlock("bone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BONE_BRICKS.get())));
  public static final RegistryObject<Block> BONE_BRICK_STAIRS = registerBlock("bone_brick_stairs", () -> new StairBlock(BONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BONE_BRICKS.get())));
  public static final RegistryObject<Block> BONE_BRICK_WALL = registerBlock("bone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BONE_BRICKS.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_BONE_BRICKS = registerBlock("cracked_bone_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));
  public static final RegistryObject<Block> BONE_TILES = registerBlock("bone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));
  public static final RegistryObject<Block> BONE_TILE_SLAB = registerBlock("bone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BONE_TILES.get())));
  public static final RegistryObject<Block> BONE_TILE_STAIRS = registerBlock("bone_tile_stairs", () -> new StairBlock(BONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BONE_TILES.get())));
  public static final RegistryObject<Block> BONE_TILE_WALL = registerBlock("bone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.BONE_TILES.get()).forceSolidOn()));
  public static final RegistryObject<Block> CRACKED_BONE_TILES = registerBlock("cracked_bone_tiles", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)));
  public static final RegistryObject<Block> COPPER_BRICKS = registerBlock("copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK)));
  public static final RegistryObject<Block> EXPOSED_COPPER_BRICKS = registerBlock("exposed_copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER)));
  public static final RegistryObject<Block> WEATHERED_COPPER_BRICKS = registerBlock("weathered_copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER)));
  public static final RegistryObject<Block> OXIDIZED_COPPER_BRICKS = registerBlock("oxidized_copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER)));
  public static final RegistryObject<Block> WAXED_COPPER_BRICKS = registerBlock("waxed_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_BRICKS = registerBlock("waxed_exposed_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.EXPOSED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_BRICKS = registerBlock("waxed_weathered_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WEATHERED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_BRICKS = registerBlock("waxed_oxidized_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.OXIDIZED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> CRACKED_COPPER_BRICKS = registerBlock("cracked_copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(SMBBlocks.COPPER_BRICKS.get())));
  public static final RegistryObject<Block> EXPOSED_CRACKED_COPPER_BRICKS = registerBlock("exposed_cracked_copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(SMBBlocks.EXPOSED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WEATHERED_CRACKED_COPPER_BRICKS = registerBlock("weathered_cracked_copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WEATHERED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> OXIDIZED_CRACKED_COPPER_BRICKS = registerBlock("oxidized_cracked_copper_bricks", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(SMBBlocks.OXIDIZED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WAXED_CRACKED_COPPER_BRICKS = registerBlock("waxed_cracked_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CRACKED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WAXED_EXPOSED_CRACKED_COPPER_BRICKS = registerBlock("waxed_exposed_cracked_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WAXED_WEATHERED_CRACKED_COPPER_BRICKS = registerBlock("waxed_weathered_cracked_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> WAXED_OXIDIZED_CRACKED_COPPER_BRICKS = registerBlock("waxed_oxidized_cracked_copper_bricks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get())));
  public static final RegistryObject<Block> CRACKED_CUT_COPPER = registerBlock("cracked_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER)));
  public static final RegistryObject<Block> EXPOSED_CRACKED_CUT_COPPER = registerBlock("exposed_cracked_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_CUT_COPPER)));
  public static final RegistryObject<Block> WEATHERED_CRACKED_CUT_COPPER = registerBlock("weathered_cracked_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_CUT_COPPER)));
  public static final RegistryObject<Block> OXIDIZED_CRACKED_CUT_COPPER = registerBlock("oxidized_cracked_cut_copper", () -> new WeatheringCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_CUT_COPPER)));
  public static final RegistryObject<Block> WAXED_CRACKED_CUT_COPPER = registerBlock("waxed_cracked_cut_copper", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.CRACKED_CUT_COPPER.get())));
  public static final RegistryObject<Block> WAXED_EXPOSED_CRACKED_CUT_COPPER = registerBlock("waxed_exposed_cracked_cut_copper", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get())));
  public static final RegistryObject<Block> WAXED_WEATHERED_CRACKED_CUT_COPPER = registerBlock("waxed_weathered_cracked_cut_copper", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get())));
  public static final RegistryObject<Block> WAXED_OXIDIZED_CRACKED_CUT_COPPER = registerBlock("waxed_oxidized_cracked_cut_copper", () -> new Block(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get())));
  public static final RegistryObject<Block> COPPER_PILLAR = registerBlock("copper_pillar", () -> new WeatheringRotatedCopperFullBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER)));
  public static final RegistryObject<Block> EXPOSED_COPPER_PILLAR = registerBlock("exposed_copper_pillar", () -> new WeatheringRotatedCopperFullBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_CUT_COPPER)));
  public static final RegistryObject<Block> WEATHERED_COPPER_PILLAR = registerBlock("weathered_copper_pillar", () -> new WeatheringRotatedCopperFullBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_CUT_COPPER)));
  public static final RegistryObject<Block> OXIDIZED_COPPER_PILLAR = registerBlock("oxidized_copper_pillar", () -> new WeatheringRotatedCopperFullBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_CUT_COPPER)));
  public static final RegistryObject<Block> WAXED_COPPER_PILLAR = registerBlock("waxed_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.COPPER_PILLAR.get())));
  public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_PILLAR = registerBlock("waxed_exposed_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.EXPOSED_COPPER_PILLAR.get())));
  public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_PILLAR = registerBlock("waxed_weathered_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.WEATHERED_COPPER_PILLAR.get())));
  public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_PILLAR = registerBlock("waxed_oxidized_copper_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(SMBBlocks.OXIDIZED_COPPER_PILLAR.get())));

  /**
   * Create and register a generic flower pot.
   *
   * @param identifier The Block identifier.
   * @param plant The Plant-like block instance.
   * @return The registered potted flower block.
   */
  private static RegistryObject<Block> createAndRegisterFlowerPotBlock(String identifier, Supplier<Block> plant) {
    return registerBlock(identifier,
      () -> new FlowerPotBlock(() ->
        ((FlowerPotBlock) Blocks.FLOWER_POT),
        plant,
        BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)
      ),
      false, null
    );
  }

  /**
   * Create and register a generic flower pot with light level.
   *
   * @param identifier The Block identifier.
   * @param plant The Plant-like block instance.
   * @param lightLevel The light level.
   * @return The registered potted flower block.
   */
  private static RegistryObject<Block> createAndRegisterFlowerPotBlock(String identifier, Supplier<Block> plant, int lightLevel) {
    return registerBlock(identifier,
      () -> new FlowerPotBlock(() ->
        ((FlowerPotBlock) Blocks.FLOWER_POT),
        plant,
        BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel((state) -> lightLevel)
      ),
      false, null
    );
  }

  /**
   * Create and register a generic block.
   *
   * @param identifier The Block identifier.
   * @param block The block instance.
   * @return The registered block.
   */
  private static <T extends Block> RegistryObject<T> registerBlock(String identifier, Supplier<T> block) {
    return registerBlock(identifier, block, true, null);
  }

  /**
   * Create and register a generic block.
   *
   * @param identifier The Block identifier.
   * @param block The block instance.
   * @param registerItemBlock If true, auto-register the BlockItem instance.
   * @return The registered block.
   */
  private static <T extends Block> RegistryObject<T> registerBlock(String identifier, Supplier<T> block, boolean registerItemBlock) {
    return registerBlock(identifier, block, registerItemBlock, null);
  }

  /**
   * Create and register a generic block.
   *
   * @param identifier The Block identifier.
   * @param block The block instance.
   * @param fuel The fuel values for the block. Like the "Block of Coal".
   * @return The registered block.
   */
  private static <T extends Block> RegistryObject<T> registerBlock(String identifier, Supplier<T> block, Integer fuel) {
    return registerBlock(identifier, block, true, fuel);
  }

  /**
   * Create and register a generic block.
   *
   * @param identifier The Block identifier.
   * @param block The block instance.
   * @param registerItemBlock If true, auto-register the BlockItem instance.
   * @param fuel The fuel values for the block. Like the "Block of Coal".
   * @return The registered block.
   */
  private static <T extends Block> RegistryObject<T> registerBlock(String identifier, Supplier<T> block, boolean registerItemBlock, @Nullable Integer fuel) {
    RegistryObject<T> blockInstance = BLOCKS.register(identifier, block);

    if (registerItemBlock && fuel == null) {
      registerBlockItem(identifier, blockInstance);
    } else if (fuel != null) {
      registerBlockItemWithFuel(identifier, blockInstance, fuel);
    }

    return blockInstance;
  }

  /**
   * Create and register a generic block.
   *
   * @param identifier The Block identifier.
   * @param block The block instance.
   */
  private static <T extends Block> void registerBlockItem(String identifier, RegistryObject<T> block) {
    SMBItems.registerItem(identifier, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  /**
   * Create and register a generic block.
   *
   * @param identifier The Block identifier.
   * @param block The block instance.
   * @param fuel The fuel values for the block. Like the "Block of Coal".
   */
  private static <T extends Block> void registerBlockItemWithFuel(String identifier, RegistryObject<T> block, int fuel) {
    SMBItems.registerItem(identifier, () -> new FuelBlockItem(block.get(), new Item.Properties(), fuel));
  }

  public static void register(IEventBus event) {
    BLOCKS.register(event);
  }
}
