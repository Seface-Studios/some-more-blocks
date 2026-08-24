package net.sefacestudios.somemoreblocks;

import net.fabricmc.api.ClientModInitializer;
import net.sefacestudios.somemoreblocks.registries.ClientRegistries;

public class SomeMoreBlocksFabricClient implements ClientModInitializer {

  @Override
  public void onInitializeClient() {
    SomeMoreBlocks.initClient();
    ClientRegistries.init();
  }
}
