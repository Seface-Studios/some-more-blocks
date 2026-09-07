package net.sefacestudios.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeafLitterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sefacestudios.somemoreblocks.registries.SMBGameRules;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LeafLitterBlock.class)
public abstract class LeafLitterBlockMixin extends Block {

  public LeafLitterBlockMixin(Properties properties) {
    super(properties);
  }

  @Override
  protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean bool) {
    if (state.getBlock() == Blocks.LEAF_LITTER) {
      return Items.LEAF_LITTER.getDefaultInstance();
    }

    return super.getCloneItemStack(level, pos, state, bool);
  }

  @Override
  protected boolean isRandomlyTicking(BlockState state) {
    return state.getBlock() != Blocks.LEAF_LITTER;
  }

  @Override
  protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    if (!level.getGameRules().get(SMBGameRules.RULE_DRY_LEAF_LITTER.get())) {
      return;
    }

    if (random.nextInt(25) == 0) {
      level.setBlock(pos, Blocks.LEAF_LITTER.withPropertiesOf(state), Block.UPDATE_ALL);
    }
  }
}
