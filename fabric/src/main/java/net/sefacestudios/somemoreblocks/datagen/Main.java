package net.sefacestudios.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.sefacestudios.somemoreblocks.datagen.providers.assets.SMBModelProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.SMBBlockLootProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.SMBRecipeProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.advancements.SMBAdventureAdvancementsProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.advancements.SMBHusbandryAdvancementsProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.advancements.SMBNetherAdvancementsProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.datamaps.SMBBlockDataMapProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.datamaps.SMBItemDataMapProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.tags.SMBBiomeTagProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.tags.SMBBlockTagProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.tags.SMBItemTagProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.SMBBiomeModifierProvider;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.SMBFeatureProvider;
import net.sefacestudios.datagen_extras.utils.ModLoaderType;
import org.jetbrains.annotations.NotNull;

public class Main implements DataGeneratorEntrypoint {

  @Override
  public void onInitializeDataGenerator(FabricDataGenerator gen) {
    FabricDataGenerator.Pack pack = gen.createPack();

    /* Assets */
    pack.addProvider(SMBModelProvider::new);

    /* Data */
    pack.addProvider(SMBRecipeProvider::new);
    pack.addProvider(SMBItemTagProvider::new);
    pack.addProvider(SMBBiomeTagProvider::new);
    pack.addProvider(SMBBlockTagProvider::new);
    pack.addProvider(SMBBlockLootProvider::new);
    pack.addProvider(SMBFeatureProvider::new);
    pack.addProvider(SMBAdventureAdvancementsProvider::new);
    pack.addProvider(SMBHusbandryAdvancementsProvider::new);
    pack.addProvider(SMBNetherAdvancementsProvider::new);
    pack.addProvider(SMBBlockDataMapProvider::new);
    pack.addProvider(SMBItemDataMapProvider::new);
    pack.addProvider(SMBBiomeModifierProvider::new);
    pack.addProvider((output, registriesFuture) -> new SMBBiomeModifierProvider(output, registriesFuture, ModLoaderType.NEOFORGE));
  }

  @Override
  public void buildRegistry(@NotNull RegistrySetBuilder registryBuilder) {
    DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);

    registryBuilder.add(Registries.PLACED_FEATURE, SMBFeatureProvider::bootstrapF);
    registryBuilder.add(Registries.CONFIGURED_FEATURE, SMBFeatureProvider::bootstrapCF);
  }
}
