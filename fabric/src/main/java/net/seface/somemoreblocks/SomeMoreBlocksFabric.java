package net.seface.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.seface.somemoreblocks.event.OnPlayerJoinOrLeaveWorld;
import net.seface.somemoreblocks.registries.CarvedBlockRegistry;
import net.seface.somemoreblocks.registries.SnowyBushRegistry;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBFeatures;
import net.seface.somemoreblocks.registries.SMBCreativeTabs;
import net.seface.somemoreblocks.registries.SMBItems;
import net.seface.somemoreblocks.utils.SMBUtils;
import net.seface.somemoreblocks.registries.WaxableCopperBlockRegistry;
import net.seface.somemoreblocks.registries.WeatheringCopperBlockRegistry;
import net.seface.somemoreblocks.registries.SMBBiomeModifiers;

import java.util.Optional;

public class SomeMoreBlocksFabric implements ModInitializer {
  private static final Optional<ModContainer> MOD_CONTAINER = FabricLoader.getInstance().getModContainer(SomeMoreBlocks.ID);

  @Override
  public void onInitialize() {
    SomeMoreBlocks.init();
    SMBBlocks.register();
    SMBItems.register();
    SMBCreativeTabs.register();
    SMBFeatures.register();
    SMBBiomeModifiers.register();

    LandPathNodeTypesRegistry.register(SMBBlocks.TINY_CACTUS, (state, neighbor) -> BlockPathTypes.DAMAGE_OTHER);

    enableOrDisableExperimentalResourcePack();

    registerCarvedBlocks();
    registerCompostableItems();
    registerFuels();
    registerSnowyBlocks();
    registerWaxableCopperBlocks();
    registerWeatheringCopperBlocks();
  }

  /**
   * Registers values related to Compostable items.
   */
  private static void registerCompostableItems() {
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBItems.TINY_CACTUS);
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBItems.DUNE_GRASS);
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBItems.TALL_DUNE_GRASS);
    SMBUtils.GenericRegistry.compostableItem(0.5F, SMBItems.TALL_DUNE_GRASS);
    SMBUtils.GenericRegistry.compostableItem(0.3F, SMBItems.SHORT_SNOW_GRASS);
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBItems.TALL_SNOW_GRASS);
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBItems.SNOW_FERN);
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBItems.LARGE_SNOW_FERN);
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBItems.CATTAIL);
    SMBUtils.GenericRegistry.compostableItem(0.65F, SMBItems.LUMINOUS_FLOWER);
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.BROWN_MUSHROOM_COLONY);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_BROWN_MUSHROOM_COLONY);
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.RED_MUSHROOM_COLONY);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_RED_MUSHROOM_COLONY);
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.CRIMSON_FUNGUS_COLONY);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_CRIMSON_FUNGUS_COLONY);
    SMBUtils.GenericRegistry.compostableItem(0.85F, SMBItems.WARPED_FUNGUS_COLONY);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.TALL_WARPED_FUNGUS_COLONY);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.LEAVES_BUCKET);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.AZALEA_LEAVES_BUCKET);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.BIRCH_LEAVES_BUCKET);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.FLOWERING_AZALEA_LEAVES_BUCKET);
    SMBUtils.GenericRegistry.compostableItem(1.0F, SMBItems.SPRUCE_LEAVES_BUCKET);
  }

  /**
   * Registers values related to Weathering-like blocks.
   */
  private static void registerWeatheringCopperBlocks() {
    WeatheringCopperBlockRegistry.register(SMBBlocks.COPPER_BRICKS, SMBBlocks.EXPOSED_COPPER_BRICKS);
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_BRICKS, SMBBlocks.WEATHERED_COPPER_BRICKS);
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_BRICKS, SMBBlocks.OXIDIZED_COPPER_BRICKS);
    WeatheringCopperBlockRegistry.register(SMBBlocks.CRACKED_COPPER_BRICKS, SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS);
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS, SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS);
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS, SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS);
    WeatheringCopperBlockRegistry.register(SMBBlocks.CRACKED_CUT_COPPER, SMBBlocks.EXPOSED_CRACKED_CUT_COPPER);
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER, SMBBlocks.WEATHERED_CRACKED_CUT_COPPER);
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER, SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER);
    WeatheringCopperBlockRegistry.register(SMBBlocks.COPPER_PILLAR, SMBBlocks.EXPOSED_COPPER_PILLAR);
    WeatheringCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_PILLAR, SMBBlocks.WEATHERED_COPPER_PILLAR);
    WeatheringCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_PILLAR, SMBBlocks.OXIDIZED_COPPER_PILLAR);
  }

  /**
   * Registers values related to Waxable-like blocks.
   */
  private static void registerWaxableCopperBlocks() {
    WaxableCopperBlockRegistry.register(SMBBlocks.COPPER_BRICKS, SMBBlocks.WAXED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_BRICKS, SMBBlocks.WAXED_EXPOSED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_BRICKS, SMBBlocks.WAXED_WEATHERED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_COPPER_BRICKS, SMBBlocks.WAXED_OXIDIZED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.CRACKED_COPPER_BRICKS, SMBBlocks.WAXED_CRACKED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_COPPER_BRICKS, SMBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_COPPER_BRICKS, SMBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS, SMBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS);
    WaxableCopperBlockRegistry.register(SMBBlocks.CRACKED_CUT_COPPER, SMBBlocks.WAXED_CRACKED_CUT_COPPER);
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_CRACKED_CUT_COPPER, SMBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER);
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_CRACKED_CUT_COPPER, SMBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER);
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_CRACKED_CUT_COPPER, SMBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER);
    WaxableCopperBlockRegistry.register(SMBBlocks.COPPER_PILLAR, SMBBlocks.WAXED_COPPER_PILLAR);
    WaxableCopperBlockRegistry.register(SMBBlocks.EXPOSED_COPPER_PILLAR, SMBBlocks.WAXED_EXPOSED_COPPER_PILLAR);
    WaxableCopperBlockRegistry.register(SMBBlocks.WEATHERED_COPPER_PILLAR, SMBBlocks.WAXED_WEATHERED_COPPER_PILLAR);
    WaxableCopperBlockRegistry.register(SMBBlocks.OXIDIZED_COPPER_PILLAR, SMBBlocks.WAXED_OXIDIZED_COPPER_PILLAR);
  }

  /**
   * Registers values related to Snowy-like blocks.
   */
  private static void registerSnowyBlocks() {
    SnowyBushRegistry.register(Blocks.SHORT_GRASS, SMBBlocks.SHORT_SNOW_GRASS);
    SnowyBushRegistry.register(Blocks.TALL_GRASS, SMBBlocks.TALL_SNOW_GRASS);
    SnowyBushRegistry.register(Blocks.FERN, SMBBlocks.SNOW_FERN);
    SnowyBushRegistry.register(Blocks.LARGE_FERN, SMBBlocks.LARGE_SNOW_FERN);
  }

  /**
   * Registers values related to Carved-like blocks.
   */
  private static void registerCarvedBlocks() {
    /*
     * "SeNiOr" dev: Why don't you use "StrippableBlockRegistry" from Fabric here?!!
     *  - We want to encompass functionality between the two versions and avoid the specific modifications for them.
     *    This makes more sense on 1.21.4 for example where the "Carved Pale Oak" has special functionality.
     * */

    CarvedBlockRegistry.register(Blocks.STRIPPED_OAK_WOOD, SMBBlocks.CARVED_OAK_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_OAK_LOG, SMBBlocks.CARVED_OAK_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_WOOD, SMBBlocks.CARVED_DARK_OAK_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_LOG, SMBBlocks.CARVED_DARK_OAK_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_ACACIA_WOOD, SMBBlocks.CARVED_ACACIA_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_ACACIA_LOG, SMBBlocks.CARVED_ACACIA_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_CHERRY_WOOD, SMBBlocks.CARVED_CHERRY_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_CHERRY_LOG, SMBBlocks.CARVED_CHERRY_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_BIRCH_WOOD, SMBBlocks.CARVED_BIRCH_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_BIRCH_LOG, SMBBlocks.CARVED_BIRCH_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_JUNGLE_WOOD, SMBBlocks.CARVED_JUNGLE_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_JUNGLE_LOG, SMBBlocks.CARVED_JUNGLE_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_SPRUCE_WOOD, SMBBlocks.CARVED_SPRUCE_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_SPRUCE_LOG, SMBBlocks.CARVED_SPRUCE_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_WARPED_STEM, SMBBlocks.CARVED_WARPED_STEM);
    CarvedBlockRegistry.register(Blocks.STRIPPED_WARPED_HYPHAE, SMBBlocks.CARVED_WARPED_HYPHAE);
    CarvedBlockRegistry.register(Blocks.STRIPPED_CRIMSON_STEM, SMBBlocks.CARVED_CRIMSON_STEM);
    CarvedBlockRegistry.register(Blocks.STRIPPED_CRIMSON_HYPHAE, SMBBlocks.CARVED_CRIMSON_HYPHAE);
    CarvedBlockRegistry.register(Blocks.STRIPPED_MANGROVE_WOOD, SMBBlocks.CARVED_MANGROVE_WOOD);
    CarvedBlockRegistry.register(Blocks.STRIPPED_MANGROVE_LOG, SMBBlocks.CARVED_MANGROVE_LOG);
    CarvedBlockRegistry.register(Blocks.STRIPPED_BAMBOO_BLOCK, SMBBlocks.CARVED_BAMBOO_BLOCK);
  }

  /**
   * Registers Fuel values.
   */
  private static void registerFuels() {
    FuelRegistry.INSTANCE.add(SMBItems.COAL_BRICKS, Constants.COAL_BRICKS_FUEL);
    FuelRegistry.INSTANCE.add(SMBItems.CRACKED_COAL_BRICKS, Constants.CRACKED_COAL_BRICKS_FUEL);
    FuelRegistry.INSTANCE.add(SMBItems.COAL_PILLAR, Constants.COAL_PILLAR_FUEL);
    FuelRegistry.INSTANCE.add(SMBItems.CUT_COAL, Constants.CUT_COAL_FUEL);
    FuelRegistry.INSTANCE.add(SMBItems.CRACKED_CUT_COAL, Constants.CRACKED_CUT_COAL_FUEL);
  }

  /**
   * Enabled/Disable Experimental 1.21 Resource Pack.
   * Since the introduction of new Tuff blocks, a new texture with new Vanilla color palette was created.
   * This method should be able to identify worlds with this experimental data pack enabled and apply the Resource Pack.
   */
  private static void enableOrDisableExperimentalResourcePack() {
    if (MOD_CONTAINER.isEmpty()) return;

    // Register as built-in Resource Pack.
    ResourceManagerHelper.registerBuiltinResourcePack(
      OnPlayerJoinOrLeaveWorld.EXPERIMENTAL_1_21_RP,
      MOD_CONTAINER.get(),
      Component.translatable("somemoreblocks.resourcepack.update_1_21.name"),
      ResourcePackActivationType.NORMAL
    );

    ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> OnPlayerJoinOrLeaveWorld.enableResourcePackOnPlayerJoinWorld(handler.getPlayer()));
    ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> OnPlayerJoinOrLeaveWorld.disableResourcePackOnPlayerLeaveWorld(handler.getPlayer()));
  }
}
