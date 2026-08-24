package net.sefacestudios.somemoreblocks.registries;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.sefacestudios.somemoreblocks.block.properties.QuadDirection;

public class SMBBlockStateProperties {
  public static final EnumProperty<QuadDirection> POSITION = EnumProperty.create("position", QuadDirection.class);
}
