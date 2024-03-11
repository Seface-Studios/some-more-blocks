import fs from 'fs';
import path from 'path';
import chalk from 'chalk';
import { BlockTags } from '../BlockTags.js';
import { Localization } from '../Localization.js';
import { Generators } from '../utils/Generators.js';

export class Block {
  NAMESPACE = 'moreblocks';

  static blockVariables = [];
  static itemBlockVariables = [];

  static registerBlockList = [];
  static registerItemBlockList = [];

  static #BLOCK_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/models/block';
  static #ITEM_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/models/item';
  static #BLOCKSTATES_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/blockstates';
  static #LOOT_TABLE_EXPORT_PATH = 'common/src/main/resources/data/moreblocks/loot_tables/blocks';
  static #RECIPE_EXPORT_PATH = 'common/src/main/resources/data/moreblocks/recipes';

  /**
   * Creates a new block instance.
   * @param {string} blockName The block name. The name will be used to create the block id too. 
   * @param {{
   *  ignore: string[],
   *  autoGenerate: string[],
   *  stoneCuttingWith: string[],
   *  smeltingWith: string,
   *  craftingWith: string
   *  cracklableWith: string
   * }} options All the configuration of the block.
   */
  constructor(blockName, options, ignoreAutoGenerate = false) {
    this.blockName = blockName;
    this.blockId = Block.parseNameToIdentifier(blockName);
    this.options = options; 

    this.ignore = this.options?.ignore || [];
    this.stoneCuttingWith = this.options?.stoneCuttingWith || [];
    this.smeltingWith = this.options?.smeltingWith || false;
    this.craftingWith = this.options?.craftingWith || false;
    this.cracklableWith = this.options?.cracklableWith || false;

    this.autoGenerate = !ignoreAutoGenerate ? {
      stairs: this.options?.autoGenerate?.includes('stairs') || false,
      slab: this.options?.autoGenerate?.includes('slab') || false,
      wall: this.options?.autoGenerate?.includes('wall') || false,
      fence: this.options?.autoGenerate?.includes('fence') || false
    } : {};


    /** Only used with non-solid blocks. */
    this.parentBlockId = this.blockId
      .replace('_wall', '').replace('_stairs', '')
      .replace('_slab', '').replace('_fence', '');

    if(
      !this.isWood() && !this.blockName.includes('Snow') &&
      !this.blockName.includes('Glass') && !this.blockName.includes('Ice')) {
        BlockTags.tags.mineable_pickaxe.push(`${this.NAMESPACE}:${this.blockId}`);
    }

    if(blockName.includes('Snow')) {
      BlockTags.tags.mineable_shovel.push(`${this.NAMESPACE}:${this.blockId}`);
    }

    if (this.cracklableWith) {
      BlockTags.tags.cracklable.push(this.cracklableWith);
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

  isFullBlock() {
    return !this.isStairs() && !this.isWall() && !this.isSlab() && !this.isFence();
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

  isMossyVariant() {
    return this.blockName.includes('Mossy');
  }

  isChiseledVariant() {
    return this.blockName.includes('Chiseled');
  }

  isPillarVariant() {
    return this.blockName.includes('Pillar');
  }

  createAndSave() {
    for (const blockModel of this.blockModels()) {
      this.#generateFileFor('block_model', Block.#BLOCK_MODEL_EXPORT_PATH, blockModel);
    }

    this.#generateFileFor('item_model', Block.#ITEM_MODEL_EXPORT_PATH, this.buildItemModel())
        .#generateFileFor('blockstate', Block.#BLOCKSTATES_MODEL_EXPORT_PATH, this.buildBlockstate())
        .#generateFileFor('loot_table', Block.#LOOT_TABLE_EXPORT_PATH, this.buildLootTable())
        .#generateFileFor('recipe_smelting', Block.#RECIPE_EXPORT_PATH, this.buildRecipeForSmelting(), this.smeltingWith && this.isFullBlock());

    for (const craftOption of this.buildRecipeForCraftingTable()) {
      this.#generateFileFor(
        'recipe_crafting_table',
        Block.#RECIPE_EXPORT_PATH,
        craftOption,
        this.craftingWith
      )
    }
        
    for (const option of this.stoneCuttingWith) {
      this.#generateFileFor(
        'recipe_stonecutter', 
        Block.#RECIPE_EXPORT_PATH, 
        this.buildRecipeForStonecutter(option), 
        (this.stoneCuttingWith.length > 0)
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
    const saveAt = path.join('..', basePath, this.blockId);

    if (this.ignore.includes(id) || this.ignore.includes('all')) {
      if (!Generators.IGNORED_CONTENT[id].includes(this)) {
        Generators.IGNORED_CONTENT[id].push(this);
      }

      return this;
    }

    if (!predicate) return this;

    const data = JSON.stringify(content[0] || content, null, 2);
    fs.writeFileSync(saveAt.concat(content[1] || '.json'), data, 'utf-8');

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
   * Create the Recipe for Stonecutter model.
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

  /**
   * Create the Recipe for Crafting Table model.
   * @returns {{}} The Recipe on Crafting Table model object.
   */
  buildRecipeForCraftingTable() {
    return !this.isMossyVariant() && !this.isChiseledVariant() && !this.isPillarVariant() ?
    [
      [
        {
          "type": "minecraft:crafting_shaped",
          "category": "building",
          "key": {
            "#": { "item": `${this.craftingWith}` }
          },
          "pattern": [
            "##",
            "##"
          ],
          "result": {
            "count": 4,
            "item": `${this.NAMESPACE}:${this.blockId}`
          }
        },
        ".json"
      ]
    ] : this.isChiseledVariant() || this.isPillarVariant() ? // else if
    [
      [
        {
          "type": "minecraft:crafting_shaped",
          "category": "building",
          "key": {
            "#": { "item": `${this.craftingWith}` }
          },
          "pattern": [
            "#",
            "#"
          ],
          "result": {
            "count": this.isPillarVariant() ? 2 : 1,
            "item": `${this.NAMESPACE}:${this.blockId}`
          }
        },
        ".json"
      ]
    ] : // else
    [
      [
        {
          "type": "minecraft:crafting_shapeless",
          "category": "building",
          "group": `${Block.popNamespaceFrom(this.blockId)}`,
          "ingredients": [
            { "item": `${this.craftingWith}` },
            { "item": "minecraft:moss_block" }
          ],
          "result": {
            "item": `${this.NAMESPACE}:${this.blockId}`
          }
        },
        '_from_moss_block.json'
      ],
      [
        {
          "type": "minecraft:crafting_shapeless",
          "category": "building",
          "group": `${Block.popNamespaceFrom(this.blockId)}`,
          "ingredients": [
            { "item": `${this.craftingWith}` },
            { "item": "minecraft:vine" }
          ],
          "result": {
            "item": `${this.NAMESPACE}:${this.blockId}`
          }
        },
        '_from_vine.json'
      ]
    ]
  }

  /**
   * Create the Recipe for Smelting model.
   * @returns {{}} The Recipe on Smelting model object.
   */
  buildRecipeForSmelting() {
    return {
      "type": "minecraft:smelting",
      "category": "blocks",
      "cookingtime": 200,
      "experience": 0.1,
      "ingredient": {
        "item": `${this.smeltingWith}`
      },
      "result": `${this.NAMESPACE}:${this.blockId}`
    }
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