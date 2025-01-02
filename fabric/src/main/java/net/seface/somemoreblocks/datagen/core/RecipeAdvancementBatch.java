package net.seface.somemoreblocks.datagen.core;

import net.minecraft.world.level.ItemLike;
import net.seface.somemoreblocks.MoreBlocks;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdvancementBatch implements IRecipeAdvancement<RecipeAdvancementBatch> {
  private final List<RecipeAdvancement> instances = new ArrayList<>();
  private final String name;

  private int expectedEntries = 1;

  public RecipeAdvancementBatch(String name) {
    this.name = name;
  }

  public RecipeAdvancementBatch create(ItemLike unlockedItem) {
    instances.add(RecipeAdvancement.create(unlockedItem));
    return this;
  }

  public RecipeAdvancementBatch create(ItemLike unlockedItem, boolean applyFromSuffix) {
    instances.add(RecipeAdvancement.create(unlockedItem, applyFromSuffix));
    return this;
  }

  public RecipeAdvancementBatch create(ItemLike unlockedItem, RecipeAdvancementGroupType groupType) {
    instances.add(RecipeAdvancement.create(unlockedItem, groupType));
    return this;
  }

  public RecipeAdvancementBatch create(ItemLike unlockedItem, RecipeAdvancementGroupType groupType, boolean applyFromSuffix) {
    instances.add(RecipeAdvancement.create(unlockedItem, groupType, applyFromSuffix));
    return this;
  }

  public RecipeAdvancementBatch setExpectedEntries(int value) {
    this.expectedEntries = value;
    return this;
  }

  @Override
  public RecipeAdvancementBatch setMainCraftableItem(ItemLike item) {
    if (!instances.isEmpty()) {
      instances.get(instances.size() - 1).setMainCraftableItem(item);
    }

    return this;
  }

  @Override
  public RecipeAdvancementBatch craftableFrom(ItemLike... items) {
    if (!instances.isEmpty()) {
      instances.get(instances.size() - 1).craftableFrom(items);
    }

    return this;
  }

  @Override
  public RecipeAdvancementBatch cuttableFrom(ItemLike... items) {
    if (!instances.isEmpty()) {
      instances.get(instances.size() - 1).cuttableFrom(items);
    }
    return this;
  }

  @Override
  public void build() {
    MoreBlocks.LOGGER.info("Generating recipe advancements for the group \"" + this.name + "\". (" + this.instances.size() + " entries)");

    if (this.instances.size() < this.expectedEntries) {
      MoreBlocks.LOGGER.warn(" - The entries size for the group \"" + this.name + "\" is not what is expected! (Expected: " + this.expectedEntries + " | Have: " + this.instances.size() + ")");
    }

    instances.forEach(RecipeAdvancement::build);
  }
}
