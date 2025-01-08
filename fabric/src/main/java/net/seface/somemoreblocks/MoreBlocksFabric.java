package net.seface.somemoreblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.seface.somemoreblocks.event.OnPlayerJoinOrLeaveWorld;
import net.seface.somemoreblocks.registry.*;
import net.seface.somemoreblocks.utils.MBUtils;
import net.seface.somemoreblocks.registry.MBFeatures;
import net.seface.somemoreblocks.utils.ResourcePackManager;
import net.seface.somemoreblocks.worldgen.MBBiomeModifiers;

import java.util.Optional;

public class MoreBlocksFabric implements ModInitializer {
  private static final Optional<ModContainer> MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MoreBlocks.ID);

  @Override
  public void onInitialize() {
    MoreBlocks.init();
    MBItems.register();
    MBBlocks.register();
    MBItemGroups.register();
    MBFeatures.register();
    MBBiomeModifiers.register();

    LandPathNodeTypesRegistry.register(MBBlocks.TINY_CACTUS, (state, neighbor) -> BlockPathTypes.DAMAGE_OTHER);

    enableOrDisableExperimentalResourcePack();

    registerCompostableItems();
    registerWeatheringCopperBlocks();
    registerWaxableCopperBlocks();
    registerFuels();
    registerSnowyBlocks();
    registerStrippableBlocks();
  }

  /**
   * Register new compostable items into composter block.
   */
  private static void registerCompostableItems() {
    MBUtils.registerCompostableItem(0.3F, MBItems.TINY_CACTUS);
    MBUtils.registerCompostableItem(0.3F, MBItems.DUNE_GRASS);
    MBUtils.registerCompostableItem(0.5F, MBItems.TALL_DUNE_GRASS);
    MBUtils.registerCompostableItem(0.5F, MBItems.TALL_DUNE_GRASS);
    MBUtils.registerCompostableItem(0.3F, MBItems.SHORT_SNOW_GRASS);
    MBUtils.registerCompostableItem(0.65F, MBItems.TALL_SNOW_GRASS);
    MBUtils.registerCompostableItem(0.65F, MBItems.SNOW_FERN);
    MBUtils.registerCompostableItem(0.65F, MBItems.LARGE_SNOW_FERN);
    MBUtils.registerCompostableItem(0.65F, MBItems.CATTAIL);
    MBUtils.registerCompostableItem(0.65F, MBItems.LUMINOUS_FLOWER);
    MBUtils.registerCompostableItem(0.85F, MBItems.BROWN_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_BROWN_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(0.85F, MBItems.RED_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_RED_MUSHROOM_COLONY);
    MBUtils.registerCompostableItem(0.85F, MBItems.CRIMSON_FUNGUS_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_CRIMSON_FUNGUS_COLONY);
    MBUtils.registerCompostableItem(0.85F, MBItems.WARPED_FUNGUS_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.TALL_WARPED_FUNGUS_COLONY);
    MBUtils.registerCompostableItem(1.0F, MBItems.LEAVES_BUCKET);
    MBUtils.registerCompostableItem(1.0F, MBItems.AZALEA_LEAVES_BUCKET);
    MBUtils.registerCompostableItem(1.0F, MBItems.BIRCH_LEAVES_BUCKET);
    MBUtils.registerCompostableItem(1.0F, MBItems.FLOWERING_AZALEA_LEAVES_BUCKET);
    MBUtils.registerCompostableItem(1.0F, MBItems.SPRUCE_LEAVES_BUCKET);
  }

  /**
   * Register new weathering copper blocks.
   */
  private static void registerWeatheringCopperBlocks() {
    MBUtils.registerWeatheringCopperBlock(MBBlocks.COPPER_BRICKS, MBBlocks.EXPOSED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_COPPER_BRICKS, MBBlocks.WEATHERED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_COPPER_BRICKS, MBBlocks.OXIDIZED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.CRACKED_COPPER_BRICKS, MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS, MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS, MBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.CRACKED_CUT_COPPER, MBBlocks.EXPOSED_CRACKED_CUT_COPPER);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_CRACKED_CUT_COPPER, MBBlocks.WEATHERED_CRACKED_CUT_COPPER);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_CRACKED_CUT_COPPER, MBBlocks.OXIDIZED_CRACKED_CUT_COPPER);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.COPPER_PILLAR, MBBlocks.EXPOSED_COPPER_PILLAR);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.EXPOSED_COPPER_PILLAR, MBBlocks.WEATHERED_COPPER_PILLAR);
    MBUtils.registerWeatheringCopperBlock(MBBlocks.WEATHERED_COPPER_PILLAR, MBBlocks.OXIDIZED_COPPER_PILLAR);
  }

  /**
   * Register new waxable copper blocks.
   */
  private static void registerWaxableCopperBlocks() {
    MBUtils.registerWaxableCopperBlock(MBBlocks.COPPER_BRICKS, MBBlocks.WAXED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_COPPER_BRICKS, MBBlocks.WAXED_EXPOSED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_COPPER_BRICKS, MBBlocks.WAXED_WEATHERED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_COPPER_BRICKS, MBBlocks.WAXED_OXIDIZED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.CRACKED_COPPER_BRICKS, MBBlocks.WAXED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_CRACKED_COPPER_BRICKS, MBBlocks.WAXED_EXPOSED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_CRACKED_COPPER_BRICKS, MBBlocks.WAXED_WEATHERED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_CRACKED_COPPER_BRICKS, MBBlocks.WAXED_OXIDIZED_CRACKED_COPPER_BRICKS);
    MBUtils.registerWaxableCopperBlock(MBBlocks.CRACKED_CUT_COPPER, MBBlocks.WAXED_CRACKED_CUT_COPPER);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_CRACKED_CUT_COPPER, MBBlocks.WAXED_EXPOSED_CRACKED_CUT_COPPER);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_CRACKED_CUT_COPPER, MBBlocks.WAXED_WEATHERED_CRACKED_CUT_COPPER);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_CRACKED_CUT_COPPER, MBBlocks.WAXED_OXIDIZED_CRACKED_CUT_COPPER);
    MBUtils.registerWaxableCopperBlock(MBBlocks.COPPER_PILLAR, MBBlocks.WAXED_COPPER_PILLAR);
    MBUtils.registerWaxableCopperBlock(MBBlocks.EXPOSED_COPPER_PILLAR, MBBlocks.WAXED_EXPOSED_COPPER_PILLAR);
    MBUtils.registerWaxableCopperBlock(MBBlocks.WEATHERED_COPPER_PILLAR, MBBlocks.WAXED_WEATHERED_COPPER_PILLAR);
    MBUtils.registerWaxableCopperBlock(MBBlocks.OXIDIZED_COPPER_PILLAR, MBBlocks.WAXED_OXIDIZED_COPPER_PILLAR);
  }

  /**
   * Register new snow variation of some plants.
   */
  private static void registerSnowyBlocks() {
    MBUtils.registerSnowVariationBlock(Blocks.SHORT_GRASS, MBBlocks.SHORT_SNOW_GRASS);
    MBUtils.registerSnowVariationBlock(Blocks.TALL_GRASS, MBBlocks.TALL_SNOW_GRASS);
    MBUtils.registerSnowVariationBlock(Blocks.FERN, MBBlocks.SNOW_FERN);
  }

  private static void registerStrippableBlocks() {
    StrippableBlockRegistry.register(Blocks.STRIPPED_OAK_WOOD, MBBlocks.CARVED_OAK_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_OAK_LOG, MBBlocks.CARVED_OAK_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_WOOD, MBBlocks.CARVED_DARK_OAK_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_DARK_OAK_LOG, MBBlocks.CARVED_DARK_OAK_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_ACACIA_WOOD, MBBlocks.CARVED_ACACIA_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_ACACIA_LOG, MBBlocks.CARVED_ACACIA_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_CHERRY_WOOD, MBBlocks.CARVED_CHERRY_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_CHERRY_LOG, MBBlocks.CARVED_CHERRY_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_BIRCH_WOOD, MBBlocks.CARVED_BIRCH_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_BIRCH_LOG, MBBlocks.CARVED_BIRCH_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_JUNGLE_WOOD, MBBlocks.CARVED_JUNGLE_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_JUNGLE_LOG, MBBlocks.CARVED_JUNGLE_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_SPRUCE_WOOD, MBBlocks.CARVED_SPRUCE_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_SPRUCE_LOG, MBBlocks.CARVED_SPRUCE_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_WARPED_STEM, MBBlocks.CARVED_WARPED_STEM);
    StrippableBlockRegistry.register(Blocks.STRIPPED_WARPED_HYPHAE, MBBlocks.CARVED_WARPED_HYPHAE);
    StrippableBlockRegistry.register(Blocks.STRIPPED_CRIMSON_STEM, MBBlocks.CARVED_CRIMSON_STEM);
    StrippableBlockRegistry.register(Blocks.STRIPPED_CRIMSON_HYPHAE, MBBlocks.CARVED_CRIMSON_HYPHAE);
    StrippableBlockRegistry.register(Blocks.STRIPPED_MANGROVE_WOOD, MBBlocks.CARVED_MANGROVE_WOOD);
    StrippableBlockRegistry.register(Blocks.STRIPPED_MANGROVE_LOG, MBBlocks.CARVED_MANGROVE_LOG);
    StrippableBlockRegistry.register(Blocks.STRIPPED_BAMBOO_BLOCK, MBBlocks.CARVED_BAMBOO_BLOCK);
  }

  /**
   * Register new fuels.
   */
  private static void registerFuels() {
    FuelRegistry.INSTANCE.add(MBItems.COAL_BRICKS, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) * 2);
    FuelRegistry.INSTANCE.add(MBItems.CRACKED_COAL_BRICKS, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) + 3200);
    FuelRegistry.INSTANCE.add(MBItems.COAL_PILLAR, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK));
    FuelRegistry.INSTANCE.add(MBItems.CUT_COAL, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) * 3);
    FuelRegistry.INSTANCE.add(MBItems.CRACKED_CUT_COAL, FuelRegistry.INSTANCE.get(Blocks.COAL_BLOCK) + 3200);
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
