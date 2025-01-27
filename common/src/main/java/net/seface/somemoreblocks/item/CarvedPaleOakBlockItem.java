package net.seface.somemoreblocks.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.api.ICarvedPaleOakBlockItem;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;

public class CarvedPaleOakBlockItem extends BlockItem implements ICarvedPaleOakBlockItem {

  public CarvedPaleOakBlockItem(Block block, Properties properties) {
    super(block, properties);
  }

  @Override
  protected boolean placeBlock(BlockPlaceContext ctx, BlockState state) {
    ItemStack stack = ctx.getItemInHand();
    int moonPhase = stack.getComponents().getOrDefault(this.getMoonPhaseComponentType(), RotatedCarvedPaleOakBlock.MIN_MOON_PHASE);

    return super.placeBlock(ctx, state.setValue(RotatedCarvedPaleOakBlock.MOON_PHASE, moonPhase));
  }
}
