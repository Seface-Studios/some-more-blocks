package net.seface.somemoreblocks.platform.registry;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.serialization.Codec;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gamerules.*;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.recipe.CarvedPaleOakWoodCraftingRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class NeoForgePlatformRegistry implements PlatformRegistry {
  private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SomeMoreBlocks.ID);
  private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SomeMoreBlocks.ID);
  private static final DeferredRegister.DataComponents DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, SomeMoreBlocks.ID);
  private static final DeferredRegister<@NotNull Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, SomeMoreBlocks.ID);
  private static final DeferredRegister<@NotNull CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SomeMoreBlocks.ID);
  private static final DeferredRegister<@NotNull GameRule<?>> GAME_RULES = DeferredRegister.create(Registries.GAME_RULE, SomeMoreBlocks.ID);
  private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, SomeMoreBlocks.ID);


  @Override
  public PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem) {
    Identifier identifier = SomeMoreBlocks.id(path);
    DeferredBlock<@NotNull Block> instance = BLOCKS.register(path, supplier);

    if (registerBlockItem) {
      this.registerItem(path,
        () -> new BlockItem(instance.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, path))));
    }

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public PlatformRegistryObject<Item> registerItem(String path, Supplier<Item> supplier) {
    Identifier identifier = SomeMoreBlocks.id(path);
    DeferredItem<@NotNull Item> instance = ITEMS.register(path, supplier);

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public <T> PlatformRegistryObject<DataComponentType<@NotNull T>> registerDataComponent(String path, UnaryOperator<DataComponentType.Builder<@NotNull T>> builder) {
    Identifier identifier = SomeMoreBlocks.id(path);
    DeferredHolder<@NotNull DataComponentType<?>, @NotNull DataComponentType<@NotNull T>> instance = DATA_COMPONENT_TYPES.register(path,
      () -> builder.apply(DataComponentType.builder()).build());

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public <F extends Feature<? extends @NotNull FeatureConfiguration>> PlatformRegistryObject<F> registerFeature(String path, Supplier<F> supplier) {
    Identifier identifier = SomeMoreBlocks.id(path);
    DeferredHolder<@NotNull  Feature<?>, @NotNull F> instance = FEATURES.register(path, supplier);

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public PlatformRegistryObject<CreativeModeTab> registerCreativeModeTab(String path, CreativeModeTab.Row row, int i, UnaryOperator<CreativeModeTab.Builder> builder) {
    Identifier identifier = SomeMoreBlocks.id(path);
    DeferredHolder<@NotNull  CreativeModeTab, @NotNull  CreativeModeTab> instance = CREATIVE_MODE_TABS.register(path,
      () -> builder.apply(CreativeModeTab.builder(row, i)).build());

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public PlatformRegistryObject<GameRule<@NotNull Boolean>> registerBooleanGameRule(String path, GameRuleCategory category, boolean defaultValue) {
    Identifier identifier = SomeMoreBlocks.id(path);

    DeferredHolder<@NotNull GameRule<?>, @NotNull GameRule<@NotNull Boolean>> instance = GAME_RULES.register(path,
      () -> new GameRule<>(
        category,
        GameRuleType.BOOL,
        BoolArgumentType.bool(),
        GameRuleTypeVisitor::visitBoolean,
        Codec.BOOL,
        bool -> bool ? 1 : 0,
        defaultValue,
        FeatureFlagSet.of()
      ));

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public void setBlockRenderType(Block block, ChunkSectionLayer renderType) {
    ItemBlockRenderTypes.setRenderLayer(block, renderType);
  }

  @Override
  public <T extends Recipe<?>> PlatformRegistryObject<RecipeSerializer<@NotNull T>> registerRecipeType(String path, RecipeSerializer<@NotNull T> serializer) {
    Identifier identifier = SomeMoreBlocks.id(path);
    DeferredHolder<@NotNull RecipeSerializer<?>, @NotNull RecipeSerializer<@NotNull T>> instance = RECIPE_SERIALIZERS.register(path, () -> serializer);

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  public static void init(IEventBus eventBus) {
    BLOCKS.register(eventBus);
    ITEMS.register(eventBus);
    DATA_COMPONENT_TYPES.register(eventBus);
    FEATURES.register(eventBus);
    CREATIVE_MODE_TABS.register(eventBus);
    GAME_RULES.register(eventBus);
    RECIPE_SERIALIZERS.register(eventBus);
  }
}
