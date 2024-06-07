package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootDataType;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.seface.moreblocks.tags.MBBlockTags;

public class TallDuneGrassBlock extends DoublePlantBlock {
    public TallDuneGrassBlock(Properties properties) {
        super(properties);
    }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());

    if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
      return blockBelow.is(MBBlockTags.DUNE_GRASS_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
    }

    return blockBelow.is(this) && blockBelow.getValue(HALF) == DoubleBlockHalf.LOWER;
  }
}
