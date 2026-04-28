package net.seface.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.seface.somemoreblocks.recipe.CarvedPaleOakWoodCraftingRecipe;
import net.seface.somemoreblocks.registries.CommonRegistries;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;
import net.seface.somemoreblocks.registries.SMBRegistries;

public class SomeMoreBlocksFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    SomeMoreBlocks.init();
    SMBRegistries.init();
    CommonRegistries.init();
    SMBBiomeModifiers.init();
  }
}
