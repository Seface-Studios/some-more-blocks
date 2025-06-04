package net.seface.somemoreblocks.datagen.providers.data.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBNetherAdvancementsProvider extends FabricAdvancementProvider {
  private Consumer<AdvancementHolder> generator;

  public SMBNetherAdvancementsProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public String getName() {
    return "Advancements Nether";
  }

  @Override
  public void generateAdvancement(Consumer<AdvancementHolder> gen) {
    this.generator = gen;
    this.verySeriousDedication();
  }

  private void verySeriousDedication() {
    ResourceLocation parentPath = SomeMoreBlocks.minecraftId("nether/obtain_ancient_debris");
    Advancement.Builder.advancement()
      .parent(Advancement.Builder.advancement().build(parentPath))
      .display(SMBBlocks.CUT_NETHERITE.get(), Component.translatable("advancements.somemoreblocks.nether.obtain_cut_netherite.title"), Component.translatable("advancements.somemoreblocks.nether.obtain_cut_netherite.description"), null, AdvancementType.CHALLENGE, true, true, false)
      .addCriterion("cut_netherite",
        InventoryChangeTrigger.TriggerInstance.hasItems(SMBBlocks.CUT_NETHERITE.get()))
      .rewards(AdvancementRewards.Builder.experience(100))
      .save(this.generator, "nether/obtain_cut_netherite");
  }
}
