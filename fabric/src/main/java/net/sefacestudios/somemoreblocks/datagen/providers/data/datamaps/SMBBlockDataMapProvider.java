package net.sefacestudios.somemoreblocks.datagen.providers.data.datamaps;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.datagen_extras.data_maps.block.BlockDataMap;
import net.sefacestudios.datagen_extras.provider.neoforge.BlockDataMapProvider;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBBlockDataMapProvider extends BlockDataMapProvider {
  public SMBBlockDataMapProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generate(HolderLookup.Provider provider, Consumer<BlockDataMap> consumer) {
    this.addOxidizableBlock(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    this.addOxidizableBlock(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    this.addOxidizableBlock(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    this.addOxidizableBlock(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    this.addOxidizableBlock(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    this.addOxidizableBlock(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    this.addOxidizableBlock(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    this.addOxidizableBlock(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    this.addOxidizableBlock(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    this.addOxidizableBlock(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    this.addOxidizableBlock(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    this.addOxidizableBlock(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get());

    this.addWaxableBlock(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    this.addWaxableBlock(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    this.addWaxableBlock(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    this.addWaxableBlock(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    this.addWaxableBlock(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    this.addWaxableBlock(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    this.addWaxableBlock(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    this.addWaxableBlock(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    this.addWaxableBlock(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());

    this.addStrippableBlock(Blocks.STRIPPED_OAK_WOOD, SMBBlocks.CARVED_OAK_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_OAK_LOG, SMBBlocks.CARVED_OAK_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_DARK_OAK_WOOD, SMBBlocks.CARVED_DARK_OAK_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_DARK_OAK_LOG, SMBBlocks.CARVED_DARK_OAK_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_ACACIA_WOOD, SMBBlocks.CARVED_ACACIA_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_ACACIA_LOG, SMBBlocks.CARVED_ACACIA_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_CHERRY_WOOD, SMBBlocks.CARVED_CHERRY_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_CHERRY_LOG, SMBBlocks.CARVED_CHERRY_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_BIRCH_WOOD, SMBBlocks.CARVED_BIRCH_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_BIRCH_LOG, SMBBlocks.CARVED_BIRCH_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_JUNGLE_WOOD, SMBBlocks.CARVED_JUNGLE_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_JUNGLE_LOG, SMBBlocks.CARVED_JUNGLE_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_SPRUCE_WOOD, SMBBlocks.CARVED_SPRUCE_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_SPRUCE_LOG, SMBBlocks.CARVED_SPRUCE_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_WARPED_STEM, SMBBlocks.CARVED_WARPED_STEM.get());
    this.addStrippableBlock(Blocks.STRIPPED_WARPED_HYPHAE, SMBBlocks.CARVED_WARPED_HYPHAE.get());
    this.addStrippableBlock(Blocks.STRIPPED_CRIMSON_STEM, SMBBlocks.CARVED_CRIMSON_STEM.get());
    this.addStrippableBlock(Blocks.STRIPPED_CRIMSON_HYPHAE, SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
    this.addStrippableBlock(Blocks.STRIPPED_MANGROVE_WOOD, SMBBlocks.CARVED_MANGROVE_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_MANGROVE_LOG, SMBBlocks.CARVED_MANGROVE_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_PALE_OAK_LOG, SMBBlocks.CARVED_PALE_OAK_LOG.get());
    this.addStrippableBlock(Blocks.STRIPPED_PALE_OAK_WOOD, SMBBlocks.CARVED_PALE_OAK_WOOD.get());
    this.addStrippableBlock(Blocks.STRIPPED_BAMBOO_BLOCK, SMBBlocks.CARVED_BAMBOO_BLOCK.get());
    this.addStrippableBlock(Blocks.MUSHROOM_STEM, SMBBlocks.CARVED_MUSHROOM_STEM.get());
  }
}
