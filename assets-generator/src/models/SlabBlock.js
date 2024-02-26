import { AbstractBlockModel } from "./AbstractBlockModel.js";

export class SlabBlock extends AbstractBlockModel {
  constructor(blockName) {
    super(blockName);

    AbstractBlockModel.blockVariables.push(
      `public static final Block ${this.blockId.toUpperCase()}_SLAB = new SlabBlock(FabricBlockSettings.copyOf(MBBlocks.${this.blockId.toUpperCase()}));`
    );
    AbstractBlockModel.itemBlockVariables.push(
      `public static final Item ${this.blockId.toUpperCase()}_SLAB = new BlockItem(MBBlocks.${this.blockId.toUpperCase()}_SLAB, new Item.Settings());`
    );

    AbstractBlockModel.registerBlockList.push(
      `Registry.register(Registries.BLOCK, new Identifier(MoreBlocks.ID, "${this.blockId}_slab"), ${this.blockId.toUpperCase()}_SLAB);`
    );
    AbstractBlockModel.registerItemBlockList.push(
      `Registry.register(Registries.ITEM, new Identifier(MoreBlocks.ID, "${this.blockId}_slab"), ${this.blockId.toUpperCase()}_SLAB);`
    );

    AbstractBlockModel.language[`block.${this.NAMESPACE}.${this.blockId}_slab`] = this.blockName.concat(' Slab');

    if (blockName.includes('Mosaic')) {
      AbstractBlockModel.tags.wooden_slabs.push(`${this.NAMESPACE}:${this.blockId}_slab`);
      return;
    }

    AbstractBlockModel.tags.slabs.push(`${this.NAMESPACE}:${this.blockId}_slab`);
  }

  build() {
    return [
      [
        {
          "parent": "minecraft:block/slab",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.blockId}`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`,
            "top": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_slab.json'
      ],
      [
        {
          "parent": "minecraft:block/slab_top",
          "textures": {
            "bottom": `${this.NAMESPACE}:block/${this.blockId}`,
            "side": `${this.NAMESPACE}:block/${this.blockId}`,
            "top": `${this.NAMESPACE}:block/${this.blockId}`
          }
        },
        '_slab_top.json'
      ]
    ]
  }

  buildItemModel() {
    return [
      {
        "parent": `${this.NAMESPACE}:block/${this.blockId}_slab`
      },
      '_slab.json'
    ]
  }
  
  buildBlockstate() {
    return [
      {
        "variants": {
          "type=bottom": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_slab`
          },
          "type=double": {
            "model": `${this.NAMESPACE}:block/${this.blockId}`
          },
          "type=top": {
            "model": `${this.NAMESPACE}:block/${this.blockId}_slab_top`
          }
        }
      },
      '_slab.json'
    ]
  }
}