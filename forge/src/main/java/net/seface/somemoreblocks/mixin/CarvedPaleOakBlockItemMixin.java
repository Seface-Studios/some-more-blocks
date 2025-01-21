package net.seface.somemoreblocks.mixin;

import net.minecraft.core.component.DataComponentType;
import net.seface.somemoreblocks.api.ICarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.registries.SMBForgedDataComponentTypes;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CarvedPaleOakBlockItem.class)
public abstract class CarvedPaleOakBlockItemMixin implements ICarvedPaleOakBlockItem {

  @Override
  public DataComponentType<Integer> getMoonPhaseComponentType() {
    return SMBForgedDataComponentTypes.MOON_PHASE.get();
  }
}
