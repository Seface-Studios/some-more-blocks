package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@SuppressWarnings("deprecation")
public class WeatheringRotatedCopperFullBlock extends RotatedPillarBlock implements WeatheringCopper {
  private final WeatheringCopper.WeatherState weatherState;

  public WeatheringRotatedCopperFullBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
    super(properties);
    this.weatherState = weatherState;
  }

  @Override
  public @NotNull Optional<BlockState> getNext(BlockState state) {
    Optional<Block> weathering = SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(state.getBlock());

    if (weathering.isPresent()) {
      return Optional.of(weathering.get().withPropertiesOf(state));
    }

    return Optional.of(WeatheringCopper.getNext(state.getBlock()).get().withPropertiesOf(state));
  }

  @Override
  public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    this.changeOverTime(state, level, pos, random);
  }

  @Override
  public boolean isRandomlyTicking(BlockState state) {
    Block block = state.getBlock();
    return SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(block).isPresent() || WeatheringCopper.getNext(block).isPresent();
  }

  @NotNull
  @Override
  public WeatherState getAge() {
    return this.weatherState;
  }
}
