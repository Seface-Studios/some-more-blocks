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

const rawJSON = fs.readFileSync('./blocks.json');
const data = JSON.parse(rawJSON);

for (const block of data.Blocks) {
  const isPillar = block.name.endsWith('Pillar');
  const isLogLike = block.name.endsWith('Log') || block.name.endsWith('Stem');
  const isWoodLike = block.name.endsWith('Wood') || block.name.endsWith('Hyphae');

  const ignore = block?.ignore || [];

  const hasSlab = block?.hasSlab || false;
  const hasStairs = block?.hasStairs || false;
  const hasFence = block?.hasFence || false;
  const hasWall = block?.hasWall || false;

  const model = isPillar ? new PillarBlock(block.name, ignore, block?.stonecutterOptions) : 
                isLogLike ? new LogBlock(block.name, ignore, block?.stonecutterOptions) : 
                isWoodLike ? new WoodBlock(block.name, ignore, block?.stonecutterOptions) :
                new FullBlock(block.name, ignore, block?.stonecutterOptions);

  model.createAndSave();

  if (hasSlab) { new SlabBlock(block.name, ignore, block?.stonecutterOptions).createAndSave(); }
  if (hasStairs) { new StairsBlock(block.name, ignore, block?.stonecutterOptions).createAndSave(); }
  if (hasFence) { new FenceBlock(block.name, ignore, block?.stonecutterOptions).createAndSave(); }
  if (hasWall) { new WallBlock(block.name, ignore, block?.stonecutterOptions).createAndSave(); }
}

BlockTags.createAndSave();
Localization.createAndSave();
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
