package net.sefacestudios.somemoreblocks.mixin;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import net.sefacestudios.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RotatedPillarBlock.class)
@Implements(@Interface(iface = IBlockExtension.class, prefix = "smb$neo$"))
public abstract class RotatedPillarBlockMixin {

  public @Nullable BlockState smb$neo$getToolModifiedState(BlockState state, UseOnContext ctx, ItemAbility itemAbility, boolean simulate) {
    return SMBRegistries.CARVED_BLOCKS.getNext(state.getBlock())
      .map((block) -> {
        if (block instanceof RotatedCarvedPaleOakBlock) {
          return block.withPropertiesOf(state)
            .setValue(RotatedCarvedPaleOakBlock.MOON_PHASE, RotatedCarvedPaleOakBlock.currentMoonPhase(ctx.getLevel()));
        }
        return block.withPropertiesOf(state);
      }).orElse(null);
  }
}
