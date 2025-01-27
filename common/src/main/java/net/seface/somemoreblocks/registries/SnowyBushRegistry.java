package net.seface.somemoreblocks.registries;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class SnowyBushRegistry {
  private static final BiMap<Block, Block> SNOWY_BUSH_VARIATIONS = HashBiMap.create();
  private static final BiMap<Block, Block> NORMAL_BUSH_VARIATIONS = SNOWY_BUSH_VARIATIONS.inverse();

  /**
   * Registry new Snowy-like Block
   *
   * @param normal The normal bush block.
   * @param snowy The snowy bush block.
   */
  public static void register(Block normal, Block snowy) {
    SNOWY_BUSH_VARIATIONS.put(normal, snowy);
  }

  /**
   * Get (if present) the Snowy Bush from the normal block state.
   *
   * @param normal The Normal Bush block state.
   * @return The Snowy Bush block state.
   */
  public static Optional<BlockState> getSnowyVariation(BlockState normal) {
    return Optional.ofNullable(
      SNOWY_BUSH_VARIATIONS.get(normal.getBlock())).map((block) -> block.withPropertiesOf(normal));
  }

  /**
   * Get (if present) the Normal Bush from the snowy block state.
   *
   * @param snowy The Snowy Bush block state.
   * @return The Normal Bush block state.
   */
  public static Optional<BlockState> getNormalVariation(BlockState snowy) {
    return Optional.ofNullable(
      NORMAL_BUSH_VARIATIONS.get(snowy.getBlock())).map((block) -> block.withPropertiesOf(snowy));
  }
}
