package net.seface.somemoreblocks.platform;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.FabricRegistryObject;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;

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
}
