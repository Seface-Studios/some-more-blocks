package net.seface.somemoreblocks.platform.registry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.material.PushReaction;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.item.LeavesBucketItem;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public interface PlatformRegistry {

  /**
   * Main method to register a Block.
   * @param path The identifier path.
   * @param supplier The block supplier.
   * @param registerBlockItem If true, a BlockItem will be auto-registered.
   * @return The registered Block.
   */
  PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem);

  /**
   * Main method to register an Item.
   * @param path The identifier path.
   * @param supplier The Item supplier.
   * @return The registered item.
   */
  PlatformRegistryObject<Item> registerItem(String path, Supplier<Item> supplier);

  /**
   * Register a model predicate.
   */
  default void registerModelPredicate(Item item, String path) {
    // register method via Access Widener
    ItemProperties.register(
      item, SomeMoreBlocks.id(path),
      (stack, world, entity, seed) ->  stack.getItem() instanceof LeavesBucketItem
        ? (float) LeavesBucketItem.getBucketVolume(stack) / 100.0F
        : 0.01F
    );
  }

  /**
   * Main method to register a Feature.
   * @param path The identifier path.
   * @param supplier The Feature supplier.
   * @return The registered Feature.
   */
  <F extends Feature<? extends FeatureConfiguration>> PlatformRegistryObject<F> registerFeature(String path, Supplier<F> supplier);

  /**
   * Main method to configure and registry a Creative Mode Tab.
   * @param path The identifier path.
   * @param row The Tab row. Used only for Minecraft Forge registry.
   * @param i The Tab index. Used only for Minecraft Forge registry.
   * @param builder The Creative Mode Tab builder.
   * @return The registered Creative Mode Tab.
   */
  PlatformRegistryObject<CreativeModeTab> registerCreativeModeTab(String path, CreativeModeTab.Row row, int i, UnaryOperator<CreativeModeTab.Builder> builder);

  <T extends GameRules.Value<T>> GameRules.Key<T> registerGameRule(String id, GameRules.Category category, GameRules.Type<T> type);

  /**
   * Main method to set the render type for a block.
   * @param block The block to be configured.
   * @param renderType The render type.
   */
  void setBlockRenderType(Block block, RenderType renderType);

  /**
   * Main method to register a Block and BlockItem.
   * @param path The identifier path.
   * @param supplier The block supplier.
   * @return The registered block.
   */
  default PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier) {
    return this.registerBlock(path, supplier, true);
  }

  /**
   * Register a Flower Pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @return The registered potted block.
   */
  default PlatformRegistryObject<Block> registerFlowerPotBlock(PlatformRegistryObject<Block> plant) {
    return this.registerFlowerPotBlock(plant, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
  }

  /**
   * Register a Flower Pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @param properties The flower pot block properties.
   * @return The registered potted block.
   */
  default PlatformRegistryObject<Block> registerFlowerPotBlock(PlatformRegistryObject<Block> plant, Block.Properties properties) {
    String path = "potted_" + plant.getPath();
    return this.registerBlock(path,
      () -> new FlowerPotBlock(plant.get(), properties), false);
  }
}
