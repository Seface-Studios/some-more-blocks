package net.seface.somemoreblocks.utils;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackRepository;

import java.util.List;

public class ClientResourcePackManager {
  private static final Minecraft client = Minecraft.getInstance();
  private static final PackRepository repo = client.getResourcePackRepository();

  /**
   * Enable specific Resource Pack.
   * @param identifier The Resource Pack identifier.
   */
  public static void enableResourcePack(ResourceLocation identifier) {
    String stringifiedId = identifier.toString();
    Pack pack = repo.getPack(stringifiedId);
    List<Pack> selectedPacks = Lists.newArrayList(repo.getSelectedPacks());

    if (selectedPacks.contains(pack)) return;
    selectedPacks.add(pack);

    updateSelectedList(selectedPacks);
    client.options.resourcePacks.add(stringifiedId);
    client.options.save();

    client.reloadResourcePacks();
  }

  /**
   * Disable specific Resource Pack.
   * @param identifier The Resource Pack identifier.
   */
  public static void disableResourcePack(ResourceLocation identifier) {
    String stringifiedId = identifier.toString();
    Pack pack = repo.getPack(stringifiedId);
    List<Pack> selectedPacks = Lists.newArrayList(repo.getSelectedPacks());

    if (!selectedPacks.contains(pack)) return;
    selectedPacks.remove(pack);

    updateSelectedList(selectedPacks);
    client.options.resourcePacks.remove(stringifiedId);
    client.options.save();

    client.reloadResourcePacks();
  }

  /**
   * Update the client-side Resource Pack selected list.
   * @param list The client-side Resource Pack selected list.
   */
  private static void updateSelectedList(List<Pack> list) {
    repo.setSelected(list.stream().map(Pack::getId).collect(ImmutableList.toImmutableList()));
    repo.reload();
  }
}
