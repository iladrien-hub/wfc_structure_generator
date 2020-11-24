package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.LazyStuff;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl.SimpleSpruceRoofEdge;

public class Misc_0008 extends AbstractMiscellaneous {
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();
    private static final BlockState SPRUCE_SLAB = Blocks.SPRUCE_SLAB.getDefaultState();
    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();

    private static class Right_v1 extends AbstractMiscellaneous {
        @Override
        public BlockState[][][] getStructure() {
            BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
            data[2][5][5] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
            data[3][5][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[3][6][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            return data;
        }
    }

    private static class Left_v1 extends AbstractMiscellaneous {
        @Override
        public BlockState[][][] getStructure() {
            BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
            data[2][1][5] = SPRUCE_SLAB.with(BlockStateProperties.SLAB_TYPE, SlabType.TOP);
            data[3][0][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[3][1][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            return data;
        }
    }

    private static class Right_v2 extends AbstractMiscellaneous {
        @Override
        public BlockState[][][] getStructure() {
            BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
            data[3][6][5] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, false);
            return data;
        }
    }

    private static class Left_v2 extends AbstractMiscellaneous {
        @Override
        public BlockState[][][] getStructure() {
            BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
            data[3][0][5] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, false);
            return data;
        }
    }


    private static final Vector3i[] miscOffsets = new Vector3i[] {
            new Vector3i(1-WIDTH, 0, 0),
            new Vector3i(0, 0, WIDTH-1),
            new Vector3i(WIDTH-1, 0, 0),
            new Vector3i(0, 0, 1-WIDTH),
    };

    private static final Vector3i[] checkDirections = new Vector3i[] {
            new Vector3i(-1, 1, 0),
            new Vector3i(0, 1, 1),
            new Vector3i(1, 1, 0),
            new Vector3i(0, 1, -1),
    };

    private static final Right_v1 right_v1 = new Right_v1();
    private static final Left_v1 left_v1 = new Left_v1();
    private static final Right_v2 right_v2 = new Right_v2();
    private static final Left_v2 left_v2 = new Left_v2();

    @Override
    public void placeAt(World world, BlockPos pos, Vector3i generatorPos, Generator generator) {
        super.placeAt(world, pos, generatorPos, generator);
        // Right
        Tile tile = generator.getTileAt(LazyStuff.addVectors3(checkDirections[rotation.angle], generatorPos));
        if (tile instanceof SimpleSpruceRoofEdge)
            right_v2.setRotation(rotation).placeAt(world, pos.add(miscOffsets[rotation.angle]), generatorPos, generator);
        else right_v1.setRotation(rotation).placeAt(world, pos.add(miscOffsets[rotation.angle]), generatorPos, generator);
        int angle = (rotation.angle + 2) % 4;
        tile = generator.getTileAt(LazyStuff.addVectors3(checkDirections[angle], generatorPos));
        if (tile instanceof SimpleSpruceRoofEdge)
            left_v2.setRotation(rotation).placeAt(world, pos.add(miscOffsets[angle]), generatorPos, generator);
        else left_v1.setRotation(rotation).placeAt(world, pos.add(miscOffsets[angle]), generatorPos, generator);
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
