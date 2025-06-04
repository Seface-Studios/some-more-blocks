package net.seface.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.seface.somemoreblocks.registries.CommonRegistries;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;
import net.seface.somemoreblocks.registries.SMBRegistries;

import java.util.Optional;

public class SomeMoreBlocksFabric implements ModInitializer {
  public static final Optional<ModContainer> CONTAINER = FabricLoader.getInstance().getModContainer(SomeMoreBlocks.ID);

  @Override
  public void onInitialize() {
    SomeMoreBlocks.init();
    SMBRegistries.init();
    CommonRegistries.init();
    SMBBiomeModifiers.init();
  }
}
