package ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom.impl;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.Tiles;
import ua.iladrien.wfcstructuregenerator.structuregen.tile.tiles.bigRoom.BigRoom;

public class TileBigSpruceRoom extends BigRoom {

    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState();
    private static final BlockState SPRUCE_PLANKS = Blocks.SPRUCE_PLANKS.getDefaultState();

    @Override
    public void registerVariants() {
        super.registerVariants();
        // UP
        variants_u.add(Tiles.SIMPLE_SPRUCE_ROOF);
        variants_u.add(Tiles.SIMPLE_SPRUCE_ROOF_90);
        variants_u.add(Tiles.SIMPLE_SPRUCE_ROOF_T);
        variants_u.add(Tiles.SIMPLE_SPRUCE_ROOF_T_90);
        variants_u.add(Tiles.SIMPLE_SPRUCE_ROOF_T_180);
        variants_u.add(Tiles.SIMPLE_SPRUCE_ROOF_T_270);
        // Down

    }

    public TileBigSpruceRoom() {
        super();
        this.allowedOnGround = false;
    }

    @Override
    public BlockState[][][] getStructure() {
        BlockState[][][] data = new BlockState[HEIGHT][WIDTH][WIDTH];

        final BlockState SPRUCE_LOG_Z = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, Direction.Axis.Z);
        final BlockState SPRUCE_LOG_X = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, Direction.Axis.X);
        final BlockState SPRUCE_LOG_Y = SPRUCE_LOG.with(RotatedPillarBlock.AXIS, Direction.Axis.Y);

        data[0][0][0] = SPRUCE_LOG_Z;
        data[0][0][1] = SPRUCE_LOG_Z;
        data[0][0][2] = SPRUCE_LOG_Z;
        data[0][0][3] = SPRUCE_LOG_Z;
        data[0][0][4] = SPRUCE_LOG_Z;
        data[0][0][5] = SPRUCE_LOG_Z;
        data[0][0][6] = SPRUCE_LOG_Z;
        data[0][1][0] = SPRUCE_LOG_X;
        data[0][1][6] = SPRUCE_LOG_X;
        data[0][2][0] = SPRUCE_LOG_X;
        data[0][2][6] = SPRUCE_LOG_X;
        data[0][3][0] = SPRUCE_LOG_X;
        data[0][3][6] = SPRUCE_LOG_X;
        data[0][4][0] = SPRUCE_LOG_X;
        data[0][4][6] = SPRUCE_LOG_X;
        data[0][5][0] = SPRUCE_LOG_X;
        data[0][5][6] = SPRUCE_LOG_X;
        data[0][6][0] = SPRUCE_LOG_Z;
        data[0][6][1] = SPRUCE_LOG_Z;
        data[0][6][2] = SPRUCE_LOG_Z;
        data[0][6][3] = SPRUCE_LOG_Z;
        data[0][6][4] = SPRUCE_LOG_Z;
        data[0][6][5] = SPRUCE_LOG_Z;
        data[0][6][6] = SPRUCE_LOG_Z;
        data[1][0][0] = SPRUCE_LOG_Y;
        data[1][0][1] = SPRUCE_PLANKS;
        data[1][0][2] = SPRUCE_LOG_Y;
        data[1][0][3] = SPRUCE_PLANKS;
        data[1][0][4] = SPRUCE_LOG_Y;
        data[1][0][5] = SPRUCE_PLANKS;
        data[1][0][6] = SPRUCE_LOG_Y;
        data[1][1][0] = SPRUCE_PLANKS;
        data[1][1][6] = SPRUCE_PLANKS;
        data[1][2][0] = SPRUCE_LOG_Y;
        data[1][2][6] = SPRUCE_LOG_Y;
        data[1][3][0] = SPRUCE_PLANKS;
        data[1][3][6] = SPRUCE_PLANKS;
        data[1][4][0] = SPRUCE_LOG_Y;
        data[1][4][6] = SPRUCE_LOG_Y;
        data[1][5][0] = SPRUCE_PLANKS;
        data[1][5][6] = SPRUCE_PLANKS;
        data[1][6][0] = SPRUCE_LOG_Y;
        data[1][6][1] = SPRUCE_PLANKS;
        data[1][6][2] = SPRUCE_LOG_Y;
        data[1][6][3] = SPRUCE_PLANKS;
        data[1][6][4] = SPRUCE_LOG_Y;
        data[1][6][5] = SPRUCE_PLANKS;
        data[1][6][6] = SPRUCE_LOG_Y;
        data[2][0][0] = SPRUCE_LOG_Y;
        data[2][0][1] = SPRUCE_PLANKS;
        data[2][0][2] = SPRUCE_LOG_Y;
        data[2][0][3] = SPRUCE_PLANKS;
        data[2][0][4] = SPRUCE_LOG_Y;
        data[2][0][5] = SPRUCE_PLANKS;
        data[2][0][6] = SPRUCE_LOG_Y;
        data[2][1][0] = SPRUCE_PLANKS;
        data[2][1][6] = SPRUCE_PLANKS;
        data[2][2][0] = SPRUCE_LOG_Y;
        data[2][2][6] = SPRUCE_LOG_Y;
        data[2][3][0] = SPRUCE_PLANKS;
        data[2][3][6] = SPRUCE_PLANKS;
        data[2][4][0] = SPRUCE_LOG_Y;
        data[2][4][6] = SPRUCE_LOG_Y;
        data[2][5][0] = SPRUCE_PLANKS;
        data[2][5][6] = SPRUCE_PLANKS;
        data[2][6][0] = SPRUCE_LOG_Y;
        data[2][6][1] = SPRUCE_PLANKS;
        data[2][6][2] = SPRUCE_LOG_Y;
        data[2][6][3] = SPRUCE_PLANKS;
        data[2][6][4] = SPRUCE_LOG_Y;
        data[2][6][5] = SPRUCE_PLANKS;
        data[2][6][6] = SPRUCE_LOG_Y;
        data[3][0][0] = SPRUCE_LOG_Y;
        data[3][0][1] = SPRUCE_PLANKS;
        data[3][0][2] = SPRUCE_LOG_Y;
        data[3][0][3] = SPRUCE_PLANKS;
        data[3][0][4] = SPRUCE_LOG_Y;
        data[3][0][5] = SPRUCE_PLANKS;
        data[3][0][6] = SPRUCE_LOG_Y;
        data[3][1][0] = SPRUCE_PLANKS;
        data[3][1][6] = SPRUCE_PLANKS;
        data[3][2][0] = SPRUCE_LOG_Y;
        data[3][2][6] = SPRUCE_LOG_Y;
        data[3][3][0] = SPRUCE_PLANKS;
        data[3][3][6] = SPRUCE_PLANKS;
        data[3][4][0] = SPRUCE_LOG_Y;
        data[3][4][6] = SPRUCE_LOG_Y;
        data[3][5][0] = SPRUCE_PLANKS;
        data[3][5][6] = SPRUCE_PLANKS;
        data[3][6][0] = SPRUCE_LOG_Y;
        data[3][6][1] = SPRUCE_PLANKS;
        data[3][6][2] = SPRUCE_LOG_Y;
        data[3][6][3] = SPRUCE_PLANKS;
        data[3][6][4] = SPRUCE_LOG_Y;
        data[3][6][5] = SPRUCE_PLANKS;
        data[3][6][6] = SPRUCE_LOG_Y;

        return data;
    }
}
