package net.seface.somemoreblocks.mixin;

import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(HoneycombItem.class)
public abstract class HoneycombItemMixin {

  @Inject(method = "getWaxed", at = @At(value = "HEAD"), cancellable = true)
  private static void getWaxedMixin(BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {
    /*
     * Why we don't run this on NeoForge?
     * Because NeoForge has a Built-in data map, so to prevent any incompatibility we need to avoid it.
     */
    if (PlatformServices.HELPER.is(PlatformServices.Platforms.NEOFORGE)) return;

    SMBRegistries.WAXED_COPPER_BLOCKS.getNext(state.getBlock())
      .ifPresent((block) -> cir.setReturnValue(Optional.of(block.withPropertiesOf(state))));
  }
}
