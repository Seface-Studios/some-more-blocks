package net.seface.somemoreblocks.properties;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import org.jetbrains.annotations.Nullable;

public record BucketVolumeProperty() implements RangeSelectItemModelProperty {
  public static final MapCodec<BucketVolumeProperty> MAP_CODEC = MapCodec.unit(new BucketVolumeProperty());

  @Override
  public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int i) {
    if (stack.getComponents().has(((LeavesBucketItem) stack.getItem()).getBucketVolumeComponentType())) {
      return stack.get(((LeavesBucketItem) stack.getItem()).getBucketVolumeComponentType());
    }

    return 0;
  }

  @Override
  public MapCodec<BucketVolumeProperty> type() {
    return MAP_CODEC;
  }
}
