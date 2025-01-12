package net.seface.somemoreblocks.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.seface.somemoreblocks.block.LeafLitterBlock;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LeavesBucketItem extends SolidBucketItem {
  public static final String BUCKET_VOLUME = "bucket_volume";
  public static final int MAX_VOLUME = 16;
  public static final int MIN_VOLUME = 1;
  private static final int BAR_COLOR = Mth.color(0.502F, 0.451F, 1.0F);

  public LeavesBucketItem(Block block, SoundEvent soundEvent, Properties properties) {
    super(block, soundEvent, properties);

    ((LeafLitterBlock) block).setBucketItem(this);
  }

  /**
   * TBD
   * @param stack
   * @return
   */
  public int getBucketVolume(ItemStack stack) {
    return stack.getComponents().getOrDefault(SMBDataComponentTypes.BUCKET_VOLUME, MIN_VOLUME);
  }

  @NotNull
  @Override
  public ItemStack getDefaultInstance() {
    ItemStack stack = new ItemStack(this);
    stack.set(SMBDataComponentTypes.BUCKET_VOLUME, 1);

    return stack;
  }

  /**
   * TBD
   * @return
   */
  public ItemStack getFullInstance() {
    ItemStack stack = new ItemStack(this);
    stack.set(SMBDataComponentTypes.BUCKET_VOLUME, MAX_VOLUME);

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

    // When collect leaves with bucket
    if ((state.getBlock().getDescriptionId().equals(this.getBlock().getDescriptionId()))) {
      if (this.getBucketVolume(stack) == 16 && !player.isCreative()) {
        return super.useOn(ctx);
      }

      level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
      if (!level.isClientSide()) {
        level.levelEvent(2001, pos, Block.getId(state));
      }

      this.increaseBucketVolume(stack);
      return InteractionResult.SUCCESS;
    }

    // When place the leaves from the bucket on the ground.
    if (this.getBucketVolume(stack) > 1 && !player.isCreative()) {
      ItemStack stackCopy = stack.copy();

      InteractionResult interactionResult = super.useOn(ctx);
      if (interactionResult.consumesAction() && player != null && !player.isCreative()) {
        this.decreaseBucketVolume(stackCopy, player);
        player.setItemInHand(ctx.getHand(), stackCopy);
      }

      return interactionResult;
    }

    return super.useOn(ctx);
  }

  @Override
  public boolean isBarVisible(ItemStack stack) {
    return this.getBucketVolume(stack) < 16;
  }

  @Override
  public int getBarWidth(ItemStack stack) {
    return Math.min(13 * this.getBucketVolume(stack) / 16, 16);
  }

  @Override
  public int getBarColor(ItemStack stack) {
    return BAR_COLOR;
  }


  @Override
  public void appendHoverText(ItemStack stack, TooltipContext ctx, List<Component> tooltip, TooltipFlag tooltipFlag) {
    super.appendHoverText(stack, ctx, tooltip, tooltipFlag);
    tooltip.add(1,
      Component.translatable("item.somemoreblocks.leaves_bucket.volume_description", this.getBucketVolume(stack), MAX_VOLUME)
        .withStyle(ChatFormatting.GRAY)
    );
  }

  private void decreaseBucketVolume(ItemStack stack, @Nullable Player player) {
    int currentBucketVolume = this.getBucketVolume(stack);

    stack.set(
      SMBDataComponentTypes.BUCKET_VOLUME,
      this.getBucketVolume(stack) > 1 ? currentBucketVolume - 1 : 0);
  }

  private void increaseBucketVolume(ItemStack stack) {
    int currentBucketVolume = this.getBucketVolume(stack);

    stack.set(
      SMBDataComponentTypes.BUCKET_VOLUME,
      currentBucketVolume < MAX_VOLUME ? currentBucketVolume + 1 : MAX_VOLUME);
  }
}
