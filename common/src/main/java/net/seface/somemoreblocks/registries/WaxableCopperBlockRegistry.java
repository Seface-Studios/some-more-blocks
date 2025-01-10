package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class WaxableCopperBlockRegistry {
  private static final Map<Block, Block> WAXABLES = new HashMap<>();

  /**
   * TBD
   */
  public static void register(Block input, Block output) {
    WAXABLES.put(input, output);
  }

  /**
   * TBD
   * @return TBD
   */
  public static Map<Block, Block> getWaxables() {
    return Objects.requireNonNull(WAXABLES);
  }

  public static boolean isPresentNext(Block block) {
    return WAXABLES.containsKey(block);
  }

  public static Map<Block, Block> getInvertedWaxables() {
    Map<Block, Block> previousMap = new HashMap<>();

    for (Map.Entry<Block, Block> entry : WAXABLES.entrySet()) {
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
    return getInvertedWaxables().containsKey(block);
  }
}
