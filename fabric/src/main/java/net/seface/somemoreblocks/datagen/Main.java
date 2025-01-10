package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class Main implements DataGeneratorEntrypoint {

  @Override
  public void onInitializeDataGenerator(FabricDataGenerator gen) {
    FabricDataGenerator.Pack pack = gen.createPack();

    pack.addProvider(ModelProvider::new);
    pack.addProvider(RecipeProvider::new);

    /*
      Why this custom provider exists?

      In the initial development stage we used to have our own data generation, tha generates
      data/assets for both Minecraft version;
      When we decided to abandon that system, we still need to generate the recipe advancements.
    */
    pack.addProvider(RecipeAdvancementProvider::new);
  }
}
