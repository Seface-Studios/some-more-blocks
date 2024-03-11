import fs from 'fs';
import path from 'path';

export class Localization {
  static LANG_PATH = 'common/src/main/resources/assets/moreblocks/lang/en_us.json';

  static data = {
    ...Localization.addItemGroups(),
    ...Localization.addPlants(),
    ...Localization.addCrackingTools(),
  }

  static add(namespace, id, name) {
    Localization.data[`block.${namespace}.${id}`] = name;
  }

  static createAndSave() {
    const enUSLang = path.join('..', Localization.LANG_PATH);
    fs.writeFileSync(enUSLang, JSON.stringify(Localization.data, null, 2), 'utf-8');
  }

  static addItemGroups() {
    return {
      'itemGroup.moreblocks.buildingBlocks': 'More Building Blocks',
      'itemGroup.moreblocks.coloredBlocks': 'More Colored Blocks',
      'itemGroup.moreblocks.naturalBlocks': 'More Natural Blocks',
    }
  }

  /**
   * The new plants are not auto-generated with assets-generator script.
   * So we need to add it manually to always add the translation keys.
   */
  static addPlants() {
    return {
      'block.moreblocks.tiny_cactus': 'Tiny Cactus',
      'block.moreblocks.dune_grass': 'Dune Grass',
      'block.moreblocks.tall_dune_grass': 'Tall Dune Grass',
      'block.moreblocks.snow_grass': 'Snow Grass',
      'block.moreblocks.tall_snow_grass': 'Tall Snow Grass',
      'block.moreblocks.snow_fern': 'Snow Fern',
      'block.moreblocks.tall_snow_fern': 'Tall Snow Fern',
      'block.moreblocks.cattail': 'Cattail',
      'block.moreblocks.leaves_bucket': 'Bucket of Leaves',
      'block.moreblocks.frozen_leaves_bucket': 'Bucket of Frozen Leaves',
      'block.moreblocks.pink_petals_bucket': 'Bucket of Pink Petals',
      'block.moreblocks.big_lily_pad': 'Big Lily Pad',
      'block.moreblocks.small_lily_pads': 'Small Lily Pads',
      'block.moreblocks.luminous_flower': 'Luminous Flower',
      'block.moreblocks.brown_mushroom_colony': 'Brown Mushroom Colony',
      'block.moreblocks.red_mushroom_colony': 'Red Mushroom Colony',
    }
  }

  static addCrackingTools() {
    return {
      'item.moreblocks.cracking_tool': 'Cracking Tool',
    }
  }
}