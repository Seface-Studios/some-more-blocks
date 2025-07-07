package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class MushroomColonyBlock extends BushBlock implements BonemealableBlock {
  public static final MapCodec<BushBlock> CODEC = simpleCodec(MushroomColonyBlock::new);
  protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);
  protected static final VoxelShape PALE_MUSHROOM_COLONY_SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 6.0, 14.0);

  private final TagKey<Block> tagKey;
  private final Block grownBlock;

  private MushroomColonyBlock(BlockBehaviour.Properties properties) {
    this(SMBBlockTags.MUSHROOM_COLONY_PLACEABLE, properties, SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get());
  }

  public MushroomColonyBlock(BlockBehaviour.Properties properties, Block grownBlock) {
    this(SMBBlockTags.MUSHROOM_COLONY_PLACEABLE, properties, grownBlock);
  }

  public MushroomColonyBlock(TagKey<Block> tagKey, BlockBehaviour.Properties properties, Block grownBlock) {
    super(properties);
    this.tagKey = tagKey;
    this.grownBlock = grownBlock;
  }

  @Override
  public MapCodec<BushBlock> codec() {
    return CODEC;
  }

  @NotNull
  @Override
  public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext context) {
    return state.is(SMBBlocks.PALE_MUSHROOM_COLONY.get()) ? PALE_MUSHROOM_COLONY_SHAPE : SHAPE;
  }

  @Override
  protected boolean mayPlaceOn(BlockState state, BlockGetter block, BlockPos pos) {
    return state.is(this.tagKey);
  }

  @Override
  public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
    return this.grownBlock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above());
  }

  @Override
  public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
    return true;
  }

  @Override
  public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
    DoubleMushroomColonyBlock.placeAt(level, this.grownBlock.defaultBlockState(), pos, 2);
  }
}
