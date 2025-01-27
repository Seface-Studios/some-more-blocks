package net.seface.somemoreblocks.registries;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.function.UnaryOperator;

public class SMBForgedDataComponentTypes {
  public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, SomeMoreBlocks.ID);

  public static final RegistryObject<DataComponentType<Integer>> BUCKET_VOLUME = register("bucket_volume", (builder) -> builder.persistent(ExtraCodecs.intRange(0, 16)).networkSynchronized(ByteBufCodecs.VAR_INT));
  public static final RegistryObject<DataComponentType<Integer>> MOON_PHASE = register("moon_phase", (builder) -> builder.persistent(ExtraCodecs.intRange(0, 7)).networkSynchronized(ByteBufCodecs.VAR_INT));

  private static <T> RegistryObject<DataComponentType<T>> register(String path, UnaryOperator<DataComponentType.Builder<T>> builder) {
    return DATA_COMPONENT_TYPES.register(path, () -> builder.apply(DataComponentType.builder()).build());
  }

  public static void init(IEventBus bus) {
    DATA_COMPONENT_TYPES.register(bus);
  }
}
