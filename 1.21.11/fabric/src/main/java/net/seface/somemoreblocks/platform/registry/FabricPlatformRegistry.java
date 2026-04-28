package net.seface.somemoreblocks.platform.registry;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.seface.somemoreblocks.SomeMoreBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FabricPlatformRegistry implements PlatformRegistry {

  @Override
  public PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem) {
    Identifier identifier = SomeMoreBlocks.id(path);
    Block instance = Registry.register(BuiltInRegistries.BLOCK, identifier, supplier.get());

    if (registerBlockItem) {
      ResourceKey<Item> itemKey = SomeMoreBlocks.key(Registries.ITEM, path);
      this.registerItem(path,
        () -> new BlockItem(instance, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey)));
    }

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public PlatformRegistryObject<Item> registerItem(String path, Supplier<Item> supplier) {
    Identifier identifier = SomeMoreBlocks.id(path);
    Item instance = Registry.register(BuiltInRegistries.ITEM, identifier, supplier.get());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public <T> PlatformRegistryObject<DataComponentType<T>> registerDataComponent(String path, UnaryOperator<DataComponentType.Builder<T>> builder) {
    Identifier identifier = SomeMoreBlocks.id(path);
    DataComponentType<@NotNull T> instance = Registry.register(
      BuiltInRegistries.DATA_COMPONENT_TYPE,
      identifier,
      builder.apply(DataComponentType.builder()).build());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public <F extends Feature<? extends @NotNull FeatureConfiguration>> PlatformRegistryObject<F> registerFeature(String path, Supplier<F> supplier) {
    Identifier identifier = SomeMoreBlocks.id(path);
    F instance = Registry.register(
      BuiltInRegistries.FEATURE,
      SomeMoreBlocks.key(Registries.PLACED_FEATURE, path).identifier(),
      supplier.get());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public PlatformRegistryObject<CreativeModeTab> registerCreativeModeTab(String path, CreativeModeTab.Row _row, int i, UnaryOperator<CreativeModeTab.Builder> builder) {
    Identifier identifier = SomeMoreBlocks.id(i + "_" + path);
    CreativeModeTab instance = Registry.register(
      BuiltInRegistries.CREATIVE_MODE_TAB,
      identifier,
      builder.apply(FabricItemGroup.builder()).build());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public PlatformRegistryObject<GameRule<@NotNull Boolean>> registerBooleanGameRule(String path, GameRuleCategory category, boolean defaultValue) {
    Identifier identifier = SomeMoreBlocks.id(path);
    GameRule<@NotNull Boolean> instance = GameRuleBuilder.forBoolean(defaultValue)
      .category(category)
      .buildAndRegister(SomeMoreBlocks.id(path));

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public void setBlockRenderType(Block block, ChunkSectionLayer renderType) {
    BlockRenderLayerMap.putBlock(block, renderType);
  }

  @Override
  public <T extends Recipe<?>> PlatformRegistryObject<RecipeSerializer<@NotNull T>> registerRecipeType(String path, RecipeSerializer<@NotNull T> serializer) {
    Identifier identifier = SomeMoreBlocks.id(path);
    RecipeSerializer<@NotNull T> instance = Registry.register(
      BuiltInRegistries.RECIPE_SERIALIZER,
      identifier,
      serializer
    );

    return new FabricRegistryObject<>(identifier, () -> instance);
  }
}
