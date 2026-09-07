package net.sefacestudios.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.sefacestudios.somemoreblocks.registries.SMBGameRules;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;

public final class SnowyPlantTicks {
  private SnowyPlantTicks() {
  }

  public static boolean isRandomlyTicking(Block block, BlockState state, boolean original) {
    boolean hasSnowy = SMBRegistries.SNOWY_PLANT_BLOCKS.getNext(block).isPresent();
    boolean hasNormal = SMBRegistries.SNOWY_PLANT_BLOCKS.getPrevious(block).isPresent();

    if (!hasSnowy && !hasNormal) {
      return original;
    }

    return (hasSnowy || hasNormal && !original) || (!hasSnowy || !hasNormal && original);
  }

  public static void randomTick(BlockState state, ServerLevel level, BlockPos pos) {
    if (!level.getGameRules().get(SMBGameRules.RULE_SNOW_ACCUMULATE.get())) {
      return;
    }

    SnowyPlantVariation.turnIntoNormalVariation(state, level, pos);
    SnowyPlantVariation.turnIntoSnowVariation(state, level, pos);
  }
}
