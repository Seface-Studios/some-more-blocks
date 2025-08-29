package net.seface.somemoreblocks.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(WeatheringCopperFullBlock.class)
public abstract class WeatheringCopperFullBlockMixin implements WeatheringCopper {

  @Override
  public Optional<BlockState> getNext(BlockState state) {
    /*
     * Prevent to run in Fabric Mod Loader.
     */
    if (PlatformServices.HELPER.is(PlatformServices.Platforms.FABRIC)) {
      return WeatheringCopper.super.getNext(state);
    }

    Block block = state.getBlock();
    Optional<Block> nextBlock = SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(block);

    if (nextBlock.isPresent()) {
      return nextBlock.map(_block -> _block.withPropertiesOf(state));
    }

    return Optional.of(WeatheringCopper.getNext(block).get().withPropertiesOf(state));
  }

  @Inject(method = "isRandomlyTicking", at = @At("HEAD"), cancellable = true)
  public void isRandomlyTickingMixin(BlockState state, CallbackInfoReturnable<Boolean> cir) {
    /*
     * Prevent to run in Fabric Mod Loader.
     */
    if (PlatformServices.HELPER.is(PlatformServices.Platforms.FABRIC)) {
      cir.setReturnValue(cir.getReturnValue());
      return;
    }

    Optional<Block> nextBlock = SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(state.getBlock());

    if (nextBlock.isPresent()) {
      cir.setReturnValue(true);
    }
  }
}
