package net.seface.somemoreblocks.worldgen.modifiers;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

public record PatchSmallLilyPadsBiomeModifier(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) implements BiomeModifier {

  @Override
  public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
    if (phase == Phase.ADD && biomes.contains(biome)) {
      builder.getGenerationSettings().addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, feature);
    }
  }

  @Override
  public MapCodec<? extends BiomeModifier> codec() {
    return SMBBiomeModifiers.PATCH_SMALL_LILY_PADS.get();
  }
}
