package net.seface.moreblocks;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBlocks {
    public static final String ID = "moreblocks";
    public static final String MOD_NAME = "More Blocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {}

    public static String id(String identifier) {
        return new ResourceLocation(MoreBlocks.ID, identifier).toString();
    }
}