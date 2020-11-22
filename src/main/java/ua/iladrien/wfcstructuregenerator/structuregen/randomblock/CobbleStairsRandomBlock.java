package ua.iladrien.wfcstructuregenerator.structuregen.randomblock;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class CobbleStairsRandomBlock extends AbstractRandomBlock {

    private static final BlockState COBBLE = Blocks.COBBLESTONE_STAIRS.getDefaultState();
    private static final BlockState BRICKS = Blocks.STONE_BRICK_STAIRS.getDefaultState();

    @Override
    public BlockState get() {
        return RANDOM.nextInt(100) < 50 ? COBBLE : BRICKS;
    }
}
