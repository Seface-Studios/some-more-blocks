package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.seface.somemoreblocks.api.IBushBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@SuppressWarnings("deprecation")
@Mixin(BushBlock.class)
public abstract class BushBlockMixin extends Block implements IBushBlock {

  public BushBlockMixin(Properties properties) {
    super(properties);
  }

  @Inject(method = "<init>", at = @At("RETURN"))
  public void init(Properties properties, CallbackInfo ci) {
    super.properties.randomTicks();
  }

  @Override
  public boolean isRandomlyTicking(BlockState state) {
    return IBushBlock.hasSnowVariation(state.getBlock()) || IBushBlock.hasNormalVariation(state.getBlock());
  }

  @Override
  public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    this.MB$turnIntoNormalVariation(state, level, pos);
    this.MB$turnIntoSnowVariation(state, level, pos);
  }

  @Unique
  private void MB$turnIntoSnowVariation(BlockState state, Level level, BlockPos pos) {
    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    boolean isSnowing = level.getBiome(pos).value().getPrecipitationAt(pos).equals(Biome.Precipitation.SNOW) && level.isRaining() && level.canSeeSky(pos);
    Optional<Block> blockVariation = IBushBlock.getSnowVariation(state.getBlock());

    if (blockVariation.isEmpty()) return;
    if (!isSnowing || level.getBrightness(LightLayer.BLOCK, pos) > 11) return;

    // ??
    if (isDoublePlant) {
      if (state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return;

      level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
      DoublePlantBlock.placeAt(level, blockVariation.get().withPropertiesOf(state), pos, Block.UPDATE_ALL);
      return;
    }

    level.setBlock(pos, blockVariation.get().defaultBlockState(), Block.UPDATE_ALL);
  }

  @Unique
  private void MB$turnIntoNormalVariation(BlockState state, Level level, BlockPos pos) {
    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    if (level.getBrightness(LightLayer.BLOCK, pos) > 11) {
      Optional<Block> blockVariation = IBushBlock.getNormalVariation(state.getBlock());

      if (blockVariation.isEmpty()) return;
      if (isDoublePlant) {
        if (state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return;

        level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
        DoublePlantBlock.placeAt(level, blockVariation.get().withPropertiesOf(state), pos, Block.UPDATE_ALL);
        return;
      }

      level.setBlock(pos, blockVariation.get().defaultBlockState(), Block.UPDATE_ALL);
    }
  }
}
