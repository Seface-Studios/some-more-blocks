package net.seface.somemoreblocks.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.registries.SMBRegistries;
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
    /*
     * Why we don't run this on NeoForge?
     * Because NeoForge has a Built-in data map, so to prevent any incompatibility we need to avoid it.
     */
    if (PlatformServices.HELPER.is(PlatformServices.Platforms.NEOFORGE)) {
      return Optional.of(WeatheringCopper.getNext(state.getBlock()).get().defaultBlockState());
    }

    return SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(state.getBlock())
      .map(block -> block.withPropertiesOf(state))
      .or(() -> Optional.of(WeatheringCopper.getNext(state.getBlock()).get().defaultBlockState()));

  }

  @Inject(method = "isRandomlyTicking", at = @At(value = "HEAD"), cancellable = true)
  public void isRandomlyTickingMixin(BlockState state, CallbackInfoReturnable<Boolean> cir) {
    /*
     * Why we don't run this on NeoForge?
     * Because NeoForge has a Built-in data map, so to prevent any incompatibility we need to avoid it.
     */
    if (PlatformServices.HELPER.is(PlatformServices.Platforms.NEOFORGE)) {
      return;
    }

    SMBRegistries.WEATHERING_COPPER_BLOCKS.getNext(state.getBlock())
      .ifPresent((block) -> cir.setReturnValue(true));
  }
}
