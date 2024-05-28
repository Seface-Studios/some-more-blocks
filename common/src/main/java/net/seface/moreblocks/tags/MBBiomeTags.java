package net.seface.moreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class MBBiomeTags extends MBCustomTags {
    public static final TagKey<Biome> CAN_GENERATE_SMALL_LILY_PADS = register(Registries.BIOME, "can_generate_small_lily_pads");

    private MBBiomeTags() {}
}
