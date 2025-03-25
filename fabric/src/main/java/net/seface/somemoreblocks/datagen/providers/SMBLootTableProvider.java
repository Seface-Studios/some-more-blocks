package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetComponentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.concurrent.CompletableFuture;

public class SMBLootTableProvider extends FabricBlockLootTableProvider {
  public SMBLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> lookup) {
    super(output, lookup);
  }

  @Override
  public void generate() {
    addSilkTouchOnly(SMBBlocks.POLISHED_ICE);
    addSilkTouchOnly(SMBBlocks.POLISHED_ICE_STAIRS);
    addSilkTouchOnly(SMBBlocks.POLISHED_ICE_SLAB);
    addSilkTouchOnly(SMBBlocks.ICE_BRICKS);
    addSilkTouchOnly(SMBBlocks.CRACKED_ICE_BRICKS);
    addSilkTouchOnly(SMBBlocks.ICE_BRICK_STAIRS);
    addSilkTouchAsSlab(SMBBlocks.ICE_BRICK_SLAB);
    addSilkTouchOnly(SMBBlocks.ICE_BRICK_WALL);
    addSilkTouchOnly(SMBBlocks.ICE_PILLAR);
    addSilkTouchOnly(SMBBlocks.ICE_TILES);
    addSilkTouchOnly(SMBBlocks.CRACKED_ICE_TILES);
    addSilkTouchOnly(SMBBlocks.ICE_TILE_STAIRS);
    addSilkTouchAsSlab(SMBBlocks.ICE_TILE_SLAB);
    addSilkTouchOnly(SMBBlocks.ICE_TILE_WALL);
    addSilkTouchOnly(SMBBlocks.TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.TILED_TINTED_GLASS);
    addSilkTouchOnly(SMBBlocks.WHITE_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.GRAY_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.BLACK_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.BROWN_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.RED_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.ORANGE_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.YELLOW_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.LIME_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.GREEN_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.CYAN_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.BLUE_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.MAGENTA_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.PINK_STAINED_TILED_GLASS);
    addSilkTouchOnly(SMBBlocks.TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.WHITE_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.GRAY_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.BLACK_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.BROWN_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.RED_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.ORANGE_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.YELLOW_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.LIME_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.GREEN_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.CYAN_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.BLUE_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE);
    addSilkTouchOnly(SMBBlocks.PINK_STAINED_TILED_GLASS_PANE);

    /* 1.21.4 */
    addGenericBlock(SMBBlocks.PALE_OAK_MOSAIC);
    addGenericBlock(SMBBlocks.PALE_OAK_MOSAIC_STAIRS);
    addGenericSlab(SMBBlocks.PALE_OAK_MOSAIC_SLAB);
    addGenericBlock(SMBBlocks.POLISHED_RESIN);
    addGenericBlock(SMBBlocks.POLISHED_RESIN_STAIRS);
    addGenericSlab(SMBBlocks.POLISHED_RESIN_SLAB);
    addGenericBlock(SMBBlocks.CRACKED_RESIN_BRICKS);
    addGenericBlock(SMBBlocks.RESINE_PILLAR);
    addGenericBlock(SMBBlocks.RESIN_TILES);
    addGenericBlock(SMBBlocks.CRACKED_RESIN_TILES);
    addGenericBlock(SMBBlocks.RESIN_TILE_STAIRS);
    addGenericSlab(SMBBlocks.RESIN_TILE_SLAB);
    addGenericBlock(SMBBlocks.RESIN_TILE_WALL);
    addGenericBlock(SMBBlocks.SMOOTH_RESIN);
    addGenericSlab(SMBBlocks.SMOOTH_RESIN_SLAB);
    addCarvedPaleLogBlock(SMBBlocks.CARVED_PALE_OAK_LOG);
    addCarvedPaleLogBlock(SMBBlocks.CARVED_PALE_OAK_WOOD);

    /* 1.21.4-without-cactus-on-forest */
    addGenericBlock(SMBBlocks.POLISHED_CACTUS);
    addGenericBlock(SMBBlocks.CHISELED_CACTUS_BRICKS);
    addGenericBlock(SMBBlocks.CACTUS_BRICKS);
    addGenericBlock(SMBBlocks.CRACKED_CACTUS_BRICKS);
    addGenericBlock(SMBBlocks.CACTUS_PILLAR);
    addGenericBlock(SMBBlocks.CACTUS_TILES);
    addGenericBlock(SMBBlocks.CRACKED_CACTUS_TILES);
    addGenericBlock(SMBBlocks.MOSSY_CACTUS_BRICKS);
    addGenericBlock(SMBBlocks.SMOOTH_CACTUS);
    addGenericBlock(SMBBlocks.CACTUS_LADDER);
  }

  /**
   * Specific to Carved Pale Log/Wood loot table where drops the correct item by the
   * moon_phase block state.
   */
  private void addCarvedPaleLogBlock(Block block) {
    LootPoolSingletonContainer.Builder<?> lootItem = LootItem.lootTableItem(block);

    for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE ; i++) {
      lootItem.apply(
        SetComponentsFunction.setComponent(SMBDataComponentTypes.MOON_PHASE, i)
          .when(
            LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
              .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RotatedCarvedPaleOakBlock.MOON_PHASE, i))
          )
      );
    }

    add(block,
      LootTable.lootTable()
        .withPool(LootPool.lootPool()
          .setRolls(ConstantValue.exactly(1.0F))
          .setBonusRolls(ConstantValue.exactly(0.0F))
          .add(lootItem))
        .setRandomSequence(ModelLocationUtils.getModelLocation(block)));
  }

  /**
   * Generic Slab + Silk Touch loot tables.
   */
  private void addSilkTouchAsSlab(Block block) {
    add(block,
      LootTable.lootTable()
        .withPool(LootPool.lootPool()
          .setRolls(ConstantValue.exactly(1.0F))
          .add(
            this.applyExplosionDecay(block, LootItem.lootTableItem(block)
              .when(this.hasSilkTouch())
              .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                .when(
                  LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                    .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))))
        ));
  }

  /**
   * Generic block where only drops if silk touch enchantment are applied to the tool.
   */
  private void addSilkTouchOnly(Block block) {
    add(block, createSilkTouchOnlyTable(block).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
  }

  /**
   * Create a generic loot table.
   * This can be also used for: Stairs & Walls
   */
  private void addGenericBlock(Block block) {
    add(block, createSingleItemTable(block).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
  }

  /**
   * Generic slab loot table where drops 2 instead of one when block state type is double.
   */
  private void addGenericSlab(Block block) {
    add(block, createSlabItemTable(block).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
  }
}

