package net.seface.somemoreblocks.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.seface.somemoreblocks.SomeMoreBlocks;

@Mod.EventBusSubscriber(modid = SomeMoreBlocks.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerJoinOrLeaveWorldEvents {

  @SubscribeEvent
  public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
    if (!(event.getEntity() instanceof Player)) return;
    OnPlayerJoinOrLeaveWorld.enableResourcePackOnPlayerJoinWorld((Player) event.getEntity());
  }

  @SubscribeEvent
  public static void onPlayerLeaveWorld(EntityLeaveLevelEvent event) {
    if (!(event.getEntity() instanceof Player)) return;
    OnPlayerJoinOrLeaveWorld.disableResourcePackOnPlayerLeaveWorld((Player) event.getEntity());
  }
}
