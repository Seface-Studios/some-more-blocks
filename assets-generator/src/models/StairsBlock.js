import { BlockTags } from "../BlockTags.js";
import { Block } from "./Block.js";

export class StairsBlock extends Block {
  constructor(blockName, options) {
    super(blockName.concat(' Stairs'), options, true);

    if ((this.stoneCuttingWith.length > 0 || this.isStairs()) && !this.isIgnoredByStonecutter()) {
      this.stoneCuttingWith.push(`${this.NAMESPACE}:${this.parentBlockId}`);
    }

    if (blockName.includes('Mosaic')) {
      BlockTags.tags.wooden_stairs.push(`${this.NAMESPACE}:${this.blockId}`);
    } else {
      BlockTags.tags.stairs.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }

  isStairs() { return true; }

  blockModels() {
    return [
      [
        {
          "parent": "minecraft:block/stairs",
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
          "parent": "minecraft:block/inner_stairs",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "side": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "top": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '_inner.json'
      ],
      [
        {
          "parent": "minecraft:block/outer_stairs",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "side": `${this.NAMESPACE}:block/${this.parentBlockId}`,
            "top": `${this.NAMESPACE}:block/${this.parentBlockId}`
          }
        },
        '_outer.json'
      ]
    ]
  }
  
  buildBlockstate() {
    return {
      "variants": {
        "facing=east,half=bottom,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "y": 270
        },
        "facing=east,half=bottom,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`
        },
        "facing=east,half=bottom,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "y": 270
        },
        "facing=east,half=bottom,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`
        },
        "facing=east,half=bottom,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`
        },
        "facing=east,half=top,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180
        },
        "facing=east,half=top,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180,
          "y": 90
        },
        "facing=east,half=top,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180
        },
        "facing=east,half=top,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180,
          "y": 90
        },
        "facing=east,half=top,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`,
          "uvlock": true,
          "x": 180
        },
        "facing=north,half=bottom,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "y": 180
        },
        "facing=north,half=bottom,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "y": 270
        },
        "facing=north,half=bottom,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "y": 180
        },
        "facing=north,half=bottom,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "y": 270
        },
        "facing=north,half=bottom,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`,
          "uvlock": true,
          "y": 270
        },
        "facing=north,half=top,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180,
          "y": 270
        },
        "facing=north,half=top,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180
        },
        "facing=north,half=top,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180,
          "y": 270
        },
        "facing=north,half=top,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180
        },
        "facing=north,half=top,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`,
          "uvlock": true,
          "x": 180,
          "y": 270
        },
        "facing=south,half=bottom,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`
        },
        "facing=south,half=bottom,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "y": 90
        },
        "facing=south,half=bottom,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`
        },
        "facing=south,half=bottom,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "y": 90
        },
        "facing=south,half=bottom,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`,
          "uvlock": true,
          "y": 90
        },
        "facing=south,half=top,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180,
          "y": 90
        },
        "facing=south,half=top,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180,
          "y": 180
        },
        "facing=south,half=top,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180,
          "y": 90
        },
        "facing=south,half=top,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180,
          "y": 180
        },
        "facing=south,half=top,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`,
          "uvlock": true,
          "x": 180,
          "y": 90
        },
        "facing=west,half=bottom,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "y": 90
        },
        "facing=west,half=bottom,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "y": 180
        },
        "facing=west,half=bottom,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "y": 90
        },
        "facing=west,half=bottom,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "y": 180
        },
        "facing=west,half=bottom,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`,
          "uvlock": true,
          "y": 180
        },
        "facing=west,half=top,shape=inner_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180,
          "y": 180
        },
        "facing=west,half=top,shape=inner_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_inner`,
          "uvlock": true,
          "x": 180,
          "y": 270
        },
        "facing=west,half=top,shape=outer_left": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180,
          "y": 180
        },
        "facing=west,half=top,shape=outer_right": {
          "model": `${this.NAMESPACE}:block/${this.blockId}_outer`,
          "uvlock": true,
          "x": 180,
          "y": 270
        },
        "facing=west,half=top,shape=straight": {
          "model": `${this.NAMESPACE}:block/${this.blockId}`,
          "uvlock": true,
          "x": 180,
          "y": 180
        }
      }
    }
  }

  buildRecipeForCraftingTable() {
    return [
      [
        {
          "type": "minecraft:crafting_shaped",
          "category": "building",
          "key": {
            "#": {
              "item": `${this.NAMESPACE}:${this.parentBlockId}`
            }
          },
          "pattern": [
            "#  ",
            "## ",
            "###"
          ],
          "result": {
            "count": 4,
            "item": `${this.NAMESPACE}:${this.blockId}`
          }
        },
        ".json"
      ]
    ]
  }
}