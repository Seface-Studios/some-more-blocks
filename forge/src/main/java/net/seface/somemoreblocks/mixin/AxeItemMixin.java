package net.seface.somemoreblocks.mixin;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.utils.CarvedBlockRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Optional;

/*
  Why not use "getToolModifiedState" method in a new class?

  Since we are not adding new log type, but using the existent stripped logs/woods, we need to mixin on forge edition.
  Thanks Fabric for making this easily by adding just a method.
*/
@Mixin(AxeItem.class)
public abstract class AxeItemMixin {

  @Final
  @Shadow
  protected static Map<Block, Block> STRIPPABLES;

  @Shadow
  protected abstract Optional<BlockState> getStripped(BlockState blockState);

  @Inject(method = "getStripped", at = @At(value = "HEAD"), cancellable = true)
  private void getStrippedMixin(BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {
    Block carvedVariation = CarvedBlockRegistry.getCarvedBlocks().get(state.getBlock());

    // Used to avoid the override of default getStripped return
    if (carvedVariation != null) {
      cir.setReturnValue(
        Optional.of(carvedVariation).map(
          (block -> block.defaultBlockState().setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS))))
      );
    }
  }
}
