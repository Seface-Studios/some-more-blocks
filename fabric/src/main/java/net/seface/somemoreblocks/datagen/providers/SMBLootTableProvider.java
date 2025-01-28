package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.seface.somemoreblocks.registries.SMBBlocks;

import java.util.concurrent.CompletableFuture;

public class SMBLootTableProvider extends FabricBlockLootTableProvider {
  public SMBLootTableProvider(FabricDataOutput output) {
    super(output);
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
              .when(HAS_SILK_TOUCH)
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

