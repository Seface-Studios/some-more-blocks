package net.seface.moreblocks.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.moreblocks.MoreBlocks;
import net.seface.moreblocks.worldgen.modifiers.*;

import java.util.function.BiFunction;

interface IBiomeModifier {
  HolderSet<Biome> biomes(BiomeModifier biomeModifier);
  Holder<PlacedFeature> feature(BiomeModifier biomeModifier);
}

public class MBBiomeModifier {
  private static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MoreBlocks.ID);

  public static RegistryObject<Codec<PatchCattailBiomeModifier>> PATCH_CATTAIL = createCodec("patch_cattail", PatchCattailBiomeModifier::new);
  public static RegistryObject<Codec<PatchLuminousFlowerBiomeModifier>> PATCH_LUMINOUS_FLOWER = createCodec("patch_luminous_flower", PatchLuminousFlowerBiomeModifier::new);
  public static RegistryObject<Codec<PatchSmallLilyPadBiomeModifier>> PATCH_SMALL_LILY_PADS = createCodec("patch_small_lily_pads", PatchSmallLilyPadBiomeModifier::new);
  public static RegistryObject<Codec<PatchTinyCactusBiomeModifier>> PATCH_TINY_CACTUS = createCodec("patch_tiny_cactus", PatchTinyCactusBiomeModifier::new);
  public static RegistryObject<Codec<PatchDuneGrassBiomeModifier>> PATCH_DUNE_GRASS = createCodec("patch_dune_grass", PatchDuneGrassBiomeModifier::new);
  public static RegistryObject<Codec<PatchTallDuneGrassBiomeModifier>> PATCH_TALL_DUNE_GRASS = createCodec("patch_tall_dune_grass", PatchTallDuneGrassBiomeModifier::new);
  public static RegistryObject<Codec<NoneLeafLitterBiomeModifier>> NONE_LEAF_LITTER = createCodec("none_leaf_litter", NoneLeafLitterBiomeModifier::new);

  private static <T extends BiomeModifier> RegistryObject<Codec<T>> createCodec(String name, BiFunction<HolderSet<Biome>, Holder<PlacedFeature>, T> factory) {
    return BIOME_MODIFIERS.register(name, () ->
      RecordCodecBuilder.create(builder -> builder.group(
        Biome.LIST_CODEC.fieldOf("biomes").forGetter((instance) -> ((IBiomeModifier) instance).biomes(instance)),
        PlacedFeature.CODEC.fieldOf("feature").forGetter((instance) -> ((IBiomeModifier) instance).feature(instance))
      ).apply(builder, factory))
    );
  }

  public static void register(IEventBus event) { BIOME_MODIFIERS.register(event); }
}
