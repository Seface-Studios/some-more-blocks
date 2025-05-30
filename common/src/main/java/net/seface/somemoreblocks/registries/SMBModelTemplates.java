package net.seface.somemoreblocks.registries;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.Optional;

public class SMBModelTemplates {
  public static final ModelTemplate SQUARE_HORIZONTAL = create("square_horizontal", TextureSlot.TEXTURE);
  public static final ModelTemplate SQUARE_VERTICAL = create("square_vertical", TextureSlot.TEXTURE);
  public static final ModelTemplate TINTED_FLOWERBED_1 = create("tinted_flowerbed_1", "_1", TextureSlot.FLOWERBED, TextureSlot.STEM);
  public static final ModelTemplate TINTED_FLOWERBED_2 = create("tinted_flowerbed_2", "_2", TextureSlot.FLOWERBED, TextureSlot.STEM);
  public static final ModelTemplate TINTED_FLOWERBED_3 = create("tinted_flowerbed_3", "_3", TextureSlot.FLOWERBED, TextureSlot.STEM);
  public static final ModelTemplate TINTED_FLOWERBED_4 = create("tinted_flowerbed_4", "_4", TextureSlot.FLOWERBED, TextureSlot.STEM);
  public static final ModelTemplate NETHER_FLOWERBED_1 = create("nether_flowerbed_1", "_1", TextureSlot.FLOWERBED, TextureSlot.STEM);
  public static final ModelTemplate NETHER_FLOWERBED_2 = create("nether_flowerbed_2", "_2", TextureSlot.FLOWERBED, TextureSlot.STEM);
  public static final ModelTemplate NETHER_FLOWERBED_3 = create("nether_flowerbed_3", "_3", TextureSlot.FLOWERBED, TextureSlot.STEM);
  public static final ModelTemplate NETHER_FLOWERBED_4 = create("nether_flowerbed_4", "_4", TextureSlot.FLOWERBED, TextureSlot.STEM);

  public static ModelTemplate create(String path, TextureSlot ...textureSlots) {
    return create(path, "", textureSlots);
  }

  /**
   * Create a new Model Template to be used in multiple block models.
   * @param path The identifier path.
   * @param textureSlots All the texture slots at the model.
   * @return The new model template
   */
  public static ModelTemplate create(String path, String suffix, TextureSlot ...textureSlots) {
    return new ModelTemplate(Optional.of(SomeMoreBlocks.id("block/templates/" + path)), Optional.of(suffix), textureSlots);
  }
}
