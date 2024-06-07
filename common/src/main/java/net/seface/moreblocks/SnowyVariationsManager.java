package net.seface.moreblocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class SnowyVariationsManager {
  private static final ArrayList<Variation> variations = new ArrayList<>();

  public static class Variation {
    protected final Block normal;
    protected final Block snowy;
    protected final boolean isDoublePlant;

    private Variation(Block normal, Block snowy, boolean isDoublePlant) {
      this.normal = normal;
      this.snowy = snowy;
      this.isDoublePlant = isDoublePlant;
    }
  }

  public static void register(Block normal, Block snowy) {
    register(normal, snowy, false);
  }

  public static void register(Block normal, Block snowy, boolean isDoublePlant) {
    variations.add(new Variation(normal, snowy, isDoublePlant));
  }

  public static boolean hasAnyVariation(BlockState blockState) {
    return hasSnowVariation(blockState) || hasNormalVariation(blockState);
  }

  public static boolean hasSnowVariation(BlockState state) {
    return getSnowyVariationFrom(state) != null;
  }

  public static boolean hasNormalVariation(BlockState state) {
    return getNormalVariationFrom(state) != null;
  }

  @Nullable
  public static BlockState getSnowyVariationFrom(BlockState normal) {
    for (Variation variation : variations) {
      if (variation.normal.equals(normal.getBlock())) {
        if (variation.isDoublePlant) {
          if (normal.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return null;

          return variation.snowy
            .defaultBlockState()
            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
        }

        return variation.snowy.defaultBlockState();
      }
    }

    return null;
  }

  @Nullable
  public static BlockState getNormalVariationFrom(BlockState snowy) {
    for (Variation variation : variations) {
      if (variation.snowy.equals(snowy.getBlock())) {
        if (variation.isDoublePlant) {
          if (snowy.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return null;

          return variation.normal
            .defaultBlockState()
            .setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER);
        }

        return variation.normal.defaultBlockState();
      }
    }

    return null;
  }
}
