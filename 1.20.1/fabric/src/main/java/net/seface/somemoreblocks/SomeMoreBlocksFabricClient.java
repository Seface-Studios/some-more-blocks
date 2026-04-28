package net.seface.somemoreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.seface.somemoreblocks.registries.ClientRegistries;

public class SomeMoreBlocksFabricClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    SomeMoreBlocks.initClient();
    ClientRegistries.init();
  }
}
