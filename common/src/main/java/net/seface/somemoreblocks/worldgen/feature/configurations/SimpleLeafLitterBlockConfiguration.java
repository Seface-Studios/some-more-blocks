package net.seface.somemoreblocks.worldgen.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public record SimpleLeafLitterBlockConfiguration(BlockStateProvider toPlace, float chance, int xzSpread, List<ResourceKey<Block>> parents) implements FeatureConfiguration {
  public static final Codec<SimpleLeafLitterBlockConfiguration> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
    BlockStateProvider.CODEC.fieldOf("to_place").forGetter(
      (simpleBlockConfiguration) -> simpleBlockConfiguration.toPlace),

    Codec.FLOAT.optionalFieldOf("chance", 12.5F).forGetter(
      (simpleBlockConfiguration) -> simpleBlockConfiguration.chance),

    Codec.INT.optionalFieldOf("xzSpread", 2).forGetter(
      (simpleBlockConfiguration) -> simpleBlockConfiguration.xzSpread),

    Codec.list(ResourceKey.codec(BuiltInRegistries.BLOCK.key())).fieldOf("parents").forGetter(
      (simpleBlockConfiguration) -> simpleBlockConfiguration.parents
    )
  ).apply(instance, SimpleLeafLitterBlockConfiguration::new));

  public SimpleLeafLitterBlockConfiguration(BlockStateProvider toPlace, List<ResourceKey<Block>> parents) {
    this(toPlace, 4, 0, parents);
  }

  public SimpleLeafLitterBlockConfiguration(BlockStateProvider toPlace, int xzSpread, List<ResourceKey<Block>> parents) {
    this(toPlace, 4, xzSpread, parents);
  }

  public SimpleLeafLitterBlockConfiguration(BlockStateProvider toPlace, float chance, int xzSpread, List<ResourceKey<Block>> parents) {
    this.toPlace = toPlace;
    this.chance = chance;
    this.xzSpread = xzSpread;
    this.parents = parents;
  }

  public BlockStateProvider toPlace() {
    return this.toPlace;
  }

  public float chance() {
    return this.chance;
  }

  public int xzSpread() {
    return this.xzSpread;
  }

  public List<ResourceKey<Block>> parents() {
    return this.parents;
  }
}
