package net.seface.somemoreblocks.datagen.templates;

/**
 * Every utilities class for JSON files generated at somemoreblocks/items
 */
public class SMBItemsTemplates {

/*
  public static void createWaxeableBlockItemModel(Block nonWaxedBlock) {
    ResourceLocation waxedIdentifier = BuiltInRegistries.BLOCK.getKey(nonWaxedBlock).withPrefix("waxed_");

    SMBItemsTemplates.createGenericItemModel(
      nonWaxedBlock,
      ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(nonWaxedBlock)));

    SMBItemsTemplates.createGenericItemModel(
      BuiltInRegistries.BLOCK.getValue(waxedIdentifier),
      ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(nonWaxedBlock)));
  }

  *//**
   * Create a new Item definition for a Wall Block.
   * @param block
   *//*
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

  public static void createGenericItemModel(Item item) {
    SMBModelProvider.ITEM_MODEL_GENERATOR
      .output.accept(item, ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(item)));
  }

  public static void createGenericItemModel(Item item, ItemModel.Unbaked unbaked) {
    SMBModelProvider.ITEM_MODEL_GENERATOR.output.accept(item, unbaked);
  }*/
}
