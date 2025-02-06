package net.seface.somemoreblocks;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.registries.*;
import net.seface.somemoreblocks.utils.SMBUtils;

@Mod(SomeMoreBlocks.ID)
public class SomeMoreBlocksForge {
  public SomeMoreBlocksForge() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    SomeMoreBlocks.init();
    SMBBlocks.register(eventBus);
    SMBItems.register(eventBus);
    SMBCreativeTabs.register(eventBus);
    SMBFeatures.register(eventBus);
    SMBBiomeModifiers.register(eventBus);

    eventBus.addListener(this::clientSetup);
    eventBus.addListener(this::commonSetup);
  }

  /**
   * TBD
   * @param event
   */
  private void clientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.LUMINOUS_FLOWER.getId(), SMBBlocks.POTTED_LUMINOUS_FLOWER);
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.SNOW_FERN.getId(), SMBBlocks.POTTED_SNOW_FERN);
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.TINY_CACTUS.getId(), SMBBlocks.POTTED_TINY_CACTUS);

      registerBlockRenders();
      registerModelPredicateProviders();
    });
  }

  /**
   * TBD
   * @param event
   */
  private void commonSetup(final FMLCommonSetupEvent event) {
    event.enqueueWork(() -> {
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
    SnowyBushRegistry.register(Blocks.GRASS, SMBBlocks.SHORT_SNOW_GRASS.get());
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
  }

  /**
   * Registers values related to BlockRender.
   */
  private static void registerBlockRenders() {
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.AZALEA_LEAF_LITTER.get(), RenderType.cutoutMipped());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BIG_LILY_PAD.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BIRCH_LEAF_LITTER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BLACK_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BLUE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BROWN_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CATTAIL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CYAN_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.DUNE_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), RenderType.cutoutMipped());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.GRAY_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.GREEN_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LARGE_SNOW_FERN.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LEAF_LITTER.get(), RenderType.cutoutMipped());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LIME_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.LUMINOUS_FLOWER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.MAGENTA_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.ORANGE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.PINK_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.POTTED_LUMINOUS_FLOWER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.POTTED_SNOW_FERN.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.POTTED_TINY_CACTUS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.PURPLE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.RED_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.RED_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.RED_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SHORT_SNOW_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SMALL_LILY_PADS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SNOW_FERN.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.SPRUCE_LEAF_LITTER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_DUNE_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_SNOW_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TILED_TINTED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.TINY_CACTUS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.WARPED_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.WHITE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.YELLOW_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
  }

  /**
   * Registers values related to ModelPredicate.
   */
  private static void registerModelPredicateProviders() {
    ModelPredicateRegistry.register(SMBItems.LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.SPRUCE_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.BIRCH_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.AZALEA_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
    ModelPredicateRegistry.register(SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
  }
}
