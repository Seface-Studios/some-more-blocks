import { BlockTags } from "../BlockTags.js";
import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class FullBlock extends AbstractBlockModel {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName, ignoreList, stonecutterOptions);
    this.addVariables('Block');

    if (this.blockName.includes('Mosaic')) {
      BlockTags.tags.planks.push(`${this.NAMESPACE}:${this.blockId}`);
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