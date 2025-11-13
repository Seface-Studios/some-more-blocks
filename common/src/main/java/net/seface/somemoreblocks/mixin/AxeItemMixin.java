package net.seface.somemoreblocks.mixin;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
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

  @Inject(method = "useOn", at = @At(value = "HEAD"), cancellable = true)
  public void useOnMixin(UseOnContext ctx, CallbackInfoReturnable<InteractionResult> cir) {
    Level level = ctx.getLevel();
    Player player = ctx.getPlayer();
    ItemStack heldItem = ctx.getItemInHand();
    BlockPos clickedPos = ctx.getClickedPos();
    BlockState state = level.getBlockState(clickedPos);

    if (this.SMB$level == null) {
      this.SMB$level = level;
    }

    Block block = state.getBlock();
    Optional<Block> carvedWoodOrLog = SMBRegistries.CARVED_BLOCKS.getNext(block);
    Optional<Block> weatheringOff = SMBRegistries.WEATHERING_COPPER_BLOCKS.getPrevious(block);
    Optional<Block> waxableOff = SMBRegistries.WAXED_COPPER_BLOCKS.getPrevious(block);
    Optional<BlockState> result = Optional.empty();
    Optional<SoundEvent> soundEvent = Optional.empty();

    if (carvedWoodOrLog.isPresent()) {
      result = Optional.of(carvedWoodOrLog.get().withPropertiesOf(state));
      soundEvent = Optional.of(SoundEvents.AXE_STRIP);
    } else if (weatheringOff.isPresent()) {
      result = Optional.of(weatheringOff.get().withPropertiesOf(state));
      soundEvent = Optional.of(SoundEvents.AXE_SCRAPE);
      level.levelEvent(player, LevelEvent.PARTICLES_SCRAPE, clickedPos, 0);
    } else if (waxableOff.isPresent()) {
      result = Optional.of(waxableOff.get().withPropertiesOf(state));
      soundEvent = Optional.of(SoundEvents.AXE_WAX_OFF);
      level.levelEvent(player, LevelEvent.PARTICLES_WAX_OFF, clickedPos, 0);
    }

    if (result.isPresent()) {
      if (player instanceof ServerPlayer) {
        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, clickedPos, heldItem);
      }

      level.setBlock(clickedPos, result.get(), 11);
      level.gameEvent(GameEvent.BLOCK_CHANGE, clickedPos, GameEvent.Context.of(player, result.get()));
      level.playSound(player, clickedPos, soundEvent.get(), SoundSource.BLOCKS, 1.0F, 1.0F);

      if (player != null) {
        heldItem.hurtAndBreak(1, player, ctx.getHand().asEquipmentSlot());
      }

      cir.setReturnValue(InteractionResult.SUCCESS);
    }
  }
}
