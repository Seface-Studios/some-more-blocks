package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.seface.moreblocks.registry.*;
import net.seface.moreblocks.world.WorldGeneration;

public class MoreBlocksFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MoreBlocks.init();
        MBItems.register();
        MBBlocks.register();
        MBItemGroups.register();
        WorldGeneration.register();
    }
}
