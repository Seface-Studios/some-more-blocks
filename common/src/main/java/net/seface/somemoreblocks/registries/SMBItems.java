package net.seface.somemoreblocks.registries;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.item.CarvedPaleOakBlockItem;
import net.seface.somemoreblocks.item.LeavesBucketItem;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;

public class SMBItems {
  public static final PlatformRegistryObject<Item> AZALEA_LEAVES_BUCKET = PlatformServices.REGISTRY.registerItem("azalea_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MAX_VOLUME).stacksTo(1).setId(SomeMoreBlocks.key(Registries.ITEM, "azalea_leaves_bucket"))));
  public static final PlatformRegistryObject<Item> BIG_LILY_PAD = PlatformServices.REGISTRY.registerItem("big_lily_pad", () -> new PlaceOnWaterBlockItem(SMBBlocks.BIG_LILY_PAD.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "big_lily_pad"))));
  public static final PlatformRegistryObject<Item> TALL_BROWN_MUSHROOM_COLONY = PlatformServices.REGISTRY.registerItem("tall_brown_mushroom_colony", () -> new BlockItem(SMBBlocks.TALL_BROWN_MUSHROOM_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "tall_brown_mushroom_colony"))));
  public static final PlatformRegistryObject<Item> BROWN_MUSHROOM_COLONY = PlatformServices.REGISTRY.registerItem("brown_mushroom_colony", () -> new StandingAndWallBlockItem(SMBBlocks.BROWN_MUSHROOM_COLONY.get(), SMBBlocks.BROWN_MUSHROOM_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "brown_mushroom_colony"))));
  public static final PlatformRegistryObject<Item> TALL_CRIMSON_FUNGUS_COLONY = PlatformServices.REGISTRY.registerItem("tall_crimson_fungus_colony", () -> new BlockItem(SMBBlocks.TALL_CRIMSON_FUNGUS_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "tall_crimson_fungus_colony"))));
  public static final PlatformRegistryObject<Item> CRIMSON_FUNGUS_COLONY = PlatformServices.REGISTRY.registerItem("crimson_fungus_colony", () -> new StandingAndWallBlockItem(SMBBlocks.CRIMSON_FUNGUS_COLONY.get(), SMBBlocks.CRIMSON_FUNGUS_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "crimson_fungus_colony"))));
  public static final PlatformRegistryObject<Item> FLOWERING_AZALEA_LEAVES_BUCKET = PlatformServices.REGISTRY.registerItem("flowering_azalea_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.FLOWERING_AZALEA_LEAF_LITTER.get(), SoundEvents.AZALEA_LEAVES_PLACE, new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MAX_VOLUME).stacksTo(1).setId(SomeMoreBlocks.key(Registries.ITEM, "flowering_azalea_leaves_bucket"))));
  public static final PlatformRegistryObject<Item> SPRUCE_LEAVES_BUCKET = PlatformServices.REGISTRY.registerItem("spruce_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.SPRUCE_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MAX_VOLUME).stacksTo(1).setId(SomeMoreBlocks.key(Registries.ITEM, "spruce_leaves_bucket"))));
  public static final PlatformRegistryObject<Item> BIRCH_LEAVES_BUCKET = PlatformServices.REGISTRY.registerItem("birch_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.BIRCH_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MAX_VOLUME).stacksTo(1).setId(SomeMoreBlocks.key(Registries.ITEM, "birch_leaves_bucket"))));
  public static final PlatformRegistryObject<Item> LEAVES_BUCKET = PlatformServices.REGISTRY.registerItem("leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MAX_VOLUME).stacksTo(1).setId(SomeMoreBlocks.key(Registries.ITEM, "leaves_bucket"))));
  public static final PlatformRegistryObject<Item> CLOVER = PlatformServices.REGISTRY.registerItem("clover", () -> new BlockItem(SMBBlocks.CLOVER.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "clover"))));
  public static final PlatformRegistryObject<Item> NETHER_CLOVER = PlatformServices.REGISTRY.registerItem("nether_clover", () -> new BlockItem(SMBBlocks.NETHER_CLOVER.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "nether_clover"))));
  public static final PlatformRegistryObject<Item> TALL_RED_MUSHROOM_COLONY = PlatformServices.REGISTRY.registerItem("tall_red_mushroom_colony", () -> new BlockItem(SMBBlocks.TALL_RED_MUSHROOM_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "tall_red_mushroom_colony"))));
  public static final PlatformRegistryObject<Item> RED_MUSHROOM_COLONY = PlatformServices.REGISTRY.registerItem("red_mushroom_colony", () -> new StandingAndWallBlockItem(SMBBlocks.RED_MUSHROOM_COLONY.get(), SMBBlocks.RED_MUSHROOM_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "red_mushroom_colony"))));
  public static final PlatformRegistryObject<Item> TALL_WARPED_FUNGUS_COLONY = PlatformServices.REGISTRY.registerItem("tall_warped_fungus_colony", () -> new BlockItem(SMBBlocks.TALL_WARPED_FUNGUS_COLONY.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "tall_warped_fungus_colony"))));
  public static final PlatformRegistryObject<Item> WARPED_FUNGUS_COLONY = PlatformServices.REGISTRY.registerItem("warped_fungus_colony", () -> new StandingAndWallBlockItem(SMBBlocks.WARPED_FUNGUS_COLONY.get(), SMBBlocks.WARPED_FUNGUS_COLONY_WALL.get(), Direction.DOWN, new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "warped_fungus_colony"))));
  public static final PlatformRegistryObject<Item> SMALL_LILY_PADS = PlatformServices.REGISTRY.registerItem("small_lily_pads", () -> new PlaceOnWaterBlockItem(SMBBlocks.SMALL_LILY_PADS.get(), new Item.Properties().useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "small_lily_pads"))));

  /* 1.21.4 */
  public static final PlatformRegistryObject<Item> PALE_OAK_LEAVES_BUCKET = PlatformServices.REGISTRY.registerItem("pale_oak_leaves_bucket", () -> new LeavesBucketItem(SMBBlocks.PALE_OAK_LEAF_LITTER.get(), SoundEvents.GRASS_PLACE, new Item.Properties().component(SMBDataComponentTypes.BUCKET_VOLUME.get(), LeavesBucketItem.MAX_VOLUME).stacksTo(1).setId(SomeMoreBlocks.key(Registries.ITEM, "pale_oak_leaves_bucket"))));
  public static final PlatformRegistryObject<Item> CARVED_PALE_OAK_LOG = PlatformServices.REGISTRY.registerItem("carved_pale_oak_log", () -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_LOG.get(), new Item.Properties().component(SMBDataComponentTypes.MOON_PHASE.get(), RotatedCarvedPaleOakBlock.MIN_MOON_PHASE).useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "carved_pale_oak_log"))));
  public static final PlatformRegistryObject<Item> CARVED_PALE_OAK_WOOD = PlatformServices.REGISTRY.registerItem("carved_pale_oak_wood", () -> new CarvedPaleOakBlockItem(SMBBlocks.CARVED_PALE_OAK_WOOD.get(), new Item.Properties().component(SMBDataComponentTypes.MOON_PHASE.get(), RotatedCarvedPaleOakBlock.MIN_MOON_PHASE).useBlockDescriptionPrefix().setId(SomeMoreBlocks.key(Registries.ITEM, "carved_pale_oak_wood"))));

  public static void init() {}
}
