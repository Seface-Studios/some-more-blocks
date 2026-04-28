package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("deprecation")
public class PaleMushroomBlock extends MushroomBlock {
  public PaleMushroomBlock(Properties properties) {
    super(null, properties);
  }

  @Override
  public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
    return false;
  }

  @Override
  public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
    return false;
  }

  @Override
  public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
    /*
      Maybe in the future we add a
      tree-like mushroom feature.
    */
  }
}
