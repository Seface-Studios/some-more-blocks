package net.sefacestudios.somemoreblocks.datagen.providers.data.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBAdventureAdvancementsProvider extends FabricAdvancementProvider {
  private Consumer<AdvancementHolder> generator;

  public SMBAdventureAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
    super(output, lookup);
  }

  @NotNull
  @Override
  public String getName() {
    return "Advancements Adventure";
  }

  @Override
  public void generateAdvancement(@NotNull HolderLookup.Provider lookup, @NotNull Consumer<AdvancementHolder> gen) {
    this.generator = gen;
    this.aGrateTimeWaste();
  }

  private void aGrateTimeWaste() {
    Identifier parentPath = Identifier.withDefaultNamespace("adventure/minecraft_trials_edition");
    Advancement.Builder.advancement()
      .parent(Advancement.Builder.advancement().build(parentPath))
      .display(SMBBlocks.NETHERITE_GRATE.get(), Component.translatable("advancements.somemoreblocks.adventure.grates.title"), Component.translatable("advancements.somemoreblocks.adventure.grates.description"), (Identifier)null, AdvancementType.CHALLENGE, true, true, false)
      .addCriterion("grates",
        InventoryChangeTrigger.TriggerInstance.hasItems(
          SMBBlocks.IRON_GRATE.get(),
          SMBBlocks.DIAMOND_GRATE.get(),
          SMBBlocks.NETHERITE_GRATE.get()
        )
      ).save(this.generator, "adventure/grates");
  }
}
