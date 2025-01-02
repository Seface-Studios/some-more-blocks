package net.seface.somemoreblocks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreBlocks {
  public static final String ID = "somemoreblocks";
  public static final String MOD_NAME = "Some More Blocks";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

  // Seface Studios brand color palettes.
  public static final int AMESFACE_COLOR = 8418303;
  public static final int GREENFUL_COLOR = 13959034;
  public static final int BLUENIVERS_COLOR = 4666;

  public static void init() {
    LOGGER.info(MOD_NAME + " mod initialized!");
    LOGGER.info("Our Links: https://sefacestudios.net/links");
  }
}
