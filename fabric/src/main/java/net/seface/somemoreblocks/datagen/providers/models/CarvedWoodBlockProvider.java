package net.seface.somemoreblocks.datagen.providers.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class CarvedWoodBlockProvider {
  private final Block block;
  private final TextureMapping mainTextureMap;
  private final BiConsumer<ResourceLocation, ModelInstance> modelOutput;
  private final ItemModelOutput itemModelOutput;
  private final Consumer<BlockStateGenerator> blockStateOutput;

  public CarvedWoodBlockProvider(Block block, BiConsumer<ResourceLocation, ModelInstance> modelOutput, ItemModelOutput itemModelOutput, Consumer<BlockStateGenerator> blockStateOutput) {
    this.block = block;
    this.mainTextureMap = TextureMapping.logColumn(block);
    this.modelOutput = modelOutput;
    this.itemModelOutput = itemModelOutput;
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

  public CarvedWoodBlockProvider logByMoonPhase(Block block, Block topBottomBlock) {
    for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE; i++) {
      String suffix = "_" + i;

      TextureMapping textureMapping = this.mainTextureMap
        .copyAndUpdate(TextureSlot.SIDE, this.mainTextureMap.get(TextureSlot.SIDE).withSuffix(suffix))
        .copyAndUpdate(TextureSlot.END, ModelLocationUtils.getModelLocation(topBottomBlock).withSuffix("_top"));

      ModelTemplates.CUBE_COLUMN.createWithSuffix(block, suffix, textureMapping, this.modelOutput);
      ModelTemplates.CUBE_COLUMN_HORIZONTAL.createWithSuffix(block, suffix, textureMapping, this.modelOutput);
    }

    ResourceLocation verticalModel = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
    ResourceLocation horizontalModel = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/").withSuffix("_horizontal");

    this.blockStateOutput.accept(createRotatedPillarWithHorizontalAndMoonPhaseVariant(block, verticalModel, horizontalModel));
    return this;
  }

  public CarvedWoodBlockProvider wood(Block block) {
    TextureMapping textureMapping = this.mainTextureMap.copyAndUpdate(TextureSlot.END, this.mainTextureMap.get(TextureSlot.SIDE));
    ResourceLocation model = ModelTemplates.CUBE_COLUMN
      .create(ModelLocationUtils.getModelLocation(block), textureMapping, this.modelOutput);

    this.blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(block, model));
    return this;
  }

  public CarvedWoodBlockProvider woodByMoonPhase(Block block) {
    for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE; i++) {
      String suffix = "_" + i;

      ResourceLocation textureLocation = this.mainTextureMap.get(TextureSlot.SIDE).withSuffix(suffix);
      TextureMapping textureMapping = this.mainTextureMap
        .copyAndUpdate(TextureSlot.SIDE, textureLocation)
        .copyAndUpdate(TextureSlot.END, textureLocation);

      ModelTemplates.CUBE_COLUMN.createWithSuffix(block, suffix, textureMapping, this.modelOutput);
    }

    ResourceLocation model = ModelLocationUtils.getModelLocation(block);

    this.blockStateOutput.accept(createRotatedPillarWithHorizontalAndMoonPhaseVariant(block, model, model));
    return this;
  }

  public static BlockStateGenerator createRotatedPillarWithHorizontalAndMoonPhaseVariant(Block block, ResourceLocation vertical, ResourceLocation horizontal) {
    PropertyDispatch.C2<Direction.Axis, Integer> c2 = PropertyDispatch.properties(BlockStateProperties.AXIS, RotatedCarvedPaleOakBlock.MOON_PHASE);

    for (Direction.Axis axis : Direction.Axis.values()) {
      for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE; i++) {
        String suffix = "_" + i;

        Variant variant = Variant.variant()
          .with(VariantProperties.MODEL, axis == Direction.Axis.Y ?
            vertical.withSuffix(suffix) :
            horizontal.withPath((path -> {
              if (path.endsWith("_horizontal")) {
                return path.replace("_horizontal", suffix + "_horizontal");
              }

              return path + suffix;
            })));

        if (axis == Direction.Axis.X || axis == Direction.Axis.Z) {
          variant.with(VariantProperties.X_ROT, VariantProperties.Rotation.R90);

          if (axis == Direction.Axis.X) {
            variant.with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90);
          }
        }

        c2.select(axis, i, variant);
      }
    }

    return MultiVariantGenerator.multiVariant(block).with(c2);
  }
}
