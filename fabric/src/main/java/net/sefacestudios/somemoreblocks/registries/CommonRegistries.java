package net.sefacestudios.somemoreblocks.registries;

import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.LandPathTypeRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.world.level.pathfinder.PathType;
import net.sefacestudios.somemoreblocks.Constants;

public class CommonRegistries {

  public static void init() {
    CommonRegistries.registerPathNodeTypes();
    CommonRegistries.registerFuels();
    CommonRegistries.registerOxidizableBlocks();
    CommonRegistries.registerWaxableBlocks();
  }

  private static void registerPathNodeTypes() {
    LandPathTypeRegistry.register(SMBBlocks.TINY_CACTUS.get(), (s, n) -> PathType.DAMAGING);
    LandPathTypeRegistry.register(SMBBlocks.TALL_CACTUS.get(), (s, n) -> PathType.DAMAGING);
  }

 /**
  * Registers Fuel values.
  */
  private static void registerFuels() {
    FuelValueEvents.BUILD.register((builder, ctx) -> {
      builder.add(SMBBlocks.COAL_BRICKS.get(), Constants.COAL_BRICKS_FUEL);
      builder.add(SMBBlocks.CRACKED_COAL_BRICKS.get(), Constants.CRACKED_COAL_BRICKS_FUEL);
      builder.add(SMBBlocks.COAL_PILLAR.get(), Constants.COAL_PILLAR_FUEL);
      builder.add(SMBBlocks.CUT_COAL.get(), Constants.CUT_COAL_FUEL);
      builder.add(SMBBlocks.CRACKED_CUT_COAL.get(), Constants.CRACKED_CUT_COAL_FUEL);
      builder.add(SMBItems.CLOVER.get(), Constants.CLOVER_FUEL);
    });
  }

  private static void registerOxidizableBlocks() {
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerNextStage(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
  }

  public static void registerWaxableBlocks() {
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerWaxable(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
  }
}
