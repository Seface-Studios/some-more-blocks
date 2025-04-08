package net.seface.somemoreblocks.datagen.providers.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class TiledGlassBlockProvider {
  private final Block block;
  private final TextureMapping mainTextureMap;
  private final BiConsumer<ResourceLocation, ModelInstance> modelOutput;
  private final ItemModelOutput itemModelOutput;
  private final Consumer<BlockStateGenerator> blockStateOutput;

  public TiledGlassBlockProvider(Block block, BiConsumer<ResourceLocation, ModelInstance> modelOutput, ItemModelOutput itemModelOutput, Consumer<BlockStateGenerator> blockStateOutput) {
    this.block = block;
    this.mainTextureMap = TextureMapping.cube(block);
    this.modelOutput = modelOutput;
    this.itemModelOutput = itemModelOutput;
    this.blockStateOutput = blockStateOutput;
  }

  public TiledGlassBlockProvider fullBlock() {
    ResourceLocation model = ModelTemplates.CUBE_ALL.create(this.block, this.mainTextureMap, this.modelOutput);
    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(this.block, model));

    return this;
  }

  public TiledGlassBlockProvider pane(Block tiledGlassPane, Block topBottomBlockPane) {
    TextureMapping textureMapping = TextureMapping.pane(this.block, topBottomBlockPane);

    ResourceLocation post = ModelTemplates.STAINED_GLASS_PANE_POST.create(tiledGlassPane, textureMapping, this.modelOutput);
    ResourceLocation side = ModelTemplates.STAINED_GLASS_PANE_SIDE.create(tiledGlassPane, textureMapping, this.modelOutput);
    ResourceLocation sideAlt = ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(tiledGlassPane, textureMapping, this.modelOutput);
    ResourceLocation noSide = ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(tiledGlassPane, textureMapping, this.modelOutput);
    ResourceLocation noSideAlt = ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(tiledGlassPane, textureMapping, this.modelOutput);

    ResourceLocation item = ModelTemplates.FLAT_ITEM.create(tiledGlassPane, TextureMapping.layer0(this.block), this.modelOutput);

    this.itemModelOutput.accept(tiledGlassPane.asItem(), ItemModelUtils.plainModel(item));
    this.blockStateOutput.accept(createPane(tiledGlassPane, post, side, sideAlt, noSide, noSideAlt));
    return this;
  }

  public static BlockStateGenerator createPane(Block block, ResourceLocation post, ResourceLocation side, ResourceLocation sideAlt, ResourceLocation noSide, ResourceLocation noSideAlt) {
    return MultiPartGenerator.multiPart(block)
      .with(Variant.variant().with(VariantProperties.MODEL, post))
      .with(Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, side))
      .with(Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, side).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
      .with(Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant() .with(VariantProperties.MODEL, sideAlt))
      .with(Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, sideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
      .with(Condition.condition().term(BlockStateProperties.NORTH, false), Variant.variant().with(VariantProperties.MODEL, noSide))
      .with(Condition.condition().term(BlockStateProperties.EAST, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt))
      .with(Condition.condition().term(BlockStateProperties.SOUTH, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
      .with(Condition.condition().term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, noSide).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));
  }
}
