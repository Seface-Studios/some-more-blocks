package net.seface.moreblocks.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class CracklableBlockManager {
    private static final List<CracklableBlockManager> $manager = new ArrayList<>(List.of(new CracklableBlockManager[]{
            // Vanilla
            new CracklableBlockManager(Blocks.CRACKED_STONE_BRICKS, Blocks.STONE_BRICKS),
            new CracklableBlockManager(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICKS),
            new CracklableBlockManager(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_TILES),
            new CracklableBlockManager(Blocks.CRACKED_NETHER_BRICKS, Blocks.NETHER_BRICKS),
            new CracklableBlockManager(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICKS),
    }));

    private final Block crackedVersion;
    private final Block normalVersion;

    public CracklableBlockManager(Block crackedVersion, Block normalVersion) {
        this.crackedVersion = crackedVersion;
        this.normalVersion = normalVersion;
    }

    public static void registerCracklableBlock(CracklableBlockManager manager) {
        $manager.add(manager);
    }

    public static Block getNormalVersion(Block crackedBlock) {
        for (CracklableBlockManager manager : CracklableBlockManager.$manager) {
            if (manager.crackedVersion.equals(crackedBlock)) {
                return manager.normalVersion;
            }
        }

        return null;
    }

    public static Block getCrackedVersion(Block normalVersion) {
        for (CracklableBlockManager manager : CracklableBlockManager.$manager) {
            if (manager.normalVersion.equals(normalVersion)) {
                return manager.crackedVersion;
            }
        }

        return null;
    }
}
