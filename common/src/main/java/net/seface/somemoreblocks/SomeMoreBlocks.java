package net.seface.somemoreblocks;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeMoreBlocks {
  public static final String ID = "somemoreblocks";
  public static final String MOD_NAME = "Some More Blocks";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

  public static void init() {
    if (PlatformServices.HELPER.isModLoaded(ID)) {
      LOGGER.info(MOD_NAME + " mod initialized!");
      LOGGER.info("Our Links: https://sefacestudios.net/links");
    }

    SMBDataComponentTypes.init();
    SMBBlockTags.register();
  }

  /**
   * Create a generic identifier with Mod ID and custom path.<br />
   * @param path The identifier path.
   */
  public static ResourceLocation id(String path) {
    return ResourceLocation.fromNamespaceAndPath(ID, path);
  }

  /**
   * Create a generic key with Mod ID and custom path.<br />
   * @param path The resource key path.
   */
  public static <T> ResourceKey<T> key(ResourceKey<? extends Registry<T>> registry, String path) {
    return ResourceKey.create(registry, SomeMoreBlocks.id(path));
  }
}
