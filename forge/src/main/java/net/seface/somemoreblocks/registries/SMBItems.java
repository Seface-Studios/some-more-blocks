package net.seface.somemoreblocks.registries;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.item.LeavesBucketItem;

import java.util.function.Supplier;

public class SMBItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SomeMoreBlocks.ID);

  public static final RegistryObject<Item> AZALEA_LEAVES_BUCKET = registerItem("azalea_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> BIG_LILY_PAD = registerItem("big_lily_pad", () -> new PlaceOnWaterBlockItem(SMBBlocks.BIG_LILY_PAD.get(), new Item.Properties().rarity(Rarity.EPIC)));
  public static final RegistryObject<Item> TALL_BROWN_MUSHROOM_COLONY = registerItem("tall_brown_mushroom_colony", () -> new BlockItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), new Item.Properties().rarity(Rarity.EPIC)));
  public static final RegistryObject<Item> BROWN_MUSHROOM_COLONY = registerItem("brown_mushroom_colony", () -> new StandingAndWallBlockItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> TALL_CRIMSON_FUNGUS_COLONY = registerItem("tall_crimson_fungus_colony", () -> new BlockItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), new Item.Properties().rarity(Rarity.EPIC)));
  public static final RegistryObject<Item> CRIMSON_FUNGUS_COLONY = registerItem("crimson_fungus_colony", () -> new StandingAndWallBlockItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> FLOWERING_AZALEA_LEAVES_BUCKET = registerItem("flowering_azalea_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> SPRUCE_LEAVES_BUCKET = registerItem("spruce_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> BIRCH_LEAVES_BUCKET = registerItem("birch_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.BIRCH_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> LEAVES_BUCKET = registerItem("leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1)));
  public static final RegistryObject<Item> TALL_RED_MUSHROOM_COLONY = registerItem("tall_red_mushroom_colony", () -> new BlockItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), new Item.Properties().rarity(Rarity.EPIC)));
  public static final RegistryObject<Item> RED_MUSHROOM_COLONY = registerItem("red_mushroom_colony", () -> new StandingAndWallBlockItem(SMBBlocks.RED_MUSHROOM_COLONY.get(), SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> TALL_WARPED_FUNGUS_COLONY = registerItem("tall_warped_fungus_colony", () -> new BlockItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), new Item.Properties().rarity(Rarity.EPIC)));
  public static final RegistryObject<Item> WARPED_FUNGUS_COLONY = registerItem("warped_fungus_colony", () -> new StandingAndWallBlockItem(SMBBlocks.WARPED_FUNGUS_COLONY.get(), SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), new Item.Properties().rarity(Rarity.EPIC), Direction.DOWN));
  public static final RegistryObject<Item> SMALL_LILY_PADS = registerItem("small_lily_pads", () -> new PlaceOnWaterBlockItem(SMBBlocks.SMALL_LILY_PADS.get(), new Item.Properties()));

  /**
   * Create and register a generic item.
   *
   * @param identifier The Item identifier.
   * @param item The item instance.
   */
  public static <T extends Item> RegistryObject<T> registerItem(String identifier, Supplier<T> item) {
      return SMBItems.ITEMS.register(identifier, item);
  }

  public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
