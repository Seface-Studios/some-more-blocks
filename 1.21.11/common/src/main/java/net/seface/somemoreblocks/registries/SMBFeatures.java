package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;
import net.seface.somemoreblocks.worldgen.feature.BigLilyPadFeature;
import net.seface.somemoreblocks.worldgen.feature.LeafLitterFeature;
import net.seface.somemoreblocks.worldgen.feature.configurations.SimpleLeafLitterBlockConfiguration;
import org.jetbrains.annotations.NotNull;

public class SMBFeatures {
  public static final PlatformRegistryObject<Feature<@NotNull SimpleLeafLitterBlockConfiguration>> SIMPLE_BLOCK_LEAF_LITTER = PlatformServices.REGISTRY.registerFeature("simple_block_leaf_litter", () -> new LeafLitterFeature(SimpleLeafLitterBlockConfiguration.CODEC));
  public static final PlatformRegistryObject<Feature<@NotNull NoneFeatureConfiguration>> NONE_BIG_LILY_FEATURE = PlatformServices.REGISTRY.registerFeature("none_big_lily_feature", () -> new BigLilyPadFeature(NoneFeatureConfiguration.CODEC));

  public static void init() {}
}
