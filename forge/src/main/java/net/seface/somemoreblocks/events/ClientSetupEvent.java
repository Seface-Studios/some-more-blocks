package net.seface.somemoreblocks.events;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.util.SMBForgeUtils;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvent {

  @SubscribeEvent
  public static void onClientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      ClientSetupEvent.registerFlowerPots();
      ClientSetupEvent.registerBlockRenders();
    });
  }

  /**
   * Registry Flowers to Flower Pots.
   */
  private static void registerFlowerPots() {
    ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.LUMINOUS_FLOWER.getId(), SMBBlocks.POTTED_LUMINOUS_FLOWER);
    ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.SNOW_FERN.getId(), SMBBlocks.POTTED_SNOW_FERN);
    ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(SMBBlocks.TINY_CACTUS.getId(), SMBBlocks.POTTED_TINY_CACTUS);
  }

  /**
   * Registry the block renders.
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
