package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.world.level.pathfinder.PathType;
import net.seface.somemoreblocks.Constants;

public class CommonRegistries {

  public static void init() {
    SMBRegistries.init();
    CommonRegistries.registerPathNodeTypes();
    CommonRegistries.registerFuels();
    SMBBiomeModifiers.init();
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
}
