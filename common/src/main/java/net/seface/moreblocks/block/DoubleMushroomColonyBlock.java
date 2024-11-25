package net.seface.moreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.seface.moreblocks.data.MBBlockTags;
import org.jetbrains.annotations.NotNull;

// TODO: Update placeholder values!
@SuppressWarnings("deprecation")
public class DoubleMushroomColonyBlock extends DoublePlantBlock {
  private final Block test;

  public DoubleMushroomColonyBlock(Block test, BlockBehaviour.Properties properties) {
    super(properties);

    this.test = test;
  }

  @Override
  protected boolean mayPlaceOn(BlockState state, BlockGetter block, BlockPos pos) {
    return state.is(MBBlockTags.TINY_CACTUS_PLACEABLE);
  }

  @NotNull
  @Override
  public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
    ItemStack itemStack = player.getItemInHand(hand);

    if (!itemStack.is(Items.SHEARS)) return super.use(state, level, pos, player, hand, result);

    BlockPos blockPos = state.getValue(HALF).equals(DoubleBlockHalf.UPPER) ? pos.below() : pos;

    int count = RandomSource.create().nextInt(3) + 1;
    Vec3 mushPos = Vec3.atLowerCornerWithOffset(blockPos, 0.5, 0.5, 0.5).offsetRandom(level.random, 0.5F);

    ItemEntity item = new ItemEntity(level, mushPos.x(), mushPos.y(), mushPos.z(), new ItemStack(Items.WARPED_FUNGUS, count));
    item.setDefaultPickUpDelay();

    level.addFreshEntity(item);

    level.removeBlock(pos, true);
    level.setBlock(blockPos, this.test.defaultBlockState(), 3);

    level.playLocalSound(pos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f, true);
    level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
    return InteractionResult.sidedSuccess(level.isClientSide);
  }
}
