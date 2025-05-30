package net.seface.somemoreblocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.registries.*;
import net.seface.somemoreblocks.tags.SMBBlockTags;
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
    SMBBlockTags.init();
    SMBFeatures.init();
    SMBCreativeTabs.init();
    SMBGameRules.init();

    if (afterRegistries != null) {
      afterRegistries.run();
    }
  }

  public static void initClient() {
    registerBlockRenders();
    registerModelPredicates();
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

  public static <T> TagKey<T> tagKey(ResourceKey<Registry<T>> registryType, String path) {
    return TagKey.create(registryType, SomeMoreBlocks.id(path));
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

  private static void registerBlockRenders() {
    RenderType cutout = RenderType.cutout();
    RenderType cutoutMipped = RenderType.cutoutMipped();
    RenderType translucent = RenderType.translucent();

    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.AZALEA_LEAF_LITTER.get(), cutoutMipped);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BIG_LILY_PAD.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BIRCH_LEAF_LITTER.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BLACK_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BLUE_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BROWN_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.CATTAIL.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.CLOVER.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.NETHER_CLOVER.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.CYAN_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.DIAMOND_GRATE.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.DUNE_GRASS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), cutoutMipped);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.GRAY_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.GREEN_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.IRON_GRATE.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LARGE_SNOW_FERN.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LEAF_LITTER.get(), cutoutMipped);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LIME_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.LUMINOUS_FLOWER.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.NETHERITE_GRATE.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.PINK_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.POTTED_SNOW_FERN.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.POTTED_TINY_CACTUS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.RED_MUSHROOM_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.RED_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.REEDS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.SHORT_SNOW_GRASS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.SMALL_LILY_PADS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.SNOW_FERN.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.SPRUCE_LEAF_LITTER.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TALL_CACTUS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TALL_DUNE_GRASS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TALL_SNOW_GRASS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TILED_TINTED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.TINY_CACTUS.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.WARPED_FUNGUS_COLONY.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), cutout);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.WHITE_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get(), translucent);
    PlatformServices.REGISTRY.setBlockRenderType(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get(), translucent);
  }

  private static void registerModelPredicates() {
    PlatformServices.REGISTRY.registerModelPredicate(SMBItems.LEAVES_BUCKET.get(), SMBDataComponentTypes.BUCKET_VOLUME.getPath());
    PlatformServices.REGISTRY.registerModelPredicate(SMBItems.SPRUCE_LEAVES_BUCKET.get(), SMBDataComponentTypes.BUCKET_VOLUME.getPath());
    PlatformServices.REGISTRY.registerModelPredicate(SMBItems.BIRCH_LEAVES_BUCKET.get(), SMBDataComponentTypes.BUCKET_VOLUME.getPath());
    PlatformServices.REGISTRY.registerModelPredicate(SMBItems.AZALEA_LEAVES_BUCKET.get(), SMBDataComponentTypes.BUCKET_VOLUME.getPath());
    PlatformServices.REGISTRY.registerModelPredicate(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get(), SMBDataComponentTypes.BUCKET_VOLUME.getPath());
  }
}
