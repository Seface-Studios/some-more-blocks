package net.sefacestudios.somemoreblocks;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.sefacestudios.somemoreblocks.platform.PlatformServices;
import net.sefacestudios.somemoreblocks.registries.*;
import net.sefacestudios.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    SMBRecipeSerializers.init();
    SMBBlockTags.init();
    SMBFeatures.init();
    SMBCreativeTabs.init();
    SMBGameRules.init();

    if (afterRegistries != null) {
      afterRegistries.run();
    }
  }

  public static void initClient() {}

  /**
   * Create a generic identifier with Mod ID and custom path.<br />
   * @param path The identifier path.
   */
  public static Identifier id(String path) {
    return Identifier.fromNamespaceAndPath(ID, path);
  }

  /**
   * Create a generic key with Mod ID and custom path.<br />
   * @param path The resource key path.
   */
  public static <T> ResourceKey<T> key(ResourceKey<@NotNull ? extends Registry<T>> registry, String path) {
    return ResourceKey.create(registry, SomeMoreBlocks.id(path));
  }

  public static <T> TagKey<T> tagKey(ResourceKey<@NotNull Registry<T>> registryType, String path) {
    return TagKey.create(registryType, SomeMoreBlocks.id(path));
  }

  private static void printHeader() {
    LOGGER.info("*****************************************************");
    LOGGER.info("*           Some More Blocks initialized!           *");
    LOGGER.info("*               https://sfc.st/links                *");
    LOGGER.info("*****************************************************");
    LOGGER.info("  > Platform: " + PlatformServices.HELPER.getPlatformName());
    LOGGER.info("  > Environment: " + PlatformServices.HELPER.getEnvironment().getName());
    LOGGER.info("  > Minecraft Version: " + PlatformServices.HELPER.getGameVersion());
    LOGGER.info("  > Mod Version: " + PlatformServices.HELPER.getModVersion());
    LOGGER.info("*****************************************************");
  }
}
