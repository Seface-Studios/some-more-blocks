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
  RECIPE_EXPORT_PATH = 'common/src/main/resources/data/moreblocks/recipes';

  static TAG_BLOCKS_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/blocks';
  static TAG_ITEM_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/items';
  static TAG_MINEABLE_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/blocks/mineable';

  constructor(blockName, ignoreList, stonecutterOptions) {
    this.blockName = blockName;
    this.blockId = AbstractBlockModel.parseNameToIdentifier(blockName);
    this.stonecutterOptions = stonecutterOptions || [];
    this.ignore = ignoreList;
    this.parentBlockId = this.blockId
      .replace('_wall', '')
      .replace('_stairs', '')
      .replace('_slab', '')
      .replace('_fence', '');

    this.blockModelPath = path.join('..',  this.BLOCK_MODEL_EXPORT_PATH, this.blockId);
    this.itemModelPath = path.join('..', this.ITEM_MODEL_EXPORT_PATH, this.blockId);
    this.blockstateModelPath = path.join('..', this.BLOCKSTATES_MODEL_EXPORT_PATH, this.blockId);
    this.lootTableModelPath = path.join('..', this.LOOT_TABLE_EXPORT_PATH, this.blockId);
    this.recipeModelPath = path.join('..', this.RECIPE_EXPORT_PATH, this.blockId);

    if(
      !this.isWood() && !blockName.includes('Snow') &&
      !blockName.includes('Glass') && !blockName.includes('Ice')) {
        AbstractBlockModel.tags.mineable_pickaxe.push(`${this.NAMESPACE}:${this.blockId}`);
    }
  }

  ignoredByStonecutter() {
    return this.isWood() || this.blockName.includes('Snow');
  }

  isWood() {
    return this.blockName.includes('Mosaic') || this.blockName.includes('Stem') ||
           this.blockName.includes('Hyphae') || this.blockName.includes('Log') ||
           this.blockName.includes('Wood')
  }

  dropOnlyWithSilkTouch() {
    return this.blockName.includes('Glass') || this.blockName.includes('Ice');
  }

  build() { return [] }
  isStairs() { return false; }
  isWall() { return false; }
  isSlab() { return false; }
  isFence() { return false; }

  isDifferentModel() {
    return this.isStairs() || this.isSlab() || this.isWall();
  }

  saveModels() {
    try {
      for (const content of this.build()) {
        this.createAndSaveGeneratedFiles('block_model', this.blockModelPath, content)
            .createAndSaveGeneratedFiles('item_model', this.itemModelPath, this.buildItemModel())
            .createAndSaveGeneratedFiles('blockstate', this.blockstateModelPath, this.buildBlockstate())
            .createAndSaveGeneratedFiles('loot_table', this.lootTableModelPath, this.buildLootTable());
        
        for (const option of this.stonecutterOptions) {
          this.createAndSaveGeneratedFiles(
            'recipe_stonecutter', 
            this.recipeModelPath, 
            this.buildRecipeForStonecutter(option), 
            (this.stonecutterOptions.length <= 0)
          );
        }
      }
    } catch (err) {
      console.error(new Error(`Something happen to create block model files of ${this.blockName}`));
    }

    return this;
  }

  createAndSaveGeneratedFiles(id, basePath, content, predicate = false) {
    if (this.ignore.includes(id)) {
      console.log(`${id} of ${this.blockName} was ignored and will not be generated.`);
      return this;
    }

    if (predicate) {
      console.log(`Invalid predicate for ${id} of ${this.blockName} or variations.`);
      return this;
    };

    const data = JSON.stringify(content[0], null, 2);
    fs.writeFileSync(basePath.concat(content[1] || '.json'), data, 'utf-8');

    return this;
  }

  buildItemModel() {
    return [
      { "parent": `${this.NAMESPACE}:block/${this.blockId}` }
    ]
  }

  buildBlockstate() {
    return [
      {
        "variants": {
          "": { "model": `${this.NAMESPACE}:block/${this.blockId}` }
        }
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
            "rolls": 1.0,
            "bonus_rolls": 0.0,
            "conditions": [
              { "condition": "minecraft:survives_explosion" }
            ],
      
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
            "rolls": 1.0,
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
            ]
          }
        ]
      }
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

        "result": `${this.NAMESPACE}:${this.blockId}`
      },
      `_from_${baseIdentifier}_stonecutting.json`
    ]
  }

  static parseNameToIdentifier(name) {
    return name
      .replaceAll(' ', '_')
      .replaceAll("'", '')
      .toLowerCase();
  }

  static popNamespaceFrom(id) {
    return id.replace(/.*:/, "");
  }

  static createAndSaveTagFiles() {
    for (const tag of Object.keys(AbstractBlockModel.tags)) {
      const tagData = JSON.stringify({
        replace: false,
        values: AbstractBlockModel.tags[tag]
      }, null, 2);

      if (tag === "logs") continue;

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