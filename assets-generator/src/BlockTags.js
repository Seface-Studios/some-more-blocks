import fs from 'fs';
import path from 'path';

export class BlockTags {
  static TAG_BLOCKS_PATH = 'common/src/main/resources/data/minecraft/tags/blocks';
  static TAG_ITEMS_PATH = 'common/src/main/resources/data/minecraft/tags/items';
  static TAG_MINEABLE_PATH = 'common/src/main/resources/data/minecraft/tags/blocks/mineable';
  static TAG_CRACKLABLE_PATH = 'common/src/main/resources/data/moreblocks/tags/blocks';

  static tags = {
    logs: [],
    planks: [],
    slabs: [],
    stairs: [],
    walls: [],
    cracklable: [...BlockTags.addVanillaCracklableBlocks()],
    wooden_slabs: [],
    wooden_stairs: [],

    mineable_pickaxe: [],
    mineable_shovel: []
  };

  static createAndSave() {
    for (const tag of Object.keys(BlockTags.tags)) {
      const tagData = JSON.stringify({
        replace: false,
        values: BlockTags.tags[tag]
      }, null, 2);

      if (tag === "logs") continue;

      if (tag.startsWith('mineable_')) {
        const mineableTag = tag.replace('mineable_', '');
        const tagMineablePath = path.join('..', BlockTags.TAG_MINEABLE_PATH, `${mineableTag}.json`);
        
        fs.writeFileSync(tagMineablePath, tagData, 'utf-8');
        continue;
      }

      if (tag === 'cracklable') {
        const tagCracklablePath = path.join('..', BlockTags.TAG_CRACKLABLE_PATH, 'cracklable.json');
        let object = JSON.parse(tagData);
        delete object.replace 

        fs.writeFileSync(tagCracklablePath, JSON.stringify(object, null, 2), 'utf-8');
        continue;
      }

      const tagBlockPath = path.join('..', BlockTags.TAG_BLOCKS_PATH, `${tag}.json`);
      const tagItemPath = path.join('..', BlockTags.TAG_ITEMS_PATH, `${tag}.json`);

      fs.writeFileSync(tagBlockPath, tagData, 'utf-8');
      fs.writeFileSync(tagItemPath, tagData, 'utf-8');
    }
  }

  static addVanillaCracklableBlocks() {
    return [
      "minecraft:stone_bricks",
      "minecraft:deepslate_bricks",
      "minecraft:deepslate_tiles",
      "minecraft:nether_bricks",
      "minecraft:polished_blackstone_bricks",
      "minecraft:tuff_bricks"
    ]
  }
}