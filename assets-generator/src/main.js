import fs from 'fs';
import { FullBlock } from './models/FullBlock.js';
import { PillarBlock } from './models/PillarBlock.js';
import { SlabBlock } from './models/SlabBlock.js';
import { StairsBlock } from './models/StairsBlock.js';
import { Block } from './models/Block.js';
import { FenceBlock } from './models/FenceBlock.js';
import { WallBlock } from './models/WallBlock.js';
import { LogBlock } from './models/LogBlock.js';
import { WoodBlock } from './models/WoodBlock.js';
import { BlockTags } from './BlockTags.js';
import { Localization } from './Localization.js';
import { BlockTypes } from './utils/BlockTypes.js';
import chalk from 'chalk';
import { Generators } from './utils/Generators.js';

const rawJSON = fs.readFileSync('./blocks.json');
const data = JSON.parse(rawJSON);

for (const block of data.Blocks) {
  const isPillar = block.name.endsWith('Pillar');
  const isLogLike = block.name.endsWith('Log') || block.name.endsWith('Stem');
  const isWoodLike = block.name.endsWith('Wood') || block.name.endsWith('Hyphae');
  const __note = block?.__note;

  if (__note) {
    console.log(`${chalk.blueBright(`[${block.name}]`)} ${__note}`);
  }

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
//console.log(temps)

// * MBItems
fs.unlinkSync('generated/MBItems.variables.txt');
fs.unlinkSync('generated/MBItems.register.txt');

// Variables
for (const itemVar of Block.itemBlockVariables) {
  fs.appendFileSync('generated/MBItems.variables.txt', itemVar + '\n', 'utf-8');
}

// Registers
for (const registerVar of Block.registerItemBlockList) {
  fs.appendFileSync('generated/MBItems.register.txt', registerVar + '\n', 'utf-8');
}

// * MBBlocks
fs.unlinkSync('generated/MBBlocks.variables.txt');
fs.unlinkSync('generated/MBBlocks.register.txt');

// Variables
for (const itemVar of Block.blockVariables) {
  fs.appendFileSync('generated/MBBlocks.variables.txt', itemVar + '\n', 'utf-8');
}

// Registers
for (const registerVar of Block.registerBlockList) {
  fs.appendFileSync('generated/MBBlocks.register.txt', registerVar + '\n', 'utf-8');
}
