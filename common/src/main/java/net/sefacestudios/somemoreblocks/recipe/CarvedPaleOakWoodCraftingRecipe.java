package net.sefacestudios.somemoreblocks.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.sefacestudios.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.sefacestudios.somemoreblocks.registries.SMBBlocks;
import net.sefacestudios.somemoreblocks.registries.SMBDataComponentTypes;
import net.sefacestudios.somemoreblocks.registries.SMBItems;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class CarvedPaleOakWoodCraftingRecipe extends ShapedRecipe {
  private static final MapCodec<CarvedPaleOakWoodCraftingRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
      Codec.BOOL.optionalFieldOf("show_notification", true).forGetter(CarvedPaleOakWoodCraftingRecipe::showNotification)
    ).apply(instance, CarvedPaleOakWoodCraftingRecipe::new)
  );

  private static final StreamCodec<@NotNull RegistryFriendlyByteBuf, @NotNull CarvedPaleOakWoodCraftingRecipe> STREAM_CODEC = StreamCodec.unit(null);

  public static final RecipeSerializer<@NotNull CarvedPaleOakWoodCraftingRecipe> SERIALIZER = new RecipeSerializer<>(CarvedPaleOakWoodCraftingRecipe.MAP_CODEC, CarvedPaleOakWoodCraftingRecipe.STREAM_CODEC) ;

  private static ShapedRecipePattern pattern() {
    return ShapedRecipePattern.of(
      Map.of('#', Ingredient.of(SMBBlocks.CARVED_PALE_OAK_LOG.get())),
      "##",
      "##");
  }

  private static ItemStackTemplate result() {
    return new ItemStackTemplate(SMBBlocks.CARVED_PALE_OAK_WOOD.get().asItem(), 3);
  }

  public CarvedPaleOakWoodCraftingRecipe(boolean showNotification) {
    super(new CommonInfo(showNotification), new CraftingBookInfo(CraftingBookCategory.BUILDING, "carved_wood"), pattern(), result());
  }

  @Override
  public boolean matches(CraftingInput input, Level level) {
    if (!super.matches(input, level)) {
      return false;
    }
    int logCount = 0;
    Integer phase = null;
    for (int i = 0; i < input.size(); i++) {
      ItemStack stack = input.getItem(i);
      if (stack.isEmpty()) {
        continue;
      }
      if (!stack.is(SMBItems.CARVED_PALE_OAK_LOG.get())) {
        return false;
      }
      logCount++;
      int p = stack.getOrDefault(SMBDataComponentTypes.MOON_PHASE.get(), RotatedCarvedPaleOakBlock.MIN_MOON_PHASE);
      if (phase == null) {
        phase = p;
      } else if (phase != p) {
        return false;
      }
    }
    return logCount == 4;
  }

  @Override
  public ItemStack assemble(CraftingInput input) {
    ItemStack out = super.assemble(input);

    int phase = RotatedCarvedPaleOakBlock.MIN_MOON_PHASE;
    for (int i = 0; i < input.size(); i++) {
      ItemStack stack = input.getItem(i);
      if (stack.isEmpty()) {
        continue;
      }
      if (stack.is(SMBItems.CARVED_PALE_OAK_LOG.get())) {
        phase = stack.getOrDefault(SMBDataComponentTypes.MOON_PHASE.get(), RotatedCarvedPaleOakBlock.MIN_MOON_PHASE);
        break;
      }
    }
    out.set(SMBDataComponentTypes.MOON_PHASE.get(), phase);
    return out;
  }

  @Override
  public RecipeSerializer<@NotNull ShapedRecipe> getSerializer() {
    return ShapedRecipe.SERIALIZER;
  }
}
