package net.seface.somemoreblocks;

import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.seface.somemoreblocks.platform.PlatformEnvironment;
import net.seface.somemoreblocks.platform.PlatformHelper;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.registries.*;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class SomeMoreBlocks {
  public static final String ID = "somemoreblocks";
  public static final String MOD_NAME = "Some More Blocks";
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

  public static void init() {
    init(null, null);
  }

  public static void init(@Nullable Runnable beforeRegistries, @Nullable Runnable afterRegistries) {
    if (PlatformServices.HELPER.isModLoaded(ID)) {
      SomeMoreBlocks.printHeader();
    }

    if (beforeRegistries != null) {
      beforeRegistries.run();
    }

    SMBDataComponentTypes.init();
    SMBBlocks.init();
    SMBItems.init();
    SMBBlockTags.register();
    SMBFeatures.init();
    SMBCreativeTabs.init();

    if (afterRegistries != null) {
      afterRegistries.run();
    }
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

  private static void printHeader() {
    LOGGER.info("*****************************************************");
    LOGGER.info("*           Some More Blocks initialized!           *");
    LOGGER.info("*          https://sefacestudios.net/links          *");
    LOGGER.info("*****************************************************");
    LOGGER.info("  > Platform: " + PlatformServices.HELPER.getPlatformName());
    LOGGER.info("  > Environment: " + PlatformServices.HELPER.getEnvironment().getName());
    LOGGER.info("  > Version: " + PlatformServices.HELPER.getVersion());
    LOGGER.info("*****************************************************");
  }
}
