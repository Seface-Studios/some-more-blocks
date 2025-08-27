package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.seface.somemoreblocks.datagen.providers.assets.SMBModelProvider;
import net.seface.somemoreblocks.datagen.providers.data.SMBBlockLootProvider;
import net.seface.somemoreblocks.datagen.providers.data.SMBRecipeProvider;
import net.seface.somemoreblocks.datagen.providers.data.advancements.SMBAdventureAdvancementsProvider;
import net.seface.somemoreblocks.datagen.providers.data.advancements.SMBHusbandryAdvancementsProvider;
import net.seface.somemoreblocks.datagen.providers.data.advancements.SMBNetherAdvancementsProvider;
import net.seface.somemoreblocks.datagen.providers.data.datamaps.SMBCompostablesDataMapProvider;
import net.seface.somemoreblocks.datagen.providers.data.datamaps.SMBCopperBehaviorDataMapProvider;
import net.seface.somemoreblocks.datagen.providers.data.datamaps.SMBFurnaceFuelsDataMapProvider;
import net.seface.somemoreblocks.datagen.providers.data.tags.SMBBiomeTagProvider;
import net.seface.somemoreblocks.datagen.providers.data.tags.SMBBlockTagProvider;
import net.seface.somemoreblocks.datagen.providers.data.tags.SMBItemTagProvider;
import net.seface.somemoreblocks.datagen.providers.data.worldgen.SMBFeatureProvider;
import net.seface.somemoreblocks.datagen.providers.data.worldgen.SMBForgeBiomeModifierProvider;
import net.sefacestudios.datagen_extras.utils.ForgedModLoaders;

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
    pack.addProvider(SMBCopperBehaviorDataMapProvider::new);
    pack.addProvider(SMBFurnaceFuelsDataMapProvider::new);
    pack.addProvider(SMBCompostablesDataMapProvider::new);
    pack.addProvider(SMBForgeBiomeModifierProvider::new);
    pack.addProvider((output, registriesFuture) -> new SMBForgeBiomeModifierProvider(output, registriesFuture).setForgedModLoader(ForgedModLoaders.NEOFORGE));
  }

  @Override
  public void buildRegistry(RegistrySetBuilder registryBuilder) {
    DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);

    registryBuilder.add(Registries.PLACED_FEATURE, SMBFeatureProvider::bootstrapF);
    registryBuilder.add(Registries.CONFIGURED_FEATURE, SMBFeatureProvider::bootstrapCF);
  }
}
