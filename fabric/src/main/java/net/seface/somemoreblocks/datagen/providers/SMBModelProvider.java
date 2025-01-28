package net.seface.somemoreblocks.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;
import net.seface.somemoreblocks.datagen.templates.SMBBlockStateTemplates;
import net.seface.somemoreblocks.registries.SMBBlocks;

public class SMBModelProvider extends FabricModelProvider {
  public static BlockModelGenerators BLOCK_STATE_GENERATOR;
  public static ItemModelGenerators ITEM_MODEL_GENERATOR;
  private FabricDataOutput output;

  public SMBModelProvider(FabricDataOutput output) {
    super(output);

    this.output = output;
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators gen) {
    BLOCK_STATE_GENERATOR = gen;

    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.TILED_GLASS, Blocks.GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.WHITE_STAINED_TILED_GLASS, Blocks.WHITE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.GRAY_STAINED_TILED_GLASS, Blocks.GRAY_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BLACK_STAINED_TILED_GLASS, Blocks.BLACK_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BROWN_STAINED_TILED_GLASS, Blocks.BROWN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.RED_STAINED_TILED_GLASS, Blocks.RED_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.ORANGE_STAINED_TILED_GLASS, Blocks.ORANGE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.YELLOW_STAINED_TILED_GLASS, Blocks.YELLOW_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIME_STAINED_TILED_GLASS, Blocks.LIME_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.GREEN_STAINED_TILED_GLASS, Blocks.GREEN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.CYAN_STAINED_TILED_GLASS, Blocks.CYAN_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.BLUE_STAINED_TILED_GLASS, Blocks.BLUE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.PURPLE_STAINED_TILED_GLASS, Blocks.PURPLE_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.MAGENTA_STAINED_TILED_GLASS, Blocks.MAGENTA_STAINED_GLASS_PANE);
    SMBBlockStateTemplates.createGlassBlocks(SMBBlocks.PINK_STAINED_TILED_GLASS, Blocks.PINK_STAINED_GLASS_PANE);
  }

  @Override
  public void generateItemModels(ItemModelGenerators gen) {
    ITEM_MODEL_GENERATOR = gen;
  }
}
