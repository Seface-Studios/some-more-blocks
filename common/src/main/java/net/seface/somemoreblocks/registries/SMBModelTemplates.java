package net.seface.somemoreblocks.registries;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.seface.somemoreblocks.SomeMoreBlocks;

import java.util.Optional;

public class SMBModelTemplates {
  public static final ModelTemplate SQUARE_HORIZONTAL = create("square_horizontal", TextureSlot.TEXTURE);
  public static final ModelTemplate SQUARE_VERTICAL = create("square_vertical", TextureSlot.TEXTURE);

  /**
   * Create a new Model Template to be used in multiple block models.
   * @param path The identifier path.
   * @param textureSlots All the texture slots at the model.
   * @return The new model template
   */
  public static ModelTemplate create(String path, TextureSlot ...textureSlots) {
    return new ModelTemplate(Optional.of(SomeMoreBlocks.id("block/templates/" + path)), Optional.empty(), textureSlots);
  }
}
