package net.seface.somemoreblocks.registries;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.seface.somemoreblocks.platform.PlatformServices;
import net.seface.somemoreblocks.platform.registry.PlatformRegistryObject;
import net.seface.somemoreblocks.recipe.CarvedPaleOakWoodCraftingRecipe;
import org.jetbrains.annotations.NotNull;

public class SMBRecipeSerializers {
  public static final PlatformRegistryObject<RecipeSerializer<@NotNull CarvedPaleOakWoodCraftingRecipe>> CRAFTING_SHAPED_CARVED_PALE_OAK_WOOD = PlatformServices.REGISTRY.registerRecipeType("crafting_shaped_carved_pale_oak_wood", CarvedPaleOakWoodCraftingRecipe.SERIALIZER);

  public static void init() {}
}
