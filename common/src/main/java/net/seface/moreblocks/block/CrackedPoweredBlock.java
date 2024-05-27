package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CrackedPoweredBlock extends PoweredBlock {
    public CrackedPoweredBlock(Properties properties) {
        super(properties);
    }

    public int getSignal(BlockState state, BlockGetter block, BlockPos pos, Direction direction) {
        return 7;
    }
}
