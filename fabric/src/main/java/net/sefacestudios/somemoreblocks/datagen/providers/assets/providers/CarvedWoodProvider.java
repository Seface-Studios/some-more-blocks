package net.sefacestudios.somemoreblocks.datagen.providers.assets.providers;

import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.sefacestudios.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.sefacestudios.somemoreblocks.item.properties.numeric.MoonPhaseProperty;
import net.sefacestudios.somemoreblocks.registries.SMBRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.function.BiFunction;

public class CarvedWoodProvider {
  private final BlockModelGenerators modelGenerator;
  private final TextureMapping carvedLogMapping;


  public CarvedWoodProvider(BlockModelGenerators modelGenerator, final TextureMapping carvedLogMapping) {
    this.modelGenerator = modelGenerator;
    this.carvedLogMapping = carvedLogMapping;
  }

  public CarvedWoodProvider log(final Block logBlock) {
    Block topBottomBlock = SMBRegistries.CARVED_BLOCKS.getPrevious(logBlock).orElseThrow();
    TextureMapping mapping = this.carvedLogMapping
      .copyAndUpdate(TextureSlot.END, TextureMapping.getBlockTexture(topBottomBlock, "_top"));

    Identifier model = ModelTemplates.CUBE_COLUMN.create(logBlock, mapping, this.modelGenerator.modelOutput);

    this.modelGenerator.blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(logBlock, BlockModelGenerators.plainVariant(model)));
    this.modelGenerator.registerSimpleItemModel(logBlock, model);
    return this;
  }

  public CarvedWoodProvider wood(final Block woodBlock) {
    TextureMapping mapping = this.carvedLogMapping
      .copyAndUpdate(TextureSlot.END, this.carvedLogMapping.get(TextureSlot.SIDE));

    Identifier model = ModelTemplates.CUBE_COLUMN.create(woodBlock, mapping, this.modelGenerator.modelOutput);

    this.modelGenerator.registerSimpleItemModel(woodBlock, model);
    this.modelGenerator.blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(woodBlock, BlockModelGenerators.plainVariant(model)));
    return this;
  }

  public CarvedWoodProvider logWithMoonPhase(final Block logBlock) {
    Block topBottomBlock = SMBRegistries.CARVED_BLOCKS.getPrevious(logBlock).orElseThrow();

    return this.createLogOrWoodWithMoonPhase(logBlock, (block, i) -> {
      String suffix = String.format(Locale.ROOT, "_%d", i);

      return this.carvedLogMapping
        .copyAndUpdate(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, suffix))
        .copyAndUpdate(TextureSlot.END, TextureMapping.getBlockTexture(topBottomBlock, "_top"));
    });
  }

  public CarvedWoodProvider woodWithMoonPhase(final Block woodBlock) {
    return this.createLogOrWoodWithMoonPhase(
      woodBlock,
      (b, i) -> {
        String suffix = String.format(Locale.ROOT, "_%d", i);

        return this.carvedLogMapping
          .copyAndUpdate(TextureSlot.SIDE, this.applySuffixToTextureSlot(TextureSlot.SIDE, suffix))
          .copyAndUpdate(TextureSlot.END, this.applySuffixToTextureSlot(TextureSlot.SIDE, suffix));
      });
  }

  private CarvedWoodProvider createLogOrWoodWithMoonPhase(Block logOrWood, BiFunction<Block, Integer, TextureMapping> mappingFactory) {
    int max = RotatedCarvedPaleOakBlock.MAX_MOON_PHASE;

    RangeSelectItemModel.Entry[] overrides = new RangeSelectItemModel.Entry[max + 1];

    PropertyDispatch.C2<@NotNull MultiVariant, Direction.@NotNull Axis, @NotNull Integer> dispatch =
      PropertyDispatch.initial(BlockStateProperties.AXIS, RotatedCarvedPaleOakBlock.MOON_PHASE);

    for (int i = 0; i <= max; i++) {
      String suffix = String.format(Locale.ROOT, "_%d", i);

      TextureMapping mapping = mappingFactory.apply(logOrWood, i);

      Identifier verticalModel = ModelTemplates.CUBE_COLUMN
        .createWithSuffix(logOrWood, suffix, mapping, this.modelGenerator.modelOutput);

      Identifier horizontalModel = ModelTemplates.CUBE_COLUMN_HORIZONTAL
        .createWithSuffix(logOrWood, suffix, mapping, this.modelGenerator.modelOutput);

      overrides[i] = ItemModelUtils.override(ItemModelUtils.plainModel(verticalModel), i);

      for (Direction.Axis axis : Direction.Axis.values()) {
        Identifier model = (axis == Direction.Axis.Y) ? verticalModel : horizontalModel;

        MultiVariant variant = BlockModelGenerators.plainVariant(model)
          .with(VariantMutator.X_ROT.withValue(
            axis == Direction.Axis.Y ? Quadrant.R0 : Quadrant.R90
          ));

        if (axis == Direction.Axis.X) {
          variant = variant.with(VariantMutator.Y_ROT.withValue(Quadrant.R90));
        }

        dispatch.select(axis, i, variant);
      }
    }

    ItemModel.Unbaked itemModel = ItemModelUtils.rangeSelect(new MoonPhaseProperty(), overrides[0].model(), overrides);

    this.modelGenerator.itemModelOutput.accept(logOrWood.asItem(), itemModel);
    this.modelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(logOrWood).with(dispatch));

    return this;
  }

  private Material applySuffixToTextureSlot(TextureSlot slot, String suffix) {
    return new Material(this.carvedLogMapping.get(slot).sprite().withSuffix(suffix));
  }
}
