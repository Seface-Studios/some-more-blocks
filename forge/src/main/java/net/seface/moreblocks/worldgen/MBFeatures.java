package net.seface.moreblocks.worldgen;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.moreblocks.MoreBlocks;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.tags.MBBlockTags;
import net.seface.moreblocks.worldgen.feature.FallenLeafFeature;

import java.util.function.Supplier;

public class MBFeatures {
  private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, MoreBlocks.ID);

  public static final RegistryObject<FallenLeafFeature> LEAF_LITTER_FEATURE = registerFeature("none_leaf_litter",
    () -> new FallenLeafFeature(NoneFeatureConfiguration.CODEC)
      .addLeafBlock(MBBlockTags.LEAF_LITTER_PARENT_LEAVES, MBBlocks.LEAF_LITTER.get())
      .addLeafBlock(MBBlockTags.BIRCH_LEAF_LITTER_PARENT_LEAVES, MBBlocks.BIRCH_LEAF_LITTER.get())
      .addLeafBlock(MBBlockTags.SPRUCE_LEAF_LITTER_PARENT_LEAVES, MBBlocks.SPRUCE_LEAF_LITTER.get())
      .addLeafBlock(MBBlockTags.AZALEA_LEAF_LITTER_PARENT_LEAVES, MBBlocks.AZALEA_LEAF_LITTER.get())
      .addLeafBlock(MBBlockTags.FLOWERING_AZALEA_LEAF_LITTER_PARENT_LEAVES, MBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get())
  );

  private static <T extends Feature<?>> RegistryObject<T> registerFeature(String name, Supplier<T> feature) {
      return FEATURES.register(name, feature);
  }

  public static void register(IEventBus event) {
    FEATURES.register(event);
  }
}
