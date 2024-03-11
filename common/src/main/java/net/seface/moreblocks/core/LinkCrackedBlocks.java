package net.seface.moreblocks.core;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class LinkCrackedBlocks {
    private static final List<LinkCrackedBlocks> $manager = new ArrayList<>(List.of(new LinkCrackedBlocks[]{
            // Vanilla
            new LinkCrackedBlocks(Blocks.CRACKED_STONE_BRICKS, Blocks.STONE_BRICKS),
            new LinkCrackedBlocks(Blocks.CRACKED_DEEPSLATE_BRICKS, Blocks.DEEPSLATE_BRICKS),
            new LinkCrackedBlocks(Blocks.CRACKED_DEEPSLATE_TILES, Blocks.DEEPSLATE_TILES),
            new LinkCrackedBlocks(Blocks.CRACKED_NETHER_BRICKS, Blocks.NETHER_BRICKS),
            new LinkCrackedBlocks(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS, Blocks.POLISHED_BLACKSTONE_BRICKS),
    }));

    private final Block crackedVersion;
    private final Block normalVersion;

    public LinkCrackedBlocks(Block crackedVersion, Block normalVersion) {
        this.crackedVersion = crackedVersion;
        this.normalVersion = normalVersion;
    }

    public Block getCrackedBlock() { return this.crackedVersion; }

    public Block getNormalBlock() { return this.normalVersion; }

    public static void register(LinkCrackedBlocks manager) {
        $manager.add(manager);
    }

    public static Block getNormalFrom(Block crackedBlock) {
        for (LinkCrackedBlocks manager : LinkCrackedBlocks.$manager) {
            if (manager.crackedVersion.equals(crackedBlock)) {
                return manager.getNormalBlock();
            }
        }

        return null;
    }

    public static Block getCrackedFrom(Block normalVersion) {
        for (LinkCrackedBlocks manager : LinkCrackedBlocks.$manager) {
            if (manager.normalVersion.equals(normalVersion)) {
                return manager.getCrackedBlock();
            }
        }

        return null;
    }
}
