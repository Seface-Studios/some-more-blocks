package net.seface.moreblocks.mixin;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.seface.moreblocks.SnowyVariationsManager;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DoublePlantBlock.class)
public class DoublePlantBlockMixin extends BushBlock {
  @Shadow @Final public static MapCodec<DoublePlantBlock> CODEC;

  protected DoublePlantBlockMixin(Properties properties) {
    super(properties);
  }

  @Inject(method = "<init>", at = @At("RETURN"))
  public void init(Properties properties, CallbackInfo ci) {
    super.properties.randomTicks();
  }

  @Shadow public @NotNull MapCodec<DoublePlantBlock> codec() { return CODEC; }

  @Override
  public boolean isRandomlyTicking(BlockState state) { return true; }

  @SuppressWarnings("deprecation")
  @Override
  public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    MB$turnIntoSnowVariation(state, level, pos);
    MB$turnIntoNormalVariation(state, level, pos);
  }

  @Override
  public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
    DoubleBlockHalf half = state.getValue(DoublePlantBlock.HALF);
    if (direction.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (direction == Direction.UP) && (!state2.is(this) || state2.getValue(DoublePlantBlock.HALF) == half)) {
      BlockState updatedShape = SnowyVariationsManager.hasAnyVariation(state2) ?
        SnowyVariationsManager.hasSnowVariation(state2) ?
          SnowyVariationsManager.getSnowyVariationFrom(state2) :
          SnowyVariationsManager.getNormalVariationFrom(state2)
        : Blocks.AIR.defaultBlockState();

      return updatedShape;
    }

    return half == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ?
      Blocks.AIR.defaultBlockState() :
      super.updateShape(state, direction, state2, level, pos, pos2);
  }

  @Unique
  private static void MB$turnIntoSnowVariation(BlockState state, Level level, BlockPos pos) {
    boolean isSnowing = level.getBiome(pos).value().getPrecipitationAt(pos).equals(Biome.Precipitation.SNOW) && level.isRaining() && level.canSeeSky(pos);
    BlockState snowyVariation = SnowyVariationsManager.getSnowyVariationFrom(state);

    if (snowyVariation == null) return;
    if (!isSnowing || level.getBrightness(LightLayer.BLOCK, pos) > 11) return;

    DoublePlantBlock.placeAt(level, snowyVariation, pos, Block.UPDATE_ALL);
  }

  @Unique
  private static void MB$turnIntoNormalVariation(BlockState state, Level level, BlockPos pos) {
    if (level.getBrightness(LightLayer.BLOCK, pos) > 11) {
      BlockState normalVariation = SnowyVariationsManager.getNormalVariationFrom(state);

      if(normalVariation == null) return;

      DoublePlantBlock.placeAt(level, normalVariation, pos, Block.UPDATE_ALL);
    }
  }
}
