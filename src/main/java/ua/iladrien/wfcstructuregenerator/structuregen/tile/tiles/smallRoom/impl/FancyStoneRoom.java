package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom.impl;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.Direction;
import ua.iladrien.wfcstructuregenerator.structuregen.randomblock.RandomBlocks;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.smallRoom.SmallRoom;

public class FancyStoneRoom extends SmallRoom {

    private static final BlockState STONE_BRICK_STAIRS = Blocks.STONE_BRICK_STAIRS.getDefaultState();
    private static final BlockState STONE_BRICKS = Blocks.STONE_BRICKS.getDefaultState();

    public FancyStoneRoom() {
        super();
        onGroundOnly = true;
    }

    @Override
    public void registerVariants() {
        super.registerVariants();
        addVariant_w(Tiles.STONE_ON_GROUND_SUPPORT);
        addVariant_e(Tiles.STONE_ON_GROUND_SUPPORT_180);
        addVariant_s(Tiles.STONE_ON_GROUND_SUPPORT_90);
        addVariant_w(Tiles.CHEST_CRAFT_TABLE_PUMPKINS);
        addVariant_e(Tiles.CHEST_CRAFT_TABLE_PUMPKINS_180);
        addVariant_s(Tiles.CHEST_CRAFT_TABLE_PUMPKINS_90);
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];

        final BlockState STAIRS_EAST = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.EAST);
        final BlockState STAIRS_SOUTH = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.SOUTH);
        final BlockState STAIRS_NORTH = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.NORTH);
        final BlockState STAIRS_WEST = STONE_BRICK_STAIRS.with(HorizontalBlock.HORIZONTAL_FACING, Direction.WEST);

        data[0][0][1] = STAIRS_EAST.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][0][5] = STAIRS_EAST.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][1][0] = STAIRS_SOUTH.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][1][1] = STONE_BRICKS;
        data[0][1][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][1][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][1][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][1][5] = STONE_BRICKS;
        data[0][1][6] = STAIRS_NORTH.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][3][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][0] = STAIRS_SOUTH.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][5][1] = STONE_BRICKS;
        data[0][5][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][3] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[0][5][5] = STONE_BRICKS;
        data[0][5][6] = STAIRS_NORTH.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][6][1] = STAIRS_WEST.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[0][6][5] = STAIRS_WEST.with(BlockStateProperties.HALF, Half.BOTTOM);
        data[1][1][1] = STONE_BRICKS;
        data[1][1][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][1][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][1][5] = STONE_BRICKS;
        data[1][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][5][1] = STONE_BRICKS;
        data[1][5][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][5][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[1][5][5] = STONE_BRICKS;
        data[2][1][1] = STONE_BRICKS;
        data[2][1][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][1][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][1][5] = STONE_BRICKS;
        data[2][2][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][2][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][3][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][4][1] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][4][5] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][5][1] = STONE_BRICKS;
        data[2][5][2] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][5][4] = RandomBlocks.COBBLE_AND_STONE_PATTERN.get();
        data[2][5][5] = STONE_BRICKS;
        data[3][0][1] = STAIRS_EAST.with(BlockStateProperties.HALF, Half.TOP);
        data[3][0][3] = STAIRS_EAST.with(BlockStateProperties.HALF, Half.TOP);
        data[3][0][5] = STAIRS_EAST.with(BlockStateProperties.HALF, Half.TOP);
        data[3][1][0] = STAIRS_SOUTH.with(BlockStateProperties.HALF, Half.TOP);
        data[3][1][1] = STONE_BRICKS;
        data[3][1][2] = STONE_BRICKS;
        data[3][1][3] = STONE_BRICKS;
        data[3][1][4] = STONE_BRICKS;
        data[3][1][5] = STONE_BRICKS;
        data[3][1][6] = STAIRS_NORTH.with(BlockStateProperties.HALF, Half.TOP);
        data[3][2][1] = STONE_BRICKS;
        data[3][2][5] = STONE_BRICKS;
        data[3][3][0] = STAIRS_SOUTH.with(BlockStateProperties.HALF, Half.TOP);
        data[3][3][1] = STONE_BRICKS;
        data[3][3][5] = STONE_BRICKS;
        data[3][3][6] = STAIRS_NORTH.with(BlockStateProperties.HALF, Half.TOP);
        data[3][4][1] = STONE_BRICKS;
        data[3][4][5] = STONE_BRICKS;
        data[3][5][0] = STAIRS_SOUTH.with(BlockStateProperties.HALF, Half.TOP);
        data[3][5][1] = STONE_BRICKS;
        data[3][5][2] = STONE_BRICKS;
        data[3][5][3] = STONE_BRICKS;
        data[3][5][4] = STONE_BRICKS;
        data[3][5][5] = STONE_BRICKS;
        data[3][5][6] = STAIRS_NORTH.with(BlockStateProperties.HALF, Half.TOP);
        data[3][6][1] = STAIRS_WEST.with(BlockStateProperties.HALF, Half.TOP);
        data[3][6][3] = STAIRS_WEST.with(BlockStateProperties.HALF, Half.TOP);
        data[3][6][5] = STAIRS_WEST.with(BlockStateProperties.HALF, Half.TOP);

        return data;
    }
}
