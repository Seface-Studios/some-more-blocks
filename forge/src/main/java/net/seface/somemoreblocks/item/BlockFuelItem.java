package net.seface.somemoreblocks.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class BlockFuelItem extends BlockItem {
  private int burnTime = 0;

  public BlockFuelItem(Block block, Properties properties, int burnTime) {
    super(block, properties);
    this.burnTime = burnTime;
  }

  @Override
  public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
    return this.burnTime;
  }
}
