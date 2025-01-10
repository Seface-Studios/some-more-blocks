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
  public @NotNull Optional<BlockState> getNext(BlockState state) {
    Optional<BlockState> weathering = WeatheringCopperBlockRegistry.getNext(state);

    if (weathering.isPresent()) {
      return weathering;
    }

    return Optional.of(WeatheringCopper.getNext(state.getBlock()).get().defaultBlockState());
  }

  @Inject(method = "isRandomlyTicking", at = @At(value = "HEAD"), cancellable = true)
  private void isRandomlyTickingMixin(BlockState state, CallbackInfoReturnable<Boolean> cir) {
    WeatheringCopperBlockRegistry.getNext(state)
      .ifPresent(blockState -> cir.setReturnValue(true));
  }
}
