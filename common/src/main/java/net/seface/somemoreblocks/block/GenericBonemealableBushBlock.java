package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class GenericBonemealableBushBlock extends TallGrassBlock implements BonemealableBlock {
  private final Block tallBlock;
  private final TagKey<Block> placeableAt;

  public GenericBonemealableBushBlock(Block tallBlock, BlockBehaviour.Properties properties) {
    this(tallBlock, BlockTags.DIRT, properties);
  }

  public GenericBonemealableBushBlock(Block tallBlock, TagKey<Block> placeableAt, Properties properties) {
    super(properties);

    this.tallBlock = tallBlock;
    this.placeableAt = placeableAt;
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());
    return blockBelow.is(this.placeableAt);
  }

  @Override
  public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
    DoublePlantBlock doublePlantBlock = (DoublePlantBlock) this.tallBlock;
    if (doublePlantBlock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {

    }
  }
}
