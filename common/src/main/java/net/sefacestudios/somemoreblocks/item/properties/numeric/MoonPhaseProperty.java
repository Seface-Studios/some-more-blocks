package net.sefacestudios.somemoreblocks.item.properties.numeric;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.sefacestudios.somemoreblocks.item.CarvedPaleOakBlockItem;
import org.jetbrains.annotations.Nullable;

public record MoonPhaseProperty() implements RangeSelectItemModelProperty {
  public static final MapCodec<MoonPhaseProperty> MAP_CODEC = MapCodec.unit(new MoonPhaseProperty());

  @Override
  public float get(ItemStack stack, @Nullable ClientLevel clientLevel, @Nullable ItemOwner itemOwner, int i) {
    if (!(stack.getItem() instanceof CarvedPaleOakBlockItem carved)) {
      return 0;
    }

    var moonPhase = carved.getMoonPhaseComponentType();
    if (stack.getComponents().has(moonPhase)) {
      return stack.get(moonPhase);
    }

    return 0;
  }

  @Override
  public MapCodec<MoonPhaseProperty> type() {
    return MAP_CODEC;
  }
}
