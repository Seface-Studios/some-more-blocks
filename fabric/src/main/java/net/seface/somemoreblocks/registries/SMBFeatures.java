package net.seface.somemoreblocks.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;
import net.seface.somemoreblocks.worldgen.feature.FallenLeafFeature;

public class SMBFeatures {
  /*public static final FallenLeafFeature LEAF_LITTER_FEATURE = new FallenLeafFeature(NoneFeatureConfiguration.CODEC)
    .addLeafLitterBlock(SMBBlockTags.LEAF_LITTER_PARENT_LEAVES, SMBBlocks.LEAF_LITTER.get())
    .addLeafLitterBlock(SMBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.BIRCH_LEAF_LITTER.get())
    .addLeafLitterBlock(SMBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.SPRUCE_LEAF_LITTER.get())
    .addLeafLitterBlock(SMBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.AZALEA_LEAF_LITTER.get())
    .addLeafLitterBlock(SMBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get())
    .addLeafLitterBlock(SMBBlockTags.PALE_OAK_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.PALE_OAK_LEAF_LITTER.get());*/

  public static void init() {
    //Registry.register(BuiltInRegistries.FEATURE, SMBPlacedFeature.NONE_LEAF_LITTER.location(), LEAF_LITTER_FEATURE);
  }
}
