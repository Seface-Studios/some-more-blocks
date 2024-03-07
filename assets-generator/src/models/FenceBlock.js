import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class FenceBlock extends AbstractBlockModel {
  constructor(blockName, ignoreList, stonecutterOptions) {
    super(blockName.concat(' Fence'), ignoreList, stonecutterOptions);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()} = new FenceBlock(FabricBlockSettings.copyOf(MBBlocks.${this.blockId.toUpperCase()}));`
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

  buildLootTable() {
    return [
      {
        "type": "minecraft:block",
        "random_sequence": `${this.NAMESPACE}:blocks/${this.blockId}_fence`,
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
                "name": `${this.NAMESPACE}:${this.blockId}_fence`
              }
            ]
          }
        ]
      },
      '_fence.json'
    ]
  }

  buildRecipeForStonecutter(baseBlock) {
    const baseIdentifier = baseBlock
      .replace('minecraft:', '')
      .replace(`${this.NAMESPACE}:`, '');

    return [
      {
        "type": "minecraft:stonecutting",
        "count": 1,
        "ingredient": {
          "item": `${baseBlock}`
        },

        "result": `${this.NAMESPACE}:${this.blockId}_fence`
      },
      `_fence_from_${baseIdentifier}_stonecutting.json`
    ]
  }
}