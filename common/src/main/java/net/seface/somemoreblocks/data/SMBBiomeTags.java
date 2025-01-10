package net.seface.somemoreblocks.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class SMBBiomeTags extends SMBAbstractData {
  public static final TagKey<Biome> GENERATES_CATTAIL = createTagKey(Registries.BIOME, "generates_cattail");
  public static final TagKey<Biome> GENERATES_LUMINOUS_FLOWER = createTagKey(Registries.BIOME, "generates_luminous_flower");
  public static final TagKey<Biome> GENERATES_SMALL_LILY_PADS = SMBAbstractData.createTagKey(Registries.BIOME, "generates_small_lily_pads");
  public static final TagKey<Biome> GENERATES_TINY_CACTUS = createTagKey(Registries.BIOME, "generates_tiny_cactus");

  private SMBBiomeTags() {}
}
