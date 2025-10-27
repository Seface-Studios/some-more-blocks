package net.seface.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.seface.somemoreblocks.block.properties.QuadDirection;
import org.jetbrains.annotations.Nullable;

public class DuckweedBlock extends WaterlilyBlock {
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

  protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effeectAplier) {
    super.entityInside(state, level, pos, entity, effeectAplier);

    if ((level instanceof ServerLevel) && !(entity instanceof ItemEntity) && !state.getValue(PERSISTENT)) {
      level.destroyBlock(new BlockPos(pos), true, entity);
    }
  }

  @Override
  public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
    return this.defaultBlockState().setValue(PERSISTENT, true);
  }
}
