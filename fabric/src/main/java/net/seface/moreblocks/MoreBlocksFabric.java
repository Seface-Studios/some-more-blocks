package net.seface.moreblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.LandPathNodeTypesRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.seface.moreblocks.registry.*;
import net.seface.moreblocks.utils.MBUtils;
import net.seface.moreblocks.registry.MBFeatures;
import net.seface.moreblocks.utils.ResourcePackManager;
import net.seface.moreblocks.worldgen.MBBiomeModifiers;

import java.util.Optional;

public class MoreBlocksFabric implements ModInitializer {
  private static final Optional<ModContainer> MOD_CONTAINER = FabricLoader.getInstance().getModContainer(MoreBlocks.ID);
  private static final ResourceLocation EXPERIMENTAL_1_21_RP = new ResourceLocation(MoreBlocks.ID, "update_1_21");

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
    MBUtils.registerSnowVariationBlock(Blocks.LARGE_FERN, MBBlocks.LARGE_SNOW_FERN);
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
      EXPERIMENTAL_1_21_RP,
      MOD_CONTAINER.get(),
      Component.translatable("moreblocks.resourcepack.update_1_21.name"),
      ResourcePackActivationType.NORMAL
    );

    ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
      ServerPlayer player = handler.getPlayer();
      if (!server.getWorldData().enabledFeatures().contains(FeatureFlags.UPDATE_1_21)) return;

      String tagID = new ResourceLocation(MoreBlocks.ID, "hide_update_1_21_message").toString();
      ResourcePackManager.enableResourcePack(EXPERIMENTAL_1_21_RP);

      if (player.getTags().contains(tagID)) return;

      MutableComponent prefix = Component.literal(MoreBlocks.MOD_NAME).withColor(MoreBlocks.AMESFACE_COLOR)
        .append(Component.literal(" › ").withStyle(ChatFormatting.GRAY));

      String readMoreURL = "https://github.com/Seface-Studios/more-blocks-mod/tree/main/common/src/main/resources/resourcepacks";
      HoverEvent readMoreHover = new HoverEvent(
        HoverEvent.Action.SHOW_TEXT,
        Component.translatable("moreblocks.resourcepack.update_1_21.read_more.hover"));

      MutableComponent message = Component.translatable("moreblocks.resourcepack.update_1_21.enabled")
        .withStyle(style -> style.withColor(ChatFormatting.GRAY))
        .append(" ")
        .append(Component.translatable("moreblocks.resourcepack.update_1_21.read_more")
          .withColor(MoreBlocks.GREENFUL_COLOR)
          .withStyle(style ->
            style.withHoverEvent(readMoreHover)
                 .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, readMoreURL))
                 .withUnderlined(true)));

      message = prefix.append(message);
      player.sendSystemMessage(message);
      player.getTags().add(tagID);
    });

    ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
      if (!server.getWorldData().enabledFeatures().contains(FeatureFlags.UPDATE_1_21)) return;
      ResourcePackManager.disableResourcePack(EXPERIMENTAL_1_21_RP);
    });
  }
}
