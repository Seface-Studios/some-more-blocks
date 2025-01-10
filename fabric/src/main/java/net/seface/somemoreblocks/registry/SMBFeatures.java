package net.seface.somemoreblocks.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.seface.somemoreblocks.data.MBBlockTags;
import net.seface.somemoreblocks.data.MBPlacedFeature;
import net.seface.somemoreblocks.worldgen.feature.FallenLeafFeature;

public class SMBFeatures {
  public static final FallenLeafFeature LEAF_LITTER_FEATURE = new FallenLeafFeature(NoneFeatureConfiguration.CODEC)
    .addLeafLitterBlock(MBBlockTags.LEAF_LITTER_PARENT_LEAVES, SMBBlocks.LEAF_LITTER)
    .addLeafLitterBlock(MBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.BIRCH_LEAF_LITTER)
    .addLeafLitterBlock(MBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.SPRUCE_LEAF_LITTER)
    .addLeafLitterBlock(MBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.AZALEA_LEAF_LITTER)
    .addLeafLitterBlock(MBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER);

  public static void register() {
    Registry.register(BuiltInRegistries.FEATURE, MBPlacedFeature.NONE_LEAF_LITTER.location(), LEAF_LITTER_FEATURE);
  }
}
