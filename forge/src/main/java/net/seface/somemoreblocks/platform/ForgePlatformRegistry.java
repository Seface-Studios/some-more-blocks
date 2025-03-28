package net.seface.somemoreblocks.platform;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.function.Function;
import java.util.function.Supplier;

public class ForgePlatformRegistry implements PlatformRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeMoreBlocks.ID);
  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SomeMoreBlocks.ID);

  @Override
  public Supplier<Block> registerBlock(String path, Function<Block.Properties, Block> factory, Block.Properties properties, boolean registerBlockItem) {
    RegistryObject<Block> instance = ForgePlatformRegistry.BLOCKS.register(path, () -> factory.apply(properties.setId(BLOCKS.key(path))));

    if (registerBlockItem) {
      Item.Properties itemProperties = new Item.Properties().useBlockDescriptionPrefix();
      this.registerItem(path, (props) -> new BlockItem(instance.get(), itemProperties), itemProperties);
    }

    return instance;
  }

  @Override
  public Supplier<Item> registerItem(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
    RegistryObject<Item> instance = ForgePlatformRegistry.ITEMS.register(path, () -> factory.apply(properties.setId(ITEMS.key(path))));

    return instance;
  }

  public static void init(IEventBus event) {
    ForgePlatformRegistry.BLOCKS.register(event);
    ForgePlatformRegistry.ITEMS.register(event);
  }
}
