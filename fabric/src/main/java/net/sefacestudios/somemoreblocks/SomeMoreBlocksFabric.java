package net.sefacestudios.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.sefacestudios.somemoreblocks.registries.CommonRegistries;
import net.sefacestudios.somemoreblocks.registries.SMBBiomeModifiers;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;

public class SomeMoreBlocksFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    SomeMoreBlocks.init();
    SMBRegistries.init();
    CommonRegistries.init();
    SMBBiomeModifiers.init();
  }
}
