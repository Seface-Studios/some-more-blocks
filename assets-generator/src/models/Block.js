import fs from 'fs';
import path from 'path';
import { BlockTags } from '../BlockTags.js';
import { Localization } from '../Localization.js';
import { Generators } from '../utils/Generators.js';
import chalk from 'chalk';

export class Block {
  NAMESPACE = 'moreblocks';

  static blockVariables = [];
  static itemBlockVariables = [];

  static registerBlockList = [];
  static registerItemBlockList = [];

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

  /**
   * Sensitive blocks need to be broken with a tool
   * containing the Silk Touch enchantment.
   */
  isSensitiveBlock() {
    return this.blockName.includes('Glass') || this.blockName.includes('Ice');
  }

  /**
   * Ignored blocks will not generate stonecutting craft and your variations.
   * @returns {boolean} If is ignored by Stonecutter.
   */
  isIgnoredByStonecutter() {
    return this.isWood() || this.blockName.includes('Snow');
  }

  isStairs() { return false; }
  isWall() { return false; }
  isSlab() { return false; }
  isFence() { return false; }

  isWood() {
    return this.blockName.includes('Mosaic') || this.blockName.includes('Stem') ||
           this.blockName.includes('Hyphae') || this.blockName.includes('Log') ||
           this.blockName.includes('Wood')
  }

  createAndSave() {
    for (const blockModel of this.blockModels()) {
      this.#generateFileFor('block_model', this.blockModelPath, blockModel);
    }

    this.#generateFileFor('item_model', this.itemModelPath, this.buildItemModel())
        .#generateFileFor('blockstate', this.blockstateModelPath, this.buildBlockstate())
        .#generateFileFor('loot_table', this.lootTableModelPath, this.buildLootTable())
        .#generateFileFor('recipe_crafting_table', this.recipeModelPath, this.buildRecipeForCraftingTable(), (this.isSlab() || this.isWall() || this.isStairs()))
        
    for (const option of this.stonecutterOptions) {
      this.#generateFileFor(
        'recipe_stonecutter', 
        this.recipeModelPath, 
        this.buildRecipeForStonecutter(option), 
        (this.stonecutterOptions.length > 0)
      );
    }

    return this;
  }

  /**
   * Generate JSON file with parsed content on specific path.
   * @param {string} id Generate id. See the possible generators at Generators.js!
   * @param {string} basePath The base export path.
   * @param {{}|[]} content The rawData to be stringfied to with JSON.
   * @param {boolean} predicate The valid predicate to generate the wanted content.
   * @returns {Block}
   */
  #generateFileFor(id, basePath, content, predicate = true) {
    if (this.ignore.includes(id)) {
      let cNum = '';
      if (content[1] !== '.json') {
        cNum = ` (${content[1].slice(1).replace('.json', '')})`
      }

      console.log(`${chalk.bold.yellow('·')} ${Generators[id]} of ${chalk.cyan(this.blockName)}${chalk.gray(cNum)} marked as ignored.`)
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
   * Create the Block Item model.
   * @returns {{}} The Block Item model object.
   */
  buildItemModel() {
    return { "parent": `${this.NAMESPACE}:block/${this.blockId}` }
  }

  /**
   * Create the Blockstate model.
   * @returns {{}} The Blockstate model object.
   */
  buildBlockstate() {
    return {
      "variants": {
        "": { "model": `${this.NAMESPACE}:block/${this.blockId}` }
      }
    }
  }

  /**
   * Create the Loot Table model.
   * @returns {{}} The Loot Table model object.
   */
  buildLootTable() {
    return !this.isSensitiveBlock() ?
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

  /**
   * Create the Recipe on Stonecutter model.
   * @returns {{}} The Recipe on Stonecutter model object.
   */
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

  buildRecipeForCraftingTable() {
    return [{}, '.json']
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