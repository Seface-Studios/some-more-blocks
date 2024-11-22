package net.seface.moreblocks.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.seface.moreblocks.registry.MBBlocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {

  @Final
  @Shadow
  protected static final Map<Block, Block> STRIPPABLES = (new ImmutableMap.Builder())
    .put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD)
    .put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
    .put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
    .put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG)
    .put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
    .put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG)
    .put(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
    .put(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG)
    .put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
    .put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG)
    .put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
    .put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG)
    .put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
    .put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG)
    .put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
    .put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
    .put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
    .put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE)
    .put(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD)
    .put(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG)
    .put(Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK)

    // Carved
    .put(Blocks.STRIPPED_OAK_WOOD, MBBlocks.CARVED_OAK_WOOD)
    .put(Blocks.STRIPPED_OAK_LOG, MBBlocks.CARVED_OAK_LOG)
    .put(Blocks.STRIPPED_DARK_OAK_WOOD, MBBlocks.CARVED_DARK_OAK_WOOD)
    .put(Blocks.STRIPPED_DARK_OAK_LOG, MBBlocks.CARVED_DARK_OAK_LOG)
    .put(Blocks.STRIPPED_ACACIA_WOOD, MBBlocks.CARVED_ACACIA_WOOD)
    .put(Blocks.STRIPPED_ACACIA_LOG, MBBlocks.CARVED_ACACIA_LOG)
    .put(Blocks.STRIPPED_CHERRY_WOOD, MBBlocks.CARVED_CHERRY_WOOD)
    .put(Blocks.STRIPPED_CHERRY_LOG, MBBlocks.CARVED_CHERRY_LOG)
    .put(Blocks.STRIPPED_BIRCH_WOOD, MBBlocks.CARVED_BIRCH_WOOD)
    .put(Blocks.STRIPPED_BIRCH_LOG, MBBlocks.CARVED_BIRCH_LOG)
    .put(Blocks.STRIPPED_JUNGLE_WOOD, MBBlocks.CARVED_JUNGLE_WOOD)
    .put(Blocks.STRIPPED_JUNGLE_LOG, MBBlocks.CARVED_JUNGLE_LOG)
    .put(Blocks.STRIPPED_SPRUCE_WOOD, MBBlocks.CARVED_SPRUCE_WOOD)
    .put(Blocks.STRIPPED_SPRUCE_LOG, MBBlocks.CARVED_SPRUCE_LOG)
    .put(Blocks.STRIPPED_WARPED_STEM, MBBlocks.CARVED_WARPED_STEM)
    .put(Blocks.STRIPPED_WARPED_HYPHAE, MBBlocks.CARVED_WARPED_HYPHAE)
    .put(Blocks.STRIPPED_CRIMSON_STEM, MBBlocks.CARVED_CRIMSON_STEM)
    .put(Blocks.STRIPPED_CRIMSON_HYPHAE, MBBlocks.CARVED_CRIMSON_HYPHAE)
    .put(Blocks.STRIPPED_MANGROVE_WOOD, MBBlocks.CARVED_MANGROVE_WOOD)
    .put(Blocks.STRIPPED_MANGROVE_LOG, MBBlocks.CARVED_MANGROVE_LOG)
    .put(Blocks.STRIPPED_BAMBOO_BLOCK, MBBlocks.CARVED_BAMBOO_BLOCK)
    .build();
}
