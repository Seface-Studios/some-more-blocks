package net.seface.moreblocks.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class MBBlockTags extends MBCustomTags {
    public static final TagKey<Block> CATTAIL_PLACEABLE = register(Registries.BLOCK, "cattail_placeable");
    public static final TagKey<Block> MOSSY_BLOCKS = register(Registries.BLOCK, "mossy_blocks");
    public static final TagKey<Block> MUSHROOM_COLONY_PLACEABLE = register(Registries.BLOCK, "mushroom_colony_placeable");

    private MBBlockTags() {}
}
