package net.sefacestudios.somemoreblocks.datagen.providers.assets.providers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class TiledGlassBlockProvider {
  private final Block block;
  private final TextureMapping mainTextureMap;
  private final BiConsumer<Identifier, ModelInstance> modelOutput;
  private final ItemModelOutput itemModelOutput;
  private final Consumer<BlockModelDefinitionGenerator> blockStateOutput;

  public TiledGlassBlockProvider(Block block, BiConsumer<Identifier, ModelInstance> modelOutput, ItemModelOutput itemModelOutput, Consumer<BlockModelDefinitionGenerator> blockStateOutput) {
    this.block = block;
    this.mainTextureMap = TextureMapping.cube(block);
    this.modelOutput = modelOutput;
    this.itemModelOutput = itemModelOutput;
    this.blockStateOutput = blockStateOutput;
  }

  public TiledGlassBlockProvider fullBlock() {
    Identifier model = ModelTemplates.CUBE_ALL.create(this.block, this.mainTextureMap, this.modelOutput);
    this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(this.block, BlockModelGenerators.plainVariant(model)));

    return this;
  }

  public TiledGlassBlockProvider pane(Block tiledGlassPane, Block topBottomBlockPane) {
    TextureMapping textureMapping = TextureMapping.pane(this.block, topBottomBlockPane);

    Identifier post = ModelTemplates.STAINED_GLASS_PANE_POST.create(tiledGlassPane, textureMapping, this.modelOutput);
    Identifier side = ModelTemplates.STAINED_GLASS_PANE_SIDE.create(tiledGlassPane, textureMapping, this.modelOutput);
    Identifier sideAlt = ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(tiledGlassPane, textureMapping, this.modelOutput);
    Identifier noSide = ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(tiledGlassPane, textureMapping, this.modelOutput);
    Identifier noSideAlt = ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(tiledGlassPane, textureMapping, this.modelOutput);

    Identifier item = ModelTemplates.FLAT_ITEM.create(tiledGlassPane, TextureMapping.layer0(this.block), this.modelOutput);

    this.itemModelOutput.accept(tiledGlassPane.asItem(), ItemModelUtils.plainModel(item));
    this.blockStateOutput.accept(createPane(tiledGlassPane, post, side, sideAlt, noSide, noSideAlt));
    return this;
  }

  public static BlockModelDefinitionGenerator createPane(Block block, Identifier post, Identifier side, Identifier sideAlt, Identifier noSide, Identifier noSideAlt) {
    MultiVariant mvPost = BlockModelGenerators.plainVariant(post);
    MultiVariant mvSide = BlockModelGenerators.plainVariant(side);
    MultiVariant mvSideAlt = BlockModelGenerators.plainVariant(sideAlt);
    MultiVariant mvNoSide = BlockModelGenerators.plainVariant(noSide);
    MultiVariant mvNoSideAlt = BlockModelGenerators.plainVariant(noSideAlt);

    return MultiPartGenerator.multiPart(block)
      .with(mvPost)
      .with(new ConditionBuilder().term(BlockStateProperties.NORTH, true), mvSide)
      .with(new ConditionBuilder().term(BlockStateProperties.EAST, true), mvSide.with(BlockModelGenerators.Y_ROT_90))
      .with(new ConditionBuilder().term(BlockStateProperties.SOUTH, true), mvSideAlt)
      .with(new ConditionBuilder().term(BlockStateProperties.WEST, true), mvSideAlt.with(BlockModelGenerators.Y_ROT_90))
      .with(new ConditionBuilder().term(BlockStateProperties.NORTH, false), mvNoSide)
      .with(new ConditionBuilder().term(BlockStateProperties.EAST, false), mvNoSideAlt)
      .with(new ConditionBuilder().term(BlockStateProperties.SOUTH, false), mvNoSideAlt.with(BlockModelGenerators.Y_ROT_90))
      .with(new ConditionBuilder().term(BlockStateProperties.WEST, false), mvNoSide.with(BlockModelGenerators.Y_ROT_270));
  }
}
