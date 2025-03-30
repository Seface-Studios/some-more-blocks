package net.seface.somemoreblocks.platform;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.platform.registry.ForgeRegistryObject;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ForgePlatformRegistry implements PlatformRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeMoreBlocks.ID);
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SomeMoreBlocks.ID);
  public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, SomeMoreBlocks.ID);

  @Override
  public PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    RegistryObject<Block> instance = BLOCKS.register(path, supplier);

    if (registerBlockItem) {
      this.registerItem(path,
        () -> new BlockItem(instance.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS.key(path))));
    }

    return new ForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public PlatformRegistryObject<Item> registerItem(String path, Supplier<Item> supplier) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    RegistryObject<Item> instance = ITEMS.register(path, supplier);

    return new ForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public <T> PlatformRegistryObject<DataComponentType<T>> registerDataComponent(String path, UnaryOperator<DataComponentType.Builder<T>> builder) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    RegistryObject<DataComponentType<T>> instance = DATA_COMPONENT_TYPES.register(path, () -> builder.apply(DataComponentType.builder()).build());
    return new ForgeRegistryObject<>(identifier, instance);
  }

  public static void init(IEventBus eventBus) {
    BLOCKS.register(eventBus);
    ITEMS.register(eventBus);
    DATA_COMPONENT_TYPES.register(eventBus);
  }
}
