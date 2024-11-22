package net.seface.moreblocks.api;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.function.Supplier;

public interface IBushBlock {
  HashBiMap<Block, Block> SNOW_VARIATIONS = HashBiMap.create();
  Supplier<BiMap<Block, Block>> NORMAL_VARIATIONS = Suppliers.memoize(SNOW_VARIATIONS::inverse);

  static Optional<Block> getSnowVariation(Block block) {
    return Optional.ofNullable(SNOW_VARIATIONS.get(block));
  }

  static boolean hasSnowVariation(Block block) {
    return getSnowVariation(block).isPresent();
  }

  static Optional<Block> getNormalVariation(Block block) {
    return Optional.ofNullable(NORMAL_VARIATIONS.get().get(block));
  }

  static boolean hasNormalVariation(Block block) {
    return getNormalVariation(block).isPresent();
  }
}
