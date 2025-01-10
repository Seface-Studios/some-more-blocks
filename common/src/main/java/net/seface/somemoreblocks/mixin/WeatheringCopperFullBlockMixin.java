package net.seface.somemoreblocks.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.registries.WeatheringCopperBlockRegistry;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(WeatheringCopperFullBlock.class)
public abstract class WeatheringCopperFullBlockMixin extends Block implements WeatheringCopper {
  public WeatheringCopperFullBlockMixin(Properties properties) {
    super(properties);
  }

  @Override
  public @NotNull Optional<BlockState> getNext(BlockState inputBlock) {
    if (WeatheringCopperBlockRegistry.isPresentNext(inputBlock.getBlock())) {
      return Optional.of(
        WeatheringCopperBlockRegistry.getNextBlockMap().get(inputBlock.getBlock()).defaultBlockState());
    }

    return Optional.of(WeatheringCopper.getNext(inputBlock.getBlock()).get().defaultBlockState());
  }

  @Inject(method = "isRandomlyTicking", at = @At(value = "HEAD"), cancellable = true)
  private void isRandomlyTickingMixin(BlockState state, CallbackInfoReturnable<Boolean> cir) {
    if (WeatheringCopperBlockRegistry.isPresentNext(state.getBlock())) {
      cir.setReturnValue(true);
    }
  }
}
