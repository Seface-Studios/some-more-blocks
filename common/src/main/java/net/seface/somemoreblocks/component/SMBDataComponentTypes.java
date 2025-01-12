package net.seface.somemoreblocks.component;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.function.UnaryOperator;

public class SMBDataComponentTypes {
  public static final DataComponentType<Integer> BUCKET_VOLUME =
    register("bucket_volume", builder -> builder.persistent(ExtraCodecs.intRange(1, 16)).networkSynchronized(ByteBufCodecs.VAR_INT));

  private static <T>DataComponentType<T> register(String identifier, UnaryOperator<DataComponentType.Builder<T>> builder) {
    return Registry.register(
      BuiltInRegistries.DATA_COMPONENT_TYPE,
      ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, identifier),
      builder.apply(DataComponentType.builder()).build());
  }

  public static void init() {}
}
