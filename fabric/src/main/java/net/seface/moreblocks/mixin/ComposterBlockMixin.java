package net.seface.moreblocks.mixin;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.seface.moreblocks.registry.MBItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ComposterBlock.class)
public abstract class ComposterBlockMixin {

  @Shadow
  private static void add(float $$0, ItemLike $$1) {}

  @Inject(method = "bootStrap", at = @At("TAIL"))
  private static void bootStrapMixin(CallbackInfo ci) {
    add(0.3F, MBItems.TINY_CACTUS);
    add(0.3F, MBItems.DUNE_GRASS);
    add(0.5F, MBItems.TALL_DUNE_GRASS);
    add(0.5F, MBItems.TALL_DUNE_GRASS);
    add(0.3F, MBItems.SNOW_GRASS);
    add(0.65F, MBItems.TALL_SNOW_GRASS);
    add(0.65F, MBItems.SNOW_FERN);
    add(0.65F, MBItems.TALL_SNOW_FERN);
    add(0.65F, MBItems.CATTAIL);
    add(0.65F, MBItems.LUMINOUS_FLOWER);
    add(0.85F, MBItems.BROWN_MUSHROOM_COLONY);
    add(1.0F, MBItems.TALL_BROWN_MUSHROOM_COLONY);
    add(0.85F, MBItems.RED_MUSHROOM_COLONY);
    add(1.0F, MBItems.TALL_RED_MUSHROOM_COLONY);
    add(0.85F, MBItems.CRIMSON_FUNGUS_COLONY);
    add(1.0F, MBItems.TALL_CRIMSON_FUNGUS_COLONY);
    add(0.85F, MBItems.WARPED_FUNGUS_COLONY);
    add(1.0F, MBItems.TALL_WARPED_FUNGUS_COLONY);
  }
}
