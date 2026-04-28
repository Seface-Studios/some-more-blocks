package net.seface.somemoreblocks.item.properties.numeric;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;
import org.jetbrains.annotations.Nullable;

public record BucketVolumeProperty() implements RangeSelectItemModelProperty {
  public static final MapCodec<BucketVolumeProperty> MAP_CODEC = MapCodec.unit(new BucketVolumeProperty());

  @Override
  public float get(ItemStack stack, @Nullable ClientLevel clientLevel, @Nullable ItemOwner itemOwner, int i) {
    if (stack.getComponents().has(SMBDataComponentTypes.BUCKET_VOLUME.get())) {
      return stack.get(SMBDataComponentTypes.BUCKET_VOLUME.get());
    }

    return 0;
  }

  @Override
  public MapCodec<BucketVolumeProperty> type() {
    return MAP_CODEC;
  }
}
