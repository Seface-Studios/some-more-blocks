package net.seface.somemoreblocks.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.seface.somemoreblocks.worldgen.feature.configurations.CeilingVeinConfiguration;

public class CeilingVeinFeature extends Feature<CeilingVeinConfiguration> {
  public CeilingVeinFeature(Codec<CeilingVeinConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<CeilingVeinConfiguration> context) {
    WorldGenLevel level = context.level();
    RandomSource random = context.random();
    BlockPos origin = context.origin();

    int veinCount = 1 + random.nextInt(2); // 1–2 veias
    for (int i = 0; i < veinCount; i++) {
      int veinWeight = 1 + random.nextInt(2); // 1–2 de grossura
      generateVein(context, level, origin, random, veinWeight);
    }

    return true;
  }

  private void generateVein(FeaturePlaceContext<CeilingVeinConfiguration> context, WorldGenLevel level, BlockPos origin, RandomSource random, int veinWeight) {
    BlockPos.MutableBlockPos pos = origin.mutable();

    Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
    int length = context.config().length().sample(random);

    // Curvatura acumulada
    int curveBias = 0;

    for (int i = 0; i < length; i++) {
      placeVeinChunk(context, level, pos, veinWeight);

      // Ramificação com bifurcação real
      if (random.nextFloat() < 0.2f) {
        Direction branchDir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        BlockPos branchPos = pos.relative(branchDir).above(random.nextInt(2));
        generateVein(context, level, branchPos, random, Math.max(1, veinWeight - 1));
      }

      // Curvatura suave com viés acumulado
      if (random.nextFloat() < 0.3f) {
        curveBias += random.nextBoolean() ? 1 : -1;
        Direction curveDir = curveBias > 0 ? direction.getClockWise() : direction.getCounterClockWise();
        pos.move(curveDir);
      }

      // Oscilação vertical suave
      if (random.nextFloat() < 0.4f) {
        pos.move(Direction.UP, random.nextInt(2));
      }

      pos.move(direction);

      // Afinamento gradual com base na distância
      if (i > length / 2 && veinWeight > 1 && random.nextFloat() < 0.3f) {
        veinWeight--;
      }
    }
  }

  private void placeVeinChunk(FeaturePlaceContext<CeilingVeinConfiguration> context, WorldGenLevel level, BlockPos center, int weight) {
    for (int dx = -weight; dx <= weight; dx++) {
      for (int dz = -weight; dz <= weight; dz++) {
        double distance = Math.sqrt(dx * dx + dz * dz);
        if (distance > weight + 0.5) continue;

        BlockPos target = center.offset(dx, 0, dz);
        BlockPos above = target.above();
        BlockState aboveState = level.getBlockState(above);

        BlockState toPlaceBlock = context.config().entries().getState(context.random(), target);
        boolean isValidPlacement = context.config().replaceablePredicate().test(context.level(), target);

        if (isValidPlacement && aboveState.isFaceSturdy(level, above, Direction.DOWN)) {
          level.setBlock(target, toPlaceBlock, 2);
        }
      }
    }
  }
}
