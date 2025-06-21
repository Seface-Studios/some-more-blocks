package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.GameRules;
import net.seface.somemoreblocks.platform.PlatformServices;

public class SMBGameRules {
  public static final GameRules.Key<GameRules.BooleanValue> RULE_SNOW_ACCUMULATE = PlatformServices.REGISTRY.registerGameRule("doSnowAccumulateOnPlants", GameRules.Category.UPDATES, GameRules.BooleanValue.create(true));
  public static final GameRules.Key<GameRules.BooleanValue> RULE_DRY_LEAF_LITTER = PlatformServices.REGISTRY.registerGameRule("doLeafLitterDry", GameRules.Category.UPDATES, GameRules.BooleanValue.create(true));

  public static void init() {}
}
