package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.block.Blocks;
import net.seface.moreblocks.registry.*;
import net.seface.moreblocks.worldgen.MBFeatures;
import net.seface.moreblocks.worldgen.MBBiomeModifiers;

public class MoreBlocksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
      MoreBlocks.init();
      MBItems.register();
      MBBlocks.register();
      MBItemGroups.register();
      MBFeatures.register();
      MBBiomeModifiers.register();

      registerSnowyVariations();
    }

    private static void registerSnowyVariations() {
      SnowyVariationsManager.register(Blocks.SHORT_GRASS, MBBlocks.SNOW_GRASS);
      SnowyVariationsManager.register(Blocks.FERN, MBBlocks.SNOW_FERN);
      SnowyVariationsManager.register(Blocks.TALL_GRASS, MBBlocks.TALL_SNOW_GRASS, true);
      SnowyVariationsManager.register(Blocks.LARGE_FERN, MBBlocks.TALL_SNOW_FERN, true);
    }
}
