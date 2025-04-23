package net.seface.somemoreblocks.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;
import net.seface.somemoreblocks.block.BigLilyPadBlock;
import net.seface.somemoreblocks.block.properties.QuadDirection;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;

public class BigLilyPadFeature extends Feature<NoneFeatureConfiguration> {
  public BigLilyPadFeature(Codec<NoneFeatureConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
    BlockPos pos = ctx.origin();
    WorldGenLevel level = ctx.level();
    RandomSource random = ctx.random();

    Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(random);

    BlockPos bottomRightPos = pos.relative(facing.getClockWise());
    BlockPos topLeftPos = pos.relative(facing);
    BlockPos topRightPos = pos.relative(facing.getClockWise()).relative(facing);

    if (!isValidPlacement(level, pos) || !isValidPlacement(level, bottomRightPos) ||
        !isValidPlacement(level, topLeftPos) || !isValidPlacement(level, topRightPos)) {
      return false;
    }

    BigLilyPadBlock.placeAt(level, facing, pos, 3);
    return true;
  }

  private boolean isValidPlacement(WorldGenLevel level, BlockPos pos) {
    BlockPos belowPos = pos.below();
    return (level.getBlockState(pos).canBeReplaced() || level.getBlockState(pos).isAir() || level.getBlockState(pos).is(SMBBlockTags.BIG_LILY_PAD_REPLACEABLE)) &&
      (level.getFluidState(belowPos).is(Fluids.WATER) || level.getBlockState(belowPos).is(Blocks.ICE));
  }
}
