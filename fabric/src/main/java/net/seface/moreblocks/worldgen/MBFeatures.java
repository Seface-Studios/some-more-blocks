package net.seface.moreblocks.worldgen;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.seface.moreblocks.data.MBPlacedFeature;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.tags.MBBlockTags;
import net.seface.moreblocks.worldgen.feature.FallenLeafFeature;

public class MBFeatures {
  public static final FallenLeafFeature LEAF_LITTER_FEATURE = new FallenLeafFeature(NoneFeatureConfiguration.CODEC)
    .addLeafBlock(MBBlockTags.LEAF_LITTER_PARENT_LEAVES, MBBlocks.LEAF_LITTER)
    .addLeafBlock(MBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, MBBlocks.BIRCH_LEAF_LITTER)
    .addLeafBlock(MBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, MBBlocks.SPRUCE_LEAF_LITTER)
    .addLeafBlock(MBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, MBBlocks.AZALEA_LEAF_LITTER)
    .addLeafBlock(MBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, MBBlocks.FLOWERING_AZALEA_LEAF_LITTER);

  public static void register() {
    Registry.register(BuiltInRegistries.FEATURE, MBPlacedFeature.NONE_LEAF_LITTER.location(), LEAF_LITTER_FEATURE);
  }
}
