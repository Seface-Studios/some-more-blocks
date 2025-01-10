package net.seface.somemoreblocks.worldgen.feature;

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
import net.seface.somemoreblocks.block.LeafLitterBlock;
import net.seface.somemoreblocks.data.SMBBlockTags;

import java.util.HashMap;
import java.util.Map;

public class FallenLeafFeature extends Feature<NoneFeatureConfiguration> {
  private static final int CHUNK_SIZE = 16;
  private final Map<TagKey<Block>, Block> leafBlocks = new HashMap<>();

  public FallenLeafFeature(Codec<NoneFeatureConfiguration> codec) {
    super(codec);
  }

  public FallenLeafFeature addLeafLitterBlock(TagKey<Block> tag, Block leafBlock) {
    this.leafBlocks.put(tag, leafBlock);
    return this;
  }

  @Override
  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
    BlockPos pos = ctx.origin();
    WorldGenLevel level = ctx.level();
    RandomSource random = ctx.random();
    BlockPos.MutableBlockPos mPos = new BlockPos.MutableBlockPos();

    if (this.leafBlocks.isEmpty()) return false;

    for (int xIndex = 0; xIndex < CHUNK_SIZE; xIndex++) {
      for (int zIndex = 0; zIndex < CHUNK_SIZE; zIndex++) {
        int x = pos.getX() + xIndex;
        int z = pos.getZ() + zIndex;

        mPos.set(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING, x, z) - 1, z);

        for (TagKey<Block> tag : this.leafBlocks.keySet()) {
          if (level.getBlockState(mPos).is(tag)) {
            Vec3i v3Pos = new Vec3i(x, level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z), z);
            Vec3i offset = new Vec3i(random.nextInt(6) - 3, 0, random.nextInt(6) - 3); // XZ offset between -2 and 2
            mPos.setWithOffset(v3Pos, offset);

            BlockState stateBelow = level.getBlockState(mPos.below());

            if (Block.isFaceFull(stateBelow.getCollisionShape(level, mPos.below()), Direction.UP) || stateBelow.is(SMBBlockTags.LEAF_LITTERS_PLACEABLE)) {
              LeafLitterBlock leafLitter = (LeafLitterBlock) this.leafBlocks.get(tag);

              if (leafLitter.getChance() < 0.0F || leafLitter.getChance() > 100.0F) {
                throw new IllegalArgumentException("The percentage chance of " + leafLitter.getName() + " is not between 0-100.");
              }

              float chance = random.nextFloat() * 100;

              if (chance <= leafLitter.getChance()) {
                BlockState state2 = level.getBlockState(mPos);

                if (state2.isAir() || state2.is(SMBBlockTags.LEAF_LITTER_REPLACEABLE)) {
                  level.setBlock(mPos, this.leafBlocks.get(tag).defaultBlockState(), 2);
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
