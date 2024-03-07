import { Block } from "./Block.js";
import { BlockTags } from "../BlockTags.js";

export class WoodBlock extends Block {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName, ignoreList, stonecutterOptions);
    this.addVariables('RotatedPillarBlock');

    BlockTags.tags.logs.push(`${this.NAMESPACE}:${this.blockId}`);
  }

  blockModels() {
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
    return {
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
  }
}