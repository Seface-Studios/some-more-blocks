package net.seface.moreblocks.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.seface.moreblocks.interfaces.ILeafLitterBlock;

import java.util.HashMap;
import java.util.Map;

public class FallenLeafFeature extends Feature<NoneFeatureConfiguration> {
  private Map<TagKey<Block>, Block> leafBlocks = new HashMap<>();

  public FallenLeafFeature(Codec<NoneFeatureConfiguration> codec) {
    super(codec);
  }

  public FallenLeafFeature addLeafBlock(TagKey<Block> tag, Block leafBlock) {
    this.leafBlocks.put(tag, leafBlock);
    return this;
  }

  @Override
  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
    BlockPos blockPos = ctx.origin();
    WorldGenLevel level = ctx.level();
    BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

    for (int xIndex = 0; xIndex < 16; xIndex++) {
      for (int zIndex = 0; zIndex < 16; zIndex++) {
        int x = blockPos.getX() + xIndex;
        int z = blockPos.getZ() + zIndex;

        mutablePos.set(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING, x, z) - 1, z);

        for (TagKey<Block> tag : this.leafBlocks.keySet()) {
          if (level.getBlockState(mutablePos).is(tag)) {
            Vec3i pos = new Vec3i(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), z);
            mutablePos.setWithOffset(pos, new Vec3i(0, -1, 0));

            BlockState stateBelow = level.getBlockState(mutablePos);

            if (stateBelow.isSolid()) {
              ILeafLitterBlock leafLitter = (ILeafLitterBlock) this.leafBlocks.get(tag);

              if (leafLitter.getChance() < 0.0F || leafLitter.getChance() > 100.0F) {
                throw new IllegalArgumentException("The percentage chance of " + leafLitter.getName() + " is not between 0-100.");
              }

              RandomSource random = ctx.random();
              float randomValue = random.nextFloat() * 100;

              mutablePos.move(Direction.UP);
              if (randomValue <= leafLitter.getChance()) {
                if (level.getBlockState(mutablePos).isAir()) {
                  level.setBlock(mutablePos, this.leafBlocks.get(tag).defaultBlockState(), 2);
                }
              }
            }
          }
        }
      }
    }

    return true;
  }
}
