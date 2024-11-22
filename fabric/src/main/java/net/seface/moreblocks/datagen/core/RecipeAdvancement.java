package net.seface.moreblocks.datagen.core;

import lombok.Setter;
import lombok.SneakyThrows;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.seface.moreblocks.MoreBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// TODO: Integrate with Recipe data gen.
@SuppressWarnings("deprecation")
public class RecipeAdvancement implements IRecipeAdvancement<RecipeAdvancement> {

  @Setter
  private static Consumer<AdvancementHolder> consumer;

  private ItemLike unlockedItem;
  private boolean applyFromSuffix;

  private List<ItemLike> craftableWith;
  private List<ItemLike> stonecutterWith;

  @Nullable
  private RecipeAdvancementGroupType groupType;

  private ItemLike mainCraftableItem = null;

  protected RecipeAdvancement(ItemLike unlockedItem) {
    this(unlockedItem, RecipeAdvancementGroupType.BUILDING_BLOCKS, false);
  }

  protected RecipeAdvancement(ItemLike unlockedItem, boolean applyFromSuffix) {
    this(unlockedItem, RecipeAdvancementGroupType.BUILDING_BLOCKS, applyFromSuffix);
  }

  protected RecipeAdvancement(ItemLike unlockedItem, @Nullable RecipeAdvancementGroupType groupType) {
    this(unlockedItem, groupType, false);
  }

  protected RecipeAdvancement(ItemLike unlockedItem, @Nullable RecipeAdvancementGroupType groupType, boolean applyFromSuffix) {
    this.unlockedItem = unlockedItem;
    this.groupType = groupType;

    this.applyFromSuffix = applyFromSuffix;
    this.craftableWith = new ArrayList<>();
    this.stonecutterWith = new ArrayList<>();
  }

  @SneakyThrows
  public static RecipeAdvancement create(ItemLike unlockedItem) {
    return new RecipeAdvancement(unlockedItem, RecipeAdvancementGroupType.BUILDING_BLOCKS, false);
  }

  @SneakyThrows
  public static RecipeAdvancement create(ItemLike unlockedItem, boolean applyFromSuffix) {
    return new RecipeAdvancement(unlockedItem, RecipeAdvancementGroupType.BUILDING_BLOCKS, applyFromSuffix);
  }

  @SneakyThrows
  public static RecipeAdvancement create(ItemLike unlockedItem, RecipeAdvancementGroupType groupType) {
    return new RecipeAdvancement(unlockedItem, groupType, false);
  }

  @SneakyThrows
  public static RecipeAdvancement create(ItemLike unlockedItem, RecipeAdvancementGroupType groupType, boolean applyFromSuffix) {
    return new RecipeAdvancement(unlockedItem, groupType, applyFromSuffix);
  }

  public static RecipeAdvancementBatch group(String name, Consumer<RecipeAdvancementBatch> consumer) {
    RecipeAdvancementBatch batch = new RecipeAdvancementBatch(name);
    consumer.accept(batch);
    return batch;
  }

  @Override
  public RecipeAdvancement setMainCraftableItem(ItemLike item) {
    this.mainCraftableItem = item;

    if (!this.craftableWith.contains(item)) {
      String itemName = item.asItem().getDefaultInstance().getDisplayName().getString();
      MoreBlocks.LOGGER.warn("Could not find main item \"" + itemName + "\" in \"craftableFrom\" method. Adding automatically.");
      this.craftableWith.add(item);
    }
    return this;
  }

  @Override
  public RecipeAdvancement craftableFrom(ItemLike... items) {
    this.craftableWith.addAll(List.of(items));
    return this;
  }

  @Override
  public RecipeAdvancement cuttableFrom(ItemLike... items) {
    this.stonecutterWith.addAll(List.of(items));
    return this;
  }

  @Override
  public void build() {
    this.craftingAdvancementRecipeBuilder();
    this.stonecuttingAdvancementRecipeBuilder();
  }

  private void craftingAdvancementRecipeBuilder() {

    if (this.craftableWith.isEmpty()) return;

    //this.mainCraftableItem = this.mainCraftableItem == null ? this.craftableWith.get(0) : this.mainCraftableItem;
    String group = this.groupType == null ? "" : this.groupType.getName() + "/";

    for (ItemLike requiredItem : this.craftableWith) {
      String requiredItemPath = requiredItem.asItem().builtInRegistryHolder().key().location().getPath();
      String suffix = "";

      if (this.craftableWith.size() > 1 && this.mainCraftableItem != requiredItem) {
        suffix = "_from_" + requiredItemPath;
      }

      ResourceLocation resourceLocation = new ResourceLocation(MoreBlocks.ID, this.unlockedItem.asItem().builtInRegistryHolder().key().location().getPath() + suffix);
      String name = resourceLocation.getPath();

      consumer.accept(
        Advancement.Builder.recipeAdvancement()
          .parent(Advancement.Builder.recipeAdvancement().build(new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, "recipes/root")))
          .addCriterion("has_needed_items", InventoryChangeTrigger.TriggerInstance.hasItems(requiredItem))
          .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation))
          .rewards(AdvancementRewards.Builder.recipe(resourceLocation))
          .requirements(AdvancementRequirements.anyOf(List.of("has_needed_items", "has_the_recipe")))
          .build(new ResourceLocation(MoreBlocks.ID, "recipes/" + group + name))
      );
    }
  }

  private void stonecuttingAdvancementRecipeBuilder() {
    if (this.stonecutterWith.isEmpty()) return;

    String group = this.groupType == null ? "" : this.groupType.getName() + "/";

    for (ItemLike requiredItem : this.stonecutterWith) {
      String requiredItemPath = requiredItem.asItem().builtInRegistryHolder().key().location().getPath();
      String suffix = "_from_" + requiredItemPath + "_stonecutting";

      ResourceLocation resourceLocation = new ResourceLocation(MoreBlocks.ID, this.unlockedItem.asItem().builtInRegistryHolder().key().location().getPath() + suffix);
      String name = resourceLocation.getPath();

      consumer.accept(
        Advancement.Builder.recipeAdvancement()
          .parent(Advancement.Builder.recipeAdvancement().build(new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, "recipes/root")))
          .addCriterion("has_needed_items", InventoryChangeTrigger.TriggerInstance.hasItems(requiredItem))
          .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation))
          .rewards(AdvancementRewards.Builder.recipe(resourceLocation))
          .requirements(AdvancementRequirements.anyOf(List.of("has_needed_items", "has_the_recipe")))
          .build(new ResourceLocation(MoreBlocks.ID, "recipes/" + group + name))
      );
    }
  }
}
