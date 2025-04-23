package net.seface.somemoreblocks.platform.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FabricPlatformRegistry implements PlatformRegistry {

  @Override
  public PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
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
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    Item instance = Registry.register(BuiltInRegistries.ITEM, identifier, supplier.get());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public <T> PlatformRegistryObject<DataComponentType<T>> registerDataComponent(String path, UnaryOperator<DataComponentType.Builder<T>> builder) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    DataComponentType<T> instance = Registry.register(
      BuiltInRegistries.DATA_COMPONENT_TYPE,
      identifier,
      builder.apply(DataComponentType.builder()).build());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public <F extends Feature<? extends FeatureConfiguration>> PlatformRegistryObject<F> registerFeature(String path, Supplier<F> supplier) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    F instance = Registry.register(
      BuiltInRegistries.FEATURE,
      SomeMoreBlocks.key(Registries.PLACED_FEATURE, path).location(),
      supplier.get());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public PlatformRegistryObject<CreativeModeTab> registerCreativeModeTab(String path, CreativeModeTab.Row _row, int i, UnaryOperator<CreativeModeTab.Builder> builder) {
    ResourceLocation identifier = SomeMoreBlocks.id(i + "_" + path);
    CreativeModeTab instance = Registry.register(
      BuiltInRegistries.CREATIVE_MODE_TAB,
      identifier,
      builder.apply(FabricItemGroup.builder()).build());

    return new FabricRegistryObject<>(identifier, () -> instance);
  }

  @Override
  public void setBlockRenderType(Block block, RenderType renderType) {
    BlockRenderLayerMap.INSTANCE.putBlock(block, renderType);
  }
}
