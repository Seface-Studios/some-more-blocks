import fs from 'fs';
import { FullBlock } from './models/FullBlock.js';
import { PillarBlock } from './models/PillarBlock.js';
import { WoodBlock } from './models/WoodBlock.js';
import { LogBlock } from './models/LogBlock.js';
import { BlockTags } from './BlockTags.js';
import { Localization } from './Localization.js';
import { BlockTypes } from './utils/BlockTypes.js';
import { Generators } from './utils/Generators.js';

const rawJSON = fs.readFileSync('./blocks.json');
const blocks = JSON.parse(rawJSON);

for (const block of blocks) {
  const isPillar = block.name.endsWith('Pillar');
  const isLogLike = block.name.endsWith('Log') || block.name.endsWith('Stem');
  const isWoodLike = block.name.endsWith('Wood') || block.name.endsWith('Hyphae');

  const options = block?.options || null;

  const blockInstance = isPillar ? new PillarBlock(block.name, options) : 
                isLogLike ? new LogBlock(block.name, options) : 
                isWoodLike ? new WoodBlock(block.name, options) :
                new FullBlock(block.name, options);

  blockInstance.createAndSave();

  for (const key of Object.keys(blockInstance.autoGenerate)) {
    if (!blockInstance.autoGenerate[key]) continue;
    const type = key.charAt(0).toUpperCase() + key.slice(1).toLowerCase();
    BlockTypes[type](block.name, options).createAndSave();
  }
}

BlockTags.createAndSave();
Localization.createAndSave();
Generators.log();