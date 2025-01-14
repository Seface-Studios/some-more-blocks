package net.seface.somemoreblocks.item;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.seface.somemoreblocks.Constants;
import net.seface.somemoreblocks.block.LeafLitterBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LeavesBucketItem extends SolidBucketItem {
  public static final String BUCKET_VOLUME = "bucket_volume";
  public static final int MAX_VOLUME = 16;
  public static final int MIN_VOLUME = 1;
  private static final int BAR_COLOR = Constants.AMESFACE_COLOR;

  private final BlockState leafLitterState;

  public LeavesBucketItem(Block block, SoundEvent soundEvent, Properties properties) {
    super(block, soundEvent, properties);

    ((LeafLitterBlock) block).setBucketItem(this);
    this.leafLitterState = block.defaultBlockState();
  }

  /**
   * Update the Bucket Volume value.
   * @param stack The affected Item Stack.
   * @param value The new value.
   */
  public static void setBucketVolume(ItemStack stack, int value) {
    CompoundTag nbt = stack.getOrCreateTag();
    nbt.putInt(BUCKET_VOLUME, value);
  }

  /**
   * Get the current Bucket Volume value.
   * @param stack The affected Item Stack.
   * @return The current Bucket Volume.
   */
  public static int getBucketVolume(ItemStack stack) {
    if (stack.hasTag() && stack.getTag().contains(BUCKET_VOLUME)) {
      return stack.getTag().getInt(BUCKET_VOLUME);
    }

    return MIN_VOLUME;
  }

  @NotNull
  @Override
  public ItemStack getDefaultInstance() {
    ItemStack stack = super.getDefaultInstance();
    LeavesBucketItem.setBucketVolume(stack, 16);

    return stack;
  }

  @NotNull
  @Override
  public InteractionResult useOn(UseOnContext ctx) {
    Player player = ctx.getPlayer();
    Level level = ctx.getLevel();
    BlockPos pos = ctx.getClickedPos();
    BlockState state = level.getBlockState(pos);
    ItemStack stack = ctx.getItemInHand();

    int bucketVolume = LeavesBucketItem.getBucketVolume(stack);

    // Try to collect leaf litter and increase bucket volume
    if (state.getBlock().equals(this.getBlock())) {
      if (bucketVolume == MAX_VOLUME && !player.isCreative()) {
        return InteractionResult.FAIL;
      }
      level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);

      if (!level.isClientSide()) {
        level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(state));
      }

      if (!player.isCreative() || bucketVolume < MAX_VOLUME) {
        LeavesBucketItem.setBucketVolume(stack, bucketVolume + 1);
      }

      return InteractionResult.SUCCESS;
    }

    if (bucketVolume > 0) {
      BlockPlaceContext placeContext = new BlockPlaceContext(ctx);

      if (!this.canPlace(placeContext, this.leafLitterState)) return InteractionResult.FAIL;

      if (player instanceof ServerPlayer) {
        CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, stack);
      }

      this.placeBlock(placeContext, this.leafLitterState);

      SoundType soundType = state.getSoundType();
      level.playSound(player, pos, this.getPlaceSound(state), SoundSource.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
      level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(player, state));

      if (player.isCreative()) {
        return InteractionResult.SUCCESS;
      }

      if (bucketVolume > 1) {
        LeavesBucketItem.setBucketVolume(stack, bucketVolume - 1);
        return InteractionResult.SUCCESS;
      }

      player.setItemInHand(ctx.getHand(), BucketItem.getEmptySuccessItem(stack, player));
      return InteractionResult.SUCCESS;
    }

    return InteractionResult.SUCCESS;
  }

  @Override
  public boolean isBarVisible(ItemStack stack) {
    return LeavesBucketItem.getBucketVolume(stack) < MAX_VOLUME;
  }

  @Override
  public int getBarWidth(ItemStack stack) {
    return Math.min(13 * LeavesBucketItem.getBucketVolume(stack) / 16, 16);
  }

  @Override
  public int getBarColor(ItemStack stack) {
    return BAR_COLOR;
  }

  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
    super.appendHoverText(stack, level, tooltip, tooltipFlag);
    tooltip.add(1,
      Component.translatable("item.somemoreblocks.leaves_bucket.volume_description", LeavesBucketItem.getBucketVolume(stack), MAX_VOLUME)
        .withStyle(ChatFormatting.GRAY)
    );
  }
}
