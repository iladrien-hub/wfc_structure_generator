package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.LazyStuff;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.TileRotation;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.BigRoof_T;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc.Miscellaneous;

public class TileSimpleSpruceRoof_T extends BigRoof_T {

    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();
    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState SPRUCE_SLAB = Blocks.SPRUCE_SLAB.getDefaultState();
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();

    protected Vector3i[] miscDirections = {
            new Vector3i(WIDTH,-HEIGHT,0),
            new Vector3i(0,-HEIGHT,-WIDTH),
            new Vector3i(-WIDTH,-HEIGHT,0),
            new Vector3i(0,-HEIGHT,WIDTH),
    };

    private Vector3i[] miscOffset = {
            new Vector3i(1,-1,0),
            new Vector3i(0,-1,-1),
            new Vector3i(-1,-1,0),
            new Vector3i(0,-1,1),
    };

    @Override
    public void placeAt(World world, BlockPos pos, Vector3i generatorPos, Generator generator) {
        super.placeAt(world, pos, generatorPos, generator);
        int angle = (rotation.angle + 2) % 4;
        Miscellaneous.Misc_0007
                .setRotation(TileRotation.fromAngle(angle))
                .placeAt(world, pos.add(miscDirections[rotation.angle]), LazyStuff.addVectors3(miscOffset[rotation.angle],generatorPos), generator);
    }

    private void addWestVariants() {
        addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_EDGE_90);
        addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_90);
        addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
        addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
        addVariant_w(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
    }

    private void addSouthVariants() {
        addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_EDGE_180);
        addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF);
        addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_T);
        addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
        addVariant_s(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
    }

    private void addEastVariants() {
        addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_EDGE_270);
        addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_90);
        addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_T);
        addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
        addVariant_e(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
    }

    private void addNorthVariants() {
        addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_EDGE);
        addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF);
        addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_T);
        addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
        addVariant_n(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
    }

    @Override
    public void registerVariants() {
        super.registerVariants();
        switch (rotation) {
            case ROTATION0:
                addWestVariants();
                addSouthVariants();
                addVariant_e(Tiles.EMPTY_TILE);
                addNorthVariants();
                break;
            case ROTATION90:
                addWestVariants();
                addSouthVariants();
                addEastVariants();
                addVariant_n(Tiles.EMPTY_TILE);
                break;
            case ROTATION180:
                addVariant_w(Tiles.EMPTY_TILE);
                addSouthVariants();
                addEastVariants();
                addNorthVariants();
                break;
            case ROTATION270:
                addWestVariants();
                addVariant_s(Tiles.EMPTY_TILE);
                addEastVariants();
                addNorthVariants();
                break;
        }
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[0][0][0] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.INNER_RIGHT);
        data[0][0][6] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.INNER_LEFT);
        data[0][6][0] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][6][1] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][6][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][6][3] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][6][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][6][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][6][6] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][0][1] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][0][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][1][0] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][1][1] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.INNER_RIGHT);
        data[1][1][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.INNER_LEFT);
        data[1][1][6] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][5][0] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][5][1] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][5][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][5][3] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][5][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][5][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][5][6] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][0][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][0][3] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.X);
        data[2][0][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][1][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][1][3] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.X);
        data[2][1][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][2][0] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][2][1] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][2][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.INNER_RIGHT);
        data[2][2][3] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.X);
        data[2][2][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.INNER_LEFT);
        data[2][2][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][2][6] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][3][0] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][3][1] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][3][2] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][3][3] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][3][4] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][3][5] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][3][6] = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, net.minecraft.util.Direction.Axis.Z);
        data[2][4][0] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][4][1] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][4][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][4][3] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][4][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][4][5] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[2][4][6] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][0][3] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        data[3][1][3] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, false);
        data[3][2][3] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        data[3][3][0] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        data[3][3][1] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, false);
        data[3][3][2] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        data[3][3][3] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, false);
        data[3][3][4] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        data[3][3][5] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, false);
        data[3][3][6] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        return data;
    }
}
