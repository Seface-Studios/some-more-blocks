package net.seface.somemoreblocks.util;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("deprecation")
public class SMBForgeUtils {

  /**
   * For some reason (or my [_Fyat] fault), Forge is not registering the correct
   * RenderType for the Translucent block items.
   */
  public static void registerRenderLayer(Block block, RenderType renderType) {
    ItemBlockRenderTypes.setRenderLayer(block, renderType);
    ItemBlockRenderTypes.TYPE_BY_BLOCK.put(block, renderType); /* TYPE_BY_BLOCK via Access Transformer. */
  }
}
