package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetComponentsFunction;
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
    /* 1.21.4 */
    addGenericBlock(SMBBlocks.PALE_OAK_MOSAIC);
    addGenericBlock(SMBBlocks.PALE_OAK_MOSAIC_STAIRS);
    addGenericSlab(SMBBlocks.PALE_OAK_MOSAIC_SLAB);
    addGenericBlock(SMBBlocks.POLISHED_RESINE);
    addGenericBlock(SMBBlocks.POLISHED_RESINE_STAIRS);
    addGenericSlab(SMBBlocks.POLISHED_RESINE_SLAB);
    addGenericBlock(SMBBlocks.CRACKED_RESINE_BRICKS);
    addGenericBlock(SMBBlocks.RESINE_PILLAR);
    addGenericBlock(SMBBlocks.RESINE_TILES);
    addGenericBlock(SMBBlocks.CRACKED_RESINE_TILES);
    addGenericBlock(SMBBlocks.RESINE_TILE_STAIRS);
    addGenericSlab(SMBBlocks.RESINE_TILE_SLAB);
    addGenericBlock(SMBBlocks.RESINE_TILE_WALL);
    addGenericBlock(SMBBlocks.SMOOTH_RESINE);
    addGenericSlab(SMBBlocks.SMOOTH_RESINE_SLAB);
    addCarvedPaleLogBlock(SMBBlocks.CARVED_PALE_OAK_LOG);
    addCarvedPaleLogBlock(SMBBlocks.CARVED_PALE_OAK_WOOD);
  }

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
   * Create a generic loot table.
   * This can be also applied for: Stairs
   *
   * @param block The to-be generated block.
   */
  private void addGenericBlock(Block block) {
    add(block, createSingleItemTable(block).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
  }

  private void addGenericSlab(Block block) {
    add(block, createSlabItemTable(block).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
  }
}

