package net.seface.somemoreblocks.datagen.providers.assets.providers;

import com.google.gson.JsonElement;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class CarvedWoodBlockProvider {
  private final Block block;
  private final TextureMapping mainTextureMap;
  private final BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput;
  private final Consumer<BlockStateGenerator> blockStateOutput;

  public CarvedWoodBlockProvider(Block block, BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput, Consumer<BlockStateGenerator> blockStateOutput) {
    this.block = block;
    this.mainTextureMap = TextureMapping.logColumn(block);
    this.modelOutput = modelOutput;
    this.blockStateOutput = blockStateOutput;
  }

  public CarvedWoodBlockProvider log(Block block, Block topBottomBlock) {
    TextureMapping textureMapping = this.mainTextureMap
      .copyAndUpdate(TextureSlot.END, ModelLocationUtils.getModelLocation(topBottomBlock).withSuffix("_top"));

    ResourceLocation verticalModel = ModelTemplates.CUBE_COLUMN.create(block, textureMapping, this.modelOutput);
    ResourceLocation horizontalModel = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, textureMapping, this.modelOutput);

    this.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(block, verticalModel, horizontalModel));
    return this;
  }

  public CarvedWoodBlockProvider wood(Block block) {
    TextureMapping textureMapping = this.mainTextureMap.copyAndUpdate(TextureSlot.END, this.mainTextureMap.get(TextureSlot.SIDE));
    ResourceLocation model = ModelTemplates.CUBE_COLUMN
      .create(ModelLocationUtils.getModelLocation(block), textureMapping, this.modelOutput);

    this.blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(block, model));
    return this;
  }
}
