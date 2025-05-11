package net.seface.somemoreblocks.datagen.providers.data.forge;

import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Either;
import lombok.Getter;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class ForgeModifierProvider implements DataProvider {
  private final FabricDataOutput output;
  protected ForgeBiomeModifier modifier;
  protected Loader loader;

  public ForgeModifierProvider(FabricDataOutput output, Loader loader) {
    this.output = output;
    this.loader = loader;
  }

  public abstract void create();

  @Override
  public CompletableFuture<?> run(CachedOutput writer) {
    this.create();
    final PackOutput.PathProvider pathResolver = this.output.createPathProvider(PackOutput.Target.DATA_PACK, this.loader.getId() + "/biome_modifier");
    List<CompletableFuture<?>> futures = new ArrayList<>();

    for (Map.Entry<ResourceLocation, ForgeBiomeModifier> entry : ForgeBiomeModifier.TO_GENERATE.entrySet()) {
      JsonObject json = new JsonObject();

      json.addProperty("type", entry.getValue().getType().toString());
      json.addProperty("biomes", this.getBiomesFieldValue(entry.getValue()));
      json.addProperty("features", entry.getValue().getFeature().location().toString());
      json.addProperty("step", entry.getValue().getStep().getName());

      futures.add(DataProvider.saveStable(writer, json, pathResolver.json(entry.getKey())));
    }

    return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
  }

  @Override
  public String getName() {
    return this.loader.getName() + " Biome Modifier";
  }

  public ForgeBiomeModifier configure() {
    this.modifier = new ForgeBiomeModifier();
    return this.modifier;
  }

  private String getBiomesFieldValue(ForgeBiomeModifier modifier) {
    Either<TagKey<Biome>, ResourceKey<Biome>> biomes = modifier.getBiomes();

    if (biomes.left().isPresent()) {
      return "#" + biomes.left().orElseThrow().location();
    }

    return biomes.right().orElseThrow().location().toString();
  }

  @Getter
  public enum Loader {
    FORGE("forge", "Forge"),
    NEOFORGE("neoforge", "NeoForge");

    private final String id;
    private final String name;

    Loader(String id, String name) {
      this.id = id;
      this.name = name;
    }

    public boolean is(Loader expectedLoader) {
      return this == expectedLoader;
    }
  }

  @Getter
  public enum Modifier {
    NONE(0, "none"),
    ADD_FEATURES(1, "add_features"),
    REMOVE_FEATURES(2, "remove_features");

    private final int index;

    private final String type;

    Modifier(int index, String type) {
      this.index = index;
      this.type = type;
    }
  }
}
