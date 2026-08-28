package net.sefacestudios.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LilyPadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;


public class DuckweedBlock extends LilyPadBlock {
  public static final BooleanProperty PERSISTENT = BlockStateProperties.PERSISTENT;;

  public DuckweedBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
      (this.stateDefinition.any())
        .setValue(PERSISTENT, false));
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
    property.add(PERSISTENT);
  }

  @Override
  protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
    super.entityInside(state, level, pos, entity, effectApplier, true);

    if ((level instanceof ServerLevel) && (entity instanceof LivingEntity) && !state.getValue(PERSISTENT)) {
      level.destroyBlock(new BlockPos(pos), true, entity);
    }
  }

  @Override
  public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState().setValue(PERSISTENT, true);
  }
}
