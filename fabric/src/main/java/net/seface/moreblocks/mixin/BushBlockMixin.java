package net.seface.moreblocks.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.moreblocks.utils.SnowyPlantsVariation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(BushBlock.class)
public abstract class BushBlockMixin extends Block {
    public BushBlockMixin(Properties $$0) {
        super($$0);
    }

    private void scheduleTick(ServerLevel level, BlockPos pos, RandomSource random) {
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("aaa?"));


        this.transformIntoSnowyVariation(level.getBlockState(pos), level, pos, random);
    }

    /*@Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);


    }*/

    /*@Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        //this.transformIntoNormalVariation(state, level, pos, random);
        this.transformIntoSnowyVariation(state, level, pos, random);
    }*/

    /*private void transformIntoNormalVariation(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (level.getBrightness(LightLayer.BLOCK, pos) > 11) {
            Block normalPlant = SnowyPlantsVariation.getNormalVariationOf(level.getBlockState(pos).getBlock());
            level.setBlock(pos, normalPlant.defaultBlockState(), 3);
        }
    }*/

    private void transformIntoSnowyVariation(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        boolean isSnowing = level.getBiome(pos).value().getPrecipitationAt(pos).equals(Biome.Precipitation.SNOW);
        if (!isSnowing || level.getBrightness(LightLayer.BLOCK, pos) > 11) return;

        if (random.nextFloat() > 0.25) return;

        BlockState snowyPlant = SnowyPlantsVariation.getSnowyVariationOf(state);
        level.setBlockAndUpdate(pos, snowyPlant);
    }
}
