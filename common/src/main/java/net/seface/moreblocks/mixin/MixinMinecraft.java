package net.seface.moreblocks.mixin;

import net.minecraft.client.Minecraft;
import net.seface.moreblocks.MoreBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    
    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {

        MoreBlocks.LOGGER.info("This line is printed by an example mod common mixin!");
        MoreBlocks.LOGGER.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}