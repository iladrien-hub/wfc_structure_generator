package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration.impl;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.state.properties.StairsShape;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration.DirectionalDecoration;

public class StoneOnGroundSupport extends DirectionalDecoration {

    private static final BlockState STONE_BRICK_STAIRS = Blocks.STONE_BRICK_STAIRS.getDefaultState();
    private static final BlockState STONE_BRICKS = Blocks.STONE_BRICKS.getDefaultState();
    private static final BlockState STONE_BRICK_SLAB = Blocks.STONE_BRICK_SLAB.getDefaultState();
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();

    public StoneOnGroundSupport() {
        super();
        onGroundOnly = true;
    }

    @Override
    public void registerVariants() {
        super.registerVariants();
        addVariant_u(Tiles.BIG_SPRUCE_ROOM);
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[0][0][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][0][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][1][0] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][1][1] = STONE_BRICKS;
        data[0][1][2] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][1][4] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][1][5] = STONE_BRICKS;
        data[0][1][6] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][2][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[0][2][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[1][1][1] = STONE_BRICKS;
        data[1][1][5] = STONE_BRICKS;
        data[2][1][1] = STONE_BRICKS;
        data[2][1][5] = STONE_BRICKS;
        data[3][0][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][0][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][1][0] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][1][1] = STONE_BRICKS;
        data[3][1][2] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][1][3] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][1][4] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][1][5] = STONE_BRICKS;
        data[3][1][6] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.NORTH).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][2][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][2][2] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][2][3] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][2][4] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][2][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.WEST).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][3][1] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][3][2] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][3][3] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][3][4] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][3][5] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][4][1] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][4][2] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][4][3] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][4][4] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][4][5] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][5][1] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][5][2] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][5][3] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][5][4] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(TrapDoorBlock.OPEN, false);
        data[3][5][5] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][6][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][6][2] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][6][3] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        data[3][6][4] = STONE_BRICK_SLAB.with(SlabBlock.TYPE, SlabType.TOP);
        data[3][6][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, net.minecraft.util.Direction.EAST).with(BlockStateProperties.HALF, Half.TOP).with(StairsBlock.SHAPE, StairsShape.STRAIGHT);
        return data;
    }
}
