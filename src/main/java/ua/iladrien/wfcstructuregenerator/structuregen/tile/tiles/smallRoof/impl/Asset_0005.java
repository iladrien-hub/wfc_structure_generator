package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoof.impl;

import net.minecraft.block.*;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import ua.iladrien.wfcstructuregenerator.structuregen.randomblock.RandomBlocks;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoof.SmallRoof;

public class Asset_0005 extends SmallRoof {

    private static final BlockState STONE_BRICKS = Blocks.STONE_BRICKS.getDefaultState();
    private static final BlockState SPRUCE_STAIRS = Blocks.SPRUCE_STAIRS.getDefaultState();
    private static final BlockState COBBLESTONE_STAIRS = Blocks.COBBLESTONE_STAIRS.getDefaultState();
    private static final BlockState STONE_BRICK_STAIRS = Blocks.STONE_BRICK_STAIRS.getDefaultState();
    private static final BlockState SPRUCE_SLAB = Blocks.SPRUCE_SLAB.getDefaultState();
    private static final BlockState SPRUCE_TRAPDOOR = Blocks.SPRUCE_TRAPDOOR.getDefaultState();

    @Override
    public void registerVariants() {
        super.registerVariants();
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[0][1][1] = STONE_BRICKS;
        data[0][1][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][1][3] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][1][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][1][5] = STONE_BRICKS;
        data[0][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][3][1] = COBBLESTONE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][3][5] = COBBLESTONE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][1] = STONE_BRICKS;
        data[0][5][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][5][3] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][5][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][5][5] = STONE_BRICKS;
        data[1][1][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][1][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][2][1] = STONE_BRICKS;
        data[1][2][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][2][3] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][2][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][2][5] = STONE_BRICKS;
        data[1][4][1] = STONE_BRICKS;
        data[1][4][2] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][4][3] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][4][4] = SPRUCE_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][4][5] = STONE_BRICKS;
        data[1][5][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][5][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[2][2][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[2][2][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[2][3][1] = STONE_BRICKS;
        data[2][3][2] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        data[2][3][3] = SPRUCE_TRAPDOOR.with(HorizontalBlock.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM).with(TrapDoorBlock.OPEN, false);
        data[2][3][4] = SPRUCE_SLAB.with(SlabBlock.TYPE, SlabType.BOTTOM);
        data[2][3][5] = STONE_BRICKS;
        data[2][4][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[2][4][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[3][3][1] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.SOUTH).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[3][3][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH).with(BlockStateProperties.HALF, Half.BOTTOM);
        return data;
    }
}
