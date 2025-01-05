package net.seface.somemoreblocks.registry;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.MoreBlocks;
import net.seface.somemoreblocks.item.LeavesBucketItem;

import java.util.function.Supplier;

public class MBItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreBlocks.ID);

  public static final RegistryObject<Item> AZALEA_LEAVES_BUCKET = registerItem("azalea_leaves_bucket", () -> new LeavesBucketItem(MBBlocks.AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> BIG_LILY_PAD = registerItem("big_lily_pad", () -> new PlaceOnWaterBlockItem(MBBlocks.BIG_LILY_PAD.get(), new Item.Properties().rarity(Rarity.EPIC)));
  public static final RegistryObject<Item> BROWN_MUSHROOM_COLONY = registerItem("brown_mushroom_colony", () -> new StandingAndWallBlockItem(MBBlocks.BROWN_MUSHROOM_COLONY.get(), MBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> CRIMSON_FUNGUS_COLONY = registerItem("crimson_fungus_colony", () -> new StandingAndWallBlockItem(MBBlocks.CRIMSON_FUNGUS_COLONY.get(), MBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> FLOWERING_AZALEA_LEAVES_BUCKET = registerItem("flowering_azalea_leaves_bucket", () -> new LeavesBucketItem(MBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> SPRUCE_LEAVES_BUCKET = registerItem("spruce_leaves_bucket", () -> new LeavesBucketItem(MBBlocks.SPRUCE_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> BIRCH_LEAVES_BUCKET = registerItem("birch_leaves_bucket", () -> new LeavesBucketItem(MBBlocks.BIRCH_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> LEAVES_BUCKET = registerItem("leaves_bucket", () -> new LeavesBucketItem(MBBlocks.LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> RED_MUSHROOM_COLONY = registerItem("red_mushroom_colony", () -> new StandingAndWallBlockItem(MBBlocks.RED_MUSHROOM_COLONY.get(), MBBlocks.RED_MUSHROOM_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> WARPED_FUNGUS_COLONY = registerItem("warped_fungus_colony", () -> new StandingAndWallBlockItem(MBBlocks.WARPED_FUNGUS_COLONY.get(), MBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> SMALL_LILY_PADS = registerItem("small_lily_pads", () -> new PlaceOnWaterBlockItem(MBBlocks.SMALL_LILY_PADS.get(), new Item.Properties()));

  public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item) {
      return MBItems.ITEMS.register(name, item);
  }

  public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
