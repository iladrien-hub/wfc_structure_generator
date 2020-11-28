package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.impl;

import net.minecraft.block.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;
import ua.iladrien.wfcstructuregenerator.structuregen.Generator;
import ua.iladrien.wfcstructuregenerator.structuregen.LazyStuff;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.Tile;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoof.RoofEdge;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc.AbstractMiscellaneous;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.misc.Miscellaneous;

public class SimpleSpruceRoofEdge extends RoofEdge {

    protected static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();
    protected static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();
    protected static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
    protected static final BlockState STONE_BUTTON = Blocks.STONE_BUTTON.getDefaultState();

    private static class Variant_1 extends AbstractMiscellaneous {
        @Override
        public BlockState[][][] getStructure() {
            BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
            data[0][0][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[0][1][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[0][1][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][2][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][3][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][4][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][5][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[0][5][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][6][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][1][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][2][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][2][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, true);
            data[1][3][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[1][4][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][4][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, true);
            data[1][5][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[2][2][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[2][3][3] = STONE_BUTTON.with(BlockStateProperties.FACE, AttachFace.WALL).with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH);
            data[2][3][4] = SPRUCE_LOG.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Z);
            data[2][3][5] = SPRUCE_LOG.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Z);
            data[2][4][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[3][3][4] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[3][3][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            return data;
        }
    }

    private static class Variant_2 extends AbstractMiscellaneous {
        private static final BlockState CHAIN = Blocks.field_235341_dI_.getDefaultState();
        private static final BlockState SPRUCE_WOOD = Blocks.SPRUCE_WOOD.getDefaultState();

        private static class Bottom1 extends AbstractMiscellaneous {
            private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState();
            private static final BlockState SWEET_BERRY_BUSH = Blocks.SWEET_BERRY_BUSH.getDefaultState();
            @Override
            public BlockState[][][] getStructure() {
                BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
                data[1][3][2] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.OPEN, false);
                data[2][2][2] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
                data[2][3][1] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
                data[2][3][2] = GRASS_BLOCK;
                data[2][3][3] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
                data[2][4][2] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
                data[3][3][2] = SWEET_BERRY_BUSH.with(BlockStateProperties.AGE_0_3, 2);
                return data;
            }
        }

        private static class Bottom2 extends AbstractMiscellaneous {
            private static final BlockState LANTERN = Blocks.LANTERN.getDefaultState();
            @Override
            public BlockState[][][] getStructure() {
                BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
                data[3][3][2] = LANTERN.with(BlockStateProperties.HANGING, true);
                return data;
            }
        }

        private static class Bottom3 extends AbstractMiscellaneous {
            private static final BlockState BELL = Blocks.BELL.getDefaultState();
            private static final BlockState COBBLESTONE_WALL = Blocks.COBBLESTONE_WALL.getDefaultState();
            @Override
            public BlockState[][][] getStructure() {
                BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
                data[2][3][2] = BELL.with(BlockStateProperties.BELL_ATTACHMENT, BellAttachment.CEILING).with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH);
                data[3][3][2] = COBBLESTONE_WALL.with(BlockStateProperties.field_235908_S_,  WallHeight.NONE).with(BlockStateProperties.field_235909_T_,  WallHeight.NONE).with(BlockStateProperties.field_235910_U_,  WallHeight.NONE).with(BlockStateProperties.UP, true).with(BlockStateProperties.field_235911_V_,  WallHeight.NONE);
                return data;
            }
        }

        private static final Tile[] bottomVariants = new Tile[] {
                new Bottom1(),
                new Bottom2(),
                new Bottom3(),
        };

        @Override
        public void placeAt(World world, BlockPos pos, Vector3i generatorPos, Generator generator) {
            super.placeAt(world, pos, generatorPos, generator);
            bottomVariants[RANDOM.nextInt(bottomVariants.length)].setRotation(rotation).placeAt(world, pos.add(0, -HEIGHT, 0), generatorPos, generator);
        }

        @Override
        public BlockState[][][] getStructure() {
            BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
            data[0][0][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[0][1][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[0][1][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][2][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][3][2] = CHAIN.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Y);
            data[0][3][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][4][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][5][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[0][5][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[0][6][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][1][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][2][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][2][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[1][3][2] = CHAIN.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Y);
            data[1][3][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[1][4][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[1][4][6] = SPRUCE_TRAPDOOR.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.OPEN, true);
            data[1][5][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[2][2][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[2][3][2] = SPRUCE_WOOD.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Z);
            data[2][3][3] = SPRUCE_LOG.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Z);
            data[2][3][4] = SPRUCE_LOG.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Z);
            data[2][3][5] = SPRUCE_LOG.with(BlockStateProperties.AXIS, net.minecraft.util.Direction.Axis.Z);
            data[2][4][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[3][3][4] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.TOP).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            data[3][3][5] = SPRUCE_STAIRS.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(BlockStateProperties.STAIRS_SHAPE, StairsShape.STRAIGHT);
            return data;
        }
    }

    private static final Variant_1 v1 = new Variant_1();

    private static final Tile[] variants = new Tile[] {
            v1,
            v1,
            new Variant_2()
    };

    @Override
    public void placeAt(World world, BlockPos pos, Vector3i generatorPos, Generator generator) {
        variants[RANDOM.nextInt(variants.length)].setRotation(rotation).placeAt(world, pos, generatorPos, generator);
        Miscellaneous.Misc_0008.setRotation(rotation).placeAt(world, pos.add(0,-HEIGHT,0), LazyStuff.addVectors3(generatorPos, new Vector3i(0,-1,0)), generator);
    }

    @Override
    public BlockState[][][] getStructure() {
        return new BlockState[0][][];
    }
}
