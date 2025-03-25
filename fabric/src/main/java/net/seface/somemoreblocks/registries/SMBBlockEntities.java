package net.seface.somemoreblocks.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.seface.somemoreblocks.SomeMoreBlocks;
import net.seface.somemoreblocks.block.entity.CactusChestBlockEntity;

public class SMBBlockEntities {
  public static final BlockEntityType<CactusChestBlockEntity> CACTUS_CHEST = register("cactus_chest", CactusChestBlockEntity::new, SMBBlocks.CACTUS_CHEST);

  private static <T extends BlockEntity> BlockEntityType<T> register(String path,  FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
    ResourceLocation identifier = ResourceLocation.fromNamespaceAndPath(SomeMoreBlocks.ID, path);
    return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, identifier, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
  }

  public static void init() {}
}
