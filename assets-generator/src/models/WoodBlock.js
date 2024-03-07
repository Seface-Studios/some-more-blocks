import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class WoodBlock extends AbstractBlockModel {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName, ignoreList, stonecutterOptions);

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
    AbstractBlockModel.tags.logs.push(`${this.NAMESPACE}:${this.blockId}`);
  }

  build() {
    const _id = this.blockId.replace('wood', 'log').replace('hyphae', 'stem');
    return [
      [
        {
          "parent": "minecraft:block/cube_column",
          "textures": {
            "end": `${this.NAMESPACE}:block/${_id}`,
            "side": `${this.NAMESPACE}:block/${_id}`
          }
        },
        '.json'
      ]
    ]
  }
  
  buildBlockstate() {
    return [
      {
        "variants": {
          "axis=x": {
            "model": `${this.NAMESPACE}:block/${this.blockId}`,
            "x": 90,
            "y": 90
          },
          "axis=y": {
            "model": `${this.NAMESPACE}:block/${this.blockId}`
          },
          "axis=z": {
            "model": `${this.NAMESPACE}:block/${this.blockId}`,
            "x": 90
          }
        }
      }
    ]
  }
}