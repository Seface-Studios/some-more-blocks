import fs from 'fs';
import path from 'path';

export class BlockTags {
  static TAG_BLOCKS_PATH = 'common/src/main/resources/data/minecraft/tags/blocks';
  static TAG_ITEMS_PATH = 'common/src/main/resources/data/minecraft/tags/items';
  static TAG_MINEABLE_PATH = 'common/src/main/resources/data/minecraft/tags/blocks/mineable';

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

      const tagBlockPath = path.join('..', BlockTags.TAG_BLOCKS_PATH, `${tag}.json`);
      const tagItemPath = path.join('..', BlockTags.TAG_ITEMS_PATH, `${tag}.json`);

      fs.writeFileSync(tagBlockPath, tagData, 'utf-8');
      fs.writeFileSync(tagItemPath, tagData, 'utf-8');
    }
  }
}