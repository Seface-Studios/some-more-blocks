package net.seface.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.seface.somemoreblocks.registries.CommonRegistries;

public class SomeMoreBlocksFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    SomeMoreBlocks.init(null, CommonRegistries::init);
  }
}
