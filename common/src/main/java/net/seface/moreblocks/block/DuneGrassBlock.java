package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DuneGrassBlock extends AbstractCustomGrassPlantBlock {
    public static final float TEMPERATURE = 2.0F;

    public DuneGrassBlock(Block tallVariation, Properties properties) {
        super(tallVariation, properties);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockBelow = level.getBlockState(pos.below());

        return blockBelow.is(BlockTags.SAND) ||
                (blockBelow.is(BlockTags.DIRT) && level.getBiome(pos).value().getBaseTemperature() >= TEMPERATURE);
    }
}
