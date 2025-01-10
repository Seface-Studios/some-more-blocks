package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarvedBlockRegistry {
  private static final Map<Block, Block> CARVED_BLOCKS = new HashMap<>();

  public static void register(Block input, Block carved) {
    CARVED_BLOCKS.put(input, carved);
  }

  public static Map<Block, Block> getCarvedBlocks() {
    return Objects.requireNonNull(CARVED_BLOCKS);
  }
}
