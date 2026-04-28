package net.seface.somemoreblocks.block.properties;

import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum QuadDirection implements StringRepresentable {
  BOTTOM_LEFT(0, "bottom_left", new Vec3i(0, 0, 0)),
  TOP_LEFT(1, "top_left", new Vec3i(0, 0, -1)),
  TOP_RIGHT(2, "top_right", new Vec3i(1, 0, -1)),
  BOTTOM_RIGHT(3, "bottom_right", new Vec3i(1, 0, 0));

  @Getter
  private final int index;

  private final String name;

  @Getter
  private final Vec3i vec3;

  QuadDirection(int index, String name, Vec3i vec3) {
    this.index = index;
    this.name = name;
    this.vec3 = vec3;
  }

  @NotNull
  @Override
  public String getSerializedName() {
    return this.name;
  }

  public static QuadDirection getByIndex(int value) {
    for (QuadDirection direction : QuadDirection.values()) {
      if (direction.index == value) {
        return direction;
      }
    }

    return QuadDirection.BOTTOM_LEFT;
  }

  public Vec3i getOffset(Direction facing) {
    Vec3i vec = this.getVec3();

    return switch (facing) {
      case SOUTH -> new Vec3i(1 - vec.getX(), 0, 1 - vec.getZ());
      case EAST -> new Vec3i(vec.getZ(), 0, 1 - vec.getX());
      case WEST -> new Vec3i(1 - vec.getZ(), 0, vec.getX());
      default -> vec;
    };
  }

  public BlockPos getRelativeBlockPosOffset(Direction facing) {
    return new BlockPos(this.getOffset(facing));
  }
}
