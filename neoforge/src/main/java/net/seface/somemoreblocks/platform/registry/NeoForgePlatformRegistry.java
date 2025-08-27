package net.seface.somemoreblocks.platform.registry;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class NeoForgePlatformRegistry implements PlatformRegistry {
  private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SomeMoreBlocks.ID);
  private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SomeMoreBlocks.ID);
  private static final DeferredRegister.DataComponents DATA_COMPONENT_TYPES = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, SomeMoreBlocks.ID);
  private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, SomeMoreBlocks.ID);
  private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SomeMoreBlocks.ID);

  @Override
  public PlatformRegistryObject<Block> registerBlock(String path, Supplier<Block> supplier, boolean registerBlockItem) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    DeferredBlock<Block> instance = BLOCKS.register(path, supplier);

    if (registerBlockItem) {
      this.registerItem(path,
        () -> new BlockItem(instance.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, path))));
    }

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public PlatformRegistryObject<Item> registerItem(String path, Supplier<Item> supplier) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    DeferredItem<Item> instance = ITEMS.register(path, supplier);

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public <T> PlatformRegistryObject<DataComponentType<T>> registerDataComponent(String path, UnaryOperator<DataComponentType.Builder<T>> builder) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    DeferredHolder<DataComponentType<?>, DataComponentType<T>> instance = DATA_COMPONENT_TYPES.register(path,
      () -> builder.apply(DataComponentType.builder()).build());

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public <F extends Feature<? extends FeatureConfiguration>> PlatformRegistryObject<F> registerFeature(String path, Supplier<F> supplier) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    DeferredHolder<Feature<?>, F> instance = FEATURES.register(path, supplier);

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  @Override
  public PlatformRegistryObject<CreativeModeTab> registerCreativeModeTab(String path, CreativeModeTab.Row row, int i, UnaryOperator<CreativeModeTab.Builder> builder) {
    ResourceLocation identifier = SomeMoreBlocks.id(path);
    DeferredHolder<CreativeModeTab, CreativeModeTab> instance = CREATIVE_MODE_TABS.register(path,
      () -> builder.apply(CreativeModeTab.builder(row, i)).build());

    return new NeoForgeRegistryObject<>(identifier, instance);
  }

  public GameRules.Key<GameRules.BooleanValue> registerBooleanGameRule(String id, GameRules.Category category, boolean defaultValue) {
    return GameRules.register(id, category, GameRules.BooleanValue.create(defaultValue));
  }

  @Override
  public void setBlockRenderType(Block block, RenderType renderType) {
    ItemBlockRenderTypes.setRenderLayer(block, renderType);
  }

  public static void init(IEventBus eventBus) {
    BLOCKS.register(eventBus);
    ITEMS.register(eventBus);
    DATA_COMPONENT_TYPES.register(eventBus);
    FEATURES.register(eventBus);
    CREATIVE_MODE_TABS.register(eventBus);
  }
}
