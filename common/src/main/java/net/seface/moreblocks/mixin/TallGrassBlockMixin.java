package net.seface.moreblocks.mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.moreblocks.SnowyVariationsManager;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TallGrassBlock.class)
public class TallGrassBlockMixin extends BushBlock implements BonemealableBlock {
  @Shadow @Final public static MapCodec<TallGrassBlock> CODEC;

  protected TallGrassBlockMixin(Properties properties) {
    super(properties);
  }

  @Inject(method = "<init>", at = @At("RETURN"))
  public void init(Properties properties, CallbackInfo ci) {
    super.properties.randomTicks();
  }

  @Shadow public @NotNull MapCodec<TallGrassBlock> codec() { return CODEC; }
  @Shadow public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) { return false; }
  @Shadow public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) { return false; }
  @Shadow public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {}

  @Override
  public boolean isRandomlyTicking(BlockState state) { return true; }

  @SuppressWarnings("deprecation")
  @Override
  public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    MB$turnIntoSnowVariation(state, level, pos);
    MB$turnIntoNormalVariation(state, level, pos);
  }

  @Unique
  private static void MB$turnIntoSnowVariation(BlockState state, Level level, BlockPos pos) {
    boolean isSnowing = level.getBiome(pos).value().getPrecipitationAt(pos).equals(Biome.Precipitation.SNOW) && level.isRaining() && level.canSeeSky(pos);
    BlockState snowyVariation = SnowyVariationsManager.getSnowyVariationFrom(state);

    if (snowyVariation == null) return;
    if (!isSnowing || level.getBrightness(LightLayer.BLOCK, pos) > 11) return;

    level.setBlock(pos, snowyVariation, Block.UPDATE_ALL);
  }

  @Unique
  private static void MB$turnIntoNormalVariation(BlockState state, Level level, BlockPos pos) {
    if (level.getBrightness(LightLayer.BLOCK, pos) > 11) {
      BlockState normalVariation = SnowyVariationsManager.getNormalVariationFrom(state);

      if(normalVariation == null) return;

      level.setBlock(pos, normalVariation, Block.UPDATE_ALL);
    }
  }
}
