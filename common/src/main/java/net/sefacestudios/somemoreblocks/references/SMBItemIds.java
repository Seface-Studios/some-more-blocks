package net.sefacestudios.somemoreblocks.references;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.sefacestudios.somemoreblocks.SomeMoreBlocks;
import org.jetbrains.annotations.NotNull;

public class SMBItemIds {
  public static final ResourceKey<Item> AZALEA_LEAVES_BUCKET = create("azalea_leaves_bucket");
  public static final ResourceKey<Item> BIG_LILY_PAD = create("big_lily_pad");
  public static final ResourceKey<Item> TALL_BROWN_MUSHROOM_COLONY = create("tall_brown_mushroom_colony");
  public static final ResourceKey<Item> BROWN_MUSHROOM_COLONY = create("brown_mushroom_colony");
  public static final ResourceKey<Item> TALL_CRIMSON_FUNGUS_COLONY = create("tall_crimson_fungus_colony");
  public static final ResourceKey<Item> CRIMSON_FUNGUS_COLONY = create("crimson_fungus_colony");
  public static final ResourceKey<Item> FLOWERING_AZALEA_LEAVES_BUCKET = create("flowering_azalea_leaves_bucket");
  public static final ResourceKey<Item> SPRUCE_LEAVES_BUCKET = create("spruce_leaves_bucket");
  public static final ResourceKey<Item> BIRCH_LEAVES_BUCKET = create("birch_leaves_bucket");
  public static final ResourceKey<Item> LEAVES_BUCKET = create("leaves_bucket");
  public static final ResourceKey<Item> CLOVER = create("clover");
  public static final ResourceKey<Item> NETHER_CLOVER = create("nether_clover");
  public static final ResourceKey<Item> TALL_RED_MUSHROOM_COLONY = create("tall_red_mushroom_colony");
  public static final ResourceKey<Item> RED_MUSHROOM_COLONY = create("red_mushroom_colony");
  public static final ResourceKey<Item> TALL_WARPED_FUNGUS_COLONY = create("tall_warped_fungus_colony");
  public static final ResourceKey<Item> WARPED_FUNGUS_COLONY = create("warped_fungus_colony");
  public static final ResourceKey<Item> SMALL_LILY_PADS = create("small_lily_pads");
  public static final ResourceKey<Item> PALE_OAK_LEAVES_BUCKET = create("pale_oak_leaves_bucket");
  public static final ResourceKey<Item> CARVED_PALE_OAK_LOG = create("carved_pale_oak_log");
  public static final ResourceKey<Item> CARVED_PALE_OAK_WOOD = create("carved_pale_oak_wood");
  public static final ResourceKey<Item> PALE_MUSHROOM = create("pale_mushroom");
  public static final ResourceKey<Item> TALL_PALE_MUSHROOM_COLONY = create("tall_pale_mushroom_colony");
  public static final ResourceKey<Item> PALE_MUSHROOM_COLONY = create("pale_mushroom_colony");
  public static final ResourceKey<Item> DRY_LEAVES_BUCKET = create("dry_leaves_bucket");
  public static final ResourceKey<Item> DUCKWEED = create("duckweed");
  public static final ResourceKey<Item> PEBBLES = create("pebbles");

  private static ResourceKey<Item> create(String name) {
    return SomeMoreBlocks.key(Registries.ITEM, name);
  }
}
