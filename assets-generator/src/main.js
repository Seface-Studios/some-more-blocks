import fs from 'fs';
import { FullBlock } from './models/FullBlock.js';
import { PillarBlock } from './models/PillarBlock.js';
import { SlabBlock } from './models/SlabBlock.js';
import { StairsBlock } from './models/StairsBlock.js';
import { AbstractBlockModel } from './models/AbstractBlockModel.js';
import { FenceBlock } from './models/FenceBlock.js';
import { WallBlock } from './models/WallBlock.js';
import { LogBlock } from './models/LogBlock.js';
import { WoodBlock } from './models/WoodBlock.js';

const rawJSON = fs.readFileSync('./blocks.json');
const data = JSON.parse(rawJSON);

//const temps = [];

for (const block of data.Blocks) {
  const isPillar = block.name.endsWith('Pillar');
  const isLogLike = block.name.endsWith('Log') || block.name.endsWith('Stem');
  const isWoodLike = block.name.endsWith('Wood') || block.name.endsWith('Hyphae');

  const isIgnored = block?.ignore || false;
  if (isIgnored) continue;

  const hasSlab = block?.hasSlab || false;
  const hasStairs = block?.hasStairs || false;
  const hasFence = block?.hasFence || false;
  const hasWall = block?.hasWall || false;

  const model = isPillar ? new PillarBlock(block.name) : 
                isLogLike ? new LogBlock(block.name) : 
                isWoodLike ? new WoodBlock(block.name) :
                new FullBlock(block.name);

  model.saveModels();

  if (hasSlab) { new SlabBlock(block.name).saveModels(); }
  if (hasStairs) { new StairsBlock(block.name).saveModels(); }
  if (hasFence) { new FenceBlock(block.name).saveModels(); }
  if (hasWall) { new WallBlock(block.name).saveModels(); }

  /* if (!block.name.includes('Mosaic') && hasStairs) {
    temps.push('moreblocks:' + AbstractBlockModel.parseNameToIdentifier(block.name) + '_stairs')
  } */
}

AbstractBlockModel.createAndSaveTagFiles();

fs.writeFileSync('generated/en_us.json', JSON.stringify(AbstractBlockModel.language, null, 2), 'utf-8');
console.log('Generating Java content in text files.');
//console.log(temps)

// * MBItems
fs.unlinkSync('generated/MBItems.variables.txt');
fs.unlinkSync('generated/MBItems.register.txt');

// Variables
for (const itemVar of AbstractBlockModel.itemBlockVariables) {
  fs.appendFileSync('generated/MBItems.variables.txt', itemVar + '\n', 'utf-8');
}

// Registers
for (const registerVar of AbstractBlockModel.registerItemBlockList) {
  fs.appendFileSync('generated/MBItems.register.txt', registerVar + '\n', 'utf-8');
}

// * MBBlocks
fs.unlinkSync('generated/MBBlocks.variables.txt');
fs.unlinkSync('generated/MBBlocks.register.txt');

// Variables
for (const itemVar of AbstractBlockModel.blockVariables) {
  fs.appendFileSync('generated/MBBlocks.variables.txt', itemVar + '\n', 'utf-8');
}

// Registers
for (const registerVar of AbstractBlockModel.registerBlockList) {
  fs.appendFileSync('generated/MBBlocks.register.txt', registerVar + '\n', 'utf-8');
}
