package net.seface.moreblocks.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.moreblocks.item.BigLilyPadBlockItem;
import net.seface.moreblocks.MoreBlocks;
import net.seface.moreblocks.item.CrackingToolItem;
import net.seface.moreblocks.item.MushroomColonyBlockItem;

import java.util.function.Supplier;

public class MBItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreBlocks.ID);

    public static final RegistryObject<Item> SMALL_LILY_PADS = registerItem("small_lily_pads", () -> new PlaceOnWaterBlockItem(MBBlocks.SMALL_LILY_PADS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIG_LILY_PAD = registerItem("big_lily_pad", () -> new BigLilyPadBlockItem(MBBlocks.BIG_LILY_PAD.get(), new Item.Properties()));

    public static final RegistryObject<Item> LEAVES_BUCKET = registerItem("leaves_bucket", () -> new SolidBucketItem(MBBlocks.LEAF_LITTER.get(), SoundEvents.AMETHYST_BLOCK_PLACE, new Item.Properties()));
    public static final RegistryObject<Item> FROZEN_LEAVES_BUCKET = registerItem("frozen_leaves_bucket", () -> new SolidBucketItem(MBBlocks.FROZEN_LEAF_LITTER.get(), SoundEvents.TNT_PRIMED, new Item.Properties()));
    public static final RegistryObject<Item> PINK_PETALS_BUCKET = registerItem("pink_petals_bucket", () -> new SolidBucketItem(MBBlocks.PINK_PETALS_LITTER.get(), SoundEvents.FROG_AMBIENT, new Item.Properties()));

    public static final RegistryObject<Item> BROWN_MUSHROOM_COLONY = registerItem("brown_mushroom_colony", () -> new MushroomColonyBlockItem(MBBlocks.BROWN_MUSHROOM_COLONY.get(), MBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> RED_MUSHROOM_COLONY = registerItem("red_mushroom_colony", () -> new MushroomColonyBlockItem(MBBlocks.RED_MUSHROOM_COLONY.get(), MBBlocks.RED_MUSHROOM_COLONY_WALL.get(), new Item.Properties()));


    public static final RegistryObject<Item> CRACKING_TOOL = registerItem("cracking_tool", () -> new CrackingToolItem(new Item.Properties().durability(238)));

    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
        return MBItems.ITEMS.register(name, item);
    }

    public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
