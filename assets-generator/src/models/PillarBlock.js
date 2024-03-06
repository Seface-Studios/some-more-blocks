import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class PillarBlock extends AbstractBlockModel {
  constructor(blockName) {
    super(blockName);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()} = new PillarBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS));`
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

    if(blockName.includes('Snow')) {
      AbstractBlockModel.tags.mineable_shovel.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }

  build() {
    return [
      [
        {
          "parent": "minecraft:block/cube_column",
          "textures": {
            "end": `${this.NAMESPACE}:block/${this.blockId}_top`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '.json'
      ],
      [
        {
          "parent": "minecraft:block/cube_column_horizontal",
          "textures": {
            "end": `${this.NAMESPACE}:block/${this.blockId}_top`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_horizontal.json'
      ]
    ]
  }
  
  buildBlockstate() {
    return [
      {
        "variants": {
          "axis=x": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_horizontal`,
            "x": 90,
            "y": 90
          },
          "axis=y": {
            "model": `${this.NAMESPACE}:block/${this.blockId}`
          },
          "axis=z": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_horizontal`,
            "x": 90
          }
        }
      },
      '.json'
    ]
  }
}