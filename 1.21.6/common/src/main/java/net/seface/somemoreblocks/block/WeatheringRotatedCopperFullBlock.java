package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class WeatheringRotatedCopperFullBlock extends RotatedPillarBlock implements WeatheringCopper {
  private final WeatheringCopper.WeatherState weatherState;

  public WeatheringRotatedCopperFullBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
    super(properties);
    this.weatherState = weatherState;
  }

  @Override
  public @NotNull Optional<BlockState> getNext(BlockState state) {
    return SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(state.getBlock())
      .map(block -> block.withPropertiesOf(state))
      .or(() -> Optional.of(WeatheringCopper.getNext(state.getBlock()).get().defaultBlockState()));
  }

  @Override
  public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    this.changeOverTime(state, level, pos, random);
  }

  @Override
  public boolean isRandomlyTicking(BlockState state) {
    return SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(state.getBlock()).isPresent();
  }

  @NotNull
  @Override
  public WeatherState getAge() {
    return this.weatherState;
  }
}
