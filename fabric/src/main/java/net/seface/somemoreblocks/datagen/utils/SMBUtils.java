package net.seface.somemoreblocks.datagen.utils;

import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class SMBUtils {

  public static Variant createGenericVariant(ResourceLocation model) {
    return createGenericVariant(model, null, null, null);
  }

  public static Variant createGenericVariant(ResourceLocation model, @Nullable Boolean uvlock, @Nullable VariantProperties.Rotation xRot, @Nullable VariantProperties.Rotation yRot) {
    Variant variant = Variant.variant().with(VariantProperties.MODEL, model);

    if (uvlock != null) variant.with(VariantProperties.UV_LOCK, uvlock);
    if (xRot != null) variant.with(VariantProperties.X_ROT, xRot);
    if (yRot != null) variant.with(VariantProperties.Y_ROT, yRot);

    return variant;
  }
}
