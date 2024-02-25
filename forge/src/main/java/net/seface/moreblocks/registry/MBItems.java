package net.seface.moreblocks.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.seface.moreblocks.MoreBlocks;

public class MBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreBlocks.ID);

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
