package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagRegistry;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Blocks;
import net.seface.moreblocks.registry.MBBlockTypes;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBItemGroups;
import net.seface.moreblocks.registry.MBItems;

public class MoreBlocksFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MoreBlocks.init();

        MBBlocks.register();
        MBBlocks.registerCracklableBlockManager();
        MBBlockTypes.register();
        MBItemGroups.register();
        MBItems.register();
    }
}
