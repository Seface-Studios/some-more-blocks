package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PoweredBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.api.IPoweredBlockMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PoweredBlock.class)
public abstract class PoweredBlockMixin extends Block implements IPoweredBlockMixin {
  @Unique protected int MB$signal = 15;

  public PoweredBlockMixin(BlockBehaviour.Properties properties) {
    super(properties);
  }

  @Unique
  public Block SMB$setSignalLevel(int value) {
    this.MB$signal = value;
    return this;
  }

  @Inject(method = "getSignal", at = @At("RETURN"), cancellable = true)
  public void getSignal(BlockState state, BlockGetter block, BlockPos pos, Direction direction, CallbackInfoReturnable<Integer> cir) {
    cir.setReturnValue(this.MB$signal);
  }
}
