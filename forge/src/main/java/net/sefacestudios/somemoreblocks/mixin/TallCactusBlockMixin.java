package net.sefacestudios.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.sefacestudios.somemoreblocks.block.TallCactusBlock;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TallCactusBlock.class)
@Implements(@Interface(iface = IForgeBlock.class, prefix = "smb$forge$"))
public abstract class TallCactusBlockMixin {

  public @Nullable PathType smb$forge$getBlockPathType(BlockState state, BlockGetter level, BlockPos pos, @Nullable Mob mob) {
    return PathType.DAMAGING;
  }
}
