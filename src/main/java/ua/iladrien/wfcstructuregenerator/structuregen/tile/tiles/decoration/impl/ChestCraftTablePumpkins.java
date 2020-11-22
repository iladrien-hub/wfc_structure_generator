package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration.impl;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.ChestType;
import net.minecraft.state.properties.DoubleBlockHalf;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.decoration.DirectionalDecoration;

public class ChestCraftTablePumpkins extends DirectionalDecoration {
    private static final BlockState SPRUCE_FENCE = Blocks.SPRUCE_FENCE.getDefaultState();
    private static final BlockState PUMPKIN = Blocks.PUMPKIN.getDefaultState();
    private static final BlockState GRASS = Blocks.GRASS.getDefaultState();
    private static final BlockState TALL_GRASS = Blocks.TALL_GRASS.getDefaultState();
    private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState();
    private static final BlockState CHEST = Blocks.CHEST.getDefaultState();
    private static final BlockState NOTE_BLOCK = Blocks.NOTE_BLOCK.getDefaultState();
    private static final BlockState CRAFTING_TABLE = Blocks.CRAFTING_TABLE.getDefaultState();
    private static final BlockState LANTERN = Blocks.LANTERN.getDefaultState();

    public ChestCraftTablePumpkins() {
        super();
        onGroundOnly = true;
    }

    @Override
    public void registerVariants() {
        super.registerVariants();
        addVariant_u(Tiles.EMPTY_TILE);
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];
        data[0][1][3] = SPRUCE_FENCE.with(BlockStateProperties.EAST, true).with(BlockStateProperties.NORTH, false).with(BlockStateProperties.SOUTH, false).with(BlockStateProperties.WEST, false);
        data[0][1][4] = PUMPKIN;
        data[0][1][5] = PUMPKIN;
        data[0][2][1] = GRASS;
        data[0][2][3] = SPRUCE_FENCE.with(BlockStateProperties.EAST, false).with(BlockStateProperties.NORTH, false).with(BlockStateProperties.SOUTH, false).with(BlockStateProperties.WEST, true);
        data[0][2][4] = PUMPKIN;
        data[0][2][5] = PUMPKIN;
        data[0][3][1] = GRASS;
        data[0][3][4] = GRASS;
        data[0][3][5] = PUMPKIN;
        data[0][4][2] = TALL_GRASS.with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER);
        data[0][5][1] = OAK_LEAVES.with(BlockStateProperties.PERSISTENT, true);
        data[0][5][2] = CHEST.with(BlockStateProperties.HORIZONTAL_FACING, net.minecraft.util.Direction.SOUTH).with(BlockStateProperties.CHEST_TYPE, ChestType.SINGLE);
        data[0][5][5] = NOTE_BLOCK;
        data[0][6][2] = OAK_LEAVES.with(BlockStateProperties.PERSISTENT, true);
        data[0][6][3] = CRAFTING_TABLE;
        data[1][1][5] = PUMPKIN;
        data[1][2][5] = PUMPKIN;
        data[1][4][2] = TALL_GRASS.with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER);
        data[1][6][2] = OAK_LEAVES.with(BlockStateProperties.PERSISTENT, true);
        data[3][6][4] = LANTERN.with(BlockStateProperties.HANGING, true);
        return data;
    }
}
