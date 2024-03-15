package net.seface.moreblocks.worldgen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.seface.moreblocks.MoreBlocks;

public class CattailFeature extends Feature<CattailFeature.Configuration> {
    public static final ResourceLocation ID = new ResourceLocation(MoreBlocks.ID, "cattail_patch");

    public CattailFeature(Codec<Configuration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<Configuration> context) {
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        Configuration config = context.config();

        int number = config.number();
        ResourceLocation blockId = config.blockId();

        BlockState blockState = Blocks.ANDESITE.defaultBlockState();

        BlockPos testPos = new BlockPos(origin);
        for (int y = 0; y < world.getHeight(); y++) {
            testPos = testPos.above();
            if (world.getBlockState(testPos).is(BlockTags.DIRT)) {
                if (world.getBlockState(testPos.above()).is(Blocks.AIR)) {
                    for (int i = 0; i < number; i++) {
                        world.setBlock(testPos, blockState, 0x10);
                        testPos = testPos.above();

                        if (testPos.getY() >= world.getMaxBuildHeight()) break;
                    }
                    return true;
                }
            }
        }

        return false;
    }

    public record Configuration(int number, ResourceLocation blockId) implements FeatureConfiguration {
        public static final Codec<Configuration> CODEC = RecordCodecBuilder.create(
                instance -> instance.group(
                                ExtraCodecs.POSITIVE_INT.fieldOf("number").forGetter(Configuration::number),
                                ResourceLocation.CODEC.fieldOf("blockID").forGetter(Configuration::blockId))
                        .apply(instance, Configuration::new));
    }
}
