package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.seface.somemoreblocks.datagen.providers.*;

public class Main implements DataGeneratorEntrypoint {

  @Override
  public void onInitializeDataGenerator(FabricDataGenerator gen) {
    FabricDataGenerator.Pack pack = gen.createPack();

    pack.addProvider(SMBModelProvider::new);
    pack.addProvider(SMBCustomRecipeProvider::new);
    pack.addProvider(SMBBlockTagProvider::new);
    pack.addProvider(SMBWorldGenTagProvider::new);
    pack.addProvider(SMBLootTableProvider::new);

    /*
      Why this custom provider exists?

      In the initial development stage we used to have our own data generation, tha generates
      data/assets for both Minecraft version;
      When we decided to abandon that system, we still need to generate the recipe advancements.
    */
    pack.addProvider(SMBRecipeAdvancementProvider::new);
  }
}
