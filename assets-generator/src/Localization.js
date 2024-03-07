import fs from 'fs';
import path from 'path';

export class Localization {
  static LANG_PATH = 'common/src/main/resources/assets/moreblocks/lang/en_us.json';

  static data = {
    // Default Values
    'itemGroup.moreblocks.buildingBlocks': 'More Building Blocks',
    'itemGroup.moreblocks.coloredBlocks': 'More Colored Blocks',
    'itemGroup.moreblocks.naturalBlocks': 'More Natural Blocks',
  }

  static add(namespace, id, name) {
    Localization.data[`block.${namespace}.${id}`] = name;
  }

  static createAndSave() {
    Localization.#addPrivateContent();

    const enUSLang = path.join('..', Localization.LANG_PATH);
    fs.writeFileSync(enUSLang, JSON.stringify(Localization.data, null, 2), 'utf-8');
  }

  /**
   * The new plants are not auto-generated with assets-generator script.
   * So we need to add it manually to always add the translation keys.
   */
  static #addPrivateContent() {
    Localization.data['block.moreblocks.tiny_cactus'] = 'Tiny Cactus';
    Localization.data['block.moreblocks.dune_grass'] = 'Dune Grass';
    Localization.data['block.moreblocks.tall_dune_grass'] = 'Tall Dune Grass';
    Localization.data['block.moreblocks.snow_grass'] = 'Snow Grass';
    Localization.data['block.moreblocks.tall_snow_grass'] = 'Tall Snow Grass';
    Localization.data['block.moreblocks.cattail'] = 'Cattail';
    Localization.data['block.moreblocks.leaves_bucket'] = 'Bucket of Leaves';
    Localization.data['block.moreblocks.frozen_leaves_bucket'] = 'Bucket of Frozen Leaves';
    Localization.data['block.moreblocks.pink_petals_bucket'] = 'Bucket of Pink Petals';
    Localization.data['block.moreblocks.big_lily_pad'] = 'Big Lily Pad';
    Localization.data['block.moreblocks.small_lily_pads'] = 'Small Lily Pads';
    Localization.data['block.moreblocks.luminous_flower'] = 'Luminous Flower';
    Localization.data['block.moreblocks.brown_mushroom_colony'] = 'Brown Mushroom Colony';
    Localization.data['block.moreblocks.red_mushroom_colony'] = 'Red Mushroom Colony';
  }
}