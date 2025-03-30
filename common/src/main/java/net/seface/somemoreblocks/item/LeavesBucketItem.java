package net.seface.somemoreblocks.item;

import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
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
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LeavesBucketItem extends SolidBucketItem {
  public static final int MAX_VOLUME = 16;
  public static final int MIN_VOLUME = 1;
  private static final int BAR_COLOR = Constants.AMESFACE_COLOR;

  private final BlockState leafLitterState;

  public LeavesBucketItem(Block block, SoundEvent placeSound, Properties properties) {
    super(block, placeSound, properties);

    ((LeafLitterBlock) block).setBucketItem(this);
    this.leafLitterState = block.defaultBlockState();
  }
  @NotNull
  @Override
  public InteractionResult useOn(UseOnContext ctx) {
    Player player = ctx.getPlayer();
    Level level = ctx.getLevel();
    BlockPos pos = ctx.getClickedPos();
    BlockState state = level.getBlockState(pos);
    ItemStack stack = ctx.getItemInHand();

    int bucketVolume = stack.getComponents().getOrDefault(this.getBucketVolumeComponentType(), 1);

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
        stack.set(this.getBucketVolumeComponentType(), bucketVolume + 1);
      }

      return InteractionResult.SUCCESS;
    }

    // Try to place leaf litter and decrease bucket volume
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
        stack.set(this.getBucketVolumeComponentType(), bucketVolume - 1);
        return InteractionResult.SUCCESS;
      }

      player.setItemInHand(ctx.getHand(), BucketItem.getEmptySuccessItem(stack, player));
      return InteractionResult.SUCCESS;
    }

    return InteractionResult.SUCCESS;
  }

  @Override
  public boolean isBarVisible(ItemStack stack) {
    return stack.getComponents().getOrDefault(this.getBucketVolumeComponentType(), 1) < MAX_VOLUME;
  }

  @Override
  public int getBarWidth(ItemStack stack) {
    return Math.min(13 * stack.getComponents().getOrDefault(this.getBucketVolumeComponentType(), 1) / 16, 16);
  }

  @Override
  public int getBarColor(ItemStack stack) {
    return BAR_COLOR;
  }

  @Override
  public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag tooltipFlag) {
    super.appendHoverText(stack, ctx, tooltip, tooltipFlag);

    int bucketVolume = stack.getComponents().getOrDefault(this.getBucketVolumeComponentType(), 1);
    tooltip.add(1,
      Component.translatable("item.somemoreblocks.leaves_bucket.volume_description", bucketVolume, MAX_VOLUME)
        .withStyle(ChatFormatting.GRAY)
    );
  }

  public DataComponentType<Integer> getBucketVolumeComponentType() {
    return SMBDataComponentTypes.BUCKET_VOLUME.get();
  }
}
