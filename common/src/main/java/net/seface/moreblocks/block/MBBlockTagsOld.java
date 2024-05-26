package net.seface.moreblocks.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.seface.moreblocks.MoreBlocks;

public class MBBlockTagsOld {
    public static final TagKey<Block> CRACKLABLE = TagKey.create(Registries.BLOCK, new ResourceLocation(MoreBlocks.ID, "cracklable"));
}
