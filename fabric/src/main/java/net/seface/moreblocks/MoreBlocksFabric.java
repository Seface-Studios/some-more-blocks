package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.seface.moreblocks.registry.*;

public class MoreBlocksFabric implements ModInitializer {

    /*public static PlacedFeature TESTING_FEATURE_PLACED = new PlacedFeature(
            Holder.direct(TESTING_FEATURE_CONFIGURED), List.of(InSquarePlacement.spread())
    );*/

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
