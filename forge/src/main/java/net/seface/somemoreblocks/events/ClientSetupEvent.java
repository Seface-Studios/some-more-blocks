package net.seface.somemoreblocks.events;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.nio.file.Path;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvent {

  @SubscribeEvent
  public static void onClientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      SomeMoreBlocks.initClient();
      ClientSetupEvent.registerFlowerPots();
    });
  }

  @SubscribeEvent
  public static void onFindPacks(AddPackFindersEvent event) {
    if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

    Path rpPath = ModList.get().getModFileById(SomeMoreBlocks.ID).getFile().findResource("resourcepacks/update_1_21");
    Pack pack = Pack.readMetaAndCreate(
      SomeMoreBlocks.id("update_1_21").toString(),
      Component.translatable("somemoreblocks.resourcepack.update_1_21.name"),
      false,
      new PathPackResources.PathResourcesSupplier(rpPath, false),
      PackType.CLIENT_RESOURCES,
      Pack.Position.BOTTOM,
      PackSource.BUILT_IN
    );

    event.addRepositorySource((source) -> source.accept(pack));
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
