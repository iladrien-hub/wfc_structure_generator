package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.BigRoof;

public class SimpleSpruceRoofEdge extends BigRoof {

    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();
    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[0][0][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][1][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP);
        data[0][1][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[0][2][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[0][3][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[0][4][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[0][5][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP);
        data[0][5][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[0][6][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][1][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][2][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP);
        data[1][2][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[1][3][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[1][4][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP);
        data[1][4][6] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, true);
        data[1][5][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[2][2][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[2][3][4] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][3][5] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][4][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[3][3][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.TOP);
        data[3][3][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM);
        return data;
    }
}
