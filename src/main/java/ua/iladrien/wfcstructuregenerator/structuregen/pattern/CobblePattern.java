package ua.iladrien.wfcstructuregenerator.structuregen.pattern;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class CobblePattern extends AbstractPattern {

    public static final BlockState COBBLE = Blocks.COBBLESTONE.getDefaultState();
    public static final BlockState BRICKS = Blocks.STONE_BRICKS.getDefaultState();

    @Override
    public BlockState get() {
        return RANDOM.nextInt(100) < 50 ? COBBLE : BRICKS;
    }
}
