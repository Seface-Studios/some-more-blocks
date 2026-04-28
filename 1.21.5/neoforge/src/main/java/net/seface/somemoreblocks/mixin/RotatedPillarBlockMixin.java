package net.seface.somemoreblocks.mixin;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RotatedPillarBlock.class)
public abstract class RotatedPillarBlockMixin extends Block implements IBlockExtension {
  public RotatedPillarBlockMixin(Properties properties) {
    super(properties);
  }

  @Override
  public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext ctx, ItemAbility itemAbility, boolean simulate) {
    return SMBRegistries.CARVED_BLOCKS.getNext(state.getBlock())
      .map((block) -> {
        if (block instanceof RotatedCarvedPaleOakBlock) {
          return block.withPropertiesOf(state)
            .setValue(RotatedCarvedPaleOakBlock.MOON_PHASE, ctx.getLevel().getMoonPhase());
        }
        return block.withPropertiesOf(state);
      }).orElse(super.getToolModifiedState(state, ctx, itemAbility, simulate));
  }
}
