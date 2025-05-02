package net.seface.somemoreblocks.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.worldgen.feature.configurations.SimpleLeafLitterBlockConfiguration;

import java.util.List;

public class LeafLitterFeature extends Feature<SimpleLeafLitterBlockConfiguration> {
  private static final int CHUNK_SIZE = 16;

  public LeafLitterFeature(Codec<SimpleLeafLitterBlockConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<SimpleLeafLitterBlockConfiguration> ctx) {
    BlockPos pos = ctx.origin();
    WorldGenLevel level = ctx.level();
    RandomSource random = ctx.random();
    BlockPos.MutableBlockPos mPos = new BlockPos.MutableBlockPos();

    BlockState leafLitter = ctx.config().toPlace().getState(random, pos);
    float placeChance = ctx.config().chance();
    int xzSpread = ctx.config().xzSpread();
    List<ResourceKey<Block>> parents = ctx.config().parents();

    for (int xIndex = 0; xIndex < CHUNK_SIZE; xIndex++) {
      for (int zIndex = 0; zIndex < CHUNK_SIZE; zIndex++) {
        int x = pos.getX() + xIndex;
        int z = pos.getZ() + zIndex;

        mPos.set(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING, x, z) - 1, z);

        if (parents.contains(BuiltInRegistries.BLOCK.getResourceKey(level.getBlockState(mPos).getBlock()).get())) {
          Vec3i v3Pos = new Vec3i(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), z);
          Vec3i offset = new Vec3i((random.nextInt(xzSpread) - random.nextInt(xzSpread)), 0, (random.nextInt(xzSpread) - random.nextInt(xzSpread))); // XZ offset between -2 and 2
          mPos.setWithOffset(v3Pos, offset);

          BlockState stateBelow = level.getBlockState(mPos.below());

          if (Block.isFaceFull(stateBelow.getCollisionShape(level, mPos.below()), Direction.UP) || stateBelow.is(SMBBlockTags.LEAF_LITTERS_PLACEABLE)) {
            float chance = random.nextFloat() * 100;

            if (chance <= placeChance) {
              BlockState state2 = level.getBlockState(mPos);

              if (state2.isAir() || state2.is(SMBBlockTags.LEAF_LITTER_REPLACEABLE)) {
                level.setBlock(mPos, leafLitter, 2);
              }
            }
          }
        }
      }
    }

    return true;
  }
}
