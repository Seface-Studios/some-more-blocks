import { BlockTags } from "../BlockTags.js";
import { Block } from "./Block.js";

export class FullBlock extends Block {
  constructor(blockName, options) {
    super(blockName, options);
    this.addVariables('Block');

    if (this.isMosaicVariant()) {
      BlockTags.tags.planks.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }

  buildRecipeForCraftingTable() {
    return this.isMosaicVariant() ?
    [
      [
        {
          "type": "minecraft:crafting_shaped",
          "category": "building",
          "key": {
            "#": { "item": `${this.craftingWith}` }
          },
          "pattern": [
            "#",
            "#"
          ],
          "result": {
            "count": 1,
            "item": `${this.NAMESPACE}:${this.blockId}`
          }
        },
        ".json"
      ]
    ] : // else
    super.buildRecipeForCraftingTable();
  }
}