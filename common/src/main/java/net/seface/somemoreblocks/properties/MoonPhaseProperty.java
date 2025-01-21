package net.seface.somemoreblocks.properties;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import org.jetbrains.annotations.Nullable;

public record MoonPhaseProperty() implements RangeSelectItemModelProperty {
  public static final MapCodec<MoonPhaseProperty> MAP_CODEC = MapCodec.unit(new MoonPhaseProperty());

  @Override
  public float get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int i) {
    if (stack.getComponents().has(((CarvedPaleOakBlockItem) stack.getItem()).getMoonPhaseComponentType())) {
      return stack.get(((CarvedPaleOakBlockItem) stack.getItem()).getMoonPhaseComponentType());
    }

    return 0;
  }

  @Override
  public MapCodec<MoonPhaseProperty> type() {
    return MAP_CODEC;
  }
}
