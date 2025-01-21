package net.seface.somemoreblocks.registries;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.LeavesBucketItem;

import java.util.function.Supplier;

public class SMBItems {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SomeMoreBlocks.ID);

  public static final RegistryObject<Item> AZALEA_LEAVES_BUCKET = registerItem("azalea_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().stacksTo(1).setId(ITEMS.key("azalea_leaves_bucket"))));
  public static final RegistryObject<Item> BIG_LILY_PAD = registerItem("big_lily_pad", () -> new PlaceOnWaterBlockItem(SMBBlocks.BIG_LILY_PAD.get(), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("big_lily_pad"))));
  public static final RegistryObject<Item> TALL_BROWN_MUSHROOM_COLONY = registerItem("tall_brown_mushroom_colony", () -> new BlockItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("tall_brown_mushroom_colony"))));
  public static final RegistryObject<Item> BROWN_MUSHROOM_COLONY = registerItem("brown_mushroom_colony", () -> new StandingAndWallBlockItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("brown_mushroom_colony"))));
  public static final RegistryObject<Item> TALL_CRIMSON_FUNGUS_COLONY = registerItem("tall_crimson_fungus_colony", () -> new BlockItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("tall_crimson_fungus_colony"))));
  public static final RegistryObject<Item> CRIMSON_FUNGUS_COLONY = registerItem("crimson_fungus_colony", () -> new StandingAndWallBlockItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("crimson_fungus_colony"))));
  public static final RegistryObject<Item> FLOWERING_AZALEA_LEAVES_BUCKET = registerItem("flowering_azalea_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().stacksTo(1).setId(ITEMS.key("flowering_azalea_leaves_bucket"))));
  public static final RegistryObject<Item> SPRUCE_LEAVES_BUCKET = registerItem("spruce_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1).setId(ITEMS.key("spruce_leaves_bucket"))));
  public static final RegistryObject<Item> BIRCH_LEAVES_BUCKET = registerItem("birch_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.BIRCH_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1).setId(ITEMS.key("birch_leaves_bucket"))));
  public static final RegistryObject<Item> LEAVES_BUCKET = registerItem("leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1).setId(ITEMS.key("leaves_bucket"))));
  public static final RegistryObject<Item> TALL_RED_MUSHROOM_COLONY = registerItem("tall_red_mushroom_colony", () -> new BlockItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("tall_red_mushroom_colony"))));
  public static final RegistryObject<Item> RED_MUSHROOM_COLONY = registerItem("red_mushroom_colony", () -> new StandingAndWallBlockItem(SMBBlocks.RED_MUSHROOM_COLONY.get(), SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("red_mushroom_colony"))));
  public static final RegistryObject<Item> TALL_WARPED_FUNGUS_COLONY = registerItem("tall_warped_fungus_colony", () -> new BlockItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("tall_warped_fungus_colony"))));
  public static final RegistryObject<Item> WARPED_FUNGUS_COLONY = registerItem("warped_fungus_colony", () -> new StandingAndWallBlockItem(SMBBlocks.WARPED_FUNGUS_COLONY.get(), SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC).setId(ITEMS.key("warped_fungus_colony"))));
  public static final RegistryObject<Item> SMALL_LILY_PADS = registerItem("small_lily_pads", () -> new PlaceOnWaterBlockItem(SMBBlocks.SMALL_LILY_PADS.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS.key("small_lily_pads"))));

  /* 1.21.4 */
  public static final RegistryObject<Item> PALE_OAK_LEAVES_BUCKET = registerItem("pale_oak_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().stacksTo(1).setId(ITEMS.key("pale_oak_leaves_bucket"))));
  public static final RegistryObject<Item> CARVED_PALE_OAK_LOG = registerItem("carved_pale_oak_log", () -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_LOG.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS.key("carved_pale_oak_log"))));
  public static final RegistryObject<Item> CARVED_PALE_OAK_WOOD = registerItem("carved_pale_oak_wood", () -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_WOOD.get(), new Item.Properties().useBlockDescriptionPrefix().setId(ITEMS.key("carved_pale_oak_wood"))));


  public static RegistryObject<Item> registerItem(String path, Supplier<Item> item) {
    return SMBItems.ITEMS.register(path, item);
  }

  public static void register(IEventBus event) {
        ITEMS.register(event);
    }
}
