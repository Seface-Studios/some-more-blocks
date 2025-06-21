package net.seface.somemoreblocks.datagen.providers.assets.providers;

import com.mojang.math.Quadrant;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.item.properties.numeric.MoonPhaseProperty;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class CarvedWoodBlockProvider {
  private final Block block;
  private final TextureMapping mainTextureMap;
  private final BiConsumer<ResourceLocation, ModelInstance> modelOutput;
  private final ItemModelOutput itemModelOutput;
  private final Consumer<BlockModelDefinitionGenerator> blockStateOutput;

  public CarvedWoodBlockProvider(Block block, BiConsumer<ResourceLocation, ModelInstance> modelOutput, ItemModelOutput itemModelOutput, Consumer<BlockModelDefinitionGenerator> blockStateOutput) {
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
    //ResourceLocation horizontalModel = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, textureMapping, this.modelOutput);

    this.blockStateOutput.accept(createAxisAlignedPillarBlock(block, BlockModelGenerators.plainVariant(verticalModel)));
    return this;
  }

  public CarvedWoodBlockProvider logByMoonPhase(Block block, Block topBottomBlock) {
    RangeSelectItemModel.Entry[] overrides = new RangeSelectItemModel.Entry[RotatedCarvedPaleOakBlock.MAX_MOON_PHASE + 1];

    for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE; i++) {
      String suffix = "_" + i;

      TextureMapping textureMapping = this.mainTextureMap
        .copyAndUpdate(TextureSlot.SIDE, this.mainTextureMap.get(TextureSlot.SIDE).withSuffix(suffix))
        .copyAndUpdate(TextureSlot.END, ModelLocationUtils.getModelLocation(topBottomBlock).withSuffix("_top"));

      ResourceLocation verticalModel = ModelTemplates.CUBE_COLUMN.createWithSuffix(block, suffix, textureMapping, this.modelOutput);
      ResourceLocation horizontalModel =  ModelTemplates.CUBE_COLUMN_HORIZONTAL.createWithSuffix(block, suffix, textureMapping, this.modelOutput);

      overrides[i] = ItemModelUtils.override(ItemModelUtils.plainModel(verticalModel), i);
    }

    ResourceLocation verticalModel = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
    ResourceLocation horizontalModel = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/").withSuffix("_horizontal");
    ItemModel.Unbaked itemModel = ItemModelUtils.rangeSelect(new MoonPhaseProperty(), overrides[0].model(), overrides);

    this.itemModelOutput.accept(block.asItem(), itemModel);
    this.blockStateOutput.accept(createRotatedPillarWithHorizontalAndMoonPhaseVariant(block, verticalModel, horizontalModel));
    return this;
  }

  public CarvedWoodBlockProvider wood(Block block) {
    TextureMapping textureMapping = this.mainTextureMap.copyAndUpdate(TextureSlot.END, this.mainTextureMap.get(TextureSlot.SIDE));
    ResourceLocation model = ModelTemplates.CUBE_COLUMN
      .create(ModelLocationUtils.getModelLocation(block), textureMapping, this.modelOutput);

    this.blockStateOutput.accept(createAxisAlignedPillarBlock(block, BlockModelGenerators.plainVariant(model)));
    return this;
  }

  public CarvedWoodBlockProvider woodByMoonPhase(Block block) {
    RangeSelectItemModel.Entry[] overrides = new RangeSelectItemModel.Entry[RotatedCarvedPaleOakBlock.MAX_MOON_PHASE + 1];

    for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE; i++) {
      String suffix = "_" + i;

      ResourceLocation textureLocation = this.mainTextureMap.get(TextureSlot.SIDE).withSuffix(suffix);
      TextureMapping textureMapping = this.mainTextureMap
        .copyAndUpdate(TextureSlot.SIDE, textureLocation)
        .copyAndUpdate(TextureSlot.END, textureLocation);

      ResourceLocation model = ModelTemplates.CUBE_COLUMN.createWithSuffix(block, suffix, textureMapping, this.modelOutput);

      overrides[i] = ItemModelUtils.override(ItemModelUtils.plainModel(model), i);
    }

    ResourceLocation model = ModelLocationUtils.getModelLocation(block);
    ItemModel.Unbaked itemModel = ItemModelUtils.rangeSelect(new MoonPhaseProperty(), overrides[0].model(), overrides);

    this.itemModelOutput.accept(block.asItem(), itemModel);
    this.blockStateOutput.accept(createRotatedPillarWithHorizontalAndMoonPhaseVariant(block, model, model));
    return this;
  }

  public static BlockModelDefinitionGenerator createRotatedPillarWithHorizontalAndMoonPhaseVariant(Block block, ResourceLocation vertical, ResourceLocation horizontal) {
    PropertyDispatch.C2<MultiVariant, Direction.Axis, Integer> c2 = PropertyDispatch.initial(BlockStateProperties.AXIS, RotatedCarvedPaleOakBlock.MOON_PHASE);

    for (Direction.Axis axis : Direction.Axis.values()) {
      for (int i = 0; i <= RotatedCarvedPaleOakBlock.MAX_MOON_PHASE; i++) {
        String suffix = "_" + i;

        MultiVariant variant = new MultiVariant(WeightedList.of(new Variant(vertical)))
          .with(VariantMutator.MODEL.withValue(
            axis == Direction.Axis.Y ?
              vertical.withSuffix(suffix) :
              horizontal.withPath((path -> {
                if (path.endsWith("_horizontal")) {
                  return path.replace("_horizontal", suffix + "_horizontal");
                }

                return path + suffix;
              })))
          );

        if (axis == Direction.Axis.X || axis == Direction.Axis.Z) {
          variant.with(VariantMutator.X_ROT.withValue(Quadrant.R90));

          if (axis == Direction.Axis.X) {
            variant.with(VariantMutator.Y_ROT.withValue(Quadrant.R90));
          }
        }

        c2.select(axis, i, variant);
      }
    }

    return MultiVariantGenerator.dispatch(block).with(c2);
  }

  public static BlockModelDefinitionGenerator createAxisAlignedPillarBlock(Block block, MultiVariant multiVariant) {
    return MultiVariantGenerator.dispatch(block, multiVariant).with(BlockModelGenerators.createRotatedPillar());
  }
}
