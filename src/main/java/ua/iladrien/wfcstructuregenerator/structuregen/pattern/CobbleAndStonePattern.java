package ua.iladrien.wfcstructuregenerator.structuregen.pattern;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class CobbleAndStonePattern extends AbstractPattern {

    private static final BlockState COBBLE = Blocks.COBBLESTONE.getDefaultState();
    private static final BlockState BRICKS = Blocks.STONE.getDefaultState();

    @Override
    public BlockState get() {
        return RANDOM.nextInt(100) < 30 ? COBBLE : BRICKS;
    }
}
