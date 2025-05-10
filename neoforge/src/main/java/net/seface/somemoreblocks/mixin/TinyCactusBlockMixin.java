package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import net.seface.somemoreblocks.block.TinyCactusBlock;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TinyCactusBlock.class)
public abstract class TinyCactusBlockMixin implements IBlockExtension {

  @Override
  public @Nullable PathType getBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob) {
    return PathType.DAMAGE_OTHER;
  }
}
