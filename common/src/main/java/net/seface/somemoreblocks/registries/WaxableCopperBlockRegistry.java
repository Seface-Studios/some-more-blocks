package net.seface.somemoreblocks.registries;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class WaxableCopperBlockRegistry {
  private static final BiMap<Block, Block> WAXABLES_ON = HashBiMap.create();
  private static final BiMap<Block, Block> WAXABLES_OFF = WAXABLES_ON.inverse();

  /**
   * Registry new Waxable-like Block
   * @param input The Non-Waxable block.
   * @param output The Waxable block.
   */
  public static void register(Block input, Block output) {
    WAXABLES_ON.put(input, output);
  }

  /**
   * Get (if present) the Waxable block from the Non-Waxable block state.
   * @param nonWaxable The Non-Waxable block state.
   * @return The Waxable block state.
   */
  public static Optional<BlockState> getWaxableOn(BlockState nonWaxable) {
    return Optional.ofNullable(
      WAXABLES_ON.get(nonWaxable.getBlock())).map((block) -> block.withPropertiesOf(nonWaxable));
  }

  /**
   * Get (if present) the Non-Waxable block from the Waxable block state.
   * @param waxable The Waxable block state.
   * @return The Non-Waxable block state.
   */
  public static Optional<BlockState> getWaxableOff(BlockState waxable) {
    return Optional.ofNullable(
      WAXABLES_OFF.get(waxable.getBlock())).map((block) -> block.withPropertiesOf(waxable));
  }
}
