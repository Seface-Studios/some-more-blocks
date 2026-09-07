package net.sefacestudios.somemoreblocks.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Optional;

@Mixin(WeatheringCopperFullBlock.class)
@Implements(@Interface(iface = WeatheringCopper.class, prefix = "smb$weathering$"))
public abstract class WeatheringCopperFullBlockMixin extends Block {

  public WeatheringCopperFullBlockMixin(Properties properties) {
    super(properties);
  }

  public Optional<BlockState> smb$weathering$getNext(BlockState state) {
    Block block = state.getBlock();
    Optional<Block> nextBlock = SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(block);

    if (nextBlock.isPresent()) {
      return nextBlock.map(_block -> _block.withPropertiesOf(state));
    }

    return Optional.of(WeatheringCopper.getNext(block).get().withPropertiesOf(state));
  }

  @Override
  protected boolean isRandomlyTicking(BlockState state) {
    if (SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(state.getBlock()).isPresent()) {
      return true;
    }

    return super.isRandomlyTicking(state);
  }
}
