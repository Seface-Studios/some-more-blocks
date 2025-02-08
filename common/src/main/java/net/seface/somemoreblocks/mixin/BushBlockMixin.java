package net.seface.somemoreblocks.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.seface.somemoreblocks.registries.SnowyBushRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Optional;

@SuppressWarnings("deprecation")
@Mixin(BushBlock.class)
public abstract class BushBlockMixin extends Block {
  public BushBlockMixin(Properties properties) {
    super(properties);
  }

  @Override
  public boolean isRandomlyTicking(BlockState state) {
    return
      (SnowyBushRegistry.getSnowyVariation(state).isPresent() || SnowyBushRegistry.getNormalVariation(state).isPresent() && !super.isRandomlyTicking(state)) ||
      (SnowyBushRegistry.getSnowyVariation(state).isEmpty() || SnowyBushRegistry.getNormalVariation(state).isEmpty() && super.isRandomlyTicking(state));
  }

  @Override
  public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
    this.SMB$turnIntoNormalVariation(state, level, pos);
    this.SMB$turnIntoSnowVariation(state, level, pos);
  }

  /**
   * Update the BlockState to the snowy variation. The parsed BlockState should be a valid Snowy variation!
   * Use {@link SnowyBushRegistry#register(Block, Block)} to registry new variations.
   *
   * @param state The current BlockState.
   * @param level The affected world.
   * @param pos The current block position.
   */
  @Unique
  private void SMB$turnIntoSnowVariation(BlockState state, Level level, BlockPos pos) {

    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    boolean isSnowing = level.getBiome(pos).value().coldEnoughToSnow(pos, level.getSeaLevel()) && level.isRaining() && level.canSeeSky(pos);
    Optional<BlockState> snowyVariation = SnowyBushRegistry.getSnowyVariation(state);

    if (snowyVariation.isEmpty()) return;
    if (!isSnowing || level.getBrightness(LightLayer.BLOCK, pos) > 11) return;

    // Investigate some possible issues that can occur here.
    if (isDoublePlant) {
      if (state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return;

      level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
      DoublePlantBlock.placeAt(level, snowyVariation.get(), pos, Block.UPDATE_CLIENTS);
      return;
    }

    level.setBlock(pos, snowyVariation.get(), Block.UPDATE_ALL);
  }

  /**
   * Update the BlockState to the normal variation. The parsed BlockState should be a valid Snowy variation!
   * Use {@link SnowyBushRegistry#register(Block, Block)} to registry new variations.
   *
   * @param state The current BlockState.
   * @param level The affected world.
   * @param pos The current block position.
   */
  @Unique
  private void SMB$turnIntoNormalVariation(BlockState state, Level level, BlockPos pos) {
    boolean isDoublePlant = state.hasProperty(DoublePlantBlock.HALF);
    if (level.getBrightness(LightLayer.BLOCK, pos) > 11) {
      Optional<BlockState> normalVariation = SnowyBushRegistry.getNormalVariation(state);

      if (normalVariation.isEmpty()) return;
      if (isDoublePlant) {
        if (state.getValue(DoublePlantBlock.HALF).equals(DoubleBlockHalf.UPPER)) return;

        level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), Block.UPDATE_NONE);
        DoublePlantBlock.placeAt(level, normalVariation.get(), pos, Block.UPDATE_ALL);
        return;
      }

      level.setBlock(pos, normalVariation.get(), Block.UPDATE_ALL);
    }
  }
}
