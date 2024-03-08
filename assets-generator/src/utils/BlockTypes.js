import { FenceBlock } from '../models/FenceBlock.js';
import { SlabBlock } from '../models/SlabBlock.js';
import { StairsBlock } from '../models/StairsBlock.js';
import { WallBlock } from '../models/WallBlock.js';

export class BlockTypes {
  static Fence(blockName, options) {
    return new FenceBlock(blockName, options);
  }

  static Slab(blockName, options) {
    return new SlabBlock(blockName, options);
  }

  static Stairs(blockName, options) {
    return new StairsBlock(blockName, options);
  }

  static Wall(blockName, options) {
    return new WallBlock(blockName, options);
  }
}