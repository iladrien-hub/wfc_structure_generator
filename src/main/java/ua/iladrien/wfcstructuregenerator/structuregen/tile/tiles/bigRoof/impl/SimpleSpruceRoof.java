package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.TileRotation;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.BigRoof;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc.Miscellaneous;

public class SimpleSpruceRoof extends BigRoof {

    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();
    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState SPRUCE_SLAB = Blocks.SPRUCE_SLAB.getDefaultState();
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();

    @Override
    public void placeAt(World world, BlockPos pos, Vector3i generatorPos, Generator generator) {
        super.placeAt(world, pos, generatorPos, generator);
        switch (rotation) {
            case ROTATION0:
                Miscellaneous.Misc_0007.setRotation(TileRotation.ROTATION0).placeAt(world, pos.add(-WIDTH, -HEIGHT, 0), generatorPos, generator);
                Miscellaneous.Misc_0007.setRotation(TileRotation.ROTATION180).placeAt(world, pos.add(WIDTH,-HEIGHT, 0), generatorPos, generator);
                break;
            case ROTATION90:
                Miscellaneous.Misc_0007.setRotation(TileRotation.ROTATION90).placeAt(world, pos.add(0, -HEIGHT, WIDTH), generatorPos, generator);
                Miscellaneous.Misc_0007.setRotation(TileRotation.ROTATION270).placeAt(world, pos.add(0, -HEIGHT,-WIDTH), generatorPos, generator);
                break;
        }
    }

    @Override
    public void registerVariants() {
        super.registerVariants();
        switch (rotation) {
            case ROTATION0:
                // SOUTH
                addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_EDGE_180);
                addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF);
                addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_T);
                addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
                addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
                // EAST
                addVariant_e(Tiles.EMPTY_TILE);
                // NORTH
                addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_EDGE);
                addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF);
                addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_T);
                addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
                addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
                // WEST
                addVariant_w(Tiles.EMPTY_TILE);
                break;
            case ROTATION90:
                // SOUTH
                addVariant_s(Tiles.EMPTY_TILE);
                // EAST
                addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_90);
                addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_EDGE_270);
                addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_T);
                addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
                addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
                // NORTH
                addVariant_n(Tiles.EMPTY_TILE);
                // WEST
                addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_90);
                addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_EDGE_90);
                addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
                addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
                addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
                break;
        }
    }

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
