package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.seface.somemoreblocks.registries.CarvedBlockRegistry;
import net.seface.somemoreblocks.registries.WaxableCopperBlockRegistry;
import net.seface.somemoreblocks.registries.WeatheringCopperBlockRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/*
  Why not use "getToolModifiedState" method in a new block class?

  Since we are not adding new log type, but using the existent stripped logs/woods, we need to mixin on forge edition.
  Thanks Fabric for making this easily by adding just a method.
*/
@Mixin(AxeItem.class)
public abstract class AxeItemMixin {

  @Inject(method = "getStripped", at = @At(value = "HEAD"), cancellable = true)
  private void getStrippedMixin(BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {
    Block carvedVariation = CarvedBlockRegistry.getCarvedBlocks().get(state.getBlock());

    // Used to avoid the override of default getStripped return.
    if (carvedVariation != null) {
      cir.setReturnValue(
        Optional.of(carvedVariation).map(
          (block -> block.withPropertiesOf(state)))
      );
    }
  }

  @Inject(method = "useOn", at = @At(value = "HEAD"), cancellable = true)
  public void useOnMixin(UseOnContext ctx, CallbackInfoReturnable<InteractionResult> cir) {
    Level level = ctx.getLevel();
    BlockPos pos = ctx.getClickedPos();
    BlockState state = level.getBlockState(pos);
    Block block = state.getBlock();

    if (WeatheringCopperBlockRegistry.isPresentPrevious(block)) {
      BlockState scrapedBlock = WeatheringCopperBlockRegistry.getPreviousBlockMap().get(block).withPropertiesOf(state);
      this.SMB$evaluateNewBlockState(ctx, level, scrapedBlock, SoundEvents.AXE_SCRAPE, LevelEvent.PARTICLES_SCRAPE);

      cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
    }

    if (WaxableCopperBlockRegistry.isPresentPrevious(block)) {
      BlockState nonWaxedBlock = WaxableCopperBlockRegistry.getInvertedWaxables().get(block).withPropertiesOf(state);
      this.SMB$evaluateNewBlockState(ctx, level, nonWaxedBlock, SoundEvents.AXE_WAX_OFF, LevelEvent.PARTICLES_WAX_OFF);

      cir.setReturnValue(InteractionResult.sidedSuccess(level.isClientSide));
    }
  }

  @Unique
  private void SMB$evaluateNewBlockState(UseOnContext ctx, Level level, BlockState newState,
                                         SoundEvent soundEvent, int levelEvent) {
    Player player = ctx.getPlayer();
    BlockPos pos = ctx.getClickedPos();

    level.setBlock(pos, newState, 11);
    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));
    level.playSound(player, pos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
    level.levelEvent(player, levelEvent, pos, 0);

    if (player != null) {
      ctx.getItemInHand().hurtAndBreak(1, player, (_player) -> _player.broadcastBreakEvent(ctx.getHand()));
    }
  }
}
