package net.seface.moreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class MBBiomeTags extends MoreBlocksTags {
  public static final TagKey<Biome> CAN_GENERATE_SMALL_LILY_PADS = register(Registries.BIOME, "can_generate_small_lily_pads");
  public static final TagKey<Biome> CAN_GENERATE_BIG_LILY_PAD = register(Registries.BIOME, "can_generate_big_lily_pad");
  public static final TagKey<Biome> CAN_GENERATE_TINY_CACTUS = register(Registries.BIOME, "can_generate_tiny_cactus");

    private MBBiomeTags() {}
}
