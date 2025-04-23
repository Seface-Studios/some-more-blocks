package net.seface.somemoreblocks.registries;

import com.mojang.serialization.MapCodec;
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
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.worldgen.modifiers.*;

import java.util.function.BiFunction;

interface IBiomeModifier {
  HolderSet<Biome> biomes(BiomeModifier biomeModifier);
  Holder<PlacedFeature> feature(BiomeModifier biomeModifier);
}

public class SMBBiomeModifiers {
  private static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SomeMoreBlocks.ID);

  public static RegistryObject<MapCodec<PatchCattailBiomeModifier>> PATCH_CATTAIL = registerBiomeModifier("patch_cattail", PatchCattailBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchLuminousFlowerBiomeModifier>> PATCH_LUMINOUS_FLOWER = registerBiomeModifier("patch_luminous_flower", PatchLuminousFlowerBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchSmallLilyPadBiomeModifier>> PATCH_SMALL_LILY_PADS = registerBiomeModifier("patch_small_lily_pads", PatchSmallLilyPadBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchTinyCactusBiomeModifier>> PATCH_TINY_CACTUS = registerBiomeModifier("patch_tiny_cactus", PatchTinyCactusBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchDuneGrassBiomeModifier>> PATCH_DUNE_GRASS = registerBiomeModifier("patch_dune_grass", PatchDuneGrassBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchTallDuneGrassBiomeModifier>> PATCH_TALL_DUNE_GRASS = registerBiomeModifier("patch_tall_dune_grass", PatchTallDuneGrassBiomeModifier::new);
  public static RegistryObject<MapCodec<NoneLeafLitterBiomeModifier>> NONE_LEAF_LITTER = registerBiomeModifier("none_leaf_litter", NoneLeafLitterBiomeModifier::new);
  public static RegistryObject<MapCodec<NoneBigLilyPadBiomeModifier>> NONE_BIG_LILY_PAD = registerBiomeModifier("none_big_lily_pad", NoneBigLilyPadBiomeModifier::new);

  /**
   * Register a new biome modifier.
   * @param path The identifier path.
   * @param factory The construction function of biome modifier.
   * @return The biome modifier object.
   */
  private static <T extends BiomeModifier> RegistryObject<MapCodec<T>> registerBiomeModifier(String path, BiFunction<HolderSet<Biome>, Holder<PlacedFeature>, T> factory) {
    return BIOME_MODIFIERS.register(path, () ->
      RecordCodecBuilder.mapCodec(builder -> builder.group(
        Biome.LIST_CODEC.fieldOf("biomes").forGetter((instance) -> ((IBiomeModifier) instance).biomes(instance)),
        PlacedFeature.CODEC.fieldOf("feature").forGetter((instance) -> ((IBiomeModifier) instance).feature(instance))
      ).apply(builder, factory))
    );
  }

  public static void init(IEventBus event) {
    BIOME_MODIFIERS.register(event);
  }
}
