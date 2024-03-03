package net.seface.moreblocks.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;

public enum BigLilyPadDirectionOffset {
    NORTH(Direction.NORTH, new Vec3i(0, 0, -1), new Vec3i(1, 0, 0), new Vec3i(1, 0, -1)),
    EAST(Direction.EAST, new Vec3i(1, 0, 0), new Vec3i(0, 0, 1), new Vec3i(1, 0, 1)),
    SOUTH(Direction.SOUTH, new Vec3i(0, 0, 1), new Vec3i(-1, 0, 0), new Vec3i(-1, 0, 1)),
    WEST(Direction.WEST, new Vec3i(-1, 0, 0), new Vec3i(0, 0, -1), new Vec3i(-1, 0, -1));

    private final Direction baseDirection;

    private final Vec3i topOffset;
    private final Vec3i rightOffset;
    private final Vec3i topRightOffset;

    BigLilyPadDirectionOffset(Direction baseDirection, Vec3i topOffset, Vec3i rightOffset, Vec3i topRightOffset) {
        this.baseDirection = baseDirection;

        this.topOffset = topOffset;
        this.rightOffset = rightOffset;
        this.topRightOffset = topRightOffset;
    }

    public BlockPos getTopOffset(BlockPos basePos) {
        return basePos.offset(this.topOffset);
    }

    public BlockPos getRightOffset(BlockPos basePos) {
        return basePos.offset(this.rightOffset);
    }

    public BlockPos getTopRightOffset(BlockPos basePos) {
        return basePos.offset(this.topRightOffset);
    }

    public static BigLilyPadDirectionOffset getByDirection(Direction direction) {
        for (BigLilyPadDirectionOffset value : BigLilyPadDirectionOffset.values()) {
            if (value.baseDirection == direction) {
                return value;
            }
        }

        return BigLilyPadDirectionOffset.NORTH;
    }
}
