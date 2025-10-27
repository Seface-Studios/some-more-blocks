package net.seface.somemoreblocks.worldgen.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record CeilingVeinConfiguration(BlockStateProvider entries, BlockPredicate replaceablePredicate, IntProvider length) implements FeatureConfiguration {
  public static final Codec<CeilingVeinConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
    BlockStateProvider.CODEC.fieldOf("entries").forGetter(o -> o.entries),
    BlockPredicate.CODEC.fieldOf("replaceablePredicate").forGetter(o -> o.replaceablePredicate),
    IntProvider.POSITIVE_CODEC.fieldOf("length").forGetter(o -> o.length)
  ).apply(instance, CeilingVeinConfiguration::new));

  public BlockStateProvider entries() {
    return this.entries;
  }

  public BlockPredicate replaceablePredicate() {
    return this.replaceablePredicate;
  }

  public IntProvider length() {
    return this.length;
  }
}
