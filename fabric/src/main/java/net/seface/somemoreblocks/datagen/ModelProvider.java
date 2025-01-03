package net.seface.somemoreblocks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.Condition;
import net.minecraft.data.models.blockstates.MultiPartGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.seface.somemoreblocks.registry.MBBlocks;

public class ModelProvider extends FabricModelProvider {
  private BlockModelGenerators blockModelGenerator;

  public ModelProvider(FabricDataOutput output) {
    super(output);
  }

  @Override
  public void generateBlockStateModels(BlockModelGenerators gen) {
    this.blockModelGenerator = gen;

    this.createGlassBlocksWithVanillaTop(MBBlocks.TILED_GLASS, MBBlocks.TILED_GLASS_PANE, Blocks.GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.BLACK_STAINED_TILED_GLASS, MBBlocks.BLACK_STAINED_TILED_GLASS_PANE, Blocks.BLACK_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.BLUE_STAINED_TILED_GLASS, MBBlocks.BLUE_STAINED_TILED_GLASS_PANE, Blocks.BLUE_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.BROWN_STAINED_TILED_GLASS, MBBlocks.BROWN_STAINED_TILED_GLASS_PANE, Blocks.BROWN_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.CYAN_STAINED_TILED_GLASS, MBBlocks.CYAN_STAINED_TILED_GLASS_PANE, Blocks.CYAN_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.GRAY_STAINED_TILED_GLASS, MBBlocks.GRAY_STAINED_TILED_GLASS_PANE, Blocks.GRAY_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.GREEN_STAINED_TILED_GLASS, MBBlocks.GREEN_STAINED_TILED_GLASS_PANE, Blocks.GREEN_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS, MBBlocks.LIGHT_BLUE_STAINED_TILED_GLASS_PANE, Blocks.LIGHT_BLUE_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS, MBBlocks.LIGHT_GRAY_STAINED_TILED_GLASS_PANE, Blocks.LIGHT_GRAY_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.LIME_STAINED_TILED_GLASS, MBBlocks.LIME_STAINED_TILED_GLASS_PANE, Blocks.LIME_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.MAGENTA_STAINED_TILED_GLASS, MBBlocks.MAGENTA_STAINED_TILED_GLASS_PANE, Blocks.MAGENTA_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.ORANGE_STAINED_TILED_GLASS, MBBlocks.ORANGE_STAINED_TILED_GLASS_PANE, Blocks.ORANGE_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.PINK_STAINED_TILED_GLASS, MBBlocks.PINK_STAINED_TILED_GLASS_PANE, Blocks.PINK_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.PURPLE_STAINED_TILED_GLASS, MBBlocks.PURPLE_STAINED_TILED_GLASS_PANE, Blocks.PURPLE_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.RED_STAINED_TILED_GLASS, MBBlocks.RED_STAINED_TILED_GLASS_PANE, Blocks.RED_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.WHITE_STAINED_TILED_GLASS, MBBlocks.WHITE_STAINED_TILED_GLASS_PANE, Blocks.WHITE_STAINED_GLASS_PANE);
    this.createGlassBlocksWithVanillaTop(MBBlocks.YELLOW_STAINED_TILED_GLASS, MBBlocks.YELLOW_STAINED_TILED_GLASS_PANE, Blocks.YELLOW_STAINED_GLASS_PANE);
  }

  @Override
  public void generateItemModels(ItemModelGenerators gen) {}

  private void createGlassBlocksWithVanillaTop(Block glassBlock, Block glassPaneBlock, Block vanillaTopBlock) {
    this.blockModelGenerator.createTrivialCube(glassBlock);

    TextureMapping paneMapping = TextureMapping.pane(glassBlock, vanillaTopBlock);
    ResourceLocation r0 = ModelTemplates.STAINED_GLASS_PANE_POST.create(glassPaneBlock, paneMapping, this.blockModelGenerator.modelOutput);
    ResourceLocation r1 = ModelTemplates.STAINED_GLASS_PANE_SIDE.create(glassPaneBlock, paneMapping, this.blockModelGenerator.modelOutput);
    ResourceLocation r2 = ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(glassPaneBlock, paneMapping, this.blockModelGenerator.modelOutput);
    ResourceLocation r3 = ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(glassPaneBlock, paneMapping, this.blockModelGenerator.modelOutput);
    ResourceLocation r4 = ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(glassPaneBlock, paneMapping, this.blockModelGenerator.modelOutput);
    Item item = glassPaneBlock.asItem();
    ModelTemplates.FLAT_ITEM.create(
      ModelLocationUtils.getModelLocation(item),
      TextureMapping.layer0(glassBlock),
      this.blockModelGenerator.modelOutput);

    this.blockModelGenerator.blockStateOutput.accept(
      MultiPartGenerator.multiPart(glassPaneBlock).with(
        Variant.variant().with(VariantProperties.MODEL, r0)).with(Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, r1)).with(Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, r1).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, r2)).with(Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, r2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.NORTH, false), Variant.variant().with(VariantProperties.MODEL, r3)).with(Condition.condition().term(BlockStateProperties.EAST, false), Variant.variant().with(VariantProperties.MODEL, r4)).with(Condition.condition().term(BlockStateProperties.SOUTH, false),
        Variant.variant().with(VariantProperties.MODEL, r4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, r3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
  }
}
