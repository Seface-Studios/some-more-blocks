package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.Items;
import net.seface.moreblocks.registry.*;

public class MoreBlocksFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MoreBlocks.init();

        MBBlocks.register();
        MBItemGroups.register();
        MBItems.register();
    }
}
