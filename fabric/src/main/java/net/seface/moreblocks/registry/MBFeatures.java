package net.seface.moreblocks.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.seface.moreblocks.worldgen.feature.CattailFeature;

public class MBFeatures {
    public static final CattailFeature CATTAIL_FEATURE = new CattailFeature(CattailFeature.Configuration.CODEC);
    /*public static final ConfiguredFeature<CattailFeature.Configuration, CattailFeature> CATTAIL_FEATURE_CONFIGURED = new ConfiguredFeature<>(
            CATTAIL_FEATURE,
            new CattailFeature.Configuration(10, new ResourceLocation("moreblocks", "netherite_bricks"))
    );*/

    public static void register() {
        Registry.register(BuiltInRegistries.FEATURE, CattailFeature.ID, CATTAIL_FEATURE);
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Decoration.VEGETAL_DECORATION,
                ResourceKey.create(Registries.PLACED_FEATURE, CattailFeature.ID));
    }
}
