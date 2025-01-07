package net.seface.somemoreblocks;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.somemoreblocks.event.OnPlayerJoinOrLeaveWorld;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.registry.MBBlocks;
import net.seface.somemoreblocks.registry.MBCreativeTabs;
import net.seface.somemoreblocks.registry.MBItems;
import net.seface.somemoreblocks.utils.MBUtils;
import net.seface.somemoreblocks.utils.ModelPredicate;
import net.seface.somemoreblocks.worldgen.MBBiomeModifier;
import net.seface.somemoreblocks.worldgen.MBFeatures;

import java.nio.file.Path;

@Mod(MoreBlocks.ID)
public class MoreBlocksForge {
  public MoreBlocksForge() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    MoreBlocks.init();
    MBBlocks.register(eventBus);
    MBItems.register(eventBus);
    MBCreativeTabs.register(eventBus);
    MBFeatures.register(eventBus);
    MBBiomeModifier.register(eventBus);

    eventBus.addListener(this::clientSetup);
    eventBus.addListener(this::commonSetup);
    eventBus.addListener(this::registerColorProviders);
    eventBus.addListener(MBCreativeTabs::buildContents);
    eventBus.addListener(this::addPackFinders);
  }

  private void clientSetup(final FMLClientSetupEvent event) {
    this.registerBlockRenders();
  }

  public void addPackFinders(AddPackFindersEvent event) {
    if (event.getPackType() == PackType.CLIENT_RESOURCES) {
      Path resourcePackPath = ModList.get().getModFileById(MoreBlocks.ID).getFile().findResource("resourcepacks/update_1_21");
      Pack pack = Pack.readMetaAndCreate(
        OnPlayerJoinOrLeaveWorld.EXPERIMENTAL_1_21_RP.toString(),
        Component.translatable("somemoreblocks.resourcepack.update_1_21.name"),
        false,
        new PathPackResources.PathResourcesSupplier(resourcePackPath, false),
        PackType.CLIENT_RESOURCES,
        Pack.Position.BOTTOM,
        PackSource.BUILT_IN);

      event.addRepositorySource((consumer) -> consumer.accept(pack));
    }
  }










  private void commonSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MBBlocks.LUMINOUS_FLOWER.getId(), MBBlocks.POTTED_LUMINOUS_FLOWER);
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MBBlocks.SNOW_FERN.getId(), MBBlocks.POTTED_SNOW_FERN);
      ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MBBlocks.TINY_CACTUS.getId(), MBBlocks.POTTED_TINY_CACTUS);

      ModelPredicate.register(MBItems.LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
      ModelPredicate.register(MBItems.SPRUCE_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
      ModelPredicate.register(MBItems.BIRCH_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
      ModelPredicate.register(MBItems.AZALEA_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);
      ModelPredicate.register(MBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get(), LeavesBucketItem.BUCKET_VOLUME);

      registerSnowyBlocks();
      registerCompostableItems();
    });
  }

  /**
   * Register new compostable items into Composter block.
   */
  private static void registerCompostableItems() {
    MBUtils.registerCompostableItem(0.3F, MBBlocks.TINY_CACTUS.get().asItem());
    MBUtils.registerCompostableItem(0.3F, MBBlocks.DUNE_GRASS.get().asItem());
    MBUtils.registerCompostableItem(0.5F, MBBlocks.TALL_DUNE_GRASS.get().asItem());
    MBUtils.registerCompostableItem(0.5F, MBBlocks.TALL_DUNE_GRASS.get().asItem());
    MBUtils.registerCompostableItem(0.3F, MBBlocks.SHORT_SNOW_GRASS.get().asItem());
    MBUtils.registerCompostableItem(0.65F, MBBlocks.TALL_SNOW_GRASS.get().asItem());
    MBUtils.registerCompostableItem(0.65F, MBBlocks.SNOW_FERN.get().asItem());
    MBUtils.registerCompostableItem(0.65F, MBBlocks.LARGE_SNOW_FERN.get().asItem());
    MBUtils.registerCompostableItem(0.65F, MBBlocks.CATTAIL.get().asItem());
    MBUtils.registerCompostableItem(0.65F, MBBlocks.LUMINOUS_FLOWER.get().asItem());
    MBUtils.registerCompostableItem(0.85F, MBBlocks.BROWN_MUSHROOM_COLONY.get().asItem());
    MBUtils.registerCompostableItem(1.0F, MBBlocks.TALL_BROWN_MUSHROOM_COLONY.get().asItem());
    MBUtils.registerCompostableItem(0.85F, MBBlocks.RED_MUSHROOM_COLONY.get().asItem());
    MBUtils.registerCompostableItem(1.0F, MBBlocks.TALL_RED_MUSHROOM_COLONY.get().asItem());
    MBUtils.registerCompostableItem(0.85F, MBBlocks.CRIMSON_FUNGUS_COLONY.get().asItem());
    MBUtils.registerCompostableItem(1.0F, MBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get().asItem());
    MBUtils.registerCompostableItem(0.85F, MBBlocks.WARPED_FUNGUS_COLONY.get().asItem());
    MBUtils.registerCompostableItem(1.0F, MBBlocks.TALL_WARPED_FUNGUS_COLONY.get().asItem());
    MBUtils.registerCompostableItem(1.0F, MBItems.LEAVES_BUCKET.get());
    MBUtils.registerCompostableItem(1.0F, MBItems.AZALEA_LEAVES_BUCKET.get());
    MBUtils.registerCompostableItem(1.0F, MBItems.BIRCH_LEAVES_BUCKET.get());
    MBUtils.registerCompostableItem(1.0F, MBItems.FLOWERING_AZALEA_LEAVES_BUCKET.get());
    MBUtils.registerCompostableItem(1.0F, MBItems.SPRUCE_LEAVES_BUCKET.get());
  }

  /**
   * Register new weathering copper blocks.
   */
  /*private static void registerWeatheringCopperBlocks() {
    MBUtils.registerWeatheringCopperBlock(MBBlocks.COPPER_BRICKS.get(), MBBlocks.EXPOSED_COPPER_BRICKS.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_COPPER_BRICKS.get(), MBBlocks.WEATHERED_COPPER_BRICKS.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_COPPER_BRICKS.get(), MBBlocks.OXIDIZED_COPPER_BRICKS.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.CRACKED_COPPER_BRICKS.get(), MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), MBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.CRACKED_CUT_COPPER.get(), MBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), MBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), MBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.COPPER_PILLAR.get(), MBBlocks.EXPOSED_COPPER_PILLAR.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_COPPER_PILLAR.get(), MBBlocks.WEATHERED_COPPER_PILLAR.get());
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_COPPER_PILLAR.get(), MBBlocks.OXIDIZED_COPPER_PILLAR.get());
  }*/

  /**
   * Register new waxable copper blocks.
   */
  /*private static void registerWaxableCopperBlocks() {
    MBUtils.registerWaxableCopperBlock(MBBlocks.COPPER_BRICKS.get(), MBBlocks.WAXED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_COPPER_BRICKS.get(), MBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_COPPER_BRICKS.get(), MBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_COPPER_BRICKS.get(), MBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.CRACKED_COPPER_BRICKS.get(), MBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), MBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), MBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), MBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.CRACKED_CUT_COPPER.get(), MBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), MBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), MBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), MBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.COPPER_PILLAR.get(), MBBlocks.WAXED_COPPER_PILLAR.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_COPPER_PILLAR.get(), MBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_COPPER_PILLAR.get(), MBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_COPPER_PILLAR.get(), MBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
  }*/

  private static void registerSnowyBlocks() {
    MBUtils.registerSnowVariationBlock(Blocks.SHORT_GRASS, MBBlocks.SHORT_SNOW_GRASS.get());
    MBUtils.registerSnowVariationBlock(Blocks.FERN, MBBlocks.SNOW_FERN.get());
    MBUtils.registerSnowVariationBlock(Blocks.TALL_GRASS, MBBlocks.TALL_SNOW_GRASS.get());
    MBUtils.registerSnowVariationBlock(Blocks.LARGE_FERN, MBBlocks.LARGE_SNOW_FERN.get());
  }

  private void registerBlockRenders() {
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TILED_TINTED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.WHITE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.GRAY_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BLACK_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BROWN_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.RED_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.ORANGE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.YELLOW_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIME_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.GREEN_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.CYAN_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BLUE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.PURPLE_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.MAGENTA_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.PINK_STAINED_TILED_GLASS.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.WHITE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.GRAY_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BLACK_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BROWN_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.RED_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.ORANGE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.YELLOW_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIME_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.GREEN_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.CYAN_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BLUE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.PURPLE_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.PINK_STAINED_TILED_GLASS_PANE.get(), RenderType.translucent());

    ItemBlockRenderTypes.setRenderLayer(MBBlocks.IRON_GRATE.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.DIAMOND_GRATE.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.NETHERITE_GRATE.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LUMINOUS_FLOWER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TINY_CACTUS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.DUNE_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_DUNE_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.SHORT_SNOW_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_SNOW_GRASS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.SNOW_FERN.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LARGE_SNOW_FERN.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.CATTAIL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.SMALL_LILY_PADS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.SPRUCE_LEAF_LITTER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BIRCH_LEAF_LITTER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.AZALEA_LEAF_LITTER.get(), RenderType.cutoutMipped());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), RenderType.cutoutMipped());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.LEAF_LITTER.get(), RenderType.cutoutMipped());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BIG_LILY_PAD.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.BROWN_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_RED_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.RED_MUSHROOM_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.RED_MUSHROOM_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.WARPED_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.CRIMSON_FUNGUS_COLONY.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.POTTED_LUMINOUS_FLOWER.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.POTTED_TINY_CACTUS.get(), RenderType.cutout());
    ItemBlockRenderTypes.setRenderLayer(MBBlocks.POTTED_SNOW_FERN.get(), RenderType.cutout());
  }

  private void registerColorProviders(RegisterColorHandlersEvent.Block event) {
    event.register((blockState, tint, pos, i) -> BiomeColors.getAverageFoliageColor(tint, pos), MBBlocks.LEAF_LITTER.get());
  }
}
