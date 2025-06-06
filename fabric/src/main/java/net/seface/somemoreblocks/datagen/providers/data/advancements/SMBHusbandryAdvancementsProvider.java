package net.seface.somemoreblocks.datagen.providers.data.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.advancements.packs.VanillaHusbandryAdvancements;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SMBHusbandryAdvancementsProvider extends FabricAdvancementProvider {
  private Consumer<Advancement> generator;

  private static final List<Block> WAX_ON_BLOCKS = new ArrayList<>(HoneycombItem.WAXABLES.get().keySet());
  private static final List<Block> WAX_OFF_BLOCKS = new ArrayList<>(HoneycombItem.WAX_OFF_BY_BLOCK.get().keySet());

  public SMBHusbandryAdvancementsProvider(FabricDataOutput output) {
    super(output);

    WAX_ON_BLOCKS.addAll(SMBRegistries.WAXED_COPPER_BLOCKS.getKeySet().stream().toList());
    WAX_OFF_BLOCKS.addAll(SMBRegistries.WAXED_COPPER_BLOCKS.getValueSet().stream().toList());
  }


  @Override
  public String getName() {
    return "Advancements Husbandry";
  }

  @Override
  public void generateAdvancement(Consumer<Advancement> gen) {
    this.generator = gen;

    this.waxOnOrOff("safely_harvest_honey", Items.HONEYCOMB, "wax_on", WAX_ON_BLOCKS, List.of(Items.HONEYCOMB));
    this.waxOnOrOff("wax_on", Items.STONE_AXE, "wax_off", WAX_OFF_BLOCKS, Arrays.stream(VanillaHusbandryAdvancements.WAX_SCRAPING_TOOLS).toList());
    this.withOurPoweredCombined();
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
    ResourceLocation parentPath = SomeMoreBlocks.minecraftId("husbandry/" + parent);
    ResourceLocation outputPath = SomeMoreBlocks.minecraftId("husbandry/" + name);

    this.generator.accept(
      Advancement.Builder.advancement()
        .parent(Advancement.Builder.advancement().build(parentPath))
        .display(displayItem,
          Component.translatable("advancements.husbandry." + name + ".title"), Component.translatable("advancements.husbandry." + name + ".description"), null, FrameType.TASK, true, true, false)
        .addCriterion(name,
          ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
            LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(usableOn).build()),
            ItemPredicate.Builder.item().of(usedBy.toArray(new ItemLike[0]))
          )
        ).build(outputPath)
    );
  }

  private void withOurPoweredCombined() {
    ResourceLocation parentPath = SomeMoreBlocks.minecraftId("husbandry/froglights");
    Advancement.Builder.advancement()
      .parent(Advancement.Builder.advancement().build(parentPath))
      .display(SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get(), Component.translatable("advancements.somemoreblocks.husbandry.redstone_froglights.title"), Component.translatable("advancements.somemoreblocks.husbandry.redstone_froglights.description"), null, FrameType.CHALLENGE, true, true, false)
      .addCriterion("redstone_froglights",
        InventoryChangeTrigger.TriggerInstance.hasItems(
          SMBBlocks.OCHRE_REDSTONE_FROGLIGHT.get(),
          SMBBlocks.PEARLESCENT_REDSTONE_FROGLIGHT.get(),
          SMBBlocks.VERDANT_REDSTONE_FROGLIGHT.get()
        )
      ).save(this.generator, "husbandry/redstone_froglights");
  }
}
