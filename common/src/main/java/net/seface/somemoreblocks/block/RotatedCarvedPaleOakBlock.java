package net.seface.somemoreblocks.block;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import org.jetbrains.annotations.NotNull;

public class RotatedCarvedPaleOakBlock extends RotatedPillarBlock {
  public static final IntegerProperty MOON_PHASE = IntegerProperty.create("moon_phase", 0, 7);

  public RotatedCarvedPaleOakBlock(Properties properties) {
    super(properties);

    this.registerDefaultState(
        (this.stateDefinition.any())
          .setValue(AXIS, Direction.Axis.Y)
          .setValue(MOON_PHASE, 0)
      );
  }

  @Override
  protected void onPlace(BlockState $$0, Level level, BlockPos $$2, BlockState $$3, boolean $$4) {
    this.registerDefaultState(
      (this.stateDefinition.any())
        .setValue(AXIS, Direction.Axis.Y)
        .setValue(MOON_PHASE, level.getMoonPhase())
    );
  }

  @Override
  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> property) {
    property.add(AXIS, MOON_PHASE);
  }

  @NotNull
  @Override
  protected ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean b) {
    ItemStack stack = super.getCloneItemStack(level, pos, state, b);
    stack.set(((CarvedPaleOakBlockItem) stack.getItem()).getMoonPhaseComponentType(), state.getValue(MOON_PHASE));

    return stack;
  }
}
