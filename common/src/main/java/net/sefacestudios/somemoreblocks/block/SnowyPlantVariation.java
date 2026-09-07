package net.sefacestudios.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;

import java.util.Optional;

public final class SnowyPlantVariation {
  private SnowyPlantVariation() {
  }

  public static void turnIntoSnowVariation(BlockState state, Level level, BlockPos pos) {
    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    boolean isSnowing = level.getBiome(pos).value().coldEnoughToSnow(pos, level.getSeaLevel()) && level.isRaining() && level.canSeeSky(pos);
    Optional<Block> snowyVariation = SMBRegistries.SNOWY_PLANT_BLOCKS.getNext(state.getBlock());

    if (snowyVariation.isEmpty()) return;
    if (!isSnowing || level.getBrightness(LightLayer.BLOCK, pos) > 11) return;

    if (isDoublePlant) {
      if (state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return;

      level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
      DoublePlantBlock.placeAt(level, snowyVariation.get().withPropertiesOf(state), pos, Block.UPDATE_CLIENTS);
      return;
    }

    level.setBlock(pos, snowyVariation.get().withPropertiesOf(state), Block.UPDATE_ALL);
  }

  public static void turnIntoNormalVariation(BlockState state, Level level, BlockPos pos) {
    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    if (level.getBrightness(LightLayer.BLOCK, pos) > 11) {
      Optional<Block> normalVariation = SMBRegistries.SNOWY_PLANT_BLOCKS.getPrevious(state.getBlock());

      if (normalVariation.isEmpty()) return;
      if (isDoublePlant) {
        if (state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return;

        level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
        DoublePlantBlock.placeAt(level, normalVariation.get().withPropertiesOf(state), pos, Block.UPDATE_ALL);
        return;
      }

      level.setBlock(pos, normalVariation.get().withPropertiesOf(state), Block.UPDATE_ALL);
    }
  }
}
