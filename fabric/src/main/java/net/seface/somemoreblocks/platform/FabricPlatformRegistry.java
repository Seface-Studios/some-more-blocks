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
    ResourceKey<Block> key = SomeMoreBlocks.key(Registries.BLOCK, path);
    Block instance = Blocks.register(key, factory, properties);

    if (registerBlockItem) {
      Items.registerBlock(instance);
    }

    return () -> instance;
  }

  @Override
  public Supplier<Item> registerItem(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
    ResourceKey<Item> key = SomeMoreBlocks.key(Registries.ITEM, path);
    Item instance = Items.registerItem(key, factory, properties);

    return () -> instance;
  }
}
