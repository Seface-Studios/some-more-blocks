package net.sefacestudios.somemoreblocks.datagen.providers.data.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBNetherAdvancementsProvider extends FabricAdvancementProvider {
  private Consumer<AdvancementHolder> generator;

  public SMBNetherAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
    super(output, lookup);
  }

  @NotNull
  @Override
  public String getName() {
    return "Advancements Nether";
  }

  @Override
  public void generateAdvancement(@NotNull HolderLookup.Provider lookup, @NotNull Consumer<AdvancementHolder> gen) {
    this.generator = gen;
    this.verySeriousDedication();
  }

  private void verySeriousDedication() {
    Identifier parentPath = Identifier.withDefaultNamespace("nether/obtain_ancient_debris");
    Advancement.Builder.advancement()
      .parent(Advancement.Builder.advancement().build(parentPath))
      .display(SMBBlocks.CUT_NETHERITE.get(), Component.translatable("advancements.somemoreblocks.nether.obtain_cut_netherite.title"), Component.translatable("advancements.somemoreblocks.nether.obtain_cut_netherite.description"), null, AdvancementType.CHALLENGE, true, true, false)
      .addCriterion("cut_netherite",
        InventoryChangeTrigger.TriggerInstance.hasItems(SMBBlocks.CUT_NETHERITE.get()))
      .rewards(AdvancementRewards.Builder.experience(100))
      .save(this.generator, "nether/obtain_cut_netherite");
  }
}
