import fs from 'fs';
import path from 'path';

export class AbstractBlockModel {
  NAMESPACE = 'moreblocks';

  static tags = {
    logs: [],
    planks: [],
    slabs: [],
    stairs: [],
    walls: [],
    wooden_slabs: [],
    wooden_stairs: [],

    mineable_pickaxe: [],
    mineable_shovel: []
  };

  static blockVariables = [];
  static itemBlockVariables = [];

  static registerBlockList = [];
  static registerItemBlockList = [];
  static language = {};

  BLOCK_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/models/block';
  ITEM_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/models/item';
  BLOCKSTATES_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/blockstates';
  LOOT_TABLE_EXPORT_PATH = 'common/src/main/resources/data/moreblocks/loot_tables/blocks';

  static TAG_BLOCKS_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/blocks';
  static TAG_ITEM_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/items';
  static TAG_MINEABLE_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/blocks/mineable';

  constructor(blockName) {
    this.blockName = blockName;
    this.blockId = AbstractBlockModel.parseNameToIdentifier(blockName);
    this.parentBlockId = this.blockId;

    this.blockModelPath = path.join('..',  this.BLOCK_MODEL_EXPORT_PATH, this.blockId);
    this.itemModelPath = path.join('..', this.ITEM_MODEL_EXPORT_PATH, this.blockId);
    this.blockstateModelPath = path.join('..', this.BLOCKSTATES_MODEL_EXPORT_PATH, this.blockId);
    this.lootTableModelPath = path.join('..', this.LOOT_TABLE_EXPORT_PATH, this.blockId);

    if(
      !this.isLogOrWoodVariation(blockName) && !blockName.includes('Snow') &&
      !blockName.includes('Glass') && !blockName.includes('Ice')) {
        AbstractBlockModel.tags.mineable_pickaxe.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }

  isLogOrWoodVariation(blockName) {
    return blockName.includes('Mosaic') || blockName.includes('Stem') ||
           blockName.includes('Hyphae') || blockName.includes('Log') ||
           blockName.includes('Wood')
  }

  dropOnlyWithSilkTouch() {
    return this.blockName.includes('Glass') || this.blockName.includes('Ice');
  }

  build() { return [] }

  saveModels() {
    try {
      for (const content of this.build()) {
        const data = JSON.stringify(content[0], null, 2);
        fs.writeFileSync(this.blockModelPath.concat(content[1]), data, 'utf-8');

        const itemModelData = JSON.stringify(this.buildItemModel()[0], null, 2);
        fs.writeFileSync(this.itemModelPath.concat(this.buildItemModel()[1]), itemModelData, 'utf-8');

        const blockstateModelData = JSON.stringify(this.buildBlockstate()[0], null, 2);
        fs.writeFileSync(this.blockstateModelPath.concat(this.buildBlockstate()[1]), blockstateModelData, 'utf-8');

        const lootTableModelData = JSON.stringify(this.buildLootTable()[0], null, 2);
        fs.writeFileSync(this.lootTableModelPath.concat(this.buildLootTable()[1]), lootTableModelData, 'utf-8');
      }
    } catch (err) {
      console.error(new Error(`Something happen to create block model files of ${this.blockName}`));
    }

    return this;
  }

  buildItemModel() {
    return [
      {
        "parent": `${this.NAMESPACE}:block/${this.blockId}`
      },
      '.json'
    ]
  }

  buildBlockstate() {
    return [
      {
        "variants": {
          "": { "model": `${this.NAMESPACE}:block/${this.blockId}` }
        }
      },
      '.json'
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
      },
      '.json'
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
      },
      '.json'
    ]
  }

  static parseNameToIdentifier(name) {
    return name
      .replaceAll(' ', '_')
      .replaceAll("'", '')
      .toLowerCase();
  }

  static createAndSaveTagFiles() {
    for (const tag of Object.keys(AbstractBlockModel.tags)) {
      const tagData = JSON.stringify({
        replace: false,
        values: AbstractBlockModel.tags[tag]
      }, null, 2);

      if (tag.startsWith('mineable_')) {
        const mineableTag = tag.replace('mineable_', '');
        const tagMineablePath = path.join('..', AbstractBlockModel.TAG_MINEABLE_EXPORT_PATH, `${mineableTag}.json`);
        
        fs.writeFileSync(tagMineablePath, tagData, 'utf-8');
        continue;
      }

      const tagBlockPath = path.join('..', AbstractBlockModel.TAG_BLOCKS_EXPORT_PATH, `${tag}.json`);
      const tagItemPath = path.join('..', AbstractBlockModel.TAG_ITEM_EXPORT_PATH, `${tag}.json`);

      fs.writeFileSync(tagBlockPath, tagData, 'utf-8');
      fs.writeFileSync(tagItemPath, tagData, 'utf-8');
    }

    return this;
  }
}