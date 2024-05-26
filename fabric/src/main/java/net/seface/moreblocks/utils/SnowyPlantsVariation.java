package net.seface.moreblocks.utils;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.moreblocks.registry.MBBlocks;

public enum SnowyPlantsVariation {
    FERN(Blocks.FERN, MBBlocks.SNOW_FERN, false, 0.25F),
    TALL_FERN(Blocks.LARGE_FERN, MBBlocks.TALL_SNOW_FERN, true, 0.25F),
    SHORT_GRASS(Blocks.SHORT_GRASS, MBBlocks.SNOW_GRASS, false, 0.25F),
    TALL_GRASS(Blocks.TALL_GRASS, MBBlocks.TALL_SNOW_GRASS, true, 0.25F);

    private final Block normal;
    private final Block snowy;
    private final boolean isTall;
    private final float chance;

    SnowyPlantsVariation(Block normal, Block snowy, boolean isTall, float chance) {
        this.normal = normal;
        this.snowy = snowy;
        this.isTall = isTall;
        this.chance = chance;
    }

    public static BlockState getSnowyVariationOf(BlockState normalVariation) {
        for (SnowyPlantsVariation plant : SnowyPlantsVariation.values()) {
            if (plant.normal.equals(normalVariation.getBlock())) {
                if (plant.isTall) {
                    return plant.snowy
                            .defaultBlockState()
                            .setValue(DoublePlantBlock.HALF, normalVariation.getValue(DoublePlantBlock.HALF));
                }

                return plant.snowy.defaultBlockState();
            }
        }

        return normalVariation;
    }

    public static BlockState getNormalVariationOf(BlockState snowyVariation) {
        for (SnowyPlantsVariation plant : SnowyPlantsVariation.values()) {
            if (plant.snowy.equals(snowyVariation.getBlock())) {
                return plant.normal.defaultBlockState();
            }
        }

        return snowyVariation;
    }
}
