package net.seface.moreblocks.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.seface.moreblocks.block.PoweredPillarBlock;

public class MBBlockTypes {

    public static void register() {
        Registry.register(BuiltInRegistries.BLOCK_TYPE, "powered_pillar", PoweredPillarBlock.CODEC);
    }
}
