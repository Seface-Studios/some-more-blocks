package net.seface.somemoreblocks.mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.item.properties.numeric.MoonPhaseProperty;
import net.seface.somemoreblocks.registries.SMBForgedDataComponentTypes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RangeSelectItemModelProperties.class)
public abstract class RangeSelectItemModelPropertiesMixin {

  @Shadow
  @Final
  private static ExtraCodecs.LateBoundIdMapper<ResourceLocation, MapCodec<? extends RangeSelectItemModelProperty>> ID_MAPPER;

  @Inject(method = "bootstrap", at = @At(value = "RETURN"))
  private static void bootstrapMixin(CallbackInfo ci) {
    ID_MAPPER.put(SMBForgedDataComponentTypes.BUCKET_VOLUME.getId(), BucketVolumeProperty.MAP_CODEC);
    ID_MAPPER.put(SMBForgedDataComponentTypes.MOON_PHASE.getId(), MoonPhaseProperty.MAP_CODEC);
  }
}
