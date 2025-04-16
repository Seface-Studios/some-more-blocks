package net.seface.somemoreblocks.platform.registry;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.Constants;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.item.FuelBlockItem;

import java.util.Map;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ForgePlatformRegistry implements PlatformRegistry {
  private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SomeMoreBlocks.ID);
  private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SomeMoreBlocks.ID);
  private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, SomeMoreBlocks.ID);
  private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SomeMoreBlocks.ID);
  private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SomeMoreBlocks.ID);

  /** Forge don't have a Fuel Registry event, so we need to be a little trick here. */
  private static final Map<String, Integer> FUEL_BLOCK_ITEMS = Map.ofEntries(
    Map.entry("coal_bricks", Constants.COAL_BRICKS_FUEL),
    Map.entry("cracked_coal_bricks", Constants.CRACKED_COAL_BRICKS_FUEL),
    Map.entry("coal_pillar", Constants.COAL_PILLAR_FUEL),
    Map.entry("cut_coal", Constants.CUT_COAL_FUEL),
    Map.entry("cracked_cut_coal", Constants.CRACKED_CUT_COAL_FUEL));

  @Override
  public PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    RegistryObject<Block> instance = BLOCKS.register(path, supplier);

    if (registerBlockItem) {
      if (FUEL_BLOCK_ITEMS.containsKey(path)) {
        this.registerItem(path,
          () -> new FuelBlockItem(instance.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS.key(path)), FUEL_BLOCK_ITEMS.get(path)));
      } else {
        this.registerItem(path,
          () -> new BlockItem(instance.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS.key(path))));
      }
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
    RegistryObject<DataComponentType<T>> instance = DATA_COMPONENT_TYPES.register(path,
      () -> builder.apply(DataComponentType.builder()).build());

    return new ForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public <F extends Feature<? extends FeatureConfiguration>> PlatformRegistryObject<F> registerFeature(String path, Supplier<F> supplier) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    RegistryObject<F> instance = FEATURES.register(path, supplier);

    return new ForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public PlatformRegistryObject<CreativeModeTab> registerCreativeModeTab(String path, CreativeModeTab.Row row, int i, UnaryOperator<CreativeModeTab.Builder> builder) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    RegistryObject<CreativeModeTab> instance = CREATIVE_MODE_TABS.register(path,
      () -> builder.apply(CreativeModeTab.builder(row, i)).build());

    return new ForgeRegistryObject<>(identifier, instance);
  }

  public static void init(IEventBus eventBus) {
    BLOCKS.register(eventBus);
    ITEMS.register(eventBus);
    DATA_COMPONENT_TYPES.register(eventBus);
    FEATURES.register(eventBus);
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
