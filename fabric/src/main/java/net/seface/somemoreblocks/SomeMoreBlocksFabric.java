package net.seface.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.seface.somemoreblocks.registries.*;

public class SomeMoreBlocksFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    SomeMoreBlocks.init();
    SMBBiomeModifiers.init();
    CommonRegistries.init();
  }
}
