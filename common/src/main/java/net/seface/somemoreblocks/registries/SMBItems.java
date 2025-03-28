package net.seface.somemoreblocks.registries;

import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.component.SMBDataComponentTypes;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.platform.PlatformServices;

import java.util.function.Supplier;

public class SMBItems {
  public static final Supplier<Item> AZALEA_LEAVES_BUCKET = PlatformServices.PLATFORM_REGISTRY.registerItem("azalea_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, properties), new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME, LeavesBucketItem.MAX_VOLUME).stacksTo(1));
  public static final Supplier<Item> BIG_LILY_PAD = PlatformServices.PLATFORM_REGISTRY.registerItem("big_lily_pad", (properties) -> new PlaceOnWaterBlockItem(SMBBlocks.BIG_LILY_PAD.get(), properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> TALL_BROWN_MUSHROOM_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("tall_brown_mushroom_colony", (properties) -> new BlockItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> BROWN_MUSHROOM_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("brown_mushroom_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> TALL_CRIMSON_FUNGUS_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("tall_crimson_fungus_colony", (properties) -> new BlockItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> CRIMSON_FUNGUS_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("crimson_fungus_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> FLOWERING_AZALEA_LEAVES_BUCKET = PlatformServices.PLATFORM_REGISTRY.registerItem("flowering_azalea_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, properties), new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME, LeavesBucketItem.MAX_VOLUME).stacksTo(1));
  public static final Supplier<Item> SPRUCE_LEAVES_BUCKET = PlatformServices.PLATFORM_REGISTRY.registerItem("spruce_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, properties), new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME, LeavesBucketItem.MAX_VOLUME).stacksTo(1));
  public static final Supplier<Item> BIRCH_LEAVES_BUCKET = PlatformServices.PLATFORM_REGISTRY.registerItem("birch_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.BIRCH_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, properties), new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME, LeavesBucketItem.MAX_VOLUME).stacksTo(1));
  public static final Supplier<Item> LEAVES_BUCKET = PlatformServices.PLATFORM_REGISTRY.registerItem("leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, properties), new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME, LeavesBucketItem.MAX_VOLUME).stacksTo(1));
  public static final Supplier<Item> TALL_RED_MUSHROOM_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("tall_red_mushroom_colony", (properties) -> new BlockItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> RED_MUSHROOM_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("red_mushroom_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.RED_MUSHROOM_COLONY.get(), SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> TALL_WARPED_FUNGUS_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("tall_warped_fungus_colony", (properties) -> new BlockItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> WARPED_FUNGUS_COLONY = PlatformServices.PLATFORM_REGISTRY.registerItem("warped_fungus_colony", (properties) -> new StandingAndWallBlockItem(SMBBlocks.WARPED_FUNGUS_COLONY.get(), SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), Direction.DOWN, properties), new Item.Properties().useBlockDescriptionPrefix().rarity(Rarity.EPIC));
  public static final Supplier<Item> SMALL_LILY_PADS = PlatformServices.PLATFORM_REGISTRY.registerItem("small_lily_pads", (properties) -> new PlaceOnWaterBlockItem(SMBBlocks.SMALL_LILY_PADS.get(), properties), new Item.Properties().useBlockDescriptionPrefix());

  /* 1.21.4 */
  public static final Supplier<Item> PALE_OAK_LEAVES_BUCKET = PlatformServices.PLATFORM_REGISTRY.registerItem("pale_oak_leaves_bucket", (properties) -> new LeavesBucketItem(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, properties), new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME, LeavesBucketItem.MAX_VOLUME).stacksTo(1));
  public static final Supplier<Item> CARVED_PALE_OAK_LOG = PlatformServices.PLATFORM_REGISTRY.registerItem("carved_pale_oak_log", (properties) -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_LOG.get(), properties), new Item.Properties().component(SMBDataComponentTypes.MOON_PHASE, RotatedCarvedPaleOakBlock.MIN_MOON_PHASE).useBlockDescriptionPrefix());
  public static final Supplier<Item> CARVED_PALE_OAK_WOOD = PlatformServices.PLATFORM_REGISTRY.registerItem("carved_pale_oak_wood", (properties) -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_WOOD.get(), properties), new Item.Properties().component(SMBDataComponentTypes.MOON_PHASE, RotatedCarvedPaleOakBlock.MIN_MOON_PHASE).useBlockDescriptionPrefix());

  public static void init() {}
}
