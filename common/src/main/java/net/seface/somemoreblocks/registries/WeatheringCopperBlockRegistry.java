package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class WeatheringCopperBlockRegistry {
  private static final Map<Block, Block> NEXT_BY_BLOCK = new HashMap<>();

  /**
   * TBD
   */
  public static void register(Block input, Block nextBlock) {
    NEXT_BY_BLOCK.put(input, nextBlock);
  }

  /**
   * TBD
   * @return TBD
   */

  /**
   * TBD
   * @return TBD
   */
  public static Map<Block, Block> getNextBlockMap() {
    return Objects.requireNonNull(NEXT_BY_BLOCK);
  }

  /**
   * The same thing as {@link Optional#isPresent()} method but passing block parameter.
   * @param block The block to be checked if exists in the "NEXT_BY_BLOCK" map.
   * @return If the block is present.
   */
  public static boolean isPresentNext(Block block) {
    return NEXT_BY_BLOCK.containsKey(block);
  }

  /**
   * TBD
   * @return TBD
   */
  public static Map<Block, Block> getPreviousBlockMap() {
    Map<Block, Block> previousMap = new HashMap<>();

    for (Map.Entry<Block, Block> entry : NEXT_BY_BLOCK.entrySet()) {
      previousMap.put(entry.getValue(), entry.getKey());
    }

    return previousMap;
  }

  /**
   * The same thing as {@link Optional#isPresent()} method but passing block parameter.
   * @param block The block to be checked if exists in the "PREVIOUS_BY_BLOCK" map.
   * @return If the block is present.
   */
  public static boolean isPresentPrevious(Block block) {
    return getPreviousBlockMap().containsKey(block);
  }
}
