import fs from 'fs';
import path from 'path';
import { BlockTags } from '../BlockTags.js';
import { Localization } from '../Localization.js';
import { Generators } from '../utils/Generators.js';
import chalk from 'chalk';

export class Block {
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

  constructor(blockName, ignoreList, stonecutterOptions) {
    this.blockName = blockName;
    this.blockId = Block.parseNameToIdentifier(blockName);
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
      !this.isWood() && !this.blockName.includes('Snow') &&
      !this.blockName.includes('Glass') && !this.blockName.includes('Ice')) {
        BlockTags.tags.mineable_pickaxe.push(`${this.NAMESPACE}:${this.blockId}`);
    }

    if(blockName.includes('Snow')) {
      BlockTags.tags.mineable_shovel.push(`${this.NAMESPACE}:${this.blockId}`);
    }

    Localization.add(this.NAMESPACE, this.blockId, this.blockName);
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

  isStairs() { return false; }
  isWall() { return false; }
  isSlab() { return false; }
  isFence() { return false; }

  isDifferentModel() {
    return this.isStairs() || this.isSlab() || this.isWall();
  }

  createAndSave() {
    for (const blockModel of this.blockModels()) {
      this.generateFileFor('block_model', this.blockModelPath, blockModel);
    }

    this.generateFileFor('item_model', this.itemModelPath, this.buildItemModel())
        .generateFileFor('blockstate', this.blockstateModelPath, this.buildBlockstate())
        .generateFileFor('loot_table', this.lootTableModelPath, this.buildLootTable());
        
    for (const option of this.stonecutterOptions) {
      this.generateFileFor(
        'recipe_stonecutter', 
        this.recipeModelPath, 
        this.buildRecipeForStonecutter(option), 
        (this.stonecutterOptions.length > 0)
      );
    }

    return this;
  }

  generateFileFor(id, basePath, content, predicate = true) {
    if (this.ignore.includes(id)) {
      console.log(`${chalk.bold.yellow('·')} ${Generators[id]} of ${chalk.cyan(this.blockName)} marked as ignored.`)
      return this;
    }

    if (!predicate) return this;

    const data = JSON.stringify(content[0] || content, null, 2);
    fs.writeFileSync(basePath.concat(content[1] || '.json'), data, 'utf-8');

    return this;
  }

  /**
   * Create all needed block models for this block.
   * Some blocks need more than one block model, for example, the StairsBlock needs
   * 3 different block models.
   * 
   * @returns [object, string][] A array with all block models.
   * The 2nd value returned as string on the array is the suffix for the block model file.
   */
  blockModels() {
    return [
      [
        {
          "parent": "minecraft:block/cube_all",
          "textures": { "all": `${this.NAMESPACE}:block/${this.blockId}` }
        },
        '.json'
      ]
    ]
  }

  /**
   * Create the Block item.
   * @returns 
   */
  buildItemModel() {
    return { "parent": `${this.NAMESPACE}:block/${this.blockId}` }
  }

  buildBlockstate() {
    return {
      "variants": {
        "": { "model": `${this.NAMESPACE}:block/${this.blockId}` }
      }
    }
  }

  buildLootTable() {
    return !this.dropOnlyWithSilkTouch() ?
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
    } :
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

  addVariables(classObj) {
    Block.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()} = new ${classObj}(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS));`
    );
    Block.itemBlockVariables.push(
      `public static final Item ${this.blockId.toUpperCase()} = new BlockItem(MBBlocks.${this.blockId.toUpperCase()}, new Item.Settings());`
    );
    Block.registerBlockList.push(
      `Registry.register(Registries.BLOCK, new Identifier(MoreBlocks.ID, "${this.blockId}"), ${this.blockId.toUpperCase()});`
    );
    Block.registerItemBlockList.push(
      `Registry.register(Registries.ITEM, new Identifier(MoreBlocks.ID, "${this.blockId}"), ${this.blockId.toUpperCase()});`
    );
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
}