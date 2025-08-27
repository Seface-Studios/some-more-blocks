package net.seface.somemoreblocks.datagen.providers.data.datamaps;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.datagen_extras.data_maps.FurnaceFuelsDataMap;
import net.sefacestudios.datagen_extras.provider.neoforge.FurnaceFuelsDataMapProvider;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBFurnaceFuelsDataMapProvider extends FurnaceFuelsDataMapProvider {
  public SMBFurnaceFuelsDataMapProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generate(HolderLookup.Provider provider, Consumer<FurnaceFuelsDataMap> consumer) {
    this.addFuel(SMBBlocks.COAL_BRICKS.get().asItem(), 32000);
    this.addFuel(SMBBlocks.CRACKED_COAL_BRICKS.get().asItem(), 19200);
    this.addFuel(SMBBlocks.COAL_PILLAR.get().asItem(), 16000);
    this.addFuel(SMBBlocks.CUT_COAL.get().asItem(), 32767);
    this.addFuel(SMBBlocks.CRACKED_CUT_COPPER.get().asItem(), 19800);
    this.addFuel(SMBBlocks.CLOVER.get().asItem(), 100);
  }
}
