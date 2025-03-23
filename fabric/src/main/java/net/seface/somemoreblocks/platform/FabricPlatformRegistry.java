package net.seface.somemoreblocks.platform;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.function.Function;
import java.util.function.Supplier;

public class FabricPlatformRegistry implements PlatformRegistry {

  @Override
  public Supplier<Block> registerBlock(String path, Function<Block.Properties, Block> factory, Block.Properties properties, boolean registerBlockItem) {
    ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, path);
    ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, identifier);

    Block instance = Blocks.register(key, factory, properties);

    SomeMoreBlocks.LOGGER.info(instance.getDescriptionId() + " registered.");
    if (registerBlockItem) {
      Items.registerBlock(instance);
    }

    return () -> instance;
  }

  @Override
  public Supplier<Item> registerItem(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
    ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, path);
    ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, identifier);

    return () -> Items.registerItem(key, factory, properties);
  }
}
