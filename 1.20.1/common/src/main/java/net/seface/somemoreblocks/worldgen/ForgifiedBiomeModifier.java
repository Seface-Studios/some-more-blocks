package net.seface.somemoreblocks.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * Only valid to Forge and NeoForge versions.
 */
public interface ForgifiedBiomeModifier<T> {
  HolderSet<Biome> biomes(T biomeModifier);
  Holder<PlacedFeature> features(T biomeModifier);
}
