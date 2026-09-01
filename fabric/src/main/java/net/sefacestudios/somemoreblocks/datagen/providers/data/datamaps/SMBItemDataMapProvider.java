package net.sefacestudios.somemoreblocks.datagen.providers.data.datamaps;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.registries.SMBItems;
import net.sefacestudios.datagen_extras.data_maps.item.ItemDataMap;
import net.sefacestudios.datagen_extras.provider.neoforge.ItemDataMapProvider;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBItemDataMapProvider extends ItemDataMapProvider {
  public SMBItemDataMapProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generate(HolderLookup.Provider provider, Consumer<ItemDataMap> consumer) {
    this.addCompostableItem(SMBBlocks.TINY_CACTUS.get().asItem(), 0.3f);
    this.addCompostableItem(SMBBlocks.TALL_CACTUS.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.TALL_DUNE_GRASS.get().asItem(), 0.5f);
    this.addCompostableItem(SMBBlocks.SHORT_SNOW_GRASS.get().asItem(), 0.3f);
    this.addCompostableItem(SMBBlocks.TALL_SNOW_GRASS.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.SNOW_FERN.get().asItem(), 0.3f);
    this.addCompostableItem(SMBBlocks.LARGE_SNOW_FERN.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.CATTAIL.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.LUMINOUS_FLOWER.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get().asItem(), 0.85f);
    this.addCompostableItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.RED_MUSHROOM_COLONY.get().asItem(), 0.85f);
    this.addCompostableItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get().asItem(), 0.85f);
    this.addCompostableItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.WARPED_FUNGUS_COLONY.get().asItem(), 0.85f);
    this.addCompostableItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.PALE_ROSE_BUSH.get().asItem(), 0.85f);
    this.addCompostableItem(SMBBlocks.SMALL_LILY_PADS.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.BIG_LILY_PAD.get().asItem(), 1.0f);
    this.addCompostableItem(SMBItems.LEAVES_BUCKET.get(), 1.0f);
    this.addCompostableItem(SMBItems.AZALEA_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostableItem(SMBItems.BIRCH_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostableItem(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostableItem(SMBItems.SPRUCE_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostableItem(SMBItems.PALE_OAK_LEAVES_BUCKET.get(), 1.0f);
    this.addCompostableItem(SMBBlocks.CLOVER.get().asItem(), 0.4f);
    this.addCompostableItem(SMBBlocks.DUCKWEED.get().asItem(), 0.4f);
    this.addCompostableItem(SMBBlocks.GALAHAD_LARKSPUR.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.SHORT_GALAHAD_LARKSPUR.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.ASTOLAT_LARKSPUR.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.SHORT_ASTOLAT_LARKSPUR.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.SUMMER_SKIES_LARKSPUR.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.SHORT_SUMMER_SKIES_LARKSPUR.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.PURPLE_LARKSPUR.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.SHORT_PURPLE_LARKSPUR.get().asItem(), 0.65f);
    this.addCompostableItem(SMBBlocks.RED_LARK_LARKSPUR.get().asItem(), 1.0f);
    this.addCompostableItem(SMBBlocks.SHORT_RED_LARK_LARKSPUR.get().asItem(), 0.65f);

    this.addFuelItem(SMBBlocks.COAL_BRICKS.get().asItem(), 32000);
    this.addFuelItem(SMBBlocks.CRACKED_COAL_BRICKS.get().asItem(), 19200);
    this.addFuelItem(SMBBlocks.COAL_PILLAR.get().asItem(), 16000);
    this.addFuelItem(SMBBlocks.CUT_COAL.get().asItem(), 32767);
    this.addFuelItem(SMBBlocks.CRACKED_CUT_COPPER.get().asItem(), 19800);
    this.addFuelItem(SMBBlocks.CLOVER.get().asItem(), 100);
  }
}
