package net.seface.somemoreblocks;

/**
 * Constants values to be used between multiple mod loaders.
 */
public abstract class Constants {
  /*
   * Seface Studios Color Palette
   * */
  public static final int AMESFACE_COLOR = 8418303;  // #8073FF
  public static final int GREENFUL_COLOR = 13959034; // #D4FF7A
  public static final int BLUENIVERS_COLOR = 4666;   // #00123A

  /*
   * Fuel Values
   * */
  private static final int $COAL_BLOCK_FUEL = 16000;
  private static final int $MAX_FUEL = 32767;
  public static final int COAL_BRICKS_FUEL = $COAL_BLOCK_FUEL * 2;
  public static final int COAL_PILLAR_FUEL = $COAL_BLOCK_FUEL;
  public static final int CRACKED_COAL_BRICKS_FUEL = $COAL_BLOCK_FUEL + 3200;
  public static final int CRACKED_CUT_COAL_FUEL = $COAL_BLOCK_FUEL + 3800;
  public static final int CUT_COAL_FUEL = $MAX_FUEL;

  /*
   * Shingles Strength Property
   * */
  public static final float SHINGLES_DESTROY_TIME = 1.25F;
  public static final float SHINGLES_EXPLOSION_RESISTANCE = 4.2F;

  /*
   * Luminous Flower Light Level
   * */
  public static final int POTTED_LUMINOUS_FLOWER_LIGHT_LEVEL = 10;
  public static final int LUMINOUS_FLOWER_LIGHT_LEVEL = 10;

  /*
   * Leaf Litter Generate Chances Value
   * */
  public static final float AZALEA_LEAF_LITTER_CHANCE = 15.0F;
  public static final float BIRCH_LEAF_LITTER_CHANCE = 12.5F;
  public static final float FLOWERING_AZALEA_LEAF_LITTER_CHANCE = 10.0F;
  public static final float SPRUCE_LEAF_LITTER_CHANCE = 12.5F;
  public static final float LEAF_LITTER_CHANCE = 12.5F;
  public static final float PALE_OAK_LEAF_LITTER_CHANCE = 12.5F;

  /*
   * Chiseled Purpur Light Level
   * */
  public static final int CHISELED_PURPUR_LIGHT_LEVEL = 14;
}
