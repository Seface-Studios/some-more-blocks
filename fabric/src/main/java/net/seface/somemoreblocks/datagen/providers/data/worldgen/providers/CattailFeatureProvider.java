package net.seface.somemoreblocks.datagen.providers.data.worldgen.providers;

import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.tags.SMBBlockTags;
import net.seface.somemoreblocks.tags.SMBConfiguredFeature;
import net.seface.somemoreblocks.tags.SMBPlacedFeature;

import java.util.Arrays;
import java.util.List;

public class CattailFeatureProvider extends AbstractFeatureProvider<RandomPatchConfiguration> {

  public CattailFeatureProvider() {
    super(Feature.RANDOM_PATCH);
  }

  @Override
  protected void placed(List<PlacementModifier> modifier) {
    modifier.add(CountPlacement.of(5));
    modifier.add(InSquarePlacement.spread());
    modifier.add(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG));
    modifier.add(BiomeFilter.biome());
  }

  @Override
  protected RandomPatchConfiguration configuration() {
    return new RandomPatchConfiguration(32, 2, 2,
      PlacementUtils.filtered(
        Feature.SIMPLE_BLOCK,
        new SimpleBlockConfiguration(SimpleStateProvider.simple(SMBBlocks.CATTAIL.get())),
        BlockPredicate.anyOf(this.getFluidOrCattailPredicate(), this.getCattailPredicate())
      )
    );
  }

  private BlockPredicate getFluidOrCattailPredicate() {
    return BlockPredicate.anyOf(
      Arrays.stream(Direction.values())
        .filter(direction -> direction != Direction.UP && direction != Direction.DOWN)
        .map(direction -> BlockPredicate.anyOf(
          BlockPredicate.matchesFluids(direction.getUnitVec3i(), Fluids.WATER, Fluids.FLOWING_WATER),
          BlockPredicate.matchesBlocks(direction.getUnitVec3i(), SMBBlocks.CATTAIL.get()),
          BlockPredicate.matchesBlocks(new Vec3i(direction.getUnitVec3i().getX(), 0, direction.getUnitVec3i().getZ()), SMBBlocks.CATTAIL.get())
        ))
        .toArray(BlockPredicate[]::new));
  }

  private BlockPredicate getCattailPredicate() {
    return BlockPredicate.allOf(
      BlockPredicate.matchesFluids(Vec3i.ZERO, Fluids.WATER),
      BlockPredicate.matchesTag(Vec3i.ZERO.below(), SMBBlockTags.CATTAIL_PLACEABLE),
      BlockPredicate.anyOf(
        Arrays.stream(Direction.values())
          .filter(dir -> dir != Direction.UP && dir != Direction.DOWN)
          .map(dir -> BlockPredicate.matchesTag(dir.getUnitVec3i(), SMBBlockTags.CATTAIL_PLACEABLE))
          .toArray(BlockPredicate[]::new)));
  }

  public static <T extends AbstractFeatureProvider<?>> T create() {
    return new CattailFeatureProvider()
      .setPlacedFeatureKey(SMBPlacedFeature.PATCH_CATTAIL)
      .setConfiguredFeatureKey(SMBConfiguredFeature.PATCH_CATTAIL);
  }
}
