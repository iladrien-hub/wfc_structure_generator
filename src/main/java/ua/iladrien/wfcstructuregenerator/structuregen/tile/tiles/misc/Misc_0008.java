package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public class Misc_0008 extends Tile {
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();
    private static final BlockState SPRUCE_SLAB = Blocks.SPRUCE_SLAB.getDefaultState();
    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();

    @Override
    public void registerVariants() {

    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[3][0][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
        data[3][1][5] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
        data[3][2][5] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, false);
        data[3][3][5] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
        data[3][4][5] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, false);
        data[3][5][5] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
        data[3][6][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
        return data;
    }
}
