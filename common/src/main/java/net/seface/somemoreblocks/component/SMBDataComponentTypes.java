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
  public static final DataComponentType<Integer> BUCKET_VOLUME = register("bucket_volume", (builder) -> builder.persistent(ExtraCodecs.intRange(0, 16)).networkSynchronized(ByteBufCodecs.VAR_INT));
  public static final DataComponentType<Integer> MOON_PHASE = register("moon_phase", (builder) -> builder.persistent(ExtraCodecs.intRange(0, 7)).networkSynchronized(ByteBufCodecs.VAR_INT));

  /**
   * Create a new instance of custom Data Component.
   * @param path The Identifier path.
   * @param builder The Data Component builder.
   * @return The Data Component instance.
   */
  private static <T> DataComponentType<T> register(String path, UnaryOperator<DataComponentType.Builder<T>> builder) {
    SomeMoreBlocks.LOGGER.info(path);
      return Registry.register(
        BuiltInRegistries.DATA_COMPONENT_TYPE,
        SomeMoreBlocks.id(path),
        builder.apply(DataComponentType.builder()).build());
  }

  public static void register() {}
}
