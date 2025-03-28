package net.seface.somemoreblocks.platform;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;
import java.util.function.Supplier;

public interface PlatformRegistry {

  /**
   * Main method to register a custom block.
   * @param path The identifier path.
   * @param factory The block factory.
   * @param properties The block properties.
   * @param registerBlockItem If true, a BlockItem will be auto-registered.
   * @return The registered block supplier.
   */
  Supplier<Block> registerBlock(String path, Function<Block.Properties, Block> factory, Block.Properties properties, boolean registerBlockItem);

  /**
   * Main method to register a custom item.
   * @param path The identifier path.
   * @param factory The item factory.
   * @param properties The item properties.
   * @return The registered item supplier.
   */
  Supplier<Item> registerItem(String path, Function<Item.Properties, Item> factory, Item.Properties properties);

  /**
   * Main method to register a custom block and BlockItem.
   * @param path The identifier path.
   * @param factory The block factory.
   * @param properties The block properties.
   * @return The registered block supplier.
   */
  default Supplier<Block> registerBlock(String path, Function<Block.Properties, Block> factory, Block.Properties properties) {
    return this.registerBlock(path, factory, properties, true);
  }

  /**
   * Register a custom flower pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @return The registered potted block supplier.
   */
  default Supplier<Block> registerFlowerPotBlock(Block plant) {
    return this.registerFlowerPotBlock(plant, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
  }

  /**
   * Register a custom flower pot block for specific plant with default BlockProperties.
   * @param plant The plant to be potted.
   * @param properties The flower pot block properties.
   * @return The registered potted block supplier.
   */
  default Supplier<Block> registerFlowerPotBlock(Block plant, Block.Properties properties) {
    return this.registerBlock("potted_" + BuiltInRegistries.BLOCK.getKey(plant).getPath(),
      (props) -> new FlowerPotBlock(plant, props),
      properties, false);
  }
}
