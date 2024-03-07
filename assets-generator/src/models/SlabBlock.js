import { BlockTags } from "../BlockTags.js";
import { Block } from "./Block.js";

export class SlabBlock extends Block {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName.concat(' Slab'), ignoreList, stonecutterOptions);
    this.addVariables('SlabBlock');

    if ((this.stonecutterOptions.length > 0 || this.isSlab()) && !this.isWood() && !this.ignoredByStonecutter()) {
      this.stonecutterOptions.push(`${this.NAMESPACE}:${this.parentBlockId}`);
    }

    if (blockName.includes('Mosaic')) {
      BlockTags.tags.wooden_slabs.push(`${this.NAMESPACE}:${this.blockId}`);
      return;
    }

    BlockTags.tags.slabs.push(`${this.NAMESPACE}:${this.blockId}`);
  }

  isSlab() { return true; }

  blockModels() {
    return [
      [
        {
          "parent": "minecraft:block/slab",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "side": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "top": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '.json'
      ],
      [
        {
          "parent": "minecraft:block/slab_top",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "side": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "top": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '_top.json'
      ]
    ]
  }
  
  buildBlockstate() {
    return {
      "variants": {
        "type=bottom": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`
        },
        "type=double": {
          "model": `${this.NAMESPACE}:block/${this.parentBlockId}`
        },
        "type=top": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_top`
        }
      }
    }
  }

  buildLootTable() {
    return !this.dropOnlyWithSilkTouch() ?
    [
      {
        "type": "minecraft:block",
        "random_sequence": `${this.NAMESPACE}:blocks/${this.blockId}`,
        "pools": [
          {
            "bonus_rolls": 0.0,
            "entries": [
              {
                "type": "minecraft:item",
                "functions": [
                  {
                    "add": false,
                    "conditions": [
                      {
                        "condition": "minecraft:match_tool",
                        "predicate": {
                          "enchantments": [
                            {
                              "enchantment": "minecraft:silk_touch",
                              "levels": {
                                "min": 1
                              }
                            }
                          ]
                        }
                      },
                      {
                        "block": `${this.NAMESPACE}:${this.blockId}`,
                        "condition": "minecraft:block_state_property",
                        "properties": {
                          "type": "double"
                        }
                      }
                    ],
                    "count": 2.0,
                    "function": "minecraft:set_count"
                  },
                  {
                    "function": "minecraft:explosion_decay"
                  }
                ],
                "name": `${this.NAMESPACE}:${this.blockId}`
              }
            ],
            "rolls": 1.0
          }
        ]
      }
    ] :
    [
      {
        "type": "minecraft:block",
        "random_sequence": `${this.NAMESPACE}:blocks/${this.blockId}`,
        "pools": [
          {
            "bonus_rolls": 0.0,
            "entries": [
              {
                "type": "minecraft:item",
                "functions": [
                  {
                    "add": false,
                    "conditions": [
                      {
                        "condition": "minecraft:match_tool",
                        "predicate": {
                          "enchantments": [
                            {
                              "enchantment": "minecraft:silk_touch",
                              "levels": {
                                "min": 1
                              }
                            }
                          ]
                        }
                      },
                      {
                        "block": `${this.NAMESPACE}:${this.blockId}`,
                        "condition": "minecraft:block_state_property",
                        "properties": {
                          "type": "double"
                        }
                      }
                    ],
                    "count": 2.0,
                    "function": "minecraft:set_count"
                  },
                  {
                    "function": "minecraft:explosion_decay"
                  }
                ],
                "name": `${this.NAMESPACE}:${this.blockId}`
              }
            ],
            "rolls": 1.0
          }
        ]
      }
    ]
  }

  buildRecipeForStonecutter(baseBlockId) {
    return [
      {
        "type": "minecraft:stonecutting",
        "count": 2,
        "ingredient": {
          "item": `${baseBlockId}`
        },

        "result": `${this.NAMESPACE}:${this.blockId}`
      },
      `_from_${SlabBlock.popNamespaceFrom(baseBlockId)}_stonecutting.json`
    ]
  }
}