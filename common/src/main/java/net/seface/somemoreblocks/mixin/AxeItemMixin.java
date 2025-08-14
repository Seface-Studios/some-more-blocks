package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AxeItem.class)
public abstract class AxeItemMixin {

  @Unique
  private Level SMB$level = null;

  @Inject(method = "getStripped", at = @At(value = "HEAD"), cancellable = true)
  private void getStrippedMixin(BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir) {
    /*
     * Why we don't run this on NeoForge?
     * Because we need to apply this to getToolModifiedState provided by IBlockExtension class.
     * See more at the mixin of RotatedPillarBlock on NeoForge project.
     */
    if (PlatformServices.HELPER.is(PlatformServices.Platforms.NEOFORGE)) return;

    SMBRegistries.CARVED_BLOCKS.getNext(state.getBlock())
        .ifPresent((block) -> {
          if (block instanceof RotatedCarvedPaleOakBlock) {
            cir.setReturnValue(Optional.of(
              block.withPropertiesOf(state).setValue(RotatedCarvedPaleOakBlock.MOON_PHASE, this.SMB$level.getMoonPhase())
            ));

            return;
          }

          cir.setReturnValue(Optional.of(block.withPropertiesOf(state)));
        });
  }

  @Inject(method = "useOn", at = @At(value = "HEAD"), cancellable = true)
  public void useOnMixin(UseOnContext ctx, CallbackInfoReturnable<InteractionResult> cir) {
    /*
     * Why we don't run this on NeoForge?
     * Because NeoForge has a Built-in data map, so to prevent any incompatibility we need to avoid it.
     */
    if (PlatformServices.HELPER.is(PlatformServices.Platforms.NEOFORGE)) return;

    Level level = ctx.getLevel();
    BlockPos pos = ctx.getClickedPos();
    BlockState state = level.getBlockState(pos);

    if (this.SMB$level == null) {
      this.SMB$level = level;
    }

    Optional<Block> weatheringOff = SMBRegistries.WEATHERING_COPPER_BLOCKS.getPrevious(state.getBlock());
    Optional<Block> waxableOff = SMBRegistries.WAXED_COPPER_BLOCKS.getPrevious(state.getBlock());

    if (weatheringOff.isPresent()) {
      this.SMB$evaluateNewBlockState(ctx, level, weatheringOff.get().withPropertiesOf(state), SoundEvents.AXE_SCRAPE, LevelEvent.PARTICLES_SCRAPE);
      cir.setReturnValue(InteractionResult.SUCCESS);
    }

    if (waxableOff.isPresent()) {
      this.SMB$evaluateNewBlockState(ctx, level, waxableOff.get().withPropertiesOf(state), SoundEvents.AXE_WAX_OFF, LevelEvent.PARTICLES_WAX_OFF);
      cir.setReturnValue(InteractionResult.SUCCESS);
    }
  }

  /**
   * Place and apply all the effects for the new {@link BlockState}.
   *
   * @param ctx The "useOn" event context.
   * @param level The affected world.
   * @param newState The new BlockState.
   * @param soundEvent The sound event to be played.
   * @param levelEvent The level event to be triggered.
   */
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
      ctx.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(ctx.getHand()));
    }
  }
}
