package net.seface.moreblocks.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

import java.util.Map;

public class MushroomColonyBlockItem extends BlockItem {
    protected final Block wallVariation;
    protected final Direction attachmentDirection = Direction.DOWN;

    public MushroomColonyBlockItem(Block block, Block wallVariation, Properties properties) {
        super(block, properties);

        this.wallVariation = wallVariation;
    }

    protected boolean canPlace(LevelReader $$0, BlockState $$1, BlockPos $$2) {
        return $$1.canSurvive($$0, $$2);
    }


    protected BlockState getPlacementState(BlockPlaceContext $$0) {
        BlockState $$1 = this.wallVariation.getStateForPlacement($$0);
        BlockState $$2 = null;
        LevelReader $$3 = $$0.getLevel();
        BlockPos $$4 = $$0.getClickedPos();
        Direction[] var6 = $$0.getNearestLookingDirections();
        int var7 = var6.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Direction $$5 = var6[var8];
            if ($$5 != this.attachmentDirection.getOpposite()) {
                BlockState $$6 = $$5 == this.attachmentDirection ? this.getBlock().getStateForPlacement($$0) : $$1;
                if ($$6 != null && this.canPlace($$3, $$6, $$4)) {
                    $$2 = $$6;
                    break;
                }
            }
        }

        return $$2 != null && $$3.isUnobstructed($$2, $$4, CollisionContext.empty()) ? $$2 : null;
    }

    /*@Nullable
    protected BlockState getPlacementState(BlockPlaceContext placeCtx) {
        Direction direction = placeCtx.getClickedFace();
        BlockState wall = this.wallVariation.getStateForPlacement(placeCtx);
        BlockState s = this.getBlock().getStateForPlacement(placeCtx);

        if (direction == Direction.UP) {

            return s;
        } else {
            placeCtx.getLevel().setBlock(placeCtx.getClickedPos(), wall, 1);
            return wall;
        }
    }*/

    @Override
    public void registerBlocks(Map<Block, Item> itemMap, Item item) {
        super.registerBlocks(itemMap, item);
        itemMap.put(this.wallVariation, item);
    }
}
