package ua.iladrien.wfcstructuregenerator.structuregen.pattern;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;

public class OakPattern extends AbstractPattern {

    private static final BlockState LOG = Blocks.STRIPPED_OAK_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y);
    private static final BlockState PLANKS = Blocks.OAK_PLANKS.getDefaultState();

    @Override
    public BlockState get() {
        return RANDOM.nextInt(100) < 30 ? LOG : PLANKS;
    }
}
