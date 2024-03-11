package net.seface.moreblocks.item;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.seface.moreblocks.block.featured.FeaturedBlock;
import net.seface.moreblocks.core.LinkCrackedBlocks;
import net.seface.moreblocks.block.MBBlockTags;

public class CrackingToolItem extends Item {
    private final Minecraft minecraft = Minecraft.getInstance();

    public CrackingToolItem(Properties properties) {
        super(properties);
    }

    public InteractionResult useOn(UseOnContext ctx) {
        Level level = ctx.getLevel();
        Player player = ctx.getPlayer();
        InteractionHand hand = ctx.getHand();

        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
        BlockPos hitPos = hitResult.getBlockPos();
        BlockState clickedBlock = level.getBlockState(hitPos);

        if (!clickedBlock.is(MBBlockTags.CRACKLABLE)) return super.useOn(ctx);

        if (!level.isClientSide) {
            if (player != null) {
                ItemStack handItem = player.getItemInHand(hand);
                handItem.hurtAndBreak(1, player, (p -> p.broadcastBreakEvent(hand)));
            }

            BlockState crackedVersion = LinkCrackedBlocks.getCrackedFrom(clickedBlock.getBlock()).defaultBlockState();

            level.setBlock(hitPos, crackedVersion, 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, hitPos, GameEvent.Context.of(player, crackedVersion));
        }

        BlockParticleOption p = new BlockParticleOption(ParticleTypes.BLOCK, clickedBlock);

        level.playSound(player, hitPos, clickedBlock.getSoundType().getBreakSound(), SoundSource.BLOCKS, 1.0F, 0.75F);
        level.playSound(player, hitPos, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.2F);
        this.minecraft.particleEngine.destroy(hitPos, clickedBlock);

        int $$7 = level.getRandom().nextInt(7, 12);
        for(int $$12 = 0; $$12 < $$7; ++$$12) {
            level.addParticle(p, hitPos.getX() + 0.5, hitPos.getY() + 1, hitPos.getZ() + 0.5, 0, 0, 0);
        }


        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
