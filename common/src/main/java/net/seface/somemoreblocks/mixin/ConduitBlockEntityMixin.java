package net.seface.somemoreblocks.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ConduitBlockEntity;
import net.seface.somemoreblocks.registries.SMBBlocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(ConduitBlockEntity.class)
public abstract class ConduitBlockEntityMixin {
  @Mutable @Shadow @Final private static Block[] VALID_BLOCKS;

  @Inject(method = "<init>", at = @At("RETURN"))
  private void constructor(CallbackInfo ci) {
    List<Block> SMB$validBlocks = new ArrayList<>(Arrays.asList(VALID_BLOCKS));
    ConduitBlockEntityMixin.SMB$modifyValidBlocks(SMB$validBlocks);
    VALID_BLOCKS = SMB$validBlocks.toArray(new Block[0]);
  }

  private static void SMB$modifyValidBlocks(List<Block> blocks) {
    blocks.add(SMBBlocks.POLISHED_PRISMARINE.get());
    blocks.add(SMBBlocks.CHISELED_PRISMARINE_BRICKS.get());
    blocks.add(SMBBlocks.PRISMARINE_PILLAR.get());
    blocks.add(SMBBlocks.PRISMARINE_TILES.get());
    blocks.add(SMBBlocks.MOSSY_PRISMARINE_BRICKS.get());
    blocks.add(SMBBlocks.SMOOTH_PRISMARINE.get());
  }
}
