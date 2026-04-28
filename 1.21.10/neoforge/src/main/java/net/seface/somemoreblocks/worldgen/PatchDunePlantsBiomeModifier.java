package net.seface.somemoreblocks.worldgen;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

public record PatchDunePlantsBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) implements BiomeModifier {

  @Override
  public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
    if (phase == Phase.ADD && biomes.contains(biome) && biome.value().getBaseTemperature() >= 0.5F) {
      builder.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
    }
  }

  @Override
  public MapCodec<? extends BiomeModifier> codec() {
    return SMBBiomeModifiers.PATCH_DUNE_GRASS.get();
  }
}
