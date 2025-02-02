package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.worldgen.feature.FallenLeafFeature;

import java.util.function.Supplier;

public class SMBFeatures {
  private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SomeMoreBlocks.ID);

  public static final RegistryObject<FallenLeafFeature> LEAF_LITTER_FEATURE = registerFeature("none_leaf_litter",
    () -> new FallenLeafFeature(NoneFeatureConfiguration.CODEC)
      .addLeafLitterBlock(SMBBlockTags.LEAF_LITTER_PARENT_LEAVES, SMBBlocks.LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.BIRCH_LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.SPRUCE_LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.AZALEA_LEAF_LITTER.get())
      .addLeafLitterBlock(SMBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get())
  );

  /**
   * Create and register a generic feature.
   *
   * @param identifier The Feature identifier.
   * @param feature The feature instance.
   */
  private static <T extends Feature<?>> RegistryObject<T> registerFeature(String identifier, Supplier<T> feature) {
      return FEATURES.register(identifier, feature);
  }

  public static void init(IEventBus event) {
    FEATURES.register(event);
  }
}
