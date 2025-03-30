package net.seface.somemoreblocks.registries;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;

public class SMBDataComponentTypes {
  public static final PlatformRegistryObject<DataComponentType<Integer>> BUCKET_VOLUME = PlatformServices.REGISTRY.registerDataComponent("bucket_volume", (builder) -> builder.persistent(ExtraCodecs.intRange(0, 16)).networkSynchronized(ByteBufCodecs.VAR_INT));
  public static final PlatformRegistryObject<DataComponentType<Integer>> MOON_PHASE = PlatformServices.REGISTRY.registerDataComponent("moon_phase", (builder) -> builder.persistent(ExtraCodecs.intRange(0, 7)).networkSynchronized(ByteBufCodecs.VAR_INT));

  public static void init() {}
}
