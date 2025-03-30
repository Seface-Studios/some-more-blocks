package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.worldgen.feature.FallenLeafFeature;

public class SMBFeatures {
  public static final PlatformRegistryObject<Feature<?>> NONE_LEAF_LITTER_FEATURE = PlatformServices.REGISTRY.registerFeature("none_leaf_litter",
    () -> new FallenLeafFeature(NoneFeatureConfiguration.CODEC)
      .addLeafLitterBlock(SMBBlockTags.LEAF_LITTER_PARENT_LEAVES, SMBBlocks.LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.BIRCH_LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.SPRUCE_LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.AZALEA_LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.PALE_OAK_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.PALE_OAK_LEAF_LITTER.get()));

  public static void init() {}
}
