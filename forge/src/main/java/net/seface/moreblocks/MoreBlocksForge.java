package net.seface.moreblocks;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.seface.moreblocks.registry.MBBlocks;
import net.seface.moreblocks.registry.MBCreativeTabs;
import net.seface.moreblocks.registry.MBItems;

@Mod(MoreBlocks.ID)
public class MoreBlocksForge {
    public MoreBlocksForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MoreBlocks.init();
        MBBlocks.register(eventBus);
        MBItems.register(eventBus);
        MBCreativeTabs.register(eventBus);

        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::registerColorProviders);
        eventBus.addListener(this::commonSetup);
    }



    private void commonSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MBBlocks.LUMINOUS_FLOWER.getId(), MBBlocks.POTTED_LUMINOUS_FLOWER);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MBBlocks.SNOW_FERN.getId(), MBBlocks.POTTED_SNOW_FERN);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(MBBlocks.TINY_CACTUS.getId(), MBBlocks.POTTED_TINY_CACTUS);
            registerSnowyVariations();
        });
    }

  private static void registerSnowyVariations() {
    SnowyVariationsManager.register(Blocks.SHORT_GRASS, MBBlocks.SNOW_GRASS.get());
    SnowyVariationsManager.register(Blocks.FERN, MBBlocks.SNOW_FERN.get());
    SnowyVariationsManager.register(Blocks.TALL_GRASS, MBBlocks.TALL_SNOW_GRASS.get(), true);
    SnowyVariationsManager.register(Blocks.LARGE_FERN, MBBlocks.TALL_SNOW_FERN.get(), true);
  }

    private void clientSetup(final FMLClientSetupEvent event) {
        this.registerBlockRenders();
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
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.IRON_GRATE.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.DIAMOND_GRATE.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.NETHERITE_GRATE.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.LUMINOUS_FLOWER.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.TINY_CACTUS.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.DUNE_GRASS.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_DUNE_GRASS.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.SNOW_GRASS.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_SNOW_GRASS.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.SNOW_FERN.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.TALL_SNOW_FERN.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.CATTAIL.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.SMALL_LILY_PADS.get(), RenderType.cutout());
      ItemBlockRenderTypes.setRenderLayer(MBBlocks.FROZEN_LEAF_LITTER.get(), RenderType.cutout());
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
