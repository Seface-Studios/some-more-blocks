package net.seface.moreblocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class MoreBlocks {
    public static final String ID = "moreblocks";
    public static final String MOD_NAME = "More Blocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
      LOGGER.info(MOD_NAME + " mod initialized!");
      LOGGER.info("Our Links: https://sefacestudios.net/links");
    }
}
