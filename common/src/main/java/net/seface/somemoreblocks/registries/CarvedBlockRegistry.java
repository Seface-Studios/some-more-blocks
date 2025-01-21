package net.seface.somemoreblocks.registries;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;

public class CarvedBlockRegistry {
  private static final BiMap<Block, Block> CARVED_BLOCKS = HashBiMap.create();

  /**
   * Registry new Carved-like Block
   * @param stripped The Stripped Log/Wood block.
   * @param carved The Carved Log/Wood block.
   */
  public static void register(Block stripped, Block carved) {
    CARVED_BLOCKS.put(stripped, carved);
  }

  /**
   * Get (if present) the Carved Log/Wood from the stripped block state.
   * @param stripped The Stripped Log/Wood block state.
   * @return The Carved Log/Wood block state.
   */
  public static Optional<BlockState> getCarvedBlock(BlockState stripped) {
    return Optional.ofNullable(
      CARVED_BLOCKS.get(stripped.getBlock())).map((block) -> block.withPropertiesOf(stripped));
  }
}
