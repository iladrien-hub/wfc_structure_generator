package ua.iladrien.wfcstructuregenerator.structuregen.randomblock;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class CobbleAndStoneRandomBlock extends AbstractRandomBlock {

    private static final BlockState COBBLE = Blocks.COBBLESTONE.getDefaultState();
    private static final BlockState BRICKS = Blocks.STONE.getDefaultState();

    @Override
    public BlockState get() {
        return RANDOM.nextInt(100) < 30 ? COBBLE : BRICKS;
    }
}
