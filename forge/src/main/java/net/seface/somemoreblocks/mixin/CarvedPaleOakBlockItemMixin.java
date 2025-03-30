package net.seface.somemoreblocks.mixin;

import net.minecraft.core.component.DataComponentType;
import net.seface.somemoreblocks.api.ICarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CarvedPaleOakBlockItem.class)
public abstract class CarvedPaleOakBlockItemMixin implements ICarvedPaleOakBlockItem {

  @Override
  public DataComponentType<Integer> getMoonPhaseComponentType() {
    return SMBDataComponentTypes.MOON_PHASE.get();
  }
}
