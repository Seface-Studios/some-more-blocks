package net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.sefacestudios.somemoreblocks.block.WallMushroomColonyBlock;
import net.sefacestudios.somemoreblocks.datagen.providers.data.worldgen.utils.RandomPatchPlacementUtils;
import net.sefacestudios.somemoreblocks.tags.SMBBlockTags;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SimpleFungusColonyWallFeatureProvider extends SimpleMushroomColonyWallFeatureProvider {
  public SimpleFungusColonyWallFeatureProvider(Block toPlaceBlock) {
    super(toPlaceBlock);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(RandomOffsetPlacement.vertical(UniformInt.of(1, 8)));
    modifier.add(BiomeFilter.biome());
    RandomPatchPlacementUtils.addEveryLayer(modifier, 256, 3, 2);
    modifier.add(BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));
  }

  @Override
  protected Holder<@NotNull PlacedFeature> placementFacing(Direction direction) {
    return PlacementUtils.filtered(
      Feature.SIMPLE_BLOCK,
      new SimpleBlockConfiguration(
        BlockStateProvider.simple(
          this.toPlaceBlock.defaultBlockState()
            .setValue(WallMushroomColonyBlock.FACING, direction)
        )
      ),

      BlockPredicate.allOf(
        BlockPredicate.ONLY_IN_AIR_PREDICATE,
        BlockPredicate.anyOf(
          BlockPredicate.matchesBlocks(Vec3i.ZERO.above(), Blocks.AIR),
          BlockPredicate.matchesTag(Vec3i.ZERO.above(), SMBBlockTags.FUNGUS_COLONIES),
          BlockPredicate.matchesBlocks(Vec3i.ZERO.relative(direction.getOpposite()), Blocks.WARPED_WART_BLOCK),
          BlockPredicate.matchesBlocks(Vec3i.ZERO.relative(direction.getOpposite()), Blocks.NETHER_WART_BLOCK)
        ),
        BlockPredicate.anyOf(
          BlockPredicate.matchesTag(Vec3i.ZERO.relative(direction.getOpposite()), BlockTags.CRIMSON_STEMS),
          BlockPredicate.matchesTag(Vec3i.ZERO.relative(direction.getOpposite()), BlockTags.WARPED_STEMS)
        )
      )
    );
  }
}
