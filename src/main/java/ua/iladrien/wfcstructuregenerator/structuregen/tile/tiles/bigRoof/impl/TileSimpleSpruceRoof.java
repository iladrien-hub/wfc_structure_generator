package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.BigRoof;

public class TileSimpleSpruceRoof extends BigRoof {

    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();
    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState SPRUCE_SLAB = Blocks.SPRUCE_SLAB.getDefaultState();
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];

        final BlockState STAIRS_EAST = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        final BlockState STAIRS_WEST = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        final BlockState LOG = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, Direction.Axis.Z);
        final BlockState TRAPDOOR = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, false);

        data[0][0][0] = STAIRS_EAST;
        data[0][0][1] = STAIRS_EAST;
        data[0][0][2] = STAIRS_EAST;
        data[0][0][3] = STAIRS_EAST;
        data[0][0][4] = STAIRS_EAST;
        data[0][0][5] = STAIRS_EAST;
        data[0][0][6] = STAIRS_EAST;
        data[0][6][0] = STAIRS_WEST;
        data[0][6][1] = STAIRS_WEST;
        data[0][6][2] = STAIRS_WEST;
        data[0][6][3] = STAIRS_WEST;
        data[0][6][4] = STAIRS_WEST;
        data[0][6][5] = STAIRS_WEST;
        data[0][6][6] = STAIRS_WEST;
        data[1][1][0] = STAIRS_EAST;
        data[1][1][1] = STAIRS_EAST;
        data[1][1][2] = STAIRS_EAST;
        data[1][1][3] = STAIRS_EAST;
        data[1][1][4] = STAIRS_EAST;
        data[1][1][5] = STAIRS_EAST;
        data[1][1][6] = STAIRS_EAST;
        data[1][5][0] = STAIRS_WEST;
        data[1][5][1] = STAIRS_WEST;
        data[1][5][2] = STAIRS_WEST;
        data[1][5][3] = STAIRS_WEST;
        data[1][5][4] = STAIRS_WEST;
        data[1][5][5] = STAIRS_WEST;
        data[1][5][6] = STAIRS_WEST;
        data[2][2][0] = STAIRS_EAST;
        data[2][2][1] = STAIRS_EAST;
        data[2][2][2] = STAIRS_EAST;
        data[2][2][3] = STAIRS_EAST;
        data[2][2][4] = STAIRS_EAST;
        data[2][2][5] = STAIRS_EAST;
        data[2][2][6] = STAIRS_EAST;
        data[2][3][0] = LOG;
        data[2][3][1] = LOG;
        data[2][3][2] = LOG;
        data[2][3][3] = LOG;
        data[2][3][4] = LOG;
        data[2][3][5] = LOG;
        data[2][3][6] = LOG;
        data[2][4][0] = STAIRS_WEST;
        data[2][4][1] = STAIRS_WEST;
        data[2][4][2] = STAIRS_WEST;
        data[2][4][3] = STAIRS_WEST;
        data[2][4][4] = STAIRS_WEST;
        data[2][4][5] = STAIRS_WEST;
        data[2][4][6] = STAIRS_WEST;
        data[3][3][0] = SPRUCE_SLAB;
        data[3][3][1] = TRAPDOOR;
        data[3][3][2] = SPRUCE_SLAB;
        data[3][3][3] = TRAPDOOR;
        data[3][3][4] = SPRUCE_SLAB;
        data[3][3][5] = TRAPDOOR;
        data[3][3][6] = SPRUCE_SLAB;

        return data;
    }
}
