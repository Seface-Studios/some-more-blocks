package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class WeatheringRotatedCopperFullBlock extends RotatedPillarBlock implements WeatheringCopper {
  private final WeatheringCopper.WeatherState weatherState;

  public WeatheringRotatedCopperFullBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
    super(properties);
    this.weatherState = weatherState;
  }

  @Override
  public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    this.changeOverTime(state, level, pos, random);
  }

  @Override
  public boolean isRandomlyTicking(BlockState state) {
    return WeatheringCopper.getNext(state.getBlock()).isPresent();
  }

  @NotNull
  @Override
  public WeatherState getAge() {
    return this.weatherState;
  }
}
