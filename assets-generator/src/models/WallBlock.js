import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class WallBlock extends AbstractBlockModel {
  constructor(blockName) {
    super(blockName);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()}_WALL = new WallBlock(FabricBlockSettings.copyOf(MBBlocks.${this.blockId.toUpperCase()}).solid());`
    );
    AbstractBlockModel.itemBlockVariables.push(
      `public static final Item ${this.blockId.toUpperCase()}_WALL = new BlockItem(MBBlocks.${this.blockId.toUpperCase()}_WALL, new Item.Settings());`
    );

    AbstractBlockModel.registerBlockList.push(
      `Registry.register(Registries.BLOCK, new Identifier(MoreBlocks.ID, "${this.blockId}_wall"), ${this.blockId.toUpperCase()}_WALL);`
    );
    AbstractBlockModel.registerItemBlockList.push(
      `Registry.register(Registries.ITEM, new Identifier(MoreBlocks.ID, "${this.blockId}_wall"), ${this.blockId.toUpperCase()}_WALL);`
    );

    AbstractBlockModel.language[`block.${this.NAMESPACE}.${this.blockId}_wall`] = this.blockName.concat(' Wall');
    AbstractBlockModel.tags.walls.push(`${this.NAMESPACE}:${this.blockId}_wall`);
  }

  build() {
    return [
      [
        {
          "parent": "minecraft:block/wall_inventory",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_wall_inventory.json'
      ],
      [
        {
          "parent": "minecraft:block/template_wall_post",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_wall_post.json'
      ],
      [
        {
          "parent": "minecraft:block/template_wall_side",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_wall_side.json'
      ],
      [
        {
          "parent": "minecraft:block/template_wall_side_tall",
          "textures": {
            "wall": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_wall_side_tall.json'
      ]
    ]
  }

  buildItemModel() {
    return [
      {
        "parent": `${this.NAMESPACE}:block/${this.blockId}_wall_inventory`
      },
      '_wall.json'
    ]
  }

  buildBlockstate() {
    return [
      {
        "multipart": [
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_post`
            },
            "when": {
              "up": "true"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side`,
              "uvlock": true
            },
            "when": {
              "north": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side`,
              "uvlock": true,
              "y": 90
            },
            "when": {
              "east": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side`,
              "uvlock": true,
              "y": 180
            },
            "when": {
              "south": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side`,
              "uvlock": true,
              "y": 270
            },
            "when": {
              "west": "low"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side_tall`,
              "uvlock": true
            },
            "when": {
              "north": "tall"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side_tall`,
              "uvlock": true,
              "y": 90
            },
            "when": {
              "east": "tall"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side_tall`,
              "uvlock": true,
              "y": 180
            },
            "when": {
              "south": "tall"
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_wall_side_tall`,
              "uvlock": true,
              "y": 270
            },
            "when": {
              "west": "tall"
            }
          }
        ]
      },
      '_wall.json'
    ]
  }
}