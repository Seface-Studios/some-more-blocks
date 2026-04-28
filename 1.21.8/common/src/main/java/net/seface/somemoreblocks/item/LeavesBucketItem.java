package net.seface.somemoreblocks.item;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.seface.somemoreblocks.Constants;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class LeavesBucketItem extends SolidBucketItem {
  public static final int MAX_VOLUME = 32;
  public static final int MIN_VOLUME = 1;
  private static final int BAR_COLOR = Constants.AMESFACE_COLOR;

  private final BlockState leafLitter;

  public LeavesBucketItem(Block block, SoundEvent placeSound, Properties properties) {
    super(block, placeSound, properties);

    this.leafLitter = block.defaultBlockState();
  }
  @NotNull
  @Override
  public InteractionResult useOn(UseOnContext ctx) {
    Player player = ctx.getPlayer();

    if (player == null) return InteractionResult.FAIL;

    InteractionHand hand = ctx.getHand();
    Level level = ctx.getLevel();
    BlockPos pos = ctx.getClickedPos();
    BlockState state = level.getBlockState(pos);
    ItemStack stack = ctx.getItemInHand();

    int bucketVolume = stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME.get(), 1);

    // Try to collect leaf litter and increase bucket volume
    if (state.getBlock().equals(this.getBlock()) && player.isCrouching()) {
      LeavesBucketItem.collectLeafLitterSegment(player, stack, level, pos);
      LeavesBucketItem.increaseBucketVolume(player, hand, stack);

      return InteractionResult.SUCCESS;
    }

    // Try to place leaf litter and decrease bucket volume
    if (bucketVolume > 0) {
      BlockPlaceContext placeContext = new BlockPlaceContext(ctx);
      BlockPos relativePos = placeContext.getClickedPos();
      BlockState relativeBlock = level.getBlockState(relativePos);

      if (!relativeBlock.canBeReplaced()) {
        return InteractionResult.FAIL;
      }

      if (relativeBlock.is(this.leafLitter.getBlock())) {
        if (relativeBlock.getValue(LeafLitterBlock.AMOUNT) == 4) {
          return InteractionResult.FAIL;
        }

        this.placeLeafLitterSegment(ctx, false);
        LeavesBucketItem.decreaseBucketVolume(player, ctx.getHand(), stack);
        return InteractionResult.SUCCESS;
      }

      if (!this.canPlace(placeContext, this.leafLitter)) {
        return InteractionResult.FAIL;
      }

      if (player instanceof ServerPlayer) {
        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, stack);
      }

      this.placeLeafLitterSegment(ctx, true);

      if (player.isCreative()) {
        return InteractionResult.SUCCESS;
      }

      LeavesBucketItem.decreaseBucketVolume(player, ctx.getHand(), stack);
      return InteractionResult.SUCCESS;
    }

    return InteractionResult.SUCCESS;
  }

  @Override
  public boolean isBarVisible(ItemStack stack) {
    return stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME.get(), 1) < MAX_VOLUME;
  }

  @Override
  public int getBarWidth(ItemStack stack) {
    return Math.min(13 * stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME.get(), 1) / MAX_VOLUME, MAX_VOLUME);
  }

  @Override
  public int getBarColor(ItemStack stack) {
    return BAR_COLOR;
  }

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext ctx, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag tooltipFlag) {
    super.appendHoverText(stack, ctx, display, tooltip, tooltipFlag);

    int bucketVolume = stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME.get(), 1);
    tooltip.accept(
      Component.translatable("item.somemoreblocks.leaves_bucket.volume_description", bucketVolume, MAX_VOLUME)
        .withStyle(ChatFormatting.GRAY));
  }

  /**
   * Increase the held Bucket Volume by the player.
   *
   * @param player The affected player.
   * @param hand The interaction hand.
   * @param stack The affected Leaves Bucket item.
   * @return The interaction result.
   */
  private static void increaseBucketVolume(Player player, InteractionHand hand, ItemStack stack) {
    int currentVolume = stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME.get(), 1);

    if (currentVolume < MAX_VOLUME) {
      stack.set(SMBDataComponentTypes.BUCKET_VOLUME.get(), currentVolume + 1);
    }
  }

  /**
   * Decrease the held Bucket Volume by the player.
   *
   * @param player The affected player.
   * @param hand The interaction hand.
   * @param stack The affected Leaves Bucket item.
   * @return The interaction result.
   */
  private static void decreaseBucketVolume(Player player, InteractionHand hand, ItemStack stack) {
    int currentVolume = stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME.get(), 1);

    if (!player.isCreative()) {
      if (currentVolume > MIN_VOLUME) {
        stack.set(SMBDataComponentTypes.BUCKET_VOLUME.get(), currentVolume - 1);
      } else {
        player.setItemInHand(hand, BucketItem.getEmptySuccessItem(stack, player));
      }
    }
  }

  public static void collectLeafLitterSegment(Player player, ItemStack stack, Level level, BlockPos pos) {
    BlockState state = level.getBlockState(pos);

    int bucketVolume = stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME.get(), 1);
    if (bucketVolume == MAX_VOLUME && !player.isCreative()) return;

    if (state.getValue(LeafLitterBlock.AMOUNT) > 1) {
      level.setBlock(pos, state.setValue(LeafLitterBlock.AMOUNT, state.getValue(LeafLitterBlock.AMOUNT) - 1), 11);
    } else {
      level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
    }

    if (!level.isClientSide()) {
      level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(state));
    }
  }

  public void placeLeafLitterSegment(UseOnContext ctx, boolean firstPlacement) {
    BlockPlaceContext placeContext = new BlockPlaceContext(ctx);

    Player player = ctx.getPlayer();
    Level level = ctx.getLevel();
    BlockPos pos = ctx.getClickedPos();
    BlockState state = level.getBlockState(pos);
    SoundType soundType = state.getSoundType();
    BlockPos relativePos = placeContext.getClickedPos();
    BlockState relativeBlock = level.getBlockState(relativePos);
    Direction direction = ctx.getHorizontalDirection().getOpposite();

    if (firstPlacement) {
      this.placeBlock(placeContext, this.leafLitter.setValue(LeafLitterBlock.FACING, direction));
    } else {
      this.placeBlock(placeContext, relativeBlock.setValue(LeafLitterBlock.AMOUNT, relativeBlock.getValue(LeafLitterBlock.AMOUNT) + 1));
    }

    level.playSound(player, pos, this.getPlaceSound(state), SoundSource.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
    level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, state));
  }
}
