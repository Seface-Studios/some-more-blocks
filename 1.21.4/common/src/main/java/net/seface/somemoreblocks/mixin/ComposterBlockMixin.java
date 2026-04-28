package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.WorldlyContainerHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ComposterBlock.class)
public abstract class ComposterBlockMixin extends Block implements WorldlyContainerHolder {
  public ComposterBlockMixin(Properties properties) {
    super(properties);
  }

  @Inject(method = "useItemOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;awardStat(Lnet/minecraft/stats/Stat;)V"), cancellable = true)
  private void useMixin(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {

    if (stack.getItem() instanceof LeavesBucketItem) {
      int levelState = state.getValue(ComposterBlock.LEVEL);
      int bucketVolume = stack.get(((LeavesBucketItem) stack.getItem()).getBucketVolumeComponentType());
      int missingLevels = ComposterBlock.MAX_LEVEL - levelState;

      bucketVolume -= Math.min(missingLevels, bucketVolume);

      if (!player.getAbilities().instabuild) {
        if (bucketVolume == 0) {
          player.setItemInHand(hand, Items.BUCKET.getDefaultInstance());
        } else {
          stack.set(((LeavesBucketItem) stack.getItem()).getBucketVolumeComponentType(), bucketVolume);
        }
      }

      cir.setReturnValue(new InteractionResult.Success(InteractionResult.SwingSource.CLIENT, new InteractionResult.ItemContext(false, stack)));
    }
  }

  @Inject(method = "addItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;setValue(Lnet/minecraft/world/level/block/state/properties/Property;Ljava/lang/Comparable;)Ljava/lang/Object;"), cancellable = true)
  private static void addItemMixin(Entity entity, BlockState state, LevelAccessor level, BlockPos pos, ItemStack stack, CallbackInfoReturnable<BlockState> cir) {
    if (stack.getItem() instanceof LeavesBucketItem) {
      int levelState = state.getValue(ComposterBlock.LEVEL);
      int bucketVolume = stack.get(((LeavesBucketItem) stack.getItem()).getBucketVolumeComponentType());
      int missingLevels = ComposterBlock.MAX_LEVEL - levelState;

      levelState += Math.min(missingLevels, bucketVolume);

      BlockState state2 = state.setValue(ComposterBlock.LEVEL, levelState);

      level.setBlock(pos, state2, 3);
      level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(entity, state2));
      cir.setReturnValue(state);
    }
  }
}
