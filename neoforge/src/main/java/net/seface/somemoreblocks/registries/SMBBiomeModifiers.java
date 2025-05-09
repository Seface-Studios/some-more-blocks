package net.seface.somemoreblocks.registries;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.worldgen.PatchDunePlantsBiomeModifier;

import java.util.function.BiFunction;
import java.util.function.Supplier;

interface IBiomeModifier {
  HolderSet<Biome> biomes(BiomeModifier biomeModifier);
  Holder<PlacedFeature> feature(BiomeModifier biomeModifier);
}

public class SMBBiomeModifiers {
  public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, SomeMoreBlocks.ID);

  public static Supplier<MapCodec<PatchDunePlantsBiomeModifier>> PATCH_DUNE_GRASS = registerBiomeModifier("patch_dune_grass", PatchDunePlantsBiomeModifier::new);

  /**
   * Register a new biome modifier.
   * @param path The identifier path.
   * @param factory The construction function of biome modifier.
   * @return The biome modifier object.
   */
  private static <T extends BiomeModifier> Supplier<MapCodec<T>> registerBiomeModifier(String path, BiFunction<HolderSet<Biome>, Holder<PlacedFeature>, T> factory) {
    return BIOME_MODIFIERS.register(path, () ->
      RecordCodecBuilder.mapCodec(builder -> builder.group(
        Biome.LIST_CODEC.fieldOf("biomes").forGetter((instance) -> ((IBiomeModifier) instance).biomes(instance)),
        PlacedFeature.CODEC.fieldOf("features").forGetter((instance) -> ((IBiomeModifier) instance).feature(instance))
      ).apply(builder, factory))
    );
  }

  public static void init(IEventBus event) {
    BIOME_MODIFIERS.register(event);
  }
}
