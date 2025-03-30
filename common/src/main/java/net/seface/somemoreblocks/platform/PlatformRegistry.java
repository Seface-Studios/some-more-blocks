package net.seface.somemoreblocks.platform;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface PlatformRegistry {

  /**
   * Main method to register a custom block.
   * @param path The identifier path.
   * @param supplier The block supplier.
   * @param registerBlockItem If true, a BlockItem will be auto-registered.
   * @return The registered block supplier.
   */
  PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem);


  /**
   * Main method to register a custom item.
   * @param path The identifier path.
   * @param supplier The item supplier.
   * @return The registered item supplier.
   */
  PlatformRegistryObject<Item> registerItem(String path, Supplier<Item> supplier);

  <T> PlatformRegistryObject<DataComponentType<T>> registerDataComponent(String path, UnaryOperator<DataComponentType.Builder<T>> builder);

  /**
   * Main method to register a custom block and BlockItem.
   * @param path The identifier path.
   * @param supplier The block supplier.
   * @return The registered block supplier.
   */
  default PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier) {
    return this.registerBlock(path, supplier, true);
  }
/*
  *//**
   * Register a custom flower pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @return The registered potted block supplier.
   *//*
  default PlatformRegistryObject<Block> registerFlowerPotBlock(Block plant) {
    return this.registerFlowerPotBlock(plant, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
  }

  *//**
   * Register a custom flower pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @param properties The flower pot block properties.
   * @return The registered potted block supplier.
   *//*
  default PlatformRegistryObject<Block> registerFlowerPotBlock(Block plant, Block.Properties properties) {
    return this.registerBlock("potted_" + BuiltInRegistries.BLOCK.getKey(plant).getPath(),
      (props) -> new FlowerPotBlock(plant, props),
      properties, false);
  }*/
}
