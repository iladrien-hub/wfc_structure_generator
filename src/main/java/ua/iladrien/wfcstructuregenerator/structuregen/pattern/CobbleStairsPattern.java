package ua.iladrien.wfcstructuregenerator.structuregen.pattern;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class CobbleStairsPattern extends AbstractPattern {

    private static final BlockState COBBLE = Blocks.COBBLESTONE_STAIRS.getDefaultState();
    private static final BlockState BRICKS = Blocks.STONE_BRICK_STAIRS.getDefaultState();

    @Override
    public BlockState get() {
        return RANDOM.nextInt(100) < 50 ? COBBLE : BRICKS;
    }
}
