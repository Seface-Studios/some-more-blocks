package net.sefacestudios.somemoreblocks.registries;

import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import net.sefacestudios.somemoreblocks.platform.PlatformEnvironment;
import net.sefacestudios.somemoreblocks.platform.PlatformServices;
import net.sefacestudios.somemoreblocks.platform.registry.PlatformRegistryObject;
import org.jetbrains.annotations.NotNull;

public class SMBGameRules {
  public static final PlatformRegistryObject<GameRule<@NotNull Boolean>> RULE_SNOW_ACCUMULATE = PlatformServices.REGISTRY.registerBooleanGameRule("snow_accumulate_on_plants", GameRuleCategory.UPDATES, true);
  public static final PlatformRegistryObject<GameRule<@NotNull Boolean>> RULE_DRY_LEAF_LITTER = PlatformServices.REGISTRY.registerBooleanGameRule("leaf_litter_dry", GameRuleCategory.UPDATES, true);

  public static void init() {
    if (PlatformServices.HELPER.getEnvironment().equals(PlatformEnvironment.DEVELOPMENT)) {
      SomeMoreBlocks.LOGGER.info("Game Rules registry initialized.");
    }
  }
}
