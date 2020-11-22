package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom.impl;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import ua.iladrien.wfcstructuregenerator.structuregen.randomblock.RandomBlocks;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom.SmallRoom;

public class Asset_0004 extends SmallRoom {

    private static final BlockState STONE_BRICKS = Blocks.STONE_BRICKS.getDefaultState();
    private static final BlockState SPRUCE_PLANKS = Blocks.SPRUCE_PLANKS.getDefaultState();
    private static final BlockState STONE_BRICK_STAIRS = Blocks.STONE_BRICK_STAIRS.getDefaultState();

    public Asset_0004() {
        super();
        onGroundOnly = true;
    }

    @Override
    public void registerVariants() {
        super.registerVariants();
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[0][1][1] = STONE_BRICKS;
        data[0][1][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][1][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][1][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][1][5] = STONE_BRICKS;
        data[0][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][2][2] = SPRUCE_PLANKS;
        data[0][2][3] = SPRUCE_PLANKS;
        data[0][2][4] = SPRUCE_PLANKS;
        data[0][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][3][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][3][2] = SPRUCE_PLANKS;
        data[0][3][3] = SPRUCE_PLANKS;
        data[0][3][4] = SPRUCE_PLANKS;
        data[0][3][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][4][2] = SPRUCE_PLANKS;
        data[0][4][3] = SPRUCE_PLANKS;
        data[0][4][4] = SPRUCE_PLANKS;
        data[0][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][1] = STONE_BRICKS;
        data[0][5][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][5] = STONE_BRICKS;
        data[1][1][1] = STONE_BRICKS;
        data[1][1][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][1][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][1][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][1][5] = STONE_BRICKS;
        data[1][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][3][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][5][1] = STONE_BRICKS;
        data[1][5][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][5][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][5][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][5][5] = STONE_BRICKS;
        data[2][1][1] = STONE_BRICKS;
        data[2][1][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][1][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][1][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][1][5] = STONE_BRICKS;
        data[2][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][3][5] = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST).with(BlockStateProperties.HALF, Half.TOP);
        data[2][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][5][1] = STONE_BRICKS;
        data[2][5][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][5][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][5][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][5][5] = STONE_BRICKS;
        data[3][1][1] = STONE_BRICKS;
        data[3][1][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][1][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][1][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][1][5] = STONE_BRICKS;
        data[3][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][3][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][3][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][5][1] = STONE_BRICKS;
        data[3][5][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][5][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][5][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[3][5][5] = STONE_BRICKS;
        return data;
    }
}
