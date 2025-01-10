package net.seface.somemoreblocks.worldgen.modifiers;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

public record PatchTallDuneGrassBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) implements BiomeModifier {
  @Override
  public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
    if (phase == Phase.ADD && biomes.contains(biome) && biome.get().getBaseTemperature() >= 0.5F) {
      builder.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
    }
  }

  @Override
  public Codec<? extends BiomeModifier> codec() {
    return SMBBiomeModifiers.PATCH_TALL_DUNE_GRASS.get();
  }
}
