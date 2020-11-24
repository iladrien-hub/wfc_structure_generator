package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;

import java.time.LocalDate;

/**
 * Widow with small (1x1) flower pot with living flower
 */
public class Misc_0009 extends AbstractMiscellaneous {
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();
    private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
    private static final BlockState GLASS_PANE = Blocks.GLASS_PANE.getDefaultState();

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[0][3][5] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, false);
        data[1][2][5] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
        data[1][3][4] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
        data[1][3][5] = GRASS_BLOCK;
        data[1][4][5] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
        data[2][3][5] = Blocks.BLUE_ORCHID.getDefaultState(); // TODO: make flower random
        data[2][3][6] = GLASS_PANE.with(BlockStateProperties.EAST, true).with(BlockStateProperties.NORTH, false).with(BlockStateProperties.SOUTH, false).with(BlockStateProperties.WEST, true);
        return data;
    }
}
