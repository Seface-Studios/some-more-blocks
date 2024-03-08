import { BlockTags } from "../BlockTags.js";
import { Block } from "./Block.js";

export class FullBlock extends Block {
  constructor(blockName, options) {
    super(blockName, options);
    this.addVariables('Block');

    if (this.blockName.includes('Mosaic')) {
      BlockTags.tags.planks.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }
}