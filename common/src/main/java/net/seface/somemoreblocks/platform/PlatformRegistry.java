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
  Supplier<Block> registerBlock(String path, Function<Block.Properties, Block> factory, Block.Properties properties, boolean registerBlockItem);
  Supplier<Item> registerItem(String path, Function<Item.Properties, Item> factory, Item.Properties properties);

  default Supplier<Block> registerBlock(String path, Function<Block.Properties, Block> factory, Block.Properties properties) {
    return this.registerBlock(path, factory, properties, true);
  }

  default Supplier<Block> registerFlowerPotBlock(Block plant) {
    return this.registerFlowerPotBlock(plant, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
  }

  default Supplier<Block> registerFlowerPotBlock(Block plant, Block.Properties properties) {
    return this.registerBlock("potted_" + BuiltInRegistries.BLOCK.getKey(plant).getPath(),
      (props) -> new FlowerPotBlock(plant, props),
      properties, false);
  }
}
