package net.seface.somemoreblocks.renderer.blockentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ChestModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.Calendar;

@Environment(EnvType.CLIENT)
public class CactusChestRenderer<T extends BlockEntity & LidBlockEntity> extends ChestRenderer<T> {
  private final ChestModel singleModel;
  private final ChestModel doubleLeftModel;
  private final ChestModel doubleRightModel;
  private final boolean xmasTextures = xmasTextures();

  public CactusChestRenderer(BlockEntityRendererProvider.Context context) {
    super(context);
    this.singleModel = new ChestModel(context.bakeLayer(ModelLayers.CHEST));
    this.doubleLeftModel = new ChestModel(context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT));
    this.doubleRightModel = new ChestModel(context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT));
  }

  public static boolean xmasTextures() {
    Calendar calendar = Calendar.getInstance();
    return calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26;
  }

  public void render(T blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
    Level level = blockEntity.getLevel();
    boolean bl = level != null;
    BlockState blockState = bl ? blockEntity.getBlockState() : (BlockState) Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
    ChestType chestType = blockState.hasProperty(ChestBlock.TYPE) ? (ChestType)blockState.getValue(ChestBlock.TYPE) : ChestType.SINGLE;
    Block block = blockState.getBlock();
    if (block instanceof AbstractChestBlock<?> abstractChestBlock) {
      boolean bl2 = chestType != ChestType.SINGLE;
      poseStack.pushPose();
      float g = ((Direction)blockState.getValue(ChestBlock.FACING)).toYRot();
      poseStack.translate(0.5F, 0.5F, 0.5F);
      poseStack.mulPose(Axis.YP.rotationDegrees(-g));
      poseStack.translate(-0.5F, -0.5F, -0.5F);
      DoubleBlockCombiner.NeighborCombineResult neighborCombineResult;
      if (bl) {
        neighborCombineResult = abstractChestBlock.combine(blockState, level, blockEntity.getBlockPos(), true);
      } else {
        neighborCombineResult = DoubleBlockCombiner.Combiner::acceptNone;
      }

      float h = ((Float2FloatFunction)neighborCombineResult.apply(ChestBlock.opennessCombiner((LidBlockEntity)blockEntity))).get(f);
      h = 1.0F - h;
      h = 1.0F - h * h * h;
      int k = ((Int2IntFunction)neighborCombineResult.apply(new BrightnessCombiner())).applyAsInt(i);

      Material material = switch (chestType) {
          case LEFT -> Sheets.chestMaterial(ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, "cactus_left"));
          case RIGHT -> Sheets.chestMaterial(ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, "cactus_right"));
          default -> Sheets.chestMaterial(ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, "cactus"));
      };

      VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entityCutout);
      if (bl2) {
        if (chestType == ChestType.LEFT) {
          this.render(poseStack, vertexConsumer, this.doubleLeftModel, h, k, j);
        } else {
          this.render(poseStack, vertexConsumer, this.doubleRightModel, h, k, j);
        }
      } else {
        this.render(poseStack, vertexConsumer, this.singleModel, h, k, j);
      }

      poseStack.popPose();
    }
  }

  private void render(PoseStack poseStack, VertexConsumer vertexConsumer, ChestModel chestModel, float f, int i, int j) {
    chestModel.setupAnim(f);
    chestModel.renderToBuffer(poseStack, vertexConsumer, i, j);
  }
}
