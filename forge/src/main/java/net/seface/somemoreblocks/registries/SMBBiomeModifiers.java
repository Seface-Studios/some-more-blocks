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
  public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SomeMoreBlocks.ID);

  public static RegistryObject<MapCodec<NoneBigLilyPadBiomeModifier>> NONE_BIG_LILY_PAD = registerBiomeModifier("none_big_lily_pad", NoneBigLilyPadBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchCactusPlantsBiomeModifier>> PATCH_CACTUS_PLANTS = registerBiomeModifier("patch_cactus_plants", PatchCactusPlantsBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchCattailBiomeModifier>> PATCH_CATTAIL = registerBiomeModifier("patch_cattail", PatchCattailBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchDunePlantsBiomeModifier>> PATCH_DUNE_GRASS = registerBiomeModifier("patch_dune_grass", PatchDunePlantsBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchSnowPlantsBiomeModifier>> PATCH_LARGE_SNOW_FERN = registerBiomeModifier("patch_large_snow_fern", PatchSnowPlantsBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchLuminousFlowerBiomeModifier>> PATCH_LUMINOUS_FLOWER = registerBiomeModifier("patch_luminous_flower", PatchLuminousFlowerBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchSmallLilyPadsBiomeModifier>> PATCH_SMALL_LILY_PADS = registerBiomeModifier("patch_small_lily_pads", PatchSmallLilyPadsBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchSmallLilyPadsLushCavesBiomeModifier>> PATCH_SMALL_LILY_PADS_LUSH_CAVES = registerBiomeModifier("patch_small_lily_pads_lush_caves", PatchSmallLilyPadsLushCavesBiomeModifier::new);
  public static RegistryObject<MapCodec<PatchSnowPlantsBiomeModifier>> PATCH_SNOW_GRASS = registerBiomeModifier("patch_snow_grass", PatchSnowPlantsBiomeModifier::new);
  public static RegistryObject<MapCodec<SimpleLeafLitterBiomeModifier>> SIMPLE_BLOCK_AZALEA_LEAF_LITTER = registerBiomeModifier("simple_block_azalea_leaf_litter", (holders, featureHolder) -> new SimpleLeafLitterBiomeModifier(holders, featureHolder, "simple_block_azalea_leaf_litter"));
  public static RegistryObject<MapCodec<SimpleLeafLitterBiomeModifier>> SIMPLE_BLOCK_BIRCH_LEAF_LITTER = registerBiomeModifier("simple_block_birch_leaf_litter", (holders, featureHolder) -> new SimpleLeafLitterBiomeModifier(holders, featureHolder, "simple_block_birch_leaf_litter"));
  public static RegistryObject<MapCodec<SimpleLeafLitterBiomeModifier>> SIMPLE_BLOCK_FLOWERING_AZALEA_LEAF_LITTER = registerBiomeModifier("simple_block_flowering_azalea_leaf_litter", (holders, featureHolder) -> new SimpleLeafLitterBiomeModifier(holders, featureHolder, "simple_block_flowering_azalea_leaf_litter"));
  public static RegistryObject<MapCodec<SimpleLeafLitterBiomeModifier>> SIMPLE_BLOCK_LEAF_LITTER = registerBiomeModifier("simple_block_leaf_litter", (holders, featureHolder) -> new SimpleLeafLitterBiomeModifier(holders, featureHolder, "simple_block_leaf_litter"));
  public static RegistryObject<MapCodec<SimpleLeafLitterBiomeModifier>> SIMPLE_BLOCK_PALE_OAK_LEAF_LITTER = registerBiomeModifier("simple_block_pale_oak_leaf_litter", (holders, featureHolder) -> new SimpleLeafLitterBiomeModifier(holders, featureHolder, "simple_block_pale_oak_leaf_litter"));
  public static RegistryObject<MapCodec<SimpleLeafLitterBiomeModifier>> SIMPLE_BLOCK_SPRUCE_LEAF_LITTER = registerBiomeModifier("simple_block_spruce_leaf_litter", (holders, featureHolder) -> new SimpleLeafLitterBiomeModifier(holders, featureHolder, "simple_block_spruce_leaf_litter"));

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
