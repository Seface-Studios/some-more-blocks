package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("deprecation")
public class PoweredRotatedPillarBlock extends RotatedPillarBlock {
  public PoweredRotatedPillarBlock(BlockBehaviour.Properties properties) {
    super(properties);
  }

  @Override
  public boolean isSignalSource(BlockState state) {
    return true;
  }

  @Override
  public int getSignal(BlockState state, BlockGetter block, BlockPos pos, Direction direction) {
    return 15;
  }
}
