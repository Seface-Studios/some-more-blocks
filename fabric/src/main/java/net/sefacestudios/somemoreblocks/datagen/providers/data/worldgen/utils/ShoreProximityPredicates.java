package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils;

import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Shoreline proximity checks for aquatic vegetation placement.
 */
public final class ShoreProximityPredicates {
  private ShoreProximityPredicates() {}

  /**
   * True if any solid block exists within Chebyshev distance {@code maxDistance}
   * on the XZ plane at the given Y offset from the placement origin.
   */
  public static BlockPredicate solidWithin(int maxDistance, int yOffset) {
    List<BlockPredicate> predicates = new ArrayList<>();

    for (int dx = -maxDistance; dx <= maxDistance; dx++) {
      for (int dz = -maxDistance; dz <= maxDistance; dz++) {
        if (dx == 0 && dz == 0) {
          continue;
        }

        predicates.add(BlockPredicate.solid(new Vec3i(dx, yOffset, dz)));
      }
    }

    return BlockPredicate.anyOf(predicates.toArray(BlockPredicate[]::new));
  }
}
