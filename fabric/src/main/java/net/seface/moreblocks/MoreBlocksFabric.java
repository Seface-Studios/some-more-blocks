package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.seface.moreblocks.registry.MBBlockTypes;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBItemGroups;
import net.seface.moreblocks.registry.MBItems;

public class MoreBlocksFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MoreBlocks.init();

        MBBlocks.register();
        MBBlockTypes.register();
        MBItemGroups.register();
        MBItems.register();
    }
}
