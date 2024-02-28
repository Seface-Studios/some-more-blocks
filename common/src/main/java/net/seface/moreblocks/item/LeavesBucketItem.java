package net.seface.moreblocks.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.seface.moreblocks.block.LeafLitterBlock;

public class LeavesBucketItem extends BucketItem {
    private final Block leafLitter;

    public LeavesBucketItem(Properties properties, LeafLitterBlock leafLitter) {
        super(Fluids.EMPTY, properties);

        this.leafLitter = leafLitter;
    }
}
