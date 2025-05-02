package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.seface.somemoreblocks.block.TallCactusBlock;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TallCactusBlock.class)
public abstract class TallCactusBlockMixin implements IForgeBlock {

  @Override
  public @Nullable PathType getBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob) {
    return PathType.DAMAGE_OTHER;
  }
}
