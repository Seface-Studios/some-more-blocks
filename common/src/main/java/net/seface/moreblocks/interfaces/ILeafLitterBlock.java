package net.seface.moreblocks.interfaces;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public interface ILeafLitterBlock {
  float getChance();
  MutableComponent getName();
}
