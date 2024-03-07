import { BlockTags } from "../BlockTags.js";
import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class LogBlock extends AbstractBlockModel {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName, ignoreList, stonecutterOptions);
    this.addVariables('RotatedPillarBlock');

    BlockTags.tags.logs.push(`${this.NAMESPACE}:${this.blockId}`);
  }

  build() {
    const topTexture = this.blockId.replace('carved', 'stripped')

    return [
      [
        {
          "parent": "minecraft:block/cube_column",
          "textures": {
            "end": `minecraft:block/${topTexture}_top`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '.json'
      ],
      [
        {
          "parent": "minecraft:block/cube_column_horizontal",
          "textures": {
            "end": `minecraft:block/${topTexture}_top`,
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
      }
    ]
  }
}