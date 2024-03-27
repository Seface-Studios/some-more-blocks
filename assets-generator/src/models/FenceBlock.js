import { Block } from "./Block.js";

export class FenceBlock extends Block {
  constructor(blockName, options) {
    super(blockName.concat(' Fence'), options);
  }

  blockModels() {
    return [
      [
        {
          "parent": "minecraft:block/fence_inventory",
          "textures": {
            "texture": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_fence_inventory.json'
      ],
      [
        {
          "parent": "minecraft:block/fence_post",
          "textures": {
            "texture": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_fence_post.json'
      ],
      [
        {
          "parent": "minecraft:block/fence_side",
          "textures": {
            "texture": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_fence_side.json'
      ]
    ]
  }

  buildItemModel() {
    return {
      "parent": `${this.NAMESPACE}:block/${this.blockId}_inventory`
    }
  }

  buildBlockstate() {
    return {
      "multipart": [
        {
          "apply": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_post`
          }
        },
        {
          "apply": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
            "uvlock": true
          },

          "when": { "north": "true" }
        },
        {
          "apply": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
            "uvlock": true,
            "y": 90
          },

          "when": { "east": "true" }
        },
        {
          "apply": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
            "uvlock": true,
            "y": 180
          },
          
          "when": { "south": "true" }
        },
        {
          "apply": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_side`,
            "uvlock": true,
            "y": 270
          },

          "when": { "west": "true" }
        }
      ]
    }
  }
}