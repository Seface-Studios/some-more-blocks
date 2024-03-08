import { BlockTags } from "../BlockTags.js";
import { Block } from "./Block.js";

export class PillarBlock extends Block {
  constructor(blockName, options) {
    super(blockName, options);
    this.addVariables('RotatedPillarBlock');
  }

  blockModels() {
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
    return {
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
    }
  }
}