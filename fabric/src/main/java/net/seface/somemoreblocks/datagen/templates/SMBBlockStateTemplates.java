package net.seface.somemoreblocks.datagen.templates;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.*;
import net.seface.somemoreblocks.datagen.providers.SMBModelProvider;
import net.seface.somemoreblocks.datagen.utils.SMBUtils;

public class SMBBlockStateTemplates {

  public static void createGenericBlock(Block block) {
    SMBModelProvider.BLOCK_STATE_GENERATOR.createTrivialCube(block);
  }

  /**
   *
   * @param glassBlock
   * @param paneTopBlock
   */
  public static void createGlassBlocks(Block glassBlock, Block paneTopBlock) {
    createGenericBlock(glassBlock);

    Block glassPane = BuiltInRegistries.BLOCK.get(BuiltInRegistries.BLOCK.getKey(glassBlock).withSuffix("_pane"));

    TextureMapping mapping = TextureMapping.pane(glassBlock, paneTopBlock);
    ResourceLocation post = ModelTemplates.STAINED_GLASS_PANE_POST.create(glassPane, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation side = ModelTemplates.STAINED_GLASS_PANE_SIDE.create(glassPane, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation sideAlt = ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(glassPane, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation noSide = ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(glassPane, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation noSideAlt = ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(glassPane, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

    Item item = glassPane.asItem();
    ModelTemplates.FLAT_ITEM.create(
      ModelLocationUtils.getModelLocation(item),
      TextureMapping.layer0(glassBlock),
      SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

    SMBModelProvider.BLOCK_STATE_GENERATOR.blockStateOutput.accept(
      MultiPartGenerator.multiPart(glassPane).with(
        Variant.variant().with(VariantProperties.MODEL, post)).with(Condition.condition().term(BlockStateProperties.NORTH, true), Variant.variant().with(VariantProperties.MODEL, side)).with(Condition.condition().term(BlockStateProperties.EAST, true), Variant.variant().with(VariantProperties.MODEL, side).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.SOUTH, true), Variant.variant().with(VariantProperties.MODEL, sideAlt)).with(Condition.condition().term(BlockStateProperties.WEST, true), Variant.variant().with(VariantProperties.MODEL, sideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.NORTH, false), Variant.variant().with(VariantProperties.MODEL, noSide)).with(Condition.condition().term(BlockStateProperties.EAST, false), Variant.variant().with(VariantProperties.MODEL, noSideAlt)).with(Condition.condition().term(BlockStateProperties.SOUTH, false),
        Variant.variant().with(VariantProperties.MODEL, noSideAlt).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).with(Condition.condition().term(BlockStateProperties.WEST, false), Variant.variant().with(VariantProperties.MODEL, noSide).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)));
  }

  /**
   *
   * @param logBlock
   */
  public static void createCarvedLogAndWoodBlocks(Block logBlock, Block strippedLogBlock) {
    ResourceLocation identifier = BuiltInRegistries.BLOCK.getKey(logBlock);

    if (identifier.getPath().contains("_wood")) {
      throw new IllegalArgumentException("Don't try to register Carved Wood blocks. Use Carved Logs instead, the wood variation will be auto-generated.");
    }

    ResourceLocation woodIdentifier = ResourceLocation.tryParse(identifier.toString().replace("log", "wood"));
    ResourceLocation[] variations = { identifier, woodIdentifier };

    for (ResourceLocation id : variations) {
      boolean isWood = id.toString().contains("_wood");
      Block block = isWood ? BuiltInRegistries.BLOCK.get(id) : logBlock;

      createRotatedPillarBlock(block, isWood ? block : strippedLogBlock, isWood);
    }
  }

  /**
   *
   * @param block
   */
  public static void createRotatedPillarBlock(Block block) {
    createRotatedPillarBlock(block, block, false);
  }

  /**
   * Generate a RotatedPillar-like block.
   * @param block
   */
  public static void createRotatedPillarBlock(Block block, Block topBlock) {
    createRotatedPillarBlock(block, topBlock, false);
  }

  /**
   *
   * @param block
   */
  public static void createRotatedPillarBlock(Block block, Block topBlock, boolean ignoreHorizontal) {
    ResourceLocation vertical = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
    ResourceLocation horizontal = ignoreHorizontal ? vertical : vertical.withSuffix("_horizontal");

    ModelTemplates.CUBE_COLUMN.create(
      ModelLocationUtils.getModelLocation(block),
      TextureMapping.column(block)
        .put(TextureSlot.END, ModelLocationUtils.getModelLocation(topBlock).withSuffix(ignoreHorizontal ? "" : "_top"))
        .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(block)),
      SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

    if (!ignoreHorizontal) {
      ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(
        ModelLocationUtils.getModelLocation(block).withSuffix("_horizontal"),
        TextureMapping.column(block)
          .put(TextureSlot.END, ModelLocationUtils.getModelLocation(topBlock).withSuffix("_top"))
          .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(block)),
        SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    }

    SMBModelProvider.BLOCK_STATE_GENERATOR.blockStateOutput.accept(
      MultiVariantGenerator.multiVariant(block).with(
        PropertyDispatch.property(BlockStateProperties.AXIS)
          // axis=x
          .select(Direction.Axis.X, Variant.variant()
            .with(VariantProperties.MODEL, horizontal)
            .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
            .with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))

          // axis=y
          .select(Direction.Axis.Y, Variant.variant()
            .with(VariantProperties.MODEL, vertical))

          // axis=z
          .select(Direction.Axis.Z, Variant.variant()
            .with(VariantProperties.MODEL, horizontal)
            .with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)))
    );
  }

  public static void createWallBlock(Block block, Block baseBlock) {
    TextureMapping mapping = new TextureMapping().put(TextureSlot.WALL, TextureMapping.getBlockTexture(baseBlock));

    ResourceLocation side = ModelTemplates.WALL_LOW_SIDE.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation tall = ModelTemplates.WALL_TALL_SIDE.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation post = ModelTemplates.WALL_POST.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ModelTemplates.WALL_INVENTORY.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

    SMBModelProvider.BLOCK_STATE_GENERATOR.blockStateOutput.accept(
      MultiPartGenerator.multiPart(block)
        .with(Condition.condition().term(BlockStateProperties.UP, true), SMBUtils.createGenericVariant(post))
        .with(Condition.condition().term(BlockStateProperties.NORTH_WALL, WallSide.LOW), SMBUtils.createGenericVariant(side, true, null, null))
        .with(Condition.condition().term(BlockStateProperties.EAST_WALL, WallSide.LOW), SMBUtils.createGenericVariant(side, true, null, VariantProperties.Rotation.R90))
        .with(Condition.condition().term(BlockStateProperties.SOUTH_WALL, WallSide.LOW), SMBUtils.createGenericVariant(side, true, null, VariantProperties.Rotation.R180))
        .with(Condition.condition().term(BlockStateProperties.WEST_WALL, WallSide.LOW), SMBUtils.createGenericVariant(side, true, null, VariantProperties.Rotation.R270))
        .with(Condition.condition().term(BlockStateProperties.NORTH_WALL, WallSide.TALL), SMBUtils.createGenericVariant(tall, true, null, null))
        .with(Condition.condition().term(BlockStateProperties.EAST_WALL, WallSide.TALL), SMBUtils.createGenericVariant(tall, true, null, VariantProperties.Rotation.R90))
        .with(Condition.condition().term(BlockStateProperties.SOUTH_WALL, WallSide.TALL), SMBUtils.createGenericVariant(tall, true, null, VariantProperties.Rotation.R180))
        .with(Condition.condition().term(BlockStateProperties.WEST_WALL, WallSide.TALL), SMBUtils.createGenericVariant(tall, true, null, VariantProperties.Rotation.R270))
    );
  }

  public static void createSlabBlock(Block block, Block baseBlock) {
    TextureMapping mapping = new TextureMapping()
      .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(baseBlock))
      .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(baseBlock))
      .put(TextureSlot.TOP, TextureMapping.getBlockTexture(baseBlock));

    ResourceLocation top = ModelTemplates.SLAB_TOP.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation bottom = ModelTemplates.SLAB_BOTTOM.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

    SMBModelProvider.BLOCK_STATE_GENERATOR.blockStateOutput.accept(
      MultiVariantGenerator.multiVariant(block).with(
        PropertyDispatch.property(BlockStateProperties.SLAB_TYPE)
          .select(SlabType.BOTTOM, Variant.variant().with(VariantProperties.MODEL, bottom))
          .select(SlabType.DOUBLE, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(baseBlock)))
          .select(SlabType.TOP, Variant.variant().with(VariantProperties.MODEL, top))
      )
    );
  }

  public static void createStairsBlock(Block block, Block baseBlock) {
    TextureMapping mapping = new TextureMapping()
      .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(baseBlock))
      .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(baseBlock))
      .put(TextureSlot.TOP, TextureMapping.getBlockTexture(baseBlock));

    ResourceLocation straight = ModelTemplates.STAIRS_STRAIGHT.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation inner = ModelTemplates.STAIRS_INNER.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);
    ResourceLocation outer = ModelTemplates.STAIRS_OUTER.create(block, mapping, SMBModelProvider.BLOCK_STATE_GENERATOR.modelOutput);

    PropertyDispatch.QuadFunction<
      ResourceLocation,
      Boolean,
      VariantProperties.Rotation,
      VariantProperties.Rotation,
      Variant> createVariant = (ResourceLocation model, Boolean uvlock,
                                VariantProperties.Rotation xRot, VariantProperties.Rotation yRot) -> {
      Variant variant = Variant.variant().with(VariantProperties.MODEL, model);

      if (uvlock) variant.with(VariantProperties.UV_LOCK, true);
      if (!xRot.equals(VariantProperties.Rotation.R0)) variant.with(VariantProperties.X_ROT, xRot);
      if (!yRot.equals(VariantProperties.Rotation.R0)) variant.with(VariantProperties.Y_ROT, yRot);

      return variant;
    };

    SMBModelProvider.BLOCK_STATE_GENERATOR.blockStateOutput.accept(
      MultiVariantGenerator.multiVariant(block).with(
        PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.HALF, BlockStateProperties.STAIRS_SHAPE)

          // east
          .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_LEFT, createVariant.apply(inner, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R270))
          .select(Direction.EAST, Half.BOTTOM, StairsShape.INNER_RIGHT, createVariant.apply(inner, false, VariantProperties.Rotation.R0, VariantProperties.Rotation.R0))
          .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_LEFT, createVariant.apply(outer, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R270))
          .select(Direction.EAST, Half.BOTTOM, StairsShape.OUTER_RIGHT, createVariant.apply(outer, false, VariantProperties.Rotation.R0, VariantProperties.Rotation.R0))
          .select(Direction.EAST, Half.BOTTOM, StairsShape.STRAIGHT, createVariant.apply(straight, false, VariantProperties.Rotation.R0, VariantProperties.Rotation.R0))
          .select(Direction.EAST, Half.TOP, StairsShape.INNER_LEFT, createVariant.apply(inner, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R0))
          .select(Direction.EAST, Half.TOP, StairsShape.INNER_RIGHT, createVariant.apply(inner, false, VariantProperties.Rotation.R180, VariantProperties.Rotation.R90))
          .select(Direction.EAST, Half.TOP, StairsShape.OUTER_LEFT, createVariant.apply(outer, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R0))
          .select(Direction.EAST, Half.TOP, StairsShape.OUTER_RIGHT, createVariant.apply(outer, false, VariantProperties.Rotation.R180, VariantProperties.Rotation.R90))
          .select(Direction.EAST, Half.TOP, StairsShape.STRAIGHT, createVariant.apply(straight, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R0))

          // north
          .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_LEFT, createVariant.apply(inner, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R180))
          .select(Direction.NORTH, Half.BOTTOM, StairsShape.INNER_RIGHT, createVariant.apply(inner, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R270))
          .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_LEFT, createVariant.apply(outer, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R180))
          .select(Direction.NORTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, createVariant.apply(outer, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R270))
          .select(Direction.NORTH, Half.BOTTOM, StairsShape.STRAIGHT, createVariant.apply(straight, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R270))
          .select(Direction.NORTH, Half.TOP, StairsShape.INNER_LEFT, createVariant.apply(inner, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R270))
          .select(Direction.NORTH, Half.TOP, StairsShape.INNER_RIGHT, createVariant.apply(inner, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R0))
          .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_LEFT, createVariant.apply(outer, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R270))
          .select(Direction.NORTH, Half.TOP, StairsShape.OUTER_RIGHT, createVariant.apply(outer, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R0))
          .select(Direction.NORTH, Half.TOP, StairsShape.STRAIGHT, createVariant.apply(straight, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R270))

          // south
          .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_LEFT, createVariant.apply(inner, false, VariantProperties.Rotation.R0, VariantProperties.Rotation.R0))
          .select(Direction.SOUTH, Half.BOTTOM, StairsShape.INNER_RIGHT, createVariant.apply(inner, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R90))
          .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_LEFT, createVariant.apply(outer, false, VariantProperties.Rotation.R0, VariantProperties.Rotation.R0))
          .select(Direction.SOUTH, Half.BOTTOM, StairsShape.OUTER_RIGHT, createVariant.apply(outer, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R90))
          .select(Direction.SOUTH, Half.BOTTOM, StairsShape.STRAIGHT, createVariant.apply(straight, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R90))
          .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_LEFT, createVariant.apply(inner, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R90))
          .select(Direction.SOUTH, Half.TOP, StairsShape.INNER_RIGHT, createVariant.apply(inner, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R180))
          .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_LEFT, createVariant.apply(outer, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R90))
          .select(Direction.SOUTH, Half.TOP, StairsShape.OUTER_RIGHT, createVariant.apply(outer, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R180))
          .select(Direction.SOUTH, Half.TOP, StairsShape.STRAIGHT, createVariant.apply(straight, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R90))

          // west
          .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_LEFT, createVariant.apply(inner, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R90))
          .select(Direction.WEST, Half.BOTTOM, StairsShape.INNER_RIGHT, createVariant.apply(inner, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R180))
          .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_LEFT, createVariant.apply(outer, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R90))
          .select(Direction.WEST, Half.BOTTOM, StairsShape.OUTER_RIGHT, createVariant.apply(outer, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R180))
          .select(Direction.WEST, Half.BOTTOM, StairsShape.STRAIGHT, createVariant.apply(straight, true, VariantProperties.Rotation.R0, VariantProperties.Rotation.R180))
          .select(Direction.WEST, Half.TOP, StairsShape.INNER_LEFT, createVariant.apply(inner, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R180))
          .select(Direction.WEST, Half.TOP, StairsShape.INNER_RIGHT, createVariant.apply(inner, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R270))
          .select(Direction.WEST, Half.TOP, StairsShape.OUTER_LEFT, createVariant.apply(outer, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R180))
          .select(Direction.WEST, Half.TOP, StairsShape.OUTER_RIGHT, createVariant.apply(outer, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R270))
          .select(Direction.WEST, Half.TOP, StairsShape.STRAIGHT, createVariant.apply(straight, true, VariantProperties.Rotation.R180, VariantProperties.Rotation.R180))
      )
    );
  }
}
