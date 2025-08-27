package net.seface.somemoreblocks.datagen.providers.data.datamaps;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBItems;
import net.sefacestudios.datagen_extras.data_maps.CompostableDataMap;
import net.sefacestudios.datagen_extras.provider.neoforge.CompostablesDataMapProvider;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBCompostablesDataMapProvider extends CompostablesDataMapProvider {
  public SMBCompostablesDataMapProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generate(HolderLookup.Provider provider, Consumer<CompostableDataMap> consumer) {
    this.addCompostable(SMBBlocks.TINY_CACTUS.get().asItem(), 0.3f);
    this.addCompostable(SMBBlocks.TALL_CACTUS.get().asItem(), 1.0f);
    this.addCompostable(SMBBlocks.TALL_DUNE_GRASS.get().asItem(), 0.5f);
    this.addCompostable(SMBBlocks.SHORT_SNOW_GRASS.get().asItem(), 0.3f);
    this.addCompostable(SMBBlocks.TALL_SNOW_GRASS.get().asItem(), 0.65f);
    this.addCompostable(SMBBlocks.SNOW_FERN.get().asItem(), 0.3f);
    this.addCompostable(SMBBlocks.LARGE_SNOW_FERN.get().asItem(), 0.65f);
    this.addCompostable(SMBBlocks.CATTAIL.get().asItem(), 0.65f);
    this.addCompostable(SMBBlocks.LUMINOUS_FLOWER.get().asItem(), 0.65f);
    this.addCompostable(SMBBlocks.BROWN_MUSHROOM_COLONY.get().asItem(), 0.85f);
    this.addCompostable(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get().asItem(), 1.0f);
    this.addCompostable(SMBBlocks.RED_MUSHROOM_COLONY.get().asItem(), 0.85f);
    this.addCompostable(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get().asItem(), 1.0f);
    this.addCompostable(SMBBlocks.CRIMSON_FUNGUS_COLONY.get().asItem(), 0.85f);
    this.addCompostable(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get().asItem(), 1.0f);
    this.addCompostable(SMBBlocks.WARPED_FUNGUS_COLONY.get().asItem(), 0.85f);
    this.addCompostable(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get().asItem(), 1.0f);
    this.addCompostable(SMBBlocks.PALE_ROSE_BUSH.get().asItem(), 0.85f);
    this.addCompostable(SMBBlocks.SMALL_LILY_PADS.get().asItem(), 0.65f);
    this.addCompostable(SMBBlocks.BIG_LILY_PAD.get().asItem(), 1.0f);
    this.addCompostable(SMBItems.LEAVES_BUCKET.get(), 1.0f);
    this.addCompostable(SMBItems.AZALEA_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostable(SMBItems.BIRCH_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostable(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostable(SMBItems.SPRUCE_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostable(SMBItems.PALE_OAK_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostable(SMBBlocks.CLOVER.get().asItem(), 0.4f);
  }
}
