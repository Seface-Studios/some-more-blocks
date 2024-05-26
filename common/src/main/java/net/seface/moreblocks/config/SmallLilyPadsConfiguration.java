package net.seface.moreblocks.config;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class SmallLilyPadsConfiguration {
    public static List<String> SUPPORTED_BIOMES = List.of(
            "minecraft:lush_caves",
            "minecraft:mangrove_swamp",
            "minecraft:jungle",
            "minecraft:bamboo_jungle",
            "minecraft:sparse_jungle"
    );

    public static boolean isSupportedBiome(ResourceKey<Biome> biomeKey) {
        return SUPPORTED_BIOMES.contains(biomeKey.location().toString());
    }
}
