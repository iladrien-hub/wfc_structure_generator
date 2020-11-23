package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;

public class Misc_0007 extends Tile {
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();
    private static final BlockState SPRUCE_SLAB = Blocks.SPRUCE_SLAB.getDefaultState();
    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();

    @Override
    public void registerVariants() {

    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        BlockState stairs = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
        BlockState trapdoor = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, false);
        data[2][6][0] = trapdoor;
        data[2][6][1] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
        data[2][6][2] = trapdoor;
        data[2][6][3] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
        data[2][6][4] = trapdoor;
        data[2][6][5] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
        data[2][6][6] = trapdoor;
        data[3][6][0] = stairs;
        data[3][6][1] = stairs;
        data[3][6][2] = stairs;
        data[3][6][3] = stairs;
        data[3][6][4] = stairs;
        data[3][6][5] = stairs;
        data[3][6][6] = stairs;
        return data;
    }
}
