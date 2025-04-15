package net.seface.somemoreblocks.datagen.providers.data.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
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
import net.seface.somemoreblocks.registries.SMBRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SMBHusbandryAdvancementsProvider extends FabricAdvancementProvider {
  private Consumer<AdvancementHolder> generator;
  private HolderGetter<Item> itemHolder;
  private HolderGetter<Block> blockHolder;

  private static final List<Block> WAX_ON_BLOCKS = new ArrayList<>(HoneycombItem.WAXABLES.get().keySet());
  private static final List<Block> WAX_OFF_BLOCKS = new ArrayList<>(HoneycombItem.WAX_OFF_BY_BLOCK.get().keySet());

  public SMBHusbandryAdvancementsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
    super(output, lookup);

    WAX_ON_BLOCKS.addAll(SMBRegistries.WAXED_COPPER_BLOCKS.getKeySet().stream().toList());
    WAX_OFF_BLOCKS.addAll(SMBRegistries.WAXED_COPPER_BLOCKS.getValueSet().stream().toList());
  }

  @Override
  public void generateAdvancement(HolderLookup.Provider lookup, Consumer<AdvancementHolder> gen) {
    this.generator = gen;
    this.itemHolder = lookup.lookupOrThrow(Registries.ITEM);
    this.blockHolder = lookup.lookupOrThrow(Registries.BLOCK);

    this.waxOnOrOff("safely_harvest_honey", Items.HONEYCOMB, "wax_on", WAX_ON_BLOCKS, List.of(Items.HONEYCOMB));
    this.waxOnOrOff("wax_on", Items.STONE_AXE, "wax_off", WAX_OFF_BLOCKS, Arrays.stream(VanillaHusbandryAdvancements.WAX_SCRAPING_TOOLS).toList());
  }

  /**
   * Extend the Wax On/Off blocks to the vanilla advancements
   * @param parent The parent advancement.
   * @param displayItem The item to be displayed.
   * @param name The advancement name.
   * @param usableOn The block to be interacted.
   * @param usedBy The item to interact on block.
   */
  private void waxOnOrOff(String parent, ItemLike displayItem, String name, List<Block> usableOn, List<Item> usedBy) {
    ResourceLocation parentPath = ResourceLocation.withDefaultNamespace("husbandry/" + parent);
    ResourceLocation outputPath = ResourceLocation.withDefaultNamespace("husbandry/" + name);

    this.generator.accept(
      Advancement.Builder.advancement()
        .parent(Advancement.Builder.advancement().build(parentPath))
        .display(displayItem,
          Component.translatable("advancements.husbandry." + name + ".title"), Component.translatable("advancements.husbandry." + name + ".description"), null, AdvancementType.TASK, true, true, false)
        .addCriterion(name,
          ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
            LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(this.blockHolder, usableOn)),
            ItemPredicate.Builder.item().of(this.itemHolder, usedBy.toArray(new ItemLike[0]))
          )
        ).build(outputPath)
    );
  }
}
