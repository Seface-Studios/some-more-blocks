package net.seface.somemoreblocks.worldgen;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.data.MBBlockTags;
import net.seface.somemoreblocks.registry.SMBBlocks;
import net.seface.somemoreblocks.worldgen.feature.FallenLeafFeature;

import java.util.function.Supplier;

public class MBFeatures {
  private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SomeMoreBlocks.ID);

  public static final RegistryObject<FallenLeafFeature> LEAF_LITTER_FEATURE = registerFeature("none_leaf_litter",
    () -> new FallenLeafFeature(NoneFeatureConfiguration.CODEC)
      .addLeafLitterBlock(MBBlockTags.LEAF_LITTER_PARENT_LEAVES, SMBBlocks.LEAF_LITTER.get())
      .addLeafLitterBlock(MBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.BIRCH_LEAF_LITTER.get())
      .addLeafLitterBlock(MBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.SPRUCE_LEAF_LITTER.get())
      .addLeafLitterBlock(MBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.AZALEA_LEAF_LITTER.get())
      .addLeafLitterBlock(MBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get())
  );

  private static <T extends Feature<?>> RegistryObject<T> registerFeature(String name, Supplier<T> feature) {
      return FEATURES.register(name, feature);
  }

  public static void register(IEventBus event) {
    FEATURES.register(event);
  }
}
