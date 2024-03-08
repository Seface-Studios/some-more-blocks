import { BlockTags } from "../BlockTags.js";
import { Block } from "./Block.js";

export class WallBlock extends Block {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName.concat(' Wall'), ignoreList, stonecutterOptions);
    this.addVariables('WallBlock');

    BlockTags.tags.walls.push(`${this.NAMESPACE}:${this.blockId}`);

    if ((this.stonecutterOptions.length > 0 || this.isWall()) && !this.isWood() && !this.isIgnoredByStonecutter()) {
      this.stonecutterOptions.push(`${this.NAMESPACE}:${this.parentBlockId}`);
    }
  }

  isWall() { return true; }

  blockModels() {
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
    return {
      "parent": `${this.NAMESPACE}:block/${this.blockId}_inventory`
    }
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

  buildRecipeForCraftingTable() {
    return {
      "type": "minecraft:crafting_shaped",
      "category": "misc",
      "key": {
        "#": {
          "item": `${this.NAMESPACE}:${this.parentBlockId}`
        }
      },
      "pattern": [
        "###",
        "###"
      ],
      "result": {
        "count": 6,
        "item": `${this.NAMESPACE}:${this.blockId}`
      }
    }
  }
}