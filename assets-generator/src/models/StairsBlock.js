import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class StairsBlock extends AbstractBlockModel {
  constructor(blockName) {
    super(blockName);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()}_STAIRS = new StairsBlock(${this.blockId.toUpperCase()}.getDefaultState(), FabricBlockSettings.copyOf(MBBlocks.${this.blockId.toUpperCase()}));`
    );
    AbstractBlockModel.itemBlockVariables.push(
      `public static final Item ${this.blockId.toUpperCase()}_STAIRS = new BlockItem(MBBlocks.${this.blockId.toUpperCase()}_STAIRS, new Item.Settings());`
    );

    AbstractBlockModel.registerBlockList.push(
      `Registry.register(Registries.BLOCK, new Identifier(MoreBlocks.ID, "${this.blockId}_stairs"), ${this.blockId.toUpperCase()}_STAIRS);`
    );
    AbstractBlockModel.registerItemBlockList.push(
      `Registry.register(Registries.ITEM, new Identifier(MoreBlocks.ID, "${this.blockId}_stairs"), ${this.blockId.toUpperCase()}_STAIRS);`
    );

    AbstractBlockModel.language[`block.${this.NAMESPACE}.${this.blockId}_stairs`] = this.blockName.concat(' Stairs');

    if (blockName.includes('Mosaic')) {
      AbstractBlockModel.tags.wooden_stairs.push(`${this.NAMESPACE}:${this.blockId}_stairs`);
      return;
    }

    AbstractBlockModel.tags.stairs.push(`${this.NAMESPACE}:${this.blockId}_stairs`);

    if (!blockName.includes('Snow')) {
      AbstractBlockModel.tags.mineable_pickaxe.push(`${this.NAMESPACE}:${this.blockId}_stairs`);
    } else if (blockName.includes('Snow')) {
      AbstractBlockModel.tags.mineable_shovel.push(`${this.NAMESPACE}:${this.blockId}_stairs`);
    }
  }

  build() {
    return [
      [
        {
          "parent": "minecraft:block/stairs",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.blockId}`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`,
            "top": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_stairs.json'
      ],
      [
        {
          "parent": "minecraft:block/inner_stairs",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.blockId}`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`,
            "top": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_stairs_inner.json'
      ],
      [
        {
          "parent": "minecraft:block/outer_stairs",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.blockId}`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`,
            "top": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_stairs_outer.json'
      ]
    ]
  }

  buildItemModel() {
    return [
      {
        "parent": `${this.NAMESPACE}:block/${this.blockId}_stairs`
      },
      '_stairs.json'
    ]
  }
  
  buildBlockstate() {
    return [
      {
        "variants": {
          "facing=east,half=bottom,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "y": 270
          },
          "facing=east,half=bottom,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`
          },
          "facing=east,half=bottom,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "y": 270
          },
          "facing=east,half=bottom,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`
          },
          "facing=east,half=bottom,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`
          },
          "facing=east,half=top,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180
          },
          "facing=east,half=top,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180,
            "y": 90
          },
          "facing=east,half=top,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180
          },
          "facing=east,half=top,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180,
            "y": 90
          },
          "facing=east,half=top,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`,
            "uvlock": true,
            "x": 180
          },
          "facing=north,half=bottom,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "y": 180
          },
          "facing=north,half=bottom,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "y": 270
          },
          "facing=north,half=bottom,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "y": 180
          },
          "facing=north,half=bottom,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "y": 270
          },
          "facing=north,half=bottom,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`,
            "uvlock": true,
            "y": 270
          },
          "facing=north,half=top,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180,
            "y": 270
          },
          "facing=north,half=top,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180
          },
          "facing=north,half=top,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180,
            "y": 270
          },
          "facing=north,half=top,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180
          },
          "facing=north,half=top,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`,
            "uvlock": true,
            "x": 180,
            "y": 270
          },
          "facing=south,half=bottom,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`
          },
          "facing=south,half=bottom,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "y": 90
          },
          "facing=south,half=bottom,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`
          },
          "facing=south,half=bottom,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "y": 90
          },
          "facing=south,half=bottom,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`,
            "uvlock": true,
            "y": 90
          },
          "facing=south,half=top,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180,
            "y": 90
          },
          "facing=south,half=top,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180,
            "y": 180
          },
          "facing=south,half=top,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180,
            "y": 90
          },
          "facing=south,half=top,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180,
            "y": 180
          },
          "facing=south,half=top,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`,
            "uvlock": true,
            "x": 180,
            "y": 90
          },
          "facing=west,half=bottom,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "y": 90
          },
          "facing=west,half=bottom,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "y": 180
          },
          "facing=west,half=bottom,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "y": 90
          },
          "facing=west,half=bottom,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "y": 180
          },
          "facing=west,half=bottom,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`,
            "uvlock": true,
            "y": 180
          },
          "facing=west,half=top,shape=inner_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180,
            "y": 180
          },
          "facing=west,half=top,shape=inner_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_inner`,
            "uvlock": true,
            "x": 180,
            "y": 270
          },
          "facing=west,half=top,shape=outer_left": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180,
            "y": 180
          },
          "facing=west,half=top,shape=outer_right": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs_outer`,
            "uvlock": true,
            "x": 180,
            "y": 270
          },
          "facing=west,half=top,shape=straight": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_stairs`,
            "uvlock": true,
            "x": 180,
            "y": 180
          }
        }
      },
      '_stairs.json'
    ]
  }

  buildLootTable() {
    return !this.dropOnlyWithSilkTouch() ?
    [
      {
        "type": "minecraft:block",
        "random_sequence": `${this.NAMESPACE}:blocks/${this.blockId}_stairs`,
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
                "name": `${this.NAMESPACE}:${this.blockId}_stairs`
              }
            ]
          }
        ]
      },
      '_stairs.json'
    ] :
    [
      {
        "type": "minecraft:block",
        "random_sequence": `${this.NAMESPACE}:blocks/${this.blockId}_stairs`,
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
                "name": `${this.NAMESPACE}:${this.blockId}_stairs`
              }
            ],
            "rolls": 1.0
          }
        ]
      },
      '_stairs.json'
    ]
  }
}