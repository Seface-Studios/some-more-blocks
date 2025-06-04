package net.seface.somemoreblocks.datagen.providers.data.forge;

import com.mojang.datafixers.util.Either;
import lombok.Getter;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ForgeBiomeModifier {
  private ResourceLocation type;
  private Either<@Nullable TagKey<Biome>, @Nullable ResourceKey<Biome>> biomes;
  private ResourceKey<PlacedFeature> feature;
  private GenerationStep.Decoration step;

  public static Map<ResourceLocation, ForgeBiomeModifier> TO_GENERATE = new HashMap<>();

  public ForgeBiomeModifier() {}

  public ForgeBiomeModifier setType() {
    this.type = this.feature.location();
    return this;
  }

  public ForgeBiomeModifier setType(ResourceLocation value) {
    this.type = value;
    return this;
  }

  public ForgeBiomeModifier setType(ForgeModifierProvider.Loader loader, ForgeModifierProvider.Modifier modifier) {
    this.type = new ResourceLocation(loader.getId(), modifier.getType());
    return this;
  }

  public ForgeBiomeModifier setBiomes(TagKey<Biome> value) {
    this.biomes = Either.left(value);
    return this;
  }

  public ForgeBiomeModifier setBiomes(ResourceKey<Biome> value) {
    this.biomes = Either.right(value);
    return this;
  }

  public ForgeBiomeModifier setFeature(ResourceKey<PlacedFeature> value) {
    this.feature = value;
    return this;
  }

  public ForgeBiomeModifier setDecorationStep(GenerationStep.Decoration value) {
    this.step = value;
    return this;
  }

  public void build() {
    TO_GENERATE.put(this.feature.location(), this);
  }
}
