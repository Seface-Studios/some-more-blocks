package net.seface.somemoreblocks.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.WorldData;
import net.seface.somemoreblocks.Constants;
import net.seface.somemoreblocks.SomeMoreBlocks;
import org.jetbrains.annotations.Nullable;

/**
 * This manager is not being used on Mod's version 1.21.x.
 *   - Resource Pack Name Translation key: "somemoreblocks.resourcepack.[rp_path].name"
 *   - Resource Pack Enabled Translation key: "somemoreblocks.resourcepack.[rp_path].enabled"
 *   - Resource Pack "Read More" Translation key: "somemoreblocks.resourcepack.[rp_path].read_more"
 *   - Resource Pack "Read More" tooltip Translation key: "somemoreblocks.resourcepack.[rp_path].read_more.hover"
 */
@Deprecated
public class EventResourcePackManager {

  public static final ResourceLocation NONE = ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, "none");

  /**
   * Should be triggered with the Player/Entity join world/server event.
   * Will depend on how ModLoader handles this event.
   *
   * @param player The affected player.
   * @param featureFlag The feature flag to filter valid worlds.
   */
  public static void onPlayerJoinEnableResourcePack(Player player, @Nullable FeatureFlag featureFlag) {
    if (!Minecraft.getInstance().getGameProfile().equals(player.getGameProfile())) return;
    if (featureFlag == null) return;

    Level world = player.level();
    if (world.isClientSide()) return;

    WorldData worldData = world.getServer().getWorldData();

    if (!worldData.enabledFeatures().contains(featureFlag)) return;

    String tagID = ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, "hide_" + NONE.getPath() + "_message").toString();
    ClientResourcePackManager.enableResourcePack(NONE);

    if (player.getTags().contains(tagID)) return;

    MutableComponent prefix = Component.literal(SomeMoreBlocks.MOD_NAME).withColor(Constants.AMESFACE_COLOR)
      .append(Component.literal(" › ").withStyle(ChatFormatting.GRAY));

    String readMoreURL = "https://github.com/Seface-Studios/some-more-blocks/tree/main/common/src/main/resources/resourcepacks";
    HoverEvent readMoreHover = new HoverEvent(
      HoverEvent.Action.SHOW_TEXT,
      Component.translatable("somemoreblocks.resourcepack." + NONE.getPath() + ".read_more.hover"));

    MutableComponent message = Component.translatable("somemoreblocks.resourcepack." + NONE.getPath() + ".enabled")
      .withStyle(style -> style.withColor(ChatFormatting.GRAY))
      .append(" ")
      .append(Component.translatable("somemoreblocks.resourcepack." + NONE.getPath() + ".read_more")
        .withColor(Constants.GREENFUL_COLOR)
        .withStyle(style ->
          style.withHoverEvent(readMoreHover)
            .withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, readMoreURL))
            .withUnderlined(true)));

    message = prefix.append(message);
    player.displayClientMessage(message, false);
    player.getTags().add(tagID);
  }

  /**
   * Should be triggered with the Player/Entity leave world/server event.
   * Will depend on how ModLoader handles this event.
   *
   * @param player The affected player.
   * @param featureFlag The feature flag to filter valid worlds.
   */
  public static void onPlayerLeaveDisableResourcePack(Player player, @Nullable FeatureFlag featureFlag) {
    if (!Minecraft.getInstance().getGameProfile().equals(player.getGameProfile())) return;
    if (featureFlag == null) return;

    Level world = player.level();
    if (world.isClientSide()) return;

    WorldData worldData = world.getServer().getWorldData();

    if (!worldData.enabledFeatures().contains(featureFlag)) return;
    ClientResourcePackManager.disableResourcePack(NONE);
  }
}
