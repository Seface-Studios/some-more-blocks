import { BlockTags } from "../BlockTags.js";
import { Block } from "./Block.js";

export class FullBlock extends Block {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName, ignoreList, stonecutterOptions);
    this.addVariables('Block');

    if (this.blockName.includes('Mosaic')) {
      BlockTags.tags.planks.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }
}