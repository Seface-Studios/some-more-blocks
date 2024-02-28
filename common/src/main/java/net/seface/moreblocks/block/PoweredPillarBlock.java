package net.seface.moreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PoweredPillarBlock extends RotatedPillarBlock {
    public static final MapCodec<PoweredPillarBlock> CODEC = simpleCodec(PoweredPillarBlock::new);

    public PoweredPillarBlock(Properties properties) {
        super(properties);
    }

    public MapCodec<PoweredPillarBlock> codec() {
        return CODEC;
    }

    public boolean isSignalSource(BlockState state) {
        return true;
    }

    public int getSignal(BlockState state, BlockGetter block, BlockPos pos, Direction direction) { return 15; }
}
