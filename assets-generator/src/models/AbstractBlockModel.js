import fs from 'fs';
import path from 'path';

export class AbstractBlockModel {
  static tags = {
    planks: [],
    slabs: [],
    stairs: [],
    walls: [],
    wooden_slabs: [],
    wooden_stairs: []
  };

  static blockVariables = [];
  static itemBlockVariables = [];

  static registerBlockList = [];
  static registerItemBlockList = [];
  static language = {};

  BLOCK_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/models/block';
  ITEM_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/models/item';
  BLOCKSTATES_MODEL_EXPORT_PATH = 'common/src/main/resources/assets/moreblocks/blockstates';

  static TAG_BLOCKS_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/blocks';
  static TAG_ITEM_EXPORT_PATH = 'common/src/main/resources/data/minecraft/tags/items';

  NAMESPACE = 'moreblocks';

  constructor(blockName) {
    this.blockName = blockName;
    this.blockId = AbstractBlockModel.parseNameToIdentifier(blockName);

    this.blockModelPath = path.join('..', this.BLOCK_MODEL_EXPORT_PATH, this.blockId);
    this.itemModelPath = path.join('..', this.ITEM_MODEL_EXPORT_PATH, this.blockId);
    this.blockstateModelPath = path.join('..', this.BLOCKSTATES_MODEL_EXPORT_PATH, this.blockId);
  }

  build() { return [] }

  saveBlockModelFile() {
    try {
      for (const content of this.build()) {
        const data = JSON.stringify(content[0], null, 2);
        fs.writeFileSync(this.blockModelPath.concat(content[1]), data, 'utf-8');

        const itemModelData = JSON.stringify(this.buildItemModel()[0], null, 2);
        fs.writeFileSync(this.itemModelPath.concat(this.buildItemModel()[1]), itemModelData, 'utf-8');

        const blockstateModelData = JSON.stringify(this.buildBlockstate()[0], null, 2);
        fs.writeFileSync(this.blockstateModelPath.concat(this.buildBlockstate()[1]), blockstateModelData, 'utf-8');
      }
    } catch (err) {
      console.error(new Error(`Something happen to create block model file of ${this.blockName}`));
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

  static parseNameToIdentifier(name) {
    return name
      .replaceAll(' ', '_')
      .replaceAll("'", '')
      .toLowerCase();
  }

  static createAndSaveTagFiles() {
    for (const tag of Object.keys(AbstractBlockModel.tags)) {
      const tagBlockPath = path.join('..', AbstractBlockModel.TAG_BLOCKS_EXPORT_PATH, `${tag}.json`);
      const tagItemPath = path.join('..', AbstractBlockModel.TAG_ITEM_EXPORT_PATH, `${tag}.json`);

      const tagData = JSON.stringify({ values: AbstractBlockModel.tags[tag] }, null, 2);

      fs.writeFileSync(tagBlockPath, tagData, 'utf-8');
      fs.writeFileSync(tagItemPath, tagData, 'utf-8');
    }

    return this;
  }
}