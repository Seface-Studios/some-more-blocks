package net.seface.moreblocks.item;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.moreblocks.MoreBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LeavesBucketItem extends SolidBucketItem {
  public static final String BUCKET_VOLUME = "bucket_volume";
  public static final int MAX_VOLUME = 16;
  public static final int DEFAULT_VOLUME = 1;
  private static final int BAR_COLOR = Mth.color(0.502F, 0.451F, 1.0F);

  public LeavesBucketItem(Block block, SoundEvent soundEvent, Properties properties) {
    super(block, soundEvent, properties);

    this.setCustomData(this.getDefaultInstance(), DEFAULT_VOLUME + 2);
  }

  public void setCustomData(ItemStack stack, int data) {
    CompoundTag nbt = stack.getOrCreateTag();
    nbt.putInt(BUCKET_VOLUME, data);
  }

  public static void registerModelPredicateProviderFor(Item item) {
    FabricModelPredicateProviderRegistry.register(
      item, new ResourceLocation(MoreBlocks.ID, BUCKET_VOLUME), (stack, world, entity, seed) -> {
        if (stack.hasTag() && stack.getTag().contains(BUCKET_VOLUME)) {
          return (stack.getTag().getInt(BUCKET_VOLUME) / 100.0f);
        }

        return 0.0F;
      }
    );
  }

  public int getCustomData(ItemStack itemStack) {
    if (itemStack.hasTag() && itemStack.getTag().contains(BUCKET_VOLUME)) {
      return itemStack.getTag().getInt(BUCKET_VOLUME);
    }

    return DEFAULT_VOLUME;
  }

  @Override
  public ItemStack getDefaultInstance() {
    ItemStack stack = new ItemStack(this);
    ((LeavesBucketItem) stack.getItem()).setCustomData(stack, 1);

    return stack;
  }

  public ItemStack getCreativeInventoryInstance() {
    ItemStack stack = new ItemStack(this);
    ((LeavesBucketItem) stack.getItem()).setCustomData(stack, 16);

    return stack;
  }

  @Override
  public InteractionResult useOn(UseOnContext ctx) {
    Player player = ctx.getPlayer();
    Level level = ctx.getLevel();
    BlockPos pos = ctx.getClickedPos();
    BlockState state = level.getBlockState(pos);
    ItemStack stack = ctx.getItemInHand();

    if ((state.getBlock().getDescriptionId().equals(this.getBlock().getDescriptionId()))) {
      if (this.getCustomData(stack) == 16 && !player.isCreative()) {
        return super.useOn(ctx);
      }

      level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
      if (!level.isClientSide()) {
        level.levelEvent(2001, pos, Block.getId(state));
      }

      this.increaseBucketVolume(stack, player);
      return InteractionResult.SUCCESS;
    }

    if (this.getCustomData(stack) > 1 && !player.isCreative()) {
      ItemStack copy = stack.copy();

      InteractionResult interactionResult = super.useOn(ctx);
      if (interactionResult.consumesAction() && player != null && !player.isCreative()) {
        InteractionHand interactionHand = ctx.getHand();

        this.decreaseBucketVolume(copy, player);
        player.setItemInHand(interactionHand, copy);
      }

      return interactionResult;
    }

    return super.useOn(ctx);
  }

  @Override
  public boolean isBarVisible(ItemStack stack) {
    return this.getCustomData(stack) < 16;
  }

  @Override
  public int getBarWidth(ItemStack stack) {
    return Math.min(13 * this.getCustomData(stack) / 16, 16);
  }

  @Override
  public int getBarColor(ItemStack stack) { return BAR_COLOR; }

  @Override
  public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
    if (stack.hasTag()) {
      super.appendHoverText(stack, level, tooltip, tooltipFlag);

      tooltip.add(1,
        Component.translatable("item.moreblocks.leaves_bucket.volume_description", this.getCustomData(stack), MAX_VOLUME)
          .withStyle(ChatFormatting.GRAY)
      );
    }
  }

  private void decreaseBucketVolume(ItemStack stack, @Nullable Player player) {
    LeavesBucketItem item = (LeavesBucketItem) stack.getItem();
    int currentBucketVolume = item.getCustomData(stack);

    /*if (player != null) {
      stack.setDamageValue(stack.getDamageValue() + 1);
      //stack.hurt(1, player.getRandom(), (ServerPlayer) player);
    }*/

    item.setCustomData(stack, currentBucketVolume > 1 ? currentBucketVolume - 1 : 0);
  }

  private void increaseBucketVolume(ItemStack stack, @Nullable Player player) {
    LeavesBucketItem item = (LeavesBucketItem) stack.getItem();
    int currentBucketVolume = item.getCustomData(stack);

    /*if (player != null) {
      stack.setDamageValue(stack.getDamageValue() - 1);
    }*/

    item.setCustomData(stack, currentBucketVolume < MAX_VOLUME ? currentBucketVolume + 1 : MAX_VOLUME);
  }
}
