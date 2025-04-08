package net.seface.somemoreblocks.datagen.templates;

import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.seface.somemoreblocks.datagen.providers.SMBModelProvider;
import net.seface.somemoreblocks.item.properties.numeric.BucketVolumeProperty;
import net.seface.somemoreblocks.item.properties.numeric.MoonPhaseProperty;

/**
 * Every utilities class for JSON files generated at somemoreblocks/items
 */
public class SMBItemsTemplates {

  public static void createCarvedBlockItemModel(Block item) {
    ResourceLocation identifier = ModelLocationUtils.getModelLocation(item);

    ItemModel.Unbaked fullMoon = ItemModelUtils.plainModel(identifier.withSuffix("_0"));
    ItemModel.Unbaked waningGibbous = ItemModelUtils.plainModel(identifier.withSuffix("_1"));
    ItemModel.Unbaked lastQuarter = ItemModelUtils.plainModel(identifier.withSuffix("_2"));
    ItemModel.Unbaked waningCrescent = ItemModelUtils.plainModel(identifier.withSuffix("_3"));
    ItemModel.Unbaked newMoon = ItemModelUtils.plainModel(identifier.withSuffix("_4"));
    ItemModel.Unbaked waxingCrescent = ItemModelUtils.plainModel(identifier.withSuffix("_5"));
    ItemModel.Unbaked firstQuarter = ItemModelUtils.plainModel(identifier.withSuffix("_6"));
    ItemModel.Unbaked waxingGibbous = ItemModelUtils.plainModel(identifier.withSuffix("_7"));

    SMBModelProvider.ITEM_MODEL_GENERATOR.itemModelOutput.accept(
      item.asItem(), ItemModelUtils.rangeSelect(new MoonPhaseProperty(), fullMoon,
        ItemModelUtils.override(fullMoon, 0),
        ItemModelUtils.override(waningGibbous, 1),
        ItemModelUtils.override(lastQuarter, 2),
        ItemModelUtils.override(waningCrescent, 3),
        ItemModelUtils.override(newMoon, 4),
        ItemModelUtils.override(waxingCrescent, 5),
        ItemModelUtils.override(firstQuarter, 6),
        ItemModelUtils.override(waxingGibbous, 7)));
  }

  /**
   * Create a new Item definition for a Wall Block.
   * @param block
   */
  public static void createWallBlockItemModel(Block block) {
    createGenericItemModel(
      block, ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block).withSuffix("_inventory")));
  }

  public static void createGenericItemModel(Block block) {
    createGenericItemModel(
      block, ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(block.asItem())));
  }

  public static void createGenericItemModel(Block block, ItemModel.Unbaked unbaked) {
    createGenericItemModel(block.asItem(), unbaked);
  }


  public static void createGenericItemModel(Item item, ItemModel.Unbaked unbaked) {
    SMBModelProvider.ITEM_MODEL_GENERATOR
      .itemModelOutput.accept(item, unbaked);
  }
}
