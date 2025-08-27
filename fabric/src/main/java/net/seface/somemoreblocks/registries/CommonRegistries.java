package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.world.level.pathfinder.PathType;
import net.seface.somemoreblocks.Constants;

public class CommonRegistries {

  public static void init() {
    CommonRegistries.registerPathNodeTypes();
    CommonRegistries.registerFuels();
    CommonRegistries.registerOxidizableBlocks();
  }

  private static void registerPathNodeTypes() {
    LandPathNodeTypesRegistry.register(SMBBlocks.TINY_CACTUS.get(), (state, neighbor) -> PathType.DAMAGE_OTHER);
    LandPathNodeTypesRegistry.register(SMBBlocks.TALL_CACTUS.get(), (state, neighbor) -> PathType.DAMAGE_OTHER);
  }

 /**
  * Registers Fuel values.
  */
  private static void registerFuels() {
    FuelRegistryEvents.BUILD.register((builder, ctx) -> {
      builder.add(SMBBlocks.COAL_BRICKS.get(), Constants.COAL_BRICKS_FUEL);
      builder.add(SMBBlocks.CRACKED_COAL_BRICKS.get(), Constants.CRACKED_COAL_BRICKS_FUEL);
      builder.add(SMBBlocks.COAL_PILLAR.get(), Constants.COAL_PILLAR_FUEL);
      builder.add(SMBBlocks.CUT_COAL.get(), Constants.CUT_COAL_FUEL);
      builder.add(SMBBlocks.CRACKED_CUT_COAL.get(), Constants.CRACKED_CUT_COAL_FUEL);
      builder.add(SMBItems.CLOVER.get(), Constants.CLOVER_FUEL);
    });
  }

  private static void registerOxidizableBlocks() {
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.EXPOSED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.EXPOSED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WEATHERED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerOxidizableBlockPair(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.OXIDIZED_COPPER_PILLAR.get());
  }

  public static void registerWaxableBlocks() {
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.COPPER_BRICKS.get(), SMBBlocks.WAXED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.EXPOSED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.WEATHERED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.OXIDIZED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER.get(), SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.COPPER_PILLAR.get(), SMBBlocks.WAXED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.EXPOSED_COPPER_PILLAR.get(), SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.WEATHERED_COPPER_PILLAR.get(), SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR.get());
    OxidizableBlocksRegistry.registerWaxableBlockPair(SMBBlocks.OXIDIZED_COPPER_PILLAR.get(), SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR.get());
  }
}
