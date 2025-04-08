package net.seface.somemoreblocks.platform.registry;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.material.PushReaction;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface PlatformRegistry {

  /**
   * Main method to register a Block.
   * @param path The identifier path.
   * @param supplier The block supplier.
   * @param registerBlockItem If true, a BlockItem will be auto-registered.
   * @return The registered Block supplier.
   */
  PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem);

  /**
   * Main method to register a Item.
   * @param path The identifier path.
   * @param supplier The Item supplier.
   * @return The registered item supplier.
   */
  PlatformRegistryObject<Item> registerItem(String path, Supplier<Item> supplier);

  /**
   * Main method to register a Data Component Type.
   * @param path The identifier path.
   * @param builder The Data Component Type builder.
   * @return The registered Data Component Type.
   * @param <T> The registered Data Component Type.
   */
  <T> PlatformRegistryObject<DataComponentType<T>> registerDataComponent(String path, UnaryOperator<DataComponentType.Builder<T>> builder);

  /**
   * Main method to register a Feature.
   * @param path The identifier path.
   * @param supplier The Feature supplier.
   * @return The registered Feature.
   */
  PlatformRegistryObject<Feature<?>> registerFeature(String path, Supplier<Feature<?>> supplier);

  /**
   * Main method to configure and registry a Creative Mode Tab.
   * @param path The identifier path.
   * @param row The Tab row. Used only for Minecraft Forge registry.
   * @param i The Tab index. Used only for Minecraft Forge registry.
   * @param builder The Creative Mode Tab builder.
   * @return The registered Creative Mode Tab.
   */
  PlatformRegistryObject<CreativeModeTab> registerCreativeModeTab(String path, CreativeModeTab.Row row, int i, UnaryOperator<CreativeModeTab.Builder> builder);

  /**
   * Main method to register a Block and BlockItem.
   * @param path The identifier path.
   * @param supplier The block supplier.
   * @return The registered block supplier.
   */
  default PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier) {
    return this.registerBlock(path, supplier, true);
  }

  /**
   * Register a Flower Pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @return The registered potted block supplier.
   */
  default PlatformRegistryObject<Block> registerFlowerPotBlock(PlatformRegistryObject<Block> plant) {
    return this.registerFlowerPotBlock(plant, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
  }

  /**
   * Register a Flower Pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @param properties The flower pot block properties.
   * @return The registered potted block supplier.
   */
  default PlatformRegistryObject<Block> registerFlowerPotBlock(PlatformRegistryObject<Block> plant, Block.Properties properties) {
    String path = "potted_" + plant.getPath();
    return this.registerBlock(path,
      () -> new FlowerPotBlock(plant.get(), properties.setId(SomeMoreBlocks.key(Registries.BLOCK, path))), false);
  }
}
