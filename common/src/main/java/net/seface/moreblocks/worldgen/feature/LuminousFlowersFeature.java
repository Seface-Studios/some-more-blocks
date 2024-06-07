package net.seface.moreblocks.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LuminousFlowersFeature extends Feature<NoneFeatureConfiguration> {
  public LuminousFlowersFeature(Codec<NoneFeatureConfiguration> codec) {
    super(codec);
  }

  @Override
  public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
    WorldGenLevel level = ctx.level();
    ChunkGenerator chunkGenerator = ctx.chunkGenerator();
    RandomSource rand = ctx.random();
    BlockPos pos = ctx.origin();
    NoneFeatureConfiguration config = ctx.config();

    this.setBlock(level, pos.above(), Blocks.OBSERVER.defaultBlockState());

    return true;
  }
}
