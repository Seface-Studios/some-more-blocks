import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class WallBlock extends AbstractBlockModel {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName.concat(' Wall'), ignoreList, stonecutterOptions);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()} = new WallBlock(FabricBlockSettings.copyOf(MBBlocks.${this.blockId.toUpperCase()}).solid());`
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
    AbstractBlockModel.tags.walls.push(`${this.NAMESPACE}:${this.blockId}`);

    if ((this.stonecutterOptions.length > 0 || this.isWall()) && !this.isWood() && !this.ignoredByStonecutter()) {
      this.stonecutterOptions.push(`${this.NAMESPACE}:${this.parentBlockId}`);
    }

    if(blockName.includes('Snow')) {
      AbstractBlockModel.tags.mineable_shovel.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }

  isWall() { return true; }

  build() {
    return [
      [
        {
          "parent": "minecraft:block/wall_inventory",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '_inventory.json'
      ],
      [
        {
          "parent": "minecraft:block/template_wall_post",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '_post.json'
      ],
      [
        {
          "parent": "minecraft:block/template_wall_side",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '_side.json'
      ],
      [
        {
          "parent": "minecraft:block/template_wall_side_tall",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '_side_tall.json'
      ]
    ]
  }

  buildItemModel() {
    return [
      {
        "parent": `${this.NAMESPACE}:block/${this.blockId}_inventory`
      }
    ]
  }

  buildBlockstate() {
    return [
      {
        "multipart": [
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_post`
            },
            "when": {
              "up": "true"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
              "uvlock": true
            },
            "when": {
              "north": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
              "uvlock": true,
              "y": 90
            },
            "when": {
              "east": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
              "uvlock": true,
              "y": 180
            },
            "when": {
              "south": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
              "uvlock": true,
              "y": 270
            },
            "when": {
              "west": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side_tall`,
              "uvlock": true
            },
            "when": {
              "north": "tall"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side_tall`,
              "uvlock": true,
              "y": 90
            },
            "when": {
              "east": "tall"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side_tall`,
              "uvlock": true,
              "y": 180
            },
            "when": {
              "south": "tall"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_side_tall`,
              "uvlock": true,
              "y": 270
            },
            "when": {
              "west": "tall"
            }
          }
        ]
      }
    ]
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
            "conditions": [
              { "condition": "minecraft:survives_explosion" }
            ],
      
            "rolls": 1.0,
            "entries": [
              {
                "type": "minecraft:item",
                "name": `${this.NAMESPACE}:${this.blockId}`
              }
            ]
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
              }
            ],
            "entries": [
              {
                "type": "minecraft:item",
                "name": `${this.NAMESPACE}:${this.blockId}`
              }
            ],
            "rolls": 1.0
          }
        ]
      }
    ]
  }
}