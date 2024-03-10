import chalk from "chalk";

export class Generators {
  static block_model = 'Block Model';
  static item_model = 'Item Model';
  static blockstate = 'Blockstate';
  static loot_table = 'Loot Table';
  static recipe_smelting = 'Smelting Recipe';
  static recipe_stonecutter = 'Stonecutter Recipe';
  static recipe_crafting_table = 'Crafting Table Recipe';

  static IGNORED_CONTENT = {
    block_model: [],
    item_model: [],
    blockstate: [],
    loot_table: [],
    recipe_smelting: [],
    recipe_stonecutter: [],
    recipe_crafting_table: []
  }

  static log() {
    for (const key of Object.keys(Generators.IGNORED_CONTENT)) {
      if (Generators.IGNORED_CONTENT[key].length <= 0) continue;

      const blocks = Generators.IGNORED_CONTENT[key];

      console.log('')
      console.log(`${chalk.yellow(`${chalk.bold(Generators[key])} are marked as ignored for the following blocks:`)}`)
      for (const block of blocks) {
        const nonParentPfx = block.isFullBlock() ?
          chalk.green('‎•') :
          chalk.gray('‎‎‎-');

        console.log(`${nonParentPfx} ${block.blockName}`)
      }
    }
  }
}