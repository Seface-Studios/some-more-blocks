package net.seface.somemoreblocks.registries;

import net.minecraft.world.level.GameRules;
import net.seface.somemoreblocks.platform.PlatformServices;

public class SMBGameRules {
  public static final GameRules.Key<GameRules.BooleanValue> RULE_SNOW_ACCUMULATE = PlatformServices.REGISTRY.registerBooleanGameRule("doSnowAccumulateOnPlants", GameRules.Category.UPDATES, true);

  public static void init() {}
}
