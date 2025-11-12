package net.seface.somemoreblocks.events;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;

@EventBusSubscriber(modid = SomeMoreBlocks.ID, value = Dist.CLIENT)
public class ClientSetupEvent {

  @SubscribeEvent
  public static void onClientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      SomeMoreBlocks.initClient();
      ClientSetupEvent.registerFlowerPots();
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
}
