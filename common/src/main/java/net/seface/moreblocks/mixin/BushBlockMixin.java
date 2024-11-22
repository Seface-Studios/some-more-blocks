package net.seface.moreblocks.mixin;

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
import net.seface.moreblocks.api.IBushBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@SuppressWarnings("deprecation")
@Mixin(BushBlock.class)
public class BushBlockMixin extends Block implements IBushBlock {

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

  /*@Override
  public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    if (!isDoublePlant) return super.updateShape(state, direction, state2, level, pos, pos2);

    DoubleBlockHalf half = state.getValue(DoublePlantBlock.HALF);

    if (direction.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (direction == Direction.UP) && (!state2.is(this) || state2.getValue(DoublePlantBlock.HALF) == half)) {
      if (IBushBlock.hasSnowVariation(state2.getBlock()) && half == DoubleBlockHalf.LOWER) {
        return IBushBlock.getSnowVariation(state2.getBlock()).get().withPropertiesOf(state2);
      } else if (IBushBlock.hasNormalVariation(state2.getBlock()) && half == DoubleBlockHalf.LOWER) {
        return IBushBlock.getNormalVariation(state2.getBlock()).get().withPropertiesOf(state2);
      }
    }

    return half == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ?
      Blocks.AIR.defaultBlockState() :
      super.updateShape(state, direction, state2, level, pos, pos2);
  }*/

  @Unique
  private void MB$turnIntoSnowVariation(BlockState state, Level level, BlockPos pos) {
    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    boolean isSnowing = level.getBiome(pos).value().getPrecipitationAt(pos).equals(Biome.Precipitation.SNOW) && level.isRaining() && level.canSeeSky(pos);
    Optional<Block> blockVariation = IBushBlock.getSnowVariation(state.getBlock());

    if (blockVariation.isEmpty()) return;
    if (!isSnowing || level.getBrightness(LightLayer.BLOCK, pos) > 11) return;

    // !
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
