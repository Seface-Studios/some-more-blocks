package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils;

import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;

import java.util.List;

public class RandomPatchPlacementUtils {

  public static void add(List<PlacementModifier> modifier, int tries, int xzSpread, int ySpread) {
    modifier.add(CountPlacement.of(tries));
    modifier.add(RandomOffsetPlacement.ofTriangle(xzSpread, ySpread));
  }

  @SuppressWarnings("deprecation")
  public static void addEveryLayer(List<PlacementModifier> modifier, int tries, int xzSpread, int ySpread) {
    modifier.add(CountOnEveryLayerPlacement.of(tries));
    modifier.add(RandomOffsetPlacement.ofTriangle(xzSpread, ySpread));
  }
}
