package net.seface.somemoreblocks.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.seface.somemoreblocks.block.RotatedCarvedPaleOakBlock;
import net.seface.somemoreblocks.registries.SMBBlocks;
import net.seface.somemoreblocks.registries.SMBDataComponentTypes;
import net.seface.somemoreblocks.registries.SMBItems;

import java.util.Map;

public class CarvedPaleOakWoodCraftingRecipe extends ShapedRecipe {
  private static final MapCodec<CarvedPaleOakWoodCraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
      Codec.BOOL.optionalFieldOf("show_notification", true).forGetter(ShapedRecipe::showNotification)
    ).apply(instance, CarvedPaleOakWoodCraftingRecipe::new)
  );

  private static ShapedRecipePattern pattern() {
    return ShapedRecipePattern.of(
        Map.of('#', Ingredient.of(SMBBlocks.CARVED_PALE_OAK_LOG.get())),
        "##",
        "##");
  }

  private static ItemStack result() {
    return new ItemStack(SMBBlocks.CARVED_PALE_OAK_WOOD.get(), 3);
  }

  public static final RecipeSerializer<CarvedPaleOakWoodCraftingRecipe> SERIALIZER = new RecipeSerializer<>() {
    @Override
    public MapCodec<CarvedPaleOakWoodCraftingRecipe> codec() {
      return CODEC;
    }

    @Override
    @SuppressWarnings("deprecation")
    public StreamCodec<RegistryFriendlyByteBuf, CarvedPaleOakWoodCraftingRecipe> streamCodec() {
      return StreamCodec.unit(null);
    }
  };

  public CarvedPaleOakWoodCraftingRecipe(boolean showNotification) {
    super("carved_wood", CraftingBookCategory.BUILDING, pattern(), result(), showNotification);
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
  public ItemStack assemble(CraftingInput input, HolderLookup.Provider access) {
    ItemStack out = super.assemble(input, access);
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
  public RecipeSerializer<? extends CarvedPaleOakWoodCraftingRecipe> getSerializer() {
    return SERIALIZER;
  }
}
