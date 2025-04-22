package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.worldgen.feature.BigLilyPadFeature;
import net.seface.somemoreblocks.worldgen.feature.FallenLeafFeature;

public class SMBFeatures {
  public static final PlatformRegistryObject<Feature<NoneFeatureConfiguration>> NONE_LEAF_LITTER_FEATURE = PlatformServices.REGISTRY.registerFeature("none_leaf_litter", () -> new FallenLeafFeature(NoneFeatureConfiguration.CODEC));
  public static final PlatformRegistryObject<Feature<NoneFeatureConfiguration>> NONE_BIG_LILY_FEATURE = PlatformServices.REGISTRY.registerFeature("none_big_lily_feature", () -> new BigLilyPadFeature(NoneFeatureConfiguration.CODEC));

  public static void init() {}
}
