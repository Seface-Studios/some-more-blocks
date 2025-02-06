package net.seface.somemoreblocks.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.utils.EventResourcePackManager;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PlayerJoinOrLeaveWorldEvents {

  @SubscribeEvent
  public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
    if (!(event.getEntity() instanceof Player)) return;
    EventResourcePackManager.onPlayerJoinEnableResourcePack((Player) event.getEntity(), FeatureFlags.UPDATE_1_21);
  }

  @SubscribeEvent
  public static void onPlayerLeaveWorld(EntityLeaveLevelEvent event) {
    if (!(event.getEntity() instanceof Player)) return;
    EventResourcePackManager.onPlayerLeaveDisableResourcePack((Player) event.getEntity(), FeatureFlags.UPDATE_1_21);
  }
}
