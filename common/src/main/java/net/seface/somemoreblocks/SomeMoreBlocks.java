package net.seface.somemoreblocks;

import net.minecraft.resources.ResourceLocation;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeMoreBlocks {
  public static final String ID = "somemoreblocks";
  public static final String MOD_NAME = "Some More Blocks";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

  public static void init() {
    init(true);
  }

  public static void init(boolean vanillaDataComponents) {
    LOGGER.info(MOD_NAME + " mod initialized!");
    LOGGER.info("Our Links: https://sefacestudios.net/links");

    if (vanillaDataComponents) {
      SMBDataComponentTypes.register();
    }

    SMBBlockTags.register();
  }

  /**
   * Create a generic identifier with Mod ID and custom path.<br />
   * <i>Some day we start to use this method. - _Fyat</i>
   *
   * @param path The identifier path.
   */
  public static ResourceLocation id(String path) {
    return ResourceLocation.fromNamespaceAndPath(ID, path);
  }
}
