package net.seface.somemoreblocks;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.somemoreblocks.registries.*;
import net.seface.somemoreblocks.util.SMBForgeUtils;
import net.seface.somemoreblocks.utils.*;

@SuppressWarnings({"removal", "deprecation"})
@Mod(SomeMoreBlocks.ID)
public class SomeMoreBlocksForge {
  public SomeMoreBlocksForge() {
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    SMBForgedDataComponentTypes.init(bus);
    SMBCreativeTabs.init(bus);
    SMBBlocks.init(bus);
    SMBItems.init(bus);
    SMBFeatures.init(bus);
    SMBBiomeModifiers.init(bus);

    bus.addListener(this::clientSetup);
    bus.addListener(this::commonSetup);
  }

  private void clientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.LUMINOUS_FLOWER.getId(), SMBBlocks.POTTED_LUMINOUS_FLOWER);
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.SNOW_FERN.getId(), SMBBlocks.POTTED_SNOW_FERN);
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.TINY_CACTUS.getId(), SMBBlocks.POTTED_TINY_CACTUS);

      registerBlockRenders();
    });
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
      SomeMoreBlocks.init(false);

      registerCarvedBlocks();
      registerCompostableItems();
      registerSnowyBlocks();
      registerWaxableCopperBlocks();
      registerWeatheringCopperBlocks();
    });
  }

  /**
   * Registers values related to Compostable items.
   */
  private static void registerCompostableItems() {
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.TINY_CACTUS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.DUNE_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBBlocks.TALL_DUNE_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBBlocks.TALL_DUNE_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBBlocks.SHORT_SNOW_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.TALL_SNOW_GRASS.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.SNOW_FERN.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.LARGE_SNOW_FERN.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.CATTAIL.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBBlocks.LUMINOUS_FLOWER.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.BROWN_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.RED_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_RED_MUSHROOM_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.CRIMSON_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBBlocks.WARPED_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get().asItem());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.AZALEA_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.BIRCH_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.SPRUCE_LEAVES_BUCKET.get());

    /* 1.21.4 */
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.PALE_OAK_LEAVES_BUCKET.get());
  }

  /**
   * Registers values related to Weathering-like blocks.
   */
  private static void registerWeatheringCopperBlocks() {
    WeatheringCopperBlockRegistry.register(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
  }

  /**
   * Registers values related to Waxable-like blocks.
   */
  private static void registerWaxableCopperBlocks() {
    WaxableCopperBlockRegistry.register(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
  }

  /**
   * Registers values related to Snowy-like blocks.
   */
  private static void registerSnowyBlocks() {
    SnowyBushRegistry.register(Blocks.SHORT_GRASS, SMBBlocks.SHORT_SNOW_GRASS.get());
    SnowyBushRegistry.register(Blocks.FERN, SMBBlocks.SNOW_FERN.get());
    SnowyBushRegistry.register(Blocks.TALL_GRASS, SMBBlocks.TALL_SNOW_GRASS.get());
    SnowyBushRegistry.register(Blocks.LARGE_FERN, SMBBlocks.LARGE_SNOW_FERN.get());
  }

  /**
   * Registers values related to Carved-like blocks.
   */
  private static void registerCarvedBlocks() {
    CarvedBlockRegistry.register(Blocks.STRIPPED_OAK_WOOD, SMBBlocks.CARVED_OAK_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_OAK_LOG, SMBBlocks.CARVED_OAK_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_WOOD, SMBBlocks.CARVED_DARK_OAK_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_LOG, SMBBlocks.CARVED_DARK_OAK_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_ACACIA_WOOD, SMBBlocks.CARVED_ACACIA_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_ACACIA_LOG, SMBBlocks.CARVED_ACACIA_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CHERRY_WOOD, SMBBlocks.CARVED_CHERRY_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CHERRY_LOG, SMBBlocks.CARVED_CHERRY_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_BIRCH_WOOD, SMBBlocks.CARVED_BIRCH_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_BIRCH_LOG, SMBBlocks.CARVED_BIRCH_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_JUNGLE_WOOD, SMBBlocks.CARVED_JUNGLE_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_JUNGLE_LOG, SMBBlocks.CARVED_JUNGLE_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_SPRUCE_WOOD, SMBBlocks.CARVED_SPRUCE_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_SPRUCE_LOG, SMBBlocks.CARVED_SPRUCE_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_WARPED_STEM, SMBBlocks.CARVED_WARPED_STEM.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_WARPED_HYPHAE, SMBBlocks.CARVED_WARPED_HYPHAE.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CRIMSON_STEM, SMBBlocks.CARVED_CRIMSON_STEM.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_CRIMSON_HYPHAE, SMBBlocks.CARVED_CRIMSON_HYPHAE.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_MANGROVE_WOOD, SMBBlocks.CARVED_MANGROVE_WOOD.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_MANGROVE_LOG, SMBBlocks.CARVED_MANGROVE_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_BAMBOO_BLOCK, SMBBlocks.CARVED_BAMBOO_BLOCK.get());

    /* 1.21.4 */
    CarvedBlockRegistry.register(Blocks.STRIPPED_PALE_OAK_LOG, SMBBlocks.CARVED_PALE_OAK_LOG.get());
    CarvedBlockRegistry.register(Blocks.STRIPPED_PALE_OAK_WOOD, SMBBlocks.CARVED_PALE_OAK_WOOD.get());
  }

  /**
   * Registers values related to BlockRender.
   */
  private static void registerBlockRenders() {
    RenderType cutout = RenderType.cutout();
    RenderType cutoutMipped = RenderType.cutoutMipped();
    RenderType translucent = RenderType.translucent();

    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.AZALEA_LEAF_LITTER.get(), cutoutMipped);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BIG_LILY_PAD.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BIRCH_LEAF_LITTER.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.BLACK_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.BLUE_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.BROWN_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CATTAIL.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.CYAN_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.DIAMOND_GRATE.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.DUNE_GRASS.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), cutoutMipped);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.GRAY_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.GREEN_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.IRON_GRATE.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LARGE_SNOW_FERN.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LEAF_LITTER.get(), cutoutMipped);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.LIME_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LUMINOUS_FLOWER.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.NETHERITE_GRATE.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.PINK_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.POTTED_SNOW_FERN.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.POTTED_TINY_CACTUS.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.RED_MUSHROOM_COLONY.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.RED_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SHORT_SNOW_GRASS.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SMALL_LILY_PADS.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SNOW_FERN.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SPRUCE_LEAF_LITTER.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_DUNE_GRASS.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_SNOW_GRASS.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.TILED_GLASS_PANE.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.TILED_TINTED_GLASS.get(), translucent);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TINY_CACTUS.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.WARPED_FUNGUS_COLONY.get(), cutout);
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), cutout);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.WHITE_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get(), translucent);
    SMBForgeUtils.registerRenderLayer(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get(), translucent);

    /* 1.21.4 */
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), cutout);
  }
}
