package net.seface.moreblocks.datagen.core;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

@Getter
public enum RecipeAdvancementGroupType {
  BREWING("brewing"),
  BUILDING_BLOCKS("building_blocks"),
  COMBAT("combat"),
  DECORATIONS("decorations"),
  FOOD("food"),
  MISC("misc"),
  REDSTONE("redstone"),
  TOOLS("tools"),
  TRANSPORTATION("transportation");

  private final String name;

  RecipeAdvancementGroupType(String name) {
    this.name = name;
  }
}
