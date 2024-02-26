import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class FullBlock extends AbstractBlockModel {
  constructor(blockName) {
    super(blockName);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()} = new Block(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS));`
    );
    AbstractBlockModel.itemBlockVariables.push(
      `public static final Item ${this.blockId.toUpperCase()} = new BlockItem(MBBlocks.${this.blockId.toUpperCase()}, new Item.Settings());`
    );

    AbstractBlockModel.registerBlockList.push(
      `Registry.register(Registries.BLOCK, new Identifier(MoreBlocks.ID, "${this.blockId}"), ${this.blockId.toUpperCase()});`
    );
    AbstractBlockModel.registerItemBlockList.push(
      `Registry.register(Registries.ITEM, new Identifier(MoreBlocks.ID, "${this.blockId}"), ${this.blockId.toUpperCase()});`
    );

    AbstractBlockModel.language[`block.${this.NAMESPACE}.${this.blockId}`] = this.blockName;

    if (this.blockName.includes('Mosaic')) {
      AbstractBlockModel.tags.planks.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }

  build() {
    return [
      [
        {
          "parent": "minecraft:block/cube_all",
          "textures": { "all": `${this.NAMESPACE}:block/${this.blockId}` }
        },
        '.json'
      ]
    ]
  }
}