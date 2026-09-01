package net.sefacestudios.somemoreblocks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class TinyCactusBlock extends TallGrassBlock {
  private static final VoxelShape SHAPE = Block.column(6.0F, 0.0F, 10.0F);

  public TinyCactusBlock(Properties properties) {
    super(properties);
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    BlockState blockBelow = level.getBlockState(pos.below());
    return blockBelow.is(SMBBlockTags.CACTUS_PLANTS_PLACEABLE) && !level.getBlockState(pos.above()).liquid();
  }

  @Override
  public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean b) {
    if (!(entity instanceof LivingEntity)) return;
    entity.hurt(level.damageSources().cactus(), 1.0F);
  }

  @Override
  public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
    return SMBBlocks.TALL_CACTUS.get().defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above());
  }

  @Override
  public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
    DoubleMushroomColonyBlock.placeAt(level, SMBBlocks.TALL_CACTUS.get().defaultBlockState(), pos, 2);
  }

  @NotNull
  @Override
  protected VoxelShape getShape(final BlockState state, final BlockGetter level, final BlockPos pos, final CollisionContext context) {
    return SHAPE.move(state.getOffset(pos));
  }
}
