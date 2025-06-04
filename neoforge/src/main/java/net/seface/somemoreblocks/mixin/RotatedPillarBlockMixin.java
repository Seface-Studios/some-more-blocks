package net.seface.somemoreblocks.mixin;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import net.seface.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RotatedPillarBlock.class)
public abstract class RotatedPillarBlockMixin extends Block implements IBlockExtension {
  public RotatedPillarBlockMixin(Properties properties) {
    super(properties);
  }

  @Override
  public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext ctx, ToolAction action, boolean simulate) {
    return SMBRegistries.CARVED_BLOCKS.getNext(state.getBlock())
      .map((block) -> block.withPropertiesOf(state))
      .orElse(super.getToolModifiedState(state, ctx, action, simulate));
  }
}
