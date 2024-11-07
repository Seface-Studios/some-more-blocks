package net.seface.moreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class MBBiomeTags extends MoreBlocksDataDriven {
  public static final TagKey<Biome> GENERATES_CATTAIL = create(Registries.BIOME, "generates_cattail");
  public static final TagKey<Biome> GENERATES_LUMINOUS_FLOWER = create(Registries.BIOME, "generates_luminous_flower");
  public static final TagKey<Biome> GENERATES_SMALL_LILY_PADS = MoreBlocksDataDriven.create(Registries.BIOME, "generates_small_lily_pads");
  public static final TagKey<Biome> GENERATES_TINY_CACTUS = create(Registries.BIOME, "generates_tiny_cactus");

  private MBBiomeTags() {}
}
