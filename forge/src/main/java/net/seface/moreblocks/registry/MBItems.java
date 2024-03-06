package net.seface.moreblocks.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.moreblocks.item.BigLilyPadBlockItem;
import net.seface.moreblocks.MoreBlocks;

import java.util.function.Supplier;

public class MBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreBlocks.ID);

    public static final RegistryObject<Item> SMALL_LILY_PADS = registerItem("small_lily_pads", () -> new PlaceOnWaterBlockItem(MBBlocks.SMALL_LILY_PADS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIG_LILY_PADS = registerItem("big_lily_pads", () -> new BigLilyPadBlockItem(MBBlocks.BIG_LILY_PAD.get(), new Item.Properties()));

    //public static final RegistryObject<Item> LEAVES_BUCKET = registerItem("leaves_bucket", () -> new LeavesBucketItem(MBBlocks.LEAF_LITTER.get(), new Item.Properties()));
    //public static final RegistryObject<Item> FROZEN_LEAVES_BUCKET = registerItem("frozen_leaves_bucket", () -> new LeavesBucketItem(MBBlocks.FROZEN_LEAF_LITTER.get(), new Item.Properties()));
    //public static final RegistryObject<Item> PINK_PETALS_BUCKET = registerItem("pink_petals_bucket", () -> new LeavesBucketItem(MBBlocks.PINK_PETALS_LITTER.get(), new Item.Properties()));

    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return MBItems.ITEMS.register(name, item);
    }

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
