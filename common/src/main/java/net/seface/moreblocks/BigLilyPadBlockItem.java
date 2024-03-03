package net.seface.moreblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.seface.moreblocks.block.BigLilyPadBlock;
import net.seface.moreblocks.utils.BigLilyPadDirectionOffset;

public class BigLilyPadBlockItem extends PlaceOnWaterBlockItem {
    public BigLilyPadBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    public InteractionResult useOn(UseOnContext ctx) {
        return InteractionResult.PASS;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack handItem = player.getItemInHand(hand);
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (hitResult.getType() != HitResult.Type.BLOCK) return InteractionResultHolder.pass(handItem);

        BlockPos pos = hitResult.getBlockPos();
        BigLilyPadDirectionOffset offset = BigLilyPadDirectionOffset.getByDirection(player.getDirection());

        BigLilyPadBlock lilyPad = (BigLilyPadBlock) this.getBlock();

        if (lilyPad.isValidPlace(level, pos, player.getDirection())) {
            lilyPad.place(level, pos.above(), this.getBlock().defaultBlockState(), player.getDirection());
            return InteractionResultHolder.consume(handItem);
        }

        return InteractionResultHolder.fail(handItem);
    }
}
