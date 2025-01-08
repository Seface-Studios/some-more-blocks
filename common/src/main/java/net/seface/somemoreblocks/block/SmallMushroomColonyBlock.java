package net.seface.somemoreblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.seface.somemoreblocks.data.MBBlockTags;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class SmallMushroomColonyBlock extends BushBlock {
  public static final MapCodec<SmallMushroomColonyBlock> CODEC = simpleCodec(SmallMushroomColonyBlock::new);
  protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

  private final TagKey<Block> tagKey;

  public SmallMushroomColonyBlock(BlockBehaviour.Properties properties) {
    this(MBBlockTags.TINY_CACTUS_PLACEABLE, properties);
  }

  public SmallMushroomColonyBlock(TagKey<Block> tagKey, BlockBehaviour.Properties properties) {
    super(properties);
    this.tagKey = tagKey;
  }

  @NotNull
  @Override
  public MapCodec<SmallMushroomColonyBlock> codec() {
    return CODEC;
  }

  @NotNull
  @Override
  public VoxelShape getShape(BlockState state, BlockGetter block, BlockPos pos, CollisionContext context) {
    return SHAPE;
  }

  @Override
  protected boolean mayPlaceOn(BlockState state, BlockGetter block, BlockPos pos) {
    return state.is(this.tagKey);
  }
}
