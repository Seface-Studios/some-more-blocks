import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class FenceBlock extends AbstractBlockModel {
  constructor(blockName) {
    super(blockName);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()}_FENCE = new FenceBlock(FabricBlockSettings.copyOf(MBBlocks.${this.blockId.toUpperCase()}));`
    );
    AbstractBlockModel.itemBlockVariables.push(
      `public static final Item ${this.blockId.toUpperCase()}_FENCE = new BlockItem(MBBlocks.${this.blockId.toUpperCase()}_FENCE, new Item.Settings());`
    );

    AbstractBlockModel.registerBlockList.push(
      `Registry.register(Registries.BLOCK, new Identifier(MoreBlocks.ID, "${this.blockId}_fence"), ${this.blockId.toUpperCase()}_FENCE);`
    );
    AbstractBlockModel.registerItemBlockList.push(
      `Registry.register(Registries.ITEM, new Identifier(MoreBlocks.ID, "${this.blockId}_fence"), ${this.blockId.toUpperCase()}_FENCE);`
    );

    AbstractBlockModel.language[`block.${this.NAMESPACE}.${this.blockId}_fence`] = this.blockName.concat(' Fence');
  }

  build() {
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
    return [
      {
        "parent": `${this.NAMESPACE}:block/${this.blockId}_fence_inventory`
      },
      '_fence.json'
    ]
  }

  buildBlockstate() {
    return [
      {
        "multipart": [
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_fence_post`
            }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_fence_side`,
              "uvlock": true
            },

            "when": { "north": "true" }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_fence_side`,
              "uvlock": true,
              "y": 90
            },

            "when": { "east": "true" }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_fence_side`,
              "uvlock": true,
              "y": 180
            },
            
            "when": { "south": "true" }
          },
          {
            "apply": {
              "model": `${this.NAMESPACE}:block/${this.blockId}_fence_side`,
              "uvlock": true,
              "y": 270
            },

            "when": { "west": "true" }
          }
        ]
      },
      '_fence.json'
    ]
  }
}