package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.seface.moreblocks.registry.*;

public class MoreBlocksFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MoreBlocks.init();

        MBBlocks.register();
        MBBlocks.registerCrackedSystem();
        MBBlockTypes.register();
        MBItemGroups.register();
        MBItems.register();
        MBFeatures.register();
    }
}
