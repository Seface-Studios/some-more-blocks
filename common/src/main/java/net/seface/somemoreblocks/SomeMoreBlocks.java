package net.seface.somemoreblocks;

import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeMoreBlocks {
  public static final String ID = "somemoreblocks";
  public static final String MOD_NAME = "Some More Blocks";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

  public static void init() {
    LOGGER.info(MOD_NAME + " mod initialized!");
    LOGGER.info("Our Links: https://sefacestudios.net/links");

    SMBDataComponentTypes.init();
    SMBBlockTags.init();
  }
}
