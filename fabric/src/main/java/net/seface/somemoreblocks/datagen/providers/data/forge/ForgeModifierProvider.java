package net.seface.somemoreblocks.datagen.providers.data.forge;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class ForgeModifierProvider implements DataProvider {
  private final FabricDataOutput output;
  private ForgeBiomeModifier modifier;

  public ForgeModifierProvider(FabricDataOutput output) {
    this.output = output;
  }

  public abstract void create();

  @Override
  public CompletableFuture<?> run(CachedOutput writer) {
    this.create();
    final PackOutput.PathProvider pathResolver = this.output.createPathProvider(PackOutput.Target.DATA_PACK, "forge/biome_modifier");
    List<CompletableFuture<?>> futures = new ArrayList<>();

    for (Map.Entry<ResourceLocation, ForgeBiomeModifier> entry : ForgeBiomeModifier.TO_GENERATE.entrySet()) {
      JsonObject json = new JsonObject();

      json.addProperty("type", entry.getValue().getType().toString());
      json.addProperty("biomes", this.getBiomesFieldValue(entry.getValue()));
      json.addProperty("feature", entry.getValue().getFeature().location().toString());
      json.addProperty("step", entry.getValue().getStep().getName());

      futures.add(DataProvider.saveStable(writer, json, pathResolver.json(entry.getKey())));
    }

    return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
  }

  @Override
  public String getName() {
    return "Forge Biome Modifier";
  }

  public ForgeBiomeModifier configure() {
    this.modifier = new ForgeBiomeModifier();
    return this.modifier;
  }

  private String getBiomesFieldValue(ForgeBiomeModifier modifier) {
    if (modifier.getBiomes().orThrow() instanceof TagKey<Biome>) {
      return "#" + modifier.getBiomes().left().orElseThrow().location();
    }

    return modifier.getBiomes().right().orElseThrow().location().toString();
  }
}
