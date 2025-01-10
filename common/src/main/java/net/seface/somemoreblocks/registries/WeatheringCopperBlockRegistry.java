package net.seface.somemoreblocks.registries;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class WeatheringCopperBlockRegistry {
  private static final BiMap<Block, Block> NEXT_BLOCK = HashBiMap.create();
  private static final BiMap<Block, Block> PREVIOUS_BLOCK = NEXT_BLOCK.inverse();

  /**
   * Registry new Weathering-like Block
   * @param input The Weathering block.
   * @param output The next block to be turned into.
   */
  public static void register(Block input, Block output) {
    NEXT_BLOCK.put(input, output);
  }

  /**
   * Get (if present) the next block state from the current block state.
   * @param state The current block state.
   * @return The next block state.
   */
  public static Optional<BlockState> getNext(BlockState state) {
    return Optional.ofNullable(
      NEXT_BLOCK.get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
  }

  /**
   * Get (if present) the previous block state from the current block state.
   * @param state The current block state.
   * @return The previous block state.
   */
  public static Optional<BlockState> getPrevious(BlockState state) {
    return Optional.ofNullable(
      PREVIOUS_BLOCK.get(state.getBlock())).map((block) -> block.withPropertiesOf(state));
  }
}
