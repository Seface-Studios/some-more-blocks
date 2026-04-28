package net.seface.somemoreblocks.datagen.providers.data.datamaps;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.datagen_extras.data_maps.CopperBlockBehaviorDataMap;
import net.sefacestudios.datagen_extras.provider.neoforge.CopperBehaviorDataMapProvider;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBCopperBehaviorDataMapProvider extends CopperBehaviorDataMapProvider {
  public SMBCopperBehaviorDataMapProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(output, registryLookup);
  }

  @Override
  public void generate(HolderLookup.Provider provider, Consumer<CopperBlockBehaviorDataMap> consumer) {
    this.addOxidizable(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    this.addOxidizable(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    this.addOxidizable(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    this.addOxidizable(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    this.addOxidizable(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    this.addOxidizable(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    this.addOxidizable(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    this.addOxidizable(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    this.addOxidizable(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    this.addOxidizable(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    this.addOxidizable(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    this.addOxidizable(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get());

    this.addWaxable(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    this.addWaxable(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    this.addWaxable(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    this.addWaxable(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    this.addWaxable(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    this.addWaxable(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    this.addWaxable(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    this.addWaxable(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    this.addWaxable(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
  }
}
