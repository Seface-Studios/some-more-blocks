import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class SlabBlock extends AbstractBlockModel {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName, ignoreList, stonecutterOptions);
    
    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()}_SLAB = new SlabBlock(FabricBlockSettings.copyOf(MBBlocks.${this.blockId.toUpperCase()}));`
    );
    AbstractBlockModel.itemBlockVariables.push(
      `public static final Item ${this.blockId.toUpperCase()}_SLAB = new BlockItem(MBBlocks.${this.blockId.toUpperCase()}_SLAB, new Item.Settings());`
    );

    AbstractBlockModel.registerBlockList.push(
      `Registry.register(Registries.BLOCK, new Identifier(MoreBlocks.ID, "${this.blockId}_slab"), ${this.blockId.toUpperCase()}_SLAB);`
    );
    AbstractBlockModel.registerItemBlockList.push(
      `Registry.register(Registries.ITEM, new Identifier(MoreBlocks.ID, "${this.blockId}_slab"), ${this.blockId.toUpperCase()}_SLAB);`
    );

    AbstractBlockModel.language[`block.${this.NAMESPACE}.${this.blockId}_slab`] = this.blockName.concat(' Slab');

    if (this.stonecutterOptions.length > 0) {
      this.stonecutterOptions.push(`${this.NAMESPACE}:${this.blockId}`);
    }

    if (blockName.includes('Mosaic')) {
      AbstractBlockModel.tags.wooden_slabs.push(`${this.NAMESPACE}:${this.blockId}_slab`);
      return;
    }

    AbstractBlockModel.tags.slabs.push(`${this.NAMESPACE}:${this.blockId}_slab`);

    if (!blockName.includes('Snow')) {
      AbstractBlockModel.tags.mineable_pickaxe.push(`${this.NAMESPACE}:${this.blockId}_slab`);
    } else if (blockName.includes('Snow')) {
      AbstractBlockModel.tags.mineable_shovel.push(`${this.NAMESPACE}:${this.blockId}_slab`);
    }
  }

  build() {
    return [
      [
        {
          "parent": "minecraft:block/slab",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.blockId}`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`,
            "top": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_slab.json'
      ],
      [
        {
          "parent": "minecraft:block/slab_top",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.blockId}`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`,
            "top": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_slab_top.json'
      ]
    ]
  }

  buildItemModel() {
    return [
      {
        "parent": `${this.NAMESPACE}:block/${this.blockId}_slab`
      },
      '_slab.json'
    ]
  }
  
  buildBlockstate() {
    return [
      {
        "variants": {
          "type=bottom": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_slab`
          },
          "type=double": {
            "model": `${this.NAMESPACE}:block/${this.blockId}`
          },
          "type=top": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_slab_top`
          }
        }
      },
      '_slab.json'
    ]
  }

  buildLootTable() {
    return !this.dropOnlyWithSilkTouch() ?
    [
      {
        "type": "minecraft:block",
        "random_sequence": `${this.NAMESPACE}:blocks/${this.blockId}_slab`,
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
                        "block": `${this.NAMESPACE}:${this.blockId}_slab`,
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
                "name": `${this.NAMESPACE}:${this.blockId}_slab`
              }
            ],
            "rolls": 1.0
          }
        ]
      },
      '_slab.json'
    ] :
    [
      {
        "type": "minecraft:block",
        "random_sequence": `${this.NAMESPACE}:blocks/${this.blockId}_slab`,
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
                        "block": `${this.NAMESPACE}:${this.blockId}_slab`,
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
                "name": `${this.NAMESPACE}:${this.blockId}_slab`
              }
            ],
            "rolls": 1.0
          }
        ]
      },
      '_slab.json'
    ]
  }

  buildRecipeForStonecutter(baseBlock) {
    const baseIdentifier = baseBlock
      .replace('minecraft:', '')
      .replace(`${this.NAMESPACE}:`, '');

    return [
      {
        "type": "minecraft:stonecutting",
        "count": 2,
        "ingredient": {
          "item": `${baseBlock}`
        },

        "result": `${this.NAMESPACE}:${this.blockId}_slab`
      },
      `_slab_from_${baseIdentifier}_stonecutting.json`
    ]
  }
}