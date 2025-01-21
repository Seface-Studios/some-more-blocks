package net.seface.somemoreblocks.registries;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.LeavesBucketItem;

import java.util.function.Function;

public class SMBItems {

  public static final Item AZALEA_LEAVES_BUCKET = registerItem("azalea_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.AZALEA_LEAF_LITTER, SoundEvents.AZALEA_LEAVES_PLACE, properties), new Item.Properties().stacksTo(1));
  public static final Item BIG_LILY_PAD = registerItem("big_lily_pad", (properties) -> new PlaceOnWaterBlockItem(SMBBlocks.BIG_LILY_PAD, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item TALL_BROWN_MUSHROOM_COLONY = registerItem("tall_brown_mushroom_colony", (properties) -> new BlockItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item BROWN_MUSHROOM_COLONY = registerItem("brown_mushroom_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.BROWN_MUSHROOM_COLONY, SMBBlocks.BROWN_MUSHROOM_COLONY_WALL, Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item TALL_CRIMSON_FUNGUS_COLONY = registerItem("tall_crimson_fungus_colony", (properties) -> new BlockItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item CRIMSON_FUNGUS_COLONY = registerItem("crimson_fungus_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.CRIMSON_FUNGUS_COLONY, SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL, Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item FLOWERING_AZALEA_LEAVES_BUCKET = registerItem("flowering_azalea_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER, SoundEvents.AZALEA_LEAVES_PLACE, properties), new Item.Properties().stacksTo(1));
  public static final Item SPRUCE_LEAVES_BUCKET = registerItem("spruce_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.SPRUCE_LEAF_LITTER, SoundEvents.GRASS_PLACE, properties), new Item.Properties().stacksTo(1));
  public static final Item BIRCH_LEAVES_BUCKET = registerItem("birch_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.BIRCH_LEAF_LITTER, SoundEvents.GRASS_PLACE, properties), new Item.Properties().stacksTo(1));
  public static final Item LEAVES_BUCKET = registerItem("leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.LEAF_LITTER, SoundEvents.GRASS_PLACE, properties), new Item.Properties().stacksTo(1));
  public static final Item TALL_RED_MUSHROOM_COLONY = registerItem("tall_red_mushroom_colony", (properties) -> new BlockItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item RED_MUSHROOM_COLONY = registerItem("red_mushroom_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.RED_MUSHROOM_COLONY, SMBBlocks.RED_MUSHROOM_COLONY_WALL, Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item TALL_WARPED_FUNGUS_COLONY = registerItem("tall_warped_fungus_colony", (properties) -> new BlockItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item WARPED_FUNGUS_COLONY = registerItem("warped_fungus_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.WARPED_FUNGUS_COLONY, SMBBlocks.WARPED_FUNGUS_COLONY_WALL, Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Item SMALL_LILY_PADS = registerItem("small_lily_pads", (properties) -> new PlaceOnWaterBlockItem(SMBBlocks.SMALL_LILY_PADS, properties), new Item.Properties().useBlockDescriptionPrefix());

  /* 1.21.4 */
  public static final Item PALE_OAK_LEAVES_BUCKET = registerItem("pale_oak_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.PALE_OAK_LEAF_LITTER, SoundEvents.GRASS_PLACE, properties), new Item.Properties().stacksTo(1));
  public static final Item CARVED_PALE_OAK_LOG = registerItem("carved_pale_oak_log", (properties -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_LOG, properties)), new Item.Properties().useBlockDescriptionPrefix());
  public static final Item CARVED_PALE_OAK_WOOD = registerItem("carved_pale_oak_wood", (properties -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_WOOD, properties)), new Item.Properties().useBlockDescriptionPrefix());

  public static void init() {}

  public static Item registerItem(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
    ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, path);
    ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, identifier);

    return Items.registerItem(key, factory, properties);
  }
}
