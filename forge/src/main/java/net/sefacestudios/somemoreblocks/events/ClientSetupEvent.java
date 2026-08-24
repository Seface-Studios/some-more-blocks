package net.sefacestudios.somemoreblocks.events;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import net.sefacestudios.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.sefacestudios.somemoreblocks.item.properties.numeric.MoonPhaseProperty;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvent {

  @SubscribeEvent
  public static void onClientSetup(final FMLClientSetupEvent event) {
    event.enqueueWork(() -> {
      registerItemModelProperties();
      SomeMoreBlocks.initClient();
      ClientSetupEvent.registerFlowerPots();
    });
  }

  /**
   * Fallback if the bootstrap mixin did not run (FG7 DevEnv without -mixin.config).
   * Idempotent: LateBoundIdMapper.put overwrites the same id.
   */
  @SuppressWarnings("unchecked")
  private static void registerItemModelProperties() {
    try {
      Field field = RangeSelectItemModelProperties.class.getDeclaredField("ID_MAPPER");
      field.setAccessible(true);
      ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends RangeSelectItemModelProperty>> mapper =
        (ExtraCodecs.LateBoundIdMapper<Identifier, MapCodec<? extends RangeSelectItemModelProperty>>) field.get(null);
      mapper.put(SomeMoreBlocks.id("bucket_volume"), BucketVolumeProperty.MAP_CODEC);
      mapper.put(SomeMoreBlocks.id("moon_phase"), MoonPhaseProperty.MAP_CODEC);
    } catch (ReflectiveOperationException e) {
      throw new IllegalStateException("Failed to register range-select item model properties", e);
    }
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
