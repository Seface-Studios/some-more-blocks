package net.seface.somemoreblocks.item;

import lombok.Getter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

@Getter
public class FuelBlockItem extends BlockItem {
  private int burnTime = 0;

  public FuelBlockItem(Block block, Properties properties, int burnTime) {
    super(block, properties);

    this.burnTime = burnTime;
  }
}
