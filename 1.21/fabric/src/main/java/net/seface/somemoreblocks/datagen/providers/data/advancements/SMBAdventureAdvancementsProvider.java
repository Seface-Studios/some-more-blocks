package net.seface.somemoreblocks.datagen.providers.data.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.packs.VanillaHusbandryAdvancements;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBAdventureAdvancementsProvider extends FabricAdvancementProvider {
  private Consumer<AdvancementHolder> generator;

  public SMBAdventureAdvancementsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
    super(output, lookup);
  }

  @Override
  public String getName() {
    return "Advancements Adventure";
  }

  @Override
  public void generateAdvancement(HolderLookup.Provider lookup, Consumer<AdvancementHolder> gen) {
    this.generator = gen;
    this.aGrateTimeWaste();
  }

  private void aGrateTimeWaste() {
    ResourceLocation parentPath = ResourceLocation.withDefaultNamespace("adventure/minecraft_trials_edition");
    Advancement.Builder.advancement()
      .parent(Advancement.Builder.advancement().build(parentPath))
      .display(SMBBlocks.NETHERITE_GRATE.get(), Component.translatable("advancements.somemoreblocks.adventure.grates.title"), Component.translatable("advancements.somemoreblocks.adventure.grates.description"), (ResourceLocation)null, AdvancementType.CHALLENGE, true, true, false)
      .addCriterion("grates",
        InventoryChangeTrigger.TriggerInstance.hasItems(
          SMBBlocks.IRON_GRATE.get(),
          SMBBlocks.DIAMOND_GRATE.get(),
          SMBBlocks.NETHERITE_GRATE.get()
        )
      ).save(this.generator, "adventure/grates");
  }
}
