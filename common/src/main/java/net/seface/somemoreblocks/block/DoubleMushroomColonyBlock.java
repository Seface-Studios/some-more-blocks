package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.seface.somemoreblocks.data.MBBlockTags;

public class DoubleMushroomColonyBlock extends DoublePlantBlock {
  public DoubleMushroomColonyBlock(BlockBehaviour.Properties properties) {
    super(properties);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());

    if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
      return blockBelow.is(MBBlockTags.MUSHROOM_COLONY_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
    }

    return blockBelow.is(this) && blockBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
  }
}
