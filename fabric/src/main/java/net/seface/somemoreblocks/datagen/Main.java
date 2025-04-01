package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.seface.somemoreblocks.datagen.providers.*;
import net.seface.somemoreblocks.datagen.providers.data.SMBLootTableProvider;
import net.seface.somemoreblocks.datagen.providers.data.SMBRecipeProvider;
import net.seface.somemoreblocks.datagen.providers.tags.SMBBlockTagProvider;
import net.seface.somemoreblocks.datagen.providers.tags.SMBItemTagProvider;
import net.seface.somemoreblocks.datagen.providers.tags.SMBBiomeTagProvider;

public class Main implements DataGeneratorEntrypoint {

  @Override
  public void onInitializeDataGenerator(FabricDataGenerator gen) {
    FabricDataGenerator.Pack pack = gen.createPack();

    pack.addProvider(SMBModelProvider::new);
    pack.addProvider(SMBRecipeProvider::new);
    pack.addProvider(SMBBlockTagProvider::new);
    pack.addProvider(SMBItemTagProvider::new);
    pack.addProvider(SMBBiomeTagProvider::new);
    pack.addProvider(SMBLootTableProvider::new);
    pack.addProvider(SMBFeatureProvider::new);

    /*
      Why this custom provider exists?

      In the initial development stage we used to have our own data generation, tha generates
      data/assets for both Minecraft version;
      When we decided to abandon that system, we still need to generate the recipe advancements.
    */
    pack.addProvider(SMBRecipeAdvancementProvider::new);
  }

  @Override
  public void buildRegistry(RegistrySetBuilder registryBuilder) {
    DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
    registryBuilder.add(Registries.CONFIGURED_FEATURE, SMBFeatureProvider::bootstrapConfiguredFeatures);
    registryBuilder.add(Registries.PLACED_FEATURE, SMBFeatureProvider::bootstrapPlacedFeatures);
  }
}
