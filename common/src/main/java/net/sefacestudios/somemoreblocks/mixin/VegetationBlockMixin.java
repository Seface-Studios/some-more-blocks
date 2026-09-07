package net.sefacestudios.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.sefacestudios.somemoreblocks.block.SnowyPlantTicks;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VegetationBlock.class)
public abstract class VegetationBlockMixin extends Block {

  public VegetationBlockMixin(Properties properties) {
    super(properties);
  }

  @Override
  protected boolean isRandomlyTicking(BlockState state) {
    return SnowyPlantTicks.isRandomlyTicking(state.getBlock(), state, super.isRandomlyTicking(state));
  }

  @Override
  protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    SnowyPlantTicks.randomTick(state, level, pos);
  }
}
